-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 04-Dez-2015 às 17:27
-- Versão do servidor: 5.5.46-0ubuntu0.14.04.2
-- versão do PHP: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `projetodesoftware`
--
CREATE DATABASE IF NOT EXISTS `projetodesoftware` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `projetodesoftware`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `inscricao`
--

CREATE TABLE IF NOT EXISTS `inscricao` (
  `idinscricao` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `minicurso_idminicurso` int(11) NOT NULL,
  `participante_idparticipante` int(11) NOT NULL,
  PRIMARY KEY (`idinscricao`),
  KEY `minicurso_idminicurso` (`minicurso_idminicurso`),
  KEY `participante_idparticipante` (`participante_idparticipante`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `inscricao`
--

INSERT INTO `inscricao` (`idinscricao`, `status`, `tipo`, `minicurso_idminicurso`, `participante_idparticipante`) VALUES
(3, 'Okay', 'Aplicador', 3, 1),
(4, 'Okay', 'Aplicador', 4, 2),
(5, 'Pago', 'Participante', 12, 2),
(6, 'OK', 'participante', 4, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `minicurso`
--

CREATE TABLE IF NOT EXISTS `minicurso` (
  `idminicurso` int(11) NOT NULL AUTO_INCREMENT,
  `assunto` varchar(255) NOT NULL,
  `duracao` varchar(255) NOT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`idminicurso`),
  UNIQUE KEY `assunto` (`assunto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Extraindo dados da tabela `minicurso`
--

INSERT INTO `minicurso` (`idminicurso`, `assunto`, `duracao`, `preco`) VALUES
(3, 'IPV6', '2 horas', 15),
(4, 'Inteligencia Artificial', '4 horas', 30),
(12, 'Unity', '4 horas', 25),
(13, 'Steam', '2 horas', 15),
(14, 'Game', '2 horas', 15),
(15, 'JQuery', '2h', 15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `participante`
--

CREATE TABLE IF NOT EXISTS `participante` (
  `idparticipante` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `ra` varchar(40) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`idparticipante`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `participante`
--

INSERT INTO `participante` (`idparticipante`, `nome`, `ra`, `email`) VALUES
(1, 'Luciano Santana', '1589490', 'luciano@gmail.com'),
(2, 'Lucas Gonsalves', '1590294', 'lucas@gmail.com');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `inscricao`
--
ALTER TABLE `inscricao`
  ADD CONSTRAINT `inscricao_ibfk_1` FOREIGN KEY (`minicurso_idminicurso`) REFERENCES `minicurso` (`idminicurso`),
  ADD CONSTRAINT `inscricao_ibfk_2` FOREIGN KEY (`participante_idparticipante`) REFERENCES `participante` (`idparticipante`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
