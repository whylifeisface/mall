package com.example.mall.service;

import com.example.mall.common.JwtTokenUtil;
import com.example.mall.service.imp.LoginServiceImp;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService implements LoginServiceImp {
    @Override
    public String createJwtToken(String username) {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        return jwtTokenUtil.generateToken(username);
    }



}
