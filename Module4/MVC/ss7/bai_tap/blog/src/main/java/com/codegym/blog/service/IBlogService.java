package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IBlogService {
    Page<Blog> findAllByDate(String date, Pageable pageable);

    void save(Blog blog);

    Blog findById(Long id);

    void removeById(Long id);
}
