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
public class HocVienLopHoc {
    private int ma_hoc_vien;
    private Date ngay_dang_ky;
    private boolean thanh_toan;
    private boolean tinh_trang;

    public int getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public void setMa_hoc_vien(int ma_hoc_vien) {
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public Date getNgay_dang_ky() {
        return ngay_dang_ky;
    }

    public void setNgay_dang_ky(Date ngay_dang_ky) {
        this.ngay_dang_ky = ngay_dang_ky;
    }

    public boolean isThanh_toan() {
        return thanh_toan;
    }

    public void setThanh_toan(boolean thanh_toan) {
        this.thanh_toan = thanh_toan;
    }

    public boolean isTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }
    
    
}
