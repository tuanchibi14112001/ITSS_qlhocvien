/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.controller;

import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import quanlyhocvien.model.TaiKhoan;
import quanlyhocvien.service.TaiKhoanService;
import quanlyhocvien.service.TaiKhoanServiceImpl;
import quanlyhocvien.view.MainJFrame;

/**
 *
 * @author tuan
 */
public class TaiKhoanController {

    private Dialog dialog;
    private JButton btn_submit;
    private JTextField jtf_username;
    private JTextField jtf_password;

    private TaiKhoanService taiKhoanService = null;

    public TaiKhoanController(Dialog dialog, JButton btn_submit, JTextField jtf_username, JTextField jtf_password) {
        this.dialog = dialog;
        this.btn_submit = btn_submit;
        this.jtf_username = jtf_username;
        this.jtf_password = jtf_password;
        taiKhoanService = new TaiKhoanServiceImpl();
    }

    public void setEvent() {
        btn_submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtf_username.getText().length() == 0 || jtf_password.getText().length() == 0) {
                    JOptionPane.showMessageDialog(dialog, "Vui lòng nhập dữ liệu bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    TaiKhoan tai_khoan = taiKhoanService.login(jtf_username.getText(), jtf_password.getText());
                    if (tai_khoan == null) {
                        JOptionPane.showMessageDialog(dialog, "Sai tài khoản hoặc mật khẩu", "Warning", JOptionPane.WARNING_MESSAGE);

                    } else if (!tai_khoan.isTinh_trang()) {
                        JOptionPane.showMessageDialog(dialog, "Tài khoản của bạn bị khóa", "Warning", JOptionPane.WARNING_MESSAGE);

                    } else {
                        dialog.dispose();
                        MainJFrame main_frame = new MainJFrame();
                        main_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

                        main_frame.setVisible(true);

                    }

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // btnSubmit.setBackground(new Color(0,200,83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // btnSubmit.setBackground(new Color(100,221,23));
            }

        });

    }

}
