/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `feature_request_mapper` (
	`feature_request_mapper_id` int (11),
	`has_feature` char (3),
	`request_path` varchar (135),
	`application_feature_id` int (11)
); 
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('1','Y','/task/getTaskDetail','2');
