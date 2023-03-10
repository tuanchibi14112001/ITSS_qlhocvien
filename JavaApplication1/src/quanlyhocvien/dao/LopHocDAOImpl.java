/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;

/**
 *
 * @author xuannang
 */
public class LopHocDAOImpl  implements LopHocDAO {
    @Override
    public List<LopHoc> getList(){
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM `lop_hoc` inner join `khoa_hoc` on `lop_hoc`.`ma_khoa_hoc` = `khoa_hoc`.`ma_khoa_hoc` where `khoa_hoc`.`tinh_trang_kh`=1";
            List<LopHoc> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LopHoc lopHoc = new LopHoc();
                KhoaHoc khoaHoc = new KhoaHoc();
                
                khoaHoc.setMa_khoa_hoc(rs.getInt("ma_khoa_hoc"));
                khoaHoc.setTen_khoa_hoc(rs.getString("ten_khoa_hoc"));
                khoaHoc.setTrinh_do(rs.getString("trinh_do"));
                khoaHoc.setMo_ta(rs.getString("mo_ta"));
                khoaHoc.setNgay_bat_dau(rs.getDate("ngay_bat_dau"));
                khoaHoc.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc"));
                khoaHoc.setTinh_trang(rs.getBoolean("tinh_trang_kh"));

                
                lopHoc.setMa_lop_hoc(rs.getInt("ma_lop_hoc"));
                lopHoc.setLich_hoc(rs.getString("lich_hoc"));
                lopHoc.setKhoaHoc(khoaHoc);
                lopHoc.setTinh_trang(rs.getBoolean("tinh_trang_lh"));

                
                list.add(lopHoc);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
            } catch (SQLException ex) {
                  ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public LopHoc getLopHocID(int ma_lop_hoc) {
        try {
            Connection conn = DBConnect.getConnection();
            LopHoc lopHoc = new LopHoc();
            String sql = "SELECT * FROM lop_hoc  inner join `khoa_hoc` on `lop_hoc`.`ma_khoa_hoc` = `khoa_hoc`.`ma_khoa_hoc` WHERE ma_lop_hoc = ? ";
            PreparedStatement ps = (PreparedStatement) (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, ma_lop_hoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHoc khoaHoc = new KhoaHoc();
                
                khoaHoc.setMa_khoa_hoc(rs.getInt("ma_khoa_hoc"));
                khoaHoc.setTen_khoa_hoc(rs.getString("ten_khoa_hoc"));
                khoaHoc.setTrinh_do(rs.getString("trinh_do"));
                khoaHoc.setMo_ta(rs.getString("mo_ta"));
                khoaHoc.setNgay_bat_dau(rs.getDate("ngay_bat_dau"));
                khoaHoc.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc"));
                khoaHoc.setTinh_trang(rs.getBoolean("tinh_trang_kh"));

                
                lopHoc.setMa_lop_hoc(rs.getInt("ma_lop_hoc"));
                lopHoc.setLich_hoc(rs.getString("lich_hoc"));
                lopHoc.setKhoaHoc(khoaHoc);
                lopHoc.setTinh_trang(rs.getBoolean("tinh_trang_lh"));

                
//                System.out.println(khoaHoc);
            }
            ps.close();
            conn.close();
            return lopHoc;
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int createOrUpdate(LopHoc lop_hoc, KhoaHoc khoa_hoc) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "INSERT INTO lop_hoc(ma_lop_hoc,lich_hoc,ma_khoa_hoc,tinh_trang_lh) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE ma_lop_hoc = VALUES(ma_lop_hoc), lich_hoc = VALUES(lich_hoc), ma_khoa_hoc = VALUES(ma_khoa_hoc), tinh_trang_lh = VALUES(tinh_trang_lh);";
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, lop_hoc.getMa_lop_hoc());
            ps.setString(2, lop_hoc.getLich_hoc());
            ps.setInt(3, khoa_hoc.getMa_khoa_hoc());
            ps.setBoolean(4, lop_hoc.isTinh_trang());
          
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            conn.close();
            return generatedKey;
        } catch (SQLException ex) {
            Logger.getLogger(LopHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
