package com.skillforge.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testing {
    @GetMapping("/test")
    public String test(){
        return "hi";
    }
}
