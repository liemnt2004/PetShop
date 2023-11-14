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
    private float phanTram;
    private String maLoaiSP;

    public SanPham() {
    }

    public SanPham(String maSP, Double giaTien, String tenSP, String donVi, float phanTram, String maLoaiSP) {
        this.maSP = maSP;
        this.giaTien = giaTien;
        this.tenSP = tenSP;
        this.donVi = donVi;
        this.phanTram = phanTram;
        this.maLoaiSP = maLoaiSP;
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

    public float getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(float phanTram) {
        this.phanTram = phanTram;
    }

    public String getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    
    
    
}
