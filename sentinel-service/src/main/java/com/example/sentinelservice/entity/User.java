package com.example.sentinelservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wei.song
 * @since 2023/4/11 16:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

}
