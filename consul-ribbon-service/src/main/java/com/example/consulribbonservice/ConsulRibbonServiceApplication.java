package com.example.consulribbonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Real
 * @date 2023/04/20 21:44
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulRibbonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulRibbonServiceApplication.class, args);
    }

}
