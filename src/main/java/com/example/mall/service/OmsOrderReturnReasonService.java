package com.example.mall.service;

import com.example.mall.mbg.mapper.OmsOrderReturnReasonMapper;
import com.example.mall.mbg.model.OmsOrderReturnReason;
import com.example.mall.mbg.model.OmsOrderReturnReasonExample;
import com.example.mall.service.imp.OmsOrderReturnReasonServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsOrderReturnReasonService implements OmsOrderReturnReasonServiceImp {
    @Autowired
    private OmsOrderReturnReasonMapper omsOrderReturnReasonMapper;

    @Override
    public PageInfo<OmsOrderReturnReason> page(int num, int size) {
        PageHelper.startPage(num,size);
        List<OmsOrderReturnReason> omsOrderReturnReasons =
                omsOrderReturnReasonMapper.selectByExample(new OmsOrderReturnReasonExample());
     return new PageInfo<OmsOrderReturnReason>(omsOrderReturnReasons) ;

    }

    @Override
    public int Insert(OmsOrderReturnReason omsOrderReturnReason) {
        return omsOrderReturnReasonMapper.insert(omsOrderReturnReason);
    }

    @Override
    public int update( OmsOrderReturnReason omsOrderReturnReason) {

        return omsOrderReturnReasonMapper.updateByPrimaryKey(omsOrderReturnReason);
    }

    @Override
    public int del(Long id) {

        return omsOrderReturnReasonMapper.deleteByPrimaryKey(id);
    }
}
