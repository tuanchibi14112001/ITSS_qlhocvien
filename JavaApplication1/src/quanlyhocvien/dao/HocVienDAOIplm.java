package quanlyhocvien.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlyhocvien.model.HocVien;

/**
 *
 * @author tuan
 */
public class HocVienDAOIplm implements HocVienDAO {

    @Override
    public List<HocVien> getList() {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM hoc_vien ORDER BY ma_hoc_vien DESC";
            List<HocVien> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocVien hoc_vien = new HocVien();
                hoc_vien.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
                hoc_vien.setHo_ten(rs.getString("ho_ten"));
                hoc_vien.setNgay_sinh(rs.getDate("ngay_sinh"));
                hoc_vien.setGioi_tinh(rs.getInt("gioi_tinh"));
                hoc_vien.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hoc_vien.setEmail(rs.getString("email"));
//                hoc_vien.setTinh_trang(rs.getInt("tinh_trang"));

                list.add(hoc_vien);
            }
            ps.close();
            conn.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(HocVienDAOIplm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public static void main(String[] args) {
//        HocVienDAO hoc_vien_dao = new HocVienDAOIplm();
//        System.out.println(hoc_vien_dao.getList());
//    }

}
