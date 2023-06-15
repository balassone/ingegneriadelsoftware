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

INSERT INTO `centralino`.`agentidivendita` (`codicefiscale`) VALUES ('ABCDEF00D11H123N');
INSERT INTO `centralino`.`agentidivendita` (`codicefiscale`) VALUES ('BNCNHA92L55F205B');
INSERT INTO `centralino`.`agentidivendita` (`codicefiscale`) VALUES ('GHIJLM01E12F456K');
INSERT INTO `centralino`.`agentidivendita` (`codicefiscale`) VALUES ('KLJFCB73M23K805B');
INSERT INTO `centralino`.`agentidivendita` (`codicefiscale`) VALUES ('FOOBAR36b87P365D');

INSERT INTO `centralino`.`listenumeritelefonici` (`id`, `nome`) VALUES (1, 'Marketing'), (2, 'Business'), (3, 'Customer Service');
INSERT INTO `centralino`.`listenumeritelefonici` (`id`, `nome`) VALUES (4, 'ClientiVodafone'), (5, 'ClientiTim'), (6, 'Clienti3');

INSERT INTO `centralino`.`gruppi` (`id`, `descrizione`, `lista`) VALUES (1, 'Vendite', 1), (2, 'Consulenze', 2), (3, 'Assistenza',3);

INSERT INTO `centralino`.`centralinisti` (`id`, `nome`, `cognome`, `email`, `gruppo`) VALUES (1, 'Mario', 'Rossi', 'mario.rossi@example.com', 1), (2, 'Luigi', 'Verdi', 'luigi.verdi@example.com', 2), (3,'Luciano','Spalletti','spalletti@sscnapoli.it',3);

INSERT INTO `centralino`.`centralinisti` (`id`, `nome`, `cognome`, `email`, `gruppo`) VALUES (4, 'Francesco', 'Conti', 'francesco.conti@example.com', 1), (5, 'Martina', 'Moretti', 'martina.moretti@example.com', 2), (6,'Sofia','Santoro','sofia.santoro@sscnapoli.it',3);

INSERT INTO `centralino`.`centralinisti` (`id`, `nome`, `cognome`, `email`, `gruppo`) VALUES (7, 'Marco', 'Bianchi', 'marco.bianchi@example.com', 1), (8, 'Giulia', 'Russo','giulia.russo@example.com', 2), (9,'Luca','Ferrari','luca.ferrari@sscnapoli.it',3);

INSERT INTO `centralino`.`telefonate` (`id`, `data`, `ora`, `note`, `esito`, `centralinista`) VALUES (1, '01/01/2023', '10:00', 'Prima telefonata', 1, 1), (2, '02/01/2023', '11:30', 'Seconda telefonata', 2, 2), (3,'23/04/2023','10:00','Sicuramente richiamerà',3,3);

INSERT INTO `centralino`.`appuntamenti` (`idappuntamenti`, `data`, `ora`, `note`, `esito`, `precedente`, `telefonata`, `agente`) VALUES (1, '03/01/2023', '15:00', 'Primo appuntamento', 1, NULL, 1, 'ABCDEF00D11H123N'), (2, '2023-01-04', '16:30', 'Secondo appuntamento', 2, 1, 2, 'KLJFCB73M23K805B');

INSERT INTO `centralino`.`numeritelefonici` (`numero`, `lista`) VALUES ('1234567890', 1), ('9876543210', 2), ('1111231234', 1), ('2221231234', 2);
