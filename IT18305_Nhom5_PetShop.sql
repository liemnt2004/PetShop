CREATE DATABASE petshop;
USE petshop;

-- 1 Bảng HoiVien
CREATE TABLE HoiVien
(
    MaHV CHAR(10) PRIMARY KEY,
    TenKhachHang NVARCHAR(255),
    GioiTinh NVARCHAR(10),
    Email NVARCHAR(255),
    SDT NVARCHAR(20),
    TichDiem INT DEFAULT 0,
    CCCD NVARCHAR(20),
    CONSTRAINT UNI_HV_SDT UNIQUE (SDT)
);

-- 2 Bảng DatDV
CREATE TABLE DatDV
(
    MaDL CHAR(10) PRIMARY KEY,
    MaHV CHAR(10),
    SoDienThoai CHAR(20),
    NgayDat DATETIME,
    TrangThai NVARCHAR(20),
    Mota NVARCHAR(255),
    NgayTra DATETIME DEFAULT GETDATE(),
    SoLuong INT,
    FOREIGN KEY (MaHV) REFERENCES HoiVien(MaHV) ON DELETE CASCADE  ON UPDATE CASCADE
);

-- 3 Bảng DichVu  
CREATE TABLE DichVu
(
    MaDv CHAR(10) PRIMARY KEY,
    TenDichVu NVARCHAR(255),
    DonVi NVARCHAR(20) DEFAULT 'Lần',
    GiaTien MONEY
);

-- 4 Bảng ChiTietDL
CREATE TABLE ChiTietDL
(
    ChiTietDLID INT IDENTITY(1,1) PRIMARY KEY,
    MaDL CHAR(10),
    MaDv CHAR(10),
    FOREIGN KEY (MaDL) REFERENCES DatDV(MaDL) ON DELETE CASCADE  ON UPDATE CASCADE,
    FOREIGN KEY (MaDv) REFERENCES DichVu(MaDv) ON DELETE CASCADE  ON UPDATE CASCADE
);

-- 5 Bảng LoaiVat
CREATE TABLE LoaiVat
(
    MaLoai CHAR(10) PRIMARY KEY,
    TenLoai NVARCHAR(255)
);

-- 6 Bảng Giong  
CREATE TABLE Giong
(
    MaGiong CHAR(10) PRIMARY KEY,
    TenGiong NVARCHAR(255),
    MaLoai CHAR(10),
    FOREIGN KEY (MaLoai) REFERENCES LoaiVat(MaLoai) ON DELETE SET NULL  ON UPDATE CASCADE
);

-- 7 Bảng Chuồng
CREATE TABLE Chuong
(
    MaChuong CHAR(10) PRIMARY KEY,
    TrangThai NVARCHAR(20) DEFAULT 'Trống',
    Mota NVARCHAR(255)
);

-- 8 Bảng ThuCung
CREATE TABLE ThuCung
(
    MaTC CHAR(10) PRIMARY KEY,
    Mota NVARCHAR(255),
    GiaTien INT,
    Tuoi DATE,
    CanNang FLOAT,
    MaGiong CHAR(10),
    GioiTinh BIT,
    MaHV CHAR(10),
    MaChuong CHAR(10) NULL,
    MaLoai CHAR(10),
    Hinh NVARCHAR(255),
    FOREIGN KEY (MaGiong) REFERENCES Giong(MaGiong) ON DELETE CASCADE  ON UPDATE CASCADE,
    FOREIGN KEY (MaHV) REFERENCES HoiVien(MaHV) ON DELETE CASCADE  ON UPDATE CASCADE,
    FOREIGN KEY (MaChuong) REFERENCES Chuong(MaChuong) ON DELETE CASCADE  ON UPDATE CASCADE,
    FOREIGN KEY (MaLoai) REFERENCES LoaiVat(MaLoai)
);
-- 9 Bảng VaiTro
CREATE TABLE VaiTro
(
    MaVT CHAR(10) PRIMARY KEY,
    TenVaiTro NVARCHAR(50) NOT NULL
);

-- 10 Bảng NhanVien
CREATE TABLE NhanVien
(
    MaNV CHAR(10) PRIMARY KEY,
    HoTen NVARCHAR(255),
    GioiTinh NVARCHAR(10),
    NgaySinh DATE,
    SDT NVARCHAR(20) unique,
    Email NVARCHAR(255) unique,
    TrangThai NVARCHAR(20),
    Hinh NVARCHAR(MAX),
    MaVT CHAR(10),
    FOREIGN KEY (MaVT) REFERENCES VaiTro(MaVT) ON UPDATE CASCADE
);


