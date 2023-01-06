-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 06, 2023 at 05:43 AM
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
  `tinh_trang` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `hoc_vien`
--

INSERT INTO `hoc_vien` (`ma_hoc_vien`, `ho_ten`, `ngay_sinh`, `gioi_tinh`, `so_dien_thoai`, `email`, `tinh_trang`) VALUES
(1, 'Trương Anh Tuấn', '2001-11-14', 1, '0971528594', 'tuanchibi14112001', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hoc_vien`
--
ALTER TABLE `hoc_vien`
  ADD PRIMARY KEY (`ma_hoc_vien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoc_vien`
--
ALTER TABLE `hoc_vien`
  MODIFY `ma_hoc_vien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
