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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
    private JButton btn_print;
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

    public LopHocChiTietInfoController(JPanel jpn_view, JButton btn_add, JButton btn_print, JTextField jtf_search, JLabel jlb_tenlop, JLabel jlb_siso,
            JLabel jlb_lichhoc) {
        this.jpn_view = jpn_view;
        this.btn_add = btn_add;
        this.btn_print = btn_print;
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

    public void setView(int ma_lop_hoc) {
        
        List<HocVien> listThongTinHv = new ArrayList<HocVien>();
        
        LopHocChiTiet lop_hoc_chi_tiet = new LopHocChiTiet();
        lop_hoc_chi_tiet = lop_hoc_chi_tiet_service.getThongTinLopHoc(ma_lop_hoc);

        for (HocVienLopHoc hoc_vien_lop_hoc : lop_hoc_chi_tiet.getListHvlh()) {
            int ma_hoc_vien = hoc_vien_lop_hoc.getMa_hoc_vien();

            HocVien hocVien = new HocVien();
            hocVien = hoc_vien_service.getHocVienID(ma_hoc_vien);
            listThongTinHv.add(hocVien);

        }

        this.ma_lop_hoc = ma_lop_hoc;

        LopHoc lopHoc = new LopHoc();
        lopHoc = lop_hoc_service.getLopHocID(ma_lop_hoc);

//        System.out.println("quanlyhocvien.controller.LopHocChiTietInfoController.setView()" + lopHoc.getMa_lop_hoc());
        jlb_tenlop.setText(lopHoc.getKhoaHoc().getTen_khoa_hoc());
        jlb_siso.setText(String.valueOf(listThongTinHv.size()));
        jlb_lichhoc.setText(lopHoc.getLich_hoc());

    }

    public void setDatatoTable(int ma_lop_hoc, LopHocChiTietInfoController lopHocChiTietInfoController, LopHocChiTietController lopHocChiTietController) {
        List<HocVien> listThongTinHv = new ArrayList<HocVien>();
        
        LopHocChiTiet lop_hoc_chi_tiet = new LopHocChiTiet();
        lop_hoc_chi_tiet = lop_hoc_chi_tiet_service.getThongTinLopHoc(ma_lop_hoc);

        for (HocVienLopHoc hoc_vien_lop_hoc : lop_hoc_chi_tiet.getListHvlh()) {
            int ma_hoc_vien = hoc_vien_lop_hoc.getMa_hoc_vien();

            HocVien hocVien = new HocVien();
            hocVien = hoc_vien_service.getHocVienID(ma_hoc_vien);
            listThongTinHv.add(hocVien);

        }
        
        DefaultTableModel model = new ClassTableModel().setTableThongTinLop(lop_hoc_chi_tiet.getListHvlh(), listThongTinHv, listColumnThongTinHvLop);
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
                    ThemThongTinHocVienJFrame frame = new ThemThongTinHocVienJFrame(ma_lop_hoc, hoc_vien_lop_hoc, hoc_vien, lopHocChiTietInfoController, lopHocChiTietController);
                    frame.setTitle("Thông tin chi tiết");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                }
            }

        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(String.class, centerRenderer);
        
        int i =0;
        for(i = 0 ; i<table.getColumnCount(); i++){
                  table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        }

        table.getTableHeader().setFont(new Font("Yrsa", Font.BOLD, 27));
        table.getTableHeader().setPreferredSize(new Dimension(50, 50));
        table.setRowHeight(50);
        table.setFont(new Font("Yrsa", Font.PLAIN, 22));
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        //table.getColumnModel().getColumn(1).setPreferredWidth(10);
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));

        jpn_view.removeAll();
        jpn_view.setLayout(new CardLayout());
        jpn_view.add(scroll);
        jpn_view.validate();//xac nhan
        jpn_view.repaint();
    }

    public void setEven(LopHocChiTietInfoController lopHocChiTietInfoController, LopHocChiTietController lopHocChiTietController) {
        btn_add.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println(".mouseClicked()");
                ChonHocVienJFrame frame = new ChonHocVienJFrame(ma_lop_hoc, lopHocChiTietInfoController, lopHocChiTietController);
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

        btn_print.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                LopHoc lopHoc = new LopHoc();
                lopHoc = lop_hoc_service.getLopHocID(ma_lop_hoc);

                LopHocChiTiet lopHocChiTiet = new LopHocChiTiet();
                lopHocChiTiet = lop_hoc_chi_tiet_service.getThongTinLopHoc(ma_lop_hoc);

                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("hv_tronglop");//tao trang tinh
                XSSFRow row = null;
                Cell cell = null;

                row = sheet.createRow((short) 2);
                row.setHeight((short) 500);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("DANH SÁCH HỌC VIÊN");

                row = sheet.createRow(3);
                row.setHeight((short) 500);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("STT");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Họ và tên");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Ngày sinh");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Giới tính");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Số điện thoại");
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("Email");
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue("Ngày đăng ký");
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue("Thanh Toán");

                List<HocVienLopHoc> listItem = lop_hoc_chi_tiet_service.getThongTinLopHoc(ma_lop_hoc).getListHvlh();

                if (listItem != null) {
                    FileOutputStream out = null;
                    int s = listItem.size();
                    for (int i = 0; i < s; i++) {
                        HocVienLopHoc hoc_vien_lop_hoc = listItem.get(i);
                        HocVien hoc_vien = hoc_vien_service.getHocVienID(hoc_vien_lop_hoc.getMa_hoc_vien());
                        row = sheet.createRow((short) 4 + i);
                        row.setHeight((short) 400);

                        cell = row.createCell(0, CellType.NUMERIC);//o
                        cell.setCellValue(i + 1);

                        row.createCell(0).setCellValue(i + 1);
                        row.createCell(1).setCellValue(hoc_vien.getHo_ten());
                        row.createCell(2).setCellValue(hoc_vien.getNgay_sinh().toString());
                        if (hoc_vien.getGioi_tinh() == 0) {
                            row.createCell(3).setCellValue("Nữ");
                        } else if (hoc_vien.getGioi_tinh() == 1) {
                            row.createCell(3).setCellValue("Nam");

                        } else {
                            row.createCell(3).setCellValue("Khác");

                        }
                        row.createCell(4).setCellValue(hoc_vien.getSo_dien_thoai());
                        row.createCell(5).setCellValue(hoc_vien.getEmail());
                        row.createCell(6).setCellValue(hoc_vien_lop_hoc.getNgay_dang_ky().toString());

                        if (hoc_vien_lop_hoc.isThanh_toan() == true) {
                            row.createCell(7).setCellValue("Đã thanh toán");
                        } else {
                            row.createCell(7).setCellValue("Chưa thanh toán");

                        }
                    }

                    File f = new File("../" + lopHoc.getKhoaHoc().getTen_khoa_hoc() + " - " + lopHoc.getLich_hoc() + ".xlsx");
                    try {
                        out = new FileOutputStream(f);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(HocVienController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        workbook.write(out);
                        JOptionPane.showMessageDialog(
                                null,
                                "Xuất file thành công!",
                                "About",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(LopHocChiTietInfoController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        out.close();
                    } catch (IOException ex) {
                        Logger.getLogger(LopHocChiTietInfoController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        });
    }
}
