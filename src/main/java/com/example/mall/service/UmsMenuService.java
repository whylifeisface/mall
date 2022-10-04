package com.example.mall.service;

import com.example.mall.mbg.mapper.UmsMenuMapper;
import com.example.mall.mbg.model.UmsMenu;
import com.example.mall.mbg.model.UmsMenuExample;
import com.example.mall.service.imp.UmsMenuServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UmsMenuService implements UmsMenuServiceImp {
    @Resource
    private UmsMenuMapper umsMenuMapper;


    @Override
    public List<UmsMenu> init(Long id) {
        return umsMenuMapper.init(id);

    }

    @Override
    public int create(UmsMenu umsMenu) {
        return umsMenuMapper.insert(umsMenu);
    }
}
