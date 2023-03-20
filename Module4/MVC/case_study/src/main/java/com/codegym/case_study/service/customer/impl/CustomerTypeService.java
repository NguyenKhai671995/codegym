package com.codegym.case_study.service.customer.impl;

import com.codegym.case_study.model.customer.CustomerType;
import com.codegym.case_study.repository.customer.ICustomerTypeRepository;
import com.codegym.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType type) {
        customerTypeRepository.save(type);
    }

    @PostConstruct
    public void editData(){
        save(new CustomerType(1L,"Diamond"));
        save(new CustomerType(2L,"Platinum"));
        save(new CustomerType(3L,"Gold"));
        save(new CustomerType(4L,"Silver"));
        save(new CustomerType(5L,"Member"));
    }
}
