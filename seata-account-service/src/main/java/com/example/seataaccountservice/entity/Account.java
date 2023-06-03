package com.example.seataaccountservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Real
 * @TableName account
 * @date 2023/06/03 23:55
 */
@Data
@TableName(value = "account")
public class Account implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 总额度
     */
    @TableField(value = "total")
    private Integer total;

    /**
     * 已用余额
     */
    @TableField(value = "used")
    private Integer used;

    /**
     * 剩余可用额度
     */
    @TableField(value = "residue")
    private Integer residue;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
