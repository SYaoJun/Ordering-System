package com.imooc.controller;


import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import com.imooc.vo.ProductInfoVO;
import com.imooc.vo.ProductVO;
import com.imooc.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.util.List;


/**
 * @author yaojun
 * @create 2021-01-08 11:32
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findAll();
        // 从数据库中查出的所有上架的商品信息
        List<ProductInfo > upProductList = new ArrayList<>();

        for (ProductInfo productInfo : productInfoList) {
            if(productInfo.getProductStatus()==0){
                upProductList.add(productInfo);
            }
        }
        //2. 查询类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法 for循环遍历所有结果，查询出不同的类别
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        //精简方法 lambda方式
        //productInfoList.stream().map(e->e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装(首先遍历类目，再在类目中遍历商品详情)
        List<ProductVO> productVOList = new ArrayList<>();
        /**外层是商品的类别*/
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            /**内层是商品的详情*/
            for (ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    /**属性拷贝*/
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        /**最最外层*/
        return ResultVOUtil.success(productVOList);

    }
}
