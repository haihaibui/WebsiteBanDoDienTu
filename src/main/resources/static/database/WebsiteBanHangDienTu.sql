CREATE DATABASE WebsiteBanHangDienTu

GO

USE WebsiteBanHangDienTu

GO

CREATE TABLE nguoi_dung(
	ma_nguoi_dung VARCHAR(50) NOT NULL PRIMARY KEY,
	mat_khau VARCHAR(50) NOT NULL,
	ho_ten NVARCHAR (100) NOT NULL,
	gioi_tinh BIT NOT NULL,
	ngay_sinh DATE,
	so_dien_thoai VARCHAR(15),
	dia_chi NVARCHAR(200),
	email VARCHAR(50) NOT NULL,
	hinh_anh NVARCHAR(100),
	ngay_dang_ky DATE NOT NULL,
	vai_tro NVARCHAR(20) NOT NULL,
	trang_thai BIT NOT NULL
)

CREATE TABLE chung_loai(
	ma_chung_loai VARCHAR(20) PRIMARY KEY NOT NULL,
	ten_chung_loai NVARCHAR(100) NOT NULL,
)

CREATE TABLE nha_cung_cap(
	ma_nha_cung_cap VARCHAR(20) PRIMARY KEY NOT NULL,
	ten_nha_cung_cap NVARCHAR(100) NOT NULL
)

CREATE TABLE thuoc_tinh_dac_biet(
	ma_thuoc_tinh_dac_biet VARCHAR(20) PRIMARY KEY NOT NULL,
	ten_thuoc_tinh_dac_biet NVARCHAR(100) NOT NULL
) 

CREATE TABLE san_pham(
	ma_san_pham VARCHAR(20) NOT NULL PRIMARY KEY,
	ten_san_pham NVARCHAR(100) NOT NULL,
	so_luong INT NOT NULL,
	gia_tien FLOAT NOT NULL,
	mo_ta NVARCHAR(200),
	hinh_anh NVARCHAR(100),
	trang_thai BIT,
	ma_cl VARCHAR(20) NOT NULL,
	ma_ncc VARCHAR(20) NOT NULL,
	ma_ttdb VARCHAR(20) NOT NULL,
	FOREIGN KEY (ma_cl) REFERENCES chung_loai(ma_chung_loai),
	FOREIGN KEY (ma_ncc) REFERENCES nha_cung_cap(ma_nha_cung_cap),
	FOREIGN KEY (ma_ttdb) REFERENCES thuoc_tinh_dac_biet(ma_thuoc_tinh_dac_biet)
)

CREATE TABLE gio_hang(
	ma_gio_hang INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	ma_nd VARCHAR(50) NOT NULL,
	ma_sp VARCHAR(20) NOT NULL,
	so_luong INT NOT NULL,
	FOREIGN KEY (ma_nd) REFERENCES nguoi_dung(ma_nguoi_dung),
	FOREIGN KEY (ma_sp) REFERENCES san_pham(ma_san_pham)
)

CREATE TABLE don_hang(
	ma_don_hang INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	ngay_lap_don DATE NOT NULL,
	dia_chi_giao NVARCHAR(200) NOT NULL,
	trang_thai NVARCHAR(50) NOT NULL,
	ma_nd VARCHAR(50) NOT NULL,
	FOREIGN KEY (ma_nd) REFERENCES nguoi_dung(ma_nguoi_dung)
)

CREATE TABLE don_hang_chi_tiet(
	ma_don_hang_chi_tiet  INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	so_luong INT NOT NULL,
	gia_tien FLOAT NOT NULL,
	ma_sp VARCHAR(20) NOT NULL,
	ma_dh INT NOT NULL,
	FOREIGN KEY (ma_sp) REFERENCES san_pham(ma_san_pham),
	FOREIGN KEY (ma_dh) REFERENCES don_hang(ma_don_hang) ON DELETE CASCADE
)

