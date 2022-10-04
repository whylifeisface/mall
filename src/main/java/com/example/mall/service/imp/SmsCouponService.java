package com.example.mall.service.imp;

import com.example.mall.mbg.mapper.SmsCouponMapper;
import com.example.mall.mbg.model.SmsCoupon;
import com.example.mall.mbg.model.SmsCouponExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmsCouponService implements SmsCouponServiceImp{
    @Resource
    private SmsCouponMapper smsCouponMapper;
    @Override
    public PageInfo<SmsCoupon> init(int num, int size) {
        PageHelper.startPage(num, size);
        List<SmsCoupon> smsCoupons = smsCouponMapper.selectByExample(new SmsCouponExample());
        PageInfo<SmsCoupon> smsCouponPageInfo = new PageInfo<>(smsCoupons);
        return smsCouponPageInfo;
    }

    @Override
    public SmsCoupon sel(Long id) {
       return smsCouponMapper.selectByPrimaryKey(id);

    }

    @Override
    public List<SmsCoupon> get(SmsCoupon smsCoupon) {

        return smsCouponMapper.get();
    }
}
