package com.atmoon.consumer.service.feign;

import com.atmoon.consumer.service.feign.fallback.GirlServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 访问demo
 *
 * @author zy
 */
@FeignClient(name = "demo", path = "/girl", fallback = GirlServiceFallback.class)
public interface IGirlService {

    @GetMapping("/hello")
    String hello(@RequestParam(value = "name") String name);

}
