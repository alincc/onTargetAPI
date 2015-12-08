DELIMITER $$

USE `ontargetbeta`$$

DROP TRIGGER /*!50032 IF EXISTS */ `document_after_update`$$

CREATE
    /*!50017 DEFINER = 'root'@'localhost' */
    TRIGGER `document_after_update` AFTER UPDATE ON `document` 
    FOR EACH ROW BEGIN
	
	DECLARE notificationId BIGINT;
	DECLARE activityLogId BIGINT;
	DECLARE documentId INT(10);
	DECLARE projectId INT(10);
	DECLARE done INT DEFAULT FALSE;
	DECLARE assignedTo BIGINT;
	DECLARE attentionTo BIGINT;
	DECLARE documentTemplateName VARCHAR(30);
	
	DECLARE attentionCursor CURSOR FOR SELECT CAST(document_key_value.value AS UNSIGNED) FROM document_key_value WHERE document_key_value.key LIKE 'attention%' AND document_id=NEW.document_id;
	DECLARE assigneeCursor CURSOR FOR SELECT assignee_user_id FROM document_submittal WHERE document_id=NEW.document_id;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	
	SET documentTemplateName = (SELECT NAME FROM document_template WHERE document_template_id = NEW.document_template_id);
	
	IF OLD.status != NEW.status  THEN 
	
		SET projectId 	= NEW.project_id;
		SET documentId 	= NEW.document_id;
			
		INSERT INTO activity_log(ACTION,activity_type,user_id,project_id,ts_insert)
		VALUES('UPDATE','DOCUMENT_STATUS',NEW.modified_by,projectId,NOW());
			
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
		VALUES('NEW',notificationId,NEW.modified_by);
		
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
		
		
		OPEN attentionCursor;
	    
			    cursor_loop:REPEAT
				
				FETCH attentionCursor INTO attentionTo;
					
					IF done THEN
						LEAVE cursor_loop;
					END IF;
					
						INSERT INTO notification(ACTION,notification_type,project_id,ts_insert)
						VALUES('UPDATE','DOCUMENT_STATUS',projectId,NOW());
					
						SET notificationId = LAST_INSERT_ID();
						
						INSERT INTO user_notification(STATUS,notification_id,user_id)
						VALUES('NEW',notificationId,attentionTo);
						
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
	    
		CLOSE attentionCursor;
	
	END IF;	
	
END;
$$

DELIMITER ;