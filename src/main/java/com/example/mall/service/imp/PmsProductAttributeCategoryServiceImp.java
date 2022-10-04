package com.example.mall.service.imp;

import com.example.mall.mbg.model.pms.PmsProductAttributeCategory;

import java.util.List;


public interface PmsProductAttributeCategoryServiceImp {
    List<PmsProductAttributeCategory> list();
    List<PmsProductAttributeCategory> selectById(Long id    );

    List<PmsProductAttributeCategory> sql();

    int insert(PmsProductAttributeCategory pmsService);
    int del(Long del);

    int update(PmsProductAttributeCategory pmsProductAttributeCategory);
}
