package repository.impl;

import model.TrangThai;
import repository.ConnectDB;
import repository.ITrangThaiRepos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrangThaiRepos implements ITrangThaiRepos<TrangThai> {
    private String findAll = "select * from trang_thai";
    @Override
    public List<TrangThai> findAll() {
        List<TrangThai> list = new ArrayList<>();
        try(Connection connection = ConnectDB.getConnectDB();
            PreparedStatement statement = connection.prepareStatement(findAll)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int ma_trang_thai = resultSet.getInt("ma_trang_thai");
                String ten_tran_thai = resultSet.getString("ten_tran_thai");
                list.add(new TrangThai(ma_trang_thai,ten_tran_thai));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
