-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30-Nov-2015 às 23:53
-- Versão do servidor: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `projetodesoftware`
--
CREATE DATABASE IF NOT EXISTS `projetodesoftware` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `projetodesoftware`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `inscricao`
--

CREATE TABLE IF NOT EXISTS `inscricao` (
  `idinscricao` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `minicurso_idminicurso` int(11) NOT NULL,
  `participante_idparticipante` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `inscricao`
--

INSERT INTO `inscricao` (`idinscricao`, `status`, `tipo`, `minicurso_idminicurso`, `participante_idparticipante`) VALUES
(3, 'Okay', 'Aplicador', 3, 1),
(4, 'Okay', 'Aplicador', 4, 2),
(5, 'Pago', 'Participante', 12, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `minicurso`
--

CREATE TABLE IF NOT EXISTS `minicurso` (
  `idminicurso` int(11) NOT NULL,
  `assunto` varchar(255) NOT NULL,
  `duracao` varchar(255) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `minicurso`
--

INSERT INTO `minicurso` (`idminicurso`, `assunto`, `duracao`, `preco`) VALUES
(3, 'IPV6', '2 horas', 15),
(4, 'Inteligencia Artificial', '4 horas', 30),
(12, 'Unity', '4 horas', 25),
(13, 'Steam', '2 horas', 15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `participante`
--

CREATE TABLE IF NOT EXISTS `participante` (
  `idparticipante` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `ra` varchar(40) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `participante`
--

INSERT INTO `participante` (`idparticipante`, `nome`, `ra`, `email`) VALUES
(1, 'Luciano Santana', '159200', 'luciano@gmail.com'),
(2, 'Lucas Gonsalves', '1590294', 'lucas@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inscricao`
--
ALTER TABLE `inscricao`
  ADD PRIMARY KEY (`idinscricao`), ADD KEY `minicurso_idminicurso` (`minicurso_idminicurso`), ADD KEY `participante_idparticipante` (`participante_idparticipante`);

--
-- Indexes for table `minicurso`
--
ALTER TABLE `minicurso`
  ADD PRIMARY KEY (`idminicurso`), ADD UNIQUE KEY `assunto` (`assunto`);

--
-- Indexes for table `participante`
--
ALTER TABLE `participante`
  ADD PRIMARY KEY (`idparticipante`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inscricao`
--
ALTER TABLE `inscricao`
  MODIFY `idinscricao` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `minicurso`
--
ALTER TABLE `minicurso`
  MODIFY `idminicurso` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `participante`
--
ALTER TABLE `participante`
  MODIFY `idparticipante` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
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
