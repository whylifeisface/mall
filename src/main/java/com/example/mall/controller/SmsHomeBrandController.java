package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsCouponHistory;
import com.example.mall.mbg.model.SmsHomeBrand;
import com.example.mall.service.SmsHomeBrandService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("SmsHomeBrandController")
public class SmsHomeBrandController {
    @Resource
    private SmsHomeBrandService smsHomeBrandService;

    @GetMapping("init")
    public CommonResult init(@RequestParam("num") int num, @RequestParam("size") int size){
        PageInfo<SmsHomeBrand> smsHomeBrands = smsHomeBrandService.init(num,size);
        if (smsHomeBrands == null) {
            return CommonResult.error(400,"SmsHomeBrandController---init",null);
        }
        return CommonResult.success(200,"SmsHomeBrandController---init",smsHomeBrands);
    }
    @PostMapping("form")
    public CommonResult form(@RequestBody(required = false) SmsHomeBrand smsHomeBrand){
      List<SmsHomeBrand> smsHomeBrands=
              smsHomeBrandService.form(smsHomeBrand);
        if (smsHomeBrands == null) {
            return CommonResult.error(400,"SmsHomeBrandController---form",null);

        }
        return CommonResult.success(200,"SmsHomeBrandController---form",smsHomeBrands);
    }

    @PostMapping("update")
    public CommonResult update(@RequestBody SmsHomeBrand smsHomeBrand){
       int i = smsHomeBrandService.update(smsHomeBrand);
        if (i == 0) {
            return CommonResult.error(400,"SmsHomeBrandController---form",null);

        }
        return CommonResult.success(200,"SmsHomeBrandController---form",null);
    }
    @PostMapping("del/{id}")
    public CommonResult del(@PathVariable Long id){
        int i = smsHomeBrandService.del(id);
        if (i == 0) {
            return CommonResult.error(400,"SmsHomeBrandController---form",null);

        }
        return CommonResult.success(200,"SmsHomeBrandController---form",null);
    }

}
