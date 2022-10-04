package com.example.mall.service.imp;

import com.example.mall.mbg.model.UmsMenu;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UmsMenuServiceImp {
    List<UmsMenu> init(Long id);

    int create(UmsMenu umsMenu);
}
