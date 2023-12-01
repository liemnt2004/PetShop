package com.app.Entitys;

import java.util.Date;


public class ChiTietCaLam {
    private int machitietcalam;
    private String maCl;
    private String maNV;
    private Date NgayLam;

    public ChiTietCaLam() {
    }

    public ChiTietCaLam(int machitietcalam, String maCl, String maNV, Date NgayLam) {
        this.machitietcalam = machitietcalam;
        this.maCl = maCl;
        this.maNV = maNV;
        this.NgayLam = NgayLam;
    }

    public int getMachitietcalam() {
        return machitietcalam;
    }

    public void setMachitietcalam(int machitietcalam) {
        this.machitietcalam = machitietcalam;
    }

    public String getMaCl() {
        return maCl;
    }

    public void setMaCl(String maCl) {
        this.maCl = maCl;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayLam() {
        return NgayLam;
    }

    public void setNgayLam(Date NgayLam) {
        this.NgayLam = NgayLam;
    }

    

    
    
    
}