--11 Bảng TaiKhoan
CREATE TABLE TaiKhoan
(
    TaiKhoan NVARCHAR(255) PRIMARY KEY,
    MatKhau NVARCHAR(255),
    MaNV CHAR(10),
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON UPDATE CASCADE
);

CREATE TABLE QuenMatKhau(
	STT INT IDENTITY(1,1) PRIMARY KEY,
    TaiKhoan NVARCHAR(255),
    MaXacNhan NVARCHAR(10),
    ThoiGian datetime,
    FOREIGN KEY (TaiKhoan) REFERENCES TaiKhoan(TaiKhoan) ON UPDATE CASCADE
);



--12 Bảng NhaCungCap  
CREATE TABLE NhaCungCap
(
    MaNhaCC CHAR(10) PRIMARY KEY,
    TenNhaCC NVARCHAR(255),
    DiaChi NVARCHAR(255)
);

--14 Bảng LoaiSanPham
CREATE TABLE LoaiSanPham
(
    MaLoaisp CHAR(10) PRIMARY KEY,
    TenLoai NVARCHAR(255)
);

--15 Bảng SanPham
CREATE TABLE SanPham
(
    MaSP CHAR(10) PRIMARY KEY,
    GiaTien INT,
    TenSP NVARCHAR(255),
    DonVi NVARCHAR(20) DEFAULT 'Cái',
    PhanTram FLOAT DEFAULT 0.1,
    MaLoaisp CHAR(10),
    MaNhaCC CHAR(10),
    TrangThai NVARCHAR(50) DEFAULT 'ĐANG BÁN'
        FOREIGN KEY (MaLoaisp) REFERENCES LoaiSanPham(MaLoaisp) ON UPDATE CASCADE,
    FOREIGN KEY (MaNhaCC) REFERENCES NhaCungCap(MaNhaCC) ON UPDATE CASCADE
);

--17 Bảng PhieuNhapHang
CREATE TABLE PhieuNhapHang
(
    SoPhieuNhap CHAR(10) PRIMARY KEY,
    NgayNhap DATETIME DEFAULT GETDATE()
);

--18 Bảng KhoHang
CREATE TABLE KhoHang
(
    MaKho CHAR(10) PRIMARY KEY,
    diachi NVARCHAR(255)
);

-- Tồn kho
CREATE TABLE tonkho
(
    Matonkho INT IDENTITY(1,1) PRIMARY KEY,
    makho CHAR(10),
    masp CHAR(10),
    soluong INT,
    FOREIGN KEY (masp) REFERENCES SanPham(MaSP) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (makho) REFERENCES KhoHang(MaKho) ON UPDATE CASCADE
);

--19 Bảng ChiTietNhapHang
CREATE TABLE ChiTietNhapHang
(
    machitietnhaphang INT IDENTITY(1,1) PRIMARY KEY,
    SoPhieuNhap CHAR(10),
    MaSP CHAR(10),
    MaNhaCC CHAR(10),
    SLNhap INT,
    FOREIGN KEY (MaNhaCC) REFERENCES NhaCungCap(MaNhaCC) ON DELETE CASCADE,
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (SoPhieuNhap) REFERENCES PhieuNhapHang(SoPhieuNhap) ON UPDATE CASCADE
);


--21 Bảng PhieuGiamGia
CREATE TABLE PhieuGiamGia
(
    MaPhieuGiamGia CHAR(10) PRIMARY KEY,
    PhanTramGiamGia FLOAT,
    DateStart DATETIME,
    DateEnd DATETIME
);

CREATE TABLE HoaDon
(
    MaHoaDon CHAR(10) PRIMARY KEY,
    MaNV CHAR(10),
    NgayLap DATETIME DEFAULT GETDATE(),
    TongTien FLOAT,
    MaHV CHAR(10),
    MaPhieuGiamGia CHAR(10),
    TrangThai NVARCHAR(50) NULL,
    MaDL CHAR(10) NULL,
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (MaHV) REFERENCES HoiVien(MaHV) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (MaPhieuGiamGia) REFERENCES PhieuGiamGia(MaPhieuGiamGia) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (MaDL) REFERENCES DatDV(MaDL) ON DELETE NO ACTION ON UPDATE NO ACTION
    -- Modified foreign key
);

--23 Bảng ChiTietHoaDon
CREATE TABLE ChiTietHoaDon
(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MaHoaDon CHAR(10),
    MaSP CHAR(10),
    SoLuong INT,
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP) ON DELETE SET NULL ON UPDATE  CASCADE
);

CREATE TABLE ChiTietHoaDon_TC
(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MaHoaDon CHAR(10),
    MaTC CHAR(10),
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (MaTC) REFERENCES ThuCung(MaTC) ON DELETE CASCADE ON UPDATE CASCADE
);

