package com.example.mall.service;

import com.example.mall.mbg.mapper.OmsOrderSettingMapper;
import com.example.mall.mbg.model.Oms.OmsOrderSetting;
import com.example.mall.mbg.model.OmsOrderSettingExample;
import com.example.mall.service.imp.OmsOrderSettingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsOrderSettingService implements OmsOrderSettingServiceImp {
    @Autowired
    private OmsOrderSettingMapper omsOrderSettingMapper;
    @Override
    public int Insert(OmsOrderSetting omsOrderSetting) {
        return omsOrderSettingMapper.insert(omsOrderSetting);
    }

    @Override
    public List<OmsOrderSetting> get() {
      return  omsOrderSettingMapper.selectByExample(new OmsOrderSettingExample());

    }
}
