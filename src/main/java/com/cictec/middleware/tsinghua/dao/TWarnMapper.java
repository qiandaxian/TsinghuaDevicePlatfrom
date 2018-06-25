package com.cictec.middleware.tsinghua.dao;

import com.cictec.middleware.tsinghua.config.Mapper;
import com.cictec.middleware.tsinghua.entity.po.TWarn;

import java.util.Map;

public interface TWarnMapper extends Mapper<TWarn> {

    TWarn getWarnByDevCodeAndHexLocationBuf(Map paramMap);

}