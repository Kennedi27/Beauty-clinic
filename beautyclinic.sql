-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 30, 2020 at 04:21 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `beautyclinic`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` char(12) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `telp` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `nama`, `telp`) VALUES
('PLGN001', 'Kennedi Riado Nadeak', '081234567781'),
('PLGN002', 'Muhammad Afif', '081377787656'),
('PLGN003', 'Genta Syahputra', '089712349898');

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `no_transaksi` char(12) NOT NULL,
  `pelanggan` varchar(255) NOT NULL,
  `dokter` varchar(255) NOT NULL,
  `tanggal` varchar(255) NOT NULL,
  `total_harga_bayar` int(11) NOT NULL,
  `kasir` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Triggers `detail_transaksi`
--
DELIMITER $$
CREATE TRIGGER `delete_transaksi` AFTER DELETE ON `detail_transaksi` FOR EACH ROW BEGIN
DELETE FROM transaksi WHERE transaksi.no_transaksi = OLD.no_transaksi;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `id` char(12) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `telp` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`id`, `nama`, `alamat`, `telp`) VALUES
('DKT0001', 'Kennedi Riado Nadeak', 'Perum Putri 7 Batu Aji', '081967433456'),
('DKT0002', 'Rido Dwi Mareta', 'Piayu', '08123455'),
('DKT0003', 'Cyntia Maharani', 'Batu Aji', '081298986565');

-- --------------------------------------------------------

--
-- Table structure for table `layanan`
--

CREATE TABLE `layanan` (
  `kode` char(12) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `layanan`
--

INSERT INTO `layanan` (`kode`, `nama`, `harga`) VALUES
('LYN001', 'Normal Facial', 120000),
('LYN002', 'Acne Facial', 150000),
('LYN003', 'Enzyme Facial', 175000),
('LYN004', 'Microdermabrasion Facial', 165000),
('LYN005', 'Collagen Facial', 125000);

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `telp` char(13) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(50) NOT NULL,
  `posisi` enum('admin','kasir') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `nama`, `alamat`, `telp`, `username`, `password`, `posisi`) VALUES
(1, 'Kennedi Riado Nadeak', 'Batu Aji', '089509666326', 'kennedi27', 'kennedi27', 'admin'),
(2, 'Rido Dwi Mareta', 'Piayu', '081248489898', 'rido27', 'rido27', 'kasir');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `kode` char(12) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`kode`, `nama`, `stok`, `harga`) VALUES
('PRDK001', 'Foundation', 100, 45000),
('PRDK002', 'Powder', 100, 65000),
('PRDK003', 'BB Cream', 100, 60000),
('PRDK004', 'CC Cream', 100, 77000),
('PRDK005', 'Moisturizer', 100, 50000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `no_transaksi` char(12) NOT NULL,
  `layanan` varchar(255) DEFAULT NULL,
  `harga_layanan` int(11) NOT NULL,
  `produk` varchar(255) DEFAULT NULL,
  `tanggal` varchar(15) NOT NULL,
  `qty` int(11) NOT NULL,
  `totalHargaProduk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Triggers `transaksi`
--
DELIMITER $$
CREATE TRIGGER `stok_produk` AFTER INSERT ON `transaksi` FOR EACH ROW BEGIN UPDATE produk SET produk.stok = produk.stok - NEW.qty WHERE produk.nama = NEW.produk;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `stok_produk2` AFTER DELETE ON `transaksi` FOR EACH ROW BEGIN UPDATE produk SET produk.stok = produk.stok + OLD.qty WHERE produk.nama = OLD.produk;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`no_transaksi`);

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `layanan`
--
ALTER TABLE `layanan`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
