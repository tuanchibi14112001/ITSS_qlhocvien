/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.dao;

import java.util.List;
import quanlyhocvien.model.HocVien;
import quanlyhocvien.model.HocVienLopHoc;
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
    public HocVienLopHoc getHocVienLopHoc(int ma_lop_hoc, int ma_hoc_vien);
    public int createOrUpdate(int ma_lop_hoc, HocVienLopHoc hocVienLopHoc, int ma_hoc_vien);
    public List<HocVien> getListHocVienChuaThem(int ma_lop_hoc);
}
