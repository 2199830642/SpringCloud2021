package com.chen.springcloud;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kaibo.Chen@hand-china.com
 * @ClassName: GateWayConfig
 * @Description: TODO
 * @date 2021/11/23 9:36
 */
@Configuration
public class GateWayConfig {

    /**
     * 除了yml配置网关路由之外，通过硬编码实现 配置了一个id为path_route_id的路由规则，当访问地址
     * http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     *
     * @Author kaibo.chen
     * @Date 9:53 2021/11/23
     **/
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_id", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_id2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
