package com.xinghua24.bookmarkbe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @Value("${root.url")
    private String rootUrl;

    @GetMapping("/login")
    public String loginToRoot() {
        return "redirect:" + rootUrl;
    }
}
