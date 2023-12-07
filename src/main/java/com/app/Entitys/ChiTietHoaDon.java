package com.app.Entitys;


public class ChiTietHoaDon {
    private String MaHang;
    private Integer SoLuong;
    private Integer GiaTien;
    private Integer TongTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String MaHang, Integer SoLuong, Integer GiaTien, Integer TongTien) {
        this.MaHang = MaHang;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
        this.TongTien = TongTien;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Integer getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(Integer GiaTien) {
        this.GiaTien = GiaTien;
    }

    public Integer getTongTien() {
        return TongTien;
    }

    public void setTongTien(Integer TongTien) {
        this.TongTien = TongTien;
    }

   
    
    
}
