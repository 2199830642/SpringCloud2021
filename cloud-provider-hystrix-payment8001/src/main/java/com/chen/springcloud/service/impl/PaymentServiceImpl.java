package com.chen.springcloud.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.chen.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

/**
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @date 2021/4/9 15:41
 * @Author xiaochen
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    // =================================== 服务降级
    @Override
    public String PaymentInfo_Ok(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_ok,id:" + id + "\t" + "哈哈啊哈哈哈哈";
    }

    @Override
    @HystrixCommand(fallbackMethod = "PaymentInfo_timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")// 这个线程的超时时间是3s
    })
    public String PaymentInfo_timeOut(Integer id) {
        // 设置自身调用超时时间的峰值，峰值内可以正常运行，超过了需要有兜底的方法做处理
        // 一旦当前方法失败，那么PaymentInfo_timeOutHandler来兜底
        try {
            TimeUnit.SECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "PaymentInfo_timeOut,id:" + id + "\t" + "哈哈啊哈哈哈哈";
    }

    @Override
    public String PaymentInfo_timeOutHandler(Integer id) {
        String str = "线程池" + Thread.currentThread().getName() + "8001系统繁忙或者运行报错，请稍后再试" + "\t" + "T-T~5555555出错了";
        System.out.println(str);
        return str;
    }

    // ============================== 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",
                    commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
                            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
                            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
                            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")}) // 失败率达到多少就跳闸
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }


    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }
}
