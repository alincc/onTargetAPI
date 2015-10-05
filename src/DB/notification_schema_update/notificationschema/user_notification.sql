/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user_notification` (
	`user_notification_id` bigint (20),
	`last_seen_at` datetime ,
	`status` varchar (12),
	`notification_id` bigint (20),
	`user_id` int (11)
); 
