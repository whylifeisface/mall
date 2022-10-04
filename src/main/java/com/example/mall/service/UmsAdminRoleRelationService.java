package com.example.mall.service;

import com.example.mall.mbg.mapper.UmsAdminRoleRelationMapper;
import com.example.mall.mbg.model.UmsAdminRoleRelation;
import com.example.mall.service.imp.UmsAdminRoleRelationServiceImp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UmsAdminRoleRelationService implements UmsAdminRoleRelationServiceImp {
@Resource
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

    @Override
    public int insert(UmsAdminRoleRelation umsAdminRoleRelation) {

      return umsAdminRoleRelationMapper.nsert(umsAdminRoleRelation);
    }
}
