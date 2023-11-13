package com.app.Entitys;

import java.util.Date;

public class PhieuNhapHang {
    private String SoPhieuNhap;
    private Date NgayNhap;
    private String SoDonHang;

    public PhieuNhapHang() {
    }

    public PhieuNhapHang(String SoPhieuNhap, Date NgayNhap, String SoDonHang) {
        this.SoPhieuNhap = SoPhieuNhap;
        this.NgayNhap = NgayNhap;
        this.SoDonHang = SoDonHang;
    }

    public String getSoPhieuNhap() {
        return SoPhieuNhap;
    }

    public void setSoPhieuNhap(String SoPhieuNhap) {
        this.SoPhieuNhap = SoPhieuNhap;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getSoDonHang() {
        return SoDonHang;
    }

    public void setSoDonHang(String SoDonHang) {
        this.SoDonHang = SoDonHang;
    }
    
    
}
