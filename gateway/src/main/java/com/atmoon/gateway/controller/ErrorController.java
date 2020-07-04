package com.atmoon.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zy
 */
@RestController
public class ErrorController {

    @GetMapping("/error")
    public String error() {
        return "error";
    }

}
