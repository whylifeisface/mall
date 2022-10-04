package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsHomeAdvertise;
import com.example.mall.service.smsHomeAdvertiseService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("SmsHomeAdvertiseController")
@RestController
public class SmsHomeAdvertiseController {
    @Resource
    private smsHomeAdvertiseService advertiseService;
    @GetMapping("init")
    public CommonResult init(@RequestParam("num") int num,@RequestParam("size") int size){
       PageInfo<SmsHomeAdvertise> smsHomeAdvertisePageInfo =
               advertiseService.init(num,size);
        if (smsHomeAdvertisePageInfo == null) {
            return CommonResult.error(400,"SmsHomeAdvertiseController -- init",null);
        }
        return CommonResult.success(200,"SmsHomeAdvertiseController -- init",smsHomeAdvertisePageInfo);
    }
    @PostMapping("get")
    public CommonResult get(@RequestBody(required = false)SmsHomeAdvertise smsHomeAdvertise){
      List<SmsHomeAdvertise> smsHomeAdvertiseList=
              advertiseService.get(smsHomeAdvertise);
        if (smsHomeAdvertiseList == null) {
            return CommonResult.error(400,"SmsHomeAdvertiseController -- get",null);
        }
        return CommonResult.success(200,"SmsHomeAdvertiseController -- get",smsHomeAdvertise);
    }
    @PostMapping("update")
    public CommonResult update(@RequestBody SmsHomeAdvertise smsHomeAdvertise){
      int i=
              advertiseService.update(smsHomeAdvertise);
        if (i == 0) {
            return CommonResult.error(400,"SmsHomeAdvertiseController -- update",null);
        }
        return CommonResult.success(200,"SmsHomeAdvertiseController -- update",null);
    }
    @PostMapping("del/{id}")
    public CommonResult del(@PathVariable Long id){
       int i =
               advertiseService.del(id);
        if (i == 0) {
            return CommonResult.error(400,"SmsHomeAdvertiseController -- del",null);
        }
        return CommonResult.success(200,"SmsHomeAdvertiseController -- del",null);
    }
}
