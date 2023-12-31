package com.app.Daos;

import com.app.Entitys.HoaDon;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO implements DaoMain<HoaDon, String> {

    @Override
    public void insert(HoaDon entity) {
        String sql = "INSERT INTO HoaDon(MaHoaDon, MaNV, Ngaylap, TongTien, MaHV, MaPhieuGiamGia, trangthai, MaDL) VALUES(?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaHoaDon(),
                entity.getMaNV(),
                entity.getNgayLap(),
                entity.getTongTien(),
                entity.getMaHV(),
                entity.getMaPhieuGiamGia(),
                entity.getTrangThai(),
                entity.getMaDL());
    }

    @Override
    public void update(HoaDon entity) {
        String sql = "UPDATE HoaDon SET MaNV=?,Ngaylap=?,TongTien=?,MaHV=?,MaPhieuGiamGia=?,trangthai=?,MaDL=? WHERE MaHoaDon=?";
        JdbcHelper.executeUpdate(sql,
                entity.getMaNV(),
                entity.getNgayLap(),
                entity.getTongTien(),
                entity.getMaHV(),
                entity.getMaPhieuGiamGia(),
                entity.getTrangThai(),
                entity.getMaDL(),
                entity.getMaHoaDon());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM HoaDon WHERE MaHoaDon=?";
        JdbcHelper.executeUpdate(sql, key);
    }

    @Override
    public List<HoaDon> selectAll() {
        String sql = "SELECT * FROM HoaDon";
        return selectBySql(sql);
    }

    public HoaDon selectByMaDL(String key) {
        String sql = "SELECT * FROM HOADON WHERE MADL = ?";
        List<HoaDon> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public HoaDon selectById(String key) {
        String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";
        List<HoaDon> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
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

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();
        model.setMaHoaDon(rs.getString("MaHoaDon"));
        model.setMaNV(rs.getString("MaNV"));
        model.setNgayLap(rs.getDate("Ngaylap"));
        model.setTongTien(rs.getFloat("TongTien"));
        model.setMaHV(rs.getString("MaHV"));
        model.setMaPhieuGiamGia(rs.getString("MaPhieuGiamGia"));
        model.setTrangThai(rs.getString("trangthai"));
        model.setMaDL(rs.getString("MaDL"));
        return model;
    }

}