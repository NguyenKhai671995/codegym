package com.codegym.case_study.dto.customer;

import com.codegym.case_study.model.customer.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.sql.Date;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerViewDTO implements Serializable {
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

    public CustomerViewDTO (Customer customer){
        this.id = customer.getId();
        this.customerType = customer.getCustomerType().getName();
        this.name = customer.getName();
        this.birthday = customer.getBirthday();
        this.gender = customer.getGender();
        this.idCard = customer.getIdCard();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
        this.status = customer.getStatus();
    }
}
