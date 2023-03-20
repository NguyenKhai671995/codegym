package model;

import java.sql.Date;

public class MatBang {
    private String ma_mb;
    private int dien_tich;
    private int trang_thai;
    private int tang;
    private int van_phong;
    private int gia;
    private Date ngay_vao;
    private Date ngay_het;

    public MatBang() {
    }

    public MatBang(String ma_mb, int dien_tich, int trang_thai, int tang, int van_phong, int gia, Date ngay_vao, Date ngay_het) {
        this.ma_mb = ma_mb;
        this.dien_tich = dien_tich;
        this.trang_thai = trang_thai;
        this.tang = tang;
        this.van_phong = van_phong;
        this.gia = gia;
        this.ngay_vao = ngay_vao;
        this.ngay_het = ngay_het;
    }

    public String getMa_mb() {
        return ma_mb;
    }

    public void setMa_mb(String ma_mb) {
        this.ma_mb = ma_mb;
    }

    public int getDien_tich() {
        return dien_tich;
    }

    public void setDien_tich(int dien_tich) {
        this.dien_tich = dien_tich;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getVan_phong() {
        return van_phong;
    }

    public void setVan_phong(int van_phong) {
        this.van_phong = van_phong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public Date getNgay_vao() {
        return ngay_vao;
    }

    public void setNgay_vao(Date ngay_vao) {
        this.ngay_vao = ngay_vao;
    }

    public Date getNgay_het() {
        return ngay_het;
    }

    public void setNgay_het(Date ngay_het) {
        this.ngay_het = ngay_het;
    }
}
