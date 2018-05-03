package com.cictec.middleware.tsinghua.handle;

import com.alibaba.fastjson.JSONObject;
import com.cictec.middleware.tsinghua.entity.dto.Terminal.MediaMessageDTO;
import com.cictec.middleware.tsinghua.entity.po.TWarnMedia;
import com.cictec.middleware.tsinghua.handle.state.MessageState;
import com.cictec.middleware.tsinghua.service.TWarnMediaService;
import com.cictec.middleware.tsinghua.utils.DateUtils;
import com.cictec.middleware.tsinghua.utils.DownloadUtils;
import com.cictec.middleware.tsinghua.utils.UUIDGenerator;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Date;


/**
 * @author 媒体信息处理
 */
@Component("0801")
public class MediaMessageHandle implements MessageState {


    Logger logger = LoggerFactory.getLogger(MediaMessageHandle.class);

    @Value("${media.file.save-model}")
    private String saveModel;
    @Value("${media.alibaba.endpoint}")
    private String endPoint;
    @Value("${media.alibaba.access-id}")
    private String accessId;
    @Value("${media.alibaba.access-key}")
    private String accessKey;
    @Value("${media.alibaba.bucket-name}")
    private String bucketName;
    @Value("${media.alibaba.bucket-expira-day}")
    private Integer expiration;

    @Autowired
    private TWarnMediaService tWarnMediaService;




    @Override
    public void messageHandle(byte[] bytes) {
        MediaMessageDTO mediaMessage = JSONObject.parseObject(bytes,MediaMessageDTO.class);
        logger.debug("收到设备【{}】多媒体消息，消息内容：{}",mediaMessage.getHexDevIdno(),mediaMessage.toString());
        try {
            String key = DateUtils.getDate()+"/"+mediaMessage.getHexDevIdno()+"/"+UUIDGenerator.genUuidStr()+"."+mediaMessage.getMediaEncoding();
            String url = DownloadUtils.saveFileToAlibabaOSS(endPoint,accessId,accessKey,mediaMessage.getMediaUrl(),bucketName,key,expiration);
            logger.debug("媒体信息保存路径：{}",url);

            tWarnMediaService.save(converMediaMessageToTwarnMedia(mediaMessage,url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TWarnMedia converMediaMessageToTwarnMedia(MediaMessageDTO messageDTO,String url){
        TWarnMedia tWarnMedia = new TWarnMedia();
        tWarnMedia.setMediaUuid(UUIDGenerator.genUuidStr());
        tWarnMedia.setCreateTime(DateUtils.parseDate(messageDTO.getYyMMddHHmmss()));
        tWarnMedia.setHexLocaltionBuf(messageDTO.getHexDevIdno()+messageDTO.getHexLocationBuf());
        tWarnMedia.setDownloadUrl(url);
        tWarnMedia.setHexMediaId(messageDTO.getHexMediaId());
        tWarnMedia.setMediaEncoding(messageDTO.getMediaEncoding());
        tWarnMedia.setMediaType(messageDTO.getMediaType());
        tWarnMedia.setDownloadTime(new Date(System.currentTimeMillis()));
        tWarnMedia.setDownloadStatus(TWarnMedia.DOWNLOAD_STATUS_SUCCESS);
        tWarnMedia.setSaveType(saveModel);
        return tWarnMedia;
    }
}
