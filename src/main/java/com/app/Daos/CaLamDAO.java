/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Daos;

import com.app.Entitys.CaLam;
import com.app.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CaLamDAO implements DaoMain<CaLam, String> {

    @Override
    public void insert(CaLam entity) {
        String sql = "INSERT INTO CaLam(MaCL,TenCaLam) VALUES (?,?)";
        JdbcHelper.executeUpdate(sql,entity.getMaCL(),entity.getTenCaLam());
    }

    @Override
    public void update(CaLam entity) {
        String sql = "UPDATE CaLam SET TenCaLam=? WHERE MaCL=?";
        JdbcHelper.executeUpdate(sql,entity.getTenCaLam(),entity.getMaCL());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM CaLam WHERE MaCL=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<CaLam> selectAll() {
        String sql = "SELECT * FROM CaLam";
        return selectBySql(sql);
    }

    @Override
    public CaLam selectById(String key) {
        String sql = "SELECT * FROM CaLam WHERE MaCL=?";
        List<CaLam> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<CaLam> selectBySql(String sql, Object... args) {
         List<CaLam> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    CaLam model = readFromResultSet(rs);
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
    
    private CaLam readFromResultSet(ResultSet rs) throws SQLException {
        CaLam model = new CaLam();
        model.setMaCL(rs.getString("MaCL"));
        model.setTenCaLam(rs.getString("TenCaLam"));
        return model;
    }
    
}
