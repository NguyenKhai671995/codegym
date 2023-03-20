package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String greeting() {
        return "index";
    }

    @GetMapping("/greeting")
    public String helloName(@RequestParam("title") String name, Model model){
        model.addAttribute("mess",name);
        return "index";
    }



}
