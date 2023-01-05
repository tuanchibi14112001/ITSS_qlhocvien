
package quanlyhocvien.controller;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import quanlyhocvien.model.HocVien;
import quanlyhocvien.service.HocVienService;
import quanlyhocvien.service.HocVienServiceImpl;
import quanlyhocvien.utility.ClassTableModel;

/**
 *
 * @author tuan
 */
public class HocVienController {
    private JPanel jpn_view;
    private JButton jbt_add;
    private JTextField jtf_search;
    private TableRowSorter<TableModel> rowSorter = null;//sap xep hang
    private HocVienService hoc_vien_service = null;
    private String[] listColumn = {"ID","STT", "Họ tên","Giới tính", "Ngày sinh", "Email", "Số điện thoại", "Tình trạng"};

    public HocVienController() {
    }

    
    public HocVienController(JPanel jpn_view, JButton jbt_add, JTextField jtf_search) {
        this.jpn_view = jpn_view;
        this.jbt_add = jbt_add;
        this.jtf_search = jtf_search;
        this.hoc_vien_service = new HocVienServiceImpl();
    }
    
    public void setDatatoTable(){
        List<HocVien> listItem = hoc_vien_service.getList();
        DefaultTableModel model = new ClassTableModel().setTableHocVien(listItem, listColumn);
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
    }
    
}
