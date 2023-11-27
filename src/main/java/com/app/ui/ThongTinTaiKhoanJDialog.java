package com.app.Ui;

import com.app.Daos.NhanVienDao;
import com.app.Daos.TaiKhoanDao;
import com.app.Entitys.NhanVien;
import com.app.Entitys.TaiKhoan;
import com.app.Utils.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ThongTinTaiKhoanJDialog extends javax.swing.JDialog {

    NhanVienDao daoNhanVien = new NhanVienDao();
    TaiKhoanDao daoTaiKhoan = new TaiKhoanDao();
    DefaultTableModel modelTbl;
    DefaultTableModel modelTblKhongTaiKhoan;
    int row = -1;

    /**
     * Creates new form ThongTinTaiKhoanJDialog
     */
    public ThongTinTaiKhoanJDialog(java.awt.Frame parent, boolean modal, String maNV) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init();
        initKhongTaiKhoan();
        taiDuLieuTaiKhoan();
        hienThiThongTinLenForm(daoTaiKhoan.selectByMaNhanVien(maNV));

    }

    private void init() {
        modelTbl = (DefaultTableModel) tblDanhSachTaiKhoan.getModel();
        String columns[] = new String[]{
            "STT", "Mã Nhân Viên ", "Tài Khoản", "Mật Khẩu", "Vai trò", "Trạng Thái"
        };
        modelTbl.setColumnIdentifiers(columns);
    }

    private void initKhongTaiKhoan() {
        modelTblKhongTaiKhoan = (DefaultTableModel) tblDanhSachNhanVienKhongCoTaiKhoan.getModel();
        String columns[] = new String[]{
            "STT", "Mã Nhân Viên ", "Họ Tên", "Vai trò", "Trạng Thái"
        };
        modelTblKhongTaiKhoan.setColumnIdentifiers(columns);
    }

    private void taiDuLieuTaiKhoan() {
        try {
            List<TaiKhoan> lst = daoTaiKhoan.selectAll();
            modelTbl.setRowCount(0);
            for (int i = 0; i < lst.size(); i++) {
                TaiKhoan tk = lst.get(i);
                Object[] rowTK = {
                    i + 1,
                    tk.getMaNhanVien(),
                    tk.getTaiKhoan(),
                    tk.getMatKhau(),
                    daoNhanVien.selectById(tk.getMaNhanVien()).isMaVaitro() ? "Quản lí" : "Nhân viên",
                    daoNhanVien.selectById(tk.getMaNhanVien()).getTrangThai()
                };
                modelTbl.addRow(rowTK);

            }
            modelTbl.fireTableDataChanged();
            taiDuLieuNhanVienKhongTaiKhoan();
        } catch (Exception e) {

        }

    }

    private void taiDuLieuNhanVienKhongTaiKhoan() {
        try {
            List<NhanVien> lst = daoNhanVien.selectKhongTaiKhoan();
            modelTblKhongTaiKhoan.setRowCount(0);
            for (int i = 0; i < lst.size(); i++) {
                NhanVien nv = lst.get(i);
                Object[] rowNV = {
                    i + 1,
                    nv.getMaNhanVien(),
                    nv.getHoTen(),
                    nv.isMaVaitro() ? "Quản lí" : "Nhân viên",
                    nv.getTrangThai()
                };
                modelTblKhongTaiKhoan.addRow(rowNV);

            }
            modelTblKhongTaiKhoan.fireTableDataChanged();
        } catch (Exception e) {

        }

    }

    private void hienThiThongTinLenForm(TaiKhoan nv) {
        try {
            txtTaiKhoan.setText(nv.getTaiKhoan());
            txtMatKhau.setText(nv.getMatKhau());
            lblTenNhanVien.setText(daoNhanVien.selectById(nv.getMaNhanVien()).getHoTen());

        } catch (Exception e) {
        }

    }

    private void edit() {
        String maNhanVien = (String) tblDanhSachTaiKhoan.getValueAt(this.row, 1);
        TaiKhoan nv = daoTaiKhoan.selectByMaNhanVien(maNhanVien);
        this.hienThiThongTinLenForm(nv);

    }

    private void ThemTaiKhoan() {
        for (int row : tblDanhSachNhanVienKhongCoTaiKhoan.getSelectedRows()) {
            TaiKhoan tk = new TaiKhoan();
            tk.setMatKhau("");
            tk.setMaNhanVien((String) tblDanhSachNhanVienKhongCoTaiKhoan.getValueAt(row, 1));
            tk.setTaiKhoan(daoNhanVien.selectById((String) tblDanhSachNhanVienKhongCoTaiKhoan.getValueAt(row, 1)).getSoDienThoai());
            daoTaiKhoan.insert(tk);
        }
    }

    private void xoaNhanVien() {
        if (!Auth.isManager()) {
            MsgBox.AlertFall(this, "Bạn không có quyền xóa tài khoản này");
        } else {
            String taiKhoan = txtTaiKhoan.getText();
            if (MsgBox.confirm(this, "Bạn thực sự muốn xóa tài khoản này?")) {
                try {
                    daoTaiKhoan.delete(taiKhoan);
                    this.taiDuLieuTaiKhoan();
                    lamMoi();
                    MsgBox.AlertSuccess(this, "Xóa thành công");
                } catch (Exception e) {
                    MsgBox.AlertFall(this, e.getMessage());
                }
            }
        }
    }

    private void capNhatTaiKhoan() {
        try {
            TaiKhoan tk = daoTaiKhoan.selectById(txtTaiKhoan.getText());
            tk.setMatKhau(txtMatKhau.getText());
            daoTaiKhoan.update(tk);
            this.taiDuLieuTaiKhoan();
            lamMoi();
            MsgBox.AlertSuccess(this, "Cập nhật thành công");
        } catch (Exception e) {
            MsgBox.AlertFall(this, e.getMessage());

        }

    }

    private void lamMoi() {
        lblTenNhanVien.setText("");
        txtMatKhau.setText("");
        txtTaiKhoan.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTenNhanVien = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        btnCapNhat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachTaiKhoan = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSachNhanVienKhongCoTaiKhoan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnCapNhat1 = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTenNhanVien.setFont(new java.awt.Font("Source Sans Pro Black", 0, 14)); // NOI18N
        lblTenNhanVien.setText("Nguyễn Văn A");

        jLabel2.setText("Tài Khoản");

        jLabel3.setText("Mật Khẩu");

        txtTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaiKhoanActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(0, 51, 51));
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Xóa");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Thoát");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        tblDanhSachTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhSachTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachTaiKhoan);

        tblDanhSachNhanVienKhongCoTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhSachNhanVienKhongCoTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachNhanVienKhongCoTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSachNhanVienKhongCoTaiKhoan);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nhân viên không có tài khoản:");

        btnCapNhat1.setBackground(new java.awt.Color(0, 51, 51));
        btnCapNhat1.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat1.setText("Cập nhật ");
        btnCapNhat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhat1ActionPerformed(evt);
            }
        });

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCapNhat1)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(22, 22, 22)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                        .addComponent(txtMatKhau))))
                            .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLamMoi)
                            .addComponent(btnCapNhat1)
                            .addComponent(btnCapNhat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaiKhoanActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        xoaNhanVien();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblDanhSachTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachTaiKhoanMouseClicked
        // TODO add your handling code here:
        this.row = tblDanhSachTaiKhoan.getSelectedRow();
        edit();
    }//GEN-LAST:event_tblDanhSachTaiKhoanMouseClicked

    private void btnCapNhat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhat1ActionPerformed
        // TODO add your handling code here:
        capNhatTaiKhoan();
    }//GEN-LAST:event_btnCapNhat1ActionPerformed

    private void tblDanhSachNhanVienKhongCoTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachNhanVienKhongCoTaiKhoanMouseClicked
        // TODO add your handling code here:
        String maNV = (String) tblDanhSachNhanVienKhongCoTaiKhoan.getValueAt(tblDanhSachNhanVienKhongCoTaiKhoan.getSelectedRow(), 1);
        if (MsgBox.confirm(this, "Bạn có muốn tạo tài khoản cho nhân viên " + maNV)) {
            ThemTaiKhoan();
        }
        taiDuLieuTaiKhoan();

    }//GEN-LAST:event_tblDanhSachNhanVienKhongCoTaiKhoanMouseClicked

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
            java.util.logging.Logger.getLogger(ThongTinTaiKhoanJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinTaiKhoanJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinTaiKhoanJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinTaiKhoanJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongTinTaiKhoanJDialog dialog = new ThongTinTaiKhoanJDialog(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnCapNhat1;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JTable tblDanhSachNhanVienKhongCoTaiKhoan;
    private javax.swing.JTable tblDanhSachTaiKhoan;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
