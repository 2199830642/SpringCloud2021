package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Kaibo.Chen@hand-china.com
 * @ClassName: orderHystrixMain80
 * @Description: TODO
 * @date 2021/11/16 15:05
 */
@SpringBootApplication
@EnableFeignClients
public class orderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(orderHystrixMain80.class, args);
    }
}
