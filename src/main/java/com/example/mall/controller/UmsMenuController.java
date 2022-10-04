package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.UmsMenu;
import com.example.mall.service.UmsMenuService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("UmsMenuController")
public class UmsMenuController {
    @Resource
    private UmsMenuService umsMenuService;
    @GetMapping("init/{id}")
    public CommonResult init(@PathVariable Long id){
       List<UmsMenu> umsMenuPageInfo=
               umsMenuService.init(id);
        if (umsMenuPageInfo == null) {
            return CommonResult.error(400,"UmsMenuController--init",null);
        }
        return CommonResult.success(200,"UmsMenuController--init",umsMenuPageInfo);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody UmsMenu umsMenu){
      int i=  umsMenuService.create(umsMenu);
        if (i == 0) {
            return CommonResult.error(400,"UmsMenuController--create",null);
        }
        return CommonResult.success(200,"UmsMenuController--create",null);
    }



}
