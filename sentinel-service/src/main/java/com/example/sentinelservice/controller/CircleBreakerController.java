package com.example.sentinelservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.sentinelservice.entity.CommonResult;
import com.example.sentinelservice.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Real
 * @since 2023/5/18 0:00
 */
@Slf4j
@RestController
@RequestMapping("/breaker")
@SuppressWarnings("rawtypes")
@RequiredArgsConstructor
public class CircleBreakerController {

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    private final RestTemplate restTemplate;

    @RequestMapping("/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handleFallback")
    public CommonResult fallback(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    @RequestMapping("/fallbackException/{id}")
    @SentinelResource(value = "fallbackException", fallback = "handleFallback2", exceptionsToIgnore = {NullPointerException.class})
    public CommonResult fallbackException(@PathVariable Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        }
        if (id == 2) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    public CommonResult handleFallback(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser, "服务降级返回", 200);
    }

    public CommonResult handleFallback2(@PathVariable Long id, Throwable e) {
        log.error("handleFallback2 id:{},throwable class:{}", id, e.getClass());
        User defaultUser = new User(-2L, "defaultUser2", "123456");
        return new CommonResult<>(defaultUser, "服务降级返回", 200);
    }

}
