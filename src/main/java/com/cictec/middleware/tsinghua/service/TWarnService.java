package com.cictec.middleware.tsinghua.service;
import com.cictec.middleware.tsinghua.entity.po.TWarn;
import com.cictec.middleware.tsinghua.config.Service;

import java.util.Map;


/**
 * Created by daxian on 2018/04/24.
 */
public interface TWarnService extends Service<TWarn> {

    TWarn getWarnByDevCodeAndHexLocationBuf(Map paramMap);

}
