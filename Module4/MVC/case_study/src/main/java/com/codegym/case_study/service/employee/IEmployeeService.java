package com.codegym.case_study.service.employee;


import com.codegym.case_study.dto.employee.EmployeeViewDTO;
import com.codegym.case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<EmployeeViewDTO> findAllByName(String name, Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void updateStatusById(Long id);

}
