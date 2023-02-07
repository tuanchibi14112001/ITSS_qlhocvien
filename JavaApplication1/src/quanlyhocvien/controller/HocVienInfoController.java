package quanlyhocvien.controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import quanlyhocvien.model.HocVien;
import quanlyhocvien.service.HocVienService;
import quanlyhocvien.service.HocVienServiceImpl;

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
    private JCheckBox jcb_tinhtrang;
    private HocVien hoc_vien;
    private HocVienService hoc_vien_service = null;

    public HocVienInfoController() {
    }

    public HocVienInfoController(JButton btn_submit, JTextField jtf_hoten, JDateChooser jdc_ngaysinh,
            JRadioButton jrb_nam, JRadioButton jrb_nu, JRadioButton jrb_khac, JTextField jtf_phone, JTextField jtf_email, JLabel jlb_msg, JCheckBox jcb_tinhtrang) {
        this.btn_submit = btn_submit;
        this.jtf_hoten = jtf_hoten;
        this.jdc_ngaysinh = jdc_ngaysinh;
        this.jrb_nam = jrb_nam;
        this.jrb_nu = jrb_nu;
        this.jrb_khac = jrb_khac;
        this.jtf_phone = jtf_phone;
        this.jtf_email = jtf_email;
        this.jlb_msg = jlb_msg;
        this.jcb_tinhtrang = jcb_tinhtrang;
        this.hoc_vien_service = new HocVienServiceImpl();

    }

    public void setView(HocVien hoc_vien) {
        this.hoc_vien = hoc_vien;
        jtf_hoten.setText(hoc_vien.getHo_ten());
        jdc_ngaysinh.setDate(hoc_vien.getNgay_sinh());
        if (hoc_vien.getGioi_tinh() == 0) {
            jrb_nu.setSelected(true);
        } else if (hoc_vien.getGioi_tinh() == 1) {
            jrb_nam.setSelected(true);
        } else {
            jrb_khac.setSelected(true);
        }
        jtf_phone.setText(hoc_vien.getSo_dien_thoai());
        jtf_email.setText(hoc_vien.getEmail());
        jcb_tinhtrang.setSelected(hoc_vien.isTinh_trang());

    }

    public void setEven(HocVienController hoc_vien_controller) {
        btn_submit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!checkNotNull()) {
                    jlb_msg.setText("Vui lòng nhập thông tin bắt buộc!");
                } else {
                    hoc_vien.setHo_ten(jtf_hoten.getText().trim());
                    hoc_vien.setSo_dien_thoai(jtf_phone.getText().trim());
                    hoc_vien.setEmail(jtf_email.getText().trim());
                    hoc_vien.setTinh_trang(jcb_tinhtrang.isSelected());
                    hoc_vien.setNgay_sinh(jdc_ngaysinh.getDate());
                    if (jrb_nu.isSelected()) {
                        hoc_vien.setGioi_tinh(0);
                    } else if (jrb_nam.isSelected()) {
                        hoc_vien.setGioi_tinh(1);
                    } else {
                        hoc_vien.setGioi_tinh(2);
                    }
                    if (showDialog()) {
                        int lastId = hoc_vien_service.createOrUpdate(hoc_vien);
                        if (lastId != 0) {
                            hoc_vien.setMa_hoc_vien(lastId);
                            jlb_msg.setText("Xử lý cập nhật dữ liệu thành công!");
                            if(!hoc_vien.isTinh_trang()){
                                hoc_vien_service.removeStudentFromClass(hoc_vien);
                            }
                            hoc_vien_controller.setDatatoTable(hoc_vien_controller);
                            hoc_vien_controller.setEven(hoc_vien_controller);
                        } else {
                            jlb_msg.setText("Có lỗi xảy ra, vui lòng thử lại!");

                        }
                    }

                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_submit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_submit.setBackground(new Color(76, 175, 80));
            }

        });

    }

    private boolean checkNotNull() {
        if (jtf_hoten.getText().length() == 0 || jtf_phone.getText().length() == 0
                || jtf_email.getText().length() == 0 || jdc_ngaysinh.getDate() == null) {
            return false;
        }
        return true;
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
