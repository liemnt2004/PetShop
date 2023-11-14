package com.app.Entitys;

public class ThuCung {

    private String maThuCung;
    private String moTa;
    private Double giaTien;
    private Integer Tuoi;
    private Float canNang;
    private String maGiong;
    private String gioiTinh;
    private String Thuoc;
    private String maChuong;

    public ThuCung() {
    }

    public ThuCung(String maThuCung, String moTa, Double giaTien, Integer Tuoi, Float canNang, String maGiong, String gioiTinh, String Thuoc, String maChuong) {
        this.maThuCung = maThuCung;
        this.moTa = moTa;
        this.giaTien = giaTien;
        this.Tuoi = Tuoi;
        this.canNang = canNang;
        this.maGiong = maGiong;
        this.gioiTinh = gioiTinh;
        this.Thuoc = Thuoc;
        this.maChuong = maChuong;
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

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public Integer getTuoi() {
        return Tuoi;
    }

    public void setTuoi(Integer Tuoi) {
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getThuoc() {
        return Thuoc;
    }

    public void setThuoc(String Thuoc) {
        this.Thuoc = Thuoc;
    }

    public String getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(String maChuogng) {
        this.maChuong = maChuogng;
    }

}
