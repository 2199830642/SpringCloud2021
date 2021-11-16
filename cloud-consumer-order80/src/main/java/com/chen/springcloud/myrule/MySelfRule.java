package com.chen.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName mySelfRule
 * @Description TODO
 * @date 2021/4/7 16:19
 * @Author xiaochen
 */
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
        //定义为随机
        return new RandomRule();
    }
}
