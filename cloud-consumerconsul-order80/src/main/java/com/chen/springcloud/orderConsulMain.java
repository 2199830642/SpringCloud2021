package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName orderConsulMain
 * @Description TODO
 * @date 2021/4/7 11:22
 * @Author xiaochen
 */
@SpringBootApplication
@EnableDiscoveryClient
public class orderConsulMain {
    public static void main(String[] args) {
        SpringApplication.run(orderConsulMain.class,args);
    }
}
