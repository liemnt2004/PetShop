package com.app.Daos;

import com.app.Entitys.GiongEntity;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiongDao implements DaoMain<GiongEntity, String> {

    @Override
    public void insert(GiongEntity entity) {
        String sql = "INSERT INTO Giong (Magiong, TenGiong, Maloai) VALUES(?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaGiong(),
                entity.getTenGiong(),
                entity.getMaLoai());
    }

    @Override
    public void update(GiongEntity entity) {
        String sql = "INSERT INTO Giong (Magiong, TenGiong, Maloai) VALUES(?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaGiong(),
                entity.getTenGiong(),
                entity.getMaLoai());
    }

    @Override
    public void delete(String Magiong) {
        String sql = "DELETE FROM Magiong WHERE Magiong=?";
        JdbcHelper.executeUpdate(sql, Magiong);
    }

    @Override
    public List<GiongEntity> selectAll() {
        String sql = "SELECT * FROM Giong";
        return selectBySql(sql);
    }

    @Override
    public GiongEntity selectById(String key) {
        String sql = "SELECT * FROM Giong WHERE MaGiong=?";
        List<GiongEntity> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<GiongEntity> selectBySql(String sql, Object... args) {
        List<GiongEntity> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    GiongEntity model = readFromResultSet(rs);
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

    private GiongEntity readFromResultSet(ResultSet rs) throws SQLException {
        GiongEntity entity = new GiongEntity();
        entity.setMaGiong(rs.getString("MaGiong"));
        entity.setTenGiong(rs.getString("TenGiong"));
        entity.setMaLoai(rs.getString("MaLoai"));
        return entity;
    }
}
