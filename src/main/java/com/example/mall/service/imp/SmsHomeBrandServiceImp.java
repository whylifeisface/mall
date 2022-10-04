package com.example.mall.service.imp;

import com.example.mall.mbg.model.SmsHomeBrand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SmsHomeBrandServiceImp {
    PageInfo<SmsHomeBrand> init(int num, int size);

    List<SmsHomeBrand> form(SmsHomeBrand smsHomeBrand);

    int update(SmsHomeBrand smsHomeBrand);

    int del(Long id);
}
