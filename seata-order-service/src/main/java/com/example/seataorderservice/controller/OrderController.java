package com.example.seataorderservice.controller;

import com.example.seataorderservice.entity.CommonResult;
import com.example.seataorderservice.entity.Order;
import com.example.seataorderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Real
 * @since 2023/6/4 1:57
 */
@RestController
@RequiredArgsConstructor
@SuppressWarnings("rawtypes")
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

    /**
     * 创建订单
     *
     * @param order 顺序
     * @return {@link CommonResult}
     */
    @GetMapping("/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult("订单创建成功!", 200);
    }
}