--25 Bảng CaLam
CREATE TABLE CaLam
(
    MaCL CHAR(10) PRIMARY KEY,
    TenCaLam NVARCHAR(255),
    ThoiGian NVARCHAR(50)
);

--26 Bảng ChiTietCaLam
CREATE TABLE ChiTietCaLam
(
    MaChiTietCaLam int IDENTITY(1,1) PRIMARY KEY,
    MaCL CHAR(10),
    MaNV CHAR(10),
    NgayLam DATE,
    FOREIGN KEY (MaCL) REFERENCES CaLam(MaCL) ON UPDATE CASCADE,
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON UPDATE CASCADE ON DELETE SET NULL
);



INSERT INTO HoiVien
    (MaHV, TenKhachHang, GioiTinh, Email, SDT, TichDiem, CCCD)
VALUES
    ('HV00','Vô Danh','Nam','email@gmail.com','00000000',0,'00000000000'),
    ('HV01', N'Nguyễn Tấn Hiếu', N'Nam', 'hieunt@gmail.com', N'0927594734', 100, '0927594731'),
    ('HV02', N'Nguyễn Hữu Trí', N'Nam', 'trinh@gmail.com', N'0946984711', 50, '0946984712'),
    ('HV03', N'Võ Quốc Hưng', N'Nam', 'qhung@gmail.com', N'0368588531', 50, '074504009006'),
    ('HV04', N'Trần Thị Mai', N'Nữ', 'maitr@gmail.com', N'0987654321', 80, '0987654321'),
    ('HV05', N'Lê Văn Hòa', N'Nam', 'hoale@gmail.com', N'0889456225', 120, '0889456225'),
    ('HV06', N'Phạm Thị Lan', N'Nữ', 'lanpham@gmail.com', N'0889456333', 90, '0978654321'),
    ('HV07', N'Lê Thị Anh', N'Nữ', 'anhle@gmail.com', N'0889456228', 60, '0965432198'),
    ('HV08', N'Nguyễn Văn Tùng', N'Nam', 'tungnguyen@gmail.com', N'0889456220', 110, '0932165487'),
    ('HV09', N'Đỗ Văn Bình', N'Nam', 'binhdo@gmail.com', N'0889456211', 70, '0923456789'),
    ('HV10', N'Nguyễn Thị Thảo', N'Nữ', 'thaonguyen@gmail.com', N'0889456212', 100, '0945678912'),
    ('HV11', N'Trần Văn Thắng', N'Nam', 'thangtran@gmail.com', N'0889456223', 80, '0987654321'),
    ('HV12', N'Đỗ Thị Ngọc', N'Nữ', 'ngocdo@gmail.com', N'0889456226', 120, '0912345678'),
    ('HV13', N'Hoàng Minh Quân', N'Nam', 'quanhoang@gmail.com', N'0889456332', 90, '0978654321'),
    ('HV14', N'Phạm Thị Mai', N'Nữ', 'maipham@gmail.com', N'0965432198', 60, '0965432198'),
    ('HV15', N'Nguyễn Văn An', N'Nam', 'annguyen@gmail.com', N'0932165487', 110, '0932165487'),
    ('HV16', N'Lê Thị Lan', N'Nữ', 'lanle@gmail.com', N'0923456789', 70, '0923456789'),
    ('HV17', N'Trần Văn Bình', N'Nam', 'binhtran@gmail.com', N'0945678912', 100, '0945678912'),
    ('HV18', N'Phạm Văn Dũng', N'Nam', 'dungpham@gmail.com', N'0889456224', 80, '0987654321'),
    ('HV19', N'Lê Thị Ngọc', N'Nữ', 'ngocle@gmail.com', N'0889456227', 120, '0912345678'),
    ('HV20', N'Nguyễn Văn Thịnh', N'Nam', 'thinhnguyen@gmail.com', N'0889456222', 90, '0978654321');
-- Dữ liệu mẫu cho bảng DichVu
INSERT INTO DichVu
    (MaDv, TenDichVu, DonVi, GiaTien)
VALUES
    ('DV01', N'Dịch vụ chăm sóc', N'Lần', 50),
    ('DV02', N'Dịch vụ làm đẹp', N'Lần', 70),
    ('DV03', N'Dịch vụ giữ thuê', N'Lần', 90);

INSERT INTO DatDV
    (MaDL, MaHV,SoDienThoai, NgayDat, TrangThai, Mota, SoLuong)
