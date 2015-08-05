-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-12-2013 a las 00:07:28
-- Versión del servidor: 5.5.8
-- Versión de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `vuelos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `codigo_hotel` int(11) NOT NULL DEFAULT '0',
  `nombre_hotel` varchar(20) DEFAULT NULL,
  `direccion_hotel` varchar(30) DEFAULT NULL,
  `ciudad_hotel` varchar(20) DEFAULT NULL,
  `telefono_hotel` int(11) DEFAULT NULL,
  `numeroplazasdisponibles_hotel` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `hotel`
--

INSERT INTO `hotel` (`codigo_hotel`, `nombre_hotel`, `direccion_hotel`, `ciudad_hotel`, `telefono_hotel`, `numeroplazasdisponibles_hotel`) VALUES
(0, 'SOL DE ORO', 'AV. PERU', 'ANDAHUAYLAS', 281012, 50),
(1, 'SOL DE ORO', 'AV. PERU', 'ANDAHUAYLAS', 105050, 50),
(2, 'IMPERIO CHANKA', 'AV. LOS CHANKAS', 'ANDAHUAYLAS', 303030, 30),
(3, 'CUZCO', 'AV PEDRO CASAFRANCA', 'ANDAHUAYLAS', 301245, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE IF NOT EXISTS `sucursal` (
  `codigo_sucursal` int(11) NOT NULL DEFAULT '0',
  `nombre_sucursal` varchar(20) DEFAULT NULL,
  `direccion_sucursal` varchar(30) DEFAULT NULL,
  `telefono_sucursal` int(11) DEFAULT NULL,
  `codigo_turista` int(11) NOT NULL,
  PRIMARY KEY (`codigo_sucursal`),
  KEY `R_1` (`codigo_turista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`codigo_sucursal`, `nombre_sucursal`, `direccion_sucursal`, `telefono_sucursal`, `codigo_turista`) VALUES
