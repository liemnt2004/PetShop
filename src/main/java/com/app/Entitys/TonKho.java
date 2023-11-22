package com.app.Entitys;


public class TonKho {
    private int maTonKho;
    private String maKho;
    private String Masp;
    private Integer soluong;

    public TonKho() {
    }

    public TonKho(int maTonKho, String maKho, String Masp, Integer soluong) {
        this.maTonKho = maTonKho;
        this.maKho = maKho;
        this.Masp = Masp;
        this.soluong = soluong;
    }

    public int getMaTonKho() {
        return maTonKho;
    }

    public void setMaTonKho(int maTonKho) {
        this.maTonKho = maTonKho;
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getMasp() {
        return Masp;
    }

    public void setMasp(String Masp) {
        this.Masp = Masp;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    
    
    
}
