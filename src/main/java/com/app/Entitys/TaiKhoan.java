package com.app.Entitys;


public class TaiKhoan {
    
    private String taiKhoan; // khóa chính
    private String matKhau;
    private String maNhanVien;

    public TaiKhoan(String taiKhoan, String matKhau, String maNhanVien) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.maNhanVien = maNhanVien;
    }

    public TaiKhoan() {
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    
    
    
}
