-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Хост: localhost:3306
-- Время создания: Июл 06 2018 г., 13:47
-- Версия сервера: 10.1.26-MariaDB-0+deb9u1
-- Версия PHP: 7.0.27-0+deb9u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `renory`
--

-- --------------------------------------------------------

--
-- Структура таблицы `amv`
--

CREATE TABLE `amv` (
  `id` int(11) NOT NULL,
  `alias` char(255) NOT NULL,
  `uploaderUserId` int(11) NOT NULL,
  `title` char(255) NOT NULL,
  `description` text NOT NULL,
  `studioId` int(11) NOT NULL,
  `dateCreated` date NOT NULL,
  `timeUploaded` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hitsOfPage` int(11) NOT NULL,
  `hitsOfOnlineView` int(11) NOT NULL,
  `downloadsCount` int(11) NOT NULL,
  `authors` text NOT NULL,
  `animeSrc` text NOT NULL,
  `musicSrc` text NOT NULL,
  `categories` text NOT NULL,
  `videos` text NOT NULL,
  `urls` text NOT NULL,
  `isComplete` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `amv_rules`
--

CREATE TABLE `amv_rules` (
  `id` int(11) NOT NULL,
  `amvId` int(11) NOT NULL,
  `rules` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `amv`
--
ALTER TABLE `amv`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `amv_rules`
--
ALTER TABLE `amv_rules`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `amv`
--
ALTER TABLE `amv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `amv_rules`
--
ALTER TABLE `amv_rules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
