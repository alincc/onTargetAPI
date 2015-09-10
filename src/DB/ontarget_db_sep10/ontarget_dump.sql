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

/*Data for the table `accident_report` */

insert  into `accident_report`(`accident_report_id`,`project_id`,`submitted_to`,`supervisor_name`,`witness`,`location`,`brief_of_accident`,`severity`,`description`,`body_part_affected`,`date_of_accident`,`time_of_accident`,`injured_visited_doctor`,`workers_compensation_filed`,`injured_left_job`,`date_injured_left_job`,`time_injured_left_job`,`possible_preventive_measures`,`unsafe_conditions_corrected`,`correction_measures_performed`,`correction_measures_to_be_performed`) values (1,1,'Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','2015-03-13','12345','YES','YES','YES','2015-03-13','Test Value','Test Value','YES','Test Value','Test Value'),(2,1,'1177202090','1177202090','1177202090','np','brief','High','desc','desc','2015-03-13','2015-03-28T18:15:00.000Z','NO','NO','NO',NULL,NULL,'hey','YES','hey hey',NULL),(3,1,'Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Test ','2015-03-13','2015-03-13','T','Te','T','2015-03-13','T','Test','Y','Y','Y'),(4,1,'Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Test Value','Y','2015-03-10','12345','Y','Y','Y','2015-03-10','Te','Tes','Y','Y','Tes'),(5,1,'1177202090','1177202090','1177202090','NP','test','High','test','test','2015-03-30','2015-03-30T18:15:00.000Z','NO','NO','NO',NULL,NULL,'test','NO',NULL,'test'),(6,1,'1','1','1','ktm','test','High','test','test','2015-07-10','2015-07-30T18:15:00.000Z','NO','NO','NO','2015-07-22','2015-07-23T18:15:00.000Z','test','NO',NULL,'test'),(7,1,'1','1','1','ktm','test','High','test','test','2015-07-10','2015-07-30T18:15:00.000Z','NO','NO','NO','2015-07-22','2015-07-23T18:15:00.000Z','test','NO',NULL,'test'),(8,1,'1','1','1','ktm','test','High','test','test','2015-07-10','2015-07-30T18:15:00.000Z','NO','NO','NO','2015-07-22','2015-07-23T18:15:00.000Z','test','NO',NULL,'test');

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
  `category` bigint(20) DEFAULT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `project_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_csf0njobhrvcaaryhn9ya8vje` (`user_id`),
  CONSTRAINT `FK_csf0njobhrvcaaryhn9ya8vje` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=latin1;

/*Data for the table `activity_log` */

