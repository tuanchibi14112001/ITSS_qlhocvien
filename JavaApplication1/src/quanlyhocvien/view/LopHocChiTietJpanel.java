/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quanlyhocvien.view;

import quanlyhocvien.controller.LopHocChiTietController;
import quanlyhocvien.controller.LopHocController;

/**
 *
 * @author TUAN
 */
public class LopHocChiTietJpanel extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeJpanel
     */
    public LopHocChiTietJpanel() {
        initComponents();
        LopHocChiTietController lop_hoc_chi_tiet_controller = new LopHocChiTietController(jpn_view, jtf_search);
        lop_hoc_chi_tiet_controller.setDatatoTable();
//        lop_hoc_chi_tiet_controller.setEven();
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
        btn_print = new javax.swing.JButton();
        jtf_search = new javax.swing.JTextField();
        jpn_view = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        btn_print.setBackground(new java.awt.Color(76, 175, 80));
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setText("+In");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        jtf_search.setFont(new java.awt.Font("Yrsa", 0, 18)); // NOI18N
        jtf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_searchActionPerformed(evt);
            }
        });

        jpn_view.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpn_viewLayout = new javax.swing.GroupLayout(jpn_view);
        jpn_view.setLayout(jpn_viewLayout);
        jpn_viewLayout.setHorizontalGroup(
            jpn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpn_viewLayout.setVerticalGroup(
            jpn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );

        jLabel1.setText("Tìm theo tên:");

        javax.swing.GroupLayout jpn_rootLayout = new javax.swing.GroupLayout(jpn_root);
        jpn_root.setLayout(jpn_rootLayout);
        jpn_rootLayout.setHorizontalGroup(
            jpn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_rootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jtf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(btn_print))
            .addComponent(jpn_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpn_rootLayout.setVerticalGroup(
            jpn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_rootLayout.createSequentialGroup()
                .addGroup(jpn_rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_search)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jpn_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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
    }// </editor-fold>//GEN-END:initComponents

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_printActionPerformed

    private void jtf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpn_root;
    private javax.swing.JPanel jpn_view;
    private javax.swing.JTextField jtf_search;
    // End of variables declaration//GEN-END:variables
}
