package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.UmsResource;
import com.example.mall.mbg.model.UmsResourceCategory;
import com.example.mall.service.UmsResourceCategoryService;
import com.example.mall.service.UmsResourceSrvice;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("UmsResourceCategoryController")
public class UmsResourceCategoryController {
    @Resource
    private UmsResourceCategoryService umsResourceCategoryService;

    @GetMapping("init")
    public CommonResult init(@RequestParam("num") int num, @RequestParam("size") int size){
        PageInfo<UmsResourceCategory> init = umsResourceCategoryService.init(num, size);
        if (init == null) {
            return CommonResult.error(400,"UmsResourceCategoryController--init",null);
        }
        return CommonResult.success(200,"UmsResourceCategoryController--init",init);
    }
    @PostMapping("insert")
    public CommonResult insert(@RequestBody UmsResourceCategory umsResourceCategory){
        umsResourceCategory.setCreateTime(new Date());
       int i =  umsResourceCategoryService.insert(umsResourceCategory);
        if (i == 0) {
            return CommonResult.error(400,"UmsResourceCategoryController--insert",null);
        }
        return CommonResult.success(200,"UmsResourceCategoryController--insert",umsResourceCategory);
    }

}
