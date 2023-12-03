package com.app.Daos;

import com.app.Entitys.Chuong;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChuongDAO implements DaoMain<Chuong, String>{
    
    public List<String> findKey(String x) {
        List<String> chuonglist = new ArrayList<>();
        try {
            String sql = "SELECT MaChuong FROM Chuong WHERE TrangThai = (?)";
            ResultSet rs = JdbcHelper.executeQuery(sql, x);
            while (rs.next()) {
                chuonglist.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChuongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chuonglist;
    }
    
    public List<String> selectTrangThai(){
        List<String> chuonglist1 = new ArrayList<>();
        try {
            String sql = "SELECT TrangThai FROM Chuong GROUP BY TrangThai";
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while(rs.next()){
                chuonglist1.add(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return chuonglist1;
    }
    
    @Override
    public void insert(Chuong entity) {
        String sql = "INSERT INTO Chuong (MaChuong,TrangThai,MoTa) VALUES(?,?,?)";
        JdbcHelper.executeUpdate(sql,entity.getMaChuong(),entity.getTrangThai(),entity.getMoTa());
    }

    @Override
    public void update(Chuong entity) {
        String sql = "UPDATE Chuong SET TrangThai=?, MoTa=? WHERE MaChuong=?";
        JdbcHelper.executeUpdate(sql,entity.getTrangThai(),entity.getMoTa(),entity.getMaChuong());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM Chuong WHERE MaChuong=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<Chuong> selectAll() {
        String sql = "SELECT * FROM Chuong";
        return selectBySql(sql);
    }

    @Override
    public Chuong selectById(String key) {
        String sql = "SELECT * FROM Chuong WHERE MaChuong=?";
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
        model.setMaChuong(rs.getString(1));
        model.setTrangThai(rs.getString(2));
        model.setMoTa(rs.getString(3));
        return model;
    }

   

    
    }
    

