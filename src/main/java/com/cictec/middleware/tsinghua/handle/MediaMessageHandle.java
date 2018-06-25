package com.cictec.middleware.tsinghua.handle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cictec.middleware.tsinghua.entity.dto.download.HttpDownloadDTO;
import com.cictec.middleware.tsinghua.entity.dto.RabbitMqClientDTO;
import com.cictec.middleware.tsinghua.entity.dto.Terminal.MediaMessageDTO;
import com.cictec.middleware.tsinghua.entity.po.TWarn;
import com.cictec.middleware.tsinghua.entity.po.TWarnMedia;
import com.cictec.middleware.tsinghua.entity.po.elasticsearch.WarnInfo;
import com.cictec.middleware.tsinghua.handle.state.MessageState;
import com.cictec.middleware.tsinghua.service.TWarnMediaService;
import com.cictec.middleware.tsinghua.service.TWarnService;
import com.cictec.middleware.tsinghua.utils.CamelRabbitMqDslUtils;
import com.cictec.middleware.tsinghua.utils.DateUtils;
import com.cictec.middleware.tsinghua.utils.UUIDGenerator;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * @author 媒体信息处理，保存基本信息，推送到下载服务器下载
 */
@Component("0801")
public class MediaMessageHandle implements MessageState {


    Logger logger = LoggerFactory.getLogger(MediaMessageHandle.class);

    @Value("${media.file.save-model}")
    private short saveModel;
    @Value("${rabbitmq.download.host}")
    private String host;
    @Value("${rabbitmq.download.port}")
    private String port;
    @Value("${rabbitmq.download.exchangename}")
    private String exchangename;
    @Value("${rabbitmq.download.username}")
    private String username;
    @Value("${rabbitmq.download.password}")
    private String password;
    @Value("${rabbitmq.download.queuename}")
    private String queuename;

    @Autowired
    private TWarnMediaService tWarnMediaService;
    @Autowired
    private ProducerTemplate producerTemplate;
    @Autowired
    private TWarnService warnService;

    private String httpDownloadDsl;

    @Override
    public void messageHandle(byte[] bytes) {
        MediaMessageDTO mediaMessage = JSONObject.parseObject(bytes,MediaMessageDTO.class);
        logger.info("收到设备【{}】多媒体消息，消息内容：{}",mediaMessage.getHexDevIdno(),mediaMessage.toString());

        //报警信息触发的图片进行存储
        if(mediaMessage.getAlarmSet()!=null&&mediaMessage.getAlarmSet().length>0) {

            TWarnMedia warnMedia = converMediaMessageToTwarnMedia(mediaMessage);
            logger.info("保存多媒体基本信息：{}", JSON.toJSONString(warnMedia));
            tWarnMediaService.save(warnMedia);

            //本地存储外，其他存储推送到下载服务器
            if(0!=saveModel) {
                HttpDownloadDTO httpDownloadDTO = initHttpDownloadDTO(warnMedia, mediaMessage);
                logger.debug("推送多媒体下载消息到MQ：{}", JSON.toJSONString(httpDownloadDTO));
                producerTemplate.sendBody(getHttpDownloadDsl(), JSON.toJSONString(httpDownloadDTO));
            }
        }

    }

    public String getHttpDownloadDsl(){
        if (httpDownloadDsl == null || httpDownloadDsl.equals("")){
            httpDownloadDsl = createHttpDownlodDsl();
        }
        return httpDownloadDsl;
    }

    private TWarnMedia converMediaMessageToTwarnMedia(MediaMessageDTO messageDTO){
        TWarnMedia tWarnMedia = new TWarnMedia();

        Map param = new HashMap();
        param.put("devCode",messageDTO.getHexDevIdno());
        param.put("hexLocationBuf",messageDTO.getHexDevIdno()+messageDTO.getHexLocationBuf());

        TWarn warn = warnService.getWarnByDevCodeAndHexLocationBuf(param);
        if (warn!=null){
            tWarnMedia.setWarnUuid(warn.getWarnUuid());
        }


        tWarnMedia.setMediaUuid(UUIDGenerator.genUuidStr());
        tWarnMedia.setCreateTime(DateUtils.parseDate(messageDTO.getYyMMddHHmmss()));
        tWarnMedia.setHexLocaltionBuf(messageDTO.getHexDevIdno()+messageDTO.getHexLocationBuf());
        tWarnMedia.setHexMediaId(messageDTO.getHexMediaId());
        tWarnMedia.setMediaEncoding(messageDTO.getMediaEncoding());
        tWarnMedia.setMediaType(messageDTO.getMediaType());
        tWarnMedia.setMediaUrl(messageDTO.getMediaUrl());
        tWarnMedia.setMediaEncoding(messageDTO.getMediaEncoding());
        tWarnMedia.setMediaType(messageDTO.getMediaType());
        tWarnMedia.setDownloadType(TWarnMedia.DOWNLOAD_TYPE_UNDOWNLOAD);
        tWarnMedia.setSaveType(saveModel);
        if(0==saveModel){
            //本地不需要下载
            tWarnMedia.setDownloadType(TWarnMedia.DOWNLOAD_TYPE_SUCCESS);
            tWarnMedia.setDownloadUrl(tWarnMedia.getMediaUrl());
            tWarnMedia.setDownloadTime(tWarnMedia.getCreateTime());
        }else {
            String savePath = getSavePathString(messageDTO);
            tWarnMedia.setSavePath(savePath);
        }

        return tWarnMedia;
    }

    private HttpDownloadDTO initHttpDownloadDTO(TWarnMedia tWarnMedia,MediaMessageDTO messageDTO){
        HttpDownloadDTO httpDownloadDTO = new HttpDownloadDTO();
        httpDownloadDTO.setMediaUuid(tWarnMedia.getMediaUuid());
        httpDownloadDTO.setSaveModel(saveModel);
        httpDownloadDTO.setUrl(messageDTO.getMediaUrl());
        String savePath = getSavePathString(messageDTO);
        httpDownloadDTO.setSavePath(savePath);
        return httpDownloadDTO;
    }

    private String getSavePathString(MediaMessageDTO messageDTO) {
        return DateUtils.getDate()+"/"+messageDTO.getHexDevIdno()+"/"+UUIDGenerator.genUuidStr()+"."+messageDTO.getMediaEncoding();
    }

    private String createHttpDownlodDsl(){

        RabbitMqClientDTO rabbitMqClientDTO = new RabbitMqClientDTO(
                host,
                port,
                exchangename,
                username,
                password,
                queuename
        );

        return CamelRabbitMqDslUtils.getCamelUrl(rabbitMqClientDTO);
    }
}
