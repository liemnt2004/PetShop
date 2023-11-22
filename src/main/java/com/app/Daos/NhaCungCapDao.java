package com.app.Daos;

import com.app.Entitys.NhaCungCap;
import com.app.Utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDao implements DaoMain<NhaCungCap, String> {

    @Override
    public void insert(NhaCungCap entity) {
        String sql = "INSERT INTO NhaCungCap (MaNhaCC, TenNhaCC, DiaChi) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, entity.getMaNhaCungCap(), entity.getTenNhaCungCap(), entity.getDiaChi());
    }

    @Override
    public void update(NhaCungCap entity) {
        String sql = "UPDATE NhaCungCap SET TenNhaCC=?, DiaChi=? WHERE MaNhaCC=?";
        JdbcHelper.executeUpdate(sql, entity.getTenNhaCungCap(), entity.getDiaChi(), entity.getMaNhaCungCap());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM NhaCungCap WHERE MaNhaCC=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<NhaCungCap> selectAll() {
        String sql = "SELECT * FROM NhaCungCap";
        return selectBySql(sql);
    }

    @Override
    public NhaCungCap selectById(String key) {
        String sql = "SELECT * FROM NhaCungCap WHERE MaNhaCC=?";
        List<NhaCungCap> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhaCungCap> selectBySql(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhaCungCap model = readFromResultSet(rs);
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

    private NhaCungCap readFromResultSet(ResultSet rs) throws SQLException {
        NhaCungCap model = new NhaCungCap();
        model.setMaNhaCungCap(rs.getString("MaNhaCC"));
        model.setTenNhaCungCap(rs.getString("TenNhaCC"));
        model.setDiaChi(rs.getString("DiaChi"));
        return model;
    }
}
