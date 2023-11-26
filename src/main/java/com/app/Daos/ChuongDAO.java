package com.app.Daos;

import com.app.Entitys.Chuong;
import com.app.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ChuongDAO implements DaoMain<Chuong, String>{
    

    @Override
    public void insert(Chuong entity) {
        String sql = "INSERT INTO Chuong (machuong,trangthai,mota) VALUES(?,?,?)";
        JdbcHelper.executeUpdate(sql,entity.getMaChuong(),entity.getTrangThai(),entity.getMoTa());
    }

    @Override
    public void update(Chuong entity) {
        String sql = "UPDATE Chuong SET trangthai=? mota=? WHERE machuong=?";
        JdbcHelper.executeUpdate(sql,entity.getTrangThai(),entity.getMoTa(),entity.getMaChuong());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM Chuong WHERE machuong=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<Chuong> selectAll() {
        String sql = "SELECT * FROM Chuong";
        return selectBySql(sql);
    }

    @Override
    public Chuong selectById(String key) {
        String sql = "SELECT * FROM Chuong WHERE machuong=?";
        List<Chuong> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Chuong> selectBySql(String sql, Object... args) {
        List<Chuong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Chuong model = readFromResultSet(rs);
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

    private Chuong readFromResultSet(ResultSet rs) throws SQLException {
        Chuong model = new Chuong();
        model.setMaChuong(rs.getString("machuong"));
        model.setTrangThai(rs.getString("trangthai"));
        model.setMoTa(rs.getString("mota"));
        return model;
    }
    }
    

