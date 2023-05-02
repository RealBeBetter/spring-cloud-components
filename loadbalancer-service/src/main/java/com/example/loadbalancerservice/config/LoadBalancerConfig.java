package com.example.loadbalancerservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;

/**
 * @author Real
 * @since 2023/5/2 22:47
 */
@Slf4j
@Configuration
public class LoadBalancerConfig {

    @Bean
    public LoadBalancerRequestTransformer transformer() {

        return new LoadBalancerRequestTransformer() {
            @Override
            public HttpRequest transformRequest(HttpRequest request, ServiceInstance instance) {
                return new HttpRequestWrapper(request) {
                    @Override
                    public HttpHeaders getHeaders() {
                        HttpHeaders headers = new HttpHeaders();
                        headers.putAll(super.getHeaders());
                        log.info("instance info : {}", instance);
                        headers.add("X-InstanceId", instance.getInstanceId());
                        return headers;
                    }
                };
            }
        };
    }

}
