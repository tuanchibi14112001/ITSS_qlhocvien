/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import quanlyhocvien.model.HocVien;
import quanlyhocvien.model.HocVienLopHoc;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;
import quanlyhocvien.model.LopHocChiTiet;
import quanlyhocvien.service.HocVienService;
import quanlyhocvien.service.HocVienServiceImpl;
import quanlyhocvien.service.LopHocChiTietService;
import quanlyhocvien.service.LopHocChiTietServiceImpl;
import quanlyhocvien.service.LopHocService;
import quanlyhocvien.service.LopHocServiceImpl;
import quanlyhocvien.utility.ClassTableModel;
import quanlyhocvien.view.LopHocInfoJFrame;
import quanlyhocvien.view.ThongTinCuTheLopJFrame;

/**
 *
 * @author xuannang
 */
public class LopHocChiTietController {
    private JPanel jpn_view;
    private JButton jbt_add;
    private JTextField jtf_search;
    private TableRowSorter<TableModel> rowSorter = null;//sap xep hang
    private HocVienService hoc_vien_service = null;
    private LopHocChiTietService lop_hoc_chi_tiet_service = null;
    private LopHocService lop_hoc_service = null;
    private String[] listColumn = {"Mã lớp học", "STT", "Tên khóa học", "Lịch học", "Ngày bắt đầu", "Ngày kết thúc", "Sĩ số"};
    private String[] listColumnThongTinHvLop = {"Mã lớp học", "STT", "Họ tên", "Ngày sinh", "Giới Tính", "Email", "Số điện thoại", "Ngày đăng ký", "Thanh Toán"};

    public LopHocChiTietController() {
    }

    public LopHocChiTietController(JPanel jpn_view, JTextField jtf_search) {
        this.jpn_view = jpn_view;
        this.jtf_search = jtf_search;
        this.lop_hoc_chi_tiet_service = new LopHocChiTietServiceImpl();
        this.lop_hoc_service = new LopHocServiceImpl();
        this.hoc_vien_service = new HocVienServiceImpl();
    }

    public void setDatatoTable() {
        List<LopHoc> listItem = lop_hoc_chi_tiet_service.getList();
        DefaultTableModel model = new ClassTableModel().setTableLopHocChiTiet(listItem, listColumn);
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        jtf_search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                String text = jtf_search.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {

                    rowSorter.setRowFilter(new RowFilter() {
                        @Override
                        public boolean include(RowFilter.Entry entry) {
                            String name = entry.getStringValue(2);
                            String text = jtf_search.getText();
                            return name.toLowerCase().contains(text.toLowerCase());

                        }
                    });
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String text = jtf_search.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {

                    rowSorter.setRowFilter(new RowFilter() {
                        @Override
                        public boolean include(RowFilter.Entry entry) {
                            String name = entry.getStringValue(2);
                            String text = jtf_search.getText();
                            return name.toLowerCase().contains(text.toLowerCase());
                        }
                    });
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
        
        
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                
                List<HocVien> listThongTinHv = new ArrayList<HocVien>();
                
                if (e.getClickCount() > 1 && table.getSelectedRow() != -1) {//click 2 lan va co hang trong bang
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    //System.out.println(selectedRowIndex);
                    
                    LopHoc lop_hoc = new LopHoc();
                    lop_hoc = lop_hoc_service.getLopHocID((int) model.getValueAt(selectedRowIndex, 0));

                    LopHocChiTiet lop_hoc_chi_tiet = new LopHocChiTiet();
                    lop_hoc_chi_tiet = lop_hoc_chi_tiet_service.getThongTinLopHoc((int) model.getValueAt(selectedRowIndex, 0));                    
                    
                    for (HocVienLopHoc hoc_vien_lop_hoc : lop_hoc_chi_tiet.getListHvlh()) {
                        int ma_hoc_vien = hoc_vien_lop_hoc.getMa_hoc_vien();
                            
                        HocVien hocVien = new HocVien();
                        hocVien = hoc_vien_service.getHocVienID(ma_hoc_vien);
                        listThongTinHv.add(hocVien);

                    }
                    
                    
                    
                    
//                    ThongTinCuTheLopJpanel panel = new ThongTinCuTheLopJpanel(lop_hoc_chi_tiet.getMaLopHoc(), lop_hoc_chi_tiet.getListHvlh(), listThongTinHv);
                    ThongTinCuTheLopJFrame frame = new ThongTinCuTheLopJFrame(lop_hoc.getMa_lop_hoc(), 
                            lop_hoc_chi_tiet.getListHvlh(), listThongTinHv);
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
//                    System.out.println(lop_hoc_chi_tiet);
                }
            }

        });
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(50, 50));
        table.setRowHeight(50);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        
        jpn_view.removeAll();
        jpn_view.setLayout(new CardLayout());     
        jpn_view.add(scroll);
        jpn_view.validate();//xac nhan
        jpn_view.repaint();
    }
    
//    public void setEven() {
//        jbt_add.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                LopHoc lop_hoc = new LopHoc();
//                KhoaHoc khoa_hoc = new KhoaHoc();
//                khoa_hoc.setMa_khoa_hoc(1);
//                lop_hoc.setTinh_trang(true);
//                lop_hoc.setKhoaHoc(khoa_hoc);
//                LopHocInfoJFrame frame = new LopHocInfoJFrame(lop_hoc);
//                frame.setTitle("Tạo lớp học mới");
//                frame.setResizable(false);
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                jbt_add.setBackground(new Color(0, 200, 83));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                jbt_add.setBackground(new Color(100, 221, 23));
//            }
//
//        });
//    }
}

