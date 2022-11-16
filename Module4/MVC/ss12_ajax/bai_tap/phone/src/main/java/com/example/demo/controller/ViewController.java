package com.example.demo.controller;

import com.example.demo.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @Autowired
    IPhoneService service;

    @GetMapping("")
    public String goHome() {
        return "home";
    }
}
