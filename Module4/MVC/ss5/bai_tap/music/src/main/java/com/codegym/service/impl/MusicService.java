package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService<Music> {
    @Autowired
    private IMusicRepository<Music> iMusicRepository;

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music);
    }

    @Override
    public void removeById(int id) {
        iMusicRepository.removeById(id);
    }

    @Override
    public List<Music> findByName(String name) {
        return iMusicRepository.findByName(name);
    }
}
