package com.example.seatastorageservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seatastorageservice.entity.Storage;
import com.example.seatastorageservice.mapper.StorageMapper;
import com.example.seatastorageservice.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Real
 * @description 针对表【storage】的数据库操作Service实现
 * @createDate 2023-06-04 00:57:08
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage>
        implements StorageService {

    private final StorageMapper storageMapper;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }

}




