package com.codegym.service;

import java.util.List;

public interface IMusicService<E> {
    E findById(int id);

    List<E> findAll();

    void save(E e);

    void update(E e);

    void removeById(int id);

    List<E> findByName(String name);
}
