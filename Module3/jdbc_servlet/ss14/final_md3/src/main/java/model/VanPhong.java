package model;

public class VanPhong {
    private int ma_van_phong;
    private String loai_phong;

    public VanPhong(int ma_van_phong, String loai_phong) {
        this.ma_van_phong = ma_van_phong;
        this.loai_phong = loai_phong;
    }

    public int getMa_van_phong() {
        return ma_van_phong;
    }

    public void setMa_van_phong(int ma_van_phong) {
        this.ma_van_phong = ma_van_phong;
    }

    public String getLoai_phong() {
        return loai_phong;
    }

    public void setLoai_phong(String loai_phong) {
        this.loai_phong = loai_phong;
    }
}
