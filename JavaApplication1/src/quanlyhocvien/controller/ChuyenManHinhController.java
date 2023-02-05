package quanlyhocvien.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import quanlyhocvien.bean.DanhMucBean;
import quanlyhocvien.view.HocVienJpanel;
import quanlyhocvien.view.KhoaHocJpanel;
import quanlyhocvien.view.LopHocChiTietJpanel;
import quanlyhocvien.view.LopHocJpanel;
import quanlyhocvien.view.ThongKeJpanel;
import quanlyhocvien.view.TrangChuJpanel;

/**
 *
 * @author TUAN
 */
public class ChuyenManHinhController {

    private JPanel jpn_root;
    private String kind_selected = "";
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel jpn_root) {
        this.jpn_root = jpn_root;
    }

    public void setView(JPanel jpn_item, JLabel jlb_item) {
        kind_selected = "TrangChu";
        jpn_item.setBackground(new Color(96, 100, 191));
        jlb_item.setBackground(new Color(96, 100, 191));

        JPanel node = new TrangChuJpanel();
        jpn_root.removeAll();
        jpn_root.setLayout(new BorderLayout());
        jpn_root.add(node);
        jpn_root.validate();
        jpn_root.repaint();

    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEven(item.getKind(), item.getJpn(), item.getJlb()));
        }

    }

    class LabelEven implements MouseListener {

        private String kind;
        private JPanel node;
        private JPanel jpn_item;
        private JLabel jlb_item;

        public LabelEven(String kind, JPanel jpn_item, JLabel jlb_item) {
            this.kind = kind;
            this.jpn_item = jpn_item;
            this.jlb_item = jlb_item;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJpanel();
                    break;
                case "HocVien":
                    node = new HocVienJpanel();
                    break;
                case "KhoaHoc":
                    node = new KhoaHocJpanel();
                    break;
                case "LopHoc":
                    node = new LopHocJpanel();
                    break;
                case "LopHocChiTiet":
                    node = new LopHocChiTietJpanel();
                    break;
                case "ThongKe":
                    node = new ThongKeJpanel();
                    break;
                 default:
                    node = new TrangChuJpanel();
                    break;
            }
            jpn_root.removeAll();
            jpn_root.setLayout(new BorderLayout());
            jpn_root.add(node);
            jpn_root.validate();//xac nhan
            jpn_root.repaint();
            setChangeBackground(kind);

        }

        @Override
        public void mousePressed(MouseEvent e) {
            kind_selected = kind;
            jpn_item.setBackground(new Color(96, 100, 191));
            jlb_item.setBackground(new Color(96, 100, 191));

        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpn_item.setBackground(new Color(96, 100, 191));
            jlb_item.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kind_selected.equalsIgnoreCase(kind)) {// so sanh ko phan biet hoa thuong
                jpn_item.setBackground(new Color(76, 175, 80));
                jlb_item.setBackground(new Color(76, 175, 80));

            }
        }

    }

    public void setChangeBackground(String kind) {
        for (DanhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));

            } else {
                item.getJpn().setBackground(new Color(76, 175, 80));
                item.getJlb().setBackground(new Color(76, 175, 80));

            }
        }
    }

}
