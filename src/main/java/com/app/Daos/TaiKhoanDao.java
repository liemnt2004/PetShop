package com.app.Daos;


import com.app.Entitys.TaiKhoan;;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.app.utils.JdbcHelper;



public class TaiKhoanDao implements DaoMain<TaiKhoan, String>  {
     public void insert(TaiKhoan model){
        String sql="INSERT INTO TaiKhoan (Tai_Khoan,Mat_Khau,MaNV) VALUES (?,?,?)";
        JdbcHelper.executeUpdate(sql,
        model.getTaiKhoan(),
        model.getMatKhau(),
        model.getMaNhanVien()
        );
    }
     public void update(TaiKhoan model){
        String sql="UPDATE TaiKhoan (Tai_Khoan,Mat_Khau,MaNV) VALUES (?,?,?)";
        JdbcHelper.executeUpdate(sql,
        model.getTaiKhoan(),
        model.getMatKhau(),
        model.getMaNhanVien()
        );
        
    }
     
     public void delete(String id){
        String sql="DELETE FROM TaiKhoan WHERE Tai_Khoan=?";
        JdbcHelper.executeUpdate(sql, id);
    }
     
     public List<TaiKhoan> select() throws SQLException{
        String sql="SELECT * FROM TaiKhoan";
        return select(sql);
    }
    
     public List<TaiKhoan> selectAll() {
        String sql = "SELECT * FROM TaiKhoan";
        return selectBySql(sql);
    }
    
    public TaiKhoan selectById(String key) {
        String sql = "SELECT * FROM TaiKhoan WHERE Tai_Khoan=?";
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
        model.setTaiKhoan(rs.getString("Tai_Khoan"));
        model.setMatKhau(rs.getString("Mat_Khau"));
        model.setMaNhanVien(rs.getString("MaNV"));
        return model;
    }
}
     

