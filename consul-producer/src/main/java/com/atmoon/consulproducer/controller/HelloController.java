package com.atmoon.consulproducer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zy
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello consul two";
    }

}
