package com.atmoon.configclient.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问demo
 *
 * @author zy
 */
@RestController
@RequestMapping("/girl")
@RefreshScope
public class GirlController {

    @Value("${girl.hello}")
    private String hello;

    @GetMapping("/hello")
    public String hello() {
        return hello;
    }

}
