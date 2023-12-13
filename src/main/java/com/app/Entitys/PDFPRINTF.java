package com.app.Entitys;


public class PDFPRINTF {
   private String masp;
   private String soluong;
   private String Tien;
   private String TongTien;

    public PDFPRINTF() {
    }

    public PDFPRINTF(String masp, String soluong, String Tien, String TongTien) {
        this.masp = masp;
        this.soluong = soluong;
        this.Tien = Tien;
        this.TongTien = TongTien;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getTien() {
        return Tien;
    }

    public void setTien(String Tien) {
        this.Tien = Tien;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }
   
   
}
