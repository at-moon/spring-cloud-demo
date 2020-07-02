package com.atmoon.consulconsumer.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 访问demo
 *
 * @author zy
 */
@FeignClient(name = "consul-producer")
public interface IHelloService {

    /**
     * 访问consul producer方法
     *
     * @return
     */
    @GetMapping("/hello")
    String hello();

}
