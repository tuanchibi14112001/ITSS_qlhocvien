package quanlyhocvien.service;

import quanlyhocvien.dao.LopHocDAOImpl;
import java.util.List;
import quanlyhocvien.model.LopHoc;
import quanlyhocvien.dao.LopHocDAO;
import quanlyhocvien.model.KhoaHoc;

/**
 *
 * @author PC
 */
public class LopHocServiceImpl implements LopHocService{
    private LopHocDAO lopHocDAO = null;
    
    public LopHocServiceImpl(){
        lopHocDAO = new LopHocDAOImpl();
    }
    @Override
    public List<LopHoc> getList() {
        return lopHocDAO.getList();
    }
    
    @Override
    public LopHoc getLopHocID(int ma_lop_hoc) {
        return lopHocDAO.getLopHocID(ma_lop_hoc);
    }

    @Override
    public int createOrUpdate(LopHoc lop_hoc, KhoaHoc khoa_hoc) {
        return lopHocDAO.createOrUpdate(lop_hoc, khoa_hoc);
    }

}