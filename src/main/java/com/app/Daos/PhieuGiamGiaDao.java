/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Daos;

import com.app.Entitys.PhieuGiamGia;
import com.app.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PhieuGiamGiaDao implements DAOMain<PhieuGiamGia, String>{
     public void insert(PhieuGiamGia model){
        String sql="INSERT INTO PhieuGiamGia (MA_PhieuGiamGia,Phan_Tram_Giam_Gia,dateStart,dateEnd) VALUES (?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
        model.getMaPhieuGiamGia(),
        model.getPhanTramGiamGia(),
        model.getDateStart(),
        model.getDateEnd()
        );
    }
     
     public void update(PhieuGiamGia model){
        String sql="UPDATE PhieuGiamGia (MA_PhieuGiamGia,Phan_Tram_Giam_Gia,dateStart,dateEnd) VALUES (?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
        model.getMaPhieuGiamGia(),
        model.getPhanTramGiamGia(),
        model.getDateStart(),
        model.getDateEnd()
        );
    }
     public void delete(String id){
        String sql="DELETE FROM PhieuGiamGia WHERE MaHV=?";
        JdbcHelper.executeUpdate(sql, id);
    }
     
     public List<PhieuGiamGia> select() throws SQLException{
        String sql="SELECT * FROM PhieuGiamGia";
        return select(sql);
    }
    
    
    
    public List<PhieuGiamGia> selectAll() {
        String sql = "SELECT * FROM PhieuGiamGia";
        return selectBySql(sql);
    }
    
    public PhieuGiamGia selectById(String key) {
        String sql = "SELECT * FROM PhieuGiamGia WHERE Ma_PhieuGiamGia=?";
        List<PhieuGiamGia> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    
    public List<PhieuGiamGia> selectBySql(String sql, Object... args) {
        List<PhieuGiamGia> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuGiamGia model = readFromResultSet(rs);
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
    
    
    private List<PhieuGiamGia> select(String sql, Object...args) throws SQLException{
    List<PhieuGiamGia> list =new ArrayList<>();
    try {
    ResultSet rs = null;
    try {
        rs=JdbcHelper.executeQuery(sql, args);
        while(rs.next()){
            PhieuGiamGia model=readFromResultSet(rs);
            list.add(model);
        }
    }finally{
        rs.getStatement().getConnection().close();
        }
    }catch(SQLException ex){
        throw new RuntimeException(ex);
    }
    return list;
    }
    
    
    
    private PhieuGiamGia readFromResultSet(ResultSet rs) throws SQLException{
        PhieuGiamGia model=new PhieuGiamGia();
        model.setMaPhieuGiamGia(rs.getString("Ma_PhieuGiamGia"));
        model.setPhanTramGiamGia(rs.getFloat("Phan_Tram_Giam_Gia"));
        model.setDateStart(rs.getDate("dateStart"));
        model.setDateEnd(rs.getDate("dateEnd"));
        return model;
    }
}

