package com.example.hystrixservice.service;

import com.example.hystrixservice.entity.CommonResult;
import com.example.hystrixservice.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * @author Real
 * @since 2023/4/12 23:34
 */
@Slf4j
@Service
@RequiredArgsConstructor
@SuppressWarnings({"unused", "rawtypes"})
public class UserService {

    private final RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    public CommonResult getUser(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    public CommonResult getDefaultUser(@PathVariable Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @HystrixCommand(fallbackMethod = "getDefaultUser",
            commandKey = "getUserCommand",
            groupKey = "getUserGroup",
            threadPoolKey = "getUserThreadPool")
    public CommonResult getUserCommand(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    @HystrixCommand(fallbackMethod = "getDefaultUserException", ignoreExceptions = {NullPointerException.class})
    public CommonResult getUserException(Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }

        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    public CommonResult getDefaultUserException(@PathVariable Long id, Throwable e) {
        log.error("getDefaultUserException id:{},throwable class:{}", id, e.getClass());
        User defaultUser = new User(-2L, "defaultUserException", "123456");
        return new CommonResult<>(defaultUser);
    }

}
