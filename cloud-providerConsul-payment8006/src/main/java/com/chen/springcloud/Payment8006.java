package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName Payment8006
 * @Description TODO
 * @date 2021/4/7 11:06
 * @Author xiaochen
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8006 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8006.class,args);
    }
}
