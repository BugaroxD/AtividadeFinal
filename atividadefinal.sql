-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13-Dez-2021 às 05:01
-- Versão do servidor: 10.4.20-MariaDB
-- versão do PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `atividadefinal`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alimentacao`
--

CREATE TABLE `alimentacao` (
  `id` int(11) NOT NULL,
  `leao_id` int(11) NOT NULL,
  `data` date NOT NULL,
  `detalhes` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `golfinho`
--

CREATE TABLE `golfinho` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `treinamento` int(11) NOT NULL,
  `jaula_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `golfinho`
--

INSERT INTO `golfinho` (`id`, `nome`, `treinamento`, `jaula_id`) VALUES
(6, 'Sese', 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `jaula`
--

CREATE TABLE `jaula` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `jaula`
--

INSERT INTO `jaula` (`id`, `descricao`) VALUES
(1, 'Jaula para Golfinho'),
(2, 'Jaula para Leao');

-- --------------------------------------------------------

--
-- Estrutura da tabela `leao`
--

CREATE TABLE `leao` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `alimentacao` int(11) NOT NULL,
  `visitantes` int(11) NOT NULL,
  `jaula_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `treinamento`
--

CREATE TABLE `treinamento` (
  `id` int(11) NOT NULL,
  `golfinho_id` int(11) NOT NULL,
  `data` date NOT NULL,
  `detalhes` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `alimentacao`
--
ALTER TABLE `alimentacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `alimentacao_fk0` (`leao_id`);

--
-- Índices para tabela `golfinho`
--
ALTER TABLE `golfinho`
  ADD PRIMARY KEY (`id`),
  ADD KEY `golfinho_fk0` (`jaula_id`);

--
-- Índices para tabela `jaula`
--
ALTER TABLE `jaula`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `leao`
--
ALTER TABLE `leao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `leao_fk0` (`jaula_id`);

--
-- Índices para tabela `treinamento`
--
ALTER TABLE `treinamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `treinamento_fk0` (`golfinho_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `alimentacao`
--
ALTER TABLE `alimentacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `golfinho`
--
ALTER TABLE `golfinho`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `jaula`
--
ALTER TABLE `jaula`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `leao`
--
ALTER TABLE `leao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `treinamento`
--
ALTER TABLE `treinamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `alimentacao`
--
ALTER TABLE `alimentacao`
  ADD CONSTRAINT `alimentacao_fk0` FOREIGN KEY (`leao_id`) REFERENCES `leao` (`id`);

--
-- Limitadores para a tabela `golfinho`
--
ALTER TABLE `golfinho`
  ADD CONSTRAINT `golfinho_fk0` FOREIGN KEY (`jaula_id`) REFERENCES `jaula` (`id`);

--
-- Limitadores para a tabela `leao`
--
ALTER TABLE `leao`
  ADD CONSTRAINT `leao_fk0` FOREIGN KEY (`jaula_id`) REFERENCES `jaula` (`id`);

--
-- Limitadores para a tabela `treinamento`
--
ALTER TABLE `treinamento`
  ADD CONSTRAINT `treinamento_fk0` FOREIGN KEY (`golfinho_id`) REFERENCES `golfinho` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
