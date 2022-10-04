package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.pms.PmsProductCategory;
import com.example.mall.service.PmsProductCategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("PmsProductCategoryController")
public class PmsProductCategoryController {
    @Autowired
    private PmsProductCategoryService pmsService;


    @GetMapping("linInId")
    public CommonResult linInId(){
        List<PmsProductCategory> pmsProductCategories = pmsService.linInId(0L);
        if (pmsProductCategories == null) {
            return CommonResult.error(400,"getProductCategory--ParentId--error",null);

        }
        return CommonResult.success(200,"getProductCategory--ParentId--success",pmsProductCategories);

    }
    @GetMapping("parentId")
    public CommonResult ParentId(@RequestParam Long id,
                                 @RequestParam("num") int num,
                                 @RequestParam("size") int size){
        PageInfo pageInfo = pmsService.parentId(id, num, size);
        if (pageInfo == null) {

            return CommonResult.error(400,"getProductCategory--ParentId--error",null);

        }
        return CommonResult.success(200,"getProductCategory--ParentId--success",pageInfo);

    }


    @GetMapping("byId/{id}")
    public CommonResult SelectById(@PathVariable Long id){

        PmsProductCategory pmsProductCategory = pmsService.SelectById(id);
        if (pmsProductCategory == null) {
            return CommonResult.error(400,"getProductCategory--error",null);

        }
        return CommonResult.success(200,"getProductCategory--success",pmsProductCategory);

    }



    @GetMapping("total")
    public CommonResult total(){
//        if ( ' ' == size){
//            size = 10;
//        }
        Long total = pmsService.getTotal();
        if (' ' != total) {
            return CommonResult.success(200,"getProductCategory--success",total);

        }
        return CommonResult.error(400,"getProductCategory--error",null);
    }

    @GetMapping("page")
    public CommonResult page(@RequestParam("num") int num,@RequestParam("size") int size){

        PageInfo<PmsProductCategory> pmsProductCategories = pmsService.getPage(num, size);
        if (null != pmsProductCategories) {
        return CommonResult.success(200,"getProductCategory--success",pmsProductCategories);

    }
        return CommonResult.error(400,"getProductCategory--error",null);
    }
    
    @GetMapping("list")
    public CommonResult getProductCategory(){
        List<PmsProductCategory> pmsProductCategory =  pmsService.getProductCategory();
        if (null != pmsProductCategory) {
            return CommonResult.success(200,"getProductCategory--success",pmsProductCategory);

        }
        return CommonResult.error(400,"getProductCategory--error",null);

    }
    @GetMapping("edit")
    public CommonResult editProductCategory(
            @RequestBody PmsProductCategory pmsProductCategory
    ){
        PmsProductCategory pmsProductCategory1 = pmsService.selectOne(pmsProductCategory.getId());

        if (pmsProductCategory1 == null) {
            return CommonResult.error(400,"can not find--error",null);
        }
       int i = pmsService.editProductCategory(pmsProductCategory);
        if (i == 0) {
            return CommonResult.error(400,"update --error",null);
        }
        return CommonResult.success(200,"editProductCategory--success",null);
    }
    @PostMapping("delete")
    public CommonResult deleteProductCategory(@RequestParam("id") Long id ){
       int i = pmsService.deleteProductCategory(id);
        if (i == 0) {
            return CommonResult.error(400,"delete --error",null);

        }
        return CommonResult.success(200,"deleteProductCategory--success",null);
    }
    @GetMapping("insert")
    public CommonResult insertProductCategory(@RequestBody PmsProductCategory pmsProductCategory)
    {
       int i = pmsService.insertProductCategory(pmsProductCategory);
        if (i == 0) {
            return CommonResult.error(400,"insert --error",null);
        }
        return CommonResult.success(200,"insertProductCategory--success",null);

    }


}
