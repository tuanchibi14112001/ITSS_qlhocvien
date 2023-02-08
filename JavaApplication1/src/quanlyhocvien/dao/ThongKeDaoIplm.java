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
import quanlyhocvien.model.HocVien;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.KhoaHocThongKe;

/**
 *
 * @author tuan
 */
public class ThongKeDaoIplm  implements ThongKeDAO{

    @Override
    public List<KhoaHocThongKe> getListKhoaHocThongKe() {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT khoa_hoc.ma_khoa_hoc, COUNT(lop_hoc_chi_tiet.ma_hoc_vien)  as tonghocvien from khoa_hoc LEFT join (lop_hoc LEFT JOIN lop_hoc_chi_tiet on lop_hoc.ma_lop_hoc = lop_hoc_chi_tiet.ma_lop_hoc ) on khoa_hoc.ma_khoa_hoc  = lop_hoc.ma_khoa_hoc WHERE lop_hoc_chi_tiet.tinh_trang = 1 "
                    + "group by khoa_hoc.ma_khoa_hoc ORDER by tonghocvien DESC LIMIT 5";
            
            List<KhoaHocThongKe> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHoc khoahoc = new KhoaHoc();
                KhoaHocThongKe khoahoc_thongke = new KhoaHocThongKe();
                khoahoc.setMa_khoa_hoc(rs.getInt("ma_khoa_hoc"));
                khoahoc_thongke.setKhoaHoc(khoahoc);
                khoahoc_thongke.setTong_hocvien(rs.getInt("tonghocvien"));
                list.add(khoahoc_thongke);
            }
            ps.close();
            conn.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDaoIplm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//        public static void main(String[] args) {
//        ThongKeDAO thongKeDAO = new ThongKeDaoIplm();
//        for(KhoaHocThongKe a:thongKeDAO.getListKhoaHocThongKe()){
//            System.out.println(a.getTong_hocvien());
//            System.out.println(a.getKhoaHoc().getMa_khoa_hoc());
//        }
//        
//    }
    
    
}
