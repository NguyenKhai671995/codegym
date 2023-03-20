package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    @Query(value = "select * from blog b where create_day like concat('%',:date,'%')", nativeQuery = true,
    countQuery = "select count('*') from blog b where (select * from b where create_day like concat('%',:date,'%'))")
    Page<Blog>findAllByDate(@Param("date") String date, Pageable page);

}
