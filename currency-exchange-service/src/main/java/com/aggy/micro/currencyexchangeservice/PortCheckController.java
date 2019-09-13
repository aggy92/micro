package com.aggy.micro.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortCheckController {

    @Autowired
    private Environment environment;

    @GetMapping("/port")
    public String getPort() {
        return environment.getProperty("server.port");
    }
}
