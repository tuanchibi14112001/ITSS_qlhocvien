/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.service;

import java.util.List;
import quanlyhocvien.dao.LopHocChiTietDAO;
import quanlyhocvien.dao.LopHocChiTietDAOImpl;
import quanlyhocvien.dao.LopHocDAO;
import quanlyhocvien.dao.LopHocDAOImpl;
import quanlyhocvien.model.HocVien;
import quanlyhocvien.model.HocVienLopHoc;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;
import quanlyhocvien.model.LopHocChiTiet;

/**
 *
 * @author xuannang
 */
public class LopHocChiTietServiceImpl implements LopHocChiTietService{
    private LopHocChiTietDAO lopHocChiTietDAO = null;
    
    public LopHocChiTietServiceImpl(){
        lopHocChiTietDAO = new LopHocChiTietDAOImpl();
    }
    @Override
    public List<LopHoc> getList() {
        return lopHocChiTietDAO.getList();
    }
    
    @Override
    public LopHocChiTiet getThongTinLopHoc(int ma_lop_hoc) {
        return lopHocChiTietDAO.getThongTinLopHoc(ma_lop_hoc);
    }
    
    @Override
    public HocVienLopHoc getHocVienLopHoc(int ma_lop_hoc, int ma_hoc_vien){
        return lopHocChiTietDAO.getHocVienLopHoc(ma_lop_hoc, ma_hoc_vien);
    }
    
    @Override
    public int createOrUpdate(int ma_lop_hoc, HocVienLopHoc hocVienLopHoc, int ma_hoc_vien){
        return lopHocChiTietDAO.createOrUpdate(ma_lop_hoc, hocVienLopHoc, ma_hoc_vien);
    }
    
    @Override
    public List<HocVien> getListHocVienChuaThem(int ma_lop_hoc) {
        return lopHocChiTietDAO.getListHocVienChuaThem(ma_lop_hoc);
    }
}
