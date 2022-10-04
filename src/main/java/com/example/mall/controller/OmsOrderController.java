package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.Oms.OmsOrder;
import com.example.mall.service.OmsOrderService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("OmsOrderController")
@RequestMapping("/OmsOrderController")
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;
    @GetMapping("se/{id}")
    public CommonResult Se(@PathVariable Long id){
        OmsOrder se =  omsOrderService.Se(id);
        if (se == null) {
            return CommonResult.error(400,"OmsOrderController--page--error",null);
        }
        return CommonResult.success(200,"OmsOrderController--page--success",se);
    }

    @ApiOperation("")
    @GetMapping("Join/{id}")
    public CommonResult Join(@PathVariable Long id){
        if (id == null) return CommonResult.error(400,"OmsOrderController--page--error",null);;
        OmsOrder join = omsOrderService.Join(id);
        if (join == null) {
            return CommonResult.error(400,"OmsOrderController--page--error",null);

        }
        return CommonResult.success(200,"OmsOrderController--page--success",join);

    }

    @ApiOperation("")
    @GetMapping("page")
    public CommonResult page(@RequestParam("size")int size,@RequestParam("num")int num){
        PageInfo<OmsOrder> page = omsOrderService.Page(num, size);
        if (page == null) {
            return CommonResult.error(400,"OmsOrderController--page--error",null);
        }
        return CommonResult.success(200,"OmsOrderController--page--success",page);
    }

    @PostMapping("searchPage")
    public CommonResult searchPage(@RequestParam("size")int size,@RequestParam("num")int num,
                                   @RequestBody OmsOrder omsOrder){
        PageInfo<OmsOrder> omsOrderPageInfo = omsOrderService.searchPage(num, size, omsOrder);
        if (omsOrderPageInfo == null) {
             return CommonResult.error(400,"OmsOrderController--searchPage--error",null);

        }
        return CommonResult.error(200,"OmsOrderController--searchPage--success",omsOrderPageInfo);
    }

    @ApiOperation("")
    @GetMapping("del/{id}")
    public CommonResult delByid(@PathVariable Long id){
        int del = omsOrderService.del(id);
        if (del == 0) {
            return CommonResult.error(400,"OmsOrderController--delByid--error",null);

        }
        return CommonResult.error(200,"OmsOrderController--delByid--success",del);
    }
    @PostMapping("/get")
    public CommonResult get(@RequestBody OmsOrder omsOrder){
        if (omsOrder == null) return CommonResult.error(400,"OmsOrderController--get--error",null);
        System.out.println(omsOrder.getPayType());
        List<OmsOrder> i = omsOrderService.get(omsOrder);
        if (i == null) {
            return CommonResult.error(400,"OmsOrderController--get--error",null);
        }
        return CommonResult.success(200,"OmsOrderController--get--success",i);
    }

}
