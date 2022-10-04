package com.example.mall.service.imp;

import com.example.mall.mbg.model.SmsHomeRecommendProduct;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SmsHomeRecommendProductServiceImp {
    PageInfo<SmsHomeRecommendProduct> init(int num,int size);

    List<SmsHomeRecommendProduct> get(SmsHomeRecommendProduct smsHomeRecommendProduct);

    int update(SmsHomeRecommendProduct smsHomeRecommendProduct);

    int del(Long id);

    List<SmsHomeRecommendProduct> sql();
}
