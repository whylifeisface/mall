package com.example.mall.service;

import com.example.mall.mbg.mapper.PmsSkuStockMapper;
import com.example.mall.mbg.model.PmsSkuStock;
import com.example.mall.service.imp.PmsSkuStockServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsSkuStockService implements PmsSkuStockServiceImp {

    @Autowired
    private PmsSkuStockMapper mapper;


    @Override
    public List<PmsSkuStock> SelectById(Long id) {

       return mapper.select(id);
    }


}
