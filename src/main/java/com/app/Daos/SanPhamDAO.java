package com.app.Daos;

import com.app.Entitys.SanPham;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPhamDAO implements DaoMain<SanPham, String> {

    @Override
    public void insert(SanPham entity) {
        String sql = "INSERT INTO SanPham (MaSP, Giatien, Tensp, donvi, phantram, maloaisp, trangthai, manhacc) VALUES (?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, entity.getMaSP(), entity.getGiaTien(), entity.getTenSP(), entity.getDonVi(), entity.getPhanTram(), entity.getMaLoaiSP(), entity.getTrangThai(), entity.getMaNhaCC());
    }

    @Override
    public void update(SanPham entity) {
        String sql = "UPDATE SanPham SET Giatien=?, Tensp=?, donvi=?, phantram=?, maloaisp=?, trangthai=? WHERE MaSP=?";
        JdbcHelper.executeUpdate(sql, entity.getGiaTien(), entity.getTenSP(), entity.getDonVi(), entity.getPhanTram(), entity.getMaLoaiSP(), entity.getTrangThai(), entity.getMaSP());
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

    public List<SanPham> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM SANPHAM WHERE TenSP LIKE ?";
        return selectBySql(sql, "%" + keyword + "%");
    }

    public void insertChiTietSanPham(String mahd, Integer SoLuong, String masp) {
        String sql = "INSERT INTO ChiTietHoaDon VALUES(?,?,?)";
        JdbcHelper.executeUpdate(sql, mahd, masp, SoLuong);
    }

    public List<SanPham> selectByCombobox(String combobox) {
        String sql = "SELECT * FROM SANPHAM WHERE TrangThai LIKE ?";
        return selectBySql(sql, "%" + combobox + "%");
    }

    public String selectNameSP(String masp) {
        String name = "";
        String sql = "SELECT TenSP FROM SanPham WHERE MaSP = ?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, masp);
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
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
        model.setGiaTien(rs.getInt("Giatien"));
        model.setTenSP(rs.getString("Tensp"));
        model.setDonVi(rs.getString("donvi"));
        model.setPhanTram(rs.getFloat("phantram"));
        model.setMaLoaiSP(rs.getString("maloaisp"));
        model.setTrangThai(rs.getString("TrangThai"));
        model.setMaNhaCC(rs.getString("MaNhaCC"));
        return model;
    }

}
