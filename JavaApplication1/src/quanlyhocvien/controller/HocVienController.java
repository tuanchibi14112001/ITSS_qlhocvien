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
import javax.swing.JFrame;
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
import quanlyhocvien.utility.ClassTableModel;
import quanlyhocvien.view.HocVienInfoJFrame;

/**
 *
 * @author tuan
 */
public class HocVienController {

    private JPanel jpn_view;
    private JButton jbt_add;
    private JButton jbt_print;
    private JTextField jtf_search;
    private TableRowSorter<TableModel> rowSorter = null;//sap xep hang
    private HocVienService hoc_vien_service = null;
    private String[] listColumn = {"ID", "STT", "Họ tên", "Giới tính", "Ngày sinh", "Email", "Số điện thoại"};

    public HocVienController() {
    }

    public HocVienController(JPanel jpn_view, JButton jbt_add, JTextField jtf_search) {
        this.jpn_view = jpn_view;
        this.jbt_add = jbt_add;
        this.jtf_search = jtf_search;
        this.hoc_vien_service = new HocVienServiceImpl();
    }

    public HocVienController(JPanel jpn_view, JButton jbt_add, JButton jbt_print, JTextField jtf_search) {
        this.jpn_view = jpn_view;
        this.jbt_add = jbt_add;
        this.jbt_print = jbt_print;
        this.jtf_search = jtf_search;
        this.hoc_vien_service = new HocVienServiceImpl();
    }

    public void setDatatoTable(HocVienController hoc_vien_controller) {
        List<HocVien> listItem = hoc_vien_service.getList();
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
        //xu li click
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

                    //hoc_vien.setHo_ten(model.getValueAt(selectedRowIndex, 2).toString());
                    HocVienInfoJFrame frame = new HocVienInfoJFrame(hoc_vien, hoc_vien_controller);
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

    public void setEven(HocVienController hoc_vien_controller) {
        jbt_add.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                HocVienInfoJFrame frame = new HocVienInfoJFrame(new HocVien(), hoc_vien_controller);
                frame.setTitle("Đăng kí học viên");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbt_add.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbt_add.setBackground(new Color(100, 221, 23));
            }

        });
        // in ra excel

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

                List<HocVien> listItem = hoc_vien_service.getList();

                if (listItem != null) {
                    FileOutputStream out = null;
                    int s = listItem.size();
                    for (int i = 0; i < s; i++) {
                        HocVien hoc_vien = listItem.get(i);
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
                    }
                    File f = new File("../hoc_vien.xlsx");
                    try {
                        out = new FileOutputStream(f);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(HocVienController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        workbook.write(out);
                        JOptionPane.showMessageDialog(
                    null, 
                    "Tạo file hoc_vien.xlsx thành công!", 
                    "About", 
                    JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(HocVienController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        out.close();
                    } catch (IOException ex) {
                        Logger.getLogger(HocVienController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jbt_add.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbt_add.setBackground(new Color(100, 221, 23));
            }

        });

    }
    
}
