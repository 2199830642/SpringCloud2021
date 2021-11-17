package com.chen.springcloud.feign.impl;

import com.chen.springcloud.feign.consumer;
import org.springframework.stereotype.Component;

/**
 * @author Kaibo.Chen@hand-china.com
 * @ClassName: consumerImpl
 * @Description: TODO
 * @date 2021/11/17 15:18
 */
@Component
public class consumerImpl implements consumer {
    @Override
    public String PaymentInfo_Ok(Integer id) {
        return "----------------PaymentInfo_Ok fall back ---------------------- T-T";
    }

    @Override
    public String PaymentInfo_timeOut(Integer id) {
        return "----------------PaymentInfo_timeOut fall back ----------------------T-T";
    }
}
