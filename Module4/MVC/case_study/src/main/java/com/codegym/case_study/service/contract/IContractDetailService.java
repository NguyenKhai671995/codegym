package com.codegym.case_study.service.contract;

import com.codegym.case_study.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();
    void save (ContractDetail contractDetail);
    List<ContractDetail> findAllByContractId(Long id);
   void removeAllByContractId(Long id);


}
