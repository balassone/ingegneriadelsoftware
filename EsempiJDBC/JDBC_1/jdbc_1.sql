-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb1` DEFAULT CHARACTER SET utf8 ;
USE `mydb1` ;

-- -----------------------------------------------------
-- Table `mydb1`.`studenti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb1`.`studenti` (
  `matricola` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cognome` VARCHAR(45) NULL,
  `nascita` VARCHAR(45) NULL,
  PRIMARY KEY (`matricola`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb1`.`studenti`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb1`;
INSERT INTO `mydb1`.`studenti` (`matricola`, `nome`, `cognome`, `nascita`) VALUES (1, 'marco', 'de luca', '27');
INSERT INTO `mydb1`.`studenti` (`matricola`, `nome`, `cognome`, `nascita`) VALUES (2, 'mario', 'rossi', '25');
INSERT INTO `mydb1`.`studenti` (`matricola`, `nome`, `cognome`, `nascita`) VALUES (3, 'luca', 'giallo', '33');

COMMIT;

