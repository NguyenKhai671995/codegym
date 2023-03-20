package com.codegym.case_study.dto.employee;

import com.codegym.case_study.model.employee.Employee;
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
public class EmployeeViewDTO {

  private Long id;
  private String name;
  private Date birthday;
  private String idCard;
  private Double salary;
  private String phoneNumber;
  private String email;
  private String address;
  private String positionEmployee;
  private String education;
  private String division;

  public EmployeeViewDTO(Employee employee){
      this.id = employee.getId();
      this.name = employee.getName();
      this.birthday = employee.getDateOfBirth();
      this.idCard = employee.getIdCard();
      this.salary = employee.getSalary();
      this.phoneNumber = employee.getPhoneNumber();
      this.email = employee.getEmail();
      this.address = employee.getAddress();
      this.positionEmployee = employee.getPosition().getName();
      this.education = employee.getEducationDegree().getName();
      this.division = employee.getDivision().getName();

  }
}
