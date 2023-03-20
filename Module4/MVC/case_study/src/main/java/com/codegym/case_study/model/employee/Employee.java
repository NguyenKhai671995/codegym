package com.codegym.case_study.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dateOfBirth;
    private String idCard;
    private Double salary;
    private String phoneNumber;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false, referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false, referencedColumnName = "id")
    private EducationDegree educationDegree;

    @Column(name = "employee_status")
    private Boolean status;

    public Employee(Long id) {
        this.id = id;
    }


    public Employee(String str) {
        this.id = Long.parseLong(str);
    }
}
