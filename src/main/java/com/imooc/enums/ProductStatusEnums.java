package com.imooc.enums;

import lombok.Getter;

/**
 * @author yaojun
 * @create 2021-01-08 11:02
 */
@Getter
public enum ProductStatusEnums {
    UP(0, "在架"), DOWN(1, "下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
