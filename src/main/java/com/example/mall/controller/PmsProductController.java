package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.mapper.PmsProductMapper;
import com.example.mall.mbg.model.PmsProduct;
import com.example.mall.service.PmsProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RequestMapping("PmsProductController")
@RestController
public class PmsProductController {
    @Autowired
    private PmsProductService pmsProductService;

        @GetMapping("searchPage")
        public CommonResult searchPage(
                @RequestBody PmsProduct pmsProduct
                ,@RequestParam("size") int size
                ,@RequestParam("num") int num){
            System.out.println(pmsProduct.getBrandName());
            int i = pmsProductService.searchSize(size, num, pmsProduct);
            if (i == 0) {
                return CommonResult.error(400,"getProductCategory--error",null);

            }
            return CommonResult.success(200,"getProductCategory--success",i);

        }

    @PostMapping("search")
    public CommonResult search(
            @RequestBody PmsProduct pmsProduct
            ,@RequestParam("size") int size
            ,@RequestParam("num") int num){
        PageInfo<PmsProduct> search = pmsProductService.search(size, num, pmsProduct);
        if (search == null) {
            return CommonResult.error(400,"getProductCategory--error",null);

        }
        return CommonResult.success(200,"getProductCategory--success",search);

    }

    @GetMapping("se")
    public CommonResult pageSize(){
        long page = pmsProductService.pageSize();
        if (page == 0) {
            return CommonResult.error(400,"getProductCategory--error",null);
        }
        return CommonResult.success(200,"getProductCategory--success",page);
    }
        @GetMapping("page")
        public CommonResult page(@RequestParam("size") int size,@RequestParam("num") int num){
            PageInfo<PmsProduct> page = pmsProductService.page(size, num);
            if (page == null) {
                return CommonResult.error(400,"getProductCategory--error",null);
            }
            return CommonResult.success(200,"getProductCategory--success",page);
        }

    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable Long id){

        PmsProduct byId = pmsProductService.getById(id);
        if (byId == null) {
            return CommonResult.error(400,"getProductCategory--error",null);

        }
        return CommonResult.success(200,"getProductCategory--success",byId);

    }
//    @GetMapping("getAll")
//    public CommonResult getAll(){
//
//        List<PmsProduct> all = pmsProductService.getAll();
//
//        if (null != all) {
//            return CommonResult.success(200,"getProductCategory--success",all);
//
//        }
//        return CommonResult.error(400,"getProductCategory--error",null);
//    }

    @GetMapping("del")
    public CommonResult del(@RequestParam("index") Long index){

        int del = pmsProductService.del(index);
        if (del == 1) {
            return CommonResult.success(200,"getProductCategory---del ----success",null);

        }
        return CommonResult.error(400,"getProductCategory--del--error",null);

    }
}
