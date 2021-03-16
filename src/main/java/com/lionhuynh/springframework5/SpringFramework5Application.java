package com.lionhuynh.springframework5;

import com.lionhuynh.springframework5.controller.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringFramework5Application {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SpringFramework5Application.class, args);

        System.out.println(ctx.getBean(MyController.class).sayGreeting());
    }
}
