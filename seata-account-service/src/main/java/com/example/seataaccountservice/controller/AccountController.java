package com.example.seataaccountservice.controller;

import com.example.seataaccountservice.entity.CommonResult;
import com.example.seataaccountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Real
 * @since 2023/6/4 0:06
 */
@RestController
@RequestMapping("/account")
@SuppressWarnings("rawtypes")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  钱
     * @return {@link CommonResult}
     */
    @RequestMapping("/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money) {
        accountService.decrease(userId, money);
        return new CommonResult("扣减账户余额成功！", 200);
    }

}
