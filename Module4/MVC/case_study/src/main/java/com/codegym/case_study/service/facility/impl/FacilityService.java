package com.codegym.case_study.service.facility.impl;


import com.codegym.case_study.dto.facility.FacilityViewDTO;
import com.codegym.case_study.model.facility.Facility;
import com.codegym.case_study.repository.facility.IFacilityRepository;
import com.codegym.case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository facilityRepository;
    @Override
    public Page<FacilityViewDTO> findAllByName(String name, Pageable pageable) {
        return facilityRepository.findAllByName(name,pageable).map(FacilityViewDTO::new);
    }

    @Override
    public Facility findById(Long id) {
        Optional<Facility> facility =facilityRepository.findById(id);
        return facility.orElse(null);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void updateStatusById(Long id) {
        facilityRepository.updateStatusById(id);
    }
}
