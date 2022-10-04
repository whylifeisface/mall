package com.example.mall.service.imp;

import com.example.mall.mbg.model.pms.PmsProductCategory;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PmsProductCategoryServiceImp {
    Long getTotal();
    List<PmsProductCategory> linInId(Long id);
    PageInfo parentId(Long id, int num , int size);

    PmsProductCategory SelectById(Long id);

    PageInfo<PmsProductCategory> getPage(int size, int num);

    List<PmsProductCategory> getProductCategory();

    PmsProductCategory selectOne(Long id);

    int editProductCategory(PmsProductCategory pmsProductCategory);

    int deleteProductCategory(Long id);

    int insertProductCategory(PmsProductCategory pmsProductCategory);



}
