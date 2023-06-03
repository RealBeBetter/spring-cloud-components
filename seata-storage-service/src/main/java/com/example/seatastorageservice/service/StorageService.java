package com.example.seatastorageservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seatastorageservice.entity.Storage;

/**
 * @author Real
 * @description 针对表【storage】的数据库操作Service
 * @createDate 2023-06-04 00:57:08
 */
public interface StorageService extends IService<Storage> {

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     计数
     */
    void decrease(Long productId, Integer count);

}
