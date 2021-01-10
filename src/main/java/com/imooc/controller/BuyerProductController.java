package com.imooc.controller;


import com.imooc.vo.ProductInfoVO;
import com.imooc.vo.ProductVO;
import com.imooc.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author yaojun
 * @create 2021-01-08 11:32
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = new ResultVO();
        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();
        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(Arrays.asList(productVO));
        return resultVO;

    }
}
