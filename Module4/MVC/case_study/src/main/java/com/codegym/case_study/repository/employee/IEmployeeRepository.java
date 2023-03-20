package com.codegym.case_study.repository.employee;

import com.codegym.case_study.model.customer.Customer;
import com.codegym.case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select * from employee e where e.name  like concat('%',:name,'%') and employee_status = 1 ",
            nativeQuery = true,
            countQuery = "select count('*') from (select * from employee e where e.name like concat('%',:name,'%')  and employee_status = 1) e ")
    Page<Employee> findAllByName(@Param("name") String name, Pageable page);
    @Modifying
    @Transactional
    @Query("update Employee  e set e.status = false  where  e.id = :id")
    void updateStatusById(@Param("id") Long id);

}
