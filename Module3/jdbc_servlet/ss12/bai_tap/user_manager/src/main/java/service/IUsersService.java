package service;

import model.User;

import java.util.List;
import java.util.Map;

public interface IUsersService {
    Map<String, String> add(User user);

    List<User> findAll();

    User findById(int id);

    boolean delete(int id);

    boolean update(User user);

    List<User> sortByName();

    List<User>findByCountry(String country);
}
