package com.codegym.case_study.service.contract.impl;

import com.codegym.case_study.model.contract.AttachFacility;

import com.codegym.case_study.repository.contract.IAttachFacilityRepository;
import com.codegym.case_study.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AttachFacilityService implements ITypeService<AttachFacility> {
    @Autowired
    IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public void save(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }

    @PostConstruct
    public void editData() {
        save(new AttachFacility(1L, "Karaoke",10000D , "hour", "OK"));
        save(new AttachFacility(2L, "Tay Vin",10000D , "girl", "Not Good"));
        save(new AttachFacility(3L, "Buffet",10000D , "dish", "OK"));
        save(new AttachFacility(4L, "Plan",10000D , "plate", "OK"));

    }
}
