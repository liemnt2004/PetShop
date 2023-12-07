package com.app.Daos;

import com.app.Entitys.ThuCung;
import com.app.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThuCungDao implements DaoMain<ThuCung, String> {

    @Override
    public void insert(ThuCung entity) {
        String sql = "INSERT INTO ThuCung (MaTC,MoTa, GiaTien, Tuoi, CanNang, MaGiong, GioiTinh, MaHV, MaChuong,MaLoai,Hinh) VALUES(?,? ,?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getMaThuCung(),
                entity.getMoTa(),
                entity.getGiaTien(),
                entity.getTuoi(),
                entity.getCanNang(),
                entity.getMaGiong(),
                entity.isGioiTinh(),
                entity.getMaHoiVien(),
                entity.getMaChuong(),
                entity.getMaLoai(),
                entity.getHinhAnh());
    }

    @Override
    public void update(ThuCung entity) {
        String sql = "UPDATE ThuCung SET MoTa=?,GiaTien=?,Tuoi=?,CanNang=?,MaGiong=?,GioiTinh=?,MaHV=?,MaChuong=?,MaLoai=?,Hinh=? WHERE MaTC=?";
        JdbcHelper.executeUpdate(sql,
                entity.getMoTa(),
                entity.getGiaTien(),
                entity.getTuoi(),
                entity.getCanNang(),
                entity.getMaGiong(),
                entity.isGioiTinh(),
                entity.getMaHoiVien(),
                entity.getMaChuong(),
                entity.getMaLoai(),
                entity.getHinhAnh(),
                entity.getMaThuCung());
    }

    @Override
    public void delete(String MaTC) {
        String sql = "DELETE FROM ThuCung WHERE MaTC=?";
        JdbcHelper.executeUpdate(sql, MaTC);
    }

    @Override
    public List<ThuCung> selectAll() {
        String sql = "SELECT * FROM ThuCung";
        return selectBySql(sql);
    }

    @Override
    public ThuCung selectById(String key) {
        String sql = "SELECT * FROM ThuCung WHERE MaTC=?";
        List<ThuCung> list = selectBySql(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<ThuCung> selectByMaHV(String key) {
        String sql = "select * from thucung where mahv = ?";
        List<ThuCung> list = selectBySql(sql, key);
        return list;
    }
    
    public List<ThuCung> selectAllNOTHOIVIEN() {
        String sql = "SELECT * FROM ThuCung WHERE MaHV IS NULL";
        List<ThuCung> list = selectBySql(sql);
        return list;
    }
    

    @Override
    public List<ThuCung> selectBySql(String sql, Object... args) {
        List<ThuCung> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                ThuCung entity = new ThuCung();
                entity.setMaThuCung(rs.getString("MaTC"));
                entity.setMoTa(rs.getString("MoTa"));
                entity.setGiaTien(rs.getInt("GiaTien"));
                entity.setTuoi(rs.getDate("Tuoi"));
                entity.setCanNang(rs.getFloat("CanNang"));
                entity.setMaGiong(rs.getString("MaGiong"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setMaHoiVien(rs.getString("MaHV"));
                entity.setMaChuong(rs.getString("MaChuong"));
                entity.setMaLoai(rs.getString("MaLoai"));
                entity.setHinhAnh(rs.getString("Hinh"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }

}
