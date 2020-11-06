-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 04 nov. 2020 à 19:46
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `guacamole`
--

-- --------------------------------------------------------

--
-- Structure de la table `calendrier`
--

DROP TABLE IF EXISTS `calendrier`;
CREATE TABLE IF NOT EXISTS `calendrier` (
  `DateTP` date NOT NULL,
  `CreneauTP` enum('8h00-9h30','9h30-11h00','11h00-12h30','12h30-14h00','14h00-15h30','15h30-17h00','17h00-18h30','18h30-20h00') NOT NULL,
  PRIMARY KEY (`DateTP`,`CreneauTP`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `calendrier`
--

INSERT INTO `calendrier` (`DateTP`, `CreneauTP`) VALUES
('2020-11-12', '9h30-11h00'),
('2020-11-12', '11h00-12h30'),
('2020-11-12', '14h00-15h30'),
('2020-11-12', '15h30-17h00'),
('2020-11-13', '9h30-11h00'),
('2020-11-13', '11h00-12h30'),
('2020-11-13', '14h00-15h30'),
('2020-11-13', '15h30-17h00');

-- --------------------------------------------------------

--
-- Structure de la table `calendrier2`
--

DROP TABLE IF EXISTS `calendrier2`;
CREATE TABLE IF NOT EXISTS `calendrier2` (
  `DateResa` date NOT NULL,
  `CreneauResa` enum('8h00-9h30','9h30-11h00','11h00-12h30','12h30-14h00','14h00-15h30','15h30-17h00','17h00-18h30','18h30-20h00') NOT NULL,
  PRIMARY KEY (`DateResa`,`CreneauResa`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `calendrier2`
--

INSERT INTO `calendrier2` (`DateResa`, `CreneauResa`) VALUES
('2020-11-12', '9h30-11h00'),
('2020-11-12', '11h00-12h30');

-- --------------------------------------------------------

--
-- Structure de la table `derouler`
--

DROP TABLE IF EXISTS `derouler`;
CREATE TABLE IF NOT EXISTS `derouler` (
  `IdG` int(11) NOT NULL,
  `IdS` int(11) NOT NULL,
  `IdEns` int(11) NOT NULL,
  `IdTP` int(11) NOT NULL,
  `DateTP` date NOT NULL,
  `CreneauTP` enum('8h00-9h30','9h30-11h00','11h00-12h30','12h30-14h00','14h00-15h30','15h30-17h00','17h00-18h30','18h30-20h00') NOT NULL,
  KEY `groupe` (`IdG`),
  KEY `salle` (`IdS`),
  KEY `enseignant` (`IdEns`),
  KEY `tp` (`IdTP`),
  KEY `calendrier` (`DateTP`,`CreneauTP`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `derouler`
--

INSERT INTO `derouler` (`IdG`, `IdS`, `IdEns`, `IdTP`, `DateTP`, `CreneauTP`) VALUES
(2, 5, 4, 1, '2020-11-12', '9h30-11h00'),
(2, 5, 4, 2, '2020-11-12', '11h00-12h30'),
(2, 7, 3, 3, '2020-11-13', '14h00-15h30'),
(2, 7, 3, 4, '2020-11-13', '15h30-17h00'),
(1, 1, 1, 5, '2020-11-12', '14h00-15h30');

-- --------------------------------------------------------

--
-- Structure de la table `encadrer`
--

DROP TABLE IF EXISTS `encadrer`;
CREATE TABLE IF NOT EXISTS `encadrer` (
  `IdF` int(11) NOT NULL,
  `IdEns` int(11) NOT NULL,
  KEY `formation` (`IdF`),
  KEY `enseignant` (`IdEns`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `encadrer`
--

INSERT INTO `encadrer` (`IdF`, `IdEns`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `IdEns` int(11) NOT NULL AUTO_INCREMENT,
  `NumEns` text NOT NULL,
  `PrenomEns` text NOT NULL,
  `NomEns` text NOT NULL,
  `MdpEns` text NOT NULL,
  PRIMARY KEY (`IdEns`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`IdEns`, `NumEns`, `PrenomEns`, `NomEns`, `MdpEns`) VALUES
(1, '20500001', 'franck', 'ravat', '1234'),
(2, '20500002', 'eric', 'andonoff', '1234'),
(3, '20500003', 'frederic', 'amblard', '1234'),
(4, '20500004', 'sylvain', 'cussat-blanc', '1234'),
(5, '20500005', 'chantal', 'soule-dupuy', '1234'),
(6, '20500006', 'julien', 'aligon', '1234'),
(7, '20500007', 'nathalie', 'valles', '1234'),
(8, '20500008', 'jean-marc', 'thevenin', '1234');

-- --------------------------------------------------------

--
-- Structure de la table `etatmachine`
--

DROP TABLE IF EXISTS `etatmachine`;
CREATE TABLE IF NOT EXISTS `etatmachine` (
  `DateResa` date NOT NULL,
  `CreneauResa` enum('8h00-9h30','9h30-11h00','11h00-12h30','12h30-14h00','14h00-15h30','15h30-17h00','17h00-18h30','18h30-20h00') NOT NULL,
  `IdM` int(11) NOT NULL,
  `EtatM` enum('libre','reservee') NOT NULL,
  KEY `calendrier2` (`DateResa`,`CreneauResa`),
  KEY `machine` (`IdM`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etatmachine`
--

INSERT INTO `etatmachine` (`DateResa`, `CreneauResa`, `IdM`, `EtatM`) VALUES
('2020-11-12', '9h30-11h00', 21, 'reservee'),
('2020-11-12', '9h30-11h00', 22, 'reservee'),
('2020-11-12', '9h30-11h00', 23, 'reservee'),
('2020-11-12', '9h30-11h00', 24, 'reservee'),
('2020-11-12', '9h30-11h00', 25, 'reservee'),
('2020-11-12', '11h00-12h30', 21, 'reservee'),
('2020-11-12', '11h00-12h30', 22, 'reservee'),
('2020-11-12', '11h00-12h30', 23, 'reservee'),
('2020-11-12', '11h00-12h30', 24, 'reservee'),
('2020-11-12', '11h00-12h30', 25, 'reservee'),
('2020-11-12', '9h30-11h00', 14, 'reservee'),
('2020-11-12', '11h00-12h30', 12, 'reservee');

-- --------------------------------------------------------

--
-- Structure de la table `etatsalle`
--

DROP TABLE IF EXISTS `etatsalle`;
CREATE TABLE IF NOT EXISTS `etatsalle` (
  `DateTP` date NOT NULL,
  `CreneauTP` enum('8h00-9h30','9h30-11h00','11h00-12h30','12h30-14h00','14h00-15h30','15h30-17h00','17h00-18h30','18h30-20h00') NOT NULL,
  `IdS` int(11) NOT NULL,
  `EtatS` enum('libre','reservee') NOT NULL,
  KEY `calendrier` (`CreneauTP`,`DateTP`),
  KEY `salle` (`IdS`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etatsalle`
--

INSERT INTO `etatsalle` (`DateTP`, `CreneauTP`, `IdS`, `EtatS`) VALUES
('2020-11-12', '9h30-11h00', 5, 'reservee'),
('2020-11-12', '11h00-12h30', 5, 'reservee'),
('2020-11-12', '14h00-15h30', 1, 'reservee'),
('2020-11-12', '15h30-17h00', 1, 'reservee'),
('2020-11-13', '9h30-11h00', 3, 'reservee'),
('2020-11-13', '11h00-12h30', 3, 'reservee'),
('2020-11-13', '14h00-15h30', 7, 'reservee'),
('2020-11-13', '15h30-17h00', 7, 'reservee');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `IdE` int(11) NOT NULL AUTO_INCREMENT,
  `NumE` text NOT NULL,
  `PrenomE` text NOT NULL,
  `NomE` text NOT NULL,
  `MdpE` text NOT NULL,
  `IdG` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdE`),
  KEY `groupe` (`IdG`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`IdE`, `NumE`, `PrenomE`, `NomE`, `MdpE`, `IdG`) VALUES
(1, '20700001', 'estelle', 'viala', '1234', 2),
(2, '20700002', 'eric', 'rabe', '1234', 2),
(3, '20700003', 'miangola', 'rakotoarisoa', '1234', 2),
(4, '20700004', 'yufei', 'zhang', '1234', 2),
(5, '20700005', 'ziqi', 'tang', '1234', 2),
(6, '20700006', 'shanshan', 'zhao', '1234', 2),
(7, '20700007', 'timona', 'toa', '1234', 2),
(8, '20700008', 'siyuan', 'zhou', '1234', 2),
(9, '20700009', 'nabil', 'aissat', '1234', 1),
(10, '20700010', 'lu', 'si', '1234', 1),
(11, '20700011', 'huijun', 'ding', '1234', 1),
(12, '20700012', 'helmi', 'jeddi', '1234', 1),
(13, '20700013', 'jessica', 'lemos', '1234', 1),
(14, '20700014', 'luqi', 'li', '1234', 1),
(15, '20700015', 'shaimaa', 'hadbi', '1234', 1),
(16, '20700016', 'renjie', 'zhai', '1234', 1),
(17, '20700017', 'afaf', 'abd', '1234', 3),
(18, '20700018', 'guillaume', 'kostrzewski', '1234', 3),
(19, '20700019', 'kenza', 'aatif', '1234', 3),
(20, '20700020', 'maky', 'kevin', '1234', 3),
(21, '20700021', 'marjorie', 'debat', '1234', 3),
(22, '20700022', 'mickael', 'gaer', '1234', 3),
(23, '20700023', 'rhita', 'ber', '1234', 3),
(24, '20700024', 'omar', 'senar', '1234', 3),
(25, '20700025', 'sebastian', 'ramirez', '1234', 4),
(26, '20700026', 'vincent', 'collin', '1234', 4),
(27, '20700027', 'weihao', 'xu', '1234', 4),
(28, '20700028', 'xingtian', 'zhang', '1234', 4),
(29, '20700029', 'deyi', 'ren', '1234', 4),
(30, '20700030', 'franck', 'sheva', '1234', 4),
(31, '20700031', 'arselane', 'hadjeus', '1234', 4),
(32, '20700032', 'chen', 'ling', '1234', 4);

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `IdF` int(11) NOT NULL AUTO_INCREMENT,
  `NomF` text NOT NULL,
  PRIMARY KEY (`IdF`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`IdF`, `NomF`) VALUES
(1, 'M2IPM'),
(2, 'M2ISIAD');

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `IdG` int(11) NOT NULL AUTO_INCREMENT,
  `NomG` text NOT NULL,
  `IdF` int(11) NOT NULL,
  PRIMARY KEY (`IdG`),
  KEY `formation` (`IdF`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`IdG`, `NomG`, `IdF`) VALUES
(1, 'M2IPMG1', 1),
(2, 'M2IPMG2', 1),
(3, 'M2ISIADG1', 2),
(4, 'M2ISIADG2', 2);

-- --------------------------------------------------------

--
-- Structure de la table `machine`
--

DROP TABLE IF EXISTS `machine`;
CREATE TABLE IF NOT EXISTS `machine` (
  `IdM` int(11) NOT NULL AUTO_INCREMENT,
  `NomM` text NOT NULL,
  `IdS` int(11) NOT NULL,
  PRIMARY KEY (`IdM`),
  KEY `salle` (`IdS`)
) ENGINE=MyISAM AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `machine`
--

INSERT INTO `machine` (`IdM`, `NomM`, `IdS`) VALUES
(1, 'ME401-01', 1),
(2, 'ME401-02', 1),
(3, 'ME401-03', 1),
(4, 'ME401-04', 1),
(5, 'ME401-05', 1),
(6, 'ME402-01', 2),
(7, 'ME402-02', 2),
(8, 'ME402-03', 2),
(9, 'ME402-04', 2),
(10, 'ME402-05', 2),
(11, 'ME403-01', 3),
(12, 'ME403-02', 3),
(13, 'ME403-03', 3),
(14, 'ME403-04', 3),
(15, 'ME403-05', 3),
(16, 'ME404-01', 4),
(17, 'ME404-02', 4),
(18, 'ME404-03', 4),
(19, 'ME404-04', 4),
(20, 'ME404-05', 4),
(21, 'ME405-01', 5),
(22, 'ME405-02', 5),
(23, 'ME405-03', 5),
(24, 'ME405-04', 5),
(25, 'ME405-05', 5),
(26, 'ME406-01', 6),
(27, 'ME406-02', 6),
(28, 'ME406-03', 6),
(29, 'ME406-04', 6),
(30, 'ME406-05', 6),
(31, 'ME407-01', 7),
(32, 'ME407-02', 7),
(33, 'ME407-03', 7),
(34, 'ME407-04', 7),
(35, 'ME407-05', 7),
(36, 'ME408-01', 8),
(37, 'ME408-02', 8),
(38, 'ME408-03', 8),
(39, 'ME408-04', 8),
(40, 'ME408-05', 8),
(41, 'ME409-01', 9),
(42, 'ME409-02', 9),
(43, 'ME409-03', 9),
(44, 'ME409-04', 9),
(45, 'ME409-05', 9),
(46, 'ME410-01', 10),
(47, 'ME410-02', 10),
(48, 'ME410-03', 10),
(49, 'ME410-04', 10),
(50, 'ME410-05', 10);

-- --------------------------------------------------------

--
-- Structure de la table `reserver`
--

DROP TABLE IF EXISTS `reserver`;
CREATE TABLE IF NOT EXISTS `reserver` (
  `IdR` int(11) NOT NULL AUTO_INCREMENT,
  `IdE` int(11) NOT NULL,
  `IdM` int(11) NOT NULL,
  `DateResa` date NOT NULL,
  `CreneauResa` enum('8h00-9h30','9h30-11h00','11h00-12h30','12h30-14h00','14h00-15h30','15h30-17h00','17h00-18h30','18h30-20hh') NOT NULL,
  PRIMARY KEY (`IdR`),
  KEY `etudiant` (`IdE`),
  KEY `machine` (`IdM`),
  KEY `calendrier2` (`DateResa`,`CreneauResa`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reserver`
--

INSERT INTO `reserver` (`IdE`, `IdM`, `DateResa`, `CreneauResa`) VALUES
(2, 22, '2020-11-12', '9h30-11h00'),
(3, 23, '2020-11-12', '9h30-11h00'),
(4, 24, '2020-11-12', '9h30-11h00'),
(5, 25, '2020-11-12', '9h30-11h00'),
(1, 21, '2020-11-12', '11h00-12h30'),
(2, 22, '2020-11-12', '11h00-12h30'),
(3, 23, '2020-11-12', '11h00-12h30'),
(4, 24, '2020-11-12', '11h00-12h30'),
(20, 14, '2020-11-12', '9h30-11h00'),
(23, 12, '2020-11-12', '11h00-12h30');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `IdS` int(11) NOT NULL AUTO_INCREMENT,
  `NomS` text NOT NULL,
  PRIMARY KEY (`IdS`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`IdS`, `NomS`) VALUES
(1, 'ME401'),
(2, 'ME402'),
(3, 'ME403'),
(4, 'ME404'),
(5, 'ME405'),
(6, 'ME406'),
(7, 'ME407'),
(8, 'ME408'),
(9, 'ME409'),
(10, 'ME410');

-- --------------------------------------------------------

--
-- Structure de la table `superadmin`
--

DROP TABLE IF EXISTS `superadmin`;
CREATE TABLE IF NOT EXISTS `superadmin` (
  `IdSA` int(11) NOT NULL AUTO_INCREMENT,
  `NumSA` text NOT NULL,
  `PrenomSA` text NOT NULL,
  `NomSA` text NOT NULL,
  `MdpSA` text NOT NULL,
  PRIMARY KEY (`IdSA`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `superadmin`
--

INSERT INTO `superadmin` (`IdSA`, `NumSA`, `PrenomSA`, `NomSA`, `MdpSA`) VALUES
(1, '12345678', 'jerome', 'barathieu', '1234');

-- --------------------------------------------------------

--
-- Structure de la table `tp`
--

DROP TABLE IF EXISTS `tp`;
CREATE TABLE IF NOT EXISTS `tp` (
  `IdTP` int(11) NOT NULL AUTO_INCREMENT,
  `NomTP` text NOT NULL,
  PRIMARY KEY (`IdTP`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tp`
--

INSERT INTO `tp` (`IdTP`, `NomTP`) VALUES
(1, 'java'),
(2, 'bpmn'),
(3, 'uml'),
(4, 'analyse'),
(5, 'big data');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
