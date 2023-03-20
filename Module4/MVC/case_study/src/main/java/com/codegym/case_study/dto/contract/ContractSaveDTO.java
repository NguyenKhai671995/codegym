package com.codegym.case_study.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractSaveDTO {
    Long id;
    Date dateIn;
    Date dateOut;
    Double deposit;
    String facility;
    String customer;
    String employee;

}