(1, 'ANDAHUAYLAS-01', 'AV.CONFRATERNIDAD', 83635241, 1),
(2, 'ANDAHUAYLAS-2', 'AV. PERU', 83635241, 2),
(3, 'ANDAHUALAS-3', 'AV. ALFONSO UGARTE', 83646512, 3),
(4, 'ANDAHUAYLAS-4', 'AV. MARTINELLY', 83451244, 4),
(5, 'ANDAHUAYLAS-5', 'AV. ANDAHUAYLAS', 83645212, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turista`
--

CREATE TABLE IF NOT EXISTS `turista` (
  `codigo_turista` int(11) NOT NULL DEFAULT '0',
  `nombre_turista` varchar(20) DEFAULT NULL,
  `apellidos_turista` varchar(20) DEFAULT NULL,
  `direccion_turista` varchar(30) DEFAULT NULL,
  `telefono_turista` int(11) DEFAULT NULL,
  `image_turista` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo_turista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `turista`
--

INSERT INTO `turista` (`codigo_turista`, `nombre_turista`, `apellidos_turista`, `direccion_turista`, `telefono_turista`, `image_turista`) VALUES
(0, 'JOSE MIGUEL', 'PEREZ ALVAREZ', 'JR. RAMOS CASTILLA', 997744123, 'C:\\Users\\Daniel\\Desktop\\TRABAJO PROGRA\\prOBANDO\\app_conexion_jdbc_ SistemaDeVuelos\\src\\AgenciaVuelos'),
(1, 'DANIEL', 'GARAYAR VELASQUEZ', 'AV. AYACUCHO', 957504821, 'C:\\Users\\Daniel\\Desktop\\TRABAJO PROGRA\\prOBANDO\\app_conexion_jdbc_ SistemaDeVuelos\\src\\AgenciaVuelos'),
(2, 'MANUEL', 'MENDOZA QUISPE', 'AV.PEDRO CASAFRANCA', 983646512, ''),
(3, 'JORGE JOSE', 'CANALES MEJIA', 'AV. PERU', 983645112, ''),
(4, 'MOISES', 'FLORES TAIPE', 'AV.TUPAC AMARU', 983653289, ''),
(5, 'JOSE MIGUEL', 'PEREZ ALVAREZ', 'JR. RAMOS CASTILLA', 997744123, ''),
(6, 'DAMIAN', 'TAIPE CASAS', 'AV. CONFRATERNIDAD', 986532456, ''),
(7, 'JOSE  CARLOS', 'VELASQUEZ', 'QUISPE', 983562312, ''),
(8, 'FABRICIO MARIO', 'PEREZ MENDOZA', 'AV PEDRO CASAFRANCA', 986532741, NULL),
(9, 'JUAN GABRIEL', 'LOPEZ TORRES', 'AV AYACUCHO', 987321258, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turista_hotel`
--

CREATE TABLE IF NOT EXISTS `turista_hotel` (
  `codigo_turista_hotel` int(11) NOT NULL,
  `codigo_turista` int(11) NOT NULL,
  `codigo_hotel` int(11) NOT NULL,
  `mediapension` varchar(11) DEFAULT NULL,
  `pensioncompleta` varchar(11) DEFAULT NULL,
  `fechallegada` varchar(20) DEFAULT NULL,
  `fechasalida` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo_turista_hotel`),
  KEY `R_4` (`codigo_turista`),
  KEY `R_6` (`codigo_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `turista_hotel`
--

INSERT INTO `turista_hotel` (`codigo_turista_hotel`, `codigo_turista`, `codigo_hotel`, `mediapension`, `pensioncompleta`, `fechallegada`, `fechasalida`) VALUES
(1, 8, 2, '200 SOLES', '500 SOLES', NULL, NULL),
(2, 2, 2, '300 SOLES', '400 SOLES', '2013-11-15', '2013-11-18'),
(3, 1, 1, '400 SOLES', '800 SOLES', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turista_vuelo`
--

CREATE TABLE IF NOT EXISTS `turista_vuelo` (
  `codigo_turista_vuelo` int(11) NOT NULL,
  `codigo_turista` int(11) NOT NULL,
  `claseprimaria` varchar(20) DEFAULT NULL,
  `claseturista` varchar(20) DEFAULT NULL,
  `codigo_vuelo` int(11) NOT NULL,
  PRIMARY KEY (`codigo_turista_vuelo`),
  KEY `R_7` (`codigo_turista`),
  KEY `R_9` (`codigo_vuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `turista_vuelo`
--

INSERT INTO `turista_vuelo` (`codigo_turista_vuelo`, `codigo_turista`, `claseprimaria`, `claseturista`, `codigo_vuelo`) VALUES
(1, 1, 'CLASE-P', 'CLASE-A', 2),
(2, 3, 'CLASE-B', 'CLASE-A', 1),
(3, 2, 'CLASE-C', 'CLASE-A', 1),
(4, 2, 'CLASE-B', 'CLASE-A', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(20) NOT NULL DEFAULT '0',
  `login_usuario` varchar(20) NOT NULL,
  `password_usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `login_usuario`, `password_usuario`) VALUES
(0, 'daniel', 'garayar'),
(1, 'susan', 'gutierrez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE IF NOT EXISTS `vuelo` (
  `codigo_vuelo` int(11) NOT NULL DEFAULT '0',
  `numero_vuelo` varchar(20) DEFAULT NULL,
  `fecha_hora_vuelo` varchar(20) DEFAULT NULL,
  `origen_vuelo` varchar(20) DEFAULT NULL,
  `destino_vuelo` varchar(20) DEFAULT NULL,
  `plazastotales_vuelo` varchar(20) DEFAULT NULL,
  `plazasdeclaseturista_vuelo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo_vuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `vuelo`
--

INSERT INTO `vuelo` (`codigo_vuelo`, `numero_vuelo`, `fecha_hora_vuelo`, `origen_vuelo`, `destino_vuelo`, `plazastotales_vuelo`, `plazasdeclaseturista_vuelo`) VALUES
(1, 'UNO-SALIDA', '2013-11-15 08:30:00', 'ANDAHUAYLAS', 'CUZCO', '50', '50'),
(2, 'DOS-SALIDA', '2013-11-15 09:00:00', 'ANDAHUAYLAS', 'LIMA', '30', '20'),
(3, 'TRES-SALIDA', '2013-11-20 09:24:45', 'ANDAHUAYLAS', 'CUZCO', '25', '15'),
(4, 'CUATRO-SALIDA', '28/11/18 21:46', 'ANDAHUALAS', 'ABANCAY', '10', '5'),
(5, 'CINCO-SALIDA', '24/11/13 21:53', 'CUZCO', 'ABANCAY', '50', '40');

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD CONSTRAINT `sucursal_ibfk_1` FOREIGN KEY (`codigo_turista`) REFERENCES `turista` (`codigo_turista`);

--
-- Filtros para la tabla `turista_hotel`
--
ALTER TABLE `turista_hotel`
  ADD CONSTRAINT `turista_hotel_ibfk_1` FOREIGN KEY (`codigo_turista`) REFERENCES `turista` (`codigo_turista`),
  ADD CONSTRAINT `turista_hotel_ibfk_2` FOREIGN KEY (`codigo_hotel`) REFERENCES `hotel` (`codigo_hotel`);

--
-- Filtros para la tabla `turista_vuelo`
--
ALTER TABLE `turista_vuelo`
  ADD CONSTRAINT `turista_vuelo_ibfk_1` FOREIGN KEY (`codigo_turista`) REFERENCES `turista` (`codigo_turista`),
  ADD CONSTRAINT `turista_vuelo_ibfk_2` FOREIGN KEY (`codigo_vuelo`) REFERENCES `vuelo` (`codigo_vuelo`);
