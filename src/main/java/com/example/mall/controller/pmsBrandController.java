package com.example.mall.controller;


import com.example.mall.common.CommonResult;
import com.example.mall.mbg.model.pms.PmsBrand;
import com.example.mall.service.BrandService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RequestMapping("pmsBrandController")
@RestController
public class pmsBrandController {
    private static final Logger LOGGER = LoggerFactory.getLogger(pmsBrandController.class);
    @Autowired
    private BrandService brandService;


    @GetMapping("byName")
    public CommonResult SelectByName(@RequestParam("name") String name ){
        if (name == null) {
            return CommonResult.error(400,"error----byName",null);

        }
        List<PmsBrand> pmsBrands = brandService.selectByName(name);
        if (pmsBrands == null) {
            return CommonResult.error(400,"error----byName",null);

        }

        return CommonResult.success(200, "success --------SelectByName", pmsBrands);

    }

    @GetMapping("page")
    public CommonResult pageAll(@RequestParam("size") int size,@RequestParam("num") int num){
//        if (size == ' ') {
//            size = 10;
//        }

        List<PmsBrand> pmsBrands = brandService.pageAll(size, num);


        if (pmsBrands!=null) {
            LOGGER.debug("createBrand--success:{}", pmsBrands);

            return CommonResult.success(200, "success --------pageAll", pmsBrands);
        }
        LOGGER.debug("createBrand--error:{}", pmsBrands);

        return CommonResult.error(400,"error----pageAll",null);
    }
    @GetMapping("visibility")
    public CommonResult visibility(@RequestParam("num")int num,@RequestParam("size") int size){
        PageInfo<PmsBrand> pageInfo =
                brandService.visibility(num,size);
        if (pageInfo == null) {
            return CommonResult.error(400,"pmsBrandController--visibility",null);
        }
        return CommonResult.success(200,"pmsBrandController--visibility",pageInfo);
    }
    @PostMapping("search")
    public CommonResult search(@RequestBody PmsBrand pmsBrand){
        if (pmsBrand.getName() == null)  return CommonResult.error(400,"pmsBrandController--search",null);
       List<PmsBrand> pmsBrands=
               brandService.search(pmsBrand);
        if (pmsBrands == null) {
            return CommonResult.error(400,"pmsBrandController--search",null);

        }
        return CommonResult.success(200,"pmsBrandController--search",pmsBrand);

    }
    @GetMapping("get")
    public CommonResult getPage(){
//        if (size == ' ') {
//            size = 10;
//        }

        int page = brandService.getPage();
        if (page!=0) {
            LOGGER.debug("createBrand--success:{}", page);

            return CommonResult.success(200, "createBrandsuccess", page);
        }
        LOGGER.debug("createBrand--error:{}", page);

        return CommonResult.error(400,"createBranderror",null);

    }



    @ApiOperation("获取所有品牌列表")
    @GetMapping("/listAll")
    public CommonResult getBrandList(){
        return CommonResult.success(200,"getBrandListsuccess",brandService.getBrandList());
    }
    @ApiOperation("添加品牌")
    @GetMapping("/create")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand
    ){
       int i =  brandService.createBrand(pmsBrand);
       if (i==1) {
           LOGGER.debug("createBrand--success:{}", pmsBrand);

           return CommonResult.success(200, "createBrandsuccess", null);
       }
        LOGGER.debug("createBrand--error:{}", pmsBrand);

        return CommonResult.error(400,"createBranderror",null);
    }
    @ApiOperation("更新指定id品牌信息")
    @GetMapping("/update/{id}")
    public CommonResult updateBrand(@PathVariable Long id,
                                    PmsBrand pmsBrand
                                    ){
        int i =  brandService.updateBrand(id,pmsBrand);

        if (i==1) {
            LOGGER.debug("updateBrand--success:{}", pmsBrand);

            return CommonResult.success(200, "createBrandsuccess", null);
        }
        LOGGER.debug("updateBrand--error:{}", pmsBrand);

        return CommonResult.error(400,"createBranderror",null);
    }
    @ApiOperation("删除指定id的品牌")
    @GetMapping("/delete/{id}")
    public CommonResult deleteBrand(@PathVariable Long id){
        int i =  brandService.deleteBrand(id);

        if (i==1) {
            LOGGER.debug("deleteBrand--success:{}", id);

            return CommonResult.success(200, "createBrandsuccess", null);
        }
        LOGGER.debug("deleteBrand--error:{}", id);

        return CommonResult.error(400,"createBranderror",null);
    }
//    @ApiOperation("分页查询品牌列表")
//    @GetMapping("/page")@ResponseBody
//    public CommonResult pageBrand(
//            @RequestParam(value = "pageNum",defaultValue = "1") @ApiParam("页码")Integer pageNum,
//            @RequestParam(value = "pageSize",defaultValue = "3")@ApiParam("每页数量")Integer pageSize
//    ){
//            return CommonResult.success(200, "createBrandsuccess", brandService.pageBrand(pageNum,pageSize));
//        }
    @ApiOperation("获取指定id的品牌详情")
   @GetMapping("/{id}")
    public CommonResult brand(@PathVariable("id")Long id ){
       PmsBrand pmsBrand = brandService.brand(id);
       if (null != pmsBrand){
           return CommonResult.success(200, "Brandsuccess", pmsBrand);
       }
       return CommonResult.error(400, "Brandsuccess", null);
   }

}
