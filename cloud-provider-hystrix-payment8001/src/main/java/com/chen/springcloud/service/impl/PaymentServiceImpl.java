package com.chen.springcloud.service.impl;

import java.util.concurrent.TimeUnit;

import com.chen.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @date 2021/4/9 15:41
 * @Author xiaochen
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String PaymentInfo_Ok(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_ok,id:" + id + "\t" + "哈哈啊哈哈哈哈";
    }

    @Override
    @HystrixCommand(fallbackMethod = "PaymentInfo_timeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")//这个线程的超时时间是3s
    })
    public String PaymentInfo_timeOut(Integer id) {
        // 设置自身调用超时时间的峰值，峰值内可以正常运行，超过了需要有兜底的方法做处理
        // 一旦当前方法失败，那么PaymentInfo_timeOutHandler来兜底
        int timeNum = 5;//这句话意思让这个接口绝对出错
        //int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "PaymentInfo_timeOut,id:" + id + "\t" + "哈哈啊哈哈哈哈" + "耗时"
                        + timeNum + "秒钟";
    }

    @Override
    public String PaymentInfo_timeOutHandler(Integer id) {
        String str = "线程池" + Thread.currentThread().getName() + "PaymentInfo_timeOutHandler,id:" + id + "\t" + "T-T~5555555出错了";
        System.out.println(str);
        return str;
    }
}
