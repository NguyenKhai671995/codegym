package com.codegym.case_study.service.facility.impl;

import com.codegym.case_study.model.employee.Position;
import com.codegym.case_study.model.facility.RentType;
import com.codegym.case_study.repository.facility.IRentTypeRepository;
import com.codegym.case_study.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RentTypeService implements ITypeService<RentType> {
    @Autowired
    IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @PostConstruct
    public void editData() {
        save(new RentType(1L,"hour"));
        save(new RentType(2L,"day"));
        save(new RentType(3L,"month"));
        save(new RentType(4L,"year"));
    }
}
