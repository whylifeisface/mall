package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsFlashPromotion;
import com.example.mall.service.smsFlashPromotionService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("SmsFlashPromotionController")
public class SmsFlashPromotionController {
    @Resource
    private smsFlashPromotionService smsFlashPromotionService;

    @GetMapping("init")
    public CommonResult init(@RequestParam("num") int num,@RequestParam("size") int size){
        PageInfo<SmsFlashPromotion> init = smsFlashPromotionService.init(num, size);
        if (init == null) {
            return  CommonResult.error(400,"SmsFlashPromotionController--init",null);
        }
        return CommonResult.success(200,"SmsFlashPromotionController--init",init);
    }



}
