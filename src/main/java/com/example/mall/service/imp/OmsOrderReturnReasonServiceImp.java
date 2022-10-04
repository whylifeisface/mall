package com.example.mall.service.imp;

import com.example.mall.mbg.model.OmsOrderReturnReason;
import com.github.pagehelper.PageInfo;

public interface OmsOrderReturnReasonServiceImp {


    PageInfo<OmsOrderReturnReason> page(int num, int size);

    int Insert(OmsOrderReturnReason omsOrderReturnReason);

    int update( OmsOrderReturnReason omsOrderReturnReason);

    int del(Long id);
}
