package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query("update blog b set b.content = ?1, b.title = ?2 , b.date = ?3 where b.id = ?4")
    void update(String content, String title, Date date, Integer id);

    List<Blog>findAllByTitleContaining(String title);
}
