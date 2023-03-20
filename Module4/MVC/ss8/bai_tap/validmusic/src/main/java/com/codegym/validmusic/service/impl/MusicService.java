package com.codegym.validmusic.service.impl;

import com.codegym.validmusic.model.Music;
import com.codegym.validmusic.repository.IMusicRepository;
import com.codegym.validmusic.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository musicRepository;
    @Override
    public Page<Music> findAllByName(String name, Pageable pageable) {
        return musicRepository.findAllByName(name,pageable);
    }

    @Override
    public Music findById(Long id) {
        return musicRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }
}
