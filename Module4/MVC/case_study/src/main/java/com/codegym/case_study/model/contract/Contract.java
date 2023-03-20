package com.codegym.case_study.model.contract;


import com.codegym.case_study.dto.contract.ContractViewDTO;
import com.codegym.case_study.model.customer.Customer;
import com.codegym.case_study.model.employee.Employee;
import com.codegym.case_study.model.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    @NotNull
    private Date endDate;

    @Min(0)
    @NotNull
    private Double deposit;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false, referencedColumnName = "id")
    private Facility facility;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private Employee employee;

    @Column(name = "contract_status")

    private Boolean status;

    public Contract(ContractViewDTO contractViewDTO){
        this.id = contractViewDTO.getId();
        this.startDate = contractViewDTO.getStartDate();
        this.endDate = contractViewDTO.getEndDate();
        this.deposit = contractViewDTO.getDeposit();
        this.customer = new Customer(contractViewDTO.getCustomer());
        this.facility = new Facility(contractViewDTO.getFacility());
        this.employee = new Employee(contractViewDTO.getEmployee());
        this.status = true;
    }
}
