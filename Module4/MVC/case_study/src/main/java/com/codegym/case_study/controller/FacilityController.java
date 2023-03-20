package com.codegym.case_study.controller;
import com.codegym.case_study.model.facility.Facility;
import com.codegym.case_study.model.facility.FacilityType;
import com.codegym.case_study.model.facility.RentType;
import com.codegym.case_study.service.ITypeService;
import com.codegym.case_study.service.facility.IFacilityService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    ITypeService<RentType> rentTypeService;
    @Autowired
    ITypeService<FacilityType>facilityTypeService;
    @Autowired
    IFacilityService facilityService;

    private void transferData(Model model){
        model.addAttribute("renList",rentTypeService.findAll());
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
    }

    @GetMapping("")
    public String goHome(Model model, @RequestParam(value = "name", defaultValue = "") String name,
                         @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("list", facilityService.findAllByName(name, pageable));
        return "/facility/home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("facility", new Facility());
        transferData(model);
        return "/facility/update";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("facility", facilityService.findById(id));
        transferData(model);
        return "/facility/update";
    }
    @PostMapping("/update")
    public String updateDB(@Valid @ModelAttribute("facility") Facility facility, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            transferData(model);
            return "/facility/update";
        }

        if (facility.getId() == null) {
            facility.setStatus(true);
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "create ok");
        } else {
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "edit ok");
        }
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String updateById( @RequestParam("id") Long id, RedirectAttributes attributes){
        Facility facility =  facilityService.findById(id);
        facility.setStatus(false);
        facilityService.save(facility);
        attributes.addFlashAttribute("message", "Delete ok");
        return "redirect:/facility";
    }
}
