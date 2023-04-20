package com.example.configsecurityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author wei.song
 * @date 2023/04/20 10:05
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigSecurityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigSecurityServerApplication.class, args);
    }

}
