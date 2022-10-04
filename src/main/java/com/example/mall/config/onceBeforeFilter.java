package com.example.mall.config;

import com.alibaba.druid.sql.visitor.functions.If;
import com.example.mall.common.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
public class onceBeforeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain filterChain) throws ServletException, IOException {


        // 请求的源:
        if(req.getRequestURI() == "/login/main"){
            filterChain.doFilter(req, res);
            log.info("passing" );

        }

        if (Objects.equals(req.getRequestURI(), "/login/main")) {
            log.info("logining");

            filterChain.doFilter(req, res);
        }
        log.info("請求路徑是{}",req.getRequestURI());

        Cookie[] cookies = req.getCookies();

        for (Cookie cookie :
                cookies) {
            if (cookie.getValue().equals("already")) {
                log.info("通過OncePerRequestFilter");
                String origin= req.getHeader("Origin");
                res.setHeader("Access-Control-Allow-Origin", origin);
                res.setHeader("Access-Control-Allow-Credentials", "true");
                res.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
                res.setHeader("Access-Control-Max-Age", "3600");
                res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

                filterChain.doFilter(req, res);
            }
        }
    }
}