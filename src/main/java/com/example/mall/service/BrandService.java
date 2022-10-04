package com.example.mall.service;

import com.example.mall.mbg.mapper.PmsBrandMapper;
import com.example.mall.mbg.model.pms.PmsBrand;
import com.example.mall.mbg.model.pms.PmsBrandExample;
import com.example.mall.service.imp.BrandServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BrandService implements BrandServiceImp {
    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    public  List<PmsBrand> selectByName(String name){
      return   pmsBrandMapper.selectByName(name);
    }

    private PageInfo<PmsBrand> sda(int size, int num){
        PageHelper.startPage(size,num);
        List<PmsBrand> pmsBrands = pmsBrandMapper.selectByExample(new PmsBrandExample());
        return new PageInfo<>(pmsBrands);
    }


    @Override
    public int getPage() {
//        PageHelper.startPage(size,num);
        List<PmsBrand> pmsBrands = pmsBrandMapper.selectByExample(new PmsBrandExample());
       return new PageInfo<>(pmsBrands).getPageSize();
//        PageInfo<PmsBrand> sda = sda(size, num);
//        return sda.getPages();
    }

    @Override
    public List<PmsBrand> pageAll(int size, int num) {
        PageHelper.startPage(size,num);
        List<PmsBrand> pmsBrands = pmsBrandMapper.selectByExample(new PmsBrandExample());
        PageInfo<PmsBrand> pmsBrandPageInfo = new PageInfo<>(pmsBrands);
        return pmsBrandPageInfo.getList();

    }

    @Override
    public List<PmsBrand> getBrandList() {

        return pmsBrandMapper.selectByExample(new PmsBrandExample());

    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
      return   pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return pmsBrandMapper.updateByPrimaryKey(pmsBrand);
    }

    @Override
    public int deleteBrand(Long id) {

      return   pmsBrandMapper.deleteByPrimaryKey(id);
    }



    @Override
    public PmsBrand brand(Long id) {

      return pmsBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<PmsBrand> visibility(int num, int size) {

        PageHelper.startPage(num, size);
       List<PmsBrand>pmsBrands= pmsBrandMapper.visibility();
        return new PageInfo<>(pmsBrands);
    }

    @Override
    public List<PmsBrand> search(PmsBrand pmsBrand) {

        return pmsBrandMapper.search(pmsBrand);
    }

}
