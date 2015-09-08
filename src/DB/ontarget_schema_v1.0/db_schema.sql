/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 : Database - ontarget
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ontarget` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ontarget`;

/*Table structure for table `accident_report` */

DROP TABLE IF EXISTS `accident_report`;

CREATE TABLE `accident_report` (
  `accident_report_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `submitted_to` varchar(45) DEFAULT NULL,
  `supervisor_name` varchar(45) DEFAULT NULL,
  `witness` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `brief_of_accident` varchar(45) DEFAULT NULL,
  `severity` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `body_part_affected` varchar(45) DEFAULT NULL,
  `date_of_accident` date DEFAULT NULL,
  `time_of_accident` varchar(45) DEFAULT NULL,
  `injured_visited_doctor` varchar(3) DEFAULT NULL,
  `workers_compensation_filed` varchar(3) DEFAULT NULL,
  `injured_left_job` varchar(3) DEFAULT NULL,
  `date_injured_left_job` date DEFAULT NULL,
  `time_injured_left_job` varchar(45) DEFAULT NULL,
  `possible_preventive_measures` varchar(45) DEFAULT NULL,
  `unsafe_conditions_corrected` varchar(3) DEFAULT NULL,
  `correction_measures_performed` varchar(45) DEFAULT NULL,
  `correction_measures_to_be_performed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`accident_report_id`),
  KEY `project_2_accident_report_idx` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `activity_category`;

CREATE TABLE `activity_category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `activity_category` */

/*Table structure for table `activity_log` */

DROP TABLE IF EXISTS `activity_log`;

CREATE TABLE `activity_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `text` text,
  `category` bigint(20) DEFAULT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `project_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_csf0njobhrvcaaryhn9ya8vje` (`user_id`),
  CONSTRAINT `FK_csf0njobhrvcaaryhn9ya8vje` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(150) NOT NULL,
  `address2` varchar(20) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(151) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `country` varchar(20) NOT NULL,
  `address_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf32;


DROP TABLE IF EXISTS `application_menu`;

CREATE TABLE `application_menu` (
  `application_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
  `menu_key` varchar(45) DEFAULT NULL,
  `menu_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`application_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `application_permission`;

