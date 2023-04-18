package com.example.feignservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wei.song
 * @since 2023/4/18 14:28
 */
@Configuration
public class FeignConfig {

    /**
     * 设置 feign 日志级别为 FULL，启动 Feign 自带的日志打印功能
     *
     * @return {@link Logger.Level}
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
