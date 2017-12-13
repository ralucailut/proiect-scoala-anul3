SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE `an_studiu_materies` (
  `id` int(11) NOT NULL,
  `materii_id` int(11) NOT NULL,
  `clasa_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

CREATE TABLE `clases` (
  `id` int(11) NOT NULL,
  `clasa` char(10) COLLATE utf8_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

INSERT INTO `clases` (`id`, `clasa`) VALUES
(1, '0'),
(2, '1'),
(3, '2'),
(4, '3'),
(5, '4'),
(6, '5'),
(7, '6'),
(8, '7'),
(9, '8');


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
  `Nume_mama` char(100) COLLATE utf8_romanian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci COMMENT='Date elevi';

CREATE TABLE `elev_clasa` (
  `id` int(11) NOT NULL,
  `elev_id` int(11) NOT NULL,
  `clasa_id` int(11) NOT NULL,
  `litera_clasa` char(3) COLLATE utf8_romanian_ci NOT NULL,
  `semestrul` int(11) NOT NULL,
  `an_scolar` char(20) COLLATE utf8_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

CREATE TABLE `materiis` (
  `id` int(11) NOT NULL,
  `Nume_materie` varchar(70) COLLATE utf8_romanian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci;

CREATE TABLE `medii_semestriales` (
  `id` int(11) NOT NULL,
  `elev_clasa_id` int(11) DEFAULT NULL,
  `materia_id` int(11) NOT NULL,
  `media` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_romanian_ci COMMENT='mediile semestriale';

ALTER TABLE `an_studiu_materies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `materii_id` (`materii_id`),
  ADD KEY `clasa` (`clasa_id`);


ALTER TABLE `clases`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `elevis`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `elev_clasa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `index elev` (`elev_id`),
  ADD KEY `index clasa` (`clasa_id`);

ALTER TABLE `materiis`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Nume_materie` (`Nume_materie`);

ALTER TABLE `medii_semestriales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `elevi_id` (`elev_clasa_id`),
  ADD KEY `an_studiu_id` (`materia_id`);

ALTER TABLE `an_studiu_materies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `clases`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE `elevis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `elev_clasa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `materiis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

ALTER TABLE `medii_semestriales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

ALTER TABLE `an_studiu_materies`
  ADD CONSTRAINT `an_studiu_materies_ibfk_1` FOREIGN KEY (`materii_id`) REFERENCES `materiis` (`id`),
  ADD CONSTRAINT `clasa_fb` FOREIGN KEY (`clasa_id`) REFERENCES `clases` (`id`);

ALTER TABLE `elev_clasa`
  ADD CONSTRAINT `elev_clasa_ibfk_1` FOREIGN KEY (`elev_id`) REFERENCES `elevis` (`id`),
  ADD CONSTRAINT `elev_clasa_ibfk_2` FOREIGN KEY (`clasa_id`) REFERENCES `clases` (`id`);

ALTER TABLE `medii_semestriales`
  ADD CONSTRAINT `medii_semestriales_ibfk_1` FOREIGN KEY (`elev_clasa_id`) REFERENCES `elev_clasa` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `medii_semestriales_ibfk_2` FOREIGN KEY (`materia_id`) REFERENCES `materiis` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
