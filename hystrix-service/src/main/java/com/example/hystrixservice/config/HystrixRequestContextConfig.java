package com.example.hystrixservice.config;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wei.song
 * @since 2023/4/14 17:45
 */
@Configuration
public class HystrixRequestContextConfig {

    @Bean
    public HystrixRequestContext hystrixRequestContext() {
        return HystrixRequestContext.initializeContext();
    }

}
