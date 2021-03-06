package com.atmoon.consulconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lenovo
 */
@SpringBootApplication
@EnableFeignClients
public class ConsulConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerApplication.class, args);
    }

}
