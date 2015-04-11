/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.41-0ubuntu0.14.04.1 : Database - ontarget
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `accident_report` */

insert  into `accident_report`(`accident_report_id`,`project_id`,`submitted_to`,`supervisor_name`,`witness`,`location`,`brief_of_accident`,`severity`,`description`,`body_part_affected`,`date_of_accident`,`time_of_accident`,`injured_visited_doctor`,`workers_compensation_filed`,`injured_left_job`,`date_injured_left_job`,`time_injured_left_job`,`possible_preventive_measures`,`unsafe_conditions_corrected`,`correction_measures_performed`,`correction_measures_to_be_performed`) values (1,1,'Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','2015-03-13','12345','YES','YES','YES','2015-03-13','Test Value','Test Value','YES','Test Value','Test Value'),(2,1,'1177202090','1177202090','1177202090','np','brief','High','desc','desc','2015-03-13','2015-03-28T18:15:00.000Z','NO','NO','NO',NULL,NULL,'hey','YES','hey hey',NULL),(3,1,'Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Test ','2015-03-13','2015-03-13','T','Te','T','2015-03-13','T','Test','Y','Y','Y'),(4,1,'Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Y','2015-03-10','12345','Y','Y','Y','2015-03-10','Te','Tes','Y','Y','Tes'),(5,1,'1177202090','1177202090','1177202090','NP','test','High','test','test','2015-03-30','2015-03-30T18:15:00.000Z','NO','NO','NO',NULL,NULL,'test','NO',NULL,'test');

/*Table structure for table `activity_category` */

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
  `user_id` int(12) NOT NULL,
  `project_id` int(11) NOT NULL,
  `category` bigint(20) DEFAULT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=199 DEFAULT CHARSET=latin1;

/*Data for the table `activity_log` */

insert  into `activity_log`(`id`,`text`,`user_id`,`category`,`ts_insert`) values (165,NULL,0,2,'2015-03-14 13:37:54'),(166,'project 7 updated by 1',0,3,'2015-03-14 13:38:28'),(167,'project 7 updated by 1',0,3,'2015-03-14 13:38:41'),(168,'New task task1 of id 1 added by 1',0,4,'2015-03-14 13:53:02'),(169,'New task hola of id 2 added by 1',0,4,'2015-03-14 15:02:17'),(170,'New task hop of id 3 added by 1',0,4,'2015-03-14 15:08:00'),(171,'New task hello hello of id 4 added by 1',0,4,'2015-03-14 15:10:17'),(172,'New task hoho of id 5 added by 1',0,4,'2015-03-14 15:21:32'),(173,'New task heh of id 6 added by 1',0,4,'2015-03-14 15:41:02'),(174,'New task hey of id 7 added by 1',0,4,'2015-03-14 15:44:12'),(175,'New task tuts of id 8 added by 1',0,4,'2015-03-14 15:44:35'),(176,'New task haha of id 9 added by 1',0,4,'2015-03-14 15:45:28'),(177,'New task haha of id 10 added by 1',0,4,'2015-03-14 15:46:41'),(178,'New task hono of id 11 added by 1',0,4,'2015-03-14 15:48:55'),(179,'New task haha of id 12 added by 1',0,4,'2015-03-14 15:53:48'),(180,'New file IMG_5312.JPG uploaded for task 10 by user 1',0,10,'2015-03-14 15:56:30'),(181,'New file file.pdf uploaded for task 10 by user 1',0,10,'2015-03-14 16:09:02'),(182,'New planned cost added for task 10 by user 1',0,6,'2015-03-14 17:23:50'),(183,'New planned cost added for task 10 by user 1',0,6,'2015-03-14 17:23:50'),(184,'New planned cost added for task 10 by user 1',0,6,'2015-03-14 17:27:10'),(185,'New planned cost added for task 10 by user 1',0,6,'2015-03-14 17:27:10'),(186,'New assignee 1177202090 added for task 11',0,9,'2015-03-15 10:29:35'),(187,'New assignee 1177202090 added for task 10',0,9,'2015-03-15 10:30:23'),(188,'Task 1 is made dependent on task 1 by user 1',0,11,'2015-03-18 22:44:44'),(189,'New task task1 of id 13 added by 1',0,4,'2015-03-18 22:44:48'),(190,'New task task1 of id 14 added by 1',0,4,'2015-03-18 22:45:17'),(191,'New task task1 of id 15 added by 1',0,4,'2015-03-18 22:47:06'),(192,'New task task1 of id 16 added by 1',0,4,'2015-03-18 22:51:37'),(193,'New task task1 of id 17 added by 1',0,4,'2015-03-18 22:56:51'),(194,'New task task1 of id 18 added by 1',0,4,'2015-03-18 22:59:17'),(195,NULL,0,2,'2015-03-25 22:22:53'),(196,'task task1 of id 17 updated by 1',0,5,'2015-03-28 10:36:16'),(197,'task task1 of id 17 updated by 1',0,5,'2015-03-28 10:36:47'),(198,'New planned cost added for task 10 by user 1',0,6,'2015-03-28 19:40:03');

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(150) NOT NULL,
  `address2` varchar(20) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(5) NOT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `country` varchar(20) NOT NULL,
  `address_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf32;

/*Data for the table `address` */

insert  into `address`(`address_id`,`address1`,`address2`,`city`,`state`,`zip`,`country`,`address_type`) values (1,'4750 59TH ST','#9C','WOODSIDE','NY','11377','USA','HOME'),(2,'393 West End Ave',NULL,'New York','NY','10024','USA','PROJECT'),(3,'address1','address2','city','state','zip','country','PROJECT'),(4,'address1','address2','city','state','zip','country','PROJECT'),(5,'393 West End Ave','km','km','km','00977','km','PROJECT'),(6,'393 West End Ave','KM','KM','KM','00977','KM','PROJECT'),(7,'393 West End Ave','km','km','km','00977','km','PROJECT'),(8,'393 West End Ave','km','km','km','00977','km','PROJECT'),(9,'address1','address2','city','state','zip','country','PROJECT'),(10,'address1','address2','city','state','zip','country','PROJECT'),(11,'address1','address2','city','state','zip','country','PROJECT'),(12,'address1','address2','city','state','zip','country','PROJECT'),(13,'address1','address2','city','state','zip','country','PROJECT'),(14,'address1','address2','city','state','zip','country','PROJECT'),(15,'address1','address2','city','state','zip','country','PROJECT'),(16,'address1','address2','city','state','zip','country','PROJECT'),(17,'address1','address2','city','state','zip','country','PROJECT'),(18,'address1','address2','city','state','zip','country','PROJECT');

/*Table structure for table `company_info` */

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `company_info` */

insert  into `company_info`(`company_id`,`company_name`,`company_type_id`,`address1`,`address2`,`city`,`state`,`zipcode`,`country`,`status`,`website`) values (1,'SIMON AND BARRON WEA RESIDENTIAL',1,'363 23rd st','Suite 2098','New York','NY','10001','USA','ACTIVE','http://www.ttg.com'),(2,'BBVA',1,'2000 Windsor Ct','APT 3','Plover','WI','54467','USA','ACTIVE',NULL),(17,'the bsn',1,'KM','KM','KM','KM','00977','KM','ACTIVE',NULL);

/*Table structure for table `company_type` */

DROP TABLE IF EXISTS `company_type`;

CREATE TABLE `company_type` (
  `company_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_type_name` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` varchar(20) DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `deleted_by` varchar(20) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  `delete_flag` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`company_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `company_type` */

insert  into `company_type`(`company_type_id`,`company_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`deleted_date`,`deleted_by`,`status`,`delete_flag`) values (1,'GENERAL CONTRACTOR',NULL,'SYSTEM','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00',NULL,'ACTIVE',NULL),(2,'CONSTRUCTION MANAGER',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,'ACTIVE',NULL),(3,'SUB CONTRACTOR',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,'ACTIVE',NULL),(4,'OWNER',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,'ACTIVE',NULL),(5,'SPECIALITY CONTRACTOR',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,'ACTIVE',NULL),(6,'ARCHITECT/ENGINEERS',NULL,'SYSTEM',NULL,'SYSTE',NULL,NULL,'ACTIVE',NULL);

