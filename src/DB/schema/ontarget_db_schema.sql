SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `ontarget` ;
CREATE SCHEMA IF NOT EXISTS `ontarget` DEFAULT CHARACTER SET latin1 ;
USE `ontarget` ;

-- -----------------------------------------------------
-- Table `ontarget`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`address` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`address` (
  `address_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `address1` VARCHAR(150) NOT NULL ,
  `address2` VARCHAR(20) NULL DEFAULT NULL ,
  `city` VARCHAR(45) NULL DEFAULT NULL ,
  `state` VARCHAR(5) NOT NULL ,
  `zip` VARCHAR(10) NULL DEFAULT NULL ,
  `country` VARCHAR(20) NOT NULL ,
  `address_type` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`address_id`) )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf32;


-- -----------------------------------------------------
-- Table `ontarget`.`project_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`project_category` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`project_category` (
  `project_category_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `category_name` VARCHAR(255) NOT NULL ,
  `parent_id` INT(11) NOT NULL ,
  `created_by` VARCHAR(20) NOT NULL ,
  `created_date` DATETIME NOT NULL ,
  `modified_by` VARCHAR(20) NOT NULL ,
  `modified_date` DATETIME NOT NULL ,
  `delete_flag` TINYINT(4) NULL ,
  `deleted_by` VARCHAR(20) NULL ,
  `deleted_date` DATETIME NULL ,
  PRIMARY KEY (`project_category_id`) )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`company_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`company_type` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`company_type` (
  `company_type_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `company_type_name` VARCHAR(255) NOT NULL ,
  `created_date` DATETIME NULL ,
  `created_by` VARCHAR(20) NULL ,
  `modified_date` DATETIME NULL ,
  `modified_by` VARCHAR(20) NULL ,
  `deleted_date` DATETIME NULL ,
  `delete_flag` TINYINT(4) NULL ,
  `deleted_by` VARCHAR(20) NULL ,
  `status` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`company_type_id`) )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`company_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`company_info` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`company_info` (
  `company_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `company_name` VARCHAR(45) NULL DEFAULT NULL ,
  `company_type_id` INT NOT NULL ,
  `address1` VARCHAR(45) NULL DEFAULT NULL ,
  `address2` VARCHAR(45) NULL DEFAULT NULL ,
  `city` VARCHAR(45) NULL DEFAULT NULL ,
  `state` VARCHAR(45) NULL DEFAULT NULL ,
  `zipcode` VARCHAR(45) NULL DEFAULT NULL ,
  `country` VARCHAR(45) NULL DEFAULT NULL ,
  `status` VARCHAR(45) NULL DEFAULT NULL ,
  `website` VARCHAR(30) NULL ,
  PRIMARY KEY (`company_id`) ,
  INDEX `comany_type_fk` (`company_type_id` ASC) ,
  CONSTRAINT `comany_type_fk`
  FOREIGN KEY (`company_type_id` )
  REFERENCES `ontarget`.`company_type` (`company_type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`user_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`user_type` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`user_type` (
  `user_type_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `user_type` VARCHAR(100) NOT NULL ,
  `created_date` DATETIME NOT NULL ,
  `created_by` VARCHAR(20) NOT NULL ,
  `modified_date` DATETIME NOT NULL ,
  `modified_by` VARCHAR(20) NOT NULL ,
  `is_expired` ENUM('0','1') NOT NULL DEFAULT '0' ,
  PRIMARY KEY (`user_type_id`) )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ontarget`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`user` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `user_name` VARCHAR(50) NULL DEFAULT NULL ,
  `user_type_id` INT NULL ,
  `password` VARCHAR(256) NOT NULL ,
  `user_status` ENUM('1','0') NULL DEFAULT '0' ,
  `number_of_login` INT(11) NULL DEFAULT NULL ,
  `modified_date` DATETIME NULL DEFAULT NULL ,
  `account_status` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`user_id`) ,
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC) ,
  INDEX `fk_user_type_id_idx` (`user_type_id` ASC) ,
  CONSTRAINT `fk_user_type_id`
  FOREIGN KEY (`user_type_id` )
  REFERENCES `ontarget`.`user_type` (`user_type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf32;


-- -----------------------------------------------------
-- Table `ontarget`.`contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`contact` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`contact` (
  `contact_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `user_id` INT(11) NOT NULL ,
  `contact_company_id` INT(11) NULL ,
  `title` VARCHAR(20) NULL ,
  `first_name` VARCHAR(45) NULL DEFAULT NULL ,
  `last_name` VARCHAR(45) NULL DEFAULT NULL ,
  `address_id` INT NULL ,
  `date_of_birth` DATE NULL DEFAULT NULL ,
  `contact_method` VARCHAR(45) NULL DEFAULT NULL ,
  `created_date` DATETIME NULL ,
  `created_by` VARCHAR(20) NULL ,
  `modified_date` DATETIME NULL ,
  `modified_by` VARCHAR(45) NULL ,
  `contact_status` VARCHAR(20) NULL DEFAULT '0' ,
  `contact_image` VARCHAR(255) NULL ,
  PRIMARY KEY (`contact_id`) ,
  INDEX `contact_user_fk` (`user_id` ASC) ,
  INDEX `company_fk` (`contact_company_id` ASC) ,
  CONSTRAINT `contact_user_fk`
  FOREIGN KEY (`user_id` )
  REFERENCES `ontarget`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `company_fk`
  FOREIGN KEY (`contact_company_id` )
  REFERENCES `ontarget`.`company_info` (`company_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf32;


-- -----------------------------------------------------
-- Table `ontarget`.`countries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`countries` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`countries` (
  `country_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `country_name` VARCHAR(100) NOT NULL ,
  `country_code` VARCHAR(3) NOT NULL ,
  PRIMARY KEY (`country_id`) )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`email`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`email` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`email` (
  `email_id` INT(11) NOT NULL ,
  `contact_id` INT(11) NOT NULL ,
  `email_address` VARCHAR(45) NULL DEFAULT NULL ,
  `email_type` VARCHAR(45) NULL DEFAULT NULL ,
  `status` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`email_id`) ,
  INDEX `email_fk` (`contact_id` ASC) ,
  CONSTRAINT `email_fk`
  FOREIGN KEY (`contact_id` )
  REFERENCES `ontarget`.`contact` (`contact_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`email_templates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`email_templates` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`email_templates` (
  `email_template_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `email_template_name` VARCHAR(255) NOT NULL ,
  `slug_name` VARCHAR(255) NOT NULL ,
  `subject` VARCHAR(255) NOT NULL ,
  `body` TEXT NOT NULL ,
  `created_date` DATETIME NOT NULL ,
  `created_by` INT(11) NOT NULL ,
  `modified_date` DATETIME NOT NULL ,
  `modified_by` INT(11) NOT NULL ,
  PRIMARY KEY (`email_template_id`) )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`phone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`phone` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`phone` (
  `phone_id` INT(11) NOT NULL ,
  `contact_id` INT(11) NOT NULL ,
  `area_code` INT(11) NULL DEFAULT NULL ,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL ,
  `phone_type` VARCHAR(45) NULL DEFAULT NULL ,
  `status` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`phone_id`) ,
  INDEX `phone_fk` (`contact_id` ASC) ,
  CONSTRAINT `phone_fk`
  FOREIGN KEY (`contact_id` )
  REFERENCES `ontarget`.`contact` (`contact_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`project_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`project_type` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`project_type` (
  `project_type_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `project_type_name` VARCHAR(255) NOT NULL ,
  `created_date` DATETIME NOT NULL ,
  `created_by` VARCHAR(20) NOT NULL ,
  `modified_date` DATETIME NOT NULL ,
  `modified_by` VARCHAR(20) NOT NULL ,
  `delete_flag` TINYINT(4) NULL ,
  `deleted_date` DATETIME NULL ,
  `deleted_by` VARCHAR(20) NULL ,
  `status` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`project_type_id`) )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`project` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`project` (
  `project_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `project_code` VARCHAR(50) NULL ,
  `project_name` VARCHAR(300) NULL DEFAULT NULL ,
  `project_owner_id` INT(11) NULL ,
  `project_category_id` INT(11) NULL DEFAULT NULL ,
  `project_type_id` INT(11) NOT NULL ,
  `project_parent_id` INT(11) NOT NULL DEFAULT '0' ,
  `project_assignee` VARCHAR(45) NULL DEFAULT NULL ,
  `project_description` TEXT NULL DEFAULT NULL ,
  `project_image` VARCHAR(255) NULL ,
  `project_start_date` DATETIME NULL DEFAULT NULL ,
  `project_end_date` DATETIME NULL DEFAULT NULL ,
  `project_status` VARCHAR(10) NULL DEFAULT NULL ,
  `company_id` INT(11) NOT NULL ,
  `address_id` INT NULL ,
  `created_date` DATETIME NULL ,
  `created_by` VARCHAR(20) NULL ,
  `modified_date` DATETIME NULL ,
  `modified_by` VARCHAR(20) NULL ,
  `delete_flag` TINYINT(4) NULL ,
  `deleted_date` DATETIME NULL ,
  `deleted_by` VARCHAR(20) NULL ,
  `project_image_path` VARCHAR(255) NULL ,
  PRIMARY KEY (`project_id`) ,
  INDEX `project_categ_fk` (`project_category_id` ASC) ,
  INDEX `project_type_fk` (`project_type_id` ASC) ,
  INDEX `project_addr_fk` (`address_id` ASC) ,
  INDEX `project_comp_fk` (`company_id` ASC) ,
  CONSTRAINT `project_categ_fk`
  FOREIGN KEY (`project_category_id` )
  REFERENCES `ontarget`.`project_category` (`project_category_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_type_fk`
  FOREIGN KEY (`project_type_id` )
  REFERENCES `ontarget`.`project_type` (`project_type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_addr_fk`
  FOREIGN KEY (`address_id` )
  REFERENCES `ontarget`.`address` (`address_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_comp_fk`
  FOREIGN KEY (`company_id` )
  REFERENCES `ontarget`.`company_info` (`company_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARACTER SET = utf32;


-- -----------------------------------------------------
-- Table `ontarget`.`project_task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`project_task` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`project_task` (
  `project_task_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `project_id` INT(11) NOT NULL ,
  `title` VARCHAR(200) NOT NULL ,
  `parent_task_id` INT(11) NULL DEFAULT '0' ,
  `status` VARCHAR(10) NULL DEFAULT NULL ,
  `percentage_complete` INT(11) NULL DEFAULT NULL ,
  `start_date` DATE NULL DEFAULT NULL ,
  `end_date` DATE NULL DEFAULT NULL ,
  `created_date` DATETIME NULL ,
  `created_by` VARCHAR(20) NULL ,
  `modified_date` DATETIME NULL ,
  `modified_by` VARCHAR(20) NULL ,
  `severity` VARCHAR(45) NULL ,
  `description` TEXT NULL ,
  PRIMARY KEY (`project_task_id`) ,
  INDEX `project_task_fk` (`project_id` ASC) ,
  CONSTRAINT `project_task_fk`
  FOREIGN KEY (`project_id` )
  REFERENCES `ontarget`.`project` (`project_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf32;


-- -----------------------------------------------------
-- Table `ontarget`.`project_activities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`project_activities` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`project_activities` (
  `project_activity_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `project_task_id` INT(11) NOT NULL ,
  `user_id` INT(11) NOT NULL ,
  `action` VARCHAR(100) NOT NULL ,
  `action_date` DATETIME NOT NULL ,
  PRIMARY KEY (`project_activity_id`) ,
  INDEX `proj_actvt_fk` (`project_task_id` ASC) ,
  CONSTRAINT `proj_actvt_fk`
  FOREIGN KEY (`project_task_id` )
  REFERENCES `ontarget`.`project_task` (`project_task_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`project_file`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`project_file` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`project_file` (
  `project_file_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `file_name` VARCHAR(255) NOT NULL ,
  `project_id` INT(11) NOT NULL ,
  `created_date` DATETIME NOT NULL ,
  `created_by` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`project_file_id`) ,
  INDEX `project_file_fk` (`project_id` ASC) ,
  CONSTRAINT `project_file_fk`
  FOREIGN KEY (`project_id` )
  REFERENCES `ontarget`.`project` (`project_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`project_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`project_member` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`project_member` (
  `project_member_id` INT(11) NOT NULL ,
  `project_id` INT(11) NOT NULL ,
  `user_id` INT(11) NULL DEFAULT NULL ,
  `member_status` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`project_member_id`) ,
  INDEX `member_project_fk` (`project_id` ASC) ,
  INDEX `member_user_fk` (`user_id` ASC) ,
  CONSTRAINT `member_project_fk`
  FOREIGN KEY (`project_id` )
  REFERENCES `ontarget`.`project` (`project_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `member_user_fk`
  FOREIGN KEY (`user_id` )
  REFERENCES `ontarget`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`project_task_comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`project_task_comments` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`project_task_comments` (
  `task_comment_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `project_task_id` INT(11) NOT NULL ,
  `comment` TEXT NOT NULL ,
  `comment_date` DATETIME NOT NULL ,
  `comment_by` INT(11) NOT NULL ,
  `reply_to` INT(11) NOT NULL ,
  PRIMARY KEY (`task_comment_id`) ,
  INDEX `task_cmnt_fk` (`project_task_id` ASC) ,
  CONSTRAINT `task_cmnt_fk`
  FOREIGN KEY (`project_task_id` )
  REFERENCES `ontarget`.`project_task` (`project_task_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`project_task_files`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`project_task_files` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`project_task_files` (
  `task_file_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `project_task_id` INT(11) NOT NULL ,
  `file_name` VARCHAR(255) NOT NULL ,
  `created_date` DATETIME NOT NULL ,
  `created_by` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`task_file_id`) ,
  INDEX `project_task_files_fk` (`project_task_id` ASC) ,
  CONSTRAINT `project_task_files_fk`
  FOREIGN KEY (`project_task_id` )
  REFERENCES `ontarget`.`project_task` (`project_task_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`project_wall_post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`project_wall_post` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`project_wall_post` (
  `project_wall_post_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `project_id` INT(11) NOT NULL ,
  `project_wall_post` VARCHAR(45) NULL DEFAULT NULL ,
  `created_date` DATETIME NOT NULL ,
  `created_by` VARCHAR(45) NOT NULL ,
  `modified_date` DATETIME NOT NULL ,
  `modified_by` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`project_wall_post_id`) ,
  INDEX `fk_project_id_idx` (`project_id` ASC) ,
  CONSTRAINT `fk_project_id`
  FOREIGN KEY (`project_id` )
  REFERENCES `ontarget`.`project` (`project_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf32;


-- -----------------------------------------------------
-- Table `ontarget`.`task_assignee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`task_assignee` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`task_assignee` (
  `task_assignee_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `project_task_id` INT(11) NOT NULL ,
  `task_asignee` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`task_assignee_id`) ,
  INDEX `task_assignee_fk` (`project_task_id` ASC) ,
  CONSTRAINT `task_assignee_fk`
  FOREIGN KEY (`project_task_id` )
  REFERENCES `ontarget`.`project_task` (`project_task_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf32;


-- -----------------------------------------------------
-- Table `ontarget`.`user_groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`user_groups` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`user_groups` (
  `user_group_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `user_group_name` VARCHAR(255) NOT NULL ,
  `created_date` DATETIME NOT NULL ,
  `created_by` INT(11) NOT NULL ,
  `modified_date` DATETIME NOT NULL ,
  `modified_by` INT(11) NOT NULL ,
  `delete_flag` TINYINT(4) NOT NULL ,
  `deleted_date` DATETIME NOT NULL ,
  `deleted_by` INT(11) NOT NULL ,
  PRIMARY KEY (`user_group_id`) )
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ontarget`.`user_session_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`user_session_info` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`user_session_info` (
  `user_session_info_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `user_id` INT(11) NOT NULL ,
  `login_token` VARCHAR(255) NOT NULL ,
  `created_date` DATETIME NOT NULL ,
  `expire_date` DATETIME NULL ,
  `is_expired` ENUM('0','1') NOT NULL DEFAULT '0' ,
  PRIMARY KEY (`user_session_info_id`) ,
  INDEX `fk_user_id_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_user_id`
  FOREIGN KEY (`user_id` )
  REFERENCES `ontarget`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ontarget`.`registration_request`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`registration_request` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`registration_request` (
  `registration_req_id` INT NULL AUTO_INCREMENT ,
  `project_id` INT NULL ,
  `name` VARCHAR(100) NULL ,
  `email` VARCHAR(45) NULL ,
  `company_name` VARCHAR(45) NULL ,
  `phone_number` VARCHAR(45) NULL ,
  `msg` TEXT NULL ,
  `status` VARCHAR(20) NULL ,
  PRIMARY KEY (`registration_req_id`) )
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ontarget`.`planned_actuals_cost`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`planned_actuals_cost` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`planned_actuals_cost` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '	' ,
  `task_id` INT NOT NULL ,
  `from_date` DATETIME NULL ,
  `to_date` DATETIME NULL ,
  `cost_type` VARCHAR(10) NULL ,
  `value` DECIMAL(10,3) NULL ,
  `expiry_date` DATETIME NULL ,
  `created_by` VARCHAR(20) NULL ,
  `created_date` DATETIME NULL ,
  `modified_by` VARCHAR(20) NULL ,
  `modified_date` DATETIME NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `planned_actual_task_fk` (`task_id` ASC) ,
  CONSTRAINT `planned_actual_task_fk`
  FOREIGN KEY (`task_id` )
  REFERENCES `ontarget`.`project_task` (`project_task_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ontarget`.`task_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`task_comment` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`task_comment` (
  `task_comment_id` INT NOT NULL AUTO_INCREMENT ,
  `task_id` INT NOT NULL ,
  `comment` TEXT NULL ,
  `commented_by` VARCHAR(20) NULL ,
  `commented_date` VARCHAR(20) NULL ,
  `comment_status` VARCHAR(15) NULL ,
  PRIMARY KEY (`task_comment_id`) ,
  INDEX `task_comment_fk` (`task_id` ASC) ,
  CONSTRAINT `task_comment_fk`
  FOREIGN KEY (`task_id` )
  REFERENCES `ontarget`.`project_task` (`project_task_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ontarget`.`task_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`task_status` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`task_status` (
  `task_status_id` INT NOT NULL AUTO_INCREMENT ,
  `status_code` VARCHAR(15) NULL ,
  `status_name` VARCHAR(15) NULL ,
  `status_description` VARCHAR(45) NULL ,
  PRIMARY KEY (`task_status_id`) )
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ontarget`.`task_percentage_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`task_percentage_log` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`task_percentage_log` (
  `task_percentage_log_id` INT NOT NULL AUTO_INCREMENT ,
  `task_id` INT NOT NULL ,
  `percentage_type` VARCHAR(45) NULL ,
  `percentage_complete` DOUBLE NULL DEFAULT 0 ,
  `start_date` DATETIME NULL ,
  `end_date` DATETIME NULL ,
  `created_by` VARCHAR(20) NULL ,
  `modified_date` DATETIME NULL ,
  `modified_by` VARCHAR(45) NULL ,
  `created_date` DATETIME NULL ,
  PRIMARY KEY (`task_percentage_log_id`) ,
  INDEX `task_percentage_fk` (`task_id` ASC) ,
  CONSTRAINT `task_percentage_fk`
  FOREIGN KEY (`task_id` )
  REFERENCES `ontarget`.`project_task` (`project_task_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ontarget`.`states`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`states` ;

CREATE  TABLE IF NOT EXISTS `ontarget`.`states` (
  `state_code` CHAR(2) NOT NULL ,
  `state` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`state_code`) )
  ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `ontarget`.`document`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `ontarget`.`document` ;

CREATE TABLE `document` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `document_template_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`document_id`),
  KEY `document_template_id_idx` (`document_template_id`),
  CONSTRAINT `document_template_2_document` FOREIGN KEY (`document_template_id`) REFERENCES `document_template` (`document_template_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

-- -----------------------------------------------------
-- Table `ontarget`.`document_attachment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`document_attachment` ;

CREATE TABLE `document_attachment` (
  `document_attachment_id` int(11) NOT NULL AUTO_INCREMENT,
  `document_id` int(11) NOT NULL,
  `file_path` varchar(45) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`document_attachment_id`),
  KEY `document_2_document_attachment_idx` (`document_id`),
  CONSTRAINT `document_2_document_attachment` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


-- -----------------------------------------------------
-- Table `ontarget`.`document_grid_key_value`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`document_grid_key_value` ;

CREATE TABLE `document_grid_key_value` (
  `document_id` int(11) NOT NULL,
  `grid_id` varchar(45) NOT NULL,
  `grid_row_index` int(11) NOT NULL,
  `key` varchar(45) NOT NULL,
  `value` text NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  KEY `document_2_document_grid_key_value_idx` (`document_id`),
  CONSTRAINT `document_2_document_grid_key_value` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- -----------------------------------------------------
-- Table `ontarget`.`document_key_value`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`document_key_value`;

CREATE TABLE `document_key_value` (
  `document_id` int(11) NOT NULL,
  `key` varchar(45) NOT NULL,
  `value` text NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  KEY `document_2_document_key_value_idx` (`document_id`),
  CONSTRAINT `document_2_document_key_value` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- -----------------------------------------------------
-- Table `ontarget`.`document_submittal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`document_submittal`;

CREATE TABLE `document_submittal` (
  `document_submittal_id` int(11) NOT NULL AUTO_INCREMENT,
  `document_id` int(11) NOT NULL,
  `assignee_user_id` int(11) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(45) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`document_submittal_id`),
  KEY `document_2_document_submittal_idx` (`document_id`),
  KEY `user_2_document_submittal_idx` (`assignee_user_id`),
  CONSTRAINT `document_2_document_submittal` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_2_document_submittal` FOREIGN KEY (`assignee_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- -----------------------------------------------------
-- Table `ontarget`.`document_template`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ontarget`.`document_template`;

CREATE TABLE `document_template` (
  `document_template_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(45) NOT NULL,
  `modfied_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`document_template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;





SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `ontarget`.`address`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`address` (`address_id`, `address1`, `address2`, `city`, `state`, `zip`, `country`, `address_type`) VALUES (1, '4750 59TH ST', '#9C', 'WOODSIDE', 'NY', '11377', 'USA', 'HOME');
INSERT INTO `ontarget`.`address` (`address_id`, `address1`, `address2`, `city`, `state`, `zip`, `country`, `address_type`) VALUES (2, '23 ST', NULL, 'New York', 'NY', '10001', 'USA', 'PROJECT');

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`company_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`company_type` (`company_type_id`, `company_type_name`, `created_date`, `created_by`, `modified_date`, `modified_by`, `deleted_date`, `delete_flag`, `deleted_by`, `status`) VALUES (1, 'GENERAL CONTRACTOR', NULL, 'SYSTEM', '', 'SYSTEM', '', NULL, NULL, 'ACTIVE');
INSERT INTO `ontarget`.`company_type` (`company_type_id`, `company_type_name`, `created_date`, `created_by`, `modified_date`, `modified_by`, `deleted_date`, `delete_flag`, `deleted_by`, `status`) VALUES (2, 'CONSTRUCTION MANAGER', NULL, 'SYSTEM', NULL, 'SYSTEM', NULL, NULL, NULL, 'ACTIVE');
INSERT INTO `ontarget`.`company_type` (`company_type_id`, `company_type_name`, `created_date`, `created_by`, `modified_date`, `modified_by`, `deleted_date`, `delete_flag`, `deleted_by`, `status`) VALUES (3, 'SUB CONTRACTOR', NULL, 'SYSTEM', NULL, 'SYSTEM', NULL, NULL, NULL, 'ACTIVE');
INSERT INTO `ontarget`.`company_type` (`company_type_id`, `company_type_name`, `created_date`, `created_by`, `modified_date`, `modified_by`, `deleted_date`, `delete_flag`, `deleted_by`, `status`) VALUES (4, 'OWNER', NULL, 'SYSTEM', NULL, 'SYSTEM', NULL, NULL, NULL, 'ACTIVE');
INSERT INTO `ontarget`.`company_type` (`company_type_id`, `company_type_name`, `created_date`, `created_by`, `modified_date`, `modified_by`, `deleted_date`, `delete_flag`, `deleted_by`, `status`) VALUES (5, 'SPECIALITY CONTRACTOR', NULL, 'SYSTEM', NULL, 'SYSTEM', NULL, NULL, NULL, 'ACTIVE');
INSERT INTO `ontarget`.`company_type` (`company_type_id`, `company_type_name`, `created_date`, `created_by`, `modified_date`, `modified_by`, `deleted_date`, `delete_flag`, `deleted_by`, `status`) VALUES (6, 'ARCHITECT/ENGINEERS', NULL, 'SYSTEM', NULL, 'SYSTE', NULL, NULL, NULL, 'ACTIVE');

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`company_info`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`company_info` (`company_id`, `company_name`, `company_type_id`, `address1`, `address2`, `city`, `state`, `zipcode`, `country`, `status`, `website`) VALUES (1, 'THE TTG', 1, '123 4TH ST', NULL, 'WOODSIDE', 'NY', '11377', 'USA', 'ACTIVE', 'http://www.ttg.com');

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`user_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`user_type` (`user_type_id`, `user_type`, `created_date`, `created_by`, `modified_date`, `modified_by`, `is_expired`) VALUES (1, 'USER', '11/05/2014', 'SYSTEM', '11/05/2014', 'SYSTEM', '0');

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`user` (`user_id`, `user_name`, `user_type_id`, `password`, `user_status`, `number_of_login`, `modified_date`, `account_status`) VALUES (1, 's@s.com', 1, '123456', '1', 1, '2014-11-05 02:30:40', 'ACTIVE');

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`contact`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`contact` (`contact_id`, `user_id`, `contact_company_id`, `title`, `first_name`, `last_name`, `address_id`, `date_of_birth`, `contact_method`, `created_date`, `created_by`, `modified_date`, `modified_by`, `contact_status`, `contact_image`) VALUES (1, 1, 1, 'CIO', 'Sanjeev', 'Ghimire', 1, '1984/01/30', 'PHONE', NULL, NULL, NULL, NULL, 'ACTIVE', NULL);

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`project_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`project_type` (`project_type_id`, `project_type_name`, `created_date`, `created_by`, `modified_date`, `modified_by`, `delete_flag`, `deleted_date`, `deleted_by`, `status`) VALUES (1, 'COMMERCIAL', '11/05/2014', 'SYSTEM', '11/05/2014', 'SYSTEM', NULL, NULL, NULL, 'ACTIVE');
INSERT INTO `ontarget`.`project_type` (`project_type_id`, `project_type_name`, `created_date`, `created_by`, `modified_date`, `modified_by`, `delete_flag`, `deleted_date`, `deleted_by`, `status`) VALUES (2, 'RESIDENTIAL', '11/05/2014', 'SYSTEM', '11/05/2014', 'SYSTEM', NULL, NULL, NULL, 'ACTIVE');
INSERT INTO `ontarget`.`project_type` (`project_type_id`, `project_type_name`, `created_date`, `created_by`, `modified_date`, `modified_by`, `delete_flag`, `deleted_date`, `deleted_by`, `status`) VALUES (3, 'INFRASTRUCTURE', '11/05/2014', 'SYSTEM', '11/05/2014', 'SYSTEM', NULL, NULL, NULL, 'ACTIVE');
INSERT INTO `ontarget`.`project_type` (`project_type_id`, `project_type_name`, `created_date`, `created_by`, `modified_date`, `modified_by`, `delete_flag`, `deleted_date`, `deleted_by`, `status`) VALUES (4, 'MEDICAL', '11/05/2014', 'SYSTEM', '11/05/2014', 'SYSTEM', NULL, NULL, NULL, 'ACTIVE');

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`project`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`project` (`project_id`, `project_code`, `project_name`, `project_owner_id`, `project_category_id`, `project_type_id`, `project_parent_id`, `project_assignee`, `project_description`, `project_image`, `project_start_date`, `project_end_date`, `project_status`, `company_id`, `address_id`, `created_date`, `created_by`, `modified_date`, `modified_by`, `delete_flag`, `deleted_date`, `deleted_by`, `project_image_path`) VALUES (1, 'TEST CODE', 'TEST PROJECT', 1, NULL, 1, 0, NULL, 'TEST PROJECT DESCRIPTION', NULL, '2014/11/13', '2014/12/13', 'ACTIVE', 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1169-1ftt0g7.JPG');
INSERT INTO `ontarget`.`project` (`project_id`, `project_code`, `project_name`, `project_owner_id`, `project_category_id`, `project_type_id`, `project_parent_id`, `project_assignee`, `project_description`, `project_image`, `project_start_date`, `project_end_date`, `project_status`, `company_id`, `address_id`, `created_date`, `created_by`, `modified_date`, `modified_by`, `delete_flag`, `deleted_date`, `deleted_by`, `project_image_path`) VALUES (2, 'TEST SUB CODE', 'TEST SUB PROJECT', 1, NULL, 2, 1, NULL, 'TEST SUB PROJECT', NULL, '2014/11/12', '2014/12/13', 'ACTIVE', 1, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`project_task`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`project_task` (`project_task_id`, `project_id`, `title`, `parent_task_id`, `status`, `percentage_complete`, `start_date`, `end_date`, `created_date`, `created_by`, `modified_date`, `modified_by`, `severity`, `description`) VALUES (1, 1, 'TEST TITLE', 0, 'ACTIVE', 0, '2014/11/12', '2014/12/13', NULL, NULL, NULL, NULL, 'MAJOR', 'TEST TASK');
INSERT INTO `ontarget`.`project_task` (`project_task_id`, `project_id`, `title`, `parent_task_id`, `status`, `percentage_complete`, `start_date`, `end_date`, `created_date`, `created_by`, `modified_date`, `modified_by`, `severity`, `description`) VALUES (2, 1, 'TEST TITLE 1', 0, 'ACTIVE', 0, '2014/11/12', '2014/12/13', NULL, NULL, NULL, NULL, 'CRITICAL', 'Test Task 1');
INSERT INTO `ontarget`.`project_task` (`project_task_id`, `project_id`, `title`, `parent_task_id`, `status`, `percentage_complete`, `start_date`, `end_date`, `created_date`, `created_by`, `modified_date`, `modified_by`, `severity`, `description`) VALUES (3, 2, 'test title 2', 0, 'ACTIVE', 0, '2014/11/12', '2014/12/13', NULL, NULL, NULL, NULL, 'MINOR', 'TEST TASK 3');

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`project_member`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`project_member` (`project_member_id`, `project_id`, `user_id`, `member_status`) VALUES (1, 1, 1, 'ACTIVE');

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`task_status`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
INSERT INTO `ontarget`.`task_status` (`task_status_id`, `status_code`, `status_name`, `status_description`) VALUES (1, 'ACTIVE', 'Active', 'Active Status');
INSERT INTO `ontarget`.`task_status` (`task_status_id`, `status_code`, `status_name`, `status_description`) VALUES (2, 'ONGOING', 'Ongoing', 'Ongoing Status');
INSERT INTO `ontarget`.`task_status` (`task_status_id`, `status_code`, `status_name`, `status_description`) VALUES (3, 'COMPLETED', 'Completed', 'Completed Status');
INSERT INTO `ontarget`.`task_status` (`task_status_id`, `status_code`, `status_name`, `status_description`) VALUES (4, 'PENDING', 'Pending', 'Pending Status');

COMMIT;
