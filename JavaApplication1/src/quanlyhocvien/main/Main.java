
package quanlyhocvien.main;

import javax.swing.JFrame;
import quanlyhocvien.view.MainJFrame;

/**
 *
 * @author TUAN
 */
public class Main {
    public static void main(String[] args) {
        MainJFrame main_frame = new MainJFrame();
        main_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //main_frame.setUndecorated(true);
        main_frame.setVisible(true);
    }
}
