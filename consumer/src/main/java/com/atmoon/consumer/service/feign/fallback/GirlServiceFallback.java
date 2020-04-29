package com.atmoon.consumer.service.feign.fallback;

import com.atmoon.consumer.service.feign.IGirlService;
import org.springframework.stereotype.Component;

@Component
public class GirlServiceFallback implements IGirlService {

    @Override
    public String hello(String name) {
        return "hello " + name + ", error";
    }
}
