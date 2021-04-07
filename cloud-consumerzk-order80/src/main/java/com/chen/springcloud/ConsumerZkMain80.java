package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ConsumerZkMain80
 * @Description TODO
 * @date 2021/4/7 9:43
 * @Author xiaochen
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkMain80.class, args);
    }
}
