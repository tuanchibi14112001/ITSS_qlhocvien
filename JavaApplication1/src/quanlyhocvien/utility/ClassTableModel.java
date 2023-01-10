package quanlyhocvien.utility;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import quanlyhocvien.model.HocVien;

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
}
