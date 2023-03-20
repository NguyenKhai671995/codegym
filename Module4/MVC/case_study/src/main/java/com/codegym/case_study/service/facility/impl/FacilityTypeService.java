package com.codegym.case_study.service.facility.impl;

import com.codegym.case_study.model.facility.FacilityType;
import com.codegym.case_study.repository.facility.IFacilityTypeRepository;
import com.codegym.case_study.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class FacilityTypeService  implements ITypeService<FacilityType> {
    @Autowired
    IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public void save(FacilityType facilityType) {
        facilityTypeRepository.save(facilityType);
    }

    @PostConstruct
    public void getData(){
        save(new FacilityType(1L,"Vip"));
        save(new FacilityType(2L,"normal"));
        save(new FacilityType(3L,"corn"));
    }
}
