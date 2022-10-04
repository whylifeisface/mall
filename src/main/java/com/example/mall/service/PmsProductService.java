package com.example.mall.service;

import com.example.mall.mbg.mapper.PmsProductMapper;
import com.example.mall.mbg.model.PmsProduct;
import com.example.mall.mbg.model.PmsProductExample;
import com.example.mall.service.imp.PmsProductServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductService implements PmsProductServiceImp {
    @Autowired
    private PmsProductMapper pmsProductMapper;




//    @Override
//    public List<PmsProduct> getAll() {
//
//        return pmsProductMapper.getAll(new PmsProductExample());
//    }

    @Override
    public int searchSize(int size, int num, PmsProduct pmsProduct) {
        PageHelper.startPage(num,size);
        List<PmsProduct> pmsProducts = pmsProductMapper.selectByBody(pmsProduct);
        PageInfo<PmsProduct> pmsProductPageInfo = new PageInfo<>(pmsProducts);
        return pmsProductPageInfo.getPages();
    }

    @Override
    public PageInfo<PmsProduct> search(int size, int num, PmsProduct pmsProduct) {
        PageHelper.startPage(num,size);
        List<PmsProduct> pmsProducts = pmsProductMapper.selectByBody(pmsProduct);
        return new PageInfo<>(pmsProducts);
    }

    @Override
    public PageInfo<PmsProduct> page(int size, int num) {
        PageHelper.startPage(num,size);
        List<PmsProduct> pmsProducts = pmsProductMapper.selectByExample(new PmsProductExample());
        PageInfo<PmsProduct> pmsProductPageInfo = new PageInfo<>(pmsProducts);
        return  pmsProductPageInfo;
    }


    @Override
    public PmsProduct getById(Long id) {

     return  pmsProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int del(Long id) {

        return pmsProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public long pageSize() {
        return pmsProductMapper.countByExample(new PmsProductExample());

    }
}
