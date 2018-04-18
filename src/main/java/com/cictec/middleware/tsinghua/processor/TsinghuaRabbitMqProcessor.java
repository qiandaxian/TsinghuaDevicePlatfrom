package com.cictec.middleware.tsinghua.processor;

import com.alibaba.fastjson.JSONObject;
import com.cictec.middleware.tsinghua.entity.dto.TsinghuaDeviceMessageDTO;
import com.cictec.middleware.tsinghua.handle.state.MessageState;
import com.cictec.middleware.tsinghua.handle.state.MessageStateContext;
import org.apache.camel.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.ws.handler.MessageContext;

/**
 * @author qiandaxian
 */
@Component
public class TsinghuaRabbitMqProcessor extends BaseProcessor {

    Logger logger = LoggerFactory.getLogger(TsinghuaRabbitMqProcessor.class);

    @Autowired
    private MessageStateContext messageStateContext;

    @Override
    public void doProcess(Message message) throws Exception {
        byte[] bytes = (byte[]) message.getBody();

        logger.info("收到消息：{}",new String(bytes,"UTF-8"));

        TsinghuaDeviceMessageDTO messageDTO = JSONObject.parseObject(bytes,TsinghuaDeviceMessageDTO.class);

        messageStateContext.messageHandle(messageDTO);

    }

}