VALUES
    ('DL01', 'HV01',09234556787, GETDATE(), N'Đã nhận', '', 1),
    ('DL02', 'HV02',76682813717, GETDATE(), N'Chờ xác nhận', N'Đặt dịch vụ 2', 3),
    ('DL03', 'HV03',67182137173, GETDATE(), N'Chờ xác nhận', N'Đặt dịch vụ 3', 2),
    ('DL04', 'HV04',09371371374, GETDATE(), N'Hoàn thành', N'Đặt dịch vụ 4', 1),
    ('DL05', 'HV05',01371127137, GETDATE(), N'Đã nhận', N'Đặt dịch vụ 5', 4),
    ('DL06', 'HV06',01837127173, GETDATE(), N'Chờ xác nhận', N'Đặt dịch vụ 6', 2),
    ('DL07', 'HV07',018371281737, GETDATE(), N'Đã nhận', N'Đặt dịch vụ 7', 3),
    ('DL08', 'HV08',018172816461, GETDATE(), N'Hoàn thành', N'Đặt dịch vụ 8', 1),
    ('DL09', 'HV09',0183128137171, GETDATE(), N'Đã nhận', N'Đặt dịch vụ 9', 2),
    ('DL10', 'HV10',01381727173731, GETDATE(), N'Chờ xác nhận', N'Đặt dịch vụ 10', 3);




-- Dữ liệu mẫu cho bảng ChiTietDL
INSERT INTO ChiTietDL
    (MaDL, MaDv)
VALUES
    ('DL01', 'DV01'),
    ('DL02', 'DV02'),
    ('DL03', 'DV03'),
    ('DL04', 'DV03'),
    ('DL05', 'DV02'),
    ('DL06', 'DV02'),
    ('DL07', 'DV02'),
    ('DL08', 'DV02'),
    ('DL09', 'DV02'),
    ('DL10', 'DV01'),
    ('DL01', 'DV01'),
    ('DL02', 'DV02'),
    ('DL08', 'DV01'),
    ('DL03', 'DV01'),
    ('DL02', 'DV03'),
    ('DL10', 'DV01'),
    ('DL03', 'DV03'),
    ('DL04', 'DV01'),
    ('DL04', 'DV03'),
    ('DL07', 'DV02');

INSERT INTO LoaiVat
VALUES
    ('D01', N'Chó nội địa'),
    ('D02', N'Chó nước ngoài'),
    ('D03', N'Mèo nội địa'),
    ('D04', N'Mèo nước ngoài'),
    ('D05', N'Chuột'),
    ('D06', N'Cá'),
    ('D07', N'Rùa'),
    ('D08', N'Chim'),
    ('D09', N'Gà'),
    ('D10', N'Thỏ');


INSERT INTO Giong
VALUES
    ('PUL01', N'Chó mặt xệ (BullDog)', 'D02'),
    ('PUL02', N'Chó Pitbull', 'D02'),
    ('SB01', N'Chó Shiba', 'D02'),
    ('LAB01', N'Chó Labrador', 'D02'),
    ('PERS01', N'Mèo Persian', 'D03'),
    ('RAG01', N'Mèo Ragdoll', 'D03'),
    ('MICE01', N'Chuột nhảy trắng', 'D05'),
    ('GOLDFISH01', N'Cá vàng Ryukin', 'D06'),
    ('TURTLE01', N'Rùa đất Xanh', 'D07'),
    ('PEAFOWL01', N'Chim công xanh', 'D08');


INSERT INTO Chuong
VALUES
    ('CH01', N'Trống', ''),
    ('CH02', N'Đã có', ''),
    ('CH04', N'Đã có', ''),
    ('CH06', N'Trống', ''),
    ('CH07', N'Đã có', ''),
    ('CH09', N'Trống', ''),
    ('CH11', N'Trống', ''),
    ('CH12', N'Trống', ''),
    ('CH13', N'Trống', ''),
    ('CH14', N'Trống', '');


