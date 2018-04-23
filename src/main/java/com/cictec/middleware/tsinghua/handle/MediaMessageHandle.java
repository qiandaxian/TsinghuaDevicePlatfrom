package com.cictec.middleware.tsinghua.handle;

import com.alibaba.fastjson.JSONObject;
import com.cictec.middleware.tsinghua.entity.dto.Terminal.MediaMessageDTO;
import com.cictec.middleware.tsinghua.handle.state.MessageState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


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

    }
}
