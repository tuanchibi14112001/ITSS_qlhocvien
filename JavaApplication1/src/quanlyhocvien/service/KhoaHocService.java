package quanlyhocvien.service;

import java.util.List;
import quanlyhocvien.model.KhoaHoc;

/**
 *
 * @author tuan
 */
public interface KhoaHocService {
    public List<KhoaHoc> getList();
    
    public KhoaHoc getKhoaHocID(int ma_khoa_hoc);

    public int createOrUpdate(KhoaHoc khoa_hoc);
    
}
