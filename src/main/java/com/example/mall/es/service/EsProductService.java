//package com.example.mall.es.service;
//
//import com.example.mall.es.dao.EsProductDao;
//import com.example.mall.es.model.EsProduct;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.util.CollectionUtils;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//
//@Service
//@Slf4j
//public class EsProductService implements EsProductServiceImp{
//    @Autowired
//    private EsProductDao esProductDao;
//    @Resource
//    private EsProductRepository productRepository;
//
//    @Override
//    public int importAll() {
//        List<EsProduct> allFromMysql = esProductDao.getAllFromMysql(null);
//        Iterable<EsProduct> esProducts = productRepository.saveAll(allFromMysql);
//        Iterator<EsProduct> iterator = esProducts.iterator();
//        int result = 0;
//        while (iterator.hasNext()){
//            result++;
//            iterator.next();
//        }
//        return result;
//    }
//
//    @Override
//    public void delete(Long id) {
//        productRepository.deleteById(id);
//    }
//
//    @Override
//    public EsProduct create(Long id) {
//        EsProduct result = null;
//        List<EsProduct> allFromMysql = esProductDao.getAllFromMysql(id);
//        if (allFromMysql.size()>0){
//            EsProduct esProduct = allFromMysql.get(0);
//            result = productRepository.save(esProduct);
//        }
//        return result;
//    }
//
//    @Override
//    public void delete(List<Long> ids) {
//        if(!CollectionUtils.isEmpty(ids)){
//            ArrayList<EsProduct> esProductList = new ArrayList<>();
//            for (Long id:ids){
//                EsProduct esProduct = new EsProduct();
//                esProduct.setId(id);
//                esProductList.add(esProduct);
//            }
//            productRepository.deleteAll(esProductList);
//        }
//    }
//
//    @Override
//    public Page<EsProduct> search(String keywords, Integer pageNum, Integer pageSize) {
//        Pageable pageable  = PageRequest.of(pageNum, pageSize);
//        return  productRepository.findByNameOrSubTitleOrKeywords(keywords,keywords,keywords,pageable);
//    }
//}
