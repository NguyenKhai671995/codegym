package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@CrossOrigin("/*")
@RequestMapping("")
public class BlogController {

    @Autowired
    private IBlogService IBlogService;

    @RequestMapping("")
    public String goHome(Model model){
        model.addAttribute("list",IBlogService.findAll());
        return "home";
    }


    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog() );
        model.addAttribute("link","/create");
        return "form";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        IBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create New Success");
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String showUpdate(Model model, @PathVariable Integer id){
        model.addAttribute("blog",IBlogService.findById(id));
        model.addAttribute("link","/edit");
        return "form";
    }

    @PostMapping("/edit")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        IBlogService.update(blog);
        redirectAttributes.addFlashAttribute("message", "update Success");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,RedirectAttributes attributes){
        IBlogService.removeById(id);
        attributes.addFlashAttribute("message","delete Success");
        return "redirect:/";
    }
    @GetMapping("search")
    public String searchName(Model model, @RequestParam("search") String name){
        model.addAttribute("list", IBlogService.findByName(name));
        return "home";
    }
}
