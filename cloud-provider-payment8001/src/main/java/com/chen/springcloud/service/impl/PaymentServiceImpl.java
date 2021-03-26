package com.chen.springcloud.service.impl;

import com.chen.springcloud.dao.PaymentDao;
import com.chen.springcloud.entities.Payment;
import com.chen.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        System.out.println(1);
        return paymentDao.getPaymentById(id);
    }
}
