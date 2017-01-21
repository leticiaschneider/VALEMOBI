-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema valemobi
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema valemobi
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `valemobi` DEFAULT CHARACTER SET utf8 ;
USE `valemobi` ;

-- -----------------------------------------------------
-- Table `valemobi`.`tb_mercadoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `valemobi`.`tb_mercadoria` (
  `cod_mercadoria` INT(11) NOT NULL,
  `tipo_mercadoria` VARCHAR(45) NOT NULL,
  `nome_mercadoria` VARCHAR(80) NOT NULL,
  `qtde_mercadoria` INT(11) NOT NULL,
  `preco_mercadoria` DECIMAL(8,2) NOT NULL,
  `tipoNeg_mercadoria` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`cod_mercadoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
