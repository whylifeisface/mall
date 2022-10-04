package com.example.mall.service.imp;

import com.example.mall.mbg.model.PmsSkuStock;

import java.util.List;

public interface PmsSkuStockServiceImp {

    public List<PmsSkuStock> SelectById(Long id);

}
