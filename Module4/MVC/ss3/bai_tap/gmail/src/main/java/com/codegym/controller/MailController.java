package com.codegym.controller;

import com.codegym.models.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class MailController {
    @RequestMapping("")
    public String goHome(Model model) {
        model.addAttribute("email",new Email());
        return "home";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("email") Email email, RedirectAttributes attributes){
        attributes.addFlashAttribute("message", "update Success");
        return "redirect:/";
    }
}
