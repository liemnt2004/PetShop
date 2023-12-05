package com.app.Entitys;

import java.util.Date;


public class HoaDon {
    private String maHoaDon;
    private String maNV;
    private Date ngayLap;  
    private float tongTien;
    private String maHV;
    private String maPhieuGiamGia;
    private String trangThai;
    private String maDL;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String maNV, Date ngayLap, float tongTien, String maHV, String maPhieuGiamGia, String trangThai, String maDL) {
        this.maHoaDon = maHoaDon;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.maHV = maHV;
        this.maPhieuGiamGia = maPhieuGiamGia;
        this.trangThai = trangThai;
        this.maDL = maDL;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getMaPhieuGiamGia() {
        return maPhieuGiamGia;
    }

    public void setMaPhieuGiamGia(String maPhieuGiamGia) {
        this.maPhieuGiamGia = maPhieuGiamGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaDL() {
        return maDL;
    }

    public void setMaDL(String maDL) {
        this.maDL = maDL;
    }

    
}
