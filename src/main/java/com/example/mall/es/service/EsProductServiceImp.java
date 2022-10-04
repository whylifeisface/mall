package com.example.mall.es.service;

import com.example.mall.es.model.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsProductServiceImp {
    int importAll();

    void delete(Long id);

    EsProduct create(Long id);

    void delete(List<Long> ids);

    Page<EsProduct> search(String keywords,Integer pageNum,Integer pageSize);

}
