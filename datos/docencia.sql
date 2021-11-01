-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 01-11-2021 a las 10:44:28
-- Versión del servidor: 5.6.51
-- Versión de PHP: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `docencia`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`%` PROCEDURE `subir_nota` (IN `procentaje` INT)  UPDATE estudiante_docencia SET notaFinal = notaFinal + notaFinal * procentaje / 100$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `id` int(11) NOT NULL,
  `nombreEstudiante` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidosEstudiante` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `fechaNacimiento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`id`, `nombreEstudiante`, `apellidosEstudiante`, `fechaNacimiento`) VALUES
(1, 'manuel', 'garcía garcía', '2000-10-07'),
(2, 'Luisa', 'Campos Campos', '1999-12-25'),
(4, 'pepe', 'arcos moya', '2021-10-26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante_docencia`
--

CREATE TABLE `estudiante_docencia` (
  `id_estudiante` int(11) NOT NULL,
  `id_materia` int(11) NOT NULL,
  `notaFinal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `estudiante_docencia`
--

INSERT INTO `estudiante_docencia` (`id_estudiante`, `id_materia`, `notaFinal`) VALUES
(2, 1, 6),
(2, 2, 4),
(1, 1, 1),
(1, 2, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `id` int(11) NOT NULL,
  `nombreMateria` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `profesor` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `horario` enum('mañana','tarde','','') COLLATE utf8_spanish_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`id`, `nombreMateria`, `profesor`, `horario`) VALUES
(1, 'base de datos', 'Joaquín Mena', 'mañana'),
(2, 'programación', 'Esperanza Ruíz', 'tarde');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `ver notas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `ver notas` (
`nombre` varchar(50)
,`apellidos` varchar(100)
,`materia` varchar(100)
,`nota` int(11)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `ver notas`
--
DROP TABLE IF EXISTS `ver notas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `ver notas`  AS SELECT `estudiante`.`nombreEstudiante` AS `nombre`, `estudiante`.`apellidosEstudiante` AS `apellidos`, `materia`.`nombreMateria` AS `materia`, `estudiante_docencia`.`notaFinal` AS `nota` FROM ((`estudiante` join `materia`) join `estudiante_docencia`) WHERE ((`estudiante`.`id` = `estudiante_docencia`.`id_estudiante`) AND (`materia`.`id` = `estudiante_docencia`.`id_materia`)) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estudiante_docencia`
--
ALTER TABLE `estudiante_docencia`
  ADD KEY `FK_ID_ESTUDIANTE` (`id_estudiante`),
  ADD KEY `FK_ID_MATERIA` (`id_materia`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estudiante_docencia`
--
ALTER TABLE `estudiante_docencia`
  ADD CONSTRAINT `FK_ID_ESTUDIANTE` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ID_MATERIA` FOREIGN KEY (`id_materia`) REFERENCES `materia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
