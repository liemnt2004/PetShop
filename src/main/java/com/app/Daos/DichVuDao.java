package com.app.Daos;

import com.app.Entitys.DichVu;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DichVuDao  {
    public void insert(DichVu model){
        String sql="INSERT INTO DichVu (MaDV, TenDichVu, DonVi, Giatien) VALUES (?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
        model.getMaDichVu(),
        model.getTenDichVu(),
        model.getDonVi(),
        model.getGiaTien()
        );
    }
    public void update(DichVu model){    
        String sql="UPDATE DichVu SET TenDichVu=? , DonVi =? , GiaTien =? WHERE MaDv =?";
        JdbcHelper.executeUpdate(sql,        
        model.getTenDichVu(),
        model.getDonVi(),
        model.getGiaTien(),
        model.getMaDichVu()
        );
    }
    
    public void delete(String id){
        String sql="DELETE FROM DichVu WHERE MaDV=?";
        JdbcHelper.executeUpdate(sql, id);
    }
    
    public List<DichVu> select() throws SQLException{
        String sql="SELECT * FROM DichVu";
        return select(sql);
    }
    
    public List<DichVu> selectAll() {
        String sql = "SELECT * FROM DichVu";
        return selectBySql(sql);
    }
    
    public DichVu selectById(String key) {
        String sql = "SELECT * FROM DichVu WHERE MaDV=?";
        List<DichVu> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<DichVu> selectByKeyword(String keyword){
    String sql="SELECT * FROM DichVu WHERE TenDichVu LIKE ?";
    return selectBySql(sql, "%"+keyword+"%");
    }
    
     public DichVu findById(String madv){
     String sql="SELECT * FROM DichVu WHERE MaDv=?";
     List<DichVu> list = selectBySql(sql, madv);
     return list.size() > 0 ? list.get(0) : null;
     }
     
    public List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DichVu model = readFromResultSet(rs);
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
    
    
    
    private List<DichVu> select(String sql, Object...args) throws SQLException{
    List<DichVu> list =new ArrayList<>();
    try {
    ResultSet rs = null;
    try {
        rs=JdbcHelper.executeQuery(sql, args);
        while(rs.next()){
            DichVu model=readFromResultSet(rs);
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
    
    private DichVu readFromResultSet(ResultSet rs) throws SQLException{
        DichVu model=new DichVu();
        model.setMaDichVu(rs.getString("MaDv"));
        model.setTenDichVu(rs.getString("TenDichVu"));
        model.setDonVi(rs.getString("DonVi"));
        model.setGiaTien(rs.getDouble("GiaTien"));
        return model;
    }
    
    
    
}
