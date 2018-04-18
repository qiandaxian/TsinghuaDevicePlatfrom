package com.cictec.middleware.tsinghua.handle.state;

import com.cictec.middleware.tsinghua.entity.dto.TsinghuaDeviceMessageDTO;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * @author qiandaxian
 * messageState上下文，用于自动获取执行handle
 */
@Component
public class MessageStateContext implements ApplicationContextAware {
    Logger logger = LoggerFactory.getLogger(MessageStateContext.class);

    private ApplicationContext context;
    private MessageState messageState;

    public void messageHandle(TsinghuaDeviceMessageDTO messageDTO){
        this.setMessageState(messageDTO);
        messageState.messageHandle(messageDTO);
    }

    public void setMessageState(TsinghuaDeviceMessageDTO messageDTO){
        this.messageState = (MessageState)context.getBean(messageDTO.getType());
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
