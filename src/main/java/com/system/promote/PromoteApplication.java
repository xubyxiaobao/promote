package com.system.promote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.systm.promote.dao")
public class PromoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PromoteApplication.class, args);
    }

}
