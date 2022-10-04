package com.example.mall.service.imp;

import com.example.mall.mbg.model.pms.PmsProductAttribute;

import java.util.List;

public interface PmsProductAttributeServiceImp {

    List<PmsProductAttribute> sql(String name);

    Long pageCount();

    List<PmsProductAttribute> PageChange(int size,int num);

    List<PmsProductAttribute> list();

    int insert(PmsProductAttribute pmsProductAttribute);

    PmsProductAttribute find(Long id);

    int update(PmsProductAttribute pmsProductAttribute);

    int delete(Long id);

    List<PmsProductAttribute> ssm(Long product_attribute_category_id);

    List<PmsProductAttribute> GetAttri(Long id);
}
