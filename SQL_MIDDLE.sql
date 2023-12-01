CREATE DATABASE petshop;
USE petshop;

-- 1 Bảng HoiVien
CREATE TABLE HoiVien
(
    MaHV CHAR(10) PRIMARY KEY,
    TenKhachHang NVARCHAR(255),
    GioiTinh NVARCHAR(10),
    Email NVARCHAR(255),
    SDT NVARCHAR(20) UNIQUE,
    TichDiem INT DEFAULT 0,
    CCCD NVARCHAR(20)
);

-- 2 Bảng DatDV
CREATE TABLE DatDV
(
    MaDL CHAR(10) PRIMARY KEY,
    MaHV CHAR(10),
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
    SoLuong INT,
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
    Thuoc CHAR(10),
    MaChuong CHAR(10),
    FOREIGN KEY (MaGiong) REFERENCES Giong(MaGiong) ON DELETE CASCADE  ON UPDATE CASCADE,
    FOREIGN KEY (Thuoc) REFERENCES HoiVien(MaHV) ON DELETE CASCADE  ON UPDATE CASCADE,
    FOREIGN KEY (MaChuong) REFERENCES Chuong(MaChuong) ON DELETE CASCADE  ON UPDATE CASCADE
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
    SDT NVARCHAR(20),
    Email NVARCHAR(255),
    TrangThai NVARCHAR(20),
    Hinh NVARCHAR(MAX),
    MaVT CHAR(10),
    FOREIGN KEY (MaVT) REFERENCES VaiTro(MaVT) ON UPDATE CASCADE
);


