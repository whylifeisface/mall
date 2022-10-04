package com.example.mall.service;

import com.example.mall.mbg.mapper.UmsResourceCategoryMapper;
import com.example.mall.mbg.mapper.UmsResourceMapper;
import com.example.mall.mbg.model.UmsResourceCategory;
import com.example.mall.mbg.model.UmsResourceCategoryExample;
import com.example.mall.service.imp.UmsResourceCategoryServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UmsResourceCategoryService implements UmsResourceCategoryServiceImp {
    @Resource
    private UmsResourceCategoryMapper umsResourceCategoryMapper;


    @Override
    public PageInfo<UmsResourceCategory> init(int num, int size) {
        PageHelper.startPage(num, size);
        List<UmsResourceCategory> umsResourceCategories =
                umsResourceCategoryMapper.selectByExample(new UmsResourceCategoryExample());

        return new PageInfo<>(umsResourceCategories);
    }

    @Override
    public int insert(UmsResourceCategory umsResourceCategory) {

        return umsResourceCategoryMapper.insert(umsResourceCategory);
    }
}
