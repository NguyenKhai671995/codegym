package repository.impl;

import model.MatBang;
import repository.ConnectDB;
import repository.IMatBangRepos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepos implements IMatBangRepos<MatBang> {
    private final String SELECT_ALL = "SELECT * FROM mat_bang order by dien_tich; ";
    private final String DELETE_BY_ID = "delete from mat_bang where ma_mb = ?";
    private final String ADD_NEW = "insert into mat_bang(ma_mb,dien_tich,trang_thai,tang,van_phong,gia,ngay_vao,ngay_het) values (?,?,?,?,?,?,?,?)";
    private final String UPDATE = "update mat_bang set dien_tich = ?,trang_thai = ?, tang = ?, van_phong = ?, gia = ?,ngay_vao = ?, ngay_het =? where ma_mb = ?";

    @Override
    public void add(MatBang matBang) {
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW)) {
            preparedStatement.setString(1, matBang.getMa_mb());
            preparedStatement.setInt(2, matBang.getDien_tich());
            preparedStatement.setInt(3, matBang.getTrang_thai());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setInt(5,matBang.getVan_phong());
            preparedStatement.setInt(6,matBang.getGia());
            preparedStatement.setDate(7,matBang.getNgay_vao());
            preparedStatement.setDate(8,matBang.getNgay_het());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<MatBang> findAll() {
        List<MatBang> matBangList = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ma_mb = resultSet.getString("ma_mb");
                int dien_tich = resultSet.getInt("dien_tich");
                int trang_thai = resultSet.getInt("trang_thai");
                int tang = resultSet.getInt("tang");
                int van_phong = resultSet.getInt("van_phong");
                int gia = resultSet.getInt("gia");
                Date ngay_vao = resultSet.getDate("ngay_vao");
                Date ngay_het = resultSet.getDate("ngay_het");
                MatBang matBang = new MatBang(ma_mb, dien_tich, trang_thai, tang, van_phong, gia, ngay_vao, ngay_het);
                matBangList.add(matBang);
            }
        } catch (SQLException e) {
            System.out.println("LOI");
            e.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public boolean delete(String id) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setString(1, id);
            int num = preparedStatement.executeUpdate();
            return (num == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(MatBang matBang) {
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, matBang.getDien_tich());
            preparedStatement.setInt(2, matBang.getTrang_thai());
            preparedStatement.setInt(3, matBang.getTang());
            preparedStatement.setInt(4,matBang.getVan_phong());
            preparedStatement.setInt(5,matBang.getGia());
            preparedStatement.setDate(6,matBang.getNgay_vao());
            preparedStatement.setDate(7,matBang.getNgay_het());
            preparedStatement.setString(8, matBang.getMa_mb());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<MatBang> findByName(String name) {
        return null;
    }

    @Override
    public MatBang findById(int id) {
        return null;
    }
}
