package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.OmsOrderReturnReason;
import com.example.mall.service.OmsOrderReturnReasonService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("OmsOrderReturnReasonController")
public class OmsOrderReturnReasonController {
    @Autowired
    private OmsOrderReturnReasonService omsOrderReturnReasonService;
    @GetMapping("page")
    @ApiOperation("Page")
    public CommonResult Page(@RequestParam("num")int num,@RequestParam("size")int size ){
      PageInfo<OmsOrderReturnReason> omsOrderReturnReasonList = omsOrderReturnReasonService.page(num,size);
        if (omsOrderReturnReasonList == null) {
        return CommonResult.error(400,"error",null);
            }
        return CommonResult.success(200,"success",omsOrderReturnReasonList);
    }
    @PostMapping("insert")
    public CommonResult Insert(@RequestBody OmsOrderReturnReason omsOrderReturnReason){
        int insert = omsOrderReturnReasonService.Insert(omsOrderReturnReason);
        if (insert == 0)
            return CommonResult.error(400,"error",null);
        return CommonResult.success(200,"success",null);
    }

    @GetMapping("del/{id}")
    public CommonResult del(@PathVariable Long id){
      int i=  omsOrderReturnReasonService.del(id);
        if (i==0)
            return CommonResult.error(400,"error",null);
        return CommonResult.success(200,"success",null);
    }
    @GetMapping("update")
    public CommonResult update(@RequestBody OmsOrderReturnReason omsOrderReturnReason){
       int i = omsOrderReturnReasonService.update(omsOrderReturnReason);
               if (i == 0)
                   return CommonResult.error(400,"error",null);
        return CommonResult.success(200,"success",null);

    }

}
