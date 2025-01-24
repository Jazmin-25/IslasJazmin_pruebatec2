-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 22-01-2025 a las 08:18:42
-- Versión del servidor: 9.1.0
-- Versión de PHP: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `turnero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

DROP TABLE IF EXISTS `ciudadano`;
CREATE TABLE IF NOT EXISTS `ciudadano` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `APELLIDO` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `TELEFONO` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`ID`, `APELLIDO`, `NOMBRE`, `TELEFONO`) VALUES
(1, 'Martinez', 'Ariadna', '11234566789'),
(2, 'Paramo', 'Pedro', '35453654747'),
(3, 'Paramo', 'Juan', '9876678997'),
(4, 'Rulfo', 'Juan ', '436364747573'),
(6, 'Bautista', 'Alfredo Bautista', '42656253536'),
(7, 'Ackerman', 'Levin ', '45678973251'),
(11, 'dominguez', 'lupita', '552442426335'),
(9, 'Hernandez', 'martin', '525285457'),
(10, 'Hidalgo', 'Miguel ', '5252463563645');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
