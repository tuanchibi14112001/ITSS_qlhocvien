
package quanlyhocvien.controller;

import javax.swing.JButton;
import javax.swing.JTextField;
import quanlyhocvien.model.HocVien;

/**
 *
 * @author tuan
 */
public class HocVienInfoController {
    private JButton btn_submit;
    private JTextField jtf_hoten;

    public HocVienInfoController() {
    }

    public HocVienInfoController(JButton btn_submit, JTextField jtf_hoten) {
        this.btn_submit = btn_submit;
        this.jtf_hoten = jtf_hoten;
    }
    
    public void setView(HocVien hoc_vien){
        jtf_hoten.setText(hoc_vien.getHo_ten());
    }
    
}
