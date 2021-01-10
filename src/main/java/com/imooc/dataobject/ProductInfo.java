package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.security.PrivateKey;

/**
 * @author yaojun
 * @create 2021-01-08 09:41
 */
@Entity
@Data
public class ProductInfo {
    @Id
    /**商品ID*/
    private String productId;
    /**商品名称*/
    private String productName;
    /**商品单价*/
    private BigDecimal productPrice;
    /**商品库存*/
    private Integer productStock;
    /**商品描述*/
    private String productDescription;
    /**商品小图*/
    private String productIcon;

    /**商品状态，0正常1下架'*/
    private Integer productStatus;
    /**目录类别*/
    private Integer categoryType;
}
