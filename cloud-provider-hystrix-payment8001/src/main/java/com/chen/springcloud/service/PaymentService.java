package com.chen.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @date 2021/4/9 15:41
 * @Author xiaochen
 */

public interface PaymentService {
    /**
     * PaymentInfo_Ok:正常访问ok
     *
     * @Author kaibo.chen
     * @Date 10:51 2021/11/16
     **/
    public String PaymentInfo_Ok(Integer id);

    /**
     * 正常访问不ok 
     *
     * @Author kaibo.chen
     * @Date 16:32 2021/11/17
     **/
    public String PaymentInfo_timeOut(Integer id);

    /**
     * PaymentInfo_timeOutHandler 不ok的兜底
     *
     * @Author kaibo.chen
     * @Date 16:33 2021/11/17
     **/
    public String PaymentInfo_timeOutHandler(Integer id);

    /**
     * paymentCircuitBreaker --服务熔断案例
     *
     * @Author kaibo.chen
     * @Date 16:32 2021/11/17
     **/
    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
