package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.SmsHomeRecommendSubject;
import com.example.mall.service.SmsHomeRecommendSubjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("SmsHomeRecommendSubjectController")
@RestController
public class SmsHomeRecommendSubjectController {
    @Resource
    private SmsHomeRecommendSubjectService smsHomeRecommendSubjectService;
    @GetMapping("init")
    public CommonResult init(@RequestParam("num") int num, @RequestParam("size") int size){
      PageInfo<SmsHomeRecommendSubject> smsHomeRecommendSubjectPageInfo=
              smsHomeRecommendSubjectService.init(num,size);
        if (smsHomeRecommendSubjectPageInfo == null) {
            return CommonResult.error(400,"SmsHomeRecommendSubjectController--init",null);
        }
        return CommonResult.success(200,"SmsHomeRecommendSubjectController--init",smsHomeRecommendSubjectPageInfo);
    }
    @PostMapping("get")
    public CommonResult get(@RequestBody(required = false)
                                        SmsHomeRecommendSubject smsHomeRecommendSubject){
       List<SmsHomeRecommendSubject> smsHomeRecommendSubjectList=
               smsHomeRecommendSubjectService.get(smsHomeRecommendSubject);
        if (smsHomeRecommendSubject == null) {
            return CommonResult.error(400,"SmsHomeRecommendSubjectController--get",null);
        }
        return CommonResult.success(200,"SmsHomeRecommendSubjectController--get",smsHomeRecommendSubjectList);
    }

}
