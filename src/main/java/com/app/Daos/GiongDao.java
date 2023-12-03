package com.app.Daos;

import com.app.Entitys.Giong;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiongDao implements DaoMain<Giong, String> {

    @Override
    public void insert(Giong entity) {
        String sql = "INSERT INTO Giong(MaGiong, TenGiong, Maloai) VALUES(?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaGiong(),
                entity.getTenGiong(),
                entity.getMaLoai());
    }

    @Override
    public void update(Giong entity) {
        String sql = "UPDATE Giong SET TenGiong=?,MaLoai=? WHERE MaGiong=?";
        JdbcHelper.executeUpdate(sql,
                entity.getTenGiong(),
                entity.getMaLoai(),
                entity.getMaGiong());
    }

    @Override
    public void delete(String Magiong) {
        String sql = "DELETE FROM Giong WHERE MaGiong=?";
        JdbcHelper.executeUpdate(sql, Magiong);
    }

    @Override
    public List<Giong> selectAll() {
        String sql = "SELECT * FROM Giong";
        return selectBySql(sql);
    }

    @Override
    public Giong selectById(String key) {
        String sql = "SELECT * FROM Giong WHERE MaGiong=?";
        List<Giong> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Giong> selectBySql(String sql, Object... args) {
        List<Giong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Giong model = readFromResultSet(rs);
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

    private Giong readFromResultSet(ResultSet rs) throws SQLException {
        Giong entity = new Giong();
        entity.setMaGiong(rs.getString("MaGiong"));
        entity.setTenGiong(rs.getString("TenGiong"));
        entity.setMaLoai(rs.getString("MaLoai"));
        return entity;
    }


   
}
