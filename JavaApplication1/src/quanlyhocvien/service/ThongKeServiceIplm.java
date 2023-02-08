/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.service;

import java.util.List;
import quanlyhocvien.dao.ThongKeDAO;
import quanlyhocvien.dao.ThongKeDaoIplm;
import quanlyhocvien.model.KhoaHocThongKe;


/**
 *
 * @author tuan
 */
public class ThongKeServiceIplm implements ThongKeService{
    ThongKeDAO thongKeDAO = new ThongKeDaoIplm();

    @Override
    public List<KhoaHocThongKe> getListKhoaHocThongKe() {
        return thongKeDAO.getListKhoaHocThongKe();
        
    }
    
}
