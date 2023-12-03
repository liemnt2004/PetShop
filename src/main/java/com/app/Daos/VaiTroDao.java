package com.app.Daos;

import com.app.Entitys.VaiTro;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VaiTroDao implements DaoMain<VaiTro, String> {
    public void insert(VaiTro model){
        String sql="INSERT INTO vaitro (MaVT,TenVaiTro) VALUES (?,?)";
        JdbcHelper.executeUpdate(sql,
        model.isMaVaiTro(),
        model.getTenVaiTro()
        );
    }
    
    public void update(VaiTro model){
        String sql="UPDATE vaitro (MaVT,TenVaiTro) VALUES (?,?)";
        JdbcHelper.executeUpdate(sql,
        model.isMaVaiTro(),
        model.getTenVaiTro()
        );
    }
    
    public void delete(String id){
        String sql="DELETE FROM vaitro WHERE mavt=?";
        JdbcHelper.executeUpdate(sql, id);
    }
     
     public List<VaiTro> select() throws SQLException{
        String sql="SELECT * FROM vaitro ";
        return select(sql);
    }
    public List<VaiTro> selectAll() {
        String sql = "SELECT * FROM VaiTro";
        return selectBySql(sql);
    }
    
    public VaiTro selectById(String key) {
        String sql = "SELECT * FROM VaiTro WHERE mavt=?";
        List<VaiTro> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    
    public List<VaiTro> selectBySql(String sql, Object... args) {
        List<VaiTro> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    VaiTro model = readFromResultSet(rs);
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
    
    
    private List<VaiTro> select(String sql, Object...args) throws SQLException{
    List<VaiTro> list =new ArrayList<>();
    try {
    ResultSet rs = null;
    try {
        rs=JdbcHelper.executeQuery(sql, args);
        while(rs.next()){
            VaiTro model=readFromResultSet(rs);
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
    
    
    
    private VaiTro readFromResultSet(ResultSet rs) throws SQLException{
        VaiTro model=new VaiTro();
        model.setMaVaiTro(rs.getBoolean("mavt"));
        model.setTenVaiTro(rs.getString("tenvaitro"));
        return model;
    }

   
}
