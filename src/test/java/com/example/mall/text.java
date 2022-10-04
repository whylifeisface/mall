package com.example.mall;

import cn.hutool.log.Log;
import com.example.mall.mbg.model.pms.PmsProductAttributeCategory;
import com.example.mall.mbg.model.pms.PmsProductCategory;
import com.example.mall.service.PmsProductAttributeCategoryService;
import com.example.mall.service.PmsProductCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class text {

    @Autowired
    private PmsProductAttributeCategoryService pmsService;

    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    private void textss(){
        String encode = passwordEncoder.encode("111");
        System.out.println(encode);
//        List<PmsProductCategory> pmsProductCategories = pmsProductCategoryService.linInId();
//        System.out.println(pmsProductCategories);
    }
}
