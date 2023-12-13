/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Entitys;

import java.util.Date;


public class PhieuGiamGia {
    private String maPhieuGiamGia;//khóa chính
    private float phanTramGiamGia;
    private Date dateStart;
    private Date dateEnd;

    public PhieuGiamGia(String maPhieuGiamGia, float phanTramGiamGia, Date dateStart, Date dateEnd) {
        this.maPhieuGiamGia = maPhieuGiamGia;
        this.phanTramGiamGia = phanTramGiamGia;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public PhieuGiamGia() {
    }

    public String getMaPhieuGiamGia() {
        return maPhieuGiamGia;
    }

    public void setMaPhieuGiamGia(String maPhieuGiamGia) {
        this.maPhieuGiamGia = maPhieuGiamGia;
    }

    public float getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(float phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        return this.maPhieuGiamGia +" Ngày Hết Hạn " +this.dateEnd + "Phần Trâm Giảm Giá" + this.getPhanTramGiamGia();
    }

    
    
}
