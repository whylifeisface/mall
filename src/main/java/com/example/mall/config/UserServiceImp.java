package com.example.mall.config;

import com.example.mall.common.UserException;
import com.example.mall.mbg.mapper.UmsAdminMapper;
import com.example.mall.mbg.model.ums.UmsAdmin;
import com.example.mall.service.UmsAdminService;
import com.example.mall.service.UmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

//@Service
//public class UserServiceImp implements UserDetailsService {
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UmsAdminService umsAdminService = new UmsAdminService();
//        if (Objects.equals(username, " "))
//            return null;
//        //抛出用戶名不能爲空
//        try {
//            throw new UserException("用戶名不能爲空");
//        } catch (UserException e) {
////
//            System.out.println("用戶名不能爲空");
//        }
//        UmsAdmin adminByName = umsAdminService.getAdminByName(username);
//        if (adminByName == null) {
//            //自定義401用戶找不到異常;
////            return null;
//            throw new UsernameNotFoundException("用戶名或密碼錯誤");
//        }
//
//        return new User(username,adminByName.getPassword(), AuthorityUtils.NO_AUTHORITIES);
//    }
//    public String getPassWord(String username){
//        UmsAdminService umsAdminService = new UmsAdminService();
//
//        return umsAdminService.GetPassword(username).getPassword();
//    }
//
//}
