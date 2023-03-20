package com.codegym.case_study.repository.customer;

import com.codegym.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer c where c.name  like concat('%',:name,'%') and customer_status <> '0' ",
            nativeQuery = true,
            countQuery = "select count('*') from (select * from customer c where c.name like concat('%',:name,'%')  and customer_status = 1) c ")
    Page<Customer> findAllByName(@Param("name") String name, Pageable page);
    @Modifying
    @Transactional
    @Query("update Customer  c set c.status = '0'  where  c.id = :id")
    Integer updateStatusById(@Param("id") Long id);
}
