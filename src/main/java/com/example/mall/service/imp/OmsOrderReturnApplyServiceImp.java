package com.example.mall.service.imp;

import com.example.mall.mbg.model.Oms.OmsOrderReturnApply;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OmsOrderReturnApplyServiceImp {


    PageInfo<OmsOrderReturnApply> page(int num, int size);

    List<OmsOrderReturnApply> pageSearch( OmsOrderReturnApply omsOrderReturnApply);

    OmsOrderReturnApply Join(Long id);
}
