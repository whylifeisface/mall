package com.example.mall.service;

import com.example.mall.mbg.mapper.UmsRoleMapper;
import com.example.mall.mbg.model.UmsRole;
import com.example.mall.mbg.model.UmsRoleExample;
import com.example.mall.service.imp.umsRoleServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class umsRoleService implements umsRoleServiceImp {
    @Resource
    private UmsRoleMapper umsRoleMapper;

    @Override
    public PageInfo<UmsRole> init(int num, int size) {
        PageHelper.startPage(num, size);
        List<UmsRole> umsRoles = umsRoleMapper.selectByExample(new UmsRoleExample());
        return new PageInfo<>(umsRoles);
    }

    @Override
    public List<UmsRole> get(UmsRole umsRole) {

        return umsRoleMapper.get(umsRole);
    }

    @Override
    public int create(UmsRole umsRole) {

        return umsRoleMapper.insert(umsRole);
    }
}
