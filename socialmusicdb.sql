-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 22, 2020 alle 13:57
-- Versione del server: 10.4.11-MariaDB
-- Versione PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `socialmusicdb`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `idUtente` int(255) NOT NULL,
  `username` varchar(99) NOT NULL,
  `password` varchar(99) NOT NULL,
  `email` varchar(99) NOT NULL,
  `firstname` varchar(99) NOT NULL,
  `lastname` varchar(99) DEFAULT NULL,
  `subsdate` varchar(15) NOT NULL,
  `birthdate` text DEFAULT NULL,
  `zone` varchar(99) DEFAULT NULL,
  `instrplayed` varchar(99) NOT NULL,
  `band` tinyint(1) DEFAULT NULL,
  `nameband` varchar(99) DEFAULT NULL,
  `logged` varchar(15) NOT NULL DEFAULT 'NON LOGGATO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`idUtente`, `username`, `password`, `email`, `firstname`, `lastname`, `subsdate`, `birthdate`, `zone`, `instrplayed`, `band`, `nameband`, `logged`) VALUES
(3, 'xDingodile', 'vincenzo96', 'djellecd@hotmail.it', 'Vincenzo', 'Visconti', '2020-01-11', '1996-03-17', 'Montecompatri', 'Chitarra', 0, 'null', 'LOGGATO');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`idUtente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
