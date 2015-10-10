
CREATE TABLE user_notification_bak SELECT * FROM user_notification;

CREATE TABLE user_notification_attribute_bak SELECT * FROM user_notification_attribute;


DROP TABLE user_notification_attribute;
DROP TABLE user_notification;


CREATE TABLE `notification` (
  `notification_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action` varchar(10) NOT NULL,
  `notification_type` varchar(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `ts_insert` datetime NOT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;


CREATE TABLE `notification_attribute` (
  `notification_attribute_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_key` varchar(20) NOT NULL,
  `attribute_value` varchar(20) NOT NULL,
  `notification_id` bigint(20) NOT NULL,
  PRIMARY KEY (`notification_attribute_id`),
  KEY `FK_gqhka1an8f0rlr5lkdo60cy0e` (`notification_id`),
  CONSTRAINT `FK_gqhka1an8f0rlr5lkdo60cy0e` FOREIGN KEY (`notification_id`) REFERENCES `notification` (`notification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=latin1;


CREATE TABLE `user_notification` (
  `user_notification_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `last_seen_at` datetime DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `notification_id` bigint(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_notification_id`),
  KEY `FK_57br8073hgsj70sww9gwv88to` (`notification_id`),
  KEY `FK_hrv2lmyjlt3ken6hk2f4sg1e` (`user_id`),
  CONSTRAINT `FK_57br8073hgsj70sww9gwv88to` FOREIGN KEY (`notification_id`) REFERENCES `notification` (`notification_id`),
  CONSTRAINT `FK_hrv2lmyjlt3ken6hk2f4sg1e` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;



ALTER TABLE user_notification_bak
ADD COLUMN
(

    activity_type_temp VARCHAR(20),
      action_temp VARCHAR(20),
    status_id_temp INT(11)
); 

/*
    add following fields in user_notification_bak table
    activity_type_temp varchar
    action_temp varchar
    status_id_temp int
   */

UPDATE user_notification_bak SET activity_type_temp='PROJECT',
action_temp='CREATE'
WHERE TEXT LIKE '%New Project%';

UPDATE user_notification_bak SET activity_type_temp='PROJECT',
action_temp='UPDATE'
WHERE  (TEXT LIKE '%Project%' AND TEXT LIKE '%updated by%');


UPDATE user_notification_bak SET activity_type_temp='TASK',
action_temp='CREATE'
WHERE TEXT LIKE '%has created new task%';


UPDATE user_notification_bak SET activity_type_temp='ACTIVITY',
action_temp='CREATE'
WHERE TEXT LIKE '%New Activity%';



UPDATE user_notification_bak SET activity_type_temp='ACTIVITY',
action_temp='UPDATE'
WHERE  (TEXT LIKE '%Activity%' AND TEXT LIKE '%updated by%');


UPDATE user_notification_bak SET activity_type_temp='PROJECT_FILE',
action_temp='CREATE'
WHERE TEXT LIKE '%has uploaded%';


UPDATE user_notification_bak SET activity_type_temp='TASK_PERCENTAGE',
action_temp='UPDATE'
WHERE TEXT LIKE '%changed progress%';


UPDATE user_notification_bak SET activity_type_temp='TASK_COST',
action_temp='CREATE'
WHERE TEXT LIKE '%New planned cost added%';

UPDATE user_notification_bak SET activity_type_temp='TASK_COST',
action_temp='UPDATE'
WHERE TEXT LIKE '%Planned cost updated%';


UPDATE user_notification_bak SET activity_type_temp='TASK_ASSIGN',
action_temp='CREATE'
WHERE TEXT LIKE '%has assigned%';


UPDATE user_notification_bak SET activity_type_temp='TASK',
action_temp='UPDATE'
WHERE TEXT LIKE '%has made an update to%';

UPDATE user_notification_bak SET activity_type_temp='TASK_STATUS',
action_temp='UPDATE'
WHERE TEXT LIKE '%has changed the status of the task%';

UPDATE user_notification_bak SET activity_type_temp='TASK_COMMENT',
action_temp='CREATE'
WHERE notification_type='TASK_COMMENTS';

UPDATE user_notification_bak SET activity_type_temp='PROJECT_FILE_COMMENT',
action_temp='CREATE'
WHERE notification_type='PRJ_FILE_CMMT';

UPDATE user_notification_bak SET activity_type_temp='TASK_ATTACHMENT',
action_temp='CREATE'
WHERE TEXT LIKE '%has made an attachment%';


UPDATE user_notification_bak SET status_id_temp = 2
WHERE TEXT LIKE '%status of the task to Pending%';


UPDATE user_notification_bak SET status_id_temp = 1
WHERE  TEXT LIKE '%status of the task to Active%';


UPDATE user_notification_bak SET status_id_temp = 3
WHERE  TEXT LIKE '%status of the task to Completed%';


ALTER TABLE user_notification_attribute_bak 
ADD COLUMN
(

    attributevalue VARCHAR(20),
   ref_id_temp bigint(11)
); 

/*
  add following fileds in user_notification_bak_attribute table
  attributevalue varchar
  ref_id_temp  bigint
*/

UPDATE user_notification_attribute_bak
SET ref_id_temp=id+1;
 
 UPDATE user_notification_attribute_bak a
  JOIN user_notification_attribute_bak b ON(a.`ref_id_temp`=b.`id`)
  SET a.`attributevalue`=b.`attribute_value`;


ALTER TABLE notification
ADD COLUMN
(

    ref_id_temp bigint(11),
    user_id_temp INT(11),
    activity_done_by_temp INT(11),
    status_id_temp int(11)
); 
/*
 add following fields in notification table
   ref_id_temp bigint
   user_id_temp int
    activity_done_by_temp int
   status_id_temp int
*/
INSERT INTO notification(ACTION,notification_type,project_id,ts_insert,ref_id_temp,user_id_temp,activity_done_by_temp,status_id_temp)
SELECT action_temp,activity_type_temp,project_id,ts_insert,id,user_id,11,status_id_temp 
FROM user_notification_bak 
WHERE action_temp IS NOT NULL;

INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
SELECT a.attribute_value,a.attributevalue,b.notification_id FROM
user_notification_attribute_bak a
JOIN notification b ON(a.user_notification_id=b.ref_id_temp)
AND a.attribute_key='notificationType';

INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
SELECT 'status',status_id_temp,notification_id
FROM notification where status_id_temp IS NOT NULL;

INSERT INTO notification_attribute(attribute_key,attribute_value,notification_id)
SELECT 'userId',11,notification_id
FROM notification;

INSERT INTO user_notification(last_seen_at,STATUS,notification_id,user_id)
SELECT last_seen_at,STATUS,n.notification_id,user_id FROM
user_notification_bak un
JOIN notification n ON(n.ref_id_temp=un.id);


 
