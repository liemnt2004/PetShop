package com.app.Entitys;

public class Giong {

    private String maGiong;
    private String tenGiong;
    private String maLoai;

    public Giong() {
    }
    public Giong(String maGiong, String tenGiong, String maLoai) {
        this.maGiong = maGiong;
        this.tenGiong = tenGiong;
        this.maLoai = maLoai;
    }

    public String getMaGiong() {
        return maGiong;
    }

    public void setMaGiong(String maGiong) {
        this.maGiong = maGiong;
    }

    public String getTenGiong() {
        return tenGiong;
    }

    public void setTenGiong(String tenGiong) {
        this.tenGiong = tenGiong;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

}
