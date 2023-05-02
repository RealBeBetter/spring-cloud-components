package com.example.loadbalancerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Real
 * @since 2023/5/2 22:23
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @ConfigurationProperties(prefix = "rest.template.config")
    public HttpComponentsClientHttpRequestFactory customHttpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(customHttpRequestFactory());
    }
}
