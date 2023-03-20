package com.codegym.case_study.model.customer;

import com.codegym.case_study.dto.contract.ContractViewDTO;
import com.codegym.case_study.dto.customer.CustomerUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_type_id",nullable = false,referencedColumnName = "id")
    private CustomerType customerType;


    @Column(name = "name",columnDefinition = "varchar(45)")
    @NotBlank(message = "name not null")
    private String name;

    @Column(name = "date_of_birth")
    private Date birthday;

    @Column(name = "gender")
    private String gender;

    @Column(name = "id_card",columnDefinition = "varchar(45)")

    private String idCard;

     @Column(name = "phone_number",columnDefinition = "varchar(45)")
    private String phone;

    @Column(name = "email",columnDefinition = "varchar(45)")
    private String email;

    @Column(name = "address",columnDefinition = "varchar(45)")
    private String address;

    @Column(name = "customer_status")
    private String status;

    public Customer(Long id){
        this.id = id;
    }

    public Customer(CustomerUpdateDTO customerUpdateDTO){
        this.customerType = new CustomerType(customerUpdateDTO.getCustomerType());
        this.id = customerUpdateDTO.getId();
        this.name = customerUpdateDTO.getName();
        this.birthday = customerUpdateDTO.getBirthday();
        this.gender = customerUpdateDTO.getGender();
        this.idCard = customerUpdateDTO.getIdCard();
        this.phone = customerUpdateDTO.getPhone();
        this.email = customerUpdateDTO.getEmail();
        this.address = customerUpdateDTO.getAddress();
        this.status = customerUpdateDTO.getStatus();
    }

    public Customer(String str) {
        this.id = Long.parseLong(str);
    }


    public Customer(ContractViewDTO contractViewDTO) {
    }
}
