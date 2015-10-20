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
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('40','Y','/document','45');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('41','Y','/document/getUserDocument','46');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('42','Y','/document/getDocument','46');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('43','Y','/document/status','47');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('44','Y','/document/status','48');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('45','Y','/task/getTaskCountsOfProject','1');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('46','Y','/project/getUserProjectList','1');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('47','Y','/task/getProjectTaskByMainProject','12');

insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('48','Y','/notification/getNotificationsByUserByProject','49');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('49','Y','/notification/markAllAsSeen','50');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('50','Y','/notification/markAsSeen','50');

insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('51','Y','/upload/getDocumentById','37');


/*
phase 2
 */


insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('52','Y','/document','51');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('53','Y','/document/attachment/save','52');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('54','Y','/project/file/tag/save','53');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('55','Y','/project/file/tag/update','54');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('56','Y','/project/file/tag/comment/add','55');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('57','Y','/project/file/tag/comment/add','56');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('58','Y','/project/file/tag/comment/delete','57');

insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('59','Y','/bim/save','58');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('60','Y','/bim/save','59');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('61','Y','/bim/save','60');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('62','Y','/bim/delete','61');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('63','Y','/bim/getAll','62');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('64','Y','/document/attachment/getAll','63');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('65','Y','/document/attachment/delete','64');


insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('66','Y','/project/file/tag/comment/list','65');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('67','Y','/project/file/tag/get','66');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('68','Y','/bim/updateThumbnailPath','67');


insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('69','Y','/bim/comment/save','68');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('70','Y','/bim/comment/save','69');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('71','Y','/bim/comment/delete','70');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('72','Y','/bim/comment/list','71');


insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('73','Y','/document/response/save','72');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('74','Y','/document/response/update','73');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('75','Y','/document/response/delete','74');
insert into `feature_request_mapper` (`feature_request_mapper_id`, `has_feature`, `request_path`, `application_feature_id`) values('76','Y','/document/response','75');

