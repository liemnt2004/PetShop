package com.app.ui;

import com.app.utils.XImage;
import com.app.utils.Auth;
import com.app.utils.XDate;
import com.app.utils.Validate;
import com.app.utils.JdbcHelper;
import com.app.utils.MsgBox;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.app.Daos.*;
import com.app.Entitys.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import com.app.Other.*;
import java.awt.Image;
import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class mainJFrame extends javax.swing.JFrame {

    int rowSK = -1;
    int rowHV = -1;
    int width = 200;
    int height = 660 - 18;
    int heightND = 200;
    private int index = 0;
    private int viTriKhoHang = -1;
    private String soluong = "";
    private List<SanPham> listSanPham = new ArrayList<>();
    int row = -1;
    HoiVienDao hvdao = new HoiVienDao();
    private Timer time;
    private Timer menuTimer;
    DefaultTableModel modelTblNhanVien;
    DefaultTableModel modelTblSuKien;
    NhanVienDao daoNhanVien = new NhanVienDao();
    DatDVDAO daoSuKien = new DatDVDAO();

    ThuCungDao tcdao = new ThuCungDao();
    LoaiVatDao lvdao = new LoaiVatDao();
    GiongDao gdao = new GiongDao();
    ChuongDAO chuongdao = new ChuongDAO();
    List<ThuCung> datalist = tcdao.selectAll();

    SanPhamDAO spDao = new SanPhamDAO();
    TonKhoDao tkDao = new TonKhoDao();
    int ViTriSanPham = 0;

    PhieuGiamGiaDao daoPGG = new PhieuGiamGiaDao();
    DichVuDao daoDv = new DichVuDao();

    DefaultTableModel tblmodelTTHD = new DefaultTableModel();

    int DichVu = -1;
    int PhieuGiamGia = -1;
    int thucung = -1;
    int hoadonthucung = -1;
    int hoadonsanpham = -1;
    
    

    public mainJFrame() {

        initComponents();
        setIconImage(XImage.insertIcon(164, 164, "..\\PetShop\\src\\main\\java\\com\\app\\img\\logo_menu.png").getImage());
        setTitle("DOCA");
        tieuDeBangKho();
        taiDuLieuKho();
        sille();
        chart.setTitle("Thống Kê");
        chart.addLegend("Tổng Tiền Theo Tháng", Color.decode("#7b4397"), Color.decode("#dc2430"));
        ThongKeKho();
        thongSoKho();
        namThongKe();
        thongKeKinhDoanh((int) cbonam.getSelectedItem());
        duLieuNhacungcapKhoHang();
        lblHinhLogo.setIcon(XImage.insertIcon(70, 70, "..\\PetShop\\src\\main\\java\\com\\app\\img\\logo_menu.jpg"));
        lblHinhLogo1.setIcon(XImage.insertIcon(32, 32, "..\\PetShop\\src\\main\\java\\com\\app\\img\\logo_gd.png"));
        lblOpenMenuIcon.setIcon(XImage.insertIcon(32, 32, "..\\PetShop\\src\\main\\java\\com\\app\\img\\menu.png"));
        lblExitMenuIcon.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\dong_menu.png"));
        lblExitMenuNguoiDung.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\dong_menu.png"));
        lblUserIcon.setIcon(XImage.insertIcon(32, 32, "..\\PetShop\\src\\main\\java\\com\\app\\img\\nguoidung_meo.png"));
        lblUserIcon1.setIcon(XImage.insertIcon(64, 64, "..\\PetShop\\src\\main\\java\\com\\app\\img\\nguoidung_meo.png"));
        lblKhuyenMaiIcon.setIcon(XImage.insertIcon(64, 64, "..\\PetShop\\src\\main\\java\\com\\app\\img\\khuyenmai.png"));
        lblMenuHoaDon.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\hoadon.png"));
        btnDauTienDanhSachNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\truoc.png"));
        btnSauDanhSachNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\sau.png"));
        btnTruocDanhSachNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\truoc.png"));
        btnCuoiCungDanhSachNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\cuoicung.png"));
        btnDauTienDanhSachNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\dautien.png"));
        btnXoaNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\xoa.png"));
        btnThemNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\them.png"));
        btnSuaNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\capnhat.png"));
        btnLamMoiNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\lammoi.png"));
        btnTimTenNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\timkiem.png"));
        btnDauTienDanhSachNhanVien.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\khuyenmai.png"));
        btnSauDanhSachKhachHang.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\sau.png"));
        btnTruocDanhSachKhachHang.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\truoc.png"));
        btnCuoiCungDanhSachKhachHang.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\cuoicung.png"));
        btnDauTienDanhSachKhachHang.setIcon(XImage.insertIcon(24, 24, "..\\PetShop\\src\\main\\java\\com\\app\\img\\dautien.png"));
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
        maPhieuNhap();
        txtMaNhapHang.setEnabled(false);
        txtMaHangNhap.setEnabled(false);
        txtTenHangNhap.setEnabled(false);
        txtDonViHangNhap.setEnabled(false);
        cbbnhacc.setEditable(false);
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
        taiDuLieuSuKien();
        // Chỗ đặt hàm*********************************************************//
        //khach hang
        taidulieuDanhSachKhachHang();
        // san pham
        taiDuLieuSP();
        // hoa don
        TieuDeBangSanPhamHoaDon();
        KhuyenMaiHoaDon();
        SanPhamHoaDon();
        LoaiThanhVien();
        String LoaiHoiVien = (String) cboLoaiKhachHangHoaDon.getSelectedItem();
        boolean Loai = !LoaiHoiVien.equals("Khách Vãn Lai");
        HoiVienHoaDon(Loai);
        NhapMaHoaDon();
        DichVuHoaDon();
        nhapMaDatLich();
        TieuDeChiTietHoaDon();
        txtMaNhanVienHoaDon.setText(Auth.user.getMaNhanVien());
        // thu cung
        TaiDuLieuThuCung();
        fillComboBoxGiong();
        fillComboBoxLoaiVat();
        fillComBoBoxLocGiongThuCung();
        fillComBoBoxLocLoaiThuCung();
        fillComBoBoxLocThuocSoHuuThuCung();
        fillComBoBoxChuongThuCung();

        // Phieu Giam Gia
        taidulieuPhieuGiamGia();

        // dich vu
        taidulieuDichVu();
    }

    //Liem Lam **************************************************************************
    private void sille() {
        ImageIcon icon = new ImageIcon("..\\PetShop\\src\\main\\java\\com\\app\\img\\banner1.jpg");
        ImageIcon icon1 = new ImageIcon("..\\PetShop\\src\\main\\java\\com\\app\\img\\banner2.jpg");
        ImageIcon icon2 = new ImageIcon("..\\PetShop\\src\\main\\java\\com\\app\\img\\banner3.jpg");
        ImageIcon icon3 = new ImageIcon("..\\PetShop\\src\\main\\java\\com\\app\\img\\banner4.jpg");

        imageSlide.addImage(icon);
        imageSlide.addImage(icon1);
        imageSlide.addImage(icon2);
        imageSlide.addImage(icon3);

        new Timer(2500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index++;
                if (index == 3) {
                    index = 0;
                }
                imageSlide.showImage(index);
            }
        }).start();
    }

    private Boolean KiemTraFormKho() {
        if (Validate.nothingText(txtSoLuonngHangNhap)) {
            MsgBox.AlertFall(this, "số Lượng Không Để Trống");
            return false;
        }
        if (Validate.validateInteger(txtSoLuonngHangNhap.getText()) && Integer.parseInt(txtSoLuonngHangNhap.getText()) < 0) {
            MsgBox.AlertFall(this, "Nhập Sai Định Dạnh");
            return false;
        }
        return true;

    }

    private void openMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
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

    private void maPhieuNhap() {
        ArrayList<PhieuNhapHang> listNhap = (ArrayList<PhieuNhapHang>) new PhieuNhapHangDao().selectAll();
        int soNhap = listNhap.size() + 1;
        txtMaNhapHang.setText("PN0" + soNhap);
    }

    private void tieuDeBangKho() {
        DefaultTableModel tbmodel = new DefaultTableModel();
        tbmodel = (DefaultTableModel) tbllDachSachNhapHang.getModel();
        String columns[] = new String[]{"STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Đơn Vị", "Số Lượng", "Mã Nhà Cung Cấp"};
        tbmodel.setColumnIdentifiers(columns);
    }

    private void taiDuLieuKho() {
        listSanPham = new SanPhamDAO().selectAll();
        DefaultTableModel tblmodel = (DefaultTableModel) tbllDachSachNhapHang.getModel();
        tblmodel.setRowCount(0);

        int stt = 0;
        for (SanPham x : listSanPham) {
            TonKho khohang = new TonKhoDao().selectByIdSanPham(x.getMaSP());
            int soluong = khohang != null ? khohang.getSoluong() : 0;
            tblmodel.addRow(new Object[]{stt, x.getMaSP(), x.getTenSP(), x.getDonVi(), soluong, x.getMaNhaCC()});
            stt++;
        }
    }

    private void thongSoKho() {
        List<Object[]> list = new TonKhoDao().getThongSoKho();
        for (Object[] row : list) {
            lblSoluongnhap.setText(String.valueOf(row[0]));
            lblSoluongxuat.setText(String.valueOf(row[1]));
            lblTongSoHangHoa.setText(String.valueOf(row[2]));
            lblTongluonghanghoa.setText(String.valueOf(row[3]));
        }
    }

    private void cuoiCungKhoHang() {
        viTriKhoHang = listSanPham.size() - 1;
        tbllDachSachNhapHang.changeSelection(viTriKhoHang, viTriKhoHang, false, false);
        inThongTinKhoHang(viTriKhoHang);
    }

    private void inThongTinKhoHang(int vitri) {
        SanPham sp = listSanPham.get(vitri);
        txtMaHangNhap.setText(sp.getMaSP());
        txtTenHangNhap.setText(sp.getTenSP());
        txtDonViHangNhap.setText(sp.getDonVi());
        DefaultComboBoxModel combox = new DefaultComboBoxModel();
        combox = (DefaultComboBoxModel) cbbnhacc.getModel();
        combox.removeAllElements();
        List<NhaCungCap> list = new NhaCungCapDao().selectAll();
        for (NhaCungCap x : list) {
            if (x.getMaNhaCungCap().equals(sp.getMaNhaCC())) {
                combox.addElement(x);
                return;
            }
        }
    }

    private void nhapHang() {
        if (KiemTraFormKho()) {
            PhieuNhapHang phieu = new PhieuNhapHang();
            phieu.setSoPhieuNhap(txtMaNhapHang.getText());
            phieu.setNgayNhap(XDate.now());
            new PhieuNhapHangDao().insert(phieu);
            NhaCungCap nhacc = (NhaCungCap) cbbnhacc.getSelectedItem();
            new PhieuNhapHangDao().insertChiTietPhieuNhapHang(txtMaNhapHang.getText(), txtMaHangNhap.getText(), nhacc.getMaNhaCungCap(), Integer.parseInt(txtSoLuonngHangNhap.getText()));
            taiDuLieuKho();
            thongSoKho();
            xoathongtinBangKhoHang();
            MsgBox.AlertSuccess(this, "Nhập Hàng Thành Công");
            return;
        }
    }

    private void suaHang() {
        TonKho tonkho = new TonKho();
        if (!soluong.isEmpty() && Validate.validateInteger(soluong) && Validate.validateInteger(txtSoLuonngHangNhap.getText())) {
            tonkho.setSoluong(Integer.parseInt(soluong));
            tonkho.setMasp(txtMaHangNhap.getText());
            new TonKhoDao().updateSoLuong(tonkho);
            thongSoKho();
            taiDuLieuKho();
            xoathongtinBangKhoHang();
        }
    }

    private void duLieuNhacungcapKhoHang() {
        DefaultComboBoxModel combox = new DefaultComboBoxModel();
        combox = (DefaultComboBoxModel) cbbnhacc.getModel();
        combox.removeAllElements();
        List<NhaCungCap> list = new NhaCungCapDao().selectAll();
        for (NhaCungCap x : list) {
            combox.addElement(x);
        }
    }

    private void ThongKeKho() {
        try {
            List<ThongKe> lists = new ArrayList<>();
            String sql = "SELECT FORMAT(HoaDon.NgayLap, 'MMMM', 'vi-VN') AS Thang, SUM(HoaDon.TongTien) AS Tong_Tien "
                    + "FROM HoaDon "
                    + "GROUP BY FORMAT(HoaDon.NgayLap, 'MMMM', 'vi-VN'), MONTH(HoaDon.NgayLap) "
                    + "ORDER BY MONTH(HoaDon.NgayLap) DESC ";

            ResultSet rs = JdbcHelper.executeQuery(sql);

            try {
                while (rs.next()) {
                    String thang = rs.getString("Thang");
                    double tongTien = rs.getDouble("Tong_Tien");
                    lists.add(new ThongKe(thang, tongTien));
                }

                rs.close();
                for (int i = lists.size() - 1; i >= 0; i--) {
                    ThongKe tk = lists.get(i);
                    chart.addData(new ModelChart(tk.getThang(), new double[]{tk.getTongTien()}));
                }
                chart.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void xoathongtinBangKhoHang() {
        txtMaHangNhap.setText(null);
        txtTenHangNhap.setText(null);
        txtDonViHangNhap.setText(null);
        txtSoLuonngHangNhap.setText(null);
        soluong = null;
        viTriKhoHang = -1;
        duLieuNhacungcapKhoHang();
        tbllDachSachNhapHang.clearSelection();
    }

    private void xoaSoLuong() {
        TonKho tonkho = new TonKho();
        tonkho.setSoluong(0);
        tonkho.setMasp(txtMaHangNhap.getText());
        new TonKhoDao().updateSoLuong(tonkho);
        thongSoKho();
        taiDuLieuKho();
        xoathongtinBangKhoHang();
    }

    private void namThongKe() {
        List<Integer> list = new ArrayList<>();
        DefaultComboBoxModel combox = new DefaultComboBoxModel();
        combox = (DefaultComboBoxModel) cbonam.getModel();
        String sql = "SELECT YEAR(HoaDon.NgayLap) AS Nam FROM HoaDon GROUP BY YEAR(HoaDon.NgayLap)";
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            for (Integer x : list) {
                combox.addElement(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void thongKeKinhDoanh(Integer nam) {
        pieChart.clearData();

        String[] listName = new String[]{"Tổng Tiền Thú Cưng", "Tổng Tiền Sản Phẩm", "Tổng Tiền Dịch Vụ"};
        Double[] listTien = new Double[3];  // Khai báo mảng listTien ở đây để sử dụng nó bên ngoài vòng lặp

        String sql = "{call ThongKeTongTien(?)}";
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, nam);

            while (rs.next()) {
                listTien[0] = rs.getDouble(2);
                listTien[1] = rs.getDouble(3);
                listTien[2] = rs.getDouble(4);
            }
            for (int i = 0; i < listName.length; i++) {
                pieChart.addData(new ModelPieChart(listName[i], listTien[i], layMau(i)));
            }

        } catch (Exception e) {
            // Xử lý ngoại lệ nếu cần thiết
            e.printStackTrace();
        }
    }

    private Color layMau(int thutu) {
        Color[] colors = new Color[]{new Color(255, 102, 102), new Color(58, 55, 227), new Color(29, 184, 85)};
        return colors[thutu];
    }
//Het Liem Lam *******************************************************************************

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

    //Khu nTThan************************************************************************
    public void taidulieuDanhSachKhachHang() {
        new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tblDanhSachKhachHang.getModel();
                model.setRowCount(0);

                try {
                    String keyword = txtTimKiemTenKhachHang.getText();
                    List<HoiVien> listHV = (List<HoiVien>) hvdao.selectByKeyword(keyword);

                    for (int i = 0; i < listHV.size(); i++) {
                        HoiVien hv = listHV.get(i);
                        Object[] row = {
                            i + 1,
                            hv.getMaHoiVien(),
                            hv.getTenKhachHang(),
                            hv.getGioiTinh(),
                            hv.getEmail(),
                            hv.getSoDienThoai(),
                            hv.getTichDiem()
                        };
                        model.addRow(row);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Xử lý ngoại lệ ở đây, ví dụ: hiển thị một hộp thoại thông báo lỗi
                }
            }
        }).start();
    }

    void dauTienKhachHang() {
        this.rowHV = 0;

    }

    private void cuoiCungKhachHang() {
        this.rowHV = tblDanhSachKhachHang.getRowCount() - 1;

    }

    void TruocKhachHang() {
        this.rowHV--;
        if (this.rowHV >= 0) {

        } else if (this.rowHV < 0) {
            this.rowHV = tblDanhSachKhachHang.getRowCount() - 1;

        }
    }

    private void SauKhachHang() {
        this.rowHV++;
        System.out.println(this.rowHV);
        if (this.rowHV <= tblDanhSachNhanVien.getRowCount() - 1) {
        } else if (this.rowHV > tblDanhSachNhanVien.getRowCount() - 1) {
            this.rowHV = 0;

        }
    }

    private void updateStatusKhachHang() {
        boolean edit = (this.rowHV >= 0);
        boolean first = (this.rowHV == 0);
        boolean last = (this.rowHV == tblDanhSachKhachHang.getRowCount() - 1);
        btnDauTienDanhSachKhachHang.setEnabled(edit && !first);
        btnCuoiCungDanhSachKhachHang.setEnabled(edit && !last);

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
            "Số điện thoại",
            "Ghi chú",
            "Ngày đặt lịch",
            "Ngày nhận",
            "Trạng thái"
        };
        modelTblSuKien.setColumnIdentifiers(columns);
        cboSuKienLoc.addItem("Tất cả");
        cboSuKienLoc.addItem("Trước đó");
        cboSuKienLoc.addItem("Hôm nay");
        cboSuKienLoc.addItem("Sau này");
    }

    private void taiDuLieuSuKien() {
        try {
            List<DatDV> lst;
            if (cboSuKienLoc.getSelectedIndex() == 0) {
                // all
                lst = daoSuKien.selectAll();
            } else if (cboSuKienLoc.getSelectedIndex() == 3) {
                // sau đó
                lst = daoSuKien.selectByNext();
            } else if (cboSuKienLoc.getSelectedIndex() == 1) {
                // trước đó
                lst = daoSuKien.selectByPre();
            } else {
                //today
                lst = daoSuKien.selectByToday();
            }
            modelTblSuKien.setRowCount(0);
            for (int i = 0; i < lst.size(); i++) {
                DatDV dv = lst.get(i);
                Object[] rowDV = {
                    i + 1,
                    dv.getMaDL(),
                    dv.getSoDienThoai(),
                    dv.getMoTa(),
                    dv.getNgayDat(),
                    dv.getNgayTra(),
                    dv.getTrangThai()
                };
                modelTblSuKien.addRow(rowDV);

            }
            modelTblSuKien.fireTableDataChanged();
        } catch (Exception e) {
            e.getMessage();
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
        cboTrangThaiNhanVien.removeAll();
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
        if (Validate.nothingText1(txtMaNhanVien, txtHoTenNhanVien, txtNgaySinhNhanVien, txtSoDienThoaiNhanVien, txtEmailNhanVien) != null) {
            MsgBox.AlertFall(this, Validate.nothingText1(txtMaNhanVien, txtHoTenNhanVien, txtNgaySinhNhanVien, txtSoDienThoaiNhanVien, txtEmailNhanVien));
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

    }

    private void capNhatNhanVien() {
        NhanVien nv = layDuLieuTuFormNhanVien();
        try {
            System.out.println(nv.getHoTen() + "hello");
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
    //TTai
    private boolean kiemTraSP() {
        if (Validate.nothingText(txtMaSanPham, txtMaLoaiSanPham, txtTenSanPham, txtGiaNhapSanPham, txtGiaBanSanPham, txtDonViSanPham, txtSoLuongSanPham, txtMaKhoSanPham) != null) {
            MsgBox.AlertFall(this, "Vui lòng nhập đầy đủ thông tin sản phẩm");
            return false;
        }
        return true;
    }

    ;
    void xoaDuLieuSP() {
        txtMaSanPham.setText("");
        txtMaLoaiSanPham.setText("");
        txtTenSanPham.setText("");
        txtGiaNhapSanPham.setText("");
        txtGiaBanSanPham.setText("");
        txtDonViSanPham.setText("");
        txtSoLuongSanPham.setText("");
        txtMaKhoSanPham.setText("");
        cboTrangThaiSanPham.setSelectedIndex(0);
    }

    private void themSP() {
        SanPham modelSP = getModelSP();
        TonKho modelTK = getModelTK();
        try {
            spDao.insert(modelSP);
            tkDao.insert(modelTK);
            this.xoaDuLieuSP();
            this.taiDuLieuSP();
            JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
        }
    }

    void capNhatSP() {
        SanPham model = getModelSP();
        try {
            spDao.update(model);
            this.taiDuLieuSP();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void xoaSP() {
        String macd = txtMaSanPham.getText();
        String makh = txtMaKhoSanPham.getText();
        try {
            spDao.delete(macd);
            this.taiDuLieuSP();
            this.xoaDuLieuSP();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
        }
    }

    void taiDuLieuSP() {

        DefaultTableModel model = (DefaultTableModel) tblDanhSachSanPham.getModel();
        model.setRowCount(0);
        String keyword = txtTimKiemTenSanPham.getText();
        Object combobox = cboLocTrangThaiSanPham.getSelectedItem();
        try {
            List<TonKho> listtk = tkDao.selectAll();
            List<SanPham> listSP = spDao.selectByKeyWord(keyword);
            List<SanPham> cboSP = spDao.selectByCombobox(combobox.toString());
            for (SanPham sp : listSP) {
                for (SanPham cboItem : cboSP) {
                    if (sp.getMaSP().equals(cboItem.getMaSP())) {
                        for (TonKho tk : listtk) {
                            if (sp.getMaSP().equals(tk.getMasp())) {
                                Object[] row = {
                                    sp.getMaSP(),
                                    sp.getMaLoaiSP(),
                                    sp.getTenSP(),
                                    sp.getGiaTien(),
                                    sp.getPhanTram(),
                                    sp.getDonVi(),
                                    tk.getSoluong(),
                                    tk.getMaKho(),
                                    sp.getMaNhaCC(),
                                    sp.getTrangThai()
                                };
                                model.addRow(row);
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    void setModelSP(SanPham model) {
        txtMaSanPham.setText(model.getMaSP());
        txtGiaNhapSanPham.setText(Double.toString(model.getGiaTien()));
        txtTenSanPham.setText(model.getTenSP());
        txtDonViSanPham.setText(model.getDonVi());
        txtGiaBanSanPham.setText(Float.toString(model.getPhanTram()));
        txtMaLoaiSanPham.setText(model.getMaLoaiSP());
        txtMaNhaCC.setText(model.getMaNhaCC());
        cboTrangThaiSanPham.setSelectedItem(model.getTrangThai());

    }

    void setModelTK(TonKho model) {
        txtMaSanPham.setText(model.getMasp());
        txtMaKhoSanPham.setText(model.getMaKho());
        txtSoLuongSanPham.setText(Integer.toString(model.getSoluong()));
    }

    SanPham getModelSP() {
        SanPham model = new SanPham();
        model.setMaSP(txtMaSanPham.getText());
        model.setMaLoaiSP(txtMaLoaiSanPham.getText());
        model.setTenSP(txtTenSanPham.getText());
        model.setGiaTien(Integer.valueOf(txtGiaNhapSanPham.getText()));
        model.setDonVi(txtDonViSanPham.getText());
        model.setMaNhaCC(txtMaNhaCC.getText());
        model.setTrangThai((String) cboTrangThaiSanPham.getSelectedItem());
        return model;
    }

    TonKho getModelTK() {
        TonKho model = new TonKho();
        model.setMasp(txtMaSanPham.getText());
        model.setMaKho(txtMaKhoSanPham.getText());
        model.setSoluong(Integer.parseInt(txtSoLuongSanPham.getText()));
        return model;
    }

    void editSP() {
        try {
            String masp = (String) tblDanhSachSanPham.getValueAt(this.ViTriSanPham, 0);
            SanPham modelSP = spDao.selectById(masp);
            TonKho modelTK = tkDao.selectBySanPham(masp);
            if (modelSP != null && modelTK != null) {
                this.setModelSP(modelSP);
                this.setModelTK(modelTK);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void dauTienSanPham() {
        this.ViTriSanPham = 0;
        this.editSP();
    }

    private void cuoiCungSamPham() {
        this.ViTriSanPham = tblDanhSachSanPham.getRowCount() - 1;
        this.editSP();
    }

    void TruocSanPham() {
        this.ViTriSanPham--;
        if (this.ViTriSanPham >= 0) {
            this.editSP();
        } else if (this.ViTriSanPham < 0) {
            this.ViTriSanPham = tblDanhSachSanPham.getRowCount() - 1;
            this.editSP();
        }
    }

    private void SauSanPham() {
        this.ViTriSanPham++;
        System.out.println(this.ViTriSanPham);
        if (this.ViTriSanPham <= tblDanhSachSanPham.getRowCount() - 1) {
            this.editSP();
        } else if (this.ViTriSanPham > tblDanhSachSanPham.getRowCount() - 1) {
            this.ViTriSanPham = 0;
            this.editSP();
        }
    }
// kết thức Ttai  

    // hoa don
    private void KhuyenMaiHoaDon() {
        DefaultComboBoxModel combox = new DefaultComboBoxModel();
        combox = (DefaultComboBoxModel) cboKhuyenMaiHoaDon.getModel();
        List<PhieuGiamGia> list = new ArrayList<>();
        list = new PhieuGiamGiaDao().selectAll();
        for (PhieuGiamGia phieuGiamGia : list) {
            combox.addElement(phieuGiamGia);
        }
    }

    private void SanPhamHoaDon() {
        DefaultTableModel tblModel = (DefaultTableModel) tablDanhSachSanPhamHoaDon.getModel();
        tblModel.setRowCount(0);
        ArrayList<SanPham> listsp = (ArrayList<SanPham>) new SanPhamDAO().selectAll();

        for (SanPham sanPham : listsp) {
            int giaTien = sanPham.getGiaTien() != null ? sanPham.getGiaTien() : 0;
            double phanTram = sanPham.getPhanTram() != null ? sanPham.getPhanTram() : 0;
            double totalPrice = giaTien * phanTram;

            tblModel.addRow(new Object[]{
                sanPham.getMaSP(),
                (int) totalPrice, // Cast to int if needed
                sanPham.getTenSP(),
                sanPham.getDonVi(),
                sanPham.getMaLoaiSP(),
                sanPham.getMaNhaCC(),
                sanPham.getTrangThai()
            });
        }
    }

    private void TieuDeBangSanPhamHoaDon() {
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel = (DefaultTableModel) tablDanhSachSanPhamHoaDon.getModel();
        tblModel.setRowCount(0);
        String columns[] = new String[]{
            "Mã Sản Phẩm", "Giá Tiền Sản Phẩm", "Tên Sản Phẩm", "Đơn Vị", "Mã Loại Sản Phẩm", "Mã Nhà Cung Cấp", "Trang Thái Sản Phẩm"
        };
        tblModel.setColumnIdentifiers(columns);
    }

    private void TieuDeBangThuCung() {
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel = (DefaultTableModel) tablDanhSachThuCungHoaDon.getModel();
        tblModel.setRowCount(0);
        String columns[] = new String[]{"Mã Thú Cưng", "Giá Tiến", "Tuổi", "Cân Nặng", "Mã Giống", "Giới Tính", "Mã Hội Viên", "Mã Chuồng", "Mã Loại", "Mô Tả"};
        tblModel.setColumnIdentifiers(columns);
    }

    private void ThuCungHoaDon() {
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel = (DefaultTableModel) tablDanhSachThuCungHoaDon.getModel();
        tblModel.setRowCount(0);
        ArrayList<ThuCung> listTC = (ArrayList<ThuCung>) new ThuCungDao().selectAllNOTHOIVIEN();
        for (ThuCung thuCung : listTC) {
            tblModel.addRow(new Object[]{thuCung.getMaThuCung(), thuCung.getGiaTien(), thuCung.getTuoi(), thuCung.getCanNang(), thuCung.getMaGiong(), thuCung.isGioiTinh() ? "Đực" : "Cái", thuCung.getMaHoiVien(), thuCung.getMaChuong(), thuCung.getMaLoai(), thuCung.getMoTa()});
        }
    }

    private void HoiVienHoaDon(Boolean x) {
        DefaultComboBoxModel combox = new DefaultComboBoxModel();
        combox = (DefaultComboBoxModel) cboDanhSachKhachHang.getModel();
        combox.removeAllElements();
        ArrayList<HoiVien> list = new ArrayList<>();
        if (x == true) {
            list = (ArrayList<HoiVien>) new HoiVienDao().selectAll();
            for (HoiVien hv : list) {
                combox.addElement(hv);
            }
        } else {
            list.clear();
            list.add(new HoiVien("Khách Vãn Lai", "Vô Danh", "Nam", "email@gmail.com", "00000000", 0, "091213121313"));
            for (HoiVien hv : list) {
                combox.addElement(hv);
            }
        }

    }

    private void LoaiThanhVien() {
        DefaultComboBoxModel combox = new DefaultComboBoxModel();
        combox = (DefaultComboBoxModel) cboLoaiKhachHangHoaDon.getModel();
        ArrayList<String> list = new ArrayList<>();
        combox.removeAllElements();
        list.clear();
        list.add("Khách Vãn Lai");
        list.add("Hội Viên");
        for (String string : list) {
            combox.addElement(string);
        }
    }

    private void NhapMaHoaDon() {
        ArrayList<HoaDon> list = (ArrayList<HoaDon>) new HoaDonDAO().selectAll();
        txtMaHoaDon.setText("HD" + (list.size() + 1));
    }

    private void DichVuHoaDon() {
        DefaultComboBoxModel combox = new DefaultComboBoxModel();
        combox = (DefaultComboBoxModel) cboTenDichVu.getModel();
        combox.removeAllElements();
        List<DichVu> list = new DichVuDao().selectAll();
        for (DichVu dichVu : list) {
            combox.addElement(dichVu);
        }
    }

    private void nhapMaDatLich() {
        ArrayList<DatDV> list = (ArrayList<DatDV>) new DatDVDAO().selectAll();
        txtMaDatDichVu.setText("DL0" + (list.size() + 1));
    }

    private void TieuDeChiTietHoaDon() {

        tblmodelTTHD = (DefaultTableModel) tblDanhSahChiTietHoaDon.getModel();
        String cloums[] = new String[]{"MÃ HÀNG", "SỐ LƯỢNG", "TIỀN", "TỔNG TIỀN"};
        tblmodelTTHD.setColumnIdentifiers(cloums);
    }

    private void ThemThuCungHoaDonChiTiet() {
        DefaultTableModel tblmodelTTHD = (DefaultTableModel) tblDanhSahChiTietHoaDon.getModel();
        String matc = (String) tablDanhSachThuCungHoaDon.getValueAt(hoadonthucung, 0);
        Integer giatien = (Integer) tablDanhSachThuCungHoaDon.getValueAt(hoadonthucung, 1);
        boolean found = false;
        for (int i = 0; i < tblmodelTTHD.getRowCount(); i++) {
            if (matc.equals(tblmodelTTHD.getValueAt(i, 0))) {
                MsgBox.AlertSuccess(this, "Thú Cưng Đã Có Trong Danh Sách");
                return;
            }
        }
        if (!found) {
            tblmodelTTHD.addRow(new Object[]{matc, 1, giatien, giatien * 1});
        }
    }

    private void ThemSanPhamHoaDonChiTiet() {
        DefaultTableModel tblmodelTTHD = (DefaultTableModel) tblDanhSahChiTietHoaDon.getModel();
        String matc = (String) tablDanhSachSanPhamHoaDon.getValueAt(hoadonsanpham, 0);
        Integer giatien = (Integer) tablDanhSachSanPhamHoaDon.getValueAt(hoadonsanpham, 1);
        boolean found = false;
        for (int i = 0; i < tblmodelTTHD.getRowCount(); i++) {
            if (matc.equals(tblmodelTTHD.getValueAt(i, 0))) {
                Integer soLuong = (Integer) tblmodelTTHD.getValueAt(i, 1) + 1;
                tblmodelTTHD.setValueAt(soLuong, i, 1);
                tblmodelTTHD.setValueAt(giatien * soLuong, i, 3);
                found = true;
            }
        }
        if (!found) {
            tblmodelTTHD.addRow(new Object[]{matc, 1, giatien, giatien * 1});
        }
    }

    private void TongTienHoaDon() {
        Integer tongTien = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < tblmodelTTHD.getRowCount(); i++) {
            list.add((Integer) tblmodelTTHD.getValueAt(i, 3));
        }
        for (Integer tien : list) {
            tongTien += tien;
        }
        txtTongTienHoaDon.setText(String.valueOf(tongTien));
        return;
    }

    private void TienThuaHoaDon() {
        int TienNhan = Integer.parseInt(txtTienNhanHoaDon.getText());
        int TienHoaDon = Integer.parseInt(txtTongTienHoaDon.getText());
        txtTienThuaHoaDon.setText(String.valueOf(TienNhan - TienHoaDon));
    }

    private void ThemDichVuHoaDon() {
        DichVu dv = (DichVu) cboTenDichVu.getSelectedItem();
        tblmodelTTHD.addRow(new Object[]{dv.getMaDichVu(), dv.getDonVi(), (int) dv.getGiaTien(), (int) dv.getGiaTien() * 1});
    }

    private void ThemVaoDatabaseHoaDon() {
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        for (int i = 0; i < tblmodelTTHD.getRowCount(); i++) {
            cthd.setMaHang((String)tblmodelTTHD.getValueAt(i, 0));
            cthd.setSoLuong((Integer)tblmodelTTHD.getValueAt(i, 1));
            cthd.setGiaTien((Integer) tblmodelTTHD.getValueAt(i, 2));
            cthd.setTongTien((Integer)tblmodelTTHD.getValueAt(i, 3));        
        }
    }

    //--------------------------QHung--------------------------------------------------------------------------------
    void TaiDuLieuThuCung() {
        int sttTC = 0;
        DefaultTableModel tableModel = (DefaultTableModel) tblDanhSachThuCung.getModel();
        tableModel.setRowCount(0);
        try {
            List<ThuCung> list = tcdao.selectAll();
            for (ThuCung tc : list) {
                Object[] row = {
                    tc.getMaThuCung(),
                    tc.getMoTa(),
                    tc.getGiaTien(),
                    XDate.toString(tc.getTuoi(), "dd/MM/yyyy"),
                    tc.getCanNang(),
                    tc.getMaGiong(),
                    tc.isGioiTinh() ? "Đực" : "Cái",
                    tc.getMaHoiVien(),
                    tc.getMaChuong(),
                    tc.getMaLoai(),
                    tc.getHinhAnh()
                };
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void editThuCung() {
        try {
            String key = (String) tblDanhSachThuCung.getValueAt(this.thucung, 0);
            ThuCung model = tcdao.selectById(key);
            if (model != null) {
                this.setModel(model);

                //this.setStatus(false);
            }

        } catch (Exception e) {
            MsgBox.AlertFall(this, "Loi truy van du lieu!");
        }
    }

    void insertThuCung() {
        if (KiemTraDuLieuThuCung()) {
            ThuCung model = getModel();
            model.setTuoi(new Date());
            try {
                if (model != null) {
                    if (tcdao.selectById(model.getMaThuCung()) != null) {
                        MsgBox.AlertFall(this, "Mã thú cưng đã tồn tại");
                        return;
                    }
                    tcdao.insert(model);
                    this.TaiDuLieuThuCung();
                    this.clearThuCung();
                    MsgBox.AlertSuccess(this, "Thêm mới thành công");
                }
            } catch (Exception e) {
                MsgBox.AlertFall(this, "Thất bại thêm thú cưng");
            }
        }
    }

    void updateThuCung() {
        if (KiemTraDuLieuThuCung()) {
            ThuCung model = getModel();
            try {
                if (model != null) {
                    tcdao.update(model);
                    this.TaiDuLieuThuCung();
                    this.clearThuCung();
                    MsgBox.AlertSuccess(this, "Cập nhật thành công");
                }
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.AlertFall(this, "Cập nhật thất bại!");
            }
        }
    }

    void clearThuCung() {
        ThuCung model = new ThuCung();
        LoaiVat loaivat = (LoaiVat) cboLoaiThuCung.getSelectedItem();
        Giong giong = (Giong) cboGiongThuCung.getSelectedItem();
        String chuong = (String) cboSoChuongThuCung.getSelectedItem();
        model.setMaLoai(loaivat.getMaLoai());
        model.setMaGiong(giong.getTenGiong());
        model.setMaChuong(chuong);

    }

    void deleteThuCung() {
        if (KiemTraDuLieuThuCung()) {
            if (MsgBox.confirm(this, "Có thiệt sự là muốn xóa hông?")) {
                String MaTC = txtMaThuCung.getText();
                try {
                    tcdao.delete(MaTC);
                    this.TaiDuLieuThuCung();
                    MsgBox.AlertSuccess(this, "Xóa thành công nè");
                } catch (Exception e) {
                    MsgBox.AlertFall(this, "Lỗi truy vấn!");
                }
            }
        }
    }

    void setModel(ThuCung model) {
        txtMaThuCung.setText(model.getMaThuCung());
        txtGiaTienThuCung.setText(Integer.toString(model.getGiaTien()));
        selectComboBoxItemLoaiVat(cboLoaiThuCung, model.getMaLoai());
        selectComboBoxItemLoaiVat(cboGiongThuCung, model.getMaGiong());
        selectComboBoxItemLoaiVat(cboSoChuongThuCung, model.getMaChuong());
        txtCanNangThuCung.setText(Float.toString(model.getCanNang()));

        if (model.isGioiTinh()) {
            rdoGioiTinhDuc.setSelected(true);
            rdoGioiTinhCai.setSelected(false);
        } else {
            rdoGioiTinhDuc.setSelected(false);
            rdoGioiTinhCai.setSelected(true);
        }

        txtTuoiThuCung.setText(XDate.toString(model.getTuoi()));

        txtThuoc.setText(model.getMaHoiVien());
        txtMoTaThuCung.setText(model.getMoTa());
        lblHinhThuCung.setText(model.getHinhAnh());
    }

    ThuCung getModel() {
        ThuCung model = new ThuCung();

        LoaiVat loaivat = (LoaiVat) cboLoaiThuCung.getSelectedItem();
        Giong giong = (Giong) cboGiongThuCung.getSelectedItem();
        String chuong = (String) cboSoChuongThuCung.getSelectedItem();

        model.setMaThuCung(txtMaThuCung.getText());
        model.setMoTa(txtMoTaThuCung.getText());
        model.setGiaTien(Integer.valueOf(txtGiaTienThuCung.getText()));
        model.setTuoi(XDate.toDate(txtTuoiThuCung.getText()));
        model.setCanNang(Float.parseFloat(txtCanNangThuCung.getText()));
        model.setMaGiong(giong.getMaGiong());
        model.setGioiTinh(rdoGioiTinhDuc.isSelected());
        model.setMaHoiVien(txtThuoc.getText());
        model.setMaChuong(chuong);
        model.setMaLoai(loaivat.getMaLoai());
        model.setHinhAnh(lblHinhThuCung.getText());
        return model;
    }

    public void fillComboBoxLoaiVat() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiThuCung.getModel();
        model.removeAllElements();
        try {
            List<LoaiVat> list = lvdao.selectAll();
            for (LoaiVat lv : list) {
                model.addElement(lv);
            }
        } catch (Exception e) {
        }
    }

    public void fillComboBoxGiong() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboGiongThuCung.getModel();
        model.removeAllElements();
        try {
            List<Giong> list = gdao.selectAll();
            for (Giong g : list) {
                model.addElement(g);
            }
        } catch (Exception e) {

        }
    }

    void fillComBoBoxLocGiongThuCung() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLocGIongThuCung.getModel();
        model.removeAllElements();
        try {
            List<Giong> list = gdao.selectAll();
            for (Giong g : list) {
                model.addElement(g);
            }
        } catch (Exception e) {
        }
    }

    //cbo chuồng
    public void fillComBoBoxChuongThuCung() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboSoChuongThuCung.getModel();
        model.removeAllElements();
        List<String> list = chuongdao.findKey("Trống");
        try {
            for (String chuong : list) {
                model.addElement(chuong);
            }
        } catch (Exception e) {
            MsgBox.AlertFall(this, "Lỗi fill cboChuong");
        }
    }

    void fillComBoBoxLocLoaiThuCung() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLocLoaiThuCung.getModel();
        model.removeAllElements();
        try {
            List<LoaiVat> list = lvdao.selectAll();
            for (LoaiVat lv : list) {
                model.addElement(lv);
            }
        } catch (Exception e) {
        }
    }

    void fillComBoBoxLocThuocSoHuuThuCung() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLocSoHuuThuCung.getModel();
        model.removeAllElements();
        try {
            List<HoiVien> list = hvdao.selectAll();
            for (HoiVien hv : list) {
                model.addElement(hv);
            }
        } catch (Exception e) {
            MsgBox.AlertFall(this, "lỗi truy vấn cbo mã hội viên");
        }
    }

    void selectComboBoxItemLoaiVat(JComboBox<?> comboBox, String value) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            Object item = comboBox.getItemAt(i);
            if (item != null && item.toString().equals(value)) {
                comboBox.setSelectedIndex(i);
                return;
            }
        }
    }

    void TimKiemThuCung(String keyword) {
        // Xóa tất cả các dòng hiện tại trong bảng
        DefaultTableModel model = (DefaultTableModel) tblDanhSachThuCung.getModel();
        model.setRowCount(0);

        for (ThuCung tc : datalist) {
            // Tìm kiếm dựa trên MaLoai hoặc TenLoai (hoặc cả hai)
            if (tc.getMaThuCung().contains(keyword) || tc.getMoTa().contains(keyword) || tc.getMaGiong().contains(keyword) || tc.getMaChuong().contains(keyword) || tc.getMaLoai().contains(keyword)) {
                // Thêm dòng mới vào bảng
                model.addRow(new Object[]{tc.getMaThuCung(),
                    tc.getMoTa(),
                    tc.getGiaTien(),
                    XDate.toString(tc.getTuoi()),
                    tc.getCanNang(),
                    tc.getMaGiong(),
                    tc.isGioiTinh() ? "Đực" : "Cái",
                    tc.getMaHoiVien(),
                    tc.getMaChuong(),
                    tc.getMaLoai()});
            }
        }
    }

    private boolean KiemTraDuLieuThuCung() {
        boolean Duc = rdoGioiTinhDuc.isSelected();
        boolean Cai = rdoGioiTinhCai.isSelected();

        if (txtMaThuCung.equals("") || txtGiaTienThuCung.equals("") || txtCanNangThuCung.equals("") || !Duc && !Cai || txtTuoiThuCung.equals("") || txtThuoc.equals("") || txtThuoc.equals("")) {
            MsgBox.AlertFall(this, "Thông tin chưa đẩy đủ! Vui lòng nhập thông tin đầy đủ");
            return false;
        }
        if (!Validate.validateInteger(txtGiaTienThuCung.getText())) {
            MsgBox.AlertFall(this, "Giá tiền phải là số");
            return false;
        }
        if (!Validate.validateDate(txtTuoiThuCung.getText())) {
            MsgBox.AlertFall(this, "Tuổi thú cưng nhập theo form dd/MM/yyyy");
            return false;
        }
        if (!Validate.validateDouble(txtCanNangThuCung.getText())) {
            MsgBox.AlertFall(this, "Cân nặng phải là số");
            return false;
        }
        return true;
    }

    private void displayImage(int rowIndex) {
        try {
            // Lấy dữ liệu hình ảnh từ cột "Image" trong model của JTable
            String imagePath = (String) tblDanhSachThuCung.getValueAt(rowIndex, 10);
            ImageIcon imageIcon = new ImageIcon("..\\PetShop\\src\\main\\java\\com\\app\\img\\" + imagePath);
            Image im = imageIcon.getImage();
            ImageIcon icon = new ImageIcon(im.getScaledInstance(lblHinhThuCung.getWidth(), lblHinhThuCung.getHeight(), im.SCALE_SMOOTH));
            lblHinhThuCung.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.AlertFall(this, "Lỗi hiển thị hình ảnh");
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------

    // thêm dịch vụ
    public void taidulieuDichVu() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachDichVu.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtTimKiemDichVu.getText();
            List<DichVu> lstDV = (List<DichVu>) daoDv.selectByKeyword(keyword);
            for (int i = 1; i < lstDV.size(); i++) {
                for (DichVu dv : lstDV) {
                    Object[] row = {
                        i++,
                        dv.getMaDichVu(),
                        dv.getTenDichVu(),
                        dv.getDonVi(),
                        dv.getGiaTien()
                    };
                    model.addRow(row);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void themDichVu() {
        if (KiemtradulieuDichVu()) {
            DichVu model = getModelDV();
            try {
                if (model != null) {
                    if (daoDv.selectById(model.getMaDichVu()) != null) {
                        MsgBox.AlertFall(this, "Mã dịch vụ tồn tại");
                        return;
                    }
                    daoDv.insert(model);
                    this.taidulieuDichVu();
                    this.xoaformDichVu();
                }
                MsgBox.AlertFall(this, "Thêm mới thành công");
            } catch (Exception e) {
                MsgBox.AlertFall(this, "Thêm mới thất bại!");
            }
        }
    }

    private void LayPhieuGiamGia() {
        List<PhieuGiamGia> list = new PhieuGiamGiaDao().selectAll();
        PhieuGiamGia PGGG = list.get(PhieuGiamGia);
        setModelPGG(PGGG);
    }

    void capnhatDichVu() {
        DichVu model = getModelDV();
        try {
            daoDv.update(model);
            this.taidulieuDichVu();
            MsgBox.AlertFall(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.AlertFall(this, "Cập nhật thất bại!");
        }
    }

    void xoaDichVu() {
        String manh = txtMaDichVu.getText();
        try {
            daoDv.delete(manh);
            this.taidulieuDichVu();
            this.xoaformDichVu();
            MsgBox.AlertFall(this, "Xóa thành công!");
        } catch (Exception e) {
            MsgBox.AlertFall(this, "Xóa thất bại!");
        }

    }

    void xoaformDichVu() {
        txtMaDichVu.setText(null);
        txtTenDichVu.setText(null);
        txtDonVi.setText(null);
        txtGiaTienDichhVu.setText(null);
    }

    void chinhsuaDichVu() {
        try {
            int selectedRow = tblDanhSachDichVu.getSelectedRow();
            if (selectedRow == -1) {
                MsgBox.AlertFall(this, "Vui lòng chọn một hàng để sửa!");
                return;
            }
            String madv = (String) tblDanhSachDichVu.getValueAt(selectedRow, 1);
            DichVu model = daoDv.findById(madv);
            if (model != null) {
                setModelDV(model);
                tblDanhSachPhieuGiamGia.setValueAt(model.getMaDichVu(), selectedRow, 1);
                tblDanhSachPhieuGiamGia.setValueAt(model.getTenDichVu(), selectedRow, 2);
                tblDanhSachPhieuGiamGia.setValueAt(model.getDonVi(), selectedRow, 3);
                tblDanhSachPhieuGiamGia.setValueAt(model.getGiaTien(), selectedRow, 4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DichVu getModelDV() {
        DichVu model = new DichVu();
        model.setMaDichVu(txtMaDichVu.getText());
        model.setTenDichVu(txtTenDichVu.getText());
        model.setDonVi(txtDonVi.getText());
        model.setGiaTien(Double.parseDouble(txtGiaTienDichhVu.getText()));
        return model;
    }

    private DichVu setModelDV(DichVu model) {
        txtMaDichVu.setText(model.getMaDichVu());
        txtTenDichVu.setText(model.getTenDichVu());
        txtDonVi.setText(model.getDonVi());
        txtGiaTienDichhVu.setText(String.valueOf(model.getGiaTien()));
        return model;
    }

    private void laydichvu() {
        List<DichVu> list = new DichVuDao().selectAll();
        DichVu dv = list.get(DichVu);
        setModelDV(dv);
    }

    private boolean KiemtradulieuDichVu() {
        if (Validate.nothingText(txtMaDichVu, txtTenDichVu, txtDonVi, txtGiaTienDichhVu) != null) {
            MsgBox.AlertFall(this, "Vui lòng nhập đầy đủ thông tin dịch vụ.");
            return false;
        }

        if (!Validate.validateDouble(txtGiaTienDichhVu.getText())) {
            MsgBox.AlertFall(this, "Gía tiền Dịch vụ chưa nhập đúng");
            return false;
        }
        return true;
    }

    // phieu giam gia
    public void taidulieuPhieuGiamGia() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachPhieuGiamGia.getModel();
        model.setRowCount(0);
        String keyword = txtTimKiemKhuyenMai.getText();
        try {
            List<PhieuGiamGia> listPGG = daoPGG.selectByKeyword(keyword);
            int key = cboLocTrangThaiKhuyenMai.getSelectedIndex();
            List<PhieuGiamGia> conhan = daoPGG.selectByConHan();
            List<PhieuGiamGia> hethan = daoPGG.selectByHetHan();
            int i = 1;
            for (PhieuGiamGia pgg : listPGG) {
                Object[] row = {
                    i++,
                    pgg.getMaPhieuGiamGia(),
                    pgg.getPhanTramGiamGia(),
                    pgg.getDateStart(),
                    pgg.getDateEnd()
                };
                if (key == 0) {
                    model.addRow(row);
                } else if (key == 1) {
                    for (PhieuGiamGia datecon : conhan) {
                        if (pgg.getMaPhieuGiamGia().equals(datecon.getMaPhieuGiamGia())) {
                            model.addRow(row);
                        }
                    }
                } else if (key == 2) {
                    for (PhieuGiamGia datehet : hethan) {
                        if (pgg.getMaPhieuGiamGia().equals(datehet.getMaPhieuGiamGia())) {
                            model.addRow(row);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void themPhieuGiamGia() {
        if (KiemtradulieuPGG()) {
            PhieuGiamGia model = getModelPGG();
            try {
                if (model != null) {
                    if (daoPGG.selectById(model.getMaPhieuGiamGia()) != null) {
                        MsgBox.AlertFall(this, "Mã giảm giá đã tồn tại");
                        return;
                    }
                    daoPGG.insert(model);
                    taidulieuPhieuGiamGia();
                    xoaformPhieuGiamGia();
                }
                MsgBox.AlertFall(this, "Thêm mới thành công");
            } catch (Exception e) {
                MsgBox.AlertFall(this, "Thêm mới thất bại!");
            }
        }
    }

    void capnhatPhieuGiamGia() {
        PhieuGiamGia model = getModelPGG();
        try {
            daoPGG.update(model);
            taidulieuPhieuGiamGia();
            xoaformPhieuGiamGia();
            MsgBox.AlertFall(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.AlertFall(this, "Cập nhật thất bại");
        }
    }

    void xoaPhieuGiamGia() {
        String makm = txtMaKhuyenMai.getText();
        try {
            daoPGG.delete(makm);
            this.taidulieuPhieuGiamGia();
            this.xoaformPhieuGiamGia();
            MsgBox.AlertFall(this, "Xóa thành công!");
        } catch (Exception e) {
            MsgBox.AlertFall(this, "Xóa thất bại!");
        }

    }

    void xoaformPhieuGiamGia() {
        txtMaKhuyenMai.setText(null);
        txtPhanTramKhuyenMai.setText(null);
        txtNgayBatDauKhuyenMai.setText(null);
        txtNgayKetThucKhuyenMai.setText(null);
    }

    void chinhsuaPhieuGiamGia() {
        try {
            int selectedRow = tblDanhSachPhieuGiamGia.getSelectedRow();
            if (selectedRow == -1) {
                MsgBox.AlertFall(this, "Vui lòng chọn một hàng để sửa!");
                return;
            }
            String mapgg = (String) tblDanhSachPhieuGiamGia.getValueAt(selectedRow, 1);
            PhieuGiamGia model = daoPGG.findById(mapgg);
            if (model != null) {
                setModelPGG(model);
                tblDanhSachPhieuGiamGia.setValueAt(model.getMaPhieuGiamGia(), selectedRow, 1);
                tblDanhSachPhieuGiamGia.setValueAt(model.getPhanTramGiamGia(), selectedRow, 2);
                tblDanhSachPhieuGiamGia.setValueAt(model.getDateStart(), selectedRow, 3);
                tblDanhSachPhieuGiamGia.setValueAt(model.getDateEnd(), selectedRow, 4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PhieuGiamGia getModelPGG() {
        PhieuGiamGia model = new PhieuGiamGia();
        model.setMaPhieuGiamGia(txtMaKhuyenMai.getText());
        model.setPhanTramGiamGia(Float.parseFloat(txtPhanTramKhuyenMai.getText()));
        model.setDateStart(XDate.toDate(txtNgayBatDauKhuyenMai.getText()));
        model.setDateEnd(XDate.toDate(txtNgayKetThucKhuyenMai.getText()));
        return model;
    }

    private PhieuGiamGia setModelPGG(PhieuGiamGia model) {
        txtMaKhuyenMai.setText(model.getMaPhieuGiamGia());
        txtPhanTramKhuyenMai.setText(String.valueOf(model.getPhanTramGiamGia()));
        txtNgayBatDauKhuyenMai.setText(XDate.toString(model.getDateStart()));
        txtNgayKetThucKhuyenMai.setText(XDate.toString(model.getDateEnd()));
        return model;
    }

    void timkiemphantramgiamgia() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachPhieuGiamGia.getModel();
        model.setRowCount(0);
        String keyword = txtTimKiemKhuyenMai.getText();
        List<PhieuGiamGia> listPGG = daoPGG.selectByKeyword(keyword);
        int stt = 1;
        for (PhieuGiamGia phieugg : listPGG) {
            model.addRow(new Object[]{
                stt + 1,
                phieugg.getMaPhieuGiamGia(),
                phieugg.getPhanTramGiamGia(),
                phieugg.getDateStart(),
                phieugg.getDateEnd()
            });
        }
        ;

    }

    private boolean KiemtradulieuPGG() {
        if (Validate.nothingText(txtMaKhuyenMai, txtPhanTramKhuyenMai, txtNgayBatDauKhuyenMai, txtNgayKetThucKhuyenMai) != null) {
            MsgBox.AlertFall(this, "Vui lòng nhập đầy đủ thông tin giảm giá.");
            return false;
        }

        if (!Validate.validateDouble(txtPhanTramKhuyenMai.getText())) {
            MsgBox.AlertFall(this, "Phần trăm khuyến mãi chưa nhập đúng");
            return false;
        }
        if (!Validate.validateDate(txtNgayBatDauKhuyenMai.getText())) {
            MsgBox.AlertFall(this, "Vui lòng nhập đúng định dạng (dd-MM-yyyy)");
            return false;
        }
        if (!Validate.validateDate(txtNgayKetThucKhuyenMai.getText())) {
            MsgBox.AlertFall(this, "Vui lòng nhập đúng định dạng (dd-MM-yyyy)");
            return false;
        }
        return true;
    }

    /**
     * *************************************************
     * /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlMain = new com.app.Other.ColorPanel();
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
        pnlTrangThai = new com.app.Other.ColorPanel();
        jLabel5 = new javax.swing.JLabel();
        lblLock = new javax.swing.JLabel();
        pnlHead = new com.app.Other.ColorPanel();
        jLabel1 = new javax.swing.JLabel();
        lblHinhLogo1 = new javax.swing.JLabel();
        lblOpenMenuIcon = new javax.swing.JLabel();
        lblUserIcon = new javax.swing.JLabel();
        pnlCard = new com.app.Other.ColorPanel();
        tabSuKien = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachSuKien = new javax.swing.JTable();
        btnSuKienThemLichDat1 = new javax.swing.JButton();
        lblSuKienNgayHienTai = new javax.swing.JLabel();
        cboSuKienLoc = new javax.swing.JComboBox<>();
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
        cboSoChuongThuCung = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        lblThuoc = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTaThuCung = new javax.swing.JTextArea();
        txtThuoc = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        lblHinhThuCung = new javax.swing.JLabel();
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
        tblDanhSachThuCung = new javax.swing.JTable();
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
        tblDanhSachKhachHang = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        txtTimKiemTenKhachHang = new javax.swing.JTextField();
        btnTimKiemKhachHang = new javax.swing.JButton();
        btnVeDauHoiVien = new javax.swing.JPanel();
        btnDauTienDanhSachKhachHang = new javax.swing.JButton();
        btnCuoiCungDanhSachKhachHang = new javax.swing.JButton();
        btnSauDanhSachKhachHang = new javax.swing.JButton();
        btnTruocDanhSachKhachHang = new javax.swing.JButton();
        btnThemKhachHang = new javax.swing.JButton();
        tabSanPham = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
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
        jLabel20 = new javax.swing.JLabel();
        txtMaKhoSanPham = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtMaNhaCC = new javax.swing.JTextField();
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
        cboLocTrangThaiKhuyenMai = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnCuoiCungDanhSachKhuyenMai = new javax.swing.JButton();
        btnSauDanhSachKhuyenMai = new javax.swing.JButton();
        btnTruocDanhSachKhuyenMai = new javax.swing.JButton();
        btnDauTienDanhSachKhuyenMai = new javax.swing.JButton();
        btnLamMoiKhuyenMai = new javax.swing.JButton();
        btnSuaKhuyenMai = new javax.swing.JButton();
        btnXoaKhuyenMai = new javax.swing.JButton();
        btnThemKhuyenMai = new javax.swing.JButton();
        btnTimKiemKhuyenMai = new javax.swing.JButton();
        txtTimKiemKhuyenMai = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtNgayBatDauKhuyenMai = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtNgayKetThucKhuyenMai = new javax.swing.JTextField();
        txtMaKhuyenMai = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtPhanTramKhuyenMai = new javax.swing.JTextField();
        lblKhuyenMaiIcon = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDanhSachPhieuGiamGia = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        tabDichVu = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtGiaTienDichhVu = new javax.swing.JTextField();
        txtTenDichVu = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtDonVi = new javax.swing.JTextField();
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
        tblDanhSachDichVu = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        txtTimKiemDichVu = new javax.swing.JTextField();
        btnTimKiemDichVu = new javax.swing.JButton();
        tabKho = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lblSoluongnhap = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        lblSoluongxuat = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        lblTongSoHangHoa = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
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
        jLabel4 = new javax.swing.JLabel();
        cbbnhacc = new javax.swing.JComboBox<>();
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
        lblTongluonghanghoa = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tabHoaDon = new javax.swing.JPanel();
        pnlNenHoaDon = new javax.swing.JPanel();
        tabThemHoaDon = new javax.swing.JPanel();
        pnlNenThemHoaDon = new javax.swing.JPanel();
        pnlNenSanPham_DichVu = new javax.swing.JPanel();
        nenHoaDonThuCungSanPham = new javax.swing.JPanel();
        tabHoaDonSP = new javax.swing.JPanel();
        btnTimKiemSanPhamHoaDon = new javax.swing.JButton();
        txtTimKiemSanPhamHoaDon = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablDanhSachSanPhamHoaDon = new javax.swing.JTable();
        btnSangTabTC = new javax.swing.JButton();
        tabHoaDOnTC = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        txtTimKiemThuCungHoaDon = new javax.swing.JTextField();
        btnTimKiemThuCungHoaDon = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        tablDanhSachThuCungHoaDon = new javax.swing.JTable();
        jLabel87 = new javax.swing.JLabel();
        btnSangTabSP = new javax.swing.JButton();
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
        jButton1 = new javax.swing.JButton();
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
        tabbedHoaDon = new javax.swing.JPanel();
        tabbedSanPham_DichVu = new javax.swing.JPanel();
        lblHoaDonSanPham = new javax.swing.JLabel();
        lblHoaDonDichVu = new javax.swing.JLabel();
        lblHoaDonLichSu = new javax.swing.JLabel();
        tabThongKe = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        panelShadow3 = new com.app.Other.PanelShadow();
        chart = new com.app.Other.CurveLineChart();
        jPanel16 = new javax.swing.JPanel();
        pieChart = new com.app.Other.PieChart();
        cbonam = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tabTrangChu = new com.app.Other.ColorPanel();
        imageSlide = new com.app.Other.ImageSlide();
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
        jLabel44 = new javax.swing.JLabel();
        txtTimTenNhanVien = new javax.swing.JTextField();
        btnTimTenNhanVien = new javax.swing.JButton();
        cboLocVaiTroNhanVien = new javax.swing.JComboBox<>();
        cboLocTrangThaiNhanVien = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        pnlThongTinNguoiDung = new com.app.Other.ColorPanel();
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
        pnlMain.setPreferredSize(new java.awt.Dimension(1250, 670));

        pnlDanhSach.setBackground(new java.awt.Color(0, 51, 51));
        pnlDanhSach.setMinimumSize(new java.awt.Dimension(200, 600));
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

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Docaaaaaaa");

        lblLock.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLock.setForeground(new java.awt.Color(255, 255, 255));
        lblLock.setText("dd-mm-yyyy   hh-mm-ss");

        javax.swing.GroupLayout pnlTrangThaiLayout = new javax.swing.GroupLayout(pnlTrangThai);
        pnlTrangThai.setLayout(pnlTrangThaiLayout);
        pnlTrangThaiLayout.setHorizontalGroup(
            pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrangThaiLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLock, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTrangThaiLayout.setVerticalGroup(
            pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrangThaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTrangThaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblLock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
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

        tabSuKien.setPreferredSize(new java.awt.Dimension(1250, 563));

        jLabel7.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        jLabel7.setText("Chi tiết lịch đặt ");

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
        tblDanhSachSuKien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSuKienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachSuKien);

        btnSuKienThemLichDat1.setBackground(new java.awt.Color(0, 51, 51));
        btnSuKienThemLichDat1.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSuKienThemLichDat1.setForeground(new java.awt.Color(255, 255, 255));
        btnSuKienThemLichDat1.setText("Thêm lịch dặt");
        btnSuKienThemLichDat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuKienThemLichDat1ActionPerformed(evt);
            }
        });

        lblSuKienNgayHienTai.setText("now");

        cboSuKienLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSuKienLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabSuKienLayout = new javax.swing.GroupLayout(tabSuKien);
        tabSuKien.setLayout(tabSuKienLayout);
        tabSuKienLayout.setHorizontalGroup(
            tabSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSuKienLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblSuKienNgayHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(586, 586, 586)
                .addComponent(cboSuKienLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnSuKienThemLichDat1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(tabSuKienLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        tabSuKienLayout.setVerticalGroup(
            tabSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSuKienLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(tabSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSuKienNgayHienTai))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSuKienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboSuKienLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuKienThemLichDat1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnlCard.add(tabSuKien, "card3");

        tabThuCung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabThuCungMouseClicked(evt);
            }
        });

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
        cboGiongThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGiongThuCungActionPerformed(evt);
            }
        });

        jLabel34.setText("Giá Tiền");

        jLabel15.setText("Giống");

        jLabel30.setText("Giới tính");

        jLabel37.setText("Mã Thú Cưng");

        cboLoaiThuCung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLoaiThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiThuCungActionPerformed(evt);
            }
        });

        rdoGioiTinhCai.setText("Cái");

        jLabel29.setText("Tuổi");

        jLabel33.setText("Số Chuồng");

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
                            .addComponent(txtMaThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboSoChuongThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 157, Short.MAX_VALUE)))
                .addContainerGap())
        );
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
                    .addComponent(cboSoChuongThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel38.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        jLabel38.setText("Thông Tin Thú Cưng");

        jLabel32.setText("Hình Ảnh");

        lblThuoc.setText("Thuộc");

        txtMoTaThuCung.setColumns(20);
        txtMoTaThuCung.setRows(5);
        jScrollPane3.setViewportView(txtMoTaThuCung);

        jLabel31.setText("Mô Tả");

        lblHinhThuCung.setBackground(new java.awt.Color(204, 204, 204));
        lblHinhThuCung.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinhThuCung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhThuCungMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                        .addComponent(lblThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHinhThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblHinhThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThuoc)
                    .addComponent(txtThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        btnLamMoiThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiThuCungActionPerformed(evt);
            }
        });

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
        btnXoaThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaThuCungActionPerformed(evt);
            }
        });

        btnThemThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnThemThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnThemThuCung.setText("Thêm");
        btnThemThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuCungActionPerformed(evt);
            }
        });

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
        btnDauTienThuCung.setText("|<");
        btnDauTienThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauTienThuCungActionPerformed(evt);
            }
        });

        btnTruocThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnTruocThuCung.setText("<");

        btnSauThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnSauThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnSauThuCung.setText(">");

        btnCuoiCungThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnCuoiCungThuCung.setText(">|");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
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
                .addGap(103, 103, 103)
                .addComponent(btnDauTienThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTruocThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSauThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCuoiCungThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemThuCung)
                    .addComponent(btnXoaThuCung)
                    .addComponent(btnSuaThuCung)
                    .addComponent(btnLamMoiThuCung)
                    .addComponent(btnThemLoaiThuCung)
                    .addComponent(btnThemChuongThuCung)
                    .addComponent(btnDauTienThuCung)
                    .addComponent(btnTruocThuCung)
                    .addComponent(btnSauThuCung)
                    .addComponent(btnCuoiCungThuCung))
                .addContainerGap())
        );

        javax.swing.GroupLayout tabThongTinThuCungLayout = new javax.swing.GroupLayout(tabThongTinThuCung);
        tabThongTinThuCung.setLayout(tabThongTinThuCungLayout);
        tabThongTinThuCungLayout.setHorizontalGroup(
            tabThongTinThuCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongTinThuCungLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        tblDanhSachThuCung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mô Tả", "Mã TC", "Giá Tiền", "Tuổi", "Cân Nặng", "Mã Giống", "Giới Tính", "Thuộc", "Mã Chuồng", "Mã Loại", "Hình ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachThuCung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachThuCungMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDanhSachThuCung);

        jLabel40.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel40.setText("Tìm kiếm");

        btnTimKiemThuCung.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemThuCung.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemThuCung.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemThuCung.setText("Tìm");
        btnTimKiemThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemThuCungActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel43.setText("Thuộc");

        jLabel42.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel42.setText("Giống");

        cboLocSoHuuThuCung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel41.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel41.setText("Loài");

        cboLocLoaiThuCung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLocLoaiThuCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocLoaiThuCungActionPerformed(evt);
            }
        });

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
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

        tabKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabKhachHangMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("Danh Sách Khách Hàng");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jScrollPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane5MouseClicked(evt);
            }
        });

        tblDanhSachKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MaNV", "Tên Khách Hàng", "Giới Tính", "Email", "Số Điện Thoại", "Tích Điểm"
            }
        ));
        tblDanhSachKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachKhachHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDanhSachKhachHang);

        jLabel47.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel47.setText("Tìm Kiếm:");
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });

        txtTimKiemTenKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemTenKhachHangMouseClicked(evt);
            }
        });

        btnTimKiemKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemKhachHang.setText("Tìm");
        btnTimKiemKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemKhachHangMouseClicked(evt);
            }
        });
        btnTimKiemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKhachHangActionPerformed(evt);
            }
        });

        btnVeDauHoiVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVeDauHoiVienMouseClicked(evt);
            }
        });

        btnDauTienDanhSachKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienDanhSachKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnDauTienDanhSachKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnDauTienDanhSachKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauTienDanhSachKhachHangActionPerformed(evt);
            }
        });

        btnCuoiCungDanhSachKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungDanhSachKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungDanhSachKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnCuoiCungDanhSachKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiCungDanhSachKhachHangActionPerformed(evt);
            }
        });

        btnSauDanhSachKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnSauDanhSachKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauDanhSachKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnSauDanhSachKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauDanhSachKhachHangActionPerformed(evt);
            }
        });

        btnTruocDanhSachKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocDanhSachKhachHang.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocDanhSachKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnTruocDanhSachKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruocDanhSachKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnVeDauHoiVienLayout = new javax.swing.GroupLayout(btnVeDauHoiVien);
        btnVeDauHoiVien.setLayout(btnVeDauHoiVienLayout);
        btnVeDauHoiVienLayout.setHorizontalGroup(
            btnVeDauHoiVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVeDauHoiVienLayout.createSequentialGroup()
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
        btnVeDauHoiVienLayout.setVerticalGroup(
            btnVeDauHoiVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVeDauHoiVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnVeDauHoiVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
        btnThemKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemKhachHangMouseClicked(evt);
            }
        });
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
                                .addComponent(btnVeDauHoiVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(41, Short.MAX_VALUE))))
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
                    .addComponent(btnVeDauHoiVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pnlCard.add(tabKhachHang, "card12");

        tabSanPham.setPreferredSize(new java.awt.Dimension(1250, 563));
        tabSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabSanPhamMouseClicked(evt);
            }
        });

        txtGiaNhapSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNhapSanPhamtxtGiaNhapSanPhamActionPerformed(evt);
            }
        });

        jLabel60.setText("Giá Bán:");

        jLabel57.setText("Số Lượng:");

        txtDonViSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonViSanPhamActionPerformed(evt);
            }
        });

        cboTrangThaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang bán", "Hết hàng" }));
        cboTrangThaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiSanPhamActionPerformed(evt);
            }
        });

        txtMaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSanPhamActionPerformed(evt);
            }
        });

        jLabel54.setText("Mã Loại:");

        jLabel58.setText("Trạng Thái:");

        jLabel59.setText("Đơn vị tính:");

        jLabel53.setText("Mã Sản Phẩm:");

        jLabel55.setText("Tên Sản Phẩm:");

        jLabel56.setText("Giá Nhập:");

        jLabel20.setText("Mã Kho");

        txtMaKhoSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhoSanPhamActionPerformed(evt);
            }
        });

        jLabel39.setText("Mã Nhà Cung Cấp");

        txtMaNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhaCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel56)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel59)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54)
                            .addComponent(jLabel57)
                            .addComponent(jLabel60))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonViSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBanSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhapSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhoSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtMaLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtGiaNhapSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaBanSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(txtDonViSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(txtSoLuongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txtMaKhoSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(cboTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Mã Loại", "Tên Sản Phẩm", "Giá Nhập", "Giá Bán", "Đơn Vị Tính", "Số Lượng", "Mã Nhà Cung Cấp", "Mã Kho", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSanPhamMouseClicked(evt);
            }
        });
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
        btnTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSanPhamActionPerformed(evt);
            }
        });

        cboLocTrangThaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Đang bán", "Hết Hàng" }));
        cboLocTrangThaiSanPham.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLocTrangThaiSanPhamItemStateChanged(evt);
            }
        });
        cboLocTrangThaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboLocTrangThaiSanPhamMouseClicked(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel62.setText("Trạng Thái:");

        jLabel63.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        jLabel63.setText("Thông Tin Sản Phẩm");

        btnCuoiCungDanhSachSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungDanhSachSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungDanhSachSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnCuoiCungDanhSachSanPham.setText(">>");
        btnCuoiCungDanhSachSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiCungDanhSachSanPhamActionPerformed(evt);
            }
        });

        btnTruocDanhSachSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocDanhSachSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocDanhSachSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnTruocDanhSachSanPham.setText("<");
        btnTruocDanhSachSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruocDanhSachSanPhamActionPerformed(evt);
            }
        });

        btnXoaSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnXoaSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSanPham.setText("Xóa");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnThemSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnThemSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSanPham.setText("Thêm");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        btnSauDanhSachSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnSauDanhSachSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauDanhSachSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnSauDanhSachSanPham.setText(">");
        btnSauDanhSachSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauDanhSachSanPhamActionPerformed(evt);
            }
        });

        banLamMoiSanPham.setBackground(new java.awt.Color(0, 51, 51));
        banLamMoiSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        banLamMoiSanPham.setForeground(new java.awt.Color(255, 255, 255));
        banLamMoiSanPham.setText("Làm mới");
        banLamMoiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                banLamMoiSanPhamMouseClicked(evt);
            }
        });

        btnDauTienDanhSachSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienDanhSachSanPham.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnDauTienDanhSachSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnDauTienDanhSachSanPham.setText("<<");
        btnDauTienDanhSachSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauTienDanhSachSanPhamActionPerformed(evt);
            }
        });

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
        btnSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamActionPerformed(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabSanPhamLayout = new javax.swing.GroupLayout(tabSanPham);
        tabSanPham.setLayout(tabSanPhamLayout);
        tabSanPhamLayout.setHorizontalGroup(
            tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabSanPhamLayout.createSequentialGroup()
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabSanPhamLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
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
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        tabSanPhamLayout.setVerticalGroup(
            tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSanPhamLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLocTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel61)
                                .addComponent(txtTimKiemTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTimKiemSanPham)))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addGap(18, 18, 18)))
                .addGroup(tabSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pnlCard.add(tabSanPham, "card10");

        tabKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabKhuyenMaiMouseClicked(evt);
            }
        });

        cboLocTrangThaiKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trạng Thái ", "Còn Hạn", "Hết Hạn" }));
        cboLocTrangThaiKhuyenMai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLocTrangThaiKhuyenMaiItemStateChanged(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel14.setText("Trạng Thái:");

        btnCuoiCungDanhSachKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungDanhSachKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungDanhSachKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnCuoiCungDanhSachKhuyenMai.setText(">>");
        btnCuoiCungDanhSachKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiCungDanhSachKhuyenMaiActionPerformed(evt);
            }
        });

        btnSauDanhSachKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnSauDanhSachKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauDanhSachKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnSauDanhSachKhuyenMai.setText(">");
        btnSauDanhSachKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauDanhSachKhuyenMaiActionPerformed(evt);
            }
        });

        btnTruocDanhSachKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocDanhSachKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocDanhSachKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnTruocDanhSachKhuyenMai.setText("<");

        btnDauTienDanhSachKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienDanhSachKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnDauTienDanhSachKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnDauTienDanhSachKhuyenMai.setText("<<");
        btnDauTienDanhSachKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauTienDanhSachKhuyenMaiActionPerformed(evt);
            }
        });

        btnLamMoiKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnLamMoiKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiKhuyenMai.setText("Làm mới");
        btnLamMoiKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiKhuyenMaiActionPerformed(evt);
            }
        });

        btnSuaKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnSuaKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSuaKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaKhuyenMai.setText("Sửa");
        btnSuaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKhuyenMaiActionPerformed(evt);
            }
        });

        btnXoaKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnXoaKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnXoaKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaKhuyenMai.setText("Xóa");
        btnXoaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhuyenMaiActionPerformed(evt);
            }
        });

        btnThemKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnThemKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKhuyenMai.setText("Thêm");
        btnThemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhuyenMaiActionPerformed(evt);
            }
        });

        btnTimKiemKhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemKhuyenMai.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemKhuyenMai.setText("Tìm");
        btnTimKiemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKhuyenMaiActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel52.setText("Tìm kiếm:");

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
                        .addComponent(txtNgayKetThucKhuyenMai)))
                .addContainerGap())
        );
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
                    .addComponent(txtNgayKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblDanhSachPhieuGiamGia.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhSachPhieuGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhieuGiamGiaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblDanhSachPhieuGiamGia);

        jLabel10.setFont(new java.awt.Font("Source Sans Pro Black", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("Khuyến Mãi");

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
                        .addGap(248, 248, 248)
                        .addComponent(btnDauTienDanhSachKhuyenMai)
                        .addGap(18, 18, 18)
                        .addComponent(btnTruocDanhSachKhuyenMai)
                        .addGap(18, 18, 18)
                        .addComponent(btnSauDanhSachKhuyenMai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCuoiCungDanhSachKhuyenMai)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tabKhuyenMaiLayout.createSequentialGroup()
                        .addGroup(tabKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabKhuyenMaiLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabKhuyenMaiLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
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
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pnlCard.add(tabKhuyenMai, "card6");

        tabDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabDichVuMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 24)); // NOI18N
        jLabel12.setText("Thông Tin Dịch Vụ");

        jLabel65.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N
        jLabel65.setText("Tên Dịch Vụ:");

        jLabel66.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N
        jLabel66.setText("Đơn Vị:");

        txtGiaTienDichhVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N

        txtTenDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N

        jLabel67.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N
        jLabel67.setText("Giá Tiền:");

        txtDonVi.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 14)); // NOI18N
        txtDonVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonViActionPerformed(evt);
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
                    .addComponent(txtGiaTienDichhVu, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
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
                    .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(txtGiaTienDichhVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnLamMoiDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnLamMoiDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiDichVu.setText("Làm mới");
        btnLamMoiDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiDichVuActionPerformed(evt);
            }
        });

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
        btnXoaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDichVuActionPerformed(evt);
            }
        });

        btnThemDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnThemDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnThemDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnThemDichVu.setText("Thêm");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        btnDauTienDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnDauTienDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnDauTienDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnDauTienDichVu.setText("<<");
        btnDauTienDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauTienDichVuActionPerformed(evt);
            }
        });

        btnTruocDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnTruocDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnTruocDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnTruocDichVu.setText("<");
        btnTruocDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruocDichVuActionPerformed(evt);
            }
        });

        btnSauDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnSauDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnSauDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnSauDichVu.setText(">");
        btnSauDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSauDichVuActionPerformed(evt);
            }
        });

        btnCuoiCungDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnCuoiCungDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 12)); // NOI18N
        btnCuoiCungDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnCuoiCungDichVu.setText(">>");
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
                .addComponent(btnDauTienDichVu)
                .addGap(18, 18, 18)
                .addComponent(btnTruocDichVu)
                .addGap(18, 18, 18)
                .addComponent(btnSauDichVu)
                .addGap(18, 18, 18)
                .addComponent(btnCuoiCungDichVu)
                .addContainerGap(100, Short.MAX_VALUE))
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

        tblDanhSachDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã DV", "Tên DV", "Ngày bắt đầu", "Ngày Kết thúc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachDichVuMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblDanhSachDichVu);

        jLabel68.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 14)); // NOI18N
        jLabel68.setText("Tìm kiếm:");

        btnTimKiemDichVu.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemDichVu.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemDichVu.setText("Tìm");
        btnTimKiemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDichVuActionPerformed(evt);
            }
        });

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
                .addContainerGap(33, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE))
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

        tabKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabKhoMouseClicked(evt);
            }
        });

        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Source Sans Pro Black", 0, 24)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 51, 51));
        jLabel92.setText("Kho");

        jLabel97.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel97.setText("Tổng nhập");

        jPanel19.setBackground(new java.awt.Color(204, 204, 0));

        lblSoluongnhap.setFont(new java.awt.Font("Source Sans Pro Light", 1, 18)); // NOI18N
        lblSoluongnhap.setText("0");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\My Xen\\Documents\\NetBeansProjects\\PetShop\\src\\main\\java\\com\\app\\Img\\correct.png")); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(lblSoluongnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblSoluongnhap)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );

        jLabel99.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel99.setText("Tổng hàng hóa");

        jPanel25.setBackground(new java.awt.Color(255, 51, 0));

        lblSoluongxuat.setFont(new java.awt.Font("Source Sans Pro Light", 1, 18)); // NOI18N
        lblSoluongxuat.setText("0");

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\My Xen\\Documents\\NetBeansProjects\\PetShop\\src\\main\\java\\com\\app\\Img\\procurement.png")); // NOI18N
        jLabel17.setPreferredSize(new java.awt.Dimension(38, 16));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(lblSoluongxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblSoluongxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );

        lbl.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        lbl.setText("Tổng xuất");

        jLabel102.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel102.setText("Tổng số lượng hàng hóa");

        jPanel26.setBackground(new java.awt.Color(255, 102, 102));

        lblTongSoHangHoa.setFont(new java.awt.Font("Source Sans Pro Light", 1, 18)); // NOI18N
        lblTongSoHangHoa.setText("0");

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\My Xen\\Documents\\NetBeansProjects\\PetShop\\src\\main\\java\\com\\app\\Img\\boxes.png")); // NOI18N
        jLabel18.setPreferredSize(new java.awt.Dimension(38, 16));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(lblTongSoHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblTongSoHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        btnThemNhapHang.setText("Nhập");
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
        tbllDachSachNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbllDachSachNhapHangMouseClicked(evt);
            }
        });
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
        btnCuoiCungNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiCungNhapHangActionPerformed(evt);
            }
        });

        txtSoLuonngHangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuonngHangNhapActionPerformed(evt);
            }
        });

        jLabel105.setText("Số Lượng");

        jLabel98.setText("Mã Nhập Hàng");

        jLabel4.setText("Nhà Cung Cấp");

        cbbnhacc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
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
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(btnThemNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63)
                            .addComponent(btnXoaNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                            .addComponent(btnMoiNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSoLuonngHangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                .addComponent(cbbnhacc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(4, 4, 4)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnDauTienNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTruocNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSauNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCuoiCungNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel105, jLabel90, jLabel94, jLabel95, jLabel98});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
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
                            .addComponent(txtSoLuonngHangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(cbbnhacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSuaNhapHang)
                                    .addComponent(btnDauTienNhapHang)
                                    .addComponent(btnTruocNhapHang)
                                    .addComponent(btnSauNhapHang)
                                    .addComponent(btnCuoiCungNhapHang)))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXoaNhapHang)
                                    .addComponent(btnThemNhapHang))))
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoiNhapHang)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
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

        jPanel30.setBackground(new java.awt.Color(51, 51, 255));

        lblTongluonghanghoa.setFont(new java.awt.Font("Source Sans Pro Light", 1, 18)); // NOI18N
        lblTongluonghanghoa.setText("0");

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\My Xen\\Documents\\NetBeansProjects\\PetShop\\src\\main\\java\\com\\app\\Img\\hop.png")); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(38, 16));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongluonghanghoa, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblTongluonghanghoa)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel97)))
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGap(164, 164, 164)
                                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(165, 165, 165)
                                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl)
                                        .addGap(248, 248, 248)
                                        .addComponent(jLabel99)
                                        .addGap(182, 182, 182)))
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel102)
                                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(141, 141, 141))
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel92)
                .addGap(14, 14, 14)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel99, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl)
                                .addComponent(jLabel97)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
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

        pnlNenHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlNenHoaDonMouseClicked(evt);
            }
        });
        pnlNenHoaDon.setLayout(new java.awt.CardLayout());

        pnlNenSanPham_DichVu.setLayout(new java.awt.CardLayout());

        nenHoaDonThuCungSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nenHoaDonThuCungSanPhamMouseClicked(evt);
            }
        });
        nenHoaDonThuCungSanPham.setLayout(new java.awt.CardLayout());

        btnTimKiemSanPhamHoaDon.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemSanPhamHoaDon.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemSanPhamHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemSanPhamHoaDon.setText("Tìm");
        btnTimKiemSanPhamHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSanPhamHoaDonActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel70.setText("Sản Phẩm:");

        jLabel72.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel72.setText("Tìm kiếm");

        tablDanhSachSanPhamHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablDanhSachSanPhamHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablDanhSachSanPhamHoaDonMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tablDanhSachSanPhamHoaDon);

        btnSangTabTC.setBackground(new java.awt.Color(0, 51, 51));
        btnSangTabTC.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnSangTabTC.setForeground(new java.awt.Color(255, 255, 255));
        btnSangTabTC.setText("Chọn Thú Cưng");
        btnSangTabTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSangTabTCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabHoaDonSPLayout = new javax.swing.GroupLayout(tabHoaDonSP);
        tabHoaDonSP.setLayout(tabHoaDonSPLayout);
        tabHoaDonSPLayout.setHorizontalGroup(
            tabHoaDonSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabHoaDonSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabHoaDonSPLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSangTabTC, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiemSanPhamHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnTimKiemSanPhamHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addComponent(jScrollPane9))
                .addContainerGap())
        );
        tabHoaDonSPLayout.setVerticalGroup(
            tabHoaDonSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabHoaDonSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(txtTimKiemSanPhamHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemSanPhamHoaDon)
                    .addComponent(jLabel70)
                    .addComponent(btnSangTabTC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        nenHoaDonThuCungSanPham.add(tabHoaDonSP, "card2");

        jLabel79.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel79.setText("Tìm kiếm");

        btnTimKiemThuCungHoaDon.setBackground(new java.awt.Color(0, 51, 51));
        btnTimKiemThuCungHoaDon.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnTimKiemThuCungHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemThuCungHoaDon.setText("Tìm");

        tablDanhSachThuCungHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablDanhSachThuCungHoaDon.setToolTipText("");
        tablDanhSachThuCungHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablDanhSachThuCungHoaDonMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tablDanhSachThuCungHoaDon);

        jLabel87.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel87.setText("Thú cưng:");

        btnSangTabSP.setBackground(new java.awt.Color(0, 51, 51));
        btnSangTabSP.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnSangTabSP.setForeground(new java.awt.Color(255, 255, 255));
        btnSangTabSP.setText("Chọn Sản Phẩm");
        btnSangTabSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSangTabSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabHoaDOnTCLayout = new javax.swing.GroupLayout(tabHoaDOnTC);
        tabHoaDOnTC.setLayout(tabHoaDOnTCLayout);
        tabHoaDOnTCLayout.setHorizontalGroup(
            tabHoaDOnTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDOnTCLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSangTabSP, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(760, Short.MAX_VALUE))
            .addGroup(tabHoaDOnTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tabHoaDOnTCLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(tabHoaDOnTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabHoaDOnTCLayout.createSequentialGroup()
                            .addGap(464, 464, 464)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTimKiemThuCungHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(btnTimKiemThuCungHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27))
                        .addComponent(jScrollPane16))
                    .addContainerGap()))
        );
        tabHoaDOnTCLayout.setVerticalGroup(
            tabHoaDOnTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDOnTCLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(tabHoaDOnTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(btnSangTabSP))
                .addContainerGap(219, Short.MAX_VALUE))
            .addGroup(tabHoaDOnTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tabHoaDOnTCLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(tabHoaDOnTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel79)
                        .addComponent(txtTimKiemThuCungHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiemThuCungHoaDon))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        nenHoaDonThuCungSanPham.add(tabHoaDOnTC, "card3");

        pnlNenSanPham_DichVu.add(nenHoaDonThuCungSanPham, "card2");

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

        txtMaDatDichVu.setEnabled(false);
        txtMaDatDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDatDichVuActionPerformed(evt);
            }
        });

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

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabHoaDonDichVuLayout = new javax.swing.GroupLayout(tabHoaDonDichVu);
        tabHoaDonDichVu.setLayout(tabHoaDonDichVuLayout);
        tabHoaDonDichVuLayout.setHorizontalGroup(
            tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                        .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongDichVu))))
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel83, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel85, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(43, 43, 43)
                        .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayDatDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                            .addComponent(txtNgayNhanThuCung)
                            .addComponent(txtSoDienThoaiDatLich)))
                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemDatLich, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(btnSuaDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoiDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
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
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(cboTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85)
                    .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel84)
                        .addComponent(txtSoLuongDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSoDienThoaiDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabHoaDonDichVuLayout.createSequentialGroup()
                        .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemDatLich)
                            .addComponent(btnSuaDatLich)
                            .addComponent(btnLamMoiDatLich))
                        .addGap(12, 12, 12)
                        .addComponent(jButton1))
                    .addGroup(tabHoaDonDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel82)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
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

        cboLoaiKhachHangHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiKhachHangHoaDonActionPerformed(evt);
            }
        });

        txtMaHoaDon.setEnabled(false);

        txtMaNhanVienHoaDon.setEnabled(false);

        txtTongTienHoaDon.setEnabled(false);

        txtTienNhanHoaDon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTienNhanHoaDonFocusLost(evt);
            }
        });
        txtTienNhanHoaDon.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtTienNhanHoaDonCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtTienNhanHoaDonInputMethodTextChanged(evt);
            }
        });

        txtTienThuaHoaDon.setEnabled(false);

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
                                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel81)
                                    .addComponent(jLabel77))
                                .addGap(18, 18, 18)
                                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtTienThuaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                            .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                                    .addComponent(txtMaNhanVienHoaDon)))
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
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pnlHoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHoaDonChiTietMouseClicked(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel74.setText("Khuyến mãi:");

        cboKhuyenMaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Phiếu Giảm Giá" }));

        tblDanhSahChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDanhSahChiTietHoaDon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblDanhSahChiTietHoaDonFocusLost(evt);
            }
        });
        tblDanhSahChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSahChiTietHoaDonMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblDanhSahChiTietHoaDon);

        btnLamMoiChiTietHoaDon.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoiChiTietHoaDon.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        btnLamMoiChiTietHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiChiTietHoaDon.setText("Làm mới");
        btnLamMoiChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiChiTietHoaDonActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane10)
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
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlNenThemHoaDonLayout = new javax.swing.GroupLayout(pnlNenThemHoaDon);
        pnlNenThemHoaDon.setLayout(pnlNenThemHoaDonLayout);
        pnlNenThemHoaDonLayout.setHorizontalGroup(
            pnlNenThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNenThemHoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlNenThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlNenSanPham_DichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHoaDonChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGap(0, 1263, Short.MAX_VALUE)
            .addGroup(tabThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tabThemHoaDonLayout.createSequentialGroup()
                    .addComponent(pnlNenThemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 1251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 12, Short.MAX_VALUE)))
        );
        tabThemHoaDonLayout.setVerticalGroup(
            tabThemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
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
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlNenHoaDon.add(tabXemLichSuHoaDon, "card3");

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

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 1239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thông Kê Theo Tháng", jPanel4);

        pieChart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbonam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbonamActionPerformed(evt);
            }
        });
        pieChart.add(cbonam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, -1, -1));

        jLabel11.setText("Năm");
        pieChart.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, -1, 20));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pieChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pieChart, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thống Kế Doanh Thu Từng Ngành Kinh Doanh", jPanel16);

        javax.swing.GroupLayout tabThongKeLayout = new javax.swing.GroupLayout(tabThongKe);
        tabThongKe.setLayout(tabThongKeLayout);
        tabThongKeLayout.setHorizontalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1251, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabThongKeLayout.setVerticalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pnlCard.add(tabThongKe, "card5");

        tabTrangChu.setPreferredSize(new java.awt.Dimension(1250, 563));

        javax.swing.GroupLayout tabTrangChuLayout = new javax.swing.GroupLayout(tabTrangChu);
        tabTrangChu.setLayout(tabTrangChuLayout);
        tabTrangChuLayout.setHorizontalGroup(
            tabTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTrangChuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageSlide, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        tabTrangChuLayout.setVerticalGroup(
            tabTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTrangChuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageSlide, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        pnlCard.add(tabTrangChu, "card2");

        tabNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        tabNhanVien.setPreferredSize(new java.awt.Dimension(1250, 600));
        tabNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabNhanVienMouseClicked(evt);
            }
        });

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
        tblDanhSachNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSachNhanVien);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setText("Mã Nhân Viên");

        jLabel27.setText("Vai Trò");

        rdoVaiTroNhanVien.setText("Nhân Viên");

        jLabel22.setText("Họ Tên");

        rdoVaiTroQuanLy.setText("Quản Lý");

        jLabel26.setText("Trạng Thái");

        jLabel24.setText("Số Điện Thoại");

        jLabel25.setText("Email");

        rdoNamNhanVien.setText("Nam");

        cboTrangThaiNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setText("Giới Tính");

        rdoNuNhanVien.setText("Nữ");

        txtMaNhanVien.setToolTipText("Mã Nhân Viên");

        jLabel28.setText("Ngày Sinh");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE))
                    .addComponent(txtNgaySinhNhanVien))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtHoTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(rdoNamNhanVien)
                    .addComponent(rdoNuNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtEmailNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cboTrangThaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(rdoVaiTroNhanVien)
                    .addComponent(rdoVaiTroQuanLy))
                .addContainerGap())
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
                .addGap(233, 233, 233)
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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoiNhanVien)
                    .addComponent(btnSuaNhanVien)
                    .addComponent(btnXoaNhanVien)
                    .addComponent(btnThemNhanVien)
                    .addComponent(btnDauTienDanhSachNhanVien)
                    .addComponent(btnTruocDanhSachNhanVien)
                    .addComponent(btnSauDanhSachNhanVien)
                    .addComponent(btnCuoiCungDanhSachNhanVien)))
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

        cboLocTrangThaiNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocTrangThaiNhanVienActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel45.setText("Vai Trò:");

        jLabel46.setFont(new java.awt.Font("Source Sans Pro SemiBold", 1, 12)); // NOI18N
        jLabel46.setText("Trạng Thái:");

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
                        .addGap(87, 87, 87)
                        .addComponent(jLabel8))
                    .addGroup(tabNhanVienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
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
                        .addGroup(tabNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblHinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTaiKhoanNhanVien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pnlCard.add(tabNhanVien, "card4");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlThongTinNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(pnlTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlThongTinNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 39, Short.MAX_VALUE)
                .addComponent(pnlTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        pnlMain.getAccessibleContext().setAccessibleName("");

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
        evt.consume();

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
        lblSuKienNgayHienTai.setText("(" + XDate.toString(new Date(), "dd-MM-yyyy") + ")");
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
        evt.consume();
        openMenuThongTinNguoiDung();
        setComponentZOrder(pnlThongTinNguoiDung, 0);

    }//GEN-LAST:event_lblUserIconMouseClicked

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

    private void lblNhapHang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhapHang1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNhapHang1MouseClicked

    private void txtTenHangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenHangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHangNhapActionPerformed

    private void txtDonViHangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonViHangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonViHangNhapActionPerformed

    private void btnThemNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhapHangActionPerformed
        nhapHang();
    }//GEN-LAST:event_btnThemNhapHangActionPerformed

    private void btnSuaNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNhapHangActionPerformed
        suaHang();
    }//GEN-LAST:event_btnSuaNhapHangActionPerformed

    private void btnXoaNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhapHangActionPerformed
        xoaSoLuong();
    }//GEN-LAST:event_btnXoaNhapHangActionPerformed

    private void btnMoiNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiNhapHangActionPerformed
        xoathongtinBangKhoHang();
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

    private void btnSauDanhSachNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauDanhSachNhanVienActionPerformed
        SauNhanVien();
    }//GEN-LAST:event_btnSauDanhSachNhanVienActionPerformed

    private void btnTaiKhoanNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanNhanVienActionPerformed
        row = 0;
        String maNhanVien = (String) tblDanhSachNhanVien.getValueAt(this.row, 1);
        new ThongTinTaiKhoanJDialog(this, true, maNhanVien).setVisible(true);
    }//GEN-LAST:event_btnTaiKhoanNhanVienActionPerformed

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        rowHV = 0;
        String maNV = (String) tblDanhSachNhanVien.getValueAt(rowHV, 1);
        new HoiVienJDialog(this, true, maNV).setVisible(true);
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void lblDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMatKhauMouseClicked
        // TODO add your handling code here:
        new DoiMatKhauJDialog(this, true).setVisible(true);

    }//GEN-LAST:event_lblDoiMatKhauMouseClicked


    private void btnDauTienDanhSachKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauTienDanhSachKhachHangActionPerformed
        this.dauTienKhachHang();
    }//GEN-LAST:event_btnDauTienDanhSachKhachHangActionPerformed

    private void btnTruocDanhSachKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruocDanhSachKhachHangActionPerformed
        this.TruocKhachHang();
    }//GEN-LAST:event_btnTruocDanhSachKhachHangActionPerformed

    private void btnSauDanhSachKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauDanhSachKhachHangActionPerformed
        this.SauKhachHang();
    }//GEN-LAST:event_btnSauDanhSachKhachHangActionPerformed

    private void btnCuoiCungDanhSachKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiCungDanhSachKhachHangActionPerformed
        this.cuoiCungKhachHang();
    }//GEN-LAST:event_btnCuoiCungDanhSachKhachHangActionPerformed

    private void tblDanhSachKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachKhachHangMouseClicked
        evt.consume();
        rowHV = tblDanhSachKhachHang.getSelectedRow();
        rowHV = tblDanhSachKhachHang.rowAtPoint(evt.getPoint());
        Object value = tblDanhSachKhachHang.getValueAt(rowHV, 1);
        System.out.println(rowHV);
        System.out.println(String.valueOf(value));
        new HoiVienJDialog(this, true, String.valueOf(value)).setVisible(true);
    }//GEN-LAST:event_tblDanhSachKhachHangMouseClicked

    private void btnTimKiemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKhachHangActionPerformed
        this.taidulieuDanhSachKhachHang();

    }//GEN-LAST:event_btnTimKiemKhachHangActionPerformed

    private void tbllDachSachNhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbllDachSachNhapHangMouseClicked
        viTriKhoHang = tbllDachSachNhapHang.getSelectedRow();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tbllDachSachNhapHang.getModel();
        Object value = model.getValueAt(viTriKhoHang, 4);
        soluong = value.toString();
        System.out.println(soluong);
        inThongTinKhoHang(viTriKhoHang);
    }//GEN-LAST:event_tbllDachSachNhapHangMouseClicked

    private void btnCuoiCungNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiCungNhapHangActionPerformed
        cuoiCungKhoHang();
    }//GEN-LAST:event_btnCuoiCungNhapHangActionPerformed

    private void cbonamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbonamActionPerformed
        int nam = (int) cbonam.getSelectedItem();
        thongKeKinhDoanh(nam);
    }//GEN-LAST:event_cbonamActionPerformed

    private void btnTimTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimTenNhanVienActionPerformed
        taiDuLieuNhanVien();
    }//GEN-LAST:event_btnTimTenNhanVienActionPerformed

    private void btnXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhanVienActionPerformed
        xoaNhanVien();
    }//GEN-LAST:event_btnXoaNhanVienActionPerformed

    private void btnSuaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNhanVienActionPerformed
        capNhatNhanVien();
    }//GEN-LAST:event_btnSuaNhanVienActionPerformed

    private void btnLamMoiNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiNhanVienActionPerformed
        lamMoiNhanVien();
    }//GEN-LAST:event_btnLamMoiNhanVienActionPerformed

    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed
        ThemNhanVien();
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void tblDanhSachNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachNhanVienMouseClicked
        this.row = tblDanhSachNhanVien.getSelectedRow();
        System.out.println(txtHoTenNhanVien.getText());
        edit();
    }//GEN-LAST:event_tblDanhSachNhanVienMouseClicked

    private void lblHinhNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhNhanVienMouseClicked
        chonHinhNhanVien();
    }//GEN-LAST:event_lblHinhNhanVienMouseClicked

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        txtTimTenNhanVien.setText("");
        taiDuLieuNhanVien();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void cboLocTrangThaiNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocTrangThaiNhanVienActionPerformed
        locDuLieuNhanVien();
    }//GEN-LAST:event_cboLocTrangThaiNhanVienActionPerformed

    private void btnCuoiCungDanhSachNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiCungDanhSachNhanVienActionPerformed
        cuoiCungNhanVien();
    }//GEN-LAST:event_btnCuoiCungDanhSachNhanVienActionPerformed

    private void btnDauTienDanhSachNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauTienDanhSachNhanVienActionPerformed
        dauTienNhanVien();
    }//GEN-LAST:event_btnDauTienDanhSachNhanVienActionPerformed

    private void btnTruocDanhSachNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruocDanhSachNhanVienActionPerformed
        TruocNhanVien();
    }//GEN-LAST:event_btnTruocDanhSachNhanVienActionPerformed

    private void tabKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabKhachHangMouseClicked
        evt.consume();
    }//GEN-LAST:event_tabKhachHangMouseClicked

    private void txtGiaNhapSanPhamtxtGiaNhapSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapSanPhamtxtGiaNhapSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaNhapSanPhamtxtGiaNhapSanPhamActionPerformed

    private void txtDonViSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonViSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonViSanPhamActionPerformed

    private void cboTrangThaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTrangThaiSanPhamActionPerformed

    private void txtMaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSanPhamActionPerformed

    private void txtMaKhoSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhoSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhoSanPhamActionPerformed

    private void txtMaNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhaCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhaCCActionPerformed

    private void tblDanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSanPhamMouseClicked
        if (evt.getClickCount() == 2) {
            this.ViTriSanPham = tblDanhSachSanPham.rowAtPoint(evt.getPoint());
            if (this.ViTriSanPham >= 0) {
                this.editSP();
            }
        }
    }//GEN-LAST:event_tblDanhSachSanPhamMouseClicked

    private void txtTimKiemTenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemTenSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemTenSanPhamActionPerformed

    private void btnTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSanPhamActionPerformed
        this.taiDuLieuSP();
    }//GEN-LAST:event_btnTimKiemSanPhamActionPerformed

    private void cboLocTrangThaiSanPhamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLocTrangThaiSanPhamItemStateChanged
        this.taiDuLieuSP();
    }//GEN-LAST:event_cboLocTrangThaiSanPhamItemStateChanged

    private void cboLocTrangThaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboLocTrangThaiSanPhamMouseClicked

    }//GEN-LAST:event_cboLocTrangThaiSanPhamMouseClicked

    private void btnCuoiCungDanhSachSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiCungDanhSachSanPhamActionPerformed
        cuoiCungSamPham();
    }//GEN-LAST:event_btnCuoiCungDanhSachSanPhamActionPerformed

    private void btnTruocDanhSachSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruocDanhSachSanPhamActionPerformed
        TruocSanPham();
    }//GEN-LAST:event_btnTruocDanhSachSanPhamActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed

        this.xoaSP();
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        try {

            if (kiemTraSP()) {
                this.themSP();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi, Vui lòng xem lại");
        }
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnSauDanhSachSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauDanhSachSanPhamActionPerformed
        SauSanPham();
    }//GEN-LAST:event_btnSauDanhSachSanPhamActionPerformed

    private void banLamMoiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_banLamMoiSanPhamMouseClicked
        this.xoaDuLieuSP();
    }//GEN-LAST:event_banLamMoiSanPhamMouseClicked

    private void btnDauTienDanhSachSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauTienDanhSachSanPhamActionPerformed
        dauTienSanPham();
    }//GEN-LAST:event_btnDauTienDanhSachSanPhamActionPerformed

    private void btnThemMoiLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiLoaiSanPhamActionPerformed
        // TODO add your handling code here:
        new ThemMoiLoaiJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnThemMoiLoaiSanPhamActionPerformed

    private void btnSuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSanPhamActionPerformed
        if (kiemTraSP()) {
            this.capNhatSP();
        }
    }//GEN-LAST:event_btnSuaSanPhamActionPerformed

    private void btnTimKiemSanPhamHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSanPhamHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemSanPhamHoaDonActionPerformed

    private void btnSangTabTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSangTabTCActionPerformed
        // TODO add your handling code here:
        tabHoaDOnTC.setVisible(true);
        tabHoaDonSP.setVisible(false);
        TieuDeBangThuCung();
        ThuCungHoaDon();
    }//GEN-LAST:event_btnSangTabTCActionPerformed

    private void btnSangTabSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSangTabSPActionPerformed
        // TODO add your handling code here:
        tabHoaDOnTC.setVisible(false);
        tabHoaDonSP.setVisible(true);
        TieuDeBangSanPhamHoaDon();
        SanPhamHoaDon();
    }//GEN-LAST:event_btnSangTabSPActionPerformed

    private void nenHoaDonThuCungSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nenHoaDonThuCungSanPhamMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_nenHoaDonThuCungSanPhamMouseClicked

    private void txtMaDatDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDatDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDatDichVuActionPerformed

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

    private void tabXemLichSuHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabXemLichSuHoaDonMouseClicked
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_tabXemLichSuHoaDonMouseClicked

    private void lblHoaDonSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonSanPhamMouseClicked
        // TODO add your handling code here:
        nenHoaDonThuCungSanPham.setVisible(true);
        tabHoaDonDichVu.setVisible(false);
    }//GEN-LAST:event_lblHoaDonSanPhamMouseClicked

    private void lblHoaDonDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonDichVuMouseClicked
        // TODO add your handling code here:
        tabThemHoaDon.setVisible(true);
        nenHoaDonThuCungSanPham.setVisible(false);
        tabHoaDonDichVu.setVisible(true);
    }//GEN-LAST:event_lblHoaDonDichVuMouseClicked

    private void lblHoaDonLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoaDonLichSuMouseClicked
        // TODO add your handling code here:
        tabThemHoaDon.setVisible(false);
        tabXemLichSuHoaDon.setVisible(true);
    }//GEN-LAST:event_lblHoaDonLichSuMouseClicked

    private void pnlNenHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNenHoaDonMouseClicked
        evt.consume();
    }//GEN-LAST:event_pnlNenHoaDonMouseClicked

    private void cboLoaiKhachHangHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiKhachHangHoaDonActionPerformed
        String LoaiHoiVien = (String) cboLoaiKhachHangHoaDon.getSelectedItem();
        boolean Loai = !LoaiHoiVien.equals("Khách Vãn Lai");
        HoiVienHoaDon(Loai);
    }//GEN-LAST:event_cboLoaiKhachHangHoaDonActionPerformed

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

    private void rdoGioiTinhDucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoGioiTinhDucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoGioiTinhDucActionPerformed

    private void cboGiongThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGiongThuCungActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboGiongThuCungActionPerformed

    private void cboLoaiThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiThuCungActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboLoaiThuCungActionPerformed

    private void lblHinhThuCungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhThuCungMouseClicked
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser("C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\PetShop\\src\\main\\java\\com\\app\\img");
        int result = jf.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                //lấy tên hình
                String fileName = jf.getSelectedFile().getName();
                lblHinhThuCung.setText(fileName);

                ImageIcon imageIcon = new ImageIcon(jf.getSelectedFile().getAbsolutePath());

                Image scaledImage = imageIcon.getImage().getScaledInstance(lblHinhThuCung.getWidth(), lblHinhThuCung.getHeight(), Image.SCALE_SMOOTH);

                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                lblHinhThuCung.setIcon(scaledIcon);
                TaiDuLieuThuCung();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_lblHinhThuCungMouseClicked

    private void btnThemChuongThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChuongThuCungActionPerformed
        // TODO add your handling code here:
        new ThemMoiChuongJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnThemChuongThuCungActionPerformed

    private void btnLamMoiThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiThuCungActionPerformed
        // TODO add your handling code here:
        clearThuCung();
    }//GEN-LAST:event_btnLamMoiThuCungActionPerformed

    private void btnSuaThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThuCungActionPerformed
        // TODO add your handling code here:
        updateThuCung();
    }//GEN-LAST:event_btnSuaThuCungActionPerformed

    private void btnXoaThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaThuCungActionPerformed
        // TODO add your handling code here:
        deleteThuCung();
    }//GEN-LAST:event_btnXoaThuCungActionPerformed

    private void btnThemThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuCungActionPerformed
        // TODO add your handling code here:
        insertThuCung();
    }//GEN-LAST:event_btnThemThuCungActionPerformed

    private void btnThemLoaiThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiThuCungActionPerformed
        // TODO add your handling code here:
        new ThemMoiLoaiJVatDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btnThemLoaiThuCungActionPerformed

    private void btnDauTienThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauTienThuCungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDauTienThuCungActionPerformed

    private void tblDanhSachThuCungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachThuCungMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.thucung = tblDanhSachThuCung.rowAtPoint(evt.getPoint());
            tabThongTinThuCung.setVisible(true);
            tabDanhSachThuCung.setVisible(false);
            if (this.thucung >= 0) {
                this.editThuCung();
                int selectTable = tblDanhSachThuCung.getSelectedRow();
                displayImage(selectTable);
            }
        }
    }//GEN-LAST:event_tblDanhSachThuCungMouseClicked

    private void btnTimKiemThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemThuCungActionPerformed
        // TODO add your handling code here:
        TimKiemThuCung(txtTimKiemThuCung.getText());
    }//GEN-LAST:event_btnTimKiemThuCungActionPerformed

    private void cboLocLoaiThuCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocLoaiThuCungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLocLoaiThuCungActionPerformed

    private void txtDonViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonViActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonViActionPerformed

    private void btnLamMoiDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiDichVuActionPerformed
        xoaformDichVu();
    }//GEN-LAST:event_btnLamMoiDichVuActionPerformed

    private void btnSuaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDichVuActionPerformed
        capnhatDichVu();

    }//GEN-LAST:event_btnSuaDichVuActionPerformed

    private void btnXoaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDichVuActionPerformed
        xoaDichVu();
        xoaformDichVu();
    }//GEN-LAST:event_btnXoaDichVuActionPerformed

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        themDichVu();
        xoaformDichVu();
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void btnDauTienDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauTienDichVuActionPerformed
        try {
            tblDanhSachDichVu.setRowSelectionInterval(DichVu, DichVu);
            chinhsuaDichVu();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnDauTienDichVuActionPerformed

    private void btnTruocDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruocDichVuActionPerformed
        try {
            if (DichVu == 0) {
                DichVu = tblDanhSachDichVu.getRowCount() - 1;
            } else {
                DichVu--;
            }
            tblDanhSachDichVu.setRowSelectionInterval(DichVu, DichVu);
            chinhsuaDichVu();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnTruocDichVuActionPerformed

    private void btnSauDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauDichVuActionPerformed
        try {
            if (DichVu != tblDanhSachDichVu.getRowCount() - 1) {
                DichVu++;
            } else {
                DichVu = 0;
            }
            tblDanhSachDichVu.setRowSelectionInterval(DichVu, DichVu);
            chinhsuaDichVu();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnSauDichVuActionPerformed

    private void btnCuoiCungDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiCungDichVuActionPerformed
        try {
            DichVu = tblDanhSachDichVu.getRowCount() - 1;
            tblDanhSachDichVu.setRowSelectionInterval(DichVu, DichVu);
            chinhsuaDichVu();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnCuoiCungDichVuActionPerformed

    private void btnTimKiemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDichVuActionPerformed
        xoaformDichVu();
    }//GEN-LAST:event_btnTimKiemDichVuActionPerformed

    private void cboLocTrangThaiKhuyenMaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLocTrangThaiKhuyenMaiItemStateChanged
        taidulieuPhieuGiamGia();
    }//GEN-LAST:event_cboLocTrangThaiKhuyenMaiItemStateChanged

    private void btnCuoiCungDanhSachKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiCungDanhSachKhuyenMaiActionPerformed
        try {
            PhieuGiamGia = tblDanhSachPhieuGiamGia.getRowCount() - 1;
            tblDanhSachPhieuGiamGia.setRowSelectionInterval(PhieuGiamGia, PhieuGiamGia);
            chinhsuaDichVu();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnCuoiCungDanhSachKhuyenMaiActionPerformed

    private void btnSauDanhSachKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSauDanhSachKhuyenMaiActionPerformed
        try {
            if (PhieuGiamGia != tblDanhSachPhieuGiamGia.getRowCount() - 1) {
                PhieuGiamGia++;
            } else {
                PhieuGiamGia = 0;
            }
            tblDanhSachPhieuGiamGia.setRowSelectionInterval(PhieuGiamGia, PhieuGiamGia);
            chinhsuaDichVu();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnSauDanhSachKhuyenMaiActionPerformed

    private void btnDauTienDanhSachKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauTienDanhSachKhuyenMaiActionPerformed
        try {
            tblDanhSachPhieuGiamGia.setRowSelectionInterval(PhieuGiamGia, PhieuGiamGia);
            chinhsuaPhieuGiamGia();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnDauTienDanhSachKhuyenMaiActionPerformed

    private void btnLamMoiKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiKhuyenMaiActionPerformed
        xoaformPhieuGiamGia();
    }//GEN-LAST:event_btnLamMoiKhuyenMaiActionPerformed

    private void btnSuaKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKhuyenMaiActionPerformed
        capnhatPhieuGiamGia();
        xoaformPhieuGiamGia();
    }//GEN-LAST:event_btnSuaKhuyenMaiActionPerformed

    private void btnXoaKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhuyenMaiActionPerformed
        xoaPhieuGiamGia();
        xoaformPhieuGiamGia();
    }//GEN-LAST:event_btnXoaKhuyenMaiActionPerformed

    private void btnThemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhuyenMaiActionPerformed
        themPhieuGiamGia();
        xoaformPhieuGiamGia();
    }//GEN-LAST:event_btnThemKhuyenMaiActionPerformed

    private void btnTimKiemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKhuyenMaiActionPerformed
        timkiemphantramgiamgia();
    }//GEN-LAST:event_btnTimKiemKhuyenMaiActionPerformed

    private void tblDanhSachPhieuGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhieuGiamGiaMouseClicked
        PhieuGiamGia = tblDanhSachPhieuGiamGia.getSelectedRow();
        LayPhieuGiamGia();

    }//GEN-LAST:event_tblDanhSachPhieuGiamGiaMouseClicked

    private void tblDanhSachDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachDichVuMouseClicked
        DichVu = tblDanhSachDichVu.getSelectedRow();
        laydichvu();
    }//GEN-LAST:event_tblDanhSachDichVuMouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        evt.consume();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jScrollPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane5MouseClicked
        evt.consume();
    }//GEN-LAST:event_jScrollPane5MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        evt.consume();
    }//GEN-LAST:event_jLabel47MouseClicked

    private void txtTimKiemTenKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemTenKhachHangMouseClicked
        evt.consume();
    }//GEN-LAST:event_txtTimKiemTenKhachHangMouseClicked

    private void btnTimKiemKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemKhachHangMouseClicked
        evt.consume();
    }//GEN-LAST:event_btnTimKiemKhachHangMouseClicked

    private void btnVeDauHoiVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVeDauHoiVienMouseClicked
        evt.consume();
    }//GEN-LAST:event_btnVeDauHoiVienMouseClicked

    private void btnThemKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemKhachHangMouseClicked
        evt.consume();
    }//GEN-LAST:event_btnThemKhachHangMouseClicked

    private void tabThuCungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabThuCungMouseClicked
        evt.consume();
    }//GEN-LAST:event_tabThuCungMouseClicked

    private void tabSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabSanPhamMouseClicked

    }//GEN-LAST:event_tabSanPhamMouseClicked

    private void tabDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDichVuMouseClicked

    }//GEN-LAST:event_tabDichVuMouseClicked

    private void tabKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabKhoMouseClicked
        evt.consume();
    }//GEN-LAST:event_tabKhoMouseClicked

    private void tabHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabHoaDonMouseClicked
        evt.consume();
    }//GEN-LAST:event_tabHoaDonMouseClicked

    private void tabNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabNhanVienMouseClicked
        evt.consume();
    }//GEN-LAST:event_tabNhanVienMouseClicked

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        evt.consume();
    }//GEN-LAST:event_jPanel18MouseClicked

    private void tablDanhSachThuCungHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablDanhSachThuCungHoaDonMouseClicked
        hoadonthucung = tablDanhSachThuCungHoaDon.getSelectedRow();
        ThemThuCungHoaDonChiTiet();
        TongTienHoaDon();
    }//GEN-LAST:event_tablDanhSachThuCungHoaDonMouseClicked

    private void tablDanhSachSanPhamHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablDanhSachSanPhamHoaDonMouseClicked
        hoadonsanpham = tablDanhSachSanPhamHoaDon.getSelectedRow();
        ThemSanPhamHoaDonChiTiet();
        TongTienHoaDon();
    }//GEN-LAST:event_tablDanhSachSanPhamHoaDonMouseClicked

    private void tblDanhSahChiTietHoaDonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblDanhSahChiTietHoaDonFocusLost

    }//GEN-LAST:event_tblDanhSahChiTietHoaDonFocusLost

    private void btnLamMoiChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiChiTietHoaDonActionPerformed

    }//GEN-LAST:event_btnLamMoiChiTietHoaDonActionPerformed

    private void tblDanhSahChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSahChiTietHoaDonMouseClicked

    }//GEN-LAST:event_tblDanhSahChiTietHoaDonMouseClicked

    private void txtTienNhanHoaDonCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTienNhanHoaDonCaretPositionChanged

    }//GEN-LAST:event_txtTienNhanHoaDonCaretPositionChanged

    private void txtTienNhanHoaDonInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTienNhanHoaDonInputMethodTextChanged

    }//GEN-LAST:event_txtTienNhanHoaDonInputMethodTextChanged

    private void txtTienNhanHoaDonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTienNhanHoaDonFocusLost
        TienThuaHoaDon();
    }//GEN-LAST:event_txtTienNhanHoaDonFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ThemDichVuHoaDon();
        TongTienHoaDon();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblDanhSachSuKienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSuKienMouseClicked
        // TODO add your handling code here:
        this.rowSK = tblDanhSachSuKien.getSelectedRow();
        String maDatLichSuKien = (String) tblDanhSachSuKien.getValueAt(this.rowSK, 1);
        new ChiTietSuKienJDialog(this, true, maDatLichSuKien).setVisible(true);
    }//GEN-LAST:event_tblDanhSachSuKienMouseClicked

    private void btnSuKienThemLichDat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuKienThemLichDat1ActionPerformed
        // TODO add your handling code here:
        tabHoaDon.setVisible(true);
        tabSuKien.setVisible(false);
    }//GEN-LAST:event_btnSuKienThemLichDat1ActionPerformed

    private void cboSuKienLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSuKienLocActionPerformed
        // TODO add your handling code here:
        taiDuLieuSuKien();
    }//GEN-LAST:event_cboSuKienLocActionPerformed

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
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnLamMoiChiTietHoaDon;
    private javax.swing.JButton btnLamMoiDatLich;
    private javax.swing.JButton btnLamMoiDichVu;
    private javax.swing.JButton btnLamMoiDonHang;
    private javax.swing.JButton btnLamMoiKhuyenMai;
    private javax.swing.JButton btnLamMoiNhanVien;
    private javax.swing.JButton btnLamMoiThuCung;
    private javax.swing.JButton btnMoiNhapHang;
    private javax.swing.JButton btnSangTabSP;
    private javax.swing.JButton btnSangTabTC;
    private javax.swing.JButton btnSauDanhSachKhachHang;
    private javax.swing.JButton btnSauDanhSachKhuyenMai;
    private javax.swing.JButton btnSauDanhSachNhanVien;
    private javax.swing.JButton btnSauDanhSachSanPham;
    private javax.swing.JButton btnSauDichVu;
    private javax.swing.JButton btnSauDonHang;
    private javax.swing.JButton btnSauNhapHang;
    private javax.swing.JButton btnSauThuCung;
    private javax.swing.JButton btnSuKienThemLichDat1;
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
    private javax.swing.JButton btnTimKiemThuCungHoaDon;
    private javax.swing.JButton btnTimTenNhanVien;
    private javax.swing.JButton btnTruocDanhSachKhachHang;
    private javax.swing.JButton btnTruocDanhSachKhuyenMai;
    private javax.swing.JButton btnTruocDanhSachNhanVien;
    private javax.swing.JButton btnTruocDanhSachSanPham;
    private javax.swing.JButton btnTruocDichVu;
    private javax.swing.JButton btnTruocDonHang;
    private javax.swing.JButton btnTruocNhapHang;
    private javax.swing.JButton btnTruocThuCung;
    private javax.swing.JPanel btnVeDauHoiVien;
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
    private javax.swing.JComboBox<String> cbbnhacc;
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
    private javax.swing.JComboBox<String> cboSoChuongThuCung;
    private javax.swing.JComboBox<String> cboSuKienLoc;
    private javax.swing.JComboBox<String> cboTenDichVu;
    private javax.swing.JComboBox<String> cboTrangThaiNhanVien;
    private javax.swing.JComboBox<String> cboTrangThaiSanPham;
    private javax.swing.JComboBox<String> cbonam;
    private com.app.Other.CurveLineChart chart;
    private com.app.Other.ImageSlide imageSlide;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDanhSachThuCung;
    private javax.swing.JLabel lblDoiMatKhau;
    private javax.swing.JLabel lblDonHang1;
    private javax.swing.JLabel lblExitMenuIcon;
    private javax.swing.JLabel lblExitMenuNguoiDung;
    private javax.swing.JLabel lblHinhLogo;
    private javax.swing.JLabel lblHinhLogo1;
    private javax.swing.JLabel lblHinhNhanVien;
    private javax.swing.JLabel lblHinhThuCung;
    private javax.swing.JLabel lblHoaDonDichVu;
    private javax.swing.JLabel lblHoaDonLichSu;
    private javax.swing.JLabel lblHoaDonSanPham;
    private javax.swing.JLabel lblKhuyenMaiIcon;
    private javax.swing.JLabel lblLock;
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
    private javax.swing.JLabel lblSoluongnhap;
    private javax.swing.JLabel lblSoluongxuat;
    private javax.swing.JLabel lblSuKienNgayHienTai;
    private javax.swing.JLabel lblThongTinThuCung;
    private javax.swing.JLabel lblThuoc;
    private javax.swing.JLabel lblTongSoHangHoa;
    private javax.swing.JLabel lblTongluonghanghoa;
    private javax.swing.JLabel lblTroGiup;
    private javax.swing.JLabel lblUserIcon;
    private javax.swing.JLabel lblUserIcon1;
    private javax.swing.JPanel nenHoaDonThuCungSanPham;
    private com.app.Other.PanelShadow panelShadow3;
    private com.app.Other.PieChart pieChart;
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
    private javax.swing.JPanel tabDonHang;
    private javax.swing.JPanel tabHoaDOnTC;
    private javax.swing.JPanel tabHoaDon;
    private javax.swing.JPanel tabHoaDonDichVu;
    private javax.swing.JPanel tabHoaDonSP;
    private javax.swing.JPanel tabKhachHang;
    private javax.swing.JPanel tabKho;
    private javax.swing.JPanel tabKhuyenMai;
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
    private javax.swing.JTable tablDanhSachThuCungHoaDon;
    private javax.swing.JTable tblDanhSachDichVu;
    private javax.swing.JTable tblDanhSachDonHang;
    private javax.swing.JTable tblDanhSachHoaDon;
    private javax.swing.JTable tblDanhSachKhachHang;
    private javax.swing.JTable tblDanhSachNhanVien;
    private javax.swing.JTable tblDanhSachPhieuGiamGia;
    private javax.swing.JTable tblDanhSachSanPham;
    private javax.swing.JTable tblDanhSachSuKien;
    private javax.swing.JTable tblDanhSachThuCung;
    private javax.swing.JTable tblDanhSahChiTietHoaDon;
    private javax.swing.JTable tbllDachSachNhapHang;
    private javax.swing.JTextField txtCanNangThuCung;
    private javax.swing.JTextField txtDonVi;
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
    private javax.swing.JTextField txtMaKhoSanPham;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtMaLoaiSanPham;
    private javax.swing.JTextField txtMaNhaCC;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMaNhanVienHoaDon;
    private javax.swing.JTextField txtMaNhapHang;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMaThuCung;
    private javax.swing.JTextArea txtMoTaThuCung;
    private javax.swing.JTextField txtNgayBatDauKhuyenMai;
    private javax.swing.JTextField txtNgayDatDichVu;
    private javax.swing.JTextField txtNgayKetThucKhuyenMai;
    private javax.swing.JTextField txtNgayNhanThuCung;
    private javax.swing.JTextField txtNgaySinhNhanVien;
    private javax.swing.JTextField txtPhanTramKhuyenMai;
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
    private javax.swing.JTextField txtThuoc;
    private javax.swing.JTextField txtTienNhanHoaDon;
    private javax.swing.JTextField txtTienThuaHoaDon;
    private javax.swing.JTextField txtTimKiemDichVu;
    private javax.swing.JTextField txtTimKiemKhuyenMai;
    private javax.swing.JTextField txtTimKiemSanPhamHoaDon;
    private javax.swing.JTextField txtTimKiemTenKhachHang;
    private javax.swing.JTextField txtTimKiemTenSanPham;
    private javax.swing.JTextField txtTimKiemThuCung;
    private javax.swing.JTextField txtTimKiemThuCungHoaDon;
    private javax.swing.JTextField txtTimTenNhanVien;
    private javax.swing.JTextField txtTongTienHoaDon;
    private javax.swing.JTextField txtTuoiThuCung;
    // End of variables declaration//GEN-END:variables

}
