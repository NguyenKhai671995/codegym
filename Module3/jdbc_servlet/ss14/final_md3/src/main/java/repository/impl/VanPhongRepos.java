package repository.impl;

import model.TrangThai;
import model.VanPhong;
import repository.ConnectDB;
import repository.IVanPhongRepos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VanPhongRepos implements IVanPhongRepos<VanPhong> {
    private String findAll = "select * from van_phong";
    @Override
    public List<VanPhong> findAll() {
        List<VanPhong> list = new ArrayList<>();
        try(Connection connection = ConnectDB.getConnectDB();
            PreparedStatement statement = connection.prepareStatement(findAll)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int ma_van_phong = resultSet.getInt("ma_van_phong");
                String loai_phong = resultSet.getString("loai_phong");
                list.add(new VanPhong(ma_van_phong,loai_phong));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
