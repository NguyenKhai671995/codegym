package reponsitory;

import model.User;

import java.util.List;

public interface IUsersRepository {

    void add(User user);

    List<User> findAll();

    User findById(int id);

    boolean delete(int id);

    boolean update(User user);

    List<User> sortByName();

    List<User>findByCountry(String country);
}
