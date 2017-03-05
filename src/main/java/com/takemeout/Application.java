package com.takemeout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.takemeout.util.SessionUtil;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SessionUtil.getSessionFactory();
        SpringApplication.run(Application.class, args);
    }
}
