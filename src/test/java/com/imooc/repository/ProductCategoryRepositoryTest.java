package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.config.RepositoryConfigurationSource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author yaojun
 * @create 2021-01-08 08:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
//        List<ProductCategory> products = repository.findAll();
//        for (ProductCategory product : products) {
//            System.out.println(product.toString());
//        }
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory);
    }
    @Test
    @Transactional
    /*测试完成后就回滚*/
    public void saveTest(){
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(2);
//        productCategory.setCategoryName("男生最爱");
//        productCategory.setCategoryType(3);
//        productCategory = repository.findById(2).get();
//        productCategory.setCategoryType(5);
//        repository.save(productCategory);
        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,5);
        List<ProductCategory> reslt = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, reslt.size());
    }
}