CREATE TABLE `application_permission` (
  `application_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
  `permission_key` varchar(45) DEFAULT NULL,
  `permission_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`application_permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `audit_project_task`;

CREATE TABLE `audit_project_task` (
  `audit_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_task_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `parent_task_id` int(11) DEFAULT '0',
  `status` varchar(10) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `severity` varchar(45) DEFAULT NULL,
  `description` text,
  `audit_action` varchar(200) NOT NULL,
  `audit_datetime` datetime NOT NULL,
  `task_percentage` int(11) DEFAULT '0',
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `audit_task_percentage_log`;

CREATE TABLE `audit_task_percentage_log` (
  `task_percentage_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NOT NULL,
  `percentage_complete` double DEFAULT '0',
  `created_date` datetime DEFAULT NULL,
  `to_date` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `audit_action` varchar(30) NOT NULL,
  `audit_datetime` datetime NOT NULL,
  PRIMARY KEY (`task_percentage_log_id`),
  KEY `task_percentage_fk` (`task_id`),
  KEY `FK_bg2ao4dgbionetoo8tvp3wmn91` (`created_by`),
  KEY `FK_kv835tca9yhj3udsvda5l93bi1` (`modified_by`),
  CONSTRAINT `FK_bg2ao4dgbionetoo8tvp3wmn91` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_kv835tca9yhj3udsvda5l93bi1` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `bulk_activity_attribute`;

CREATE TABLE `bulk_activity_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_key` varchar(20) NOT NULL,
  `attribute_value` varchar(20) NOT NULL,
  `valid` varchar(2) NOT NULL,
  `bulk_activity_log_id` bigint(20) NOT NULL,
  `row_index` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_k8q918aomg0vruqg8nsy6yrkx` (`bulk_activity_log_id`),
  CONSTRAINT `FK_k8q918aomg0vruqg8nsy6yrkx` FOREIGN KEY (`bulk_activity_log_id`) REFERENCES `bulk_activity_log` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=317 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `bulk_activity_log`;

CREATE TABLE `bulk_activity_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) NOT NULL,
  `uploaded_date` datetime DEFAULT NULL,
  `uploaded_by` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bfmddopkaobsub4cvy7ggq589` (`uploaded_by`),
  CONSTRAINT `FK_bfmddopkaobsub4cvy7ggq589` FOREIGN KEY (`uploaded_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `company_info`;

CREATE TABLE `company_info` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) DEFAULT NULL,
  `company_type_id` int(11) NOT NULL,
  `address1` varchar(45) DEFAULT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `website` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`company_id`),
  KEY `comany_type_fk` (`company_type_id`),
  CONSTRAINT `comany_type_fk` FOREIGN KEY (`company_type_id`) REFERENCES `company_type` (`company_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `company_type`;

CREATE TABLE `company_type` (
  `company_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_type_name` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` varchar(20) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`company_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `contact_company_id` int(11) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `contact_method` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `contact_status` varchar(20) DEFAULT '0',
  `contact_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `contact_user_fk` (`user_id`),
  KEY `company_fk` (`contact_company_id`),
  KEY `FK_7usm4c5y9pj5v32d96w2520p0` (`created_by`),
  KEY `FK_5ub2tgt1ih6u94attrvtx8xqa` (`modified_by`),
  CONSTRAINT `company_fk` FOREIGN KEY (`contact_company_id`) REFERENCES `company_info` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `contact_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_5ub2tgt1ih6u94attrvtx8xqa` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_7usm4c5y9pj5v32d96w2520p0` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf32;


DROP TABLE IF EXISTS `countries`;

CREATE TABLE `countries` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(100) NOT NULL,
  `country_code` varchar(3) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `countries` */

/*Table structure for table `dependent_task` */

DROP TABLE IF EXISTS `dependent_task`;

CREATE TABLE `dependent_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_id` int(12) NOT NULL,
  `dependent_task_id` int(12) NOT NULL,
  `category_id` int(12) DEFAULT NULL,
  `created_by` int(12) NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_3fk9f02mk4fn01ri65rb3tukb` (`task_id`),
  CONSTRAINT `FK_3fk9f02mk4fn01ri65rb3tukb` FOREIGN KEY (`task_id`) REFERENCES `project_task` (`project_task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dependent_task` */

/*Table structure for table `discipline` */

DROP TABLE IF EXISTS `discipline`;

CREATE TABLE `discipline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `info` text NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `document`;

CREATE TABLE `document` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `document_template_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `project_id` int(11) NOT NULL,
  `due_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`document_id`),
  KEY `document_template_id_idx` (`document_template_id`),
  KEY `FK_e2prifqdip2w5ht20jfr7ak55` (`created_by`),
  KEY `FK_omqhjqvabsk4htbdwrt10rsko` (`modified_by`),
  CONSTRAINT `document_template_2_document` FOREIGN KEY (`document_template_id`) REFERENCES `document_template` (`document_template_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_e2prifqdip2w5ht20jfr7ak55` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_omqhjqvabsk4htbdwrt10rsko` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `document_attachment`;

CREATE TABLE `document_attachment` (
  `document_attachment_id` int(11) NOT NULL AUTO_INCREMENT,
  `document_id` int(11) NOT NULL,
  `file_path` varchar(255) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`document_attachment_id`),
  KEY `document_2_document_attachment_idx` (`document_id`),
  KEY `FK_f8nrugjw63u1okkk1o39b4km8` (`created_by`),
  KEY `FK_41jd0nxrbm3q9mxndbtaqita8` (`modified_by`),
  CONSTRAINT `document_2_document_attachment` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_41jd0nxrbm3q9mxndbtaqita8` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_f8nrugjw63u1okkk1o39b4km8` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `document_grid_key_value`;

CREATE TABLE `document_grid_key_value` (
  `document_id` int(11) NOT NULL,
  `grid_id` varchar(45) NOT NULL,
  `grid_row_index` int(11) NOT NULL,
  `key` varchar(45) NOT NULL,
  `value` text NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `document_grid_key_value_id` int(11) NOT NULL AUTO_INCREMENT,
  KEY `document_2_document_grid_key_value_idx` (`document_id`),
  KEY `document_grid_key_value_id` (`document_grid_key_value_id`),
  KEY `FK_pc6a4gqpl3fyheo25ius27b6i` (`created_by`),
  KEY `FK_ecusuf9xos94wja684fn5hwt9` (`modified_by`),
  CONSTRAINT `document_2_document_grid_key_value` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ecusuf9xos94wja684fn5hwt9` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_pc6a4gqpl3fyheo25ius27b6i` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `document_key_value`;

CREATE TABLE `document_key_value` (
  `document_id` int(11) NOT NULL,
  `key` varchar(45) NOT NULL,
  `value` text NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `document_key_value_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`document_key_value_id`),
  KEY `document_2_document_key_value_idx` (`document_id`),
  KEY `FK_2kxaifitibh9j770eik3cfcm5` (`created_by`),
  KEY `FK_ny0rbixwuuudfgt971gtygepm` (`modified_by`),
  CONSTRAINT `document_2_document_key_value` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_2kxaifitibh9j770eik3cfcm5` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_ny0rbixwuuudfgt971gtygepm` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `document_submittal`;

CREATE TABLE `document_submittal` (
  `document_submittal_id` int(11) NOT NULL AUTO_INCREMENT,
  `document_id` int(11) NOT NULL,
  `assignee_user_id` int(11) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`document_submittal_id`),
  KEY `document_2_document_submittal_idx` (`document_id`),
  KEY `user_2_document_submittal_idx` (`assignee_user_id`),
  KEY `FK_8b0qvm7ku3mmdwxpldcdxl2qf` (`created_by`),
  KEY `FK_fh5c4n30gbmulr5fgx79aj0dn` (`modified_by`),
  CONSTRAINT `document_2_document_submittal` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_8b0qvm7ku3mmdwxpldcdxl2qf` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_fh5c4n30gbmulr5fgx79aj0dn` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_2_document_submittal` FOREIGN KEY (`assignee_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `document_template`;

CREATE TABLE `document_template` (
  `document_template_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` int(11) NOT NULL,
  `modfied_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`document_template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `email`;

CREATE TABLE `email` (
  `email_id` int(11) NOT NULL AUTO_INCREMENT,
  `added_date` datetime DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`email_id`),
  KEY `FK_qcesbut8qtn9jih0mrh93qxj6` (`user_id`),
  CONSTRAINT `FK_qcesbut8qtn9jih0mrh93qxj6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `email_templates`;

CREATE TABLE `email_templates` (
  `email_template_id` int(11) NOT NULL AUTO_INCREMENT,
  `email_template_name` varchar(255) NOT NULL,
  `slug_name` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `body` text NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `modified_date` datetime NOT NULL,
  `modified_by` int(11) NOT NULL,
  PRIMARY KEY (`email_template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `email_templates` */

/*Table structure for table `field_worker` */

DROP TABLE IF EXISTS `field_worker`;

CREATE TABLE `field_worker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_date` datetime NOT NULL,
  `email_address` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `added_by` int(11) NOT NULL,
  `discipline_id` bigint(20) NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1wa282m6f14ur9myljkkbu8d` (`added_by`),
  KEY `FK_fnvttbj06ub9virpmy4sb5w19` (`discipline_id`),
  KEY `FK_sigh58fecyn2119ybpcwriqcg` (`modified_by`),
  CONSTRAINT `FK_1wa282m6f14ur9myljkkbu8d` FOREIGN KEY (`added_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_fnvttbj06ub9virpmy4sb5w19` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`id`),
  CONSTRAINT `FK_sigh58fecyn2119ybpcwriqcg` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `forgot_password_request`;

CREATE TABLE `forgot_password_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `forgot_password_token` varchar(64) NOT NULL,
  `status` varchar(10) NOT NULL,
  `ts_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ts_expiry` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `phone`;

CREATE TABLE `phone` (
  `phone_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_id` int(11) NOT NULL,
  `area_code` int(11) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `phone_type` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`phone_id`),
  KEY `phone_fk` (`contact_id`),
  CONSTRAINT `phone_fk` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `planned_actuals_cost`;

CREATE TABLE `planned_actuals_cost` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `task_id` int(11) NOT NULL,
  `from_date` datetime DEFAULT NULL,
  `to_date` datetime DEFAULT NULL,
  `cost_type` varchar(10) DEFAULT NULL,
  `value` decimal(10,3) DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `created_by` int(12) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` int(12) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `planned_actual_task_fk` (`task_id`),
  KEY `FK_5esfn5kr4k3cphjuhlih229gs` (`created_by`),
  KEY `FK_7dacqo4sy74ub6anhlw4bso5q` (`modified_by`),
  CONSTRAINT `FK_5esfn5kr4k3cphjuhlih229gs` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_7dacqo4sy74ub6anhlw4bso5q` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `planned_actual_task_fk` FOREIGN KEY (`task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
  `profile_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
  `added_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `profile_type` varchar(20) DEFAULT NULL,
  `added_by` int(11) DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `profile_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`profile_id`),
  KEY `FK_gghjim1ec1hbmxe4flkaemr86` (`added_by`),
  KEY `FK_p7if4v464n5pmiaxne6buammd` (`modified_by`),
  CONSTRAINT `FK_gghjim1ec1hbmxe4flkaemr86` FOREIGN KEY (`added_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_p7if4v464n5pmiaxne6buammd` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `profile_menu`;

CREATE TABLE `profile_menu` (
  `profile_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
  `application_menu_id` int(11) DEFAULT NULL,
  `profile_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`profile_menu_id`),
  KEY `FK_9vueq0wt3makrr93mewtb4b1v` (`application_menu_id`),
  KEY `FK_9l4bmcmlsobb91y7858wr1o9f` (`profile_id`),
  CONSTRAINT `FK_9l4bmcmlsobb91y7858wr1o9f` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`profile_id`),
  CONSTRAINT `FK_9vueq0wt3makrr93mewtb4b1v` FOREIGN KEY (`application_menu_id`) REFERENCES `application_menu` (`application_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;


/*Table structure for table `profile_permission` */

DROP TABLE IF EXISTS `profile_permission`;

CREATE TABLE `profile_permission` (
  `profile_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
  `application_permission_id` int(11) DEFAULT NULL,
  `profile_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`profile_permission_id`),
  KEY `FK_t9w620c3h8posdxri3hlydgs8` (`application_permission_id`),
  KEY `FK_adn7ium0mbiryk0t87k8xl4qq` (`profile_id`),
  CONSTRAINT `FK_adn7ium0mbiryk0t87k8xl4qq` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`profile_id`),
  CONSTRAINT `FK_t9w620c3h8posdxri3hlydgs8` FOREIGN KEY (`application_permission_id`) REFERENCES `application_permission` (`application_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `profile_permission` */

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_code` varchar(50) DEFAULT NULL,
  `project_name` varchar(300) DEFAULT NULL,
  `project_owner_id` int(11) DEFAULT NULL,
  `project_type_id` int(11) NOT NULL,
  `project_parent_id` int(11) NOT NULL DEFAULT '0',
  `project_assignee` varchar(45) DEFAULT NULL,
  `project_description` text,
  `project_image` varchar(255) DEFAULT NULL,
  `project_start_date` datetime DEFAULT NULL,
  `project_end_date` datetime DEFAULT NULL,
  `project_status` varchar(10) DEFAULT NULL,
  `company_id` int(11) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `project_image_path` varchar(255) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `project_type_fk` (`project_type_id`),
  KEY `project_addr_fk` (`address_id`),
  KEY `project_comp_fk` (`company_id`),
  KEY `FK_tk609r8dpanu5xbync1iocl1t` (`created_by`),
  KEY `FK_48uylhug5ey9qd8c8ncoay526` (`modified_by`),
  CONSTRAINT `FK_48uylhug5ey9qd8c8ncoay526` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_tk609r8dpanu5xbync1iocl1t` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `project_addr_fk` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_comp_fk` FOREIGN KEY (`company_id`) REFERENCES `company_info` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_type_fk` FOREIGN KEY (`project_type_id`) REFERENCES `project_type` (`project_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf32;

alter table project add project_asset_folder_name varchar(30);


/*Table structure for table `project_activities` */

DROP TABLE IF EXISTS `project_activities`;

CREATE TABLE `project_activities` (
  `project_activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_task_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `action` varchar(100) NOT NULL,
  `action_date` datetime NOT NULL,
  PRIMARY KEY (`project_activity_id`),
  KEY `proj_actvt_fk` (`project_task_id`),
  CONSTRAINT `proj_actvt_fk` FOREIGN KEY (`project_task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project_activities` */

/*Table structure for table `project_category` */

DROP TABLE IF EXISTS `project_category`;

CREATE TABLE `project_category` (
  `project_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(20) NOT NULL,
  `modified_date` datetime NOT NULL,
  `delete_flag` tinyint(4) DEFAULT NULL,
  `deleted_by` varchar(20) DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  PRIMARY KEY (`project_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project_category` */

/*Table structure for table `project_configuration` */

DROP TABLE IF EXISTS `project_configuration`;

CREATE TABLE `project_configuration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_key` varchar(30) NOT NULL,
  `config_value` varchar(30) NOT NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fserys4sc7k295w86erainwlv` (`project_id`),
  CONSTRAINT `FK_fserys4sc7k295w86erainwlv` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;


/*Table structure for table `project_file` */

DROP TABLE IF EXISTS `project_file`;

CREATE TABLE `project_file` (
  `project_file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) NOT NULL,
  `project_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `file_type` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `project_file_category_id` int(11) NOT NULL,
  PRIMARY KEY (`project_file_id`),
  KEY `project_file_fk` (`project_id`),
  KEY `FK_2v0bylp54dbusaabhxg3qbtdn` (`created_by`),
  CONSTRAINT `FK_2v0bylp54dbusaabhxg3qbtdn` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `project_file_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


/*Table structure for table `project_file_category` */

DROP TABLE IF EXISTS `project_file_category`;

CREATE TABLE `project_file_category` (
  `project_file_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` varchar(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`project_file_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `project_file_category` */


/*Table structure for table `project_file_comment` */

DROP TABLE IF EXISTS `project_file_comment`;

CREATE TABLE `project_file_comment` (
  `project_file_comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` text,
  `comment_status` varchar(15) DEFAULT NULL,
  `commented_date` datetime DEFAULT NULL,
  `commented_by` int(11) DEFAULT NULL,
  `project_file_id` int(11) NOT NULL,
  PRIMARY KEY (`project_file_comment_id`),
  KEY `FK_92xvveoohly5qsed8g9p9qu52` (`commented_by`),
  KEY `FK_2i929pjpoondffbgpom4101q0` (`project_file_id`),
  CONSTRAINT `FK_2i929pjpoondffbgpom4101q0` FOREIGN KEY (`project_file_id`) REFERENCES `project_file` (`project_file_id`),
  CONSTRAINT `FK_92xvveoohly5qsed8g9p9qu52` FOREIGN KEY (`commented_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `project_member` */

DROP TABLE IF EXISTS `project_member`;

CREATE TABLE `project_member` (
  `project_member_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `member_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`project_member_id`),
  KEY `member_project_fk` (`project_id`),
  KEY `member_user_fk` (`user_id`),
  CONSTRAINT `member_project_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `member_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Table structure for table `project_task` */

DROP TABLE IF EXISTS `project_task`;

CREATE TABLE `project_task` (
  `project_task_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `parent_task_id` int(11) DEFAULT '0',
  `status` varchar(10) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `severity` varchar(45) DEFAULT NULL,
  `description` text,
  `task_percentage` int(11) DEFAULT '0',
  PRIMARY KEY (`project_task_id`),
  KEY `project_task_fk` (`project_id`),
  KEY `FK_3d965u7t9ixv7tw0ihk3ntf8b` (`created_by`),
  KEY `FK_lswu8hb7600pskjbu9lrutpgi` (`modified_by`),
  CONSTRAINT `FK_3d965u7t9ixv7tw0ihk3ntf8b` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_lswu8hb7600pskjbu9lrutpgi` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `project_task_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf32;


/*Table structure for table `project_task_comments` */

DROP TABLE IF EXISTS `project_task_comments`;

CREATE TABLE `project_task_comments` (
  `task_comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_task_id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `comment_date` datetime NOT NULL,
  `comment_by` int(11) NOT NULL,
  `reply_to` int(11) NOT NULL,
  PRIMARY KEY (`task_comment_id`),
  KEY `task_cmnt_fk` (`project_task_id`),
  KEY `FK_iuooltn4m43txqt1kv2chidd` (`comment_by`),
  CONSTRAINT `FK_iuooltn4m43txqt1kv2chidd` FOREIGN KEY (`comment_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `task_cmnt_fk` FOREIGN KEY (`project_task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project_task_comments` */

/*Table structure for table `project_task_files` */

DROP TABLE IF EXISTS `project_task_files`;

CREATE TABLE `project_task_files` (
  `task_file_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_task_id` int(11) NOT NULL,
  `file_name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` int(12) NOT NULL,
  PRIMARY KEY (`task_file_id`),
  KEY `project_task_files_fk` (`project_task_id`),
  CONSTRAINT `project_task_files_fk` FOREIGN KEY (`project_task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


/*Table structure for table `project_type` */

DROP TABLE IF EXISTS `project_type`;

CREATE TABLE `project_type` (
  `project_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_type_name` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `modified_date` datetime NOT NULL,
  `modified_by` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`project_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `project_wall_post` */

DROP TABLE IF EXISTS `project_wall_post`;

CREATE TABLE `project_wall_post` (
  `project_wall_post_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `project_wall_post` varchar(45) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `modified_date` datetime NOT NULL,
  `modified_by` varchar(45) NOT NULL,
  PRIMARY KEY (`project_wall_post_id`),
  KEY `fk_project_id_idx` (`project_id`),
  CONSTRAINT `fk_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

/*Data for the table `project_wall_post` */

/*Table structure for table `registration_request` */

DROP TABLE IF EXISTS `registration_request`;

CREATE TABLE `registration_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `registration_token` varchar(64) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `company_name` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `msg` text,
  `status` varchar(20) DEFAULT NULL,
  `ts_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company_address1` varchar(255) DEFAULT NULL,
  `company_address2` varchar(255) DEFAULT NULL,
  `company_city` varchar(255) DEFAULT NULL,
  `company_country` varchar(255) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `company_state` varchar(255) DEFAULT NULL,
  `company_zip` varchar(255) DEFAULT NULL,
  `company_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `states` */

DROP TABLE IF EXISTS `states`;

CREATE TABLE `states` (
  `state_code` varchar(2) NOT NULL,
  `state` varchar(45) NOT NULL,
  PRIMARY KEY (`state_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `states` */

/*Table structure for table `task_assignee` */

DROP TABLE IF EXISTS `task_assignee`;

CREATE TABLE `task_assignee` (
  `task_assignee_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_task_id` int(11) NOT NULL,
  `task_assignee` int(11) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`task_assignee_id`),
  KEY `task_assignee_fk` (`project_task_id`),
  KEY `FK_g7nktpoqdfsdumeg28ylqg1ja` (`created_by`),
  KEY `FK_gkt2o02okukrnijnx1lev5f99` (`modified_by`),
  CONSTRAINT `FK_g7nktpoqdfsdumeg28ylqg1ja` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_gkt2o02okukrnijnx1lev5f99` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `task_assignee_fk` FOREIGN KEY (`project_task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf32;


/*Table structure for table `task_comment` */

DROP TABLE IF EXISTS `task_comment`;

CREATE TABLE `task_comment` (
  `task_comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NOT NULL,
  `comment` text,
  `commented_by` int(11) DEFAULT NULL,
  `commented_date` datetime DEFAULT NULL,
  `comment_status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`task_comment_id`),
  KEY `task_comment_fk` (`task_id`),
  KEY `FK_mjfxkt431suodwh1e5k9cglck` (`commented_by`),
  CONSTRAINT `FK_mjfxkt431suodwh1e5k9cglck` FOREIGN KEY (`commented_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `task_comment_fk` FOREIGN KEY (`task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;


/*Table structure for table `task_fieldworker` */

DROP TABLE IF EXISTS `task_fieldworker`;

CREATE TABLE `task_fieldworker` (
  `task_fieldworker_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `created_by` int(11) NOT NULL,
  `field_worker_id` int(11) DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `project_task_id` int(11) NOT NULL,
  PRIMARY KEY (`task_fieldworker_id`),
  KEY `FK_e7tp6v1xqgs7lxwpku1pu2qus` (`created_by`),
  KEY `FK_542dg8ja17vpuwonf7w1vdvwl` (`field_worker_id`),
  KEY `FK_6kyd6q21rodfjbsnxibjwtrro` (`modified_by`),
  KEY `FK_qjf06abb1b6iuwri5pg2q0xjw` (`project_task_id`),
  CONSTRAINT `FK_542dg8ja17vpuwonf7w1vdvwl` FOREIGN KEY (`field_worker_id`) REFERENCES `field_worker` (`id`),
  CONSTRAINT `FK_6kyd6q21rodfjbsnxibjwtrro` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_e7tp6v1xqgs7lxwpku1pu2qus` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_qjf06abb1b6iuwri5pg2q0xjw` FOREIGN KEY (`project_task_id`) REFERENCES `project_task` (`project_task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


/*Table structure for table `task_percentage_log` */

DROP TABLE IF EXISTS `task_percentage_log`;

CREATE TABLE `task_percentage_log` (
  `task_percentage_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NOT NULL,
  `percentage_type` varchar(45) DEFAULT NULL,
  `percentage_complete` double DEFAULT '0',
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`task_percentage_log_id`),
  KEY `task_percentage_fk` (`task_id`),
  KEY `FK_bg2ao4dgbionetoo8tvp3wmn9` (`created_by`),
  KEY `FK_kv835tca9yhj3udsvda5l93bi` (`modified_by`),
  CONSTRAINT `FK_bg2ao4dgbionetoo8tvp3wmn9` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_kv835tca9yhj3udsvda5l93bi` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `task_percentage_fk` FOREIGN KEY (`task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `task_priority`;

CREATE TABLE `task_priority` (
  `task_priority_id` int(11) NOT NULL AUTO_INCREMENT,
  `priority` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`task_priority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `task_status` */

DROP TABLE IF EXISTS `task_status`;

CREATE TABLE `task_status` (
  `task_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_code` varchar(15) DEFAULT NULL,
  `status_name` varchar(15) DEFAULT NULL,
  `status_description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`task_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


/*Table structure for table `time_card` */

DROP TABLE IF EXISTS `time_card`;

CREATE TABLE `time_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `time_in` datetime NOT NULL,
  `time_out` datetime NOT NULL,
  `added_by` int(11) NOT NULL,
  `field_worker_id` int(11) NOT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `project_task_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jc3c9yj4vutludvmc4g6ykmdy` (`added_by`),
  KEY `FK_mw9x22mr9hwc00tqck0k10s8i` (`field_worker_id`),
  KEY `FK_m1rs638fywmo3ut861ipf713u` (`modified_by`),
  KEY `FK_dqqdcq3661trg2mbi0t56ffym` (`project_task_id`),
  CONSTRAINT `FK_dqqdcq3661trg2mbi0t56ffym` FOREIGN KEY (`project_task_id`) REFERENCES `project_task` (`project_task_id`),
  CONSTRAINT `FK_jc3c9yj4vutludvmc4g6ykmdy` FOREIGN KEY (`added_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_m1rs638fywmo3ut861ipf713u` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_mw9x22mr9hwc00tqck0k10s8i` FOREIGN KEY (`field_worker_id`) REFERENCES `field_worker` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_type_id` int(11) DEFAULT NULL,
  `password` text NOT NULL,
  `salt` text NOT NULL,
  `user_status` varchar(1) DEFAULT '0',
  `discipline` bigint(20) NOT NULL,
  `number_of_login` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `account_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  KEY `fk_user_type_id_idx` (`user_type_id`),
  KEY `FK_tfg4ytlwtbbks3dqy6sbbjpkq` (`discipline`),
  CONSTRAINT `FK_tfg4ytlwtbbks3dqy6sbbjpkq` FOREIGN KEY (`discipline`) REFERENCES `discipline` (`id`),
  CONSTRAINT `fk_user_type_id` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`user_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf32;


/*Table structure for table `user_groups` */

DROP TABLE IF EXISTS `user_groups`;

CREATE TABLE `user_groups` (
  `user_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_group_name` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `modified_date` datetime NOT NULL,
  `modified_by` int(11) NOT NULL,
  `delete_flag` tinyint(4) NOT NULL,
  `deleted_date` datetime NOT NULL,
  `deleted_by` int(11) NOT NULL,
  PRIMARY KEY (`user_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_groups` */

/*Table structure for table `user_notification` */

DROP TABLE IF EXISTS `user_notification`;

CREATE TABLE `user_notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `last_seen_at` datetime DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `text` text,
  `ts_insert` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `notification_type` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hrv2lmyjlt3ken6hk2f4sg1e` (`user_id`),
  CONSTRAINT `FK_hrv2lmyjlt3ken6hk2f4sg1e` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=latin1;

ALTER TABLE `ontarget`.`user_notification`
ADD COLUMN `project_id` BIGINT(20) NULL AFTER `notification_type`;

/*Table structure for table `user_notification_attribute` */

DROP TABLE IF EXISTS `user_notification_attribute`;

CREATE TABLE `user_notification_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_key` varchar(20) NOT NULL,
  `attribute_value` varchar(20) NOT NULL,
  `user_notification_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3a2j0bxaiwccw4elllxy2syxm` (`user_notification_id`),
  CONSTRAINT `FK_3a2j0bxaiwccw4elllxy2syxm` FOREIGN KEY (`user_notification_id`) REFERENCES `user_notification` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=811 DEFAULT CHARSET=latin1;


/*Table structure for table `user_profile` */

DROP TABLE IF EXISTS `user_profile`;

CREATE TABLE `user_profile` (
  `user_profile_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_profile_id` int(11) DEFAULT NULL,
  `permission_profile_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_profile_id`),
  KEY `FK_kll87k4jctw8alm5v0plm6jnd` (`menu_profile_id`),
  KEY `FK_m733lnvim3aee2ek5c373xst1` (`permission_profile_id`),
  KEY `FK_ebc21hy5j7scdvcjt0jy6xxrv` (`user_id`),
  CONSTRAINT `FK_ebc21hy5j7scdvcjt0jy6xxrv` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_kll87k4jctw8alm5v0plm6jnd` FOREIGN KEY (`menu_profile_id`) REFERENCES `profile` (`profile_id`),
  CONSTRAINT `FK_m733lnvim3aee2ek5c373xst1` FOREIGN KEY (`permission_profile_id`) REFERENCES `profile` (`profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `user_safety_info` */

DROP TABLE IF EXISTS `user_safety_info`;

CREATE TABLE `user_safety_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(524) NOT NULL,
  `info` text NOT NULL,
  `discipline_id` bigint(20) NOT NULL,
  `ts_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=latin1;


/*Table structure for table `user_session_info` */

DROP TABLE IF EXISTS `user_session_info`;

CREATE TABLE `user_session_info` (
  `user_session_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `login_token` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `expire_date` datetime DEFAULT NULL,
  `is_expired` varchar(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_session_info_id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=latin1;


/*Table structure for table `user_type` */

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `user_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` varchar(100) NOT NULL,
  `user_type_desc` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `modified_date` datetime NOT NULL,
  `modified_by` varchar(20) NOT NULL,
  `is_expired` varchar(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


/* Trigger structure for table `dependent_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_dependentTask_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_dependentTask_add` AFTER INSERT ON `dependent_task` FOR EACH ROW BEGIN


	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("Task ",`getProjectTaskTitleById`(NEW.dependent_task_id)," is made dependent on task",
	`getProjectTaskTitleById`(NEW.task_id)),
	NEW.created_by,11, NOW());


END */$$


DELIMITER ;

/* Trigger structure for table `planned_actuals_cost` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_plannedActualCost_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_plannedActualCost_add` AFTER INSERT ON `planned_actuals_cost` FOR EACH ROW BEGIN

	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("New planned cost added for task ",`getProjectTaskTitleById`(NEW.task_id)),
	New.created_by,6, NOW());

END */$$


DELIMITER ;

/* Trigger structure for table `planned_actuals_cost` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_plannedActualCost_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_plannedActualCost_update` AFTER UPDATE ON `planned_actuals_cost` FOR EACH ROW BEGIN



	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("Planned cost updated for task ",`getProjectTaskTitleById`(NEW.task_id)),
	NEW.modified_by,7, NOW());

END */$$


DELIMITER ;

/* Trigger structure for table `project` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `project_AFTER_INSERT` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `project_AFTER_INSERT` AFTER INSERT ON `project` FOR EACH ROW BEGIN

	DECLARE projectType VARCHAR(20);
	DECLARE userNotificationId BIGINT;
	DECLARE projectTypeText VARCHAR(100);

	SELECT TYPE INTO projectType FROM  project WHERE project_id= NEW.project_id;

	if projectType != 'MAIN_PROJECT' THEN

		if projectType = 'PROJECT'   THEN
			SET  projectTypeText = 'New Project';
		ELSE
			SET projectTypeText = 'New Activity';
		END IF;

		INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
		(CONCAT(projectTypeText, ' ',NEW.project_name, " added by ", get_userNameById(NEW.project_owner_id)),
		NEW.project_owner_id,2, NOW(),NEW.project_id);

		INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert,notification_type)
		VALUES (CONCAT(projectTypeText,' ', NEW.project_name, " added by ", get_userNameById(NEW.project_owner_id)),
		"NEW",NEW.project_owner_id, NOW(),projectType);

		set userNotificationId = LAST_INSERT_ID();

		IF projectType = 'ACTIVITY'   THEN

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationType','activityId',userNotificationId);

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationId',NEW.project_id,userNotificationId);

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationType','projectId',userNotificationId);

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationId',getProjectParentIdById(NEW.project_id),userNotificationId);

		ELSEIF projectType = 'PROJECT' THEN

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationType','projectId',userNotificationId);

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationId',NEW.project_id,userNotificationId);

		END IF;

	END IF;
END */$$


DELIMITER ;

/* Trigger structure for table `project` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `project_AFTER_UPDATE` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `project_AFTER_UPDATE` AFTER UPDATE ON `project` FOR EACH ROW BEGIN


	DECLARE projectType VARCHAR(20);
	DECLARE userNotificationId BIGINT;
	DECLARE projectTypeText VARCHAR(100);

	SELECT TYPE INTO projectType FROM project WHERE project_id= OLD.project_id;

	IF projectType != 'MAIN_PROJECT' THEN

		IF projectType = 'PROJECT'   THEN
			SET  projectTypeText = 'Project';
		ELSE
			SET projectTypeText = 'Activity';
		END IF;

		INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
		(CONCAT(projectTypeText, ' ',NEW.project_name, " updated by ", get_userNameById(NEW.modified_by)),
		NEW.modified_by,2, NOW(),OLD.project_id);

		INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert,notification_type)
		VALUES (CONCAT(projectTypeText,' ',NEW.project_name, "  updated by ", get_userNameById(NEW.modified_by)),
		"NEW",NEW.modified_by, NOW(),projectType);

		SET userNotificationId = LAST_INSERT_ID();

				IF projectType = 'ACTIVITY'   THEN

					INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
					VALUES('notificationType','activityId',userNotificationId);

					INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
					VALUES('notificationId',OLD.project_id,userNotificationId);

					INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
					VALUES('notificationType','projectId',userNotificationId);

					INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
					VALUES('notificationId',getProjectParentIdById(OLD.project_id),userNotificationId);

				ELSEIF projectType = 'PROJECT' THEN

					INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
					VALUES('notificationType','projectId',userNotificationId);

					INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
					VALUES('notificationId',OLD.project_id,userNotificationId);

				END IF;

	END IF;

  END */$$


DELIMITER ;

/* Trigger structure for table `project_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_task_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `log_task_add` AFTER INSERT ON `project_task` FOR EACH ROW BEGIN

	DECLARE userNotificationId BIGINT;

	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("New task ", NEW.title, " added by ", get_userNameById(NEW.created_by),project_id),
	New.created_by,4, NOW(),NEW.project_id);

	INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert,notification_type)
	VALUES (CONCAT("New task ", NEW.title, " added by ", get_userNameById(NEW.created_by)),
	"NEW",NEW.created_by, NOW(),"TASK");

	SET userNotificationId = LAST_INSERT_ID();

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','taskId',userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.project_task_id,userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','activityId',userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.project_id,userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','projectId',userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',getProjectParentIdById(NEW.project_id),userNotificationId);

END */$$


DELIMITER ;

/* Trigger structure for table `project_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `before_project_task` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `before_project_task` BEFORE UPDATE ON `project_task` FOR EACH ROW BEGIN

	INSERT INTO audit_project_task
        	SET audit_action='UPDATE',
            audit_datetime=NOW(),
            project_task_id=OLD.project_task_id,
            project_id = OLD.project_id,
            title = OLD.title,
            parent_task_id = OLD.parent_task_id,
            status = OLD.status,
            start_date = OLD.start_date,
            end_date = OLD.end_date,
            created_date = OLD.created_date,
            created_by = OLD.created_by,
            modified_date = OLD.modified_date,
            modified_by = OLD.modified_by,
            severity = OLD.severity,
            description = OLD.description,
            task_percentage = OLD.task_percentage;
      END */$$


DELIMITER ;

/* Trigger structure for table `project_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `after_project_task` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `after_project_task` AFTER UPDATE ON `project_task` FOR EACH ROW BEGIN

	DECLARE userNotificationId BIGINT;
	DECLARE updatedTaskPercentage INT;
	DECLARE insertId INT;


		SET updatedTaskPercentage = (SELECT task_percentage FROM  project_task WHERE project_task_id= NEW.project_task_id);


		 IF OLD.task_percentage != updatedTaskPercentage THEN

			INSERT INTO audit_task_percentage_log
				SET audit_action='UPDATE',
				audit_datetime=NOW(),
				task_id=OLD.project_task_id,
				to_date = STR_TO_DATE('31/12/9999', '%d/%m/%Y'),
				created_date = NOW(),
				created_by = OLD.created_by,
				percentage_complete = updatedTaskPercentage;

			SET insertId = (SELECT task_percentage_log_id FROM audit_task_percentage_log ORDER BY 1 DESC LIMIT 1);

			UPDATE audit_task_percentage_log set to_date=now()  WHERE task_percentage_log_id != insertId and DATE_FORMAT(created_date,'%Y-%m') =DATE_FORMAT(NOW(),'%Y-%m') ;

		ELSE

			INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
			(CONCAT("Task ", NEW.title, " updated by ", get_userNameById(NEW.modified_by)),
			NEW.modified_by,5, NOW());

			INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert,notification_type)
			VALUES (CONCAT("Task ",NEW.title, " updated by ", get_userNameById(NEW.modified_by)),
			"NEW",NEW.modified_by, NOW(),"TASK");

			SET userNotificationId = LAST_INSERT_ID();

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationType','taskId',userNotificationId);

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationId',NEW.project_task_id,userNotificationId);

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationType','activityId',userNotificationId);

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationId',NEW.project_id,userNotificationId);

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationType','projectId',userNotificationId);

			INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
			VALUES('notificationId',getProjectParentIdById(NEW.project_id),userNotificationId);

	 END IF ;
END */$$


DELIMITER ;

/* Trigger structure for table `project_task_files` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_projectTaskFile_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_projectTaskFile_add` AFTER INSERT ON `project_task_files` FOR EACH ROW BEGIN

	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("New file ",NEW.file_name," uploaded for task ",`getProjectTaskTitleById`(NEW.project_task_id)),
	NEW.created_by,10, NOW());


END */$$


DELIMITER ;

/* Trigger structure for table `task_comment` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_comment_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `log_comment_add` AFTER INSERT ON `task_comment` FOR EACH ROW BEGIN

	DECLARE userNotificationId BIGINT;
	declare activityId BIGINT;

	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("Comment ", NEW.comment, " added on task ", `getProjectTaskTitleById`(NEW.task_id)),
	NEW.commented_by,1, NOW());

	INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert,notification_type)
	VALUES (CONCAT("Comment ", NEW.comment, " added on task ", getProjectTaskTitleById(NEW.task_id)),
	"NEW",NEW.commented_by, NOW(),"COMMENT");

	SET userNotificationId = LAST_INSERT_ID();

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','commentId',userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.task_comment_id,userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','taskId',userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.task_id,userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','activityId',userNotificationId);

	SET activityId = getActivityIdByTaskId(NEW.task_id);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',activityId,userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','projectId',userNotificationId);

	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',getProjectParentIdById(activityId),userNotificationId);

END */$$


DELIMITER ;

/* Function  structure for function  `getActivityIdByTaskId` */

/*!50003 DROP FUNCTION IF EXISTS `getActivityIdByTaskId` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`ontarget`@`localhost` FUNCTION `getActivityIdByTaskId`(taskId INT) RETURNS varchar(100) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE activityId BIGINT;
  SET activityId = (SELECT project_id FROM  project_task WHERE project_task_id= taskId);
  RETURN activityId;
END */$$
DELIMITER ;

/* Function  structure for function  `getActivityNameById` */

/*!50003 DROP FUNCTION IF EXISTS `getActivityNameById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`ontarget`@`localhost` FUNCTION `getActivityNameById`(projectId INT) RETURNS varchar(100) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE activityName VARCHAR(100);
  SET activityName = (SELECT project_name FROM project WHERE project_id = projectId);
  RETURN activityName;
END */$$
DELIMITER ;

/* Function  structure for function  `getProjectParentIdById` */

/*!50003 DROP FUNCTION IF EXISTS `getProjectParentIdById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`ontarget`@`localhost` FUNCTION `getProjectParentIdById`(projectId INT) RETURNS varchar(100) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE projectParentId BIGINT;
  SET projectParentId = (SELECT project_parent_id FROM  project WHERE project_id= projectId);
  RETURN projectParentId;
END */$$
DELIMITER ;

/* Function  structure for function  `getProjectTaskTitleById` */

/*!50003 DROP FUNCTION IF EXISTS `getProjectTaskTitleById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`ontarget`@`localhost` FUNCTION `getProjectTaskTitleById`(projectTaskId INT) RETURNS varchar(100) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE projectTaskTitle VARCHAR(100);
  SET projectTaskTitle = (SELECT title FROM project_task WHERE project_task_id = projectTaskId);
  RETURN projectTaskTitle;
END */$$
DELIMITER ;

/* Function  structure for function  `getProjectTitleById` */

/*!50003 DROP FUNCTION IF EXISTS `getProjectTitleById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`ontarget`@`localhost` FUNCTION `getProjectTitleById`(projectId INT) RETURNS varchar(100) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE projectTitle VARCHAR(100);
  SET projectTitle = (SELECT project_name FROM project WHERE project_id = projectId);
  RETURN projectTitle;
END */$$
DELIMITER ;

/* Function  structure for function  `get_userNameById` */

/*!50003 DROP FUNCTION IF EXISTS `get_userNameById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`ontarget`@`localhost` FUNCTION `get_userNameById`(userId INT) RETURNS varchar(100) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE userName VARCHAR(100);
  SET userName = (SELECT CONCAT(first_name,' ',last_name) FROM ontarget.`contact` WHERE user_id = userId);
  RETURN userName;
END */$$
DELIMITER ;

/* Procedure structure for procedure `sample_sp_no_param` */

/*!50003 DROP PROCEDURE IF EXISTS  `sample_sp_no_param` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sample_sp_no_param`()
BEGIN
    UPDATE emp SET `first name`= 'ChangedHJK' where id = 1;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sample_sp_with_params` */

/*!50003 DROP PROCEDURE IF EXISTS  `sample_sp_with_params` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sample_sp_with_params`(IN empId INT UNSIGNED, OUT oldName VARCHAR(20), INOUT newName VARCHAR(20))
BEGIN
    SELECT `first name` into oldName FROM emp where id = empId;
    UPDATE emp SET `first name`= newName where id = empId;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;