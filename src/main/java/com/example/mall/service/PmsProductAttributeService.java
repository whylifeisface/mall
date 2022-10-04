package com.example.mall.service;

import com.example.mall.mbg.mapper.PmsProductAttributeMapper;
import com.example.mall.mbg.model.pms.PmsProductAttribute;
import com.example.mall.mbg.model.pms.PmsProductAttributeExample;
import com.example.mall.service.imp.PmsProductAttributeServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductAttributeService implements PmsProductAttributeServiceImp {
    @Autowired
    private PmsProductAttributeMapper pmsProductAttributeMapper;


    @Override
    public List<PmsProductAttribute> sql(String name) {

        return pmsProductAttributeMapper.sql(name);
    }

    @Override
    public Long pageCount() {
        return pmsProductAttributeMapper.countByExample(new PmsProductAttributeExample());
    }

    @Override
    public List<PmsProductAttribute> PageChange(int size, int num) {

        PageHelper.startPage(num,size);
        List<PmsProductAttribute> pmsProductAttributes
                = pmsProductAttributeMapper.selectByExample(new PmsProductAttributeExample());
        PageInfo<PmsProductAttribute> pageInfo = new PageInfo<>(pmsProductAttributes);
        return pageInfo.getList();

    }


    @Override
    public List<PmsProductAttribute> list() {

        return pmsProductAttributeMapper.selectByExample(new PmsProductAttributeExample());
    }

    @Override
    public int insert(PmsProductAttribute pmsProductAttribute) {

     return    pmsProductAttributeMapper.insert(pmsProductAttribute);
    }

    @Override
    public PmsProductAttribute find(Long id) {

       return pmsProductAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(PmsProductAttribute pmsProductAttribute) {

        return pmsProductAttributeMapper.updateByExample(pmsProductAttribute,
                new PmsProductAttributeExample());
    }

    @Override
    public int delete(Long id) {

       return pmsProductAttributeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsProductAttribute> ssm(Long product_attribute_category_id) {
       return pmsProductAttributeMapper.ssm(product_attribute_category_id);

    }

    @Override
    public List<PmsProductAttribute> GetAttri(Long id) {
       return pmsProductAttributeMapper.GetAttri(id);

    }


}
