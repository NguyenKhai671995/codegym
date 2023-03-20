package com.codegym.case_study.repository.contract;

import com.codegym.case_study.model.contract.Contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface IContractRepository extends JpaRepository<Contract,Long> {
    @Query(value = "select * from contract t where t.start_date  like concat('%',:startDate,'%') and contract_status = 1 ",
            nativeQuery = true,
            countQuery = "select count('*') from (select * from contract t  where t.start_date like concat('%',:startDate,'%')  and contract_status = 1) t ")
    Page<Contract> findAllByName(@Param("startDate") String startDate, Pageable page);
    @Modifying
    @Transactional
    @Query("update Contract  t set t.status = false  where t.id = :id")
    Integer updateStatusById(@Param("id") Long id);
}
