package com.example.ribbonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wei.song
 * @date 2023/04/12 11:01
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LoadBalanceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceServiceApplication.class, args);
    }

}
