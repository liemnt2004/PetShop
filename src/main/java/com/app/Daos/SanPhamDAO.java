package com.app.Daos;

import com.app.Entitys.SanPham;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO implements DaoMain<SanPham, String> {

    @Override
    public void insert(SanPham entity) {
        String sql = "INSERT INTO SanPham (MaSP, GiaTien, TenSP, DonVi, PhanTram, MaLoaiSP, MaNhaCC) VALUES (?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, entity.getMaSP(), entity.getGiaTien(), entity.getTenSP(), entity.getDonVi(), entity.getPhanTram(), entity.getMaLoaiSP(), entity.getMaNhaCungCap());
    }

    @Override
    public void update(SanPham entity) {
        String sql = "UPDATE SanPham SET GiaTien=?, TenSP=?, DonVi=?, PhanTram=?, MaLoaiSP=?, MaNhaCC=? WHERE MaSP=?";
        JdbcHelper.executeUpdate(sql, entity.getGiaTien(), entity.getTenSP(), entity.getDonVi(), entity.getPhanTram(), entity.getMaLoaiSP(), entity.getMaNhaCungCap(), entity.getMaSP());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM SanPham WHERE MaSP=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<SanPham> selectAll() {
        String sql = "SELECT * FROM SanPham";
        return selectBySql(sql);
    }

    @Override
    public SanPham selectById(String key) {
        String sql = "SELECT * FROM SanPham WHERE MaSP=?";
        List<SanPham> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet(rs);
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

    private SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setMaSP(rs.getString("MaSP"));
        model.setGiaTien(rs.getDouble("GiaTien"));
        model.setTenSP(rs.getString("TenSP"));
        model.setDonVi(rs.getString("DonVi"));
        model.setPhanTram(rs.getFloat("PhanTram"));
        model.setMaLoaiSP(rs.getString("MaLoaiSP"));
        model.setMaNhaCungCap(rs.getString("MaNhaCC"));
        return model;
    }

}
