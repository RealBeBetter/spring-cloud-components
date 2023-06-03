package com.example.seataorderservice.service;

import com.example.seataorderservice.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Real
 * @since 2023/6/4 0:44
 */
@SuppressWarnings("rawtypes")
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     计数
     * @return {@link CommonResult}
     */
    @GetMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
