package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author yaojun
 * @create 2021-01-08 11:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    void findById() {
        ProductInfo result = productService.findById("123456");
        Assert.assertEquals("很好喝", result.getProductDescription());
    }

    @Test
    void findAll() {
        List<ProductInfo> result = productService.findAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    void testFindAll() {
        Pageable pageable = PageRequest.of(0,2);
        Page<ProductInfo> result = productService.findAll(pageable);
        System.out.println(result.getTotalElements());

    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("玉米香菜粥");
        productInfo.setCategoryType(2);
        productInfo.setProductStatus(0);
        productInfo.setProductPrice(new BigDecimal(7.2));
        productInfo.setProductDescription("很好吃");
        productInfo.setProductIcon("https://baidu.com");
        productInfo.setProductStock(100);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}