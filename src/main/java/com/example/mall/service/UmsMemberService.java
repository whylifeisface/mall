package com.example.mall.service;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.mapper.UmsMemberMapper;
import com.example.mall.service.imp.UmsMemberServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;


@Service
public class UmsMemberService implements UmsMemberServiceImp {
    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult getAuthCode(String telephone) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i=0 ; i<6 ; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,stringBuilder.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);

        return CommonResult.success(200,"获取验证码成功",stringBuilder.toString());

    }

    @Override
    public CommonResult updatePassword(String telephone,String author) {
        if (StringUtils.isEmpty(author)){
            return CommonResult.error(400,"请输入密码",null);
        }
        String code = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE);
        boolean result = author.equals(code);
        if (result){
            return CommonResult.success(200,"验证成功",null);
        }
        return CommonResult.error(440,"验证吗错误",null);

    }
}
