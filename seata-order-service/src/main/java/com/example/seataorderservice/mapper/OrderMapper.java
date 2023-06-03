package com.example.seataorderservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seataorderservice.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author Real
 * @description 针对表【order】的数据库操作Mapper
 * @createDate 2023-06-04 00:39:02
 * @Entity com.example.seataorderservice.entity.Order
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 创建订单
     *
     * @param order 顺序
     */
    void create(Order order);

    /**
     * 修改订单金额
     *
     * @param userId 用户id
     * @param status 状态
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}




