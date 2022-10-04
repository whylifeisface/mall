package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsHomeNewProduct;
import com.example.mall.service.SmsHomeNewProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("SmsHomeNewProductController")
@RestController
public class SmsHomeNewProductController {
    @Resource
    private SmsHomeNewProductService smsHomeNewProductService;

    @GetMapping("init")
    public CommonResult init(@RequestParam("num") int num, @RequestParam("size") int size){
      PageInfo<SmsHomeNewProduct> smsHomeNewProductPageInfo=
              smsHomeNewProductService.init(num,size);
        if (smsHomeNewProductPageInfo == null) {
            return CommonResult.error(400,"SmsHomeNewProductController---init",null);
        }
        return CommonResult.success(200,"SmsHomeNewProductController--init",null);
    }
    @PostMapping("get")
    public CommonResult get(@RequestBody(required = false) SmsHomeNewProduct smsHomeNewProduct){
        List<SmsHomeNewProduct> smsHomeNewProductList=
                smsHomeNewProductService.get(smsHomeNewProduct);
        if (smsHomeNewProductList == null) {
            return CommonResult.error(400,"SmsHomeNewProductController--get",null);
        }
        return CommonResult.success(200,"SmsHomeNewProductController--get",smsHomeNewProductList);
    }
    @PostMapping("del/{id}")
    public CommonResult del(@PathVariable Long id){
       int i = smsHomeNewProductService.del(id);
        if (i == 0) {
            return CommonResult.error(400,"SmsHomeNewProductController--del",null);
        }
        return CommonResult.success(200,"SmsHomeNewProductController--del",null);
    }
    @PostMapping("update")
    public CommonResult update(@RequestBody SmsHomeNewProduct smsHomeNewProduct) {
       int i = smsHomeNewProductService.update(smsHomeNewProduct);
        if (i == 0) {
            return CommonResult.error(400,"SmsHomeNewProductController--del",null);
        }
        return CommonResult.success(200,"SmsHomeNewProductController--del",null);

    }


    }
