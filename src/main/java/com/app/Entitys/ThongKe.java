package com.app.Entitys;


public class ThongKe {
    private String Thang;
    private double TongTien;

    public ThongKe() {
    }

    public ThongKe(String Thang, double TongTien) {
        this.Thang = Thang;
        this.TongTien = TongTien;
    }

    public String getThang() {
        return Thang;
    }

    public void setThang(String Thang) {
        this.Thang = Thang;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    
    
    
}
