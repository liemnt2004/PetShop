package com.app.Ui;

import com.app.Entitys.*;
import java.sql.*;
import com.app.Utils.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ChiTietCaLamJDialog extends javax.swing.JDialog {

    private int index = -1;
    private ArrayList<ChiTietCaLam> listCaLam = new ArrayList<>();

    /**
     * Creates new form ThemMoiLoaiJDialog
     */
    public ChiTietCaLamJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        caLam();
        ngayLamTrongThang();
        NhanVienCaLam();
        ngaylam();
    }

    private void NhanVienCaLam() {
        try {
            DefaultComboBoxModel combox = new DefaultComboBoxModel<>();
            combox = (DefaultComboBoxModel) cbocalamnhanvien.getModel();
            combox.removeAllElements();
            CaLam calam = (CaLam) cbocalam.getSelectedItem();
            Date ngaylam = (Date) cbongaylam.getSelectedItem();
            String sql = "{call dbo.NhanVienChuaCaLam(?, ?)}";
            ResultSet rs = JdbcHelper.executeQuery(sql, ngaylam, calam.getMaCL());
            while (rs.next()) {
                combox.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietCaLamJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ngayLamTrongThang() {
        try {
            DefaultComboBoxModel combox = new DefaultComboBoxModel();
            combox = (DefaultComboBoxModel) cbongaylam.getModel();
            combox.removeAllElements();
            String sql = "{call dbo.NgayCaLam}";
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                combox.addElement(rs.getDate(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChiTietCaLamJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void caLam() {
        try {
            DefaultComboBoxModel combox = new DefaultComboBoxModel();
            combox = (DefaultComboBoxModel) cbocalam.getModel();
            combox.removeAllElements();
            List<CaLam> list = new ArrayList<>();
            String sql = "select * FROM CaLam";
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                CaLam cl = new CaLam(rs.getString(1), rs.getString(3), rs.getString(2));
                list.add(cl);
            }
            for (CaLam caLam : list) {
                combox.addElement(caLam);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietCaLamJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void themCaLam() {
        String sql = "INSERT INTO ChiTietCaLam VALUES (?, ?, ?)";
        CaLam calam = (CaLam) cbocalam.getSelectedItem();
        String MaNv = (String) cbocalamnhanvien.getSelectedItem();
        Date ngaylam = (Date) cbongaylam.getSelectedItem();
        int rowsAffected = JdbcHelper.executeUpdate(sql, calam.getMaCL(), MaNv, ngaylam);
        if (rowsAffected > 0) {
            MsgBox.AlertSuccess(this, "Thêm Ca Làm Thành Công");
        } else {
            MsgBox.AlertFall(this, "Thêm Ca Làm Thất Bại");
        }
    }

    private void ngaylam() {
        try {
            DefaultComboBoxModel combox = new DefaultComboBoxModel();
            combox = (DefaultComboBoxModel) cbongay.getModel();
            combox.removeAllElements();
            String sql = "SELECT ChiTietCaLam.NgayLam FROM ChiTietCaLam GROUP BY ChiTietCaLam.NgayLam";
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                combox.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietCaLamJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void duLieuBangCaLam(String ngay) {
        try {
            DefaultTableModel tblmodel = new DefaultTableModel();
            tblmodel = (DefaultTableModel) tblCaLam.getModel();
            tblmodel.setRowCount(0);
            String sql = "select * FROM ChiTietCaLam WHERE NgayLam = (?)";
            ResultSet rs = JdbcHelper.executeQuery(sql, ngay);
            listCaLam.clear();
            while (rs.next()) {
                ChiTietCaLam ctcl = new ChiTietCaLam(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                listCaLam.add(ctcl);
            }
            int i = 0;
            for (ChiTietCaLam chiTietCaLam : listCaLam) {
                tblmodel.addRow(new Object[]{i, chiTietCaLam.getMaCl(), chiTietCaLam.getMaNV(), chiTietCaLam.getNgayLam(), chiTietCaLam.getMachitietcalam()});
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietCaLamJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void xoaCaLam() {
        String sql = "DELETE FROM ChiTietCaLam WHERE ChiTietCaLam.MaCL = ? AND ChiTietCaLam.MaNV = ? AND ChiTietCaLam.NgayLam = ?";
        String Macl = (String) tblCaLam.getValueAt(index, 1);
        String manv = (String) tblCaLam.getValueAt(index, 2);
        Date NgayLam = (Date) tblCaLam.getValueAt(index, 3);
        System.out.println(Macl + manv + NgayLam);
        int rowsAffected = JdbcHelper.executeUpdate(sql, Macl, manv, NgayLam);
        if (rowsAffected > 0) {
            MsgBox.AlertSuccess(this, "Xóa Thành Công");
            duLieuBangCaLam(XDate.toString(NgayLam));
        } else {
            MsgBox.AlertFall(this, "Xóa Không Thành Công");
        }
    }

    private void suaCaLam() {
        String sql = "UPDATE ChiTietCaLam SET MaNV = (?) WHERE MaChiTietCaLam = (?)";
        String manv = (String) tblCaLam.getValueAt(index, 2);
        int machitietcalam = (Integer) tblCaLam.getValueAt(index, 4);
        Date NgayLam = (Date) tblCaLam.getValueAt(index, 3);
        int rowsAffected = JdbcHelper.executeUpdate(sql, manv, machitietcalam);
        if (rowsAffected > 0) {
            MsgBox.AlertSuccess(this, "Sửa Thành Công");
            duLieuBangCaLam(XDate.toString(NgayLam));
        } else {
            MsgBox.AlertFall(this, "Sửa Không Thành Công");
        }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cbocalam = new javax.swing.JComboBox<>();
        cbongaylam = new javax.swing.JComboBox<>();
        cbocalamnhanvien = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cbongay = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCaLam = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jButton10.setText("Cập nhật");

        jButton11.setText("Thêm");

        jButton12.setText("Xóa");

        jButton13.setText("Mới");

        jButton14.setText("<--");

        jButton15.setText("<");

        jButton16.setText(">");

        jButton17.setText("-->");

        jLabel5.setText("Tìm kiếm");

        jButton1.setText("Tìm");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mã Nhân Viên");

        jLabel2.setText("Ca Làm");

        jLabel3.setText("Ngày Làm");

        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbocalam.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbocalamPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbocalamPopupMenuWillBecomeVisible(evt);
            }
        });
        cbocalam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbocalamActionPerformed(evt);
            }
        });

        cbongaylam.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbongaylamPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbongaylamPopupMenuWillBecomeVisible(evt);
            }
        });
        cbongaylam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbongaylamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbocalam, 0, 610, Short.MAX_VALUE)
                            .addComponent(cbongaylam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbocalamnhanvien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbocalam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbongaylam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbocalamnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phân Ca", jPanel6);

        cbongay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbongayActionPerformed(evt);
            }
        });

        tblCaLam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Stt", "Mã Ca Làm", "Mã Nhân Viên", "Ngày Làm", "Mã Chi Tiết Ca Làm"
            }
        ));
        tblCaLam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCaLamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCaLam);

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(cbongay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cbongay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Danh Sách Ca Làm", jPanel2);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Ca Làm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbocalamPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbocalamPopupMenuWillBecomeVisible

    }//GEN-LAST:event_cbocalamPopupMenuWillBecomeVisible

    private void cbongaylamPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbongaylamPopupMenuWillBecomeVisible

    }//GEN-LAST:event_cbongaylamPopupMenuWillBecomeVisible

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        themCaLam();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbocalamPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbocalamPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_cbocalamPopupMenuWillBecomeInvisible

    private void cbongaylamPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbongaylamPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_cbongaylamPopupMenuWillBecomeInvisible

    private void cbocalamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbocalamActionPerformed
        NhanVienCaLam();
    }//GEN-LAST:event_cbocalamActionPerformed

    private void cbongaylamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbongaylamActionPerformed
        NhanVienCaLam();
    }//GEN-LAST:event_cbongaylamActionPerformed

    private void tblCaLamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCaLamMouseClicked
        index = tblCaLam.getSelectedRow();
    }//GEN-LAST:event_tblCaLamMouseClicked

    private void cbongayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbongayActionPerformed
        String ngay = (String) cbongay.getSelectedItem();
        duLieuBangCaLam(ngay);
    }//GEN-LAST:event_cbongayActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        xoaCaLam();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        suaCaLam();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietCaLamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietCaLamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietCaLamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietCaLamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChiTietCaLamJDialog dialog = new ChiTietCaLamJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbocalam;
    private javax.swing.JComboBox<String> cbocalamnhanvien;
    private javax.swing.JComboBox<String> cbongay;
    private javax.swing.JComboBox<String> cbongaylam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tblCaLam;
    // End of variables declaration//GEN-END:variables
}
