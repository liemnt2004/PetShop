package com.app.Entitys;

import java.io.Serializable;

public class HoiVienEntity implements Serializable {

    private String maHoiVien;
    private String tenKhachHang;
    private String gioiTinh;
    private String Email;
    private String soDienThoai;
    private int tichDiem;
    private String canCuocCongDan;

    public HoiVienEntity() {
    }

    public HoiVienEntity(String maHoiVien, String tenKhachHang, String gioiTinh, String Email, String soDienThoai, int tichDiem, String canCuocCongDan) {
        this.maHoiVien = maHoiVien;
        this.tenKhachHang = tenKhachHang;
        this.gioiTinh = gioiTinh;
        this.Email = Email;
        this.soDienThoai = soDienThoai;
        this.tichDiem = tichDiem;
        this.canCuocCongDan = canCuocCongDan;
    }

    public String getMaHoiVien() {
        return maHoiVien;
    }

    public void setMaHoiVien(String MaHoiVien) {
        this.maHoiVien = MaHoiVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.tenKhachHang = TenKhachHang;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.gioiTinh = GioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.soDienThoai = SoDienThoai;
    }

    public int getTichDiem() {
        return tichDiem;
    }

    public void setTichDiem(int TichDiem) {
        this.tichDiem = TichDiem;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setCanCuocCongDan(String CanCuocCongDan) {
        this.canCuocCongDan = CanCuocCongDan;
    }

}
