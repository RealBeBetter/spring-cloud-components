package com.example.seataaccountservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seataaccountservice.entity.Account;
import com.example.seataaccountservice.mapper.AccountMapper;
import com.example.seataaccountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Real
 * @description 针对表【account】的数据库操作Service实现
 * @createDate 2023-06-03 23:53:42
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
        implements AccountService {

    private final AccountMapper accountMapper;

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  钱
     */
    @Override
    public void decrease(Long userId, Long money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountMapper.decrease(userId, money);
        log.info("------->account-service中扣减账户余额结束");
    }
}




