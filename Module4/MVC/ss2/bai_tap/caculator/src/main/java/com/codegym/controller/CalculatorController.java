package com.codegym.controller;

import com.codegym.sevice.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculator iCalculator;
    @GetMapping("/")
    public String goHome(){
        return "/index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam Double num1, Double num2, String calculator, Model model){

        model.addAttribute("result", iCalculator.getvalue(num1,num2,calculator));
        return "/index";
    }

}
