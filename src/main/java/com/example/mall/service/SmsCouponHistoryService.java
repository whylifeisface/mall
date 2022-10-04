package com.example.mall.service;

import com.example.mall.mbg.mapper.SmsCouponHistoryMapper;
import com.example.mall.mbg.model.SmsCouponHistory;
import com.example.mall.service.imp.SmsCouponHistoryServiceImp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmsCouponHistoryService implements SmsCouponHistoryServiceImp {
    @Resource
    private SmsCouponHistoryMapper smsCouponHistoryMapper;

    @Override
    public List<SmsCouponHistory> init(SmsCouponHistory smsCouponHistory) {
      return   smsCouponHistoryMapper.sele(smsCouponHistory);
    }
}
