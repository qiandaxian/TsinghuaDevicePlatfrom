package com.cictec.middleware.tsinghua.dao.elasticsearch;

import com.cictec.middleware.tsinghua.entity.po.elasticsearch.PositionInfo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

/**
 * 位置信息存储ES
 */
@Service
public interface PositionInfoReponsitory extends ElasticsearchRepository<PositionInfo,String> {

}
