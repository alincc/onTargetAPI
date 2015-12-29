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
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_DASHBOARD','View Dashboard');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ADD_PROJECT','Add Project');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','EDIT_PROJECT','Edit Project');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_PROJECT','View Project');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','DELETE_PROJECT','Delete Project');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ADD_ACTIVITY','Add Activity');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','EDIT_ACTIVITY','Edit Activity');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_ACTIVITY','View Activity');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','DELETE_ACTIVITY','Delete Activity');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ADD_TASK','Add Task');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','EDIT_TASK','Edit Task');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_TASK','View Task');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','DELETE_TASK','Delete Task');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ADD_TASK_COMMENT','Add Task Comment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','EDIT_TASK_COMMENT','Edit Task Comment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_TASK_COMMENT','View Task Comment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','DELETE_TASK_COMMENT','Delete Task Comment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ADD_TASK_ATTACHMENT','Add Task Attachment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','EDIT_TASK_ATTACHMENT','Edit Task Attachment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_TASK_ATTACHMENT','View Task Attachment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','DELETE_TASK_ATTACHMENT','Delete Task Attachment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ADD_TASK_PERCENTAGE','Add Task Percentage');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','EDIT_TASK_PERCENTAGE','Edit Task Percentage');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_TASK_PERCENTAGE','View Task Percentage');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','DELETE_TASK_PERCENTAGE','Delete Task Percentage');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','IMPORT_ACTIVITY','Import Activity');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ADD_TASK_BUDGET','Add Task Budget');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','EDIT_TASK_BUDGET','Edit Task Budget');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_TASK_BUDGET','View Task Budget');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','DELETE_TASK_BUDGET','Delete Task Budget');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ADD_TASK_MEMBER','Add Task Member');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_TASK_MEMBER','View Task Member');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','REMOVE_TASK_MEMBER','Remove Task Member');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','INVITE_TO_COLLABORATE','Invite To Collaborate');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_GANTT_CHART','View Gantt Chart');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','SEARCH','Search');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_VIEW','OnSite View');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_UPLOAD','OnSite Upload');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_DELETE','OnSite Delete');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_ADD_COMMENT','OnSIte Add Comment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_EDIT_COMMENT','OnSite Edit Comment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_DELETE_COMMENT','OnSite Delete Comment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_VIEW_COMMENT','OnSite View Comment');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_CONTACT','View Contact');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_ADD','OnFile Add');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_VIEW','OnFile View');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_APPROVE','OnFile Approve');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_REJECT','OnFIle Reject');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','VIEW_NOTIFICATION','View Notificaiton');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','MARK_NOTIFICATION_SEEN','Mark Notificaiton Seen');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_UPDATE','OnFile UPDATE');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_DOCUMENT_ATTACHMENT_UPLOAD','OnFile Attachment UPLOAD');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_MARKUP_TAG_ADD','OnSite markup tag add');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_MARKUP_TAG_UPDATE','OnSite markup tag delete');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_MARKUP_TAG_ADD_COMMENT','OnSite markup tag comment add');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_MARKUP_TAG_UPDATE_COMMENT','OnSite markup tag comment update');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_MARKUP_TAG_DELETE_COMMENT','OnSite markup tag comment delete');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONBIM_ADD','onBim Add');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONBIM_UPLOAD','onBim upload');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONBIM_UPDATE','onBim update');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONBIM_DELETE','OnFile delete');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONBIM_VIEW','onBim View');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_DOCUMENT_ATTACHMENT_VIEW','OnFile Attachment view');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_DOCUMENT_ATTACHMENT_DELETE','OnFile Attachment delete');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_MARKUP_TAG_VIEW_COMMENT','View markup tag comments');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONSITE_MARKUP_TAG_VIEW','VIEW MARKUP TAGS');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONBIM_THUMBNAIL_UPDATE','onBim thumbnail update');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONBIM_COMMENT_SAVE','onBim comment save');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONBIM_COMMENT_UPDATE','onBim comment update');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONBIM_COMMENT_DELETE','onBim comment delete');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONBIM_COMMENT_VIEW','onBim comment VIEW');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_DOCUMENT_RESPONSE_SAVE','onfile document response save');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_DOCUMENT_RESPONSE_UPDATE','onfile document response update');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_DOCUMENT_RESPONSE_DELETE','onfile document response delete');
insert into `application_feature` ( `active`, `feature_key`, `feature_name`) values('Y','ONFILE_DOCUMENT_RESPONSE_VIEW','onfile document response VIEW');










