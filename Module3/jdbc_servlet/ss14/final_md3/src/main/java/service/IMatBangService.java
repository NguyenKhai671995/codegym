package service;

import java.util.List;
import java.util.Map;

public interface IMatBangService<E> {
    E findById(int id);

    Map<String, String> add(E e);

    boolean delete(String id);

    boolean update(E e);

    List<E> findByName(String name);

    List<E> findAll();
}
