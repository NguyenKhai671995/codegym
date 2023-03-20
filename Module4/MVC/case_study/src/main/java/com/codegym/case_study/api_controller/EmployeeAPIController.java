package com.codegym.case_study.api_controller;

import com.codegym.case_study.dto.customer.CustomerViewDTO;
import com.codegym.case_study.dto.employee.EmployeeViewDTO;
import com.codegym.case_study.dto.facility.FacilityViewDTO;
import com.codegym.case_study.service.employee.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
@CrossOrigin("http://localhost:4200")
public class EmployeeAPIController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public Page<EmployeeViewDTO> getListCustomer(@RequestParam(value = "nameSearch",defaultValue = "")String name) {
        return employeeService.findAllByName(name, Pageable.unpaged());
    }

}
