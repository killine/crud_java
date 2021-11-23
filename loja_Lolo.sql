-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23-Nov-2021 às 03:28
-- Versão do servidor: 10.4.14-MariaDB
-- versão do PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `loja_lo`
--
CREATE DATABASE IF NOT EXISTS `loja_lo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `loja_lo`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `idcli` int(11) NOT NULL,
  `nomecli` varchar(50) NOT NULL,
  `endcli` varchar(100) DEFAULT NULL,
  `fonecli` varchar(15) NOT NULL,
  `emailcli` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`idcli`, `nomecli`, `endcli`, `fonecli`, `emailcli`) VALUES
(1, 'wendy', 'rua dos gatinhos,12', '114821-4470', 'lee_gatinha@gmail.com'),
(2, 'cacau', 'rua da toca, 24', '1195555-4444', 'chocolate@gmail.com'),
(3, 'leon', 'rua nct, 23', '11925814736', 'gatinho_leon@gmain'),
(4, 'louis', 'rua nct, 23', '11931456287', 'louis@gmail.com'),
(5, 'bella', 'rua nct, 23', '11966666555', 'doguinha_nct@gmail.com'),
(6, 'bongsik', 'rua nct, 23', '11932145632', 'gatinho_drean@gmail.com'),
(7, 'seol', 'rua nct, 23', '11965412387', 'seol@gmail.com'),
(8, 'nal', 'rua nct, 23', '11912312345', 'nal_gatinha@gmail.com'),
(9, 'kkoong', 'rua shinee, 5', '11955227733', 'kkoongie@gmail.com'),
(10, 'sonnie', 'rua perdida, 8', '11914785221', 'soonie@gmail.com'),
(11, 'doongie', 'rua perdida, 8', '11900218954', 'doongie@gmail.com'),
(12, 'dori', 'rua perdida, 8', '11975193482', 'dori_gatinha@gmail.com'),
(13, 'toto', 'rua do amanhã, 5', '11984521364', 'papagaio_toto@gmail.com'),
(14, 'choi odi', 'rua do amanhã, 5', '11984356155', 'odi@gmail.com'),
(15, 'hobak', 'rua do amanhã, 5', '11921549865', 'gatinho_hobak@gmail.com'),
(17, 'marvin', 'rua dos doguinhos, 113', '11944702121', 'marvin@gmail.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ordem_servico`
--

CREATE TABLE `ordem_servico` (
  `os` int(11) NOT NULL,
  `data_os` timestamp NOT NULL DEFAULT current_timestamp(),
  `equipamento` varchar(150) NOT NULL,
  `defeito` varchar(150) NOT NULL,
  `servico` varchar(150) NOT NULL,
  `tecnico` varchar(30) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `idcli` int(11) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  `situacao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `ordem_servico`
--

INSERT INTO `ordem_servico` (`os`, `data_os`, `equipamento`, `defeito`, `servico`, `tecnico`, `valor`, `idcli`, `tipo`, `situacao`) VALUES
(1, '2021-08-06 18:00:00', 'brinquedo', 'pelúcia sem perna ', 'costurar a perna da pelúcia', 'Niki', '40.00', 1, '', ''),
(2, '2021-08-05 12:10:00', 'gaiola média', 'porta quebrada', 'arrumar a porta', 'Louie', '25.00', 2, '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `iduser` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `fone` varchar(15) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `perfil` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`iduser`, `usuario`, `fone`, `login`, `senha`, `perfil`) VALUES
(1, 'yuta', '1195555-9999', 'yuta', '127', 'admin'),
(2, 'chan', '1194444-9999', 'chan', 'skz', 'admin'),
(3, 'jaemin', '11936405555', 'nana', 'czennie', 'user'),
(4, 'kwan', '11969125544', 'boo', 'svt', 'user'),
(5, 'tae', '11944706912', 'taemin', 'shinee', 'admin');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idcli`);

--
-- Índices para tabela `ordem_servico`
--
ALTER TABLE `ordem_servico`
  ADD PRIMARY KEY (`os`),
  ADD KEY `idcli` (`idcli`);

--
-- Índices para tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`iduser`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idcli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de tabela `ordem_servico`
--
ALTER TABLE `ordem_servico`
  MODIFY `os` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `ordem_servico`
--
ALTER TABLE `ordem_servico`
  ADD CONSTRAINT `ordem_servico_ibfk_1` FOREIGN KEY (`idcli`) REFERENCES `clientes` (`idcli`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