INSERT INTO ThuCung
VALUES
    ('TC01', '', 100000, '2022-02-20', 6, 'PUL01', 0, 'HV01', null, 'D01', 'logo_menu.jpg'),
    ('TC02', '', 120000, '2021-02-20', 8, 'PUL02', 1, NULL, null, 'D02', 'logo_menu.jpg'),
    ('TC03', '', 120000, '2020-02-20', 8, 'SB01', 0, 'HV03', null, 'D02', 'logo_menu.jpg'),
    ('TC04', '', 120000, '2023-02-20', 8, 'PUL02', 1, NULL, null, 'D03', 'logo_menu.jpg'),
    ('TC05', '', 80000, '2023-05-10', 5, 'MICE01', 0, 'HV02', null, 'D05', 'logo_menu.jpg'),
    ('TC06', '', 150000, '2022-11-15', 7, 'LAB01', 1, NULL, null, 'D02', 'logo_menu.jpg'),
    ('TC07', '', 90000, '2023-01-15', 5, 'TURTLE01', 0, 'HV04', null, 'D07', 'logo_menu.jpg'),
    ('TC08', '', 130000, '2021-09-30', 6, 'PEAFOWL01', 1, NULL, null, 'D08', 'logo_menu.jpg'),
    ('TC09', '', 110000, '2022-04-05', 4, 'GOLDFISH01', 0, 'HV02', null, 'D09', 'logo_menu.jpg'),
    ('TC10', '', 95000, '2023-07-20', 3, 'RAG01', 1, NULL, null, 'D10', 'logo_menu.jpg'),
    ('TC11', '', 85000, '2022-03-15', 5, 'MICE01', 0, 'HV03', null, 'D05', 'logo_menu.jpg'),
    ('TC12', '', 160000, '2022-08-10', 8, 'PUL01', 1, NULL, null, 'D01', 'logo_menu.jpg'),
    ('TC13', '', 75000, '2021-12-01', 4, 'GOLDFISH01', 0, 'HV01', null, 'D06', 'logo_menu.jpg'),
    ('TC14', '', 140000, '2023-04-25', 7, 'SB01', 1, NULL, null, 'D02', 'logo_menu.jpg'),
    ('TC15', '', 110000, '2023-03-20', 6, 'RAG01', 0, 'HV02', 'CH09', 'D03', 'logo_menu.jpg'),
    ('TC16', '', 95000, '2022-06-15', 5, 'PEAFOWL01', 1, NULL, 'CH01', 'D08', 'logo_menu.jpg'),
    ('TC17', '', 120000, '2021-11-10', 7, 'LAB01', 0, 'HV04', 'CH02', 'D09', 'logo_menu.jpg'),
    ('TC18', '', 100000, '2022-01-05', 6, 'TURTLE01', 1, NULL, null, 'D07', 'logo_menu.jpg'),
    ('TC19', '', 90000, '2023-01-15', 5, 'PUL01', 0, 'HV04', 'CH07', 'D02', 'logo_menu.jpg'),
    ('TC20', '', 150000, '2022-11-10', 7, 'PUL01', 1, NULL, 'CH04', 'D01', 'logo_menu.jpg');
-- Thêm dữ liệu cho bảng LoaiVat và Giong


-- Thêm dữ liệu cho bảng VaiTro
INSERT INTO VaiTro
VALUES
    (0, N'Nhân viên'),
    (1, N'Quản lí');


-- Thêm dữ liệu cho bảng NhanVien
INSERT INTO NhanVien
VALUES
    ('NV01', N'Lê Quốc Huy', N'Nam', '1954-12-3', N'0889456201', 'mylinh.khanhhung@gmail.com', N'Đang làm', 'logo_menu.jpg', 1),
    ('NV02', N'Đỗ Văn Minh', N'Nữ', '1983-8-19', N'0968095685', 'minhdv@gmail.com', N'Đã nghỉ', 'logo_menu.jpg', 0),
    ('NV03', N'Võ Hoài Hưng', N'Nam', '2004-8-19', N'0956872574', 'hhung@gmail.com', N'Đang làm', 'logo_menu.jpg', 0),
    ('NV04', N'Châu Tinh Trì', N'Nam', '1985-4-29', N'0964687963', 'tinhtri12@gmail.com', N'Đang làm', 'logo_menu.jpg', 0);


-- Thêm dữ liệu tài khoản
INSERT INTO TaiKhoan
VALUES
    ('mylinh.khanhhung@gmail.com', '$2a$12$TGgFs8/L59fckjA6pAap7.wx39KbZ8GBdKSI/1BCTZVNWdiThSq.S', 'NV01'),
    ('minhdv@gmail.com', '2', 'NV02');


-- Thêm dữ liệu nhà cung cấp


INSERT INTO NhaCungCap
VALUES
    ('NCC01', N'Nhà cung cấp thức ăn thú cưng', N'Bình Tân'),
    ('NCC02', N'Nhà cung đồ chơi thú cưng', N'Quận 7'),
    ('NCC03', N'Nhà cung vật dùng chăm sóc thú cưng', N'Quận 7'),
    ('NCC04', N'Nhà cung vệ sinh thú cưng', N'Quận 7'),
    ('NCC05', N'Nhà cung cấp 2', N'Quận 7'),
    ('NCC06', N'Nhà cung cấp 3', N'Quận 7');


-- Thêm dữ liệu loại sản phẩm


INSERT INTO LoaiSanPham
VALUES
    ('Loai01', N'Thức ăn cho thú cưng'),
    ('Loai02', N'Đồ chơi cho thú cưng'),
    ('Loai03', N'Vệ sinh cho thú cưng'),
    ('Loai04', N'Chăm sóc cho thú cưng'),
    ('Loai05', N'Quần áo cho thú cưng');





