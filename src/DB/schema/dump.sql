-- MySQL dump 10.13  Distrib 5.5.40, for Linux (x86_64)
--
-- Host: localhost    Database: ontarget
-- ------------------------------------------------------
-- Server version	5.5.40-cll

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accident_report`
--

DROP TABLE IF EXISTS `accident_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accident_report`
--

LOCK TABLES `accident_report` WRITE;
/*!40000 ALTER TABLE `accident_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `accident_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_category`
--

DROP TABLE IF EXISTS `activity_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_category`
--

LOCK TABLES `activity_category` WRITE;
/*!40000 ALTER TABLE `activity_category` DISABLE KEYS */;
INSERT INTO `activity_category` VALUES (1,'comment add','adding task comment','2014-12-05 22:44:02'),(2,'project add','','2014-12-06 13:27:01');
/*!40000 ALTER TABLE `activity_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_log`
--

DROP TABLE IF EXISTS `activity_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `text` text,
  `user_id` int(12) NOT NULL,
  `category` bigint(20) DEFAULT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_log`
--

LOCK TABLES `activity_log` WRITE;
/*!40000 ALTER TABLE `activity_log` DISABLE KEYS */;
INSERT INTO `activity_log` VALUES (1,'New file 2015-01-02 12.40.35.jpg uploaded for task 3 by user 1',0,10,'2015-01-17 07:40:41'),(2,'New planned cost added for task 3 by user 1',0,6,'2015-01-17 07:45:31'),(3,'New planned cost added for task 3 by user 1',0,6,'2015-01-17 07:45:31'),(4,'planned cost updated for task 3 by user 1',0,7,'2015-01-17 07:46:24'),(5,'planned cost updated for task 3 by user 1',0,7,'2015-01-17 07:46:24'),(6,'project 15 updated by 1',0,3,'2015-01-17 11:02:30'),(7,'project 2 updated by 1',0,3,'2015-01-17 11:14:00'),(8,'task Kitchen supply of id 3 updated by 1',0,5,'2015-01-17 11:14:16'),(9,'New planned cost added for task 6 by user 1',0,6,'2015-01-18 09:59:49'),(10,'New planned cost added for task 6 by user 1',0,6,'2015-01-18 09:59:49'),(17,'New assignee 1 added for task 3',0,9,'2015-01-18 11:07:58'),(18,'New assignee 1 added for task 1',0,9,'2015-01-19 09:12:18'),(20,'New assignee 1 added for task 1',0,9,'2015-01-19 09:15:02'),(21,'New assignee 1011406604 added for task 1',0,9,'2015-01-19 09:15:02'),(22,'New assignee 1 added for task 1',0,9,'2015-01-19 09:22:58'),(23,'New assignee 1011406604 added for task 1',0,9,'2015-01-19 09:22:58'),(24,'New assignee 1 added for task 3',0,9,'2015-01-19 09:37:52'),(25,'New assignee 1011406604 added for task 3',0,9,'2015-01-19 09:37:52'),(26,'New assignee 1 added for task 3',0,9,'2015-01-19 09:38:36'),(27,'New assignee 1011406604 added for task 3',0,9,'2015-01-19 09:38:36'),(28,'New assignee 1011406604 added for task 3',0,9,'2015-01-19 09:38:36'),(29,'New assignee 1 added for task 3',0,9,'2015-01-19 09:42:05'),(30,'New assignee 1 added for task 1',0,9,'2015-01-19 10:10:10'),(31,'New assignee 1011406604 added for task 1',0,9,'2015-01-19 10:10:13'),(32,'New assignee 1011406604 added for task 3',0,9,'2015-01-19 10:13:44'),(33,'New assignee 1 added for task 1',0,9,'2015-01-19 10:18:22'),(34,'New assignee 1011406604 added for task 1',0,9,'2015-01-19 10:18:22'),(35,'New assignee 1 added for task 1',0,9,'2015-01-19 10:18:29'),(36,'New assignee 1011406604 added for task 1',0,9,'2015-01-19 10:18:29'),(37,'New assignee 1 added for task 1',0,9,'2015-01-19 10:21:17'),(38,'New assignee 1011406604 added for task 1',0,9,'2015-01-19 10:21:17'),(39,'New assignee 1 added for task 1',0,9,'2015-01-19 10:40:51'),(40,'New assignee 1011406604 added for task 1',0,9,'2015-01-19 10:40:51'),(41,'New assignee 1 added for task 1',0,9,'2015-01-19 10:41:17'),(42,'New assignee 1011406604 added for task 3',0,9,'2015-01-19 11:53:43'),(43,'New assignee 1 added for task 3',0,9,'2015-01-19 11:53:43'),(44,'New assignee 1 added for task 3',0,9,'2015-01-19 14:47:01'),(45,'project 1 updated by 0',0,3,'2015-01-19 17:43:54'),(46,'task Kitchen supply of id 3 updated by 1',0,5,'2015-01-19 19:09:37'),(47,'task Kitchen supply of id 3 updated by 1',0,5,'2015-01-19 19:11:12'),(48,'task kitchen - 3-edit of id 6 updated by 1',0,5,'2015-01-19 19:11:45'),(49,'New assignee 1 added for task 3',0,9,'2015-01-19 19:11:55'),(50,'New assignee 1011406604 added for task 3',0,9,'2015-01-19 19:11:55');
/*!40000 ALTER TABLE `activity_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'4750 59TH ST','#9C','WOODSIDE','NY','11377','USA','HOME'),(2,'393 West End Ave',NULL,'New York','NY','10024','USA','PROJECT'),(3,'US','NP','NP','NP','00977','NP','PROJECT'),(4,'NP','NP','NP','NP','00977','NP','PROJECT'),(5,'NP','NP','NP','NP','00977','NP','PROJECT'),(6,'NP','NP','NP','NP','00977','NP','PROJECT'),(7,'NP','NP','NP','NP','00977','NP','PROJECT'),(8,'NP','NP','NP','NP','00977','NP','PROJECT'),(9,'NP','NP','NP','NP','00977','NP','PROJECT'),(10,'NP','NP','NP','NP','00977','NP','PROJECT'),(11,'NP','NP','NP','NP','0977','NP','PROJECT'),(12,'NP','NP','NP','NP','00977','NP','PROJECT'),(13,'NP','NP','NP','NP','00977','NP','PROJECT'),(14,'add1','add2','NP','NP','00977','NP','PROJECT'),(15,'add1','add2','NP','NP','00977','NP','PROJECT'),(16,'NP','NP','NP','NP','00977','NP','PROJECT'),(17,'NP','NP','NP','NP','00977','NP','PROJECT'),(18,'NP','NP','NP','NP','00977','NP','PROJECT'),(19,'NP','NP','NP','NP','00977','NP','PROJECT'),(20,'asdfasdffd','asdfdafsdsf','dfasdfasadsf','sa','2323','adsfdfas','PROJECT');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_info`
--

DROP TABLE IF EXISTS `company_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_info`
--

LOCK TABLES `company_info` WRITE;
/*!40000 ALTER TABLE `company_info` DISABLE KEYS */;
INSERT INTO `company_info` VALUES (1,'SIMON AND BARRON WEA RESIDENTIAL',1,'363 23rd st','Suite 2098','New York','NY','10001','USA','ACTIVE','http://www.ttg.com'),(2,'BBVA',1,'2000 Windsor Ct','APT 3','Plover','WI','54467','USA','ACTIVE',NULL);
/*!40000 ALTER TABLE `company_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_type`
--

DROP TABLE IF EXISTS `company_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_type` (
  `company_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_type_name` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` varchar(20) DEFAULT NULL,
  `deleted_date` datetime DEFAULT NULL,
  `delete_flag` tinyint(4) DEFAULT NULL,
  `deleted_by` varchar(20) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`company_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_type`
--

LOCK TABLES `company_type` WRITE;
/*!40000 ALTER TABLE `company_type` DISABLE KEYS */;
INSERT INTO `company_type` VALUES (1,'GENERAL CONTRACTOR',NULL,'SYSTEM','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00',NULL,NULL,'ACTIVE'),(2,'CONSTRUCTION MANAGER',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,NULL,'ACTIVE'),(3,'SUB CONTRACTOR',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,NULL,'ACTIVE'),(4,'OWNER',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,NULL,'ACTIVE'),(5,'SPECIALITY CONTRACTOR',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,NULL,'ACTIVE'),(6,'ARCHITECT/ENGINEERS',NULL,'SYSTEM',NULL,'SYSTE',NULL,NULL,NULL,'ACTIVE');
/*!40000 ALTER TABLE `company_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  CONSTRAINT `contact_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `company_fk` FOREIGN KEY (`contact_company_id`) REFERENCES `company_info` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,1,1,'CIO','Sanjeev','Ghimire',1,'1984-01-30','PHONE',NULL,NULL,'2015-01-16 05:44:05','1','ACTIVE','assets/profile/bsn1.jpg'),(2,1011406604,2,'Developer','Nitika','Pradhan',NULL,NULL,NULL,'2015-01-15 22:59:28','0','2015-01-15 22:59:28','0','ACTIVE','');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countries` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(100) NOT NULL,
  `country_code` varchar(3) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependent_task`
--

DROP TABLE IF EXISTS `dependent_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dependent_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_id` int(12) NOT NULL,
  `dependent_task_id` int(12) NOT NULL,
  `category_id` int(12) DEFAULT NULL,
  `created_by` int(12) NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependent_task`
--

LOCK TABLES `dependent_task` WRITE;
/*!40000 ALTER TABLE `dependent_task` DISABLE KEYS */;
INSERT INTO `dependent_task` VALUES (1,2,2,NULL,0,'0000-00-00 00:00:00'),(2,1,2,2,1,'2015-01-05 15:30:44');
/*!40000 ALTER TABLE `dependent_task` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_dependentTask_add AFTER INSERT ON dependent_task
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("Task ", NEW.dependent_task_id," is made dependent on task ",NEW.task_id, " by user ", NEW.created_by), 11);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("Task ", NEW.dependent_task_id," is made dependent on task ",NEW.task_id, " by user ", NEW.created_by), NEW.created_by, 11);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discipline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `info` text NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discipline`
--

LOCK TABLES `discipline` WRITE;
/*!40000 ALTER TABLE `discipline` DISABLE KEYS */;
INSERT INTO `discipline` VALUES (1,'masonry','Masonry','2015-01-09 19:19:58'),(2,'plumbing','Plumbing','2015-01-09 19:19:58'),(3,'electrical','Electrical','2015-01-09 19:19:58'),(4,'mechanical','Mechanical','2015-01-09 19:19:58'),(5,'Interiors','Interiors','2015-01-09 19:19:58'),(6,'landscaping','Landscaping','2015-01-09 19:19:58'),(7,'bridges','Bridges','2015-01-09 19:19:58'),(8,'tunnels','Tunnels','2015-01-09 19:19:58'),(9,'design','Design','2015-01-09 19:19:58');
/*!40000 ALTER TABLE `discipline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  PRIMARY KEY (`document_id`),
  KEY `document_template_id_idx` (`document_template_id`),
  CONSTRAINT `document_template_2_document` FOREIGN KEY (`document_template_id`) REFERENCES `document_template` (`document_template_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (77,20,'CO Document','SUBMITTED','1','2015-01-19 17:26:46','1','2015-01-19 17:26:46',0),(78,20,'CO Document','SUBMITTED','1','2015-01-19 17:30:47','1','2015-01-19 17:30:47',0),(79,20,'CO Document','SUBMITTED','1','2015-01-19 17:32:25','1','2015-01-19 17:32:25',0),(80,20,'CO Document','SUBMITTED','1','2015-01-19 17:37:04','1','2015-01-19 17:37:04',0),(81,20,'CO Document','SUBMITTED','1','2015-01-19 17:39:06','1','2015-01-19 17:39:06',0),(82,20,'CO Document','SUBMITTED','1','2015-01-19 17:47:20','1','2015-01-19 17:47:20',0),(83,20,'CO Document','SUBMITTED','1','2015-01-19 17:51:10','1','2015-01-19 17:51:10',0),(84,20,'CO Document','SUBMITTED','1','2015-01-19 17:59:11','1','2015-01-19 17:59:11',0),(85,20,'CO Document','SUBMITTED','1','2015-01-19 18:00:24','1','2015-01-19 18:00:24',0),(86,20,'CO Document','SUBMITTED','1','2015-01-19 18:01:24','1','2015-01-19 18:01:24',0),(87,20,'CO Document','SUBMITTED','1','2015-01-19 18:04:16','1','2015-01-19 18:04:16',0),(88,20,'CO Document','SUBMITTED','1','2015-01-19 18:04:58','1','2015-01-19 18:04:58',0),(89,20,'CO Document','SUBMITTED','1','2015-01-19 18:05:28','1','2015-01-19 18:05:28',0),(90,20,'CO Document','SUBMITTED','1','2015-01-19 18:10:15','1','2015-01-19 18:10:15',0),(91,20,'CO Document','SUBMITTED','1','2015-01-19 18:13:32','1','2015-01-19 18:13:32',0),(92,20,'CO Document','SUBMITTED','1','2015-01-19 18:16:58','1','2015-01-19 18:16:58',0),(93,20,'CO Document','SUBMITTED','1','2015-01-19 18:17:06','1','2015-01-19 18:17:06',0),(94,20,'CO Document','SUBMITTED','1','2015-01-19 18:20:47','1','2015-01-19 18:20:47',0),(95,20,'CO Document','SUBMITTED','1','2015-01-19 18:26:33','1','2015-01-19 18:26:33',0),(96,20,'CO Document','SUBMITTED','1','2015-01-19 18:28:09','1','2015-01-19 18:28:09',0),(97,20,'CO Document','SUBMITTED','1','2015-01-19 18:29:01','1','2015-01-19 18:29:01',0),(98,20,'CO Document','SUBMITTED','1','2015-01-19 18:30:06','1','2015-01-19 18:30:06',0),(99,20,'CO Document','SUBMITTED','1','2015-01-19 18:32:13','1','2015-01-19 18:32:13',0),(100,20,'CO Document','SUBMITTED','1','2015-01-19 18:32:13','1','2015-01-19 18:32:13',0),(101,20,'CO Document','SUBMITTED','1','2015-01-19 18:33:35','1','2015-01-19 18:33:35',0),(102,20,'CO Document','SUBMITTED','1','2015-01-19 18:34:34','1','2015-01-19 18:34:34',0),(103,20,'CO Document','SUBMITTED','1','2015-01-19 18:34:41','1','2015-01-19 18:34:41',0),(104,20,'CO Document','SUBMITTED','1','2015-01-19 18:38:00','1','2015-01-19 18:38:00',0),(105,20,'CO Document','SUBMITTED','1','2015-01-19 18:40:32','1','2015-01-19 18:40:32',0),(106,20,'CO Document','SUBMITTED','1','2015-01-19 18:47:54','1','2015-01-19 18:47:54',0),(107,20,'CO Document','SUBMITTED','1','2015-01-19 18:50:00','1','2015-01-19 18:50:00',0),(108,20,'CO Document','SUBMITTED','1','2015-01-19 18:52:47','1','2015-01-19 18:52:47',0),(109,20,'CO Document','SUBMITTED','1','2015-01-19 18:56:20','1','2015-01-19 18:56:20',0),(110,20,'CO Document','SUBMITTED','1','2015-01-19 18:56:52','1','2015-01-19 18:56:52',0),(111,20,'CO Document','SUBMITTED','1','2015-01-19 18:58:03','1','2015-01-19 18:58:03',0),(112,20,'CO Document','SUBMITTED','1','2015-01-19 19:01:02','1','2015-01-19 19:01:02',0),(113,20,'CO Document','SUBMITTED','1','2015-01-19 19:02:17','1','2015-01-19 19:02:17',0),(114,20,'CO Document','SUBMITTED','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46',0),(115,20,'CO Document','SUBMITTED','1','2015-01-19 19:09:07','1','2015-01-19 19:09:07',0),(116,20,'CO Document','SUBMITTED','1','2015-01-19 19:09:53','1','2015-01-19 19:09:53',0),(117,20,'CO Document','SUBMITTED','1','2015-01-19 19:27:48','1','2015-01-19 19:27:48',0),(118,20,'CO Document','SUBMITTED','1','2015-01-19 19:29:26','1','2015-01-19 19:29:26',0),(119,20,'CO Document','SUBMITTED','1','2015-01-19 19:30:10','1','2015-01-19 19:30:10',0),(120,20,'CO Document','SUBMITTED','1','2015-01-19 19:30:25','1','2015-01-19 19:30:25',0);
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_attachment`
--

DROP TABLE IF EXISTS `document_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_attachment`
--

LOCK TABLES `document_attachment` WRITE;
/*!40000 ALTER TABLE `document_attachment` DISABLE KEYS */;
INSERT INTO `document_attachment` VALUES (6,90,'assets/change-order/977S3485.JPG','1','2015-01-19 18:10:22','1','2015-01-19 18:10:22'),(7,98,'assets/change-order/977S3484.JPG','1','2015-01-19 18:30:12','1','2015-01-19 18:30:12'),(8,100,'assets/change-order/977S3484.JPG','1','2015-01-19 18:32:16','1','2015-01-19 18:32:16'),(9,99,'assets/change-order/977S3484.JPG','1','2015-01-19 18:32:16','1','2015-01-19 18:32:16'),(10,101,'assets/change-order/977S3484.JPG','1','2015-01-19 18:33:37','1','2015-01-19 18:33:37'),(11,103,'assets/change-order/977S3484.JPG','1','2015-01-19 18:34:43','1','2015-01-19 18:34:43'),(12,104,'assets/change-order/977S3484.JPG','1','2015-01-19 18:38:02','1','2015-01-19 18:38:02'),(13,105,'assets/change-order/977S3484.JPG','1','2015-01-19 18:40:34','1','2015-01-19 18:40:34'),(14,106,'assets/change-order/977S3484.JPG','1','2015-01-19 18:47:56','1','2015-01-19 18:47:56'),(15,107,'assets/change-order/977S3484.JPG','1','2015-01-19 18:50:01','1','2015-01-19 18:50:01'),(16,108,'assets/change-order/977S3484.JPG','1','2015-01-19 18:52:49','1','2015-01-19 18:52:49'),(17,119,'assets/change-order/977S3484.JPG','1','2015-01-19 19:30:11','1','2015-01-19 19:30:11');
/*!40000 ALTER TABLE `document_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_grid_key_value`
--

DROP TABLE IF EXISTS `document_grid_key_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_grid_key_value`
--

LOCK TABLES `document_grid_key_value` WRITE;
/*!40000 ALTER TABLE `document_grid_key_value` DISABLE KEYS */;
INSERT INTO `document_grid_key_value` VALUES (82,'CO-COSTGRID',0,'amount','1','1','2015-01-19 17:47:20','1','2015-01-19 17:47:20'),(82,'CO-COSTGRID',1,'amount','1','1','2015-01-19 17:47:20','1','2015-01-19 17:47:20'),(91,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:13:32','1','2015-01-19 18:13:32'),(91,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:13:32','1','2015-01-19 18:13:32'),(93,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:17:06','1','2015-01-19 18:17:06'),(93,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:17:06','1','2015-01-19 18:17:06'),(94,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:20:47','1','2015-01-19 18:20:47'),(94,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:20:47','1','2015-01-19 18:20:47'),(94,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:20:47','1','2015-01-19 18:20:47'),(94,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:20:47','1','2015-01-19 18:20:47'),(94,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:20:47','1','2015-01-19 18:20:47'),(94,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:20:47','1','2015-01-19 18:20:47'),(95,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:26:33','1','2015-01-19 18:26:33'),(95,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:26:33','1','2015-01-19 18:26:33'),(95,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:26:33','1','2015-01-19 18:26:33'),(95,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:26:33','1','2015-01-19 18:26:33'),(95,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:26:33','1','2015-01-19 18:26:33'),(95,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:26:33','1','2015-01-19 18:26:33'),(96,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:28:09','1','2015-01-19 18:28:09'),(96,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:28:09','1','2015-01-19 18:28:09'),(96,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:28:09','1','2015-01-19 18:28:09'),(96,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:28:09','1','2015-01-19 18:28:09'),(96,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:28:09','1','2015-01-19 18:28:09'),(96,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:28:09','1','2015-01-19 18:28:09'),(97,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:29:01','1','2015-01-19 18:29:01'),(97,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:29:01','1','2015-01-19 18:29:01'),(97,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:29:01','1','2015-01-19 18:29:01'),(97,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:29:01','1','2015-01-19 18:29:01'),(97,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:29:01','1','2015-01-19 18:29:01'),(97,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:29:01','1','2015-01-19 18:29:01'),(98,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:30:06','1','2015-01-19 18:30:06'),(98,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:30:06','1','2015-01-19 18:30:06'),(98,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:30:06','1','2015-01-19 18:30:06'),(98,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:30:06','1','2015-01-19 18:30:06'),(98,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:30:06','1','2015-01-19 18:30:06'),(98,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:30:06','1','2015-01-19 18:30:06'),(99,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:32:13','1','2015-01-19 18:32:13'),(100,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:32:13','1','2015-01-19 18:32:13'),(100,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:32:13','1','2015-01-19 18:32:13'),(99,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:32:13','1','2015-01-19 18:32:13'),(100,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:32:13','1','2015-01-19 18:32:13'),(99,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:32:13','1','2015-01-19 18:32:13'),(100,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:32:13','1','2015-01-19 18:32:13'),(99,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:32:13','1','2015-01-19 18:32:13'),(100,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:32:14','1','2015-01-19 18:32:14'),(100,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:32:14','1','2015-01-19 18:32:14'),(99,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:32:14','1','2015-01-19 18:32:14'),(99,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:32:14','1','2015-01-19 18:32:14'),(101,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:33:35','1','2015-01-19 18:33:35'),(101,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:33:35','1','2015-01-19 18:33:35'),(101,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:33:35','1','2015-01-19 18:33:35'),(101,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:33:35','1','2015-01-19 18:33:35'),(101,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:33:35','1','2015-01-19 18:33:35'),(101,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:33:35','1','2015-01-19 18:33:35'),(102,'CO-COSTGRID',0,'workDesc','1','1','2015-01-19 18:34:34','1','2015-01-19 18:34:34'),(102,'CO-COSTGRID',0,'workDesc','1','1','2015-01-19 18:34:34','1','2015-01-19 18:34:34'),(102,'CO-COSTGRID',0,'workDesc','1','1','2015-01-19 18:34:34','1','2015-01-19 18:34:34'),(102,'CO-COSTGRID',1,'workDesc','1','1','2015-01-19 18:34:34','1','2015-01-19 18:34:34'),(102,'CO-COSTGRID',1,'workDesc','1','1','2015-01-19 18:34:34','1','2015-01-19 18:34:34'),(102,'CO-COSTGRID',1,'workDesc','1','1','2015-01-19 18:34:34','1','2015-01-19 18:34:34'),(103,'CO-COSTGRID',0,'workDesc','1','1','2015-01-19 18:34:41','1','2015-01-19 18:34:41'),(103,'CO-COSTGRID',0,'workDesc','1','1','2015-01-19 18:34:41','1','2015-01-19 18:34:41'),(103,'CO-COSTGRID',0,'workDesc','1','1','2015-01-19 18:34:41','1','2015-01-19 18:34:41'),(103,'CO-COSTGRID',1,'workDesc','1','1','2015-01-19 18:34:41','1','2015-01-19 18:34:41'),(103,'CO-COSTGRID',1,'workDesc','1','1','2015-01-19 18:34:41','1','2015-01-19 18:34:41'),(103,'CO-COSTGRID',1,'workDesc','1','1','2015-01-19 18:34:41','1','2015-01-19 18:34:41'),(104,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:38:00','1','2015-01-19 18:38:00'),(104,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:38:00','1','2015-01-19 18:38:00'),(104,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:38:00','1','2015-01-19 18:38:00'),(104,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:38:00','1','2015-01-19 18:38:00'),(104,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:38:00','1','2015-01-19 18:38:00'),(104,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:38:00','1','2015-01-19 18:38:00'),(105,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:40:32','1','2015-01-19 18:40:32'),(105,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:40:32','1','2015-01-19 18:40:32'),(105,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:40:32','1','2015-01-19 18:40:32'),(105,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:40:32','1','2015-01-19 18:40:32'),(105,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:40:32','1','2015-01-19 18:40:32'),(105,'CO-COSTGRID',1,'amount','1','1','2015-01-19 18:40:32','1','2015-01-19 18:40:32'),(107,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:50:00','1','2015-01-19 18:50:00'),(107,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:50:00','1','2015-01-19 18:50:00'),(107,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:50:00','1','2015-01-19 18:50:00'),(107,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:50:00','1','2015-01-19 18:50:00'),(107,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:50:00','1','2015-01-19 18:50:00'),(107,'CO-COSTGRID',1,'amount','2','1','2015-01-19 18:50:00','1','2015-01-19 18:50:00'),(108,'CO-COSTGRID',0,'workDescription','1','1','2015-01-19 18:52:47','1','2015-01-19 18:52:47'),(108,'CO-COSTGRID',0,'costCode','1','1','2015-01-19 18:52:47','1','2015-01-19 18:52:47'),(108,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:52:47','1','2015-01-19 18:52:47'),(108,'CO-COSTGRID',0,'workDescription','2','1','2015-01-19 18:52:47','1','2015-01-19 18:52:47'),(108,'CO-COSTGRID',0,'costCode','2','1','2015-01-19 18:52:47','1','2015-01-19 18:52:47'),(108,'CO-COSTGRID',0,'amount','2','1','2015-01-19 18:52:47','1','2015-01-19 18:52:47'),(109,'CO-COSTGRID',0,'workDescription','1','1','2015-01-19 18:56:20','1','2015-01-19 18:56:20'),(109,'CO-COSTGRID',0,'costCode','1','1','2015-01-19 18:56:20','1','2015-01-19 18:56:20'),(109,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:56:20','1','2015-01-19 18:56:20'),(109,'CO-COSTGRID',0,'workDescription','2','1','2015-01-19 18:56:20','1','2015-01-19 18:56:20'),(109,'CO-COSTGRID',0,'costCode','2','1','2015-01-19 18:56:20','1','2015-01-19 18:56:20'),(109,'CO-COSTGRID',0,'amount','2','1','2015-01-19 18:56:20','1','2015-01-19 18:56:20'),(110,'CO-COSTGRID',0,'workDescription','1','1','2015-01-19 18:56:52','1','2015-01-19 18:56:52'),(110,'CO-COSTGRID',0,'costCode','1','1','2015-01-19 18:56:52','1','2015-01-19 18:56:52'),(110,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:56:52','1','2015-01-19 18:56:52'),(110,'CO-COSTGRID',0,'workDescription','2','1','2015-01-19 18:56:52','1','2015-01-19 18:56:52'),(110,'CO-COSTGRID',0,'costCode','2','1','2015-01-19 18:56:52','1','2015-01-19 18:56:52'),(110,'CO-COSTGRID',0,'amount','2','1','2015-01-19 18:56:52','1','2015-01-19 18:56:52'),(111,'CO-COSTGRID',0,'workDescription','1','1','2015-01-19 18:58:03','1','2015-01-19 18:58:03'),(111,'CO-COSTGRID',0,'costCode','1','1','2015-01-19 18:58:03','1','2015-01-19 18:58:03'),(111,'CO-COSTGRID',0,'amount','1','1','2015-01-19 18:58:03','1','2015-01-19 18:58:03'),(111,'CO-COSTGRID',0,'workDescription','2','1','2015-01-19 18:58:03','1','2015-01-19 18:58:03'),(111,'CO-COSTGRID',0,'costCode','2','1','2015-01-19 18:58:03','1','2015-01-19 18:58:03'),(111,'CO-COSTGRID',0,'amount','2','1','2015-01-19 18:58:03','1','2015-01-19 18:58:03'),(112,'CO-COSTGRID',0,'workDescription','1','1','2015-01-19 19:01:02','1','2015-01-19 19:01:02'),(112,'CO-COSTGRID',0,'costCode','1','1','2015-01-19 19:01:02','1','2015-01-19 19:01:02'),(112,'CO-COSTGRID',0,'amount','1','1','2015-01-19 19:01:02','1','2015-01-19 19:01:02'),(112,'CO-COSTGRID',0,'workDescription','2','1','2015-01-19 19:01:02','1','2015-01-19 19:01:02'),(112,'CO-COSTGRID',0,'costCode','2','1','2015-01-19 19:01:02','1','2015-01-19 19:01:02'),(112,'CO-COSTGRID',0,'amount','2','1','2015-01-19 19:01:02','1','2015-01-19 19:01:02'),(113,'CO-COSTGRID',0,'workDescription','1','1','2015-01-19 19:02:17','1','2015-01-19 19:02:17'),(113,'CO-COSTGRID',0,'costCode','1','1','2015-01-19 19:02:17','1','2015-01-19 19:02:17'),(113,'CO-COSTGRID',0,'amount','1','1','2015-01-19 19:02:18','1','2015-01-19 19:02:18'),(113,'CO-COSTGRID',0,'workDescription','2','1','2015-01-19 19:02:18','1','2015-01-19 19:02:18'),(113,'CO-COSTGRID',0,'costCode','2','1','2015-01-19 19:02:18','1','2015-01-19 19:02:18'),(113,'CO-COSTGRID',0,'amount','2','1','2015-01-19 19:02:18','1','2015-01-19 19:02:18'),(115,'CO-COSTGRID',0,'workDescription','1','1','2015-01-19 19:09:07','1','2015-01-19 19:09:07'),(115,'CO-COSTGRID',0,'costCode','1','1','2015-01-19 19:09:07','1','2015-01-19 19:09:07'),(115,'CO-COSTGRID',0,'amount','1','1','2015-01-19 19:09:07','1','2015-01-19 19:09:07'),(115,'CO-COSTGRID',0,'workDescription','2','1','2015-01-19 19:09:07','1','2015-01-19 19:09:07'),(115,'CO-COSTGRID',0,'costCode','2','1','2015-01-19 19:09:07','1','2015-01-19 19:09:07'),(115,'CO-COSTGRID',0,'amount','2','1','2015-01-19 19:09:07','1','2015-01-19 19:09:07'),(116,'CO-COSTGRID',0,'workDescription','1','1','2015-01-19 19:09:53','1','2015-01-19 19:09:53'),(116,'CO-COSTGRID',0,'costCode','1','1','2015-01-19 19:09:53','1','2015-01-19 19:09:53'),(116,'CO-COSTGRID',0,'amount','1','1','2015-01-19 19:09:53','1','2015-01-19 19:09:53'),(116,'CO-COSTGRID',0,'workDescription','2','1','2015-01-19 19:09:53','1','2015-01-19 19:09:53'),(116,'CO-COSTGRID',0,'costCode','2','1','2015-01-19 19:09:54','1','2015-01-19 19:09:54'),(116,'CO-COSTGRID',0,'amount','2','1','2015-01-19 19:09:54','1','2015-01-19 19:09:54'),(120,'CO-COSTGRID',0,'workDescription','1','1','2015-01-19 19:30:25','1','2015-01-19 19:30:25'),(120,'CO-COSTGRID',0,'costCode','1','1','2015-01-19 19:30:25','1','2015-01-19 19:30:25'),(120,'CO-COSTGRID',0,'amount','1','1','2015-01-19 19:30:25','1','2015-01-19 19:30:25'),(120,'CO-COSTGRID',0,'workDescription','2','1','2015-01-19 19:30:25','1','2015-01-19 19:30:25'),(120,'CO-COSTGRID',0,'costCode','2','1','2015-01-19 19:30:25','1','2015-01-19 19:30:25'),(120,'CO-COSTGRID',0,'amount','2','1','2015-01-19 19:30:25','1','2015-01-19 19:30:25');
/*!40000 ALTER TABLE `document_grid_key_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_key_value`
--

DROP TABLE IF EXISTS `document_key_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_key_value`
--

LOCK TABLES `document_key_value` WRITE;
/*!40000 ALTER TABLE `document_key_value` DISABLE KEYS */;
INSERT INTO `document_key_value` VALUES (114,'change_order','CP-201','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'location','NY','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'subject','Test','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'description_of_scope','test','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'contract_no','123','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'contract_title','Test title','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'date_created','2015-01-01','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'priority','High','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'discipline','MECHANICAL','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'category','OMISSONS','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'schedule_impact','YES','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'cost_impact','YES','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'time_impact','12:30','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'specification','test spec','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'drawing_no','123f','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(114,'cost_code','CD 123','1','2015-01-19 19:08:46','1','2015-01-19 19:08:46');
/*!40000 ALTER TABLE `document_key_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_submittal`
--

DROP TABLE IF EXISTS `document_submittal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_submittal`
--

LOCK TABLES `document_submittal` WRITE;
/*!40000 ALTER TABLE `document_submittal` DISABLE KEYS */;
INSERT INTO `document_submittal` VALUES (25,77,1,'1','2015-01-19 17:26:46','1','2015-01-19 17:26:46'),(26,78,1,'1','2015-01-19 17:30:47','1','2015-01-19 17:30:47'),(27,79,1,'1','2015-01-19 17:32:25','1','2015-01-19 17:32:25'),(28,80,1,'1','2015-01-19 17:37:04','1','2015-01-19 17:37:04'),(29,81,1,'1','2015-01-19 17:39:06','1','2015-01-19 17:39:06'),(30,82,1,'1','2015-01-19 17:47:20','1','2015-01-19 17:47:20'),(31,83,1,'1','2015-01-19 17:51:10','1','2015-01-19 17:51:10'),(32,84,1,'1','2015-01-19 17:59:11','1','2015-01-19 17:59:11'),(33,85,1,'1','2015-01-19 18:00:24','1','2015-01-19 18:00:24'),(34,86,1,'1','2015-01-19 18:01:24','1','2015-01-19 18:01:24'),(35,87,1,'1','2015-01-19 18:04:16','1','2015-01-19 18:04:16'),(36,88,1,'1','2015-01-19 18:04:58','1','2015-01-19 18:04:58'),(37,89,1,'1','2015-01-19 18:05:28','1','2015-01-19 18:05:28'),(38,90,1,'1','2015-01-19 18:10:15','1','2015-01-19 18:10:15'),(39,91,1,'1','2015-01-19 18:13:32','1','2015-01-19 18:13:32'),(40,92,1,'1','2015-01-19 18:16:58','1','2015-01-19 18:16:58'),(41,93,1,'1','2015-01-19 18:17:06','1','2015-01-19 18:17:06'),(42,94,1,'1','2015-01-19 18:20:47','1','2015-01-19 18:20:47'),(43,95,1,'1','2015-01-19 18:26:33','1','2015-01-19 18:26:33'),(44,96,1,'1','2015-01-19 18:28:09','1','2015-01-19 18:28:09'),(45,97,1,'1','2015-01-19 18:29:01','1','2015-01-19 18:29:01'),(46,98,1,'1','2015-01-19 18:30:06','1','2015-01-19 18:30:06'),(47,100,1,'1','2015-01-19 18:32:14','1','2015-01-19 18:32:14'),(48,99,1,'1','2015-01-19 18:32:14','1','2015-01-19 18:32:14'),(49,101,1,'1','2015-01-19 18:33:35','1','2015-01-19 18:33:35'),(50,102,1,'1','2015-01-19 18:34:34','1','2015-01-19 18:34:34'),(51,103,1,'1','2015-01-19 18:34:41','1','2015-01-19 18:34:41'),(52,104,1,'1','2015-01-19 18:38:00','1','2015-01-19 18:38:00'),(53,105,1,'1','2015-01-19 18:40:32','1','2015-01-19 18:40:32'),(54,106,1,'1','2015-01-19 18:47:54','1','2015-01-19 18:47:54'),(55,107,1,'1','2015-01-19 18:50:00','1','2015-01-19 18:50:00'),(56,108,1,'1','2015-01-19 18:52:47','1','2015-01-19 18:52:47'),(57,109,1,'1','2015-01-19 18:56:20','1','2015-01-19 18:56:20'),(58,110,1,'1','2015-01-19 18:56:52','1','2015-01-19 18:56:52'),(59,111,1,'1','2015-01-19 18:58:03','1','2015-01-19 18:58:03'),(60,112,1,'1','2015-01-19 19:01:02','1','2015-01-19 19:01:02'),(61,113,1,'1','2015-01-19 19:02:18','1','2015-01-19 19:02:18'),(62,114,1,'1','2015-01-19 19:08:46','1','2015-01-19 19:08:46'),(63,115,1,'1','2015-01-19 19:09:07','1','2015-01-19 19:09:07'),(64,116,1,'1','2015-01-19 19:09:54','1','2015-01-19 19:09:54'),(65,117,1,'1','2015-01-19 19:27:48','1','2015-01-19 19:27:48'),(66,118,1,'1','2015-01-19 19:29:26','1','2015-01-19 19:29:26'),(67,119,1,'1','2015-01-19 19:30:10','1','2015-01-19 19:30:10'),(68,120,1,'1','2015-01-19 19:30:25','1','2015-01-19 19:30:25');
/*!40000 ALTER TABLE `document_submittal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_template`
--

DROP TABLE IF EXISTS `document_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document_template` (
  `document_template_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(45) NOT NULL,
  `modfied_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`document_template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_template`
--

LOCK TABLES `document_template` WRITE;
/*!40000 ALTER TABLE `document_template` DISABLE KEYS */;
INSERT INTO `document_template` VALUES (20,'Purchase Order','SYSTEM','2015-01-09 19:19:58','SYSTEM','2015-01-09 19:19:58'),(21,'Change Order','SYSTEM','2015-01-09 19:19:58','SYSTEM','2015-01-09 19:19:58'),(22,'Request For Information','SYSTEM','2015-01-09 19:19:58','SYSTEM','2015-01-09 19:19:58'),(23,'Transmittal','SYSTEM','2015-01-09 19:19:58','SYSTEM','2015-01-09 19:19:58');
/*!40000 ALTER TABLE `document_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_templates`
--

DROP TABLE IF EXISTS `email_templates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_templates`
--

LOCK TABLES `email_templates` WRITE;
/*!40000 ALTER TABLE `email_templates` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_templates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forgot_password_request`
--

DROP TABLE IF EXISTS `forgot_password_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forgot_password_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `forgot_password_token` varchar(64) NOT NULL,
  `status` varchar(10) NOT NULL,
  `ts_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ts_expiry` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forgot_password_request`
--

LOCK TABLES `forgot_password_request` WRITE;
/*!40000 ALTER TABLE `forgot_password_request` DISABLE KEYS */;
INSERT INTO `forgot_password_request` VALUES (1,1,'92263472049943137117528948216981588004833145350748465292303','EXPIRED','2015-01-09 19:31:47','2015-01-10 19:31:47'),(2,70246881,'31241831666831537510413871443918454281698718710383800068779','ACTIVE','2015-01-15 04:12:25','2015-01-16 04:12:25');
/*!40000 ALTER TABLE `forgot_password_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (1,2,347,'335-1016','CELL','ACTIVE'),(2,1,859,'684-7931','CELL','ACTIVE');
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planned_actuals_cost`
--

DROP TABLE IF EXISTS `planned_actuals_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planned_actuals_cost`
--

LOCK TABLES `planned_actuals_cost` WRITE;
/*!40000 ALTER TABLE `planned_actuals_cost` DISABLE KEYS */;
INSERT INTO `planned_actuals_cost` VALUES (1,3,'2015-01-10 00:00:00','2015-01-13 00:00:00','ACTUAL',20.000,'9999-12-31 00:00:00',1,'2015-01-17 01:45:31',1,'2015-01-17 01:46:24'),(2,3,'2015-01-10 00:00:00','2015-01-13 00:00:00','PLANNED',20.000,'9999-12-31 00:00:00',1,'2015-01-17 01:45:31',1,'2015-01-17 01:46:24'),(3,6,'2015-01-10 00:00:00','2015-01-13 00:00:00','ACTUAL',40.000,'9999-12-31 00:00:00',1,'2015-01-18 03:59:49',1,'2015-01-18 03:59:49'),(4,6,'2015-01-10 00:00:00','2015-01-13 00:00:00','PLANNED',40.000,'9999-12-31 00:00:00',1,'2015-01-18 03:59:49',1,'2015-01-18 03:59:49');
/*!40000 ALTER TABLE `planned_actuals_cost` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_plannedActualCost_add AFTER INSERT ON planned_actuals_cost
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New planned cost added for task ", NEW.task_id, " by user ", NEW.created_by), 6);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New planned cost added for task ", " by ", NEW.created_by, NEW.task_id), NEW.created_by, 6);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_plannedActualCost_update AFTER UPDATE ON planned_actuals_cost
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("planned cost updated for task ", NEW.task_id, " by user ", NEW.modified_by), 7);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("planned cost updated for task ", NEW.task_id, " by ", NEW.modified_by), NEW.modified_by, 7);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  CONSTRAINT `project_categ_fk` FOREIGN KEY (`project_category_id`) REFERENCES `project_category` (`project_category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_type_fk` FOREIGN KEY (`project_type_id`) REFERENCES `project_type` (`project_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_addr_fk` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_comp_fk` FOREIGN KEY (`company_id`) REFERENCES `company_info` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'SIM_BARR','Simon and Barron WEA Residential',1,NULL,1,0,NULL,'With objective to develop a comprehensive Model for 200,000 sqft Renovation Project. The challenge was to do a complete survey of the existing system in detail to include in the Model. Our team successfully provided Architecture, Structure, Mechanical , Electrical and Plumbing and identified clashes. We also provided solutions for resolving conflicts and innovative approaches for coordination.',NULL,'2015-01-08 23:00:00','2015-12-31 23:00:00',NULL,1,2,NULL,NULL,'2015-01-09 23:00:07','0',NULL,NULL,NULL,'393wea_web.jpg'),(2,NULL,'Electricity',1,NULL,1,1,NULL,'bsn-electricity',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00','1',1,3,'2015-01-09 13:59:29','SYSTEM','2015-01-17 05:14:00','1',NULL,NULL,NULL,NULL),(3,NULL,'PLUMBING',1,NULL,1,0,NULL,'bsn-plumbing',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00','1',1,4,'2015-01-09 14:01:09','SYSTEM','2015-01-09 14:01:09','SYSTEM',NULL,NULL,NULL,NULL),(4,NULL,'PLUMBING',1,NULL,1,0,NULL,'bsn-plumbing',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00','1',1,5,'2015-01-09 14:09:05','SYSTEM','2015-01-09 14:09:05','SYSTEM',NULL,NULL,NULL,NULL),(5,NULL,'PLUMBING',1,NULL,2,1,NULL,'bsn-plumbing',NULL,'2015-01-04 00:00:00','2015-01-25 00:00:00','2',1,6,'2015-01-09 14:13:38','SYSTEM','2015-01-09 14:13:38','SYSTEM',NULL,NULL,NULL,NULL),(6,NULL,'CEILING',1,NULL,1,0,NULL,'bsn-ceiling',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00','1',1,7,'2015-01-09 14:17:06','SYSTEM','2015-01-09 14:17:06','SYSTEM',NULL,NULL,NULL,NULL),(7,NULL,'WINDOWS',1,NULL,1,0,NULL,'bsn-windows',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00','1',1,8,'2015-01-09 14:24:12','SYSTEM','2015-01-09 14:24:12','SYSTEM',NULL,NULL,NULL,NULL),(8,NULL,'actvity1',1,NULL,1,0,NULL,'activity1',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00','1',1,9,'2015-01-09 14:31:57','SYSTEM','2015-01-09 14:31:57','SYSTEM',NULL,NULL,NULL,NULL),(9,NULL,'activity2',1,NULL,1,0,NULL,'bsn-activity',NULL,'2015-01-04 00:00:00','2015-01-11 00:00:00','1',1,10,'2015-01-09 14:34:03','SYSTEM','2015-01-09 14:34:03','SYSTEM',NULL,NULL,NULL,NULL),(10,NULL,'activity3',1,NULL,1,0,NULL,'activity3',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00','1',1,11,'2015-01-09 14:38:40','SYSTEM','2015-01-09 14:38:40','SYSTEM',NULL,NULL,NULL,NULL),(11,NULL,'activity4',1,NULL,1,0,NULL,'activity4',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00',NULL,1,12,'2015-01-09 14:41:35','SYSTEM','2015-01-09 14:41:35','SYSTEM',NULL,NULL,NULL,NULL),(12,NULL,'activity 10',1,NULL,2,0,NULL,'bsn activity',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00','1',1,13,'2015-01-10 14:03:57','SYSTEM','2015-01-10 14:03:57','SYSTEM',NULL,NULL,NULL,NULL),(13,NULL,'activity 11',1,NULL,1,0,NULL,'bsn-description',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00','1',1,14,'2015-01-10 14:07:43','SYSTEM','2015-01-10 14:07:43','SYSTEM',NULL,NULL,NULL,NULL),(14,NULL,'activity 12',1,NULL,1,0,NULL,'bsn-activity',NULL,'2015-01-11 00:00:00','2015-01-15 00:00:00','1',1,15,'2015-01-10 14:10:17','SYSTEM','2015-01-10 14:10:17','SYSTEM',NULL,NULL,NULL,NULL),(15,NULL,'bsn-activity 13',1,NULL,1,1,NULL,'bsn-activity 13',NULL,'2015-01-11 00:00:00','2015-01-15 00:00:00','1',1,16,'2015-01-10 14:18:51','SYSTEM','2015-01-17 05:02:30','1',NULL,NULL,NULL,NULL),(16,NULL,'activity-13',1,NULL,2,1,NULL,'activity-13',NULL,'2015-01-11 00:00:00','2015-01-19 00:00:00','1',1,17,'2015-01-10 14:59:02','SYSTEM','2015-01-10 14:59:02','SYSTEM',NULL,NULL,NULL,NULL),(17,NULL,'activity-5',1,NULL,1,1,NULL,'activity-5',NULL,'2015-01-11 00:00:00','2015-01-18 00:00:00','1',1,18,'2015-01-11 06:50:13','SYSTEM','2015-01-11 06:50:13','SYSTEM',NULL,NULL,NULL,NULL),(18,NULL,'activity-6',1,NULL,1,1,NULL,'activity-6',NULL,'2015-01-11 00:00:00','2015-01-25 00:00:00','1',1,19,'2015-01-11 06:52:34','SYSTEM','2015-01-11 06:52:34','SYSTEM',NULL,NULL,NULL,NULL),(19,NULL,'Act1',1,NULL,1,0,NULL,'asdfdfsdsfa',NULL,'2014-09-30 00:00:00','2015-06-30 00:00:00','1',1,20,'2015-01-12 09:58:07','SYSTEM','2015-01-12 09:58:07','SYSTEM',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_project_add AFTER INSERT ON project
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New project ", NEW.project_id, " of type", New.project_category_id , " added by ", NEW.project_owner_id), 2);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New project ", NEW.project_id, " of type", New.project_category_id , " added by ", NEW.project_owner_id), NEW.project_owner_id, 2);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_project_update AFTER UPDATE ON project
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("project ", NEW.project_id, " updated by ", NEW.modified_by), 3);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("project ", NEW.project_id, " updated by ", NEW.modified_by), NEW.modified_by, 3);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `project_activities`
--

DROP TABLE IF EXISTS `project_activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_activities`
--

LOCK TABLES `project_activities` WRITE;
/*!40000 ALTER TABLE `project_activities` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_category`
--

DROP TABLE IF EXISTS `project_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_category`
--

LOCK TABLES `project_category` WRITE;
/*!40000 ALTER TABLE `project_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_file`
--

DROP TABLE IF EXISTS `project_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_file` (
  `project_file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) NOT NULL,
  `project_id` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `file_type` varchar(45) NOT NULL,
  PRIMARY KEY (`project_file_id`),
  KEY `project_file_fk` (`project_id`),
  CONSTRAINT `project_file_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_file`
--

LOCK TABLES `project_file` WRITE;
/*!40000 ALTER TABLE `project_file` DISABLE KEYS */;
INSERT INTO `project_file` VALUES (15,'Details 1.pdf',1,'2015-01-19 13:21:21','1','application/pdf'),(16,'Details 2.pdf',1,'2015-01-19 13:21:44','1','application/pdf');
/*!40000 ALTER TABLE `project_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_member`
--

DROP TABLE IF EXISTS `project_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_member`
--

LOCK TABLES `project_member` WRITE;
/*!40000 ALTER TABLE `project_member` DISABLE KEYS */;
INSERT INTO `project_member` VALUES (1,1,1,'ACTIVE'),(2,1,1011406604,'ACTIVE');
/*!40000 ALTER TABLE `project_member` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_projectMember_add AFTER INSERT ON project_member
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New member ", NEW.user_id," added for project ",NEW.project_id), 8);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New member ", NEW.user_id," added for project ",NEW.project_id), NEW.user_id, 8);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `project_task`
--

DROP TABLE IF EXISTS `project_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_task`
--

LOCK TABLES `project_task` WRITE;
/*!40000 ALTER TABLE `project_task` DISABLE KEYS */;
INSERT INTO `project_task` VALUES (1,1,'Installation of Lights',0,'1',NULL,'2015-01-11','2015-01-14','2015-01-09 23:00:59',0,'2015-01-09 23:00:59',0,'1','Installation of lights'),(2,3,'activity-2 task',0,'1',NULL,'2015-01-11','2015-01-15','2015-01-10 13:42:52',0,'2015-01-10 13:42:52',0,'1','activity task'),(3,2,'Kitchen supply',0,'2',0,'2015-01-11','2015-01-11','2015-01-11 11:40:18',0,'2015-01-19 13:11:12',1,'2','fix tiles'),(4,19,'sdfdfadsfadsf',0,'1',NULL,'2014-11-30','2015-02-05','2015-01-12 10:00:11',0,'2015-01-12 10:00:11',0,'1','asdfdfsadsaf'),(5,5,'plumbing-task-1',0,'1',0,'2015-01-12','2015-01-14','2015-01-12 12:46:46',0,'2015-01-13 08:10:53',1,'1','plumbing-task-1'),(6,2,'kitchen - 3-edit',0,'3',0,'2015-01-11','2015-01-15','2015-01-13 06:39:36',1,'2015-01-19 13:11:45',1,'1','kitchen - 3-edit');
/*!40000 ALTER TABLE `project_task` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_task_add AFTER INSERT ON project_task
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New task ", NEW.title, " of id ", New.project_task_id , " added by ", NEW.created_by), 4);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New task ", NEW.title, " of id ", New.project_task_id , " added by ", NEW.created_by), NEW.created_by, 4);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_task_update AFTER UPDATE ON project_task
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("task ", NEW.title, " of id ", New.project_task_id , " updated by ", NEW.modified_by), 5);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("task ", NEW.title, " of id ", New.project_task_id , " updated by ", NEW.modified_by), NEW.created_by, 5);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `project_task_comments`
--

DROP TABLE IF EXISTS `project_task_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_task_comments`
--

LOCK TABLES `project_task_comments` WRITE;
/*!40000 ALTER TABLE `project_task_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_task_comments` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_comment_add AFTER INSERT ON project_task_comments
FOR EACH ROW BEGIN

  INSERT INTO user_notification (text, user_id, category) VALUES
    (CONCAT("Comment ", NEW.comment, " added on task ", NEW.project_task_id, " by ", NEW.comment_by), NEW.comment_by,
     1);
  INSERT INTO activity_log (text, user_id, category) VALUES
    (CONCAT("Comment ", NEW.comment, " added on task ", NEW.project_task_id), NEW.comment_by,
     1);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `project_task_files`
--

DROP TABLE IF EXISTS `project_task_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_task_files`
--

LOCK TABLES `project_task_files` WRITE;
/*!40000 ALTER TABLE `project_task_files` DISABLE KEYS */;
INSERT INTO `project_task_files` VALUES (1,3,'bsn1.jpg','/client/assets/task/','2015-01-12 13:01:22',1),(2,2,'test.txt','/server/assets/task/','2015-01-13 14:13:35',1),(3,3,'DSC_1718.JPG','/client/assets/task/','2015-01-16 05:02:25',1011406604),(11,3,'2015-01-02 12.40.35.jpg','/client/assets/task/','2015-01-17 07:40:41',1);
/*!40000 ALTER TABLE `project_task_files` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_projectTaskFile_add AFTER INSERT ON project_task_files
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New file ", NEW.file_name," uploaded for task ",NEW.project_task_id, " by user ", NEW.created_by), 10);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New file ", NEW.file_name," uploaded for task ",NEW.project_task_id, " by user ", NEW.created_by), NEW.created_by, 10);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `project_type`
--

DROP TABLE IF EXISTS `project_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_type`
--

LOCK TABLES `project_type` WRITE;
/*!40000 ALTER TABLE `project_type` DISABLE KEYS */;
INSERT INTO `project_type` VALUES (1,'COMMERCIAL','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE'),(2,'RESIDENTIAL','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE'),(3,'INFRASTRUCTURE','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE'),(4,'MEDICAL','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE');
/*!40000 ALTER TABLE `project_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_wall_post`
--

DROP TABLE IF EXISTS `project_wall_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_wall_post`
--

LOCK TABLES `project_wall_post` WRITE;
/*!40000 ALTER TABLE `project_wall_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_wall_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration_request`
--

DROP TABLE IF EXISTS `registration_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `registration_token` varchar(64) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `company_name` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `msg` text,
  `status` varchar(20) DEFAULT NULL,
  `ts_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration_request`
--

LOCK TABLES `registration_request` WRITE;
/*!40000 ALTER TABLE `registration_request` DISABLE KEYS */;
INSERT INTO `registration_request` VALUES (2,'428206657838463924041187614985792714519492428695044178242038',1,'',NULL,NULL,NULL,NULL,NULL,NULL,'ACCT_INVITE','2015-01-11 05:45:14',NULL),(3,'64713267214124527376857149902133826553861355364403214847051',1,'','Niranjan','Shrestha','nlalshrestha@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-11 17:38:29',1686452034),(4,'343291216567145600082014417652674813974988191543434216587228',1,'','Niranjan','Shrestha','nlalshrestha@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-11 17:38:39',NULL),(5,'560879354468331296021022279318422234533408096361567269526158',1,'',NULL,NULL,NULL,NULL,NULL,NULL,'ACCT_INVITE','2015-01-12 05:10:54',NULL),(6,'145475899084511879506983452505620002737340864143527873486904',1,'',NULL,NULL,NULL,NULL,NULL,NULL,'ACCT_INVITE','2015-01-12 07:44:52',NULL),(7,'1827753176295259741501544714186829354336025862758009208315',1,'','sumit','shrestha','rhs4shr@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-12 09:35:59',NULL),(8,'726052518122673849710334747276930133986040872669835466732811',1,'','asdfadsf','asdfadsf','asdfdasf@asdfdsf.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-12 09:38:06',NULL),(9,'606960465105233441099497523702905270361539533315955260993414',1,'','basant','rijal','rijalbsn@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-12 19:34:56',NULL),(10,'229778400058301941802602167297188449405467020337530367143360',1,'','Basant','Rijan','rijalbsn@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-12 19:43:28',NULL),(11,'444013664823315293983275938827194610692954856864854376892893',1,'','Aashis','Khanal','aashis_khl@yahoo.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-12 19:44:20',NULL),(12,'635630220721152693387790763915576861839094347001211197277097',1,'','aashis','khanal','aashiskhanal@yahoo.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-12 19:46:28',NULL),(13,'402626517357884385697775265357666186947717189392044772011025',1,'',NULL,NULL,NULL,NULL,NULL,NULL,'ACCT_INVITE','2015-01-12 19:52:20',NULL),(14,'295476874453393381060766678162276783873433076186190947693592',1,'',NULL,NULL,NULL,NULL,NULL,NULL,'ACCT_INVITE','2015-01-12 19:52:40',NULL),(15,'113935243838375895402229891186389571156845506876201159466242',1,'','Niranjan','Shrestha','',NULL,NULL,NULL,'ACCT_INVITE','2015-01-13 03:25:57',NULL),(16,'518940441045446917591469825240864015779594803428118250822209',1,'',NULL,NULL,NULL,NULL,NULL,NULL,'ACCT_INVITE','2015-01-13 05:25:50',NULL),(17,'585934053601158290892538075030391043780294509705381491972516',1,'','basant','rijal','rijalbsn@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-13 17:03:01',NULL),(18,'309462986670016992912932885005017514156240593222762859796181',1,'','Aashis','Khanal','aashis.khanal@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 03:31:17',NULL),(19,'768781907748199878876709511800775865023939633518385700866309',1,'','Aashis','Khanal','aashiskhanal@yahoo.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 03:38:45',NULL),(20,'656657331057304871480602459752234186202631205475425062086234',1,'','Aashis','Khanal','aashis.khanal@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 03:42:03',NULL),(21,'365617577704934309502144702977000201971798137916475159679916',1,'','Aashis','Khanal','aashis.khanal@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 03:44:31',NULL),(22,'340501111777656933171013174562740931045618143752185983271083',1,'','Binaya','Adhikari','email2binaya@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 04:08:39',NULL),(23,'278823138418718713817462123246577197109431967389197614364165',1,'','Binaya','Adhikari','email2binaya@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 04:11:37',NULL),(24,'429563672967919871281332983100726627655849208544129786754951',1,'','binaya','adhikari','email2binaya@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 04:16:13',NULL),(25,'167842414556016391244235732976683597734466190772265072361370',1,'','Binaya','Adhikari','email2binaya@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 04:34:07',NULL),(26,'60081129173454984777318334455530149346137665558320849908356',1,'','sanjeev','ghimire','email2binaya@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 04:39:53',NULL),(27,'238362288424308599828850490700204158712373833048986483840382',1,'','sanjeev','ghimire','email2binaya@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 04:39:57',NULL),(28,'762387093233569350076389856728538962307236377592802609783223',1,'','sanjeev','ghimire','email2binaya@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-14 04:55:31',NULL),(29,'126050159120336443579237130781742465679538948298632479945596',1,'',NULL,NULL,NULL,NULL,NULL,NULL,'ACCT_INVITE','2015-01-15 03:39:08',NULL),(30,'384763849348984829350609377582954808437444547759773477115050',1,'','Aashis','Khanal','aashis.khanal@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-15 04:06:59',70246881),(31,'584379033126948836285912300167952821973264119361559894207035',1,'','Aashis','Khanal','aashis.khanal@gmail.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-16 03:02:18',NULL),(32,'733074263663563311242598141375044910137347918884045613312294',1,'','Nitika','Pradhan','aashis@ontargetcloud.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-16 03:06:23',510260216),(33,'30252497726887170374794348489275539960848321539707232071563',1,'','Nitika','Pradhan','aashis@ontargetcloud.com',NULL,NULL,NULL,'ACCT_INVITE','2015-01-16 03:55:25',1011406604),(34,'344201270913382616031528003577986122099023589567356062538621',1,'',NULL,NULL,NULL,NULL,NULL,NULL,'ACCT_INVITE','2015-01-17 16:39:20',NULL),(35,'204616183891575109947521223234522323814468269159458852447331',1,'',NULL,NULL,NULL,NULL,NULL,NULL,'ACCT_INVITE','2015-01-17 18:51:21',NULL),(36,'700772287616233583492328396570364780617694647033605170860310',1,'',NULL,NULL,NULL,NULL,NULL,NULL,'ACCT_INVITE','2015-01-17 18:51:35',NULL),(37,'379291213098487660039914689388942456265716745052516413804099',2,'sumit shrestha',NULL,NULL,'rhs4shr@gmail.com','test','981564654','adsfadsf ','PENDING','2015-01-18 15:56:17',NULL);
/*!40000 ALTER TABLE `registration_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `states` (
  `state_code` char(2) NOT NULL,
  `state` varchar(45) NOT NULL,
  PRIMARY KEY (`state_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_assignee`
--

DROP TABLE IF EXISTS `task_assignee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_assignee`
--

LOCK TABLES `task_assignee` WRITE;
/*!40000 ALTER TABLE `task_assignee` DISABLE KEYS */;
INSERT INTO `task_assignee` VALUES (31,1,1,1,'2015-01-19 10:41:17',1,'2015-01-19 04:41:17'),(35,3,1,1,'2015-01-19 19:11:55',1,'2015-01-19 13:11:55'),(36,3,1011406604,1,'2015-01-19 19:11:55',1,'2015-01-19 13:11:55');
/*!40000 ALTER TABLE `task_assignee` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`ontarget`@`localhost`*/ /*!50003 TRIGGER log_taskAssignee_add AFTER INSERT ON task_assignee
FOR EACH ROW BEGIN
INSERT INTO activity_log (text, category) VALUES (CONCAT("New assignee ", NEW.task_assignee," added for task ",NEW.project_task_id), 9);
INSERT INTO user_notification (text, user_id, category) VALUES (CONCAT("New assignee ", NEW.task_assignee," added for task ",NEW.task_assignee), NEW.task_assignee, 9);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `task_comment`
--

DROP TABLE IF EXISTS `task_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_comment`
--

LOCK TABLES `task_comment` WRITE;
/*!40000 ALTER TABLE `task_comment` DISABLE KEYS */;
INSERT INTO `task_comment` VALUES (1,1,'great task',0,'2015-01-09 23:12:07','ACTIVE'),(2,1,'Hey',0,'2015-01-11 11:35:22','ACTIVE'),(3,3,'comment by basant rijal',1,'2015-01-19 05:55:38','ACTIVE'),(4,3,'test',1,'2015-01-20 09:32:11','ACTIVE');
/*!40000 ALTER TABLE `task_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_percentage_log`
--

DROP TABLE IF EXISTS `task_percentage_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_percentage_log`
--

LOCK TABLES `task_percentage_log` WRITE;
/*!40000 ALTER TABLE `task_percentage_log` DISABLE KEYS */;
INSERT INTO `task_percentage_log` VALUES (1,1,'PERCENTAGE',58,'2015-01-11 11:35:38','9999-12-31 00:00:00','0','2015-01-11 11:35:38','0','2015-01-11 11:35:38'),(2,3,'PERCENTAGE',25,'2015-01-11 11:40:32','2015-01-16 23:36:07','0','2015-01-11 11:40:32','0','2015-01-11 11:40:32'),(3,3,'PERCENTAGE',53,'2015-01-15 23:00:50','2015-01-16 23:36:07','0','2015-01-15 23:00:50','0','2015-01-15 23:00:50'),(4,3,'PERCENTAGE',21,'2015-01-16 21:52:17','2015-01-16 23:36:07','0','2015-01-16 21:52:17','0','2015-01-16 21:52:17'),(5,3,'PERCENTAGE',64,'2015-01-16 22:59:52','2015-01-16 23:36:07','0','2015-01-16 22:59:52','0','2015-01-16 22:59:52'),(6,3,'PERCENTAGE',21,'2015-01-16 23:00:05','2015-01-16 23:36:07','0','2015-01-16 23:00:05','0','2015-01-16 23:00:05'),(7,3,'PERCENTAGE',71,'2015-01-16 23:00:36','9999-12-31 00:00:00','0','2015-01-16 23:00:36','0','2015-01-16 23:00:36'),(8,3,'PERCENTAGE',44,'2015-01-16 23:59:15','9999-12-31 00:00:00','0','2015-01-16 23:59:15','0','2015-01-16 23:59:15'),(9,6,'PERCENTAGE',51,'2015-01-18 11:09:42','9999-12-31 00:00:00','0','2015-01-18 11:09:42','0','2015-01-18 11:09:42');
/*!40000 ALTER TABLE `task_percentage_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_status`
--

DROP TABLE IF EXISTS `task_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_status` (
  `task_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_code` varchar(15) DEFAULT NULL,
  `status_name` varchar(15) DEFAULT NULL,
  `status_description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`task_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_status`
--

LOCK TABLES `task_status` WRITE;
/*!40000 ALTER TABLE `task_status` DISABLE KEYS */;
INSERT INTO `task_status` VALUES (1,'ACTIVE','Active','Active Status'),(2,'ONGOING','Ongoing','Ongoing Status'),(3,'COMPLETED','Completed','Completed Status'),(4,'PENDING','Pending','Pending Status');
/*!40000 ALTER TABLE `task_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_type_id` int(11) DEFAULT NULL,
  `password` text NOT NULL,
  `salt` text NOT NULL,
  `user_status` enum('1','0') DEFAULT '0',
  `discipline` bigint(20) NOT NULL,
  `number_of_login` int(11) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `account_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`),
  KEY `fk_user_type_id_idx` (`user_type_id`),
  CONSTRAINT `fk_user_type_id` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`user_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1686452035 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sanjeev@ontargetcloud.com',1,'10515762231801932055942522785891722998094701605877005091931551573660595626724150388858932701341485373009333081613193941784374252782071997234564297484308712','50361531871558752904344884219565807138913546494717517369715431234690292284291316205859193226222504923221934193852719115666533569920831077286174878116017226316533849655637467991547483853663839295443622857882395639070329758961677375812931980163878875440695468844619476672047308085777931365264715137911782725553','1',1,1,'2014-11-05 02:30:40','ACTIVE'),(70246881,'aashis.khanal@gmail.com',1,'1051285348528545785797644521946512632872872062151521083272095543073209804213785874083198935593485151739245608362858353832053920222011562487339797266572676','6913071779033782592949626409511406451160440937191820981952027306478224479219616707772312516653586820508629088014731780808333789558529377780768254592498335580770871703086996515116625802804545050968425285988135438669218608180119181188406014418541964775042419175763047774435616049203743800534197924896423077592','1',2,1,'2015-01-14 22:08:17','ACCT_INVITE'),(1011406604,'aashis@ontargetcloud.com',1,'9623576865848815273223311793894372701105520796387300948224723103841111456232473970130595075988604963210344962283437577741699307450857718633365386005206571','80071932072993292548110343007649167552578942466418833785059445539725718138181630121061116680473550318179927230808459566284617293294387078615774699864651465199712887187254889867554821462962973525274383607355688782402174747910295007429065501992208336465570193051174262525470199685660792271103979346424859420539','1',2,1,'2015-01-15 21:56:00','ACTIVE'),(1686452034,'nlalshrestha@gmail.com',1,'6219764909995843219278520634957056939925687483587497114579355079566813568755090699249706059706891070058730222287141849455166404240212638710795742480242514','2813492369955308449549022946107539039602045770573754261131200242889656851718703935054070942049994753016122447964370214147382235175295028367234634714227703195470155341853320339918348672527203981107564652699806603121055429995587665555419248680196546472730695313245243238307203647316079864573753685433142113263','1',2,1,'2015-01-11 11:39:10','ACCT_INVITE');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_groups`
--

DROP TABLE IF EXISTS `user_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_groups`
--

LOCK TABLES `user_groups` WRITE;
/*!40000 ALTER TABLE `user_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_notification`
--

DROP TABLE IF EXISTS `user_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `text` text,
  `category` bigint(20) DEFAULT NULL,
  `user_id` int(12) NOT NULL,
  `ts_insert` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_notification`
--

LOCK TABLES `user_notification` WRITE;
/*!40000 ALTER TABLE `user_notification` DISABLE KEYS */;
INSERT INTO `user_notification` VALUES (1,'adfs adsf adsfadsf dafs ',2323,0,'2014-12-26 22:49:39'),(2,'Comment asfasfdsaf adsfdsf added on task 1 by 23223',1,23223,'2014-12-27 22:44:05'),(3,'Comment dfgfdg asgfdg added on task 1 by 1',1,1,'2014-12-28 19:58:19'),(4,'project 2 updated by 1',3,1,'2015-01-16 11:39:12'),(5,'New planned cost added for task  by 13',6,1,'2015-01-16 19:20:31'),(6,'New file 2015-01-02 12.40.35.jpg uploaded for task 3 by user 1',10,1,'2015-01-17 07:40:41'),(7,'New planned cost added for task  by 13',6,1,'2015-01-17 07:45:31'),(8,'New planned cost added for task  by 13',6,1,'2015-01-17 07:45:31'),(9,'planned cost updated for task 3 by 1',7,1,'2015-01-17 07:46:24'),(10,'planned cost updated for task 3 by 1',7,1,'2015-01-17 07:46:24'),(11,'project 15 updated by 1',3,1,'2015-01-17 11:02:30'),(12,'project 2 updated by 1',3,1,'2015-01-17 11:14:00'),(13,'task Kitchen supply of id 3 updated by 1',5,0,'2015-01-17 11:14:16'),(14,'New planned cost added for task  by 16',6,1,'2015-01-18 09:59:49'),(15,'New planned cost added for task  by 16',6,1,'2015-01-18 09:59:49'),(22,'New assignee 1 added for task 1',9,1,'2015-01-18 11:07:58'),(23,'New assignee 1 added for task 1',9,1,'2015-01-19 09:12:18'),(25,'New assignee 1 added for task 1',9,1,'2015-01-19 09:15:02'),(26,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 09:15:02'),(27,'New assignee 1 added for task 1',9,1,'2015-01-19 09:22:58'),(28,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 09:22:58'),(29,'New assignee 1 added for task 1',9,1,'2015-01-19 09:37:52'),(30,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 09:37:52'),(31,'New assignee 1 added for task 1',9,1,'2015-01-19 09:38:36'),(32,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 09:38:36'),(33,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 09:38:36'),(34,'New assignee 1 added for task 1',9,1,'2015-01-19 09:42:05'),(35,'New assignee 1 added for task 1',9,1,'2015-01-19 10:10:10'),(36,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 10:10:13'),(37,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 10:13:44'),(38,'New assignee 1 added for task 1',9,1,'2015-01-19 10:18:22'),(39,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 10:18:22'),(40,'New assignee 1 added for task 1',9,1,'2015-01-19 10:18:29'),(41,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 10:18:29'),(42,'New assignee 1 added for task 1',9,1,'2015-01-19 10:21:17'),(43,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 10:21:17'),(44,'New assignee 1 added for task 1',9,1,'2015-01-19 10:40:51'),(45,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 10:40:51'),(46,'New assignee 1 added for task 1',9,1,'2015-01-19 10:41:17'),(47,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 11:53:43'),(48,'New assignee 1 added for task 1',9,1,'2015-01-19 11:53:43'),(49,'New assignee 1 added for task 1',9,1,'2015-01-19 14:47:01'),(50,'project 1 updated by 0',3,0,'2015-01-19 17:43:54'),(51,'task Kitchen supply of id 3 updated by 1',5,0,'2015-01-19 19:09:37'),(52,'task Kitchen supply of id 3 updated by 1',5,0,'2015-01-19 19:11:12'),(53,'task kitchen - 3-edit of id 6 updated by 1',5,1,'2015-01-19 19:11:45'),(54,'New assignee 1 added for task 1',9,1,'2015-01-19 19:11:55'),(55,'New assignee 1011406604 added for task 1011406604',9,1011406604,'2015-01-19 19:11:55');
/*!40000 ALTER TABLE `user_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_safety_info`
--

DROP TABLE IF EXISTS `user_safety_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_safety_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(524) NOT NULL,
  `info` text NOT NULL,
  `discipline_id` bigint(20) NOT NULL,
  `ts_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_safety_info`
--

LOCK TABLES `user_safety_info` WRITE;
/*!40000 ALTER TABLE `user_safety_info` DISABLE KEYS */;
INSERT INTO `user_safety_info` VALUES (2,'10 fingers, 10 toes 2 eyes 1 nose…safety counts','',1,'2014-12-02 21:41:53'),(3,'10 fingers. 10 toes, If you are not safe Who knows?','',1,'2014-12-02 21:41:53'),(4,'A clean floor everyday keeps lost days away.','',1,'2014-12-02 21:41:53'),(5,'A spill, a slip, a hospital trip','',1,'2014-12-02 21:41:53'),(6,'A tree never hits an automobile except in self defense','',1,'2014-12-02 21:41:53'),(7,'Accidents Big Or Small, Avoid Them All','',1,'2014-12-02 21:41:53'),(8,'Accidents hurt, Safety doesn’t.','',1,'2014-12-02 21:41:53'),(9,'An ounce of prevention is worth a pound of cure','',1,'2014-12-02 21:41:53'),(10,'Are you part of the safety TEAM….(Together Employees Accomplish More)','',1,'2014-12-02 21:41:53'),(11,'Arms work best when attached to the body','',1,'2014-12-02 21:41:54'),(12,'At work at play, let safety lead the way.','',1,'2014-12-02 21:41:54'),(13,'Avoid the worst. Put safety first.','',1,'2014-12-02 21:41:54'),(14,'Be a safety hero – score an accident zero','',1,'2014-12-02 21:41:54'),(15,'Be alert! Accidents hurt.','',1,'2014-12-02 21:41:54'),(16,'Be aware Take care','',1,'2014-12-02 21:41:54'),(17,'Before you do it, take time to think through it.','',1,'2014-12-02 21:41:54'),(18,'Behind the wheel, anger is one letter away from danger.','',1,'2014-12-02 21:41:54'),(19,'Being safe is in your own hands.','',1,'2014-12-02 21:41:54'),(20,'Best gift you can give your family is YOU! Please be safe','',1,'2014-12-02 21:41:54'),(21,'Break the drive and arrive alive.','',1,'2014-12-02 21:41:54'),(22,'Chance takers are accident makers','',1,'2014-12-02 21:41:54'),(23,'Choose safety, for your family.','',1,'2014-12-02 21:41:54'),(24,'Click clack front and back.','',1,'2014-12-02 21:41:55'),(25,'Click it or ticket!','',1,'2014-12-02 21:41:55'),(26,'Computer problems you can avoid, so you don’t have to get paranoid.','',1,'2014-12-02 21:41:55'),(27,'Courtesy and common sense promote safety.','',1,'2014-12-02 21:41:55'),(28,'Courtesy is contagious','',1,'2014-12-02 21:41:55'),(29,'Dare to be aware.','',1,'2014-12-02 21:41:55'),(30,'Do you have eye for safety or are you blinded by bad habits','',1,'2014-12-02 21:41:55'),(31,'Doesn’t matter how far. JUST BELT UP!','',1,'2014-12-02 21:41:55'),(32,'Don’t be a fool, cause safety is cool, so make that your rule.','',1,'2014-12-02 21:41:55'),(33,'Don’t be a fool. Use the proper tool.','',1,'2014-12-02 21:41:55'),(34,'Don’t be hasty when it comes to safety.','',1,'2014-12-02 21:41:55'),(35,'Don’t be safety blinded, be safety minded.','',1,'2014-12-02 21:41:55'),(36,'Don’t learn safety by accident.','',1,'2014-12-02 21:41:55'),(37,'Don’t leave Private information on a public computer screen','',1,'2014-12-02 21:41:55'),(38,'Eyes are priceless, eye protection is cheap.','',1,'2014-12-02 21:41:55'),(39,'Falling objects can be brutal if you don’t protect your noodle.','',1,'2014-12-02 21:41:55'),(40,'Fingers toes, If you are not safe Who knows?','',1,'2014-12-02 21:41:55'),(41,'Forget the nurse with safety first.','',1,'2014-12-02 21:41:55'),(42,'Forgot your hearing protection? Forget about hearing!','',1,'2014-12-02 21:41:55'),(43,'Get in high speed pursuit of safety','',1,'2014-12-02 21:41:56'),(44,'Get smart! Use safety from the start.','',1,'2014-12-02 21:41:56'),(45,'Give them a Brake!','',1,'2014-12-02 21:41:56'),(46,'Got crazy with the lighter? Call a firefighter.','',1,'2014-12-02 21:41:56'),(47,'Hard hats, they’re not just for decoration','',1,'2014-12-02 21:41:56'),(48,'Have another day by being safe today!','',1,'2014-12-02 21:41:56'),(49,'Hearing protection is a sound investment.','',1,'2014-12-02 21:41:56'),(50,'Housekeeping you skip may cause a fall or slip.','',1,'2014-12-02 21:41:56'),(51,'If everything comes your way, you are in the wrong lane.','',1,'2014-12-02 21:41:56'),(52,'If they email you asking for cash, be sure to throw it in the trash.','',1,'2014-12-02 21:41:56'),(53,'If they email you asking for Money, Say no thanks I won’t fall for it honey.','',1,'2014-12-02 21:41:56'),(54,'If you don’t know the sender, it might be a pretender','',1,'2014-12-02 21:41:56'),(55,'If you don’t think it will happen to you, find the person who had it happen to them','',1,'2014-12-02 21:41:56'),(56,'If you mess up, ‘fess up','',1,'2014-12-02 21:41:56'),(57,'Is better to lose one minute in life… than to lose life in a minute.','',1,'2014-12-02 21:41:56'),(58,'It only takes one mistake to bring us all down; don’t let it be yours!','',1,'2014-12-02 21:41:57'),(59,'It’s easier to ask a dumb question than it is to fix a dumb mistake','',1,'2014-12-02 21:41:57'),(60,'Keep a grip on life and protect your hands','',1,'2014-12-02 21:41:57'),(61,'Keep safety in mind. It will save your behind.','',1,'2014-12-02 21:41:57'),(62,'Keeping your work area clean, helps keep hazards from being unseen.','',1,'2014-12-02 21:41:57'),(63,'Knock out…accidents','',1,'2014-12-02 21:41:57'),(64,'Know safety – no pain','',1,'2014-12-02 21:41:57'),(65,'Know safety No Accidents','',1,'2014-12-02 21:41:57'),(66,'Lead the way, safety today.','',1,'2014-12-02 21:41:57'),(67,'Learn from others mistakes, don’t have others learn from you.','',1,'2014-12-02 21:41:57'),(68,'Let’s all keep our heads, and other body parts, together','',1,'2014-12-02 21:41:57'),(69,'Life’s short, don’t rush it','',1,'2014-12-02 21:41:57'),(70,'Light up your tree – not your home','',1,'2014-12-02 21:41:57'),(71,'Make it your mission, not to live in unsafe condition.','',1,'2014-12-02 21:41:57'),(72,'Make safety a reality and don’t be a fatality','',1,'2014-12-02 21:41:57'),(73,'My job provides my paycheck, but safety takes me home.','',1,'2014-12-02 21:41:57'),(74,'Near miss reported today, is the accident that does not happen tomorrow.','',1,'2014-12-02 21:41:57'),(75,'Never drive faster than your guardian angel can fly','',1,'2014-12-02 21:41:57'),(76,'Never give safety a day off','',1,'2014-12-02 21:41:57'),(77,'No Belt. No Brains','',1,'2014-12-02 21:41:57'),(78,'No safety – know pain','',1,'2014-12-02 21:41:57'),(79,'One bad day at the grinder could ruin your whole life','',1,'2014-12-02 21:41:57'),(80,'Only You can prevent forest fires!','',1,'2014-12-02 21:41:57'),(81,'Pencils have erasers–mishaps don’t!','',1,'2014-12-02 21:41:58'),(82,'Prevent a jam, don’t open spam','',1,'2014-12-02 21:41:58'),(83,'Protect your hands, you need them to pick up your pay check','',1,'2014-12-02 21:41:58'),(84,'Quench the thirst – safety first','',1,'2014-12-02 21:41:58'),(85,'Replacing a saw guard is easier than replacing a finger','',1,'2014-12-02 21:41:58'),(86,'Safe crane operation is uplifting','',1,'2014-12-02 21:41:58'),(87,'Safety – A small investment for a rich future','',1,'2014-12-02 21:41:58'),(88,'Safety by Choice, Not by Chance.','',1,'2014-12-02 21:41:58'),(89,'Safety comes in a can, I can, You can, We can be safe.','',1,'2014-12-02 21:41:58'),(90,'Safety doesn’t happen by accident','',1,'2014-12-02 21:41:58'),(91,'Safety first makes us last.','',1,'2014-12-02 21:41:58'),(92,'Safety First, Avoid the Worst.','',1,'2014-12-02 21:41:58'),(93,'Safety first, to last.','',1,'2014-12-02 21:41:58'),(94,'Safety first…because accidents last.','',1,'2014-12-02 21:41:58'),(95,'Safety fits like a glove; Try one on.','',1,'2014-12-02 21:41:58'),(96,'Safety Glasses – All in favor say EYE','',1,'2014-12-02 21:41:58'),(97,'Safety in – we win','',1,'2014-12-02 21:41:58'),(98,'Safety is a cheap and effective insurance policy','',1,'2014-12-02 21:41:58'),(99,'Safety is a continuing journey, not a final destination.','',1,'2014-12-02 21:41:58'),(100,'Safety is a frame of mind – So concentrate on it all the time.','',1,'2014-12-02 21:41:59'),(101,'Safety is a Frame of Mind, Get the Picture.','',1,'2014-12-02 21:41:59'),(102,'Safety is a full time job – don’t make it a part time practice','',1,'2014-12-02 21:41:59'),(103,'Safety is a mission not an intermission','',1,'2014-12-02 21:41:59'),(104,'Safety is about doing the right thing, even if no one is looking.','',1,'2014-12-02 21:41:59'),(105,'Safety is as simple as ABC – Always Be Careful','',1,'2014-12-02 21:41:59'),(106,'Safety is like a lock – But you are the key.','',1,'2014-12-02 21:41:59'),(107,'Safety is no accident','',1,'2014-12-02 21:41:59'),(108,'Safety is success by purpose – Not Accident.','',1,'2014-12-02 21:41:59'),(109,'Safety isn’t a hobby, it’s a living.','',1,'2014-12-02 21:41:59'),(110,'Safety isn’t expensive it’s priceless.','',1,'2014-12-02 21:41:59'),(111,'Safety isn’t just a slogan, it’s a way of life.','',1,'2014-12-02 21:41:59'),(112,'Safety makes good dollars and sense','',1,'2014-12-02 21:41:59'),(113,'Safety rules are there to follow. So take care and we will see you tomorrow.','',1,'2014-12-02 21:41:59'),(114,'Safety rules are your best tools.','',1,'2014-12-02 21:41:59'),(115,'Safety saves, Accidents cost you.','',1,'2014-12-02 21:41:59'),(116,'Safety starts with “S” but begins with “YOU”.','',1,'2014-12-02 21:42:00'),(117,'Safety starts with me.','',1,'2014-12-02 21:42:00'),(118,'Safety: more fun than running with scissors','',1,'2014-12-02 21:42:00'),(119,'Safety… It can charm you, or ALARM you!','',1,'2014-12-02 21:42:00'),(120,'Safety…Did it, done it, doing it tomorrow','',1,'2014-12-02 21:42:00'),(121,'Safety…one habit you never need to break','',1,'2014-12-02 21:42:00'),(122,'Save tomorrow. Think safety today.','',1,'2014-12-02 21:42:00'),(123,'Seat Belts are for kids – Hug them at home – Belt them in the car','',1,'2014-12-02 21:42:00'),(124,'Seatbelts save lives. Buckle up everytime.','',1,'2014-12-02 21:42:00'),(125,'Shortcuts cut life short','',1,'2014-12-02 21:42:00'),(126,'Speed Thrills but Kills.','',1,'2014-12-02 21:42:00'),(127,'Stay safe, someone at home is waiting for you.','',1,'2014-12-02 21:42:00'),(128,'Stop drop & roll','',1,'2014-12-02 21:42:00'),(129,'Success is no accident','',1,'2014-12-02 21:42:00'),(130,'The best car safety device is a rear-view mirror with a cop in it.','',1,'2014-12-02 21:42:00'),(131,'The door to Safety swings on the hinges of common sense','',1,'2014-12-02 21:42:00'),(132,'The only trip you take should be on vacation.','',1,'2014-12-02 21:42:00'),(133,'The safe way is the only way.','',1,'2014-12-02 21:42:00'),(134,'The stupid shall be punished','',1,'2014-12-02 21:42:00'),(135,'Think Safety, Because I Love You Man.','',1,'2014-12-02 21:42:00'),(136,'Think sharp….never handle broken glass with bare hands.','',1,'2014-12-02 21:42:00'),(137,'Think smart before you start.','',1,'2014-12-02 21:42:00'),(138,'Those precious fingers don’t ignore, Or they could end up on the floor.','',1,'2014-12-02 21:42:00'),(139,'Those who work the safest way- live to see another day','',1,'2014-12-02 21:42:01'),(140,'To avoid a scene keep your work place clean.','',1,'2014-12-02 21:42:01'),(141,'To prevent a drastic call, Install a firewall','',1,'2014-12-02 21:42:01'),(142,'Tomorrow: Your reward for working safely today.','',1,'2014-12-02 21:42:01'),(143,'Trying to make up time could cost you your life.','',1,'2014-12-02 21:42:01'),(144,'Unsafe acts will keep you in stitches','',1,'2014-12-02 21:42:01'),(145,'Watch where you walk or you might need a walker.','',1,'2014-12-02 21:42:01'),(146,'Watch your step – it could be your last tomorrow','',1,'2014-12-02 21:42:01'),(147,'whats holding you back?','',1,'2014-12-02 21:42:01'),(148,'When you gamble with safety ..You bet your life.','',1,'2014-12-02 21:42:01'),(149,'While on a ladder, never step back to admire your work','',1,'2014-12-02 21:42:01'),(150,'Wipe Up and avoid a Slip Up!','',1,'2014-12-02 21:42:01'),(151,'Work safe today–heaven can wait.','',1,'2014-12-02 21:42:01'),(152,'Work together…work safely.','',1,'2014-12-02 21:42:01'),(153,'Working safely may get old, but so do those who practice it.','',1,'2014-12-02 21:42:01'),(154,'Your first mistake could be your last','',1,'2014-12-02 21:42:01'),(155,'Your reward for working safely today.','',1,'2014-12-02 21:42:01'),(156,'Your wife will spend your 401K; If you get killed at work today.','',1,'2014-12-02 21:42:01'),(157,'Protect your hands, you need them to pick up your pay check','',1,'2014-12-02 21:42:01'),(158,'Your wife will spend your 401K; If you get killed at work today','',1,'2014-12-02 21:42:01'),(159,'Safety…Did it, done it, doing it tomorrow','',1,'2014-12-02 21:42:01'),(160,'Watch your step - it could be your last tomorrow','',1,'2014-12-02 21:42:01'),(161,'Those precious fingers don’t ignore. . . Or they could end up on the floor','',1,'2014-12-02 21:42:01'),(162,'Your reward for working safely today.','',1,'2014-12-02 21:42:02'),(163,'Those who work the safest way- live to see another day','',1,'2014-12-02 21:42:02'),(164,'Get in high speed pursuit of safety','',1,'2014-12-02 21:42:02'),(165,'Seat Belts are for kids - Hug them at home - Belt them in the car','',1,'2014-12-02 21:42:02'),(166,'Safe crane operation is uplifting','',1,'2014-12-02 21:42:02'),(167,'Pencils have erasers–mishaps don’t!','',1,'2014-12-02 21:42:02'),(168,'Work safe today–heaven can wait.','',1,'2014-12-02 21:42:02'),(169,'Safety is a mission not an intermission','',1,'2014-12-02 21:42:02'),(170,'Safety doesn’t happen by accident','',1,'2014-12-02 21:42:02'),(171,'A spill, a slip, a hospital trip ','',1,'2014-12-02 21:42:02'),(172,'Falling objects can be brutal if you don’t protect your noodle','',1,'2014-12-02 21:42:02'),(173,'Safety glasses: All in favor say “Eye!”','',1,'2014-12-02 21:42:02'),(174,'It’s easier to ask a dumb question than it is to fix a dumb mistake','',1,'2014-12-02 21:42:02'),(175,'Safety isn’t a hobby, it’s a living.','',1,'2014-12-02 21:42:02'),(176,'Safety - A small investment for a rich future','',1,'2014-12-02 21:42:02'),(177,'Safety is no accident','',1,'2014-12-02 21:42:02'),(178,'Safety is a cheap and effective insurance policy','',1,'2014-12-02 21:42:02'),(179,'Let’s all keep our heads, and other body parts, together','',1,'2014-12-02 21:42:02'),(180,'While on a ladder, never step back to admire your work','',1,'2014-12-02 21:42:02'),(181,'Quench the thirst – safety first','',1,'2014-12-02 21:42:02'),(182,'When you gamble with safety you bet your life','',1,'2014-12-02 21:42:02'),(183,'The stupid shall be punished','',1,'2014-12-02 21:42:02'),(184,'Chance takers are accident makers','',1,'2014-12-02 21:42:02'),(185,'Safety is a full time job; don’t make it a part time practice','',1,'2014-12-02 21:42:02'),(186,'The door to Safety swings on the hinges of common sense','',1,'2014-12-02 21:42:02'),(187,'Is better to lose one minute in life… than to lose life in a minute.','',1,'2014-12-02 21:42:02'),(188,'Safety — a small investment for a rich future','',1,'2014-12-02 21:42:03'),(189,'Your first mistake could be your last','',1,'2014-12-02 21:42:03'),(190,'Safety isn’t expensive it’s priceless.','',1,'2014-12-02 21:42:03'),(191,'Safety is as simple as ABC…Always Be Careful','',1,'2014-12-02 21:42:03'),(192,'Unsafe acts will keep you in stitches','',1,'2014-12-02 21:42:03'),(193,'Knock out…accidents','',1,'2014-12-02 21:42:03'),(194,'If you mess up, ‘fess up','',1,'2014-12-02 21:42:03'),(195,'Hard hats, they’re not just for decoration','',1,'2014-12-02 21:42:03'),(196,'If you don’t think it will happen to you, find the person who had it happen to them','',1,'2014-12-02 21:42:03'),(197,'Keep safety in mind. It will save your behind.','',1,'2014-12-02 21:42:03'),(198,'One bad day at the grinder could ruin your whole life','',1,'2014-12-02 21:42:03'),(199,'Shortcuts cut life short','',1,'2014-12-02 21:42:03');
/*!40000 ALTER TABLE `user_safety_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_session_info`
--

DROP TABLE IF EXISTS `user_session_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_session_info` (
  `user_session_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `login_token` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `expire_date` datetime DEFAULT NULL,
  `is_expired` enum('0','1') NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_session_info_id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_session_info`
--

LOCK TABLES `user_session_info` WRITE;
/*!40000 ALTER TABLE `user_session_info` DISABLE KEYS */;
INSERT INTO `user_session_info` VALUES (1,1,'64d722c0-1a8a-4527-9582-4302707498b2','2015-01-09 13:33:17','9999-12-31 00:00:00','0'),(2,1,'61add699-c043-48f8-a1d8-5a39e6164402','2015-01-09 13:35:48','9999-12-31 00:00:00','0'),(3,1,'151628e8-66c9-489b-a37e-03dbd4d87254','2015-01-09 14:44:32','9999-12-31 00:00:00','0'),(4,1,'8cb22ae3-c54e-403d-bdf9-662d54d51e0a','2015-01-09 22:58:33','9999-12-31 00:00:00','0'),(5,1,'0c3f4cbd-a2ae-42f3-a5f6-416bdf9197df','2015-01-10 00:24:27','9999-12-31 00:00:00','0'),(6,1,'0ed8f226-3b75-420d-a2bf-a437dcdb2088','2015-01-10 00:29:14','9999-12-31 00:00:00','0'),(7,1,'ce786525-11a1-40ca-b390-0d48b97dc735','2015-01-10 09:06:48','9999-12-31 00:00:00','0'),(8,1,'4ece17fb-be7c-4dfb-8de7-61cd9ea572dc','2015-01-10 11:25:33','9999-12-31 00:00:00','0'),(9,1,'57521e8a-8cd9-4dd2-a24e-b8253a71537e','2015-01-10 13:02:05','9999-12-31 00:00:00','0'),(10,1,'fa3a6256-f649-413b-a150-266c9d4ab19d','2015-01-10 13:23:52','9999-12-31 00:00:00','0'),(11,1,'53baae60-27a0-4c8f-ab2d-2e8170626d62','2015-01-10 13:51:12','9999-12-31 00:00:00','0'),(12,1,'bb9983e0-e494-4772-a715-91aca7914b2f','2015-01-10 13:58:44','9999-12-31 00:00:00','0'),(13,1,'baa2f301-99df-4228-bc6a-b54ba4f8cd27','2015-01-10 14:00:35','9999-12-31 00:00:00','0'),(14,1,'bc59f671-87a8-4b04-a24a-2edbae19a971','2015-01-10 14:04:38','9999-12-31 00:00:00','0'),(15,1,'e49627db-5571-4fbc-a9ec-559335934be4','2015-01-10 14:51:42','9999-12-31 00:00:00','0'),(16,1,'17e181f6-deee-45df-9b53-8b59dc93d39f','2015-01-10 15:36:03','9999-12-31 00:00:00','0'),(17,1,'385a2090-ff3d-4125-bcf9-af67e2e68746','2015-01-10 15:38:16','9999-12-31 00:00:00','0'),(18,1,'43ddf594-18b3-4e1a-b201-974fd1446cb1','2015-01-10 17:46:02','9999-12-31 00:00:00','0'),(19,1,'ef5cbdfe-65d3-4287-9d74-4c5a97c14e5b','2015-01-11 02:13:13','9999-12-31 00:00:00','0'),(20,1,'1cf4e4e9-1c4d-4fa0-870b-418d23b72008','2015-01-11 04:54:22','9999-12-31 00:00:00','0'),(21,1,'16bc0046-6947-4b1b-923b-c919a7aecf1d','2015-01-11 09:38:22','9999-12-31 00:00:00','0'),(22,1,'f8f430b4-4c48-49bf-b03c-d84b471206ed','2015-01-11 09:38:25','9999-12-31 00:00:00','0'),(23,1,'985555b4-4f6e-42ac-9af7-e51a7ac14a9f','2015-01-11 10:04:39','9999-12-31 00:00:00','0'),(24,1,'37f58d3e-bc79-43db-b803-44a4fb48545b','2015-01-11 11:29:55','9999-12-31 00:00:00','0'),(25,1,'3ebea52a-9932-455d-ab4b-4578b08dc681','2015-01-11 11:34:56','9999-12-31 00:00:00','0'),(26,1,'989e086f-4d4d-43d7-8d70-a7cea68b93b1','2015-01-11 11:39:15','9999-12-31 00:00:00','0'),(27,1686452034,'7303c2c9-e878-42bc-906a-52fea185afd8','2015-01-11 11:39:20','9999-12-31 00:00:00','0'),(28,1686452034,'8aaea7f7-d66b-409d-a81e-09b916ca53ac','2015-01-11 11:39:26','9999-12-31 00:00:00','0'),(29,1686452034,'24554942-2e4e-432d-ac29-2c2d29e94edb','2015-01-11 11:39:29','9999-12-31 00:00:00','0'),(30,1686452034,'9f1a1d11-d514-46c1-b7c5-eab9b22a29ad','2015-01-11 11:39:30','9999-12-31 00:00:00','0'),(31,1,'2915e185-dff7-43b1-a53e-bc959cc39302','2015-01-11 11:57:51','9999-12-31 00:00:00','0'),(32,1,'c5f2740e-d1eb-444c-bcab-4b954f308018','2015-01-11 12:31:43','9999-12-31 00:00:00','0'),(33,1,'92349a1d-39df-4af4-a810-dc614e1d28b7','2015-01-11 13:13:04','9999-12-31 00:00:00','0'),(34,1,'32bb7de6-d8ae-4d0c-a9bb-57a282379690','2015-01-11 18:39:11','9999-12-31 00:00:00','0'),(35,1,'ff3f7907-41fe-45ed-af36-cdb4cc1dbfda','2015-01-11 19:23:32','9999-12-31 00:00:00','0'),(36,1,'ce76b35a-a7f3-433a-9244-c2d46b5c21fd','2015-01-11 19:25:56','9999-12-31 00:00:00','0'),(37,1,'bd36759d-7df2-46cc-bd80-0c70f4a3fa17','2015-01-11 19:28:26','9999-12-31 00:00:00','0'),(38,1,'8f9a1a20-52c3-4258-a890-4ab70570a2ca','2015-01-11 22:06:21','9999-12-31 00:00:00','0'),(39,1,'86ca8a65-34c1-4579-93b8-c2e67eff43ab','2015-01-11 22:07:20','9999-12-31 00:00:00','0'),(40,1,'53a065e5-ee46-4957-a686-b6b4e9205315','2015-01-11 23:09:13','9999-12-31 00:00:00','0'),(41,1,'52efa929-3854-47f1-9357-b16158cf04fd','2015-01-11 23:12:27','9999-12-31 00:00:00','0'),(42,1,'2dde24c3-d38d-4c31-aade-942103542ddf','2015-01-12 01:43:46','9999-12-31 00:00:00','0'),(43,1,'a40939aa-12a2-4058-8ff9-4f4cc75cde2e','2015-01-12 05:11:52','9999-12-31 00:00:00','0'),(44,1,'37954429-2cea-486e-bd1e-a9b38141654a','2015-01-12 09:10:29','9999-12-31 00:00:00','0'),(45,1,'02b01296-d348-4ec4-aee0-a0a7762f9aeb','2015-01-12 10:29:08','9999-12-31 00:00:00','0'),(46,1,'69817326-f7fa-4276-ad46-0c380bad54e3','2015-01-12 11:04:43','9999-12-31 00:00:00','0'),(47,1,'9392c105-87dd-4b3c-9ba7-36f04f285318','2015-01-12 11:17:21','9999-12-31 00:00:00','0'),(48,1,'308af9eb-de9b-476d-a417-959b30c16e2d','2015-01-12 12:47:49','9999-12-31 00:00:00','0'),(49,1,'4551e567-7587-449c-a016-14b25b37eeb7','2015-01-12 13:42:27','9999-12-31 00:00:00','0'),(50,1,'399903f7-74ba-464e-9c6e-aa54cfbe1b3f','2015-01-12 13:49:54','9999-12-31 00:00:00','0'),(51,1,'0143b48c-bf6e-41d5-bc6c-224d2daa65fa','2015-01-12 14:46:32','9999-12-31 00:00:00','0'),(52,1,'42d2e419-b460-4764-92f6-b49a3c0c491e','2015-01-12 20:57:23','9999-12-31 00:00:00','0'),(53,1,'c15f9cdb-0e8c-436f-b4c1-6d3f2ca558b9','2015-01-12 21:25:38','9999-12-31 00:00:00','0'),(54,1,'9771540b-9887-4c88-b3a0-d1c90032388a','2015-01-13 03:15:11','9999-12-31 00:00:00','0'),(55,1,'2da9e663-e4ef-425f-93b0-e405d918aaea','2015-01-13 10:12:25','9999-12-31 00:00:00','0'),(56,1,'95157dde-de4b-4097-b7c5-236634a09c36','2015-01-13 10:35:11','9999-12-31 00:00:00','0'),(57,1,'df5ca4b5-9f12-4bc5-aae3-7617d7df6795','2015-01-13 11:02:09','9999-12-31 00:00:00','0'),(58,1,'682ae19d-50c0-4725-a589-c8d0592096f2','2015-01-13 11:26:27','9999-12-31 00:00:00','0'),(59,1,'b4988129-54b6-4645-98cc-79ea6b790be6','2015-01-13 11:56:59','9999-12-31 00:00:00','0'),(60,1,'ba6658ae-3c5a-48aa-a9ff-7c2dc46a1fb8','2015-01-13 11:59:16','9999-12-31 00:00:00','0'),(61,1,'eb34a570-c9e1-4e40-a083-d2efc533857b','2015-01-13 12:05:29','9999-12-31 00:00:00','0'),(62,1,'dc5c5122-28ee-40e5-a665-ea93fd10ae81','2015-01-13 12:11:18','9999-12-31 00:00:00','0'),(63,1,'e138e423-b558-40aa-9d92-d0d6c3ffe990','2015-01-13 15:56:30','9999-12-31 00:00:00','0'),(64,1,'befe24dc-bc93-46d9-a30e-e6b011231469','2015-01-13 16:24:11','9999-12-31 00:00:00','0'),(65,1,'d505316f-753f-4552-9416-915502a6e131','2015-01-13 22:08:21','9999-12-31 00:00:00','0'),(66,1,'b729e53d-fcde-4910-a9cf-d34f2a95d4e1','2015-01-13 22:39:09','9999-12-31 00:00:00','0'),(67,1,'3a80df93-f7af-43f9-8807-1f194e257975','2015-01-13 22:54:12','9999-12-31 00:00:00','0'),(68,70246881,'2210ef10-1fd5-43f1-aca5-8cfd5660756c','2015-01-14 22:08:54','9999-12-31 00:00:00','0'),(69,70246881,'3dfd039f-9b2e-47f2-956a-7551a95a6629','2015-01-14 22:08:59','9999-12-31 00:00:00','0'),(70,1,'592458fd-e904-4ff1-9511-0d137a3da880','2015-01-14 22:39:57','9999-12-31 00:00:00','0'),(78,1,'629f8ede-bcd1-40d4-a9ac-eca3855ebf8c','2015-01-15 21:55:09','9999-12-31 00:00:00','0'),(79,1011406604,'cb24af11-86c1-445e-ab20-b17e5c7178f7','2015-01-15 21:56:08','9999-12-31 00:00:00','0'),(80,1011406604,'ff3610e4-0bb5-49a6-bb79-54b03aadd020','2015-01-15 22:46:48','9999-12-31 00:00:00','0'),(81,1011406604,'c606f319-2184-46e3-9768-e8423f232d3c','2015-01-15 22:54:29','9999-12-31 00:00:00','0'),(82,1,'666be1f8-1d54-4cd1-ac5d-b53eceaa7410','2015-01-15 22:57:18','9999-12-31 00:00:00','0'),(83,1011406604,'d8316994-69e3-4227-8810-b9e48020c994','2015-01-15 22:58:01','9999-12-31 00:00:00','0'),(84,1,'55415441-09d9-41ab-82b5-a042904e06e0','2015-01-16 03:06:13','9999-12-31 00:00:00','0'),(85,1,'d5449850-83ba-49a2-bc21-1586fd0858ba','2015-01-16 04:15:28','9999-12-31 00:00:00','0'),(86,1,'1a36accc-ce27-4926-8f0d-47b49c1da4a3','2015-01-16 04:29:55','9999-12-31 00:00:00','0'),(87,1,'92dcc28a-c56a-40e6-914f-b791184f883b','2015-01-16 05:37:21','9999-12-31 00:00:00','0'),(88,1,'5760c577-4a69-4cc4-8569-a62fde87162e','2015-01-16 08:58:17','9999-12-31 00:00:00','0'),(89,1,'55030dc1-e946-42d4-a0ba-4b7b7d148565','2015-01-16 21:50:36','9999-12-31 00:00:00','0'),(90,1011406604,'d8a826e6-5f7c-437c-9a03-123322076279','2015-01-16 21:59:16','9999-12-31 00:00:00','0'),(91,1,'2639e5bc-18e3-4340-8db7-0a72b1a3db9a','2015-01-16 22:58:28','9999-12-31 00:00:00','0'),(92,1,'57bcc1bf-7034-4ab5-bef0-86119b3e3954','2015-01-16 23:52:26','9999-12-31 00:00:00','0'),(93,1,'3d223390-2fa0-49bd-844f-8235b9294af1','2015-01-17 00:19:46','9999-12-31 00:00:00','0'),(94,1,'66d26cda-8332-4475-93d5-7e2c0f3ba210','2015-01-17 01:19:14','9999-12-31 00:00:00','0'),(95,1,'b29ce6b1-eac5-4974-bc8a-0db072fe1e96','2015-01-17 02:42:43','9999-12-31 00:00:00','0'),(96,1,'557ebaff-4724-4c8e-a5dd-8358c0affdc4','2015-01-17 02:42:43','9999-12-31 00:00:00','0'),(97,1,'5dc61352-d948-4a70-9748-5029c3a1af76','2015-01-17 04:47:56','9999-12-31 00:00:00','0'),(98,1,'b4bcb78d-a295-424f-8ade-2c8ee698118e','2015-01-17 12:49:43','9999-12-31 00:00:00','0'),(99,1,'9c2f0476-cb5d-4a5b-8df6-a47795004a1a','2015-01-17 14:41:07','9999-12-31 00:00:00','0'),(100,1,'b5cc37ca-fdd5-4b5a-8c27-884804acbb2b','2015-01-17 23:14:07','9999-12-31 00:00:00','0'),(101,1,'74502f5c-e597-40b0-abba-534f96fe1cb5','2015-01-17 23:14:41','9999-12-31 00:00:00','0'),(102,1,'d8560451-5376-49f6-afc7-828808d6ffe3','2015-01-17 23:41:08','9999-12-31 00:00:00','0'),(103,1,'69e926ee-2ea1-4cda-b85c-bdc74af40a0b','2015-01-17 23:45:55','9999-12-31 00:00:00','0'),(104,1,'1046e91b-c505-45fe-b380-cdd0f44777ed','2015-01-18 00:59:06','9999-12-31 00:00:00','0'),(105,1,'c83eb1d8-6aaa-40c9-84fc-ab3868a0d0cc','2015-01-18 03:36:36','9999-12-31 00:00:00','0'),(106,1,'e1b6b922-3c00-4b56-8f0e-4350ec5e6d5d','2015-01-18 10:26:31','9999-12-31 00:00:00','0'),(107,1,'8d358ba9-0583-45a9-a2c7-ca23f6d19d56','2015-01-18 10:45:11','9999-12-31 00:00:00','0'),(108,1,'2d2f3d9a-5657-422b-9efc-0a8928cafb8d','2015-01-18 10:45:28','9999-12-31 00:00:00','0'),(109,1,'faad0ac7-ab2d-4976-a759-eb99bfed073c','2015-01-18 11:03:16','9999-12-31 00:00:00','0'),(110,1,'2110cfc1-1b35-4f39-afdc-cf2009f9be34','2015-01-18 17:23:29','9999-12-31 00:00:00','0'),(111,1,'89bc9e32-ed6e-40b2-ab4b-0b52dcd6c203','2015-01-18 23:14:11','9999-12-31 00:00:00','0'),(112,1,'df0a33ab-aa42-4ef2-addf-23be8e6e5e11','2015-01-18 23:21:55','9999-12-31 00:00:00','0'),(113,1,'5807637d-d38c-4026-bb8b-391c7dd10860','2015-01-19 00:50:11','9999-12-31 00:00:00','0'),(114,1,'53efefae-70ef-48cc-9117-5aa8c226d7ea','2015-01-19 06:11:53','9999-12-31 00:00:00','0'),(115,1,'aa1124c8-c99c-4be0-b38d-1536f73cd358','2015-01-19 06:37:14','9999-12-31 00:00:00','0'),(116,1,'f2161151-3327-43e7-b574-21c73752b757','2015-01-19 07:51:16','9999-12-31 00:00:00','0'),(117,1,'5a1d4abc-b5b1-496d-a6eb-62d2f94045a2','2015-01-19 07:59:17','9999-12-31 00:00:00','0'),(118,1,'351d6a1f-cc74-48da-b566-caf729c0fc3b','2015-01-19 08:18:07','9999-12-31 00:00:00','0'),(119,1,'68754d68-0bc1-4f48-9035-4eff4dbb7b84','2015-01-19 08:27:31','9999-12-31 00:00:00','0'),(120,1,'cff935b3-421d-48e3-bf92-b5938d6e85da','2015-01-19 08:31:23','9999-12-31 00:00:00','0'),(121,1,'824f133d-514d-42fe-bbd9-68a155f05e49','2015-01-19 08:41:27','9999-12-31 00:00:00','0'),(122,1,'1129273e-0031-4d5d-a285-fcc5c75c5d5e','2015-01-19 08:50:12','9999-12-31 00:00:00','0'),(123,1,'e09cd82a-f47e-4933-aa5a-345e61544942','2015-01-19 09:50:35','9999-12-31 00:00:00','0'),(124,1,'4a70e340-ec77-4928-aa72-6a5431c656cb','2015-01-19 10:10:01','9999-12-31 00:00:00','0'),(125,1,'fbb0ed58-9d61-4036-b979-64d84cd791e2','2015-01-19 10:10:05','9999-12-31 00:00:00','0'),(126,1,'97189d51-79ea-4577-b69f-5bc1da702d0d','2015-01-19 11:32:01','9999-12-31 00:00:00','0'),(127,1,'497a3868-8b4a-4afe-ab8d-8b0ee6633b3e','2015-01-19 11:34:10','9999-12-31 00:00:00','0'),(128,1,'6fee67f2-c44e-4dd8-a05a-7dd89aaa77ed','2015-01-19 13:02:24','9999-12-31 00:00:00','0'),(129,1011406604,'3ab73dac-dfb9-4525-83fc-4e0930acbcf8','2015-01-19 14:32:44','9999-12-31 00:00:00','0'),(130,1,'969b245f-1eda-4028-bd6a-e5e33e30401b','2015-01-20 09:28:36','9999-12-31 00:00:00','0'),(131,1,'bf9fa71b-c3e1-4e53-a597-d5ee259ba06d','2015-01-20 22:04:34','9999-12-31 00:00:00','0'),(132,1,'49723c6f-be21-4c6f-ad3e-c8654cba5899','2015-01-21 01:22:37','9999-12-31 00:00:00','0');
/*!40000 ALTER TABLE `user_session_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_type` (
  `user_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` varchar(100) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `modified_date` datetime NOT NULL,
  `modified_by` varchar(20) NOT NULL,
  `is_expired` enum('0','1') NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_type`
--

LOCK TABLES `user_type` WRITE;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
INSERT INTO `user_type` VALUES (1,'USER','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM','0');
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-21  2:22:11
