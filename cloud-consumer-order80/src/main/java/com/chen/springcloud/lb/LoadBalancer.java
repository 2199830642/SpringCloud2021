package com.chen.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName LoadBalancer
 * @Description TODO
 * @date 2021/4/8 16:34
 * @Author xiaochen
 */
@Component
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
