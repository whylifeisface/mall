package com.example.mall.service.imp;

import com.example.mall.mbg.model.SmsHomeNewProduct;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SmsHomeNewProductServiceImp {
    PageInfo<SmsHomeNewProduct> init(int num, int size);

    List<SmsHomeNewProduct> get(SmsHomeNewProduct smsHomeNewProduct);

    int del(Long id);

    int update(SmsHomeNewProduct smsHomeNewProduct);
}
