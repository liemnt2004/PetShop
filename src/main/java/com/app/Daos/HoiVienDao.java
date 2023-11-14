package com.app.Daos;

import com.app.Daos.DaoMain;
import com.app.Entitys.HoiVienEntity;
import com.app.Utils.JdbcHelper;
import com.sun.org.apache.xml.internal.resolver.Catalog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoiVienDao implements DaoMain<HoiVienEntity, String> {

    @Override
    public void insert(HoiVienEntity entity) {
        String sql = "INSERT INTO HoiVien (MaHV, TenKhachHang, Gioi_Tinh, Email, SDT, Tich_diem, CCCD) VALUES(?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaHoiVien(),
                entity.getTenKhachHang(),
                entity.getGioiTinh(),
                entity.getEmail(),
                entity.getSoDienThoai(),
                entity.getTichDiem(),
                entity.getCanCuocCongDan());
    }

    @Override
    public void update(HoiVienEntity entity) {
        String sql = "UPDATE INTO HoiVien (MaHV, TenKhachHang, Gioi_Tinh, Email, SDT, Tich_diem, CCCD) VALUES(?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaHoiVien(),
                entity.getTenKhachHang(),
                entity.getGioiTinh(),
                entity.getEmail(),
                entity.getSoDienThoai(),
                entity.getTichDiem(),
                entity.getCanCuocCongDan());
    }

    @Override
    public void delete(String MaHV) {
        String sql = "DELETE FROM MaHV WHERE MaHV=?";
        JdbcHelper.executeUpdate(sql, MaHV);
    }

    @Override
    public List<HoiVienEntity> selectAll() {
        String sql = "SELECT * FROM HoiVien";
        return selectBySql(sql);
    }

    @Override
    public HoiVienEntity selectById(String key) {
        String sql = "SELECT * FROM HoiVien WHERE MaHV=?";
        List<HoiVienEntity> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HoiVienEntity> selectBySql(String sql, Object... args) {
        List<HoiVienEntity> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoiVienEntity model = readFromResultSet(rs);
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

    private HoiVienEntity readFromResultSet(ResultSet rs) throws SQLException {
        HoiVienEntity entity = new HoiVienEntity();
        entity.setMaHoiVien(rs.getString("MaHV"));
        entity.setTenKhachHang(rs.getString("TenKhachHang"));
        entity.setGioiTinh(rs.getString("Gioi_Tinh"));
        entity.setEmail(rs.getString("Email"));
        entity.setSoDienThoai(rs.getString("Sdt"));
        entity.setTichDiem(rs.getInt("Tich_diem"));
        entity.setCanCuocCongDan(rs.getString("CCCD"));
        return entity;
    }
}
