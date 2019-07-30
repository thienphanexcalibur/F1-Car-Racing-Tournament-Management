-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 30, 2019 at 12:36 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `f1`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `ID` int(10) NOT NULL,
  `Name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Dob` date DEFAULT NULL,
  `Username` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Password` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Address` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`ID`, `Name`, `Dob`, `Username`, `Password`, `Address`) VALUES
(2, 'Phan Khanh Thien', '1984-04-08', 'thienphan', 'thien123', 'Nguyen Hoang Ton\r\n1002'),
(3, 'William Wike', '1974-04-05', 'abc', '1', 'New York');

-- --------------------------------------------------------

--
-- Table structure for table `fault`
--

CREATE TABLE `fault` (
  `ID` int(10) NOT NULL,
  `LapID` int(10) NOT NULL,
  `Description` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lap`
--

CREATE TABLE `lap` (
  `ID` int(10) NOT NULL,
  `RegisterID` int(10) NOT NULL,
  `TotalScore` float NOT NULL,
  `Faults` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `lap`
--

INSERT INTO `lap` (`ID`, `RegisterID`, `TotalScore`, `Faults`) VALUES
(4, 50, 50, 1),
(5, 53, 50, 2);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `ID` int(11) NOT NULL,
  `accountID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`ID`, `accountID`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `racer`
--

CREATE TABLE `racer` (
  `ID` int(10) NOT NULL,
  `TeamID` int(10) NOT NULL,
  `Name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Dob` date DEFAULT '2019-03-01',
  `Experience` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `racer`
--

INSERT INTO `racer` (`ID`, `TeamID`, `Name`, `Dob`, `Experience`) VALUES
(14, 28, 'Phan Khanh Thien', '1997-10-06', 3),
(15, 28, 'Nguyen Duc Thinh', '1997-10-06', 3),
(16, 28, 'John Williams', '1976-10-06', 3),
(17, 28, 'Hayden James', '1976-10-06', 3),
(18, 30, 'Bill Gates', '1955-10-28', 0),
(19, 30, 'Satya Nadella', '1955-10-28', 0),
(20, 30, 'Paul Allen', '1955-10-28', 0),
(21, 30, 'George Hotz', '1955-10-28', 0),
(22, 31, 'Phan Khanh Thien', '1997-10-06', 3),
(23, 31, 'Truong Quang Thai', '1997-10-06', 2),
(24, 31, 'Bui Manh Ha', '1997-10-06', 1),
(25, 31, 'Pham Son Ha', '1997-10-06', 0),
(26, 32, 'Alexander', '1997-10-06', 0),
(27, 32, 'James', '1997-10-06', 0),
(28, 32, 'Auto', '1997-10-06', 0),
(29, 32, 'Mith', '1997-10-06', 0);

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `ID` int(10) NOT NULL,
  `TeamID` int(10) NOT NULL,
  `RacerID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`ID`, `TeamID`, `RacerID`) VALUES
(50, 28, 15),
(51, 28, 16),
(52, 30, 20),
(53, 30, 21);

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `ID` int(10) NOT NULL,
  `LapID` int(10) NOT NULL,
  `Point` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stage`
--

CREATE TABLE `stage` (
  `ID` int(10) NOT NULL,
  `TotalLaps` int(10) NOT NULL DEFAULT '8'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `stage`
--

INSERT INTO `stage` (`ID`, `TotalLaps`) VALUES
(1, 8),
(2, 8),
(3, 8),
(4, 8),
(5, 8);

-- --------------------------------------------------------

--
-- Table structure for table `stage_register`
--

CREATE TABLE `stage_register` (
  `StageID` int(10) NOT NULL,
  `RegisterID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `stage_register`
--

INSERT INTO `stage_register` (`StageID`, `RegisterID`) VALUES
(1, 50),
(1, 51),
(2, 52),
(2, 53);

-- --------------------------------------------------------

--
-- Table structure for table `supporter`
--

CREATE TABLE `supporter` (
  `ID` int(10) NOT NULL,
  `Name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Dob` date DEFAULT NULL,
  `Mobile` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `ID` int(10) NOT NULL,
  `TournamentID` int(10) NOT NULL,
  `Name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`ID`, `TournamentID`, `Name`, `Description`) VALUES
(28, 1, 'Superior F1', 'We will win this F1'),
(29, 1, 'Stripe', 'A cross border payment solution'),
(30, 1, 'Microsoft', 'A software company'),
(31, 1, 'Coc Coc', 'A top 1 Search Engine in Vietnam'),
(32, 1, 'Github', 'Repository Management System');

-- --------------------------------------------------------

--
-- Table structure for table `tournament`
--

CREATE TABLE `tournament` (
  `ID` int(10) NOT NULL,
  `Name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `tournament`
--

INSERT INTO `tournament` (`ID`, `Name`, `StartDate`, `EndDate`) VALUES
(1, 'F1 Racing Cars 2019', '2019-07-18', '2019-07-31');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(10) NOT NULL,
  `AccountID` int(10) NOT NULL,
  `Discriminator` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `fault`
--
ALTER TABLE `fault`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKFault918010` (`LapID`);

--
-- Indexes for table `lap`
--
ALTER TABLE `lap`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKLap592043` (`RegisterID`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKAccountID` (`accountID`);

--
-- Indexes for table `racer`
--
ALTER TABLE `racer`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKRacer526111` (`TeamID`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `RacerID` (`RacerID`) USING BTREE,
  ADD KEY `FKRegister158857` (`TeamID`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKScore977782` (`LapID`);

--
-- Indexes for table `stage`
--
ALTER TABLE `stage`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `stage_register`
--
ALTER TABLE `stage_register`
  ADD PRIMARY KEY (`StageID`,`RegisterID`) USING BTREE,
  ADD KEY `RegisterID` (`RegisterID`);

--
-- Indexes for table `supporter`
--
ALTER TABLE `supporter`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKTeam728453` (`TournamentID`);

--
-- Indexes for table `tournament`
--
ALTER TABLE `tournament`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKUser921365` (`AccountID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `fault`
--
ALTER TABLE `fault`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lap`
--
ALTER TABLE `lap`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `manager`
--
ALTER TABLE `manager`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `racer`
--
ALTER TABLE `racer`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `score`
--
ALTER TABLE `score`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stage`
--
ALTER TABLE `stage`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `supporter`
--
ALTER TABLE `supporter`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `tournament`
--
ALTER TABLE `tournament`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `fault`
--
ALTER TABLE `fault`
  ADD CONSTRAINT `FKFault918010` FOREIGN KEY (`LapID`) REFERENCES `lap` (`ID`);

--
-- Constraints for table `lap`
--
ALTER TABLE `lap`
  ADD CONSTRAINT `FKLap592043` FOREIGN KEY (`RegisterID`) REFERENCES `register` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `manager`
--
ALTER TABLE `manager`
  ADD CONSTRAINT `FKAccountID` FOREIGN KEY (`accountID`) REFERENCES `account` (`ID`);

--
-- Constraints for table `racer`
--
ALTER TABLE `racer`
  ADD CONSTRAINT `FKRacer526111` FOREIGN KEY (`TeamID`) REFERENCES `team` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `register`
--
ALTER TABLE `register`
  ADD CONSTRAINT `FKRegister158857` FOREIGN KEY (`TeamID`) REFERENCES `team` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKRegister586976` FOREIGN KEY (`RacerID`) REFERENCES `racer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `FKScore977782` FOREIGN KEY (`LapID`) REFERENCES `lap` (`ID`);

--
-- Constraints for table `stage_register`
--
ALTER TABLE `stage_register`
  ADD CONSTRAINT `FKStage_Regi276932` FOREIGN KEY (`StageID`) REFERENCES `stage` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKStage_Regi910960` FOREIGN KEY (`RegisterID`) REFERENCES `register` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `FKTeam728453` FOREIGN KEY (`TournamentID`) REFERENCES `tournament` (`ID`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKUser921365` FOREIGN KEY (`AccountID`) REFERENCES `account` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
