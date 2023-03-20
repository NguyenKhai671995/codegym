package reponsitory;

import model.User;

import java.util.List;

public interface IUserReponsitory {
    void add(User user);

    List<User> findAll();

    boolean delete(int id);

    boolean update(User user);

    User findById(int id);
}
