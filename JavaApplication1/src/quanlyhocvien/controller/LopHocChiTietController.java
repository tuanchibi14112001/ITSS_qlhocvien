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
import javax.swing.JLabel;
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
import quanlyhocvien.view.LopHocInfoJFrame;
import quanlyhocvien.view.ThongTinCuTheLopJFrame;

/**
 *
 * @author xuannang
 */
public class LopHocChiTietController {

    private List<LopHoc> listLopHoc;
    private JPanel jpn_view;
    private JButton jbt_add;
    private JButton jbt_print;
    private JTextField jtf_search;
    private TableRowSorter<TableModel> rowSorter = null;//sap xep hang
    private HocVienService hoc_vien_service = null;
    private LopHocChiTietService lop_hoc_chi_tiet_service = null;
    private LopHocService lop_hoc_service = null;
    private String[] listColumn = {"Mã lớp học", "STT", "Tên khóa học", "Lịch học", "Ngày bắt đầu", "Ngày kết thúc", "Sĩ số"};
    private String[] listColumnThongTinHvLop = {"Mã lớp học", "STT", "Họ tên", "Ngày sinh", "Giới Tính", "Email", "Số điện thoại", "Ngày đăng ký", "Thanh Toán"};

    public LopHocChiTietController() {
    }

    public LopHocChiTietController(JPanel jpn_view, JButton jbt_print, JTextField jtf_search) {
        this.jbt_print = jbt_print;
        this.jpn_view = jpn_view;
        this.jtf_search = jtf_search;
        this.lop_hoc_chi_tiet_service = new LopHocChiTietServiceImpl();
        this.lop_hoc_service = new LopHocServiceImpl();
        this.hoc_vien_service = new HocVienServiceImpl();
        this.listLopHoc = new ArrayList<>();
    }

    public void setDatatoTable(LopHocChiTietController lopHocChiTietController) {
        List<LopHoc> listItem = lop_hoc_chi_tiet_service.getList();
        listLopHoc = listItem;
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
                    ThongTinCuTheLopJFrame frame = new ThongTinCuTheLopJFrame(lop_hoc.getMa_lop_hoc(), lopHocChiTietController);
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
//                    System.out.println(lop_hoc_chi_tiet);
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

    public void setEven() {
        jbt_print.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("hv_hientai");//tao trang tinh
                XSSFRow row = null;
                Cell cell = null;

                row = sheet.createRow((short) 2);
                row.setHeight((short) 500);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("DANH SÁCH LỚP HỌC");

                row = sheet.createRow(3);
                row.setHeight((short) 500);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("STT");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Tên khóa học");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Lịch học");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Ngày bắt đầu");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Ngày kết thúc");
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("Sỹ số");

                List<LopHoc> listItem = listLopHoc;

                if (listItem != null) {
                    FileOutputStream out = null;
                    int s = listItem.size();
                    for (int i = 0; i < s; i++) {
                        LopHoc lop_hoc = listItem.get(i);
                        row = sheet.createRow((short) 4 + i);
                        row.setHeight((short) 400);

                        cell = row.createCell(0, CellType.NUMERIC);//o
                        cell.setCellValue(i + 1);

                        row.createCell(0).setCellValue(i + 1);
                        row.createCell(1).setCellValue(lop_hoc.getKhoaHoc().getTen_khoa_hoc());
                        row.createCell(2).setCellValue(lop_hoc.getLich_hoc());

                        row.createCell(3).setCellValue(lop_hoc.getKhoaHoc().getNgay_bat_dau().toString());
                        row.createCell(4).setCellValue(lop_hoc.getKhoaHoc().getNgay_ket_thuc().toString());
                        row.createCell(5).setCellValue(lop_hoc.getSySo());
                    }
                    File f = new File("../danh_sach_lop_hoc.xlsx");
                    try {
                        out = new FileOutputStream(f);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(HocVienController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        workbook.write(out);
                        JOptionPane.showMessageDialog(
                                null,
                                "Tạo file danh_sach_lop_hoc.xlsx thành công!",
                                "About",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(LopHocChiTietController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        out.close();
                    } catch (IOException ex) {
                        Logger.getLogger(LopHocChiTietController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        });
    }
}
