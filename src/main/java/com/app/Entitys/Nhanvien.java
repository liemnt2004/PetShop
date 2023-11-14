package com.app.Entitys;

import java.io.Serializable;
import java.util.Date;

public class Nhanvien implements Serializable {

    private String maNhanVien;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String soDienThoai;
    private String Emai;
    private String trangThai;
    private String Hinh;
    private boolean maVaiTro = false;

    public Nhanvien() {
    }

    public Nhanvien(String maNhanVien, String hoTen, String gioiTinh, Date ngaySinh, String soDienThoai, String Emai, String trangThai, String Hinh) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.Emai = Emai;
        this.trangThai = trangThai;
        this.Hinh = Hinh;
    }


    public String getMaNhanvien() {
        return maNhanVien;
    }

    public void setMaNhanvien(String maNhanvien) {
        this.maNhanVien = maNhanvien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmai() {
        return Emai;
    }

    public void setEmai(String Emai) {
        this.Emai = Emai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public boolean isMaVaitro() {
        return maVaiTro;
    }

    public void setMaVaitro(boolean maVaitro) {
        this.maVaiTro = maVaitro;
    }

}
