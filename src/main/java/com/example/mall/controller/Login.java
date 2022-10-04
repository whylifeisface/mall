package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.common.UserException;
import com.example.mall.service.LoginService;
import com.example.mall.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@RestController
@RequestMapping("/login")
@Slf4j
public class Login {
    @Autowired
    private UmsAdminService umsAdminService;
    @Autowired
    private LoginService loginService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @PostMapping("/main")
    public CommonResult main(HttpServletResponse response,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password) throws UserException {
        //获取用户信息，存放到session域中
        String passWord =  umsAdminService.GetPassword(username).getPassword();
        System.out.println("Aaaa");
        if (!Objects.equals(passWord, password)) {
            //抛出用戶名密碼錯誤異常
            throw new UsernameNotFoundException("用戶名或密碼錯誤");

        }

        log.info("用戶正常");
        Cookie cookie = new Cookie("login", "already");
        cookie.setPath("/");
        if (cookie != null) cookie.setMaxAge(60*60*60);
        System.out.println("1");
        response.addCookie(cookie);
        //如何在前後端分離的情況下 把Cookie返回出去 不會 先寫出去 结束了
        System.out.println("11");

        //token生成 token写入浏览器 写入数据库
        String jwtToken = tokenHead +" "+ loginService.createJwtToken(username);
        response.setHeader( tokenHeader,jwtToken);

        return CommonResult.success(200,"success",null);
    }


}
