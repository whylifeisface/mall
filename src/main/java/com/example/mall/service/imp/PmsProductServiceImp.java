package com.example.mall.service.imp;

import com.example.mall.mbg.model.PmsProduct;
import com.github.pagehelper.PageInfo;

public interface PmsProductServiceImp {
//    List<PmsProduct> getAll();
    int searchSize(int size,int num,PmsProduct pmsProduct);
    PageInfo<PmsProduct> search(int size, int num, PmsProduct pmsProduct);
    PageInfo<PmsProduct> page(int size, int num);
    PmsProduct getById(Long id);
    int del(Long id);
    long pageSize();

}
