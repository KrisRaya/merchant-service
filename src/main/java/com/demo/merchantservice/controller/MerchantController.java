package com.demo.merchantservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
