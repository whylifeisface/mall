package com.example.mall.service.imp;

import com.example.mall.mbg.model.SmsFlashPromotionSession;

import java.util.List;

public interface SmsFlashPromotionSessionServiceImp {
    List<SmsFlashPromotionSession> init();

    int del(Long id);
}
