package com.example.mall.service.imp;

import com.example.mall.mbg.model.SmsHomeAdvertise;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface smsHomeAdvertiseServiceImp {
    PageInfo<SmsHomeAdvertise> init(int num, int size);

    List<SmsHomeAdvertise> get(SmsHomeAdvertise smsHomeAdvertise);

    int update(SmsHomeAdvertise smsHomeAdvertise);

    int del(Long id);
}
