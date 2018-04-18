package com.cictec.middleware.tsinghua.handle;

import com.cictec.middleware.tsinghua.entity.dto.TsinghuaDeviceMessageDTO;
import com.cictec.middleware.tsinghua.handle.state.MessageState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author qiandaxian
 * 连接信息处理
 */
@Component("connect")
public class ConnectMessageHandle implements MessageState {

    Logger logger = LoggerFactory.getLogger(ConnectMessageHandle.class);

    @Override
    public void messageHandle(TsinghuaDeviceMessageDTO messageDTO) {
        logger.info(messageDTO.toString());
    }
}
