
package com.app.Entitys;

import java.util.Date;


public class DatDV {
    private String maDL;
    private String maHV; 
    private String soDienThoai;
    private Date   ngayDat;
    private String trangThai;
    private String moTa;
    private Date   ngayTra;
    

    public DatDV() {
    }

    public DatDV(String maDL, String maHV, String soDienThoai, Date ngayDat, String trangThai, String moTa, Date ngayTra) {
        this.maDL = maDL;
        this.maHV = maHV;
        this.soDienThoai = soDienThoai;
        this.ngayDat = ngayDat;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.ngayTra = ngayTra;
       
    }

    public String getMaDL() {
        return maDL;
    }

    public void setMaDL(String maDL) {
        this.maDL = maDL;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

   

     
      
}