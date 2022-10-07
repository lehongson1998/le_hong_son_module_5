package model;

import java.time.LocalDate;

public class HocVien {
    private int maHocVien;
    private String hoTen;
    private LocalDate ngaySinh;
    private String email;
    private String diChi;
    private String soDienThoai;
    private int maKhoaHoc;

    public HocVien(String hoTen, LocalDate ngaySinh, String email, String diChi, String soDienThoai, int maKhoaHoc) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.diChi = diChi;
        this.soDienThoai = soDienThoai;
        this.maKhoaHoc = maKhoaHoc;
    }

    public HocVien(int maHocVien, String hoTen, LocalDate ngaySinh, String email, String diChi, String soDienThoai, int maKhoaHoc) {
        this.maHocVien = maHocVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.diChi = diChi;
        this.soDienThoai = soDienThoai;
        this.maKhoaHoc = maKhoaHoc;
    }

    public int getMaHocVien() {
        return maHocVien;
    }

    public void setMaHocVien(int maHocVien) {
        this.maHocVien = maHocVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiChi() {
        return diChi;
    }

    public void setDiChi(String diChi) {
        this.diChi = diChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(int maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }
}
