/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `feature_request_mapper` (
	`feature_request_mapper_id` int (11),
	`has_feature` char (9),
	`request_path` varchar (405),
	`application_feature_id` int (11)
); 
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('1','Y','/report/earnedValueReport','1');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('2','Y','/report/bireport','1');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('3','Y','/activityLog/getLog','1');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('4','Y','/project/addProject','2');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('5','Y','/project/addProject','3');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('6','Y','/project/getUserProjectList','4');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('7','Y','/project/getProject','4');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('8','Y','/project/deleteProject','5');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('9','Y','/project/addActivity','6');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('10','Y','/project/addActivity','7');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('11','Y','/project/getActivityOfProject','8');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('12','Y','/project/getProject','8');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('13','Y','/project/deleteProject','9');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('14','Y','/task/addTask','10');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('15','Y','/task/addTask','11');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('16','Y','/task/getProjectTaskByActivity','12');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('17','Y','/task/getTaskDetail','12');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('18','Y','/task/deleteTask','13');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('19','Y','/task/addComment','14');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('20','Y','/task/saveTaskFile','18');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('21','Y','/task/getTaskAttachments','20');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('22','Y','/task/deleteTaskAttachment','21');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('23','Y','/task/percentage/add','22');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('24','Y','/task/percentage/update','23');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('25','Y','/task/budget/add','27');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('26','Y','/task/budget/add','28');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('27','Y','/task/budget/getTaskBudgetByTaskId','29');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('28','Y','/task/assignUserToTask','31');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('29','Y','/register/inviteUserIntoProject','34');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('30','Y','/upload','37');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('31','Y','/upload/projectFileCategoryList','37');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('32','Y','/upload/saveUploadedDocsInfo','38');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('33','Y','/upload/delete','39');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('34','Y','/upload/addComment','40');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('35','Y','/upload/addComment','41');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('36','Y','/upload/deleteComment','42');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('37','Y','/upload/projectFileCommentList','43');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('38','Y','/uploadActivity','26');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('39','Y','/project/getProjectMembers','44');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('40','Y','/documents','45');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('41','Y','/documents/getUserDocument','46');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('42','Y','/documents/getDocument','46');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('43','Y','/documents/approve','47');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('44','Y','/documents/approve','48');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('45','Y','/task/getTaskCountsOfProject','1');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('46','Y','/project/getUserProjectList','1');
