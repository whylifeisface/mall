package com.example.mall.service.imp;

import com.example.mall.mbg.model.SmsHomeRecommendSubject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SmsHomeRecommendSubjectServiceImp {
    PageInfo<SmsHomeRecommendSubject> init(int num, int size);

    List<SmsHomeRecommendSubject> get(SmsHomeRecommendSubject smsHomeRecommendSubject);
}
