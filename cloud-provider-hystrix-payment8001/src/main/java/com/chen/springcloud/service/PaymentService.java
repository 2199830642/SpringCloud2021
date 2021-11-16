package com.chen.springcloud.service;

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

    public String PaymentInfo_timeOut(Integer id);

    public String PaymentInfo_timeOutHandler(Integer id);
}
