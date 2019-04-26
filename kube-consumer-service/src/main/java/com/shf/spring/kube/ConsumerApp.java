package com.shf.spring.kube;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author songhaifeng
 */
@SpringBootApplication
public class ConsumerApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsumerApp.class).web(WebApplicationType.SERVLET).build().run(args);
    }
}
