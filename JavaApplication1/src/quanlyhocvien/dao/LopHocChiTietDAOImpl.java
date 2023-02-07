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
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlyhocvien.model.HocVienLopHoc;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;
import quanlyhocvien.model.LopHocChiTiet;

/**
 *
 * @author xuannang
 */
public class LopHocChiTietDAOImpl implements LopHocChiTietDAO{
    @Override
    public List<LopHoc> getList(){
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM `lop_hoc` inner join `khoa_hoc` on `lop_hoc`.`ma_khoa_hoc` = `khoa_hoc`.`ma_khoa_hoc` where `lop_hoc`.`tinh_trang_lh`=1 and `khoa_hoc`.`tinh_trang_kh`=1";
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
                
                // đang lỗi phần sql thứ 2 và không hiển thị được sỹ số
                
//                 truy cập bảng lớp học chi tiết để tính tống học viên của từng lớp học
                
                String sql2 = "SELECT count(`lop_hoc`.`ma_lop_hoc`) as `sy so` "
                        + "FROM (`lop_hoc` inner join `khoa_hoc` on `lop_hoc`.`ma_khoa_hoc` = `khoa_hoc`.`ma_khoa_hoc` ) "
                        + "left join (`lop_hoc_chi_tiet` left join `hoc_vien` on `hoc_vien`.`ma_hoc_vien` = `lop_hoc_chi_tiet`.`ma_hoc_vien`) "
                        + "on `lop_hoc`.`ma_lop_hoc` = `lop_hoc_chi_tiet`.`ma_lop_hoc` "
                        + "where `lop_hoc`.`tinh_trang_lh`=1 and `khoa_hoc`.`tinh_trang_kh`=1 and `lop_hoc_chi_tiet`.`tinh_trang`= 1 "
                        + "and `hoc_vien`.`tinh_trang` =1 and `lop_hoc`.`ma_lop_hoc` =?";
                PreparedStatement ps2 = (PreparedStatement) (PreparedStatement) cons.prepareStatement(sql2);
                ps2.setInt(1, rs.getInt("ma_lop_hoc"));
                ResultSet rs2 = ps2.executeQuery();
                
                
                while(rs2.next()){
                    lopHoc.setSySo(rs2.getInt("sy so"));
                }
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
    public LopHocChiTiet getThongTinLopHoc(int ma_lop_hoc) {
        try {
            Connection conn = DBConnect.getConnection();
            LopHocChiTiet lopHocChiTiet = new LopHocChiTiet();
            String sql = "SELECT * FROM `lop_hoc_chi_tiet` where `ma_lop_hoc` = ? and `tinh_trang` = 1";
            PreparedStatement ps = (PreparedStatement) (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, ma_lop_hoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocVienLopHoc hocVienLopHoc = new HocVienLopHoc();
               
                hocVienLopHoc.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
                hocVienLopHoc.setNgay_dang_ky(rs.getDate("ngay_dang_ky"));
                hocVienLopHoc.setThanh_toan(rs.getBoolean("thanh_toan"));
                hocVienLopHoc.setTinh_trang(rs.getBoolean("tinh_trang"));

                lopHocChiTiet.setMaLopHoc(rs.getInt("ma_lop_hoc"));
                lopHocChiTiet.setListHvlh(hocVienLopHoc);
                
//                System.out.println(rs.getBoolean(ss"tinh_trang"));
//                System.out.println(hocVienLopHoc.getMa_hoc_vien());
      

            }
            for (HocVienLopHoc s : lopHocChiTiet.getListHvlh()) {
                    System.out.println("ma hoc vien:" +s.getMa_hoc_vien());
                }
            ps.close();
            conn.close();
            return lopHocChiTiet;
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

