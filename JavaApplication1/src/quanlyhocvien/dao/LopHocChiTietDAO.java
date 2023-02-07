/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.dao;

import java.util.List;
import quanlyhocvien.model.HocVien;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;
import quanlyhocvien.model.LopHocChiTiet;

/**
 *
 * @author xuannang
 */
public interface LopHocChiTietDAO {
    public List<LopHoc> getList();
    public LopHocChiTiet getThongTinLopHoc(int ma_lop_hoc);
//    public int createOrUpdate(LopHoc lop_hoc, KhoaHoc khoa_hoc);
}
