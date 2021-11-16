package com.chen.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface consumer {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_Ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String PaymentInfo_timeOut(@PathVariable("id") Integer id);
}
