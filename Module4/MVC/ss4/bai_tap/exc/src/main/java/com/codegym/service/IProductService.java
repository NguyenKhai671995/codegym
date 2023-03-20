package com.codegym.service;


import java.util.List;

public interface IProductService<E> {
    E findBy(int id);

    List<E> findAll();

    void save(E e);

    void remove(E e);

    void update(E e);

    void removeById(int id);

    List<E> findByName(String name);
}
