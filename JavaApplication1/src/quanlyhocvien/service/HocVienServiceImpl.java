
package quanlyhocvien.service;

import java.util.List;
import quanlyhocvien.dao.HocVienDAO;
import quanlyhocvien.dao.HocVienDAOIplm;
import quanlyhocvien.model.HocVien;

/**
 *
 * @author tuan
 */
public class HocVienServiceImpl implements HocVienService{

    private HocVienDAO hoc_vien_dao= null;

    public HocVienServiceImpl() {
        this.hoc_vien_dao = new HocVienDAOIplm();
    }
    
    
    @Override
    public List<HocVien> getList() {
        return hoc_vien_dao.getList();
    }
    
    
}
