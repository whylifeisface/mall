package com.example.mall.service.imp;

import com.example.mall.mbg.mapper.OmsOrderMapper;
import com.example.mall.mbg.model.Oms.OmsOrder;
import com.example.mall.service.OmsOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OmsOrderServiceImp {

    List<OmsOrder> List();

    OmsOrder selectByPri(Long id);

    PageInfo<OmsOrder> Page(int num, int size);

    PageInfo<OmsOrder> searchPage(int num,int size, OmsOrder omsOrder);

    int del(Long id);

    OmsOrder Join(Long id);

    OmsOrder Se(Long id);

    List<OmsOrder> get(OmsOrder omsOrder);
}
