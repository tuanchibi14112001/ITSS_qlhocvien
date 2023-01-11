package quanlyhocvien.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
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
            String sql = "SELECT * FROM hoc_vien WHERE tinh_trang =1 ORDER BY ma_hoc_vien DESC";
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
                hoc_vien.setTinh_trang(rs.getBoolean("tinh_trang"));

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
    @Override
    public HocVien getHocVienID(int ma_hoc_vien) {
        try {
            Connection conn = DBConnect.getConnection();
            HocVien hoc_vien = new HocVien();
            String sql = "SELECT * FROM hoc_vien WHERE ma_hoc_vien = ?";
            PreparedStatement ps = (PreparedStatement) (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, ma_hoc_vien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hoc_vien.setMa_hoc_vien(rs.getInt("ma_hoc_vien"));
                hoc_vien.setHo_ten(rs.getString("ho_ten"));
                hoc_vien.setNgay_sinh(rs.getDate("ngay_sinh"));
                hoc_vien.setGioi_tinh(rs.getInt("gioi_tinh"));
                hoc_vien.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hoc_vien.setEmail(rs.getString("email"));
                hoc_vien.setTinh_trang(rs.getBoolean("tinh_trang"));

            }
            ps.close();
            conn.close();
            return hoc_vien;
        } catch (SQLException ex) {
            Logger.getLogger(HocVienDAOIplm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int createOrUpdate(HocVien hoc_vien) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "INSERT INTO hoc_vien(ma_hoc_vien,ho_ten, ngay_sinh, gioi_tinh, so_dien_thoai, email,tinh_trang) VALUES(?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE ma_hoc_vien = VALUES(ma_hoc_vien),ho_ten = VALUES(ho_ten), ngay_sinh = VALUES(ngay_sinh), gioi_tinh = VALUES(gioi_tinh), so_dien_thoai = VALUES(so_dien_thoai), email = VALUES(email), tinh_trang = VALUES(tinh_trang);";
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hoc_vien.getMa_hoc_vien());
            ps.setString(2, hoc_vien.getHo_ten());
            ps.setDate(3, new Date(hoc_vien.getNgay_sinh().getTime()));
            ps.setInt(4, hoc_vien.getGioi_tinh());
            ps.setString(5, hoc_vien.getSo_dien_thoai());
            ps.setString(6, hoc_vien.getEmail());
            ps.setBoolean(7, hoc_vien.isTinh_trang());
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
            Logger.getLogger(HocVienDAOIplm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
