package com.lionhuynh.springframework5;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:chuck-config.xml")
public class SpringFramework5Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringFramework5Application.class, args);
        ChuckNorrisQuotes chuckNorrisQuotes = (ChuckNorrisQuotes) ctx.getBean("chuckNorrisQuotes");
        System.out.println(chuckNorrisQuotes.getRandomQuote());
    }
}
