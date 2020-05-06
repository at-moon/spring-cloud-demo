package com.atmoon.consumer.controller;


import com.atmoon.consumer.service.feign.IGirlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 访问demo
 *
 * @author zy
 */
@RestController
@RequestMapping("/girl")
public class GirlController {

    @Resource
    IGirlService girlService;

    @GetMapping("/hello")
    public String hello(String name) {
        return girlService.hello2(name);
    }

}
