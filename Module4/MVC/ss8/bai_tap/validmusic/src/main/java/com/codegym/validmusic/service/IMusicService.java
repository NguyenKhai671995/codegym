package com.codegym.validmusic.service;

import com.codegym.validmusic.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> findAllByName(String name, Pageable pageable);

    Music findById(Long id);

    void save(Music music);
}
