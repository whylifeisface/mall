package com.example.mall.service;

import com.example.mall.mbg.mapper.SmsHomeNewProductMapper;
import com.example.mall.mbg.model.SmsHomeNewProduct;
import com.example.mall.mbg.model.SmsHomeNewProductExample;
import com.example.mall.service.imp.SmsHomeNewProductServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmsHomeNewProductService implements SmsHomeNewProductServiceImp {
    @Resource
    private SmsHomeNewProductMapper smsHomeNewProductMapper;

    @Override
    public PageInfo<SmsHomeNewProduct> init(int num, int size) {
        PageHelper.startPage(num,size);
        List<SmsHomeNewProduct> smsHomeNewProducts =
                smsHomeNewProductMapper.selectByExample(new SmsHomeNewProductExample());
        return new PageInfo<>(smsHomeNewProducts);
    }

    @Override
    public List<SmsHomeNewProduct> get(SmsHomeNewProduct smsHomeNewProduct) {
       return smsHomeNewProductMapper.get(smsHomeNewProduct);

    }

    @Override
    public int del(Long id) {
        return smsHomeNewProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(SmsHomeNewProduct smsHomeNewProduct) {

        return smsHomeNewProductMapper.updateByExample(smsHomeNewProduct,new SmsHomeNewProductExample());
    }


}
