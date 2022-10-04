package com.example.mall.service;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.mapper.UmsResourceMapper;
import com.example.mall.mbg.mapper.UmsRoleMapper;
import com.example.mall.mbg.model.UmsResource;
import com.example.mall.mbg.model.UmsResourceExample;
import com.example.mall.service.imp.UmsResourceServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UmsResourceSrvice implements UmsResourceServiceImp {
    @Resource
    private UmsResourceMapper umsResourceMapper;


    @Override
    public PageInfo<UmsResource> init(int num, int size) {
        PageHelper.startPage(num, size);

      List<UmsResource> umsResourceList=  umsResourceMapper.init();
        return new PageInfo<>(umsResourceList);
    }

    @Override
    public int create(UmsResource umsResource) {

        return umsResourceMapper.insert(umsResource);
    }

    @Override
    public int update(UmsResource umsResource) {

        return umsResourceMapper.updateByExample(umsResource,new UmsResourceExample());
    }
}
