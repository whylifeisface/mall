package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.UmsRole;
import com.example.mall.service.umsRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("umsRoleController")
@RestController
public class umsRoleController {
    @Resource
    private umsRoleService umsRoleservice;

    @GetMapping("init")
    public CommonResult init(@RequestParam("num") int num,@RequestParam("size") int size){
        PageInfo<UmsRole> umsRolePageInfo =
                umsRoleservice.init(num,size);
        if (umsRolePageInfo == null) {
            return CommonResult.error(400,"umsRoleController--init",null);
        }
        return CommonResult.success(200,"umsRoleController--init",umsRolePageInfo);
    }

    @PostMapping("/get")
    public CommonResult get(@RequestBody UmsRole umsRole){
        List<UmsRole> umsRoleList
                =umsRoleservice.get(umsRole);
        if (umsRoleList == null) {
            return CommonResult.error(400,"umsRoleController--get",null);

        }
        return CommonResult.success(200,"umsRoleController--get",umsRoleList);
    }
    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsRole umsRole){
      int i=  umsRoleservice.create(umsRole);
        if (i == 0) {
            return CommonResult.error(400,"umsRoleController--create",null);
        }
        return CommonResult.success(200,"umsRoleController--create",null);
    }

}
