/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Entitys;

import java.time.LocalDateTime;

public class QuenMatKhau {

    private String taiKhoan;
    private String maXacNhan;
    private LocalDateTime thoiGian;

    public QuenMatKhau(String taiKhoan, String maXacNhan, LocalDateTime thoiGian) {
        this.taiKhoan = taiKhoan;
        this.maXacNhan = maXacNhan;
        this.thoiGian = thoiGian;
    }

    public QuenMatKhau() {
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMaXacNhan() {
        return maXacNhan;
    }

    public void setMaXacNhan(String maXacNhan) {
        this.maXacNhan = maXacNhan;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDateTime thoiGian) {
        this.thoiGian = thoiGian;
    }

}
