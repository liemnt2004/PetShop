
package com.app.Entitys;


public class Chuong {
    private String maChuong;
    private String trangThai;
    private String moTa;

    public Chuong() {
    }
    
    @Override
    public String toString() {
        return this.maChuong;
    }
    
    public Chuong(String maChuong, String trangThai, String moTa) {
        this.maChuong = maChuong;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public String getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(String maChuong) {
        this.maChuong = maChuong;
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

    
    
    
}
