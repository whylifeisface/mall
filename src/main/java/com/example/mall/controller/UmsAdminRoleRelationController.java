package com.example.mall.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.example.mall.common.CommonResult;
import com.example.mall.mbg.mapper.UmsAdminRoleRelationMapper;
import com.example.mall.mbg.model.UmsAdminRoleRelation;
import com.example.mall.mbg.model.UmsRole;
import com.example.mall.mbg.model.myUmsAdminRoleRelation;
import com.example.mall.service.UmsAdminRoleRelationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("UmsAdminRoleRelationController")
public class UmsAdminRoleRelationController {
    @Resource
    private UmsAdminRoleRelationService umsAdminRoleRelationService;
    @Resource
    private SqlSessionFactory sqlSessionFactory;
    public int count = 0;


    @PostMapping("insert")
    public CommonResult insert(@RequestBody UmsAdminRoleRelation umsAdminRoleRelation){
        count = 0;
        String umsRole = umsAdminRoleRelation.getUmsRole().getName();
        String[] split = umsRole.split(",");

        log.info("11111111111111111");

        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        UmsAdminRoleRelationMapper mapper = session.getMapper(UmsAdminRoleRelationMapper.class);

        ArrayList<UmsAdminRoleRelation> umsAdminRoleRelationArrayList = new ArrayList<>();
        UmsAdminRoleRelation myAdminRoleRelation = new UmsAdminRoleRelation();
        myAdminRoleRelation.setAdminId(umsAdminRoleRelation.getAdminId());
        UmsRole umsRole1 = new UmsRole();
        for (String s :
                split) {
            log.info(s);
            umsRole1.setName(s);
            myAdminRoleRelation.setUmsRole(umsRole1);
            umsAdminRoleRelationArrayList.add(myAdminRoleRelation);
        }


        int size = umsAdminRoleRelationArrayList.size();

        umsAdminRoleRelationArrayList.forEach(s -> {
            int nsert = mapper.nsert(s);
            if (nsert != 0) {
                count++;
            }
        });
        if (count > 0 && count<=size){
            log.info("有"+size+"条执行"+"成功"+count+"条");

            return CommonResult.success(200,"有条执行",null);
        }
            return CommonResult.error(400,"",null);
    }

}