insert  into `activity_log`(`id`,`text`,`category`,`ts_insert`,`project_id`,`user_id`) values (1,'Project project7 updated by Sanjeev Ghimire',2,'2015-07-10 20:17:34',12,1),(2,'New Project project8 added by Sanjeev Ghimire',2,'2015-07-10 20:18:15',13,1),(3,'Project project8 updated by Sanjeev Ghimire',2,'2015-07-10 20:18:33',13,1),(4,'Activity activity1 updated by Sanjeev Ghimire',2,'2015-07-10 20:19:16',4,1),(5,'New Project project9 added by Sanjeev Ghimire',2,'2015-07-10 20:41:14',14,1),(6,'New Project project10 added by Sanjeev Ghimire',2,'2015-07-10 21:10:04',15,1),(7,'New Project project11 added by Sanjeev Ghimire',2,'2015-07-10 21:17:04',16,1),(8,'Project project6 updated by Sanjeev Ghimire',2,'2015-07-10 21:18:52',9,1),(10,'Project project11 updated by Sanjeev Ghimire',2,'2015-07-10 21:26:55',16,1),(11,'Project project11 updated by Sanjeev Ghimire',2,'2015-07-10 21:27:01',16,1),(12,'New Project project12 added by Sanjeev Ghimire',2,'2015-07-10 21:33:00',17,1),(13,'New Project project13 added by Sanjeev Ghimire',2,'2015-07-10 21:41:23',18,1),(14,'Planned cost updated for task activity1 task1',7,'2015-07-11 08:29:29',NULL,1),(15,'Planned cost updated for task activity1 task1',7,'2015-07-11 08:29:30',NULL,1),(16,'New file 3d-building-construction-image_1600x1200_78628.jpg uploaded for task activity1 task1',10,'2015-07-12 18:58:22',NULL,1),(17,'New file 3d-building-construction-image_1600x1200_78628.jpg uploaded for task activity1 task1',10,'2015-07-12 18:58:27',NULL,1),(18,'New file 1.jpg uploaded for task activity1 task1',10,'2015-07-12 18:59:00',NULL,1),(19,'New file 1.jpg uploaded for task activity1 task1',10,'2015-07-12 18:59:42',NULL,1),(20,'New file 3d-building-construction-image_1600x1200_78628.jpg uploaded for task activity1 task1',10,'2015-07-12 19:45:57',NULL,1),(21,'New file 1111.jpeg uploaded for task activity1 task1',10,'2015-07-13 08:28:18',NULL,1),(22,'New file 1.jpg uploaded for task activity1 task1',10,'2015-07-13 08:30:02',NULL,1),(23,'New file office.jpg uploaded for task activity1 task1',10,'2015-07-13 08:30:26',NULL,1),(24,'New file const3.jpeg uploaded for task activity1 task1',10,'2015-07-16 22:36:27',NULL,1),(25,'New file 1.jpg uploaded for task activity1 task1',10,'2015-07-16 22:42:04',NULL,1),(30,'New Activity activity1 added by Sanjeev Ghimire',2,'2015-07-18 10:19:41',21,1),(31,'New task task1 added by Sanjeev Ghimire',4,'2015-07-18 10:19:41',NULL,1),(32,'New planned cost added for task task1',6,'2015-07-18 10:19:41',NULL,1),(33,'New planned cost added for task task1',6,'2015-07-18 10:19:41',NULL,1),(34,'New Activity activity11 added by Sanjeev Ghimire',2,'2015-07-18 10:28:34',22,1),(35,'New task task1 added by Sanjeev Ghimire',4,'2015-07-18 10:28:34',NULL,1),(36,'New planned cost added for task task1',6,'2015-07-18 10:28:34',NULL,1),(37,'New planned cost added for task task1',6,'2015-07-18 10:28:34',NULL,1),(38,'New Activity activity1 added by Sanjeev Ghimire',2,'2015-07-18 10:33:35',23,1),(39,'New task task1 added by Sanjeev Ghimire',4,'2015-07-18 10:33:36',NULL,1),(40,'New planned cost added for task task1',6,'2015-07-18 10:33:36',NULL,1),(41,'New planned cost added for task task1',6,'2015-07-18 10:33:36',NULL,1),(42,'New task task2 added by Sanjeev Ghimire',4,'2015-07-18 10:33:36',NULL,1),(43,'New planned cost added for task task2',6,'2015-07-18 10:33:36',NULL,1),(44,'New planned cost added for task task2',6,'2015-07-18 10:33:36',NULL,1),(45,'New Activity activity3 added by Sanjeev Ghimire',2,'2015-07-18 10:33:36',24,1),(46,'New task task3 added by Sanjeev Ghimire',4,'2015-07-18 10:33:36',NULL,1),(47,'New planned cost added for task task3',6,'2015-07-18 10:33:36',NULL,1),(48,'New planned cost added for task task3',6,'2015-07-18 10:33:36',NULL,1),(49,'New Activity activity4 added by Sanjeev Ghimire',2,'2015-07-18 10:33:36',25,1),(50,'New task task4 added by Sanjeev Ghimire',4,'2015-07-18 10:33:36',NULL,1),(51,'New planned cost added for task task4',6,'2015-07-18 10:33:36',NULL,1),(52,'New planned cost added for task task4',6,'2015-07-18 10:33:36',NULL,1),(53,'New task task11111221 added by Sanjeev Ghimire',4,'2015-07-18 21:56:09',NULL,1),(54,'New task task2222 added by Sanjeev Ghimire',4,'2015-07-18 21:59:52',NULL,1),(55,'New task task222211 added by Sanjeev Ghimire',4,'2015-07-18 22:01:49',NULL,1),(56,'New task task34343434 added by Sanjeev Ghimire',4,'2015-07-20 21:50:22',NULL,1),(57,'New task task32423432423 added by Sanjeev Ghimire',4,'2015-07-20 21:52:15',NULL,1),(58,'New task task342423423 added by Sanjeev Ghimire',4,'2015-07-20 21:57:17',NULL,1),(59,'New task tasdsad2312312 added by Sanjeev Ghimire',4,'2015-07-20 22:02:49',NULL,1),(60,'New task dsadasd added by Sanjeev Ghimire',4,'2015-07-20 22:14:44',NULL,1),(61,'New task ttttttt242423 added by Sanjeev Ghimire',4,'2015-07-20 22:20:55',NULL,1),(62,'New task dsadasd added by Sanjeev Ghimire',4,'2015-07-20 22:23:50',NULL,1),(63,'New planned cost added for task ttttttt242423',6,'2015-07-20 22:24:24',NULL,1),(64,'New planned cost added for task ttttttt242423',6,'2015-07-20 22:24:24',NULL,1),(65,'Planned cost updated for task ttttttt242423',7,'2015-07-20 23:06:48',NULL,1),(66,'Planned cost updated for task ttttttt242423',7,'2015-07-20 23:06:49',NULL,1),(67,'Task ttttttt242423 updated by Sanjeev Ghimire',5,'2015-07-20 23:07:15',NULL,1),(68,'Comment test added on task ttttttt242423',1,'2015-07-20 23:25:15',NULL,1),(69,'Comment s added on task activity1 task1',1,'2015-07-21 20:19:55',NULL,1),(70,'Comment test added on task activity1 task1',1,'2015-07-21 21:55:51',NULL,1),(71,'Comment abc added on task activity1 task1',1,'2015-07-21 23:16:21',NULL,1),(72,'Comment cde added on task activity1 task1',1,'2015-07-21 23:16:32',NULL,1),(73,'Activity activity1 updated by Sanjeev Ghimire',2,'2015-07-21 23:21:46',4,1),(74,'New Activity activity4 added by Sanjeev Ghimire',2,'2015-07-21 23:22:52',26,1),(75,'Activity activity4 updated by Sanjeev Ghimire',2,'2015-07-21 23:24:08',26,1),(76,'Activity activity4 updated by Sanjeev Ghimire',2,'2015-07-26 19:37:06',26,1),(77,'New Project project name added by Sanjeev Ghimire',2,'2015-07-26 19:37:50',27,1),(78,'New Activity activity name added by Sanjeev Ghimire',2,'2015-07-26 19:38:39',28,1),(79,'Activity activity name2 updated by Sanjeev Ghimire',2,'2015-07-26 19:39:16',22,1),(80,'Planned cost updated for task activity1 task1',7,'2015-07-26 19:44:55',NULL,1),(81,'New planned cost added for task activity1 task1',6,'2015-07-26 19:51:08',NULL,1),(82,'New task task1 added by Sanjeev Ghimire',4,'2015-07-26 19:53:53',NULL,1),(83,'Task task1 updated by Sanjeev Ghimire',5,'2015-07-26 20:01:53',NULL,1),(84,'Task task1 updated by Sanjeev Ghimire',5,'2015-07-26 20:05:12',NULL,1),(85,'Comment this is test comment added on task task1',1,'2015-07-26 20:05:55',NULL,1),(86,'New file sa.jpg uploaded for task task1',10,'2015-07-26 20:07:21',NULL,1),(87,'Task ttttttt242423 updated by Sanjeev Ghimire',5,'2015-07-26 20:10:16',NULL,1),(88,'New Activity activity1 added by Sanjeev Ghimire',2,'2015-07-27 22:03:06',29,1),(89,'New task task1 added by Sanjeev Ghimire',4,'2015-07-27 22:03:06',NULL,1),(90,'New planned cost added for task task1',6,'2015-07-27 22:03:07',NULL,1),(91,'New planned cost added for task task1',6,'2015-07-27 22:03:07',NULL,1),(92,'New task task225 added by Sanjeev Ghimire',4,'2015-07-27 22:46:40',NULL,1),(93,'New Activity santosh activity added by Sanjeev Ghimire',2,'2015-07-27 22:53:51',30,1),(94,'New task santosh activity task1 added by Sanjeev Ghimire',4,'2015-07-27 22:55:11',NULL,1),(95,'New Activity activity1 added by Sanjeev Ghimire',2,'2015-07-27 23:59:20',31,1),(96,'New task task1 added by Sanjeev Ghimire',4,'2015-07-27 23:59:20',NULL,1),(97,'New planned cost added for task task1',6,'2015-07-27 23:59:21',NULL,1),(98,'New planned cost added for task task1',6,'2015-07-27 23:59:21',NULL,1),(99,'New Activity activity1 added by Sanjeev Ghimire',2,'2015-07-28 00:01:09',32,1),(100,'New task task1 added by Sanjeev Ghimire',4,'2015-07-28 00:01:09',NULL,1),(101,'New planned cost added for task task1',6,'2015-07-28 00:01:09',NULL,1),(102,'New planned cost added for task task1',6,'2015-07-28 00:01:09',NULL,1),(103,'Task task1 updated by Sanjeev Ghimire',5,'2015-07-28 00:02:23',NULL,1),(104,'New Activity sa added by Santosh Pun',2,'2015-07-28 08:05:30',33,6),(105,'Project project7 updated by Sanjeev Ghimire',2,'2015-07-28 21:13:40',12,1),(108,'Activity project name updated by Sanjeev Ghimire',2,'2015-08-15 16:30:56',27,1),(111,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(112,'Task task2 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(113,'Task task5 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(114,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(115,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(116,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(117,'Task task2 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(118,'Task task3 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(119,'Task task4 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(120,'Task task11111221 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(121,'Task task2222 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(122,'Task task222211 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(123,'Task task34343434 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(124,'Task task32423432423 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(125,'Task task342423423 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(126,'Task tasdsad2312312 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(127,'Task dsadasd updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(128,'Task ttttttt242423 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(129,'Task dsadasd updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(130,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(131,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(132,'Task task225 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(133,'Task santosh activity task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(134,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(135,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:31:31',NULL,1),(136,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:11',NULL,1),(137,'Task task2 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:13',NULL,1),(138,'Task task5 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:15',NULL,1),(139,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:16',NULL,1),(140,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:17',NULL,1),(141,'Task task3 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:20',NULL,1),(142,'Task task2222 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:22',NULL,1),(143,'Task task222211 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:24',NULL,1),(144,'Task task34343434 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:25',NULL,1),(145,'Task task32423432423 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:27',NULL,1),(146,'Task task342423423 updated by Sanjeev Ghimire',5,'2015-08-21 07:51:28',NULL,1),(147,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-21 07:57:56',NULL,1),(148,'New Project projectsa1 added by Sanjeev Ghimire',2,'2015-08-22 11:55:59',34,1),(149,'New Project project22 added by Sanjeev Ghimire',2,'2015-08-22 11:57:22',35,1),(150,'New Activity activitynew1 added by Sanjeev Ghimire',2,'2015-08-23 19:22:27',38,1),(151,'New task task11new added by Sanjeev Ghimire',4,'2015-08-23 19:23:28',NULL,1),(152,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:24:08',NULL,1),(153,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:24:50',NULL,1),(154,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:25:35',NULL,1),(155,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:26:13',NULL,1),(156,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:26:20',NULL,1),(157,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:26:50',NULL,1),(158,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:27:35',NULL,1),(159,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:35:46',NULL,1),(160,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:38:04',NULL,1),(161,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:45:12',NULL,1),(162,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 09:45:23',NULL,1),(163,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 22:41:45',NULL,1),(164,'Task task1 updated by Sanjeev Ghimire',5,'2015-08-24 22:54:17',NULL,1),(165,'New Activity activity11 added by Sanjeev Ghimire',2,'2015-08-26 20:10:30',39,1),(166,'New task task1 added by Sanjeev Ghimire',4,'2015-08-26 20:10:30',NULL,1),(167,'New planned cost added for task task1',6,'2015-08-26 20:10:30',NULL,1),(168,'New planned cost added for task task1',6,'2015-08-26 20:10:30',NULL,1),(169,'Project project1 updated by Sanjeev Ghimire',2,'2015-09-05 07:34:47',2,1),(170,'Project project1 updated by Sanjeev Ghimire',2,'2015-09-05 07:35:35',2,1),(171,'New Activity activity1 added by Sanjeev Ghimire',2,'2015-09-05 07:36:00',40,1),(172,'New task task1 added by Sanjeev Ghimire',4,'2015-09-05 07:36:00',NULL,1),(173,'New planned cost added for task task1',6,'2015-09-05 07:36:01',NULL,1),(174,'New planned cost added for task task1',6,'2015-09-05 07:36:01',NULL,1);

/*Table structure for table `address` */

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

/*Data for the table `address` */

insert  into `address`(`address_id`,`address1`,`address2`,`city`,`state`,`zip`,`country`,`address_type`) values (1,'4750 59TH ST','#9C','WOODSIDE','NY','11377','USA','HOME'),(2,'NY','NY','NY','Gandaki','1001','NP','PROJECT'),(3,'NY','NY','NY','Gandaki','1001','NP','PROJECT'),(4,'NY',NULL,'NY','Gandaki','1001','NP','PROJECT'),(5,'NY',NULL,'NY','Gandaki','1001','NP','PROJECT'),(6,'NY',NULL,'NY','Gandaki','1001','NP','PROJECT'),(7,'NY',NULL,'NY','Gandaki','1001','NP','PROJECT'),(8,'NY',NULL,'NY','Gandaki','1001','NP','PROJECT'),(9,'NY',NULL,'NY','Gandaki','1001','NP','PROJECT'),(10,'ktm',NULL,'ktm','Gandaki','977','NP','PROJECT'),(11,'ktm',NULL,'ktm','Gandaki','1001','NP','PROJECT'),(12,'ktm',NULL,'ktm','Gandaki','1001','NP','PROJECT'),(13,'ktm','ktm','ktm','Gandaki','1001','NP','PROJECT'),(14,'ktm',NULL,'ktm','Gandaki','1001','NP','PROJECT'),(15,'ktm',NULL,'ktm','Gandaki','1001','NP','PROJECT'),(16,'ktm','ktm','ktm','Gandaki','1001','NP','PROJECT'),(17,'address1','address2','city','state','zip','country','PROJECT'),(18,'addr1',NULL,'ny','Narayani','977','NP','PROJECT'),(19,'addr1','addr2','ny','Otjozondjupa','999','NA','PROJECT'),(20,'nepal',NULL,'ktm','Lumbini','977','NP','PROJECT'),(21,'nepal',NULL,'ktm','Dhawalagiri','977','NP','PROJECT');

/*Table structure for table `application_menu` */

DROP TABLE IF EXISTS `application_menu`;

CREATE TABLE `application_menu` (
  `application_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
  `menu_key` varchar(45) DEFAULT NULL,
  `menu_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`application_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `application_menu` */

insert  into `application_menu`(`application_menu_id`,`active`,`menu_key`,`menu_name`) values (1,'Y','DASHBOARD','Dashboard'),(2,'Y','ONTIME','onTime'),(3,'Y','ONSITE','onSITE'),(4,'Y','ONFILE','onFILE'),(5,'Y','ONTARGET','onTARGET'),(6,'Y','ONCONTACT','onCONTACT'),(7,'Y','ONREPORT','onREPORT');

/*Table structure for table `application_permission` */

DROP TABLE IF EXISTS `application_permission`;

CREATE TABLE `application_permission` (
  `application_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
  `permission_key` varchar(45) DEFAULT NULL,
  `permission_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`application_permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `application_permission` */

insert  into `application_permission`(`application_permission_id`,`active`,`permission_key`,`permission_name`) values (1,'Y','VIEW_DASHBOARD','View Dashboard'),(2,'Y','VIEW_ONTIME','View OnTime'),(3,'Y','EDIT_ONTIME','Edit OnTime'),(4,'Y','ADD_TASK_COMMENT','Add Task Comment'),(5,'Y','VIEW_ONSITE','View OnSite'),(6,'Y','ONSITE_UPLOAD','OnSite Upload'),(7,'Y','ONFILE_FULL_ACCESS','OnFile Full Access');

/*Table structure for table `audit_project_task` */

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `audit_project_task` */

/*Table structure for table `audit_task_percentage_log` */

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
  CONSTRAINT `FK_kv835tca9yhj3udsvda5l93bi1` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_swsutqllb00s0th0ugfxiaxb9` FOREIGN KEY (`task_id`) REFERENCES `project_task` (`project_task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `audit_task_percentage_log` */

/*Table structure for table `bulk_activity_attribute` */

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
) ENGINE=InnoDB AUTO_INCREMENT=401 DEFAULT CHARSET=latin1;

/*Data for the table `bulk_activity_attribute` */

insert  into `bulk_activity_attribute`(`id`,`attribute_key`,`attribute_value`,`valid`,`bulk_activity_log_id`,`row_index`) values (1,'activityCode','ACT-001','Y',1,'1'),(2,'activityName','activity1','Y',1,'1'),(3,'activityStartDate','17/04/2015','Y',1,'1'),(4,'activityEndDate','17/06/2015','Y',1,'1'),(5,'taskCode','TASK-001','Y',1,'1'),(6,'taskName','task1','Y',1,'1'),(7,'taskStartDate','17/04/2015','Y',1,'1'),(8,'taskEndDate','17/06/2015','Y',1,'1'),(9,'percentageComplete','20','Y',1,'1'),(10,'actualCost','500','Y',1,'1'),(11,'estimatedCost','200','Y',1,'1'),(12,'activityCode','ACT-002','Y',1,'2'),(13,'activityName','activity2','Y',1,'2'),(14,'activityStartDate','17/04/2015','Y',1,'2'),(15,'activityEndDate','17/06/2015','Y',1,'2'),(16,'taskCode','TASK-002','Y',1,'2'),(17,'taskName','task2','Y',1,'2'),(18,'taskStartDate','17/04/2015','Y',1,'2'),(19,'taskEndDate','17/06/2015','Y',1,'2'),(20,'percentageComplete','20','Y',1,'2'),(21,'actualCost','500','Y',1,'2'),(22,'estimatedCost','200','Y',1,'2'),(23,'activityCode','ACT-003','Y',1,'3'),(24,'activityName','activity3','Y',1,'3'),(25,'activityStartDate','17/04/2015','Y',1,'3'),(26,'activityEndDate','17/06/2015','Y',1,'3'),(27,'taskCode','TASK-003','Y',1,'3'),(28,'taskName','task3','Y',1,'3'),(29,'taskStartDate','17/04/2015','Y',1,'3'),(30,'taskEndDate','17/06/2015','Y',1,'3'),(31,'percentageComplete','20','Y',1,'3'),(32,'actualCost','500','Y',1,'3'),(33,'estimatedCost','200','Y',1,'3'),(48,'activityCode','ACT-001','N',4,'1'),(49,'activityName','activity1','N',4,'1'),(50,'activityStartDate','17/04/2014','N',4,'1'),(51,'activityEndDate','17/06/2014','N',4,'1'),(52,'taskCode','TASK-001','N',4,'1'),(53,'taskName','task1','N',4,'1'),(54,'taskStartDate','17/04/2015','N',4,'1'),(55,'taskEndDate','17/06/2015','N',4,'1'),(56,'percentageComplete','20','N',4,'1'),(57,'actualCost','500','N',4,'1'),(58,'estimatedCost','200','N',4,'1'),(59,'activityCode','ACT-001','Y',5,'1'),(60,'activityName','activity1','Y',5,'1'),(61,'activityStartDate','17/04/2015','Y',5,'1'),(62,'activityEndDate','17/06/2015','Y',5,'1'),(63,'taskCode','TASK-001','Y',5,'1'),(64,'taskName','task1','Y',5,'1'),(65,'taskStartDate','17/04/2015','Y',5,'1'),(66,'taskEndDate','17/06/2015','Y',5,'1'),(67,'percentageComplete','20','Y',5,'1'),(68,'actualCost','500','Y',5,'1'),(69,'estimatedCost','200','Y',5,'1'),(70,'activityCode','ACT-002','Y',5,'2'),(71,'activityName','activity2','Y',5,'2'),(72,'activityStartDate','17/04/2015','Y',5,'2'),(73,'activityEndDate','17/06/2015','Y',5,'2'),(74,'taskCode','TASK-002','Y',5,'2'),(75,'taskName','task2','Y',5,'2'),(76,'taskStartDate','17/04/2015','Y',5,'2'),(77,'taskEndDate','17/06/2015','Y',5,'2'),(78,'percentageComplete','20','Y',5,'2'),(79,'actualCost','500','Y',5,'2'),(80,'estimatedCost','200','Y',5,'2'),(81,'activityCode','ACT-003','Y',5,'3'),(82,'activityName','activity3','Y',5,'3'),(83,'activityStartDate','17/04/2015','Y',5,'3'),(84,'activityEndDate','17/06/2015','Y',5,'3'),(85,'taskCode','TASK-003','Y',5,'3'),(86,'taskName','task3','Y',5,'3'),(87,'taskStartDate','17/04/2015','Y',5,'3'),(88,'taskEndDate','17/06/2015','Y',5,'3'),(89,'percentageComplete','20','Y',5,'3'),(90,'actualCost','500','Y',5,'3'),(91,'estimatedCost','200','Y',5,'3'),(92,'activityCode','ACT-001','Y',6,'1'),(93,'activityName','activity1','Y',6,'1'),(94,'activityStartDate','17/04/2015','Y',6,'1'),(95,'activityEndDate','17/06/2015','Y',6,'1'),(96,'taskCode','TASK-001','Y',6,'1'),(97,'taskName','task1','Y',6,'1'),(98,'taskStartDate','17/04/2015','Y',6,'1'),(99,'taskEndDate','17/06/2015','Y',6,'1'),(100,'percentageComplete','20','Y',6,'1'),(101,'actualCost','500','Y',6,'1'),(102,'estimatedCost','200','Y',6,'1'),(103,'activityCode','ACT-001','Y',7,'1'),(104,'activityName','activity1','Y',7,'1'),(105,'activityStartDate','17/04/2015','Y',7,'1'),(106,'activityEndDate','17/06/2015','Y',7,'1'),(107,'taskCode','TASK-001','Y',7,'1'),(108,'taskName','task1','Y',7,'1'),(109,'taskStartDate','17/04/2015','Y',7,'1'),(110,'taskEndDate','17/06/2015','Y',7,'1'),(111,'percentageComplete','20','Y',7,'1'),(112,'actualCost','500','Y',7,'1'),(113,'estimatedCost','200','Y',7,'1'),(114,'activityCode','ACT-001','N',8,'1'),(115,'activityName','activity1','N',8,'1'),(116,'activityStartDate','17/04/2015','N',8,'1'),(117,'activityEndDate','17/06/2015','N',8,'1'),(118,'taskCode','TASK-001','N',8,'1'),(119,'taskName','task1','N',8,'1'),(120,'taskStartDate','17/04/2015','N',8,'1'),(121,'taskEndDate','17/06/2015','N',8,'1'),(122,'percentageComplete','20','N',8,'1'),(123,'actualCost','500','N',8,'1'),(124,'estimatedCost','200','N',8,'1'),(125,'activityCode','ACT-001','Y',11,'1'),(126,'activityName','activity1','Y',11,'1'),(127,'activityStartDate','17/04/2015','Y',11,'1'),(128,'activityEndDate','17/06/2015','Y',11,'1'),(129,'taskCode','TASK-001','Y',11,'1'),(130,'taskName','task1','Y',11,'1'),(131,'taskStartDate','17/04/2015','Y',11,'1'),(132,'taskEndDate','17/06/2015','Y',11,'1'),(133,'percentageComplete','20','Y',11,'1'),(134,'actualCost','500','Y',11,'1'),(135,'estimatedCost','200','Y',11,'1'),(136,'activityCode','ACT-001','N',12,'1'),(137,'activityName','activity1','N',12,'1'),(138,'activityStartDate','17/04/2015','N',12,'1'),(139,'activityEndDate','17/06/2015','N',12,'1'),(140,'taskCode','TASK-001','N',12,'1'),(141,'taskName','task1','N',12,'1'),(142,'taskStartDate','17/04/2015','N',12,'1'),(143,'taskEndDate','17/06/2015','N',12,'1'),(144,'percentageComplete','20','N',12,'1'),(145,'actualCost','500','N',12,'1'),(146,'estimatedCost','200','N',12,'1'),(147,'activityCode','ACT-001','N',13,'1'),(148,'activityName','activity1','N',13,'1'),(149,'activityStartDate','17/04/2015','N',13,'1'),(150,'activityEndDate','17/01/2015','N',13,'1'),(151,'taskCode','TASK-001','N',13,'1'),(152,'taskName','task1','N',13,'1'),(153,'taskStartDate','17/04/2015','N',13,'1'),(154,'taskEndDate','17/06/2015','N',13,'1'),(155,'percentageComplete','20','N',13,'1'),(156,'actualCost','500','N',13,'1'),(157,'estimatedCost','200','N',13,'1'),(158,'activityCode','ACT-005','Y',14,'1'),(159,'activityName','activity11','Y',14,'1'),(160,'activityStartDate','17/04/2015','Y',14,'1'),(161,'activityEndDate','17/09/2015','Y',14,'1'),(162,'taskCode','TASK-001','Y',14,'1'),(163,'taskName','task1','Y',14,'1'),(164,'taskStartDate','17/04/2015','Y',14,'1'),(165,'taskEndDate','17/06/2015','Y',14,'1'),(166,'percentageComplete','20','Y',14,'1'),(167,'actualCost','500','Y',14,'1'),(168,'estimatedCost','200','Y',14,'1'),(169,'activityCode','ACT-001','Y',15,'1'),(170,'activityName','activity1','Y',15,'1'),(171,'activityStartDate','17/04/2015','Y',15,'1'),(172,'activityEndDate','17/06/2015','Y',15,'1'),(173,'taskCode','TASK-001','Y',15,'1'),(174,'taskName','task1','Y',15,'1'),(175,'taskStartDate','17/04/2015','Y',15,'1'),(176,'taskEndDate','17/06/2015','Y',15,'1'),(177,'percentageComplete','20','Y',15,'1'),(178,'actualCost','500','Y',15,'1'),(179,'estimatedCost','200','Y',15,'1'),(180,'activityCode','ACT-001','Y',15,'2'),(181,'activityName','activity1','Y',15,'2'),(182,'activityStartDate','17/04/2015','Y',15,'2'),(183,'activityEndDate','17/06/2015','Y',15,'2'),(184,'taskCode','TASK-002','Y',15,'2'),(185,'taskName','task2','Y',15,'2'),(186,'taskStartDate','17/04/2015','Y',15,'2'),(187,'taskEndDate','17/06/2015','Y',15,'2'),(188,'percentageComplete','20','Y',15,'2'),(189,'actualCost','500','Y',15,'2'),(190,'estimatedCost','200','Y',15,'2'),(191,'activityCode','ACT-003','Y',15,'3'),(192,'activityName','activity3','Y',15,'3'),(193,'activityStartDate','17/04/2015','Y',15,'3'),(194,'activityEndDate','17/06/2015','Y',15,'3'),(195,'taskCode','TASK-003','Y',15,'3'),(196,'taskName','task3','Y',15,'3'),(197,'taskStartDate','17/04/2015','Y',15,'3'),(198,'taskEndDate','17/06/2015','Y',15,'3'),(199,'percentageComplete','20','Y',15,'3'),(200,'actualCost','500','Y',15,'3'),(201,'estimatedCost','200','Y',15,'3'),(202,'activityCode','ACT-004','Y',15,'4'),(203,'activityName','activity4','Y',15,'4'),(204,'activityStartDate','17/04/2015','Y',15,'4'),(205,'activityEndDate','17/06/2015','Y',15,'4'),(206,'taskCode','TASK-004','Y',15,'4'),(207,'taskName','task4','Y',15,'4'),(208,'taskStartDate','17/04/2015','Y',15,'4'),(209,'taskEndDate','17/06/2015','Y',15,'4'),(210,'percentageComplete','20','Y',15,'4'),(211,'actualCost','500','Y',15,'4'),(212,'estimatedCost','200','Y',15,'4'),(213,'activityCode','ACT-001','N',16,'1'),(214,'activityName','activity1','N',16,'1'),(215,'activityStartDate','17/04/2015','N',16,'1'),(216,'activityEndDate','17/06/2015','N',16,'1'),(217,'taskCode','TASK-001','N',16,'1'),(218,'taskName','task1','N',16,'1'),(219,'taskStartDate','17/04/2015','N',16,'1'),(220,'taskEndDate','17/06/2015','N',16,'1'),(221,'percentageComplete','20','N',16,'1'),(222,'actualCost','500','N',16,'1'),(223,'estimatedCost','200','N',16,'1'),(224,'activityCode','ACT-001','N',16,'2'),(225,'activityName','activity1','N',16,'2'),(226,'activityStartDate','17/04/2015','N',16,'2'),(227,'activityEndDate','17/06/2015','N',16,'2'),(228,'taskCode','TASK-002','N',16,'2'),(229,'taskName','task2','N',16,'2'),(230,'taskStartDate','17/04/2015','N',16,'2'),(231,'taskEndDate','17/06/2015','N',16,'2'),(232,'percentageComplete','20','N',16,'2'),(233,'actualCost','500','N',16,'2'),(234,'estimatedCost','200','N',16,'2'),(235,'activityCode','ACT-003','N',16,'3'),(236,'activityName','activity3','N',16,'3'),(237,'activityStartDate','17/04/2015','N',16,'3'),(238,'activityEndDate','17/06/2015','N',16,'3'),(239,'taskCode','TASK-003','N',16,'3'),(240,'taskName','task3','N',16,'3'),(241,'taskStartDate','17/04/2015','N',16,'3'),(242,'taskEndDate','17/06/2015','N',16,'3'),(243,'percentageComplete','20','N',16,'3'),(244,'actualCost','500','N',16,'3'),(245,'estimatedCost','200','N',16,'3'),(246,'activityCode','ACT-004','N',16,'4'),(247,'activityName','activity4','N',16,'4'),(248,'activityStartDate','17/04/2015','N',16,'4'),(249,'activityEndDate','17/06/2015','N',16,'4'),(250,'taskCode','TASK-004','N',16,'4'),(251,'taskName','task4','N',16,'4'),(252,'taskStartDate','17/04/2015','N',16,'4'),(253,'taskEndDate','17/06/2015','N',16,'4'),(254,'percentageComplete','20','N',16,'4'),(255,'actualCost','500','N',16,'4'),(256,'estimatedCost','200','N',16,'4'),(257,'activityCode','ACT-001','N',17,'1'),(258,'activityName','activity1','N',17,'1'),(259,'activityStartDate','17/04/2015','N',17,'1'),(260,'activityEndDate','17/06/2015','N',17,'1'),(261,'taskCode','TASK-001','N',17,'1'),(262,'taskName','task1','N',17,'1'),(263,'taskDescription','task desc1','N',17,'1'),(264,'taskStartDate','17/04/2015','N',17,'1'),(265,'taskEndDate','17/06/2015','N',17,'1'),(266,'percentageComplete','20','N',17,'1'),(267,'actualCost','500','N',17,'1'),(268,'estimatedCost','200','N',17,'1'),(269,'activityCode','ACT-001','Y',18,'1'),(270,'activityName','activity1','Y',18,'1'),(271,'activityStartDate','17/06/2015','Y',18,'1'),(272,'activityEndDate','22/06/2015','Y',18,'1'),(273,'taskCode','TASK-001','Y',18,'1'),(274,'taskName','task1','Y',18,'1'),(275,'taskDescription','task desc1','Y',18,'1'),(276,'taskStartDate','17/06/2015','Y',18,'1'),(277,'taskEndDate','12/06/2015','Y',18,'1'),(278,'percentageComplete','20','Y',18,'1'),(279,'actualCost','500','Y',18,'1'),(280,'estimatedCost','200','Y',18,'1'),(281,'activityCode','ACT-001','N',19,'1'),(282,'activityName','activity1','N',19,'1'),(283,'activityStartDate','17/04/2015','N',19,'1'),(284,'activityEndDate','17/06/2015','N',19,'1'),(285,'taskCode','TASK-001','N',19,'1'),(286,'taskName','task1','N',19,'1'),(287,'taskDescription','task desc1','N',19,'1'),(288,'taskStartDate','17/04/2015','N',19,'1'),(289,'taskEndDate','17/06/2015','N',19,'1'),(290,'percentageComplete','20','N',19,'1'),(291,'actualCost','500','N',19,'1'),(292,'estimatedCost','200','N',19,'1'),(293,'activityCode','ACT-001','Y',20,'1'),(294,'activityName','activity1','Y',20,'1'),(295,'activityStartDate','17/06/2015','Y',20,'1'),(296,'activityEndDate','22/06/2015','Y',20,'1'),(297,'taskCode','TASK-001','Y',20,'1'),(298,'taskName','task1','Y',20,'1'),(299,'taskDescription','task desc1','Y',20,'1'),(300,'taskStartDate','17/06/2015','Y',20,'1'),(301,'taskEndDate','22/06/2015','Y',20,'1'),(302,'percentageComplete','20','Y',20,'1'),(303,'actualCost','500','Y',20,'1'),(304,'estimatedCost','200','Y',20,'1'),(305,'activityCode','ACT-001','Y',21,'1'),(306,'activityName','activity1','Y',21,'1'),(307,'activityStartDate','17/06/2015','Y',21,'1'),(308,'activityEndDate','22/06/2015','Y',21,'1'),(309,'taskCode','TASK-001','Y',21,'1'),(310,'taskName','task1','Y',21,'1'),(311,'taskDescription','','Y',21,'1'),(312,'taskStartDate','17/06/2015','Y',21,'1'),(313,'taskEndDate','22/06/2015','Y',21,'1'),(314,'percentageComplete','20','Y',21,'1'),(315,'actualCost','500','Y',21,'1'),(316,'estimatedCost','200','Y',21,'1'),(317,'activityCode','ACT-005','Y',22,'1'),(318,'activityName','activity11','Y',22,'1'),(319,'activityStartDate','27/07/2015','Y',22,'1'),(320,'activityEndDate','27/08/2015','Y',22,'1'),(321,'taskCode','TASK-001','Y',22,'1'),(322,'taskName','task1','Y',22,'1'),(323,'taskDescription','task1','Y',22,'1'),(324,'taskStartDate','28/07/2015','Y',22,'1'),(325,'taskEndDate','30/07/2015','Y',22,'1'),(326,'percentageComplete','40','Y',22,'1'),(327,'actualCost','500','Y',22,'1'),(328,'estimatedCost','200','Y',22,'1'),(353,'activityCode','ACT-001','N',27,'1'),(354,'activityName','activity1','N',27,'1'),(355,'activityStartDate','17/06/2015','N',27,'1'),(356,'activityEndDate','22/10/2015','N',27,'1'),(357,'taskCode','TASK-001','N',27,'1'),(358,'taskName','task1','N',27,'1'),(359,'taskDescription','','N',27,'1'),(360,'taskStartDate','17/06/2015','N',27,'1'),(361,'taskEndDate','22/09/2015','N',27,'1'),(362,'percentageComplete','20','N',27,'1'),(363,'actualCost','500','N',27,'1'),(364,'estimatedCost','200','N',27,'1'),(365,'activityCode','ACT-001','N',28,'1'),(366,'activityName','activity1','N',28,'1'),(367,'activityStartDate','06/17/2015','N',28,'1'),(368,'activityEndDate','10/22/2015','N',28,'1'),(369,'taskCode','TASK-001','N',28,'1'),(370,'taskName','task1','N',28,'1'),(371,'taskDescription','','N',28,'1'),(372,'taskStartDate','06/17/2015','N',28,'1'),(373,'taskEndDate','09/22/2015','N',28,'1'),(374,'percentageComplete','20','N',28,'1'),(375,'actualCost','500','N',28,'1'),(376,'estimatedCost','200','N',28,'1'),(377,'activityCode','ACT-001','N',29,'1'),(378,'activityName','activity1','N',29,'1'),(379,'activityStartDate','06/17/2015','N',29,'1'),(380,'activityEndDate','10/22/2015','N',29,'1'),(381,'taskCode','TASK-001','N',29,'1'),(382,'taskName','task1','N',29,'1'),(383,'taskDescription','','N',29,'1'),(384,'taskStartDate','06/17/2015','N',29,'1'),(385,'taskEndDate','09/22/2015','N',29,'1'),(386,'percentageComplete','20','N',29,'1'),(387,'actualCost','500','N',29,'1'),(388,'estimatedCost','200','N',29,'1'),(389,'activityCode','ACT-001','Y',30,'1'),(390,'activityName','activity1','Y',30,'1'),(391,'activityStartDate','06/17/2015','Y',30,'1'),(392,'activityEndDate','10/22/2015','Y',30,'1'),(393,'taskCode','TASK-001','Y',30,'1'),(394,'taskName','task1','Y',30,'1'),(395,'taskDescription','','Y',30,'1'),(396,'taskStartDate','06/17/2015','Y',30,'1'),(397,'taskEndDate','09/22/2015','Y',30,'1'),(398,'percentageComplete','20','Y',30,'1'),(399,'actualCost','500','Y',30,'1'),(400,'estimatedCost','200','Y',30,'1');

/*Table structure for table `bulk_activity_log` */

DROP TABLE IF EXISTS `bulk_activity_log`;

CREATE TABLE `bulk_activity_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) NOT NULL,
  `uploaded_date` datetime DEFAULT NULL,
  `uploaded_by` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bfmddopkaobsub4cvy7ggq589` (`uploaded_by`),
  CONSTRAINT `FK_bfmddopkaobsub4cvy7ggq589` FOREIGN KEY (`uploaded_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

/*Data for the table `bulk_activity_log` */

insert  into `bulk_activity_log`(`id`,`file_name`,`uploaded_date`,`uploaded_by`) values (1,'Onfile.xls','2015-04-18 18:12:53',1),(4,'Onfile.xls','2015-04-18 18:20:56',1),(5,'Onfile.xls','2015-04-18 18:23:13',1),(6,'Onfile.xls','2015-05-01 15:18:15',1),(7,'Onfile.xls','2015-05-01 15:18:44',1),(8,'Onfile.xls','2015-07-18 10:11:56',1),(11,'Onfile.xls','2015-07-18 10:19:40',1),(12,'Onfile.xls','2015-07-18 10:23:12',1),(13,'Onfile.xls','2015-07-18 10:24:05',1),(14,'Onfile.xls','2015-07-18 10:28:34',1),(15,'Onfile.xls','2015-07-18 10:33:35',1),(16,'Onfile.xls','2015-07-26 20:11:11',1),(17,'Onfile.xls','2015-07-27 21:58:02',1),(18,'Onfile.xls','2015-07-27 22:03:06',1),(19,'Onfile.xls','2015-07-27 23:57:43',1),(20,'Onfile.xls','2015-07-27 23:59:20',1),(21,'Onfile.xls','2015-07-28 00:01:09',1),(22,'onTime-reformatted.xlsx','2015-08-26 20:10:29',1),(27,'Onfile.xls','2015-09-05 07:33:20',1),(28,'Onfile.xls','2015-09-05 07:34:36',1),(29,'Onfile.xls','2015-09-05 07:35:14',1),(30,'Onfile.xls','2015-09-05 07:36:00',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `company_info` */

insert  into `company_info`(`company_id`,`company_name`,`company_type_id`,`address1`,`address2`,`city`,`state`,`zipcode`,`country`,`status`,`website`) values (1,'SIMON AND BARRON WEA RESIDENTIAL',1,'363 23rd st','Suite 2098','New York','NY','10001','USA','ACTIVE','http://www.ttg.com'),(2,'Santosh Company',1,'NY',NULL,'NY','Gandaki','1001','NP','ACTIVE',NULL),(3,'scompany',1,'nepal',NULL,'ktm','Lumbini','977','NP','ACTIVE',NULL),(4,'pkcompany',1,'nepal',NULL,'ktm','Dhawalagiri','977','NP','ACTIVE',NULL);

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

/*Data for the table `contact` */

insert  into `contact`(`contact_id`,`user_id`,`contact_company_id`,`title`,`first_name`,`last_name`,`address_id`,`date_of_birth`,`contact_method`,`created_date`,`created_by`,`modified_date`,`modified_by`,`contact_status`,`contact_image`) values (1,1,1,'Er','Sanjeev','Ghimire',1,'2015-05-03',NULL,'2015-05-03 17:32:14',1,NULL,NULL,'ACTIVE','assets/profile/1111111.jpeg'),(2,2,1,'Mr','Santosh','Pun',NULL,NULL,NULL,'2015-06-27 19:01:22',2,NULL,NULL,'ACTIVE','assets/profile/const2.jpg'),(3,3,1,'Mr','Basanta','Rijal',NULL,NULL,NULL,'2015-06-27 22:18:52',3,NULL,NULL,'ACTIVE','assets/profile/a1.jpeg'),(4,4,2,'Mr','Ashish','Khanal',NULL,NULL,NULL,'2015-06-27 22:24:27',4,NULL,NULL,'ACTIVE','assets/profile/1711016_f260.jpg'),(5,6,1,'Mr','Niran','Shrestha',NULL,NULL,NULL,'2015-07-26 23:51:25',6,NULL,NULL,'ACTIVE','assets/profile/1111.jpeg'),(6,7,3,'Mr','Santosh','Pun',NULL,NULL,NULL,'2015-08-23 19:04:15',7,NULL,NULL,'ACTIVE','assets/profile/hulk2.jpeg'),(7,8,4,'Mr','Santosh','Pun',NULL,NULL,NULL,'2015-08-23 19:16:06',8,NULL,NULL,'ACTIVE','assets/profile/superman1.jpeg');

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

/*Data for the table `discipline` */

insert  into `discipline`(`id`,`name`,`info`,`ts_insert`) values (1,'masonry','Masonry','2015-01-10 01:04:58'),(2,'plumbing','Plumbing','2015-01-10 01:04:58'),(3,'electrical','Electrical','2015-01-10 01:04:58'),(4,'mechanical','Mechanical','2015-01-10 01:04:58'),(5,'Interiors','Interiors','2015-01-10 01:04:58'),(6,'landscaping','Landscaping','2015-01-10 01:04:58'),(7,'bridges','Bridges','2015-01-10 01:04:58'),(8,'tunnels','Tunnels','2015-01-10 01:04:58'),(9,'design','Design','2015-01-10 01:04:58');

/*Table structure for table `document` */

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

/*Data for the table `document` */

insert  into `document`(`document_id`,`document_template_id`,`name`,`status`,`created_by`,`created_date`,`modified_by`,`modified_date`,`project_id`,`due_date`) values (4,21,'CO Document','APPROVED',1,'2015-03-14 12:53:37',1,'2015-04-11 13:26:15',1,'2015-03-13 00:00:00'),(5,20,'test doc','SUBMITTED',1,'2015-03-27 16:49:05',1,'2015-07-26 20:20:29',0,'2015-03-10 00:00:00'),(13,20,'test doc','SUBMITTED',1,'2015-03-27 17:59:38',1,'2015-03-28 19:29:35',0,'2015-03-10 00:00:00'),(14,22,'RFI Document','SUBMITTED',1,'2015-04-11 22:14:43',NULL,NULL,1,'2015-04-10 05:45:00'),(15,20,'test doc','SUBMITTED',1,'2015-07-27 00:33:11',1,'2015-07-27 00:37:35',1,'2015-07-26 00:00:00');

/*Table structure for table `document_attachment` */

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

/*Data for the table `document_attachment` */

insert  into `document_attachment`(`document_attachment_id`,`document_id`,`file_path`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,13,'/home/ontargetrs/sa.jpg',1,'2015-03-28 19:28:11',1,'2015-03-28 19:28:11'),(2,5,'/home/ontargetrs/sa.jpg',1,'2015-07-27 00:32:22',NULL,NULL);

/*Table structure for table `document_grid_key_value` */

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

/*Data for the table `document_grid_key_value` */

insert  into `document_grid_key_value`(`document_id`,`grid_id`,`grid_row_index`,`key`,`value`,`created_by`,`created_date`,`modified_by`,`modified_date`,`document_grid_key_value_id`) values (13,'C000',1,'gridkey1','gridkeyvalue',1,'2015-03-27 17:59:38',1,'2015-03-27 17:59:38',1),(14,'CO-COSTGRID',0,'workDescription','cc1',1,'2015-04-11 22:14:43',NULL,NULL,2),(14,'CO-COSTGRID',0,'costCode','ccode1',1,'2015-04-11 22:14:43',NULL,NULL,3),(14,'CO-COSTGRID',0,'amount','100',1,'2015-04-11 22:14:43',NULL,NULL,4),(14,'CO-COSTGRID',1,'workDescription','cc2',1,'2015-04-11 22:14:43',NULL,NULL,5),(14,'CO-COSTGRID',1,'costCode','ccode2',1,'2015-04-11 22:14:43',NULL,NULL,6),(14,'CO-COSTGRID',1,'amount','200',1,'2015-04-11 22:14:43',NULL,NULL,7),(15,'C000',1,'gridkey1','gridkeyvalue',1,'2015-07-27 00:33:12',1,'2015-07-27 00:37:35',8);

/*Table structure for table `document_key_value` */

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

/*Data for the table `document_key_value` */

insert  into `document_key_value`(`document_id`,`key`,`value`,`created_by`,`created_date`,`modified_by`,`modified_date`,`document_key_value_id`) values (4,'username','1177202090',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',1),(4,'company_name','1',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',2),(4,'change_order','CP-201',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',3),(4,'location','np',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',4),(4,'subject','np',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',5),(4,'description_of_scope','np',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',6),(4,'contract_no','99',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',7),(4,'contract_title','99',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',8),(4,'date_created','2015-03-13T18:15:00.000Z',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',9),(4,'priority','High',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',10),(4,'discipline','MECHANICAL',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',11),(4,'category','ERRORS',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',12),(4,'schedule_impact','YES',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',13),(4,'cost_impact','YES',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',14),(4,'time_impact','9',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',15),(4,'specification','99',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',16),(4,'drawing_no','99',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',17),(4,'cost_code','99',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',18),(4,'total_change_order_amount','99',1,'2015-03-14 12:53:37',1,'2015-03-14 12:53:37',19),(13,'name','Santosh Pun',1,'2015-03-27 17:59:38',1,'2015-03-27 17:59:38',25),(14,'username','1',1,'2015-04-11 22:14:43',NULL,NULL,26),(14,'company_name','1',1,'2015-04-11 22:14:43',NULL,NULL,27),(14,'change_order','CP-201',1,'2015-04-11 22:14:43',NULL,NULL,28),(14,'location','pkr',1,'2015-04-11 22:14:43',NULL,NULL,29),(14,'subject','subject',1,'2015-04-11 22:14:43',NULL,NULL,30),(14,'description_of_scope','scope1',1,'2015-04-11 22:14:43',NULL,NULL,31),(14,'contract_no','4342',1,'2015-04-11 22:14:43',NULL,NULL,32),(14,'contract_title','title',1,'2015-04-11 22:14:43',NULL,NULL,33),(14,'date_created','2015-04-10T18:15:00.000Z',1,'2015-04-11 22:14:43',NULL,NULL,34),(14,'priority','High',1,'2015-04-11 22:14:43',NULL,NULL,35),(14,'discipline','ELECTRICAL',1,'2015-04-11 22:14:43',NULL,NULL,36),(14,'category','ERRORS',1,'2015-04-11 22:14:43',NULL,NULL,37),(14,'schedule_impact','YES',1,'2015-04-11 22:14:43',NULL,NULL,38),(14,'cost_impact','YES',1,'2015-04-11 22:14:43',NULL,NULL,39),(14,'time_impact','y',1,'2015-04-11 22:14:43',NULL,NULL,40),(14,'specification','spec',1,'2015-04-11 22:14:43',NULL,NULL,41),(14,'drawing_no','3434',1,'2015-04-11 22:14:43',NULL,NULL,42),(14,'cost_code','cc',1,'2015-04-11 22:14:43',NULL,NULL,43),(14,'total_change_order_amount','300',1,'2015-04-11 22:14:43',NULL,NULL,44),(15,'name','Santosh Pun',1,'2015-07-27 00:33:11',1,'2015-07-27 00:37:35',45);

/*Table structure for table `document_submittal` */

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

/*Data for the table `document_submittal` */

insert  into `document_submittal`(`document_submittal_id`,`document_id`,`assignee_user_id`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,4,1,1,'2015-04-06 22:10:41',NULL,NULL),(2,14,1,1,'2015-04-11 22:14:43',NULL,NULL),(3,15,1,1,'2015-07-27 00:33:12',NULL,NULL);

/*Table structure for table `document_template` */

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

/*Data for the table `document_template` */

insert  into `document_template`(`document_template_id`,`name`,`created_by`,`created_date`,`modified_by`,`modfied_date`) values (20,'Purchase Order',0,'2015-01-10 01:04:58',0,'2015-01-10 01:04:58'),(21,'Change Order',0,'2015-01-10 01:04:58',0,'2015-01-10 01:04:58'),(22,'Request For Information',0,'2015-01-10 01:04:58',0,'2015-01-10 01:04:58'),(23,'Transmittal',0,'2015-01-10 01:04:58',0,'2015-01-10 01:04:58');

/*Table structure for table `email` */

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

/*Data for the table `email` */

insert  into `email`(`email_id`,`added_date`,`email_address`,`status`,`user_id`) values (1,'2015-06-26 09:07:58','santosh8pun@gmail.com','ACTIVE',1),(2,'2015-06-27 19:01:22','santosh8pun@gmail.com','ACTIVE',2),(3,'2015-06-27 22:18:52','santosh8pun@gmail.com','ACTIVE',3),(4,'2015-06-27 22:24:27','santosh8pun@gmail.com','ACTIVE',4),(5,'2015-07-26 23:51:25','nlalshrestha@gmail.com','ACTIVE',6),(6,'2015-08-23 19:04:15','santosh8pun@gmail.com','ACTIVE',7),(7,'2015-08-23 19:16:06','santosh8pun@gmail.com','ACTIVE',8);

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

/*Data for the table `field_worker` */

insert  into `field_worker`(`id`,`added_date`,`email_address`,`first_name`,`last_name`,`phone_number`,`added_by`,`discipline_id`,`modified_date`,`modified_by`) values (1,'2015-06-29 20:18:54','santosh8pun@gmail.com','Santosh','Pun','9808639594',1,1,'2015-07-27 00:46:23',1),(2,'2015-07-01 22:33:47','sanjeev@ontargetcloud.com','Sanjeev','Ghimire','432423423',1,1,NULL,NULL),(3,'2015-07-21 22:04:45','santosh8pun@gmail.com','Basanta','Rijal','432423423',1,3,NULL,NULL),(4,'2015-07-27 00:45:44','nlalshrestha@gmail.com','Niran','Shrestha','9808639594',1,1,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `forgot_password_request` */

insert  into `forgot_password_request`(`id`,`user_id`,`forgot_password_token`,`status`,`ts_create`,`ts_expiry`) values (1,1,'275142101522168837465559979545132563527776104131693011149935','ACTIVE','2015-07-21 00:02:56','2015-07-22 00:02:55'),(2,1,'42732387850252230550019991206115026016674111340522778737236','EXPIRED','2015-07-21 00:40:03','2015-07-22 00:40:03'),(3,1,'9828919429226498593167161871725923512188149231357883123863','EXPIRED','2015-07-21 20:12:51','2015-07-22 20:12:51'),(4,1,'327334366566840211132377434638196103687710520630711817637710','ACTIVE','2015-07-26 23:57:45','2015-07-27 23:57:45'),(5,1,'634598413384037635163186640303227766980135315424274206252084','EXPIRED','2015-07-26 23:59:05','2015-07-27 23:59:05'),(6,1,'139870595109289457865431015892853046288127560682417179152882','ACTIVE','2015-07-27 00:59:34','2015-07-28 00:59:34');

/*Table structure for table `permission_mapped_request` */

DROP TABLE IF EXISTS `permission_mapped_request`;

CREATE TABLE `permission_mapped_request` (
  `permission_mapped_request_id` int(11) NOT NULL AUTO_INCREMENT,
  `has_permission` char(1) DEFAULT NULL,
  `request_path` varchar(45) DEFAULT NULL,
  `application_permission_id` int(11) NOT NULL,
  PRIMARY KEY (`permission_mapped_request_id`),
  KEY `FK_eftyhxx38q26je13xhbwgxvae` (`application_permission_id`),
  CONSTRAINT `FK_eftyhxx38q26je13xhbwgxvae` FOREIGN KEY (`application_permission_id`) REFERENCES `application_permission` (`application_permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `permission_mapped_request` */

insert  into `permission_mapped_request`(`permission_mapped_request_id`,`has_permission`,`request_path`,`application_permission_id`) values (1,'Y','/project/getUserProjectList',2),(2,'Y','/project/getProject',1),(3,'Y','/report/earnedValueReport',1),(4,'Y','/report/bireport',1),(5,'Y','task/getProjectTaskByMainProject',1),(6,'Y','/task/getTaskCountsOfProject',1),(7,'Y','/documents/getUserDocument',1),(8,'Y','/activityLog/getLog',1),(9,'Y','/project/getActivityOfProject',2);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `phone` */

insert  into `phone`(`phone_id`,`contact_id`,`area_code`,`phone_number`,`phone_type`,`status`) values (1,1,971,'9801012345','CELL','ACTIVE'),(2,2,977,'9808639594','CELL','ACTIVE'),(3,3,989,'9991919','CELL','ACTIVE'),(4,4,989,'9999111','CELL','ACTIVE'),(5,5,980,'8639594','CELL','ACTIVE'),(6,6,988,'8898999','CELL','ACTIVE'),(7,7,989,'9900009','CELL','ACTIVE');

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
  KEY `FK_5esfn5kr4k3cphjuhlih229gs` (`created_by`),
  KEY `FK_7dacqo4sy74ub6anhlw4bso5q` (`modified_by`),
  CONSTRAINT `FK_5esfn5kr4k3cphjuhlih229gs` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_7dacqo4sy74ub6anhlw4bso5q` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `planned_actual_task_fk` FOREIGN KEY (`task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

/*Data for the table `planned_actuals_cost` */

insert  into `planned_actuals_cost`(`id`,`task_id`,`from_date`,`to_date`,`cost_type`,`value`,`expiry_date`,`created_by`,`created_date`,`modified_by`,`modified_date`) values (1,1,'2015-06-10 00:00:00','2015-06-25 00:00:00','ACTUAL','100.000','9999-12-31 00:00:00',1,'2015-07-05 23:07:49',1,'2015-07-26 19:44:55'),(2,1,'2015-06-10 00:00:00','2015-06-25 00:00:00','PLANNED','15.000','9999-12-31 00:00:00',1,'2015-07-05 23:07:49',1,'2015-07-11 08:29:30'),(3,3,'2015-06-10 00:00:00','2015-06-18 00:00:00','ACTUAL','10.000','9999-12-31 00:00:00',1,'2015-07-08 22:45:19',1,'2015-07-09 20:09:57'),(4,3,'2015-06-10 00:00:00','2015-06-18 00:00:00','PLANNED','90.000','9999-12-31 00:00:00',1,'2015-07-08 22:45:19',1,'2015-07-09 20:09:57'),(5,7,'2015-04-17 00:00:00','2015-06-17 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-07-18 10:19:41',NULL,NULL),(6,7,'2015-04-17 00:00:00','2015-06-17 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-07-18 10:19:41',NULL,NULL),(7,8,'2015-04-17 00:00:00','2015-06-17 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-07-18 10:28:34',NULL,NULL),(8,8,'2015-04-17 00:00:00','2015-06-17 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-07-18 10:28:34',NULL,NULL),(9,9,'2015-04-17 00:00:00','2015-06-17 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-07-18 10:33:36',NULL,NULL),(10,9,'2015-04-17 00:00:00','2015-06-17 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-07-18 10:33:36',NULL,NULL),(11,10,'2015-04-17 00:00:00','2015-06-17 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-07-18 10:33:36',NULL,NULL),(12,10,'2015-04-17 00:00:00','2015-06-17 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-07-18 10:33:36',NULL,NULL),(13,11,'2015-04-17 00:00:00','2015-06-17 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-07-18 10:33:36',NULL,NULL),(14,11,'2015-04-17 00:00:00','2015-06-17 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-07-18 10:33:36',NULL,NULL),(15,12,'2015-04-17 00:00:00','2015-06-17 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-07-18 10:33:36',NULL,NULL),(16,12,'2015-04-17 00:00:00','2015-06-17 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-07-18 10:33:36',NULL,NULL),(17,21,'2015-06-10 00:00:00','2015-06-11 00:00:00','ACTUAL','10.000','9999-12-31 00:00:00',1,'2015-07-20 22:24:24',1,'2015-07-20 23:06:48'),(18,21,'2015-06-10 00:00:00','2015-06-11 00:00:00','PLANNED','100.000','9999-12-31 00:00:00',1,'2015-07-20 22:24:24',1,'2015-07-20 23:06:49'),(19,1,'2015-07-26 00:00:00','2015-07-26 00:00:00','P','100.000','9999-12-31 00:00:00',1,'2015-07-26 19:51:08',NULL,NULL),(20,24,'2015-06-17 00:00:00','2015-06-12 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-07-27 22:03:07',NULL,NULL),(21,24,'2015-06-17 00:00:00','2015-06-12 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-07-27 22:03:07',NULL,NULL),(22,27,'2015-06-17 00:00:00','2015-06-22 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-07-27 23:59:21',NULL,NULL),(23,27,'2015-06-17 00:00:00','2015-06-22 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-07-27 23:59:21',NULL,NULL),(24,28,'2015-06-17 00:00:00','2015-06-22 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-07-28 00:01:09',NULL,NULL),(25,28,'2015-06-17 00:00:00','2015-06-22 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-07-28 00:01:09',NULL,NULL),(26,30,'2015-07-28 00:00:00','2015-07-30 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-08-26 20:10:30',NULL,NULL),(27,30,'2015-07-28 00:00:00','2015-07-30 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-08-26 20:10:30',NULL,NULL),(28,31,'2015-06-17 00:00:00','2015-09-22 00:00:00','PLANNED','200.000','9999-12-31 00:00:00',1,'2015-09-05 07:36:01',NULL,NULL),(29,31,'2015-06-17 00:00:00','2015-09-22 00:00:00','ACTUAL','500.000','9999-12-31 00:00:00',1,'2015-09-05 07:36:01',NULL,NULL);

/*Table structure for table `profile` */

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

/*Data for the table `profile` */

insert  into `profile`(`profile_id`,`active`,`added_date`,`modified_date`,`name`,`profile_type`,`added_by`,`modified_by`,`description`,`profile_code`) values (1,'Y','2015-08-23 17:27:48',NULL,'Super User','MENU',1,NULL,'Super User menu profile','SU'),(2,'Y','2015-08-23 17:28:09',NULL,'Project Manager','MENU',1,NULL,'Project Manager Profile','PM'),(3,'Y','2015-08-23 17:28:27',NULL,'Regular User','MENU',1,NULL,'Regular User','RU'),(4,'Y','2015-08-23 17:28:46',NULL,'Super User','PERMISSION',1,NULL,'Super User permission profile','SU'),(5,'Y','2015-08-23 17:29:07',NULL,'Project Manager','PERMISSION',1,NULL,'Project Manager permission profile','PM'),(6,'Y','2015-08-23 17:29:31',NULL,'Regular User','PERMISSION',1,NULL,'Regular User permission profile','RU');

/*Table structure for table `profile_menu` */

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

/*Data for the table `profile_menu` */

insert  into `profile_menu`(`profile_menu_id`,`active`,`application_menu_id`,`profile_id`) values (1,'Y',1,1),(2,'Y',2,1),(3,'Y',3,1),(4,'Y',4,1),(5,'Y',5,1),(6,'Y',6,1),(7,'Y',7,1),(10,'Y',1,2),(11,'Y',2,2),(12,'Y',3,2),(13,'Y',4,2),(14,'Y',1,3),(15,'Y',2,3),(16,'Y',3,3),(17,'Y',4,3),(18,'Y',1,4),(19,'Y',2,4),(20,'Y',3,4),(21,'Y',4,4),(22,'Y',5,4),(23,'Y',6,4),(24,'Y',7,4),(25,'Y',1,5),(26,'Y',2,5),(27,'Y',3,5),(28,'Y',4,5),(29,'Y',5,5),(30,'Y',6,5),(31,'Y',7,5),(32,'Y',1,6),(33,'Y',2,6),(34,'Y',3,6),(35,'Y',5,6),(36,'Y',6,6),(37,'Y',7,6);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `profile_permission` */

insert  into `profile_permission`(`profile_permission_id`,`active`,`application_permission_id`,`profile_id`) values (1,'Y',2,4);

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
  `project_status` int(1) DEFAULT NULL,
  `company_id` int(11) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `project_image_path` varchar(255) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  `project_asset_folder_name` varchar(30) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf32;

/*Data for the table `project` */

insert  into `project`(`project_id`,`project_code`,`project_name`,`project_owner_id`,`project_type_id`,`project_parent_id`,`project_assignee`,`project_description`,`project_image`,`project_start_date`,`project_end_date`,`project_status`,`company_id`,`address_id`,`created_date`,`created_by`,`modified_date`,`modified_by`,`project_image_path`,`type`,`project_asset_folder_name`) values (1,'SIM_BARR','Simon and Barron WEA Residential',1,1,0,NULL,'With objective to develop a comprehensive Model for 200,000 sqft Renovation Project. The challenge was to do a complete survey of the existing system in detail to include in the Model. Our team successfully provided Architecture, Structure, Mechanical , Electrical and Plumbing and identified clashes. We also provided solutions for resolving conflicts and innovative approaches for coordination.',NULL,'2015-01-08 23:00:00','2015-12-31 23:00:00',1,1,1,NULL,1,'2015-01-09 23:00:07',1,'/assets/project/532114_798942323454369_463283099_n.jpg','MAIN_PROJECT',NULL),(2,NULL,'project1',1,1,1,NULL,'project1 desc',NULL,'2015-06-01 00:00:00','2015-10-30 00:00:00',1,1,2,'2015-06-26 21:09:55',1,'2015-06-27 07:10:08',1,'/assets/project/const3.jpeg','PROJECT',NULL),(3,NULL,'project2',1,1,1,NULL,'project2 desc',NULL,'2015-06-02 00:00:00','2015-06-27 00:00:00',1,1,3,'2015-06-27 07:04:12',1,NULL,NULL,'/assets/project/const4.jpeg','PROJECT',NULL),(4,NULL,'activity1',1,1,2,NULL,'activity1 desc',NULL,'2015-06-02 00:00:00','2015-06-27 00:00:00',1,1,NULL,'2015-06-27 07:19:38',1,'2015-07-21 23:21:46',1,NULL,'ACTIVITY',NULL),(5,NULL,'Santosh Company\'s Project',4,1,0,NULL,'Santosh Company\'s Project',NULL,'2015-06-27 22:24:27','2032-02-27 22:24:27',1,2,4,'2015-06-27 22:24:27',4,NULL,NULL,NULL,'MAIN_PROJECT',NULL),(6,NULL,'project3',1,1,1,NULL,'project3 desc',NULL,'2015-06-02 00:00:00','2015-09-12 00:00:00',1,1,6,'2015-06-28 23:11:45',1,NULL,NULL,'/assets/project/const1.jpeg','PROJECT',NULL),(7,NULL,'project4',1,1,1,NULL,'project4 desc',NULL,'2015-06-01 00:00:00','2015-09-18 00:00:00',2,1,7,'2015-06-28 23:13:12',1,'2015-07-10 19:40:39',1,'/assets/project/const4.jpeg','PROJECT',NULL),(8,NULL,'project5',1,1,1,NULL,'project5 desc',NULL,'2015-06-01 00:00:00','2015-10-09 00:00:00',1,1,8,'2015-06-28 23:15:06',1,NULL,NULL,'/assets/project/const2.jpg','PROJECT',NULL),(9,NULL,'project6',1,1,1,NULL,'project6 desc',NULL,'2015-06-02 00:00:00','2015-09-12 00:00:00',2,1,9,'2015-06-28 23:25:17',1,'2015-07-10 21:18:52',1,'/assets/project/const2.jpg','PROJECT',NULL),(10,NULL,'activity2',1,1,2,NULL,'activity2 desc',NULL,'2015-06-02 00:00:00','2015-06-22 00:00:00',1,1,NULL,'2015-06-28 23:26:26',1,NULL,NULL,NULL,'ACTIVITY',NULL),(11,NULL,'activity3',1,1,2,NULL,'activity3 desc',NULL,'2015-06-10 00:00:00','2015-06-25 00:00:00',1,1,NULL,'2015-06-29 07:34:49',1,'2015-06-29 07:35:27',1,NULL,'ACTIVITY',NULL),(12,NULL,'project7',1,1,1,NULL,'project7 desc',NULL,'2015-06-30 00:00:00','2015-11-05 00:00:00',1,1,10,'2015-07-10 20:06:42',1,'2015-07-28 21:13:40',1,'/assets/project/1.jpg','PROJECT',NULL),(13,NULL,'project8',1,1,1,NULL,'project8 desc',NULL,'2015-07-02 00:00:00','2015-10-09 00:00:00',1,1,11,'2015-07-10 20:18:15',1,'2015-07-10 20:18:33',1,'/assets/project/3d-building-construction-image_1600x1200_78628.jpg','PROJECT',NULL),(14,NULL,'project9',1,1,1,NULL,'project9 desc',NULL,'2015-07-10 00:00:00','2015-11-06 00:00:00',1,1,12,'2015-07-10 20:41:14',1,NULL,NULL,'/assets/project/ss11.jpeg','PROJECT',NULL),(15,NULL,'project10',1,1,1,NULL,'project10 desc',NULL,'2015-07-01 00:00:00','2015-09-04 00:00:00',1,1,13,'2015-07-10 21:10:04',1,NULL,NULL,'/assets/project/ss11.jpeg','PROJECT',NULL),(16,NULL,'project11',1,1,1,NULL,'project11 desc',NULL,'2015-07-01 00:00:00','2015-09-11 00:00:00',1,1,14,'2015-07-10 21:17:03',1,'2015-07-10 21:26:57',1,'/assets/project/medium_1.jpg','PROJECT',NULL),(17,NULL,'project12',1,1,1,NULL,'project12 desc',NULL,'2015-07-01 00:00:00','2015-10-09 00:00:00',1,1,15,'2015-07-10 21:33:00',1,NULL,NULL,'/assets/project/medium_const3.jpeg','PROJECT',NULL),(18,NULL,'project13',1,1,1,NULL,'project13 desc',NULL,'2015-07-02 00:00:00','2015-10-09 00:00:00',1,1,16,'2015-07-10 21:41:23',1,NULL,NULL,'/assets/project/medium_www.jpeg','PROJECT',NULL),(21,'ACT-001','activity1',1,1,1,NULL,'activity1',NULL,'2015-04-17 00:00:00','2015-06-17 00:00:00',1,1,NULL,'2015-07-18 10:19:41',1,NULL,NULL,NULL,'ACTIVITY',NULL),(22,'ACT-005','activity name2',1,1,0,NULL,'activity desc2',NULL,'2015-07-26 00:00:00','2015-07-26 00:00:00',1,1,NULL,'2015-07-18 10:28:34',1,'2015-07-26 19:39:16',1,NULL,'ACTIVITY',NULL),(23,'ACT-001','activity1',1,1,1,NULL,'activity1',NULL,'2015-04-17 00:00:00','2015-06-17 00:00:00',1,1,NULL,'2015-07-18 10:33:35',1,NULL,NULL,NULL,'ACTIVITY',NULL),(24,'ACT-003','activity3',1,1,1,NULL,'activity3',NULL,'2015-04-17 00:00:00','2015-06-17 00:00:00',1,1,NULL,'2015-07-18 10:33:36',1,NULL,NULL,NULL,'ACTIVITY',NULL),(25,'ACT-004','activity4',1,1,1,NULL,'activity4',NULL,'2015-04-17 00:00:00','2015-06-17 00:00:00',1,1,NULL,'2015-07-18 10:33:36',1,NULL,NULL,NULL,'ACTIVITY',NULL),(26,NULL,'activity4',1,1,2,NULL,'activity4 desc',NULL,'2015-07-01 00:00:00','2015-12-17 00:00:00',2,1,NULL,'2015-07-21 23:22:52',1,'2015-07-26 19:37:06',1,NULL,'ACTIVITY',NULL),(27,NULL,'project name',1,1,2,NULL,'project desc',NULL,'2015-07-26 00:00:00','2015-07-26 00:00:00',1,1,17,'2015-07-26 19:37:50',1,NULL,1,'/home/santosh/project1.jpg','ACTIVITY',NULL),(28,NULL,'activity name',1,1,2,NULL,'activity desc',NULL,'2015-07-26 00:00:00','2015-07-26 00:00:00',1,1,NULL,'2015-07-26 19:38:39',1,NULL,NULL,NULL,'ACTIVITY',NULL),(29,'ACT-001','activity1',1,1,2,NULL,'activity1',NULL,'2015-06-17 00:00:00','2015-06-22 00:00:00',1,1,NULL,'2015-07-27 22:03:06',1,NULL,NULL,NULL,'ACTIVITY',NULL),(30,NULL,'santosh activity',1,1,2,NULL,'santosh activity desc',NULL,'2015-07-01 00:00:00','2015-11-19 00:00:00',1,1,NULL,'2015-07-27 22:53:51',1,NULL,NULL,NULL,'ACTIVITY',NULL),(31,'ACT-001','activity1',1,1,2,NULL,'activity1',NULL,'2015-06-17 00:00:00','2015-06-22 00:00:00',1,1,NULL,'2015-07-27 23:59:20',1,NULL,NULL,NULL,'ACTIVITY',NULL),(32,'ACT-001','activity1',1,1,2,NULL,'activity1',NULL,'2015-06-17 00:00:00','2015-06-22 00:00:00',1,1,NULL,'2015-07-28 00:01:09',1,NULL,NULL,NULL,'ACTIVITY',NULL),(33,NULL,'sa',6,1,2,NULL,'a',NULL,'2015-07-08 00:00:00','2015-07-16 00:00:00',1,1,NULL,'2015-07-28 08:05:30',6,NULL,NULL,NULL,'ACTIVITY',NULL),(34,NULL,'projectsa1',1,1,1,NULL,'projectsa1',NULL,'2015-08-04 00:00:00','2015-09-11 00:00:00',1,1,18,'2015-08-22 11:55:59',1,NULL,NULL,'/assets/project/medium_const3.jpeg','PROJECT',NULL),(35,NULL,'project22',1,1,1,NULL,'project22',NULL,'2015-08-06 00:00:00','2015-08-22 00:00:00',1,1,19,'2015-08-22 11:57:22',1,NULL,NULL,'/assets/project/medium_const4.jpeg','PROJECT',NULL),(36,NULL,'scompany\'s Project',7,1,0,NULL,'scompany\'s Project',NULL,'2015-08-23 19:04:16','2032-04-23 19:04:16',1,3,20,'2015-08-23 19:04:16',7,NULL,NULL,NULL,'MAIN_PROJECT',NULL),(37,NULL,'pkcompany\'s Project',8,1,0,NULL,'pkcompany\'s Project',NULL,'2015-08-23 19:16:06','2032-04-23 19:16:06',1,4,21,'2015-08-23 19:16:06',8,NULL,NULL,NULL,'MAIN_PROJECT',NULL),(38,NULL,'activitynew1',1,1,2,NULL,'activitynew1',NULL,'2015-08-04 00:00:00','2015-08-25 00:00:00',1,1,NULL,'2015-08-23 19:22:27',1,NULL,NULL,NULL,'ACTIVITY',NULL),(39,'ACT-005','activity11',1,1,1,NULL,'activity11',NULL,'2015-07-27 00:00:00','2015-08-27 00:00:00',1,1,NULL,'2015-08-26 20:10:30',1,NULL,NULL,NULL,'ACTIVITY',NULL),(40,'ACT-001','activity1',1,1,2,NULL,'activity1',NULL,'2015-06-17 00:00:00','2015-10-22 00:00:00',1,1,NULL,'2015-09-05 07:36:00',1,NULL,NULL,NULL,'ACTIVITY',NULL);

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

/*Data for the table `project_configuration` */

insert  into `project_configuration`(`id`,`config_key`,`config_value`,`project_id`) values (2,'UNIT_OF_MEASUREMENT','HOUR',2),(3,'UNIT_OF_MEASUREMENT','HOUR',3),(4,'UNIT_OF_MEASUREMENT','HOUR',6),(5,'UNIT_OF_MEASUREMENT','HOUR',7),(6,'UNIT_OF_MEASUREMENT','HOUR',8),(7,'UNIT_OF_MEASUREMENT','HOUR',9),(8,'UNIT_OF_MEASUREMENT','HOUR',12),(9,'UNIT_OF_MEASUREMENT','HOUR',13),(10,'UNIT_OF_MEASUREMENT','HOUR',14),(11,'UNIT_OF_MEASUREMENT','HOUR',15),(12,'UNIT_OF_MEASUREMENT','HOUR',16),(13,'UNIT_OF_MEASUREMENT','HOUR',17),(14,'UNIT_OF_MEASUREMENT','HOUR',18),(15,'UNIT_OF_MEASUREMENT','HOUR',34),(16,'UNIT_OF_MEASUREMENT','HOUR',35);

/*Table structure for table `project_file` */

DROP TABLE IF EXISTS `project_file`;

CREATE TABLE `project_file` (
  `project_file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) NOT NULL,
  `project_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `file_type` varchar(80) NOT NULL,
  `description` varchar(255) NOT NULL,
  `project_file_category_id` int(11) NOT NULL,
  `status` varchar(10) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`project_file_id`),
  KEY `project_file_fk` (`project_id`),
  KEY `FK_2v0bylp54dbusaabhxg3qbtdn` (`created_by`),
  KEY `FK_pitnp5i4rcjntirjfbqpo2ka3` (`project_file_category_id`),
  KEY `FK_dfitgtopdcx3ra8n4t29wus0n` (`modified_by`),
  CONSTRAINT `FK_2v0bylp54dbusaabhxg3qbtdn` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_dfitgtopdcx3ra8n4t29wus0n` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_pitnp5i4rcjntirjfbqpo2ka3` FOREIGN KEY (`project_file_category_id`) REFERENCES `project_file_category` (`project_file_category_id`),
  CONSTRAINT `project_file_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `project_file` */

insert  into `project_file`(`project_file_id`,`file_name`,`project_id`,`created_date`,`created_by`,`file_type`,`description`,`project_file_category_id`,`status`,`modified_date`,`modified_by`) values (1,'bsn_bsn.jpg',1,'2015-03-13 16:35:15',1,'image/jpeg','',1,'ACTIVE',NULL,NULL),(2,'IMG_7491.JPG',1,'2015-03-13 16:36:26',1,'image/jpeg','',1,'ACTIVE',NULL,NULL),(3,'file.pdf',1,'2015-03-14 12:37:33',1,'application/pdf','',1,'ACTIVE',NULL,NULL),(4,'Details 3.pdf',1,'2015-03-28 19:46:51',1,'application/pdf','',1,'ACTIVE',NULL,NULL),(5,'handson-nodejs-sample.pdf',1,'2015-03-31 23:45:46',1,'application/pdf','',1,'ACTIVE',NULL,NULL),(7,'Details 3.pdf',1,'2015-07-13 22:54:42',1,'application/pdf','',1,'ACTIVE',NULL,NULL),(8,'Details 3.pdf',4,'2015-07-26 20:15:53',1,'application/pdf','',1,'ACTIVE',NULL,NULL),(9,'a2.jpeg',2,'2015-08-22 12:00:05',1,'image/jpeg','',1,'ACTIVE','2015-09-10 07:51:30',1),(10,'Details 3.pdf',2,'2015-08-22 14:09:50',1,'application/pdf','Project image',1,'ACTIVE',NULL,NULL);

/*Table structure for table `project_file_category` */

DROP TABLE IF EXISTS `project_file_category`;

CREATE TABLE `project_file_category` (
  `project_file_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` varchar(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`project_file_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `project_file_category` */

insert  into `project_file_category`(`project_file_category_id`,`active`,`name`) values (1,'Y','Drawing'),(2,'Y','Painting'),(3,'Y','Furnishing');

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

/*Data for the table `project_file_comment` */

insert  into `project_file_comment`(`project_file_comment_id`,`comment`,`comment_status`,`commented_date`,`commented_by`,`project_file_id`) values (1,'This is comment2','ACTIVE','2015-08-22 22:28:36',1,1),(2,'This is another comment','ACTIVE','2015-08-23 00:00:00',1,1);

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

/*Data for the table `project_member` */

insert  into `project_member`(`project_member_id`,`project_id`,`user_id`,`member_status`) values (1,1,1,'ACTIVE'),(2,2,1,'ACTIVE'),(3,3,1,'ACTIVE'),(4,1,2,'ACTIVE'),(5,2,2,'ACTIVE'),(6,1,3,'ACTIVE'),(7,2,3,'ACTIVE'),(8,5,4,'ACTIVE'),(9,6,1,'ACTIVE'),(10,7,1,'ACTIVE'),(11,8,1,'ACTIVE'),(12,9,1,'ACTIVE'),(13,12,1,'ACTIVE'),(14,13,1,'ACTIVE'),(15,14,1,'ACTIVE'),(16,15,1,'ACTIVE'),(17,16,1,'ACTIVE'),(18,17,1,'ACTIVE'),(19,18,1,'ACTIVE'),(20,27,1,'ACTIVE'),(21,1,6,'ACTIVE'),(22,2,6,'ACTIVE'),(23,3,6,'ACTIVE'),(24,34,1,'ACTIVE'),(25,35,1,'ACTIVE'),(26,36,7,'ACTIVE'),(27,37,8,'ACTIVE');

/*Table structure for table `project_task` */

DROP TABLE IF EXISTS `project_task`;

CREATE TABLE `project_task` (
  `project_task_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `parent_task_id` int(11) DEFAULT '0',
  `status` int(1) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf32;

/*Data for the table `project_task` */

insert  into `project_task`(`project_task_id`,`project_id`,`title`,`parent_task_id`,`status`,`start_date`,`end_date`,`created_date`,`created_by`,`modified_date`,`modified_by`,`severity`,`description`,`task_percentage`) values (1,4,'task1',NULL,1,'2015-06-06','2015-06-15','2015-06-27 07:20:26',1,'2015-08-21 07:57:55',1,'1','task desc',10),(3,4,'task2',NULL,1,'2015-06-10','2015-06-18','2015-06-29 07:36:59',1,NULL,1,'1','task2 desc',20),(4,10,'task5',NULL,1,'2015-06-10','2015-06-18','2015-06-29 20:11:15',1,'2015-06-29 20:12:00',1,'1','task5 desc',10),(7,21,'task1',NULL,2,'2015-04-17','2015-06-17','2015-07-18 10:19:41',1,NULL,1,'2','task1',13),(8,22,'task1',NULL,1,'2015-04-17','2015-06-17','2015-07-18 10:28:34',1,NULL,1,'2','task1',5),(9,23,'task1',NULL,1,'2015-04-17','2015-06-17','2015-07-18 10:33:36',1,NULL,1,'2','task1',90),(10,23,'task2',NULL,1,'2015-04-17','2015-06-17','2015-07-18 10:33:36',1,NULL,1,'2','task2',0),(11,24,'task3',NULL,1,'2015-04-17','2015-06-17','2015-07-18 10:33:36',1,NULL,1,'2','task3',30),(12,25,'task4',NULL,1,'2015-04-17','2015-06-17','2015-07-18 10:33:36',1,NULL,1,'2','task4',0),(13,4,'task11111221',NULL,1,'2015-06-03','2015-06-16','2015-07-18 21:56:09',1,NULL,1,'1','task1111122 desc',0),(14,4,'task2222',NULL,1,'2015-06-03','2015-06-16','2015-07-18 21:59:52',1,NULL,1,'1','task22222 desc',50),(15,4,'task222211',NULL,1,'2015-06-03','2015-06-16','2015-07-18 22:01:49',1,NULL,1,'1','task22222 desc',40),(16,4,'task34343434',NULL,1,'2015-06-03','2015-06-18','2015-07-20 21:50:22',1,NULL,1,'1','task323523535',70),(17,4,'task32423432423',NULL,1,'2015-06-10','2015-06-18','2015-07-20 21:52:15',1,NULL,1,'1','task4324234234',12),(18,4,'task342423423',NULL,1,'2015-06-04','2015-06-10','2015-07-20 21:57:17',1,NULL,1,'1','taaksdasd',34),(19,4,'tasdsad2312312',NULL,1,'2015-06-10','2015-06-17','2015-07-20 22:02:49',1,NULL,1,'1','tadsasd',0),(20,4,'dsadasd',NULL,1,'2015-06-10','2015-06-11','2015-07-20 22:14:44',1,NULL,1,'1','dasdas',0),(21,4,'ttttttt242423',NULL,2,'2015-06-10','2015-06-11','2015-07-20 22:20:55',1,'2015-07-26 20:10:16',1,'1','ttrtttt32432',0),(22,4,'dsadasd',NULL,2,'2015-06-10','2015-06-17','2015-07-20 22:23:50',1,NULL,1,'1','dsadas',0),(23,2,'task1',NULL,1,'2015-06-06','2015-06-15','2015-07-26 19:53:53',1,NULL,1,'1','task desc',0),(24,29,'task1',NULL,1,'2015-06-17','2015-06-12','2015-07-27 22:03:06',1,NULL,1,'2','task desc1',0),(25,4,'task225',NULL,1,'2015-06-10','2015-06-18','2015-07-27 22:46:40',1,NULL,1,'1','task11',0),(26,30,'santosh activity task1',NULL,1,'2015-07-08','2015-07-23','2015-07-27 22:55:11',1,NULL,1,'1','santosh activity task1 desc',0),(27,31,'task1',NULL,1,'2015-06-17','2015-06-22','2015-07-27 23:59:20',1,NULL,1,'2','task desc1',0),(28,32,'task1',NULL,1,'2015-06-17','2015-06-22','2015-07-28 00:01:09',1,'2015-07-28 00:02:22',1,'2','test',0),(29,38,'task11new',NULL,1,'2015-08-05','2015-08-20','2015-08-23 19:23:28',1,NULL,NULL,'1','task11new',0),(30,39,'task1',NULL,1,'2015-07-28','2015-07-30','2015-08-26 20:10:30',1,NULL,NULL,'2','task1',40),(31,40,'task1',NULL,1,'2015-06-17','2015-09-22','2015-09-05 07:36:00',1,NULL,NULL,'2','',20);

/*Table structure for table `project_task_files` */

DROP TABLE IF EXISTS `project_task_files`;

CREATE TABLE `project_task_files` (
  `task_file_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_task_id` int(11) NOT NULL,
  `file_name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` int(12) NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  `modified_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_file_id`),
  KEY `project_task_files_fk` (`project_task_id`),
  KEY `FK_8prh9dk6yobl5jv80k8jmwglq` (`modified_by`),
  CONSTRAINT `FK_8prh9dk6yobl5jv80k8jmwglq` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `project_task_files_fk` FOREIGN KEY (`project_task_id`) REFERENCES `project_task` (`project_task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `project_task_files` */

insert  into `project_task_files`(`task_file_id`,`project_task_id`,`file_name`,`location`,`created_date`,`created_by`,`modified_date`,`status`,`modified_by`) values (1,1,'a2.jpeg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(2,1,'3d-building-construction-image_1600x1200_78628.jpg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(3,1,'3d-building-construction-image_1600x1200_78628.jpg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(4,1,'1.jpg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(5,1,'1.jpg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(6,1,'3d-building-construction-image_1600x1200_78628.jpg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(7,1,'1111.jpeg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(8,1,'1.jpg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(9,1,'office.jpg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(10,1,'const3.jpeg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(11,1,'1.jpg','/assets/task/','2015-09-10 20:06:08',1,NULL,'ACTIVE',NULL),(12,1,'sa.jpg','D:	est','2015-09-10 20:06:08',1,'2015-09-10 20:08:58','DELETED',1);

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

/*Data for the table `registration_request` */

insert  into `registration_request`(`id`,`registration_token`,`project_id`,`first_name`,`last_name`,`email`,`company_name`,`phone_number`,`msg`,`status`,`ts_create`,`user_id`,`name`,`company_address1`,`company_address2`,`company_city`,`company_country`,`company_id`,`company_state`,`company_zip`,`company_type_id`) values (1,'524707371827338909030067302462985880986055341612636568031119',37,'Santosh','Pun','santosh8pun@gmail.com','pkcompany','9808639594','demo','ACCT_NEW','2015-08-23 19:15:06',8,NULL,'nepal',NULL,'ktm','NP',4,'Dhawalagiri','977',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf32;

/*Data for the table `task_assignee` */

insert  into `task_assignee`(`task_assignee_id`,`project_task_id`,`task_assignee`,`created_by`,`created_date`,`modified_by`,`modified_date`,`status`) values (1,1,1,1,'2015-07-21 23:05:07',1,'2015-07-28 20:23:58',2),(2,23,1,1,'2015-07-26 19:53:53',NULL,NULL,1),(3,23,2,1,'2015-07-26 19:53:53',NULL,NULL,1),(4,24,1,1,'2015-07-27 22:03:06',NULL,NULL,1),(5,25,1,1,'2015-07-27 22:46:40',NULL,NULL,1),(6,26,1,1,'2015-07-27 22:55:11',NULL,NULL,1),(7,27,1,1,'2015-07-27 23:59:21',NULL,NULL,1),(8,28,1,1,'2015-07-28 00:01:09',6,'2015-07-28 08:17:52',1),(9,28,2,6,'2015-07-28 08:17:53',NULL,NULL,1),(10,1,2,1,'2015-07-28 20:16:07',1,'2015-07-28 20:23:58',1),(11,1,6,1,'2015-07-28 20:23:58',NULL,NULL,1),(12,29,2,1,'2015-08-23 19:23:28',NULL,NULL,1),(13,30,1,1,'2015-08-26 20:10:30',NULL,NULL,1),(14,31,1,1,'2015-09-05 07:36:00',NULL,NULL,1);

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

/*Data for the table `task_comment` */

insert  into `task_comment`(`task_comment_id`,`task_id`,`comment`,`commented_by`,`commented_date`,`comment_status`) values (3,1,'comment1',1,'2015-06-29 07:52:50','ACTIVE'),(4,4,'comment added',1,'2015-06-29 20:12:30','ACTIVE'),(5,1,'test comment',1,'2015-07-05 22:31:50','ACTIVE'),(6,4,'test',1,'2015-07-05 22:32:22','ACTIVE'),(7,1,'santosh',1,'2015-07-05 22:34:14','ACTIVE'),(8,1,'test',1,'2015-07-05 22:34:45','ACTIVE'),(9,3,'hello',1,'2015-07-05 23:04:47','ACTIVE'),(10,3,'hi',1,'2015-07-05 23:15:07','ACTIVE'),(11,21,'test',1,'2015-07-20 23:25:15','ACTIVE'),(12,1,'s',1,'2015-07-21 20:19:55','ACTIVE'),(13,1,'test',1,'2015-07-21 21:55:51','ACTIVE'),(14,1,'abc',1,'2015-07-21 23:16:21','ACTIVE'),(15,1,'cde',1,'2015-07-21 23:16:32','ACTIVE'),(16,1,'this is test comment',1,'2015-07-26 20:05:55','ACTIVE');

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

/*Data for the table `task_fieldworker` */

insert  into `task_fieldworker`(`task_fieldworker_id`,`created_date`,`modified_date`,`status`,`created_by`,`field_worker_id`,`modified_by`,`project_task_id`) values (1,'2015-07-03 22:30:25','2015-07-28 20:25:52',2,1,2,1,1),(2,'2015-07-04 22:05:07','2015-07-28 20:25:52',2,1,1,1,1),(3,'2015-07-21 23:12:43','2015-07-28 20:25:52',2,1,3,1,1),(4,'2015-07-28 20:25:03','2015-07-28 20:25:52',1,1,4,1,1);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `task_percentage_log` */

/*Table structure for table `task_priority` */

DROP TABLE IF EXISTS `task_priority`;

CREATE TABLE `task_priority` (
  `task_priority_id` int(11) NOT NULL AUTO_INCREMENT,
  `priority` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`task_priority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `task_priority` */

insert  into `task_priority`(`task_priority_id`,`priority`,`code`) values (1,'Critical','CRITICAL'),(2,'High','HIGH'),(3,'Low','LOW');

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

/*Data for the table `time_card` */

insert  into `time_card`(`id`,`added_date`,`modified_date`,`time_in`,`time_out`,`added_by`,`field_worker_id`,`modified_by`,`project_task_id`) values (1,'2015-07-21 23:06:18',NULL,'2015-06-10 00:00:00','2015-06-11 00:00:00',1,1,NULL,1),(2,'2015-07-21 23:06:44',NULL,'2015-06-11 00:00:00','2015-06-11 00:00:00',1,3,NULL,1),(3,'2015-07-21 23:07:12',NULL,'2015-06-11 00:00:00','2015-06-12 00:00:00',1,3,NULL,3),(4,'2015-07-27 00:44:40',NULL,'2015-06-06 08:35:50','2015-06-07 08:35:50',1,1,NULL,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_type_id` int(11) DEFAULT NULL,
  `password` text NOT NULL,
  `salt` text NOT NULL,
  `user_status` int(1) DEFAULT '0',
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

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_type_id`,`password`,`salt`,`user_status`,`discipline`,`number_of_login`,`modified_date`,`account_status`) values (1,'sanjeev',1,'1116498511374380225290218669984473954663051253417628552740431367293687935025473432647676322191310614568616549292722075223326141781934491702836223431796988','42260744833193773908642048352554563734407567442773618115432912143707474601897545369520036155558960404164961667091423749533416970629935556214737560313830937681568607893076334409219853908060064527302563918707107970662746185969993337712253653026601446226039573207339715837103451824475729779064977291712078096524',1,1,1,'2014-11-05 02:30:40','ACTIVE'),(2,'santosh',1,'12743122043224347422492019347777528212770461258126373476137874108648870961130325517641486334949198775205185071284442292557518588876333492799779242574399185','69233601208507241839615612362251809087887061499558733846271016995898866376211656852334433898975729254723937914136987510500040154883497964230592038755036340833539509960836012777157025607580170188822472937040641903693996795985374692779645453357250506631430677475918606502218299243767355189649107015291506758815',1,1,1,'2015-06-27 19:01:22','ACTIVE'),(3,'santosh123',1,'143818543519591233958785449093545880827483332933415329256203739790219454152657113219312495622698752858968818017528410269587690678950929984299679196371502','42963137105677291998309679722552906054941835619113764704109490750647748024004928899114093670362698356289361211683048749358242737253566140170827018594259088930557741084825430789188628768752422205351474029025805637621729110761120546765787585633848981211296358750230711736484434113534925005445055834806184549139',1,2,1,'2015-06-27 22:18:52','ACTIVE'),(4,'santoshpun',1,'1314088968069448544142636830252476248047348267255172656823617259442391715597993923138256292663279393556881319159725823810957126701805806027664974612226374','2814188756579499179042624459003022585391610451300370704759230737500813731156792414119713139789687534834535911278805112272790821964201032090838896859291243833024216725205920455877711358935979626069699113117222972347701220131614177055350003081989933299885284164631139705965681580534958787629714576824940372511',1,3,1,'2015-06-27 22:24:27','ACTIVE'),(5,'santosh8pun@gmail.com',1,'e6a79b6a-44a8-4836-bc04-285c31ce57b5','',0,1,1,'2015-07-26 20:15:05','ACCT_NEW'),(6,'santoshpun1',1,'1116498511374380225290218669984473954663051253417628552740431367293687935025473432647676322191310614568616549292722075223326141781934491702836223431796988','42260744833193773908642048352554563734407567442773618115432912143707474601897545369520036155558960404164961667091423749533416970629935556214737560313830937681568607893076334409219853908060064527302563918707107970662746185969993337712253653026601446226039573207339715837103451824475729779064977291712078096524',1,2,1,'2015-07-26 23:51:25','ACTIVE'),(7,'santosh2121',1,'11849952567958364137654231755905885900395542476363611260100092799718776199443073191165701998400909631192913189297608231226400400814538384756701296288956164','38301022323114162711488722687219109235191820037203852057630692044100505963011245931289726462654682869367362518589237160824555623671449443601895549680086816187207135920229844681965724977786208025654907490551853001189506127959152624464954524354277083039153827869643803634587434353697353374092724602581851217941',1,4,1,'2015-08-23 19:04:15','ACTIVE'),(8,'santosh1212',1,'9433298756059187619534569109011647082861993698357411393376000693249919870895900609229595442922686528513438663038193737853770771686301249339475195021508083','45580141563474336386882399491249733364801266880374262824298058497158705679144259761886666170321404691132413455725434082447627902342938901225514754386610431515915647624634134533585162009864189281676499867363851490746606243413102751165080726299006621680271388724481036691647113060123082781451547281835068883936',1,3,1,'2015-08-23 19:16:06','ACTIVE');

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
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hrv2lmyjlt3ken6hk2f4sg1e` (`user_id`),
  CONSTRAINT `FK_hrv2lmyjlt3ken6hk2f4sg1e` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=latin1;

/*Data for the table `user_notification` */

insert  into `user_notification`(`id`,`last_seen_at`,`status`,`text`,`ts_insert`,`user_id`,`notification_type`,`project_id`) values (1,NULL,'NEW','New Project project5 added by Sanjeev Ghimire','2015-06-28 23:25:17',1,'PROJECT',0),(2,NULL,'NEW','New Activity activity2 added by Sanjeev Ghimire','2015-06-28 23:26:26',1,'ACTIVITY',0),(3,NULL,'NEW','projectTypeText project6  updated by Sanjeev Ghimire','2015-06-29 07:28:25',1,'PROJECT',0),(4,NULL,'NEW','projectTypeText project6  updated by Sanjeev Ghimire','2015-06-29 07:32:25',1,'PROJECT',0),(5,NULL,'NEW','Project project6  updated by Sanjeev Ghimire','2015-06-29 07:33:22',1,'PROJECT',0),(6,NULL,'NEW','New Activity activity3 added by Sanjeev Ghimire','2015-06-29 07:34:49',1,'ACTIVITY',0),(7,NULL,'NEW','Activity activity3  updated by Sanjeev Ghimire','2015-06-29 07:35:27',1,'ACTIVITY',0),(8,NULL,'NEW','New task task2 added by Sanjeev Ghimire','2015-06-29 07:36:59',1,'TASK',0),(9,NULL,'NEW','Task activity1 task1 updated by Sanjeev Ghimire','2015-06-29 07:39:55',1,'TASK',0),(10,NULL,'NEW','Task activity1 task1 updated by Sanjeev Ghimire','2015-06-29 07:50:21',1,'TASK',0),(11,NULL,'NEW','Task activity1 task1 updated by Sanjeev Ghimire','2015-06-29 07:50:43',1,'TASK',0),(14,NULL,'NEW','Comment comment1 added on task activity1 task1','2015-06-29 07:52:50',1,'COMMENT',0),(15,NULL,'NEW','Activity activity1  updated by Sanjeev Ghimire','2015-06-29 20:10:25',1,'ACTIVITY',0),(16,NULL,'NEW','New task task5 added by Sanjeev Ghimire','2015-06-29 20:11:15',1,'TASK',0),(17,NULL,'NEW','Task task5 updated by Sanjeev Ghimire','2015-06-29 20:12:00',1,'TASK',0),(18,NULL,'NEW','Comment comment added added on task task5','2015-06-29 20:12:30',1,'COMMENT',0),(19,NULL,'NEW','Activity activity1  updated by Sanjeev Ghimire','2015-06-29 20:17:53',1,'ACTIVITY',0),(20,NULL,'NEW','Project project6  updated by Sanjeev Ghimire','2015-06-29 20:20:35',1,'PROJECT',0),(21,NULL,'NEW','Task activity1 task1 updated by Sanjeev Ghimire','2015-07-04 12:10:30',1,'TASK',0),(22,NULL,'NEW','Comment test comment added on task activity1 task1','2015-07-05 22:31:50',1,'COMMENT',0),(23,NULL,'NEW','Comment test added on task task5','2015-07-05 22:32:22',1,'COMMENT',0),(24,NULL,'NEW','Comment santosh added on task activity1 task1','2015-07-05 22:34:14',1,'COMMENT',0),(25,NULL,'NEW','Comment test added on task activity1 task1','2015-07-05 22:34:45',1,'COMMENT',0),(26,NULL,'NEW','Task activity1 task1 updated by Sanjeev Ghimire','2015-07-05 22:41:40',1,'TASK',0),(27,NULL,'NEW','Comment hello added on task task2','2015-07-05 23:04:48',1,'COMMENT',0),(28,NULL,'NEW','Comment hi added on task task2','2015-07-05 23:15:07',1,'COMMENT',0),(29,NULL,'NEW','Task activity1 task1 updated by Sanjeev Ghimire','2015-07-08 22:44:52',1,'TASK',0),(30,NULL,'NEW','Project project4  updated by Sanjeev Ghimire','2015-07-10 19:40:39',1,'PROJECT',0),(31,NULL,'NEW','New Project project7 added by Sanjeev Ghimire','2015-07-10 20:06:42',1,'PROJECT',0),(32,NULL,'NEW','Project project7  updated by Sanjeev Ghimire','2015-07-10 20:17:34',1,'PROJECT',0),(33,NULL,'NEW','New Project project8 added by Sanjeev Ghimire','2015-07-10 20:18:15',1,'PROJECT',0),(34,NULL,'NEW','Project project8  updated by Sanjeev Ghimire','2015-07-10 20:18:33',1,'PROJECT',0),(35,NULL,'NEW','Activity activity1  updated by Sanjeev Ghimire','2015-07-10 20:19:16',1,'ACTIVITY',0),(36,NULL,'NEW','New Project project9 added by Sanjeev Ghimire','2015-07-10 20:41:14',1,'PROJECT',0),(37,NULL,'NEW','New Project project10 added by Sanjeev Ghimire','2015-07-10 21:10:04',1,'PROJECT',0),(38,NULL,'NEW','New Project project11 added by Sanjeev Ghimire','2015-07-10 21:17:04',1,'PROJECT',0),(39,NULL,'NEW','Project project6  updated by Sanjeev Ghimire','2015-07-10 21:18:52',1,'PROJECT',0),(40,NULL,'NEW','Project project11  updated by Sanjeev Ghimire','2015-07-10 21:26:55',1,'PROJECT',0),(41,NULL,'NEW','Project project11  updated by Sanjeev Ghimire','2015-07-10 21:27:01',1,'PROJECT',0),(42,'2015-07-10 22:08:24','SEEN','New Project project12 added by Sanjeev Ghimire','2015-07-10 21:33:00',1,'PROJECT',0),(43,'2015-07-10 22:07:58','SEEN','New Project project13 added by Sanjeev Ghimire','2015-07-10 21:41:23',1,'PROJECT',0),(48,NULL,'NEW','New Activity activity1 added by Sanjeev Ghimire','2015-07-18 10:19:41',1,'ACTIVITY',0),(49,NULL,'NEW','New task task1 added by Sanjeev Ghimire','2015-07-18 10:19:41',1,'TASK',0),(50,NULL,'NEW','New Activity activity11 added by Sanjeev Ghimire','2015-07-18 10:28:34',1,'ACTIVITY',0),(51,NULL,'NEW','New task task1 added by Sanjeev Ghimire','2015-07-18 10:28:34',1,'TASK',0),(52,NULL,'NEW','New Activity activity1 added by Sanjeev Ghimire','2015-07-18 10:33:35',1,'ACTIVITY',0),(53,NULL,'NEW','New task task1 added by Sanjeev Ghimire','2015-07-18 10:33:36',1,'TASK',0),(54,NULL,'NEW','New task task2 added by Sanjeev Ghimire','2015-07-18 10:33:36',1,'TASK',0),(55,NULL,'NEW','New Activity activity3 added by Sanjeev Ghimire','2015-07-18 10:33:36',1,'ACTIVITY',0),(56,NULL,'NEW','New task task3 added by Sanjeev Ghimire','2015-07-18 10:33:36',1,'TASK',0),(57,NULL,'NEW','New Activity activity4 added by Sanjeev Ghimire','2015-07-18 10:33:36',1,'ACTIVITY',0),(58,NULL,'NEW','New task task4 added by Sanjeev Ghimire','2015-07-18 10:33:36',1,'TASK',0),(59,NULL,'NEW','New task task11111221 added by Sanjeev Ghimire','2015-07-18 21:56:09',1,'TASK',0),(60,NULL,'NEW','New task task2222 added by Sanjeev Ghimire','2015-07-18 21:59:52',1,'TASK',0),(61,NULL,'NEW','New task task222211 added by Sanjeev Ghimire','2015-07-18 22:01:49',1,'TASK',0),(62,NULL,'NEW','New task task34343434 added by Sanjeev Ghimire','2015-07-20 21:50:22',1,'TASK',0),(63,NULL,'NEW','New task task32423432423 added by Sanjeev Ghimire','2015-07-20 21:52:15',1,'TASK',0),(64,NULL,'NEW','New task task342423423 added by Sanjeev Ghimire','2015-07-20 21:57:17',1,'TASK',0),(65,NULL,'NEW','New task tasdsad2312312 added by Sanjeev Ghimire','2015-07-20 22:02:49',1,'TASK',0),(66,NULL,'NEW','New task dsadasd added by Sanjeev Ghimire','2015-07-20 22:14:44',1,'TASK',0),(67,NULL,'NEW','New task ttttttt242423 added by Sanjeev Ghimire','2015-07-20 22:20:55',1,'TASK',0),(68,NULL,'NEW','New task dsadasd added by Sanjeev Ghimire','2015-07-20 22:23:50',1,'TASK',0),(69,NULL,'NEW','Task ttttttt242423 updated by Sanjeev Ghimire','2015-07-20 23:07:15',1,'TASK',0),(70,NULL,'NEW','Comment test added on task ttttttt242423','2015-07-20 23:25:15',1,'COMMENT',0),(71,NULL,'NEW','Comment s added on task activity1 task1','2015-07-21 20:19:55',1,'COMMENT',0),(72,NULL,'NEW','Comment test added on task activity1 task1','2015-07-21 21:55:51',1,'COMMENT',0),(73,NULL,'NEW','Comment abc added on task activity1 task1','2015-07-21 23:16:21',1,'COMMENT',0),(74,NULL,'NEW','Comment cde added on task activity1 task1','2015-07-21 23:16:32',1,'COMMENT',0),(75,NULL,'NEW','Activity activity1  updated by Sanjeev Ghimire','2015-07-21 23:21:46',1,'ACTIVITY',0),(76,NULL,'NEW','New Activity activity4 added by Sanjeev Ghimire','2015-07-21 23:22:52',1,'ACTIVITY',0),(77,NULL,'NEW','Activity activity4  updated by Sanjeev Ghimire','2015-07-21 23:24:08',1,'ACTIVITY',0),(78,NULL,'NEW','Activity activity4  updated by Sanjeev Ghimire','2015-07-26 19:37:06',1,'ACTIVITY',0),(79,NULL,'NEW','New Project project name added by Sanjeev Ghimire','2015-07-26 19:37:50',1,'PROJECT',0),(80,NULL,'NEW','New Activity activity name added by Sanjeev Ghimire','2015-07-26 19:38:39',1,'ACTIVITY',0),(81,NULL,'NEW','Activity activity name2  updated by Sanjeev Ghimire','2015-07-26 19:39:16',1,'ACTIVITY',0),(82,NULL,'NEW','New task task1 added by Sanjeev Ghimire','2015-07-26 19:53:53',1,'TASK',0),(83,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-07-26 20:01:53',1,'TASK',0),(84,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-07-26 20:05:12',1,'TASK',0),(85,NULL,'NEW','Comment this is test comment added on task task1','2015-07-26 20:05:55',1,'COMMENT',0),(86,NULL,'NEW','Task ttttttt242423 updated by Sanjeev Ghimire','2015-07-26 20:10:16',1,'TASK',0),(87,NULL,'NEW','New Activity activity1 added by Sanjeev Ghimire','2015-07-27 22:03:06',1,'ACTIVITY',0),(88,NULL,'NEW','New task task1 added by Sanjeev Ghimire','2015-07-27 22:03:06',1,'TASK',0),(89,NULL,'NEW','New task task225 added by Sanjeev Ghimire','2015-07-27 22:46:40',1,'TASK',0),(90,NULL,'NEW','New Activity santosh activity added by Sanjeev Ghimire','2015-07-27 22:53:51',1,'ACTIVITY',0),(91,NULL,'NEW','New task santosh activity task1 added by Sanjeev Ghimire','2015-07-27 22:55:11',1,'TASK',0),(92,NULL,'NEW','New Activity activity1 added by Sanjeev Ghimire','2015-07-27 23:59:20',1,'ACTIVITY',0),(93,NULL,'NEW','New task task1 added by Sanjeev Ghimire','2015-07-27 23:59:20',1,'TASK',0),(94,NULL,'NEW','New Activity activity1 added by Sanjeev Ghimire','2015-07-28 00:01:09',1,'ACTIVITY',0),(95,NULL,'NEW','New task task1 added by Sanjeev Ghimire','2015-07-28 00:01:09',1,'TASK',0),(96,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-07-28 00:02:23',1,'TASK',0),(97,NULL,'NEW','New Activity sa added by Santosh Pun','2015-07-28 08:05:30',6,'ACTIVITY',0),(98,NULL,'NEW','Project project7  updated by Sanjeev Ghimire','2015-07-28 21:13:40',1,'PROJECT',0),(99,NULL,'NEW','Activity project name  updated by Sanjeev Ghimire','2015-08-15 16:30:56',1,'ACTIVITY',0),(101,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(102,NULL,'NEW','Task task2 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(103,NULL,'NEW','Task task5 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(104,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(105,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(106,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(107,NULL,'NEW','Task task2 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(108,NULL,'NEW','Task task3 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(109,NULL,'NEW','Task task4 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(110,NULL,'NEW','Task task11111221 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(111,NULL,'NEW','Task task2222 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(112,NULL,'NEW','Task task222211 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(113,NULL,'NEW','Task task34343434 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(114,NULL,'NEW','Task task32423432423 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(115,NULL,'NEW','Task task342423423 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(116,NULL,'NEW','Task tasdsad2312312 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(117,NULL,'NEW','Task dsadasd updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(118,NULL,'NEW','Task ttttttt242423 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(119,NULL,'NEW','Task dsadasd updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(120,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(121,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(122,NULL,'NEW','Task task225 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(123,NULL,'NEW','Task santosh activity task1 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(124,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(125,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:31:31',1,'TASK',0),(126,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:51:11',1,'TASK',0),(127,NULL,'NEW','Task task2 updated by Sanjeev Ghimire','2015-08-21 07:51:13',1,'TASK',0),(128,NULL,'NEW','Task task5 updated by Sanjeev Ghimire','2015-08-21 07:51:15',1,'TASK',0),(129,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:51:16',1,'TASK',0),(130,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:51:17',1,'TASK',0),(131,NULL,'NEW','Task task3 updated by Sanjeev Ghimire','2015-08-21 07:51:20',1,'TASK',0),(132,NULL,'NEW','Task task2222 updated by Sanjeev Ghimire','2015-08-21 07:51:22',1,'TASK',0),(133,NULL,'NEW','Task task222211 updated by Sanjeev Ghimire','2015-08-21 07:51:24',1,'TASK',0),(134,NULL,'NEW','Task task34343434 updated by Sanjeev Ghimire','2015-08-21 07:51:25',1,'TASK',0),(135,NULL,'NEW','Task task32423432423 updated by Sanjeev Ghimire','2015-08-21 07:51:27',1,'TASK',0),(136,NULL,'NEW','Task task342423423 updated by Sanjeev Ghimire','2015-08-21 07:51:28',1,'TASK',0),(137,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-21 07:57:56',1,'TASK',0),(138,NULL,'NEW','New Project projectsa1 added by Sanjeev Ghimire','2015-08-22 11:55:59',1,'PROJECT',0),(139,NULL,'NEW','New Project project22 added by Sanjeev Ghimire','2015-08-22 11:57:22',1,'PROJECT',0),(140,NULL,'NEW','New Activity activitynew1 added by Sanjeev Ghimire','2015-08-23 19:22:27',1,'ACTIVITY',0),(141,NULL,'NEW','New task task11new added by Sanjeev Ghimire','2015-08-23 19:23:28',1,'TASK',0),(142,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:24:08',1,'TASK',0),(143,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:24:50',1,'TASK',0),(144,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:25:35',1,'TASK',0),(145,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:26:13',1,'TASK',0),(146,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:26:20',1,'TASK',0),(147,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:26:50',1,'TASK',0),(148,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:27:35',1,'TASK',0),(149,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:35:46',1,'TASK',0),(150,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:38:04',1,'TASK',0),(151,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:45:12',1,'TASK',0),(152,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 09:45:23',1,'TASK',0),(153,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 22:41:45',1,'TASK',0),(154,NULL,'NEW','Task task1 updated by Sanjeev Ghimire','2015-08-24 22:54:17',1,'TASK',0),(155,NULL,'NEW','New Activity activity11 added by Sanjeev Ghimire','2015-08-26 20:10:30',1,'ACTIVITY',0),(156,NULL,'NEW','New task task1 added by Sanjeev Ghimire','2015-08-26 20:10:30',1,'TASK',0),(157,NULL,'NEW','Project project1  updated by Sanjeev Ghimire','2015-09-05 07:34:47',1,'PROJECT',0),(158,NULL,'NEW','Project project1  updated by Sanjeev Ghimire','2015-09-05 07:35:35',1,'PROJECT',0),(159,NULL,'NEW','New Activity activity1 added by Sanjeev Ghimire','2015-09-05 07:36:00',1,'ACTIVITY',0),(160,NULL,'NEW','New task task1 added by Sanjeev Ghimire','2015-09-05 07:36:00',1,'TASK',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=835 DEFAULT CHARSET=latin1;

/*Data for the table `user_notification_attribute` */

insert  into `user_notification_attribute`(`id`,`attribute_key`,`attribute_value`,`user_notification_id`) values (1,'notificationType','projectId',1),(2,'notificationId','9',1),(3,'notificationType','activityId',2),(4,'notificationId','10',2),(5,'notificationType','projectId',2),(6,'notificationId','2',2),(7,'notificationType','projectId',3),(8,'notificationId','9',3),(9,'notificationType','projectId',4),(10,'notificationId','9',4),(11,'notificationType','projectId',5),(12,'notificationId','9',5),(13,'notificationType','activityId',6),(14,'notificationId','11',6),(15,'notificationType','projectId',6),(16,'notificationId','2',6),(17,'notificationType','activityId',7),(18,'notificationId','11',7),(19,'notificationType','projectId',7),(20,'notificationId','2',7),(21,'notificationType','taskId',8),(22,'notificationId','3',8),(23,'notificationType','activityId',8),(24,'notificationId','4',8),(25,'notificationType','projectId',8),(26,'notificationId','2',8),(27,'notificationType','taskId',9),(28,'notificationId','1',9),(29,'notificationType','activityId',9),(30,'notificationId','4',9),(31,'notificationType','projectId',9),(32,'notificationId','2',9),(33,'notificationType','taskId',10),(34,'notificationId','1',10),(35,'notificationType','activityId',10),(36,'notificationId','4',10),(37,'notificationType','projectId',10),(38,'notificationId','2',10),(39,'notificationType','taskId',11),(40,'notificationId','1',11),(41,'notificationType','activityId',11),(42,'notificationId','4',11),(43,'notificationType','projectId',11),(44,'notificationId','2',11),(55,'notificationType','commentId',14),(56,'notificationId','3',14),(57,'notificationType','taskId',14),(58,'notificationId','1',14),(59,'notificationType','activityId',14),(60,'notificationId','4',14),(61,'notificationType','projectId',14),(62,'notificationId','2',14),(63,'notificationType','activityId',15),(64,'notificationId','4',15),(65,'notificationType','projectId',15),(66,'notificationId','2',15),(67,'notificationType','taskId',16),(68,'notificationId','4',16),(69,'notificationType','activityId',16),(70,'notificationId','10',16),(71,'notificationType','projectId',16),(72,'notificationId','2',16),(73,'notificationType','taskId',17),(74,'notificationId','4',17),(75,'notificationType','activityId',17),(76,'notificationId','10',17),(77,'notificationType','projectId',17),(78,'notificationId','2',17),(79,'notificationType','commentId',18),(80,'notificationId','4',18),(81,'notificationType','taskId',18),(82,'notificationId','4',18),(83,'notificationType','activityId',18),(84,'notificationId','10',18),(85,'notificationType','projectId',18),(86,'notificationId','2',18),(87,'notificationType','activityId',19),(88,'notificationId','4',19),(89,'notificationType','projectId',19),(90,'notificationId','2',19),(91,'notificationType','projectId',20),(92,'notificationId','9',20),(93,'notificationType','taskId',21),(94,'notificationId','1',21),(95,'notificationType','activityId',21),(96,'notificationId','4',21),(97,'notificationType','projectId',21),(98,'notificationId','2',21),(99,'notificationType','commentId',22),(100,'notificationId','5',22),(101,'notificationType','taskId',22),(102,'notificationId','1',22),(103,'notificationType','activityId',22),(104,'notificationId','4',22),(105,'notificationType','projectId',22),(106,'notificationId','2',22),(107,'notificationType','commentId',23),(108,'notificationId','6',23),(109,'notificationType','taskId',23),(110,'notificationId','4',23),(111,'notificationType','activityId',23),(112,'notificationId','10',23),(113,'notificationType','projectId',23),(114,'notificationId','2',23),(115,'notificationType','commentId',24),(116,'notificationId','7',24),(117,'notificationType','taskId',24),(118,'notificationId','1',24),(119,'notificationType','activityId',24),(120,'notificationId','4',24),(121,'notificationType','projectId',24),(122,'notificationId','2',24),(123,'notificationType','commentId',25),(124,'notificationId','8',25),(125,'notificationType','taskId',25),(126,'notificationId','1',25),(127,'notificationType','activityId',25),(128,'notificationId','4',25),(129,'notificationType','projectId',25),(130,'notificationId','2',25),(131,'notificationType','taskId',26),(132,'notificationId','1',26),(133,'notificationType','activityId',26),(134,'notificationId','4',26),(135,'notificationType','projectId',26),(136,'notificationId','2',26),(137,'notificationType','commentId',27),(138,'notificationId','9',27),(139,'notificationType','taskId',27),(140,'notificationId','3',27),(141,'notificationType','activityId',27),(142,'notificationId','4',27),(143,'notificationType','projectId',27),(144,'notificationId','2',27),(145,'notificationType','commentId',28),(146,'notificationId','10',28),(147,'notificationType','taskId',28),(148,'notificationId','3',28),(149,'notificationType','activityId',28),(150,'notificationId','4',28),(151,'notificationType','projectId',28),(152,'notificationId','2',28),(153,'notificationType','taskId',29),(154,'notificationId','1',29),(155,'notificationType','activityId',29),(156,'notificationId','4',29),(157,'notificationType','projectId',29),(158,'notificationId','2',29),(159,'notificationType','projectId',30),(160,'notificationId','7',30),(161,'notificationType','projectId',31),(162,'notificationId','12',31),(163,'notificationType','projectId',32),(164,'notificationId','12',32),(165,'notificationType','projectId',33),(166,'notificationId','13',33),(167,'notificationType','projectId',34),(168,'notificationId','13',34),(169,'notificationType','activityId',35),(170,'notificationId','4',35),(171,'notificationType','projectId',35),(172,'notificationId','2',35),(173,'notificationType','projectId',36),(174,'notificationId','14',36),(175,'notificationType','projectId',37),(176,'notificationId','15',37),(177,'notificationType','projectId',38),(178,'notificationId','16',38),(179,'notificationType','projectId',39),(180,'notificationId','9',39),(181,'notificationType','projectId',40),(182,'notificationId','16',40),(183,'notificationType','projectId',41),(184,'notificationId','16',41),(185,'notificationType','projectId',42),(186,'notificationId','17',42),(187,'notificationType','projectId',43),(188,'notificationId','18',43),(209,'notificationType','activityId',48),(210,'notificationId','21',48),(211,'notificationType','projectId',48),(212,'notificationId','1',48),(213,'notificationType','taskId',49),(214,'notificationId','7',49),(215,'notificationType','activityId',49),(216,'notificationId','21',49),(217,'notificationType','projectId',49),(218,'notificationId','1',49),(219,'notificationType','activityId',50),(220,'notificationId','22',50),(221,'notificationType','projectId',50),(222,'notificationId','1',50),(223,'notificationType','taskId',51),(224,'notificationId','8',51),(225,'notificationType','activityId',51),(226,'notificationId','22',51),(227,'notificationType','projectId',51),(228,'notificationId','1',51),(229,'notificationType','activityId',52),(230,'notificationId','23',52),(231,'notificationType','projectId',52),(232,'notificationId','1',52),(233,'notificationType','taskId',53),(234,'notificationId','9',53),(235,'notificationType','activityId',53),(236,'notificationId','23',53),(237,'notificationType','projectId',53),(238,'notificationId','1',53),(239,'notificationType','taskId',54),(240,'notificationId','10',54),(241,'notificationType','activityId',54),(242,'notificationId','23',54),(243,'notificationType','projectId',54),(244,'notificationId','1',54),(245,'notificationType','activityId',55),(246,'notificationId','24',55),(247,'notificationType','projectId',55),(248,'notificationId','1',55),(249,'notificationType','taskId',56),(250,'notificationId','11',56),(251,'notificationType','activityId',56),(252,'notificationId','24',56),(253,'notificationType','projectId',56),(254,'notificationId','1',56),(255,'notificationType','activityId',57),(256,'notificationId','25',57),(257,'notificationType','projectId',57),(258,'notificationId','1',57),(259,'notificationType','taskId',58),(260,'notificationId','12',58),(261,'notificationType','activityId',58),(262,'notificationId','25',58),(263,'notificationType','projectId',58),(264,'notificationId','1',58),(265,'notificationType','taskId',59),(266,'notificationId','13',59),(267,'notificationType','activityId',59),(268,'notificationId','4',59),(269,'notificationType','projectId',59),(270,'notificationId','2',59),(271,'notificationType','taskId',60),(272,'notificationId','14',60),(273,'notificationType','activityId',60),(274,'notificationId','4',60),(275,'notificationType','projectId',60),(276,'notificationId','2',60),(277,'notificationType','taskId',61),(278,'notificationId','15',61),(279,'notificationType','activityId',61),(280,'notificationId','4',61),(281,'notificationType','projectId',61),(282,'notificationId','2',61),(283,'notificationType','taskId',62),(284,'notificationId','16',62),(285,'notificationType','activityId',62),(286,'notificationId','4',62),(287,'notificationType','projectId',62),(288,'notificationId','2',62),(289,'notificationType','taskId',63),(290,'notificationId','17',63),(291,'notificationType','activityId',63),(292,'notificationId','4',63),(293,'notificationType','projectId',63),(294,'notificationId','2',63),(295,'notificationType','taskId',64),(296,'notificationId','18',64),(297,'notificationType','activityId',64),(298,'notificationId','4',64),(299,'notificationType','projectId',64),(300,'notificationId','2',64),(301,'notificationType','taskId',65),(302,'notificationId','19',65),(303,'notificationType','activityId',65),(304,'notificationId','4',65),(305,'notificationType','projectId',65),(306,'notificationId','2',65),(307,'notificationType','taskId',66),(308,'notificationId','20',66),(309,'notificationType','activityId',66),(310,'notificationId','4',66),(311,'notificationType','projectId',66),(312,'notificationId','2',66),(313,'notificationType','taskId',67),(314,'notificationId','21',67),(315,'notificationType','activityId',67),(316,'notificationId','4',67),(317,'notificationType','projectId',67),(318,'notificationId','2',67),(319,'notificationType','taskId',68),(320,'notificationId','22',68),(321,'notificationType','activityId',68),(322,'notificationId','4',68),(323,'notificationType','projectId',68),(324,'notificationId','2',68),(325,'notificationType','taskId',69),(326,'notificationId','21',69),(327,'notificationType','activityId',69),(328,'notificationId','4',69),(329,'notificationType','projectId',69),(330,'notificationId','2',69),(331,'notificationType','commentId',70),(332,'notificationId','11',70),(333,'notificationType','taskId',70),(334,'notificationId','21',70),(335,'notificationType','activityId',70),(336,'notificationId','4',70),(337,'notificationType','projectId',70),(338,'notificationId','2',70),(339,'notificationType','commentId',71),(340,'notificationId','12',71),(341,'notificationType','taskId',71),(342,'notificationId','1',71),(343,'notificationType','activityId',71),(344,'notificationId','4',71),(345,'notificationType','projectId',71),(346,'notificationId','2',71),(347,'notificationType','commentId',72),(348,'notificationId','13',72),(349,'notificationType','taskId',72),(350,'notificationId','1',72),(351,'notificationType','activityId',72),(352,'notificationId','4',72),(353,'notificationType','projectId',72),(354,'notificationId','2',72),(355,'notificationType','commentId',73),(356,'notificationId','14',73),(357,'notificationType','taskId',73),(358,'notificationId','1',73),(359,'notificationType','activityId',73),(360,'notificationId','4',73),(361,'notificationType','projectId',73),(362,'notificationId','2',73),(363,'notificationType','commentId',74),(364,'notificationId','15',74),(365,'notificationType','taskId',74),(366,'notificationId','1',74),(367,'notificationType','activityId',74),(368,'notificationId','4',74),(369,'notificationType','projectId',74),(370,'notificationId','2',74),(371,'notificationType','activityId',75),(372,'notificationId','4',75),(373,'notificationType','projectId',75),(374,'notificationId','2',75),(375,'notificationType','activityId',76),(376,'notificationId','26',76),(377,'notificationType','projectId',76),(378,'notificationId','2',76),(379,'notificationType','activityId',77),(380,'notificationId','26',77),(381,'notificationType','projectId',77),(382,'notificationId','2',77),(383,'notificationType','activityId',78),(384,'notificationId','26',78),(385,'notificationType','projectId',78),(386,'notificationId','2',78),(387,'notificationType','projectId',79),(388,'notificationId','27',79),(389,'notificationType','activityId',80),(390,'notificationId','28',80),(391,'notificationType','projectId',80),(392,'notificationId','2',80),(393,'notificationType','activityId',81),(394,'notificationId','22',81),(395,'notificationType','projectId',81),(396,'notificationId','0',81),(397,'notificationType','taskId',82),(398,'notificationId','23',82),(399,'notificationType','activityId',82),(400,'notificationId','2',82),(401,'notificationType','projectId',82),(402,'notificationId','1',82),(403,'notificationType','taskId',83),(404,'notificationId','1',83),(405,'notificationType','activityId',83),(406,'notificationId','4',83),(407,'notificationType','projectId',83),(408,'notificationId','2',83),(409,'notificationType','taskId',84),(410,'notificationId','1',84),(411,'notificationType','activityId',84),(412,'notificationId','4',84),(413,'notificationType','projectId',84),(414,'notificationId','2',84),(415,'notificationType','commentId',85),(416,'notificationId','16',85),(417,'notificationType','taskId',85),(418,'notificationId','1',85),(419,'notificationType','activityId',85),(420,'notificationId','4',85),(421,'notificationType','projectId',85),(422,'notificationId','2',85),(423,'notificationType','taskId',86),(424,'notificationId','21',86),(425,'notificationType','activityId',86),(426,'notificationId','4',86),(427,'notificationType','projectId',86),(428,'notificationId','2',86),(429,'notificationType','activityId',87),(430,'notificationId','29',87),(431,'notificationType','projectId',87),(432,'notificationId','2',87),(433,'notificationType','taskId',88),(434,'notificationId','24',88),(435,'notificationType','activityId',88),(436,'notificationId','29',88),(437,'notificationType','projectId',88),(438,'notificationId','2',88),(439,'notificationType','taskId',89),(440,'notificationId','25',89),(441,'notificationType','activityId',89),(442,'notificationId','4',89),(443,'notificationType','projectId',89),(444,'notificationId','2',89),(445,'notificationType','activityId',90),(446,'notificationId','30',90),(447,'notificationType','projectId',90),(448,'notificationId','2',90),(449,'notificationType','taskId',91),(450,'notificationId','26',91),(451,'notificationType','activityId',91),(452,'notificationId','30',91),(453,'notificationType','projectId',91),(454,'notificationId','2',91),(455,'notificationType','activityId',92),(456,'notificationId','31',92),(457,'notificationType','projectId',92),(458,'notificationId','2',92),(459,'notificationType','taskId',93),(460,'notificationId','27',93),(461,'notificationType','activityId',93),(462,'notificationId','31',93),(463,'notificationType','projectId',93),(464,'notificationId','2',93),(465,'notificationType','activityId',94),(466,'notificationId','32',94),(467,'notificationType','projectId',94),(468,'notificationId','2',94),(469,'notificationType','taskId',95),(470,'notificationId','28',95),(471,'notificationType','activityId',95),(472,'notificationId','32',95),(473,'notificationType','projectId',95),(474,'notificationId','2',95),(475,'notificationType','taskId',96),(476,'notificationId','28',96),(477,'notificationType','activityId',96),(478,'notificationId','32',96),(479,'notificationType','projectId',96),(480,'notificationId','2',96),(481,'notificationType','activityId',97),(482,'notificationId','33',97),(483,'notificationType','projectId',97),(484,'notificationId','2',97),(485,'notificationType','projectId',98),(486,'notificationId','12',98),(487,'notificationType','activityId',99),(488,'notificationId','27',99),(489,'notificationType','projectId',99),(490,'notificationId','2',99),(497,'notificationType','taskId',101),(498,'notificationId','1',101),(499,'notificationType','activityId',101),(500,'notificationId','4',101),(501,'notificationType','projectId',101),(502,'notificationId','2',101),(503,'notificationType','taskId',102),(504,'notificationId','3',102),(505,'notificationType','activityId',102),(506,'notificationId','4',102),(507,'notificationType','projectId',102),(508,'notificationId','2',102),(509,'notificationType','taskId',103),(510,'notificationId','4',103),(511,'notificationType','activityId',103),(512,'notificationId','10',103),(513,'notificationType','projectId',103),(514,'notificationId','2',103),(515,'notificationType','taskId',104),(516,'notificationId','7',104),(517,'notificationType','activityId',104),(518,'notificationId','21',104),(519,'notificationType','projectId',104),(520,'notificationId','1',104),(521,'notificationType','taskId',105),(522,'notificationId','8',105),(523,'notificationType','activityId',105),(524,'notificationId','22',105),(525,'notificationType','projectId',105),(526,'notificationId','0',105),(527,'notificationType','taskId',106),(528,'notificationId','9',106),(529,'notificationType','activityId',106),(530,'notificationId','23',106),(531,'notificationType','projectId',106),(532,'notificationId','1',106),(533,'notificationType','taskId',107),(534,'notificationId','10',107),(535,'notificationType','activityId',107),(536,'notificationId','23',107),(537,'notificationType','projectId',107),(538,'notificationId','1',107),(539,'notificationType','taskId',108),(540,'notificationId','11',108),(541,'notificationType','activityId',108),(542,'notificationId','24',108),(543,'notificationType','projectId',108),(544,'notificationId','1',108),(545,'notificationType','taskId',109),(546,'notificationId','12',109),(547,'notificationType','activityId',109),(548,'notificationId','25',109),(549,'notificationType','projectId',109),(550,'notificationId','1',109),(551,'notificationType','taskId',110),(552,'notificationId','13',110),(553,'notificationType','activityId',110),(554,'notificationId','4',110),(555,'notificationType','projectId',110),(556,'notificationId','2',110),(557,'notificationType','taskId',111),(558,'notificationId','14',111),(559,'notificationType','activityId',111),(560,'notificationId','4',111),(561,'notificationType','projectId',111),(562,'notificationId','2',111),(563,'notificationType','taskId',112),(564,'notificationId','15',112),(565,'notificationType','activityId',112),(566,'notificationId','4',112),(567,'notificationType','projectId',112),(568,'notificationId','2',112),(569,'notificationType','taskId',113),(570,'notificationId','16',113),(571,'notificationType','activityId',113),(572,'notificationId','4',113),(573,'notificationType','projectId',113),(574,'notificationId','2',113),(575,'notificationType','taskId',114),(576,'notificationId','17',114),(577,'notificationType','activityId',114),(578,'notificationId','4',114),(579,'notificationType','projectId',114),(580,'notificationId','2',114),(581,'notificationType','taskId',115),(582,'notificationId','18',115),(583,'notificationType','activityId',115),(584,'notificationId','4',115),(585,'notificationType','projectId',115),(586,'notificationId','2',115),(587,'notificationType','taskId',116),(588,'notificationId','19',116),(589,'notificationType','activityId',116),(590,'notificationId','4',116),(591,'notificationType','projectId',116),(592,'notificationId','2',116),(593,'notificationType','taskId',117),(594,'notificationId','20',117),(595,'notificationType','activityId',117),(596,'notificationId','4',117),(597,'notificationType','projectId',117),(598,'notificationId','2',117),(599,'notificationType','taskId',118),(600,'notificationId','21',118),(601,'notificationType','activityId',118),(602,'notificationId','4',118),(603,'notificationType','projectId',118),(604,'notificationId','2',118),(605,'notificationType','taskId',119),(606,'notificationId','22',119),(607,'notificationType','activityId',119),(608,'notificationId','4',119),(609,'notificationType','projectId',119),(610,'notificationId','2',119),(611,'notificationType','taskId',120),(612,'notificationId','23',120),(613,'notificationType','activityId',120),(614,'notificationId','2',120),(615,'notificationType','projectId',120),(616,'notificationId','1',120),(617,'notificationType','taskId',121),(618,'notificationId','24',121),(619,'notificationType','activityId',121),(620,'notificationId','29',121),(621,'notificationType','projectId',121),(622,'notificationId','2',121),(623,'notificationType','taskId',122),(624,'notificationId','25',122),(625,'notificationType','activityId',122),(626,'notificationId','4',122),(627,'notificationType','projectId',122),(628,'notificationId','2',122),(629,'notificationType','taskId',123),(630,'notificationId','26',123),(631,'notificationType','activityId',123),(632,'notificationId','30',123),(633,'notificationType','projectId',123),(634,'notificationId','2',123),(635,'notificationType','taskId',124),(636,'notificationId','27',124),(637,'notificationType','activityId',124),(638,'notificationId','31',124),(639,'notificationType','projectId',124),(640,'notificationId','2',124),(641,'notificationType','taskId',125),(642,'notificationId','28',125),(643,'notificationType','activityId',125),(644,'notificationId','32',125),(645,'notificationType','projectId',125),(646,'notificationId','2',125),(647,'notificationType','taskId',126),(648,'notificationId','1',126),(649,'notificationType','activityId',126),(650,'notificationId','4',126),(651,'notificationType','projectId',126),(652,'notificationId','2',126),(653,'notificationType','taskId',127),(654,'notificationId','3',127),(655,'notificationType','activityId',127),(656,'notificationId','4',127),(657,'notificationType','projectId',127),(658,'notificationId','2',127),(659,'notificationType','taskId',128),(660,'notificationId','4',128),(661,'notificationType','activityId',128),(662,'notificationId','10',128),(663,'notificationType','projectId',128),(664,'notificationId','2',128),(665,'notificationType','taskId',129),(666,'notificationId','8',129),(667,'notificationType','activityId',129),(668,'notificationId','22',129),(669,'notificationType','projectId',129),(670,'notificationId','0',129),(671,'notificationType','taskId',130),(672,'notificationId','9',130),(673,'notificationType','activityId',130),(674,'notificationId','23',130),(675,'notificationType','projectId',130),(676,'notificationId','1',130),(677,'notificationType','taskId',131),(678,'notificationId','11',131),(679,'notificationType','activityId',131),(680,'notificationId','24',131),(681,'notificationType','projectId',131),(682,'notificationId','1',131),(683,'notificationType','taskId',132),(684,'notificationId','14',132),(685,'notificationType','activityId',132),(686,'notificationId','4',132),(687,'notificationType','projectId',132),(688,'notificationId','2',132),(689,'notificationType','taskId',133),(690,'notificationId','15',133),(691,'notificationType','activityId',133),(692,'notificationId','4',133),(693,'notificationType','projectId',133),(694,'notificationId','2',133),(695,'notificationType','taskId',134),(696,'notificationId','16',134),(697,'notificationType','activityId',134),(698,'notificationId','4',134),(699,'notificationType','projectId',134),(700,'notificationId','2',134),(701,'notificationType','taskId',135),(702,'notificationId','17',135),(703,'notificationType','activityId',135),(704,'notificationId','4',135),(705,'notificationType','projectId',135),(706,'notificationId','2',135),(707,'notificationType','taskId',136),(708,'notificationId','18',136),(709,'notificationType','activityId',136),(710,'notificationId','4',136),(711,'notificationType','projectId',136),(712,'notificationId','2',136),(713,'notificationType','taskId',137),(714,'notificationId','1',137),(715,'notificationType','activityId',137),(716,'notificationId','4',137),(717,'notificationType','projectId',137),(718,'notificationId','2',137),(719,'notificationType','projectId',138),(720,'notificationId','34',138),(721,'notificationType','projectId',139),(722,'notificationId','35',139),(723,'notificationType','activityId',140),(724,'notificationId','38',140),(725,'notificationType','projectId',140),(726,'notificationId','2',140),(727,'notificationType','taskId',141),(728,'notificationId','29',141),(729,'notificationType','activityId',141),(730,'notificationId','38',141),(731,'notificationType','projectId',141),(732,'notificationId','2',141),(733,'notificationType','taskId',142),(734,'notificationId','7',142),(735,'notificationType','activityId',142),(736,'notificationId','21',142),(737,'notificationType','projectId',142),(738,'notificationId','1',142),(739,'notificationType','taskId',143),(740,'notificationId','7',143),(741,'notificationType','activityId',143),(742,'notificationId','21',143),(743,'notificationType','projectId',143),(744,'notificationId','1',143),(745,'notificationType','taskId',144),(746,'notificationId','7',144),(747,'notificationType','activityId',144),(748,'notificationId','21',144),(749,'notificationType','projectId',144),(750,'notificationId','1',144),(751,'notificationType','taskId',145),(752,'notificationId','7',145),(753,'notificationType','activityId',145),(754,'notificationId','21',145),(755,'notificationType','projectId',145),(756,'notificationId','1',145),(757,'notificationType','taskId',146),(758,'notificationId','7',146),(759,'notificationType','activityId',146),(760,'notificationId','21',146),(761,'notificationType','projectId',146),(762,'notificationId','1',146),(763,'notificationType','taskId',147),(764,'notificationId','7',147),(765,'notificationType','activityId',147),(766,'notificationId','21',147),(767,'notificationType','projectId',147),(768,'notificationId','1',147),(769,'notificationType','taskId',148),(770,'notificationId','7',148),(771,'notificationType','activityId',148),(772,'notificationId','21',148),(773,'notificationType','projectId',148),(774,'notificationId','1',148),(775,'notificationType','taskId',149),(776,'notificationId','7',149),(777,'notificationType','activityId',149),(778,'notificationId','21',149),(779,'notificationType','projectId',149),(780,'notificationId','1',149),(781,'notificationType','taskId',150),(782,'notificationId','7',150),(783,'notificationType','activityId',150),(784,'notificationId','21',150),(785,'notificationType','projectId',150),(786,'notificationId','1',150),(787,'notificationType','taskId',151),(788,'notificationId','7',151),(789,'notificationType','activityId',151),(790,'notificationId','21',151),(791,'notificationType','projectId',151),(792,'notificationId','1',151),(793,'notificationType','taskId',152),(794,'notificationId','7',152),(795,'notificationType','activityId',152),(796,'notificationId','21',152),(797,'notificationType','projectId',152),(798,'notificationId','1',152),(799,'notificationType','taskId',153),(800,'notificationId','7',153),(801,'notificationType','activityId',153),(802,'notificationId','21',153),(803,'notificationType','projectId',153),(804,'notificationId','1',153),(805,'notificationType','taskId',154),(806,'notificationId','7',154),(807,'notificationType','activityId',154),(808,'notificationId','21',154),(809,'notificationType','projectId',154),(810,'notificationId','1',154),(811,'notificationType','activityId',155),(812,'notificationId','39',155),(813,'notificationType','projectId',155),(814,'notificationId','1',155),(815,'notificationType','taskId',156),(816,'notificationId','30',156),(817,'notificationType','activityId',156),(818,'notificationId','39',156),(819,'notificationType','projectId',156),(820,'notificationId','1',156),(821,'notificationType','projectId',157),(822,'notificationId','2',157),(823,'notificationType','projectId',158),(824,'notificationId','2',158),(825,'notificationType','activityId',159),(826,'notificationId','40',159),(827,'notificationType','projectId',159),(828,'notificationId','2',159),(829,'notificationType','taskId',160),(830,'notificationId','31',160),(831,'notificationType','activityId',160),(832,'notificationId','40',160),(833,'notificationType','projectId',160),(834,'notificationId','2',160);

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

/*Data for the table `user_profile` */

insert  into `user_profile`(`user_profile_id`,`menu_profile_id`,`permission_profile_id`,`user_id`) values (1,1,4,1),(2,1,4,7),(3,1,4,8);

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

insert  into `user_safety_info`(`id`,`name`,`info`,`discipline_id`,`ts_create`) values (2,'10 fingers, 10 toes 2 eyes 1 nose…safety counts','',1,'2014-12-03 03:26:53'),(3,'10 fingers. 10 toes, If you are not safe Who knows?','',2,'2014-12-03 03:26:53'),(4,'A clean floor everyday keeps lost days away.','',3,'2014-12-03 03:26:53'),(5,'A spill, a slip, a hospital trip','',4,'2014-12-03 03:26:53'),(6,'A tree never hits an automobile except in self defense','',5,'2014-12-03 03:26:53'),(7,'Accidents Big Or Small, Avoid Them All','',1,'2014-12-03 03:26:53'),(8,'Accidents hurt, Safety doesn’t.','',2,'2014-12-03 03:26:53'),(9,'An ounce of prevention is worth a pound of cure','',3,'2014-12-03 03:26:53'),(10,'Are you part of the safety TEAM….(Together Employees Accomplish More)','',4,'2014-12-03 03:26:53'),(11,'Arms work best when attached to the body','',5,'2014-12-03 03:26:54'),(12,'At work at play, let safety lead the way.','',1,'2014-12-03 03:26:54'),(13,'Avoid the worst. Put safety first.','',2,'2014-12-03 03:26:54'),(14,'Be a safety hero – score an accident zero','',3,'2014-12-03 03:26:54'),(15,'Be alert! Accidents hurt.','',4,'2014-12-03 03:26:54'),(16,'Be aware Take care','',5,'2014-12-03 03:26:54'),(17,'Before you do it, take time to think through it.','',1,'2014-12-03 03:26:54'),(18,'Behind the wheel, anger is one letter away from danger.','',2,'2014-12-03 03:26:54'),(19,'Being safe is in your own hands.','',3,'2014-12-03 03:26:54'),(20,'Best gift you can give your family is YOU! Please be safe','',4,'2014-12-03 03:26:54'),(21,'Break the drive and arrive alive.','',5,'2014-12-03 03:26:54'),(22,'Chance takers are accident makers','',2,'2014-12-03 03:26:54'),(23,'Choose safety, for your family.','',1,'2014-12-03 03:26:54'),(24,'Click clack front and back.','',3,'2014-12-03 03:26:55'),(25,'Click it or ticket!','',4,'2014-12-03 03:26:55'),(26,'Computer problems you can avoid, so you don’t have to get paranoid.','',1,'2014-12-03 03:26:55'),(27,'Courtesy and common sense promote safety.','',2,'2014-12-03 03:26:55'),(28,'Courtesy is contagious','',1,'2014-12-03 03:26:55'),(29,'Dare to be aware.','',4,'2014-12-03 03:26:55'),(30,'Do you have eye for safety or are you blinded by bad habits','',1,'2014-12-03 03:26:55'),(31,'Doesn’t matter how far. JUST BELT UP!','',2,'2014-12-03 03:26:55'),(32,'Don’t be a fool, cause safety is cool, so make that your rule.','',3,'2014-12-03 03:26:55'),(33,'Don’t be a fool. Use the proper tool.','',5,'2014-12-03 03:26:55'),(34,'Don’t be hasty when it comes to safety.','',1,'2014-12-03 03:26:55'),(35,'Don’t be safety blinded, be safety minded.','',2,'2014-12-03 03:26:55'),(36,'Don’t learn safety by accident.','',3,'2014-12-03 03:26:55'),(37,'Don’t leave Private information on a public computer screen','',4,'2014-12-03 03:26:55'),(38,'Eyes are priceless, eye protection is cheap.','',5,'2014-12-03 03:26:55'),(39,'Falling objects can be brutal if you don’t protect your noodle.','',2,'2014-12-03 03:26:55'),(40,'Fingers toes, If you are not safe Who knows?','',3,'2014-12-03 03:26:55'),(41,'Forget the nurse with safety first.','',4,'2014-12-03 03:26:55'),(42,'Forgot your hearing protection? Forget about hearing!','',5,'2014-12-03 03:26:55'),(43,'Get in high speed pursuit of safety','',1,'2014-12-03 03:26:56'),(44,'Get smart! Use safety from the start.','',2,'2014-12-03 03:26:56'),(45,'Give them a Brake!','',3,'2014-12-03 03:26:56'),(46,'Got crazy with the lighter? Call a firefighter.','',4,'2014-12-03 03:26:56'),(47,'Hard hats, they’re not just for decoration','',5,'2014-12-03 03:26:56'),(48,'Have another day by being safe today!','',1,'2014-12-03 03:26:56'),(49,'Hearing protection is a sound investment.','',1,'2014-12-03 03:26:56'),(50,'Housekeeping you skip may cause a fall or slip.','',1,'2014-12-03 03:26:56'),(51,'If everything comes your way, you are in the wrong lane.','',1,'2014-12-03 03:26:56'),(52,'If they email you asking for cash, be sure to throw it in the trash.','',1,'2014-12-03 03:26:56'),(53,'If they email you asking for Money, Say no thanks I won’t fall for it honey.','',2,'2014-12-03 03:26:56'),(54,'If you don’t know the sender, it might be a pretender','',3,'2014-12-03 03:26:56'),(55,'If you don’t think it will happen to you, find the person who had it happen to them','',1,'2014-12-03 03:26:56'),(56,'If you mess up, ‘fess up','',1,'2014-12-03 03:26:56'),(57,'Is better to lose one minute in life… than to lose life in a minute.','',1,'2014-12-03 03:26:56'),(58,'It only takes one mistake to bring us all down; don’t let it be yours!','',1,'2014-12-03 03:26:57'),(59,'It’s easier to ask a dumb question than it is to fix a dumb mistake','',1,'2014-12-03 03:26:57'),(60,'Keep a grip on life and protect your hands','',1,'2014-12-03 03:26:57'),(61,'Keep safety in mind. It will save your behind.','',1,'2014-12-03 03:26:57'),(62,'Keeping your work area clean, helps keep hazards from being unseen.','',1,'2014-12-03 03:26:57'),(63,'Knock out…accidents','',1,'2014-12-03 03:26:57'),(64,'Know safety – no pain','',1,'2014-12-03 03:26:57'),(65,'Know safety No Accidents','',1,'2014-12-03 03:26:57'),(66,'Lead the way, safety today.','',1,'2014-12-03 03:26:57'),(67,'Learn from others mistakes, don’t have others learn from you.','',1,'2014-12-03 03:26:57'),(68,'Let’s all keep our heads, and other body parts, together','',1,'2014-12-03 03:26:57'),(69,'Life’s short, don’t rush it','',1,'2014-12-03 03:26:57'),(70,'Light up your tree – not your home','',1,'2014-12-03 03:26:57'),(71,'Make it your mission, not to live in unsafe condition.','',1,'2014-12-03 03:26:57'),(72,'Make safety a reality and don’t be a fatality','',1,'2014-12-03 03:26:57'),(73,'My job provides my paycheck, but safety takes me home.','',1,'2014-12-03 03:26:57'),(74,'Near miss reported today, is the accident that does not happen tomorrow.','',1,'2014-12-03 03:26:57'),(75,'Never drive faster than your guardian angel can fly','',1,'2014-12-03 03:26:57'),(76,'Never give safety a day off','',1,'2014-12-03 03:26:57'),(77,'No Belt. No Brains','',1,'2014-12-03 03:26:57'),(78,'No safety – know pain','',1,'2014-12-03 03:26:57'),(79,'One bad day at the grinder could ruin your whole life','',1,'2014-12-03 03:26:57'),(80,'Only You can prevent forest fires!','',1,'2014-12-03 03:26:57'),(81,'Pencils have erasers–mishaps don’t!','',1,'2014-12-03 03:26:58'),(82,'Prevent a jam, don’t open spam','',1,'2014-12-03 03:26:58'),(83,'Protect your hands, you need them to pick up your pay check','',1,'2014-12-03 03:26:58'),(84,'Quench the thirst – safety first','',1,'2014-12-03 03:26:58'),(85,'Replacing a saw guard is easier than replacing a finger','',1,'2014-12-03 03:26:58'),(86,'Safe crane operation is uplifting','',1,'2014-12-03 03:26:58'),(87,'Safety – A small investment for a rich future','',1,'2014-12-03 03:26:58'),(88,'Safety by Choice, Not by Chance.','',1,'2014-12-03 03:26:58'),(89,'Safety comes in a can, I can, You can, We can be safe.','',1,'2014-12-03 03:26:58'),(90,'Safety doesn’t happen by accident','',1,'2014-12-03 03:26:58'),(91,'Safety first makes us last.','',1,'2014-12-03 03:26:58'),(92,'Safety First, Avoid the Worst.','',1,'2014-12-03 03:26:58'),(93,'Safety first, to last.','',1,'2014-12-03 03:26:58'),(94,'Safety first…because accidents last.','',1,'2014-12-03 03:26:58'),(95,'Safety fits like a glove; Try one on.','',1,'2014-12-03 03:26:58'),(96,'Safety Glasses – All in favor say EYE','',1,'2014-12-03 03:26:58'),(97,'Safety in – we win','',1,'2014-12-03 03:26:58'),(98,'Safety is a cheap and effective insurance policy','',1,'2014-12-03 03:26:58'),(99,'Safety is a continuing journey, not a final destination.','',1,'2014-12-03 03:26:58'),(100,'Safety is a frame of mind – So concentrate on it all the time.','',1,'2014-12-03 03:26:59'),(101,'Safety is a Frame of Mind, Get the Picture.','',1,'2014-12-03 03:26:59'),(102,'Safety is a full time job – don’t make it a part time practice','',1,'2014-12-03 03:26:59'),(103,'Safety is a mission not an intermission','',1,'2014-12-03 03:26:59'),(104,'Safety is about doing the right thing, even if no one is looking.','',1,'2014-12-03 03:26:59'),(105,'Safety is as simple as ABC – Always Be Careful','',1,'2014-12-03 03:26:59'),(106,'Safety is like a lock – But you are the key.','',1,'2014-12-03 03:26:59'),(107,'Safety is no accident','',1,'2014-12-03 03:26:59'),(108,'Safety is success by purpose – Not Accident.','',1,'2014-12-03 03:26:59'),(109,'Safety isn’t a hobby, it’s a living.','',1,'2014-12-03 03:26:59'),(110,'Safety isn’t expensive it’s priceless.','',1,'2014-12-03 03:26:59'),(111,'Safety isn’t just a slogan, it’s a way of life.','',1,'2014-12-03 03:26:59'),(112,'Safety makes good dollars and sense','',1,'2014-12-03 03:26:59'),(113,'Safety rules are there to follow. So take care and we will see you tomorrow.','',1,'2014-12-03 03:26:59'),(114,'Safety rules are your best tools.','',1,'2014-12-03 03:26:59'),(115,'Safety saves, Accidents cost you.','',1,'2014-12-03 03:26:59'),(116,'Safety starts with “S” but begins with “YOU”.','',1,'2014-12-03 03:27:00'),(117,'Safety starts with me.','',1,'2014-12-03 03:27:00'),(118,'Safety: more fun than running with scissors','',1,'2014-12-03 03:27:00'),(119,'Safety… It can charm you, or ALARM you!','',1,'2014-12-03 03:27:00'),(120,'Safety…Did it, done it, doing it tomorrow','',1,'2014-12-03 03:27:00'),(121,'Safety…one habit you never need to break','',1,'2014-12-03 03:27:00'),(122,'Save tomorrow. Think safety today.','',1,'2014-12-03 03:27:00'),(123,'Seat Belts are for kids – Hug them at home – Belt them in the car','',1,'2014-12-03 03:27:00'),(124,'Seatbelts save lives. Buckle up everytime.','',1,'2014-12-03 03:27:00'),(125,'Shortcuts cut life short','',1,'2014-12-03 03:27:00'),(126,'Speed Thrills but Kills.','',1,'2014-12-03 03:27:00'),(127,'Stay safe, someone at home is waiting for you.','',1,'2014-12-03 03:27:00'),(128,'Stop drop & roll','',1,'2014-12-03 03:27:00'),(129,'Success is no accident','',1,'2014-12-03 03:27:00'),(130,'The best car safety device is a rear-view mirror with a cop in it.','',1,'2014-12-03 03:27:00'),(131,'The door to Safety swings on the hinges of common sense','',1,'2014-12-03 03:27:00'),(132,'The only trip you take should be on vacation.','',1,'2014-12-03 03:27:00'),(133,'The safe way is the only way.','',1,'2014-12-03 03:27:00'),(134,'The stupid shall be punished','',1,'2014-12-03 03:27:00'),(135,'Think Safety, Because I Love You Man.','',1,'2014-12-03 03:27:00'),(136,'Think sharp….never handle broken glass with bare hands.','',1,'2014-12-03 03:27:00'),(137,'Think smart before you start.','',1,'2014-12-03 03:27:00'),(138,'Those precious fingers don’t ignore, Or they could end up on the floor.','',1,'2014-12-03 03:27:00'),(139,'Those who work the safest way- live to see another day','',1,'2014-12-03 03:27:01'),(140,'To avoid a scene keep your work place clean.','',1,'2014-12-03 03:27:01'),(141,'To prevent a drastic call, Install a firewall','',1,'2014-12-03 03:27:01'),(142,'Tomorrow: Your reward for working safely today.','',1,'2014-12-03 03:27:01'),(143,'Trying to make up time could cost you your life.','',1,'2014-12-03 03:27:01'),(144,'Unsafe acts will keep you in stitches','',1,'2014-12-03 03:27:01'),(145,'Watch where you walk or you might need a walker.','',1,'2014-12-03 03:27:01'),(146,'Watch your step – it could be your last tomorrow','',1,'2014-12-03 03:27:01'),(147,'whats holding you back?','',1,'2014-12-03 03:27:01'),(148,'When you gamble with safety ..You bet your life.','',1,'2014-12-03 03:27:01'),(149,'While on a ladder, never step back to admire your work','',1,'2014-12-03 03:27:01'),(150,'Wipe Up and avoid a Slip Up!','',1,'2014-12-03 03:27:01'),(151,'Work safe today–heaven can wait.','',1,'2014-12-03 03:27:01'),(152,'Work together…work safely.','',1,'2014-12-03 03:27:01'),(153,'Working safely may get old, but so do those who practice it.','',1,'2014-12-03 03:27:01'),(154,'Your first mistake could be your last','',1,'2014-12-03 03:27:01'),(155,'Your reward for working safely today.','',1,'2014-12-03 03:27:01'),(156,'Your wife will spend your 401K; If you get killed at work today.','',1,'2014-12-03 03:27:01'),(157,'Protect your hands, you need them to pick up your pay check','',1,'2014-12-03 03:27:01'),(158,'Your wife will spend your 401K; If you get killed at work today','',1,'2014-12-03 03:27:01'),(159,'Safety…Did it, done it, doing it tomorrow','',1,'2014-12-03 03:27:01'),(160,'Watch your step - it could be your last tomorrow','',1,'2014-12-03 03:27:01'),(161,'Those precious fingers don’t ignore. . . Or they could end up on the floor','',1,'2014-12-03 03:27:01'),(162,'Your reward for working safely today.','',1,'2014-12-03 03:27:02'),(163,'Those who work the safest way- live to see another day','',1,'2014-12-03 03:27:02'),(164,'Get in high speed pursuit of safety','',1,'2014-12-03 03:27:02'),(165,'Seat Belts are for kids - Hug them at home - Belt them in the car','',1,'2014-12-03 03:27:02'),(166,'Safe crane operation is uplifting','',1,'2014-12-03 03:27:02'),(167,'Pencils have erasers–mishaps don’t!','',1,'2014-12-03 03:27:02'),(168,'Work safe today–heaven can wait.','',1,'2014-12-03 03:27:02'),(169,'Safety is a mission not an intermission','',1,'2014-12-03 03:27:02'),(170,'Safety doesn’t happen by accident','',1,'2014-12-03 03:27:02'),(171,'A spill, a slip, a hospital trip ','',1,'2014-12-03 03:27:02'),(172,'Falling objects can be brutal if you don’t protect your noodle','',1,'2014-12-03 03:27:02'),(173,'Safety glasses: All in favor say “Eye!”','',1,'2014-12-03 03:27:02'),(174,'It’s easier to ask a dumb question than it is to fix a dumb mistake','',1,'2014-12-03 03:27:02'),(175,'Safety isn’t a hobby, it’s a living.','',1,'2014-12-03 03:27:02'),(176,'Safety - A small investment for a rich future','',1,'2014-12-03 03:27:02'),(177,'Safety is no accident','',1,'2014-12-03 03:27:02'),(178,'Safety is a cheap and effective insurance policy','',1,'2014-12-03 03:27:02'),(179,'Let’s all keep our heads, and other body parts, together','',1,'2014-12-03 03:27:02'),(180,'While on a ladder, never step back to admire your work','',1,'2014-12-03 03:27:02'),(181,'Quench the thirst – safety first','',1,'2014-12-03 03:27:02'),(182,'When you gamble with safety you bet your life','',1,'2014-12-03 03:27:02'),(183,'The stupid shall be punished','',1,'2014-12-03 03:27:02'),(184,'Chance takers are accident makers','',1,'2014-12-03 03:27:02'),(185,'Safety is a full time job; don’t make it a part time practice','',1,'2014-12-03 03:27:02'),(186,'The door to Safety swings on the hinges of common sense','',1,'2014-12-03 03:27:02'),(187,'Is better to lose one minute in life… than to lose life in a minute.','',1,'2014-12-03 03:27:02'),(188,'Safety — a small investment for a rich future','',1,'2014-12-03 03:27:03'),(189,'Your first mistake could be your last','',1,'2014-12-03 03:27:03'),(190,'Safety isn’t expensive it’s priceless.','',1,'2014-12-03 03:27:03'),(191,'Safety is as simple as ABC…Always Be Careful','',1,'2014-12-03 03:27:03'),(192,'Unsafe acts will keep you in stitches','',1,'2014-12-03 03:27:03'),(193,'Knock out…accidents','',1,'2014-12-03 03:27:03'),(194,'If you mess up, ‘fess up','',1,'2014-12-03 03:27:03'),(195,'Hard hats, they’re not just for decoration','',1,'2014-12-03 03:27:03'),(196,'If you don’t think it will happen to you, find the person who had it happen to them','',1,'2014-12-03 03:27:03'),(197,'Keep safety in mind. It will save your behind.','',1,'2014-12-03 03:27:03'),(198,'One bad day at the grinder could ruin your whole life','',1,'2014-12-03 03:27:03'),(199,'Shortcuts cut life short','',1,'2014-12-03 03:27:03');

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

/*Data for the table `user_session_info` */

insert  into `user_session_info`(`user_session_info_id`,`user_id`,`login_token`,`created_date`,`expire_date`,`is_expired`) values (1,1,'3f23fbf2-8e9e-4426-8a64-651c09909f55','2015-06-26 09:21:37','9999-12-31 00:00:00','1'),(2,1,'784c6817-7074-42fa-af20-914eca545484','2015-06-26 20:44:24','9999-12-31 00:00:00','1'),(3,1,'ba7cf9de-291f-4d96-8375-d4b6c1512776','2015-06-26 21:12:53','9999-12-31 00:00:00','1'),(4,1,'e8f3d700-97e1-468d-9472-3e19688c053f','2015-06-26 21:12:59','9999-12-31 00:00:00','1'),(5,1,'d4ae15db-e282-4990-a9a8-998e40778b6e','2015-06-26 21:13:19','9999-12-31 00:00:00','1'),(6,1,'23270a2e-c202-4ec2-8f6c-a8496105bbbf','2015-06-26 21:16:19','9999-12-31 00:00:00','1'),(7,1,'daade456-efaf-43ec-b5b7-b480a095aaa2','2015-06-27 06:59:43','9999-12-31 00:00:00','1'),(8,1,'77e83be4-966f-44ec-9e0c-084a399394de','2015-06-27 07:00:22','9999-12-31 00:00:00','1'),(9,1,'58c00cbd-7dc6-4515-81f4-9b1990e4532a','2015-06-27 07:07:36','9999-12-31 00:00:00','1'),(10,1,'01e577f9-e144-4cbf-93f3-fde6b0ac7af6','2015-06-27 07:09:34','9999-12-31 00:00:00','1'),(11,1,'10b7528a-2929-4c04-9af9-d9af8ae3deb5','2015-06-27 07:21:50','9999-12-31 00:00:00','1'),(12,1,'77173703-1605-4829-8f20-f088b32c03f1','2015-06-27 07:32:35','9999-12-31 00:00:00','1'),(13,1,'3dfd836e-391b-4c37-88c2-57a6844096f4','2015-06-27 19:15:58','9999-12-31 00:00:00','1'),(14,2,'0234ce9b-91b4-4196-9077-b87ab0f88409','2015-06-27 19:17:26','9999-12-31 00:00:00','0'),(15,1,'69df8232-c4cc-439d-8f1c-7cd74e9ba241','2015-06-27 21:58:24','9999-12-31 00:00:00','1'),(16,2,'eb746a85-f94c-4627-b718-1196b8ed54e4','2015-06-27 21:59:01','9999-12-31 00:00:00','0'),(17,1,'0bc15cac-cad1-48e2-aac3-3b85718dc8d6','2015-06-27 21:59:08','9999-12-31 00:00:00','1'),(18,1,'c2fb909a-3f06-49b7-aff5-ea65a3a27f3e','2015-06-27 22:07:42','9999-12-31 00:00:00','1'),(19,1,'bbed87de-820a-4499-8f14-223a26854f02','2015-06-27 22:10:23','9999-12-31 00:00:00','1'),(20,3,'ee80d174-e196-4bc8-ae57-3d81a57491fb','2015-06-27 22:19:54','9999-12-31 00:00:00','0'),(21,4,'4a1f991c-0432-41e2-af73-1dba2d9995f5','2015-06-27 22:25:47','9999-12-31 00:00:00','0'),(22,1,'da3c2460-1695-45e6-87ba-e8694cb36fe6','2015-06-27 22:46:29','9999-12-31 00:00:00','1'),(23,1,'d4cf7f37-7cba-4f94-9fa1-aa5bc61acd2c','2015-06-27 22:47:06','9999-12-31 00:00:00','1'),(24,1,'6cc2c1a4-27e8-4f6d-b7fc-c97ac66bef83','2015-06-27 22:56:06','9999-12-31 00:00:00','1'),(25,1,'dddfe65c-b46a-46a9-9294-d8c410fbcd86','2015-06-27 22:56:27','9999-12-31 00:00:00','1'),(26,1,'e8b54ab2-a888-4e23-b1d1-e43ae299c2ee','2015-06-27 22:57:21','9999-12-31 00:00:00','1'),(27,1,'680cb354-a019-4bf1-a9ce-6433ed8a8e6c','2015-06-27 22:57:59','9999-12-31 00:00:00','1'),(28,1,'def4a2a9-14b0-4b4f-a0bf-1ab1bb658fe5','2015-06-27 22:58:46','9999-12-31 00:00:00','1'),(29,1,'e9373366-5eca-4682-9362-ac1f51e0f829','2015-06-27 22:59:12','9999-12-31 00:00:00','1'),(30,1,'65be7067-fc23-4560-88d7-1f3bd5cba1ab','2015-06-27 23:00:28','9999-12-31 00:00:00','1'),(31,2,'0030b04f-2d79-4b74-9429-dea07817b38b','2015-06-27 23:00:38','9999-12-31 00:00:00','0'),(32,1,'53a8a343-4888-4fa1-a598-c9be50b87af1','2015-06-27 23:00:59','9999-12-31 00:00:00','1'),(33,1,'6f102a6a-fc1e-4956-a732-3c879863a432','2015-06-27 23:01:35','9999-12-31 00:00:00','1'),(34,2,'5e848c8c-fc0c-42b7-b1d5-db46251a5e39','2015-06-27 23:02:56','9999-12-31 00:00:00','0'),(35,1,'6a91bacb-78fa-46d6-ae99-0b95df8c6bad','2015-06-27 23:12:48','9999-12-31 00:00:00','1'),(36,2,'b57d8fae-bf0b-4178-aaca-0015204bc492','2015-06-27 23:55:07','9999-12-31 00:00:00','0'),(37,1,'f427fb31-65e0-4b60-9e3a-c00c0db5d49c','2015-06-28 19:28:51','9999-12-31 00:00:00','1'),(38,1,'5da0093a-30a6-499e-bc27-cd4794c44be9','2015-06-28 20:17:29','9999-12-31 00:00:00','1'),(39,1,'b9401845-c65b-4caa-aca2-79d5e784826c','2015-06-28 23:10:01','9999-12-31 00:00:00','1'),(40,1,'254cbddf-5803-4988-8f07-90df2d034b37','2015-06-29 07:27:46','9999-12-31 00:00:00','1'),(41,1,'b8c2810b-9ae8-4dd8-b06e-51a1e0344c32','2015-06-29 20:08:41','9999-12-31 00:00:00','1'),(42,1,'b33b08e3-6011-40bf-b846-8b6fc92ea64a','2015-06-29 20:09:47','9999-12-31 00:00:00','1'),(43,1,'3c5d51d6-6e28-4f32-a715-a5816deb4c77','2015-06-29 20:10:05','9999-12-31 00:00:00','1'),(44,1,'46bd3056-015a-4eb3-886d-badd2557ac01','2015-06-29 21:41:29','9999-12-31 00:00:00','1'),(45,1,'905dbb96-be8b-4b1d-9074-3f0c3aaf2caa','2015-06-29 21:43:49','9999-12-31 00:00:00','1'),(46,1,'671f9ed7-31ef-4d2c-89a5-1cfda43e5d4e','2015-06-29 21:44:01','9999-12-31 00:00:00','1'),(47,1,'4090d0e3-15d7-4682-baf7-1ce4c11d6632','2015-06-29 21:44:29','9999-12-31 00:00:00','1'),(48,1,'b9acda91-92d5-4cd5-a270-01f152c4b49d','2015-06-29 21:44:50','9999-12-31 00:00:00','1'),(49,1,'af0eb780-366b-40ea-858a-18f252e72062','2015-06-29 21:45:06','9999-12-31 00:00:00','1'),(50,1,'f9b2fc35-66d7-4495-aa09-7437c74c0a2b','2015-06-29 22:04:37','9999-12-31 00:00:00','1'),(51,1,'71208222-4190-419e-89a2-4b70d22f3ad7','2015-06-29 22:04:44','9999-12-31 00:00:00','1'),(52,1,'03729577-c08e-4b6f-add5-6e14297d878c','2015-06-29 22:12:00','9999-12-31 00:00:00','1'),(53,1,'585a4448-a5cf-468d-a18d-91650fd96683','2015-06-29 22:12:13','9999-12-31 00:00:00','1'),(54,1,'64517618-3448-436a-927c-ebbbf670c5c9','2015-06-30 21:47:42','9999-12-31 00:00:00','1'),(55,1,'16b1afcc-b3fc-4028-b56a-402d066f9719','2015-06-30 23:00:18','9999-12-31 00:00:00','1'),(56,1,'07ac832a-986b-4559-a28d-b7a358fed143','2015-06-30 23:01:09','9999-12-31 00:00:00','1'),(57,1,'2efd66f8-c494-4106-8a6a-23aff1b0ae24','2015-06-30 23:01:37','9999-12-31 00:00:00','1'),(58,1,'f21dbc42-dec6-4958-89bd-815a160522fc','2015-06-30 23:10:32','9999-12-31 00:00:00','1'),(59,1,'38b732a8-79e5-41c3-bfd7-8c9a223f2786','2015-07-01 21:57:10','9999-12-31 00:00:00','1'),(60,1,'2ff450f5-ad2c-4d91-935c-5aa77dc96c78','2015-07-02 08:15:21','9999-12-31 00:00:00','1'),(61,1,'b2f49a6a-e764-4040-a37d-0bcdf908ab13','2015-07-02 08:26:18','9999-12-31 00:00:00','1'),(62,1,'9200b8c5-f21f-40bd-889b-f067ddb61be1','2015-07-02 21:54:24','9999-12-31 00:00:00','1'),(63,1,'9967d7d4-b1c7-4997-82d6-7330862b0725','2015-07-03 08:05:05','9999-12-31 00:00:00','1'),(64,1,'70d0c542-fbc7-4024-a92f-1c0d7dab7207','2015-07-03 21:06:48','9999-12-31 00:00:00','1'),(65,1,'9d2d7815-5997-453d-a1ca-15239ab0d9b6','2015-07-03 22:26:42','9999-12-31 00:00:00','1'),(66,1,'ddab1f2d-0eb3-477f-a29b-8468be3b4f79','2015-07-04 11:46:31','9999-12-31 00:00:00','1'),(67,1,'bbd86a30-f99b-45f8-a85b-a4f662bb5901','2015-07-04 21:21:17','9999-12-31 00:00:00','1'),(68,1,'1cee0ade-2302-4924-bf86-e22087fec15a','2015-07-04 23:06:17','9999-12-31 00:00:00','1'),(69,1,'d0f87372-d2de-4d90-9c37-2b09c5ea642e','2015-07-04 23:13:25','9999-12-31 00:00:00','1'),(70,1,'d731d77c-eba6-4f8a-b464-fa40e6cbe8cb','2015-07-04 23:14:19','9999-12-31 00:00:00','1'),(71,1,'e816d188-e534-4c10-9c2c-c22d08fe5931','2015-07-05 08:34:54','9999-12-31 00:00:00','1'),(72,1,'eeeb0372-dc9c-4ef7-9322-d108df49e5dc','2015-07-05 08:39:18','9999-12-31 00:00:00','1'),(73,1,'7fcd6e27-0ed5-48ee-9d3b-d61ab2cc95bb','2015-07-05 22:30:13','9999-12-31 00:00:00','1'),(74,1,'8268ba35-75e4-4190-8b18-55fa75ef9c11','2015-07-08 21:54:42','9999-12-31 00:00:00','1'),(75,1,'709d31e9-7c1b-4d74-b452-4af267d0d900','2015-07-09 20:16:58','9999-12-31 00:00:00','1'),(76,1,'db049002-b1a1-4b73-82e2-8c570ce20d07','2015-07-09 21:20:27','9999-12-31 00:00:00','1'),(77,1,'907c8949-d810-4061-96c7-15bd787f470d','2015-07-09 22:13:07','9999-12-31 00:00:00','1'),(78,1,'4edbeb85-3afc-4d30-ab82-2cbf3a728130','2015-07-09 22:59:15','9999-12-31 00:00:00','1'),(79,1,'7a63f13d-b5ec-4852-9049-d8521cbe5b92','2015-07-10 19:29:18','9999-12-31 00:00:00','1'),(80,1,'cfa6580b-1c23-42ac-811b-55dd6de9aaab','2015-07-10 19:40:47','9999-12-31 00:00:00','1'),(81,1,'38374a06-3d28-4083-b153-f3e6c925e2e8','2015-07-10 19:41:52','9999-12-31 00:00:00','1'),(82,1,'ce559f61-fb00-41ab-8702-af3369cf7ba0','2015-07-10 20:16:08','9999-12-31 00:00:00','1'),(83,1,'ea5f4ad0-93eb-40bf-bf1d-530d5341acb4','2015-07-10 20:26:00','9999-12-31 00:00:00','1'),(84,1,'4f4ccc61-c678-4968-b71e-9b4ae3d7345f','2015-07-10 20:30:51','9999-12-31 00:00:00','1'),(85,1,'488242db-cef6-4b8e-8926-03d4902e5b5c','2015-07-10 20:36:17','9999-12-31 00:00:00','1'),(86,1,'4ea31bc7-cbac-40de-a601-8295663119f6','2015-07-10 20:40:05','9999-12-31 00:00:00','1'),(87,1,'cb322911-b12a-49b7-9a7d-fd468bffa254','2015-07-10 21:18:38','9999-12-31 00:00:00','1'),(88,1,'e3c810ef-f275-46a5-822b-f15c23ebd5de','2015-07-10 21:20:30','9999-12-31 00:00:00','1'),(89,1,'7ebf0f1d-7230-46af-b06d-00cb23a06688','2015-07-10 21:20:32','9999-12-31 00:00:00','1'),(90,1,'9095a9d9-d144-45cb-8a27-7b41906ef233','2015-07-10 21:22:18','9999-12-31 00:00:00','1'),(91,1,'63822ecc-46a6-420b-a737-c37750e69b29','2015-07-10 21:31:27','9999-12-31 00:00:00','1'),(92,1,'4fc44565-432e-4073-b38e-89e47220ab30','2015-07-10 21:37:32','9999-12-31 00:00:00','1'),(93,1,'a9ab8994-8b1a-4b3b-bbd7-6567f652f9b6','2015-07-10 21:38:00','9999-12-31 00:00:00','1'),(94,1,'022b79d2-9b5d-499c-8000-dd1e1caed40d','2015-07-10 21:39:58','9999-12-31 00:00:00','1'),(95,1,'467346f7-705b-4219-9aa1-b00695fb0377','2015-07-10 21:59:04','9999-12-31 00:00:00','1'),(96,1,'8ca4108d-bb13-4700-b094-b9ef2c7bfb8b','2015-07-11 08:28:07','9999-12-31 00:00:00','1'),(97,1,'69e5f5d9-b285-4140-a323-acfaefcae26c','2015-07-11 22:40:31','9999-12-31 00:00:00','1'),(98,1,'f73864fb-b834-4ef0-a41b-58a6b8c84fbc','2015-07-11 22:42:30','9999-12-31 00:00:00','1'),(99,1,'3ce1673f-df13-4bd1-a34f-98b1da1dd53c','2015-07-12 18:55:12','9999-12-31 00:00:00','1'),(100,1,'ac5c3e9c-eabc-44c1-9cfc-a1ab2b640f61','2015-07-12 19:28:11','9999-12-31 00:00:00','1'),(101,1,'a9545d7b-177c-46b1-b358-2c3ede26b646','2015-07-13 08:27:31','9999-12-31 00:00:00','1'),(102,1,'9b476c70-4083-4255-bd80-cee11fa4da91','2015-07-13 22:10:57','9999-12-31 00:00:00','1'),(103,1,'7e99f25b-0c99-4fe1-87a9-8e0ba2de7d5f','2015-07-13 22:34:39','9999-12-31 00:00:00','1'),(104,1,'3c924ab6-fc1a-457a-8c51-347bf786138b','2015-07-15 21:19:13','9999-12-31 00:00:00','1'),(105,1,'0a078569-98aa-401c-a19a-c927a629a672','2015-07-16 21:56:02','9999-12-31 00:00:00','1'),(106,1,'99c0a5d2-06ff-4257-82de-58c4fbc909fb','2015-07-16 22:41:29','9999-12-31 00:00:00','1'),(107,1,'1b3c99ff-1416-40c4-ade1-239e3eebe413','2015-07-18 12:45:07','9999-12-31 00:00:00','1'),(108,1,'ee4d86a0-3622-46cb-848a-30bba13fafad','2015-07-18 13:38:49','9999-12-31 00:00:00','1'),(109,1,'2d01d0ad-001b-437b-a864-4123a9e83f08','2015-07-20 21:46:39','9999-12-31 00:00:00','1'),(110,1,'1ab84c9a-9fa5-4f38-b1dc-d5a8ec86aa73','2015-07-21 00:48:59','9999-12-31 00:00:00','1'),(111,1,'a4eb4878-d816-4021-acfc-4ada1f290af5','2015-07-21 20:15:06','9999-12-31 00:00:00','1'),(112,1,'f2a8e754-3a3a-428d-bb20-c7bb1809bf4d','2015-07-21 20:15:25','9999-12-31 00:00:00','1'),(113,1,'c65860dc-f167-4340-a648-cad92ebd9341','2015-07-21 20:18:57','9999-12-31 00:00:00','1'),(114,1,'6994ec43-af05-47d9-bcba-55afb9c24e25','2015-07-21 21:46:36','9999-12-31 00:00:00','1'),(115,1,'921bcdde-3049-4f6e-99a0-cb5fe1aaeed7','2015-07-21 22:00:55','9999-12-31 00:00:00','1'),(116,1,'afb8c463-0954-4fd3-9fe0-12dc9ca62f49','2015-07-21 23:10:29','9999-12-31 00:00:00','1'),(117,1,'4f3d3f3c-b539-4109-80cc-42e543c62080','2015-07-21 23:14:51','9999-12-31 00:00:00','1'),(118,1,'4c23761e-b638-48e3-ac0f-49faf65df9ba','2015-07-21 23:28:24','9999-12-31 00:00:00','1'),(119,1,'42198b45-05fa-4cd7-bc37-edbd9e63b314','2015-07-26 20:12:57','9999-12-31 00:00:00','0'),(120,1,'be1c3601-00fc-41bc-8fc2-bb3cadb01406','2015-07-26 22:59:48','9999-12-31 00:00:00','0'),(121,1,'a000be56-6de0-4521-ae24-f92378d1dfc7','2015-07-27 01:01:35','9999-12-31 00:00:00','0'),(122,1,'f0bc1d61-7a23-4007-bed5-5e38363bfc57','2015-07-27 22:42:39','9999-12-31 00:00:00','0'),(123,1,'049c6edf-91f9-4d44-8a6e-016e92811ccc','2015-07-27 23:28:02','9999-12-31 00:00:00','0'),(124,1,'ea8ed5eb-a0b4-49ee-a8bc-2887b3862254','2015-07-27 23:56:02','9999-12-31 00:00:00','0'),(125,6,'2d4b5481-1cde-4fc5-b4f8-ffe56d1cade8','2015-07-28 07:58:37','9999-12-31 00:00:00','0'),(126,6,'5cc4e60b-75a3-4571-96c6-6e5fba7362ae','2015-07-28 08:02:52','9999-12-31 00:00:00','0'),(127,1,'a60ce505-070a-4da4-bc6f-bfa8e4f1360d','2015-07-28 08:03:01','9999-12-31 00:00:00','0'),(128,6,'ec47f47c-d3d9-4bbe-becc-c263e95a98e0','2015-07-28 08:03:43','9999-12-31 00:00:00','0'),(129,1,'2cc1aaac-4649-4cd4-9b5c-ffa45b7e7987','2015-07-28 08:15:34','9999-12-31 00:00:00','0'),(130,6,'74a41419-c82f-48fe-b03c-2502d1580b28','2015-07-28 08:15:56','9999-12-31 00:00:00','0'),(131,1,'dd66d51d-9bf1-42ee-8115-3721b7310b30','2015-07-28 20:14:50','9999-12-31 00:00:00','0'),(132,6,'c7153385-b7cf-4dac-b713-a80b34f7e9ff','2015-07-28 20:15:12','9999-12-31 00:00:00','0'),(133,1,'9df3fd3f-202f-45db-b13a-6ece30e3a6a5','2015-07-28 20:15:27','9999-12-31 00:00:00','0'),(134,1,'6a39efac-8dd0-4ba9-b1df-3d645a874f31','2015-07-28 20:19:55','9999-12-31 00:00:00','0'),(135,1,'77f82a70-7f34-4ef7-8571-4c9c71c0ba21','2015-07-28 20:23:35','9999-12-31 00:00:00','0'),(136,1,'a3c3ea42-ae9a-4724-98ef-0d7bd9c3d7b5','2015-07-28 21:12:51','9999-12-31 00:00:00','0'),(137,1,'44e3114c-1a8f-4630-ae31-227cc92f2602','2015-07-30 21:37:57','9999-12-31 00:00:00','0'),(138,1,'284f7871-51ff-42a0-ba6a-620a7b4e88d3','2015-08-15 17:03:44','9999-12-31 00:00:00','0'),(139,1,'b0626fb7-5c16-47e7-8028-373ab34fe25b','2015-08-22 11:51:49','9999-12-31 00:00:00','0'),(140,1,'f80fd5fa-32ac-4cdf-a5bc-053549d19d0b','2015-08-22 11:53:33','9999-12-31 00:00:00','0'),(141,1,'9e4b12df-347a-4c13-8dbc-6f4ed82d3adc','2015-08-23 17:19:46','9999-12-31 00:00:00','0'),(142,7,'85417e66-191d-4867-93e6-f07ffe9af0c3','2015-08-23 19:07:24','9999-12-31 00:00:00','0'),(143,8,'d1586af3-4add-4d52-9a42-7cd6ca383f7c','2015-08-23 19:21:10','9999-12-31 00:00:00','0'),(144,1,'5aaafe16-2ff0-4985-b048-00383b98a301','2015-08-23 19:21:23','9999-12-31 00:00:00','0');

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
	(CONCAT("New task ", NEW.title, " added by ", get_userNameById(NEW.created_by)),
	New.created_by,4, NOW());
	
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
