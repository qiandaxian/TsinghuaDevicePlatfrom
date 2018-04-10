package com.cictec.middleware.tsinghua.service.impl;

import com.cictec.middleware.tsinghua.entity.po.TDevice;
import com.cictec.middleware.tsinghua.service.TDeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TDeviceServiceImplTest {
    @Autowired
    private TDeviceService tDeviceService;

    @Test
    public void test1(){
        List<TDevice> deviceList = tDeviceService.findAll();
        System.out.println(deviceList.size());
    }
}