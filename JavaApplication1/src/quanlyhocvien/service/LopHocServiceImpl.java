package quanlyhocvien.service;

import quanlyhocvien.dao.LopHocDAOImpl;
import java.util.List;
import quanlyhocvien.model.LopHoc;
import quanlyhocvien.dao.LopHocDAO;

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

}