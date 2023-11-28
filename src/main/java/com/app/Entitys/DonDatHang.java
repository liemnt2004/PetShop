/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Entitys;

import java.util.Date;

/**
 *
 * @author My Xen
 */
public class DonDatHang {
    private String SoDonHang;
    private Date NgayDatDonHang;
    private String MaNhaCungCap;

    public DonDatHang() {
        
    }
    
    public String getSoDonHang() {
        return SoDonHang;
    }

    public DonDatHang(String SoDonHang, Date NgayDatDonHang, String MaNhaCungCap) {
        this.SoDonHang = SoDonHang;
        this.NgayDatDonHang = NgayDatDonHang;
        this.MaNhaCungCap = MaNhaCungCap;
    }
    
    
    public void setSoDonHang(String SoDonHang) {
        this.SoDonHang = SoDonHang;
    }

    public Date getNgayDatDonHang() {
        return NgayDatDonHang;
    }

    public void setNgayDatDonHang(Date NgayDatDonHang) {
        this.NgayDatDonHang = NgayDatDonHang;
    }

    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }
    
    
}
