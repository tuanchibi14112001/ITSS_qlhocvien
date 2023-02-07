/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package quanlyhocvien.dao;

import quanlyhocvien.model.TaiKhoan;

/**
 *
 * @author tuan
 */
public interface TaiKhoanDAO {
    public  TaiKhoan login(String ten_dang_nhap, String mat_khau);
}
