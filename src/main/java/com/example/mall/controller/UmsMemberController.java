package com.example.mall.controller;


import com.example.mall.common.CommonResult;
import com.example.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "UmsMemberController",description = "会员登录注册管理")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @GetMapping("sso/get")
    @ApiOperation("获取验证码")
    public CommonResult getAuthCode(@RequestParam String telephone){
     return umsMemberService.getAuthCode(telephone);
    }
    @GetMapping("sso/update")
    @ApiOperation("判断验证码是否正确")
    public CommonResult updatePassword(@RequestParam String telephone,
    @RequestParam String authCode){
       return   umsMemberService.updatePassword(telephone,authCode);
    }
}
