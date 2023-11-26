package com.app.Daos;

import com.app.Entitys.ThuCung;
import com.app.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThuCungDao implements DaoMain<ThuCung, String> {

    @Override
    public void insert(ThuCung entity) {
        String sql = "INSERT INTO ThuCung (MaTC, MoTa, Gia_Tien, Tuoi, Can_Nang, Magiong, GioiTinh, Thuoc, MaChuong) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaThuCung(),
                entity.getMoTa(),
                entity.getGiaTien(),
                entity.getTuoi(),
                entity.getCanNang(),
                entity.getMaGiong(),
                entity.getGioiTinh(),
                entity.getThuoc(),
                entity.getMaChuong());
    }

    @Override
    public void update(ThuCung entity) {
        String sql = "UPDATE INTO ThuCung (MaTC, MoTa, Gia_Tien, Tuoi, Can_Nang, Magiong, GioiTinh, Thuoc, MaChuong) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaThuCung(),
                entity.getMoTa(),
                entity.getGiaTien(),
                entity.getTuoi(),
                entity.getCanNang(),
                entity.getMaGiong(),
                entity.getGioiTinh(),
                entity.getThuoc(),
                entity.getMaChuong());
    }

    @Override
    public void delete(String MaTC) {
        String sql = "DELETE FROM MaTC WHERE MaTC=?";
        JdbcHelper.executeUpdate(sql, MaTC);
    }

    private ThuCung readFromResultSet(ResultSet rs) throws SQLException {
        ThuCung entity = new ThuCung();
        entity.setMaThuCung(rs.getString("MaTC"));
        entity.setMoTa(rs.getString("MoTa"));
        entity.setGiaTien(rs.getDouble("Gia_tien"));
        entity.setTuoi(rs.getInt("Tuoi"));
        entity.setCanNang(rs.getFloat("Can_Nang"));
        entity.setMaGiong(rs.getString("Magiong"));
        entity.setGioiTinh(rs.getString("Gioitinh"));
        entity.setThuoc(rs.getString("Thuoc"));
        entity.setMaChuong(rs.getString("Machuong"));
        return entity;
    }

    @Override
    public List<ThuCung> selectAll() {
        String sql = "SELECT * FROM ThuCung";
        return selectBySql(sql);
    }

    @Override
    public ThuCung selectById(String key) {
        String sql = "SELECT * FROM Giong WHERE MaTC=?";
        List<ThuCung> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<ThuCung> selectBySql(String sql, Object... args) {
        List<ThuCung> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ThuCung model = readFromResultSet(rs);
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
}