--11 Bảng TaiKhoan
CREATE TABLE TaiKhoan
(
    TaiKhoan NVARCHAR(50) PRIMARY KEY,
    MatKhau NVARCHAR(50),
    MaNV CHAR(10),
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON UPDATE CASCADE
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
    GiaTien MONEY,
    TenSP NVARCHAR(255),
    DonVi NVARCHAR(20) DEFAULT 'Cái',
    PhanTram FLOAT DEFAULT 0.1,
    MaLoaisp CHAR(10),
    MaNhaCC CHAR(10),
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

--20 Bảng PhuongThucThanhToan  
CREATE TABLE PhuongThucThanhToan
(
    MaPTTT CHAR(10) PRIMARY KEY,
    TenPhuongThuc NVARCHAR(255)
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
    MaPTTT CHAR(10),
    MaDL CHAR(10),
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (MaHV) REFERENCES HoiVien(MaHV) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (MaPhieuGiamGia) REFERENCES PhieuGiamGia(MaPhieuGiamGia) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (MaPTTT) REFERENCES PhuongThucThanhToan(MaPTTT) ON UPDATE CASCADE,
    FOREIGN KEY (MaDL) REFERENCES DatDV(MaDL) ON DELETE NO ACTION ON UPDATE NO ACTION  -- Modified foreign key
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

--24 Bảng ChiTietHoaDon_TC
CREATE TABLE ChiTietHoaDon_TC
(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MaHoaDon CHAR(10),
    MaSP CHAR(10),
    MaTC CHAR(10),
    SoLuong INT,
    FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP) ON DELETE SET NULL ON UPDATE CASCADE,
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

-- Dữ liệu mẫu
INSERT INTO HoiVien
VALUES
    ('HV01', N'Nguyễn Tấn Hiếu', N'Nam', 'hieunt@gmail.com', N'0927594734', 100, N'0927594734'),
    ('HV02', N'Nguyễn Hữu Trí', N'Nam', 'trinh@gmail.com', N'0946984711', 50, N'0946984711'),
    ('HV03', N'Võ Quốc Hưng', N'Nam', 'qhung@gmail.com', N'0368588531', 50, N'074504009006');

-- Thêm dữ liệu cho bảng DichVu và DatDV
INSERT INTO DichVu
VALUES
    ('SPA01', N'Dịch vụ Spa, Chăm sóc thú cưng', N'Lộ trình', 1000000),
    ('RE01', N'Dịch vụ thuê thú cưng', N'Lần', 100000);

INSERT INTO DatDV
VALUES
    ('DL01', 'HV01', GETDATE(), N'Đã nhận', '', NULL, 1),
    ('DL02', 'HV02', GETDATE(), N'Đã nhận', '', NULL, 1),
    ('DL03', 'HV03', GETDATE(), N'Đã nhận', '', NULL, 1),
    ('DL04', 'HV01', GETDATE(), N'Đã nhận', '', NULL, 1);

-- Thêm dữ liệu cho bảng ChiTietDL
INSERT INTO ChiTietDL
VALUES
    ('DL01', 'SPA01', 1),
    ('DL02', 'SPA01', 1),
    ('DL03', 'RE01', 1),
    ('DL04', 'RE01', 2);

-- Thêm dữ liệu cho bảng LoaiVat và Giong
INSERT INTO LoaiVat
VALUES
    ('D01', N'Chó nội địa'),
    ('D02', N'Chó nước ngoài');

INSERT INTO Giong
VALUES
    ('PUL01', N'Chó mặt xệ (BullDog)', 'D02'),
    ('PUL02', N'Chó Pitbull', 'D02'),
    ('SB01', N'Chó Shiba', 'D02');

-- Thêm dữ liệu cho bảng Chuong
INSERT INTO Chuong
VALUES
    ('CH01', N'Trống', ''),
    ('CH02', N'Đã có', '');

-- Thêm dữ liệu cho bảng ThuCung
INSERT INTO ThuCung
VALUES
    ('TC01', '', 100000, '2022-02-20', 6, 'PUL01', 0, 'HV01', 'CH01'),
    ('TC02', '', 120000, '2021-02-20', 8, 'PUL02', 1, NULL, 'CH02'),
    ('TC03', '', 120000, '2020-02-20', 8, 'SB01', 0, 'HV03', 'CH01'),
    ('TC04', '', 120000, '2023-02-20', 8, 'PUL02', 1, NULL, 'CH01');

-- Thêm dữ liệu cho bảng VaiTro
INSERT INTO VaiTro
VALUES
    (0, N'Nhân viên'),
    (1, N'Quản lí');

-- Thêm dữ liệu cho bảng NhanVien
INSERT INTO NhanVien
VALUES
    ('NV01', N'Lê Quốc Huy', N'Nam', '1954-12-3', N'0928768265', 'cuonglh@gmail.com', N'Đang làm', '..\PetShop\src\main\java\com\app\img\logo_menu.jpg', 1),
    ('NV02', N'Đỗ Văn Minh', N'Nữ', '1983-8-19', N'0968095685', 'minhdv@gmail.com', N'Đã nghỉ', '..\PetShop\src\main\java\com\app\img\logo_menu.jpg', 0),
    ('NV03', N'Võ Hoài Hưng', N'Nam', '2004-8-19', N'0956872574', 'hhung@gmail.com', N'Đang làm', '..\PetShop\src\main\java\com\app\img\logo_menu.jpg', 0),
    ('NV04', N'Châu Tinh Trì', N'Nam', '1985-4-29', N'0964687963', 'tinhtri12@gmail.com', N'Đang làm', '..\PetShop\src\main\java\com\app\img\logo_menu.jpg', 0);

-- Thêm dữ liệu tài khoản
INSERT INTO TaiKhoan
VALUES
    ('TK01', '1', 'NV01'),
    ('TK02', '2', 'NV02');

-- Thêm dữ liệu nhà cung cấp

INSERT INTO NhaCungCap
VALUES
    ('NCC01', N'Nhà cung cấp thức ăn thú cưng', N'Bình Tân'),
    ('NCC02', N'Nhà cung giống thú cưng', N'Quận 7');

-- Thêm dữ liệu loại sản phẩm

INSERT INTO LoaiSanPham
VALUES
    ('TA01', N'Thức ăn cho thú cưng'),
    ('QA02', N'Quần áo cho thú cưng');

-- Thêm dữ liệu sản phẩm

INSERT INTO SanPham
VALUES
    ('SP01', 76000, N'Pate cho mèo', N'cái', 0.1, 'TA01', 'NCC01'),
    ('SP02', 36000, N'Áo cho chó', N'cái', 0.1, 'QA02', 'NCC02');

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

INSERT INTO tonkho
VALUES
    ('KHO1', 'SP01', 100),
    ('KHO1', 'SP02', 100);


-- Thêm dữ liệu chi tiết nhập hàng

INSERT INTO ChiTietNhapHang
VALUES
    ('PN01', 'SP01', 'NCC01', 100000),
    ('PN02', 'SP02', 'NCC02', 100000);

-- Thêm dữ liệu phương thức thành toán

INSERT INTO PhuongThucThanhToan
VALUES
    ('CK', N'Chuyển khoản'),
    ('TM', N'Tiền mặt');

-- Thêm dữ liệu phiếu giảm giá

INSERT INTO PhieuGiamGia
VALUES
    ('DISCOUNT1', 1.2, '2023-11-3', '2023-11-29'),
    ('DISCOUNT2', 1.1, '2023-12-1', '2023-12-27');

-- Thêm dữ liệu hóa đơn

INSERT INTO HoaDon
VALUES
    ('HD01', 'NV01', '2023-11-10', '2000000', 'HV02', 'DISCOUNT1', N'Đã thanh toán', N'CK', 'DL01'),
    ('HD02', 'NV02', '2023-11-10', '1000000', 'HV01', 'DISCOUNT1', N'Đã hủy', N'CK', 'DL02'),
    ('HD03', 'NV02', '2023-11-11', '1120000', 'HV03', 'DISCOUNT2', N'Đã thanh toán', N'CK', 'DL03'),
    ('HD04', 'NV03', GETDATE(), '1000000', 'HV01', 'DISCOUNT2', N'Đã thanh toán', N'CK', 'DL04'),
    ('HD05', 'NV04', GETDATE(), '1000000', 'HV02', 'DISCOUNT2', N'Đã hủy', N'CK', 'DL01'),
    ('HD6', 'NV01', '2023-12-05', 1500000, 'HV01', 'DISCOUNT1', N'Đã thanh toán', N'CK', 'DL01'),
    ('HD7', 'NV02', '2023-12-10', 800000, 'HV02', 'DISCOUNT1', N'Đã hủy', N'CK', 'DL02'),
    ('HD8', 'NV02', '2023-12-15', 920000, 'HV03', 'DISCOUNT2', N'Đã thanh toán', N'CK', 'DL03'),
    ('HD9', 'NV03', '2024-01-02', 1000000, 'HV01', 'DISCOUNT2', N'Đã thanh toán', N'CK', 'DL04'),
    ('HD10', 'NV04', '2024-02-20', 1000000, 'HV02', 'DISCOUNT2', N'Đã hủy', N'CK', 'DL01'),
    ('HD11', 'NV01', '2024-03-08', 1500000, 'HV01', 'DISCOUNT1', N'Đã thanh toán', N'CK', 'DL01'),
    ('HD12', 'NV02', '2024-03-15', 800000, 'HV02', 'DISCOUNT1', N'Đã hủy', N'CK', 'DL02'),
    ('HD13', 'NV02', '2024-04-01', 920000, 'HV03', 'DISCOUNT2', N'Đã thanh toán', N'CK', 'DL03'),
    ('HD14', 'NV03', '2024-05-12', 1000000, 'HV01', 'DISCOUNT2', N'Đã thanh toán', N'CK', 'DL04'),
    ('HD15', 'NV04', '2024-06-30', 1000000, 'HV02', 'DISCOUNT2', N'Đã hủy', N'CK', 'DL01');


-- Thêm dữ liệu hóa đơn



INSERT INTO ChiTietHoaDon
VALUES
    ('HD01', 'SP01', 10),
    ('HD02', 'SP02', 10);

INSERT INTO ChiTietHoaDon_TC
Values
    ('HD01', 'SP01', 'TC01', 2);

INSERT INTO CaLam
Values
    ('CL01','7:00:00-12:00:00', N'ca sáng'),
    ('CL02','12:00:00-17:00:00',N'ca chiều');

INSERT INTO ChiTietCaLam
Values
    ('CL01','NV01','2021/01/23'),
    ('CL02','NV02','2022/02/06');


-- lấy ra thông tin của kho
CREATE PROCEDURE dbo.ThongSoKho
AS
BEGIN
   SELECT 
       (SELECT COUNT(*) FROM PhieuNhapHang) AS TongNhap,
       (SELECT COUNT(*) FROM HoaDon) AS TongXuat,  
       (SELECT COUNT(*) FROM SanPham) AS TongSanPham,
       (SELECT SUM(soluong) FROM tonkho) AS TongSoLuongSanPham
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
    SELECT 'KHO1', inserted.MaSP, 0
    FROM inserted;
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

    WITH DateList AS (
        SELECT @Today AS [Date]
        UNION ALL
        SELECT DATEADD(DAY, 1, [Date])
        FROM DateList
        WHERE [Date] < @LastDayOfMonth
    )

    SELECT [Date]
    FROM DateList
    OPTION (MAXRECURSION 0);
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

SELECT * FROM ChiTietCaLam