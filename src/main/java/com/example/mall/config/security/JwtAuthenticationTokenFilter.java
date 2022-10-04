package com.example.mall.config.security;


import com.example.mall.common.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//
//在用户名和密码校验前添加的过滤器，如果请求中有jwt的token且有效，
// 会取出token中的用户名，然后调用SpringSecurity的API进行登录操作。
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("")
    private String TokenHeader;
    @Value("")
    private String TokenHead;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.TokenHeader);
        if (null != authHeader && authHeader.startsWith(this.TokenHead)){
            String Token = authHeader.substring(this.TokenHead.length());
            String userNameFromToken = jwtTokenUtil.getUserNameFromToken(Token);
            LOGGER.info("登录:{}",userNameFromToken);
            if (null != userNameFromToken && SecurityContextHolder.getContext().getAuthentication() != null){
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userNameFromToken);
                if (jwtTokenUtil.validateToken(Token,userDetails)){
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            LOGGER.info("authenticated user:{}", userNameFromToken);
                            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);


                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
