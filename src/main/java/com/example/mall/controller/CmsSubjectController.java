package com.example.mall.controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mbg.mapper.CmsSubjectMapper;
import com.example.mall.mbg.model.CmsSubject;
import com.example.mall.service.CmsSubjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("CmsSubjectController")
public class CmsSubjectController {
    @Resource
    private CmsSubjectService cmsSubjectService;

    @GetMapping("init")
    public CommonResult init(@RequestParam("num") int num,@RequestParam("size") int size){
        PageInfo<CmsSubject> cmsSubjectPageInfo=
                cmsSubjectService.init(num,size);
        if (cmsSubjectPageInfo == null) {
            return CommonResult.error(400,"CmsSubjectController--init",null);
        }
        return CommonResult.success(200,"CmsSubjectController--init",cmsSubjectPageInfo);

    }

}
