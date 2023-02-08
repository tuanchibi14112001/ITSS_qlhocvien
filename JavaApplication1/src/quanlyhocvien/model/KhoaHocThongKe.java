/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuan
 */
public class KhoaHocThongKe {
    private int tong_hocvien;
    private KhoaHoc khoaHoc;

    public KhoaHocThongKe() {
    }

    public KhoaHocThongKe(int tong_hocvien, KhoaHoc khoaHoc) {
        this.tong_hocvien = tong_hocvien;
        this.khoaHoc = khoaHoc;
    }

    public int getTong_hocvien() {
        return tong_hocvien;
    }

    public void setTong_hocvien(int tong_hocvien) {
        this.tong_hocvien = tong_hocvien;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

   
    
    
}
