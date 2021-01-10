package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.service.CategoryService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yaojun
 * @create 2021-01-08 09:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CategroyServiceImplTest {
    @Autowired
    private CategroyServiceImpl categroyService;

    @Test
    void findById() {
        ProductCategory productCategory = categroyService.findById(1);
        Assert.assertEquals(Integer.valueOf(1), productCategory.getCategoryId());
    }

    @Test
    void findAll() {
        List<ProductCategory> result = categroyService.findAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> result = categroyService.findByCategoryTypeIn(Arrays.asList(1, 2, 4));
        Assert.assertNotEquals(0, result.size());

    }

    @Test
    void save() {
        ProductCategory productCategory = new ProductCategory("男生专项",10);
        ProductCategory result = categroyService.save(productCategory);
        Assert.assertNotNull(result);
    }
}