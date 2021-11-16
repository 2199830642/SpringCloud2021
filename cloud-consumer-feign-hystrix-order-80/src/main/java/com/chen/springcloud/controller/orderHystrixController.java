package com.chen.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chen.springcloud.feign.consumer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kaibo.Chen@hand-china.com
 * @ClassName: orderHystrixController
 * @Description: TODO
 * @date 2021/11/16 15:12
 */
@RestController
@Slf4j
public class orderHystrixController {

    @Resource
    private consumer consumer;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String PaymentInfo_Ok(@PathVariable Integer id) {
        String result = consumer.PaymentInfo_Ok(id);
        log.info("******************************" + result + "*************************************");
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeOut/{id}")
    public String PaymentInfo_timeOut(@PathVariable Integer id) {
        String result = consumer.PaymentInfo_timeOut(id);
        log.info("******************************" + result + "*************************************");
        return result;
    }
}
