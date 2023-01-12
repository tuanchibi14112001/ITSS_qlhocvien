package quanlyhocvien.service;

import quanlyhocvien.dao.KhoaHocDAOImpl;
import java.util.List;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.dao.KhoaHocDAO;

/**
 *
 * @author PC
 */
public class KhoaHocServiceImpl implements KhoaHocService{
    private KhoaHocDAO khoaHocDAO = null;
    
    public KhoaHocServiceImpl(){
        khoaHocDAO = new KhoaHocDAOImpl();
    }
    @Override
    public List<KhoaHoc> getList() {
        return khoaHocDAO.getList();
    }
    
    @Override
    public KhoaHoc getKhoaHocID(int ma_hoc_vien) {
        return khoaHocDAO.getKhoaHocID(ma_hoc_vien);
    }

    @Override
    public int createOrUpdate(KhoaHoc khoa_hoc) {
        return khoaHocDAO.createOrUpdate(khoa_hoc);
    }

}