/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlyhocvien.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import quanlyhocvien.controller.ChonHocVienController;
import quanlyhocvien.controller.LopHocChiTietController;
import quanlyhocvien.controller.LopHocChiTietInfoController;
import quanlyhocvien.controller.ThemThongTinHocVienController;

/**
 *
 * @author xuannang
 */
public class ChonHocVienJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChonHocVienJFrame
     */
    public ChonHocVienJFrame(int ma_lop_hoc, LopHocChiTietInfoController lopHocChiTietInfoController, LopHocChiTietController lopHocChiTietController) {
        initComponents();
        
        ChonHocVienController chon_hoc_vien_controller = new ChonHocVienController(jpn_view, jtf_search, ma_lop_hoc);
         chon_hoc_vien_controller.setDatatoTable(chon_hoc_vien_controller, lopHocChiTietInfoController, lopHocChiTietController);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpn_root = new javax.swing.JPanel();
        jtf_search = new javax.swing.JTextField();
        jpn_view = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtf_search.setFont(new java.awt.Font("Yrsa", 0, 20)); // NOI18N

        javax.swing.GroupLayout jpn_viewLayout = new javax.swing.GroupLayout(jpn_view);
        jpn_view.setLayout(jpn_viewLayout);
        jpn_viewLayout.setHorizontalGroup(
            jpn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpn_viewLayout.setVerticalGroup(
            jpn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        jLabel1.setText("T??m theo t??n:");

        javax.swing.GroupLayout jpn_rootLayout = new javax.swing.GroupLayout(jpn_root);
        jpn_root.setLayout(jpn_rootLayout);
        jpn_rootLayout.setHorizontalGroup(
            jpn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_rootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 555, Short.MAX_VALUE))
            .addComponent(jpn_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpn_rootLayout.setVerticalGroup(
            jpn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_rootLayout.createSequentialGroup()
                .addGroup(jpn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpn_rootLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jtf_search, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpn_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpn_root, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpn_root, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpn_root;
    private javax.swing.JPanel jpn_view;
    private javax.swing.JTextField jtf_search;
    // End of variables declaration//GEN-END:variables
}
