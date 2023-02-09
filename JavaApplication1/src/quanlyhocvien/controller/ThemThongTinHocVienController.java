/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import quanlyhocvien.model.HocVien;
import quanlyhocvien.model.HocVienLopHoc;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;
import quanlyhocvien.service.LopHocChiTietService;
import quanlyhocvien.service.LopHocChiTietServiceImpl;
import quanlyhocvien.service.LopHocService;
import quanlyhocvien.service.LopHocServiceImpl;

/**
 *
 * @author xuannang
 */
public class ThemThongTinHocVienController {

    private JButton btn_submit;
    private JLabel jlb_msg;
    private JLabel jlb_hoten;
    private JLabel jlb_sdt;
    private JLabel jlb_email;
    private JDateChooser jdc_ngaydangki;
    private JCheckBox jcb_tinhtranghocphi;
    private JCheckBox jcb_trangthai;
    private LopHoc lop_hoc;
    private LopHocService lop_hoc_service = null;
    private LopHocChiTietService lop_hoc_chi_tiet_service = null;

    public ThemThongTinHocVienController() {
    }

    public ThemThongTinHocVienController(JButton btn_submit, JLabel jlb_msg, JLabel jlb_hoten, JLabel jlb_sdt, JLabel jlb_email,
            JDateChooser jdc_ngaydangki, JCheckBox jcb_tinhtranghocphi, JCheckBox jcb_trangthai) {
        this.btn_submit = btn_submit;
        this.jlb_msg = jlb_msg;
        this.jlb_hoten = jlb_hoten;
        this.jlb_sdt = jlb_sdt;
        this.jlb_email = jlb_email;
        this.jdc_ngaydangki = jdc_ngaydangki;
        this.jcb_tinhtranghocphi = jcb_tinhtranghocphi;
        this.jcb_trangthai = jcb_trangthai;
        this.lop_hoc_service = new LopHocServiceImpl();
        this.lop_hoc_chi_tiet_service = new LopHocChiTietServiceImpl();

    }

    public void setView(HocVienLopHoc hocVienLopHoc, HocVien hocVien) {
        this.lop_hoc = lop_hoc;

        jlb_hoten.setText(hocVien.getHo_ten());
        jlb_sdt.setText(hocVien.getSo_dien_thoai());
        jlb_email.setText(hocVien.getEmail());
        jdc_ngaydangki.setDate(hocVienLopHoc.getNgay_dang_ky());
        jcb_tinhtranghocphi.setSelected(hocVienLopHoc.isThanh_toan());
        jcb_trangthai.setSelected(hocVienLopHoc.isTinh_trang());

    }

    public void setEven(int ma_lop_hoc, HocVienLopHoc hocVienLopHoc, int ma_hoc_vien) {
        btn_submit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!checkNotNull()) {
                    jlb_msg.setText("Vui lòng nhập thông tin bắt buộc!");
                } else {

                    hocVienLopHoc.setNgay_dang_ky(jdc_ngaydangki.getDate());
                    hocVienLopHoc.setThanh_toan(jcb_tinhtranghocphi.isSelected());
                    hocVienLopHoc.setTinh_trang(jcb_trangthai.isSelected());

                    if (showDialog()) {
                        int lastId = lop_hoc_chi_tiet_service.createOrUpdate(ma_lop_hoc, hocVienLopHoc, ma_hoc_vien);
//                        System.out.println(ma_lop_hoc);
//                        System.out.println(hocVienLopHoc.getMa_hoc_vien());
//                        System.out.println(hocVienLopHoc.isThanh_toan());
//                        System.out.println(hocVienLopHoc.isTinh_trang());
//                        System.out.println(ma_hoc_vien);

                        if (lastId != 0) {
                            jlb_msg.setText("Xử lý cập nhật dữ liệu thành công!");

                        } else {
                            jlb_msg.setText("Có lỗi xảy ra, vui lòng thử lại!");

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

    public void setEven(int ma_lop_hoc, HocVienLopHoc hocVienLopHoc, int ma_hoc_vien, LopHocChiTietInfoController lopHocChiTietInfoController, LopHocChiTietController lopHocChiTietController) {
        btn_submit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!checkNotNull()) {
                    jlb_msg.setText("Vui lòng nhập thông tin bắt buộc!");
                } else {

                    hocVienLopHoc.setNgay_dang_ky(jdc_ngaydangki.getDate());
                    hocVienLopHoc.setThanh_toan(jcb_tinhtranghocphi.isSelected());
                    hocVienLopHoc.setTinh_trang(jcb_trangthai.isSelected());

                    if (showDialog()) {
                        int lastId = lop_hoc_chi_tiet_service.createOrUpdate(ma_lop_hoc, hocVienLopHoc, ma_hoc_vien);
//                        System.out.println(ma_lop_hoc);
//                        System.out.println(hocVienLopHoc.getMa_hoc_vien());
//                        System.out.println(hocVienLopHoc.isThanh_toan());
//                        System.out.println(hocVienLopHoc.isTinh_trang());
//                        System.out.println(ma_hoc_vien);

                        if (lastId != 0) {
                            jlb_msg.setText("Xử lý cập nhật dữ liệu thành công!");
                            lopHocChiTietInfoController.setDatatoTable(ma_lop_hoc, lopHocChiTietInfoController, lopHocChiTietController);
                            lopHocChiTietController.setDatatoTable(lopHocChiTietController);

                            //lopHocChiTietInfoController.setEven(lopHocChiTietInfoController);
                        } else {
                            jlb_msg.setText("Xử lý cập nhật dữ liệu thành công!");

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

    public void setEven(int ma_lop_hoc, HocVienLopHoc hocVienLopHoc, int ma_hoc_vien, ChonHocVienController chonHocVienController, LopHocChiTietInfoController lopHocChiTietInfoController, LopHocChiTietController lopHocChiTietController) {
        btn_submit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!checkNotNull()) {
                    jlb_msg.setText("Vui lòng nhập thông tin bắt buộc!");
                } else {

                    hocVienLopHoc.setNgay_dang_ky(jdc_ngaydangki.getDate());
                    hocVienLopHoc.setThanh_toan(jcb_tinhtranghocphi.isSelected());
                    hocVienLopHoc.setTinh_trang(jcb_trangthai.isSelected());

                    if (showDialog()) {
                        int lastId = lop_hoc_chi_tiet_service.createOrUpdate(ma_lop_hoc, hocVienLopHoc, ma_hoc_vien);
                        

                        if (lastId != 0) {
                            jlb_msg.setText("Xử lý cập nhật dữ liệu thành công!");
                            chonHocVienController.setDatatoTable(chonHocVienController, lopHocChiTietInfoController, lopHocChiTietController);
                            lopHocChiTietInfoController.setDatatoTable(ma_lop_hoc, lopHocChiTietInfoController, lopHocChiTietController);
                            lopHocChiTietController.setDatatoTable(lopHocChiTietController);

                            //lopHocChiTietInfoController.setEven(lopHocChiTietInfoController);
                        } else {
                            jlb_msg.setText("Có lỗi xảy ra, vui lòng thử lại!");

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
        if (jdc_ngaydangki.getDate() == null) {
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
