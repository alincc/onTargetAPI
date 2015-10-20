/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `application_feature` (
	`application_feature_id` int (11),
	`active` char (9),
	`feature_key` varchar (405),
	`feature_name` varchar (405)
); 
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('1','Y','VIEW_DASHBOARD','View Dashboard');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('2','Y','ADD_PROJECT','Add Project');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('3','Y','EDIT_PROJECT','Edit Project');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('4','Y','VIEW_PROJECT','View Project');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('5','Y','DELETE_PROJECT','Delete Project');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('6','Y','ADD_ACTIVITY','Add Activity');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('7','Y','EDIT_ACTIVITY','Edit Activity');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('8','Y','VIEW_ACTIVITY','View Activity');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('9','Y','DELETE_ACTIVITY','Delete Activity');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('10','Y','ADD_TASK','Add Task');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('11','Y','EDIT_TASK','Edit Task');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('12','Y','VIEW_TASK','View Task');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('13','Y','DELETE_TASK','Delete Task');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('14','Y','ADD_TASK_COMMENT','Add Task Comment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('15','Y','EDIT_TASK_COMMENT','Edit Task Comment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('16','Y','VIEW_TASK_COMMENT','View Task Comment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('17','Y','DELETE_TASK_COMMENT','Delete Task Comment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('18','Y','ADD_TASK_ATTACHMENT','Add Task Attachment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('19','Y','EDIT_TASK_ATTACHMENT','Edit Task Attachment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('20','Y','VIEW_TASK_ATTACHMENT','View Task Attachment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('21','Y','DELETE_TASK_ATTACHMENT','Delete Task Attachment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('22','Y','ADD_TASK_PERCENTAGE','Add Task Percentage');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('23','Y','EDIT_TASK_PERCENTAGE','Edit Task Percentage');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('24','Y','VIEW_TASK_PERCENTAGE','View Task Percentage');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('25','Y','DELETE_TASK_PERCENTAGE','Delete Task Percentage');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('26','Y','IMPORT_ACTIVITY','Import Activity');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('27','Y','ADD_TASK_BUDGET','Add Task Budget');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('28','Y','EDIT_TASK_BUDGET','Edit Task Budget');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('29','Y','VIEW_TASK_BUDGET','View Task Budget');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('30','Y','DELETE_TASK_BUDGET','Delete Task Budget');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('31','Y','ADD_TASK_MEMBER','Add Task Member');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('32','Y','VIEW_TASK_MEMBER','View Task Member');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('33','Y','REMOVE_TASK_MEMBER','Remove Task Member');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('34','Y','INVITE_TO_COLLABORATE','Invite To Collaborate');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('35','Y','VIEW_GANTT_CHART','View Gantt Chart');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('36','Y','SEARCH','Search');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('37','Y','ONSITE_VIEW','OnSite View');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('38','Y','ONSITE_UPLOAD','OnSite Upload');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('39','Y','ONSITE_DELETE','OnSite Delete');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('40','Y','ONSITE_ADD_COMMENT','OnSIte Add Comment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('41','Y','ONSITE_EDIT_COMMENT','OnSite Edit Comment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('42','Y','ONSITE_DELETE_COMMENT','OnSite Delete Comment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('43','Y','ONSITE_VIEW_COMMENT','OnSite View Comment');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('44','Y','VIEW_CONTACT','View Contact');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('45','Y','ONFILE_ADD','OnFile Add');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('46','Y','ONFILE_VIEW','OnFile View');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('47','Y','ONFILE_APPROVE','OnFile Approve');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('48','Y','ONFILE_REJECT','OnFIle Reject');

insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('49','Y','VIEW_NOTIFICATION','View Notificaiton');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('50','Y','MARK_NOTIFICATION_SEEN','Mark Notificaiton Seen');

/*
New changes for phase 2.
 */

insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('51','Y','ONFILE_UPDATE','OnFile UPDATE');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('52','Y','ONFILE_ATTACHMENT','OnFile Attachment');

insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('53','Y','ONSITE_MARKUP_TAG_ADD','OnSite Upload');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('54','Y','ONSITE_MARKUP_TAG_UPDATE','OnSite Upload');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('55','Y','ONSITE_MARKUP_TAG_ADD_COMMENT','OnSite Upload');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('56','Y','ONSITE_MARKUP_TAG_UPDATE_COMMENT','OnSite Upload');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('57','Y','ONSITE_MARKUP_TAG_DELETE_COMMENT','OnSite Upload');


insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('58','Y','ONBIM_ADD','onBim Add');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('59','Y','ONBIM_UPLOAD','onBim upload');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('60','Y','ONBIM_UPDATE','onBim update');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('61','Y','ONBIM_DELETE','OnFile delete');
insert into `application_feature` (`application_feature_id`, `active`, `feature_key`, `feature_name`) values('62','Y','ONBIM_VIEW','onBim View');

