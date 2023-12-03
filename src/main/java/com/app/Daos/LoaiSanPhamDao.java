package com.app.Daos;

import com.app.Entitys.LoaiSanPham;
import com.app.utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiSanPhamDao implements DaoMain<LoaiSanPham, String> {

    @Override
    public void insert(LoaiSanPham entity) {
        String sql = "INSERT INTO LoaiSanPham (maloaisp, ten_loai) VALUES (?, ?)";
        JdbcHelper.executeUpdate(sql, entity.getMaloaisanpham(), entity.getTenloai());
    }

    @Override
    public void update(LoaiSanPham entity) {
        String sql = "UPDATE LoaiSanPham SET ten_loai=? WHERE maloaisp=?";
        JdbcHelper.executeUpdate(sql, entity.getTenloai(), entity.getMaloaisanpham());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM LoaiSanPham WHERE maloaisp=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<LoaiSanPham> selectAll() {
        String sql = "SELECT * FROM LoaiSanPham";
        return selectBySql(sql);
    }

    @Override
    public LoaiSanPham selectById(String key) {
        String sql = "SELECT * FROM LoaiSanPham WHERE maloaisp=?";
        List<LoaiSanPham> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiSanPham> selectBySql(String sql, Object... args) {
        List<LoaiSanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    LoaiSanPham model = readFromResultSet(rs);
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

    private LoaiSanPham readFromResultSet(ResultSet rs) throws SQLException {
        LoaiSanPham model = new LoaiSanPham();
        model.setMaloaisanpham(rs.getString("maloaisp"));
        model.setTenloai(rs.getString("ten_loai"));
        return model;
    }

 
}
