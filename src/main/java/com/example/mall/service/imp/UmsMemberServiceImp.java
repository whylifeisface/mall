package com.example.mall.service.imp;

import com.example.mall.common.CommonResult;

public interface UmsMemberServiceImp {
    CommonResult getAuthCode(String telephone);

    CommonResult updatePassword(String telephone,String authCode);
}
