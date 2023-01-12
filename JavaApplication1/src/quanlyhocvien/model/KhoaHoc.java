/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.model;

import java.util.Date;

/**
 *
 * @author xuannang
 */
public class KhoaHoc {
    private int ma_khoa_hoc;
    private String ten_khoa_hoc;
    private String trinh_do;
    private String mo_ta;
    private int hoc_phi;
    private Date ngay_bat_dau;
    private Date ngay_ket_thuc;
    private boolean tinh_trang;

    public int getMa_khoa_hoc() {
        return ma_khoa_hoc;
    }

    public void setMa_khoa_hoc(int ma_khoa_hoc) {
        this.ma_khoa_hoc = ma_khoa_hoc;
    }

    public String getTen_khoa_hoc() {
        return ten_khoa_hoc;
    }

    public void setTen_khoa_hoc(String ten_khoa_hoc) {
        this.ten_khoa_hoc = ten_khoa_hoc;
    }

    public String getTrinh_do() {
        return trinh_do;
    }

    public void setTrinh_do(String trinh_do) {
        this.trinh_do = trinh_do;
    }

    public int getHoc_phi() {
        return hoc_phi;
    }

    public void setHoc_phi(int hoc_phi) {
        this.hoc_phi = hoc_phi;
    }
    
    

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public Date getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(Date ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public Date getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(Date ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public boolean isTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    @Override
    public String toString() {
        return "KhoaHoc{" + "ma_khoa_hoc=" + ma_khoa_hoc + ", ten_khoa_hoc=" + ten_khoa_hoc + ", trinh_do=" + trinh_do + ", mo_ta=" + mo_ta + ", ngay_bat_dau=" + ngay_bat_dau + ", ngay_ket_thuc=" + ngay_ket_thuc + ", tinh_trang=" + tinh_trang + '}';
    }

}
