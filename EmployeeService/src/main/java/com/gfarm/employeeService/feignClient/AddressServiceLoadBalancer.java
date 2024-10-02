package com.gfarm.employeeService.feignClient;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(name = "ADRESSSERVICE")
public class AddressServiceLoadBalancer {

    @Bean
    @LoadBalanced
    public Feign.Builder feiBuilder(){
        return Feign.builder();
    }

}
