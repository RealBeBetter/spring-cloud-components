package com.example.sentinelservice.controller;

import com.example.sentinelservice.entity.CommonResult;
import com.example.sentinelservice.entity.User;
import com.example.sentinelservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Real
 * @since 2023/5/18 0:10
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
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
