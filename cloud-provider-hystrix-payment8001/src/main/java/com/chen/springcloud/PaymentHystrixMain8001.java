package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName PaymentHystrixMain8001
 * @Description TODO
 * @date 2021/4/9 15:35
 * @Author xiaochen
 */
@SpringBootApplication
@EnableEurekaClient //本次服务启动后会自动注册进eureka服务注册中心
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }
}
