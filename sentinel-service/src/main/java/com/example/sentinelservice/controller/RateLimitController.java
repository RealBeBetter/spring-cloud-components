package com.example.sentinelservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.sentinelservice.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Real
 * @since 2023/5/16 0:13
 */
@RestController
@RequestMapping("/rateLimit")
@SuppressWarnings("rawtypes")
public class RateLimitController {

    /**
     * 按资源名称限流，需要指定限流处理逻辑
     *
     * @return {@link CommonResult}
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult("按资源名称限流", 200);
    }

    /**
     * 按URL限流，有默认的限流处理逻辑
     *
     * @return {@link CommonResult}
     */
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl", blockHandler = "handleException")
    public CommonResult byUrl() {
        return new CommonResult("按url限流", 200);
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(exception.getClass().getCanonicalName(), 200);
    }

}
