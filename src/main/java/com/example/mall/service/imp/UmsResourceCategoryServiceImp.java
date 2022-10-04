package com.example.mall.service.imp;

import com.example.mall.mbg.model.UmsResourceCategory;
import com.github.pagehelper.PageInfo;

public interface UmsResourceCategoryServiceImp {
    PageInfo<UmsResourceCategory> init(int num, int size);

    int insert(UmsResourceCategory umsResourceCategory);
}
