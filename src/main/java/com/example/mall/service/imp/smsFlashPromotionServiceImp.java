package com.example.mall.service.imp;

import com.example.mall.mbg.model.SmsFlashPromotion;
import com.github.pagehelper.PageInfo;

public interface smsFlashPromotionServiceImp {

    PageInfo<SmsFlashPromotion> init(int num, int size);
}
