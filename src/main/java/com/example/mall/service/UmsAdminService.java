package com.example.mall.service;

import com.example.mall.mbg.mapper.UmsAdminMapper;
import com.example.mall.mbg.model.LoginUser;
import com.example.mall.mbg.model.ums.UmsAdmin;
import com.example.mall.service.imp.UmsAdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class UmsAdminService implements UmsAdminServiceImp {

    @Autowired
    private UmsAdminMapper umsAdminMapper;


    @Override
    public UmsAdmin GetPassword(String name) {
        return umsAdminMapper.selectByname(name);
    }
}
