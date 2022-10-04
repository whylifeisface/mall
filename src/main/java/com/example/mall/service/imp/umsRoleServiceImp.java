package com.example.mall.service.imp;

import com.example.mall.mbg.model.UmsRole;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface umsRoleServiceImp {
    PageInfo<UmsRole> init(int num, int size);

    List<UmsRole> get(UmsRole umsRole);

    int create(UmsRole umsRole);
}
