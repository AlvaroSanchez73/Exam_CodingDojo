-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-07-2019 a las 13:27:43
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `exam`
--
CREATE DATABASE IF NOT EXISTS `exam` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `exam`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `borrowers`
--

CREATE TABLE `borrowers` (
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(15) NOT NULL,
  `needMoneyFor` varchar(25) NOT NULL,
  `description` varchar(100) NOT NULL,
  `amountMoney` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `borrowers`
--

INSERT INTO `borrowers` (`firstName`, `lastName`, `email`, `password`, `needMoneyFor`, `description`, `amountMoney`) VALUES
('Aiped', 'Rey', 'aipedrey@gmail.com', '4321', 'Vehiculo', 'Compra de vehiculo para trabajar como UBER', 500),
('Jenny', 'Torres', 'jtorres@gmail.com', '4321', 'Cartera', 'Compra de cartera LB          ', 1000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lenders`
--

CREATE TABLE `lenders` (
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(15) NOT NULL,
  `money` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lenders`
--

INSERT INTO `lenders` (`firstName`, `lastName`, `email`, `password`, `money`) VALUES
('Alvaro', 'Sanchez', 'aasc73@gmail.com', '1234', 1000),
('Alex', 'Vega', 'alex@gmail.com', '1111', 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lending`
--

CREATE TABLE `lending` (
  `lenderEmail` varchar(30) NOT NULL,
  `borrowerEmail` varchar(30) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lending`
--

INSERT INTO `lending` (`lenderEmail`, `borrowerEmail`, `amount`) VALUES
('aasc73@gmail.com', 'aipedrey@gmail.com', 100),
('aasc73@gmail.com', 'jtorres@gmail.com', 200);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `borrowers`
--
ALTER TABLE `borrowers`
  ADD PRIMARY KEY (`email`);

--
-- Indices de la tabla `lenders`
--
ALTER TABLE `lenders`
  ADD PRIMARY KEY (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
