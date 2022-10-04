package com.example.mall.service;

import com.example.mall.mbg.mapper.SmsHomeAdvertiseMapper;
import com.example.mall.mbg.model.SmsHomeAdvertise;
import com.example.mall.mbg.model.SmsHomeAdvertiseExample;
import com.example.mall.service.imp.smsHomeAdvertiseServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class smsHomeAdvertiseService implements smsHomeAdvertiseServiceImp {
    @Resource
    private SmsHomeAdvertiseMapper advertiseMapper;
    @Override
    public PageInfo<SmsHomeAdvertise> init(int num, int size) {
        PageHelper.startPage(num, size);
        List<SmsHomeAdvertise> smsHomeAdvertises =
                advertiseMapper.selectByExample(new SmsHomeAdvertiseExample());
        return new PageInfo<>(smsHomeAdvertises);
    }

    @Override
    public List<SmsHomeAdvertise> get(SmsHomeAdvertise smsHomeAdvertise) {

        return advertiseMapper.get(smsHomeAdvertise);
    }

    @Override
    public int update(SmsHomeAdvertise smsHomeAdvertise) {

        return advertiseMapper.updateByExample(smsHomeAdvertise,new SmsHomeAdvertiseExample());
    }

    @Override
    public int del(Long id) {

        return advertiseMapper.deleteByPrimaryKey(id);
    }
}
