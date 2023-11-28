package com.app.Daos;

import com.app.Entitys.PhieuNhapHang;
import com.app.utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapHangDao implements DaoMain<PhieuNhapHang, String> {

    @Override
    public void insert(PhieuNhapHang entity) {
        String sql = "INSERT INTO PhieuNhapHang (So_phieu_nhap, Ngay_Nhap, sodh) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, entity.getSoPhieuNhap(), entity.getNgayNhap(), entity.getSoDonHang());
    }

    @Override
    public void update(PhieuNhapHang entity) {
        String sql = "UPDATE PhieuNhapHang SET Ngay_Nhap=?, sodh=? WHERE So_phieu_nhap=?";
        JdbcHelper.executeUpdate(sql, entity.getNgayNhap(), entity.getSoDonHang(), entity.getSoPhieuNhap());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM PhieuNhapHang WHERE So_phieu_nhap=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<PhieuNhapHang> selectAll() {
        String sql = "SELECT * FROM PhieuNhapHang";
        return selectBySql(sql);
    }

    @Override
    public PhieuNhapHang selectById(String key) {
        String sql = "SELECT * FROM PhieuNhapHang WHERE So_phieu_nhap=?";
        List<PhieuNhapHang> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<PhieuNhapHang> selectBySql(String sql, Object... args) {
        List<PhieuNhapHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuNhapHang model = readFromResultSet(rs);
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

    private PhieuNhapHang readFromResultSet(ResultSet rs) throws SQLException {
        PhieuNhapHang model = new PhieuNhapHang();
        model.setSoPhieuNhap(rs.getString("So_phieu_nhap"));
        model.setNgayNhap(rs.getDate("Ngay_Nhap"));
        model.setSoDonHang(rs.getString("sodh"));
        return model;
    }
}
