package com.app.ui;

import com.app.Daos.DatDVDAO;
import com.app.Daos.HoaDonDAO;
import com.app.Daos.HoiVienDao;
import com.app.Daos.ThuCungDao;
import com.app.Entitys.ChiTietDatLich;
import com.app.Entitys.DatDV;
import com.app.Entitys.ThuCung;
import com.app.utils.XImage;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import com.app.utils.XDate;
public class ChiTietSuKienJDialog extends javax.swing.JDialog {

    boolean flag = false;
    HoaDonDAO daoHD = new HoaDonDAO();
    DatDVDAO daoDDV = new DatDVDAO();
    HoiVienDao daoHV = new HoiVienDao();
    String maDL;
    DefaultTableModel modelTblThuCung;
    DefaultTableModel modelTblDichVu;

    /**
     * Creates new form ChiTietSuKienJDialog
     */
    public ChiTietSuKienJDialog(java.awt.Frame parent, boolean modal, String maDatLich) {
        super(parent, modal);
        initComponents();
        pnl1.setVisible(flag);
        if (!flag) {
            setSize(820, 340);
        } else {
            pnl1.setVisible(flag);
            setSize(820, 520);
        }
        setLocationRelativeTo(null);
        maDL = maDatLich;
        initThuCung();
        taiDuLieuLenForm();
        taiDuLieuThuCung();
        taiDuLieuDichVu();

    }

    private void taiDuLieuLenForm() {
        try {

            DatDV ddv = new DatDV();
            lblSuKienHoaDon.setText(daoHD.selectByMaDL(maDL).getMaHoaDon());

            if (daoHD.selectByMaDL(maDL).getMaHV() != null) {
                lblSuKienMaKhachHang.setText(daoHD.selectByMaDL(maDL).getMaHV());
            } else {
                lblSuKienMaKhachHang.setText("Khách vãng lai");

            }
            ddv = daoDDV.selectById(maDL);
            txtMaDatDichVu.setText(ddv.getMaDL());
            txtNgayDatDichVu.setText(XDate.toString(ddv.getNgayDat(), "dd-MM-yyyy"));
            txtGhiChuDichVu.setText(ddv.getMoTa());
            txtNgayNhanThuCung.setText(XDate.toString(ddv.getNgayTra(), "dd-MM-yyyy"));
            txtSoDienThoaiDatLich.setText(ddv.getSoDienThoai());
        } catch (Exception e) {
            e.getMessage();
        }

    }
    ThuCungDao daoTC = new ThuCungDao();

    private void taiDuLieuDichVu() {
        try {
            List<ChiTietDatLich> lst = daoDDV.selectByMaDL(maDL);
            modelTblDichVu.setRowCount(0);
            for (int i = 0; i < lst.size(); i++) {
                ChiTietDatLich dv = lst.get(i);
                Object[] row = {
                    i + 1,
                    dv.getMaDV(),
                    dv.getSoLuong()
                };
                modelTblDichVu.addRow(row);
            }
            modelTblDichVu.fireTableDataChanged();
        } catch (Exception e) {
        }
    }

    private void taiDuLieuThuCung() {
        try {
            if (daoHD.selectByMaDL(maDL).getMaHV() != null) {
                lblTenHoiVienSuKien.setText(daoHV.selectById(daoHD.selectByMaDL(maDL).getMaHV()).getTenKhachHang());
                List<ThuCung> lst = daoTC.selectByMaHV(daoHD.selectByMaDL(maDL).getMaHV());
                modelTblThuCung.setRowCount(0);
                for (int i = 0; i < lst.size(); i++) {
                    ThuCung tc = lst.get(i);
                    if (tc.getHinhAnh() != null) {
                        lblHinhThuCungHoiVien.setToolTipText(tc.getHinhAnh());
                        ImageIcon ico = XImage.read(tc.getHinhAnh());
                        Image img = ico.getImage().getScaledInstance(lblHinhThuCungHoiVien.getWidth(), lblHinhThuCungHoiVien.getHeight(), Image.SCALE_SMOOTH);
                        lblHinhThuCungHoiVien.setIcon(new ImageIcon(img));
                    }
                    Object[] row = {
                        i + 1,
                        tc.getMaThuCung(),
                        tc.getMoTa(),
                        tc.isGioiTinh() ? "Đực" : "Cái",
                        tc.getTuoi(),
                        tc.getCanNang(),
                        tc.getMaGiong(),
                        tc.getMaChuong()
                    };
                    modelTblThuCung.addRow(row);
                }
                modelTblThuCung.fireTableDataChanged();
            } else {
                lblTenHoiVienSuKien.setText("Khách vãng lai");
            }

        } catch (Exception e) {
        }
    }

