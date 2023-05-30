-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb3` DEFAULT CHARACTER SET utf8 ;
USE `mydb3` ;

-- -----------------------------------------------------
-- Table `mydb3`.`studenti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb3`.`studenti` (
  `matricola` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cognome` VARCHAR(45) NULL,
  `nascita` VARCHAR(45) NULL,
  PRIMARY KEY (`matricola`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb3`.`Corsi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb3`.`Corsi` (
  `idCorsi` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idCorsi`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb3`.`Badge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb3`.`Badge` (
  `idBadge` INT NOT NULL,
  `tipo` VARCHAR(45) NULL,
  `studenti_matricola` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBadge`, `studenti_matricola`),
  INDEX `fk_Badge_studenti1_idx` (`studenti_matricola` ASC) VISIBLE,
  CONSTRAINT `fk_Badge_studenti1`
    FOREIGN KEY (`studenti_matricola`)
    REFERENCES `mydb3`.`studenti` (`matricola`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb3`.`studenti_has_Corsi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb3`.`studenti_has_Corsi` (
  `studenti_matricola` VARCHAR(45) NOT NULL,
  `Corsi_idCorsi` INT NOT NULL,
  PRIMARY KEY (`studenti_matricola`, `Corsi_idCorsi`),
  INDEX `fk_studenti_has_Corsi_Corsi1_idx` (`Corsi_idCorsi` ASC) VISIBLE,
  INDEX `fk_studenti_has_Corsi_studenti_idx` (`studenti_matricola` ASC) VISIBLE,
  CONSTRAINT `fk_studenti_has_Corsi_studenti`
    FOREIGN KEY (`studenti_matricola`)
    REFERENCES `mydb3`.`studenti` (`matricola`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_studenti_has_Corsi_Corsi1`
    FOREIGN KEY (`Corsi_idCorsi`)
    REFERENCES `mydb3`.`Corsi` (`idCorsi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb3`.`Testi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb3`.`Testi` (
  `idTesti` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `Corsi_idCorsi` INT NOT NULL,
  PRIMARY KEY (`idTesti`, `Corsi_idCorsi`),
  INDEX `fk_Testi_Corsi1_idx` (`Corsi_idCorsi` ASC) VISIBLE,
  CONSTRAINT `fk_Testi_Corsi1`
    FOREIGN KEY (`Corsi_idCorsi`)
    REFERENCES `mydb3`.`Corsi` (`idCorsi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb3`.`studenti`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb3`;
INSERT INTO `mydb3`.`studenti` (`matricola`, `nome`, `cognome`, `nascita`) VALUES ('M6300001', 'marco', 'de luca', '15/12/1994');
INSERT INTO `mydb3`.`studenti` (`matricola`, `nome`, `cognome`, `nascita`) VALUES ('M6300002', 'mario', 'rossi', '18/12/1994');
INSERT INTO `mydb3`.`studenti` (`matricola`, `nome`, `cognome`, `nascita`) VALUES ('M6300003', 'luca', 'verde', '01/02/1994');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb3`.`Corsi`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb3`;
INSERT INTO `mydb3`.`Corsi` (`idCorsi`, `nome`) VALUES (1, 'ingengeria del software');
INSERT INTO `mydb3`.`Corsi` (`idCorsi`, `nome`) VALUES (2, 'teoria dei segnali');
INSERT INTO `mydb3`.`Corsi` (`idCorsi`, `nome`) VALUES (3, 'analisi matematica 1');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb3`.`Badge`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb3`;
INSERT INTO `mydb3`.`Badge` (`idBadge`, `tipo`, `studenti_matricola`) VALUES (1, 'full', 'M6300001');
INSERT INTO `mydb3`.`Badge` (`idBadge`, `tipo`, `studenti_matricola`) VALUES (2, 'basic', 'M6300002');
INSERT INTO `mydb3`.`Badge` (`idBadge`, `tipo`, `studenti_matricola`) VALUES (3, 'pro', 'M6300003');
INSERT INTO `mydb3`.`Badge` (`idBadge`, `tipo`, `studenti_matricola`) VALUES (4, 'pro', 'M6300001');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb3`.`studenti_has_Corsi`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb3`;
INSERT INTO `mydb3`.`studenti_has_Corsi` (`studenti_matricola`, `Corsi_idCorsi`) VALUES ('M6300001', 1);
INSERT INTO `mydb3`.`studenti_has_Corsi` (`studenti_matricola`, `Corsi_idCorsi`) VALUES ('M6300001', 2);
INSERT INTO `mydb3`.`studenti_has_Corsi` (`studenti_matricola`, `Corsi_idCorsi`) VALUES ('M6300002', 3);
INSERT INTO `mydb3`.`studenti_has_Corsi` (`studenti_matricola`, `Corsi_idCorsi`) VALUES ('M6300003', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb3`.`Testi`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb3`;
INSERT INTO `mydb3`.`Testi` (`idTesti`, `nome`, `Corsi_idCorsi`) VALUES (1, 'is_libro', 1);
INSERT INTO `mydb3`.`Testi` (`idTesti`, `nome`, `Corsi_idCorsi`) VALUES (2, 'ta_libro', 2);
INSERT INTO `mydb3`.`Testi` (`idTesti`, `nome`, `Corsi_idCorsi`) VALUES (3, 'am_libro', 3);
INSERT INTO `mydb3`.`Testi` (`idTesti`, `nome`, `Corsi_idCorsi`) VALUES (4, 'is_libro_2', 1);

COMMIT;

