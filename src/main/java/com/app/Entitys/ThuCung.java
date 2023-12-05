package com.app.Entitys;

import java.util.Date;

public class ThuCung {

    private String maThuCung;
    private String moTa;
    private int giaTien;
    private Date Tuoi;
    private Float canNang;
    private String maGiong;
    private boolean gioiTinh;
    private String maHoiVien;
    private String maChuong;
    private String maLoai;
    private String hinhAnh;

    
    public ThuCung() {
    }

    public ThuCung(String maThuCung, String moTa, int giaTien, Date Tuoi, Float canNang, String maGiong, boolean gioiTinh, String maHoiVien, String maChuong, String maLoai, String hinhAnh) {
        this.maThuCung = maThuCung;
        this.moTa = moTa;
        this.giaTien = giaTien;
        this.Tuoi = Tuoi;
        this.canNang = canNang;
        this.maGiong = maGiong;
        this.gioiTinh = gioiTinh;
        this.maHoiVien = maHoiVien;
        this.maChuong = maChuong;
        this.maLoai = maLoai;
        this.hinhAnh = hinhAnh;
    }

    public String getMaThuCung() {
        return maThuCung;
    }

    public void setMaThuCung(String maThuCung) {
        this.maThuCung = maThuCung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public Date getTuoi() {
        return Tuoi;
    }

    public void setTuoi(Date Tuoi) {
        this.Tuoi = Tuoi;
    }

    public Float getCanNang() {
        return canNang;
    }

    public void setCanNang(Float canNang) {
        this.canNang = canNang;
    }

    public String getMaGiong() {
        return maGiong;
    }

    public void setMaGiong(String maGiong) {
        this.maGiong = maGiong;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaHoiVien() {
        return maHoiVien;
    }

    public void setMaHoiVien(String maHoiVien) {
        this.maHoiVien = maHoiVien;
    }

    public String getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(String maChuong) {
        this.maChuong = maChuong;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
    
 
}