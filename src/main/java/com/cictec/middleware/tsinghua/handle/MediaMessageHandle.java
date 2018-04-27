package com.cictec.middleware.tsinghua.handle;

import com.alibaba.fastjson.JSONObject;
import com.cictec.middleware.tsinghua.entity.dto.Terminal.MediaMessageDTO;
import com.cictec.middleware.tsinghua.handle.state.MessageState;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @author 媒体信息处理
 */
@Component("0801")
public class MediaMessageHandle implements MessageState {
    Logger logger = LoggerFactory.getLogger(MediaMessageHandle.class);


    @Override
    public void messageHandle(byte[] bytes) {
        MediaMessageDTO mediaMessage = JSONObject.parseObject(bytes,MediaMessageDTO.class);
        logger.info("收到设备【{}】多媒体消息，消息内容：{}",mediaMessage.getHexDevIdno(),mediaMessage.toString());
        logger.info("保存媒体信息到数据库，下载文件，保存到服务器");
        //保存媒体下载信息

//        //下载媒体资源
//        String url = "http://192.168.10.72:9002/media/lines.xml";
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(url);
//        try {
//            CloseableHttpResponse response1 = httpclient.execute(httpGet);
//            HttpEntity entity1 = response1.getEntity();
//            System.out.println(entity1.getContent());
//            response1.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//
//        }


        //TODO 保存证据信息

    }
}
