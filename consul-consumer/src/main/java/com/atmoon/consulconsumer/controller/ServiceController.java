package com.atmoon.consulconsumer.controller;

import com.atmoon.consulconsumer.service.feign.IHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author : zy
 */
@RestController
public class ServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    @Resource
    private LoadBalancerClient balancerClient;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private IHelloService helloService;

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("consul-producer");
    }

    /**
     * 从所有服务中选择一个服务（轮询）
     */
    @RequestMapping("/discover")
    public Object discover() {
        return balancerClient.choose("consul-producer").getUri().toString();
    }

    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = balancerClient.choose("consul-producer");
        logger.info("服务地址: {}", serviceInstance.getUri());
        logger.info("服务名称: {}", serviceInstance.getServiceId());

        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        logger.info(callServiceResult);
        return callServiceResult;
    }

    @RequestMapping("/call1")
    public String call1() {
        return helloService.hello();
    }

}
