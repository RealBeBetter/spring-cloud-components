package com.example.seataorderservice.service;

import com.example.seataorderservice.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Real
 * @since 2023/6/4 0:45
 */
@SuppressWarnings("rawtypes")
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  钱
     * @return {@link CommonResult}
     */
    @RequestMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
