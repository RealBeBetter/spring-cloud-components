package com.example.seataorderservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seataorderservice.entity.Order;

/**
 * @author Real
 * @description 针对表【order】的数据库操作Service
 * @createDate 2023-06-04 00:39:02
 */
public interface OrderService extends IService<Order> {

    /**
     * 创建订单
     *
     * @param order 顺序
     */
    void create(Order order);

}
