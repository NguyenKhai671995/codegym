package model;

public class TrangThai {
    private int ma_trang_thai;
    private String ten_tran_thai;

    public TrangThai(int ma_trang_thai, String ten_tran_thai) {
        this.ma_trang_thai = ma_trang_thai;
        this.ten_tran_thai = ten_tran_thai;
    }

    public int getMa_trang_thai() {
        return ma_trang_thai;
    }

    public void setMa_trang_thai(int ma_trang_thai) {
        this.ma_trang_thai = ma_trang_thai;
    }

    public String getTen_tran_thai() {
        return ten_tran_thai;
    }

    public void setTen_tran_thai(String ten_tran_thai) {
        this.ten_tran_thai = ten_tran_thai;
    }
}
