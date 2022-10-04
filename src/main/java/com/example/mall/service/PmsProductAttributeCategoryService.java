package com.example.mall.service;

import com.example.mall.MallApplication;
import com.example.mall.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.example.mall.mbg.model.pms.PmsProductAttributeCategory;
import com.example.mall.mbg.model.pms.PmsProductAttributeCategoryExample;
import com.example.mall.mbg.model.pms.PmsProductCategory;
import com.example.mall.service.imp.PmsProductAttributeCategoryServiceImp;
import com.example.mall.service.imp.PmsProductCategoryServiceImp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductAttributeCategoryService implements PmsProductAttributeCategoryServiceImp {

    @Autowired
    private PmsProductAttributeCategoryMapper mapper;



    @Override
    public List<PmsProductAttributeCategory> list() {
     return  mapper.selectByExample(new PmsProductAttributeCategoryExample());

    }

    @Override
    public List<PmsProductAttributeCategory> selectById(Long id) {
        return mapper.selectByPrimaryKey(id);

    }

    @Override
    public List<PmsProductAttributeCategory> sql() {
        return mapper.sqlSQL(new PmsProductAttributeCategoryExample());
    }


    @Override
    public int insert(PmsProductAttributeCategory pmsService) {

        return mapper.insert(pmsService);
    }




    @Override
    public int del(Long del) {

        return mapper.deleteByPrimaryKey(del);
    }

    @Override
    public int update(PmsProductAttributeCategory pmsProductAttributeCategory) {
        return mapper.updateByExample(pmsProductAttributeCategory, new PmsProductAttributeCategoryExample());

    }


}
