package com.example.mall.dao;

import com.example.mall.mbg.mapper.UmsPermissionMapper;
import com.example.mall.mbg.model.ums.UmsPermission;
import com.example.mall.mbg.model.ums.UmsPermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UmsadminDaoImp implements UmsadminDao {
    @Autowired
    private UmsPermissionMapper umsPermissionMapper;

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return umsPermissionMapper.selectByExample(new UmsPermissionExample());
    }
}
