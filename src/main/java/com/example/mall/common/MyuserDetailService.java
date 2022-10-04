package com.example.mall.common;

import com.alibaba.druid.sql.visitor.functions.If;
import com.example.mall.mbg.mapper.UmsAdminMapper;
import com.example.mall.mbg.mapper.UmsPermissionMapper;
import com.example.mall.mbg.mapper.UmsRoleMapper;
import com.example.mall.mbg.model.UmsRole;
import com.example.mall.mbg.model.ums.UmsAdmin;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MyuserDetailService implements UserDetailsService {

    @Resource
    private UmsAdminMapper umsAdminMapper;
    @Resource
    private UmsRoleMapper umsRoleMapper;
    @Resource
    private UmsPermissionMapper umsPermissionMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        用户数据加载
        UmsAdmin umsAdmin
                = umsAdminMapper.selectByname(username);
//        用户角色加载
         long id = umsRoleMapper.getId();
//        根据角色加载权限
        List<String> authority =  umsPermissionMapper.getPermission(id);

      return new AdminUserDetails(umsAdmin.getUsername(),umsAdmin.getPassword(),
                umsAdmin.getStatus()==0, AuthorityUtils.commaSeparatedStringToAuthorityList(
                        String.join(",",authority)
        ));



    }
}
