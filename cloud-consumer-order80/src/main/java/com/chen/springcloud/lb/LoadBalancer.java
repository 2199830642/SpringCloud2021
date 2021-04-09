package com.chen.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName LoadBalancer
 * @Description TODO
 * @date 2021/4/8 16:34
 * @Author xiaochen
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
