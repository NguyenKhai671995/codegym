package reponsitory.impl;

import model.User;
import reponsitory.BaseRepository;
import reponsitory.IUserReponsitory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserReponsitory implements IUserReponsitory {
    private final String SELECT_ALL = "call sp_find_all_user();";
    private final String DELETE_BY_ID = "call sp_delete_user(?);";
    private final String UPDATE = "call sp_update_user(?,?,?,?);";
    private final String ADD_NEW = "call sp_add_user(?,?,?);";
    private final String FIND_BY_ID = "call sp_find_by_id(?);";

    @Override
    public void add(User user) {
        try (Connection connection = BaseRepository.getConnectDB();
             CallableStatement statement = connection.prepareCall(ADD_NEW)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             CallableStatement statement = connection.prepareCall(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             CallableStatement callableStatement = connection.prepareCall(DELETE_BY_ID)) {
            callableStatement.setInt(1, id);
            int num = callableStatement.executeUpdate();
            return (num == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {

        try (Connection connection = BaseRepository.getConnectDB();
             CallableStatement callableStatement = connection.prepareCall(UPDATE)) {
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            callableStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(int id) {
        try (Connection connection = BaseRepository.getConnectDB();
             CallableStatement callableStatement = connection.prepareCall(FIND_BY_ID)) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                return new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
