/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Entitys;


public class CaLam {
    private String maCL;
    private String tenCaLam;
    private String ThoiGian;

    public CaLam() {
    }

    public CaLam(String maCL, String tenCaLam, String ThoiGian) {
        this.maCL = maCL;
        this.tenCaLam = tenCaLam;
        this.ThoiGian = ThoiGian;
    }
    
    

    public String getMaCL() {
        return maCL;
    }

    public void setMaCL(String maCL) {
        this.maCL = maCL;
    }

    public String getTenCaLam() {
        return tenCaLam;
    }

    public void setTenCaLam(String tenCaLam) {
        this.tenCaLam = tenCaLam;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    @Override
    public String toString() {
        return this.tenCaLam;
    }
   
    

    
    
}
