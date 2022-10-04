package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsFlashPromotionSession;
import com.example.mall.service.SmsFlashPromotionSessionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("SmsFlashPromotionSessionController")
public class SmsFlashPromotionSessionController {
    @Resource
    private SmsFlashPromotionSessionService smsFlashPromotionSessionService;

    @GetMapping("/init")
    public CommonResult init(){
      List<SmsFlashPromotionSession> list = smsFlashPromotionSessionService.init();
        if (list == null) {
            return CommonResult.error(400,"SmsFlashPromotionSessionController--init",null);
        }
        return  CommonResult.success(200,"SmsFlashPromotionSessionController--init",list);
    }
    @GetMapping("del/{id}")
    public CommonResult del(@PathVariable Long id){
      int i = smsFlashPromotionSessionService.del(id);
        if (i == 0) {
            return CommonResult.error(400,"SmsFlashPromotionSessionController--init",null);
        }
        return  CommonResult.success(200,"SmsFlashPromotionSessionController--init",null);
    }

    //
}
