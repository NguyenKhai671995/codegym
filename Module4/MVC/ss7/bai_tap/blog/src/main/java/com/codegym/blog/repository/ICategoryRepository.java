package com.codegym.blog.repository;

import com.codegym.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
    List<Category>findAll();
}
