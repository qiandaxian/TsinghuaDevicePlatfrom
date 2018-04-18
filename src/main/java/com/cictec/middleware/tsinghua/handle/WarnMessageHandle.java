package com.cictec.middleware.tsinghua.handle;

import com.cictec.middleware.tsinghua.entity.dto.TsinghuaDeviceMessageDTO;
import com.cictec.middleware.tsinghua.handle.state.MessageState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author qiandaxian
 * 报警信息处理
 */
@Component("warn")
public class WarnMessageHandle implements MessageState {
    Logger logger = LoggerFactory.getLogger(WarnMessageHandle.class);
    @Override
    public void messageHandle(TsinghuaDeviceMessageDTO messageDTO) {
        logger.info(messageDTO.toString());
    }
}
