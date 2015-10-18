/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.43-0ubuntu0.14.04.1 : Database - ontarget
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ontarget` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `ontarget`;

/* Trigger structure for table `document` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `document_after_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `document_after_insert` AFTER INSERT ON `document` FOR EACH ROW BEGIN
	
	DECLARE notificationId BIGINT;
	DECLARE activityLogId BIGINT;
	DECLARE documentId INT(10);
	DECLARE projectId INT(10);
	
	SET projectId 	= NEW.project_id;
	SET documentId 	= NEW.document_id;
		
	INSERT INTO activity_log(action,activity_type,user_id,project_id,ts_insert)
	VALUES('CREATE','DOCUMENT',NEW.created_by,projectId,NOW());
		
	SET activityLogId = LAST_INSERT_ID();
		
	INSERT INTO notification(action,notification_type,project_id,ts_insert)
	VALUES('CREATE','DOCUMENT',projectId,NOW());
		
	SET notificationId = LAST_INSERT_ID();
			
	INSERT INTO user_notification(status,notification_id,user_id)
	VALUES('NEW',notificationId,NEW.created_by);
		
	INSERT INTO activity_log_attribute(attribute_key,attribute_value,activity_log_id)
	VALUES('documentId',documentId,activityLogId);
		
	INSERT INTO activity_log_attribute(attribute_key,attribute_value,activity_log_id)
	VALUES('userId',NEW.created_by,activityLogId);
	
	INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
	VALUES('documentId',documentId,notificationId);
		
	INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
	VALUES('projectId',projectId,notificationId);
			
	INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
	VALUES('userId',NEW.created_by,notificationId);
	
END */$$


DELIMITER ;

/* Trigger structure for table `document` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `document_after_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `document_after_update` AFTER UPDATE ON `document` FOR EACH ROW BEGIN
	
	DECLARE notificationId BIGINT;
	DECLARE activityLogId BIGINT;
	DECLARE documentId INT(10);
	DECLARE projectId INT(10);
	DECLARE done INT DEFAULT FALSE;
	DECLARE assignedTo BIGINT;
	DECLARE documentTemplateName VARCHAR(30);
	
	DECLARE assigneeCursor CURSOR FOR SELECT assignee_user_id FROM document_submittal WHERE document_id=NEW.document_id;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	
	SET documentTemplateName = (SELECT name FROM document_template WHERE document_template_id = NEW.document_template_id);
	
	IF OLD.status != NEW.status and documentTemplateName !=  'Request For Information' THEN 
	
		SET projectId 	= NEW.project_id;
		SET documentId 	= NEW.document_id;
			
		INSERT INTO activity_log(ACTION,activity_type,user_id,project_id,ts_insert)
		VALUES('UPDATE','DOCUMENT_STATUS',NEW.modified_by,projectId,NOW());
			
		SET activityLogId = LAST_INSERT_ID();
			
		INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
		VALUES('UPDATE','DOCUMENT_STATUS',projectId,NOW());
			
		SET notificationId = LAST_INSERT_ID();
				
		INSERT INTO user_notification(STATUS,notification_id,user_id)
		VALUES('NEW',notificationId,NEW.modified_by);
			
		INSERT INTO activity_log_attribute(attribute_key,attribute_value,activity_log_id)
		VALUES('documentId',documentId,activityLogId);
			
		INSERT INTO activity_log_attribute(attribute_key,attribute_value,activity_log_id)
		VALUES('userId',NEW.modified_by,activityLogId);
		
		INSERT INTO activity_log_attribute(attribute_key,attribute_value,activity_log_id)
		VALUES('status',NEW.status,activityLogId);
		
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('documentId',documentId,notificationId);
			
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('projectId',projectId,notificationId);
		
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('status',NEW.status,notificationId);
				
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('userId',NEW.modified_by,notificationId);
		
		OPEN assigneeCursor;
	    
			    cursor_loop:REPEAT
				
				FETCH assigneeCursor INTO assignedTo;
					
					IF done THEN
						LEAVE cursor_loop;
					END IF;
					
						INSERT INTO activity_log(ACTION,activity_type,user_id,project_id,ts_insert)
						VALUES('UPDATE','DOCUMENT_STATUS',assignedTo,projectId,NOW());
					
						SET activityLogId = LAST_INSERT_ID();
						
						INSERT INTO activity_log_attribute(attribute_key,attribute_value,activity_log_id)
						VALUES('documentId',documentId,activityLogId);
					
						INSERT INTO activity_log_attribute(attribute_key,attribute_value,activity_log_id)
						VALUES('userId',NEW.modified_by,activityLogId);
				
						INSERT INTO activity_log_attribute(attribute_key,attribute_value,activity_log_id)
						VALUES('status',NEW.status,activityLogId);
					
						INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
						VALUES('UPDATE','DOCUMENT_STATUS',projectId,NOW());
					
						SET notificationId = LAST_INSERT_ID();
						
						INSERT INTO user_notification(STATUS,notification_id,user_id)
						VALUES('NEW',notificationId,assignedTo);
						
						INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
						VALUES('documentId',documentId,notificationId);
					
						INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
						VALUES('projectId',projectId,notificationId);
				
						INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
						VALUES('status',NEW.status,notificationId);
						
						INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
						VALUES('userId',NEW.modified_by,notificationId);
						
			    UNTIL done
	    
			END REPEAT;
	    
		CLOSE assigneeCursor;
	
	END IF;	
	
END */$$


DELIMITER ;

/* Trigger structure for table `document_submittal` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `document_submittal_after_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `document_submittal_after_insert` AFTER INSERT ON `document_submittal` FOR EACH ROW BEGIN
	
	DECLARE notificationId BIGINT;
	DECLARE activityLogId BIGINT;
	DECLARE documentId INT(10);
	DECLARE projectId INT(10);
	
	SET projectId		= (SELECT project_id FROM document WHERE document_id=NEW.document_id);
	SET documentId 	= NEW.document_id;
		
	INSERT INTO activity_log(ACTION,activity_type,user_id,project_id,ts_insert)
	VALUES('CREATE','DOCUMENT',NEW.assignee_user_id,projectId,NOW());
		
	SET activityLogId = LAST_INSERT_ID();
		
	INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
	VALUES('CREATE','DOCUMENT',projectId,NOW());
		
	SET notificationId = LAST_INSERT_ID();
			
	INSERT INTO user_notification(STATUS,notification_id,user_id)
	VALUES('NEW',notificationId,NEW.assignee_user_id);
		
	INSERT INTO activity_log_attribute(attribute_key,attribute_value,activity_log_id)
	VALUES('documentId',documentId,activityLogId);
		
	INSERT INTO activity_log_attribute(attribute_key,attribute_value,activity_log_id)
	VALUES('userId',NEW.created_by,activityLogId);
	
	INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
	VALUES('documentId',documentId,notificationId);
		
	INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
	VALUES('projectId',projectId,notificationId);
			
	INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
	VALUES('userId',NEW.created_by,notificationId);
	
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
