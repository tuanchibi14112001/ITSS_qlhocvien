/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.service;

import quanlyhocvien.dao.TaiKhoanDAO;
import quanlyhocvien.model.TaiKhoan;
import quanlyhocvien.dao.TaiKhoanDAOIplm;

/**
 *
 * @author tuan
 */
public class TaiKhoanServiceImpl implements TaiKhoanService {

    private TaiKhoanDAO taiKhoanDAO = null;

    public TaiKhoanServiceImpl() {
        taiKhoanDAO = new TaiKhoanDAOIplm();
    }

    @Override
    public TaiKhoan login(String ten_dang_nhap, String mat_khau) {
        return taiKhoanDAO.login(ten_dang_nhap, mat_khau);
    }

}
