package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsCoupon;
import com.example.mall.service.imp.SmsCouponService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.activation.CommandMap;
import javax.annotation.Resource;
import java.util.List;

@RequestMapping("SmsCouponController")
@RestController
public class SmsCouponController {
    @Resource
    private SmsCouponService smsCouponService;

    @GetMapping("init")
    public CommonResult init(@RequestParam("num") int num,@RequestParam("size") int size){
        PageInfo<SmsCoupon> smsCouponList=
                smsCouponService.init(num,size);
        if (smsCouponList == null) {
            return CommonResult.error(400,"SmsCouponController--init",null);
        }
       return CommonResult.success(200,"SmsCouponController--init",smsCouponList);
    }
    @GetMapping("sel/{id}")
    public CommonResult sel(@PathVariable Long id){
      SmsCoupon smsCoupon = smsCouponService.sel(id);
        if (smsCoupon == null) {
            return CommonResult.error(400,"SmsCouponController--sel",null);

        }
        return CommonResult.success(200,"SmsCouponController--sel",smsCoupon);
    }
    @PostMapping("get")
    public CommonResult get(@RequestBody SmsCoupon smsCoupon){
      List<SmsCoupon> smsCouponList=
              smsCouponService.get(smsCoupon);
        if (smsCouponList == null) {
            return CommonResult.error(400,"SmsCouponController",null);
        }
        return CommonResult.success(200,"SmsCouponController",smsCouponList);
    }


}
