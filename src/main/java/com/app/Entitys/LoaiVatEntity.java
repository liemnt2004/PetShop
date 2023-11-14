package com.app.Entitys;

import java.io.Serializable;

public class LoaiVatEntity implements Serializable {

    private String maLoai;
    private String tenLoai;

    public LoaiVatEntity() {
    }

    public LoaiVatEntity(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

}
