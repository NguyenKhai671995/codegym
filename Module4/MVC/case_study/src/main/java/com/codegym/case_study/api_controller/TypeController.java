package com.codegym.case_study.api_controller;

import com.codegym.case_study.model.customer.CustomerType;
import com.codegym.case_study.service.customer.impl.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin("http://localhost:4200")
public class TypeController {
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping("/cusType")
    public ResponseEntity<List<CustomerType>> getListTypeCustomer(){
        return new ResponseEntity<>(customerTypeService.findAll(), HttpStatus.OK);
    }
}
