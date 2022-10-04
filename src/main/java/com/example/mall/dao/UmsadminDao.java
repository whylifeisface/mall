package com.example.mall.dao;

import com.example.mall.mbg.model.ums.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UmsadminDao {
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