--Thêm dữ liệu phiếu nhập hàng


INSERT INTO PhieuNhapHang
    (SoPhieuNhap, NgayNhap)
VALUES
    ('PN01', GETDATE()),
    ('PN02', GETDATE());

-- Thêm dữ liệu kho hàng



INSERT INTO KhoHang
VALUES
    ('KHO1', 'Quận 12');


-- thêm dữ liệu tồn kho

-- Thêm dữ liệu sản phẩm
INSERT INTO SanPham
VALUES
    ('SP01', 76000, N'Pate cho mèo', N'cái', 0.1, 'Loai01', 'NCC01', 'Đang Bán'),
    ('SP02', 36000, N'Áo cho chó', N'cái', 0.1, 'Loai05', 'NCC02', 'Đang Bán'),
    ('SP03', 45000, N'Đồ chơi chuột nhựa', N'cái', 0.2, 'Loai02', 'NCC03', 'Đang Bán'),
    ('SP04', 89000, N'Mái chèo cho thú cưng', N'cái', 0.5, 'Loai04', 'NCC04', 'Đang Bán'),
    ('SP05', 120000, N'Bát ăn cho chó', N'cái', 0.3, 'Loai01', 'NCC05', 'Đang Bán'),
    ('SP06', 25000, N'Bóng nhựa cho mèo', N'cái', 0.1, 'Loai02', 'NCC01', 'Đang Bán'),
    ('SP07', 98000, N'Nước súc miệng cho chó', N'lọ', 0.2, 'Loai03', 'NCC02', 'Đang Bán'),
    ('SP08', 56000, N'Đèn hồ cá mini', N'cái', 0.4, 'Loai04', 'NCC03', 'Đang Bán'),
    ('SP09', 32000, N'Bàn chải lông cho thú cưng', N'cái', 0.2, 'Loai04', 'NCC04', 'Đang Bán'),
    ('SP10', 18000, N'Chuột nhựa cho mèo', N'cái', 0.1, 'Loai02', 'NCC05', 'Đang Bán'),
    ('SP11', 79000, N'Túi xách cho chó', N'cái', 0.3, 'Loai05', 'NCC01', 'Đang Bán'),
    ('SP12', 42000, N'Ổ chia thức ăn cho chó', N'cái', 0.2, 'Loai01', 'NCC02', 'Đang Bán'),
    ('SP13', 110000, N'Tấm lót nhà vệ sinh cho mèo', N'cái', 0.4, 'Loai03', 'NCC03', 'Đang Bán'),
    ('SP14', 67000, N'Bình nước tự động cho chó', N'cái', 0.3, 'Loai01', 'NCC04', 'Đang Bán'),
    ('SP15', 15000, N'Bóng cao su cho chó', N'cái', 0.1, 'Loai02', 'NCC05', 'Đang Bán'),
    ('SP16', 88000, N'Miếng lót nhà vệ sinh cho chó', N'cái', 0.4, 'Loai03', 'NCC01', 'Đang Bán'),
    ('SP17', 40000, N'Đồ chơi nhựa cho chó', N'cái', 0.2, 'Loai02', 'NCC02', 'Đang Bán'),
    ('SP18', 54000, N'Vòi sen cho chó', N'cái', 0.3, 'Loai04', 'NCC03', 'Đang Bán'),
    ('SP19', 96000, N'Găng tay chải lông cho mèo', N'cái', 0.2, 'Loai04', 'NCC04', 'Đang Bán'),
    ('SP20', 28000, N'Cái đồ chơi nhỏ cho thú cưng', N'cái', 0.1, 'Loai02', 'NCC05', 'Đang Bán');


-- INSERT INTO tonkho
-- VALUES
--     ('KHO1', 'SP01', 100),
--     ('KHO1', 'SP02', 100);



-- Thêm dữ liệu chi tiết nhập hàng


INSERT INTO ChiTietNhapHang
VALUES
    ('PN01', 'SP01', 'NCC01', 100000),
    ('PN02', 'SP02', 'NCC02', 100000);




-- Thêm dữ liệu phương thức thành toán bỏ


