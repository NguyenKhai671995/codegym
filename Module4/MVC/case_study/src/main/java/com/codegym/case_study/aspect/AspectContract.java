package com.codegym.case_study.aspect;

import com.codegym.case_study.service.contract.IContractDetailService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectContract {
    @Autowired
    IContractDetailService service;

    @Before("execution( * com.codegym.case_study.api_controller.ContractAPIController.deleteById(..)) && args(id))")
    public void beforeDeleteContract(Long id) {
        service.removeAllByContractId(id);
    }
}
