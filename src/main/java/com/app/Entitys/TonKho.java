/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Entitys;

/**
 *
 * @author Admin
 */
public class TonKho {
   private Integer MaTonKho;
   private String MaKho;
   private String MaSP;
   private Integer SoLuong;

    public TonKho() {
    }
    public TonKho(Integer MaTonKho, String MaKho, String MaSP, Integer SoLuong) {
        this.MaTonKho = MaTonKho;
        this.MaKho = MaKho;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
    }

    public Integer getMaTonKho() {
        return MaTonKho;
    }

    public void setMaTonKho(Integer MaTonKho) {
        this.MaTonKho = MaTonKho;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }
   
   
   
}
