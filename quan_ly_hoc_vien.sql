-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 05, 2023 at 04:55 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quan_ly_hoc_vien`
--

-- --------------------------------------------------------

--
-- Table structure for table `hoc_vien`
--

CREATE TABLE `hoc_vien` (
  `ma_hoc_vien` int(11) NOT NULL,
  `ho_ten` varchar(255) NOT NULL,
  `ngay_sinh` date NOT NULL,
  `gioi_tinh` int(11) NOT NULL,
  `so_dien_thoai` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tinh_trang` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `hoc_vien`
--

INSERT INTO `hoc_vien` (`ma_hoc_vien`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `so_dien_thoai`, `email`, `tinh_trang`) VALUES
(13, 'Trần Cao Minh', '2001-01-01', 1, '0350111111', 'nang2@gmail.com', b'1'),
(14, 'Trần Xuân Năng', '2001-01-01', 1, '0350111112', 'nang1@gmail.com', b'1'),
(15, 'Nguyễn Đức Thái', '2001-01-02', 1, '0350111113', 'nang3@gmail.com', b'1'),
(16, 'Trần Quang Huy', '2001-01-03', 1, '0350111114', 'nang4@gmail.com', b'1'),
(17, 'Phạm Đắc An', '2001-01-03', 1, '0350111115', 'nang3@gmail.com', b'1'),
(18, 'Hà Thị Linh', '2001-01-04', 1, '0350111116', 'nang4@gmail.com', b'1'),
(19, 'Nguyễn Thị Hoài Thu', '2001-01-05', 0, '0350111117', 'nang5@gmail.com', b'1'),
(20, 'Nguyễn Tuấn Anh', '2001-01-06', 1, '0350111118', 'nang6@gmail.com', b'1'),
(21, 'Nguyễn Việt Anh', '2001-01-07', 1, '0350111119', 'nang7@gmail.com', b'1'),
(22, 'Đào Ngọc Bản', '2001-01-08', 1, '0350111120', 'nang8@gmail.com', b'1'),
(23, 'Nguyễn Công Bình', '2001-01-09', 1, '0350111121', 'nang9@gmail.com', b'1'),
(24, 'Phạm Đắc Tùng', '2001-01-17', 1, '0350111222', 'nang10@gmail.com', b'1'),
(25, 'Hà Thị Trang', '2001-01-18', 0, '0350111223', 'nang11@gmail.com', b'1'),
(26, 'Nguyễn Thị Hoài Anh', '2001-01-19', 0, '0350111224', 'nang12@gmail.com', b'1'),
(27, 'Nguyễn Tuấn Minh', '2001-01-20', 1, '0350111225', 'nang13@gmail.com', b'1'),
(28, 'Nguyễn Việt Hùng', '2001-01-21', 1, '0350111226', 'nang14@gmail.com', b'1'),
(29, 'Đào Ngọc Thái', '2001-01-15', 1, '0350111227', 'nang15@gmail.com', b'1'),
(30, 'NNguyễn Công Huy', '2001-01-16', 1, '0350111228', 'nang16@gmail.com', b'1'),
(31, 'Trương Anh Tuấn', '2001-11-14', 1, '0971528594', 'tuanchibi14112001@gmail.com', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `khoa_hoc`
--

CREATE TABLE `khoa_hoc` (
  `ma_khoa_hoc` int(11) NOT NULL,
  `ten_khoa_hoc` varchar(255) NOT NULL,
  `trinh_do` varchar(30) NOT NULL,
  `mo_ta` text NOT NULL,
  `hoc_phi` int(15) NOT NULL,
  `ngay_bat_dau` date NOT NULL,
  `ngay_ket_thuc` date NOT NULL,
  `tinh_trang_kh` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khoa_hoc`
--

INSERT INTO `khoa_hoc` (`ma_khoa_hoc`, `ten_khoa_hoc`, `trinh_do`, `mo_ta`, `hoc_phi`, `ngay_bat_dau`, `ngay_ket_thuc`, `tinh_trang_kh`) VALUES
(5, 'N3_Junbi_02_2023', 'N3', 'Khóa học chuẩn bị thi N3', 500000, '2023-02-11', '2023-03-20', b'1'),
(6, 'N1_Kaiwa_02_2023', 'N1', 'Khóa học luyện nói trình độ N1', 700000, '2023-02-10', '2023-03-10', b'1'),
(7, 'N5_Kaiwa_02_2023', 'N5', 'Khóa học luyện nói trình độ N5', 500000, '2023-02-10', '2023-03-10', b'1'),
(8, 'N3_Kaiwa_02_2023', 'N3', 'Khóa học luyện nói trình độ N3', 500000, '2023-02-09', '2023-03-09', b'1'),
(9, 'N2_Kaiwa_02_2023', 'N2', 'Khóa học luyện nói trình độ N2', 600000, '2023-02-11', '2023-03-11', b'1'),
(12, 'N2_Junbi_02_2023', 'N2', '- Khoa hoc chuan bi N2', 700000, '2023-02-10', '2023-03-17', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `lop_hoc`
--

CREATE TABLE `lop_hoc` (
  `ma_lop_hoc` int(10) NOT NULL,
  `lich_hoc` varchar(255) NOT NULL,
  `ma_khoa_hoc` int(10) NOT NULL,
  `tinh_trang_lh` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lop_hoc`
--

INSERT INTO `lop_hoc` (`ma_lop_hoc`, `lich_hoc`, `ma_khoa_hoc`, `tinh_trang_lh`) VALUES
(6, 'Thứ 2, 4, 6 hàng tuần - 15h30-17h30', 8, b'1'),
(7, 'Thứ 2, 4, 6 hàng tuần - 7h30-9h30', 7, b'1'),
(8, 'Thứ 2, 4, 6 hàng tuần - 19h30-21h30', 7, b'1'),
(9, 'Thứ 3, 5, 7 hàng tuần - 7h30-9h30', 8, b'1'),
(10, 'Thứ 3, 5, 7 hàng tuần - 15h30-17h30', 9, b'1'),
(11, 'Thứ 3, 5, 7 hàng tuần - 7h30-9h30', 9, b'1'),
(16, 'Thứ 3, 5, 7 hàng tuần - 7h30-9h30', 8, b'1'),
(17, 'Thứ 2, 4, 6 hàng tuần - 15h30-17h30', 5, b'1'),
(19, 'Thứ 2, 4, 6 hàng tuần - 19h30-21h30', 12, b'1'),
(20, 'Thứ 3, 5, 7 hàng tuần - 7h30-9h30', 5, b'1'),
(21, 'Thứ 3, 5, 7 hàng tuần - 19h30-21h30', 9, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `lop_hoc_chi_tiet`
--

CREATE TABLE `lop_hoc_chi_tiet` (
  `ma_lop_hoc` int(11) NOT NULL,
  `ma_hoc_vien` int(11) NOT NULL,
  `ngay_dang_ky` date NOT NULL,
  `thanh_toan` bit(1) NOT NULL,
  `tinh_trang` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lop_hoc_chi_tiet`
--

INSERT INTO `lop_hoc_chi_tiet` (`ma_lop_hoc`, `ma_hoc_vien`, `ngay_dang_ky`, `thanh_toan`, `tinh_trang`) VALUES
(6, 15, '2023-02-10', b'1', b'1'),
(6, 18, '2023-02-10', b'1', b'1'),
(6, 19, '2023-02-10', b'1', b'1'),
(6, 20, '2023-02-10', b'1', b'1'),
(6, 21, '2023-02-10', b'1', b'1'),
(6, 23, '2023-02-10', b'1', b'1'),
(6, 25, '2023-02-10', b'1', b'1'),
(6, 26, '2023-02-10', b'1', b'1'),
(6, 27, '2023-02-10', b'1', b'1'),
(6, 28, '2023-02-10', b'1', b'1'),
(7, 18, '2023-02-10', b'1', b'1'),
(7, 19, '2023-02-10', b'1', b'1'),
(7, 20, '2023-02-10', b'1', b'1'),
(7, 25, '2023-02-10', b'1', b'1'),
(7, 26, '2023-02-10', b'1', b'1'),
(8, 19, '2023-02-10', b'0', b'1'),
(8, 20, '2023-02-10', b'1', b'0'),
(8, 23, '2023-02-10', b'1', b'1'),
(8, 25, '2023-02-10', b'1', b'1'),
(8, 26, '2023-02-10', b'1', b'1'),
(8, 27, '2023-02-10', b'1', b'1'),
(17, 18, '2023-02-10', b'1', b'1'),
(21, 18, '2023-02-10', b'1', b'1'),
(21, 25, '2023-02-10', b'0', b'0'),
(21, 26, '2023-02-10', b'1', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `tai_khoan`
--

CREATE TABLE `tai_khoan` (
  `ma_tai_khoan` int(11) NOT NULL,
  `ten_dang_nhap` varchar(50) NOT NULL,
  `mat_khau` varchar(50) NOT NULL,
  `tinh_trang` bit(1) NOT NULL DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tai_khoan`
--

INSERT INTO `tai_khoan` (`ma_tai_khoan`, `ten_dang_nhap`, `mat_khau`, `tinh_trang`) VALUES
(1, 'admin', 'admin', b'1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hoc_vien`
--
ALTER TABLE `hoc_vien`
  ADD PRIMARY KEY (`ma_hoc_vien`);

--
-- Indexes for table `khoa_hoc`
--
ALTER TABLE `khoa_hoc`
  ADD PRIMARY KEY (`ma_khoa_hoc`);

--
-- Indexes for table `lop_hoc`
--
ALTER TABLE `lop_hoc`
  ADD PRIMARY KEY (`ma_lop_hoc`),
  ADD KEY `ma_khoa_hoc` (`ma_khoa_hoc`);

--
-- Indexes for table `lop_hoc_chi_tiet`
--
ALTER TABLE `lop_hoc_chi_tiet`
  ADD PRIMARY KEY (`ma_lop_hoc`,`ma_hoc_vien`),
  ADD KEY `lien_ket_2` (`ma_hoc_vien`);

--
-- Indexes for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD PRIMARY KEY (`ma_tai_khoan`),
  ADD UNIQUE KEY `username` (`ten_dang_nhap`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoc_vien`
--
ALTER TABLE `hoc_vien`
  MODIFY `ma_hoc_vien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `khoa_hoc`
--
ALTER TABLE `khoa_hoc`
  MODIFY `ma_khoa_hoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `lop_hoc`
--
ALTER TABLE `lop_hoc`
  MODIFY `ma_lop_hoc` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `lop_hoc_chi_tiet`
--
ALTER TABLE `lop_hoc_chi_tiet`
  MODIFY `ma_lop_hoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `tai_khoan`
--
ALTER TABLE `tai_khoan`
  MODIFY `ma_tai_khoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `lop_hoc`
--
ALTER TABLE `lop_hoc`
  ADD CONSTRAINT `lop_hoc_ibfk_1` FOREIGN KEY (`ma_khoa_hoc`) REFERENCES `khoa_hoc` (`ma_khoa_hoc`);

--
-- Constraints for table `lop_hoc_chi_tiet`
--
ALTER TABLE `lop_hoc_chi_tiet`
  ADD CONSTRAINT `lien_ket_1` FOREIGN KEY (`ma_lop_hoc`) REFERENCES `lop_hoc` (`ma_lop_hoc`),
  ADD CONSTRAINT `lien_ket_2` FOREIGN KEY (`ma_hoc_vien`) REFERENCES `hoc_vien` (`ma_hoc_vien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
