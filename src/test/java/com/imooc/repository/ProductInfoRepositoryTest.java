package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yaojun
 * @create 2021-01-08 10:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    void testRepository() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setCategoryType(2);
        productInfo.setProductStatus(0);
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductDescription("很好喝");
        productInfo.setProductIcon("https://baidu.com");
        productInfo.setProductStock(100);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    void findByProductStatus(){
        List<ProductInfo> products = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, products.size());
    }
}