package com.example.feignservice.service;

import com.example.feignservice.entity.CommonResult;
import com.example.feignservice.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author wei.song
 * @since 2023/4/18 14:17
 */
@Component
@SuppressWarnings("rawtypes")
public class UserFallbackClientImpl implements UserClient {

    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult("调用失败，服务被降级", 500);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult("调用失败，服务被降级", 500);
    }
}
