package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private IProductService<Product> iProductService;

    @RequestMapping("")
    public String goHome(Model model) {
        model.addAttribute("list", iProductService.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("link", "/create");
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String showFormUpdate(Model model, @PathVariable Integer id) {
        model.addAttribute("product", iProductService.findBy(id));
        model.addAttribute("link", "/edit");
        return "create";
    }

    @PostMapping("/create")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create New Success");
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("message", "update Success");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        iProductService.removeById(id);
        redirectAttributes.addFlashAttribute("message", "delete Success");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchName(Model model, @RequestParam("search") String name){
        model.addAttribute("list", iProductService.findByName(name));
        return "home";
    }
}
