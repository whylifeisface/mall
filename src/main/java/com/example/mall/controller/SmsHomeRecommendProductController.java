package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsHomeRecommendProduct;
import com.example.mall.service.SmsHomeRecommendProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("SmsHomeRecommendProductController")
@RestController
public class SmsHomeRecommendProductController {
    @Resource
    private SmsHomeRecommendProductService smsHomeRecommendProductService;
    @GetMapping("init")
    public CommonResult init(
            @RequestParam("num")int num,
            @RequestParam("size") int size
    ){
      PageInfo<SmsHomeRecommendProduct> smsHomeRecommendProductPageInfo=
              smsHomeRecommendProductService.init(num,size);
        if (smsHomeRecommendProductPageInfo == null) {
            return CommonResult.error(400,"SmsHomeRecommendProductController--init",null);
        }
      return CommonResult.success(200,"SmsHomeRecommendProductController--init",smsHomeRecommendProductPageInfo);
    }

    @PostMapping("get")
    public CommonResult get(@RequestBody(required = false) SmsHomeRecommendProduct smsHomeRecommendProduct){
       List<SmsHomeRecommendProduct> smsHomeRecommendProductList =
               smsHomeRecommendProductService.get(smsHomeRecommendProduct);
        if (smsHomeRecommendProductList == null) {
            return CommonResult.error(400,"SmsHomeRecommendProductController--get",null);

        }      return CommonResult.success(200,"SmsHomeRecommendProductController--get",smsHomeRecommendProductList);
    }
    @PostMapping("update")
    public CommonResult update(@RequestBody SmsHomeRecommendProduct smsHomeRecommendProduct){
        int smsHomeRecommendProductList =
                smsHomeRecommendProductService.update(smsHomeRecommendProduct);
        if (smsHomeRecommendProductList == 0) {
            return CommonResult.error(400,"SmsHomeRecommendProductController--update",null);

        }      return CommonResult.success(200,"SmsHomeRecommendProductController--update",smsHomeRecommendProduct);
    }
    @PostMapping("del/{id}")
    public CommonResult del(@PathVariable Long id){
        int smsHomeRecommendProductList =
                smsHomeRecommendProductService.del(id);
        if (smsHomeRecommendProductList == 0) {
            return CommonResult.error(400,"SmsHomeRecommendProductController--del",null);

        }      return CommonResult.success(200,"SmsHomeRecommendProductController--del",null);
    }
    @GetMapping("sql")
    public CommonResult sql(){
     List<SmsHomeRecommendProduct> smsHomeRecommendProductLists=
             smsHomeRecommendProductService.sql();
        if (smsHomeRecommendProductLists == null) {
            return CommonResult.error(400,"SmsHomeRecommendProductController--sql",null);
        }
        return CommonResult.success(200,"SmsHomeRecommendProductController--sql",smsHomeRecommendProductLists);
    }
}
