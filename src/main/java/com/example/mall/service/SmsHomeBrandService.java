package com.example.mall.service;

import com.example.mall.mbg.mapper.SmsHomeBrandMapper;
import com.example.mall.mbg.model.SmsHomeBrand;
import com.example.mall.mbg.model.SmsHomeBrandExample;
import com.example.mall.service.imp.SmsHomeBrandServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmsHomeBrandService implements SmsHomeBrandServiceImp {
    @Resource
    private SmsHomeBrandMapper smsHomeBrandMapper;

    @Override
    public PageInfo<SmsHomeBrand> init(int num,int size) {
        PageHelper.startPage(num, size);
        List<SmsHomeBrand> smsHomeBrands =
                smsHomeBrandMapper.selectByExample(new SmsHomeBrandExample());
        return new PageInfo<>(smsHomeBrands);
    }

    @Override
    public List<SmsHomeBrand> form(SmsHomeBrand smsHomeBrand) {
       return smsHomeBrandMapper.form(smsHomeBrand);

    }

    @Override
    public int update(SmsHomeBrand smsHomeBrand) {

      return smsHomeBrandMapper.updateByExample(smsHomeBrand,new SmsHomeBrandExample());
    }

    @Override
    public int del(Long id) {

        return smsHomeBrandMapper.deleteByPrimaryKey(id);
    }

}
