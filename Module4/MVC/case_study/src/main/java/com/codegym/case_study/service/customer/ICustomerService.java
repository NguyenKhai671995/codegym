package com.codegym.case_study.service.customer;

import com.codegym.case_study.dto.customer.CustomerViewDTO;
import com.codegym.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<CustomerViewDTO> findAllByName(String name, Pageable pageable);

    Customer findById(Long id);

    CustomerViewDTO save(Customer customer);

    Integer updateStatusById(Long id);
}
