package com.example.mall.service;

import com.example.mall.mbg.mapper.SmsHomeRecommendSubjectMapper;
import com.example.mall.mbg.model.SmsHomeRecommendSubject;
import com.example.mall.mbg.model.SmsHomeRecommendSubjectExample;
import com.example.mall.service.imp.SmsHomeRecommendSubjectServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmsHomeRecommendSubjectService implements SmsHomeRecommendSubjectServiceImp {
    @Resource
    private SmsHomeRecommendSubjectMapper smsHomeRecommendSubjectMapper;

    @Override
    public PageInfo<SmsHomeRecommendSubject> init(int num, int size) {
        PageHelper.startPage(num, size);
        List<SmsHomeRecommendSubject> smsHomeRecommendSubjects =
                smsHomeRecommendSubjectMapper.selectByExample(new SmsHomeRecommendSubjectExample());
        return new PageInfo<>(smsHomeRecommendSubjects);
    }

    @Override
    public List<SmsHomeRecommendSubject> get(SmsHomeRecommendSubject smsHomeRecommendSubject) {
        return smsHomeRecommendSubjectMapper.get(smsHomeRecommendSubject);

    }
}
