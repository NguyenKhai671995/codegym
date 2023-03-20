package com.codegym.case_study.service.customer;


import com.codegym.case_study.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType>findAll();

    void save(CustomerType type);
}
