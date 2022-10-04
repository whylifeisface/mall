package com.example.mall.mongodb.Controller;

import com.example.mall.common.CommonResult;
import com.example.mall.mongodb.Service.MeberHisoryService;
import com.example.mall.mongodb.model.MemberReadHistory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "MemberReadHistoryController")
@RequestMapping("MeberHisoryController")
public class MeberHisoryController {
    @Resource
    private MeberHisoryService meberHisoryService;

    @ApiOperation("创建浏览记录")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory) {
        int count = meberHisoryService.create(memberReadHistory);
        if (count > 0) {
            return CommonResult.success(200,"",null);
        } else {
            return CommonResult.error(400,"",null);
        }
    }

    @ApiOperation("删除浏览记录")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestParam("ids") List<String> ids) {
        int count = meberHisoryService.delete(ids);
        if (count > 0) {
            return CommonResult.success(200,"MeberHisoryController--delete",count);
        } else {
            return CommonResult.error(400,"MeberHisoryController--delete",null);
        }
    }

    @ApiOperation("展示浏览记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult list(Long memberId) {
        List<MemberReadHistory> memberReadHistoryList = meberHisoryService.list(memberId);
        return CommonResult.success(200,"MeberHisoryController--delete",memberReadHistoryList);

    }


}