/*Thêm dữ liệu vào các bảng*/
INSERT INTO nguoi_dung VALUES
	('hoang0207', '02072003', N'Nguyễn Văn Kim Hoàng', 1, '2003-07-02', '0849314345', N'293 Nam Kỳ Khởi Nghĩa, TP.HCM', 'hoangnvksp24867@fpt.edu.vn', null, '2024-10-3', N'Quản lý', 1),
	('hoa232', '1234567', N'Lưu Đức Hòa', 1, '2003-01-03', '0979324347', N'85 Phan Kế Bính, Đa Kao, Quận 1, Hồ Chí Minh', 'hoa2222@gmail.com', null, '2024-10-3', N'Nhân viên', 1),
	('thanh222', '222333', N'Nguyễn Văn Thanh', 1, '2003-11-30', '0849314345', N'142 Nguyễn Văn Công, Phường 3, Gò Vấp, Hồ Chí Minh', 'thanh23232@gmail.com', null, '2024-10-3', N'Khách hàng', 1),
	('long888', '19102004', N'Trần Chiến Long', 1, '2003-03-02', '0908730881', N'345 Tô Ký, Trung Mỹ Tây, Quận 12, Hồ Chí Minh', 'long888@gmail.com', null, '2024-10-3', N'Khách hàng', 1),
	('linh775', '232323', N'Nguyễn Kiều Thảo Linh', 0, '2003-05-06', '0909748663', N'194 Hoàng Văn Thụ, Phường 9, Phú Nhuận, Hồ Chí Minh', 'Linh775@gmail.com', null, '2024-10-3', N'Khách hàng', 1),
	('Thang443', '222333', N'Trần Ngọc Thắng', 1, '2003-04-23', '0907574883', N'141 Lê Thị Nho, Trung Mỹ Tây, Quận 12, Hồ Chí Minh', 'Thang443@gmail.com', null, '2024-10-3', N'Khách hàng', 1)

INSERT INTO chung_loai VALUES
	('CL001', N'Máy tính xách tay'),
	('CL002', N'Bo mạch chủ'),
	('CL003', N'Card màn hình'),
	('CL004', N'Chip xử lý CPU')

INSERT INTO nha_cung_cap VALUES
	('NCC001', N'Asus'),
	('NCC002', N'Msi'),
	('NCC003', N'Lenovo'),
	('NCC004', N'intel'),
	('NCC005', N'AMD')


INSERT INTO thuoc_tinh_dac_biet VALUES
	('TTDB001',N'Hàng nổi bật'),
	('TTDB002',N'Hàng mới')

INSERT INTO san_pham VALUES
	('SP001', N'Laptop Asus VivoBook 14X', 10, 23490000, N'Laptop Asus VivoBook 14X là một trong những chiếc laptop đáng chú ý trên thị trường hiện nay, đặc biệt dành cho những người dùng yêu thích thiết kế đẹp mắt và trải nghiệm hình ảnh sắc nét.', 'hinh1.png', 1, 'CL001', 'NCC001', 'TTDB001'),
	('SP002', N'Laptop ASUS ProArt',  5, 69490000, N'Laptop ASUS ProArt là lựa chọn hàng đầu cho những ai đang tìm kiếm một chiếc máy tính xách tay cao cấp và tiện lợi.', 'hinh2.png', 1, 'CL001', 'NCC001', 'TTDB002'),
	('SP003', N'Laptop MSI Modern 14', 7, 9990000, N'Một trong những siêu phẩm sở hữu thiết kế năng động cấu hình mạnh mẽ đến từ con chip gen 12 đáp ứng mọi nhu cầu công việc hằng ngày.', 'hinh3.png', 1, 'CL001', 'NCC002', 'TTDB002'),
	('SP004', N'Laptop Lenovo V15 G3 ABA', 15, 9990000, N'Lenovo V15 G3 ABA là chiếc laptop văn phòng chỉn chu từ thiết kế, hoàn thiện về cấu hình sẽ không làm các bạn học sinh - sinh viên thất vọng.', 'hinh4.png', 1, 'CL001', 'NCC003', 'TTDB001'),
	('SP005', N'Bo mạch chủ ASUS Strix B760', 10, 4990000, N'Bộ phận tản nhiệt trên mainboard ASUS ROG STRIX B760 được bố trí hợp lý và tối ưu hóa các khe VRM và M2 để đảm bảo hiệu suất.', 'hinh5.png', 1, 'CL002', 'NCC001', 'TTDB002'),
	('SP006', N'Mainboard Gigabyte B760M GAMING X DDR4', 12, 5199000, N'một chiêc main boar cực kì mạnh mẽ hỗ trợ cho con chip của đội xanh với 4 khe ram tối đa tới 128gb giúp bạn thoải mái trong việc lựa chọn', 'hinh6.png', 1, 'CL002', 'NCC001', 'TTDB002'),
	('SP007', N'Card màn hình Asus TUF RTX 4070 SUPER-O12G GAMING', 11, 21999000, N'Chiếc card đồ họa cực kì mạnh mẽ tới từ nhà NVDIA với hiệu năng vượt trội và giá thành lại không quá đắt như 4070 ti', 'hinh7.png', 1, 'CL003', 'NCC001', 'TTDB002'),
	('SP008', N'Card màn hình Asus DUAL RX 6600 8GB-V3', 13, 5499000, N'Một chiếc card quốc dân ở tầm giá rẻ đến từ đội đỏ sản phẩm này mang 1 hiệu năng ấn tượng so với tầm giá của nó', 'hinh8.png', 1, 'CL003', 'NCC001', 'TTDB002'),
	('SP009', N'CPU Intel Core i7-14700K', 18, 12999000, N'Chiếc CPU mạnh mẽ đến từ đội xanh với hiệu năng vượt trội đảm bảo mượt mà khi trải nghiệm', 'hinh9.png', 1, 'CL004', 'NCC004', 'TTDB001'),
    ('SP010', N'CPU AMD Ryzen 9 5900X', 15, 14499000, N'Chiếc CPU này có 1 hiệu năng vượt trội đảm bảo mang lại trải nghiệm làm việc và học tập tốt nhất', 'hinh10.png', 1, 'CL004', 'NCC005', 'TTDB001')

