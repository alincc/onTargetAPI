/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.41-0ubuntu0.14.04.1 : Database - ontarget
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ontarget` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ontarget`;

/* Trigger structure for table `dependent_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_dependentTask_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_dependentTask_add` AFTER INSERT ON `dependent_task` FOR EACH ROW BEGIN
	
	DECLARE userNotificationId BIGINT;
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("Task ",`getProjectTaskTitleById`(NEW.dependent_task_id)," is made dependent on task",
	`getProjectTaskTitleById`(NEW.task_id)),
	NEW.created_by,11, NOW());	
	
	INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert) 
	VALUES (CONCAT("Task ",`getProjectTaskTitleById`(NEW.dependent_task_id)," is made dependent on task",
	`getProjectTaskTitleById`(NEW.task_id)), "NEW",
	NEW.created_by, NOW());
 
	SET userNotificationId = LAST_INSERT_ID();
 
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','DEPENDENT_TASK',userNotificationId);
	
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.id,userNotificationId);
END */$$


DELIMITER ;

/* Trigger structure for table `planned_actuals_cost` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_plannedActualCost_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_plannedActualCost_add` AFTER INSERT ON `planned_actuals_cost` FOR EACH ROW BEGIN
    
	DECLARE userNotificationId BIGINT;
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("New planned cost added for task ",`getProjectTaskTitleById`(NEW.task_id)),
	New.created_by,6, NOW());	
	
	INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert) 
	VALUES (CONCAT("New planned cost added for task ", getProjectTaskTitleById(NEW.task_id)),
	 "NEW",NEW.created_by, NOW());
 
	SET userNotificationId = LAST_INSERT_ID();
 
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','COST',userNotificationId);
	
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.id,userNotificationId);
END */$$


DELIMITER ;

/* Trigger structure for table `planned_actuals_cost` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_plannedActualCost_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_plannedActualCost_update` AFTER UPDATE ON `planned_actuals_cost` FOR EACH ROW BEGIN
	
	DECLARE userNotificationId BIGINT;
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("Planned cost updated for task ",`getProjectTaskTitleById`(NEW.task_id)),
	NEW.modified_by,7, NOW());	
	
	INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert) 
	VALUES (CONCAT("Planned cost updated for task ", getProjectTaskTitleById(NEW.task_id)), 
	"NEW",NEW.modified_by, NOW());
 
	SET userNotificationId = LAST_INSERT_ID();
 
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','COST',userNotificationId);
	
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.id,userNotificationId);
END */$$


DELIMITER ;

/* Trigger structure for table `project` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `project_AFTER_INSERT` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `project_AFTER_INSERT` AFTER INSERT ON `project` FOR EACH ROW BEGIN
	
	DECLARE ppId BIGINT;
	
   
	SELECT project_parent_id INTO ppId FROM  project WHERE project_id= NEW.project_id;    
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
	(CONCAT("New Activity ", NEW.project_name, " added by ", get_userNameById(NEW.project_owner_id)),
	NEW.project_owner_id,2, NOW(),ppId);
	
	
      
END */$$


DELIMITER ;

/* Trigger structure for table `project` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `project_AFTER_UPDATE` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `project_AFTER_UPDATE` AFTER UPDATE ON `project` FOR EACH ROW BEGIN
	
	DECLARE ppId BIGINT;
	
	
	SELECT project_parent_id INTO ppId FROM  project WHERE project_id= OLD.project_id;
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert,project_id) VALUES
	(CONCAT("Activity ", NEW.project_name, " updated by ", get_userNameById(NEW.modified_by)),
	New.modified_by,2, NOW(),ppId);
  
	
  
  END */$$


DELIMITER ;

/* Trigger structure for table `project_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_task_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `log_task_add` AFTER INSERT ON `project_task` FOR EACH ROW BEGIN
	
	DECLARE userNotificationId BIGINT;
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("New task ", NEW.title, " added by ", get_userNameById(NEW.created_by)),
	New.created_by,4, NOW());
	
	INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert) 
	VALUES (CONCAT("New task ", NEW.title, " added by ", get_userNameById(NEW.created_by)), 
	"NEW",NEW.created_by, NOW());
 
	SET userNotificationId = LAST_INSERT_ID();
	
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','TASK',userNotificationId);
	
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.project_task_id,userNotificationId);
END */$$


DELIMITER ;

/* Trigger structure for table `project_task` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_task_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `log_task_update` AFTER UPDATE ON `project_task` FOR EACH ROW BEGIN
	
	DECLARE userNotificationId BIGINT;
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("Task ", NEW.title, " updated by ", get_userNameById(NEW.modified_by)),
	NEW.modified_by,5, NOW());
	
	INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert) 
	VALUES (CONCAT("Task of id ",NEW.project_task_id , " updated by ", get_userNameById(NEW.modified_by)), 
	"NEW",NEW.modified_by, NOW());
 
	SET userNotificationId = LAST_INSERT_ID();
	
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','TASK',userNotificationId);
	
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.project_task_id,userNotificationId);
END */$$


DELIMITER ;

/* Trigger structure for table `project_task_files` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_projectTaskFile_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'ontarget'@'localhost' */ /*!50003 TRIGGER `log_projectTaskFile_add` AFTER INSERT ON `project_task_files` FOR EACH ROW BEGIN
	
	DECLARE userNotificationId BIGINT;
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("New file ",NEW.file_name," uploaded for task ",`getProjectTaskTitleById`(NEW.project_task_id)),
	NEW.created_by,10, NOW());
	
	INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert) 
	VALUES (CONCAT("New file ",NEW.file_name," uploaded for task ", getProjectTaskTitleById(NEW.project_task_id)), "NEW",
	NEW.created_by, NOW());
 
	SET userNotificationId = LAST_INSERT_ID();
 
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','TASK_FILE',userNotificationId);
	
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.task_file_id,userNotificationId);
END */$$


DELIMITER ;

/* Trigger structure for table `task_comment` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `log_comment_add` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `log_comment_add` AFTER INSERT ON `task_comment` FOR EACH ROW BEGIN
 
	DECLARE userNotificationId BIGINT;
	
	INSERT INTO activity_log (TEXT, user_id,category,ts_insert) VALUES
	(CONCAT("Comment ", NEW.comment, " added on task ", `getProjectTaskTitleById`(NEW.task_id)),
	NEW.commented_by,1, NOW());
	
	INSERT INTO user_notification (TEXT, STATUS,user_id, ts_insert) 
	VALUES (CONCAT("Comment ", NEW.comment, " added on task ", getProjectTaskTitleById(NEW.task_id)), 
	"NEW",NEW.commented_by, NOW());
 
	SET userNotificationId = LAST_INSERT_ID();
 
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationType','COMMENT',userNotificationId);
	
	INSERT INTO user_notification_attribute(attribute_key,attribute_value,user_notification_id)
	VALUES('notificationId',NEW.task_comment_id,userNotificationId);
          
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
