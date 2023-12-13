package com.app.Daos;

import com.app.Entitys.DichVu;
import com.app.Entitys.PhieuGiamGia;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PhieuGiamGiaDao implements DaoMain<PhieuGiamGia, String>{
     public void insert(PhieuGiamGia model){
        String sql="INSERT INTO PhieuGiamGia (MAPhieuGiamGia,PhanTramGiamGia,dateStart,dateEnd) VALUES (?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
        model.getMaPhieuGiamGia(),
        model.getPhanTramGiamGia(),
        model.getDateStart(),
        model.getDateEnd()
        );
    }
     
     public void update(PhieuGiamGia model){
        String sql="UPDATE PhieuGiamGia SET PhanTramGiamGia=? , DateStart=?,DateEnd=? WHERE MaPhieuGiamGia=? ";
        JdbcHelper.executeUpdate(sql,        
        model.getPhanTramGiamGia(),
        model.getDateStart(),
        model.getDateEnd(),
        model.getMaPhieuGiamGia()
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
    
    public List<PhieuGiamGia> selectByKeyword(String keyword){
    String sql="SELECT * FROM PhieuGiamGia WHERE PhanTramGiamGia LIKE ?";
    return selectBySql(sql, "%"+keyword+"%");
    }
    
    public List<PhieuGiamGia> selectByHetHan(){
    String sql = "SELECT * FROM PhieuGiamGia WHERE GETDATE() > dateStart";
    return selectBySql(sql);
    }
    public List<PhieuGiamGia> selectByConHan(){
    String sql = "SELECT * FROM PhieuGiamGia WHERE  GETDATE() BETWEEN DateStart and DateEnd";
    return selectBySql(sql);
    }
    
    public List<PhieuGiamGia> selectAll() {
        String sql = "SELECT * FROM PhieuGiamGia";
        return selectBySql(sql);
    }
    
    public PhieuGiamGia selectById(String key) {
        String sql = "SELECT * FROM PhieuGiamGia WHERE MaPhieuGiamGia=?";
        List<PhieuGiamGia> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    public PhieuGiamGia findById(String mapgg){
     String sql="SELECT * FROM PhieuGiamGia WHERE MaPhieuGiamGia=?";
     List<PhieuGiamGia> list = selectBySql(sql, mapgg);
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
        model.setMaPhieuGiamGia(rs.getString("MaPhieuGiamGia"));
        model.setPhanTramGiamGia(rs.getFloat("PhanTramGiamGia"));
        model.setDateStart(rs.getDate("dateStart"));
        model.setDateEnd(rs.getDate("dateEnd"));
        return model;
    }
}