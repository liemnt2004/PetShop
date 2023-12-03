package com.app.Daos;

import com.app.Entitys.HoiVien;
import com.app.utils.JdbcHelper;
import com.app.utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoiVienDao implements DaoMain<HoiVien, String> {

    @Override
    public void insert(HoiVien entity) {

        String sql = "INSERT INTO HoiVien (MaHV, TenKhachHang, GioiTinh, Email, SDT, Tichdiem, CCCD) VALUES (?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaHoiVien(),
                entity.getTenKhachHang(),
                entity.getGioiTinh(),
                entity.getEmail(),
                entity.getSoDienThoai(),
                entity.getTichDiem(),
                entity.getCccd());
    }

    @Override
    public void update(HoiVien entity) {

        String sql = "UPDATE HoiVien SET TenKhachHang=?, GioiTinh=?, Email=?, SDT=?, Tichdiem=?, CCCD=? WHERE MaHV=?";
        JdbcHelper.executeUpdate(sql,
                entity.getTenKhachHang(),
                entity.getGioiTinh(),
                entity.getEmail(),
                entity.getSoDienThoai(),
                entity.getTichDiem(),
                entity.getCccd(),
                entity.getMaHoiVien());
    }

    @Override
    public void delete(String MaHV) {
        String sql = "DELETE FROM HoiVien WHERE MaHV=?";
        JdbcHelper.executeUpdate(sql, MaHV);
    }

    @Override
    public List<HoiVien> selectAll() {
        String sql = "SELECT * FROM HoiVien";
        return selectBySql(sql);
    }

    @Override
    public HoiVien selectById(String key) {
        String sql = "SELECT * FROM HoiVien WHERE MaHV=?";
        List<HoiVien> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HoiVien> selectBySql(String sql, Object... args) {
        List<HoiVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoiVien entity = readFromResultSet(rs);
                    list.add(entity);
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
    public List<HoiVien> select() throws SQLException{
        String sql="SELECT * FROM HoiVien";
        return selectBySql(sql);
    }
    public List<HoiVien> selectByKeyword(String keyword) throws SQLException{
        String sql="SELECT * FROM HoiVien WHERE TenKhachHang LIKE ?";
        return selectBySql(sql, "%"+keyword+"%");
    }
    private HoiVien readFromResultSet(ResultSet rs) throws SQLException {
        HoiVien entity = new HoiVien();
        entity.setMaHoiVien(rs.getString("MaHV"));
        entity.setTenKhachHang(rs.getString("TenKhachHang"));
        entity.setGioiTinh(rs.getString("GioiTinh"));
        entity.setEmail(rs.getString("Email"));
        entity.setSoDienThoai(rs.getString("SDT"));
        entity.setTichDiem(rs.getInt("TichDiem"));
        entity.setCccd(rs.getString("CCCD"));
        return entity;
    }


}
