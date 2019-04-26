package com.shf.spring.kube.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author songhaifeng
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${external.services.producer-service.address}")
    private String producerService;

    @GetMapping(value = "hello/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello(@PathVariable String name) {
        final String message = String.format("hello %s", name);
        log.info(message);
        return message;
    }

    @GetMapping(value = "call/producer-service", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String call() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://" + producerService + "/hello/{name}", String.class, "consumer");
        return String.format("Get response from producer-service : \"%s\"", responseEntity.getBody());
    }
}
