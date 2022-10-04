package com.example.mall.service;

import com.example.mall.mbg.mapper.OmsOrderReturnApplyMapper;
import com.example.mall.mbg.model.Oms.OmsOrderReturnApply;
import com.example.mall.mbg.model.Oms.OmsOrderReturnApplyExample;
import com.example.mall.service.imp.OmsOrderReturnApplyServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsOrderReturnApplyService implements OmsOrderReturnApplyServiceImp {
    @Autowired
    private OmsOrderReturnApplyMapper omsOrderReturnApplyMapper;
    @Override
    public PageInfo<OmsOrderReturnApply> page(int num, int size) {
        PageHelper.startPage(num,size);
        List<OmsOrderReturnApply> omsOrderReturnApplies =
                omsOrderReturnApplyMapper.selectByExample(new OmsOrderReturnApplyExample());
        return new PageInfo<OmsOrderReturnApply>(omsOrderReturnApplies);
    }

    @Override
    public List<OmsOrderReturnApply> pageSearch( OmsOrderReturnApply omsOrderReturnApply) {
        return omsOrderReturnApplyMapper.pageSearch(omsOrderReturnApply);
    }

    @Override
    public OmsOrderReturnApply Join(Long id) {
        return  omsOrderReturnApplyMapper.Join(id);
    }
}
