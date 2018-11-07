package com.rocketman.github.controller.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Non Secured";
    }

    @GetMapping("/private")
    public String privateArea() {
        return "Secured";
    }
}
