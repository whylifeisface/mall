package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.Oms.OmsOrderSetting;
import com.example.mall.service.OmsOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("OmsOrderSettingController")
public class OmsOrderSettingController {
    @Autowired
    private OmsOrderSettingService omsOrderSettingService;

    @PostMapping("insert")
    public CommonResult Insert(@RequestBody OmsOrderSetting omsOrderSetting){
        if (omsOrderSetting == null) {
         return    CommonResult.error(403,"error--OmsOrderSettingController--insert",null);
        }

        int insert = omsOrderSettingService.Insert(omsOrderSetting);
        if (insert == 0) {
         return CommonResult.error(400,"error--OmsOrderSettingController--insert",null);

        }
      return CommonResult.success(200,"success--OmsOrderSettingController--insert",null);
    }
    @GetMapping("get")
    public CommonResult get(){
        List<OmsOrderSetting> o = omsOrderSettingService.get();
        if (o == null) {
            return CommonResult.error(400,"error--OmsOrderSettingController--insert",null);
        }
        return CommonResult.success(200,"success--OmsOrderSettingController--insert",o);

    }
}
