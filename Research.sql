-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Research
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Research
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Research` DEFAULT CHARACTER SET utf8 ;
USE `Research` ;

-- -----------------------------------------------------
-- Table `Research`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Research`.`Users` ;

CREATE TABLE IF NOT EXISTS `Research`.`Users` (
  `userID` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `name` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `interestArea` VARCHAR(100) NULL,
  `office` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Research`.`Projects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Research`.`Projects` ;

CREATE TABLE IF NOT EXISTS `Research`.`Projects` (
  `projectID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(100) NULL,
  `userID` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`projectID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Research`.`Users`
-- -----------------------------------------------------
START TRANSACTION;
USE `Research`;
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('gpavks', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Garret Arcoraci', 'Lecturer', 'cit nsa ist', 'GOL 2315', '5854757854', 'gpavks@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('ciiics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Catherine Beaton', 'Associate Professor', 'hci hcc cit ist', 'GOL 2621', '585-281-6162', 'catherine.beaton@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('dsbics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Daniel Bogaard', 'Associate Professor', 'cit hcc wmc ist', 'GOL 2111', '5854755231', 'dsbics@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('cbbics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Charlie Border', 'Associate Professor', 'cit ist nsa', 'GOL 2615', '585-475-7946', 'cbbics@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('sgcics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Stephen Cady', 'Visiting Lecturer', 'ist', 'GOL-2627', NULL, 'sgcics@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('mjfics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Michael Floeser', 'Senior Lecturer', 'ist cit wmc', 'GOL 2669', '585-475-7031', 'Michael.Floeser@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('bdfvks', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Bryan French', 'Lecturer', 'cit ist wmc', 'GOL 2619', '(585) 475-6511', 'bdfvks@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('efgics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Erik Golen', 'Lecturer', 'nsa ist cit', 'GOL 2617', NULL, 'efgics@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('jrhicsa', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'James Habermas', 'Visiting Lecturer', 'wmc cit hcc hci nsa ist', 'GOL 2443', '475-6369', 'jrhicsa@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('vlhics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Vicki Hanson', 'Professor Emerita', 'hci hcc', 'GOL 2645', '585-475-5384', 'vlh@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('bhhics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Bruce Hartpence', 'Professor', 'cit ist nsa', 'GOL 2323', '585-475-7938', 'Bruce.Hartpence@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('amhgss', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Andrew Herbert', 'Professor', 'hcc', 'EAS 01-2323', '585-475-4554', 'amhgss@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('lwhfac', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Larry Hill', 'Associate Professor', 'cit nsa ist hi', 'GOL 2331', '585-475-7064', 'Lawrence.Hill@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('ephics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Ed Holden', 'Associate Professor', 'cit ist hi', 'GOL 2655', '585-475-5361', 'edward.holden@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('mphics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Matt Huenerfauth', 'Professor', 'hcc hci', 'GOL 2659', '585-475-2459', 'matt.huenerfauth (AT) rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('sjhcco', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Sarah J. Huibregtse', 'Visiting Lecturer', 'ist', 'GOL 2518', NULL, 'sjhcco@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('jwkics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Jai Kang', 'Associate Professor', 'cit ist hi', 'GOL 2651', '585-475-5362', 'jai.kang@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('jalics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Jeffrey Lasky', 'Professor', 'cit ist', 'GOL 26xx', '585-475-2284', 'Jeffrey.Lasky@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('jalvks', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Jim Leone', 'Professor', 'cit ist nsa wmc', 'GOL 2657', '585-475-6451', 'jalvks@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('phlics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Peter Lutz', 'Professor', 'cit nsa ist', 'GOL 2345', '585-475-6162', 'Peter.Lutz@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('spmics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Sharon Mason', 'Professor', 'nsa cit ist', 'GOL 2319', '585-475-6989', 'Sharon.Mason@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('mjmics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Michael McQuaid', 'Lecturer', 'cit ist hci hcc', NULL, NULL, 'mickmcquaid@gmail.com', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('thoics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Tae (Tom) Oh', 'Associate Professor', 'hci hcc cit nsa ist wmc', 'GOL 2281', '585-475-7642', 'Tom.Oh@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('dkpvcs', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'David Patric', 'Visiting Lecturer', 'ist', 'GOL-2281', '585-475-5231', 'dkpvcs@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('sphics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Sylvia Perez-Hardy', 'Associate Professor', 'cit nsa ist', NULL, '585-475-7941', 'sylvia.perez-hardy@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('djpihst', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Jerry Powell', 'Visiting Assistant Professor', 'hi', 'CBT-2161', '585-475-2487', 'djpihst@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('nxsvks', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Nirmala Shenoy', 'Professor', 'cit nsa ist', NULL, NULL, 'nxsvks@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('kssics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Kristen Shinohara', 'Assistant Professor', 'hci hcc', NULL, NULL, 'kssics@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('aesfaa', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Adam Smith', 'Assistant Professor', 'hcc', NULL, '585-475-4552', 'adam.smith@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('bmtski', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Brian Tomaszewski', 'Assistant Professor', 'cit wmc', 'GOL 2673', '585-475-2859', 'bmtski@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('rpvvks', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Ronald Vullo', 'Assistant Professor', 'cit ist wmc', 'GOL 2519', '585-475-7281', 'rpv@mail.rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('emwics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Elissa Weeden', 'Assistant Professor', 'cit ist hcc hci', 'GOL 2635', '585-475-6733', 'emwics@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('qyuvks', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Qi Yu', 'Assistant Professor', 'cit ist nsa hci hi', 'GOL 2113', '585-475-6929', 'qyuvks@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('sjzics', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Steve Zilora', 'Professor', 'wmc cit hcc hci nsa ist hi', 'GOL 2109', '585-475-7643', 'sjzics@rit.edu', 'faculty');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('jma6658', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Julian Arya', NULL, NULL, NULL, NULL, 'jma6658@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('axb4069', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Andrew Berson', NULL, NULL, NULL, NULL, 'axb4069@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('wkc6735', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Winston Chang', NULL, NULL, NULL, NULL, 'wkc6735@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('bdc5435', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Brandon Connors', NULL, NULL, NULL, NULL, 'bdc5435@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('see2797', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Samuel Evans', NULL, NULL, NULL, NULL, 'see2797@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('alk2993', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Andrew Kukielka', NULL, NULL, NULL, NULL, 'alk2993@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('vk4534', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Vignesh Kumar', NULL, NULL, NULL, NULL, 'vk4534@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('kxl3544', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Kevin Lozano', NULL, NULL, NULL, NULL, 'kxl3544@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('dxm2269', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Dishant Mishra', NULL, NULL, NULL, NULL, 'dxm2269@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('djm7955', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Sylvia Mosquea Garcia', NULL, NULL, NULL, NULL, 'djm7955@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('arp6333', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Ellie Parobek', NULL, NULL, NULL, NULL, 'arp6333@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('llr4395', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Lorenzo Romero', NULL, NULL, NULL, NULL, 'llr4395@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('lgs9654', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Luke Schwarting', NULL, NULL, NULL, NULL, 'lgs9654@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('rms1252', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Rachael Simmonds', NULL, NULL, NULL, NULL, 'rms1252@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('dxt4298', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Dominico Tran', NULL, NULL, NULL, NULL, 'dxt4298@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('cet2576', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Clare Truell', NULL, NULL, NULL, NULL, 'cet2576@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('ra7918', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Rixhers Ajazi', NULL, NULL, NULL, NULL, 'ra7918@mail.rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('ksc2650', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Kemoy Campbell', NULL, NULL, NULL, NULL, 'ksc2650@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('cfc1182', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Cameron Casselman', NULL, NULL, NULL, NULL, 'cfc1182@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('clc8254', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Conner Catanese', NULL, NULL, NULL, NULL, 'clc8254@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('dpc3140', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Daniel Chang', NULL, NULL, NULL, NULL, 'dpc3140@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('mc4107', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Mikhail Chebotar', NULL, NULL, NULL, NULL, 'mc4107@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('atc1512', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Andrew Costanzo', NULL, NULL, NULL, NULL, 'atc1512@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('txd5857', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Tenzin Dhondup', NULL, NULL, NULL, NULL, 'txd5857@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('zpe4421', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Zachary Easley', NULL, NULL, NULL, NULL, 'zpe4421@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('ajg2473', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Andrew Grubbs', NULL, NULL, NULL, NULL, 'ajg2473@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('axk3897', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Aaron Kelly', NULL, NULL, NULL, NULL, 'axk3897@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('mxl4543', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Mei Ling Liu', NULL, NULL, NULL, NULL, 'mxl4543@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('axm6392', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Amina Mahmood', NULL, NULL, NULL, NULL, 'axm6392@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('bxm5989', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Brandon Mok', NULL, NULL, NULL, NULL, 'bxm5989@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('dwmdis', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Dale Moore', NULL, NULL, NULL, NULL, 'dwmdis@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('jo8390', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Jacob O\'Connor', NULL, NULL, NULL, NULL, 'jo8390@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('nsp6459', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Nicholas Porillo', NULL, NULL, NULL, NULL, 'nsp6459@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('axr1623', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Abid Raja', NULL, NULL, NULL, NULL, 'axr1623@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('dxs8115', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Demetri Sakellaropoulos', NULL, NULL, NULL, NULL, 'dxs8115@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('als6301', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Abbey Sands', NULL, NULL, NULL, NULL, 'als6301@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('cas8738', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Charles Shaner', NULL, NULL, NULL, NULL, 'cas8738@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('brt4557', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Benjamin Thorn', NULL, NULL, NULL, NULL, 'brt4557@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('kmv7239', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Kevin Voltz', NULL, NULL, NULL, NULL, 'kmv7239@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('acy8525', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Alexander Yu Huang', NULL, NULL, NULL, NULL, 'acy8525@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('moa3971', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Mohammed Owaidh H Aljohani', NULL, NULL, NULL, NULL, 'moa3971@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('sa9635', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Shatha Naqa Alotaibi', NULL, NULL, NULL, NULL, 'sa9635@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('axa5735', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Abeer Ali H Alshehri', NULL, NULL, NULL, NULL, 'axa5735@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('pa1001', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Pallavi Arora', NULL, NULL, NULL, NULL, 'pa1001@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('ppd1073', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Prajakta Prashant Deshpande', NULL, NULL, NULL, NULL, 'ppd1073@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('rjl9447', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Ryan Leonard', NULL, NULL, NULL, NULL, 'rjl9447@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('lpn2762', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Lekha Pramodkumar Nahar', NULL, NULL, NULL, NULL, 'lpn2762@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('mpn3885', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Mayuresh Pradeep Naik', NULL, NULL, NULL, NULL, 'mpn3885@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('vxp9202', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Vismay Ashok Pandit', NULL, NULL, NULL, NULL, 'vxp9202@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('sp5100', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Sulagna Patra', NULL, NULL, NULL, NULL, 'sp5100@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('sxr3463', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Shashank Prasanna Reddy', NULL, NULL, NULL, NULL, 'sxr3463@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('aj4693', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Anna Jacobsen', NULL, NULL, NULL, NULL, 'aj4693@rit.edu', 'student');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('aw1234', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Adam West', NULL, NULL, NULL, NULL, 'aw1234@gmail.com', 'public');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('bw9876', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Bruce Wayne', NULL, NULL, NULL, NULL, 'bw9876@gmail.com', 'public');
INSERT INTO `Research`.`Users` (`userID`, `password`, `name`, `title`, `interestArea`, `office`, `phone`, `email`, `role`) VALUES ('ck5555', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'Clark Kent', NULL, NULL, NULL, NULL, 'ck5555@gmail.com', 'public');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Research`.`Projects`
-- -----------------------------------------------------
START TRANSACTION;
USE `Research`;
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (1, 'Alpha', 'High-command', 'gpavks');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (2, 'Beta', 'The Elites', 'dsbics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (3, 'Charlie', 'Vanguards', 'sgcics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (4, 'Delta', 'Infiltrators', 'bdfvks');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (5, 'Echo', 'The flyers', 'jrhicsa');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (6, 'Foxtrot', 'The cavalry', 'jrhicsa');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (7, 'Golf', 'A sport', 'bhhics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (8, 'Hotel', 'A place', 'lwhfac');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (9, 'India', 'A country', 'ephics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (10, 'Juliet', 'Female lead', 'mjfics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (11, 'Kilo', 'Weight', 'mjfics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (12, 'Lima', 'Llama?', 'mjfics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (13, 'Mike', 'A name', 'cbbics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (14, 'November', 'A month', 'efgics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (15, 'Oscar', 'DiCaprio', 'qyuvks');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (16, 'Papa', 'Father', 'rpvvks');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (17, 'Quebec', 'Friendly place', 'mjfics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (18, 'Romeo', 'Male lead', 'spmics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (19, 'Sierra', 'Mist', 'phlics');
INSERT INTO `Research`.`Projects` (`projectID`, `name`, `description`, `userID`) VALUES (20, 'Tango', 'Dance', 'mjmics');

COMMIT;

