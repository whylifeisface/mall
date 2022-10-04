package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.pms.PmsProductAttribute;
import com.example.mall.service.PmsProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("PmsProductAttributeController")
public class PmsProductAttributeController {
    @Autowired
    private PmsProductAttributeService pmsService;

    @GetMapping("sql")
    public CommonResult sql(@RequestParam("name") String name){
        List<PmsProductAttribute> sql = pmsService.sql(name);
        if (sql == null) {
            return CommonResult.error(400,"PmsProductAttributeController--error--PageCount",null);
        }
        return CommonResult.success(200,"PmsProductAttributeController--success--PageCount",sql);

    }

    @GetMapping("pageChange")
    public CommonResult pageChange(@RequestParam("size")int size, @RequestParam("num")int num){
        List<PmsProductAttribute> pmsProductAttributes = pmsService.PageChange(size, num);
        if (pmsProductAttributes == null) {
            return CommonResult.error(400,"PmsProductAttributeController--error--PageCount",null);

        }
        return CommonResult.success(200,"PmsProductAttributeController--success--PageCount",pmsProductAttributes);

    }
    @GetMapping("count")
    public CommonResult PageCount(){

        Long pageCount = pmsService.pageCount();

        if (pageCount == null) {
            return CommonResult.error(400,"PmsProductAttributeController--error--PageCount",null);

        }
        return CommonResult.success(200,"PmsProductAttributeController--success--PageCount",pageCount);

    }



    @GetMapping("list")
    public CommonResult list(){
      List<PmsProductAttribute>pmsProductAttributes =  pmsService.list();
        if (pmsProductAttributes == null) {
            return CommonResult.error(400,"PmsProductAttributeController--error--list",null);

        }
        return CommonResult.success(200,"PmsProductAttributeController--success--list",pmsProductAttributes);

    }
    @GetMapping("insert")
    public CommonResult insert(@RequestBody PmsProductAttribute pmsProductAttribute){
      int i =  pmsService.insert(pmsProductAttribute);
        if (i == 0) {
            return CommonResult.error(400,"PmsProductAttributeController--error--inset",null);

        }
        return CommonResult.success(200,"PmsProductAttributeController--success--inset",null);

    }
    @GetMapping("update")
    public CommonResult update(@RequestBody PmsProductAttribute pmsProductAttribute){
        Long id = pmsProductAttribute.getId();
        if (id == null) {
            return CommonResult.error(400,"PmsProductAttributeController--error--update",null);

        }
        PmsProductAttribute PmsProductAttribute = pmsService.find(id);
        if (PmsProductAttribute == null) {
            return CommonResult.error(400,"PmsProductAttributeController--error--update",null);

        }
        int i = pmsService.update(pmsProductAttribute);
        if (i == 0) {
            return CommonResult.error(400,"PmsProductAttributeController--error--update",null);

        }
        return CommonResult.success(200,"PmsProductAttributeController--success--inset",null);

    }
    @GetMapping("delete")
    public CommonResult delete(@RequestParam("id") Long id){
        PmsProductAttribute pmsProductAttribute = pmsService.find(id);
        if (pmsProductAttribute == null) {
            return CommonResult.error(400,"PmsProductAttributeController--error--delete",null);

        }
      int i =  pmsService.delete(id);
        if (i == 0) {
            return CommonResult.error(400,"PmsProductAttributeController--error--delete",null);

        }
        return CommonResult.success(200,"PmsProductAttributeController--success--inset",null);
    }
    @GetMapping("ssm")
    public CommonResult ssm(@RequestParam("product_attribute_category_id") Long product_attribute_category_id){
       List<PmsProductAttribute> pmsProductAttributes = pmsService.ssm(product_attribute_category_id);
        if (pmsProductAttributes == null) {
            return CommonResult.error(400,"PmsProductAttributeController--error--delete",null);
        }
        return CommonResult.success(200,"PmsProductAttributeController--success--inset",pmsProductAttributes);
    }

    @GetMapping("attri/{id}")
    public CommonResult GetAttri(@PathVariable Long id) {
        List<PmsProductAttribute> pmsProductAttributes = pmsService.GetAttri(id);
        if (pmsProductAttributes == null) {
            return CommonResult.error(400, "PmsProductAttributeController--error--delete", null);
        }
        return CommonResult.success(200, "PmsProductAttributeController--success--inset", pmsProductAttributes);
    }
}
