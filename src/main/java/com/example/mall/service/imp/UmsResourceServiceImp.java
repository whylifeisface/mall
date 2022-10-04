package com.example.mall.service.imp;

import com.example.mall.mbg.model.UmsResource;
import com.github.pagehelper.PageInfo;

public interface UmsResourceServiceImp {
    PageInfo<UmsResource> init(int num, int size);

    int create(UmsResource umsResource);

    int update(UmsResource umsResource);

}
