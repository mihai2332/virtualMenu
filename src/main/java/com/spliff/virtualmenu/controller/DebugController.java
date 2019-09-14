package com.spliff.virtualmenu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/debug")
public class DebugController {
    @GetMapping(value = {"","/"})
    public String getString() {
        return "hello world";
    }
}
