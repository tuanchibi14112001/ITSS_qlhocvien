/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.service;


import quanlyhocvien.dao.TrangChuDAO;
import quanlyhocvien.dao.TrangChuDAOIplm;

/**
 *
 * @author xuannang
 */
public class TrangChuServiceIplm implements TrangChuService{
    private TrangChuDAO trangChuDAO = null;
    
    public TrangChuServiceIplm(){
        trangChuDAO = new TrangChuDAOIplm();
    }
    @Override
    public int[] getList() {
        return trangChuDAO.getList();
    }
}
