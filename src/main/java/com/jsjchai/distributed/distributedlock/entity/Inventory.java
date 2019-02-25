package com.jsjchai.distributed.distributedlock.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 *  库存表实体类
 * @author jsjchai.
 */
@Setter
@Getter
@ToString
public class Inventory {

    private Integer id;

    /**
     * 库存总数
     */
    private Integer total;

    /**
     * 剩余库存
     */
    private Integer remainStock;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
