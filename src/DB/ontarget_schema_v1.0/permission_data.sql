/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

/* profile table data */

insert into `profile` (`profile_id`, `active`, `added_date`, `modified_date`, `name`, `profile_type`, `added_by`, `modified_by`, `description`, `profile_code`) values('1','Y','2015-08-23 17:27:48',NULL,'Super User','MENU','1',NULL,'Super User menu profile','SU');
insert into `profile` (`profile_id`, `active`, `added_date`, `modified_date`, `name`, `profile_type`, `added_by`, `modified_by`, `description`, `profile_code`) values('2','Y','2015-08-23 17:28:09',NULL,'Project Manager','MENU','1',NULL,'Project Manager Profile','PM');
insert into `profile` (`profile_id`, `active`, `added_date`, `modified_date`, `name`, `profile_type`, `added_by`, `modified_by`, `description`, `profile_code`) values('3','Y','2015-08-23 17:28:27',NULL,'Regular User','MENU','1',NULL,'Regular User','RU');
insert into `profile` (`profile_id`, `active`, `added_date`, `modified_date`, `name`, `profile_type`, `added_by`, `modified_by`, `description`, `profile_code`) values('4','Y','2015-08-23 17:28:46',NULL,'Super User','PERMISSION','1',NULL,'Super User permission profile','SU');
insert into `profile` (`profile_id`, `active`, `added_date`, `modified_date`, `name`, `profile_type`, `added_by`, `modified_by`, `description`, `profile_code`) values('5','Y','2015-08-23 17:29:07',NULL,'Project Manager','PERMISSION','1',NULL,'Project Manager permission profile','PM');
insert into `profile` (`profile_id`, `active`, `added_date`, `modified_date`, `name`, `profile_type`, `added_by`, `modified_by`, `description`, `profile_code`) values('6','Y','2015-08-23 17:29:31',NULL,'Regular User','PERMISSION','1',NULL,'Regular User permission profile','RU');


/* permission data */

insert into `application_permission` (`application_permission_id`, `active`, `permission_key`, `permission_name`) values('1','Y','VIEW_DASHBOARD','View Dashboard');
insert into `application_permission` (`application_permission_id`, `active`, `permission_key`, `permission_name`) values('2','Y','VIEW_ONTIME','View OnTime');
insert into `application_permission` (`application_permission_id`, `active`, `permission_key`, `permission_name`) values('3','Y','EDIT_ONTIME','Edit OnTime');
insert into `application_permission` (`application_permission_id`, `active`, `permission_key`, `permission_name`) values('4','Y','ADD_TASK_COMMENT','Add Task Comment');
insert into `application_permission` (`application_permission_id`, `active`, `permission_key`, `permission_name`) values('5','Y','VIEW_ONSITE','View OnSite');
insert into `application_permission` (`application_permission_id`, `active`, `permission_key`, `permission_name`) values('6','Y','ONSITE_UPLOAD','OnSite Upload');
insert into `application_permission` (`application_permission_id`, `active`, `permission_key`, `permission_name`) values('7','Y','ONFILE_FULL_ACCESS','OnFile Full Access');


/* profile permission map data */

insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('1','Y','1','4');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('2','Y','2','4');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('3','Y','3','4');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('4','Y','4','4');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('5','Y','5','4');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('6','Y','6','4');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('7','Y','7','4');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('8','Y','1','5');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('9','Y','2','5');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('10','Y','3','5');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('11','Y','4','5');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('12','Y','5','5');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('13','Y','6','5');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('14','Y','7','5');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('15','Y','1','6');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('16','Y','4','6');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('17','Y','5','6');
insert into `profile_permission` (`profile_permission_id`, `active`, `application_permission_id`, `profile_id`) values('18','Y','7','6');


/* request path permission mapping */

insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('2','Y','/project/getProject','1');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('3','Y','/report/earnedValueReport','1');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('4','Y','/report/bireport','1');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('5','Y','task/getProjectTaskByMainProject','1');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('6','Y','/task/getTaskCountsOfProject','1');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('7','Y','/documents/getUserDocument','1');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('8','Y','/activityLog/getLog','1');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('9','Y','/project/getActivityOfProject','2');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('10','Y','/task/getProjectTaskByActivity','2');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('11','Y','/project/addActivity','3');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('12','Y','/task/getTaskDetail','2');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('13','Y','/task/addTask','3');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('14','Y','/task/assignUserToTask','3');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('15','Y','/task/addComment','4');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('16','Y','/task/budget/getTaskBudgetByTaskId','2');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('17','Y','/task/budget/add','4');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('18','Y','/task/percentage/add','4');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('19','Y','/task/getTaskAttachments','2');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('20','Y','/task/saveTaskFile','4');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('21','Y','/task/deleteTask','4');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('22','Y','/upload','5');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('24','Y','/upload/projectFileCommentList','5');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('25','Y','/upload/addComment','6');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('26','Y','/upload/saveUploadedDocsInfo','6');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('27','Y','/upload/delete','6');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('28','Y','/upload/deleteComment','6');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('29','Y','/accidentreports','7');
insert into `permission_mapped_request` (`permission_mapped_request_id`, `has_permission`, `request_path`, `application_permission_id`) values('30','Y','/accidentreports/getAccidentReportsOfProject','7');
