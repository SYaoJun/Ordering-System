package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author yaojun
 * @create 2021-01-08 10:58
 */
public interface ProductService {
    ProductInfo findById(String productId);
    List<ProductInfo> findAll();
    /**分页*/
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
    /**加减库存*/
}
