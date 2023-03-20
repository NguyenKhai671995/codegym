package com.codegym.validmusic.service.impl;

import com.codegym.validmusic.model.Category;
import com.codegym.validmusic.repository.ICategoryRepository;
import com.codegym.validmusic.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @PostConstruct
    private void getData(){
        categoryRepository.save(new Category(1L,"comedy"));
        categoryRepository.save(new Category(2L,"korea"));
        categoryRepository.save(new Category(3L,"japan"));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }





}
