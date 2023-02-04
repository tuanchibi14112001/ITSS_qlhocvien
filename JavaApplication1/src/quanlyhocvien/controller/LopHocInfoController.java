/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.LopHoc;
import quanlyhocvien.service.LopHocService;
import quanlyhocvien.service.LopHocServiceImpl;

/**
 *
 * @author xuannang
 */
public class LopHocInfoController {
    private JButton btn_submit;
    private JList jlist_khoahoc;
    private JTextField jtf_lichhoc;
    private JLabel jlb_msg;
    private JCheckBox jcb_tinhtrang;
    private LopHoc lop_hoc;
    private LopHocService lop_hoc_service = null;

    public LopHocInfoController() {
    }

    public LopHocInfoController(JButton btn_submit, JTextField jtf_lichhoc, 
            JList jlist_khoahoc, JLabel jlb_msg, JCheckBox jcb_tinhtrang) {
        this.btn_submit = btn_submit;
        this.jtf_lichhoc = jtf_lichhoc;
        this.jlb_msg = jlb_msg;
        this.jcb_tinhtrang = jcb_tinhtrang;
        this.jlist_khoahoc = jlist_khoahoc;
        this.lop_hoc_service = new LopHocServiceImpl();
        
    } 

    public void setView(LopHoc lop_hoc) {
        this.lop_hoc = lop_hoc;
        jtf_lichhoc.setText(lop_hoc.getLich_hoc());
                            System.out.println(lop_hoc.getKhoaHoc().getMa_khoa_hoc());

        jlist_khoahoc.setSelectedIndex(lop_hoc.getKhoaHoc().getMa_khoa_hoc()-1);

        
        
        jcb_tinhtrang.setSelected(lop_hoc.isTinh_trang());
        

    }

    public void setEven() {
        btn_submit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!checkNotNull()) {
                    jlb_msg.setText("Vui lòng nhập thông tin bắt buộc!");
                } else {
                    KhoaHoc khoa_hoc= new KhoaHoc();
                    String s = (String) jlist_khoahoc.getSelectedValue();
                    khoa_hoc.setMa_khoa_hoc(Integer.parseInt(s.substring(0, 1)));
                    lop_hoc.setKhoaHoc(khoa_hoc);
                    lop_hoc.setLich_hoc(jtf_lichhoc.getText().trim());
                    lop_hoc.setTinh_trang(jcb_tinhtrang.isSelected());
                    
                    if (showDialog()) {
                        int lastId = lop_hoc_service.createOrUpdate(lop_hoc, khoa_hoc);
                        if (lastId != 0) {
                            lop_hoc.setMa_lop_hoc(lastId);
                            jlb_msg.setText("Xử lý cập nhật dữ liệu thành công!");
                            
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
        if (jtf_lichhoc.getText().length() == 0 ) {
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
