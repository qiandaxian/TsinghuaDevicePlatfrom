package com.cictec.middleware.tsinghua;

import com.cictec.middleware.tsinghua.entity.po.TDevice;
import com.cictec.middleware.tsinghua.service.TDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @date 2018年2月9日 下午2:46:23 
 */  
@Component
public class TsinghuaDevicePlatfromApplicationRunner implements ApplicationRunner {

	
	private static final Logger logger = LoggerFactory.getLogger(TsinghuaDevicePlatfromApplicationRunner.class);

	@Autowired
	private TDeviceService deviceService;

	
	
    @Override  
    public void run(ApplicationArguments args) throws Exception {
    	logger.info("程序启动开始...");
        deviceService.allDeviceOffline();
        logger.info("所以设备状态设置为离线...");

    }
    
} 