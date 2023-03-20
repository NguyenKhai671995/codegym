package com.codegym.case_study.controller;

import com.codegym.case_study.model.employee.Division;
import com.codegym.case_study.model.employee.EducationDegree;
import com.codegym.case_study.model.employee.Employee;
import com.codegym.case_study.model.employee.Position;
import com.codegym.case_study.service.employee.IEmployeeService;
import com.codegym.case_study.service.ITypeService;
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
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ITypeService<Division>divisionService;
    @Autowired
    ITypeService<EducationDegree>educationService;
    @Autowired
    ITypeService<Position>positionService;

    private void transferData(Model model){
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("educations", educationService.findAll());
        model.addAttribute("positions", positionService.findAll());
    }

    @GetMapping("")
    public String goHome(Model model, @RequestParam(value = "name", defaultValue = "") String name,
                         @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("list", employeeService.findAllByName(name, pageable));
        return "/employee/home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        transferData(model);
        return "/employee/update";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        transferData(model);
        return "/employee/update";
    }

    @PostMapping("/update")
    public String updateDB(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
          transferData(model);
            return "/employee/update";
        }

        if (employee.getId() == null) {
            employee.setStatus(true);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "create ok");
        } else {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "edit ok");
        }
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String updateById( @RequestParam("id") Long id, RedirectAttributes attributes){
        Employee employee =  employeeService.findById(id);
        employee.setStatus(false);
        employeeService.save(employee);
        attributes.addFlashAttribute("message", "Delete ok");
        return "redirect:/employee";
    }
}
