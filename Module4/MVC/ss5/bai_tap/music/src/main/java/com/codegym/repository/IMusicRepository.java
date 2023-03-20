package com.codegym.repository;

import java.util.List;

public interface IMusicRepository<E> {
    E findById(int id);

    List<E> findAll();

    void save(E e);

    void update(E e);

    void removeById(int id);

    List<E> findByName(String name);
}
