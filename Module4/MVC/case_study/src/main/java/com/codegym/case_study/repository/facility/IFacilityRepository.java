package com.codegym.case_study.repository.facility;

import com.codegym.case_study.model.customer.Customer;
import com.codegym.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Long> {

    @Query(value = "select * from facility f where f.name  like concat('%',:name,'%') and facility_status = 1 ",
            nativeQuery = true,
            countQuery = "select count('*') from (select * from facility f where f.name like concat('%',:name,'%')  and facility_status = 1) f ")
    Page<Facility> findAllByName(@Param("name") String name, Pageable page);
    @Modifying
    @Transactional
    @Query("update Facility  f set f.status = false  where  f.id = :id")
    void updateStatusById(@Param("id") Long id);
}
