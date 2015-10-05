/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `notification_attribute` (
	`notification_attribute_id` bigint (20),
	`attribute_key` varchar (60),
	`attribute_value` varchar (60),
	`notification_id` bigint (20)
); 
