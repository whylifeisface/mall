package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.ums.UmsAdmin;
import com.example.mall.mbg.model.ums.UmsLoginAdmin;
import com.example.mall.mbg.model.ums.UmsPermission;
import com.example.mall.service.UmsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("UmsAdminController")
@Api(tags = "UmsAdminController",description = "后台用户管理")
public class UmsAdminController {

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Autowired
    private UmsService umsService;
    @ApiOperation("用户注册")
    @PostMapping("register")
    public CommonResult register(@RequestBody UmsAdmin umsAdmin
                                 ){
        UmsAdmin register = umsService.register(umsAdmin);
        if (null != register){
            return CommonResult.success(200,"register-success",register);
        }
        return CommonResult.error(400,"register--error",null);
    }

    @PostMapping("login")
    @ApiOperation("用户登录")
    public CommonResult login(@RequestBody UmsLoginAdmin umsLoginAdmin){
        String token = umsService.login(umsLoginAdmin.getUsername(), umsLoginAdmin.getPassword());
        if (null != token){
            HashMap<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token",token);
            tokenMap.put("tokenHead",tokenHead);
            return CommonResult.success(200,"login--success",tokenMap);
        }
        return CommonResult.error(400,"login--error",null);
    }

    @GetMapping("permission/{id}")
    public CommonResult getPermissionList(@PathVariable("id")Long id ){
        List<UmsPermission> permissionList = umsService.getPermissionList(id);
        return CommonResult.success(200,"permission-success",permissionList);
    }
    @GetMapping("/init")
    public CommonResult init(@RequestParam("num") int num, @RequestParam("size") int size){
       PageInfo<UmsAdmin> umsAdminPageInfo =
               umsService.init(num,size);
        if (umsAdminPageInfo == null) {
            return CommonResult.error(400,"init--error",null);

        }
        return CommonResult.success(200,"init--success",umsAdminPageInfo);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsAdmin umsAdmin){
      int i =   umsService.create(umsAdmin);
        if (i == 0) {
            return CommonResult.error(400,"init--error",null);

        }
        return CommonResult.success(200,"init--success",null);

    }
}
