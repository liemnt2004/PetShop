package com.app.Daos;

import com.app.Entitys.NhanVien;
import com.app.Entitys.TaiKhoan;
import com.app.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDao implements DaoMain<NhanVien, String> {

    String SELECT_NOT_IN_TaiKhoan = "SELECT * FROM NhanVien WHERE MANV NOT IN (SELECT MANV FROM TAIKHOAN)";

    public List<NhanVien> selectKhongTaiKhoan() {
        return selectBySql(SELECT_NOT_IN_TaiKhoan);
    }

    @Override
    public void insert(NhanVien entity) {
        String sql = "INSERT INTO NhanVien (MaNV, HoTen, GioiTinh, NgaySinh, Sdt, Email, TrangThai, Hinh, MaVT) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaNhanVien(),
                entity.getHoTen(),
                entity.getGioiTinh(),
                entity.getNgaySinh(),
                entity.getSoDienThoai(),
                entity.getEmail(),
                entity.getTrangThai(),
                entity.getHinh(),
                entity.isMaVaitro());

    }

    @Override
    public void update(NhanVien entity) {
        String sql = "UPDATE  NhanVien SET HoTen = ?, GioiTinh= ?, NgaySinh= ?, Sdt= ?, Email= ?, TrangThai= ?, Hinh= ?, MaVT= ? Where MaNV =?";
        JdbcHelper.executeUpdate(sql,
                entity.getHoTen(),
                entity.getGioiTinh(),
                entity.getNgaySinh(),
                entity.getSoDienThoai(),
                entity.getEmail(),
                entity.getTrangThai(),
                entity.getHinh(),
                entity.isMaVaitro(),
                entity.getMaNhanVien());
    }

    @Override
    public void delete(String MaNV) {
        String sql = "DELETE NhanVien WHERE MaNV = ?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "SELECT * FROM NhanVien";
        return selectBySql(sql);
    }

    @Override
    public NhanVien selectById(String key) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        List<NhanVien> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien entity = new NhanVien();
        entity.setMaNhanVien(rs.getString("MaNV"));
        entity.setHoTen(rs.getString("HoTen"));
        entity.setGioiTinh(rs.getString("GioiTinh"));
        entity.setNgaySinh(rs.getDate("NgaySinh"));
        entity.setSoDienThoai(rs.getString("Sdt"));
        entity.setEmail(rs.getString("Email"));
        entity.setTrangThai(rs.getString("TrangThai"));
        entity.setHinh(rs.getString("Hinh"));
        entity.setMaVaitro(rs.getBoolean("MaVT"));
        return entity;
    }

    public List<NhanVien> selectByName(String name) {
        String sql = "SELECT * FROM NhanVien WHERE HoTen like ?";
        List<NhanVien> list = selectBySql(sql, "%" + name + "%");
        return list;
    }

   

    public List<NhanVien> selectBy(boolean vaitro, String name, String trangThai) {
        String sql = "SELECT * FROM NhanVien WHERE MaVT = ? and HoTen like ? and TrangThai like ?";
        List<NhanVien> list = selectBySql(sql, vaitro, "%" + name + "%", "%" + trangThai + "%");
        return list;
    }
}
