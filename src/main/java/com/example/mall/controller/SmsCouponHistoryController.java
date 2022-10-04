package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsCouponHistory;
import com.example.mall.service.SmsCouponHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("SmsCouponHistoryController")
public class SmsCouponHistoryController {
    @Resource
    private SmsCouponHistoryService smsCouponHistoryService;

    @PostMapping("/init")
    public CommonResult init(@RequestBody(required = false) SmsCouponHistory smsCouponHistory){
       List<SmsCouponHistory> smsCouponHistory1 = smsCouponHistoryService.init(smsCouponHistory);
        if (smsCouponHistory1 == null) {
            return CommonResult.error(400,"SmsCouponHistoryController--init",null);

        }
        return CommonResult.success(200,"SmsCouponHistoryController--init",smsCouponHistory1);

    }
}
