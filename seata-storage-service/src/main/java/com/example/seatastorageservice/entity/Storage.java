package com.example.seatastorageservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Real
 * @TableName storage
 * @date 2023/06/04 00:59
 */
@Data
@TableName(value = "storage")
public class Storage implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 总库存
     */
    @TableField(value = "total")
    private Integer total;

    /**
     * 已用库存
     */
    @TableField(value = "used")
    private Integer used;

    /**
     * 剩余库存
     */
    @TableField(value = "residue")
    private Integer residue;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
