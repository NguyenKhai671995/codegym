package com.codegym.case_study.service.customer.impl;

import com.codegym.case_study.dto.customer.CustomerViewDTO;
import com.codegym.case_study.model.customer.Customer;
import com.codegym.case_study.repository.customer.ICustomerRepository;
import com.codegym.case_study.service.customer.ICustomerService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;


    @Override
    public Page<CustomerViewDTO> findAllByName(String name, Pageable pageable) {
        return customerRepository.findAllByName(name,pageable).map(CustomerViewDTO::new);
    }

    @Override
    @SneakyThrows
    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return (customer.get());
        }
        throw new Exception("");
    }

    @Override
    public CustomerViewDTO save(Customer customer) {
        Customer save = customerRepository.save(customer);
       return new CustomerViewDTO(save) ;
    }

    @Override
    public Integer updateStatusById(Long id) {
       return customerRepository.updateStatusById(id);
    }

}
