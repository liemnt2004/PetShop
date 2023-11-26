package com.app.Daos;

import com.app.Daos.DaoMain;
import com.app.Entitys.Nhanvien;
import com.app.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDao implements DaoMain<Nhanvien, String> {

    @Override
    public void insert(Nhanvien entity) {
        String sql = "INSERT INTO NhanVien (MaNV, Ho_Ten, Gioi_Tinh, Ngay_Sinh, Sdt, Email, Trang_Thai, Hinh, MaVT) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaNhanvien(),
                entity.getHoTen(),
                entity.getGioiTinh(),
                entity.getNgaySinh(),
                entity.getSoDienThoai(),
                entity.getEmai(),
                entity.getTrangThai(),
                entity.getHinh(),
                entity.isMaVaitro());

    }

    @Override
    public void update(Nhanvien entity) {
        String sql = "UPDATE INTO NhanVien (MaNV, Ho_Ten, Gioi_Tinh, Ngay_Sinh, Sdt, Email, Trang_Thai, Hinh, MaVT) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaNhanvien(),
                entity.getHoTen(),
                entity.getGioiTinh(),
                entity.getNgaySinh(),
                entity.getSoDienThoai(),
                entity.getEmai(),
                entity.getTrangThai(),
                entity.getHinh(),
                entity.isMaVaitro());
    }

    @Override
    public void delete(String MaNV) {
        String sql = "DELETE FROM MaNV WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }

    @Override
    public List<Nhanvien> selectAll() {
        String sql = "SELECT * FROM NhanVien";
        return selectBySql(sql);
    }

    @Override
    public Nhanvien selectById(String key) {
        String sql = "SELECT * FROM Giong WHERE MaNV=?";
        List<Nhanvien> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Nhanvien> selectBySql(String sql, Object... args) {
        List<Nhanvien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Nhanvien model = readFromResultSet(rs);
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

    private Nhanvien readFromResultSet(ResultSet rs) throws SQLException {
        Nhanvien entity = new Nhanvien();
        entity.setMaNhanvien(rs.getString("MaNV"));
        entity.setHoTen(rs.getString("Ho_Ten"));
        entity.setGioiTinh(rs.getString("Gioi_Tinh"));
        entity.setNgaySinh(rs.getDate("Ngay_Sinh"));
        entity.setSoDienThoai(rs.getString("Sdt"));
        entity.setEmai(rs.getString("Email"));
        entity.setTrangThai(rs.getString("Trang_Thai"));
        entity.setHinh(rs.getString("Hinh"));
        entity.isMaVaitro();
        return entity;
    }

}
