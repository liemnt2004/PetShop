package com.app.Daos;


import com.app.Entitys.DonDatHang;
import com.app.utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonDatHangDao implements DaoMain<DonDatHang, String> {

    @Override
    public void insert(DonDatHang entity) {
        String sql = "INSERT INTO DonDatHang (sodh, ngay_dh, Ma_Nha_Cc) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, entity.getNgayDatDonHang(), entity.getNgayDatDonHang(), entity.getMaNhaCungCap());
    }

    @Override
    public void update(DonDatHang entity) {
        String sql = "UPDATE DonDatHang SET ngay_dh=?, Ma_Nha_Cc=? WHERE sodh=?";
        JdbcHelper.executeUpdate(sql, entity.getNgayDatDonHang(), entity.getMaNhaCungCap(), entity.getSoDonHang());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM DonDatHang WHERE sodh=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<DonDatHang> selectAll() {
        String sql = "SELECT * FROM DonDatHang";
        return selectBySql(sql);
    }

    @Override
    public DonDatHang selectById(String key) {
        String sql = "SELECT * FROM DonDatHang WHERE sodh=?";
        List<DonDatHang> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DonDatHang> selectBySql(String sql, Object... args) {
        List<DonDatHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DonDatHang model = readFromResultSet(rs);
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

    private DonDatHang readFromResultSet(ResultSet rs) throws SQLException {
        DonDatHang model = new DonDatHang();
        model.setSoDonHang(rs.getString("sodh"));
        model.setNgayDatDonHang(rs.getDate("ngay_dh"));
        model.setMaNhaCungCap(rs.getString("Ma_Nha_Cc"));
        return model;
    }
}
