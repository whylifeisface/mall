package com.example.mall.es.dao;

import com.example.mall.es.model.EsProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EsProductDao {
    List<EsProduct> getAllFromMysql(@Param("id")Long id);
}
