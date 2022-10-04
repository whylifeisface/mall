package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.PmsSkuStock;
import com.example.mall.service.PmsProductService;
import com.example.mall.service.PmsSkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("pmsSkuStockController")
@RestController
public class pmsSkuStockController {

    @Autowired
    private PmsSkuStockService pmsSkuStockService;

    @GetMapping("se")
    public CommonResult se(@RequestParam("id") Long id){
        if (id == null) {
            return null;
        }
        List<PmsSkuStock> pmsSkuStocks = pmsSkuStockService.SelectById(id);
        if (pmsSkuStocks == null) {
            return CommonResult.error(400,"getProductCategory--error",null);

        }
        return CommonResult.success(200,"getProductCategory--success",pmsSkuStocks);

    }
}
