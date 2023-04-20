package com.example.consulconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Real
 * @date 2023/04/20 22:11
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigClientApplication.class, args);
    }

}
