package com.app.ui;



import com.app.Daos.GiongDao;
import com.app.Entitys.Giong;
import com.app.utils.MsgBox;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.app.ui.mainJFrame;




public class ThemMoiGiongDialog extends javax.swing.JDialog {
    int index = 0;
    GiongDao gdao = new GiongDao();
    List<Giong> datalist = gdao.selectAll();
    mainJFrame mainJFrame;
    public ThemMoiGiongDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        loadGiong();
    }
    
    void loadGiong(){
        DefaultTableModel model = (DefaultTableModel) tblDachSachGiong.getModel();
        model.setRowCount(0);
        try {
            List<Giong> list = gdao.selectAll();
            for(Giong g : list){
                
                Object[] row ={
                    
                    g.getMaGiong(),
                    g.getTenGiong(),
                    g.getMaLoai()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.AlertFall(this,"Lỗi");
        }
    }
    
    void edit(){
        try {
            String key = (String) tblDachSachGiong.getValueAt(this.index, 0);
            Giong model = gdao.selectById(key);
            if(model != null){
                this.setModel(model);
                //this.setStatus(false);
                
            }
        
        }catch (Exception e) {
            MsgBox.AlertFall(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    void insert(){
        Giong model = getModel();
        try {
            gdao.insert(model);
            this.loadGiong();
            mainJFrame.fillComboBoxGiong();
            MsgBox.AlertSuccess(this,"Thêm thành công");
        } catch (Exception e) {
            MsgBox.AlertFall(this,"Lỗi!");
        }
    }
    
    void delete(){
        if(MsgBox.confirm(this,"Muốn xóa thiệt không?")){
            String MaGiong = txtMaGiong.getText();
            try {
                gdao.delete(MaGiong);
                this.loadGiong();
                mainJFrame.fillComboBoxGiong();
                MsgBox.AlertSuccess(this,"Xóa thành công");
            } catch (Exception e) {
                MsgBox.AlertFall(this,"Lỗi!");
            }
        }
    }
    
    void update(){
        Giong model = getModel();
        try {
            gdao.update(model);
            this.loadGiong();
            mainJFrame.fillComboBoxGiong();
            MsgBox.AlertSuccess(this,"Cập nhật thành công");
        } catch (Exception e) {
            MsgBox.AlertFall(this,"Lỗi!");
        }
    }
    
    void clear(){
        txtMaGiong.setText("");
        txtMaLoaiVat.setText("");
        txtTenGiong.setText("");
        txtTimKiemGiong.setText("");
    }
    
    void first() {
        this.index = 0;
        this.edit();
    }

    void back() {
        if (this.index <= 0) {
            this.index = tblDachSachGiong.getRowCount() - 1;
            this.edit();
        } else {
            this.index--;
            this.edit();

        }
    }

    void last() {
        this.index = tblDachSachGiong.getRowCount() - 1;
        this.edit();
    }

    void next() {
        if (this.index >= tblDachSachGiong.getRowCount() - 1) {
            this.index = 0;
            this.edit();
        } else {
            this.index++;
            this.edit();
        }
    }
    
    void setModel(Giong model){
        txtMaGiong.setText(model.getMaGiong());
        txtTenGiong.setText(model.getTenGiong());
        txtMaLoaiVat.setText(model.getMaLoai());
    }
    
    Giong getModel(){
        Giong model = new Giong();
        model.setMaGiong(txtMaGiong.getText());
        model.setTenGiong(txtTenGiong.getText());
        model.setMaLoai(txtMaLoaiVat.getText());
        return model;
    }
    
    void searchAndFill(String keyword) {
        // Xóa tất cả các dòng hiện tại trong bảng
        DefaultTableModel model = (DefaultTableModel) tblDachSachGiong.getModel();
        model.setRowCount(0);

        for (Giong giongThuCung : datalist) {
            // Tìm kiếm dựa trên MaLoai hoặc TenLoai (hoặc cả hai)
            if (giongThuCung.getMaGiong().contains(keyword) || giongThuCung.getTenGiong().contains(keyword)|| giongThuCung.getMaLoai().contains(keyword)) {
                // Thêm dòng mới vào bảng
                model.addRow(new Object[]{giongThuCung.getMaGiong(), giongThuCung.getTenGiong(),giongThuCung.getMaLoai()});
            }
        }
    }
    

    
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
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThemGiong = new javax.swing.JButton();
        btnXoaGiong = new javax.swing.JButton();
        btnLamMoiGiong = new javax.swing.JButton();
        btnSuaGiong = new javax.swing.JButton();
        txtMaGiong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenGiong = new javax.swing.JTextField();
        txtMaLoaiVat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDachSachGiong = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiemGiong = new javax.swing.JTextField();
        btDauTienGiong = new javax.swing.JButton();
        btnTruocGiong = new javax.swing.JButton();
        btnSauGiong = new javax.swing.JButton();
        btnCuoiCungGiong = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();

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

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        jLabel1.setText("THÊM GIỐNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnThemGiong.setBackground(new java.awt.Color(0, 51, 51));
        btnThemGiong.setForeground(new java.awt.Color(255, 255, 255));
        btnThemGiong.setText("Thêm");
        btnThemGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGiongActionPerformed(evt);
            }
        });

        btnXoaGiong.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaGiong.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaGiong.setText("Xóa");
        btnXoaGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGiongActionPerformed(evt);
            }
        });

        btnLamMoiGiong.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiGiong.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiGiong.setText("Mới");
        btnLamMoiGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiGiongActionPerformed(evt);
            }
        });

        btnSuaGiong.setBackground(new java.awt.Color(0, 51, 51));
        btnSuaGiong.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaGiong.setText("Cập nhật");
        btnSuaGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaGiongActionPerformed(evt);
            }
        });

        txtMaGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaGiongActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã Giống");

        jLabel3.setText("Tên Giống");

        txtTenGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenGiongActionPerformed(evt);
            }
        });

        txtMaLoaiVat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLoaiVatActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã Loài");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaGiong))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenGiong, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaLoaiVat, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemGiong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaGiong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSuaGiong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoiGiong, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaGiong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemGiong)
                    .addComponent(btnSuaGiong)
                    .addComponent(jLabel3)
                    .addComponent(txtTenGiong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoaGiong)
                            .addComponent(btnLamMoiGiong))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaLoaiVat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblDachSachGiong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Giống", "Tên Giống", "Mã Loài"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDachSachGiong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDachSachGiongMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDachSachGiong);

        jLabel6.setText("Tìm kiếm");

        txtTimKiemGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemGiongActionPerformed(evt);
            }
        });

        btDauTienGiong.setBackground(new java.awt.Color(0, 51, 51));
        btDauTienGiong.setForeground(new java.awt.Color(255, 255, 255));
        btDauTienGiong.setText("<--");
        btDauTienGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDauTienGiongActionPerformed(evt);
            }
        });

        btnTruocGiong.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocGiong.setForeground(new java.awt.Color(255, 255, 255));
        btnTruocGiong.setText("<");
        btnTruocGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruocGiongActionPerformed(evt);
            }
        });

        btnSauGiong.setBackground(new java.awt.Color(0, 51, 51));
        btnSauGiong.setForeground(new java.awt.Color(255, 255, 255));
        btnSauGiong.setText(">");
        btnSauGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauGiongActionPerformed(evt);
            }
        });

        btnCuoiCungGiong.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungGiong.setForeground(new java.awt.Color(255, 255, 255));
        btnCuoiCungGiong.setText("-->");
        btnCuoiCungGiong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiCungGiongActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setText("Tìm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemGiong, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDauTienGiong)
                        .addGap(18, 18, 18)
                        .addComponent(btnTruocGiong, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSauGiong, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCuoiCungGiong)
                        .addGap(16, 16, 16))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTimKiemGiong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDauTienGiong)
                    .addComponent(btnTruocGiong)
                    .addComponent(btnSauGiong)
                    .addComponent(btnCuoiCungGiong)
                    .addComponent(btnTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGiongActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemGiongActionPerformed

    private void btnXoaGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGiongActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaGiongActionPerformed

    private void btnLamMoiGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiGiongActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnLamMoiGiongActionPerformed

    private void btnSuaGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaGiongActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaGiongActionPerformed

    private void txtMaGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaGiongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaGiongActionPerformed

    private void txtTenGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenGiongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenGiongActionPerformed

    private void txtTimKiemGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemGiongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemGiongActionPerformed

    private void btnTruocGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruocGiongActionPerformed
        // TODO add your handling code here:
        back();
    }//GEN-LAST:event_btnTruocGiongActionPerformed

    private void btnSauGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauGiongActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnSauGiongActionPerformed

    private void txtMaLoaiVatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLoaiVatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLoaiVatActionPerformed

    private void tblDachSachGiongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDachSachGiongMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            this.index =tblDachSachGiong.rowAtPoint(evt.getPoint());
            if(index >= 0){
                this.edit();
            }
        }
    }//GEN-LAST:event_tblDachSachGiongMouseClicked

    private void btDauTienGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDauTienGiongActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btDauTienGiongActionPerformed

    private void btnCuoiCungGiongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiCungGiongActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnCuoiCungGiongActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        searchAndFill(txtTimKiemGiong.getText());
    }//GEN-LAST:event_btnTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(ThemMoiGiongDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemMoiGiongDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemMoiGiongDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemMoiGiongDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemMoiGiongDialog dialog = new ThemMoiGiongDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btDauTienGiong;
    private javax.swing.JButton btnCuoiCungGiong;
    private javax.swing.JButton btnLamMoiGiong;
    private javax.swing.JButton btnSauGiong;
    private javax.swing.JButton btnSuaGiong;
    private javax.swing.JButton btnThemGiong;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTruocGiong;
    private javax.swing.JButton btnXoaGiong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tblDachSachGiong;
    private javax.swing.JTextField txtMaGiong;
    private javax.swing.JTextField txtMaLoaiVat;
    private javax.swing.JTextField txtTenGiong;
    private javax.swing.JTextField txtTimKiemGiong;
    // End of variables declaration//GEN-END:variables
}
