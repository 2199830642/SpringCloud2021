package com.chen.springcloud.filiter;

import java.util.Date;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author Kaibo.Chen@hand-china.com
 * @ClassName: MtLogGateWayFiliter
 * @Description: TODO
 * @date 2021/11/23 11:25
 */
@Configuration
@Slf4j
public class MtLogGateWayFiliter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**************************************欢迎来到全局过滤器  MtLogGateWayFiliter:" + new Date()+"*******************************");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null){
            log.info("*******非法用户*****");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 这个0代表加载过滤器的顺序，一般这个数字越小，优先级越高
        return 0;
    }
}
