package com.example.mall.service.imp;

import com.example.mall.mbg.model.SmsCoupon;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SmsCouponServiceImp {

    PageInfo<SmsCoupon> init(int num, int size);

    SmsCoupon sel(Long id);

    List<SmsCoupon> get(SmsCoupon smsCoupon);
}
