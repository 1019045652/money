package com.an.an_be;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.an.an_be.mapper")
public class AnBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnBeApplication.class, args);
    }

}
