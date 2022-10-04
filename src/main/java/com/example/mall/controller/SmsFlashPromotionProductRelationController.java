package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsFlashPromotionProductRelation;
import com.example.mall.service.SmsFlashPromotionProductRelationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("SmsFlashPromotionProductRelationController")
@RestController
public class SmsFlashPromotionProductRelationController {

    @Resource
    private SmsFlashPromotionProductRelationService smsFlashPromotionProductRelationService;

    @GetMapping("init")
    public CommonResult init(){
       List<SmsFlashPromotionProductRelation>smsFlashPromotionProductRelations
               = smsFlashPromotionProductRelationService.init();
        if (smsFlashPromotionProductRelations == null) {
            return CommonResult.error(400,"SmsFlashPromotionProductRelationService--init",null);
        }
        return CommonResult.success(200,"SmsFlashPromotionProductRelationService--init",smsFlashPromotionProductRelations);
    }
    @GetMapping("/joinPmsProduct/{id}")
    public CommonResult joinPmsProduct(@PathVariable Long id ){
       List<SmsFlashPromotionProductRelation> smsFlashPromotionProductRelations=
               smsFlashPromotionProductRelationService.joinPmsProduct(id);
        if (smsFlashPromotionProductRelations == null) {
            return CommonResult.error(400,"SmsFlashPromotionProductRelationService--joinPmsProduct",null);
        }
        return CommonResult.success(200,"SmsFlashPromotionProductRelationService--joinPmsProduct",smsFlashPromotionProductRelations);
    }
    @GetMapping("twice")
    public CommonResult twice(){
       List<SmsFlashPromotionProductRelation> smsFlashPromotionProductRelations=
               smsFlashPromotionProductRelationService.twice();
        if (smsFlashPromotionProductRelations == null) {
            return CommonResult.error(400,"SmsFlashPromotionProductRelationService--twice",null);
        }
        return CommonResult.success(200,"SmsFlashPromotionProductRelationService--twice",smsFlashPromotionProductRelations);
    }

}
