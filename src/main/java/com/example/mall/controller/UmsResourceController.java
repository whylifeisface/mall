package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.UmsResource;
import com.example.mall.service.UmsResourceSrvice;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("UmsResourceController")
public class UmsResourceController
{
    @Resource
    public UmsResourceSrvice umsResourceSrvice;

    @GetMapping("/init")
    public CommonResult init(@RequestParam("num") int num,@RequestParam("size")int size){
       PageInfo<UmsResource> umsResourcePageInfo =
               umsResourceSrvice.init(num,size);
        if (umsResourcePageInfo == null) {
            return CommonResult.error(400,"UmsResourceController--init",null);
        }
        return CommonResult.success(200,"UmsResourceController--init",umsResourcePageInfo);
    }
    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsResource umsResource){
       int i=
               umsResourceSrvice.create(umsResource);
        if (i == 0) {
            return CommonResult.error(400,"UmsResourceController--create",null);
        }
        return CommonResult.success(200,"UmsResourceController--create",null);
    }
    @PostMapping("/update")
    public CommonResult update(@RequestBody UmsResource umsResource){
       int i = umsResourceSrvice.update(umsResource);
        if (i == 0) {
            return CommonResult.error(400,"UmsResourceController--update",null);

        }
        return CommonResult.success(200,"UmsResourceController--update",null);

    }

}
