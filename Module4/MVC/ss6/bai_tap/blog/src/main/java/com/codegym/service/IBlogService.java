package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    Blog findById(int id);

    List<Blog> findAll();

    void save(Blog blog);

    void update(Blog blog);

    void removeById(int id);

    List<Blog> findByName(String name);
}
