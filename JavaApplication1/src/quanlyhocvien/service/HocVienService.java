package quanlyhocvien.service;

import java.util.List;
import quanlyhocvien.model.HocVien;

/**
 *
 * @author tuan
 */
public interface HocVienService {

    public List<HocVien> getList();

    public HocVien getHocVienID(int ma_hoc_vien);

    public int createOrUpdate(HocVien hoc_vien);

    public int removeStudentFromClass(HocVien hoc_vien);

}