/*Table structure for table `contact` */

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
  `created_by` varchar(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` varchar(45) DEFAULT NULL,
  `contact_status` varchar(20) DEFAULT '0',
  `contact_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `contact_user_fk` (`user_id`),
  KEY `company_fk` (`contact_company_id`),
  CONSTRAINT `company_fk` FOREIGN KEY (`contact_company_id`) REFERENCES `company_info` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `contact_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf32;

/*Data for the table `contact` */

insert  into `contact`(`contact_id`,`user_id`,`contact_company_id`,`title`,`first_name`,`last_name`,`address_id`,`date_of_birth`,`contact_method`,`created_date`,`created_by`,`modified_date`,`modified_by`,`contact_status`,`contact_image`) values (1,1,1,'CIO','Sanjeev','Ghimire',1,'1984-01-30','PHONE','2015-03-12 13:39:27','1','2015-02-10 12:59:52','1','ACTIVE','assets/profile/bsn.jpg'),(6,1177202090,17,'CIA','basant','rijal',NULL,NULL,NULL,'2015-03-12 16:37:37','0','2015-03-12 16:37:37','0','ACTIVE','');

/*Table structure for table `countries` */

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `dependent_task` */

insert  into `dependent_task`(`id`,`task_id`,`dependent_task_id`,`category_id`,`created_by`,`ts_insert`) values (1,1,1,1,1,'2015-03-18 22:44:44');

/*Table structure for table `discipline` */

DROP TABLE IF EXISTS `discipline`;

CREATE TABLE `discipline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `info` text NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `discipline` */

insert  into `discipline`(`id`,`name`,`info`,`ts_insert`) values (1,'masonry','Masonry','2015-01-10 01:04:58'),(2,'plumbing','Plumbing','2015-01-10 01:04:58'),(3,'electrical','Electrical','2015-01-10 01:04:58'),(4,'mechanical','Mechanical','2015-01-10 01:04:58'),(5,'Interiors','Interiors','2015-01-10 01:04:58'),(6,'landscaping','Landscaping','2015-01-10 01:04:58'),(7,'bridges','Bridges','2015-01-10 01:04:58'),(8,'tunnels','Tunnels','2015-01-10 01:04:58'),(9,'design','Design','2015-01-10 01:04:58');

/*Table structure for table `document` */

DROP TABLE IF EXISTS `document`;

CREATE TABLE `document` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `document_template_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `project_id` int(11) NOT NULL,
  `due_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`document_id`),
  KEY `document_template_id_idx` (`document_template_id`),
  CONSTRAINT `document_template_2_document` FOREIGN KEY (`document_template_id`) REFERENCES `document_template` (`document_template_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `document` */

insert  into `document`(`document_id`,`document_template_id`,`name`,`status`,`created_by`,`created_date`,`modified_by`,`modified_date`,`project_id`,`due_date`) values (4,21,'CO Document','SUBMITTED','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',1,'2015-03-13 00:00:00'),(5,20,'test doc','SUBMITTED','1','2015-03-27 16:49:05','1','2015-03-27 16:49:05',0,'2015-03-10 00:00:00'),(13,20,'test doc','SUBMITTED','1','2015-03-27 17:59:38','1','2015-03-28 19:29:35',0,'2015-03-10 00:00:00');

/*Table structure for table `document_attachment` */

DROP TABLE IF EXISTS `document_attachment`;

CREATE TABLE `document_attachment` (
  `document_attachment_id` int(11) NOT NULL AUTO_INCREMENT,
  `document_id` int(11) NOT NULL,
  `file_path` varchar(255) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`document_attachment_id`),
  KEY `document_2_document_attachment_idx` (`document_id`),
  CONSTRAINT `document_2_document_attachment` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `document_attachment` */

insert  into `document_attachment`(`document_attachment_id`,`document_id`,`file_path`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,13,'/home/ontargetrs/sa.jpg','1','2015-03-28 19:28:11','1','2015-03-28 19:28:11');

/*Table structure for table `document_grid_key_value` */

DROP TABLE IF EXISTS `document_grid_key_value`;

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
  `document_grid_key_value_id` int(11) NOT NULL AUTO_INCREMENT,
  KEY `document_2_document_grid_key_value_idx` (`document_id`),
  KEY `document_grid_key_value_id` (`document_grid_key_value_id`),
  CONSTRAINT `document_2_document_grid_key_value` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `document_grid_key_value` */

insert  into `document_grid_key_value`(`document_id`,`grid_id`,`grid_row_index`,`key`,`value`,`created_by`,`created_date`,`modified_by`,`modified_date`,`document_grid_key_value_id`) values (13,'C000',1,'gridkey1','gridkeyvalue','1','2015-03-27 17:59:38','1','2015-03-27 17:59:38',1);

/*Table structure for table `document_key_value` */

DROP TABLE IF EXISTS `document_key_value`;

CREATE TABLE `document_key_value` (
  `document_id` int(11) NOT NULL,
  `key` varchar(45) NOT NULL,
  `value` text NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `document_key_value_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`document_key_value_id`),
  KEY `document_2_document_key_value_idx` (`document_id`),
  CONSTRAINT `document_2_document_key_value` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `document_key_value` */

insert  into `document_key_value`(`document_id`,`key`,`value`,`created_by`,`created_date`,`modified_by`,`modified_date`,`document_key_value_id`) values (4,'username','1177202090','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',1),(4,'company_name','1','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',2),(4,'change_order','CP-201','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',3),(4,'location','np','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',4),(4,'subject','np','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',5),(4,'description_of_scope','np','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',6),(4,'contract_no','99','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',7),(4,'contract_title','99','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',8),(4,'date_created','2015-03-13T18:15:00.000Z','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',9),(4,'priority','High','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',10),(4,'discipline','MECHANICAL','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',11),(4,'category','ERRORS','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',12),(4,'schedule_impact','YES','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',13),(4,'cost_impact','YES','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',14),(4,'time_impact','9','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',15),(4,'specification','99','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',16),(4,'drawing_no','99','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',17),(4,'cost_code','99','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',18),(4,'total_change_order_amount','99','1','2015-03-14 12:53:37','1','2015-03-14 12:53:37',19),(13,'name','Santosh Pun','1','2015-03-27 17:59:38','1','2015-03-27 17:59:38',25);

/*Table structure for table `document_submittal` */

DROP TABLE IF EXISTS `document_submittal`;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `document_submittal` */

