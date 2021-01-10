package com.imooc.dataobject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author yaojun
 * @create 2021-01-08 08:21
 * 类目表
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory {
    /**类目id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CategoryId;
    /**类目名称 */
    private String CategoryName;

    /**类目类型 */
    private int categoryType;

    public ProductCategory(String categoryName, int categoryType) {
        this.CategoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {

    }
}
