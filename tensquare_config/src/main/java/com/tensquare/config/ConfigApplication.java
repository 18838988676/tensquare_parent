package com.tensquare.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {
//http://localhost:12000/base-dev.yml
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
