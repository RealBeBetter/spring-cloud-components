package com.example.hystrixservice.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.example.hystrixservice.entity.CommonResult;
import com.example.hystrixservice.entity.User;
import com.example.hystrixservice.service.UserService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author Real
 * @since 2023/4/12 23:32
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@SuppressWarnings("rawtypes")
public class UserHystrixController {

    private final UserService userService;

    @GetMapping("/testFallback/{id}")
    public CommonResult testFallback(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/testCommand/{id}")
    public CommonResult testCommand(@PathVariable Long id) {
        return userService.getUserCommand(id);
    }

    @GetMapping("/testException/{id}")
    public CommonResult testException(@PathVariable Long id) {
        return userService.getUserException(id);
    }

    @GetMapping("/testCache/{id}")
    public CommonResult testCache(@PathVariable Long id) {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            CommonResult userCache = userService.getUserCache(id);
            CommonResult userCache1 = userService.getUserCache(id);
            CommonResult userCache2 = userService.getUserCache(id);
            log.info("userCache: {}, userCache1: {}, userCache2: {}", userCache, userCache1, userCache2);
            return new CommonResult("操作成功", 200);
            // 执行 Hystrix 命令
        } finally {
            context.shutdown();
        }
    }

    @GetMapping("/testRemoveCache/{id}")
    public CommonResult testRemoveCache(@PathVariable Long id) {
        CommonResult userCachePre = userService.getUserCache(id);
        CommonResult commonResult = userService.removeCache(id);
        CommonResult userCacheNex = userService.getUserCache(id);
        log.info("userCachePre: {}, userCacheNex: {}, commonResult: {}", userCachePre, userCacheNex, commonResult);
        return new CommonResult("操作成功", 200);
    }

    @SneakyThrows
    @GetMapping("/testCollapser")
    public CommonResult testCollapser() {
        Future<User> future1 = userService.getUserFuture(1L);
        Future<User> future2 = userService.getUserFuture(2L);
        future1.get();
        future2.get();

        ThreadUtil.safeSleep(200);
        Future<User> future3 = userService.getUserFuture(3L);
        future3.get();
        return new CommonResult("操作成功", 200);
    }

}
