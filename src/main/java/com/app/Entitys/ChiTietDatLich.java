/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Entitys;

public class ChiTietDatLich {

    private int chiTiet;
    private String maDL;
    private String maDV;
    private int soLuong;

    public ChiTietDatLich(int chiTiet, String maDL, String maDV, int soLuong) {
        this.chiTiet = chiTiet;
        this.maDL = maDL;
        this.maDV = maDV;
        this.soLuong = soLuong;
    }

    public ChiTietDatLich() {
    }

    public int getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(int chiTiet) {
        this.chiTiet = chiTiet;
    }

    public String getMaDL() {
        return maDL;
    }

    public void setMaDL(String maDL) {
        this.maDL = maDL;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
