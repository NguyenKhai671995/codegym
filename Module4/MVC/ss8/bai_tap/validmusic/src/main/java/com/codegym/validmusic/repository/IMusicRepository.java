package com.codegym.validmusic.repository;

import com.codegym.validmusic.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music,Long> {
    @Query(value = "select * from Music m where m.name like concat('%',:name,'%') ",
            nativeQuery = true ,
            countQuery = "select count('*') from (select * from Music m where m.name like concat('%',:name,'%')) m ")
    Page<Music> findAllByName(@Param("name")String name, Pageable page);
}
