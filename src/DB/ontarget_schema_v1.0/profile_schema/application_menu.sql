/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `application_menu` (
	`application_menu_id` int (11),
	`active` char (9),
	`menu_key` varchar (405),
	`menu_name` varchar (405)
); 
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('1','Y','DASHBOARD','Dashboard');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('2','Y','ONTIME','onTime');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('3','Y','ONSITE','onSite');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('4','Y','ONFILE','onFile');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('5','Y','ONCONTACT','onContact');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('6','Y','ONBIM','onBim');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('7','Y','ONTARGET','onTarget');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('8','Y','ONREPORT','onReport');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('9','Y','INVITETOCOLLABORATE','inviteToCollaborate');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('10','Y','SEARCH','search');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('11','Y','GANTTCHART','ganttChart');
insert into `application_menu` (`application_menu_id`, `active`, `menu_key`, `menu_name`) values('12','Y','NOTIFICATION','notification');
