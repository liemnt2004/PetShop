/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Daos;

import com.app.Entitys.Chuong;
import com.app.Entitys.QuenMatKhau;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MY LINH
 */
public class QuenMatKhauDAO implements DaoMain<QuenMatKhau, String> {

    @Override
    public void insert(QuenMatKhau entity) {
        String sql = "INSERT INTO QuenMatKhau (TaiKhoan,MaXacNhan,ThoiGian) VALUES(?,?,?)";
        JdbcHelper.executeUpdate(sql, entity.getTaiKhoan(), entity.getMaXacNhan(), entity.getThoiGian());
    }

    @Override
    public void update(QuenMatKhau entity) {
        String sql = "UPDATE QuenMatKhau SET  ThoiGian=? WHERE TaiKhoan=? and MaXacNhan=?";
        JdbcHelper.executeUpdate(sql, entity.getThoiGian(), entity.getTaiKhoan(), entity.getMaXacNhan());
    }

    @Override
    public void delete(String key) {
    }

    @Override
    public List<QuenMatKhau> selectAll() {
        return null;
    }

    public QuenMatKhau selectByXacNhan(String tk, String id) {
        String sql = "SELECT * FROM QuenMatKhau WHERE TaiKhoan=? and MaXacNhan=?";
        List<QuenMatKhau> list = selectBySql(sql, tk, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<QuenMatKhau> selectBySql(String sql, Object... args) {

        List<QuenMatKhau> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    QuenMatKhau model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                if (rs != null) {
                    rs.close();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;

    }

    private QuenMatKhau readFromResultSet(ResultSet rs) throws SQLException {
        QuenMatKhau model = new QuenMatKhau();
        model.setTaiKhoan(rs.getString("TaiKhoan"));
        model.setMaXacNhan(rs.getString("maXacNhan"));
        model.setThoiGian(rs.getTimestamp("ThoiGian").toLocalDateTime());
        return model;
    }

    @Override
    public QuenMatKhau selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
