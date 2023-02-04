package quanlyhocvien.service;

import java.util.List;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;

/**
 *
 * @author tuan
 */
public interface LopHocService {
    public List<LopHoc> getList();
    
    public LopHoc getLopHocID(int ma_lop_hoc);

    public int createOrUpdate(LopHoc lop_hoc, KhoaHoc khoa_hoc);
    
}
