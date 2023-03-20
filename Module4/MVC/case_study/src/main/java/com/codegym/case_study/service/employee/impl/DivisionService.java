package com.codegym.case_study.service.employee.impl;

import com.codegym.case_study.model.employee.Division;
import com.codegym.case_study.repository.employee.IDivisionRepository;
import com.codegym.case_study.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class DivisionService implements ITypeService<Division> {
    @Autowired
    IDivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @PostConstruct
    public void editData() {
        save(new Division(1L,"Sale-Marketing"));
        save(new Division(2L,"Service"));
        save(new Division(3L,"Manager"));
        save(new Division(4L,"Administration"));
    }
}
