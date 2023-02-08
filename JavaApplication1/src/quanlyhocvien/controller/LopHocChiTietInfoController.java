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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
import quanlyhocvien.view.ChonHocVienJFrame;
import quanlyhocvien.view.LopHocInfoJFrame;
import quanlyhocvien.view.ThemThongTinHocVienJFrame;

/**
 *
 * @author xuannang
 */
public class LopHocChiTietInfoController {
    private int ma_lop_hoc;
    private JPanel jpn_view;
    private JButton btn_add;
    private JTextField jtf_search;
    private JLabel jlb_tenlop;
    private JLabel jlb_siso;
    private JLabel jlb_lichhoc;
    private LopHoc lop_hoc;
    private TableRowSorter<TableModel> rowSorter = null;//sap xep hang
    private HocVienService hoc_vien_service = null;
    private LopHocService lop_hoc_service = null;
    private LopHocChiTietService lop_hoc_chi_tiet_service = null;
    private String[] listColumnThongTinHvLop = {"Mã lớp học", "STT", "Họ tên", "Ngày sinh", "Giới Tính", "Email", "Số điện thoại", "Ngày đăng ký", "Thanh Toán"};
    private HocVien hocVien;
    private HocVienLopHoc hocVienLopHoc;

    public LopHocChiTietInfoController() {
    }

    public LopHocChiTietInfoController(JPanel jpn_view,JButton btn_add, JTextField jtf_search, JLabel jlb_tenlop, JLabel jlb_siso,
              JLabel jlb_lichhoc) {
        this.jpn_view = jpn_view;
        this.btn_add = btn_add;
        this.jtf_search = jtf_search;
        this.jlb_tenlop = jlb_tenlop;
        this.jlb_siso = jlb_siso;
        this.jlb_lichhoc = jlb_lichhoc;
        this.lop_hoc_chi_tiet_service = new LopHocChiTietServiceImpl();
        this.lop_hoc_service = new LopHocServiceImpl();
        this.hoc_vien_service = new HocVienServiceImpl();
        this.hocVien = new HocVien();
        this.hocVienLopHoc = new HocVienLopHoc();
        
    } 

    public void setView(int ma_lop_hoc, List<HocVien> listHv) {
        this.ma_lop_hoc = ma_lop_hoc;
        
        LopHoc lopHoc = new LopHoc();
        lopHoc = lop_hoc_service.getLopHocID(ma_lop_hoc);
        
        System.out.println("quanlyhocvien.controller.LopHocChiTietInfoController.setView()" + lopHoc.getMa_lop_hoc());
        
        jlb_tenlop.setText(lopHoc.getKhoaHoc().getTen_khoa_hoc());      
        jlb_siso.setText(String.valueOf(listHv.size()));
        jlb_lichhoc.setText(lopHoc.getLich_hoc());
            
    }

    public void setDatatoTable(List<HocVienLopHoc> listHvlh, List<HocVien> listHv) {
        DefaultTableModel model = new ClassTableModel().setTableThongTinLop(listHvlh, listHv, listColumnThongTinHvLop);
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
                if (e.getClickCount() > 1 && table.getSelectedRow() != -1) {//click 2 lan va co hang trong bang
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    //System.out.println(selectedRowIndex);

                    HocVien hoc_vien = new HocVien();
                    hoc_vien = hoc_vien_service.getHocVienID((int) model.getValueAt(selectedRowIndex, 0));
                   
                    hocVien = hoc_vien;
                    
                    
                    HocVienLopHoc hoc_vien_lop_hoc = new HocVienLopHoc();
                    hoc_vien_lop_hoc = lop_hoc_chi_tiet_service.getHocVienLopHoc(ma_lop_hoc, hoc_vien.getMa_hoc_vien());
                    
                    hocVienLopHoc = hoc_vien_lop_hoc;
                    

                    //hoc_vien.setHo_ten(model.getValueAt(selectedRowIndex, 2).toString());
                    ThemThongTinHocVienJFrame frame = new ThemThongTinHocVienJFrame(ma_lop_hoc, hoc_vien_lop_hoc, hoc_vien);
                    frame.setTitle("Thông tin chi tiết");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

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
    
    public void setEven() {
        btn_add.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(".mouseClicked()");
                ChonHocVienJFrame frame = new ChonHocVienJFrame(ma_lop_hoc);
                frame.setTitle("Thông tin học viên");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_add.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_add.setBackground(new Color(100, 221, 23));
            }

        });
    }
}
