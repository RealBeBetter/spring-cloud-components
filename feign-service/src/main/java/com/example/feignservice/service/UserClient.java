package com.example.feignservice.service;

import com.example.feignservice.entity.CommonResult;
import com.example.feignservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author wei.song
 * @since 2023-04-18 12:11
 */
@SuppressWarnings("rawtypes")
@FeignClient(value = "user-service", fallback = UserFallbackClientImpl.class)
public interface UserClient {

    /**
     * 创建
     *
     * @param user 用户
     * @return {@link CommonResult}
     */
    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    /**
     * 获取用户
     *
     * @param id id
     * @return {@link CommonResult}<{@link User}>
     */
    @GetMapping("/user/{id}")
    CommonResult<User> getUser(@PathVariable("id") Long id);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return {@link CommonResult}<{@link User}>
     */
    @GetMapping("/user/getByUsername")
    CommonResult<User> getByUsername(@RequestParam("username") String username);

    /**
     * 更新
     *
     * @param user 用户
     * @return {@link CommonResult}
     */
    @PostMapping("/user/update")
    CommonResult update(@RequestBody User user);

    /**
     * 删除
     *
     * @param id id
     * @return {@link CommonResult}
     */
    @PostMapping("/user/delete/{id}")
    CommonResult delete(@PathVariable("id") Long id);
}
