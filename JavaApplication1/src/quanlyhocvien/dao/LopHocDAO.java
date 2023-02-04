package quanlyhocvien.dao;

import java.util.List;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;

/**
 *
 * @author xuannang
 */
public interface LopHocDAO {
    public List<LopHoc> getList();
    public LopHoc getLopHocID(int ma_lop_hoc);
    public int createOrUpdate(LopHoc lop_hoc, KhoaHoc khoa_hoc);
}
