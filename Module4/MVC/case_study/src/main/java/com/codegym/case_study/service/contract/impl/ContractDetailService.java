package com.codegym.case_study.service.contract.impl;
import com.codegym.case_study.model.contract.ContractDetail;
import com.codegym.case_study.repository.contract.IContractDetailRepository;

import com.codegym.case_study.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAllByContractId(Long id) {
        return contractDetailRepository.findAllByContractId(id);
    }

    @Override
    public void removeAllByContractId(Long id) {
       contractDetailRepository.removeAllByContractId(id);
    }


}

