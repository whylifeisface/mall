package com.example.mall.service;

import com.example.mall.mbg.mapper.OmsOrderMapper;
import com.example.mall.mbg.model.Oms.OmsOrder;
import com.example.mall.mbg.model.OmsOrderExample;
import com.example.mall.service.imp.OmsOrderServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OmsOrderService implements OmsOrderServiceImp {
    @Autowired
    private OmsOrderMapper omsOrderMapper;
    @Override
    public List<OmsOrder> List() {
        return omsOrderMapper.selectByExample(new com.example.mall.mbg.model.OmsOrderExample());
    }

    @Override
    public OmsOrder selectByPri(Long id) {
        return omsOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<OmsOrder> Page(int num, int size) {
        PageHelper.startPage(num,size);
        return new PageInfo<OmsOrder>(omsOrderMapper.selectByExample(new OmsOrderExample()));
    }

    @Override
    public PageInfo<OmsOrder> searchPage(int num,int size,OmsOrder omsOrder) {
        PageHelper.startPage(num,size);
        return new PageInfo<OmsOrder>(omsOrderMapper.searchPage(omsOrder));
    }

    @Override
    public int del(Long id) {
        return omsOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public OmsOrder Join(Long id) {
        return omsOrderMapper.Join(id);
    }

    @Override
    public OmsOrder Se(Long id) {

       return omsOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OmsOrder> get(OmsOrder omsOrder) {

        return omsOrderMapper.get(omsOrder);
    }

}
