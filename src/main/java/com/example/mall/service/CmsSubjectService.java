package com.example.mall.service;

import com.example.mall.mbg.mapper.CmsSubjectMapper;
import com.example.mall.mbg.model.CmsSubject;
import com.example.mall.service.imp.CmsSubjectServiceImp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CmsSubjectService implements CmsSubjectServiceImp {
    @Resource
    private CmsSubjectMapper cmsSubjectMapper;


    @Override
    public PageInfo<CmsSubject> init(int num, int size) {
        PageHelper.startPage(num, size);
        List<CmsSubject> cmsSubjects=
                cmsSubjectMapper.init();

        return new PageInfo<>(cmsSubjects);
    }
}
