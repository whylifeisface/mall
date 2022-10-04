package com.example.mall.service.imp;

import com.example.mall.mbg.model.SmsFlashPromotionProductRelation;

import java.util.List;

public interface SmsFlashPromotionProductRelationServiceImp {
    List<SmsFlashPromotionProductRelation> init();

    List<SmsFlashPromotionProductRelation> joinPmsProduct(Long id);

    List<SmsFlashPromotionProductRelation> twice();

}
