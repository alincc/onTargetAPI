/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `project_file_tag` (
	`project_file_tag_id` bigint (20),
	`file_id` int (11),
	`tag_title` varchar (150),
	`lattitude` float ,
	`longitude` float ,
	`parent_file_tag_id` bigint (20),
	`created_by` int (11),
	`created_date` datetime ,
	`modified_by` int (11),
	`modified_date` datetime ,
	`status` varchar (30),
	`tag_type` varchar (60),
	`version_no` int (11),
	`tag_file_path` varchar (600)
); 
