
package quanlyhocvien.main;

import javax.swing.JFrame;
import quanlyhocvien.view.DangNhapJDialog;
import quanlyhocvien.view.MainJFrame;

/**
 *
 * @author TUAN
 */
public class Main {
    public static void main(String[] args) {
        DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        dialog.setTitle("Đăng Nhập Hệ  Thống");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
    }
}
