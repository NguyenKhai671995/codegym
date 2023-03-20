package com.codegym.case_study.service.employee.impl;

import com.codegym.case_study.model.employee.Position;
import com.codegym.case_study.repository.employee.IPositionRepository;
import com.codegym.case_study.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PositionService implements ITypeService<Position> {
    @Autowired
    IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }
    @PostConstruct
    public void editData() {
        save(new Position(1L,"Receptionist"));
        save(new Position(2L,"Service"));
        save(new Position(3L,"expert"));
        save(new Position(4L,"monitoring"));
        save(new Position(5L,"manager"));
        save(new Position(6L,"president"));
    }
}
