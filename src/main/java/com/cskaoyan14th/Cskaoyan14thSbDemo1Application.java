package com.cskaoyan14th;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.cskaoyan14th.mapper")
public class Cskaoyan14thSbDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Cskaoyan14thSbDemo1Application.class, args);
    }

}
