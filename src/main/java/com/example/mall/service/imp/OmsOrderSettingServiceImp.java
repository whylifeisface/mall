package com.example.mall.service.imp;

import com.example.mall.mbg.model.Oms.OmsOrderSetting;

import java.util.List;

public interface OmsOrderSettingServiceImp {
    int Insert(OmsOrderSetting omsOrderSetting);

    List<OmsOrderSetting> get();
}