-- Thêm dữ liệu phiếu giảm 
INSERT INTO PhieuGiamGia
VALUES
    ('DISCOUNT',0.0,GETDATE(),GETDATE()),
    ('DISCOUNT1', 1.2, '2023-11-3', '2023-11-29'),
    ('DISCOUNT2', 1.1, '2023-12-1', '2023-12-27'),
    ('DISCOUNT3', 1.5, '2023-10-15', '2023-11-10'),
    ('DISCOUNT4', 1.3, '2023-09-5', '2023-09-30'),
    ('DISCOUNT5', 1.0, '2023-08-1', '2023-08-31'),
    ('DISCOUNT6', 1.8, '2023-07-10', '2023-08-5'),
    ('DISCOUNT7', 1.2, '2023-06-15', '2023-07-5'),
    ('DISCOUNT8', 1.4, '2023-05-1', '2023-05-20'),
    ('DISCOUNT9', 1.1, '2023-04-8', '2023-04-30'),
    ('DISCOUNT10', 1.7, '2023-03-12', '2023-03-31');


-- Thêm dữ liệu hóa đơn bỏ cột thanh toán


INSERT INTO HoaDon
VALUES
    ('HD01', 'NV01', '2023-11-10', '2000000', 'HV02', 'DISCOUNT1', N'Đã thanh toán', 'DL01'),
    ('HD02', 'NV02', '2023-11-10', '1000000', 'HV01', 'DISCOUNT1', N'Đã hủy', 'DL02'),
    ('HD03', 'NV02', '2023-11-11', '1120000', 'HV03', 'DISCOUNT4', N'Đã thanh toán', 'DL03'),
    ('HD04', 'NV03', GETDATE(), '1000000', 'HV01', 'DISCOUNT6', N'Đã thanh toán', 'DL04'),
    ('HD05', 'NV04', GETDATE(), '1000000', 'HV02', 'DISCOUNT9', N'Đã hủy', 'DL05'),
    ('HD06', 'NV01', '2023-12-05', 1500000, 'HV01', 'DISCOUNT10', N'Đã thanh toán', 'DL06'),
    ('HD07', 'NV02', '2023-12-10', 800000, 'HV02', 'DISCOUNT1', N'Đã hủy', 'DL07'),
    ('HD08', 'NV02', '2023-12-15', 920000, 'HV03', 'DISCOUNT4', N'Đã thanh toán', 'DL08'),
    ('HD09', 'NV03', '2024-01-02', 1000000, 'HV01', 'DISCOUNT5', N'Đã thanh toán', 'DL09'),
    ('HD10', 'NV04', '2024-02-20', 1000000, 'HV02', 'DISCOUNT2', N'Đã hủy', null),
    ('HD11', 'NV01', '2024-03-08', 1500000, 'HV01', 'DISCOUNT1', N'Đã thanh toán', 'DL10'),
    ('HD12', 'NV02', '2024-03-15', 800000, 'HV02', 'DISCOUNT1', N'Đã hủy', null),
    ('HD13', 'NV02', '2024-04-01', 920000, 'HV03', 'DISCOUNT3', N'Đã thanh toán', null),
    ('HD14', 'NV03', '2024-05-12', 1000000, 'HV01', 'DISCOUNT5', N'Đã thanh toán', null),
    ('HD15', 'NV04', '2024-06-30', 1000000, 'HV02', 'DISCOUNT8', N'Đã hủy', null);



-- Thêm dữ liệu hóa đơn


INSERT INTO ChiTietHoaDon
VALUES
    ('HD13', 'SP01', 10),
    ('HD10', 'SP02', 10),
    ('HD10', 'SP03', 8),
    ('HD14', 'SP04', 5),
    ('HD15', 'SP05', 12),
    ('HD11', 'SP06', 15),
    ('HD13', 'SP07', 7),
    ('HD14', 'SP08', 20),
    ('HD15', 'SP09', 10),
    ('HD12', 'SP10', 18);


-- Thêm dữ liệu cho bảng ChiTietHoaDon_TC
INSERT INTO ChiTietHoaDon_TC
VALUES
    ('HD01', 'TC01'),
    ('HD02', 'TC02'),
    ('HD03', 'TC03'),
    ('HD04', 'TC04'),
    ('HD05', 'TC05'),
    ('HD10', 'TC06'),
    ('HD12', 'TC07'),
    ('HD13', 'TC08'),
    ('HD14', 'TC09'),
    ('HD15', 'TC10');



INSERT INTO CaLam
Values
    ('CL01', '7:00:00-12:00:00', N'ca sáng'),
    ('CL02', '12:00:00-17:00:00', N'ca chiều');



INSERT INTO ChiTietCaLam
Values
    ('CL01', 'NV01', '2021/01/23'),
    ('CL02', 'NV02', '2022/02/06');


