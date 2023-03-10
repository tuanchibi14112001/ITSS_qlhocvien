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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.service.KhoaHocService;
import quanlyhocvien.service.KhoaHocServiceImpl;

/**
 *
 * @author tuan
 */
public class KhoaHocInfoController {

    private JButton btn_submit;
    private JTextField jtf_tenkhoahoc;
    private JRadioButton jrb_n5;
    private JRadioButton jrb_n4;
    private JRadioButton jrb_n3;
    private JRadioButton jrb_n2;
    private JRadioButton jrb_n1;
    private JTextField jtf_hocphi;
    private JDateChooser jdc_ngaybatdau;
    private JDateChooser jdc_ngayketthuc;
    private JTextArea jta_mota;
    private JLabel jlb_msg;
    private JCheckBox jcb_tinhtrang;
    private KhoaHoc khoa_hoc;
    private KhoaHocService khoa_hoc_service = null;

    public KhoaHocInfoController() {
    }

    public KhoaHocInfoController(JButton btn_submit, JTextField jtf_tenkhoahoc,
            JRadioButton jrb_n5, JRadioButton jrb_n4, JRadioButton jrb_n3, JRadioButton jrb_n2, JRadioButton jrb_n1,
            JDateChooser jdc_ngaybatdau, JDateChooser jdc_ngayketthuc,
            JTextField jtf_hocphi, JLabel jlb_msg, JCheckBox jcb_tinhtrang, JTextArea jta_mota) {
        this.btn_submit = btn_submit;
        this.jtf_tenkhoahoc = jtf_tenkhoahoc;
        this.jrb_n5 = jrb_n5;
        this.jrb_n4 = jrb_n4;
        this.jrb_n3 = jrb_n3;
        this.jrb_n2 = jrb_n2;
        this.jrb_n1 = jrb_n1;
        this.jdc_ngaybatdau = jdc_ngaybatdau;
        this.jdc_ngayketthuc = jdc_ngayketthuc;
        this.jtf_hocphi = jtf_hocphi;
        this.jlb_msg = jlb_msg;
        this.jta_mota = jta_mota;
        this.jcb_tinhtrang = jcb_tinhtrang;
        this.khoa_hoc_service = new KhoaHocServiceImpl();

    }

    public void setView(KhoaHoc khoa_hoc) {
        this.khoa_hoc = khoa_hoc;
        jtf_tenkhoahoc.setText(khoa_hoc.getTen_khoa_hoc());

        if (khoa_hoc.getTrinh_do().equals("N5")) {
            jrb_n5.setSelected(true);
        } else if (khoa_hoc.getTrinh_do().equals("N4")) {
            jrb_n4.setSelected(true);
        } else if (khoa_hoc.getTrinh_do().equals("N3")) {
            jrb_n3.setSelected(true);
        } else if (khoa_hoc.getTrinh_do().equals("N2")) {
            jrb_n2.setSelected(true);
        } else {
            jrb_n1.setSelected(true);
        }

        jtf_hocphi.setText(Integer.toString(khoa_hoc.getHoc_phi()));
        jdc_ngaybatdau.setDate(khoa_hoc.getNgay_bat_dau());
        jdc_ngayketthuc.setDate(khoa_hoc.getNgay_ket_thuc());
        jcb_tinhtrang.setSelected(khoa_hoc.isTinh_trang());
        jta_mota.setText(khoa_hoc.getMo_ta());

    }

    public void setEven(KhoaHocController khoa_hoc_controller) {
        btn_submit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!checkNotNull()) {
                    jlb_msg.setText("Vui l??ng nh???p th??ng tin b???t bu???c!");
                } else {
                    khoa_hoc.setTen_khoa_hoc(jtf_tenkhoahoc.getText().trim());
                    khoa_hoc.setHoc_phi(Integer.parseInt(jtf_hocphi.getText().trim()));
                    khoa_hoc.setTinh_trang(jcb_tinhtrang.isSelected());
                    khoa_hoc.setNgay_bat_dau(jdc_ngaybatdau.getDate());
                    khoa_hoc.setNgay_ket_thuc(jdc_ngayketthuc.getDate());
                    khoa_hoc.setMo_ta(jta_mota.getText().trim());

                    if (jrb_n5.isSelected()) {
                        khoa_hoc.setTrinh_do("N5");
                    } else if (jrb_n4.isSelected()) {
                        khoa_hoc.setTrinh_do("N4");
                    } else if (jrb_n3.isSelected()) {
                        khoa_hoc.setTrinh_do("N3");
                    } else if (jrb_n2.isSelected()) {
                        khoa_hoc.setTrinh_do("N2");
                    } else {
                        khoa_hoc.setTrinh_do("N1");
                    }
                    if (showDialog()) {
                        int lastId = khoa_hoc_service.createOrUpdate(khoa_hoc);
                        if (lastId != 0) {
                            khoa_hoc.setMa_khoa_hoc(lastId);
                            jlb_msg.setText("X??? l?? c???p nh???t d??? li???u th??nh c??ng!");
                            khoa_hoc_controller.setDatatoTable(khoa_hoc_controller);
                            khoa_hoc_controller.setEven(khoa_hoc_controller);

                        } else {
                            jlb_msg.setText("C?? l???i x???y ra, vui l??ng th??? l???i!");

                        }
                    }

                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                btn_submit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                btn_submit.setBackground(new Color(76, 175, 80));
            }

        });

    }

    private boolean checkNotNull() {
        if (jtf_tenkhoahoc.getText().length() == 0 || jtf_hocphi.getText().length() == 0 || jta_mota.getText().length() == 0
                || jdc_ngaybatdau.getDate() == null || jdc_ngayketthuc.getDate() == null) {
            return false;
        }
        return true;
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "B???n mu???n c???p nh???t d??? li???u hay kh??ng?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
