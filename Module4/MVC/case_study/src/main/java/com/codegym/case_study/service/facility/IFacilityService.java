package com.codegym.case_study.service.facility;


import com.codegym.case_study.dto.facility.FacilityViewDTO;
import com.codegym.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<FacilityViewDTO> findAllByName(String name, Pageable pageable);

    Facility findById(Long id);

    void save(Facility facility);

    void updateStatusById(Long id);
}
