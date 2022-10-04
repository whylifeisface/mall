package com.example.mall.service;

import com.example.mall.mbg.mapper.SmsFlashPromotionMapper;
import com.example.mall.mbg.model.SmsFlashPromotion;
import com.example.mall.mbg.model.SmsFlashPromotionExample;
import com.example.mall.service.imp.smsFlashPromotionServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class smsFlashPromotionService implements smsFlashPromotionServiceImp {
    @Resource
    private SmsFlashPromotionMapper smsFlashPromotionMapper;
    @Override
    public PageInfo<SmsFlashPromotion> init(int num, int size) {
        PageHelper.startPage(num,size);
        List<SmsFlashPromotion> smsFlashPromotions =
                smsFlashPromotionMapper.selectByExample(new SmsFlashPromotionExample());
        PageInfo<SmsFlashPromotion> smsFlashPromotionPageInfo
                = new PageInfo<>(smsFlashPromotions);
        return smsFlashPromotionPageInfo;

    }
}