INSERT INTO QUENMATKHAU(TAIKHOAN,MAXACNHAN,THOIGIAN) VALUES('mylinh.khanhhung@gmail.com','937553',GETDATE());
INSERT INTO QUENMATKHAU(TAIKHOAN,MAXACNHAN,THOIGIAN) VALUES('mylinh.khanhhung@gmail.com','937555',GETDATE());
INSERT INTO QUENMATKHAU(TAIKHOAN,MAXACNHAN,THOIGIAN) VALUES('mylinh.khanhhung@gmail.com','937554',GETDATE());
INSERT INTO QUENMATKHAU(TAIKHOAN,MAXACNHAN,THOIGIAN) VALUES('mylinh.khanhhung@gmail.com','937556',GETDATE());
INSERT INTO QUENMATKHAU(TAIKHOAN,MAXACNHAN,THOIGIAN) VALUES('mylinh.khanhhung@gmail.com','937557',GETDATE());
INSERT INTO QUENMATKHAU(TAIKHOAN,MAXACNHAN,THOIGIAN) VALUES('mylinh.khanhhung@gmail.com','937559',GETDATE());
go



SELECT * FROM TaiKhoan


-- lấy ra thông tin của kho
CREATE PROCEDURE dbo.ThongSoKho
AS
BEGIN
    SELECT
        (SELECT COUNT(*)
        FROM PhieuNhapHang) AS TongNhap,
        (SELECT COUNT(*)
        FROM HoaDon) AS TongXuat,
        (SELECT COUNT(*)
        FROM SanPham) AS TongSanPham,
        (SELECT SUM(soluong)
        FROM tonkho) AS TongSoLuongSanPham
END;

-- EXECUTE dbo.ThongSoKho




-- triger tự thêm sản phẩm vào tồn kho nếu có sản phẩm mới được thêm vào database
CREATE TRIGGER AfterInsertSanPhamTrigger
ON SanPham
AFTER INSERT
AS
BEGIN
    -- Insert các sản phẩm mới vào bảng tonkho
    INSERT INTO tonkho
        (makho, masp, soluong)
    SELECT 'KHO1', i.MaSP, 0
    FROM inserted i;
END;


-- triger tự thêm cập nhật số lượng sản phẩm
CREATE TRIGGER updateSoLuongSanPhamKho
ON ChiTietNhapHang
AFTER INSERT
AS
BEGIN
    UPDATE tonkho
    SET soluong = soluong + i.SLNhap
    FROM tonkho
        INNER JOIN inserted i ON tonkho.masp = i.masp;
END;



CREATE PROCEDURE [dbo].[ThongKeTongTien]
    @nam INT
AS
BEGIN
    SELECT
        YEAR(HoaDon.NgayLap) AS Nam,
        SUM(CASE WHEN ChiTietHoaDon_TC.MaTC IS NOT NULL THEN HoaDon.TongTien ELSE 0 END) AS TongTienThuCung,
        SUM(CASE WHEN ChiTietHoaDon.MaSP IS NOT NULL THEN HoaDon.TongTien ELSE 0 END) AS TongTienSanPham,
        SUM(CASE WHEN DatDV.MaDL IS NOT NULL THEN HoaDon.TongTien ELSE 0 END) AS TongTienDichVu
    FROM
        HoaDon
        LEFT JOIN ChiTietHoaDon_TC ON HoaDon.MaHoaDon = ChiTietHoaDon_TC.MaHoaDon
        LEFT JOIN ChiTietHoaDon ON HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon
        LEFT JOIN DatDV ON HoaDon.MaDL = DatDV.MaDL
    WHERE
        YEAR(HoaDon.NgayLap) = @nam
    GROUP BY
        YEAR(HoaDon.NgayLap)
    ORDER BY
        Nam DESC;
END;


CREATE PROCEDURE NgayCaLam
AS
BEGIN
    DECLARE @Today DATE = GETDATE();
    DECLARE @LastDayOfMonth DATE = EOMONTH(@Today);

    WITH
        DateList
        AS
        (
                            SELECT @Today AS [Date]
            UNION ALL
                SELECT DATEADD(DAY, 1, [Date])
                FROM DateList
                WHERE [Date] < @LastDayOfMonth
        )

    SELECT [Date]
    FROM DateList
    OPTION
    (MAXRECURSION
    0);
END;



-- Tạo thủ tục tìm nhân viên chưa thuộc ca làm đó
CREATE PROCEDURE NhanVienChuaCaLam
    @ngay DATE,
    @macl CHAR(10)
AS
BEGIN
    SELECT NV.*
    FROM NhanVien NV
    WHERE NOT EXISTS (
        SELECT 1
    FROM ChiTietCaLam CTL
        JOIN CaLam CL ON CTL.MaCL = CL.MaCL
    WHERE CTL.MaNV = NV.MaNV
        AND CTL.NgayLam = @ngay
        AND CTL.MaCL = @macl
    );
END;

SELECT TichDiem FROM HoiVien WHERE MaHV = 


