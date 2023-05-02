package com.example.loadbalancerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Real
 * @date 2023/05/02 22:27
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class LoadbalancerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadbalancerServiceApplication.class, args);
    }

}
