package com.chen.springcloud.controller;

import com.chen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Kaibo.Chen@hand-china.com
 * @ClassName: paymentController
 * @Description: TODO
 * @date 2021/11/16 10:56
 */
@RestController
@Slf4j
public class paymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_Ok(@PathVariable Integer id){
        String result = paymentService.PaymentInfo_Ok(id);
        log.info("******result"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String PaymentInfo_timeOut(@PathVariable Integer id){
        String result = paymentService.PaymentInfo_timeOut(id);
        log.info("******result"+result);
        return result;
    }

    // ==================== 服务熔断
    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("******result"+result);
        return result;
    }
}
