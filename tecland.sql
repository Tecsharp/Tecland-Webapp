-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-10-2023 a las 23:16:04
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tecland`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `achievements`
--

CREATE TABLE `achievements` (
  `playername` char(36) NOT NULL,
  `username` varchar(60) NOT NULL,
  `achievement` varchar(64) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `achievements`
--

INSERT INTO `achievements` (`playername`, `username`, `achievement`, `date`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'ArchToon', 'connect_1', '2023-07-20 20:38:25'),
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'ArchToon', 'distancefoot_1000', '2023-07-20 20:39:00'),
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'ArchToon', 'eatenitems_1', '2023-07-20 20:38:55'),
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'ArchToon', 'itembreaks_1', '2023-07-20 20:40:10'),
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'ArchToon', 'itemdrops_15', '2023-07-20 21:55:49'),
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'ArchToon', 'itempickups_40', '2023-07-20 20:40:00'),
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'ArchToon', 'kills_1_zombie', '2023-07-20 20:58:51'),
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'ArchToon', 'maxlevel_10', '2023-07-20 21:41:36'),
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'ArchToon', 'playedtime_1', '2023-07-20 20:51:32'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'arrows_50', '2023-09-21 04:42:56'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'break_1_stone', '2023-07-20 21:11:29'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'connect_1', '2023-07-20 20:17:13'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'deaths_1', '2023-07-20 20:57:50'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'distancefoot_1000', '2023-07-20 20:17:43'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'distancehorse_500', '2023-09-21 05:17:09'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'distancesneaking_500', '2023-09-21 05:23:49'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'eatenitems_1', '2023-07-20 20:42:21'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'fish_1', '2023-09-21 06:04:55'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'hoeplowings_10', '2023-09-21 04:46:03'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'itemdrops_15', '2023-07-20 20:48:25'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'itempickups_40', '2023-07-20 21:10:14'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'kills_1_zombie', '2023-07-20 21:07:20'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'maxlevel_10', '2023-07-20 21:11:39'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'playedtime_1', '2023-07-20 20:17:16'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'treasure_1', '2023-09-21 06:05:44');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `advancementscompleted`
--

CREATE TABLE `advancementscompleted` (
  `playername` char(36) NOT NULL,
  `advancementscompleted` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigos`
--

