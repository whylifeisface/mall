package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.pms.PmsProductAttributeCategory;
import com.example.mall.mbg.model.pms.PmsProductCategory;
import com.example.mall.service.PmsProductAttributeCategoryService;
import com.example.mall.service.PmsProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("PmsProductAttributeCategoryController")
public class PmsProductAttributeCategoryController {
    @Autowired
    private PmsProductAttributeCategoryService pmsService;

    @GetMapping("/sql")
    public CommonResult sql(){
        List<PmsProductAttributeCategory> sql = pmsService.sql();
        if (sql == null) {
            return CommonResult.error(400,"PmsProductAttributeCategoryController----sql--error",null);

        }
        return CommonResult.success(200,"PmsProductAttributeCategoryController----sql--success",sql);

    }


    @GetMapping("/by/{id}")
    public CommonResult selectById(@PathVariable Long id){
        if (id == null) {
            return CommonResult.error(400,"PmsProductAttributeCategoryController----selectById--error",null);

        }

        List<PmsProductAttributeCategory> pmsProductAttributeCategories = pmsService.selectById(id);
        if (pmsProductAttributeCategories == null) {
            return CommonResult.error(400,"PmsProductAttributeCategoryController----selectById--error",null);

        }
        return CommonResult
                .success(200,
                        "PmsProductAttributeCategoryController----selectById--success",pmsProductAttributeCategories);

    }

    @GetMapping("delete/{del}")
    public  CommonResult del(@PathVariable Long del){
        if (del == null) {
            return CommonResult.error(400,"PmsProductAttributeCategoryController----del--error",null);
        }
        int del1 = pmsService.del(del);
        if (del1 == 0) {
            return CommonResult.error(400,"PmsProductAttributeCategoryController----del--error",null);

        }
        return CommonResult.success(200,"PmsProductAttributeCategoryController----del--success",null);

    }
    @GetMapping("list")
    public CommonResult list(){
      List<PmsProductAttributeCategory> pmsProductCategories = pmsService.list();
        if (pmsProductCategories == null) {
            return CommonResult.error(400,"PmsProductAttributeCategoryController--error",null);
        }
        return CommonResult.success(200,"PmsProductAttributeCategoryController--success",pmsProductCategories);

    }
    @GetMapping("insert")//只传上来一个name多少有点问题
    public CommonResult insert(@RequestBody PmsProductAttributeCategory pmsProductAttributeCategory){
     int i = pmsService.insert(pmsProductAttributeCategory);
        if (i == 0) {
            return CommonResult.error(400,"PmsProductAttributeCategoryController--error--insert",null);

        }
        return CommonResult.success(200,"PmsProductAttributeCategoryController--success--insert",null);
    }
    @GetMapping("update")
    public CommonResult update(@RequestBody PmsProductAttributeCategory pmsProductAttributeCategory){
          int i = pmsService.update(pmsProductAttributeCategory);
        if (i == 0) {
            return CommonResult.error(400,"PmsProductAttributeCategoryController--error--insert",null);
        }
        return CommonResult.success(200,"PmsProductAttributeCategoryController--success--insert",null);

    }
}
