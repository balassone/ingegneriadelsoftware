-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema centralino
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema centralino
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `centralino` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `centralino` ;

-- -----------------------------------------------------
-- Table `centralino`.`agentidivendita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centralino`.`agentidivendita` (
  `codicefiscale` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`codicefiscale`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `centralino`.`listenumeritelefonici`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centralino`.`listenumeritelefonici` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `centralino`.`gruppi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centralino`.`gruppi` (
  `id` INT NOT NULL,
  `descrizione` VARCHAR(45) NULL DEFAULT NULL,
  `lista` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_gruppi_listenumeritelefonici1_idx` (`lista` ASC) VISIBLE,
  CONSTRAINT `fk_gruppi_listenumeritelefonici1`
    FOREIGN KEY (`lista`)
    REFERENCES `centralino`.`listenumeritelefonici` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `centralino`.`centralinisti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centralino`.`centralinisti` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `cognome` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `gruppo` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_centralinisti_gruppi1_idx` (`gruppo` ASC) VISIBLE,
  CONSTRAINT `fk_centralinista_gruppo`
    FOREIGN KEY (`gruppo`)
    REFERENCES `centralino`.`gruppi` (`id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `centralino`.`telefonate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centralino`.`telefonate` (
  `id` INT NOT NULL,
  `data` VARCHAR(10) NULL DEFAULT NULL,
  `ora` VARCHAR(5) NULL DEFAULT NULL,
  `note` VARCHAR(1000) NULL DEFAULT NULL,
  `esito` INT NULL DEFAULT NULL,
  `centralinista` INT NOT NULL,
  PRIMARY KEY (`id`, `centralinista`),
  INDEX `fk_telefonate_centralinisti1_idx` (`centralinista` ASC) VISIBLE,
  CONSTRAINT `fk_telefonate_centralinisti1`
    FOREIGN KEY (`centralinista`)
    REFERENCES `centralino`.`centralinisti` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `centralino`.`appuntamenti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centralino`.`appuntamenti` (
  `idappuntamenti` INT NOT NULL,
  `data` VARCHAR(10) NULL DEFAULT NULL,
  `ora` VARCHAR(5) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_bin' NULL DEFAULT NULL,
  `note` VARCHAR(1000) NULL DEFAULT NULL,
  `esito` INT NULL DEFAULT NULL,
  `precedente` INT NULL DEFAULT NULL,
  `telefonata` INT NOT NULL,
  `agente` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`idappuntamenti`, `telefonata`, `agente`),
  INDEX `fk_appuntamenti_telefonate1_idx` (`telefonata` ASC) VISIBLE,
  INDEX `fk_appuntamenti_agentidivendita1_idx` (`agente` ASC) VISIBLE,
  CONSTRAINT `fk_appuntamenti_agentidivendita1`
    FOREIGN KEY (`agente`)
    REFERENCES `centralino`.`agentidivendita` (`codicefiscale`),
  CONSTRAINT `fk_appuntamenti_telefonate1`
    FOREIGN KEY (`telefonata`)
    REFERENCES `centralino`.`telefonate` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `centralino`.`numeritelefonici`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `centralino`.`numeritelefonici` (
  `numero` VARCHAR(10) NOT NULL,
  `lista` INT NULL DEFAULT NULL,
  PRIMARY KEY (`numero`),
  INDEX `fk_numeritelefonici_listenumeritelefonici_idx` (`lista` ASC) VISIBLE,
  CONSTRAINT `fk_numeritelefonici_listenumeritelefonici`
    FOREIGN KEY (`lista`)
    REFERENCES `centralino`.`listenumeritelefonici` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
