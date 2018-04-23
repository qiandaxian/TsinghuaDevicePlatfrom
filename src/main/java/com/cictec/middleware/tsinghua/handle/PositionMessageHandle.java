package com.cictec.middleware.tsinghua.handle;

import com.alibaba.fastjson.JSONObject;
import com.cictec.middleware.tsinghua.entity.dto.Terminal.PositionMessageDTO;
import com.cictec.middleware.tsinghua.handle.state.MessageState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author qiandaxian
 * 位置信息处理
 */
@Component("0200")
public class PositionMessageHandle implements MessageState {
    Logger logger = LoggerFactory.getLogger(PositionMessageHandle.class);


    @Override
    public void messageHandle(byte[] bytes) {
        PositionMessageDTO positionMessage = JSONObject.parseObject(bytes,PositionMessageDTO.class);
        logger.info("收到位置信息消息，消息内容：{}",positionMessage.toString());
        logger.info("保存位置信息到ES");

    }
}
