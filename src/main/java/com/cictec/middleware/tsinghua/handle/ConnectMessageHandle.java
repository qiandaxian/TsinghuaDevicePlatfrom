package com.cictec.middleware.tsinghua.handle;

import com.alibaba.fastjson.JSONObject;
import com.cictec.middleware.tsinghua.entity.dto.Terminal.ConnectMessageDTO;
import com.cictec.middleware.tsinghua.handle.state.MessageState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author qiandaxian
 * 连接信息处理
 */
@Component("0102")
public class ConnectMessageHandle implements MessageState {

    Logger logger = LoggerFactory.getLogger(ConnectMessageHandle.class);


    @Override
    public void messageHandle(byte[] bytes) {
        ConnectMessageDTO connectMessage = JSONObject.parseObject(bytes,ConnectMessageDTO.class);
        logger.info("收到设备【{}】鉴权消息，消息内容：{}",connectMessage.getHexDevIdno(),connectMessage.toString());
        logger.info("设备设备【{}】状态为在线。",connectMessage.getHexDevIdno());



    }
}
