package com.example.sentinelservice.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.sentinelservice.entity.CommonResult;

/**
 * @author Real
 * @since 2023/5/17 23:53
 */
@SuppressWarnings("rawtypes")
public class CustomBlockHandler {

    public CommonResult handleException(BlockException exception) {
        return new CommonResult("自定义限流信息", 200);
    }

}
