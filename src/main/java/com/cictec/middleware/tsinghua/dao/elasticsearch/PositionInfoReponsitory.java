package com.cictec.middleware.tsinghua.dao.elasticsearch;

import com.cictec.middleware.tsinghua.entity.po.elasticsearch.PositionInfo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PositionInfoReponsitory extends ElasticsearchRepository<PositionInfo,String> {

}
