package quanlyhocvien.controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
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
import quanlyhocvien.model.LopHoc;
import quanlyhocvien.utility.ClassTableModel;
import quanlyhocvien.service.LopHocService;
import quanlyhocvien.service.LopHocServiceImpl;

/**
 *
 * @author xuannang
 */
public class LopHocController {
    private JPanel jpn_view;
    private JButton jbt_add;
    private JTextField jtf_search;
    private TableRowSorter<TableModel> rowSorter = null;//sap xep hang
    private LopHocService lop_hoc_service = null;
    private String[] listColumn = {"Mã lớp học", "STT", "Tên khóa học", "Lịch học", "Ngày bắt đầu", "Ngày kết thúc"};

    public LopHocController() {
    }

    public LopHocController(JPanel jpn_view, JButton jbt_add, JTextField jtf_search) {
        this.jpn_view = jpn_view;
        this.jbt_add = jbt_add;
        this.jtf_search = jtf_search;
        this.lop_hoc_service = new LopHocServiceImpl();
    }

    public void setDatatoTable() {
        List<LopHoc> listItem = lop_hoc_service.getList();
        DefaultTableModel model = new ClassTableModel().setTableLopHoc(listItem, listColumn);
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

                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String text = jtf_search.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {

                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
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
