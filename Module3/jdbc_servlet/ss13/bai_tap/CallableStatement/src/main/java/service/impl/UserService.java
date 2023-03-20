package service.impl;

import model.User;
import reponsitory.IUserReponsitory;
import reponsitory.impl.UserReponsitory;
import service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements IUserService {
    private IUserReponsitory userReponsitory = new UserReponsitory();

    @Override
    public Map<String, String> add(User user) {
        Map<String, String> map = new HashMap<>();
        if (map.isEmpty()) {
            userReponsitory.add(user);
        }
        return map;
    }

    @Override
    public List<User> findAll() {
        return userReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        return userReponsitory.delete(id);
    }

    @Override
    public boolean update(User user) {
        return userReponsitory.update(user);
    }

    @Override
    public User findById(int id) {
        return userReponsitory.findById(id);
    }
}
