package com.example.sentinelservice.service;

import com.example.sentinelservice.entity.CommonResult;
import com.example.sentinelservice.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author Real
 * @since 2023/5/18 0:09
 */
@Component
@SuppressWarnings("rawtypes")
public class UserFallbackServiceImpl implements UserService {

    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser, "服务降级返回", 200);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser, "服务降级返回", 200);
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser, "服务降级返回", 200);
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
