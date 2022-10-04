package com.example.mall.service;

import com.example.mall.mbg.mapper.SmsFlashPromotionSessionMapper;
import com.example.mall.mbg.model.SmsFlashPromotionSession;
import com.example.mall.mbg.model.SmsFlashPromotionSessionExample;
import com.example.mall.service.imp.SmsFlashPromotionSessionServiceImp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmsFlashPromotionSessionService implements SmsFlashPromotionSessionServiceImp {

    @Resource
    private SmsFlashPromotionSessionMapper smsFlashPromotionSessionMapper;
    @Override
    public List<SmsFlashPromotionSession> init() {
        return smsFlashPromotionSessionMapper.selectByExample(new SmsFlashPromotionSessionExample());
    }

    @Override
    public int del(Long id) {

      return smsFlashPromotionSessionMapper.deleteByPrimaryKey(id);
    }
}
