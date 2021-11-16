package com.chen.springcloud.service.impl;

import java.util.concurrent.TimeUnit;

import com.chen.springcloud.service.PaymentService;
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
    public String PaymentInfo_timeOut(Integer id) {
        int timeNum = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "PaymentInfo_timeOut,id:" + id + "\t" + "哈哈啊哈哈哈哈" + "耗时"
                        + timeNum + "秒钟";
    }
}
