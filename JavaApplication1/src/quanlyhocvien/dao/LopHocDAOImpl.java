/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            String sql = "SELECT * FROM `lop_hoc` inner join `khoa_hoc` on `lop_hoc`.`ma_khoa_hoc` = `khoa_hoc`.`ma_khoa_hoc`";
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
                lopHoc.setTong(rs.getInt("tong"));
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
    
    public static void main(String[] args) {
        LopHocDAO lopHocDAO = new LopHocDAOImpl();
        System.out.println(lopHocDAO.getList());
    }
}
