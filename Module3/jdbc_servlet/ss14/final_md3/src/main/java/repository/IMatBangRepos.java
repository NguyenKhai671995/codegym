package repository;

import java.util.List;

public interface IMatBangRepos<E> {
    void add(E e);

    List<E> findAll();

    boolean delete(String id);

    boolean update(E e);

    List<E> findByName(String name);

    E findById(int id);


}
