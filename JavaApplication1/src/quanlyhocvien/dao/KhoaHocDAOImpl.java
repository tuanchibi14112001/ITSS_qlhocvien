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
import quanlyhocvien.model.KhoaHoc;

/**
 *
 * @author xuannang
 */
public class KhoaHocDAOImpl  implements KhoaHocDAO {
    @Override
    public List<KhoaHoc> getList(){
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select * from khoa_hoc where tinh_trang_kh = 1";
            List<KhoaHoc> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhoaHoc khoaHoc = new KhoaHoc();
                khoaHoc.setMa_khoa_hoc(rs.getInt("ma_khoa_hoc"));
                khoaHoc.setTen_khoa_hoc(rs.getString("ten_khoa_hoc"));
                khoaHoc.setTrinh_do(rs.getString("trinh_do"));
                khoaHoc.setHoc_phi(rs.getInt("hoc_phi"));
                khoaHoc.setMo_ta(rs.getString("mo_ta"));
                khoaHoc.setNgay_bat_dau(rs.getDate("ngay_bat_dau"));
                khoaHoc.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc"));
                khoaHoc.setTinh_trang(rs.getBoolean("tinh_trang_kh"));
                list.add(khoaHoc);
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
    public KhoaHoc getKhoaHocID(int ma_khoa_hoc) {
        try {
            Connection conn = DBConnect.getConnection();
            KhoaHoc khoaHoc = new KhoaHoc();
            String sql = "SELECT * FROM khoa_hoc WHERE ma_khoa_hoc = ?";
            PreparedStatement ps = (PreparedStatement) (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, ma_khoa_hoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                khoaHoc.setMa_khoa_hoc(rs.getInt("ma_khoa_hoc"));
                khoaHoc.setTen_khoa_hoc(rs.getString("ten_khoa_hoc"));
                khoaHoc.setTrinh_do(rs.getString("trinh_do"));
                khoaHoc.setHoc_phi(rs.getInt("hoc_phi"));
                khoaHoc.setMo_ta(rs.getString("mo_ta"));
                khoaHoc.setNgay_bat_dau(rs.getDate("ngay_bat_dau"));
                khoaHoc.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc"));
                khoaHoc.setTinh_trang(rs.getBoolean("tinh_trang_kh"));

            }
            ps.close();
            conn.close();
            return khoaHoc;
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int createOrUpdate(KhoaHoc khoa_hoc) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "INSERT INTO khoa_hoc(ma_khoa_hoc,ten_khoa_hoc, trinh_do, hoc_phi, mo_ta, ngay_bat_dau, ngay_ket_thuc,tinh_trang_kh) VALUES(?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE ma_khoa_hoc = VALUES(ma_khoa_hoc),ten_khoa_hoc = VALUES(ten_khoa_hoc), trinh_do = VALUES(trinh_do), hoc_phi = VALUES(hoc_phi), mo_ta = VALUES(mo_ta), ngay_bat_dau = VALUES(ngay_bat_dau), ngay_ket_thuc = VALUES(ngay_ket_thuc), tinh_trang_kh = VALUES(tinh_trang_kh);";
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, khoa_hoc.getMa_khoa_hoc());
            ps.setString(2, khoa_hoc.getTen_khoa_hoc());
            ps.setString(3, khoa_hoc.getTrinh_do());
            ps.setInt(4, khoa_hoc.getHoc_phi());
            ps.setString(5, khoa_hoc.getMo_ta());
            ps.setDate(6, new Date(khoa_hoc.getNgay_bat_dau().getTime()));
            ps.setDate(7, new Date(khoa_hoc.getNgay_ket_thuc().getTime()));
            ps.setBoolean(8, khoa_hoc.isTinh_trang());
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
            Logger.getLogger(KhoaHocDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
