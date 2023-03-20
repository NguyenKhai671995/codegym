package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.update(blog.getContent(), blog.getTitle(),blog.getDate(), blog.getId());
    }

    @Override
    public void removeById(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByName(String name) {
        return iBlogRepository.findAllByTitleContaining(name);
    }
}
