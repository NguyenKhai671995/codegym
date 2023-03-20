package com.codegym.case_study.controller;

import com.codegym.case_study.model.contract.AttachFacility;

import com.codegym.case_study.service.ITypeService;
import com.codegym.case_study.service.contract.IContractDetailService;
import com.codegym.case_study.service.contract.IContractService;
import com.codegym.case_study.service.customer.ICustomerService;
import com.codegym.case_study.service.employee.IEmployeeService;
import com.codegym.case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ITypeService<AttachFacility> attachFacilityService;

    @Autowired
    IContractDetailService contractDetailService;

    @Autowired
    IContractService contractService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IFacilityService facilityService;

    public void transferData(Model model) {
        model.addAttribute("employeeList", employeeService.findAllByName("", Pageable.unpaged()));
        model.addAttribute("customerList", customerService.findAllByName("", Pageable.unpaged()));
        model.addAttribute("facilityList", facilityService.findAllByName("", Pageable.unpaged()));
        model.addAttribute("attachList", attachFacilityService.findAll());
    }

    @GetMapping("")
    public String goHome(Model model, @RequestParam(value = "startDate", defaultValue = "") String startDate,
                         @PageableDefault(size = 5, sort = "start_date", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("list", contractService.findAllByName(startDate, Pageable.unpaged()));
        transferData(model);
        return "/contract/home";
    }


//    @GetMapping("/create")
//    public String showCreateForm(Model model) {
//        model.addAttribute("contract", new Contract());
//        transferData(model);
//        return "/contract/update";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable Long id, Model model) {
//        model.addAttribute("contract", contractService.findById(id));
//        transferData(model);
//        return "/contract/update";
//    }
//
//    @PostMapping("/update")
//    public String updateDB(@Valid @ModelAttribute("contract") Contract contract, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
//        if (result.hasErrors()) {
//            transferData(model);
//            return "/contract/update";
//        }
//
//        if (contract.getId() == null) {
//            contract.setStatus(true);
//            contractService.save(contract);
//            redirectAttributes.addFlashAttribute("message", "create ok");
//        } else {
//            contractService.save(contract);
//            redirectAttributes.addFlashAttribute("message", "edit ok");
//        }
//        return "redirect:/contract";
//    }
//
//    @PostMapping("/delete")
//    public String updateById( @RequestParam("id") Long id, RedirectAttributes attributes){
//        Contract contract =  contractService.findById(id);
//        contract.setStatus(false);
//        contractService.save(contract);
//        attributes.addFlashAttribute("message", "Delete ok");
//        return "redirect:/contract";
//    }
}
