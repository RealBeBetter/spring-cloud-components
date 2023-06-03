package com.example.seataaccountservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seataaccountservice.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author Real
 * @description 针对表【account】的数据库操作Mapper
 * @createDate 2023-06-03 23:53:42
 * @Entity com.example.seataaccountservice.entity.Account
 */
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);

}




