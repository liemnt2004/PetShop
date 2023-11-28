/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Entitys;


public class SanPham {
    private String maSP;
    private Double giaTien;
    private String tenSP;
    private String donVi;
    private Float phanTram;
    private String maLoaiSP;
    private String maNhaCC;
    private String trangThai;

    public SanPham() {
    }

    public SanPham(String maSP, Double giaTien, String tenSP, String donVi, Float phanTram, String maLoaiSP, String maNhaCC, String trangThai) {
        this.maSP = maSP;
        this.giaTien = giaTien;
        this.tenSP = tenSP;
        this.donVi = donVi;
        this.phanTram = phanTram;
        this.maLoaiSP = maLoaiSP;
        this.maNhaCC = maNhaCC;
        this.trangThai = trangThai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Float getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(Float phanTram) {
        this.phanTram = phanTram;
    }

    public String getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getMaNhaCC() {
        return maNhaCC;
    }

    public void setMaNhaCC(String maNhaCC) {
        this.maNhaCC = maNhaCC;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

   


    
    

}