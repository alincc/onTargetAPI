CREATE DATABASE  IF NOT EXISTS `ontarget` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ontarget`;
-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ontarget
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.14.04.1

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
-- Table structure for table `activity_log`
--

DROP TABLE IF EXISTS `activity_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_log` (
  `activity_log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_type` varchar(20) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `ts_insert` datetime NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `action` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`activity_log_id`),
  KEY `FK_csf0njobhrvcaaryhn9ya8vje` (`user_id`),
  CONSTRAINT `FK_csf0njobhrvcaaryhn9ya8vje` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notification_attribute`
--


--
-- Table structure for table `activity_log_attribute`
--

DROP TABLE IF EXISTS `activity_log_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_log_attribute` (
  `activity_log_attribute_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_key` varchar(20) NOT NULL,
  `attribute_value` varchar(20) NOT NULL,
  `activity_log_id` bigint(20) NOT NULL,
  PRIMARY KEY (`activity_log_attribute_id`),
  KEY `FK_j7vs8186p7geqilm8ru3g16d4` (`activity_log_id`),
  CONSTRAINT `FK_j7vs8186p7geqilm8ru3g16d4` FOREIGN KEY (`activity_log_id`) REFERENCES `activity_log` (`activity_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `notification_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action` varchar(10) NOT NULL,
  `notification_type` varchar(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `ts_insert` datetime NOT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `notification_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification_attribute` (
  `notification_attribute_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_key` varchar(20) NOT NULL,
  `attribute_value` varchar(20) NOT NULL,
  `notification_id` bigint(20) NOT NULL,
  PRIMARY KEY (`notification_attribute_id`),
  KEY `FK_gqhka1an8f0rlr5lkdo60cy0e` (`notification_id`),
  CONSTRAINT `FK_gqhka1an8f0rlr5lkdo60cy0e` FOREIGN KEY (`notification_id`) REFERENCES `notification` (`notification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user_notification`
--

DROP TABLE IF EXISTS `user_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_notification` (
  `user_notification_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `last_seen_at` datetime DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `notification_id` bigint(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_notification_id`),
  KEY `FK_57br8073hgsj70sww9gwv88to` (`notification_id`),
  KEY `FK_hrv2lmyjlt3ken6hk2f4sg1e` (`user_id`),
  CONSTRAINT `FK_57br8073hgsj70sww9gwv88to` FOREIGN KEY (`notification_id`) REFERENCES `notification` (`notification_id`),
  CONSTRAINT `FK_hrv2lmyjlt3ken6hk2f4sg1e` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-06 19:40:56
