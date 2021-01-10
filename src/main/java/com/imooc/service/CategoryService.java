package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * @author yaojun
 * @create 2021-01-08 09:28
 */
public interface CategoryService {
    ProductCategory findById(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
