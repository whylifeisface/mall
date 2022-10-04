package com.example.mall.service.imp;

import com.example.mall.mbg.model.pms.PmsBrand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandServiceImp {

    int getPage();

    List<PmsBrand> pageAll(int size,int num);

    List<PmsBrand> getBrandList();

    int createBrand(PmsBrand pmsBrand);

    int updateBrand(Long id, PmsBrand pmsBrand);

    int deleteBrand(Long id);



    PmsBrand brand(Long id);

    PageInfo<PmsBrand> visibility(int num, int size);

    List<PmsBrand> search(PmsBrand pmsBrand);
}
