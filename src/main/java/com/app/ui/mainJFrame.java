package com.app.Ui;

import com.app.Daos.DatDVDAO;
import com.app.Daos.NhanVienDao;
import com.app.Entitys.NhanVien;
import com.app.Utils.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class mainJFrame extends javax.swing.JFrame {

    int width = 200;
    int height = 635 - 18;
    int heightND = 200;
    int row = -1;
    private Timer time;
    private Timer menuTimer;
    DefaultTableModel modelTblNhanVien;
    DefaultTableModel modelTblSuKien;
    NhanVienDao daoNhanVien = new NhanVienDao();
    DatDVDAO daoSuKien = new DatDVDAO();

    /**
     * Creates new form mainJFrame
     */
    public mainJFrame() {
        initComponents();

//        ImageIcon icon4 = new ImageIcon("..\\PetShop\\src\\main\\java\\com\\app\\img\\target.png");
//        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(icon4.getImage(), new Point(0, 0), "curson");
//        setCursor(cursor);
        lblHinhLogo.setIcon(XImage.insertIcon(70, 70, "..\\PetShop\\src\\main\\java\\com\\app\\img\\logo_menu.jpg"));
        lblTrangChu.setIcon(XImage.insertIcon(lblTrangChu.getWidth(), lblTrangChu.getHeight(), "..\\PetShop\\src\\main\\java\\com\\app\\img\\logo_menu.jpg"));

        lblHinhLogo1.setIcon(XImage.insertIcon(32, 32, "..\\PetShop\\src\\main\\java\\com\\app\\img\\logo_gd.png"));
        lblOpenMenuIcon.setIcon(XImage.insertIcon(32, 32, "..\\PetShop\\src\\main\\java\\com\\app\\img\\menu.png"));
        lblExitMenuIcon.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\dong_menu.png"));
        lblExitMenuNguoiDung.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\dong_menu.png"));
        lblUserIcon.setIcon(XImage.insertIcon(32, 32, "..\\PetShop\\src\\main\\java\\com\\app\\img\\nguoidung_meo.png"));
        lblUserIcon1.setIcon(XImage.insertIcon(64, 64, "..\\PetShop\\src\\main\\java\\com\\app\\img\\nguoidung_meo.png"));
        lblKhuyenMaiIcon.setIcon(XImage.insertIcon(64, 64, "..\\PetShop\\src\\main\\java\\com\\app\\img\\khuyenmai.png"));
        lblMenuHoaDon.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\hoadon.png"));
        btnSauDanhSachNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\sau.png"));
        btnTruocDanhSachNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\truoc.png"));
        btnCuoiCungDanhSachNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\cuoicung.png"));
        btnDauTienDanhSachNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\dautien.png"));
        btnXoaNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\xoa.png"));
        btnThemNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\them.png"));
        btnSuaNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\capnhat.png"));
        btnLamMoiNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\lammoi.png"));
        btnTimTenNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\timkiem.png"));

        btnDauTienDichVu.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\dautien.png"));
        btnSauDichVu.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\sau.png"));
        btnTruocDichVu.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\truoc.png"));
        btnCuoiCungDichVu.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\cuoicung.png"));
        btnXoaDichVu.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\xoa.png"));
        btnThemDichVu.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\them.png"));
        btnSuaDichVu.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\capnhat.png"));
        btnLamMoiDichVu.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\lammoi.png"));

        btnDauTienThuCung.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\dautien.png"));
        btnSauThuCung.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\sau.png"));
        btnTruocThuCung.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\truoc.png"));
        btnCuoiCungThuCung.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\cuoicung.png"));
        btnXoaThuCung.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\xoa.png"));
        btnThemThuCung.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\them.png"));
        btnSuaThuCung.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\capnhat.png"));
        btnLamMoiThuCung.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\lammoi.png"));

        btnTimTenNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\timkiem.png"));
        tabTrangChu.setVisible(true);
        tabHoaDon.setVisible(false);
        tabDichVu.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKho.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSanPham.setVisible(false);
        tabThongKe.setVisible(false);
        tabThuCung.setVisible(false);
        tabSuKien.setVisible(false);
        setLocationRelativeTo(null);

        new ManHinhChaoJDialog(this, true).setVisible(true);
        new DangNhapJDialog(this, true).setVisible(true);
        // vùng set trạng thái component************************************************
        updateStatusNhanVien();
        rdoNamNhanVien.setSelected(true);
        rdoVaiTroQuanLy.setSelected(true);
        // Tải dữ liệu*************************************************************
        initTableNhanVien();
        taiDuLieuNhanVien();
        
        initTableSuKien();

        // Chỗ đặt hàm*********************************************************//
    }

    // vùng code của Linh*********************************************************************
    private void startTimers() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss a");
                lblLock.setText(fd.format(new Date()));

            }
        };
        time = new javax.swing.Timer(1000, action);
        time.start();

    }
    // FoRM Sư Kiện ****************************************************************
    public void initTableSuKien() {
        modelTblSuKien = (DefaultTableModel) tblDanhSachSuKien.getModel();
        String columns[] = new String[]{
            "STT",
            "Mã đặt lịch",
            "Tên khách hàng",
            "Số điện thoại",
            "Tên dịch vụ",
            "Ghi chú",
            "Ngày đặt lịch",
            "Ngày nhận"
        };
        modelTblNhanVien.setColumnIdentifiers(columns);
    }
     private void taiDuLieuSuKien() {
        try {
            String name = txtTimTenNhanVien.getText();
            List<NhanVien> lst = daoNhanVien.selectByName(name);
            modelTblNhanVien.setRowCount(0);
            for (int i = 0; i < lst.size(); i++) {
                NhanVien nv = lst.get(i);
                Object[] rowNV = {
                    i + 1,
                    nv.getMaNhanVien(),
                    nv.getHoTen(),
                    nv.isMaVaitro() ? "Quản lí" : "Nhân viên",
                    nv.getGioiTinh().equals("Nam") ? "Nam" : "Nữ",
                    nv.getNgaySinh(),
                    nv.getSoDienThoai(),
                    nv.getEmail(),
                    nv.getTrangThai(),
                    nv.getHinh()
                };
                modelTblNhanVien.addRow(rowNV);

            }
            modelTblNhanVien.fireTableDataChanged();
        } catch (Exception e) {

        }

    }

    
    // HẾt Form sự kiện **********************************************************************
