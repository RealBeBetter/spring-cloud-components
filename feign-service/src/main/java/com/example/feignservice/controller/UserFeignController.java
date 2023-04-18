package com.example.feignservice.controller;

import com.example.feignservice.entity.CommonResult;
import com.example.feignservice.entity.User;
import com.example.feignservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wei.song
 * @since 2023/4/18 12:13
 */
@RestController
@RequestMapping("/user")
@SuppressWarnings("rawtypes")
public class UserFeignController {

    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam String username) {
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
    public CommonResult delete(@PathVariable Long id) {
        return userService.delete(id);
    }

}
