package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @RequestMapping("")
    public String goHome() {
        return "home";
    }

    @RequestMapping("/find")
    public String views(@RequestParam("condiments") String[] name, Model model){
        model.addAttribute("name", Arrays.toString(name));
        return "home";
    }


}
