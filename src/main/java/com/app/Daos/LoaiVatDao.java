package com.app.Daos;

import com.app.Entitys.LoaiVatEntity;
import com.app.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiVatDao implements DaoMain<LoaiVatEntity, String> {

    @Override
    public void insert(LoaiVatEntity entity) {
        String sql = "INSERT INTO LoaiVat (Maloai, Tenloai) VALUES(?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaLoai(),
                entity.getTenLoai());
    }

    @Override
    public void update(LoaiVatEntity entity) {
        String sql = "UPDATE INTO LoaiVat (Maloai, Tenloai) VALUES(?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaLoai(),
                entity.getTenLoai());
    }

    @Override
    public void delete(String Maloai) {
        String sql = "DELETE FROM Maloai WHERE Maloai=?";
        JdbcHelper.executeUpdate(sql, Maloai);
    }

    @Override
    public List<LoaiVatEntity> selectAll() {
        String sql = "SELECT * FROM LoaiVat";
        return selectBySql(sql);

    }

    @Override
    public LoaiVatEntity selectById(String key) {
        String sql = "SELECT * FROM LoaiVat WHERE MaLoai=?";
        List<LoaiVatEntity> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiVatEntity> selectBySql(String sql, Object... args) {

        List<LoaiVatEntity> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    LoaiVatEntity model = readFromResultSet(rs);
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

    private LoaiVatEntity readFromResultSet(ResultSet rs) throws SQLException {
        LoaiVatEntity entity = new LoaiVatEntity();
        entity.setMaLoai(rs.getString("Maloai"));
        entity.setTenLoai(rs.getString("Tenloai"));
        return entity;
    }

}
