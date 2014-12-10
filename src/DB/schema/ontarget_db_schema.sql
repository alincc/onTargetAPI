SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='';

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
DROP TABLE IF EXISTS `ontarget`.`user`;

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL auto_increment ,
  `user_name` varchar(50) DEFAULT NULL,
  `user_type_id` int(11) DEFAULT NULL,
  `password` text NOT NULL,
  `salt` text NOT NULL,
  `user_status` enum('1','0') DEFAULT '0',
  `discipline` bigint(20) NOT NULL,
  `number_of_login` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `account_status` varchar(45) DEFAULT NULL,
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

--
-- Table structure for table `discipline`
--
DROP TABLE IF EXISTS `ontarget`.`discipline`;

CREATE TABLE IF NOT EXISTS `discipline` (
  `id` bigint(20) NOT NULL,
  `name` varchar(200) NOT NULL,
  `info` text NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Indexes for table `discipline`
--
ALTER TABLE `discipline`
ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for table `discipline`
--
ALTER TABLE `discipline`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;


--
-- Table structure for table `user_safety_info`
--
DROP TABLE IF EXISTS `ontarget`.`user_safety_info`;
CREATE TABLE IF NOT EXISTS `user_safety_info` (
  `id` bigint(20) NOT NULL,
  `name` varchar(524) NOT NULL,
  `info` text NOT NULL,
  `discipline_id` bigint(20) NOT NULL,
  `ts_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=200 ;


--
-- Indexes for table `user_safety_info`
--
ALTER TABLE `user_safety_info`
ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for table `user_safety_info`
--
ALTER TABLE `user_safety_info`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=200;



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
  `phone_id` INT(11) NOT NULL auto_increment,
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

ALTER TABLE `ontarget`.`project_file`
ADD COLUMN `file_type` VARCHAR(45) NOT NULL ;


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
  `location` varchar(255) NOT NULL,
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

CREATE TABLE IF NOT EXISTS `registration_request` (
  `id` bigint(20) NOT NULL primary key AUTO_INCREMENT,
  `registration_token` varchar(64) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `company_name` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `msg` text,
  `status` varchar(20) DEFAULT NULL,
  `ts_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

alter table registration_request add column user_id bigint(20);

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
  `commented_date` DATETIME NULL ,
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
INSERT INTO `user` (`user_id`, `user_name`, `user_type_id`, `password`, `salt`, `user_status`, `discipline`, `number_of_login`, `modified_date`, `account_status`) VALUES (1, 's@s.com', 1, '12181283118380180445335585944462131631204182922070938422473264293905395639766447125822477536403010703646002314643700483720602782325437365521667942326009590', '16468408816162761056360314163240453909611518639368113122311522613954727264320999800960119461651792926693894616283890051322500209473979134653470895270221910736053124525230359038613417509020465117643578975099969164265858301330201493161869022298101183775297053607871038563272630740066062165808655461416231531384', '1', 1, 1, '2014-11-05 02:30:40', 'ACTIVE');

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



--
-- Dumping data for table `discipline`
--
START TRANSACTION;
USE `ontarget`;
INSERT INTO `discipline` (`id`, `name`, `info`, `ts_insert`) VALUES (1, 'masonry', 'Masonry', now());
INSERT INTO `discipline` (`id`, `name`, `info`, `ts_insert`) VALUES (2, 'plumbing', 'Plumbing', now());
INSERT INTO `discipline` (`id`, `name`, `info`, `ts_insert`) VALUES (3, 'electrical', 'Electrical', now());
INSERT INTO `discipline` (`id`, `name`, `info`, `ts_insert`) VALUES (4, 'mechanical', 'Mechanical', now());
INSERT INTO `discipline` (`id`, `name`, `info`, `ts_insert`) VALUES (5, 'Interiors', 'Interiors', now());
INSERT INTO `discipline` (`id`, `name`, `info`, `ts_insert`) VALUES (6, 'landscaping', 'Landscaping', now());
INSERT INTO `discipline` (`id`, `name`, `info`, `ts_insert`) VALUES (7, 'bridges', 'Bridges', now());
INSERT INTO `discipline` (`id`, `name`, `info`, `ts_insert`) VALUES (8, 'tunnels', 'Tunnels', now());
INSERT INTO `discipline` (`id`, `name`, `info`, `ts_insert`) VALUES (9, 'design', 'Design', now());
commit;


--
-- Dumping data for table `user_safety_info`
--
START TRANSACTION;
USE `ontarget`;
INSERT INTO `user_safety_info` (`id`, `name`, `info`, `discipline_id`, `ts_create`) VALUES
  (2, '10 fingers, 10 toes 2 eyes 1 nose…safety counts', '', 1, '2014-12-02 15:41:53'),
  (3, '10 fingers. 10 toes, If you are not safe Who knows?', '', 1, '2014-12-02 15:41:53'),
  (4, 'A clean floor everyday keeps lost days away.', '', 1, '2014-12-02 15:41:53'),
  (5, 'A spill, a slip, a hospital trip', '', 1, '2014-12-02 15:41:53'),
  (6, 'A tree never hits an automobile except in self defense', '', 1, '2014-12-02 15:41:53'),
  (7, 'Accidents Big Or Small, Avoid Them All', '', 1, '2014-12-02 15:41:53'),
  (8, 'Accidents hurt, Safety doesn’t.', '', 1, '2014-12-02 15:41:53'),
  (9, 'An ounce of prevention is worth a pound of cure', '', 1, '2014-12-02 15:41:53'),
  (10, 'Are you part of the safety TEAM….(Together Employees Accomplish More)', '', 1, '2014-12-02 15:41:53'),
  (11, 'Arms work best when attached to the body', '', 1, '2014-12-02 15:41:54'),
  (12, 'At work at play, let safety lead the way.', '', 1, '2014-12-02 15:41:54'),
  (13, 'Avoid the worst. Put safety first.', '', 1, '2014-12-02 15:41:54'),
  (14, 'Be a safety hero – score an accident zero', '', 1, '2014-12-02 15:41:54'),
  (15, 'Be alert! Accidents hurt.', '', 1, '2014-12-02 15:41:54'),
  (16, 'Be aware Take care', '', 1, '2014-12-02 15:41:54'),
  (17, 'Before you do it, take time to think through it.', '', 1, '2014-12-02 15:41:54'),
  (18, 'Behind the wheel, anger is one letter away from danger.', '', 1, '2014-12-02 15:41:54'),
  (19, 'Being safe is in your own hands.', '', 1, '2014-12-02 15:41:54'),
  (20, 'Best gift you can give your family is YOU! Please be safe', '', 1, '2014-12-02 15:41:54'),
  (21, 'Break the drive and arrive alive.', '', 1, '2014-12-02 15:41:54'),
  (22, 'Chance takers are accident makers', '', 1, '2014-12-02 15:41:54'),
  (23, 'Choose safety, for your family.', '', 1, '2014-12-02 15:41:54'),
  (24, 'Click clack front and back.', '', 1, '2014-12-02 15:41:55'),
  (25, 'Click it or ticket!', '', 1, '2014-12-02 15:41:55'),
  (26, 'Computer problems you can avoid, so you don’t have to get paranoid.', '', 1, '2014-12-02 15:41:55'),
  (27, 'Courtesy and common sense promote safety.', '', 1, '2014-12-02 15:41:55'),
  (28, 'Courtesy is contagious', '', 1, '2014-12-02 15:41:55'),
  (29, 'Dare to be aware.', '', 1, '2014-12-02 15:41:55'),
  (30, 'Do you have eye for safety or are you blinded by bad habits', '', 1, '2014-12-02 15:41:55'),
  (31, 'Doesn’t matter how far. JUST BELT UP!', '', 1, '2014-12-02 15:41:55'),
  (32, 'Don’t be a fool, cause safety is cool, so make that your rule.', '', 1, '2014-12-02 15:41:55'),
  (33, 'Don’t be a fool. Use the proper tool.', '', 1, '2014-12-02 15:41:55'),
  (34, 'Don’t be hasty when it comes to safety.', '', 1, '2014-12-02 15:41:55'),
  (35, 'Don’t be safety blinded, be safety minded.', '', 1, '2014-12-02 15:41:55'),
  (36, 'Don’t learn safety by accident.', '', 1, '2014-12-02 15:41:55'),
  (37, 'Don’t leave Private information on a public computer screen', '', 1, '2014-12-02 15:41:55'),
  (38, 'Eyes are priceless, eye protection is cheap.', '', 1, '2014-12-02 15:41:55'),
  (39, 'Falling objects can be brutal if you don’t protect your noodle.', '', 1, '2014-12-02 15:41:55'),
  (40, 'Fingers toes, If you are not safe Who knows?', '', 1, '2014-12-02 15:41:55'),
  (41, 'Forget the nurse with safety first.', '', 1, '2014-12-02 15:41:55'),
  (42, 'Forgot your hearing protection? Forget about hearing!', '', 1, '2014-12-02 15:41:55'),
  (43, 'Get in high speed pursuit of safety', '', 1, '2014-12-02 15:41:56'),
  (44, 'Get smart! Use safety from the start.', '', 1, '2014-12-02 15:41:56'),
  (45, 'Give them a Brake!', '', 1, '2014-12-02 15:41:56'),
  (46, 'Got crazy with the lighter? Call a firefighter.', '', 1, '2014-12-02 15:41:56'),
  (47, 'Hard hats, they’re not just for decoration', '', 1, '2014-12-02 15:41:56'),
  (48, 'Have another day by being safe today!', '', 1, '2014-12-02 15:41:56'),
  (49, 'Hearing protection is a sound investment.', '', 1, '2014-12-02 15:41:56'),
  (50, 'Housekeeping you skip may cause a fall or slip.', '', 1, '2014-12-02 15:41:56'),
  (51, 'If everything comes your way, you are in the wrong lane.', '', 1, '2014-12-02 15:41:56'),
  (52, 'If they email you asking for cash, be sure to throw it in the trash.', '', 1, '2014-12-02 15:41:56'),
  (53, 'If they email you asking for Money, Say no thanks I won’t fall for it honey.', '', 1, '2014-12-02 15:41:56'),
  (54, 'If you don’t know the sender, it might be a pretender', '', 1, '2014-12-02 15:41:56'),
  (55, 'If you don’t think it will happen to you, find the person who had it happen to them', '', 1, '2014-12-02 15:41:56'),
  (56, 'If you mess up, ‘fess up', '', 1, '2014-12-02 15:41:56'),
  (57, 'Is better to lose one minute in life… than to lose life in a minute.', '', 1, '2014-12-02 15:41:56'),
  (58, 'It only takes one mistake to bring us all down; don’t let it be yours!', '', 1, '2014-12-02 15:41:57'),
  (59, 'It’s easier to ask a dumb question than it is to fix a dumb mistake', '', 1, '2014-12-02 15:41:57'),
  (60, 'Keep a grip on life and protect your hands', '', 1, '2014-12-02 15:41:57'),
  (61, 'Keep safety in mind. It will save your behind.', '', 1, '2014-12-02 15:41:57'),
  (62, 'Keeping your work area clean, helps keep hazards from being unseen.', '', 1, '2014-12-02 15:41:57'),
  (63, 'Knock out…accidents', '', 1, '2014-12-02 15:41:57'),
  (64, 'Know safety – no pain', '', 1, '2014-12-02 15:41:57'),
  (65, 'Know safety No Accidents', '', 1, '2014-12-02 15:41:57'),
  (66, 'Lead the way, safety today.', '', 1, '2014-12-02 15:41:57'),
  (67, 'Learn from others mistakes, don’t have others learn from you.', '', 1, '2014-12-02 15:41:57'),
  (68, 'Let’s all keep our heads, and other body parts, together', '', 1, '2014-12-02 15:41:57'),
  (69, 'Life’s short, don’t rush it', '', 1, '2014-12-02 15:41:57'),
  (70, 'Light up your tree – not your home', '', 1, '2014-12-02 15:41:57'),
  (71, 'Make it your mission, not to live in unsafe condition.', '', 1, '2014-12-02 15:41:57'),
  (72, 'Make safety a reality and don’t be a fatality', '', 1, '2014-12-02 15:41:57'),
  (73, 'My job provides my paycheck, but safety takes me home.', '', 1, '2014-12-02 15:41:57'),
  (74, 'Near miss reported today, is the accident that does not happen tomorrow.', '', 1, '2014-12-02 15:41:57'),
  (75, 'Never drive faster than your guardian angel can fly', '', 1, '2014-12-02 15:41:57'),
  (76, 'Never give safety a day off', '', 1, '2014-12-02 15:41:57'),
  (77, 'No Belt. No Brains', '', 1, '2014-12-02 15:41:57'),
  (78, 'No safety – know pain', '', 1, '2014-12-02 15:41:57'),
  (79, 'One bad day at the grinder could ruin your whole life', '', 1, '2014-12-02 15:41:57'),
  (80, 'Only You can prevent forest fires!', '', 1, '2014-12-02 15:41:57'),
  (81, 'Pencils have erasers–mishaps don’t!', '', 1, '2014-12-02 15:41:58'),
  (82, 'Prevent a jam, don’t open spam', '', 1, '2014-12-02 15:41:58'),
  (83, 'Protect your hands, you need them to pick up your pay check', '', 1, '2014-12-02 15:41:58'),
  (84, 'Quench the thirst – safety first', '', 1, '2014-12-02 15:41:58'),
  (85, 'Replacing a saw guard is easier than replacing a finger', '', 1, '2014-12-02 15:41:58'),
  (86, 'Safe crane operation is uplifting', '', 1, '2014-12-02 15:41:58'),
  (87, 'Safety – A small investment for a rich future', '', 1, '2014-12-02 15:41:58'),
  (88, 'Safety by Choice, Not by Chance.', '', 1, '2014-12-02 15:41:58'),
  (89, 'Safety comes in a can, I can, You can, We can be safe.', '', 1, '2014-12-02 15:41:58'),
  (90, 'Safety doesn’t happen by accident', '', 1, '2014-12-02 15:41:58'),
  (91, 'Safety first makes us last.', '', 1, '2014-12-02 15:41:58'),
  (92, 'Safety First, Avoid the Worst.', '', 1, '2014-12-02 15:41:58'),
  (93, 'Safety first, to last.', '', 1, '2014-12-02 15:41:58'),
  (94, 'Safety first…because accidents last.', '', 1, '2014-12-02 15:41:58'),
  (95, 'Safety fits like a glove; Try one on.', '', 1, '2014-12-02 15:41:58'),
  (96, 'Safety Glasses – All in favor say EYE', '', 1, '2014-12-02 15:41:58'),
  (97, 'Safety in – we win', '', 1, '2014-12-02 15:41:58'),
  (98, 'Safety is a cheap and effective insurance policy', '', 1, '2014-12-02 15:41:58'),
  (99, 'Safety is a continuing journey, not a final destination.', '', 1, '2014-12-02 15:41:58'),
  (100, 'Safety is a frame of mind – So concentrate on it all the time.', '', 1, '2014-12-02 15:41:59'),
  (101, 'Safety is a Frame of Mind, Get the Picture.', '', 1, '2014-12-02 15:41:59'),
  (102, 'Safety is a full time job – don’t make it a part time practice', '', 1, '2014-12-02 15:41:59'),
  (103, 'Safety is a mission not an intermission', '', 1, '2014-12-02 15:41:59'),
  (104, 'Safety is about doing the right thing, even if no one is looking.', '', 1, '2014-12-02 15:41:59'),
  (105, 'Safety is as simple as ABC – Always Be Careful', '', 1, '2014-12-02 15:41:59'),
  (106, 'Safety is like a lock – But you are the key.', '', 1, '2014-12-02 15:41:59'),
  (107, 'Safety is no accident', '', 1, '2014-12-02 15:41:59'),
  (108, 'Safety is success by purpose – Not Accident.', '', 1, '2014-12-02 15:41:59'),
  (109, 'Safety isn’t a hobby, it’s a living.', '', 1, '2014-12-02 15:41:59'),
  (110, 'Safety isn’t expensive it’s priceless.', '', 1, '2014-12-02 15:41:59'),
  (111, 'Safety isn’t just a slogan, it’s a way of life.', '', 1, '2014-12-02 15:41:59'),
  (112, 'Safety makes good dollars and sense', '', 1, '2014-12-02 15:41:59'),
  (113, 'Safety rules are there to follow. So take care and we will see you tomorrow.', '', 1, '2014-12-02 15:41:59'),
  (114, 'Safety rules are your best tools.', '', 1, '2014-12-02 15:41:59'),
  (115, 'Safety saves, Accidents cost you.', '', 1, '2014-12-02 15:41:59'),
  (116, 'Safety starts with “S” but begins with “YOU”.', '', 1, '2014-12-02 15:42:00'),
  (117, 'Safety starts with me.', '', 1, '2014-12-02 15:42:00'),
  (118, 'Safety: more fun than running with scissors', '', 1, '2014-12-02 15:42:00'),
  (119, 'Safety… It can charm you, or ALARM you!', '', 1, '2014-12-02 15:42:00'),
  (120, 'Safety…Did it, done it, doing it tomorrow', '', 1, '2014-12-02 15:42:00'),
  (121, 'Safety…one habit you never need to break', '', 1, '2014-12-02 15:42:00'),
  (122, 'Save tomorrow. Think safety today.', '', 1, '2014-12-02 15:42:00'),
  (123, 'Seat Belts are for kids – Hug them at home – Belt them in the car', '', 1, '2014-12-02 15:42:00'),
  (124, 'Seatbelts save lives. Buckle up everytime.', '', 1, '2014-12-02 15:42:00'),
  (125, 'Shortcuts cut life short', '', 1, '2014-12-02 15:42:00'),
  (126, 'Speed Thrills but Kills.', '', 1, '2014-12-02 15:42:00'),
  (127, 'Stay safe, someone at home is waiting for you.', '', 1, '2014-12-02 15:42:00'),
  (128, 'Stop drop & roll', '', 1, '2014-12-02 15:42:00'),
  (129, 'Success is no accident', '', 1, '2014-12-02 15:42:00'),
  (130, 'The best car safety device is a rear-view mirror with a cop in it.', '', 1, '2014-12-02 15:42:00'),
  (131, 'The door to Safety swings on the hinges of common sense', '', 1, '2014-12-02 15:42:00'),
  (132, 'The only trip you take should be on vacation.', '', 1, '2014-12-02 15:42:00'),
  (133, 'The safe way is the only way.', '', 1, '2014-12-02 15:42:00'),
  (134, 'The stupid shall be punished', '', 1, '2014-12-02 15:42:00'),
  (135, 'Think Safety, Because I Love You Man.', '', 1, '2014-12-02 15:42:00'),
  (136, 'Think sharp….never handle broken glass with bare hands.', '', 1, '2014-12-02 15:42:00'),
  (137, 'Think smart before you start.', '', 1, '2014-12-02 15:42:00'),
  (138, 'Those precious fingers don’t ignore, Or they could end up on the floor.', '', 1, '2014-12-02 15:42:00'),
  (139, 'Those who work the safest way- live to see another day', '', 1, '2014-12-02 15:42:01'),
  (140, 'To avoid a scene keep your work place clean.', '', 1, '2014-12-02 15:42:01'),
  (141, 'To prevent a drastic call, Install a firewall', '', 1, '2014-12-02 15:42:01'),
  (142, 'Tomorrow: Your reward for working safely today.', '', 1, '2014-12-02 15:42:01'),
  (143, 'Trying to make up time could cost you your life.', '', 1, '2014-12-02 15:42:01'),
  (144, 'Unsafe acts will keep you in stitches', '', 1, '2014-12-02 15:42:01'),
  (145, 'Watch where you walk or you might need a walker.', '', 1, '2014-12-02 15:42:01'),
  (146, 'Watch your step – it could be your last tomorrow', '', 1, '2014-12-02 15:42:01'),
  (147, 'whats holding you back?', '', 1, '2014-12-02 15:42:01'),
  (148, 'When you gamble with safety ..You bet your life.', '', 1, '2014-12-02 15:42:01'),
  (149, 'While on a ladder, never step back to admire your work', '', 1, '2014-12-02 15:42:01'),
  (150, 'Wipe Up and avoid a Slip Up!', '', 1, '2014-12-02 15:42:01'),
  (151, 'Work safe today–heaven can wait.', '', 1, '2014-12-02 15:42:01'),
  (152, 'Work together…work safely.', '', 1, '2014-12-02 15:42:01'),
  (153, 'Working safely may get old, but so do those who practice it.', '', 1, '2014-12-02 15:42:01'),
  (154, 'Your first mistake could be your last', '', 1, '2014-12-02 15:42:01'),
  (155, 'Your reward for working safely today.', '', 1, '2014-12-02 15:42:01'),
  (156, 'Your wife will spend your 401K; If you get killed at work today.', '', 1, '2014-12-02 15:42:01'),
  (157, 'Protect your hands, you need them to pick up your pay check', '', 1, '2014-12-02 15:42:01'),
  (158, 'Your wife will spend your 401K; If you get killed at work today', '', 1, '2014-12-02 15:42:01'),
  (159, 'Safety…Did it, done it, doing it tomorrow', '', 1, '2014-12-02 15:42:01'),
  (160, 'Watch your step - it could be your last tomorrow', '', 1, '2014-12-02 15:42:01'),
  (161, 'Those precious fingers don’t ignore. . . Or they could end up on the floor', '', 1, '2014-12-02 15:42:01'),
  (162, 'Your reward for working safely today.', '', 1, '2014-12-02 15:42:02'),
  (163, 'Those who work the safest way- live to see another day', '', 1, '2014-12-02 15:42:02'),
  (164, 'Get in high speed pursuit of safety', '', 1, '2014-12-02 15:42:02'),
  (165, 'Seat Belts are for kids - Hug them at home - Belt them in the car', '', 1, '2014-12-02 15:42:02'),
  (166, 'Safe crane operation is uplifting', '', 1, '2014-12-02 15:42:02'),
  (167, 'Pencils have erasers–mishaps don’t!', '', 1, '2014-12-02 15:42:02'),
  (168, 'Work safe today–heaven can wait.', '', 1, '2014-12-02 15:42:02'),
  (169, 'Safety is a mission not an intermission', '', 1, '2014-12-02 15:42:02'),
  (170, 'Safety doesn’t happen by accident', '', 1, '2014-12-02 15:42:02'),
  (171, 'A spill, a slip, a hospital trip ', '', 1, '2014-12-02 15:42:02'),
  (172, 'Falling objects can be brutal if you don’t protect your noodle', '', 1, '2014-12-02 15:42:02'),
  (173, 'Safety glasses: All in favor say “Eye!”', '', 1, '2014-12-02 15:42:02'),
  (174, 'It’s easier to ask a dumb question than it is to fix a dumb mistake', '', 1, '2014-12-02 15:42:02'),
  (175, 'Safety isn’t a hobby, it’s a living.', '', 1, '2014-12-02 15:42:02'),
  (176, 'Safety - A small investment for a rich future', '', 1, '2014-12-02 15:42:02'),
  (177, 'Safety is no accident', '', 1, '2014-12-02 15:42:02'),
  (178, 'Safety is a cheap and effective insurance policy', '', 1, '2014-12-02 15:42:02'),
  (179, 'Let’s all keep our heads, and other body parts, together', '', 1, '2014-12-02 15:42:02'),
  (180, 'While on a ladder, never step back to admire your work', '', 1, '2014-12-02 15:42:02'),
  (181, 'Quench the thirst – safety first', '', 1, '2014-12-02 15:42:02'),
  (182, 'When you gamble with safety you bet your life', '', 1, '2014-12-02 15:42:02'),
  (183, 'The stupid shall be punished', '', 1, '2014-12-02 15:42:02'),
  (184, 'Chance takers are accident makers', '', 1, '2014-12-02 15:42:02'),
  (185, 'Safety is a full time job; don’t make it a part time practice', '', 1, '2014-12-02 15:42:02'),
  (186, 'The door to Safety swings on the hinges of common sense', '', 1, '2014-12-02 15:42:02'),
  (187, 'Is better to lose one minute in life… than to lose life in a minute.', '', 1, '2014-12-02 15:42:02'),
  (188, 'Safety — a small investment for a rich future', '', 1, '2014-12-02 15:42:03'),
  (189, 'Your first mistake could be your last', '', 1, '2014-12-02 15:42:03'),
  (190, 'Safety isn’t expensive it’s priceless.', '', 1, '2014-12-02 15:42:03'),
  (191, 'Safety is as simple as ABC…Always Be Careful', '', 1, '2014-12-02 15:42:03'),
  (192, 'Unsafe acts will keep you in stitches', '', 1, '2014-12-02 15:42:03'),
  (193, 'Knock out…accidents', '', 1, '2014-12-02 15:42:03'),
  (194, 'If you mess up, ‘fess up', '', 1, '2014-12-02 15:42:03'),
  (195, 'Hard hats, they’re not just for decoration', '', 1, '2014-12-02 15:42:03'),
  (196, 'If you don’t think it will happen to you, find the person who had it happen to them', '', 1, '2014-12-02 15:42:03'),
  (197, 'Keep safety in mind. It will save your behind.', '', 1, '2014-12-02 15:42:03'),
  (198, 'One bad day at the grinder could ruin your whole life', '', 1, '2014-12-02 15:42:03'),
  (199, 'Shortcuts cut life short', '', 1, '2014-12-02 15:42:03');

COMMIT;

-- -----------------------------------------------------
-- Data for table `ontarget`.`document_template`
-- -----------------------------------------------------
START TRANSACTION;
USE `ontarget`;
insert into `document_template` (`name`, `created_by`, `created_date`, `modified_by`, `modfied_date`) values('Purchase Order', 'SYSTEM', now(), 'SYSTEM', now());
insert into `document_template` (`name`, `created_by`, `created_date`, `modified_by`, `modfied_date`) values('Change Order', 'SYSTEM', now(), 'SYSTEM', now());
insert into `document_template` (`name`, `created_by`, `created_date`, `modified_by`, `modfied_date`) values('Request For Information', 'SYSTEM', now(), 'SYSTEM', now());
insert into `document_template` (`name`, `created_by`, `created_date`, `modified_by`, `modfied_date`) values('Transmittal', 'SYSTEM', now(), 'SYSTEM', now());
COMMIT;


--
-- Table structure for table `activity_category`
--
DROP TABLE IF EXISTS `ontarget`.`activity_category` ;

CREATE TABLE IF NOT EXISTS `activity_category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `activity_category`
--

INSERT INTO `activity_category` (`id`, `name`, `description`, `ts_insert`) VALUES
  (1, 'comment add', 'adding task comment', '2014-12-05 16:44:02'),
  (2, 'project add', '', '2014-12-06 07:27:01');

-- --------------------------------------------------------

--
-- Table structure for table `activity_log`
--

DROP TABLE IF EXISTS `ontarget`.`activity_log` ;

CREATE TABLE IF NOT EXISTS `activity_log` (
  `id` bigint(20) NOT NULL,
  `text` text NOT NULL,
  `category` bigint(20) DEFAULT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `activity_log`
--

INSERT INTO `activity_log` (`id`, `text`, `category`, `ts_insert`) VALUES
  (4, 'Comment dsfsdfafsd added on task 1 by 2232332', NULL, '2014-12-05 16:40:45'),
  (5, 'Comment dadfsdasf  added on task 1 by 3434', 1, '2014-12-05 16:45:14');

--
-- Indexes for table `activity_category`
--
ALTER TABLE `activity_category`
ADD PRIMARY KEY (`id`);

--
-- Indexes for table `activity_log`
--
ALTER TABLE `activity_log`
ADD PRIMARY KEY (`id`);


--
-- Triggers `project_task_comments`
--
DELIMITER //
CREATE TRIGGER `log_comment_activity` AFTER INSERT ON `project_task_comments`
FOR EACH ROW INSERT INTO activity_log (text, category) VALUES (CONCAT("Comment ", NEW.comment , " added on task ", NEW.project_task_id, " by ", NEW.comment_by), 1)
//
DELIMITER ;

--
-- Triggers `project`
--
DELIMITER //
CREATE TRIGGER `log_project_add` AFTER INSERT ON `project`
FOR EACH ROW INSERT INTO activity_log (text, category) VALUES (CONCAT("New project ", NEW.project_id, " of type", New.project_category_id , " added by ", NEW.project_owner_id), 2)
//
DELIMITER ;