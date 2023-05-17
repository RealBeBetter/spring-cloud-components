package com.example.sentinelservice.service;

import com.example.sentinelservice.entity.CommonResult;
import com.example.sentinelservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Real
 * @since 2023/5/18 0:08
 */
@SuppressWarnings("rawtypes")
@FeignClient(value = "nacos-user-service", fallback = UserFallbackServiceImpl.class)
public interface UserService {

    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    @GetMapping("/user/{id}")
    CommonResult<User> getUser(@PathVariable("id") Long id);

    @GetMapping("/user/getByUsername")
    CommonResult<User> getByUsername(@RequestParam("username") String username);

    @PostMapping("/user/update")
    CommonResult update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    CommonResult delete(@PathVariable("id") Long id);
}
