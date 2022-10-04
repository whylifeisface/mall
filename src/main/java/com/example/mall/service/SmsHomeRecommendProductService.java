package com.example.mall.service;

import com.example.mall.mbg.mapper.SmsHomeRecommendProductMapper;
import com.example.mall.mbg.model.SmsHomeRecommendProduct;
import com.example.mall.mbg.model.SmsHomeRecommendProductExample;
import com.example.mall.service.imp.SmsHomeRecommendProductServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmsHomeRecommendProductService implements SmsHomeRecommendProductServiceImp {
    @Resource
    private SmsHomeRecommendProductMapper smsHomeRecommendProductMapper;

    @Override
    public PageInfo<SmsHomeRecommendProduct> init(int num,int size) {
        PageHelper.startPage(num, size);
        List<SmsHomeRecommendProduct> smsHomeRecommendProducts =
                smsHomeRecommendProductMapper.selectByExample(new SmsHomeRecommendProductExample());
        return new PageInfo<>(smsHomeRecommendProducts);

    }

    @Override
    public List<SmsHomeRecommendProduct> get(SmsHomeRecommendProduct smsHomeRecommendProduct) {

       return smsHomeRecommendProductMapper.get(smsHomeRecommendProduct);
    }

    @Override
    public int update(SmsHomeRecommendProduct smsHomeRecommendProduct) {

        return smsHomeRecommendProductMapper.updateByExample(smsHomeRecommendProduct,new SmsHomeRecommendProductExample());
    }

    @Override
    public int del(Long id) {

        return smsHomeRecommendProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SmsHomeRecommendProduct> sql() {
       return smsHomeRecommendProductMapper.sql();

    }
}
