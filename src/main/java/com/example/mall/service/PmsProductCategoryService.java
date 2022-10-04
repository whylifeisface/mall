package com.example.mall.service;

import com.example.mall.mbg.mapper.PmsProductCategoryMapper;
import com.example.mall.mbg.model.pms.PmsProductCategory;
import com.example.mall.mbg.model.pms.PmsProductCategoryExample;
import com.example.mall.service.imp.PmsProductCategoryServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductCategoryService implements PmsProductCategoryServiceImp {
    @Autowired
    private PmsProductCategoryMapper pmsProductCategoryMapper;




    @Override
    public Long getTotal() {
        return pmsProductCategoryMapper.countByExample(new PmsProductCategoryExample());
    }

    @Override
    public List<PmsProductCategory> linInId(Long id) {
        return pmsProductCategoryMapper.linInId(id);
    }

    @Override
    public PageInfo parentId(Long id, int num, int size) {
    PageHelper.startPage(num,size);
        List<PmsProductCategory> pmsProductCategories = pmsProductCategoryMapper.selectParentId(id);
        return  new PageInfo(pmsProductCategories);
    }

    @Override
    public PmsProductCategory SelectById(Long id) {

      return   pmsProductCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<PmsProductCategory> getPage(int num, int size) {
        PageHelper.startPage(num,size);
        List<PmsProductCategory> pmsProductCategories = pmsProductCategoryMapper.selectByExample(new PmsProductCategoryExample());
        PageInfo<PmsProductCategory> pmsProductCategoryPageInfo = new PageInfo<>(pmsProductCategories);
        return pmsProductCategoryPageInfo;
    }

    public List<PmsProductCategory> getProductCategory() {
      return  pmsProductCategoryMapper.selectByExample(new PmsProductCategoryExample());

    }



    @Override
    public PmsProductCategory selectOne(Long id) {

       return pmsProductCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editProductCategory(PmsProductCategory pmsProductCategory) {
        return pmsProductCategoryMapper.updateByExample(pmsProductCategory,new PmsProductCategoryExample());
    }

    @Override
    public int deleteProductCategory(Long id) {
        return pmsProductCategoryMapper.deleteByPrimaryKey(id);

    }

    @Override
    public int insertProductCategory(PmsProductCategory pmsProductCategory) {

        return pmsProductCategoryMapper.insert(pmsProductCategory);

    }




}
