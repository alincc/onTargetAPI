/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `application_menu` (
	`application_menu_id` int (11),
	`active` char (3),
	`menu_key` varchar (135),
	`menu_name` varchar (135)
); 
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('1','Y','DASHBOARD','Dashboard');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('2','Y','ONTIME','onTime');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('3','Y','ONSITE','onSITE');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('4','Y','ONFILE','onFILE');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('5','Y','ONTARGET','onTARGET');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('6','Y','ONCONTACT','onCONTACT');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('7','Y','ONREPORT','onREPORT');
