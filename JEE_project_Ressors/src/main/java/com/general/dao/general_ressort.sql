-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Ha´te : 127.0.0.1:3306
-- Genere le : mer. 26 oct. 2022 a  11:05
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de donnees : `general_ressort`
--

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

DROP DATABASE IF EXISTS general_ressort;
CREATE DATABASE general_ressort;
USE general_ressort;


-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) COLLATE utf8_bin NOT NULL,
  `nom` varchar(25) COLLATE utf8_bin NOT NULL,
  `prix` double NOT NULL,
  `description` varchar(255) COLLATE utf8_bin NOT NULL,
  `reference` varchar(30) COLLATE utf8_bin NOT NULL,
  `link` varchar(200) COLLATE utf8_bin NOT NULL,
  `stock` int(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

INSERT INTO `article` (`id`, `type`, `nom`, `prix`, `description`, `reference`,`link` , `stock` ) VALUES
(1, 'Ressorts de compression coniques en acier a  ressort inoxydable', 'cx225', 2.25, 'a', 'A600-026-125', 'https://medias.la-becanerie.com/cache/images_articles/2/800_800/ressort-variateur-malossi-t-max.jpg',5),
(2, 'Ressorts de compression coniques en acier a  ressort inoxydable', 'rccari-9850', 9.850, 'a', 'A600-026-101', 'https://www.ressortsduleman.ch/images/intro/ressorts-compression-din.jpg',5),

(3, 'Ressorts de compression en corde a  piano, en fil electrozingue ou en fil d acier inoxydable', 'rccp_fe_220', 2.2, 'a', 'C00570060120S', 'https://www.ressortsduleman.ch/images/intro/ressorts-compression-astm.jpg',5),
(4, 'Ressorts de compression en corde a  piano, en fil electrozingue ou en fil d acier inoxydable', 'rccp_faii_330', 3.3, 'a', 'C00570060120M', 'https://www.ressortsduleman.ch/images/intro/ressorts-de-presse.jpg',5),
(5, 'Ressorts de compression en corde a  piano, en fil electrozingue ou en fil d acier inoxydable', 'rccp_faii_340', 3.4, 'a', 'C00570060190S', 'https://www.ressortsduleman.ch/images/intro/ressorts-conique.jpg',5),

(6, 'Ressorts de traction en corde a  piano, en fil electrozingue ou en fil d acier inoxydable', 'super_traction', 1, 'a', 'E00630070250S', 'https://www.ressortsduleman.ch/images/intro/ressorts-compression-multiwave.jpg',5),

(7, 'Ressorts de torsion', 'rfx_tors', 0.9, 'a', 'F770', 'https://www.ressortsduleman.ch/images/intro/ressorts-traction.jpg',5),
(8, 'Ressorts de torsion', 'testi_torsion223', 2.23, 'a', 'F771', 'https://www.ressortsduleman.ch/images/intro/ressorts-de-torsion.jpg',5),
(9, 'Ressorts de torsion', 'testi_torsion446', 4.46, 'a', 'F772', 'https://www.ressortsduleman.ch/images/intro/ressorts-gaine-de-compression.jpg',5),

(10, 'Ressorts dynamometriques en acier a  ressort inoxydable', 'rdai_1000', 0.1, 'a', 'BF-10980', 'https://www.ressortsduleman.ch/images/intro/ressorts-gaine-traction.jpg',5),
(11, 'Ressorts dynamometriques en acier a  ressort inoxydable', 'dynamoxydable1', 0.15, 'a', 'BF-10981', 'https://www.ressortsduleman.ch/images/intro/joncs-standard-arbres.jpg',5),

(12, 'Ressorts a  force constante', 'avogadro', 6.022, 'a', 'TPD220057', 'https://www.ressortsduleman.ch/images/intro/ressorts-force-constante.jpg',5),
(13, 'Ressorts a  force constante', 'pi', 3.14, 'a', 'TPD224646', 'https://www.ressortsduleman.ch/images/intro/ressorts-epingles.jpg',5),
(14, 'Ressorts a  force constante', 'euler', 2.71, 'a', 'TPD225981', 'https://www.ressortsduleman.ch/images/intro/anneaux-de-portes-clefs.jpg',5),
(15, 'Ressorts a  force constante', 'gravitation', 9.8 , 'a', 'TPD224443', 'https://www.ressortsduleman.ch/images/intro/rondelles-ressort/rondelles-belleville.jpg',5),
(16, 'Ressorts a  force constante', 'boltzmann', 1.38, 'a', 'TPD221567', 'https://www.ressortsduleman.ch/images/intro/verins-attaches/verins-et-attaches.jpg',5),
(17, 'Ressorts a  force constante', 'faraday', 2.4, 'a', 'TPD224564', 'https://www.ressortsduleman.ch/images/intro/goupilles-clips/goupilles-et-clips.jpg',5),

(18, '"Ressorts a  gaz"- mecaniques', 'propane', 4.93, 'a', 'LMS1505102', 'https://media.castorama.fr/is/image/Castorama/12-ressorts-a-compression-chapuis-assortiment~3233690265702_03CF?$MOB_PREV$&$width=618&$height=618',5),
(19, '"Ressorts a  gaz"- mecaniques', 'butane', 5.73, 'a', 'LMS1510205', 'https://www.rlc-diffusion.fr/12704-large/ressort-efs-avant-toyota-hdj-80.jpg',5),
(20, '"Ressorts a  gaz"- mecaniques', 'ZyB', 0.0001, 'a', 'LMS1515205', 'https://www.shopix.fr/28364-thickbox_default/ressort-dynamometrique.jpg',5),
(21, '"Ressorts a  gaz"- mecaniques', 'moutarde', 0.0127, 'a', 'LMS1520306', 'http://maxence.delannoy.pagesperso-orange.fr/trucs/ressort.png',5),
(22, '"Ressorts a  gaz"- mecaniques', 'sarazin', 0.0109, 'a', 'LMS1525407', 'https://img.freepik.com/vecteurs-libre/ressort-magique-simple-fond-blanc_1308-113098.jpg?w=1380&t=st=1668683352~exp=1668683952~hmac=68886b72063182fd18bce7cd078f9d5cca997371fe697965dd19bace97c74526',5);
COMMIT;



--
-- Structure de la table `commande`
--


DROP TABLE IF EXISTS `achat`;
CREATE TABLE IF NOT EXISTS `achat` (
  `commande` int(11) NOT NULL,
  `mail` varchar(25) NOT NULL,
  `nomArticle` varchar(200) NOT NULL,
  `qts` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `achat`
--

INSERT INTO `achat` (`commande`, `mail`, `nomArticle`, `qts`) VALUES
(1, 'brise.quentin@gmail.com', 'tcp12', 3),
(1, 'brise.quentin@gmail.com', 'tcp13', 3);
COMMIT;
--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(25) COLLATE utf8_bin NOT NULL,
  `mail` varchar(30) COLLATE utf8_bin NOT NULL,
  `pass` varchar(200) COLLATE utf8_bin NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dechargement des donnees de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `mail`, `pass`, `role`) VALUES
(1, 'brise', 'quentin', 'brise.quentin@gmail.com', 'quentin', 1),
(2, 'munzner', 'louis', 'munzner.louis@gmail.com', 'louis', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;