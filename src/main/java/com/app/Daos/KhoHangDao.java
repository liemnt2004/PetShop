package com.app.Daos;

import com.app.Entitys.KhoHang;
import com.app.Utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoHangDao implements DaoMain<KhoHang, String> {

    @Override
    public void insert(KhoHang entity) {
        String sql = "INSERT INTO KhoHang (MaSP, Ma_kho, So_Luong_Ton) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, entity.getMasanpham(), entity.getMaKho(), entity.getSoluong());
    }

    @Override
    public void update(KhoHang entity) {
        String sql = "UPDATE KhoHang SET So_Luong_Ton=? WHERE MaSP=? AND Ma_kho=?";
        JdbcHelper.executeUpdate(sql, entity.getSoluong(), entity.getMasanpham(), entity.getMaKho());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM KhoHang WHERE MaSP=? AND Ma_kho=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<KhoHang> selectAll() {
        String sql = "SELECT * FROM KhoHang";
        return selectBySql(sql);
    }

    @Override
    public KhoHang selectById(String key) {
        String sql = "SELECT * FROM KhoHang WHERE MaSP=? AND Ma_kho=?";
        List<KhoHang> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<KhoHang> selectBySql(String sql, Object... args) {
        List<KhoHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhoHang model = readFromResultSet(rs);
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

    private KhoHang readFromResultSet(ResultSet rs) throws SQLException {
        KhoHang model = new KhoHang();
        model.setMasanpham(rs.getString("MaSP"));
        model.setMaKho(rs.getString("Ma_kho"));
        model.setSoluong(rs.getInt("So_Luong_Ton"));
        return model;
    }
}
