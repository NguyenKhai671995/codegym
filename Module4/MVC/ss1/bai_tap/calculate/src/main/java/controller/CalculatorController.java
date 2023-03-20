package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("")
    public String goHome() {
        return "/index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam(value = "usd",defaultValue = "0") Integer usd, Model model) {
        model.addAttribute("mess", String.format("VND: %d", usd * 23000));
        return "/index";
    }


}
