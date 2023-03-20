package com.codegym.case_study.api_controller;

import com.codegym.case_study.dto.customer.CustomerUpdateDTO;
import com.codegym.case_study.dto.customer.CustomerViewDTO;
import com.codegym.case_study.model.customer.Customer;
import com.codegym.case_study.service.customer.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cus")
@CrossOrigin("http://localhost:4200")
public class CustomerAPIController {
    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public Page<CustomerViewDTO> getListCustomer(@RequestParam(value = "nameSearch",defaultValue = "")String name) {
        return customerService.findAllByName(name, Pageable.unpaged());
    }

    @GetMapping("/{id}")
    public  Customer findByID(@PathVariable("id")Long id) {
        return customerService.findById(id);
    }

    @PutMapping("/{id}")
    public  CustomerViewDTO updateCustomer(@Valid @RequestBody CustomerUpdateDTO customerUpdateDTO) {
        return customerService.save(new Customer(customerUpdateDTO));
    }
    @PostMapping("")
    public CustomerViewDTO saveCustomer(@Valid @RequestBody CustomerUpdateDTO customer) {
        return customerService.save(new Customer(customer));
    }

    @DeleteMapping("/{id}")
    public Integer deleteByID(@PathVariable("id") Long id){
        return customerService.updateStatusById(id);
    }
}
