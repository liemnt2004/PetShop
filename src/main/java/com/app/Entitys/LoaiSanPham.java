package com.app.Entitys;

public class LoaiSanPham {
    private String maloaisanpham;
    private String tenloai;
    
    

    public LoaiSanPham() {
    }

    public LoaiSanPham(String maloaisanpham, String tenloai) {
        this.maloaisanpham = maloaisanpham;
        this.tenloai = tenloai;
    }

    public String getMaloaisanpham() {
        return maloaisanpham;
    }

    public void setMaloaisanpham(String maloaisanpham) {
        this.maloaisanpham = maloaisanpham;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }
    
    
}