CREATE TABLE `amigos` (
  `id` int(9) NOT NULL,
  `usuarioid` int(9) NOT NULL,
  `amigoid` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `amigos`
--

INSERT INTO `amigos` (`id`, `usuarioid`, `amigoid`) VALUES
(45, 2, 3),
(46, 3, 2),
(49, 2, 6),
(50, 6, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anvils`
--

CREATE TABLE `anvils` (
  `playername` char(36) NOT NULL,
  `anvils` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `anvils`
--

INSERT INTO `anvils` (`playername`, `anvils`) VALUES
('ccc510af-71d1-3975-80fd-69db6cb7b641', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arrows`
--

CREATE TABLE `arrows` (
  `playername` char(36) NOT NULL,
  `arrows` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `arrows`
--

INSERT INTO `arrows` (`playername`, `arrows`) VALUES
('ccc510af-71d1-3975-80fd-69db6cb7b641', 144);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authme`
--

CREATE TABLE `authme` (
  `id` int(8) NOT NULL,
  `username` varchar(255) NOT NULL,
  `realname` varchar(255) NOT NULL,
  `password` varchar(255) CHARACTER SET ascii COLLATE ascii_bin NOT NULL,
  `ip` varchar(40) CHARACTER SET ascii COLLATE ascii_bin DEFAULT NULL,
  `lastlogin` bigint(20) DEFAULT NULL,
  `x` double NOT NULL DEFAULT 0,
  `y` double NOT NULL DEFAULT 0,
  `z` double NOT NULL DEFAULT 0,
  `world` varchar(255) NOT NULL DEFAULT 'world',
  `regdate` bigint(20) NOT NULL DEFAULT 0,
  `regip` varchar(40) CHARACTER SET ascii COLLATE ascii_bin DEFAULT NULL,
  `yaw` float DEFAULT NULL,
  `pitch` float DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `isLogged` smallint(6) NOT NULL DEFAULT 0,
  `hasSession` smallint(6) NOT NULL DEFAULT 0,
  `totp` varchar(32) DEFAULT NULL,
  `biografia` varchar(500) NOT NULL,
  `admin` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `authme`
--

INSERT INTO `authme` (`id`, `username`, `realname`, `password`, `ip`, `lastlogin`, `x`, `y`, `z`, `world`, `regdate`, `regip`, `yaw`, `pitch`, `email`, `isLogged`, `hasSession`, `totp`, `biografia`, `admin`) VALUES
(1, 'cuchariao', 'Cuchariao', '$SHA$f5871f5c5ae0dedb$4f76b36sebf1f924b721c9f22bd0b7909af4a6ab4139f510ba127806591d9ae0c', '192.168.1.5', 1686627358089, 0, 0, 0, 'world', 1686623034159, '192.168.1.5', NULL, NULL, NULL, 0, 0, NULL, '', 0),
(2, 'tecsharp', 'Tecsharp', '$SHA$de1b483670c82b40$737fbd02db5s8af23f7d9680552723d0b1e88ba3ad0ee6ea0053da5543f9fa2fa', '127.0.0.1', 1695281107310, 0, 0, 0, 'world', 1686627529424, '192.168.1.5', NULL, NULL, NULL, 0, 0, NULL, 'A lupita le gustan las qks', 1),
(3, 'denisse', 'Denisse', '$SHA$cae65b8f9732a55d$bb0658b11a73c89fac6b37fcc0664e626dc7b7c48596509aa566c87a485848de7', NULL, NULL, 0, 0, 0, 'world', 1686627633764, NULL, NULL, NULL, NULL, 0, 0, NULL, 'Me gustan las morritas', 0),
(4, 'cuchao', 'Cuchao', '$SHA$0fe680c49438c00a$a8d31f07b133a9843fffa17ac8df189fd597df211b2bccf9f45de2ac413238d5b', NULL, NULL, 0, 0, 0, 'world', 1686635565712, NULL, NULL, NULL, NULL, 0, 0, NULL, '', 0),
(5, 'panchita', 'Panchita', '$SHA$d79b2aede9dcde98$e3b616bd5acbcc2d467a0e0f56e98efb3a64ec279b56c132944890e11103e61af', NULL, NULL, 0, 0, 0, 'world', 1686640775708, NULL, NULL, NULL, NULL, 0, 0, NULL, '', 0),
(6, 'archtoon', 'ArchToon', '$SHA$f0d7f26094fc1386$9b5f06a26f03s9cd50ec230c3aea7d0cc2beb4acb5dcde14461568eb8ab9457c7', '26.22.75.119', 1689930961941, 0, 0, 0, 'world', 1689050053722, '26.22.75.119', NULL, NULL, NULL, 0, 0, NULL, '', 0),
(7, 'zabdita', 'Zabdita', '$SHA$f4501e519bb554fb$be04b8252076d964s0c13621752a2b6a0ac9ba0b22e9fd953a8498244573b31ae', '26.52.126.128', 1689653362422, 0, 0, 0, 'world', 1689130901742, '26.52.126.128', NULL, NULL, NULL, 0, 0, NULL, '', 0),
(8, 'diegohazard', 'Diegohazard', '$SHA$6e0a3ee5e313cf29$8121b709ddabdd184adfb252b9cfaf3f493ee65202bacf97566afa8903baa6a25', '26.183.126.80', 1689401758499, 0, 0, 0, 'world', 1689392013979, '26.183.126.80', NULL, NULL, NULL, 0, 0, NULL, '', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `beds`
--

CREATE TABLE `beds` (
  `playername` char(36) NOT NULL,
  `beds` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `beds`
--

INSERT INTO `beds` (`playername`, `beds`) VALUES
('831c1c9c-362a-3499-adca-860e3c4bf241', 1),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `booksedited`
--

CREATE TABLE `booksedited` (
  `playername` char(36) NOT NULL,
  `booksedited` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `breaks`
--

CREATE TABLE `breaks` (
  `playername` char(36) NOT NULL,
  `blockid` varchar(128) NOT NULL,
  `breaks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `breaks`
--

INSERT INTO `breaks` (`playername`, `blockid`, `breaks`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'stone', 39),
('831c1c9c-362a-3499-adca-860e3c4bf241', 'stone', 11),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'stone', 543);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `breeding`
--

CREATE TABLE `breeding` (
  `playername` char(36) NOT NULL,
  `mobname` varchar(128) NOT NULL,
  `breeding` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brewing`
--

CREATE TABLE `brewing` (
  `playername` char(36) NOT NULL,
  `brewing` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `connections`
--

CREATE TABLE `connections` (
  `playername` char(36) NOT NULL,
  `connections` int(11) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `connections`
--

INSERT INTO `connections` (`playername`, `connections`, `date`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 3, '21/07/2023'),
('831c1c9c-362a-3499-adca-860e3c4bf241', 2, '17/07/2023'),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 9, '21/09/2023');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consumedpotions`
--

CREATE TABLE `consumedpotions` (
  `playername` char(36) NOT NULL,
  `consumedpotions` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `crafts`
--

CREATE TABLE `crafts` (
  `playername` char(36) NOT NULL,
  `item` varchar(128) NOT NULL,
  `crafts` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `custom`
--

CREATE TABLE `custom` (
  `playername` char(36) NOT NULL,
  `customname` varchar(128) NOT NULL,
  `custom` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deaths`
--

CREATE TABLE `deaths` (
  `playername` char(36) NOT NULL,
  `deaths` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `deaths`
--

INSERT INTO `deaths` (`playername`, `deaths`) VALUES
('831c1c9c-362a-3499-adca-860e3c4bf241', 1),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distanceboat`
--

CREATE TABLE `distanceboat` (
  `playername` char(36) NOT NULL,
  `distanceboat` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distancefoot`
--

CREATE TABLE `distancefoot` (
  `playername` char(36) NOT NULL,
  `distancefoot` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `distancefoot`
--

INSERT INTO `distancefoot` (`playername`, `distancefoot`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 10782),
('831c1c9c-362a-3499-adca-860e3c4bf241', 14885),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 15037);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distancegliding`
--

CREATE TABLE `distancegliding` (
  `playername` char(36) NOT NULL,
  `distancegliding` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distancehorse`
--

CREATE TABLE `distancehorse` (
  `playername` char(36) NOT NULL,
  `distancehorse` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `distancehorse`
--

INSERT INTO `distancehorse` (`playername`, `distancehorse`) VALUES
('831c1c9c-362a-3499-adca-860e3c4bf241', 13),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 1032);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distancellama`
--

CREATE TABLE `distancellama` (
  `playername` char(36) NOT NULL,
  `distancellama` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distanceminecart`
--

CREATE TABLE `distanceminecart` (
  `playername` char(36) NOT NULL,
  `distanceminecart` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distancepig`
--

CREATE TABLE `distancepig` (
  `playername` char(36) NOT NULL,
  `distancepig` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distancesneaking`
--

CREATE TABLE `distancesneaking` (
  `playername` char(36) NOT NULL,
  `distancesneaking` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `distancesneaking`
--

INSERT INTO `distancesneaking` (`playername`, `distancesneaking`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 131),
('831c1c9c-362a-3499-adca-860e3c4bf241', 19),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 977);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `drops`
--

CREATE TABLE `drops` (
  `playername` char(36) NOT NULL,
  `drops` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `drops`
--

INSERT INTO `drops` (`playername`, `drops`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 26),
('831c1c9c-362a-3499-adca-860e3c4bf241', 39),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 122);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eatenitems`
--

CREATE TABLE `eatenitems` (
  `playername` char(36) NOT NULL,
  `eatenitems` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `eatenitems`
--

INSERT INTO `eatenitems` (`playername`, `eatenitems`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 49),
('831c1c9c-362a-3499-adca-860e3c4bf241', 31),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `effectsheld`
--

CREATE TABLE `effectsheld` (
  `playername` char(36) NOT NULL,
  `effect` varchar(128) NOT NULL,
  `effectsheld` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eggs`
--

CREATE TABLE `eggs` (
  `playername` char(36) NOT NULL,
  `eggs` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `eggs`
--

INSERT INTO `eggs` (`playername`, `eggs`) VALUES
('ccc510af-71d1-3975-80fd-69db6cb7b641', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enchantments`
--

CREATE TABLE `enchantments` (
  `playername` char(36) NOT NULL,
  `enchantments` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enderpearls`
--

CREATE TABLE `enderpearls` (
  `playername` char(36) NOT NULL,
  `enderpearls` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `essentials_userdata`
--

CREATE TABLE `essentials_userdata` (
  `id` int(10) UNSIGNED NOT NULL,
  `player_uuid` char(36) NOT NULL,
  `player_name` varchar(16) NOT NULL,
  `userdata` text NOT NULL,
  `money` double(30,2) NOT NULL,
  `offline_money` double(30,2) NOT NULL,
  `sync_complete` varchar(5) NOT NULL,
  `last_seen` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `essentials_userdata`
--

INSERT INTO `essentials_userdata` (`id`, `player_uuid`, `player_name`, `userdata`, `money`, `offline_money`, `sync_complete`, `last_seen`) VALUES
(1, 'ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 'money: \'3505038.00000000019916497403123093\'\ntimestamps:\n  kits:\n    identificacion: 1689930986190\n    soldado: 307206\n  login: 1695280646223\n  lastteleport: 1695273722357\n  logout: 1695281107167\n  lastheal: 1594851279640\nafk: false\nlastAccountName: Tecsharp\nipAddress: 127.0.0.1\nlastlocation:\n  world: survival\n  x: 50150.5\n  y: 69.0\n  z: 49975.5\n  yaw: 287.04443\n  pitch: 43.42384\nlogoutlocation:\n  world: survival\n  x: 50225.943336605524\n  y: 69.0\n  z: 49994.634874977164\n  yaw: -47.371826\n  pitch: 7.8502283\nhomes:\n  home:\n    world: survival\n    x: 50150.424109330896\n    y: 69.0\n    z: 49975.092044805475\n    yaw: 287.04443\n    pitch: 43.42384\ngodmode: false\n', 3505038.00, 0.00, 'true', '1695281107653');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fertilising`
--

CREATE TABLE `fertilising` (
  `playername` char(36) NOT NULL,
  `fertilising` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fertilising`
--

INSERT INTO `fertilising` (`playername`, `fertilising`) VALUES
('ccc510af-71d1-3975-80fd-69db6cb7b641', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fireworks`
--

CREATE TABLE `fireworks` (
  `playername` char(36) NOT NULL,
  `fireworks` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fish`
--

CREATE TABLE `fish` (
  `playername` char(36) NOT NULL,
  `fish` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fish`
--

INSERT INTO `fish` (`playername`, `fish`) VALUES
('ccc510af-71d1-3975-80fd-69db6cb7b641', 47);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hoeplowing`
--

CREATE TABLE `hoeplowing` (
  `playername` char(36) NOT NULL,
  `hoeplowing` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `hoeplowing`
--

INSERT INTO `hoeplowing` (`playername`, `hoeplowing`) VALUES
('831c1c9c-362a-3499-adca-860e3c4bf241', 22),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `info_tecland`
--

CREATE TABLE `info_tecland` (
  `id` int(5) NOT NULL,
  `descripcion` varchar(3000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `info_tecland`
--

INSERT INTO `info_tecland` (`id`, `descripcion`) VALUES
(1, '\n<style>\ntable.GeneratedTable {\n  margin-left: 45px;\n  margin-right: auto;\n  width: 100%;\n  background-color: #ffffff;\n  border-collapse: collapse;\n  border-width: 0px;\n  border-color: #ffcc00;\n  border-style: solid;\n  color: #000000;\n}\n\ntable.GeneratedTable td, table.GeneratedTable th {\n  border-width: 0px;\n  border-color: #ffcc00;\n  border-style: solid;\n  padding: 3px;\n}\n\ntable.GeneratedTable thead {\n  background-color: #ffcc00;\n}\n</style>\n<p></p>\n<p></p>\n<p></p>\n<h2>Tecland es un servidor de RolePlay.<h2>\n\n<p>Tecland es un servidor de Minecraft, creado en la versión 1.12.2, añadido con mods y plugins de Spigot, que hacen de una experiencia única en el juego. </p>\n\n<p>El servidor contiene diferentes mundos, misiones, un lobby donde podrás comprar artículos complicados de craftear o incluso que no existen de forma survival (como Mega Loot). </p>\n\n<p>Tecland cuenta con membresias VIP que te proveerán de algunas ventajas, como los <b>kits</b> y <b>warps</b> gratuitos.</p>\n\n\n<p>Cuenta también con los siguientes mods y facciones.</p>\n\n<p></p>\n<h2>MODS</h2>\n<p></p>\n<table class=\"GeneratedTable\">\n  <tbody>\n    <tr>\n      <td><p>TreeChopper</p></td>\n      <td><p>Mystical Agri</p></td>\n    </tr>\n    <tr>\n      <td><p>OpenElevator</p></td>\n      <td><p>MegaLoot</p></td>\n    </tr>\n    <tr>\n      <td><p>DecoCraft</p></td>\n      <td><p>Armourers Wrksh</p></td>\n    </tr>\n    <tr>\n      <td><p>Comes Alive</p></td>\n      <td><p>Coins</p></td>\n    </tr>\n    <tr>\n      <td><p>FutureMC</p></td>\n      <td><p>Online Picture</p></td>\n    </tr>\n  </tbody>\n</table>\n');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `itembreaks`
--

CREATE TABLE `itembreaks` (
  `playername` char(36) NOT NULL,
  `itembreaks` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `itembreaks`
--

INSERT INTO `itembreaks` (`playername`, `itembreaks`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 5),
('831c1c9c-362a-3499-adca-860e3c4bf241', 7),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobsreborn`
--

CREATE TABLE `jobsreborn` (
  `playername` char(36) NOT NULL,
  `jobname` varchar(128) NOT NULL,
  `jobsreborn` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jobsreborn`
--

INSERT INTO `jobsreborn` (`playername`, `jobname`, `jobsreborn`) VALUES
('831c1c9c-362a-3499-adca-860e3c4bf241', 'hunter', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs_archive`
--

CREATE TABLE `jobs_archive` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `job` text DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `left` bigint(20) DEFAULT NULL,
  `jobid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jobs_archive`
--

INSERT INTO `jobs_archive` (`id`, `userid`, `job`, `experience`, `level`, `left`, `jobid`) VALUES
(1, 1, 'Miner', 18, 4, 1685934673131, 10),
(2, 1, 'Builder', 5, 3, 1685934673170, 2),
(3, 1, 'Crafter', 2, 1, 1685934673234, 3),
(4, 1, 'Digger', 3, 1, 1685934705553, 4),
(5, 1, 'Explorer', 16, 2, 1685934749054, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs_blocks`
--

CREATE TABLE `jobs_blocks` (
  `id` int(11) NOT NULL,
  `world` varchar(36) DEFAULT NULL,
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `z` int(11) DEFAULT NULL,
  `recorded` bigint(20) DEFAULT NULL,
  `resets` bigint(20) DEFAULT NULL,
  `worldid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs_exploredata`
--

CREATE TABLE `jobs_exploredata` (
  `id` int(11) NOT NULL,
  `worldname` varchar(64) DEFAULT NULL,
  `chunkX` int(11) DEFAULT NULL,
  `chunkZ` int(11) DEFAULT NULL,
  `playerNames` text DEFAULT NULL,
  `worldid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jobs_exploredata`
--

INSERT INTO `jobs_exploredata` (`id`, `worldname`, `chunkX`, `chunkZ`, `playerNames`, `worldid`) VALUES
(1, 'lobby', -7, 3, '1;2;4;6', 1),
(2, 'lobby', -7, 4, '1;2;4;6', 1),
(3, 'lobby', -6, 5, '1;2', 1),
(4, 'lobby', -7, 5, '1;2;4', 1),
(5, 'lobby', -11, 5, NULL, 1),
(6, 'lobby', -7, 6, '1;2;4', 1),
(7, 'lobby', -6, 6, '1;2;4', 1),
(8, 'lobby', -8, 6, '1;2;4', 1),
(9, 'lobby', -11, 6, NULL, 1),
(10, 'lobby', -7, 7, NULL, 1),
(11, 'lobby', -8, 7, NULL, 1),
(12, 'lobby', -9, 7, NULL, 1),
(13, 'lobby', -10, 7, NULL, 1),
(14, 'lobby', -7, 8, NULL, 1),
(15, 'lobby', -9, 8, '1;4;2', 1),
(16, 'lobby', -8, 8, '1;2;4', 1),
(38, 'lobby', -6, 7, '2;4', 1),
(39, 'lobby', -12, 6, '2;4', 1),
(49, 'lobby', -10, 4, '2;4;6', 1),
(50, 'lobby', -12, 5, '2;4', 1),
(51, 'lobby', -10, 5, '2;4;6', 1),
(52, 'lobby', -8, 5, '2;4', 1),
(53, 'lobby', -10, 6, '2;4', 1),
(54, 'lobby', -6, 8, '2;4;6', 1),
(55, 'lobby', -9, 5, '2;4', 1),
(56, 'lobby', -9, 6, '2;4', 1),
(57, 'lobby', -11, 7, '2;4;5;6', 1),
(58, 'lobby', -5, 7, '2;4', 1),
(59, 'lobby', -5, 8, '2;4', 1),
(60, 'lobby', -8, 1, '2;4', 1),
(61, 'lobby', -12, 2, '4', 1),
(62, 'lobby', -8, 2, '4', 1),
(63, 'lobby', -12, 3, '4;2', 1),
(64, 'lobby', -12, 4, '2;4', 1),
(65, 'lobby', -4, 5, '2', 1),
(66, 'lobby', -4, 6, '2', 1),
(67, 'lobby', -4, 7, '2', 1),
(68, 'lobby', -12, 7, '2', 1),
(69, 'lobby', -4, 8, '2;4', 1),
(70, 'lobby', -12, 8, '4', 1),
(71, 'lobby', -8, 9, '2;4', 1),
(72, 'lobby', -7, 1, '4;2', 1),
(73, 'lobby', -7, 2, '4;2;6', 1),
(74, 'lobby', -11, 3, '2;4', 1),
(75, 'lobby', -11, 4, '2;4', 1),
(76, 'lobby', -3, 4, '4;2', 1),
(77, 'lobby', -3, 5, '4;2', 1),
(78, 'lobby', -3, 6, '4;2', 1),
(79, 'lobby', -3, 8, '4;2', 1),
(80, 'lobby', -11, 8, '4', 1),
(81, 'lobby', -7, 9, '4', 1),
(82, 'lobby', -10, 3, '2;4', 1),
(83, 'lobby', -6, 3, '2', 1),
(84, 'lobby', -6, 4, '2', 1),
(85, 'lobby', -2, 4, '4;2', 1),
(86, 'lobby', -2, 5, '2;4', 1),
(87, 'lobby', -10, 8, '4;2', 1),
(88, 'lobby', -13, 3, '2;4', 1),
(89, 'lobby', -9, 3, '4', 1),
(90, 'lobby', -13, 4, '2;4', 1),
(91, 'lobby', -9, 4, '4;2', 1),
(92, 'lobby', -5, 6, '4', 1),
(1301, 'lobby', -4, 4, '2', 1),
(1302, 'lobby', -8, 4, '4', 1),
(1303, 'lobby', -12, 9, '2', 1),
(1304, 'lobby', -12, 10, '2;4', 1),
(1305, 'lobby', -3, 7, '2', 1),
(1306, 'lobby', -11, 9, '2;4', 1),
(1307, 'lobby', -15, 9, '4', 1),
(1308, 'lobby', -11, 10, '2;4', 1),
(1309, 'lobby', -2, 6, '2', 1),
(1310, 'lobby', -2, 7, '2', 1),
(1311, 'lobby', -10, 9, '2;4', 1),
(1312, 'lobby', -14, 9, '2;4', 1),
(1313, 'lobby', -10, 10, '2', 1),
(1314, 'lobby', -14, 10, '2;4', 1),
(1315, 'lobby', -10, 11, '4', 1),
(1316, 'lobby', -5, 2, '4', 1),
(1317, 'lobby', -1, 8, '4', 1),
(1318, 'lobby', -13, 9, '2', 1),
(1319, 'lobby', -13, 10, '2;4', 1),
(1320, 'lobby', -8, 0, '4', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs_jobnames`
--

CREATE TABLE `jobs_jobnames` (
  `id` int(11) NOT NULL,
  `name` varchar(36) DEFAULT NULL,
  `img` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jobs_jobnames`
--

INSERT INTO `jobs_jobnames` (`id`, `name`, `img`) VALUES
(1, 'Brewer', '/icons/jobs/Brewer.png'),
(2, 'Builder', '/icons/jobs/Builder.png'),
(3, 'Crafter', '/icons/jobs/Crafter.png'),
(4, 'Digger', '/icons/jobs/Digger.png'),
(5, 'Enchanter', '/icons/jobs/Enchanter.png'),
(6, 'Explorer', '/icons/jobs/Explorer.png'),
(7, 'Farmer', '/icons/jobs/Farmer.png'),
(8, 'Fisherman', '/icons/jobs/Fisherman.png'),
(9, 'Hunter', '/icons/jobs/Hunter.png'),
(10, 'Miner', '/icons/jobs/Miner.png'),
(11, 'Weaponsmith', '/icons/jobs/Weaponsmith.png'),
(12, 'Woodcutter', '/icons/jobs/Woodencutter.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs_jobs`
--

CREATE TABLE `jobs_jobs` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `job` text DEFAULT NULL,
  `experience` double DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `jobid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jobs_jobs`
--

INSERT INTO `jobs_jobs` (`id`, `userid`, `job`, `experience`, `level`, `jobid`) VALUES
(6, 1, 'Farmer', 9.9, 1, 7),
(7, 1, 'Fisherman', 10.75, 2, 8),
(9, 2, 'Fisherman', 0, 30, 13),
(10, 2, 'Miner', 269.6539999999989, 8, 10),
(11, 2, 'Farmer', 37.27, 3, 7),
(12, 2, 'Woodcutter', 6.860000000000001, 1, 12),
(13, 5, 'Miner', 148.25999999999982, 7, 10),
(14, 5, 'Hunter', 142.60000000000005, 5, 9),
(15, 5, 'Crafter', 5.012000000000002, 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs_limits`
--

CREATE TABLE `jobs_limits` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `type` varchar(36) DEFAULT NULL,
  `collected` double DEFAULT NULL,
  `started` bigint(20) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs_log`
--

CREATE TABLE `jobs_log` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `action` varchar(20) DEFAULT NULL,
  `itemname` text DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `exp` double DEFAULT NULL,
  `points` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs_points`
--

CREATE TABLE `jobs_points` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `totalpoints` double DEFAULT NULL,
  `currentpoints` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jobs_points`
--

INSERT INTO `jobs_points` (`id`, `userid`, `totalpoints`, `currentpoints`) VALUES
(5, 1, 221.22500000000005, 221.22500000000005),
(11, 3, 0, 0),
(17, 4, 0, 0),
(30, 6, 0, 0),
(65, 5, 1055.7656999999997, 1055.7656999999997),
(85, 2, 1465.3751000000002, 1465.3751000000002);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs_users`
--

CREATE TABLE `jobs_users` (
  `id` int(11) NOT NULL,
  `player_uuid` varchar(36) DEFAULT NULL,
  `username` text DEFAULT NULL,
  `seen` bigint(20) DEFAULT NULL,
  `donequests` int(11) DEFAULT NULL,
  `quests` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jobs_users`
--

INSERT INTO `jobs_users` (`id`, `player_uuid`, `username`, `seen`, `donequests`, `quests`) VALUES
(1, '46cb1f5e-a1aa-3b89-bf55-05fe792c8be6', 'Denisse', 1685937906373, 0, 'Farmer:1:1685959200000:MILK;COW;0:;:BREED;SHEEP;0:;:SHEAR;WHITE;0;:;Pescador:1:1685959200000:FISH;RAW_FISH:2;0:;:FISH;RAW_FISH:1;1'),
(2, 'ccc510af-71d1-3975-80fd-69db6cb7b641', 'Tecsharp', 1695280811804, 0, 'Miner:1:1695290400000:BREAK;SANDSTONE;0:;:BREAK;STONE:1;0:;:BREAK;STONE;0;:;Farmer:1:1695290400000:BREED;SHEEP;0:;:MILK;COW;0:;:SHEAR;WHITE;0;:;Woodcutter:1:1695290400000:BREAK;LOG;0:;:BREAK;LOG:3;0:;:BREAK;LOG:2;0'),
(3, '14dd5642-528d-3296-a651-9895cad0e457', 'Cuchariao', 1686622671283, 0, NULL),
(4, '33245eac-bc16-3282-b4ab-172fd5233ea8', 'ArchToon', 1689050433836, 0, NULL),
(5, '831c1c9c-362a-3499-adca-860e3c4bf241', 'Zabdita', 1689653819058, 0, 'Miner:1:1689674400000:BREAK;SANDSTONE;0:;:BREAK;STONE:1;0:;:BREAK;STONE;0;:;Hunter:1:1689674400000:KILL;CREEPER;0:;:KILL;WOLF;0:;:KILL;SKELETON;0;:;Crafter:1:1689674400000:CRAFT;CHEST;0:;:CRAFT;LADDER;0:;:CRAFT;DISPENSER;0'),
(6, '38aa02d2-ee48-3198-9a74-d2f017644aa6', 'Diegohazard', 1689392350766, 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobs_worlds`
--

CREATE TABLE `jobs_worlds` (
  `id` int(11) NOT NULL,
  `name` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jobs_worlds`
--

INSERT INTO `jobs_worlds` (`id`, `name`) VALUES
(6, 'creativo'),
(7, 'DIM1'),
(8, 'end'),
(1, 'lobby'),
(5, 'misiones'),
(3, 'misionesflat'),
(2, 'nether'),
(4, 'survival'),
(9, 'test');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `kills`
--

CREATE TABLE `kills` (
  `playername` char(36) NOT NULL,
  `mobname` varchar(128) NOT NULL,
  `kills` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `kills`
--

INSERT INTO `kills` (`playername`, `mobname`, `kills`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 'zombie', 7),
('831c1c9c-362a-3499-adca-860e3c4bf241', 'zombie', 10),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 'zombie', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lavabuckets`
--

CREATE TABLE `lavabuckets` (
  `playername` char(36) NOT NULL,
  `lavabuckets` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lavabuckets`
--

INSERT INTO `lavabuckets` (`playername`, `lavabuckets`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `levels`
--

CREATE TABLE `levels` (
  `playername` char(36) NOT NULL,
  `levels` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `levels`
--

INSERT INTO `levels` (`playername`, `levels`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 28),
('831c1c9c-362a-3499-adca-860e3c4bf241', 17),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 35);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresias`
--

CREATE TABLE `membresias` (
  `id` int(5) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `informacion` varchar(2000) NOT NULL,
  `costo` int(100) NOT NULL,
  `numObjetos` int(80) NOT NULL,
  `imgLink` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `membresias`
--

INSERT INTO `membresias` (`id`, `nombre`, `informacion`, `costo`, `numObjetos`, `imgLink`) VALUES
(1, 'Esclavo', 'Membresía de entrada. Cuenta con los items necesarios para no morir al inicio de la partida. <br><br>Además de que te brinda rebajas en los warps y algunos son gratuitos. <br><br>Para más información de clic en \"Saber más\".', 299, 300, 'images/esclavo.png'),
(2, 'Funcionario', 'Membresía de nivel 2. Cuenta con objetos importantes para poder avanzar rápidamente en el juego. <br><br>Además de que te brinda warps gratuitos y un kit exquisito. <br><br>Para más información de clic en \"Saber más\".<br><br>', 399, 400, 'images/funcionario.png'),
(3, 'Doncella', 'Membresía de entrada. Cuenta con los items necesarios para no morir al inicio de la partida. <br><br>Además de que te brinda rebajas en los warps y algunos son gratuitos. <br><br>Para más información de clic en \"Saber más\".', 499, 500, 'images/doncella.png'),
(4, 'Sugar Daddy', 'Membresía de entrada. Cuenta con los items necesarios para no morir al inicio de la partida. <br><br>Además de que te brinda rebajas en los warps y algunos son gratuitos. <br><br>Para más información de clic en \"Saber más\".', 599, 600, 'images/about.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `milks`
--

CREATE TABLE `milks` (
  `playername` char(36) NOT NULL,
  `milks` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `milks`
--

INSERT INTO `milks` (`playername`, `milks`) VALUES
('831c1c9c-362a-3499-adca-860e3c4bf241', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `musicdiscs`
--

CREATE TABLE `musicdiscs` (
  `playername` char(36) NOT NULL,
  `musicdiscs` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificaciones`
--

CREATE TABLE `notificaciones` (
  `id` int(10) NOT NULL,
  `usuarioId` int(10) NOT NULL,
  `usuarioIdSender` int(10) NOT NULL,
  `tipoNotificacion` varchar(30) NOT NULL,
  `notificacionMensaje` varchar(100) NOT NULL,
  `estado` int(1) NOT NULL,
  `url` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `notificaciones`
--

INSERT INTO `notificaciones` (`id`, `usuarioId`, `usuarioIdSender`, `tipoNotificacion`, `notificacionMensaje`, `estado`, `url`) VALUES
(48, 2, 3, 'Agregar', 'Denisse te ha enviado una solicitud de amistad', 0, 'test'),
(50, 2, 3, 'Agregar', 'Denisse te ha enviado una solicitud de amistad', 0, 'test'),
(51, 3, 2, 'Agregar', 'Tecsharp te ha enviado una solicitud de amistad', 0, 'test'),
(52, 2, 1, 'Agregar', 'Cuchariao te ha enviado una solicitud de amistad', 0, 'test'),
(53, 6, 2, 'Agregar', 'Tecsharp te ha enviado una solicitud de amistad', 0, 'test'),
(54, 2, 1, 'Agregar', 'Cuchariao te ha enviado una solicitud de amistad', 0, 'test');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `petmastergive`
--

CREATE TABLE `petmastergive` (
  `playername` char(36) NOT NULL,
  `petmastergive` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `petmasterreceive`
--

CREATE TABLE `petmasterreceive` (
  `playername` char(36) NOT NULL,
  `petmasterreceive` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pickups`
--

CREATE TABLE `pickups` (
  `playername` char(36) NOT NULL,
  `pickups` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pickups`
--

INSERT INTO `pickups` (`playername`, `pickups`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 187),
('831c1c9c-362a-3499-adca-860e3c4bf241', 859),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 884);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `places`
--

CREATE TABLE `places` (
  `playername` char(36) NOT NULL,
  `blockid` varchar(128) NOT NULL,
  `places` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playedtime`
--

CREATE TABLE `playedtime` (
  `playername` char(36) NOT NULL,
  `playedtime` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `playedtime`
--

INSERT INTO `playedtime` (`playername`, `playedtime`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 16222542),
('831c1c9c-362a-3499-adca-860e3c4bf241', 12975503),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 34966876);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playercommands`
--

CREATE TABLE `playercommands` (
  `playername` char(36) NOT NULL,
  `command` varchar(128) NOT NULL,
  `playercommands` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `raidswon`
--

CREATE TABLE `raidswon` (
  `playername` char(36) NOT NULL,
  `raidswon` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `riptides`
--

CREATE TABLE `riptides` (
  `playername` char(36) NOT NULL,
  `riptides` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shears`
--

CREATE TABLE `shears` (
  `playername` char(36) NOT NULL,
  `shears` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `smelting`
--

CREATE TABLE `smelting` (
  `playername` char(36) NOT NULL,
  `smelting` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `smelting`
--

INSERT INTO `smelting` (`playername`, `smelting`) VALUES
('831c1c9c-362a-3499-adca-860e3c4bf241', 159),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 38);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `snowballs`
--

CREATE TABLE `snowballs` (
  `playername` char(36) NOT NULL,
  `snowballs` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudesamistad`
--

CREATE TABLE `solicitudesamistad` (
  `id` int(10) NOT NULL,
  `usuarioEmisor` int(10) NOT NULL,
  `usuarioReceptor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `spring_session`
--

CREATE TABLE `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `spring_session`
--

INSERT INTO `spring_session` (`PRIMARY_ID`, `SESSION_ID`, `CREATION_TIME`, `LAST_ACCESS_TIME`, `MAX_INACTIVE_INTERVAL`, `EXPIRY_TIME`, `PRINCIPAL_NAME`) VALUES
('09dd7421-df50-4145-a7ad-abec17629a8d', '375ffee3-7444-43d2-bd3d-cdca1d71db13', 1687055656554, 1687058762731, 900, 1687059662731, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `spring_session_attributes`
--

CREATE TABLE `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tames`
--

CREATE TABLE `tames` (
  `playername` char(36) NOT NULL,
  `tames` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tames`
--

INSERT INTO `tames` (`playername`, `tames`) VALUES
('831c1c9c-362a-3499-adca-860e3c4bf241', 1),
('ccc510af-71d1-3975-80fd-69db6cb7b641', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `targetsshot`
--

CREATE TABLE `targetsshot` (
  `playername` char(36) NOT NULL,
  `targetname` varchar(128) NOT NULL,
  `targetsshot` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trades`
--

CREATE TABLE `trades` (
  `playername` char(36) NOT NULL,
  `trades` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `treasures`
--

CREATE TABLE `treasures` (
  `playername` char(36) NOT NULL,
  `treasures` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `treasures`
--

INSERT INTO `treasures` (`playername`, `treasures`) VALUES
('ccc510af-71d1-3975-80fd-69db6cb7b641', 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `waterbuckets`
--

CREATE TABLE `waterbuckets` (
  `playername` char(36) NOT NULL,
  `waterbuckets` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `waterbuckets`
--

INSERT INTO `waterbuckets` (`playername`, `waterbuckets`) VALUES
('33245eac-bc16-3282-b4ab-172fd5233ea8', 4),
('831c1c9c-362a-3499-adca-860e3c4bf241', 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `achievements`
--
ALTER TABLE `achievements`
  ADD PRIMARY KEY (`playername`,`achievement`);

--
-- Indices de la tabla `advancementscompleted`
--
ALTER TABLE `advancementscompleted`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `amigos`
--
ALTER TABLE `amigos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuarioid` (`usuarioid`),
  ADD KEY `amigoid` (`amigoid`);

--
-- Indices de la tabla `anvils`
--
ALTER TABLE `anvils`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `arrows`
--
ALTER TABLE `arrows`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `authme`
--
ALTER TABLE `authme`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indices de la tabla `beds`
--
ALTER TABLE `beds`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `booksedited`
--
ALTER TABLE `booksedited`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `breaks`
--
ALTER TABLE `breaks`
  ADD PRIMARY KEY (`playername`,`blockid`);

--
-- Indices de la tabla `breeding`
--
ALTER TABLE `breeding`
  ADD PRIMARY KEY (`playername`,`mobname`);

--
-- Indices de la tabla `brewing`
--
ALTER TABLE `brewing`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `connections`
--
ALTER TABLE `connections`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `consumedpotions`
--
ALTER TABLE `consumedpotions`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `crafts`
--
ALTER TABLE `crafts`
  ADD PRIMARY KEY (`playername`,`item`);

--
-- Indices de la tabla `custom`
--
ALTER TABLE `custom`
  ADD PRIMARY KEY (`playername`,`customname`);

--
-- Indices de la tabla `deaths`
--
ALTER TABLE `deaths`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `distanceboat`
--
ALTER TABLE `distanceboat`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `distancefoot`
--
ALTER TABLE `distancefoot`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `distancegliding`
--
ALTER TABLE `distancegliding`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `distancehorse`
--
ALTER TABLE `distancehorse`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `distancellama`
--
ALTER TABLE `distancellama`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `distanceminecart`
--
ALTER TABLE `distanceminecart`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `distancepig`
--
ALTER TABLE `distancepig`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `distancesneaking`
--
ALTER TABLE `distancesneaking`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `drops`
--
ALTER TABLE `drops`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `eatenitems`
--
ALTER TABLE `eatenitems`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `effectsheld`
--
ALTER TABLE `effectsheld`
  ADD PRIMARY KEY (`playername`,`effect`);

--
-- Indices de la tabla `eggs`
--
ALTER TABLE `eggs`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `enchantments`
--
ALTER TABLE `enchantments`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `enderpearls`
--
ALTER TABLE `enderpearls`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `essentials_userdata`
--
ALTER TABLE `essentials_userdata`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `player_uuid` (`player_uuid`);

--
-- Indices de la tabla `fertilising`
--
ALTER TABLE `fertilising`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `fireworks`
--
ALTER TABLE `fireworks`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `fish`
--
ALTER TABLE `fish`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `hoeplowing`
--
ALTER TABLE `hoeplowing`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `info_tecland`
--
ALTER TABLE `info_tecland`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `itembreaks`
--
ALTER TABLE `itembreaks`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `jobsreborn`
--
ALTER TABLE `jobsreborn`
  ADD PRIMARY KEY (`playername`,`jobname`);

--
-- Indices de la tabla `jobs_archive`
--
ALTER TABLE `jobs_archive`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `jobs_blocks`
--
ALTER TABLE `jobs_blocks`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `jobs_exploredata`
--
ALTER TABLE `jobs_exploredata`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `jobs_jobnames`
--
ALTER TABLE `jobs_jobnames`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `template_jobNames` (`name`);

--
-- Indices de la tabla `jobs_jobs`
--
ALTER TABLE `jobs_jobs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_userid` (`userid`);

--
-- Indices de la tabla `jobs_limits`
--
ALTER TABLE `jobs_limits`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `jobs_log`
--
ALTER TABLE `jobs_log`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `jobs_points`
--
ALTER TABLE `jobs_points`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `jobs_users`
--
ALTER TABLE `jobs_users`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `jobs_worlds`
--
ALTER TABLE `jobs_worlds`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `template_worlds` (`name`);

--
-- Indices de la tabla `kills`
--
ALTER TABLE `kills`
  ADD PRIMARY KEY (`playername`,`mobname`);

--
-- Indices de la tabla `lavabuckets`
--
ALTER TABLE `lavabuckets`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `levels`
--
ALTER TABLE `levels`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `membresias`
--
ALTER TABLE `membresias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `milks`
--
ALTER TABLE `milks`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `musicdiscs`
--
ALTER TABLE `musicdiscs`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuarioId` (`usuarioId`),
  ADD KEY `usuarioIdSender` (`usuarioIdSender`);

--
-- Indices de la tabla `petmastergive`
--
ALTER TABLE `petmastergive`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `petmasterreceive`
--
ALTER TABLE `petmasterreceive`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `pickups`
--
ALTER TABLE `pickups`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `places`
--
ALTER TABLE `places`
  ADD PRIMARY KEY (`playername`,`blockid`);

--
-- Indices de la tabla `playedtime`
--
ALTER TABLE `playedtime`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `playercommands`
--
ALTER TABLE `playercommands`
  ADD PRIMARY KEY (`playername`,`command`);

--
-- Indices de la tabla `raidswon`
--
ALTER TABLE `raidswon`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `riptides`
--
ALTER TABLE `riptides`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `shears`
--
ALTER TABLE `shears`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `smelting`
--
ALTER TABLE `smelting`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `snowballs`
--
ALTER TABLE `snowballs`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `solicitudesamistad`
--
ALTER TABLE `solicitudesamistad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuarioEmisor` (`usuarioEmisor`),
  ADD KEY `usuarioReceptor` (`usuarioReceptor`);

--
-- Indices de la tabla `spring_session`
--
ALTER TABLE `spring_session`
  ADD PRIMARY KEY (`PRIMARY_ID`),
  ADD UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  ADD KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  ADD KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`);

--
-- Indices de la tabla `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  ADD KEY `SPRING_SESSION_ATTRIBUTES_IX1` (`SESSION_PRIMARY_ID`);

--
-- Indices de la tabla `tames`
--
ALTER TABLE `tames`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `targetsshot`
--
ALTER TABLE `targetsshot`
  ADD PRIMARY KEY (`playername`,`targetname`);

--
-- Indices de la tabla `trades`
--
ALTER TABLE `trades`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `treasures`
--
ALTER TABLE `treasures`
  ADD PRIMARY KEY (`playername`);

--
-- Indices de la tabla `waterbuckets`
--
ALTER TABLE `waterbuckets`
  ADD PRIMARY KEY (`playername`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `amigos`
--
ALTER TABLE `amigos`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT de la tabla `authme`
--
ALTER TABLE `authme`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `essentials_userdata`
--
ALTER TABLE `essentials_userdata`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `info_tecland`
--
ALTER TABLE `info_tecland`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `jobs_archive`
--
ALTER TABLE `jobs_archive`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `jobs_blocks`
--
ALTER TABLE `jobs_blocks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `jobs_exploredata`
--
ALTER TABLE `jobs_exploredata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1490;

--
-- AUTO_INCREMENT de la tabla `jobs_jobnames`
--
ALTER TABLE `jobs_jobnames`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `jobs_jobs`
--
ALTER TABLE `jobs_jobs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `jobs_limits`
--
ALTER TABLE `jobs_limits`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `jobs_log`
--
ALTER TABLE `jobs_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `jobs_points`
--
ALTER TABLE `jobs_points`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;

--
-- AUTO_INCREMENT de la tabla `jobs_users`
--
ALTER TABLE `jobs_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `jobs_worlds`
--
ALTER TABLE `jobs_worlds`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `membresias`
--
ALTER TABLE `membresias`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT de la tabla `solicitudesamistad`
--
ALTER TABLE `solicitudesamistad`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `amigos`
--
ALTER TABLE `amigos`
  ADD CONSTRAINT `amigos_ibfk_1` FOREIGN KEY (`usuarioid`) REFERENCES `authme` (`id`),
  ADD CONSTRAINT `amigos_ibfk_2` FOREIGN KEY (`amigoid`) REFERENCES `authme` (`id`);

--
-- Filtros para la tabla `jobs_jobs`
--
ALTER TABLE `jobs_jobs`
  ADD CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `authme` (`id`);

--
-- Filtros para la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  ADD CONSTRAINT `notificaciones_ibfk_1` FOREIGN KEY (`usuarioId`) REFERENCES `authme` (`id`),
  ADD CONSTRAINT `notificaciones_ibfk_2` FOREIGN KEY (`usuarioIdSender`) REFERENCES `authme` (`id`);

--
-- Filtros para la tabla `solicitudesamistad`
--
ALTER TABLE `solicitudesamistad`
  ADD CONSTRAINT `solicitudesamistad_ibfk_1` FOREIGN KEY (`usuarioEmisor`) REFERENCES `notificaciones` (`usuarioIdSender`),
  ADD CONSTRAINT `solicitudesamistad_ibfk_2` FOREIGN KEY (`usuarioReceptor`) REFERENCES `notificaciones` (`usuarioId`),
  ADD CONSTRAINT `solicitudesamistad_ibfk_3` FOREIGN KEY (`usuarioEmisor`) REFERENCES `authme` (`id`),
  ADD CONSTRAINT `solicitudesamistad_ibfk_4` FOREIGN KEY (`usuarioReceptor`) REFERENCES `authme` (`id`);

--
-- Filtros para la tabla `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
