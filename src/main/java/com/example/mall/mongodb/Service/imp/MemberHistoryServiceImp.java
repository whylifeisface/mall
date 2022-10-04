package com.example.mall.mongodb.Service.imp;

import com.example.mall.mongodb.model.MemberReadHistory;

import java.util.List;

public interface MemberHistoryServiceImp {
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);
}
