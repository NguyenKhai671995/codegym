package com.codegym.controller;

import com.codegym.service.impl.DictionaryService;
import com.codegym.service.IDicSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {

     IDicSer iDicSer;
     @Autowired
     public DictionaryController (){
         this.iDicSer = new DictionaryService();
     }

    @RequestMapping("")
    public String goHome() {
        return "index";
    }

    @RequestMapping("/find")
    public String translate(@RequestParam String key, Model model) {
        model.addAttribute("mess", iDicSer.getValue(key));
        return "index";
    }

}
