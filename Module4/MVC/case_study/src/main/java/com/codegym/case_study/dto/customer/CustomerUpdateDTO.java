package com.codegym.case_study.dto.customer;

import com.codegym.case_study.model.customer.Customer;
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
public class CustomerUpdateDTO {
    private Long id;
    private String customerType;
    private String name;
    private Date birthday;
    private String gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;
    private String status;
}
