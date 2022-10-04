package com.example.mall.service;

import com.example.mall.mbg.mapper.SmsFlashPromotionProductRelationMapper;
import com.example.mall.mbg.model.SmsFlashPromotionProductRelation;
import com.example.mall.service.imp.SmsFlashPromotionProductRelationServiceImp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmsFlashPromotionProductRelationService implements SmsFlashPromotionProductRelationServiceImp {
    @Resource
    private SmsFlashPromotionProductRelationMapper smsFlashPromotionProductRelationMapper;

    @Override
    public List<SmsFlashPromotionProductRelation> init() {

        return smsFlashPromotionProductRelationMapper.init();
    }

    @Override
    public List<SmsFlashPromotionProductRelation> joinPmsProduct(Long id) {
      return smsFlashPromotionProductRelationMapper.joinPmsProduct(id);
    }

    @Override
    public List<SmsFlashPromotionProductRelation> twice() {
       return smsFlashPromotionProductRelationMapper.twice();

    }
}
