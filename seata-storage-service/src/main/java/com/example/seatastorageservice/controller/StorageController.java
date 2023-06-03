package com.example.seatastorageservice.controller;

import com.example.seatastorageservice.entity.CommonResult;
import com.example.seatastorageservice.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Real
 * @since 2023/6/4 1:58
 */
@RestController
@RequiredArgsConstructor
@SuppressWarnings("rawtypes")
@RequestMapping("/storage")
public class StorageController {

    private final StorageService storageService;

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     计数
     * @return {@link CommonResult}
     */
    @RequestMapping("/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult("扣减库存成功！", 200);
    }
}
