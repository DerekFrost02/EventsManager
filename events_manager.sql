-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: mysql
-- Creato il: Mar 04, 2026 alle 11:34
-- Versione del server: 9.3.0
-- Versione PHP: 8.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `events_manager`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `categories`
--

CREATE TABLE `categories` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `notes` text,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `categories`
--

INSERT INTO `categories` (`id`, `name`, `notes`, `created_at`, `updated_at`) VALUES
(1, 'funerale', NULL, '2026-02-17 13:31:07', '2026-02-17 13:31:07'),
(2, 'festa Scudetto', NULL, '2026-02-17 13:31:44', '2026-02-17 13:31:44'),
(3, 'vittoria del derby', NULL, '2026-02-20 14:41:42', '2026-02-20 14:41:42');

-- --------------------------------------------------------

--
-- Struttura della tabella `events`
--

CREATE TABLE `events` (
  `id` int UNSIGNED NOT NULL,
  `name` varchar(250) NOT NULL,
  `place_id` int UNSIGNED NOT NULL,
  `description` text NOT NULL,
  `date` datetime NOT NULL,
  `guests` int UNSIGNED NOT NULL,
  `notes` text,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `events`
--

INSERT INTO `events` (`id`, `name`, `place_id`, `description`, `date`, `guests`, `notes`, `created_at`, `updated_at`) VALUES
(10, 'Finale de Coppa Italia', 1, 'Lazio - Roma', '2026-03-04 11:32:58', 70000, NULL, '2026-03-04 11:33:41', '2026-03-04 11:33:41');

-- --------------------------------------------------------

--
-- Struttura della tabella `locations`
--

CREATE TABLE `locations` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `notes` text,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `locations`
--

INSERT INTO `locations` (`id`, `name`, `city`, `country`, `notes`, `created_at`, `updated_at`) VALUES
(1, 'Stadio Olimpico', 'Roma', 'Italia', NULL, '2026-02-17 13:33:19', '2026-02-17 13:33:19'),
(2, 'Arena Garibaldi', 'Pisa', 'Italia', NULL, '2026-02-17 13:33:44', '2026-02-17 13:33:44');

-- --------------------------------------------------------

--
-- Struttura della tabella `members`
--

CREATE TABLE `members` (
  `id` int NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `notes` text,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `members`
--

INSERT INTO `members` (`id`, `firstname`, `lastname`, `email`, `notes`, `created_at`, `updated_at`) VALUES
(1, 'Massimo', 'Bossetti', 'pazzainteramala@gmail.vaffanculo', NULL, '2026-02-17 13:36:23', '2026-02-17 13:36:23'),
(2, 'Giuseppe', 'Cruciani', 'giuseppecruciani@gmail.com', 'Signore e Signori Tony da Milano', '2026-02-17 13:38:02', '2026-02-17 13:38:02'),
(3, 'Massimiliano ', 'Minnocci', 'erbrasilianoreal@gmail.com', 'Volevo te pensavo solo a te eeeeeeeeh', '2026-02-17 13:39:22', '2026-02-17 13:39:22'),
(4, 'David', 'Parenzo', 'davidparenzo@gmail.com', 'Combatti Tigre combatti', '2026-02-17 13:40:33', '2026-02-17 13:40:33');

-- --------------------------------------------------------

--
-- Struttura della tabella `places`
--

CREATE TABLE `places` (
  `id` int UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city` varchar(50) NOT NULL,
  `lon` int DEFAULT NULL,
  `lng` int DEFAULT NULL,
  `note` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dump dei dati per la tabella `places`
--

INSERT INTO `places` (`id`, `name`, `address`, `city`, `lon`, `lng`, `note`, `created_at`, `updated_at`) VALUES
(1, 'Stadio Olimpico', 'Via del Duce 22', 'Roma', NULL, NULL, 'Oma oma oma ore de sta citta', '2026-03-04 11:30:57', '2026-03-04 11:30:57');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`),
  ADD KEY `place_id` (`place_id`);

--
-- Indici per le tabelle `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `places`
--
ALTER TABLE `places`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `events`
--
ALTER TABLE `events`
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `locations`
--
ALTER TABLE `locations`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `members`
--
ALTER TABLE `members`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `places`
--
ALTER TABLE `places`
  MODIFY `id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `events_ibfk_1` FOREIGN KEY (`place_id`) REFERENCES `places` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
