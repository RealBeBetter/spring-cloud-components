package com.example.loadbalancerservice.controller;

import com.example.loadbalancerservice.entity.CommonResult;
import com.example.loadbalancerservice.entity.User;
import com.example.loadbalancerservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Real
 * @since 2023/5/2 22:30
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/userFeign")
@SuppressWarnings("rawtypes")
public class UserFeignController {

    private final UserService userService;

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam("username") String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}
