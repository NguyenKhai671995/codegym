package com.codegym.case_study.service.contract.impl;

import com.codegym.case_study.dto.contract.ContractViewDTO;

import com.codegym.case_study.model.contract.Contract;

import com.codegym.case_study.repository.contract.IContractRepository;
import com.codegym.case_study.service.contract.IContractService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository iContractRepository;
    @Override
    public Page<ContractViewDTO> findAllByName(String startDate, Pageable pageable) {
        return iContractRepository.findAllByName(startDate,pageable).map(ContractViewDTO::new);
    }

    @Override
    @SneakyThrows
    public Contract findById(Long id) {
        Optional<Contract> contract = iContractRepository.findById(id);
        if(contract.isPresent()){
            return (contract.get());
        }
        throw new Exception("");
    }

    @Override
    public ContractViewDTO save(Contract contract) {
        Contract save = iContractRepository.save(contract);
       return  new ContractViewDTO(save);
    }



    @Override
    public Integer updateStatusById(Long id) {
       return iContractRepository.updateStatusById(id);
    }
}
