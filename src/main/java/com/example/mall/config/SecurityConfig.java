package com.example.mall.config;

import com.example.mall.common.AdminUserDetails;
//import com.example.mall.config.security.JwtAuthenticationTokenFilter;
import com.example.mall.common.MyuserDetailService;
import com.example.mall.config.security.MyAuthencationFailureHandler;
import com.example.mall.config.security.MyAuthencationSuccessHandler;
import com.example.mall.config.security.RestAuthenticationEntryPoint;
import com.example.mall.config.security.RestfulAccessDeniedHandler;
import com.example.mall.mbg.model.ums.UmsAdmin;
import com.example.mall.mbg.model.ums.UmsPermission;
import com.example.mall.service.UmsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.modeler.BaseAttributeFilter;
import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.*;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Resource
    private DataSource dataSource;
    @Resource
    private MyuserDetailService myuserDetailService;
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth    .inMemoryAuthentication()
                    .withUser("user")
                    .password(passwordEncoder().encode("123456")).roles("admin")
//                    .and()
//                    .userDetailsService(myuserDetailService)
                    .and()
                    .passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .formLogin()
                .loginProcessingUrl("/in")

                .and().rememberMe().rememberMeParameter("rememberMe")
                .tokenRepository(tokenRepository());
        http.logout().logoutUrl("/logout");
        http
                .authorizeRequests()
                .antMatchers("/login/main")
                .permitAll()
                .antMatchers("/in").permitAll()
                .antMatchers("/login.html","/login").permitAll()
                .anyRequest().authenticated()
        ;

        http.headers().cacheControl();
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);

    }



    @Bean
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;

    }



    //配置用户登录密码需要BCryptPasswordEncoder密文认证

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


}
