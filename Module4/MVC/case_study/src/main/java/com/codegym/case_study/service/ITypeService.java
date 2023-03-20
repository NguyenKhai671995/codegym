package com.codegym.case_study.service;

import java.util.List;

public interface ITypeService<E> {
    List<E>findAll();
    void save (E e);
}
