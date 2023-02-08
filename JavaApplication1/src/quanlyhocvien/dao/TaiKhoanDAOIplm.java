/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlyhocvien.model.TaiKhoan;

/**
 *
 * @author tuan
 */
public class TaiKhoanDAOIplm implements TaiKhoanDAO {

    @Override
    public TaiKhoan login(String ten_dang_nhap, String mat_khau) {
        try {
            Connection conn = DBConnect.getConnection();

            String sql = "SELECT * FROM tai_khoan WHERE  ten_dang_nhap LIKE ?  AND mat_khau LIKE ?";
            TaiKhoan tai_khoan = null;
            PreparedStatement ps = (PreparedStatement) (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, ten_dang_nhap);
            ps.setString(2, mat_khau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tai_khoan = new TaiKhoan();
                tai_khoan.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
                tai_khoan.setTen_dang_nhap(rs.getString("ten_dang_nhap"));
                tai_khoan.setMat_khau(rs.getString("mat_khau"));
                tai_khoan.setTinh_trang(rs.getBoolean("tinh_trang"));

            }

            return tai_khoan;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAOIplm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
