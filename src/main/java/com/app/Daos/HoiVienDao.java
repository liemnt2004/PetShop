/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Daos;

import com.app.Entitys.HoiVien;
import com.app.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class HoiVienDao implements DAOMain<HoiVien, String>{
    public void insert(HoiVien model){
        String sql="INSERT INTO HoiVien (MAHV,TENKHACHHANG,GIOITINH,EMAIL,SDT,TICH_DIEM,CCCD) VALUES (?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
        model.getMaHoiVien(),
        model.getTenKhachHang(),
        model.getGioiTinh(),
        model.getEmail(),
        model.getSoDienThoai(),
        model.getTichDiem(),
        model.getCccd()
        );
    }
    
     public void update(HoiVien model){
        String sql="UPDATE HoiVien (MAHV,TENKHACHHANG,GIOITINH,EMAIL,SDT,TICH_DIEM,CCCD) VALUES (?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
        model.getMaHoiVien(),
        model.getTenKhachHang(),
        model.getGioiTinh(),
        model.getEmail(),
        model.getSoDienThoai(),
        model.getTichDiem(),
        model.getCccd()
        );
    }
     
     public void delete(String id){
        String sql="DELETE FROM HoiVien WHERE MaHV=?";
        JdbcHelper.executeUpdate(sql, id);
    }
     
     public List<HoiVien> select() throws SQLException{
        String sql="SELECT * FROM HoiVien";
        return select(sql);
    }
    
    
    public List<HoiVien> selectAll() {
        String sql = "SELECT * FROM HoiVien";
        return selectBySql(sql);
    }
    
    public HoiVien selectById(String key) {
        String sql = "SELECT * FROM HoiVien WHERE MaHV=?";
        List<HoiVien> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    
    public List<HoiVien> selectBySql(String sql, Object... args) {
        List<HoiVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoiVien model = readFromResultSet(rs);
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
    
    
    private List<HoiVien> select(String sql, Object...args) throws SQLException{
    List<HoiVien> list =new ArrayList<>();
    try {
    ResultSet rs = null;
    try {
        rs=JdbcHelper.executeQuery(sql, args);
        while(rs.next()){
            HoiVien model=readFromResultSet(rs);
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
    
    
    
    private HoiVien readFromResultSet(ResultSet rs) throws SQLException{
        HoiVien model=new HoiVien();
        model.setMaHoiVien(rs.getString("MaHV"));
        model.setTenKhachHang(rs.getString("TenKhachHang"));
        model.setGioiTinh(rs.getString("GioiTinh"));
        model.setEmail(rs.getString("Email"));
        model.setSoDienThoai(rs.getString("SDT"));
        model.setTichDiem(rs.getInt("Tich_diem"));
        model.setCccd(rs.getString("CCCD"));
        return model;
    }
}
