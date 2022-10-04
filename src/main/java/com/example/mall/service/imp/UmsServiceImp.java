package com.example.mall.service.imp;

import com.example.mall.mbg.model.ums.UmsAdmin;
import com.example.mall.mbg.model.ums.UmsPermission;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UmsServiceImp {
    UmsAdmin getAdminByUserName(String username);
    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long id);
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    PageInfo<UmsAdmin> init(int num, int size);

    int create(UmsAdmin umsAdmin);
}
