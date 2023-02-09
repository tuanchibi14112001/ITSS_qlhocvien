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
public class TrangChuDAOIplm implements TrangChuDAO {
    @Override
    public int[] getList(){
        try {
            int[] list = new int[3];
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT count(*) as `tong hoc vien` FROM `hoc_vien`";
           
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                list[0] = rs.getInt("tong hoc vien"); 
                
            }
            
            String sql1 = "SELECT count(*) as `tong khoa hoc` FROM `khoa_hoc`";
            PreparedStatement ps1 = cons.prepareCall(sql1);
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next()){
                
                list[2] = rs1.getInt("tong khoa hoc"); 
                
            }
            
            String sql2 = "SELECT count(*) as `tong lop hoc` FROM `lop_hoc`";
            PreparedStatement ps2 = cons.prepareCall(sql2);
            ResultSet rs2 = ps2.executeQuery();

            while(rs2.next()){
                
                list[1] = rs2.getInt("tong lop hoc"); 
                
            }
            ps.close();
            rs.close();
            ps1.close();
            rs1.close();
            ps2.close();
            rs2.close();
            cons.close();
            return list;
            } catch (SQLException ex) {
                  ex.printStackTrace();
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        TrangChuDAO trang_chu_dao = new TrangChuDAOIplm();
//        for (int i:trang_chu_dao.getList()) {
//            System.out.println(i);
//        }
//        
//    }
}
