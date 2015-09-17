/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `profile_feature` (
	`profile_feature_id` int (11),
	`active` char (3),
	`application_feature_id` int (11),
	`profile_id` int (11)
); 
insert into `profile_feature` (`profile_feature_id`, `active`, `application_feature_id`, `profile_id`) values('1','Y','1','1');
insert into `profile_feature` (`profile_feature_id`, `active`, `application_feature_id`, `profile_id`) values('2','N','2','1');
insert into `profile_feature` (`profile_feature_id`, `active`, `application_feature_id`, `profile_id`) values('3','Y','1','2');
insert into `profile_feature` (`profile_feature_id`, `active`, `application_feature_id`, `profile_id`) values('4','Y','2','2');
insert into `profile_feature` (`profile_feature_id`, `active`, `application_feature_id`, `profile_id`) values('5','Y','1','3');
insert into `profile_feature` (`profile_feature_id`, `active`, `application_feature_id`, `profile_id`) values('6','Y','2','3');
