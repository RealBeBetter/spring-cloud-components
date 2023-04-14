package com.example.hystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Real
 * @date 2023/04/12 23:28
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.example.hystrixservice.filter"})
public class HystrixServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixServiceApplication.class, args);
    }

}
