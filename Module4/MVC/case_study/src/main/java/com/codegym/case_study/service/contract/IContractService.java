package com.codegym.case_study.service.contract;

import com.codegym.case_study.dto.contract.ContractViewDTO;
import com.codegym.case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<ContractViewDTO> findAllByName(String startDate, Pageable pageable);

    Contract findById(Long id);

    ContractViewDTO save(Contract contract);

    Integer updateStatusById(Long id);


}
