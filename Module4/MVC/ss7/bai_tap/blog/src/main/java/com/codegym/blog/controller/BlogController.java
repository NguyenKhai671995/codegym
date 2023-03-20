package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String goHome(Model model, @RequestParam(value = "date", defaultValue = "") String date,
                         @PageableDefault(size = 5, sort = "create_day", direction = Sort.Direction.ASC)
                                 Pageable pageable) {
        model.addAttribute("list", blogService.findAllByDate(date, pageable));
        return "home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("list", categoryService.findAll());
        return "update";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable Long id) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("list", categoryService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String updateDB(@Valid @PathVariable("Blog") Blog blog, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", categoryService.findAll());
            return "/update";
        }
        blogService.save(blog);
        if (blog.getId() == null) {
            redirectAttributes.addFlashAttribute("message", "create ok");
        } else {
            redirectAttributes.addFlashAttribute("message", "edit ok");
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        blogService.removeById(id);
        redirectAttributes.addFlashAttribute("message", "delete ok");
        return "redirect:/";
    }
}