insert  into `document_submittal`(`document_submittal_id`,`document_id`,`assignee_user_id`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (4,4,1177202090,'1','2015-03-14 12:53:37','1','2015-03-14 12:53:37');

/*Table structure for table `document_template` */

DROP TABLE IF EXISTS `document_template`;

CREATE TABLE `document_template` (
  `document_template_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(45) NOT NULL,
  `modfied_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`document_template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `document_template` */

insert  into `document_template`(`document_template_id`,`name`,`created_by`,`created_date`,`modified_by`,`modfied_date`) values (20,'Purchase Order','SYSTEM','2015-01-10 01:04:58','SYSTEM','2015-01-10 01:04:58'),(21,'Change Order','SYSTEM','2015-01-10 01:04:58','SYSTEM','2015-01-10 01:04:58'),(22,'Request For Information','SYSTEM','2015-01-10 01:04:58','SYSTEM','2015-01-10 01:04:58'),(23,'Transmittal','SYSTEM','2015-01-10 01:04:58','SYSTEM','2015-01-10 01:04:58');

/*Table structure for table `email` */

DROP TABLE IF EXISTS `email`;

CREATE TABLE `email` (
  `email_id` int(11) NOT NULL,
  `contact_id` int(11) NOT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  `email_type` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`email_id`),
  KEY `email_fk` (`contact_id`),
  CONSTRAINT `email_fk` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `email` */

/*Table structure for table `email_templates` */

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

/*Table structure for table `forgot_password_request` */

DROP TABLE IF EXISTS `forgot_password_request`;

CREATE TABLE `forgot_password_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `forgot_password_token` varchar(64) NOT NULL,
  `status` varchar(10) NOT NULL,
  `ts_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ts_expiry` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `forgot_password_request` */

/*Table structure for table `phone` */

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `phone` */

insert  into `phone`(`phone_id`,`contact_id`,`area_code`,`phone_number`,`phone_type`,`status`) values (4,6,0,NULL,'CELL','ACTIVE');

/*Table structure for table `planned_actuals_cost` */

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
  CONSTRAINT `planned_actual_task_fk` FOREIGN KEY (`task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `planned_actuals_cost` */

insert  into `planned_actuals_cost`(`id`,`task_id`,`from_date`,`to_date`,`cost_type`,`value`,`expiry_date`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (3,10,'2015-03-14 00:00:00','2015-03-29 00:00:00','ACTUAL','10.000','9999-12-31 00:00:00',1,'2015-03-14 17:27:10',1,'2015-03-14 17:27:10'),(4,10,'2015-03-14 00:00:00','2015-03-29 00:00:00','PLANNED','10.000','9999-12-31 00:00:00',1,'2015-03-14 17:27:10',1,'2015-03-14 17:27:10'),(6,10,'2015-04-10 00:00:00','2015-04-10 00:00:00','P','100.000','9999-12-31 00:00:00',1,'2015-03-28 19:40:03',1,'2015-03-28 19:40:03');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_code` varchar(50) DEFAULT NULL,
  `project_name` varchar(300) DEFAULT NULL,
  `project_owner_id` int(11) DEFAULT NULL,
  `project_category_id` int(11) DEFAULT NULL,
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
  `created_by` varchar(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` varchar(20) DEFAULT NULL,
  `delete_flag` tinyint(4) DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `deleted_by` varchar(20) DEFAULT NULL,
  `project_image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `project_categ_fk` (`project_category_id`),
  KEY `project_type_fk` (`project_type_id`),
  KEY `project_addr_fk` (`address_id`),
  KEY `project_comp_fk` (`company_id`),
  CONSTRAINT `project_addr_fk` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_categ_fk` FOREIGN KEY (`project_category_id`) REFERENCES `project_category` (`project_category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_comp_fk` FOREIGN KEY (`company_id`) REFERENCES `company_info` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_type_fk` FOREIGN KEY (`project_type_id`) REFERENCES `project_type` (`project_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf32;

/*Data for the table `project` */

insert  into `project`(`project_id`,`project_code`,`project_name`,`project_owner_id`,`project_category_id`,`project_type_id`,`project_parent_id`,`project_assignee`,`project_description`,`project_image`,`project_start_date`,`project_end_date`,`project_status`,`company_id`,`address_id`,`created_date`,`created_by`,`modified_date`,`modified_by`,`delete_flag`,`deleted_date`,`deleted_by`,`project_image_path`) values (1,'SIM_BARR','Simon and Barron WEA Residential',1,NULL,1,0,NULL,'With objective to develop a comprehensive Model for 200,000 sqft Renovation Project. The challenge was to do a complete survey of the existing system in detail to include in the Model. Our team successfully provided Architecture, Structure, Mechanical , Electrical and Plumbing and identified clashes. We also provided solutions for resolving conflicts and innovative approaches for coordination.',NULL,'2015-01-08 23:00:00','2015-12-31 23:00:00',NULL,1,2,NULL,NULL,'2015-01-09 23:00:07','0',NULL,NULL,NULL,'393wea_web.jpg'),(6,NULL,'hello santosh',1,NULL,1,1,NULL,'hello santosh',NULL,'2015-03-13 00:00:00','2015-03-29 00:00:00','1',1,7,'2015-03-13 22:28:53','SYSTEM','2015-03-31 23:16:08','1',NULL,NULL,NULL,NULL),(7,NULL,'bye bye',1,NULL,1,1,NULL,'bye bye',NULL,'2015-03-14 00:00:00','2015-03-29 00:00:00','1',1,8,'2015-03-14 13:37:54','SYSTEM','2015-03-14 13:38:41','1',NULL,NULL,NULL,NULL),(8,NULL,'project name',1,NULL,1,0,NULL,NULL,NULL,'2015-03-13 00:00:00','2015-03-13 00:00:00','1',1,10,NULL,'1',NULL,'1',NULL,NULL,NULL,NULL),(15,NULL,'project name2',1,NULL,1,0,NULL,'project desc',NULL,'2015-03-26 00:00:00','2015-03-26 00:00:00','1',1,17,'2015-03-26 08:04:56','1','2015-03-26 08:09:04','1',NULL,NULL,NULL,NULL),(16,NULL,'project name',1,NULL,1,0,NULL,'project desc',NULL,'2015-03-26 00:00:00','2015-03-26 00:00:00','1',1,18,'2015-03-26 08:06:19','1','2015-03-26 08:06:19','1',NULL,NULL,NULL,NULL);

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

/*Table structure for table `project_file` */

DROP TABLE IF EXISTS `project_file`;

CREATE TABLE `project_file` (
  `project_file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) NOT NULL,
  `project_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `file_type` varchar(45) NOT NULL,
  PRIMARY KEY (`project_file_id`),
  KEY `project_file_fk` (`project_id`),
  CONSTRAINT `project_file_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `project_file` */

insert  into `project_file`(`project_file_id`,`file_name`,`project_id`,`created_date`,`created_by`,`file_type`) values (1,'bsn_bsn.jpg',1,'2015-03-13 16:35:15',1,'image/jpeg'),(2,'IMG_7491.JPG',1,'2015-03-13 16:36:26',1,'image/jpeg'),(3,'file.pdf',1,'2015-03-14 12:37:33',1,'application/pdf'),(4,'Details 3.pdf',1,'2015-03-28 19:46:51',1,'application/pdf'),(5,'handson-nodejs-sample.pdf',1,'2015-03-31 23:45:46',1,'application/pdf');

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `project_member` */

insert  into `project_member`(`project_member_id`,`project_id`,`user_id`,`member_status`) values (7,1,1177202090,'ACTIVE'),(8,1,1,'ACTIVE'),(15,15,1,'ACTIVE'),(16,16,1,'ACTIVE');

/*Table structure for table `project_task` */

DROP TABLE IF EXISTS `project_task`;

CREATE TABLE `project_task` (
  `project_task_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `parent_task_id` int(11) DEFAULT '0',
  `status` varchar(10) DEFAULT NULL,
  `percentage_complete` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(12) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(12) DEFAULT NULL,
  `severity` varchar(45) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`project_task_id`),
  KEY `project_task_fk` (`project_id`),
  CONSTRAINT `project_task_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf32;

/*Data for the table `project_task` */

insert  into `project_task`(`project_task_id`,`project_id`,`title`,`parent_task_id`,`status`,`percentage_complete`,`start_date`,`end_date`,`created_date`,`created_by`,`modified_date`,`modified_by`,`severity`,`description`) values (10,7,'haha',7,'1',NULL,'2015-03-14','2015-03-29','2015-03-14 15:46:41',1,'2015-03-14 15:46:41',1,'1','haha'),(11,7,'hono',7,'1',NULL,'2015-03-14','2015-03-29','2015-03-14 15:48:55',1,'2015-03-14 15:48:55',1,'1','hoho'),(12,7,'haha',7,'1',NULL,'2015-03-14','2015-03-29','2015-03-14 15:53:48',1,'2015-03-14 15:53:48',1,'1','haha'),(13,1,'task1',1,'1',NULL,'2015-03-18','2015-03-18','2015-03-18 22:44:48',1,'2015-03-18 22:44:48',1,'1','task desc'),(14,1,'task1',1,'1',NULL,'2015-03-18','2015-03-18','2015-03-18 22:45:17',1,'2015-03-18 22:45:17',1,'1','task desc'),(15,1,'task1',1,'1',NULL,'2015-03-18','2015-03-18','2015-03-18 22:47:06',1,'2015-03-18 22:47:06',1,'1','task desc'),(16,1,'task1',1,'1',NULL,'2015-03-18','2015-03-18','2015-03-18 22:51:37',1,'2015-03-18 22:51:37',1,'1','task desc'),(17,1,'task1',1,'0',NULL,'2015-03-18','2015-03-18','2015-03-18 22:56:51',1,'2015-03-28 10:36:47',1,'1','task desc'),(18,1,'task1',1,'1',NULL,'2015-03-18','2015-03-18','2015-03-18 22:59:17',1,'2015-03-18 22:59:17',1,'1','task desc');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `project_task_files` */

insert  into `project_task_files`(`task_file_id`,`project_task_id`,`file_name`,`location`,`created_date`,`created_by`) values (1,10,'IMG_5312.JPG','/assets/task/','2015-03-14 15:56:30',1),(2,10,'file.pdf','/assets/task/','2015-03-14 16:09:02',1);

/*Table structure for table `project_type` */

DROP TABLE IF EXISTS `project_type`;

CREATE TABLE `project_type` (
  `project_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_type_name` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `modified_date` datetime NOT NULL,
  `modified_by` varchar(20) NOT NULL,
  `delete_flag` tinyint(4) DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `deleted_by` varchar(20) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`project_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `project_type` */

insert  into `project_type`(`project_type_id`,`project_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`delete_flag`,`deleted_date`,`deleted_by`,`status`) values (1,'COMMERCIAL','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE'),(2,'RESIDENTIAL','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE'),(3,'INFRASTRUCTURE','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE'),(4,'MEDICAL','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE');

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=latin1;

/*Data for the table `registration_request` */

insert  into `registration_request`(`id`,`registration_token`,`project_id`,`first_name`,`last_name`,`email`,`company_name`,`phone_number`,`msg`,`status`,`ts_create`,`user_id`,`name`) values (88,'724367608013897850291735237287962000717039346144346091094471',1,'basant','rijal','rijalbsn@gmail.com',NULL,NULL,NULL,'PENDING','2015-03-12 13:43:32',1177202090,NULL),(89,'76633290492749641017290892895502755827191350222628424507446',1,'santosh','pun','santosh8pun@gmail.com',NULL,NULL,NULL,'PENDING','2015-03-18 21:33:31',NULL,NULL),(90,'200159620785675962946666177837126947750814368195687148296742',1,'santosh','pun','santosh8pun@gmail.com',NULL,NULL,NULL,'PENDING','2015-03-18 21:34:21',NULL,NULL),(91,'424234243424',1,'santosh','pun','santosh8pun@gmail.com',NULL,NULL,NULL,'PENDING','2015-03-18 21:35:56',NULL,NULL),(92,'424234243424',1,'sa','santosh','santosh8pun@gmail.com',NULL,NULL,NULL,'APPROVED','2015-03-23 07:48:16',NULL,NULL),(93,'473470952246054790612814866284185996681624473595953387133810',1,NULL,NULL,'santosh7pun@gmail.com','company name','43434223','request to join','PENDING','2015-03-25 20:34:22',NULL,'santosh pun'),(94,'801730620255958691818052496876952196576753361320345638139917',1,NULL,NULL,'santosh7pun@gmail.com','company name','43434223','request to join','PENDING','2015-03-27 15:05:01',NULL,'santosh pun'),(95,'406263815574648580382858226385814888083695317000156863038364',1,NULL,NULL,'santosh7pun@gmail.com','company name','43434223','request to join','PENDING','2015-03-27 16:11:54',NULL,'santosh pun'),(96,'187606897527811672352503253656301116341744312123377879655719',1,NULL,NULL,'santosh8pun@gmail.com','company name','43434223','request to join','PENDING','2015-03-27 16:43:01',NULL,'santosh pun'),(97,'792723293711752393584946131643116263708525031840596214132251',1,NULL,NULL,'santosh8pun@gmail.com','company name','43434223','request to join','PENDING','2015-03-28 19:22:11',NULL,'santosh pun'),(98,'516295962518319362581535263248916329682366302585832816287318',NULL,'santosh','Pun234','santosh8pun@gmail.com',NULL,'45345345','I want to request for onboard demo','PENDING','2015-03-28 19:58:52',NULL,NULL),(99,'254354095371586726235176811094231768621762119386937010673676',NULL,'santosh','Pun234','santosh8pun@gmail.com',NULL,'45345345','I want to request for onboard demo','PENDING','2015-03-28 20:00:15',NULL,NULL),(100,'789767624257316688374640271675707659703553307124837552265509',1,'Santosh','Pun','santosh8pun@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-03-31 23:24:47',NULL,NULL),(101,'690842391867141465900905955449988308764225138255434779742823',1,'Santosh','Pun','santosh8pun@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-03-31 23:25:22',NULL,NULL),(102,'651935780112823040908535467926137982211605583716189273927597',1,'Santosh','Pun','santosh8pun@hotmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-03-31 23:25:38',NULL,NULL),(103,'38511110665790010563950776627892968697383382824135011198037',1,'Santosh','Pun','santosh8pun@hotmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-03-31 23:25:57',NULL,NULL),(104,'593789462942157299197608606370285786708338287946624364896531',1,'Santosh','Pun','santosh@yahoo.com',NULL,NULL,NULL,'ACCT_INVITE','2015-03-31 23:26:13',NULL,NULL),(105,'266994169359940814883832007073092089633306093129908455437726',1,'Santosh','Pun','santosh@yahoo.com',NULL,NULL,NULL,'ACCT_INVITE','2015-03-31 23:26:34',NULL,NULL),(106,'427753387130084528118171187048062764715096693150174118879097',1,'Santosh','Pun','santosh@yahoo.com',NULL,NULL,NULL,'ACCT_INVITE','2015-03-31 23:31:32',NULL,NULL),(107,'800094842487666886969328345641905327615636055695669227704944',1,'Santosh','pun','santosh8pun@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-03-31 23:59:51',NULL,NULL),(108,'480231032983696794223023637091247133400471324720607372398175',1,'Santosh','Pun','santosh8pun@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-04-01 00:18:02',NULL,NULL),(109,'142340256496391402258998768905107916336407654000351550462561',1,'Santosh','Pun','santosh8pun@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-04-01 00:24:06',1615835308,NULL);

/*Table structure for table `shops` */

DROP TABLE IF EXISTS `shops`;

CREATE TABLE `shops` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employees_number` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `shops` */

insert  into `shops`(`id`,`employees_number`,`name`) values (1,1,'Santosh Pun');

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
  `task_assignee` bigint(20) NOT NULL,
  `created_by` int(12) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_by` int(12) NOT NULL,
  `modified_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`task_assignee_id`),
  KEY `task_assignee_fk` (`project_task_id`),
  CONSTRAINT `task_assignee_fk` FOREIGN KEY (`project_task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf32;

/*Data for the table `task_assignee` */

insert  into `task_assignee`(`task_assignee_id`,`project_task_id`,`task_assignee`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,11,1177202090,1,'2015-03-15 10:29:35',1,'2015-03-15 10:29:35'),(2,10,1177202090,1,'2015-03-15 10:30:23',1,'2015-03-15 10:30:23');

/*Table structure for table `task_comment` */

DROP TABLE IF EXISTS `task_comment`;

CREATE TABLE `task_comment` (
  `task_comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NOT NULL,
  `comment` text,
  `commented_by` int(12) DEFAULT NULL,
  `commented_date` datetime DEFAULT NULL,
  `comment_status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`task_comment_id`),
  KEY `task_comment_fk` (`task_id`),
  CONSTRAINT `task_comment_fk` FOREIGN KEY (`task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `task_comment` */

insert  into `task_comment`(`task_comment_id`,`task_id`,`comment`,`commented_by`,`commented_date`,`comment_status`) values (1,10,'hey',1,'2015-03-15 11:14:22','ACTIVE'),(2,10,'hoho',1,'2015-03-15 11:15:17','ACTIVE'),(3,17,'this is test comment',1,'2015-03-28 10:33:30','ACTIVE');

/*Table structure for table `task_percentage_log` */

DROP TABLE IF EXISTS `task_percentage_log`;

CREATE TABLE `task_percentage_log` (
  `task_percentage_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NOT NULL,
  `percentage_type` varchar(45) DEFAULT NULL,
  `percentage_complete` double DEFAULT '0',
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`task_percentage_log_id`),
  KEY `task_percentage_fk` (`task_id`),
  CONSTRAINT `task_percentage_fk` FOREIGN KEY (`task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `task_percentage_log` */

insert  into `task_percentage_log`(`task_percentage_log_id`,`task_id`,`percentage_type`,`percentage_complete`,`start_date`,`end_date`,`created_by`,`modified_date`,`modified_by`,`created_date`) values (1,10,'PERCENTAGE',10,'2015-03-14 17:50:56','9999-12-31 00:00:00','1','2015-03-14 17:50:56','0','2015-03-14 17:50:56'),(2,10,'PERCENTAGE',20,'2015-03-14 17:51:59','9999-12-31 00:00:00','1','2015-03-14 17:51:59','0','2015-03-14 17:51:59'),(3,10,'PERCENTAGE',34,'2015-03-14 18:14:26','9999-12-31 00:00:00','1','2015-03-14 18:14:26','0','2015-03-14 18:14:26'),(4,10,'PERCENTAGE',34,'2015-03-14 18:16:02','9999-12-31 00:00:00','1','2015-03-14 18:16:02','0','2015-03-14 18:16:02'),(5,10,'PERCENTAGE',34,'2015-03-14 18:18:03','9999-12-31 00:00:00','1','2015-03-14 18:18:03','0','2015-03-14 18:18:03');

/*Table structure for table `task_status` */

DROP TABLE IF EXISTS `task_status`;

CREATE TABLE `task_status` (
  `task_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_code` varchar(15) DEFAULT NULL,
  `status_name` varchar(15) DEFAULT NULL,
  `status_description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`task_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `task_status` */

insert  into `task_status`(`task_status_id`,`status_code`,`status_name`,`status_description`) values (1,'ACTIVE','Active','Active Status'),(2,'ONGOING','Ongoing','Ongoing Status'),(3,'COMPLETED','Completed','Completed Status'),(4,'PENDING','Pending','Pending Status');

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
  CONSTRAINT `fk_user_type_id` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`user_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1177202095 DEFAULT CHARSET=utf32;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_type_id`,`password`,`salt`,`user_status`,`discipline`,`number_of_login`,`modified_date`,`account_status`) values (1,'sanjeev@ontargetcloud.com',1,'1590310726305658489385413286246310421708183859017331762359811768282286250496125258650711064416852986500525561573032470152798992490138986736254587494427318','77669879705837938287414502915720472866484455098518912426265626992059650737739823785159646056478502713513267012025588248826960353027302007756549749933969868427164204553495305009994916526176912381547176962343088050627479321990373536626712927075116584241322944156585090188954193261685969230545053392010255966860','1',1,1,'2014-11-05 02:30:40','ACTIVE'),(1177202090,'rijalbsn@gmail.com',1,'4094773960715232235434823068019545525781069130133653871739472231162376445881493416617201219896320224787803196425967303485057890212439831795739903615989518','48116663777377151718258305613608080419270082004406646126153186085005856067823567402111453130029394236413570431911369002823461696018608976748168167291797206872060255692486233749427893742536736692885933695474147481779462369352909525635113743119764753433380013160018701350189796782721653435441714435695080083938','1',3,1,'2015-03-12 13:45:20','ACTIVE'),(1177202091,'santosh7pun@gmail.com',1,'90959adc-7449-48b9-bca5-fba92ec1ca8c','','0',1,1,'2015-03-25 21:27:47','ACCT_NEW'),(1177202094,'santosh8pun@gmail.com',1,'2376301310833556200705082248108324862446594610970926777169526996013355008898392235194312412098255796594516921375612909561690099008192725219710278361854146','63339939641129356770827870387024060441717624052611677261795177289042992052214481048724232313971648723966401904229751829469202203385846573255645608709613845371169606328414022773075789037375234317062443467990015392648714719281224319588522419843262481975736366653358809658934458002784381865404260798556722604288','1',3,1,'2015-04-01 00:30:04','ACCT_INVITE');

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
  `text` text,
  `category` bigint(20) DEFAULT NULL,
  `user_id` int(12) NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=latin1;

/*Data for the table `user_notification` */

insert  into `user_notification`(`id`,`text`,`category`,`user_id`,`ts_insert`) values (144,'New member 1177202090 added for project 1',8,1177202090,'2015-03-12 16:06:55'),(145,'New member 1 added for project 1',8,1,'2015-03-12 16:11:02'),(146,'New member 1177202090 added for project 1',8,1177202090,'2015-03-12 16:12:21'),(147,'New member 1177202090 added for project 1',8,1177202090,'2015-03-12 16:35:41'),(148,'New member 1177202090 added for project 1',8,1177202090,'2015-03-12 16:37:37'),(149,NULL,2,1,'2015-03-13 18:37:35'),(150,'New member 1 added for project 2',8,1,'2015-03-13 18:37:35'),(151,NULL,2,1,'2015-03-13 19:01:17'),(152,'New member 1 added for project 3',8,1,'2015-03-13 19:01:17'),(153,NULL,2,1,'2015-03-13 19:55:45'),(154,NULL,2,1,'2015-03-13 22:17:31'),(155,NULL,2,1,'2015-03-13 22:28:53'),(156,NULL,2,1,'2015-03-14 13:37:54'),(157,'project 7 updated by 1',3,1,'2015-03-14 13:38:28'),(158,'project 7 updated by 1',3,1,'2015-03-14 13:38:41'),(159,'New task task1 of id 1 added by 1',4,1,'2015-03-14 13:53:02'),(160,'New task hola of id 2 added by 1',4,1,'2015-03-14 15:02:17'),(161,'New task hop of id 3 added by 1',4,1,'2015-03-14 15:08:00'),(162,'New task hello hello of id 4 added by 1',4,1,'2015-03-14 15:10:17'),(163,'New task hoho of id 5 added by 1',4,1,'2015-03-14 15:21:32'),(164,'New task heh of id 6 added by 1',4,1,'2015-03-14 15:41:02'),(165,'New task hey of id 7 added by 1',4,1,'2015-03-14 15:44:12'),(166,'New task tuts of id 8 added by 1',4,1,'2015-03-14 15:44:35'),(167,'New task haha of id 9 added by 1',4,1,'2015-03-14 15:45:28'),(168,'New task haha of id 10 added by 1',4,1,'2015-03-14 15:46:41'),(169,'New task hono of id 11 added by 1',4,1,'2015-03-14 15:48:55'),(170,'New task haha of id 12 added by 1',4,1,'2015-03-14 15:53:48'),(171,'New file IMG_5312.JPG uploaded for task 10 by user 1',10,1,'2015-03-14 15:56:30'),(172,'New file file.pdf uploaded for task 10 by user 1',10,1,'2015-03-14 16:09:02'),(173,'New planned cost added for task  by 110',6,1,'2015-03-14 17:23:50'),(174,'New planned cost added for task  by 110',6,1,'2015-03-14 17:23:50'),(175,'New planned cost added for task  by 110',6,1,'2015-03-14 17:27:10'),(176,'New planned cost added for task  by 110',6,1,'2015-03-14 17:27:10'),(177,'New assignee 1177202090 added for task 1177202090',9,1177202090,'2015-03-15 10:29:35'),(178,'New assignee 1177202090 added for task 1177202090',9,1177202090,'2015-03-15 10:30:23'),(179,'Task 1 is made dependent on task 1 by user 1',11,1,'2015-03-18 22:44:44'),(180,'New task task1 of id 13 added by 1',4,1,'2015-03-18 22:44:48'),(181,'New task task1 of id 14 added by 1',4,1,'2015-03-18 22:45:17'),(182,'New task task1 of id 15 added by 1',4,1,'2015-03-18 22:47:06'),(183,'New task task1 of id 16 added by 1',4,1,'2015-03-18 22:51:37'),(184,'New task task1 of id 17 added by 1',4,1,'2015-03-18 22:56:51'),(185,'New task task1 of id 18 added by 1',4,1,'2015-03-18 22:59:17'),(186,NULL,2,1,'2015-03-25 22:22:53'),(187,'task task1 of id 17 updated by 1',5,1,'2015-03-28 10:36:16'),(188,'task task1 of id 17 updated by 1',5,1,'2015-03-28 10:36:47'),(189,'New planned cost added for task  by 110',6,1,'2015-03-28 19:40:03');

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

/*Data for the table `user_safety_info` */

insert  into `user_safety_info`(`id`,`name`,`info`,`discipline_id`,`ts_create`) values (2,'10 fingers, 10 toes 2 eyes 1 nose…safety counts','',1,'2014-12-03 03:26:53'),(3,'10 fingers. 10 toes, If you are not safe Who knows?','',1,'2014-12-03 03:26:53'),(4,'A clean floor everyday keeps lost days away.','',1,'2014-12-03 03:26:53'),(5,'A spill, a slip, a hospital trip','',1,'2014-12-03 03:26:53'),(6,'A tree never hits an automobile except in self defense','',1,'2014-12-03 03:26:53'),(7,'Accidents Big Or Small, Avoid Them All','',1,'2014-12-03 03:26:53'),(8,'Accidents hurt, Safety doesn’t.','',1,'2014-12-03 03:26:53'),(9,'An ounce of prevention is worth a pound of cure','',1,'2014-12-03 03:26:53'),(10,'Are you part of the safety TEAM….(Together Employees Accomplish More)','',1,'2014-12-03 03:26:53'),(11,'Arms work best when attached to the body','',1,'2014-12-03 03:26:54'),(12,'At work at play, let safety lead the way.','',1,'2014-12-03 03:26:54'),(13,'Avoid the worst. Put safety first.','',1,'2014-12-03 03:26:54'),(14,'Be a safety hero – score an accident zero','',1,'2014-12-03 03:26:54'),(15,'Be alert! Accidents hurt.','',1,'2014-12-03 03:26:54'),(16,'Be aware Take care','',1,'2014-12-03 03:26:54'),(17,'Before you do it, take time to think through it.','',1,'2014-12-03 03:26:54'),(18,'Behind the wheel, anger is one letter away from danger.','',1,'2014-12-03 03:26:54'),(19,'Being safe is in your own hands.','',1,'2014-12-03 03:26:54'),(20,'Best gift you can give your family is YOU! Please be safe','',1,'2014-12-03 03:26:54'),(21,'Break the drive and arrive alive.','',1,'2014-12-03 03:26:54'),(22,'Chance takers are accident makers','',1,'2014-12-03 03:26:54'),(23,'Choose safety, for your family.','',1,'2014-12-03 03:26:54'),(24,'Click clack front and back.','',1,'2014-12-03 03:26:55'),(25,'Click it or ticket!','',1,'2014-12-03 03:26:55'),(26,'Computer problems you can avoid, so you don’t have to get paranoid.','',1,'2014-12-03 03:26:55'),(27,'Courtesy and common sense promote safety.','',1,'2014-12-03 03:26:55'),(28,'Courtesy is contagious','',1,'2014-12-03 03:26:55'),(29,'Dare to be aware.','',1,'2014-12-03 03:26:55'),(30,'Do you have eye for safety or are you blinded by bad habits','',1,'2014-12-03 03:26:55'),(31,'Doesn’t matter how far. JUST BELT UP!','',1,'2014-12-03 03:26:55'),(32,'Don’t be a fool, cause safety is cool, so make that your rule.','',1,'2014-12-03 03:26:55'),(33,'Don’t be a fool. Use the proper tool.','',1,'2014-12-03 03:26:55'),(34,'Don’t be hasty when it comes to safety.','',1,'2014-12-03 03:26:55'),(35,'Don’t be safety blinded, be safety minded.','',1,'2014-12-03 03:26:55'),(36,'Don’t learn safety by accident.','',1,'2014-12-03 03:26:55'),(37,'Don’t leave Private information on a public computer screen','',1,'2014-12-03 03:26:55'),(38,'Eyes are priceless, eye protection is cheap.','',1,'2014-12-03 03:26:55'),(39,'Falling objects can be brutal if you don’t protect your noodle.','',1,'2014-12-03 03:26:55'),(40,'Fingers toes, If you are not safe Who knows?','',1,'2014-12-03 03:26:55'),(41,'Forget the nurse with safety first.','',1,'2014-12-03 03:26:55'),(42,'Forgot your hearing protection? Forget about hearing!','',1,'2014-12-03 03:26:55'),(43,'Get in high speed pursuit of safety','',1,'2014-12-03 03:26:56'),(44,'Get smart! Use safety from the start.','',1,'2014-12-03 03:26:56'),(45,'Give them a Brake!','',1,'2014-12-03 03:26:56'),(46,'Got crazy with the lighter? Call a firefighter.','',1,'2014-12-03 03:26:56'),(47,'Hard hats, they’re not just for decoration','',1,'2014-12-03 03:26:56'),(48,'Have another day by being safe today!','',1,'2014-12-03 03:26:56'),(49,'Hearing protection is a sound investment.','',1,'2014-12-03 03:26:56'),(50,'Housekeeping you skip may cause a fall or slip.','',1,'2014-12-03 03:26:56'),(51,'If everything comes your way, you are in the wrong lane.','',1,'2014-12-03 03:26:56'),(52,'If they email you asking for cash, be sure to throw it in the trash.','',1,'2014-12-03 03:26:56'),(53,'If they email you asking for Money, Say no thanks I won’t fall for it honey.','',1,'2014-12-03 03:26:56'),(54,'If you don’t know the sender, it might be a pretender','',1,'2014-12-03 03:26:56'),(55,'If you don’t think it will happen to you, find the person who had it happen to them','',1,'2014-12-03 03:26:56'),(56,'If you mess up, ‘fess up','',1,'2014-12-03 03:26:56'),(57,'Is better to lose one minute in life… than to lose life in a minute.','',1,'2014-12-03 03:26:56'),(58,'It only takes one mistake to bring us all down; don’t let it be yours!','',1,'2014-12-03 03:26:57'),(59,'It’s easier to ask a dumb question than it is to fix a dumb mistake','',1,'2014-12-03 03:26:57'),(60,'Keep a grip on life and protect your hands','',1,'2014-12-03 03:26:57'),(61,'Keep safety in mind. It will save your behind.','',1,'2014-12-03 03:26:57'),(62,'Keeping your work area clean, helps keep hazards from being unseen.','',1,'2014-12-03 03:26:57'),(63,'Knock out…accidents','',1,'2014-12-03 03:26:57'),(64,'Know safety – no pain','',1,'2014-12-03 03:26:57'),(65,'Know safety No Accidents','',1,'2014-12-03 03:26:57'),(66,'Lead the way, safety today.','',1,'2014-12-03 03:26:57'),(67,'Learn from others mistakes, don’t have others learn from you.','',1,'2014-12-03 03:26:57'),(68,'Let’s all keep our heads, and other body parts, together','',1,'2014-12-03 03:26:57'),(69,'Life’s short, don’t rush it','',1,'2014-12-03 03:26:57'),(70,'Light up your tree – not your home','',1,'2014-12-03 03:26:57'),(71,'Make it your mission, not to live in unsafe condition.','',1,'2014-12-03 03:26:57'),(72,'Make safety a reality and don’t be a fatality','',1,'2014-12-03 03:26:57'),(73,'My job provides my paycheck, but safety takes me home.','',1,'2014-12-03 03:26:57'),(74,'Near miss reported today, is the accident that does not happen tomorrow.','',1,'2014-12-03 03:26:57'),(75,'Never drive faster than your guardian angel can fly','',1,'2014-12-03 03:26:57'),(76,'Never give safety a day off','',1,'2014-12-03 03:26:57'),(77,'No Belt. No Brains','',1,'2014-12-03 03:26:57'),(78,'No safety – know pain','',1,'2014-12-03 03:26:57'),(79,'One bad day at the grinder could ruin your whole life','',1,'2014-12-03 03:26:57'),(80,'Only You can prevent forest fires!','',1,'2014-12-03 03:26:57'),(81,'Pencils have erasers–mishaps don’t!','',1,'2014-12-03 03:26:58'),(82,'Prevent a jam, don’t open spam','',1,'2014-12-03 03:26:58'),(83,'Protect your hands, you need them to pick up your pay check','',1,'2014-12-03 03:26:58'),(84,'Quench the thirst – safety first','',1,'2014-12-03 03:26:58'),(85,'Replacing a saw guard is easier than replacing a finger','',1,'2014-12-03 03:26:58'),(86,'Safe crane operation is uplifting','',1,'2014-12-03 03:26:58'),(87,'Safety – A small investment for a rich future','',1,'2014-12-03 03:26:58'),(88,'Safety by Choice, Not by Chance.','',1,'2014-12-03 03:26:58'),(89,'Safety comes in a can, I can, You can, We can be safe.','',1,'2014-12-03 03:26:58'),(90,'Safety doesn’t happen by accident','',1,'2014-12-03 03:26:58'),(91,'Safety first makes us last.','',1,'2014-12-03 03:26:58'),(92,'Safety First, Avoid the Worst.','',1,'2014-12-03 03:26:58'),(93,'Safety first, to last.','',1,'2014-12-03 03:26:58'),(94,'Safety first…because accidents last.','',1,'2014-12-03 03:26:58'),(95,'Safety fits like a glove; Try one on.','',1,'2014-12-03 03:26:58'),(96,'Safety Glasses – All in favor say EYE','',1,'2014-12-03 03:26:58'),(97,'Safety in – we win','',1,'2014-12-03 03:26:58'),(98,'Safety is a cheap and effective insurance policy','',1,'2014-12-03 03:26:58'),(99,'Safety is a continuing journey, not a final destination.','',1,'2014-12-03 03:26:58'),(100,'Safety is a frame of mind – So concentrate on it all the time.','',1,'2014-12-03 03:26:59'),(101,'Safety is a Frame of Mind, Get the Picture.','',1,'2014-12-03 03:26:59'),(102,'Safety is a full time job – don’t make it a part time practice','',1,'2014-12-03 03:26:59'),(103,'Safety is a mission not an intermission','',1,'2014-12-03 03:26:59'),(104,'Safety is about doing the right thing, even if no one is looking.','',1,'2014-12-03 03:26:59'),(105,'Safety is as simple as ABC – Always Be Careful','',1,'2014-12-03 03:26:59'),(106,'Safety is like a lock – But you are the key.','',1,'2014-12-03 03:26:59'),(107,'Safety is no accident','',1,'2014-12-03 03:26:59'),(108,'Safety is success by purpose – Not Accident.','',1,'2014-12-03 03:26:59'),(109,'Safety isn’t a hobby, it’s a living.','',1,'2014-12-03 03:26:59'),(110,'Safety isn’t expensive it’s priceless.','',1,'2014-12-03 03:26:59'),(111,'Safety isn’t just a slogan, it’s a way of life.','',1,'2014-12-03 03:26:59'),(112,'Safety makes good dollars and sense','',1,'2014-12-03 03:26:59'),(113,'Safety rules are there to follow. So take care and we will see you tomorrow.','',1,'2014-12-03 03:26:59'),(114,'Safety rules are your best tools.','',1,'2014-12-03 03:26:59'),(115,'Safety saves, Accidents cost you.','',1,'2014-12-03 03:26:59'),(116,'Safety starts with “S” but begins with “YOU”.','',1,'2014-12-03 03:27:00'),(117,'Safety starts with me.','',1,'2014-12-03 03:27:00'),(118,'Safety: more fun than running with scissors','',1,'2014-12-03 03:27:00'),(119,'Safety… It can charm you, or ALARM you!','',1,'2014-12-03 03:27:00'),(120,'Safety…Did it, done it, doing it tomorrow','',1,'2014-12-03 03:27:00'),(121,'Safety…one habit you never need to break','',1,'2014-12-03 03:27:00'),(122,'Save tomorrow. Think safety today.','',1,'2014-12-03 03:27:00'),(123,'Seat Belts are for kids – Hug them at home – Belt them in the car','',1,'2014-12-03 03:27:00'),(124,'Seatbelts save lives. Buckle up everytime.','',1,'2014-12-03 03:27:00'),(125,'Shortcuts cut life short','',1,'2014-12-03 03:27:00'),(126,'Speed Thrills but Kills.','',1,'2014-12-03 03:27:00'),(127,'Stay safe, someone at home is waiting for you.','',1,'2014-12-03 03:27:00'),(128,'Stop drop & roll','',1,'2014-12-03 03:27:00'),(129,'Success is no accident','',1,'2014-12-03 03:27:00'),(130,'The best car safety device is a rear-view mirror with a cop in it.','',1,'2014-12-03 03:27:00'),(131,'The door to Safety swings on the hinges of common sense','',1,'2014-12-03 03:27:00'),(132,'The only trip you take should be on vacation.','',1,'2014-12-03 03:27:00'),(133,'The safe way is the only way.','',1,'2014-12-03 03:27:00'),(134,'The stupid shall be punished','',1,'2014-12-03 03:27:00'),(135,'Think Safety, Because I Love You Man.','',1,'2014-12-03 03:27:00'),(136,'Think sharp….never handle broken glass with bare hands.','',1,'2014-12-03 03:27:00'),(137,'Think smart before you start.','',1,'2014-12-03 03:27:00'),(138,'Those precious fingers don’t ignore, Or they could end up on the floor.','',1,'2014-12-03 03:27:00'),(139,'Those who work the safest way- live to see another day','',1,'2014-12-03 03:27:01'),(140,'To avoid a scene keep your work place clean.','',1,'2014-12-03 03:27:01'),(141,'To prevent a drastic call, Install a firewall','',1,'2014-12-03 03:27:01'),(142,'Tomorrow: Your reward for working safely today.','',1,'2014-12-03 03:27:01'),(143,'Trying to make up time could cost you your life.','',1,'2014-12-03 03:27:01'),(144,'Unsafe acts will keep you in stitches','',1,'2014-12-03 03:27:01'),(145,'Watch where you walk or you might need a walker.','',1,'2014-12-03 03:27:01'),(146,'Watch your step – it could be your last tomorrow','',1,'2014-12-03 03:27:01'),(147,'whats holding you back?','',1,'2014-12-03 03:27:01'),(148,'When you gamble with safety ..You bet your life.','',1,'2014-12-03 03:27:01'),(149,'While on a ladder, never step back to admire your work','',1,'2014-12-03 03:27:01'),(150,'Wipe Up and avoid a Slip Up!','',1,'2014-12-03 03:27:01'),(151,'Work safe today–heaven can wait.','',1,'2014-12-03 03:27:01'),(152,'Work together…work safely.','',1,'2014-12-03 03:27:01'),(153,'Working safely may get old, but so do those who practice it.','',1,'2014-12-03 03:27:01'),(154,'Your first mistake could be your last','',1,'2014-12-03 03:27:01'),(155,'Your reward for working safely today.','',1,'2014-12-03 03:27:01'),(156,'Your wife will spend your 401K; If you get killed at work today.','',1,'2014-12-03 03:27:01'),(157,'Protect your hands, you need them to pick up your pay check','',1,'2014-12-03 03:27:01'),(158,'Your wife will spend your 401K; If you get killed at work today','',1,'2014-12-03 03:27:01'),(159,'Safety…Did it, done it, doing it tomorrow','',1,'2014-12-03 03:27:01'),(160,'Watch your step - it could be your last tomorrow','',1,'2014-12-03 03:27:01'),(161,'Those precious fingers don’t ignore. . . Or they could end up on the floor','',1,'2014-12-03 03:27:01'),(162,'Your reward for working safely today.','',1,'2014-12-03 03:27:02'),(163,'Those who work the safest way- live to see another day','',1,'2014-12-03 03:27:02'),(164,'Get in high speed pursuit of safety','',1,'2014-12-03 03:27:02'),(165,'Seat Belts are for kids - Hug them at home - Belt them in the car','',1,'2014-12-03 03:27:02'),(166,'Safe crane operation is uplifting','',1,'2014-12-03 03:27:02'),(167,'Pencils have erasers–mishaps don’t!','',1,'2014-12-03 03:27:02'),(168,'Work safe today–heaven can wait.','',1,'2014-12-03 03:27:02'),(169,'Safety is a mission not an intermission','',1,'2014-12-03 03:27:02'),(170,'Safety doesn’t happen by accident','',1,'2014-12-03 03:27:02'),(171,'A spill, a slip, a hospital trip ','',1,'2014-12-03 03:27:02'),(172,'Falling objects can be brutal if you don’t protect your noodle','',1,'2014-12-03 03:27:02'),(173,'Safety glasses: All in favor say “Eye!”','',1,'2014-12-03 03:27:02'),(174,'It’s easier to ask a dumb question than it is to fix a dumb mistake','',1,'2014-12-03 03:27:02'),(175,'Safety isn’t a hobby, it’s a living.','',1,'2014-12-03 03:27:02'),(176,'Safety - A small investment for a rich future','',1,'2014-12-03 03:27:02'),(177,'Safety is no accident','',1,'2014-12-03 03:27:02'),(178,'Safety is a cheap and effective insurance policy','',1,'2014-12-03 03:27:02'),(179,'Let’s all keep our heads, and other body parts, together','',1,'2014-12-03 03:27:02'),(180,'While on a ladder, never step back to admire your work','',1,'2014-12-03 03:27:02'),(181,'Quench the thirst – safety first','',1,'2014-12-03 03:27:02'),(182,'When you gamble with safety you bet your life','',1,'2014-12-03 03:27:02'),(183,'The stupid shall be punished','',1,'2014-12-03 03:27:02'),(184,'Chance takers are accident makers','',1,'2014-12-03 03:27:02'),(185,'Safety is a full time job; don’t make it a part time practice','',1,'2014-12-03 03:27:02'),(186,'The door to Safety swings on the hinges of common sense','',1,'2014-12-03 03:27:02'),(187,'Is better to lose one minute in life… than to lose life in a minute.','',1,'2014-12-03 03:27:02'),(188,'Safety — a small investment for a rich future','',1,'2014-12-03 03:27:03'),(189,'Your first mistake could be your last','',1,'2014-12-03 03:27:03'),(190,'Safety isn’t expensive it’s priceless.','',1,'2014-12-03 03:27:03'),(191,'Safety is as simple as ABC…Always Be Careful','',1,'2014-12-03 03:27:03'),(192,'Unsafe acts will keep you in stitches','',1,'2014-12-03 03:27:03'),(193,'Knock out…accidents','',1,'2014-12-03 03:27:03'),(194,'If you mess up, ‘fess up','',1,'2014-12-03 03:27:03'),(195,'Hard hats, they’re not just for decoration','',1,'2014-12-03 03:27:03'),(196,'If you don’t think it will happen to you, find the person who had it happen to them','',1,'2014-12-03 03:27:03'),(197,'Keep safety in mind. It will save your behind.','',1,'2014-12-03 03:27:03'),(198,'One bad day at the grinder could ruin your whole life','',1,'2014-12-03 03:27:03'),(199,'Shortcuts cut life short','',1,'2014-12-03 03:27:03');

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
) ENGINE=InnoDB AUTO_INCREMENT=435 DEFAULT CHARSET=latin1;

/*Data for the table `user_session_info` */

insert  into `user_session_info`(`user_session_info_id`,`user_id`,`login_token`,`created_date`,`expire_date`,`is_expired`) values (350,1,'2d942296-4fc0-45c2-823f-7084206a6474','2015-03-12 13:42:27','9999-12-31 00:00:00','1'),(351,1,'d10e9164-c545-4be6-a407-30798522707b','2015-03-12 13:42:59','9999-12-31 00:00:00','1'),(352,1,'a4f7d8be-8acb-44ed-afb1-c6fa8dc17e5a','2015-03-12 13:44:25','9999-12-31 00:00:00','1'),(353,1177202090,'01e7af5f-4cfc-4151-9b0e-77dba20355a5','2015-03-12 13:45:28','9999-12-31 00:00:00','0'),(359,1177202090,'390ebae7-cbf3-4e4a-ba50-97355f7d50c6','2015-03-12 16:11:53','9999-12-31 00:00:00','0'),(360,1177202090,'9e328440-7378-46b4-aea0-42744a618342','2015-03-12 16:35:18','9999-12-31 00:00:00','0'),(361,1177202090,'97c0d9d2-2e85-4279-8473-de5d3774f57a','2015-03-12 16:37:20','9999-12-31 00:00:00','0'),(362,1,'6017ebc0-e6fa-4250-9401-f76fa1e9b36d','2015-03-13 11:25:59','9999-12-31 00:00:00','1'),(363,1,'7af926f5-e499-4e2d-bcf7-556a6ccd3c5e','2015-03-13 12:12:10','9999-12-31 00:00:00','1'),(364,1,'c93b6b8e-c748-4d13-985a-7b9962933d0d','2015-03-13 12:53:09','9999-12-31 00:00:00','1'),(365,1,'701ce8b9-6183-47d1-b859-2bc114ba51af','2015-03-13 12:53:55','9999-12-31 00:00:00','1'),(366,1,'16c49471-6013-4cad-9f6f-c8ccdeb9318c','2015-03-13 12:58:38','9999-12-31 00:00:00','1'),(367,1,'96ca66bd-3ef5-43ea-84b1-076023951025','2015-03-13 12:59:53','9999-12-31 00:00:00','1'),(368,1,'c07e6bd0-5731-4fe6-9a79-417ade58f406','2015-03-13 13:01:01','9999-12-31 00:00:00','1'),(369,1,'cdb2b36c-2a72-49f9-9e58-9e10b7d0e5d4','2015-03-13 13:02:30','9999-12-31 00:00:00','1'),(370,1,'dfc9da3c-5690-4356-a2af-2c685d19160d','2015-03-13 13:07:41','9999-12-31 00:00:00','1'),(371,1,'7c10dcc2-9ded-4209-81a9-b084611b7200','2015-03-13 14:56:49','9999-12-31 00:00:00','1'),(372,1,'dc2ac997-99ee-4c24-a7b3-3116d74de7ec','2015-03-13 15:20:28','9999-12-31 00:00:00','1'),(373,1,'edc1d242-8e37-41b5-b786-87bae71f903c','2015-03-13 16:04:05','9999-12-31 00:00:00','1'),(374,1,'37304b24-b65b-4387-bc15-6953e2c4b99d','2015-03-13 16:04:49','9999-12-31 00:00:00','1'),(375,1,'3014865f-884b-4127-9e4b-dadaab8e702f','2015-03-13 16:12:05','9999-12-31 00:00:00','1'),(376,1,'42299dae-5395-4af9-a314-02df40f61c30','2015-03-13 16:13:15','9999-12-31 00:00:00','1'),(377,1,'b195367c-55f5-4fa4-a2c7-cc9bca915d16','2015-03-13 16:14:10','9999-12-31 00:00:00','1'),(378,1,'25892043-b8c0-4f10-9f1e-09cd34e48019','2015-03-14 17:19:31','9999-12-31 00:00:00','1'),(379,1,'6fec0f60-171d-4854-a802-ffce6fd0bd74','2015-03-15 09:43:01','9999-12-31 00:00:00','1'),(380,1,'3e74ec8c-5e18-4cc5-adb1-f1daf8f5b016','2015-03-15 09:49:30','9999-12-31 00:00:00','1'),(381,1,'6070b70d-44ab-4301-a036-34beb4b335c7','2015-03-15 10:37:12','9999-12-31 00:00:00','1'),(382,1,'8fe3123e-1580-462a-9f8e-9f33c65814a4','2015-03-15 11:24:25','9999-12-31 00:00:00','1'),(383,1,'e5fdbcb5-171a-412a-89ba-c40678948467','2015-03-15 11:26:46','9999-12-31 00:00:00','1'),(384,1,'f751abca-fbdf-465b-8991-18f9ccc4c6f8','2015-03-15 14:23:06','9999-12-31 00:00:00','1'),(385,1,'6c0abed1-62bb-45a8-aad0-b40a18feeaf6','2015-03-15 15:13:35','9999-12-31 00:00:00','1'),(386,1,'943355b1-13de-46cf-919d-bbc06876d4ec','2015-03-15 15:30:23','9999-12-31 00:00:00','1'),(387,1,'17955d1c-1c68-442d-a0ff-cdde5ce05f11','2015-03-15 15:39:25','9999-12-31 00:00:00','1'),(388,1,'4a87fdaf-4c16-40aa-b945-93b631d59068','2015-03-15 15:40:19','9999-12-31 00:00:00','1'),(389,1,'6ac20bd3-3df8-4c2e-a41b-f1db17453e54','2015-03-15 15:40:39','9999-12-31 00:00:00','1'),(390,1,'bfb6e3b0-e299-4487-98cc-83178d5242fc','2015-03-15 15:41:45','9999-12-31 00:00:00','1'),(391,1,'87ac2a26-9a47-4b91-9173-fd0800b221dc','2015-03-15 15:43:49','9999-12-31 00:00:00','1'),(392,1,'2a34bd90-e55c-46ff-a54e-b123d2bfc012','2015-03-15 16:18:10','9999-12-31 00:00:00','1'),(393,1,'7ace2886-39fb-4e27-b53e-23c15369b754','2015-03-15 16:35:06','9999-12-31 00:00:00','1'),(394,1,'811add8f-5f9c-4412-9a6c-c376fe03d37e','2015-03-15 16:47:29','9999-12-31 00:00:00','1'),(395,1,'09a355b1-3433-4859-87c6-fec36e2117c4','2015-03-15 16:52:16','9999-12-31 00:00:00','1'),(396,1,'0801dfcf-288d-450f-a9e6-121f80c5fe1e','2015-03-15 17:44:52','9999-12-31 00:00:00','1'),(397,1,'7461e2d4-ff78-4c1c-baa0-3977cecfbb46','2015-03-17 07:56:22','9999-12-31 00:00:00','1'),(398,1,'f200f311-6cf9-4fd0-a090-53fa7b50f2e2','2015-03-23 07:51:11','9999-12-31 00:00:00','1'),(399,1,'799d7a1f-8b84-4e7b-9b52-8a1c23617a95','2015-03-23 08:15:08','9999-12-31 00:00:00','1'),(400,1,'d56ae9b1-c74c-4110-b039-6ba6665b115f','2015-03-23 08:22:19','9999-12-31 00:00:00','1'),(401,1,'a7ffe6ce-6f13-42dd-9827-77b0a64947ba','2015-03-23 20:49:34','9999-12-31 00:00:00','1'),(402,1,'666c1a05-45f8-405d-9c36-92e6cc12ecf5','2015-03-23 22:12:27','9999-12-31 00:00:00','1'),(403,1,'5b161e92-0037-4c18-8507-44376bb5a342','2015-03-24 00:58:15','9999-12-31 00:00:00','1'),(404,1,'ce5e3aa7-2579-47b6-957c-504ff36b5d2e','2015-03-24 01:42:11','9999-12-31 00:00:00','1'),(405,1,'d8afef39-ba3c-48c7-9616-1f7aedb6fbb2','2015-03-24 02:12:12','9999-12-31 00:00:00','1'),(406,1,'06be47f1-b98b-42be-bcda-2a3264236ae5','2015-03-24 19:49:13','9999-12-31 00:00:00','1'),(407,1,'beb2afb2-ad04-4c12-8f7e-2fb33ddcaa9e','2015-03-24 20:27:48','9999-12-31 00:00:00','1'),(408,1,'93ca17e4-7ae5-452d-a828-55e1c0035925','2015-03-24 20:30:21','9999-12-31 00:00:00','1'),(409,1,'622b4eae-5f27-4049-9e76-250d0b904107','2015-03-24 20:33:23','9999-12-31 00:00:00','1'),(410,1,'f5a19ac2-73d0-4dce-9dbd-4e22844732be','2015-03-24 20:38:17','9999-12-31 00:00:00','1'),(411,1,'9feacc56-cfbd-4c4f-ac85-5f2c1bf77166','2015-03-24 22:05:37','9999-12-31 00:00:00','1'),(413,1,'748e2eea-5c42-4968-978b-49e04a5ada32','2015-03-24 22:27:10','9999-12-31 00:00:00','1'),(414,1,'fe64c580-8e61-4047-b272-20e7fc14b431','2015-03-25 20:11:30','9999-12-31 00:00:00','0'),(415,1,'37d28821-f314-4bdd-beee-ffd1a066d009','2015-03-27 15:04:23','9999-12-31 00:00:00','0'),(416,1,'0b216e85-efff-4824-87cd-bb72a4ea3d98','2015-03-27 16:40:38','9999-12-31 00:00:00','0'),(417,1,'c2449f92-fc55-441b-8b80-b2af8b66b6da','2015-03-28 19:20:49','9999-12-31 00:00:00','0'),(418,1,'602a03e8-299d-4f0a-93f8-a2108a7bf84c','2015-03-28 22:12:32','9999-12-31 00:00:00','0'),(419,1,'1c85b4c0-3b5e-409c-a7d4-7e2dd81b4551','2015-03-28 22:22:36','9999-12-31 00:00:00','0'),(420,1,'ca8d5a32-5546-4573-80b4-2fedfafc7f5d','2015-03-28 22:24:44','9999-12-31 00:00:00','0'),(421,1,'ffb70649-32dc-45b1-a54b-ce22d720e282','2015-03-28 22:25:06','9999-12-31 00:00:00','0'),(422,1,'932dd069-33a9-4f49-984a-babe7d8f9fa0','2015-03-29 21:27:48','9999-12-31 00:00:00','0'),(423,1,'75923a15-8c3b-480b-9b94-772f40fbdb6d','2015-03-29 21:44:35','9999-12-31 00:00:00','0'),(424,1,'e6dcdc1e-2e56-4f8d-8324-a9008c219a23','2015-03-29 21:49:27','9999-12-31 00:00:00','0'),(425,1,'2f513ada-4fdf-4e94-b5c9-437ec0467589','2015-03-29 21:52:26','9999-12-31 00:00:00','0'),(426,1,'cf2a5e2f-a110-468e-9316-692e81214dd2','2015-03-29 22:12:32','9999-12-31 00:00:00','0'),(427,1,'bbb9b3d7-35ad-4b2e-96f8-15824d57b053','2015-03-29 22:21:49','9999-12-31 00:00:00','0'),(428,1,'78cdcc50-f062-476d-a2e7-4999328cb4ad','2015-03-29 22:27:38','9999-12-31 00:00:00','0'),(429,1,'a0bed674-fff1-406b-963c-34ee23fc8dd8','2015-03-30 21:27:09','9999-12-31 00:00:00','0'),(430,1,'5f370fc7-a665-4ecd-84a3-925018016ea3','2015-03-30 22:26:57','9999-12-31 00:00:00','0'),(431,1,'02df0d4b-ca0d-42d3-9283-342d60858839','2015-03-31 23:11:00','9999-12-31 00:00:00','0'),(432,1,'4c1dc72e-f6f0-4620-9107-2a06119328c4','2015-03-31 23:13:43','9999-12-31 00:00:00','0'),(433,1,'bc59834e-1152-44e4-9e40-91d13a55f485','2015-03-31 23:39:26','9999-12-31 00:00:00','0'),(434,1,'b589e951-50a0-476d-b024-fba6a04e9f41','2015-04-01 00:30:48','9999-12-31 00:00:00','0');

/*Table structure for table `user_type` */

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `user_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `modified_date` datetime NOT NULL,
  `modified_by` varchar(20) NOT NULL,
  `is_expired` varchar(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `user_type` */

insert  into `user_type`(`user_type_id`,`user_type`,`created_date`,`created_by`,`modified_date`,`modified_by`,`is_expired`) values (1,'USER','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM','0');

/* Trigger structure for table `dependent_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_dependentTask_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_dependentTask_add` AFTER INSERT ON `dependent_task` FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("Task ", NEW.dependent_task_id," is made dependent on task ",NEW.task_id, " by user ", NEW.created_by), 11);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("Task ", NEW.dependent_task_id," is made dependent on task ",NEW.task_id, " by user ", NEW.created_by), NEW.created_by, 11);
END */$$


DELIMITER ;

/* Trigger structure for table `planned_actuals_cost` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_plannedActualCost_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_plannedActualCost_add` AFTER INSERT ON `planned_actuals_cost` FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New planned cost added for task ", NEW.task_id, " by user ", NEW.created_by), 6);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New planned cost added for task ", " by ", NEW.created_by, NEW.task_id), NEW.created_by, 6);
END */$$


DELIMITER ;

/* Trigger structure for table `planned_actuals_cost` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_plannedActualCost_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_plannedActualCost_update` AFTER UPDATE ON `planned_actuals_cost` FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("planned cost updated for task ", NEW.task_id, " by user ", NEW.modified_by), 7);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("planned cost updated for task ", NEW.task_id, " by ", NEW.modified_by), NEW.modified_by, 7);
END */$$


DELIMITER ;

/* Trigger structure for table `project` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_project_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_project_add` AFTER INSERT ON `project` FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New project ", NEW.project_id, " of type", New.project_category_id , " added by ", NEW.project_owner_id), 2);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New project ", NEW.project_id, " of type", New.project_category_id , " added by ", NEW.project_owner_id), NEW.project_owner_id, 2);
END */$$


DELIMITER ;

/* Trigger structure for table `project` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_project_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_project_update` AFTER UPDATE ON `project` FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("project ", NEW.project_id, " updated by ", NEW.modified_by), 3);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("project ", NEW.project_id, " updated by ", NEW.modified_by), NEW.modified_by, 3);
END */$$


DELIMITER ;

/* Trigger structure for table `project_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_task_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_task_add` AFTER INSERT ON `project_task` FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New task ", NEW.title, " of id ", New.project_task_id , " added by ", NEW.created_by), 4);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New task ", NEW.title, " of id ", New.project_task_id , " added by ", NEW.created_by), NEW.created_by, 4);
END */$$


DELIMITER ;

/* Trigger structure for table `project_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_task_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_task_update` AFTER UPDATE ON `project_task` FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("task ", NEW.title, " of id ", New.project_task_id , " updated by ", NEW.modified_by), 5);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("task ", NEW.title, " of id ", New.project_task_id , " updated by ", NEW.modified_by), NEW.created_by, 5);
END */$$


DELIMITER ;

/* Trigger structure for table `project_task_comments` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_comment_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_comment_add` AFTER INSERT ON `project_task_comments` FOR EACH ROW BEGIN
  INSERT INTO user_notification (text, user_id, category) VALUES
    (CONCAT("Comment ", NEW.comment, " added on task ", NEW.project_task_id, " by ", NEW.comment_by), NEW.comment_by,
     1);
  INSERT INTO activity_log (text, user_id, category) VALUES
    (CONCAT("Comment ", NEW.comment, " added on task ", NEW.project_task_id), NEW.comment_by,
     1);
END */$$


DELIMITER ;

/* Trigger structure for table `project_task_files` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_projectTaskFile_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_projectTaskFile_add` AFTER INSERT ON `project_task_files` FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New file ", NEW.file_name," uploaded for task ",NEW.project_task_id, " by user ", NEW.created_by), 10);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New file ", NEW.file_name," uploaded for task ",NEW.project_task_id, " by user ", NEW.created_by), NEW.created_by, 10);
END */$$


DELIMITER ;

/* Trigger structure for table `task_assignee` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_taskAssignee_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_taskAssignee_add` AFTER INSERT ON `task_assignee` FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New assignee ", NEW.task_assignee," added for task ",NEW.project_task_id), 9);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New assignee ", NEW.task_assignee," added for task ",NEW.task_assignee), NEW.task_assignee, 9);
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
