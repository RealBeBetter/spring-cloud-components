package com.example.seataaccountservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Real
 * @date 2023/06/03 23:53
 */
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan({"com.example.seataaccountservice.mapper"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountServiceApplication.class, args);
    }

}
