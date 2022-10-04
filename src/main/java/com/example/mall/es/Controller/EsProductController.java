//package com.example.mall.es.Controller;
//
//import com.example.mall.common.CommonResult;
//import com.example.mall.es.model.EsProduct;
//import com.example.mall.es.service.EsProductService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController
//@RequestMapping("EsProductController")
//@Api(tags="EsProductController")
//public class EsProductController {
//    @Resource
//    private EsProductService esProductService;
//
//    @ApiOperation("导入所有pmsproduct到ES")
//    @PostMapping("importAll")
//    public CommonResult importAll(){
//        int i = esProductService.importAll();
//        return CommonResult.success(200,"EsProductController--importAll",i);
//    }
//
//    @ApiOperation("根据id删除商品")
//    @GetMapping("delete/{id}")
//    public CommonResult DeleteByid(@PathVariable Long id){
//        esProductService.delete(id);
//        return CommonResult.success(200,"EsProductController---DeleteByid",null);
//    }
//
//    @ApiOperation("根据id批量删除数据")
//    @PostMapping("delete/batch")
//    public CommonResult delete(@RequestParam("ids") List<Long> ids){
//        esProductService.delete(ids);
//        return CommonResult.success(200,"EsProductController---DeleteByid",null);
//    }
//    @ApiOperation("根据id创建商品")
//    @PostMapping("/create/{id}")
//    public CommonResult create(@PathVariable Long id){
//        EsProduct esProduct = esProductService.create(id);
//        if (esProduct == null) {
//            return CommonResult.error(400,"EsProductController---create",null);
//        }
//            return CommonResult.success(200,"EsProductController---create",esProduct);
//    }
//    @ApiOperation("简单搜索")
//    @GetMapping("/search/simple")
//    public CommonResult search(
//            @RequestParam(required = false) String keyword,
//            @RequestParam(required = false,defaultValue = "0") Integer pageNum,
//            @RequestParam(required = false,defaultValue = "5") Integer pageSize
//            ){
//        Page<EsProduct> search = esProductService.search(keyword, pageNum, pageSize);
//        return CommonResult.success(200,"EsProductController---search",search);
//    }
//
//
//
//}
