package com.example.mall.service;


import com.example.mall.common.JwtTokenUtil;
import com.example.mall.dao.UmsadminDaoImp;
import com.example.mall.mbg.mapper.UmsAdminMapper;
import com.example.mall.mbg.model.ums.UmsAdmin;
import com.example.mall.mbg.model.ums.UmsAdminExample;
import com.example.mall.mbg.model.ums.UmsPermission;
import com.example.mall.service.imp.UmsServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UmsService implements UmsServiceImp {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private UmsadminDaoImp adminDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public UmsAdmin getAdminByUserName(String username) {

        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectByExample(new UmsAdminExample());
        if (null != umsAdmins){
            return umsAdmins.get(0);
        }
        return null;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long id) {
        return adminDao.getPermissionList(id);
    }

    @Override
    public String login(String username, String password) {
        String Token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            Token = jwtTokenUtil.generateToken(userDetails.getUsername());
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();

        }
        return Token;
    }

    @Override
    public PageInfo<UmsAdmin> init(int num, int size) {
        PageHelper.startPage(num, size);
        List<UmsAdmin> umsAdmins =
                umsAdminMapper.selectByExample(new UmsAdminExample());
        return new PageInfo<>(umsAdmins);
    }

    @Override
    public int create(UmsAdmin umsAdmin) {

        return umsAdminMapper.insert(umsAdmin);
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdmin,umsAdminParam);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectByExample(example);
        if (umsAdmins.size()>0){
            return  null;
        }
        String encode = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encode);
        umsAdminMapper.insert(umsAdmin);
        return umsAdmin;


    }
}
