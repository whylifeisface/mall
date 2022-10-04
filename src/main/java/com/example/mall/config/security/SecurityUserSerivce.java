package com.example.mall.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//public class SecurityUserSerivce implements UserDetailsService {
//
////    @Autowired
////    private UserService userService;
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        User user = userService.queryUserByName(username);
////        if (user == null) {
////            try {
////                throw new Exception("user does not exist");
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
////        return user;
////    }
//}