INSERT INTO gio_hang VALUES
	('thanh222', 'SP001', 1),
	('hoang0207', 'SP003', 1),
	('long888', 'SP006', 1),
	('Thang443', 'SP005', 1)


INSERT INTO don_hang VALUES
	('2024-6-3', N'293 Nam Kỳ Khởi Nghĩa, TP.HCM', N'Chờ xác nhận', 'hoang0207'),
	('2024-6-3', N'85 Phan Kế Bính, Đa Kao, Quận 1, Hồ Chí Minh', N'Đang xử lý', 'hoa232'),
	('2024-6-3', N'85 Phan Kế Bính, Đa Kao, Quận 1, Hồ Chí Minh', N'Đang vận chuyển', 'hoa232'),
	('2024-6-3', N'142 Nguyễn Văn Công, Phường 3, Gò Vấp, Hồ Chí Minh', N'Đã giao', 'thanh222'),
	('2024-7-3', N'142 Nguyễn Văn Công, Phường 3, Gò Vấp, Hồ Chí Minh', N'Đã giao', 'thanh222'),
	('2024-7-3', N'345 Tô Ký, Trung Mỹ Tây, Quận 12, Hồ Chí Minh', N'Đã giao', 'long888'),
	('2024-7-3', N'345 Tô Ký, Trung Mỹ Tây, Quận 12, Hồ Chí Minh', N'Đã giao', 'long888'),
	('2024-7-3', N'141 Lê Thị Nho, Trung Mỹ Tây, Quận 12, Hồ Chí Minh', N'Đã hủy', 'thang443'),
	('2024-8-3', N'194 Hoàng Văn Thụ, Phường 9, Phú Nhuận, Hồ Chí Minh', N'Đã giao', 'linh775'),
	('2024-8-5', N'345 Tô Ký, Trung Mỹ Tây, Quận 12, Hồ Chí Minh', N'Đã giao', 'long888'),
	('2024-8-8', N'142 Nguyễn Văn Công, Phường 3, Gò Vấp, Hồ Chí Minh', N'Đã hủy', 'thanh222'),
	('2024-9-3', N'85 Phan Kế Bính, Đa Kao, Quận 1, Hồ Chí Minh', N'Đang vận chuyển', 'hoa232'),
	('2024-9-3', N'293 Nam Kỳ Khởi Nghĩa, TP.HCM', N'Chờ xác nhận', 'hoang0207'),
	('2024-10-5', N'345 Tô Ký, Trung Mỹ Tây, Quận 12, Hồ Chí Minh', N'Đã giao', 'long888'),
	('2024-10-3', N'85 Phan Kế Bính, Đa Kao, Quận 1, Hồ Chí Minh', N'Đang vận chuyển', 'hoa232')

INSERT INTO don_hang_chi_tiet VALUES
	(1, 23490000, 'SP001', 1),
	(1, 4990000, 'SP005', 2),
	(2, 9990000, 'SP004', 3),
	(2, 9990000, 'SP004', 4),
	(3, 4990000, 'SP005', 5),
	(1, 23490000, 'SP001', 5),
	(1, 69490000, 'SP002', 6),
	(1, 9990000, 'SP003', 7),
	(2, 4990000, 'SP004', 8),
	(3, 16497000, 'SP006', 9),
	(2, 10998000, 'SP008', 10),
	(1, 9990000, 'SP004', 11),
	(1, 5499000, 'SP008', 12),
	(1, 69490000, 'SP002', 13),
	(3, 16497000, 'SP008', 14),
	(1, 12999000, 'SP009', 15)


SELECT 	
	MONTH(ngay_lap_don) AS thang,
	YEAR(ngay_lap_don) AS nam,
	SUM(so_luong*gia_tien) AS tong_doanh_thu
FROM don_hang 
	JOIN don_hang_chi_tiet ON don_hang.ma_don_hang = don_hang_chi_tiet.ma_dh
WHERE trang_thai LIKE N'%Đã giao%'
GROUP BY 
	MONTH(ngay_lap_don), 
	YEAR(ngay_lap_don)
ORDER BY nam, thang
