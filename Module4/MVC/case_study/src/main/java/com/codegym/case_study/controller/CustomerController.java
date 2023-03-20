package com.codegym.case_study.controller;

import com.codegym.case_study.model.customer.Customer;
import com.codegym.case_study.service.customer.ICustomerService;
import com.codegym.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String goHome(Model model, @RequestParam(value = "name", defaultValue = "") String name,
                         @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("list", customerService.findAllByName(name, pageable));
        return "/customer/home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("list", customerTypeService.findAll());
        return "/customer/update";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("list", customerTypeService.findAll());
        return "/customer/update";
    }

    @PostMapping("/update")
    public String updateDB(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", customerTypeService.findAll());
            return "/customer/update";
        }

        if (customer.getId() == null) {
            customer.setStatus("1");
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "create ok");
        } else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "edit ok");
        }
        return "redirect:/customer";
    }

//    @PostMapping("/delete")
//    public String updateById( @RequestParam("id") Long id, RedirectAttributes attributes){
//       Customer customer =  customerService.findById(id);
//       customer.setStatus(false);
//        customerService.save(customer);
//        attributes.addFlashAttribute("message", "Delete ok");
//        return "redirect:/customer";
//    }
}
