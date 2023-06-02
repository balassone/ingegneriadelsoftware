-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb2` DEFAULT CHARACTER SET utf8 ;
USE `mydb2` ;

-- -----------------------------------------------------
-- Table `mydb2`.`studenti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`studenti` (
  `matricola` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cognome` VARCHAR(45) NULL,
  `nascita` VARCHAR(45) NULL,
  PRIMARY KEY (`matricola`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`Corsi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`Corsi` (
  `idCorsi` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idCorsi`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`Badge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`Badge` (
  `idBadge` INT NOT NULL,
  `tipo` VARCHAR(45) NULL,
  `studenti_matricola` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBadge`, `studenti_matricola`),
  INDEX `fk_Badge_studenti1_idx` (`studenti_matricola` ASC) VISIBLE,
  CONSTRAINT `fk_Badge_studenti1`
    FOREIGN KEY (`studenti_matricola`)
    REFERENCES `mydb2`.`studenti` (`matricola`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb2`.`studenti_has_Corsi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`studenti_has_Corsi` (
  `studenti_matricola` VARCHAR(45) NOT NULL,
  `Corsi_idCorsi` INT NOT NULL,
  PRIMARY KEY (`studenti_matricola`, `Corsi_idCorsi`),
  INDEX `fk_studenti_has_Corsi_Corsi1_idx` (`Corsi_idCorsi` ASC) VISIBLE,
  INDEX `fk_studenti_has_Corsi_studenti_idx` (`studenti_matricola` ASC) VISIBLE,
  CONSTRAINT `fk_studenti_has_Corsi_studenti`
    FOREIGN KEY (`studenti_matricola`)
    REFERENCES `mydb2`.`studenti` (`matricola`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_studenti_has_Corsi_Corsi1`
    FOREIGN KEY (`Corsi_idCorsi`)
    REFERENCES `mydb2`.`Corsi` (`idCorsi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `mydb2`.`studenti`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb2`;
INSERT INTO `mydb2`.`studenti` (`matricola`, `nome`, `cognome`, `nascita`) VALUES ('M6300001', 'marco', 'de luca', '15/12/1994');
INSERT INTO `mydb2`.`studenti` (`matricola`, `nome`, `cognome`, `nascita`) VALUES ('M6300002', 'mario', 'rossi', '18/12/1994');
INSERT INTO `mydb2`.`studenti` (`matricola`, `nome`, `cognome`, `nascita`) VALUES ('M6300003', 'luca', 'verde', '01/02/1994');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb2`.`Corsi`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb2`;
INSERT INTO `mydb2`.`Corsi` (`idCorsi`, `nome`) VALUES (1, 'ingengeria del software');
INSERT INTO `mydb2`.`Corsi` (`idCorsi`, `nome`) VALUES (2, 'teoria dei segnali');
INSERT INTO `mydb2`.`Corsi` (`idCorsi`, `nome`) VALUES (3, 'analisi matematica 1');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb2`.`Badge`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb2`;
INSERT INTO `mydb2`.`Badge` (`idBadge`, `tipo`, `studenti_matricola`) VALUES (1, 'full', 'M6300001');
INSERT INTO `mydb2`.`Badge` (`idBadge`, `tipo`, `studenti_matricola`) VALUES (2, 'basic', 'M6300002');
INSERT INTO `mydb2`.`Badge` (`idBadge`, `tipo`, `studenti_matricola`) VALUES (3, 'pro', 'M6300003');
INSERT INTO `mydb2`.`Badge` (`idBadge`, `tipo`, `studenti_matricola`) VALUES (4, 'pro', 'M6300001');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb2`.`studenti_has_Corsi`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb2`;
INSERT INTO `mydb2`.`studenti_has_Corsi` (`studenti_matricola`, `Corsi_idCorsi`) VALUES ('M6300001', 1);
INSERT INTO `mydb2`.`studenti_has_Corsi` (`studenti_matricola`, `Corsi_idCorsi`) VALUES ('M6300001', 2);
INSERT INTO `mydb2`.`studenti_has_Corsi` (`studenti_matricola`, `Corsi_idCorsi`) VALUES ('M6300002', 3);
INSERT INTO `mydb2`.`studenti_has_Corsi` (`studenti_matricola`, `Corsi_idCorsi`) VALUES ('M6300003', 1);

COMMIT;