/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.service;

import java.util.List;
import quanlyhocvien.dao.LopHocChiTietDAO;
import quanlyhocvien.dao.LopHocChiTietDAOImpl;
import quanlyhocvien.dao.LopHocDAO;
import quanlyhocvien.dao.LopHocDAOImpl;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;

/**
 *
 * @author xuannang
 */
public class LopHocChiTietServiceImpl implements LopHocChiTietService{
    private LopHocChiTietDAO lopHocChiTietDAO = null;
    
    public LopHocChiTietServiceImpl(){
        lopHocChiTietDAO = new LopHocChiTietDAOImpl();
    }
    @Override
    public List<LopHoc> getList() {
        return lopHocChiTietDAO.getList();
    }
    
    
}
