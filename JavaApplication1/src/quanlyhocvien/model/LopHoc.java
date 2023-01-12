/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.model;

/**
 *
 * @author xuannang
 */
public class LopHoc {
    private int ma_lop_hoc;
    private String lich_hoc;
    private KhoaHoc khoaHoc;
    private boolean tinh_trang;

    public int getMa_lop_hoc() {
        return ma_lop_hoc;
    }

    public void setMa_lop_hoc(int ma_lop_hoc) {
        this.ma_lop_hoc = ma_lop_hoc;
    }

    public String getLich_hoc() {
        return lich_hoc;
    }

    public void setLich_hoc(String lich_hoc) {
        this.lich_hoc = lich_hoc;
    }
    
    

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public boolean isTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }
    
    
    @Override
    public String toString() {
        return "LopHoc{" + "ma_lop_hoc=" + ma_lop_hoc + ", ten_khoa_hoc=" + khoaHoc.getTen_khoa_hoc() 
                + ", lich_hoc=" + lich_hoc + ", ngay_bat_dau=" + khoaHoc.getNgay_bat_dau() 
                + ", ngay_ket_thuc=" + khoaHoc.getNgay_ket_thuc() + ", tinh_trang=" + tinh_trang + '}';
    }

    public Object get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
