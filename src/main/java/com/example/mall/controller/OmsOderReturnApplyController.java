package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.Oms.OmsOrderReturnApply;
import com.example.mall.service.OmsOrderReturnApplyService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("OmsOderReturnApplyController")
@Api("OmsOderReturnApplyController")
public class OmsOderReturnApplyController {
    @Autowired
    private OmsOrderReturnApplyService omsOrderReturnApplyService;
    @GetMapping("JOIN/{id}")
    public CommonResult Join(@PathVariable Long id){
        OmsOrderReturnApply omsOrderReturnApplies = omsOrderReturnApplyService.Join(id);
        if (omsOrderReturnApplies == null) {
            return CommonResult.error(400,"error",null);
        }
        return CommonResult.success(200,"success",omsOrderReturnApplies);
    }

    @GetMapping("page")
    @ApiOperation("查询table 分页 传递 num size")
    public CommonResult page(@RequestParam("num") int num,@RequestParam("size") int size){
        PageInfo<OmsOrderReturnApply> page =
                omsOrderReturnApplyService.page(num, size);
        if (page == null) {
           return CommonResult.error(400,"error",null);
        }
       return CommonResult.success(200,"success",page);
    }

    @ApiOperation("三参")
    @GetMapping("pageSearch")
    public CommonResult pageSearch(
                                   @RequestBody OmsOrderReturnApply omsOrderReturnApply){
        List<OmsOrderReturnApply> omsOrderReturnApplyPageInfo =
                omsOrderReturnApplyService.pageSearch(omsOrderReturnApply);
        if (omsOrderReturnApplyPageInfo == null) {
            return CommonResult.error(400,"error",null);
        }
        return CommonResult.success(200,"success",omsOrderReturnApplyPageInfo);
    }
}
