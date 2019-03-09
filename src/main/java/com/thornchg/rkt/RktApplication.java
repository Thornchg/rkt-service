package com.thornchg.rkt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.thornchg.rkt.mapper")
public class RktApplication {

    public static void main(String[] args) {
        SpringApplication.run(RktApplication.class, args);
    }

}

