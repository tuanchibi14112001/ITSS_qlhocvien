
package quanlyhocvien.model;

import java.util.Date;

/**
 *
 * @author tuan
 */
public class HocVien {
    private int ma_hoc_vien;
    private String ho_ten;
    private Date ngay_sinh;
    private int gioi_tinh; // 1: Nam 0: Nu 3: Khac
    private String so_dien_thoai;
    private String email;

    public HocVien() {
    }
    
    

    public HocVien(int ma_hoc_vien, String ho_ten, Date ngay_sinh, int gioi_tinh, String so_dien_thoai, String email) {
        this.ma_hoc_vien = ma_hoc_vien;
        this.ho_ten = ho_ten;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.so_dien_thoai = so_dien_thoai;
        this.email = email;
    }

    public int getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public void setMa_hoc_vien(int ma_hoc_vien) {
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public int getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(int gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

   

    @Override
    public String toString() {
        return "\nHocVien{" + "ma_hoc_vien=" + ma_hoc_vien + ", ho_ten=" + ho_ten + ", ngay_sinh=" + ngay_sinh + ", gioi_tinh=" + gioi_tinh + ", so_dien_thoai=" + so_dien_thoai + ", email=" + email +  '}';
    }
    
    
    
    
}
