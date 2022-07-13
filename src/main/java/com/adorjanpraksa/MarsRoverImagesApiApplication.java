package com.adorjanpraksa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MarsRoverImagesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsRoverImagesApiApplication.class, args);
    }

}
