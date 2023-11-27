package com.app.Daos;

import com.app.Entitys.DatDV;
import com.app.Utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatDVDAO implements DaoMain<DatDV, String> {

    @Override
    public void insert(DatDV entity) {
        String sql = "INSERT INTO DatDV(MaDL, MaHV, sdt, NgayDat, TrangThai, mota, NgayTra, soluong) VALUES(?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, entity.getMaDL(), entity.getMaHV(), entity.getSoDienThoai(), entity.getNgayDat(), entity.getTrangThai(), entity.getMoTa(), entity.getNgayTra(), entity.getSoLuong());
    }

    @Override
    public void update(DatDV entity) {
        String sql = "UPDATE DatDV SET MaHV=?, sdt=?, NgayDat=?, TrangThai=?,mota=?,NgayTra=?,soluong=? WHERE MaDL=?";
        JdbcHelper.executeUpdate(sql, entity.getMaHV(), entity.getSoDienThoai(), entity.getNgayDat(), entity.getTrangThai(), entity.getMoTa(), entity.getNgayTra(), entity.getSoLuong(), entity.getMaDL());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM DatDV WHERE MADL=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<DatDV> selectAll() {
        String sql = "SELECT * FROM DatDV";
        return selectBySql(sql);
    }

    @Override
    public DatDV selectById(String key) {
        String sql = "SELECT * FROM DatDV WHERE MaDL = ?";
        List<DatDV> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List selectByToday() {
        String sql = "SELECT * FROM DATDV WHERE NGAYTRA >= GETDATE()";
        List<DatDV> lst = selectBySql(sql);
        return lst;
    }

    @Override
    public List<DatDV> selectBySql(String sql, Object... args) {
        List<DatDV> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DatDV model = readFromResultSet(rs);
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

    private DatDV readFromResultSet(ResultSet rs) throws SQLException {
        DatDV model = new DatDV();
        model.setMaDL(rs.getString("MaDL"));
        model.setMaHV(rs.getString("MaHV"));
        model.setSoDienThoai(rs.getString("sdt"));
        model.setNgayDat(rs.getDate("NgayDat"));
        model.setTrangThai(rs.getString("TrangThai"));
        model.setMoTa(rs.getString("mota"));
        model.setNgayTra(rs.getDate("NgayTra"));
        model.setSoLuong(rs.getInt("soluong"));
        return model;

    }

}
