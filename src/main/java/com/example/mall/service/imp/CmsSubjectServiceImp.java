package com.example.mall.service.imp;

import com.example.mall.mbg.model.CmsSubject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CmsSubjectServiceImp {
    PageInfo<CmsSubject> init(int num,int size);
}
