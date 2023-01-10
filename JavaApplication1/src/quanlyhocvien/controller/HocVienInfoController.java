package quanlyhocvien.controller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import quanlyhocvien.model.HocVien;

/**
 *
 * @author tuan
 */
public class HocVienInfoController {

    private JButton btn_submit;
    private JTextField jtf_hoten;
    private JDateChooser jdc_ngaysinh;
    private JRadioButton jrb_nam;
    private JRadioButton jrb_nu;
    private JRadioButton jrb_khac;
    private JTextField jtf_phone;
    private JTextField jtf_email;
    private JLabel jlb_msg;

    public HocVienInfoController() {
    }

    public HocVienInfoController(JButton btn_submit, JTextField jtf_hoten, JDateChooser jdc_ngaysinh, JRadioButton jrb_nam, JRadioButton jrb_nu, JRadioButton jrb_khac, JTextField jtf_phone, JTextField jtf_email, JLabel jlb_msg) {
        this.btn_submit = btn_submit;
        this.jtf_hoten = jtf_hoten;
        this.jdc_ngaysinh = jdc_ngaysinh;
        this.jrb_nam = jrb_nam;
        this.jrb_nu = jrb_nu;
        this.jrb_khac = jrb_khac;
        this.jtf_phone = jtf_phone;
        this.jtf_email = jtf_email;
        this.jlb_msg = jlb_msg;
    }

    

    public void setView(HocVien hoc_vien) {
        jtf_hoten.setText(hoc_vien.getHo_ten());
        jdc_ngaysinh.setDate(hoc_vien.getNgay_sinh());
        if(hoc_vien.getGioi_tinh() == 0){
            jrb_nu.setSelected(true);
        }
        else if(hoc_vien.getGioi_tinh() == 1){
            jrb_nam.setSelected(true);
        }
        else
            jrb_khac.setSelected(true);
        jtf_phone.setText(hoc_vien.getSo_dien_thoai());
        jtf_email.setText(hoc_vien.getEmail());
    }
        

}
