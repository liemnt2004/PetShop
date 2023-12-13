package com.app.Entitys;


public class ChiTietHoaDon {
    private String MaHang;
    private Integer SoLuong;
    private String MaHD;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String MaHang, Integer SoLuong, String MaHD) {
        this.MaHang = MaHang;
        this.SoLuong = SoLuong;
        this.MaHD = MaHD;
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

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

   


 
    
}
