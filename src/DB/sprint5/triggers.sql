DELIMITER $$

USE `ontarget`$$

DROP TRIGGER /*!50032 IF EXISTS */ `document_submittal_after_insert`$$

CREATE
    /*!50017 DEFINER = 'root'@'localhost' */
    TRIGGER `document_submittal_after_insert` AFTER INSERT ON `document_submittal` 
    FOR EACH ROW BEGIN
	
	DECLARE notificationId BIGINT;
	DECLARE documentId INT(10);
	DECLARE projectId INT(10);
	
	SET projectId		= getProjectIdByDocumentId(NEW.document_id);
	SET documentId 	= NEW.document_id;
	
	IF NEW.assignee_user_id !=NEW.created_by THEN
	
		INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
		VALUES('CREATE','DOCUMENT_SUBMITTAL_ASSIGN',projectId,NOW());
			
		SET notificationId = LAST_INSERT_ID();
				
		INSERT INTO user_notification(STATUS,notification_id,user_id)
		VALUES('NEW',notificationId,NEW.assignee_user_id);
			
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('documentId',documentId,notificationId);
			
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('projectId',projectId,notificationId);
				
		INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
		VALUES('userId',NEW.created_by,notificationId);

	END IF;
END;
$$

DELIMITER ;