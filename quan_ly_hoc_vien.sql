-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 12, 2023 at 05:26 PM
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
(1, 'Trương Anh Tuấn', '2001-11-14', 1, '0971528594', 'tuanchibi14112001', b'1'),
(2, 'Trần Xuân Năng', '2023-01-10', 1, '0333501404', 'nang3007@gmail.com', b'0'),
(3, 'Trần Xuân Năng', '2023-01-04', 1, '0333501404', 'nang3007@gmail.com', b'1');

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
(1, 'Khóa Kaiwa - N3', 'N5', 'Dành cho những bạn có trình độ ~ N3, N2.', 1000000, '2023-01-13', '2023-04-13', b'0'),
(2, 'Khóa luyện đề N3.', 'N5', '60 ngày đỗ N3.', 2000000, '2023-01-15', '2023-03-15', b'0'),
(3, 'Khóa luyện đề N2.', 'N1', 'Dành cho các bạn đã học xong kiến thức cơ bản N2.', 2131321, '2023-02-01', '2023-04-15', b'1'),
(4, 'Khóa luyện đề N5', 'N5', 'Dành cho các bạn mới học.\n<3', 10221220, '2023-01-13', '2023-03-12', b'0');

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
(1, 'Thứ 3, 5, 7 hàng tuần - 19h30-21h30', 2, b'1'),
(2, 'Thứ 2, 4, 6 hàng tuần - 15h30-17h30', 3, b'1');

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
  ADD PRIMARY KEY (`ma_lop_hoc`),
  ADD KEY `lien_ket_2` (`ma_hoc_vien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoc_vien`
--
ALTER TABLE `hoc_vien`
  MODIFY `ma_hoc_vien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `khoa_hoc`
--
ALTER TABLE `khoa_hoc`
  MODIFY `ma_khoa_hoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `lop_hoc`
--
ALTER TABLE `lop_hoc`
  MODIFY `ma_lop_hoc` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `lop_hoc_chi_tiet`
--
ALTER TABLE `lop_hoc_chi_tiet`
  MODIFY `ma_lop_hoc` int(11) NOT NULL AUTO_INCREMENT;

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
