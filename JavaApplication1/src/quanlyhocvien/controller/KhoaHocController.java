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
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.service.KhoaHocService;
import quanlyhocvien.service.KhoaHocServiceImpl;
import quanlyhocvien.utility.ClassTableModel;
import quanlyhocvien.view.KhoaHocInfoJFrame;

/**
 *
 * @author xuannang
 */
public class KhoaHocController {
    private JPanel jpn_view;
    private JButton jbt_add;
    private JButton btn_print;
    private JTextField jtf_search;
    private TableRowSorter<TableModel> rowSorter = null;//sap xep hang
    private KhoaHocService khoa_hoc_service = null;
    private String[] listColumn = {"Mã khóa học","STT", "Tên khóa học", "Trình độ", "Học phí (VNĐ)", "Ngày bắt đầu", "Ngày kết thúc"};

    public KhoaHocController() {
    }

    public KhoaHocController(JPanel jpn_view, JButton btn_print, JButton jbt_add, JTextField jtf_search) {
        this.jpn_view = jpn_view;
        this.btn_print = btn_print;
        this.jbt_add = jbt_add;
        this.jtf_search = jtf_search;
        this.khoa_hoc_service = new KhoaHocServiceImpl();
    }

    public void setDatatoTable(KhoaHocController khoa_hoc_controller) {
        List<KhoaHoc> listItem = khoa_hoc_service.getList();
        DefaultTableModel model = new ClassTableModel().setTableKhoaHoc(listItem, listColumn);
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

                    KhoaHoc khoa_hoc = new KhoaHoc();
                    khoa_hoc = khoa_hoc_service.getKhoaHocID((int) model.getValueAt(selectedRowIndex, 0));

                    //hoc_vien.setHo_ten(model.getValueAt(selectedRowIndex, 2).toString());
                    KhoaHocInfoJFrame frame = new KhoaHocInfoJFrame(khoa_hoc,khoa_hoc_controller);
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

    public void setEven(KhoaHocController khoa_hoc_controller) {
        jbt_add.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                KhoaHoc khoa_hoc = new KhoaHoc();
                khoa_hoc.setTrinh_do("N5");
                khoa_hoc.setTinh_trang(true);
                KhoaHocInfoJFrame frame = new KhoaHocInfoJFrame(khoa_hoc,khoa_hoc_controller);
                frame.setTitle("Tạo khóa học mới");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                jbt_add.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                jbt_add.setBackground(new Color(100, 221, 23));
            }

        });
        
        btn_print.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("KHOA_HOC");//tao trang tinh
                XSSFRow row = null;
                Cell cell = null;

                row = sheet.createRow((short) 2);
                row.setHeight((short) 500);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("DANH SÁCH KHÓA HỌC");

                row = sheet.createRow(3);
                row.setHeight((short) 500);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("STT");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Tên khóa học");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Trình độ");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Học phí(VNĐ)");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Ngày bắt đầu");
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("Ngày kết thúc");

                List<KhoaHoc> listItem = khoa_hoc_service.getList();

                if (listItem != null) {
                    FileOutputStream out = null;
                    int s = listItem.size();
                    for (int i = 0; i < s; i++) {
                        KhoaHoc khoa_hoc = listItem.get(i);
                        row = sheet.createRow((short) 4 + i);
                        row.setHeight((short) 400);

                        cell = row.createCell(0, CellType.NUMERIC);//o
                        cell.setCellValue(i + 1);

                        row.createCell(0).setCellValue(i + 1);
                        row.createCell(1).setCellValue(khoa_hoc.getTen_khoa_hoc());
                        row.createCell(2).setCellValue(khoa_hoc.getTrinh_do());
                        
                        row.createCell(3).setCellValue(khoa_hoc.getHoc_phi());
                        
                           
                        row.createCell(4).setCellValue(khoa_hoc.getNgay_bat_dau().toString());
                        row.createCell(5).setCellValue(khoa_hoc.getNgay_ket_thuc().toString());
                    }
                    File f = new File("../khoa_hoc.xlsx");
                    try {
                        out = new FileOutputStream(f);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(HocVienController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        workbook.write(out);
                        JOptionPane.showMessageDialog(
                                null,
                                "Tạo file khoa_hoc.xlsx thành công!",
                                "About",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(KhoaHocController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        out.close();
                    } catch (IOException ex) {
                        Logger.getLogger(KhoaHocController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //jbt_add.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
              //  jbt_add.setBackground(new Color(100, 221, 23));
            }

        });
    }
}
