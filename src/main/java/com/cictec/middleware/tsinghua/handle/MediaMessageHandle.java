package com.cictec.middleware.tsinghua.handle;

import com.cictec.middleware.tsinghua.entity.dto.TsinghuaDeviceMessageDTO;
import com.cictec.middleware.tsinghua.handle.state.MessageState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author 媒体信息处理
 */
@Component("media")
public class MediaMessageHandle implements MessageState {
    Logger logger = LoggerFactory.getLogger(MediaMessageHandle.class);

    @Override
    public void messageHandle(TsinghuaDeviceMessageDTO messageDTO) {
        logger.info(messageDTO.toString());

    }
}
