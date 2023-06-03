package com.example.seatastorageservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seatastorageservice.entity.Storage;
import org.apache.ibatis.annotations.Param;

/**
 * @author Real
 * @description 针对表【storage】的数据库操作Mapper
 * @createDate 2023-06-04 00:57:08
 * @Entity com.example.seatastorageservice.entity.Storage
 */
public interface StorageMapper extends BaseMapper<Storage> {

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     计数
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}




