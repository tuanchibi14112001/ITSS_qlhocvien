/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.controller;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;
import quanlyhocvien.service.LopHocService;
import quanlyhocvien.service.LopHocServiceImpl;
import quanlyhocvien.service.TrangChuService;
import quanlyhocvien.service.TrangChuServiceIplm;


/**
 *
 * @author xuannang
 */
public class TrangChuController {
    private JLabel jlb_hocvien;
    private JLabel jlb_khoahoc;
    private JLabel jlb_lophoc;
    private TrangChuService trang_chu_service = null;

    public TrangChuController() {
    }

    public TrangChuController(JLabel jlb_hocvien, JLabel jlb_lophoc, JLabel jlb_khoahoc) {
        this.jlb_hocvien = jlb_hocvien;
        this.jlb_lophoc = jlb_lophoc;
        this.jlb_khoahoc = jlb_khoahoc;
        
        this.trang_chu_service = new TrangChuServiceIplm();
    }
    
    public void setView() {
        int[] list = trang_chu_service.getList();
        this.jlb_hocvien.setText(String.valueOf(list[0]));
        this.jlb_lophoc.setText(String.valueOf(list[1]));
        this.jlb_khoahoc.setText(String.valueOf(list[2]));
    }
                
}
