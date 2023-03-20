package service.impl;

import model.User;
import reponsitory.IUsersRepository;
import reponsitory.impl.UsersReponsitory;
import service.IUsersService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersService implements IUsersService {
    private IUsersRepository usersRepository = new UsersReponsitory();

    @Override
    public Map<String, String> add(User user) {
        Map<String, String> map = new HashMap<>();
        if (map.isEmpty()) {
            usersRepository.add(user);
        }
        return map;
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return usersRepository.findById(id);
    }


    @Override
    public boolean delete(int id) {
        return usersRepository.delete(id);
    }

    @Override
    public boolean update(User user) {
        return usersRepository.update(user);
    }

    @Override
    public List<User> sortByName() {
        return usersRepository.sortByName();
    }

    @Override
    public List<User> findByCountry(String country) {
        return usersRepository.findByCountry(country);
    }
}
