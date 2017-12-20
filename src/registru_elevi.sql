-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20 Dec 2017 la 14:14
-- Versiune server: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `registru_elevi`
--

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `an_studiu_materies`
--

CREATE TABLE `an_studiu_materies` (
  `id` int(11) NOT NULL,
  `materii_id` int(11) NOT NULL,
  `clasa_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `clases`
--

CREATE TABLE `clases` (
  `id` int(11) NOT NULL,
  `clasa` char(10) COLLATE utf8_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `elevis`
--

CREATE TABLE `elevis` (
  `id` int(11) NOT NULL,
  `Nume` char(40) COLLATE utf8_romanian_ci NOT NULL,
  `Prenume` char(40) COLLATE utf8_romanian_ci NOT NULL,
  `Initiala_tatalui` char(1) COLLATE utf8_romanian_ci NOT NULL,
  `CNP` char(13) COLLATE utf8_romanian_ci NOT NULL,
  `Volum_matricol` char(4) COLLATE utf8_romanian_ci NOT NULL,
  `Pagina_matricol` char(4) COLLATE utf8_romanian_ci NOT NULL,
  `Adresa_elev` char(100) COLLATE utf8_romanian_ci NOT NULL,
  `Adresa_parinti` char(100) COLLATE utf8_romanian_ci DEFAULT NULL,
  `Locul_nasterii` char(100) COLLATE utf8_romanian_ci DEFAULT NULL,
  `Nationalitate` char(20) COLLATE utf8_romanian_ci DEFAULT NULL,
  `Nume_tata` char(100) COLLATE utf8_romanian_ci DEFAULT NULL,
  `Nume_mama` char(100) COLLATE utf8_romanian_ci DEFAULT NULL,
  `inmatriculat` tinyint(1) NOT NULL,
  `transferat` tinyint(1) NOT NULL,
  `observatii` text COLLATE utf8_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci COMMENT='Date elevi';

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `elev_clasa`
--

CREATE TABLE `elev_clasa` (
  `id` int(11) NOT NULL,
  `elev_id` int(11) NOT NULL,
  `clasa_id` int(11) NOT NULL,
  `litera_clasa` char(3) COLLATE utf8_romanian_ci NOT NULL,
  `semestrul` int(11) NOT NULL,
  `an_scolar` char(20) COLLATE utf8_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `materiis`
--

CREATE TABLE `materiis` (
  `id` int(11) NOT NULL,
  `Nume_materie` varchar(70) COLLATE utf8_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `medii_semestriales`
--

CREATE TABLE `medii_semestriales` (
  `id` int(11) NOT NULL,
  `elev_clasa_id` int(11) DEFAULT NULL,
  `materia_id` int(11) NOT NULL,
  `media` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci COMMENT='mediile semestriale';

-- --------------------------------------------------------

--
-- Structura de tabel pentru tabelul `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` char(20) COLLATE utf8_romanian_ci NOT NULL,
  `pass` char(20) COLLATE utf8_romanian_ci NOT NULL,
  `clasa_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `an_studiu_materies`
--
ALTER TABLE `an_studiu_materies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `materii_id` (`materii_id`),
  ADD KEY `clasa` (`clasa_id`);

--
-- Indexes for table `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `elevis`
--
ALTER TABLE `elevis`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `elev_clasa`
--
ALTER TABLE `elev_clasa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index elev` (`elev_id`),
  ADD KEY `index clasa` (`clasa_id`);

--
-- Indexes for table `materiis`
--
ALTER TABLE `materiis`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Nume_materie` (`Nume_materie`);

--
-- Indexes for table `medii_semestriales`
--
ALTER TABLE `medii_semestriales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `elevi_id` (`elev_clasa_id`),
  ADD KEY `an_studiu_id` (`materia_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nume_unic` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `an_studiu_materies`
--
ALTER TABLE `an_studiu_materies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `clases`
--
ALTER TABLE `clases`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `elevis`
--
ALTER TABLE `elevis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `elev_clasa`
--
ALTER TABLE `elev_clasa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `materiis`
--
ALTER TABLE `materiis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `medii_semestriales`
--
ALTER TABLE `medii_semestriales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Restrictii pentru tabele sterse
--

--
-- Restrictii pentru tabele `an_studiu_materies`
--
ALTER TABLE `an_studiu_materies`
  ADD CONSTRAINT `an_studiu_materies_ibfk_1` FOREIGN KEY (`materii_id`) REFERENCES `materiis` (`id`),
  ADD CONSTRAINT `clasa_fb` FOREIGN KEY (`clasa_id`) REFERENCES `clases` (`id`);

--
-- Restrictii pentru tabele `elev_clasa`
--
ALTER TABLE `elev_clasa`
  ADD CONSTRAINT `elev_clasa_ibfk_1` FOREIGN KEY (`elev_id`) REFERENCES `elevis` (`id`),
  ADD CONSTRAINT `elev_clasa_ibfk_2` FOREIGN KEY (`clasa_id`) REFERENCES `clases` (`id`);

--
-- Restrictii pentru tabele `medii_semestriales`
--
ALTER TABLE `medii_semestriales`
  ADD CONSTRAINT `medii_semestriales_ibfk_1` FOREIGN KEY (`elev_clasa_id`) REFERENCES `elev_clasa` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `medii_semestriales_ibfk_2` FOREIGN KEY (`materia_id`) REFERENCES `materiis` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
