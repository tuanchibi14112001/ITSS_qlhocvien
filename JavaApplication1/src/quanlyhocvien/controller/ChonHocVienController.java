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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import quanlyhocvien.model.HocVien;
import quanlyhocvien.service.HocVienService;
import quanlyhocvien.service.HocVienServiceImpl;
import quanlyhocvien.service.LopHocChiTietService;
import quanlyhocvien.service.LopHocChiTietServiceImpl;
import quanlyhocvien.utility.ClassTableModel;
import quanlyhocvien.view.HocVienInfoJFrame;

/**
 *
 * @author xuannang
 */
public class ChonHocVienController {
    private int ma_lop_hoc;
    private JPanel jpn_view;
    private JTextField jtf_search;
    private TableRowSorter<TableModel> rowSorter = null;//sap xep hang
    private HocVienService hoc_vien_service = null;
    private LopHocChiTietService lop_hoc_chi_tiet_service = null;
    private String[] listColumn = {"ID", "STT", "Họ tên", "Giới tính", "Ngày sinh", "Email", "Số điện thoại"};

    public ChonHocVienController() {
    }

    public ChonHocVienController(JPanel jpn_view, JTextField jtf_search, int ma_lop_hoc) {
        this.ma_lop_hoc = ma_lop_hoc;
        this.jpn_view = jpn_view;
        this.jtf_search = jtf_search;
        this.hoc_vien_service = new HocVienServiceImpl();
        this.lop_hoc_chi_tiet_service = new LopHocChiTietServiceImpl();
        this.hoc_vien_service = new HocVienServiceImpl();
    }


    public void setDatatoTable() {
        List<HocVien> listItem = lop_hoc_chi_tiet_service.getListHocVienChuaThem(ma_lop_hoc);
        DefaultTableModel model = new ClassTableModel().setTableHocVien(listItem, listColumn);
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

    
}