    private void initThuCung() {
        modelTblThuCung = (DefaultTableModel) tblThuCungHoiVien.getModel();
        String columns[] = new String[]{
            "STT",
            "Mã thú cưng",
            "Mô tả ",
            "Giới tính",
            "Tuổi",
            "Cân nặng",
            "Mã giống",
            "Mã chuồng"
        };
        modelTblThuCung.setColumnIdentifiers(columns);
        modelTblDichVu = (DefaultTableModel) tblDichVuDaDat.getModel();
        String columnsDV[] = new String[]{
            "STT",
            "Mã dịch vụ",
            "Số lượng"
        };
        modelTblDichVu.setColumnIdentifiers(columnsDV);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabHoaDonDichVu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSuKienHoaDon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        txtNgayDatDichVu = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtGhiChuDichVu = new javax.swing.JTextArea();
        txtNgayNhanThuCung = new javax.swing.JTextField();
        txtMaDatDichVu = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txtSoDienThoaiDatLich = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVuDaDat = new javax.swing.JTable();
        lblSuKienMaKhachHang = new javax.swing.JLabel();
        pnl1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThuCungHoiVien = new javax.swing.JTable();
        lblTenHoiVienSuKien = new javax.swing.JLabel();
        lblHinhThuCungHoiVien = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabHoaDonDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabHoaDonDichVuMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã khách hàng ");

        lblSuKienHoaDon.setFont(new java.awt.Font("Source Sans Pro Black", 1, 18)); // NOI18N
        lblSuKienHoaDon.setText("Hóa Đơn 001");

        jLabel85.setText("Số Điện Thoại");

        jLabel82.setText("Ghi Chú");

        jLabel86.setText("Ngày Nhận ");

        jLabel83.setText("Ngày Đặt");

        txtGhiChuDichVu.setColumns(20);
        txtGhiChuDichVu.setRows(5);
        jScrollPane12.setViewportView(txtGhiChuDichVu);

        txtMaDatDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDatDichVuActionPerformed(evt);
            }
        });

        jLabel73.setText("Mã Đặt Lịch");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73)
                    .addComponent(jLabel83)
                    .addComponent(jLabel86)
                    .addComponent(jLabel85)
                    .addComponent(jLabel82))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoDienThoaiDatLich)
                    .addComponent(jScrollPane12)
                    .addComponent(txtMaDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayDatDichVu)
                    .addComponent(txtNgayNhanThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayDatDichVu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayNhanThuCung)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoDienThoaiDatLich))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(70, 70, 70)))
                .addContainerGap())
        );

        tblDichVuDaDat.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDichVuDaDat);

        lblSuKienMaKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuKienMaKhachHang.setText("001");
        lblSuKienMaKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSuKienMaKhachHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tabHoaDonDichVuLayout = new javax.swing.GroupLayout(tabHoaDonDichVu);
        tabHoaDonDichVu.setLayout(tabHoaDonDichVuLayout);
        tabHoaDonDichVuLayout.setHorizontalGroup(
            tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSuKienHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(lblSuKienMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        tabHoaDonDichVuLayout.setVerticalGroup(
            tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabHoaDonDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSuKienHoaDon)
                    .addComponent(jLabel1)
                    .addComponent(lblSuKienMaKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(118, 118, 118))
        );

        pnl1.setLayout(new java.awt.CardLayout());

        jLabel6.setText("Tên khách hàng");

        jLabel7.setText("Thú cưng:");

        tblThuCungHoiVien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblThuCungHoiVien);

        lblTenHoiVienSuKien.setText("Nguyen Van A");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHinhThuCungHoiVien, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenHoiVienSuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTenHoiVienSuKien))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(lblHinhThuCungHoiVien, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        pnl1.add(jPanel3, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabHoaDonDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabHoaDonDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaDatDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDatDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDatDichVuActionPerformed

    private void lblSuKienMaKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuKienMaKhachHangMouseClicked
        // TODO add your handling code here:
        if (!flag) {
            flag = true;
        } else {
            flag = false;
        }
        pnl1.setVisible(flag);
        if (!flag) {
            setSize(820, 340);
        } else {
            pnl1.setVisible(flag);
            setSize(820, 520);
        }
    }//GEN-LAST:event_lblSuKienMaKhachHangMouseClicked

    private void tabHoaDonDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabHoaDonDichVuMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_tabHoaDonDichVuMouseClicked

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
            java.util.logging.Logger.getLogger(ChiTietSuKienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSuKienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSuKienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSuKienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChiTietSuKienJDialog dialog = new ChiTietSuKienJDialog(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHinhThuCungHoiVien;
    private javax.swing.JLabel lblSuKienHoaDon;
    private javax.swing.JLabel lblSuKienMaKhachHang;
    private javax.swing.JLabel lblTenHoiVienSuKien;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel tabHoaDonDichVu;
    private javax.swing.JTable tblDichVuDaDat;
    private javax.swing.JTable tblThuCungHoiVien;
    private javax.swing.JTextArea txtGhiChuDichVu;
    private javax.swing.JTextField txtMaDatDichVu;
    private javax.swing.JTextField txtNgayDatDichVu;
    private javax.swing.JTextField txtNgayNhanThuCung;
    private javax.swing.JTextField txtSoDienThoaiDatLich;
    // End of variables declaration//GEN-END:variables

}
