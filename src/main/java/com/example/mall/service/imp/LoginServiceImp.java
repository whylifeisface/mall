package com.example.mall.service.imp;

import org.springframework.security.core.userdetails.UserDetails;

public interface LoginServiceImp {
    String createJwtToken(String username);
}
