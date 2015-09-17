/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `application_feature` (
	`application_feature_id` int (11),
	`active` char (3),
	`feature_key` varchar (135),
	`feature_name` varchar (135)
); 
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('1','Y','VIEW_DASHBOARD','View Dashboard');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('2','Y','VIEW_ONTIME','View OnTime');
