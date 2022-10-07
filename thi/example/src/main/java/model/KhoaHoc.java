package model;

import java.time.LocalDate;

public class KhoaHoc {
    private int maKhoahoc;
    private String tenKhoaHoc;
    private String thoiGianHoc;
    private double hocPhi;
    private int maModule;

    public KhoaHoc(String tenKhoaHoc, String thoiGianHoc, double hocPhi, int maModule) {
        this.tenKhoaHoc = tenKhoaHoc;
        this.thoiGianHoc = thoiGianHoc;
        this.hocPhi = hocPhi;
        this.maModule = maModule;
    }

    public KhoaHoc(int maKhoahoc, String tenKhoaHoc, String thoiGianHoc, double hocPhi, int maModule) {
        this.maKhoahoc = maKhoahoc;
        this.tenKhoaHoc = tenKhoaHoc;
        this.thoiGianHoc = thoiGianHoc;
        this.hocPhi = hocPhi;
        this.maModule = maModule;
    }

    public int getMaKhoahoc() {
        return maKhoahoc;
    }

    public void setMaKhoahoc(int maKhoahoc) {
        this.maKhoahoc = maKhoahoc;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getThoiGianHoc() {
        return thoiGianHoc;
    }

    public void setThoiGianHoc(String thoiGianHoc) {
        this.thoiGianHoc = thoiGianHoc;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getMaModule() {
        return maModule;
    }

    public void setMaModule(int maModule) {
        this.maModule = maModule;
    }
}
