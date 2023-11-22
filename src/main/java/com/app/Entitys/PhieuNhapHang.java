package com.app.Entitys;

import java.time.LocalDate;
import java.util.Date;

public class PhieuNhapHang {
    private String SoPhieuNhap;
    private Date NgayNhap ;

    public PhieuNhapHang() {
    }

    public PhieuNhapHang(String SoPhieuNhap, Date NgayNhap) {
        this.SoPhieuNhap = SoPhieuNhap;
        this.NgayNhap = NgayNhap;
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

}
