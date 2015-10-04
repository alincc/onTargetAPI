/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `notification` (
	`notification_id` bigint (20),
	`action` varchar (30),
	`notification_type` varchar (60),
	`project_id` bigint (20),
	`ts_insert` datetime 
); 
