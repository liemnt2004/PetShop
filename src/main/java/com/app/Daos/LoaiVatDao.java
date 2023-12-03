package com.app.Daos;

import com.app.Entitys.LoaiVat;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiVatDao implements DaoMain<LoaiVat, String> {

    @Override
    public void insert(LoaiVat entity) {
        String sql = "INSERT INTO LoaiVat (MaLoai, TenLoai) VALUES(?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaLoai(),
                entity.getTenLoai());
    }

    @Override
    public void update(LoaiVat entity) {
        String sql = "UPDATE LoaiVat SET TenLoai=? WHERE MaLoai=?";
        JdbcHelper.executeUpdate(sql,
                entity.getTenLoai(),
                entity.getMaLoai());
    }

    @Override
    public void delete(String Maloai) {
        String sql = "DELETE FROM LoaiVat WHERE MaLoai=?";
        JdbcHelper.executeUpdate(sql, Maloai);
    }

    @Override
    public List<LoaiVat> selectAll() {
        String sql = "SELECT * FROM LoaiVat";
        return selectBySql(sql);

    }

    @Override
    public LoaiVat selectById(String key) {
        String sql = "SELECT * FROM LoaiVat WHERE MaLoai=?";
        List<LoaiVat> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiVat> selectBySql(String sql, Object... args) {

        List<LoaiVat> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    LoaiVat model = readFromResultSet(rs);
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

    private LoaiVat readFromResultSet(ResultSet rs) throws SQLException {
        LoaiVat entity = new LoaiVat();
        entity.setMaLoai(rs.getString("MaLoai"));
        entity.setTenLoai(rs.getString("TenLoai"));
        return entity;
    }



}
