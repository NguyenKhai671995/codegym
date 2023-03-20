package com.codegym.case_study.service.employee.impl;


import com.codegym.case_study.model.employee.EducationDegree;
import com.codegym.case_study.repository.employee.IEducationDegreeRepository;
import com.codegym.case_study.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class EducationDegreeService implements ITypeService<EducationDegree> {
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
       educationDegreeRepository.save(educationDegree);
    }

    @PostConstruct
    public void editData() {
        save(new EducationDegree(1L,"Undergraduate"));
        save(new EducationDegree(2L,"University"));
        save(new EducationDegree(3L,"College"));
        save(new EducationDegree(4L,"Intermediate"));
    }
}
