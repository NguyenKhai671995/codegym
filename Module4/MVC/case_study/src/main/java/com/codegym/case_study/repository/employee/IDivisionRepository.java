package com.codegym.case_study.repository.employee;

import com.codegym.case_study.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends JpaRepository<Division,Long> {


}