// FORM NV*******************************

    private void updateStatusNhanVien() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblDanhSachNhanVien.getRowCount() - 1);
        txtMaNhanVien.setEditable(!edit);
        btnThemNhanVien.setEnabled(!edit);
        btnXoaNhanVien.setEnabled(edit);
        btnSuaNhanVien.setEnabled(edit);
        btnDauTienDanhSachNhanVien.setEnabled(edit && !first);
        btnCuoiCungDanhSachNhanVien.setEnabled(edit && !last);

    }

    public void initTableNhanVien() {
        modelTblNhanVien = (DefaultTableModel) tblDanhSachNhanVien.getModel();
        String columns[] = new String[]{
            "STT",
            "Mã Nhân Viên ",
            "Họ Tên",
            "Vai Trò",
            "Giới Tính",
            "Ngày Sinh",
            "Số Điện Thoại",
            "Email",
            "Trạng Thái",
            "Hình"
        };
        modelTblNhanVien.setColumnIdentifiers(columns);

        cboTrangThaiNhanVien.addItem("Đang làm");
        cboTrangThaiNhanVien.addItem("Đã nghỉ");

        cboLocTrangThaiNhanVien.addItem("Đang làm");
        cboLocTrangThaiNhanVien.addItem("Đã nghỉ");

        cboLocVaiTroNhanVien.addItem("Nhân viên");
        cboLocVaiTroNhanVien.addItem("Quản lí");
    }

    private void locDuLieuNhanVien() {
        List<NhanVien> lst = null;
        String name = txtTimTenNhanVien.getText();
        String trangThai = (String) cboLocTrangThaiNhanVien.getSelectedItem();
        try {
            int vaiTro = cboLocVaiTroNhanVien.getSelectedIndex();
            boolean key = false;
            if (vaiTro != 0) {
                key = true;
            }
            lst = daoNhanVien.selectBy(key, name, trangThai);

            modelTblNhanVien.setRowCount(0);
            for (int i = 0; i < lst.size(); i++) {
                NhanVien nv = lst.get(i);
                Object[] rowNV = {
                    i + 1,
                    nv.getMaNhanVien(),
                    nv.getHoTen(),
                    nv.isMaVaitro() ? "Quản lí" : "Nhân viên",
                    nv.getGioiTinh().equals("Nam") ? "Nam" : "Nữ",
                    nv.getNgaySinh(),
                    nv.getSoDienThoai(),
                    nv.getEmail(),
                    nv.getTrangThai(),
                    nv.getHinh()
                };
                modelTblNhanVien.addRow(rowNV);

            }
            modelTblNhanVien.fireTableDataChanged();
        } catch (Exception e) {

        }
    }

    private void taiDuLieuNhanVien() {
        try {
            String name = txtTimTenNhanVien.getText();
            List<NhanVien> lst = daoNhanVien.selectByName(name);
            modelTblNhanVien.setRowCount(0);
            for (int i = 0; i < lst.size(); i++) {
                NhanVien nv = lst.get(i);
                Object[] rowNV = {
                    i + 1,
                    nv.getMaNhanVien(),
                    nv.getHoTen(),
                    nv.isMaVaitro() ? "Quản lí" : "Nhân viên",
                    nv.getGioiTinh().equals("Nam") ? "Nam" : "Nữ",
                    nv.getNgaySinh(),
                    nv.getSoDienThoai(),
                    nv.getEmail(),
                    nv.getTrangThai(),
                    nv.getHinh()
                };
                modelTblNhanVien.addRow(rowNV);

            }
            modelTblNhanVien.fireTableDataChanged();
        } catch (Exception e) {

        }

    }

    private void chonHinhNhanVien() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.save(file);
            ImageIcon ico = XImage.read(file.getName());
            Image img = ico.getImage().getScaledInstance(lblHinhNhanVien.getWidth(), lblHinhNhanVien.getHeight(), Image.SCALE_SMOOTH);
            lblHinhNhanVien.setIcon(new ImageIcon(img));
            lblHinhNhanVien.setToolTipText(file.getName());
        }
    }

    private void hienThiThongTinLenFormNhanVien(NhanVien nv) {
        try {
            txtMaNhanVien.setText(nv.getMaNhanVien());
            txtHoTenNhanVien.setText(nv.getHoTen());
            rdoNamNhanVien.setSelected(nv.getGioiTinh().equals("Nam"));
            rdoNuNhanVien.setSelected(!nv.getGioiTinh().equals("Nam"));
            txtSoDienThoaiNhanVien.setText(nv.getSoDienThoai());
            txtEmailNhanVien.setText(nv.getEmail());
            txtNgaySinhNhanVien.setText(XDate.toString(nv.getNgaySinh(), "dd/MM/yyyy"));
            cboTrangThaiNhanVien.setSelectedItem(nv.getTrangThai());
            rdoVaiTroQuanLy.setSelected(nv.isMaVaitro());
            rdoVaiTroNhanVien.setSelected(!nv.isMaVaitro());
            if (nv.getHinh() != null) {
                lblHinhNhanVien.setToolTipText(nv.getHinh());
                ImageIcon ico = XImage.read(nv.getHinh());
                Image img = ico.getImage().getScaledInstance(lblHinhNhanVien.getWidth(), lblHinhNhanVien.getHeight(), Image.SCALE_SMOOTH);
                lblHinhNhanVien.setIcon(new ImageIcon(img));
            }
        } catch (Exception e) {
        }

    }

    private boolean kiemTraDuLieuVao() {
        if (Validate.nothingText(txtMaNhanVien, txtHoTenNhanVien, txtNgaySinhNhanVien, txtSoDienThoaiNhanVien, txtEmailNhanVien) != null) {
            MsgBox.AlertFall(this, Validate.nothingText(txtMaNhanVien, txtHoTenNhanVien, txtNgaySinhNhanVien, txtSoDienThoaiNhanVien, txtEmailNhanVien));
            return false;
        }
        if (!Validate.validateDate(txtNgaySinhNhanVien.getText())) {
            MsgBox.AlertFall(this, "Vui lòng nhập đúng định dạng dd/MM/yyyy!!");
            return false;
        }
        if (!Validate.validateNumberPhone(txtSoDienThoaiNhanVien.getText())) {
            MsgBox.AlertFall(this, "Số điện thoại chưa đúng!!");
            return false;
        }
        if (!Validate.validateEmail(txtEmailNhanVien.getText())) {
            MsgBox.AlertFall(this, "Email chưa hợp lệ!!");
            return false;
        }
        return true;
    }

    private NhanVien layDuLieuTuFormNhanVien() {

        if (!kiemTraDuLieuVao()) {
            return null;
        }

        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(txtMaNhanVien.getText());
        nv.setHoTen(txtHoTenNhanVien.getText());
        nv.setGioiTinh(rdoNamNhanVien.isSelected() ? "Nam" : "Nữ");
        nv.setSoDienThoai(txtSoDienThoaiNhanVien.getText());
        nv.setEmail(txtEmailNhanVien.getText());
        nv.setNgaySinh(XDate.toDate(txtNgaySinhNhanVien.getText(), "dd/MM/yyyy"));
        nv.setTrangThai((String) cboTrangThaiNhanVien.getSelectedItem());
        nv.setMaVaitro(rdoVaiTroQuanLy.isSelected());
        nv.setHinh(lblHinhNhanVien.getToolTipText());
        return nv;
    }

    private void ThemNhanVien() {
        NhanVien nv = layDuLieuTuFormNhanVien();
        try {
            if (nv != null) {
                if (daoNhanVien.selectById(nv.getMaNhanVien()) != null) {
                    MsgBox.AlertFall(this, "Mã nhân viên đã tồn tại");
                    return;
                }
                daoNhanVien.insert(nv);
                this.taiDuLieuNhanVien();
                MsgBox.AlertSuccess(this, "Thêm mới thành công");
            }

        } catch (Exception e) {
            MsgBox.AlertFall(this, e.getMessage());
        }
    }

    private void xoaNhanVien() {
        if (!Auth.isManager()) {
            MsgBox.AlertFall(this, "Bạn không có quyền xóa nhân viên");
        } else {
            String maNV = txtMaNhanVien.getText();
            if (MsgBox.confirm(this, "Bạn thực sự muốn xóa nhân viên " + maNV)) {
                try {
                    daoNhanVien.delete(maNV);
                    this.taiDuLieuNhanVien();
                    MsgBox.AlertSuccess(this, "Xóa thành công");
                } catch (Exception e) {
                    MsgBox.AlertFall(this, e.getMessage());
                }
            }
        }
    }

    private void lamMoiNhanVien() {
        NhanVien nv = new NhanVien(null, null, "Nam", XDate.toDate("1/1/1999", "dd/MM/yyyy"), null, null, "Đang làm", "");
        this.hienThiThongTinLenFormNhanVien(nv);
        lblHinhNhanVien.setIcon(null);
        txtNgaySinhNhanVien.setText("");
        lblHinhNhanVien.setToolTipText("");
        this.row = -1;
        this.lamMoiNhanVien();

    }

    private void capNhatNhanVien() {
        NhanVien nv = layDuLieuTuFormNhanVien();
        try {
            daoNhanVien.update(nv);
            this.taiDuLieuNhanVien();
            MsgBox.AlertSuccess(this, "Cập nhật thành công");
        } catch (Exception e) {
            MsgBox.AlertFall(this, e.getMessage());

        }

    }

    private void edit() {
        String maNhanVien = (String) tblDanhSachNhanVien.getValueAt(this.row, 1);
        NhanVien nv = daoNhanVien.selectById(maNhanVien);
        this.hienThiThongTinLenFormNhanVien(nv);
        this.updateStatusNhanVien();

    }

    void dauTienNhanVien() {
        this.row = 0;
        this.edit();
    }

    private void cuoiCungNhanVien() {
        this.row = tblDanhSachNhanVien.getRowCount() - 1;
        this.edit();
    }

    void TruocNhanVien() {
        this.row--;
        if (this.row >= 0) {
            this.edit();
        } else if (this.row < 0) {
            this.row = tblDanhSachNhanVien.getRowCount() - 1;
            this.edit();
        }
    }

    private void SauNhanVien() {
        this.row++;
        System.out.println(this.row);
        if (this.row <= tblDanhSachNhanVien.getRowCount() - 1) {
            this.edit();
        } else if (this.row > tblDanhSachNhanVien.getRowCount() - 1) {
            this.row = 0;
            this.edit();
        }
    }

    // HẾt FORM NV*******************************
    // Giao diện*********************
    private void openMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                pnlDanhSach.setBounds(0, 0, 0, height);
                for (int i = 0; i < width; i++) {
                    pnlDanhSach.setSize(i, height);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(mainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();

    }

    private void closeMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    pnlDanhSach.setSize(i, height);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(mainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }).start();
    }

    private void openMenuThongTinNguoiDung() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                pnlThongTinNguoiDung.setBounds(1085, 70, 156, 200);
                for (int i = 0; i < heightND; i++) {
                    pnlThongTinNguoiDung.setSize(156, i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(mainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    private void closeMenuThongTinNguoiDung() {
        pnlThongTinNguoiDung.setVisible(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = heightND; i > 0; i--) {
                    pnlThongTinNguoiDung.setSize(156, i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(mainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }).start();
    }

    // Hết Giao diện*********************
    // hết vùng code của Linh****************************************************************
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnGVaiTro = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        pnlDanhSach = new javax.swing.JPanel();
        lblHinhLogo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlHeThong = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMenuNhanVien = new javax.swing.JLabel();
        lblMenuThongKe = new javax.swing.JLabel();
        lblMenuKho = new javax.swing.JLabel();
        lblMenuTrangChu = new javax.swing.JLabel();
        lblMenuSuKien = new javax.swing.JLabel();
        lblMenuKhuyenMai = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pnlChucNang = new javax.swing.JPanel();
        lblMenuDichVu = new javax.swing.JLabel();
        lblMenuHoaDon = new javax.swing.JLabel();
        lblMenuSanPham = new javax.swing.JLabel();
        lblMenuThuCung = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblMenuKhachHang = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblExitMenuIcon = new javax.swing.JLabel();
        pnlTrangThai = new javax.swing.JPanel();
        lblLock = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlHead = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblHinhLogo1 = new javax.swing.JLabel();
        lblOpenMenuIcon = new javax.swing.JLabel();
        lblUserIcon = new javax.swing.JLabel();
        pnlCard = new javax.swing.JPanel();
        tabNhanVien = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblHinhNhanVien = new javax.swing.JLabel();
        btnTaiKhoanNhanVien = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSachNhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        rdoVaiTroNhanVien = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        rdoVaiTroQuanLy = new javax.swing.JRadioButton();
        txtHoTenNhanVien = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtSoDienThoaiNhanVien = new javax.swing.JTextField();
        rdoNamNhanVien = new javax.swing.JRadioButton();
        txtEmailNhanVien = new javax.swing.JTextField();
        cboTrangThaiNhanVien = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        rdoNuNhanVien = new javax.swing.JRadioButton();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtNgaySinhNhanVien = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnThemNhanVien = new javax.swing.JButton();
        btnLamMoiNhanVien = new javax.swing.JButton();
        btnSauDanhSachNhanVien = new javax.swing.JButton();
        btnTruocDanhSachNhanVien = new javax.swing.JButton();
        btnCuoiCungDanhSachNhanVien = new javax.swing.JButton();
        btnDauTienDanhSachNhanVien = new javax.swing.JButton();
        btnSuaNhanVien = new javax.swing.JButton();
        btnXoaNhanVien = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        txtTimTenNhanVien = new javax.swing.JTextField();
        btnTimTenNhanVien = new javax.swing.JButton();
        cboLocVaiTroNhanVien = new javax.swing.JComboBox<>();
        cboLocTrangThaiNhanVien = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tabSuKien = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachSuKien = new javax.swing.JTable();
        tabThuCung = new javax.swing.JPanel();
        pnlNenThuCung = new javax.swing.JPanel();
        tabbedThuCung = new javax.swing.JPanel();
        lblThongTinThuCung = new javax.swing.JLabel();
        lblDanhSachThuCung = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        tabThongTinThuCung = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        rdoGioiTinhDuc = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        cboGiongThuCung = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        txtMaThuCung = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtGiaTienThuCung = new javax.swing.JTextField();
        txtCanNangThuCung = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        cboLoaiThuCung = new javax.swing.JComboBox<>();
        rdoGioiTinhCai = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        txtTuoiThuCung = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtSoChuongThuCung = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtThuocSoHuuThuCung = new javax.swing.JLabel();
        lblAnhThuCung = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTaThuCung = new javax.swing.JTextArea();
        jTextField9 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnThemChuongThuCung = new javax.swing.JButton();
        btnLamMoiThuCung = new javax.swing.JButton();
        btnSuaThuCung = new javax.swing.JButton();
        btnXoaThuCung = new javax.swing.JButton();
        btnThemThuCung = new javax.swing.JButton();
        btnThemLoaiThuCung = new javax.swing.JButton();
        btnDauTienThuCung = new javax.swing.JButton();
        btnTruocThuCung = new javax.swing.JButton();
        btnSauThuCung = new javax.swing.JButton();
        btnCuoiCungThuCung = new javax.swing.JButton();
        tabDanhSachThuCung = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDanahSachThuCung = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        txtTimKiemThuCung = new javax.swing.JTextField();
        btnTimKiemThuCung = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        cboLocSoHuuThuCung = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        cboLocLoaiThuCung = new javax.swing.JComboBox<>();
        cboLocGIongThuCung = new javax.swing.JComboBox<>();
        tabKhachHang = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSanhSachKhachHang = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        txtTimKiemTenKhachHang = new javax.swing.JTextField();
        btnTimKiemKhachHang = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        btnDauTienDanhSachKhachHang = new javax.swing.JButton();
        btnCuoiCungDanhSachKhachHang = new javax.swing.JButton();
        btnSauDanhSachKhachHang = new javax.swing.JButton();
        btnTruocDanhSachKhachHang = new javax.swing.JButton();
        btnThemKhachHang = new javax.swing.JButton();
        tabSanPham = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtGiaNhapSanPham = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtDonViSanPham = new javax.swing.JTextField();
        cboTrangThaiSanPham = new javax.swing.JComboBox<>();
        txtMaSanPham = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtGiaBanSanPham = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtMaLoaiSanPham = new javax.swing.JTextField();
        txtSoLuongSanPham = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDanhSachSanPham = new javax.swing.JTable();
        jLabel61 = new javax.swing.JLabel();
        txtTimKiemTenSanPham = new javax.swing.JTextField();
        btnTimKiemSanPham = new javax.swing.JButton();
        cboLocTrangThaiSanPham = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnCuoiCungDanhSachSanPham = new javax.swing.JButton();
        btnTruocDanhSachSanPham = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        btnThemSanPham = new javax.swing.JButton();
        btnSauDanhSachSanPham = new javax.swing.JButton();
        banLamMoiSanPham = new javax.swing.JButton();
        btnDauTienDanhSachSanPham = new javax.swing.JButton();
        btnThemMoiLoaiSanPham = new javax.swing.JButton();
        btnSuaSanPham = new javax.swing.JButton();
        tabKhuyenMai = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        txtNgayBatDauKhuyenMai = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        txtMaKhuyenMai = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtPhanTramKhuyenMai = new javax.swing.JTextField();
        lblKhuyenMaiIcon = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtTimKiemKhuyenMai = new javax.swing.JTextField();
        btnTimKiemKhuyenMai = new javax.swing.JButton();
        btnThemKhuyenMai = new javax.swing.JButton();
        btnXoaKhuyenMai = new javax.swing.JButton();
        btnSuaKhuyenMai = new javax.swing.JButton();
        btnLamMoiKhuyenMai = new javax.swing.JButton();
        btnDauTienDanhSachKhuyenMai = new javax.swing.JButton();
        btnTruocDanhSachKhuyenMai = new javax.swing.JButton();
        btnSauDanhSachKhuyenMai = new javax.swing.JButton();
        btnCuoiCungDanhSachKhuyenMai = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cboLocTrangThaiKhuyenMai = new javax.swing.JComboBox<>();
        tabDichVu = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtDonViDichVu = new javax.swing.JTextField();
        txtTenDichVu = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtGiaTienDichhVu = new javax.swing.JTextField();
        txtMaDichVu = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnLamMoiDichVu = new javax.swing.JButton();
        btnSuaDichVu = new javax.swing.JButton();
        btnXoaDichVu = new javax.swing.JButton();
        btnThemDichVu = new javax.swing.JButton();
        btnDauTienDichVu = new javax.swing.JButton();
        btnTruocDichVu = new javax.swing.JButton();
        btnSauDichVu = new javax.swing.JButton();
        btnCuoiCungDichVu = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tnlDanhSachDichVu = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        txtTimKiemDichVu = new javax.swing.JTextField();
        btnTimKiemDichVu = new javax.swing.JButton();
        tabKho = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lblTongTienNhap = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        lblTongTienXuat = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        lblTongSoHangHoa = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        lblNhapHang1 = new javax.swing.JLabel();
        lblDonHang1 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        tabNhapHang = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        txtMaHangNhap = new javax.swing.JTextField();
        txtTenHangNhap = new javax.swing.JTextField();
        txtDonViHangNhap = new javax.swing.JTextField();
        btnThemNhapHang = new javax.swing.JButton();
        btnSuaNhapHang = new javax.swing.JButton();
        btnXoaNhapHang = new javax.swing.JButton();
        btnMoiNhapHang = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbllDachSachNhapHang = new javax.swing.JTable();
        btnDauTienNhapHang = new javax.swing.JButton();
        btnTruocNhapHang = new javax.swing.JButton();
        btnSauNhapHang = new javax.swing.JButton();
        btnCuoiCungNhapHang = new javax.swing.JButton();
        txtSoLuonngHangNhap = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        txtMaNhapHang = new javax.swing.JTextField();
        tabDonHang = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        txtMaHangDonHang = new javax.swing.JTextField();
        txtTenHangDonHang = new javax.swing.JTextField();
        txtDonViDonHang = new javax.swing.JTextField();
        btnThemDonHang = new javax.swing.JButton();
        btnSuaDonHang = new javax.swing.JButton();
        btnXoaDonHang = new javax.swing.JButton();
        btnLamMoiDonHang = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblDanhSachDonHang = new javax.swing.JTable();
        btnDauTienDonHang = new javax.swing.JButton();
        btnTruocDonHang = new javax.swing.JButton();
        btnSauDonHang = new javax.swing.JButton();
        btnCuoiCungDonHang = new javax.swing.JButton();
        txtSoLuongHangDonHang = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        txtMaHangDonHang1 = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        lblTongSoTienHang = new javax.swing.JLabel();
        tabHoaDon = new javax.swing.JPanel();
        tabbedHoaDon = new javax.swing.JPanel();
        tabbedSanPham_DichVu = new javax.swing.JPanel();
        lblHoaDonSanPham = new javax.swing.JLabel();
        lblHoaDonDichVu = new javax.swing.JLabel();
        lblHoaDonLichSu = new javax.swing.JLabel();
        pnlNenHoaDon = new javax.swing.JPanel();
        tabThemHoaDon = new javax.swing.JPanel();
        pnlNenThemHoaDon = new javax.swing.JPanel();
        pnlNenSanPham_DichVu = new javax.swing.JPanel();
        tabHoaDonSanPham = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablDanhSachSanPhamHoaDon = new javax.swing.JTable();
        jLabel72 = new javax.swing.JLabel();
        txtTimKiemSanPhamHoaDon = new javax.swing.JTextField();
        btnTimKiemSanPhamHoaDon = new javax.swing.JButton();
        tabHoaDonDichVu = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txtNgayDatDichVu = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        txtMaDatDichVu = new javax.swing.JTextField();
        cboTenDichVu = new javax.swing.JComboBox<>();
        txtSoLuongDichVu = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtGhiChuDichVu = new javax.swing.JTextArea();
        txtNgayNhanThuCung = new javax.swing.JTextField();
        txtSoDienThoaiDatLich = new javax.swing.JTextField();
        btnLamMoiDatLich = new javax.swing.JButton();
        btnThemDatLich = new javax.swing.JButton();
        btnSuaDatLich = new javax.swing.JButton();
        pnlHoaDon = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        cboLoaiKhachHangHoaDon = new javax.swing.JComboBox<>();
        txtMaHoaDon = new javax.swing.JTextField();
        txtMaNhanVienHoaDon = new javax.swing.JTextField();
        txtTongTienHoaDon = new javax.swing.JTextField();
        txtTienNhanHoaDon = new javax.swing.JTextField();
        txtTienThuaHoaDon = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtGhiChuHoaDon = new javax.swing.JTextArea();
        btnTaoHoaDon = new javax.swing.JButton();
        btnHuyHoaDon = new javax.swing.JButton();
        btnThemHoaDon = new javax.swing.JButton();
        btnXuatHoaDon = new javax.swing.JButton();
        cboDanhSachKhachHang = new javax.swing.JComboBox<>();
        pnlHoaDonChiTiet = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        cboKhuyenMaiHoaDon = new javax.swing.JComboBox<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblDanhSahChiTietHoaDon = new javax.swing.JTable();
        btnLamMoiChiTietHoaDon = new javax.swing.JButton();
        btnXoaChiTietHoaDon = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        tabXemLichSuHoaDon = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblDanhSachHoaDon = new javax.swing.JTable();
        tabThongKe = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lblDanhThuThongKe = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        lblDoanhThu = new javax.swing.JLabel();
        lblLuotBan = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        tabDoanhThu = new javax.swing.JPanel();
        tabLuotBan = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        lblLuotBanThongKe = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        tabTrangChu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblTrangChu = new javax.swing.JLabel();
        pnlThongTinNguoiDung = new javax.swing.JPanel();
        lblUserIcon1 = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        lblDoiMatKhau = new javax.swing.JLabel();
        lblTroGiup = new javax.swing.JLabel();
        lblExitMenuNguoiDung = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));

        pnlDanhSach.setBackground(new java.awt.Color(0, 51, 51));
        pnlDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDanhSachMouseClicked(evt);
            }
        });
        pnlDanhSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlDanhSach.add(lblHinhLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 70, 87));
        pnlDanhSach.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 108, 81, -1));

        pnlHeThong.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hệ Thống:");

        lblMenuNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuNhanVien.setText("Nhân Viên");
        lblMenuNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuNhanVienMouseClicked(evt);
            }
        });

        lblMenuThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuThongKe.setText("Thống Kê");
        lblMenuThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuThongKeMouseClicked(evt);
            }
        });

        lblMenuKho.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuKho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuKho.setText("Kho");
        lblMenuKho.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuKhoMouseClicked(evt);
            }
        });

        lblMenuTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuTrangChu.setText("Trang Chủ");
        lblMenuTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuTrangChuMouseClicked(evt);
            }
        });

        lblMenuSuKien.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuSuKien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuSuKien.setText("Sự Kiện");
        lblMenuSuKien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuSuKien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuSuKienMouseClicked(evt);
            }
        });

        lblMenuKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuKhuyenMai.setText("Khuyến mãi");
        lblMenuKhuyenMai.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuKhuyenMaiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlHeThongLayout = new javax.swing.GroupLayout(pnlHeThong);
        pnlHeThong.setLayout(pnlHeThongLayout);
        pnlHeThongLayout.setHorizontalGroup(
            pnlHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeThongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuSuKien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlHeThongLayout.setVerticalGroup(
            pnlHeThongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeThongLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenuTrangChu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenuSuKien)
                .addGap(12, 12, 12)
                .addComponent(lblMenuThongKe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenuKho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenuNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenuKhuyenMai)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pnlDanhSach.add(pnlHeThong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 200, 240));

        pnlChucNang.setBackground(new java.awt.Color(0, 51, 51));

        lblMenuDichVu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuDichVu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuDichVu.setText("Dịch Vụ ");
        lblMenuDichVu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuDichVuMouseClicked(evt);
            }
        });

        lblMenuHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuHoaDon.setText("Hóa Đơn");
        lblMenuHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuHoaDonMouseClicked(evt);
            }
        });

        lblMenuSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuSanPham.setText("Sản Phẩm");
        lblMenuSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuSanPhamMouseClicked(evt);
            }
        });

        lblMenuThuCung.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuThuCung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuThuCung.setText("Thú Cưng");
        lblMenuThuCung.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuThuCung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuThuCungMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Chức Năng:");

        lblMenuKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuKhachHang.setText("Khách Hàng");
        lblMenuKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblMenuKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuKhachHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuThuCung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenuKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(lblMenuHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenuHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenuSanPham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenuThuCung)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenuDichVu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenuKhachHang)
                .addContainerGap())
        );

        pnlDanhSach.add(pnlChucNang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, 210));

        lblExitMenuIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMenuIconMouseClicked(evt);
            }
        });
        pnlDanhSach.add(lblExitMenuIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 24, 24));

        pnlTrangThai.setBackground(new java.awt.Color(0, 51, 51));

        lblLock.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLock.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlTrangThaiLayout = new javax.swing.GroupLayout(pnlTrangThai);
        pnlTrangThai.setLayout(pnlTrangThaiLayout);
        pnlTrangThaiLayout.setHorizontalGroup(
            pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTrangThaiLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLock, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        pnlTrangThaiLayout.setVerticalGroup(
            pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblLock, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        pnlHead.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("DOCA");

        lblOpenMenuIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOpenMenuIconMouseClicked(evt);
            }
        });

        lblUserIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeadLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblOpenMenuIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHinhLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlHeadLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblHinhLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(lblOpenMenuIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlCard.setPreferredSize(new java.awt.Dimension(1250, 580));
        pnlCard.setLayout(new java.awt.CardLayout());

        tabNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        tabNhanVien.setPreferredSize(new java.awt.Dimension(1250, 600));

        jLabel8.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        jLabel8.setText("Thông Tin Nhân Viên");

        lblHinhNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblHinhNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhNhanVienMouseClicked(evt);
            }
        });

        btnTaiKhoanNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        btnTaiKhoanNhanVien.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTaiKhoanNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnTaiKhoanNhanVien.setText("Tài Khoản Nhân Viên");
        btnTaiKhoanNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanNhanVienActionPerformed(evt);
            }
        });

        tblDanhSachNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhSachNhanVien.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblDanhSachNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSachNhanVien);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setText("Mã Nhân Viên");

        jLabel27.setText("Vai Trò");

        btnGVaiTro.add(rdoVaiTroNhanVien);
        rdoVaiTroNhanVien.setText("Nhân Viên");

        jLabel22.setText("Họ Tên");

        btnGVaiTro.add(rdoVaiTroQuanLy);
        rdoVaiTroQuanLy.setText("Quản Lý");

        txtHoTenNhanVien.setToolTipText("Họ tên nhân viên");

        jLabel26.setText("Trạng Thái");

        jLabel24.setText("Số Điện Thoại");

        jLabel25.setText("Email");

        txtSoDienThoaiNhanVien.setToolTipText("Số điện thoại");

        rdoNamNhanVien.setText("Nam");

        txtEmailNhanVien.setToolTipText("Email");
        txtEmailNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailNhanVienActionPerformed(evt);
            }
        });

        jLabel23.setText("Giới Tính");

        rdoNuNhanVien.setText("Nữ");

        txtMaNhanVien.setToolTipText("Mã nhân viên");

        jLabel28.setText("Ngày Sinh");

        txtNgaySinhNhanVien.setToolTipText("Ngày sinh");
        txtNgaySinhNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinhNhanVienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgaySinhNhanVien)
                    .addComponent(cboTrangThaiNhanVien, 0, 337, Short.MAX_VALUE)
                    .addComponent(txtEmailNhanVien)
                    .addComponent(txtMaNhanVien)
                    .addComponent(txtHoTenNhanVien)
                    .addComponent(txtSoDienThoaiNhanVien)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoNamNhanVien)
                                .addGap(44, 44, 44)
                                .addComponent(rdoNuNhanVien))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoVaiTroNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoVaiTroQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtHoTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(rdoNamNhanVien)
                    .addComponent(rdoNuNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtEmailNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cboTrangThaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(rdoVaiTroNhanVien)
                    .addComponent(rdoVaiTroQuanLy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnThemNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        btnThemNhanVien.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnThemNhanVien.setText("Thêm");
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        btnLamMoiNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiNhanVien.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnLamMoiNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiNhanVien.setText("Làm mới");
        btnLamMoiNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiNhanVienActionPerformed(evt);
            }
        });

        btnSauDanhSachNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        btnSauDanhSachNhanVien.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauDanhSachNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnSauDanhSachNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauDanhSachNhanVienActionPerformed(evt);
            }
        });

        btnTruocDanhSachNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocDanhSachNhanVien.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocDanhSachNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnTruocDanhSachNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruocDanhSachNhanVienActionPerformed(evt);
            }
        });

        btnCuoiCungDanhSachNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungDanhSachNhanVien.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungDanhSachNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnCuoiCungDanhSachNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiCungDanhSachNhanVienActionPerformed(evt);
            }
        });

        btnDauTienDanhSachNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienDanhSachNhanVien.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnDauTienDanhSachNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnDauTienDanhSachNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauTienDanhSachNhanVienActionPerformed(evt);
            }
        });

        btnSuaNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        btnSuaNhanVien.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSuaNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaNhanVien.setText("Sửa");
        btnSuaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNhanVienActionPerformed(evt);
            }
        });

        btnXoaNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaNhanVien.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnXoaNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaNhanVien.setText("Xóa");
        btnXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhanVienActionPerformed(evt);
            }
        });

        btnLoad.setBackground(new java.awt.Color(0, 51, 51));
        btnLoad.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnLoad.setForeground(new java.awt.Color(255, 255, 255));
        btnLoad.setText("Tải lại");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(btnDauTienDanhSachNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnTruocDanhSachNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSauDanhSachNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCuoiCungDanhSachNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoiNhanVien)
                    .addComponent(btnSuaNhanVien)
                    .addComponent(btnXoaNhanVien)
                    .addComponent(btnThemNhanVien)
                    .addComponent(btnDauTienDanhSachNhanVien)
                    .addComponent(btnTruocDanhSachNhanVien)
                    .addComponent(btnSauDanhSachNhanVien)
                    .addComponent(btnCuoiCungDanhSachNhanVien)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel44.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel44.setText("Tìm kiếm");

        btnTimTenNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        btnTimTenNhanVien.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimTenNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnTimTenNhanVien.setText("Tìm");
        btnTimTenNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimTenNhanVienActionPerformed(evt);
            }
        });

        cboLocVaiTroNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocVaiTroNhanVienActionPerformed(evt);
            }
        });

        cboLocTrangThaiNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocTrangThaiNhanVienActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel45.setText("Vai Trò:");

        jLabel46.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel46.setText("Trạng Thái:");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout tabNhanVienLayout = new javax.swing.GroupLayout(tabNhanVien);
        tabNhanVien.setLayout(tabNhanVienLayout);
        tabNhanVienLayout.setHorizontalGroup(
            tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabNhanVienLayout.createSequentialGroup()
                .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabNhanVienLayout.createSequentialGroup()
                        .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabNhanVienLayout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(lblHinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnTaiKhoanNhanVien)
                                .addGap(64, 64, 64))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabNhanVienLayout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboLocVaiTroNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboLocTrangThaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46)))))
                    .addGroup(tabNhanVienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(tabNhanVienLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabNhanVienLayout.setVerticalGroup(
            tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabNhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabNhanVienLayout.createSequentialGroup()
                        .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabNhanVienLayout.createSequentialGroup()
                        .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabNhanVienLayout.createSequentialGroup()
                                .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblHinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTaiKhoanNhanVien))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(tabNhanVienLayout.createSequentialGroup()
                                .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel44)
                                    .addComponent(txtTimTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTimTenNhanVien)
                                    .addComponent(cboLocVaiTroNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboLocTrangThaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pnlCard.add(tabNhanVien, "card4");

        tabSuKien.setPreferredSize(new java.awt.Dimension(1250, 563));

        jLabel7.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        jLabel7.setText("Thông Báo");

        tblDanhSachSuKien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDanhSachSuKien);

        javax.swing.GroupLayout tabSuKienLayout = new javax.swing.GroupLayout(tabSuKien);
        tabSuKien.setLayout(tabSuKienLayout);
        tabSuKienLayout.setHorizontalGroup(
            tabSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSuKienLayout.createSequentialGroup()
                .addGroup(tabSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabSuKienLayout.createSequentialGroup()
                        .addGap(588, 588, 588)
                        .addComponent(jLabel7))
                    .addGroup(tabSuKienLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        tabSuKienLayout.setVerticalGroup(
            tabSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSuKienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlCard.add(tabSuKien, "card3");

        pnlNenThuCung.setPreferredSize(new java.awt.Dimension(1275, 580));

        tabbedThuCung.setBackground(new java.awt.Color(0, 51, 51));
        tabbedThuCung.setLayout(new java.awt.GridLayout(1, 0));

        lblThongTinThuCung.setBackground(new java.awt.Color(0, 51, 51));
        lblThongTinThuCung.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThongTinThuCung.setForeground(new java.awt.Color(255, 255, 255));
        lblThongTinThuCung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongTinThuCung.setText("Thông Tin");
        lblThongTinThuCung.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblThongTinThuCung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongTinThuCungMouseClicked(evt);
            }
        });
        tabbedThuCung.add(lblThongTinThuCung);

        lblDanhSachThuCung.setBackground(new java.awt.Color(0, 51, 51));
        lblDanhSachThuCung.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDanhSachThuCung.setForeground(new java.awt.Color(255, 255, 255));
        lblDanhSachThuCung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDanhSachThuCung.setText("Danh Sách");
        lblDanhSachThuCung.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDanhSachThuCung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDanhSachThuCungMouseClicked(evt);
            }
        });
        tabbedThuCung.add(lblDanhSachThuCung);

        jPanel7.setLayout(new java.awt.CardLayout());

        jLabel36.setText("Cân Nặng");

        rdoGioiTinhDuc.setText("Đực");
        rdoGioiTinhDuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoGioiTinhDucActionPerformed(evt);
            }
        });

        jLabel35.setText("Loài");

        cboGiongThuCung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel34.setText("Giá Tiền");

        jLabel15.setText("Giống");

        jLabel30.setText("Giới tính");

        jLabel37.setText("Mã Thú Cưng");

        cboLoaiThuCung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        rdoGioiTinhCai.setText("Cái");

        jLabel29.setText("Tuổi");

        jLabel33.setText("Số Chuồng");

        txtSoChuongThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoChuongThuCungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtSoChuongThuCung)
                        .addGap(61, 61, 61))
                    .addComponent(txtGiaTienThuCung, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCanNangThuCung)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(rdoGioiTinhDuc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoGioiTinhCai, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cboGiongThuCung, 0, 228, Short.MAX_VALUE)
                                .addComponent(cboLoaiThuCung, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTuoiThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 157, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel15, jLabel30, jLabel34, jLabel35, jLabel36, jLabel37});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtMaThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtGiaTienThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(cboLoaiThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cboGiongThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtCanNangThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoGioiTinhDuc)
                        .addComponent(rdoGioiTinhCai)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtTuoiThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtSoChuongThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel38.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        jLabel38.setText("Thông Tin Thú Cưng");

        jLabel32.setText("Hình Ảnh");

        txtThuocSoHuuThuCung.setText("Thuộc");

        lblAnhThuCung.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtMoTaThuCung.setColumns(20);
        txtMoTaThuCung.setRows(5);
        jScrollPane3.setViewportView(txtMoTaThuCung);

        jLabel31.setText("Mô Tả");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtThuocSoHuuThuCung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnhThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(4, 4, 4)
                .addComponent(lblAnhThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtThuocSoHuuThuCung)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        btnThemChuongThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnThemChuongThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemChuongThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnThemChuongThuCung.setText("Thêm chuồng");
        btnThemChuongThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChuongThuCungActionPerformed(evt);
            }
        });

        btnLamMoiThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnLamMoiThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiThuCung.setText("Làm mới");

        btnSuaThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnSuaThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSuaThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaThuCung.setText("Sửa");
        btnSuaThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThuCungActionPerformed(evt);
            }
        });

        btnXoaThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnXoaThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaThuCung.setText("Xóa");

        btnThemThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnThemThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnThemThuCung.setText("Thêm");

        btnThemLoaiThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnThemLoaiThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemLoaiThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnThemLoaiThuCung.setText("Thêm loài mới");
        btnThemLoaiThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiThuCungActionPerformed(evt);
            }
        });

        btnDauTienThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnDauTienThuCung.setForeground(new java.awt.Color(255, 255, 255));

        btnTruocThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocThuCung.setForeground(new java.awt.Color(255, 255, 255));

        btnSauThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnSauThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauThuCung.setForeground(new java.awt.Color(255, 255, 255));

        btnCuoiCungThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungThuCung.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnThemThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuaThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoiThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemLoaiThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemChuongThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDauTienThuCung)
                .addGap(18, 18, 18)
                .addComponent(btnTruocThuCung)
                .addGap(18, 18, 18)
                .addComponent(btnSauThuCung)
                .addGap(18, 18, 18)
                .addComponent(btnCuoiCungThuCung)
                .addGap(81, 81, 81))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDauTienThuCung)
                    .addComponent(btnTruocThuCung)
                    .addComponent(btnSauThuCung)
                    .addComponent(btnCuoiCungThuCung)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemThuCung)
                        .addComponent(btnXoaThuCung)
                        .addComponent(btnSuaThuCung)
                        .addComponent(btnLamMoiThuCung)
                        .addComponent(btnThemLoaiThuCung)
                        .addComponent(btnThemChuongThuCung)))
                .addContainerGap())
        );

        javax.swing.GroupLayout tabThongTinThuCungLayout = new javax.swing.GroupLayout(tabThongTinThuCung);
        tabThongTinThuCung.setLayout(tabThongTinThuCungLayout);
        tabThongTinThuCungLayout.setHorizontalGroup(
            tabThongTinThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongTinThuCungLayout.createSequentialGroup()
                .addGap(501, 501, 501)
                .addComponent(jLabel38)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(tabThongTinThuCungLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 125, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabThongTinThuCungLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabThongTinThuCungLayout.setVerticalGroup(
            tabThongTinThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabThongTinThuCungLayout.createSequentialGroup()
                .addGroup(tabThongTinThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabThongTinThuCungLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabThongTinThuCungLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel7.add(tabThongTinThuCung, "card2");

        tabDanhSachThuCung.setPreferredSize(new java.awt.Dimension(1250, 520));

        tblDanahSachThuCung.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblDanahSachThuCung);

        jLabel40.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel40.setText("Tìm kiếm");

        btnTimKiemThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemThuCung.setText("Tìm");

        jLabel43.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel43.setText("Thuộc");

        jLabel42.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel42.setText("Giống");

        cboLocSoHuuThuCung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel41.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel41.setText("Loài");

        cboLocLoaiThuCung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboLocGIongThuCung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboLocLoaiThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(cboLocGIongThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(cboLocSoHuuThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLocLoaiThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLocGIongThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLocSoHuuThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout tabDanhSachThuCungLayout = new javax.swing.GroupLayout(tabDanhSachThuCung);
        tabDanhSachThuCung.setLayout(tabDanhSachThuCungLayout);
        tabDanhSachThuCungLayout.setHorizontalGroup(
            tabDanhSachThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDanhSachThuCungLayout.createSequentialGroup()
                .addGroup(tabDanhSachThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(tabDanhSachThuCungLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDanhSachThuCungLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiemThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnTimKiemThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        tabDanhSachThuCungLayout.setVerticalGroup(
            tabDanhSachThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDanhSachThuCungLayout.createSequentialGroup()
                .addGroup(tabDanhSachThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDanhSachThuCungLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(tabDanhSachThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtTimKiemThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemThuCung)))
                    .addGroup(tabDanhSachThuCungLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jPanel7.add(tabDanhSachThuCung, "card3");

        javax.swing.GroupLayout pnlNenThuCungLayout = new javax.swing.GroupLayout(pnlNenThuCung);
        pnlNenThuCung.setLayout(pnlNenThuCungLayout);
        pnlNenThuCungLayout.setHorizontalGroup(
            pnlNenThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedThuCung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );
        pnlNenThuCungLayout.setVerticalGroup(
            pnlNenThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNenThuCungLayout.createSequentialGroup()
                .addComponent(tabbedThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tabThuCungLayout = new javax.swing.GroupLayout(tabThuCung);
        tabThuCung.setLayout(tabThuCungLayout);
        tabThuCungLayout.setHorizontalGroup(
            tabThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNenThuCung, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
        );
        tabThuCungLayout.setVerticalGroup(
            tabThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNenThuCung, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

        pnlCard.add(tabThuCung, "card11");

        jLabel16.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("Danh Sách Khách Hàng");

        tblSanhSachKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblSanhSachKhachHang);

        jLabel47.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel47.setText("Tìm Kiếm:");

        btnTimKiemKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemKhachHang.setText("Tìm");

        btnDauTienDanhSachKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienDanhSachKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnDauTienDanhSachKhachHang.setForeground(new java.awt.Color(255, 255, 255));

        btnCuoiCungDanhSachKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungDanhSachKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungDanhSachKhachHang.setForeground(new java.awt.Color(255, 255, 255));

        btnSauDanhSachKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnSauDanhSachKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauDanhSachKhachHang.setForeground(new java.awt.Color(255, 255, 255));

        btnTruocDanhSachKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocDanhSachKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocDanhSachKhachHang.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDauTienDanhSachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnTruocDanhSachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSauDanhSachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCuoiCungDanhSachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCuoiCungDanhSachKhachHang)
                    .addComponent(btnSauDanhSachKhachHang)
                    .addComponent(btnTruocDanhSachKhachHang)
                    .addComponent(btnDauTienDanhSachKhachHang))
                .addContainerGap())
        );

        btnThemKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnThemKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKhachHang.setText("Thêm Khách Hàng");
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabKhachHangLayout = new javax.swing.GroupLayout(tabKhachHang);
        tabKhachHang.setLayout(tabKhachHangLayout);
        tabKhachHangLayout.setHorizontalGroup(
            tabKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabKhachHangLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(tabKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabKhachHangLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(tabKhachHangLayout.createSequentialGroup()
                        .addGroup(tabKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabKhachHangLayout.createSequentialGroup()
                                .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        tabKhachHangLayout.setVerticalGroup(
            tabKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabKhachHangLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(tabKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel47)
                    .addComponent(txtTimKiemTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemKhachHang))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(tabKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pnlCard.add(tabKhachHang, "card12");

        txtGiaNhapSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNhapSanPhamActionPerformed(evt);
            }
        });

        jLabel60.setText("Giá Bán:");

        jLabel57.setText("Số Lượng:");

        txtDonViSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonViSanPhamActionPerformed(evt);
            }
        });

        cboTrangThaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTrangThaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiSanPhamActionPerformed(evt);
            }
        });

        jLabel54.setText("Mã Loại:");

        jLabel58.setText("Trạng Thái:");

        jLabel59.setText("Đơn vị tính:");

        jLabel53.setText("Mã Sản Phẩm:");

        jLabel55.setText("Tên Sản Phẩm:");

        jLabel56.setText("Giá Nhập:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel55)
                                .addComponent(jLabel59)
                                .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel53)
                                .addComponent(jLabel54))
                            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMaLoaiSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                .addComponent(txtTenSanPham, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDonViSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                .addComponent(txtGiaBanSanPham))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaNhapSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel55, jLabel56, jLabel57, jLabel58, jLabel59, jLabel60});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtMaLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtGiaNhapSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaBanSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtDonViSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(txtSoLuongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(cboTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tblDanhSachSanPham);

        jLabel61.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel61.setText("Tìm kiếm:");

        txtTimKiemTenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemTenSanPhamActionPerformed(evt);
            }
        });

        btnTimKiemSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemSanPham.setText("Tìm");

        cboLocTrangThaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel62.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel62.setText("Trạng Thái:");

        jLabel63.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        jLabel63.setText("Thông Tin Sản Phẩm");

        btnCuoiCungDanhSachSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungDanhSachSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungDanhSachSanPham.setForeground(new java.awt.Color(255, 255, 255));

        btnTruocDanhSachSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocDanhSachSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocDanhSachSanPham.setForeground(new java.awt.Color(255, 255, 255));

        btnXoaSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnXoaSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSanPham.setText("Xóa");

        btnThemSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnThemSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSanPham.setText("Thêm");

        btnSauDanhSachSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnSauDanhSachSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauDanhSachSanPham.setForeground(new java.awt.Color(255, 255, 255));

        banLamMoiSanPham.setBackground(new java.awt.Color(0, 51, 51));
        banLamMoiSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        banLamMoiSanPham.setForeground(new java.awt.Color(255, 255, 255));
        banLamMoiSanPham.setText("Làm mới");

        btnDauTienDanhSachSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienDanhSachSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnDauTienDanhSachSanPham.setForeground(new java.awt.Color(255, 255, 255));

        btnThemMoiLoaiSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnThemMoiLoaiSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemMoiLoaiSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMoiLoaiSanPham.setText("Thêm loại sản phẩm mới");
        btnThemMoiLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiLoaiSanPhamActionPerformed(evt);
            }
        });

        btnSuaSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnSuaSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSuaSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaSanPham.setText("Sửa");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(banLamMoiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemMoiLoaiSanPham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDauTienDanhSachSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTruocDanhSachSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSauDanhSachSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCuoiCungDanhSachSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDauTienDanhSachSanPham)
                    .addComponent(btnTruocDanhSachSanPham)
                    .addComponent(btnSauDanhSachSanPham)
                    .addComponent(btnCuoiCungDanhSachSanPham)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemSanPham)
                        .addComponent(btnXoaSanPham)
                        .addComponent(btnThemMoiLoaiSanPham)
                        .addComponent(banLamMoiSanPham)
                        .addComponent(btnSuaSanPham)))
                .addContainerGap())
        );

        javax.swing.GroupLayout tabSanPhamLayout = new javax.swing.GroupLayout(tabSanPham);
        tabSanPham.setLayout(tabSanPhamLayout);
        tabSanPhamLayout.setHorizontalGroup(
            tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSanPhamLayout.createSequentialGroup()
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabSanPhamLayout.createSequentialGroup()
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiemTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboLocTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel62))
                                .addGap(49, 49, 49))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        tabSanPhamLayout.setVerticalGroup(
            tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSanPhamLayout.createSequentialGroup()
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabSanPhamLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemSanPham)
                            .addComponent(jLabel63)
                            .addComponent(jLabel61))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSanPhamLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboLocTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabSanPhamLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pnlCard.add(tabSanPham, "card10");

        tabKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabKhuyenMaiMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("Khuyến Mãi");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable5);

        jLabel48.setText("Mã Khuyến Mãi");

        jLabel51.setText("Ngày Bắt Đầu");

        jLabel49.setText("Ngày Kết Thúc");

        jLabel50.setText("Phần Trăm");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayBatDauKhuyenMai))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaKhuyenMai))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhanTramKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(lblKhuyenMaiIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField13)))
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel48, jLabel49, jLabel50, jLabel51});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(txtPhanTramKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblKhuyenMaiIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtNgayBatDauKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel52.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel52.setText("Tìm kiếm:");

        btnTimKiemKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemKhuyenMai.setText("Tìm");

        btnThemKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnThemKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKhuyenMai.setText("Thêm");

        btnXoaKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnXoaKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaKhuyenMai.setText("Xóa");

        btnSuaKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnSuaKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSuaKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaKhuyenMai.setText("Sửa");

        btnLamMoiKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnLamMoiKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiKhuyenMai.setText("Làm mới");

        btnDauTienDanhSachKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienDanhSachKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnDauTienDanhSachKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnDauTienDanhSachKhuyenMai.setText("kk");

        btnTruocDanhSachKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocDanhSachKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocDanhSachKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnTruocDanhSachKhuyenMai.setText("jButton17");

        btnSauDanhSachKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnSauDanhSachKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauDanhSachKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnSauDanhSachKhuyenMai.setText("jButton18");

        btnCuoiCungDanhSachKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungDanhSachKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungDanhSachKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnCuoiCungDanhSachKhuyenMai.setText("jButton19");

        jLabel14.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel14.setText("Trạng Thái:");

        cboLocTrangThaiKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout tabKhuyenMaiLayout = new javax.swing.GroupLayout(tabKhuyenMai);
        tabKhuyenMai.setLayout(tabKhuyenMaiLayout);
        tabKhuyenMaiLayout.setHorizontalGroup(
            tabKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabKhuyenMaiLayout.createSequentialGroup()
                .addGroup(tabKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabKhuyenMaiLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnThemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoiKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(btnDauTienDanhSachKhuyenMai)
                        .addGap(47, 47, 47)
                        .addComponent(btnTruocDanhSachKhuyenMai)
                        .addGap(47, 47, 47)
                        .addComponent(btnSauDanhSachKhuyenMai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(btnCuoiCungDanhSachKhuyenMai))
                    .addGroup(tabKhuyenMaiLayout.createSequentialGroup()
                        .addGroup(tabKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabKhuyenMaiLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabKhuyenMaiLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tabKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabKhuyenMaiLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(31, 31, 31)
                                .addComponent(txtTimKiemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addGroup(tabKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboLocTrangThaiKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(43, 43, 43))
        );
        tabKhuyenMaiLayout.setVerticalGroup(
            tabKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabKhuyenMaiLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtTimKiemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemKhuyenMai)
                    .addComponent(cboLocTrangThaiKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(tabKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabKhuyenMaiLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(53, 53, 53)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(tabKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKhuyenMai)
                    .addComponent(btnXoaKhuyenMai)
                    .addComponent(btnSuaKhuyenMai)
                    .addComponent(btnLamMoiKhuyenMai)
                    .addComponent(btnDauTienDanhSachKhuyenMai)
                    .addComponent(btnTruocDanhSachKhuyenMai)
                    .addComponent(btnSauDanhSachKhuyenMai)
                    .addComponent(btnCuoiCungDanhSachKhuyenMai))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pnlCard.add(tabKhuyenMai, "card6");

        jLabel12.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 24)); // NOI18N
        jLabel12.setText("Thông Tin Dịch Vụ");

        jLabel65.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N
        jLabel65.setText("Tên Dịch Vụ:");

        jLabel66.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N
        jLabel66.setText("GIá Tiền:");

        txtDonViDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N

        txtTenDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N

        jLabel67.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N
        jLabel67.setText("Đơn Vị:");

        txtGiaTienDichhVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N
        txtGiaTienDichhVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaTienDichhVuActionPerformed(evt);
            }
        });

        txtMaDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N

        jLabel64.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N
        jLabel64.setText("Mã Dịch Vụ:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(jLabel64)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67))
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDonViDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaTienDichhVu, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDonViDichVu, txtGiaTienDichhVu, txtMaDichVu, txtTenDichVu});

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel64, jLabel65, jLabel66, jLabel67});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(txtGiaTienDichhVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(txtDonViDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnLamMoiDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnLamMoiDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiDichVu.setText("Làm mới");

        btnSuaDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnSuaDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSuaDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaDichVu.setText("Sửa");
        btnSuaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDichVuActionPerformed(evt);
            }
        });

        btnXoaDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnXoaDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaDichVu.setText("Xóa");

        btnThemDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnThemDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnThemDichVu.setText("Thêm");

        btnDauTienDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnDauTienDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnDauTienDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauTienDichVuActionPerformed(evt);
            }
        });

        btnTruocDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocDichVu.setForeground(new java.awt.Color(255, 255, 255));

        btnSauDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnSauDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauDichVu.setForeground(new java.awt.Color(255, 255, 255));

        btnCuoiCungDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnCuoiCungDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiCungDichVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242)
                .addComponent(btnDauTienDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTruocDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSauDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCuoiCungDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDauTienDichVu)
                    .addComponent(btnTruocDichVu)
                    .addComponent(btnSauDichVu)
                    .addComponent(btnCuoiCungDichVu)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemDichVu)
                        .addComponent(btnXoaDichVu)
                        .addComponent(btnSuaDichVu)
                        .addComponent(btnLamMoiDichVu)))
                .addContainerGap())
        );

        tnlDanhSachDichVu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tnlDanhSachDichVu);

        jLabel68.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 14)); // NOI18N
        jLabel68.setText("Tìm kiếm:");

        btnTimKiemDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemDichVu.setText("Tìm");

        javax.swing.GroupLayout tabDichVuLayout = new javax.swing.GroupLayout(tabDichVu);
        tabDichVu.setLayout(tabDichVuLayout);
        tabDichVuLayout.setHorizontalGroup(
            tabDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDichVuLayout.createSequentialGroup()
                .addGroup(tabDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabDichVuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDichVuLayout.createSequentialGroup()
                        .addGroup(tabDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDichVuLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabDichVuLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel12)))
                        .addGap(31, 31, 31)
                        .addGroup(tabDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabDichVuLayout.createSequentialGroup()
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabDichVuLayout.setVerticalGroup(
            tabDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDichVuLayout.createSequentialGroup()
                .addGroup(tabDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDichVuLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel12)
                        .addGap(84, 84, 84)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE))
                    .addGroup(tabDichVuLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(tabDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTimKiemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTimKiemDichVu))
                            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(32, 32, 32)))
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pnlCard.add(tabDichVu, "card8");

        jLabel92.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 51, 51));
        jLabel92.setText("Kho");

        jLabel97.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel97.setText("Tổng nhập");

        lblTongTienNhap.setFont(new java.awt.Font("Source Sans Pro Light", 1, 18)); // NOI18N
        lblTongTienNhap.setText("0");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTongTienNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTongTienNhap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel99.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel99.setText("Tổng số lượng hàng hóa");

        lblTongTienXuat.setFont(new java.awt.Font("Source Sans Pro Light", 1, 18)); // NOI18N
        lblTongTienXuat.setText("0");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongTienXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTongTienXuat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lbl.setText("Tổng xuất");

        jLabel102.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel102.setText("Tổng số tiền hàng");

        lblTongSoHangHoa.setFont(new java.awt.Font("Source Sans Pro Light", 1, 18)); // NOI18N
        lblTongSoHangHoa.setText("0");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongSoHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTongSoHangHoa)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(0, 51, 51));
        jPanel28.setLayout(new java.awt.GridLayout(1, 0));

        lblNhapHang1.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lblNhapHang1.setForeground(new java.awt.Color(255, 255, 255));
        lblNhapHang1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhapHang1.setText("Nhập Hàng");
        lblNhapHang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhapHang1MouseClicked(evt);
            }
        });
        jPanel28.add(lblNhapHang1);

        lblDonHang1.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lblDonHang1.setForeground(new java.awt.Color(255, 255, 255));
        lblDonHang1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDonHang1.setText("Đơn Hàng");
        jPanel28.add(lblDonHang1);

        jPanel29.setLayout(new java.awt.CardLayout());

        jLabel90.setText("Mã Hàng");

        jLabel94.setText("Đơn Vị ");

        jLabel95.setText("Tên Hàng");

        txtTenHangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenHangNhapActionPerformed(evt);
            }
        });

        txtDonViHangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonViHangNhapActionPerformed(evt);
            }
        });

        btnThemNhapHang.setBackground(new java.awt.Color(0, 51, 51));
        btnThemNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnThemNhapHang.setText("Thêm");
        btnThemNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhapHangActionPerformed(evt);
            }
        });

        btnSuaNhapHang.setBackground(new java.awt.Color(0, 51, 51));
        btnSuaNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaNhapHang.setText("Sửa");
        btnSuaNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNhapHangActionPerformed(evt);
            }
        });

        btnXoaNhapHang.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaNhapHang.setText("Xóa");
        btnXoaNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhapHangActionPerformed(evt);
            }
        });

        btnMoiNhapHang.setBackground(new java.awt.Color(0, 51, 51));
        btnMoiNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnMoiNhapHang.setText("Làm Mới");
        btnMoiNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiNhapHangActionPerformed(evt);
            }
        });

        tbllDachSachNhapHang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(tbllDachSachNhapHang);

        btnDauTienNhapHang.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnDauTienNhapHang.setText("<--");

        btnTruocNhapHang.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnTruocNhapHang.setText("<");

        btnSauNhapHang.setBackground(new java.awt.Color(0, 51, 51));
        btnSauNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnSauNhapHang.setText(">");

        btnCuoiCungNhapHang.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnCuoiCungNhapHang.setText("-->");

        txtSoLuonngHangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuonngHangNhapActionPerformed(evt);
            }
        });

        jLabel105.setText("Số Lượng");

        jLabel98.setText("Mã Nhâp Hàng");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDonViHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel90)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(btnThemNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnSuaNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoiNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel105)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuonngHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDauTienNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnTruocNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnSauNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnCuoiCungNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel105, jLabel90, jLabel94, jLabel95, jLabel98});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel98)
                            .addComponent(txtMaNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel90))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel95))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94)
                            .addComponent(txtDonViHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel105)
                            .addComponent(txtSoLuonngHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNhapHang)
                    .addComponent(btnXoaNhapHang)
                    .addComponent(btnMoiNhapHang)
                    .addComponent(btnSuaNhapHang)
                    .addComponent(btnCuoiCungNhapHang)
                    .addComponent(btnDauTienNhapHang)
                    .addComponent(btnTruocNhapHang)
                    .addComponent(btnSauNhapHang))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout tabNhapHangLayout = new javax.swing.GroupLayout(tabNhapHang);
        tabNhapHang.setLayout(tabNhapHangLayout);
        tabNhapHangLayout.setHorizontalGroup(
            tabNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabNhapHangLayout.setVerticalGroup(
            tabNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel29.add(tabNhapHang, "card2");

        jLabel106.setText("Mã Hàng");

        jLabel107.setText("Đơn Vị ");

        jLabel108.setText("Tên Hàng");

        txtTenHangDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenHangDonHangActionPerformed(evt);
            }
        });

        txtDonViDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonViDonHangActionPerformed(evt);
            }
        });

        btnThemDonHang.setBackground(new java.awt.Color(0, 51, 51));
        btnThemDonHang.setForeground(new java.awt.Color(255, 255, 255));
        btnThemDonHang.setText("Thêm");
        btnThemDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDonHangActionPerformed(evt);
            }
        });

        btnSuaDonHang.setBackground(new java.awt.Color(0, 51, 51));
        btnSuaDonHang.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaDonHang.setText("Sửa");
        btnSuaDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDonHangActionPerformed(evt);
            }
        });

        btnXoaDonHang.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaDonHang.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaDonHang.setText("Xóa");
        btnXoaDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDonHangActionPerformed(evt);
            }
        });

        btnLamMoiDonHang.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiDonHang.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiDonHang.setText("Làm Mới");
        btnLamMoiDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiDonHangActionPerformed(evt);
            }
        });

        tblDanhSachDonHang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(tblDanhSachDonHang);

        btnDauTienDonHang.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienDonHang.setForeground(new java.awt.Color(255, 255, 255));

        btnTruocDonHang.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocDonHang.setForeground(new java.awt.Color(255, 255, 255));

        btnSauDonHang.setBackground(new java.awt.Color(0, 51, 51));
        btnSauDonHang.setForeground(new java.awt.Color(255, 255, 255));

        btnCuoiCungDonHang.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungDonHang.setForeground(new java.awt.Color(255, 255, 255));

        txtSoLuongHangDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongHangDonHangActionPerformed(evt);
            }
        });

        jLabel109.setText("Số Lượng");

        jLabel110.setText("Mã Đơn Hàng");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addComponent(jLabel107)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDonViDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                            .addComponent(jLabel106)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMaHangDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addComponent(jLabel108)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTenHangDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                            .addComponent(btnThemDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnXoaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(btnSuaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnLamMoiDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addComponent(jLabel109)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSoLuongHangDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel110)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaHangDonHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(btnDauTienDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnTruocDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnSauDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnCuoiCungDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel106, jLabel107, jLabel108, jLabel109, jLabel110});

        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel110)
                            .addComponent(txtMaHangDonHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel106)
                            .addComponent(txtMaHangDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenHangDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel108))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel107)
                            .addComponent(txtDonViDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel109)
                            .addComponent(txtSoLuongHangDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDonHang)
                    .addComponent(btnXoaDonHang)
                    .addComponent(btnLamMoiDonHang)
                    .addComponent(btnSuaDonHang)
                    .addComponent(btnCuoiCungDonHang)
                    .addComponent(btnDauTienDonHang)
                    .addComponent(btnTruocDonHang)
                    .addComponent(btnSauDonHang))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout tabDonHangLayout = new javax.swing.GroupLayout(tabDonHang);
        tabDonHang.setLayout(tabDonHangLayout);
        tabDonHangLayout.setHorizontalGroup(
            tabDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabDonHangLayout.setVerticalGroup(
            tabDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel29.add(tabDonHang, "card3");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTongSoTienHang.setFont(new java.awt.Font("Source Sans Pro Light", 1, 18)); // NOI18N
        lblTongSoTienHang.setText("0");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongSoTienHang, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTongSoTienHang)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99))
                .addGap(100, 100, 100)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel102)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel92)
                .addGap(14, 14, 14)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel99)
                                    .addComponent(lbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel97)
                                .addGap(4, 4, 4)))
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabKhoLayout = new javax.swing.GroupLayout(tabKho);
        tabKho.setLayout(tabKhoLayout);
        tabKhoLayout.setHorizontalGroup(
            tabKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabKhoLayout.setVerticalGroup(
            tabKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlCard.add(tabKho, "card7");

        tabHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabHoaDonMouseClicked(evt);
            }
        });

        tabbedHoaDon.setBackground(new java.awt.Color(0, 51, 51));

        tabbedSanPham_DichVu.setBackground(new java.awt.Color(0, 51, 51));
        tabbedSanPham_DichVu.setLayout(new java.awt.GridLayout(1, 0));

        lblHoaDonSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lblHoaDonSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDonSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDonSanPham.setText("Thêm Sản Phẩm");
        lblHoaDonSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonSanPhamMouseClicked(evt);
            }
        });
        tabbedSanPham_DichVu.add(lblHoaDonSanPham);

        lblHoaDonDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lblHoaDonDichVu.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDonDichVu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDonDichVu.setText("Thêm Dịch Vụ");
        lblHoaDonDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonDichVuMouseClicked(evt);
            }
        });
        tabbedSanPham_DichVu.add(lblHoaDonDichVu);

        lblHoaDonLichSu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lblHoaDonLichSu.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDonLichSu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDonLichSu.setText("Lịch Sử");
        lblHoaDonLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoaDonLichSuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tabbedHoaDonLayout = new javax.swing.GroupLayout(tabbedHoaDon);
        tabbedHoaDon.setLayout(tabbedHoaDonLayout);
        tabbedHoaDonLayout.setHorizontalGroup(
            tabbedHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedHoaDonLayout.createSequentialGroup()
                .addComponent(tabbedSanPham_DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHoaDonLichSu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabbedHoaDonLayout.setVerticalGroup(
            tabbedHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabbedHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedSanPham_DichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(lblHoaDonLichSu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlNenHoaDon.setLayout(new java.awt.CardLayout());

        pnlNenSanPham_DichVu.setLayout(new java.awt.CardLayout());

        tabHoaDonSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabHoaDonSanPhamMouseClicked(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel70.setText("Sản Phẩm:");

        tablDanhSachSanPhamHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(tablDanhSachSanPhamHoaDon);

        jLabel72.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel72.setText("Tìm kiếm");

        btnTimKiemSanPhamHoaDon.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemSanPhamHoaDon.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemSanPhamHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemSanPhamHoaDon.setText("Tìm");

        javax.swing.GroupLayout tabHoaDonSanPhamLayout = new javax.swing.GroupLayout(tabHoaDonSanPham);
        tabHoaDonSanPham.setLayout(tabHoaDonSanPhamLayout);
        tabHoaDonSanPhamLayout.setHorizontalGroup(
            tabHoaDonSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabHoaDonSanPhamLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiemSanPhamHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnTimKiemSanPhamHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(tabHoaDonSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9)
                .addContainerGap())
        );
        tabHoaDonSanPhamLayout.setVerticalGroup(
            tabHoaDonSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonSanPhamLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(tabHoaDonSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabHoaDonSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel72)
                        .addComponent(txtTimKiemSanPhamHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiemSanPhamHoaDon))
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlNenSanPham_DichVu.add(tabHoaDonSanPham, "card2");

        tabHoaDonDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabHoaDonDichVuMouseClicked(evt);
            }
        });

        jLabel73.setText("Mã Đặt Lịch");

        jLabel75.setText("Tên Dịch Vụ");

        jLabel82.setText("Ghi Chú");

        jLabel83.setText("Ngày Đặt");

        jLabel84.setText("Số Lượng");

        jLabel85.setText("Số Điện Thoại");

        jLabel86.setText("Ngày Nhận ");

        cboTenDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtGhiChuDichVu.setColumns(20);
        txtGhiChuDichVu.setRows(5);
        jScrollPane12.setViewportView(txtGhiChuDichVu);

        btnLamMoiDatLich.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiDatLich.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnLamMoiDatLich.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiDatLich.setText("Làm mới");

        btnThemDatLich.setBackground(new java.awt.Color(0, 51, 51));
        btnThemDatLich.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnThemDatLich.setForeground(new java.awt.Color(255, 255, 255));
        btnThemDatLich.setText("Đặt lịch");

        btnSuaDatLich.setBackground(new java.awt.Color(0, 51, 51));
        btnSuaDatLich.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnSuaDatLich.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaDatLich.setText("Sửa");

        javax.swing.GroupLayout tabHoaDonDichVuLayout = new javax.swing.GroupLayout(tabHoaDonDichVu);
        tabHoaDonDichVu.setLayout(tabHoaDonDichVuLayout);
        tabHoaDonDichVuLayout.setHorizontalGroup(
            tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                        .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                                .addComponent(jLabel84)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuongDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel85))
                            .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                                        .addComponent(jLabel75)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboTenDichVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabHoaDonDichVuLayout.createSequentialGroup()
                                        .addComponent(jLabel73)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel83, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(43, 43, 43)
                        .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayDatDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                            .addComponent(txtNgayNhanThuCung)
                            .addComponent(txtSoDienThoaiDatLich)))
                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(btnThemDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnSuaDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoiDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

        tabHoaDonDichVuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel73, jLabel75, jLabel82, jLabel83, jLabel84, jLabel85, jLabel86});

        tabHoaDonDichVuLayout.setVerticalGroup(
            tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jLabel83)
                    .addComponent(txtMaDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel86)
                        .addComponent(txtNgayNhanThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85)
                    .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel84)
                        .addComponent(txtSoLuongDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSoDienThoaiDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabHoaDonDichVuLayout.createSequentialGroup()
                        .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemDatLich)
                            .addComponent(btnSuaDatLich)
                            .addComponent(btnLamMoiDatLich))
                        .addGap(35, 35, 35)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pnlNenSanPham_DichVu.add(tabHoaDonDichVu, "card3");

        pnlHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHoaDonMouseClicked(evt);
            }
        });

        jLabel69.setText("Mã Hóa Đơn");

        jLabel13.setText("Mã Nhân Viên");

        jLabel76.setText("Khách Hàng");

        jLabel77.setText("Ghi Chú");

        jLabel78.setText("Tổng");

        jLabel80.setText("Tiền Nhận ");

        jLabel81.setText("Tiền Thừa");

        cboLoaiKhachHangHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtGhiChuHoaDon.setColumns(20);
        txtGhiChuHoaDon.setRows(5);
        jScrollPane11.setViewportView(txtGhiChuHoaDon);

        btnTaoHoaDon.setText("Tạo Hóa Đơn");

        btnHuyHoaDon.setText("Hủy");

        btnThemHoaDon.setText("Thanh Toán");

        btnXuatHoaDon.setText("Xuất Hóa Đơn");

        cboDanhSachKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHoaDonLayout.createSequentialGroup()
                        .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHoaDonLayout.createSequentialGroup()
                                        .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel81)
                                            .addComponent(jLabel77))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                            .addComponent(txtTienThuaHoaDon)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHoaDonLayout.createSequentialGroup()
                                            .addComponent(jLabel80)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTienNhanHoaDon))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHoaDonLayout.createSequentialGroup()
                                            .addComponent(jLabel78)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTongTienHoaDon))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHoaDonLayout.createSequentialGroup()
                                            .addComponent(jLabel76)
                                            .addGap(18, 18, 18)
                                            .addComponent(cboLoaiKhachHangHoaDon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHoaDonLayout.createSequentialGroup()
                                            .addComponent(jLabel69)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHoaDonLayout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtMaNhanVienHoaDon)))))
                            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlHoaDonLayout.createSequentialGroup()
                                        .addComponent(btnThemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlHoaDonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cboDanhSachKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlHoaDonLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, jLabel69, jLabel76, jLabel77, jLabel78, jLabel80, jLabel81});

        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMaNhanVienHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(cboLoaiKhachHangHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboDanhSachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(txtTongTienHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(txtTienNhanHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(txtTienThuaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTaoHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuyHoaDon)
                    .addComponent(btnThemHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXuatHoaDon)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pnlHoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHoaDonChiTietMouseClicked(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel74.setText("Khuyến mãi:");

        cboKhuyenMaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblDanhSahChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(tblDanhSahChiTietHoaDon);

        btnLamMoiChiTietHoaDon.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiChiTietHoaDon.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnLamMoiChiTietHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiChiTietHoaDon.setText("Làm mới");

        btnXoaChiTietHoaDon.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaChiTietHoaDon.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnXoaChiTietHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaChiTietHoaDon.setText("Xóa chi tiết");

        javax.swing.GroupLayout pnlHoaDonChiTietLayout = new javax.swing.GroupLayout(pnlHoaDonChiTiet);
        pnlHoaDonChiTiet.setLayout(pnlHoaDonChiTietLayout);
        pnlHoaDonChiTietLayout.setHorizontalGroup(
            pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                        .addComponent(jScrollPane10)
                        .addContainerGap())
                    .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboKhuyenMaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoiChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
            .addComponent(jSeparator3)
        );
        pnlHoaDonChiTietLayout.setVerticalGroup(
            pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonChiTietLayout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHoaDonChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(cboKhuyenMaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaChiTietHoaDon)
                    .addComponent(btnLamMoiChiTietHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlNenThemHoaDonLayout = new javax.swing.GroupLayout(pnlNenThemHoaDon);
        pnlNenThemHoaDon.setLayout(pnlNenThemHoaDonLayout);
        pnlNenThemHoaDonLayout.setHorizontalGroup(
            pnlNenThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNenThemHoaDonLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlNenThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlNenSanPham_DichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHoaDonChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );
        pnlNenThemHoaDonLayout.setVerticalGroup(
            pnlNenThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNenThemHoaDonLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlNenThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNenThemHoaDonLayout.createSequentialGroup()
                        .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlNenThemHoaDonLayout.createSequentialGroup()
                        .addComponent(pnlNenSanPham_DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlHoaDonChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout tabThemHoaDonLayout = new javax.swing.GroupLayout(tabThemHoaDon);
        tabThemHoaDon.setLayout(tabThemHoaDonLayout);
        tabThemHoaDonLayout.setHorizontalGroup(
            tabThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1292, Short.MAX_VALUE)
            .addGroup(tabThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlNenThemHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabThemHoaDonLayout.setVerticalGroup(
            tabThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
            .addGroup(tabThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlNenThemHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlNenHoaDon.add(tabThemHoaDon, "card2");

        tabXemLichSuHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabXemLichSuHoaDonMouseClicked(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        jLabel71.setText("Lịch Sử Thanh Toán");

        tblDanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(tblDanhSachHoaDon);

        javax.swing.GroupLayout tabXemLichSuHoaDonLayout = new javax.swing.GroupLayout(tabXemLichSuHoaDon);
        tabXemLichSuHoaDon.setLayout(tabXemLichSuHoaDonLayout);
        tabXemLichSuHoaDonLayout.setHorizontalGroup(
            tabXemLichSuHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabXemLichSuHoaDonLayout.createSequentialGroup()
                .addGroup(tabXemLichSuHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabXemLichSuHoaDonLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 1233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabXemLichSuHoaDonLayout.createSequentialGroup()
                        .addGap(510, 510, 510)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabXemLichSuHoaDonLayout.setVerticalGroup(
            tabXemLichSuHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabXemLichSuHoaDonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel71)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pnlNenHoaDon.add(tabXemLichSuHoaDon, "card3");

        javax.swing.GroupLayout tabHoaDonLayout = new javax.swing.GroupLayout(tabHoaDon);
        tabHoaDon.setLayout(tabHoaDonLayout);
        tabHoaDonLayout.setHorizontalGroup(
            tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlNenHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabHoaDonLayout.setVerticalGroup(
            tabHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonLayout.createSequentialGroup()
                .addComponent(tabbedHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNenHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCard.add(tabHoaDon, "card9");

        tabThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabThongKeMouseClicked(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        jLabel87.setText("Thống Kê");

        lblDanhThuThongKe.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 36)); // NOI18N
        lblDanhThuThongKe.setText("10000000");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("VND");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(40, 40, 40))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lblDanhThuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblDanhThuThongKe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(0, 51, 51));
        jPanel22.setLayout(new java.awt.GridLayout(1, 0));

        lblDoanhThu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lblDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lblDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThu.setText("Doanh Thu");
        lblDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoanhThuMouseClicked(evt);
            }
        });
        jPanel22.add(lblDoanhThu);

        lblLuotBan.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lblLuotBan.setForeground(new java.awt.Color(255, 255, 255));
        lblLuotBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLuotBan.setText("Lượt Bán");
        lblLuotBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLuotBanMouseClicked(evt);
            }
        });
        jPanel22.add(lblLuotBan);

        jPanel23.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout tabDoanhThuLayout = new javax.swing.GroupLayout(tabDoanhThu);
        tabDoanhThu.setLayout(tabDoanhThuLayout);
        tabDoanhThuLayout.setHorizontalGroup(
            tabDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1249, Short.MAX_VALUE)
        );
        tabDoanhThuLayout.setVerticalGroup(
            tabDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jPanel23.add(tabDoanhThu, "card2");

        javax.swing.GroupLayout tabLuotBanLayout = new javax.swing.GroupLayout(tabLuotBan);
        tabLuotBan.setLayout(tabLuotBanLayout);
        tabLuotBanLayout.setHorizontalGroup(
            tabLuotBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1249, Short.MAX_VALUE)
        );
        tabLuotBanLayout.setVerticalGroup(
            tabLuotBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jPanel23.add(tabLuotBan, "card3");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblLuotBanThongKe.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 36)); // NOI18N
        lblLuotBanThongKe.setText("100000");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Lượt");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(36, 36, 36))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lblLuotBanThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblLuotBanThongKe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel31.setLayout(new java.awt.GridLayout(1, 0));

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Doanh Thu");
        jPanel31.add(jLabel88);

        jLabel91.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("Lượt Bán");
        jPanel31.add(jLabel91);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel87)
                .addGap(9, 9, 9)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabThongKeLayout = new javax.swing.GroupLayout(tabThongKe);
        tabThongKe.setLayout(tabThongKeLayout);
        tabThongKeLayout.setHorizontalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabThongKeLayout.setVerticalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlCard.add(tabThongKe, "card5");

        tabTrangChu.setPreferredSize(new java.awt.Dimension(1250, 563));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTrangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(lblTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tabTrangChuLayout = new javax.swing.GroupLayout(tabTrangChu);
        tabTrangChu.setLayout(tabTrangChuLayout);
        tabTrangChuLayout.setHorizontalGroup(
            tabTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabTrangChuLayout.setVerticalGroup(
            tabTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlCard.add(tabTrangChu, "card2");

        pnlThongTinNguoiDung.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongTinNguoiDung.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlThongTinNguoiDung.setForeground(new java.awt.Color(255, 255, 255));
        pnlThongTinNguoiDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlThongTinNguoiDungMouseClicked(evt);
            }
        });
        pnlThongTinNguoiDung.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlThongTinNguoiDung.add(lblUserIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 28, 66, 64));

        lblDangXuat.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(0, 51, 51));
        lblDangXuat.setText("Đăng xuất");
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });
        pnlThongTinNguoiDung.add(lblDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 110, 79, -1));

        lblDoiMatKhau.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lblDoiMatKhau.setForeground(new java.awt.Color(0, 51, 51));
        lblDoiMatKhau.setText("Đổi mật khẩu");
        lblDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoiMatKhauMouseClicked(evt);
            }
        });
        pnlThongTinNguoiDung.add(lblDoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 138, 79, -1));

        lblTroGiup.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lblTroGiup.setForeground(new java.awt.Color(0, 51, 51));
        lblTroGiup.setText("Trợ giúp");
        pnlThongTinNguoiDung.add(lblTroGiup, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 166, 79, -1));

        lblExitMenuNguoiDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMenuNguoiDungMouseClicked(evt);
            }
        });
        pnlThongTinNguoiDung.add(lblExitMenuNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 31, 25));

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlThongTinNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlThongTinNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblOpenMenuIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOpenMenuIconMouseClicked
        // TODO add your handling code here:
        openMenuBar();
    }//GEN-LAST:event_lblOpenMenuIconMouseClicked

    private void lblExitMenuIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMenuIconMouseClicked
        // TODO add your handling code here:
        closeMenuBar();
    }//GEN-LAST:event_lblExitMenuIconMouseClicked

    private void lblMenuHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuHoaDonMouseClicked
        // TODO add your handling code here:
        tabHoaDon.setVisible(true);
        tabDichVu.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKho.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSanPham.setVisible(false);
        tabSuKien.setVisible(false);
        tabThongKe.setVisible(false);
        tabThuCung.setVisible(false);
        tabTrangChu.setVisible(false);
    }//GEN-LAST:event_lblMenuHoaDonMouseClicked

    private void tabThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabThongKeMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabThongKeMouseClicked

    private void tabKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabKhuyenMaiMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabKhuyenMaiMouseClicked

    private void lblMenuKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuKhuyenMaiMouseClicked
        // TODO add your handling code here:
        tabKhuyenMai.setVisible(true);
        tabThongKe.setVisible(false);
        tabHoaDon.setVisible(false);
        tabDichVu.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKho.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSanPham.setVisible(false);
        tabSuKien.setVisible(false);
        tabThuCung.setVisible(false);
        tabTrangChu.setVisible(false);
    }//GEN-LAST:event_lblMenuKhuyenMaiMouseClicked

    private void lblMenuThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuThongKeMouseClicked
        // TODO add your handling code here:
        tabThongKe.setVisible(true);
        tabHoaDon.setVisible(false);
        tabDichVu.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKho.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSanPham.setVisible(false);
        tabSuKien.setVisible(false);
        tabThuCung.setVisible(false);
        tabTrangChu.setVisible(false);
    }//GEN-LAST:event_lblMenuThongKeMouseClicked

    private void lblMenuNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuNhanVienMouseClicked
        // TODO add your handling code here:
        tabNhanVien.setVisible(true);
        tabHoaDon.setVisible(false);
        tabDichVu.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKho.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabSanPham.setVisible(false);
        tabSuKien.setVisible(false);
        tabThongKe.setVisible(false);
        tabThuCung.setVisible(false);
        tabTrangChu.setVisible(false);
    }//GEN-LAST:event_lblMenuNhanVienMouseClicked

    private void lblMenuSuKienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuSuKienMouseClicked
        // TODO add your handling code here:
        tabSuKien.setVisible(true);
        tabHoaDon.setVisible(false);
        tabDichVu.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKho.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSanPham.setVisible(false);
        tabThongKe.setVisible(false);
        tabThuCung.setVisible(false);
        tabTrangChu.setVisible(false);
    }//GEN-LAST:event_lblMenuSuKienMouseClicked

    private void lblMenuKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuKhoMouseClicked
        // TODO add your handling code here:
        tabKho.setVisible(true);
        tabSuKien.setVisible(false);
        tabHoaDon.setVisible(false);
        tabDichVu.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSanPham.setVisible(false);
        tabThongKe.setVisible(false);
        tabThuCung.setVisible(false);
        tabTrangChu.setVisible(false);
    }//GEN-LAST:event_lblMenuKhoMouseClicked

    private void lblMenuTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuTrangChuMouseClicked
        // TODO add your handling code here:
        tabTrangChu.setVisible(true);
        tabSuKien.setVisible(false);
        tabHoaDon.setVisible(false);
        tabDichVu.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKho.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSanPham.setVisible(false);
        tabThongKe.setVisible(false);
        tabThuCung.setVisible(false);
    }//GEN-LAST:event_lblMenuTrangChuMouseClicked

    private void lblMenuKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuKhachHangMouseClicked
        // TODO add your handling code here:
        tabKhachHang.setVisible(true);
        tabSuKien.setVisible(false);
        tabHoaDon.setVisible(false);
        tabDichVu.setVisible(false);
        tabKho.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSanPham.setVisible(false);
        tabThongKe.setVisible(false);
        tabThuCung.setVisible(false);
        tabTrangChu.setVisible(false);
    }//GEN-LAST:event_lblMenuKhachHangMouseClicked

    private void lblMenuDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuDichVuMouseClicked
        // TODO add your handling code here:
        tabDichVu.setVisible(true);
        tabSuKien.setVisible(false);
        tabHoaDon.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKho.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSanPham.setVisible(false);
        tabThongKe.setVisible(false);
        tabThuCung.setVisible(false);
        tabTrangChu.setVisible(false);
    }//GEN-LAST:event_lblMenuDichVuMouseClicked

    private void lblMenuThuCungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuThuCungMouseClicked
        // TODO add your handling code here:
        tabThuCung.setVisible(true);
        tabSuKien.setVisible(false);
        tabHoaDon.setVisible(false);
        tabDichVu.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKho.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSanPham.setVisible(false);
        tabThongKe.setVisible(false);
        tabTrangChu.setVisible(false);
    }//GEN-LAST:event_lblMenuThuCungMouseClicked

    private void lblMenuSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuSanPhamMouseClicked
        // TODO add your handling code here:
        tabSanPham.setVisible(true);
        tabHoaDon.setVisible(false);
        tabDichVu.setVisible(false);
        tabKhachHang.setVisible(false);
        tabKho.setVisible(false);
        tabKhuyenMai.setVisible(false);
        tabNhanVien.setVisible(false);
        tabSuKien.setVisible(false);
        tabThongKe.setVisible(false);
        tabThuCung.setVisible(false);
        tabTrangChu.setVisible(false);
    }//GEN-LAST:event_lblMenuSanPhamMouseClicked

    private void lblUserIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserIconMouseClicked
        // TODO add your handling code here:
        evt.consume();
        openMenuThongTinNguoiDung();
        setComponentZOrder(pnlThongTinNguoiDung, 0);

    }//GEN-LAST:event_lblUserIconMouseClicked

    private void rdoGioiTinhDucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoGioiTinhDucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoGioiTinhDucActionPerformed

    private void txtSoChuongThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoChuongThuCungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoChuongThuCungActionPerformed

    private void lblThongTinThuCungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinThuCungMouseClicked
        // TODO add your handling code here:
        tabThongTinThuCung.setVisible(true);
        tabDanhSachThuCung.setVisible(false);
    }//GEN-LAST:event_lblThongTinThuCungMouseClicked

    private void lblDanhSachThuCungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDanhSachThuCungMouseClicked
        // TODO add your handling code here:
        tabThongTinThuCung.setVisible(false);
        tabDanhSachThuCung.setVisible(true);
    }//GEN-LAST:event_lblDanhSachThuCungMouseClicked

    private void lblExitMenuNguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMenuNguoiDungMouseClicked
        // TODO add your handling code here:
        closeMenuThongTinNguoiDung();
    }//GEN-LAST:event_lblExitMenuNguoiDungMouseClicked

    private void pnlThongTinNguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongTinNguoiDungMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_pnlThongTinNguoiDungMouseClicked

    private void pnlDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDanhSachMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_pnlDanhSachMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_formMouseClicked

    private void txtGiaNhapSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNhapSanPhamActionPerformed

    private void cboTrangThaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTrangThaiSanPhamActionPerformed

    private void txtDonViSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonViSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonViSanPhamActionPerformed

    private void txtTimKiemTenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemTenSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemTenSanPhamActionPerformed

    private void btnSuaThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThuCungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaThuCungActionPerformed

    private void btnThemMoiLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiLoaiSanPhamActionPerformed
        // TODO add your handling code here:
        new ThemMoiLoaiJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnThemMoiLoaiSanPhamActionPerformed

    private void btnSuaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaDichVuActionPerformed

    private void txtGiaTienDichhVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaTienDichhVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaTienDichhVuActionPerformed

    private void lblHoaDonSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonSanPhamMouseClicked
        // TODO add your handling code here:
        tabHoaDonSanPham.setVisible(true);
        tabHoaDonDichVu.setVisible(false);
    }//GEN-LAST:event_lblHoaDonSanPhamMouseClicked

    private void lblHoaDonDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonDichVuMouseClicked
        // TODO add your handling code here:
        tabThemHoaDon.setVisible(true);
        tabHoaDonSanPham.setVisible(false);
        tabHoaDonDichVu.setVisible(true);
    }//GEN-LAST:event_lblHoaDonDichVuMouseClicked

    private void lblHoaDonLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonLichSuMouseClicked
        // TODO add your handling code here:
        tabThemHoaDon.setVisible(false);
        tabXemLichSuHoaDon.setVisible(true);
    }//GEN-LAST:event_lblHoaDonLichSuMouseClicked

    private void tabHoaDonSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabHoaDonSanPhamMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_tabHoaDonSanPhamMouseClicked

    private void tabHoaDonDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabHoaDonDichVuMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_tabHoaDonDichVuMouseClicked

    private void pnlHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_pnlHoaDonMouseClicked

    private void pnlHoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonChiTietMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_pnlHoaDonChiTietMouseClicked

    private void lblDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoanhThuMouseClicked
        // TODO add your handling code here:
        tabDoanhThu.setVisible(true);
        tabLuotBan.setVisible(false);
    }//GEN-LAST:event_lblDoanhThuMouseClicked

    private void lblNhapHang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhapHang1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNhapHang1MouseClicked

    private void lblLuotBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLuotBanMouseClicked
        // TODO add your handling code here:
        tabLuotBan.setVisible(true);
        tabDoanhThu.setVisible(false);
    }//GEN-LAST:event_lblLuotBanMouseClicked

    private void txtTenHangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenHangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHangNhapActionPerformed

    private void txtDonViHangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonViHangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonViHangNhapActionPerformed

    private void btnThemNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhapHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemNhapHangActionPerformed

    private void btnSuaNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNhapHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaNhapHangActionPerformed

    private void btnXoaNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhapHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaNhapHangActionPerformed

    private void btnMoiNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiNhapHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoiNhapHangActionPerformed

    private void txtSoLuonngHangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuonngHangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuonngHangNhapActionPerformed

    private void txtTenHangDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenHangDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHangDonHangActionPerformed

    private void txtDonViDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonViDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonViDonHangActionPerformed

    private void btnThemDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemDonHangActionPerformed

    private void btnSuaDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaDonHangActionPerformed

    private void btnXoaDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaDonHangActionPerformed

    private void btnLamMoiDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiDonHangActionPerformed

    private void txtSoLuongHangDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongHangDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongHangDonHangActionPerformed

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        // TODO add your handling code here:
        new HoiVienJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void btnThemLoaiThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiThuCungActionPerformed
        // TODO add your handling code here:
        new ThemMoiLoaiJVatDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnThemLoaiThuCungActionPerformed

    private void btnThemChuongThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChuongThuCungActionPerformed
        // TODO add your handling code here:
        new ThemMoiChuongJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnThemChuongThuCungActionPerformed

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void lblDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMatKhauMouseClicked
        // TODO add your handling code here:
        new DoiMatKhauJDialog(this, true).setVisible(true);

    }//GEN-LAST:event_lblDoiMatKhauMouseClicked

    private void btnCuoiCungDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiCungDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCuoiCungDichVuActionPerformed

    private void btnDauTienDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauTienDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDauTienDichVuActionPerformed

    private void cboLocVaiTroNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocVaiTroNhanVienActionPerformed
        // TODO add your handling code here:
        locDuLieuNhanVien();
    }//GEN-LAST:event_cboLocVaiTroNhanVienActionPerformed

    private void btnTimTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimTenNhanVienActionPerformed
        // TODO add your handling code here:

        taiDuLieuNhanVien();
    }//GEN-LAST:event_btnTimTenNhanVienActionPerformed

    private void btnXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhanVienActionPerformed
        // TODO add your handling code here:
        xoaNhanVien();
    }//GEN-LAST:event_btnXoaNhanVienActionPerformed

    private void btnSuaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNhanVienActionPerformed
        // TODO add your handling code here:
        capNhatNhanVien();
    }//GEN-LAST:event_btnSuaNhanVienActionPerformed

    private void btnSauDanhSachNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauDanhSachNhanVienActionPerformed
        // TODO add your handling code here:
        SauNhanVien();
    }//GEN-LAST:event_btnSauDanhSachNhanVienActionPerformed

    private void btnLamMoiNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiNhanVienActionPerformed
        // TODO add your handling code here:
        lamMoiNhanVien();
    }//GEN-LAST:event_btnLamMoiNhanVienActionPerformed

    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed
        // TODO add your handling code here:
        ThemNhanVien();
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void txtNgaySinhNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinhNhanVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhNhanVienMouseClicked

    private void txtEmailNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailNhanVienActionPerformed

    private void tblDanhSachNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachNhanVienMouseClicked
        // TODO add your handling code here:
        this.row = tblDanhSachNhanVien.getSelectedRow();
        edit();
    }//GEN-LAST:event_tblDanhSachNhanVienMouseClicked

    private void btnTaiKhoanNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanNhanVienActionPerformed
        // TODO add your handling code here:
        row = 0;
        String maNhanVien = (String) tblDanhSachNhanVien.getValueAt(this.row, 1);
        new ThongTinTaiKhoanJDialog(this, true, maNhanVien).setVisible(true);
    }//GEN-LAST:event_btnTaiKhoanNhanVienActionPerformed

    private void lblHinhNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhNhanVienMouseClicked
        // TODO add your handling code here:
        chonHinhNhanVien();
    }//GEN-LAST:event_lblHinhNhanVienMouseClicked

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        txtTimTenNhanVien.setText("");
        taiDuLieuNhanVien();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void cboLocTrangThaiNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocTrangThaiNhanVienActionPerformed
        // TODO add your handling code here:
        locDuLieuNhanVien();
    }//GEN-LAST:event_cboLocTrangThaiNhanVienActionPerformed

    private void btnDauTienDanhSachNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauTienDanhSachNhanVienActionPerformed
        // TODO add your handling code here:
        dauTienNhanVien();
    }//GEN-LAST:event_btnDauTienDanhSachNhanVienActionPerformed

    private void btnTruocDanhSachNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruocDanhSachNhanVienActionPerformed
        // TODO add your handling code here:
        TruocNhanVien();
    }//GEN-LAST:event_btnTruocDanhSachNhanVienActionPerformed

    private void btnCuoiCungDanhSachNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiCungDanhSachNhanVienActionPerformed
        // TODO add your handling code here:
        cuoiCungNhanVien();
    }//GEN-LAST:event_btnCuoiCungDanhSachNhanVienActionPerformed

    private void tabHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabHoaDonMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_tabHoaDonMouseClicked

    private void tabXemLichSuHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabXemLichSuHoaDonMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_tabXemLichSuHoaDonMouseClicked

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
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton banLamMoiSanPham;
    private javax.swing.JButton btnCuoiCungDanhSachKhachHang;
    private javax.swing.JButton btnCuoiCungDanhSachKhuyenMai;
    private javax.swing.JButton btnCuoiCungDanhSachNhanVien;
    private javax.swing.JButton btnCuoiCungDanhSachSanPham;
    private javax.swing.JButton btnCuoiCungDichVu;
    private javax.swing.JButton btnCuoiCungDonHang;
    private javax.swing.JButton btnCuoiCungNhapHang;
    private javax.swing.JButton btnCuoiCungThuCung;
    private javax.swing.JButton btnDauTienDanhSachKhachHang;
    private javax.swing.JButton btnDauTienDanhSachKhuyenMai;
    private javax.swing.JButton btnDauTienDanhSachNhanVien;
    private javax.swing.JButton btnDauTienDanhSachSanPham;
    private javax.swing.JButton btnDauTienDichVu;
    private javax.swing.JButton btnDauTienDonHang;
    private javax.swing.JButton btnDauTienNhapHang;
    private javax.swing.JButton btnDauTienThuCung;
    private javax.swing.ButtonGroup btnGVaiTro;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnLamMoiChiTietHoaDon;
    private javax.swing.JButton btnLamMoiDatLich;
    private javax.swing.JButton btnLamMoiDichVu;
    private javax.swing.JButton btnLamMoiDonHang;
    private javax.swing.JButton btnLamMoiKhuyenMai;
    private javax.swing.JButton btnLamMoiNhanVien;
    private javax.swing.JButton btnLamMoiThuCung;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnMoiNhapHang;
    private javax.swing.JButton btnSauDanhSachKhachHang;
    private javax.swing.JButton btnSauDanhSachKhuyenMai;
    private javax.swing.JButton btnSauDanhSachNhanVien;
    private javax.swing.JButton btnSauDanhSachSanPham;
    private javax.swing.JButton btnSauDichVu;
    private javax.swing.JButton btnSauDonHang;
    private javax.swing.JButton btnSauNhapHang;
    private javax.swing.JButton btnSauThuCung;
    private javax.swing.JButton btnSuaDatLich;
    private javax.swing.JButton btnSuaDichVu;
    private javax.swing.JButton btnSuaDonHang;
    private javax.swing.JButton btnSuaKhuyenMai;
    private javax.swing.JButton btnSuaNhanVien;
    private javax.swing.JButton btnSuaNhapHang;
    private javax.swing.JButton btnSuaSanPham;
    private javax.swing.JButton btnSuaThuCung;
    private javax.swing.JButton btnTaiKhoanNhanVien;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThemChuongThuCung;
    private javax.swing.JButton btnThemDatLich;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnThemDonHang;
    private javax.swing.JButton btnThemHoaDon;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnThemKhuyenMai;
    private javax.swing.JButton btnThemLoaiThuCung;
    private javax.swing.JButton btnThemMoiLoaiSanPham;
    private javax.swing.JButton btnThemNhanVien;
    private javax.swing.JButton btnThemNhapHang;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnThemThuCung;
    private javax.swing.JButton btnTimKiemDichVu;
    private javax.swing.JButton btnTimKiemKhachHang;
    private javax.swing.JButton btnTimKiemKhuyenMai;
    private javax.swing.JButton btnTimKiemSanPham;
    private javax.swing.JButton btnTimKiemSanPhamHoaDon;
    private javax.swing.JButton btnTimKiemThuCung;
    private javax.swing.JButton btnTimTenNhanVien;
    private javax.swing.JButton btnTruocDanhSachKhachHang;
    private javax.swing.JButton btnTruocDanhSachKhuyenMai;
    private javax.swing.JButton btnTruocDanhSachNhanVien;
    private javax.swing.JButton btnTruocDanhSachSanPham;
    private javax.swing.JButton btnTruocDichVu;
    private javax.swing.JButton btnTruocDonHang;
    private javax.swing.JButton btnTruocNhapHang;
    private javax.swing.JButton btnTruocThuCung;
    private javax.swing.JButton btnXoaChiTietHoaDon;
    private javax.swing.JButton btnXoaDichVu;
    private javax.swing.JButton btnXoaDonHang;
    private javax.swing.JButton btnXoaKhuyenMai;
    private javax.swing.JButton btnXoaNhanVien;
    private javax.swing.JButton btnXoaNhapHang;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JButton btnXoaThuCung;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboDanhSachKhachHang;
    private javax.swing.JComboBox<String> cboGiongThuCung;
    private javax.swing.JComboBox<String> cboKhuyenMaiHoaDon;
    private javax.swing.JComboBox<String> cboLoaiKhachHangHoaDon;
    private javax.swing.JComboBox<String> cboLoaiThuCung;
    private javax.swing.JComboBox<String> cboLocGIongThuCung;
    private javax.swing.JComboBox<String> cboLocLoaiThuCung;
    private javax.swing.JComboBox<String> cboLocSoHuuThuCung;
    private javax.swing.JComboBox<String> cboLocTrangThaiKhuyenMai;
    private javax.swing.JComboBox<String> cboLocTrangThaiNhanVien;
    private javax.swing.JComboBox<String> cboLocTrangThaiSanPham;
    private javax.swing.JComboBox<String> cboLocVaiTroNhanVien;
    private javax.swing.JComboBox<String> cboTenDichVu;
    private javax.swing.JComboBox<String> cboTrangThaiNhanVien;
    private javax.swing.JComboBox<String> cboTrangThaiSanPham;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblAnhThuCung;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDanhSachThuCung;
    private javax.swing.JLabel lblDanhThuThongKe;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblDoiMatKhau;
    private javax.swing.JLabel lblDonHang1;
    private javax.swing.JLabel lblExitMenuIcon;
    private javax.swing.JLabel lblExitMenuNguoiDung;
    private javax.swing.JLabel lblHinhLogo;
    private javax.swing.JLabel lblHinhLogo1;
    private javax.swing.JLabel lblHinhNhanVien;
    private javax.swing.JLabel lblHoaDonDichVu;
    private javax.swing.JLabel lblHoaDonLichSu;
    private javax.swing.JLabel lblHoaDonSanPham;
    private javax.swing.JLabel lblKhuyenMaiIcon;
    private javax.swing.JLabel lblLock;
    private javax.swing.JLabel lblLuotBan;
    private javax.swing.JLabel lblLuotBanThongKe;
    private javax.swing.JLabel lblMenuDichVu;
    private javax.swing.JLabel lblMenuHoaDon;
    private javax.swing.JLabel lblMenuKhachHang;
    private javax.swing.JLabel lblMenuKho;
    private javax.swing.JLabel lblMenuKhuyenMai;
    private javax.swing.JLabel lblMenuNhanVien;
    private javax.swing.JLabel lblMenuSanPham;
    private javax.swing.JLabel lblMenuSuKien;
    private javax.swing.JLabel lblMenuThongKe;
    private javax.swing.JLabel lblMenuThuCung;
    private javax.swing.JLabel lblMenuTrangChu;
    private javax.swing.JLabel lblNhapHang1;
    private javax.swing.JLabel lblOpenMenuIcon;
    private javax.swing.JLabel lblThongTinThuCung;
    private javax.swing.JLabel lblTongSoHangHoa;
    private javax.swing.JLabel lblTongSoTienHang;
    private javax.swing.JLabel lblTongTienNhap;
    private javax.swing.JLabel lblTongTienXuat;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JLabel lblTroGiup;
    private javax.swing.JLabel lblUserIcon;
    private javax.swing.JLabel lblUserIcon1;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JPanel pnlHeThong;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlHoaDonChiTiet;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNenHoaDon;
    private javax.swing.JPanel pnlNenSanPham_DichVu;
    private javax.swing.JPanel pnlNenThemHoaDon;
    private javax.swing.JPanel pnlNenThuCung;
    private javax.swing.JPanel pnlThongTinNguoiDung;
    private javax.swing.JPanel pnlTrangThai;
    private javax.swing.JRadioButton rdoGioiTinhCai;
    private javax.swing.JRadioButton rdoGioiTinhDuc;
    private javax.swing.JRadioButton rdoNamNhanVien;
    private javax.swing.JRadioButton rdoNuNhanVien;
    private javax.swing.JRadioButton rdoVaiTroNhanVien;
    private javax.swing.JRadioButton rdoVaiTroQuanLy;
    private javax.swing.JPanel tabDanhSachThuCung;
    private javax.swing.JPanel tabDichVu;
    private javax.swing.JPanel tabDoanhThu;
    private javax.swing.JPanel tabDonHang;
    private javax.swing.JPanel tabHoaDon;
    private javax.swing.JPanel tabHoaDonDichVu;
    private javax.swing.JPanel tabHoaDonSanPham;
    private javax.swing.JPanel tabKhachHang;
    private javax.swing.JPanel tabKho;
    private javax.swing.JPanel tabKhuyenMai;
    private javax.swing.JPanel tabLuotBan;
    private javax.swing.JPanel tabNhanVien;
    private javax.swing.JPanel tabNhapHang;
    private javax.swing.JPanel tabSanPham;
    private javax.swing.JPanel tabSuKien;
    private javax.swing.JPanel tabThemHoaDon;
    private javax.swing.JPanel tabThongKe;
    private javax.swing.JPanel tabThongTinThuCung;
    private javax.swing.JPanel tabThuCung;
    private javax.swing.JPanel tabTrangChu;
    private javax.swing.JPanel tabXemLichSuHoaDon;
    private javax.swing.JPanel tabbedHoaDon;
    private javax.swing.JPanel tabbedSanPham_DichVu;
    private javax.swing.JPanel tabbedThuCung;
    private javax.swing.JTable tablDanhSachSanPhamHoaDon;
    private javax.swing.JTable tblDanahSachThuCung;
    private javax.swing.JTable tblDanhSachDonHang;
    private javax.swing.JTable tblDanhSachHoaDon;
    private javax.swing.JTable tblDanhSachNhanVien;
    private javax.swing.JTable tblDanhSachSanPham;
    private javax.swing.JTable tblDanhSachSuKien;
    private javax.swing.JTable tblDanhSahChiTietHoaDon;
    private javax.swing.JTable tblSanhSachKhachHang;
    private javax.swing.JTable tbllDachSachNhapHang;
    private javax.swing.JTable tnlDanhSachDichVu;
    private javax.swing.JTextField txtCanNangThuCung;
    private javax.swing.JTextField txtDonViDichVu;
    private javax.swing.JTextField txtDonViDonHang;
    private javax.swing.JTextField txtDonViHangNhap;
    private javax.swing.JTextField txtDonViSanPham;
    private javax.swing.JTextField txtEmailNhanVien;
    private javax.swing.JTextArea txtGhiChuDichVu;
    private javax.swing.JTextArea txtGhiChuHoaDon;
    private javax.swing.JTextField txtGiaBanSanPham;
    private javax.swing.JTextField txtGiaNhapSanPham;
    private javax.swing.JTextField txtGiaTienDichhVu;
    private javax.swing.JTextField txtGiaTienThuCung;
    private javax.swing.JTextField txtHoTenNhanVien;
    private javax.swing.JTextField txtMaDatDichVu;
    private javax.swing.JTextField txtMaDichVu;
    private javax.swing.JTextField txtMaHangDonHang;
    private javax.swing.JTextField txtMaHangDonHang1;
    private javax.swing.JTextField txtMaHangNhap;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtMaLoaiSanPham;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMaNhanVienHoaDon;
    private javax.swing.JTextField txtMaNhapHang;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMaThuCung;
    private javax.swing.JTextArea txtMoTaThuCung;
    private javax.swing.JTextField txtNgayBatDauKhuyenMai;
    private javax.swing.JTextField txtNgayDatDichVu;
    private javax.swing.JTextField txtNgayNhanThuCung;
    private javax.swing.JTextField txtNgaySinhNhanVien;
    private javax.swing.JTextField txtPhanTramKhuyenMai;
    private javax.swing.JTextField txtSoChuongThuCung;
    private javax.swing.JTextField txtSoDienThoaiDatLich;
    private javax.swing.JTextField txtSoDienThoaiNhanVien;
    private javax.swing.JTextField txtSoLuongDichVu;
    private javax.swing.JTextField txtSoLuongHangDonHang;
    private javax.swing.JTextField txtSoLuongSanPham;
    private javax.swing.JTextField txtSoLuonngHangNhap;
    private javax.swing.JTextField txtTenDichVu;
    private javax.swing.JTextField txtTenHangDonHang;
    private javax.swing.JTextField txtTenHangNhap;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JLabel txtThuocSoHuuThuCung;
    private javax.swing.JTextField txtTienNhanHoaDon;
    private javax.swing.JTextField txtTienThuaHoaDon;
    private javax.swing.JTextField txtTimKiemDichVu;
    private javax.swing.JTextField txtTimKiemKhuyenMai;
    private javax.swing.JTextField txtTimKiemSanPhamHoaDon;
    private javax.swing.JTextField txtTimKiemTenKhachHang;
    private javax.swing.JTextField txtTimKiemTenSanPham;
    private javax.swing.JTextField txtTimKiemThuCung;
    private javax.swing.JTextField txtTimTenNhanVien;
    private javax.swing.JTextField txtTongTienHoaDon;
    private javax.swing.JTextField txtTuoiThuCung;
    // End of variables declaration//GEN-END:variables

}
