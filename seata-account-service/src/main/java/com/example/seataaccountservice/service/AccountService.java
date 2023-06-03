package com.example.seataaccountservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seataaccountservice.entity.Account;

/**
 * @author Real
 * @description 针对表【account】的数据库操作Service
 * @createDate 2023-06-03 23:53:42
 */
public interface AccountService extends IService<Account> {

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     */
    void decrease(Long userId, Long money);

}
