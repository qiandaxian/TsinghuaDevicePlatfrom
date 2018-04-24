package com.cictec.middleware.tsinghua.dao.elasticsearch;

import com.cictec.middleware.tsinghua.entity.po.elasticsearch.WarnInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface WarnInfoReponsitory extends ElasticsearchRepository<WarnInfo,String> {
}
