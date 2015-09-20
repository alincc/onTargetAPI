/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user_profile` (
	`user_profile_id` int (11),
	`profile_id` int (11),
	`user_id` int (11)
); 
insert into `user_profile` (`user_profile_id`, `profile_id`, `user_id`) values('2','1','10');
