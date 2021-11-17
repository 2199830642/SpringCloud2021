package com.chen.springcloud.controller;

import javax.annotation.Resource;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "payment_global_fallback")
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
    /*@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @HystrixCommand //这个注解的意思加了说明该方法涉及服务降级，且走的fallback是全局配置
    public String PaymentInfo_timeOut(@PathVariable("id") Integer id) {
        // int age = 10/0;
        String result = consumer.PaymentInfo_timeOut(id);
        log.info("******************************" + result + "*************************************");
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "对方支付系统繁忙，请10s后再试或检查自己，T-T~";
    }

    // 每一个都要配置一个fallback 代码太膨胀，全局的兜底方法
    public String payment_global_fallback(){
        return "Global异常信息处理，请稍后重试，T-T~";
    }
}
