/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Daos;

import com.app.Entitys.TonKho;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TonKhoDAO implements DaoMain<TonKho, String> {

    @Override
    public void insert(TonKho entity) {
        String sql = "INSERT INTO TonKho (MaKho, MaSP, SoLuong) VALUES(?,?,?)";
        JdbcHelper.executeUpdate(sql, entity.getMaKho(), entity.getMaSP(), entity.getSoLuong());
    }

    @Override
    public void update(TonKho entity) {
        String sql = "UPDATE TonKho SET MaKho=?, SoLuong=? WHERE MaSP=? )";
        JdbcHelper.executeUpdate(sql, entity.getMaKho(), entity.getMaSP(), entity.getSoLuong());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM TonKho WHERE MaSP=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<TonKho> selectAll() {
        String sql = "SELECT * FROM TonKho";
        return selectBySql(sql);
    }

    @Override
    public TonKho selectById(String key) {
        String sql = "SELECT * FROM TonKho WHERE MaSP=?";
        List<TonKho> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<TonKho> selectBySql(String sql, Object... args) {
        List<TonKho> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TonKho model = readFromResultSet(rs);
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
private TonKho readFromResultSet(ResultSet rs) throws SQLException {
        TonKho model = new TonKho();
        model.setMaTonKho(rs.getInt("MaTonKho"));
        model.setMaKho(rs.getString("MaKho"));
        model.setMaSP(rs.getString("MaSP"));
        model.setSoLuong(rs.getInt("SoLuong"));
        return model;
    }
}
