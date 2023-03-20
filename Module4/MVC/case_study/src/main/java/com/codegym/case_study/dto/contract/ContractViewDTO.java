package com.codegym.case_study.dto.contract;

import com.codegym.case_study.model.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;
@Component
@AllArgsConstructor @NoArgsConstructor @Getter
 @Setter
public class ContractViewDTO implements Serializable {
    Long id;
    Date startDate;
    Date endDate;
    Double deposit;
    String facility;
    String customer;
    String employee;

    public ContractViewDTO (Contract contract){
        this.id= contract.getId();
        this.startDate = contract.getStartDate();
        this.endDate = contract.getEndDate();
        this.deposit = contract.getDeposit();
        this.facility =contract.getFacility().getName();
        this.employee = contract.getEmployee().getName();
        this.customer = contract.getCustomer().getName();
    }
}
