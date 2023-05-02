package com.example.loadbalancerservice.service;

import com.example.loadbalancerservice.entity.CommonResult;
import com.example.loadbalancerservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Real
 * @since 2023/5/2 22:29
 */
@SuppressWarnings("rawtypes")
@FeignClient(value = "user-service")
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
