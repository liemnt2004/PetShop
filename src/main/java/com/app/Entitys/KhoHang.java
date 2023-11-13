package com.app.Entitys;

public class KhoHang {
    private String MaKho;
    private int soluong;
    private String masanpham;

    public KhoHang() {
    }

    public KhoHang(String MaKho, int soluong, String masanpham) {
        this.MaKho = MaKho;
        this.soluong = soluong;
        this.masanpham = masanpham;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }
    
    
}
