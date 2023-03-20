package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;


    @Override
    public Page<Blog> findAllByDate(String date, Pageable pageable) {
        return blogRepository.findAllByDate(date,pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
       return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void removeById(Long id) {
        blogRepository.deleteById(id);
    }
}
