package quanlyhocvien.utility;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import quanlyhocvien.model.HocVien;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;

/**
 *
 * @author tuan
 */
public class ClassTableModel {

    public DefaultTableModel setTableHocVien(List<HocVien> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int cols = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        HocVien hoc_vien = null;
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                hoc_vien = listItem.get(i);
                obj = new Object[cols];
                obj[0] = hoc_vien.getMa_hoc_vien();
                obj[1] = i + 1;
                obj[2] = hoc_vien.getHo_ten();
                if (hoc_vien.getGioi_tinh() == 1) {
                    obj[3] = "Nam";
                } else if (hoc_vien.getGioi_tinh() == 0) {
                    obj[3] = "Nữ";
                } else {
                    obj[3] = "Khác";
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                obj[4] = formatter.format(hoc_vien.getNgay_sinh());
                obj[5] = hoc_vien.getEmail();
                obj[6] = hoc_vien.getSo_dien_thoai();
//                obj[7] = hoc_vien.getTinh_trang();
                
                dtm.addRow(obj);
            }
        }

        return dtm;
    }
        
        public DefaultTableModel setTableKhoaHoc(List<KhoaHoc> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int cols = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        KhoaHoc khoa_hoc = null;
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                khoa_hoc = listItem.get(i);
                obj = new Object[cols];
                obj[0] = khoa_hoc.getMa_khoa_hoc();
                obj[1] = i + 1;
                obj[2] = khoa_hoc.getTen_khoa_hoc();
                obj[3] = khoa_hoc.getTrinh_do();
//                obj[4] = khoa_hoc.getMo_ta();
                obj[4] = khoa_hoc.getHoc_phi();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                obj[5] = formatter.format(khoa_hoc.getNgay_bat_dau());
                SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                obj[6] = formatter2.format(khoa_hoc.getNgay_ket_thuc());
                
                dtm.addRow(obj);
            }
        }

        return dtm;
    }
    
    public DefaultTableModel setTableLopHoc(List<LopHoc> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;

            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int cols = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        LopHoc lop_hoc = null;
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                lop_hoc = listItem.get(i);
                obj = new Object[cols];
                obj[0] = lop_hoc.getMa_lop_hoc();
                obj[1] = i + 1;
                obj[2] = lop_hoc.getKhoaHoc().getTen_khoa_hoc();
                obj[3] = lop_hoc.getLich_hoc();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                obj[4] = formatter.format(lop_hoc.getKhoaHoc().getNgay_bat_dau());
                SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                obj[5] = formatter2.format(lop_hoc.getKhoaHoc().getNgay_ket_thuc());
                
                dtm.addRow(obj);
            }
        }

        return dtm;
    }
}
