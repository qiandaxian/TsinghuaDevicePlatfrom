package com.cictec.middleware.tsinghua.processor;

import org.apache.camel.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TsinghuaRabbitMqProcessor extends BaseProcessor {

    Logger logger = LoggerFactory.getLogger(TsinghuaRabbitMqProcessor.class);

    @Override
    public void doProcess(Message message) throws Exception {
        Map<String,Object> header =  message.getHeaders();
        String deviceId =  header.get("deviceId").toString();
        byte[] bytes = (byte[]) message.getBody();
        logger.info("收到消息：{}",new String(bytes,"UTF-8"));

        //1.重写解码器解码？


    }
}
