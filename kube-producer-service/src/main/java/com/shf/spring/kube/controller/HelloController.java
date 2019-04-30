package com.shf.spring.kube.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author songhaifeng
 */
@RestController
@Slf4j
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping(value = "{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello(@PathVariable String name) throws UnknownHostException {
        final String message = String.format("hello %s, I am %s(hostname)", name, InetAddress.getLocalHost().getHostName());
        log.info(message);
        return message;
    }
}
