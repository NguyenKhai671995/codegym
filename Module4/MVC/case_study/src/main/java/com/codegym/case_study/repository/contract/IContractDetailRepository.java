package com.codegym.case_study.repository.contract;

import com.codegym.case_study.model.contract.Contract;
import com.codegym.case_study.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
    List<ContractDetail> findAllByContractId(Long id);

    void removeAllByContractId(Long id);

}
