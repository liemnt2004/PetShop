package com.app.Daos;


import com.app.Entitys.TaiKhoan;;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.app.utils.JdbcHelper;



public class TaiKhoanDao implements DaoMain<TaiKhoan, String>  {
    
        
        
     public void insert(TaiKhoan model){
        String sql="INSERT INTO TaiKhoan (TaiKhoan,MatKhau,MaNV) VALUES (?,?,?)";
        JdbcHelper.executeUpdate(sql,
        model.getTaiKhoan(),
        model.getMatKhau(),
        model.getMaNhanVien()
        );
    }
     public void update(TaiKhoan model){
        String sql="UPDATE TaiKhoan Set MatKhau = ?,MaNV =? Where TaiKhoan = ?";
        JdbcHelper.executeUpdate(sql,
        model.getMatKhau(),
        model.getMaNhanVien(),
        model.getTaiKhoan()
        );
        
    }
     
     public void delete(String id){
        String sql="DELETE FROM TaiKhoan WHERE TaiKhoan=?";
        JdbcHelper.executeUpdate(sql, id);
    }
    
     public List<TaiKhoan> selectAll() {
        String sql = "SELECT * FROM TaiKhoan";
        return selectBySql(sql);
    }

    
    public TaiKhoan selectById(String key) {
        String sql = "SELECT * FROM TaiKhoan WHERE TaiKhoan =?";
        List<TaiKhoan> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
        public TaiKhoan selectByMaNhanVien(String key) {
        String sql = "SELECT * FROM TaiKhoan WHERE MaNV =?";
        List<TaiKhoan> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    
    public List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet(rs);
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
    
    private List<TaiKhoan> select(String sql, Object...args) throws SQLException{
    List<TaiKhoan> list =new ArrayList<>();
    try {
    ResultSet rs = null;
    try {
        rs=JdbcHelper.executeQuery(sql, args);
        while(rs.next()){
            TaiKhoan model=readFromResultSet(rs);
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
    
    
    
    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException{
        TaiKhoan model=new TaiKhoan();
        model.setTaiKhoan(rs.getString("TaiKhoan"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setMaNhanVien(rs.getString("MaNV"));
        return model;
    }
}
     

