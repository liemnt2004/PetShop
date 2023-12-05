package com.app.Entitys;


public class DichVu {
    private String maDichVu; 
    private String tenDichVu;
    private String donVi;
    private double giaTien;

    public DichVu(String maDichVu, String tenDichVu, String donVi, double giaTien) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.donVi = donVi;
        this.giaTien = giaTien;
    }

    public DichVu() {
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return this.tenDichVu;
    }
    
   
}