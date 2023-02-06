/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.model;
import java.util.List;

/**
 *
 * @author xuannang
 */
public class LopHocChiTiet {
    private int maLopHoc;
    private List<HocVienLopHoc> listHvlh;
    

    public int getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(int maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public List<HocVienLopHoc> getListHvlh() {
        return listHvlh;
    }

    public void setListHvlh(HocVienLopHoc hvlh) {
        this.listHvlh.add(hvlh);
    }

    

}
