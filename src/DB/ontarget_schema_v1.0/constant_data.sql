/*Data for the table `application_menu` */

insert  into `application_menu`(`application_menu_id`,`active`,`menu_key`,`menu_name`) values
  (1,'Y','DASHBOARD','Dashboard'),
  (2,'Y','ONTIME','onTime'),
  (3,'Y','ONSITE','onSITE'),
  (4,'Y','ONFILE','onFILE'),
  (5,'Y','ONTARGET','onTARGET'),
  (6,'Y','ONCONTACT','onCONTACT'),
  (7,'Y','ONREPORT','onREPORT');

/*Table structure for table `application_permission` */


/*Data for the table `application_permission` */

insert  into `application_permission`(`application_permission_id`,`active`,`permission_key`,`permission_name`) values
  (1,'Y','VIEW_DASHBOARD','View Dashboard'),
  (2,'Y','VIEW_ONTIME','View OnTime'),
  (3,'Y','EDIT_ONTIME','Edit OnTime'),
  (4,'Y','ADD_TASK_COMMENT','Add Task Comment'),
  (5,'Y','VIEW_ONSITE','View OnSite'),
  (6,'Y','ONSITE_UPLOAD','OnSite Upload'),
  (7,'Y','ONFILE_FULL_ACCESS','OnFile Full Access');


/**
profile - need to figure out the user id who added and modified it initially.
 */
INSERT INTO `profile` (`profile_id`, `active`, `added_date`, `modified_date`, `name`, `added_by`, `modified_by`, `description`, `profile_code`) VALUES
  (1,'Y','2015-08-23 17:27:48',NULL,'Super User',10,NULL,'Super User Profile','SU'),
  (2,'Y','2015-08-23 17:28:09',NULL,'Project Manager',10,NULL,'Project Manager Profile','PM'),
  (3,'Y','2015-08-23 17:28:27',NULL,'Regular User',10,NULL,'Regular User','RU');



insert  into `profile_menu`(`profile_menu_id`,`active`,`application_menu_id`,`profile_id`) values
  (1,'Y',1,1),
  (2,'Y',2,1),
  (3,'Y',3,1),
  (4,'Y',4,1),
  (5,'Y',5,1),
  (6,'Y',6,1),
  (7,'Y',7,1),
  (10,'Y',1,2),
  (11,'Y',2,2),
  (12,'Y',3,2),
  (13,'Y',4,2),
  (14,'Y',1,3),
  (15,'Y',2,3),
  (16,'Y',3,3),
  (17,'Y',4,3),
  (18,'Y',1,4),
  (19,'Y',2,4),
  (20,'Y',3,4),
  (21,'Y',4,4),
  (22,'Y',5,4),
  (23,'Y',6,4),
  (24,'Y',7,4),
  (25,'Y',1,5),
  (26,'Y',2,5),
  (27,'Y',3,5),
  (28,'Y',4,5),
  (29,'Y',5,5),
  (30,'Y',6,5),
  (31,'Y',7,5),
  (32,'Y',1,6),
  (33,'Y',2,6),
  (34,'Y',3,6),
  (35,'Y',5,6),
  (36,'Y',6,6),
  (37,'Y',7,6);


insert  into `profile_permission`(`profile_permission_id`,`active`,`application_permission_id`,`profile_id`) values (1,'Y',2,4);

/* user safety info by discipline*/

insert  into `user_safety_info`(`id`,`name`,`info`,`discipline_id`,`ts_create`) values (2,'10 fingers, 10 toes 2 eyes 1 nose…safety counts','',1,'2014-12-03 03:26:53'),(3,'10 fingers. 10 toes, If you are not safe Who knows?','',2,'2014-12-03 03:26:53'),(4,'A clean floor everyday keeps lost days away.','',3,'2014-12-03 03:26:53'),(5,'A spill, a slip, a hospital trip','',4,'2014-12-03 03:26:53'),(6,'A tree never hits an automobile except in self defense','',5,'2014-12-03 03:26:53'),(7,'Accidents Big Or Small, Avoid Them All','',1,'2014-12-03 03:26:53'),(8,'Accidents hurt, Safety doesn’t.','',2,'2014-12-03 03:26:53'),(9,'An ounce of prevention is worth a pound of cure','',3,'2014-12-03 03:26:53'),(10,'Are you part of the safety TEAM….(Together Employees Accomplish More)','',4,'2014-12-03 03:26:53'),(11,'Arms work best when attached to the body','',5,'2014-12-03 03:26:54'),(12,'At work at play, let safety lead the way.','',1,'2014-12-03 03:26:54'),(13,'Avoid the worst. Put safety first.','',2,'2014-12-03 03:26:54'),(14,'Be a safety hero – score an accident zero','',3,'2014-12-03 03:26:54'),(15,'Be alert! Accidents hurt.','',4,'2014-12-03 03:26:54'),(16,'Be aware Take care','',5,'2014-12-03 03:26:54'),(17,'Before you do it, take time to think through it.','',1,'2014-12-03 03:26:54'),(18,'Behind the wheel, anger is one letter away from danger.','',2,'2014-12-03 03:26:54'),(19,'Being safe is in your own hands.','',3,'2014-12-03 03:26:54'),(20,'Best gift you can give your family is YOU! Please be safe','',4,'2014-12-03 03:26:54'),(21,'Break the drive and arrive alive.','',5,'2014-12-03 03:26:54'),(22,'Chance takers are accident makers','',2,'2014-12-03 03:26:54'),(23,'Choose safety, for your family.','',1,'2014-12-03 03:26:54'),(24,'Click clack front and back.','',3,'2014-12-03 03:26:55'),(25,'Click it or ticket!','',4,'2014-12-03 03:26:55'),(26,'Computer problems you can avoid, so you don’t have to get paranoid.','',1,'2014-12-03 03:26:55'),(27,'Courtesy and common sense promote safety.','',2,'2014-12-03 03:26:55'),(28,'Courtesy is contagious','',1,'2014-12-03 03:26:55'),(29,'Dare to be aware.','',4,'2014-12-03 03:26:55'),(30,'Do you have eye for safety or are you blinded by bad habits','',1,'2014-12-03 03:26:55'),(31,'Doesn’t matter how far. JUST BELT UP!','',2,'2014-12-03 03:26:55'),(32,'Don’t be a fool, cause safety is cool, so make that your rule.','',3,'2014-12-03 03:26:55'),(33,'Don’t be a fool. Use the proper tool.','',5,'2014-12-03 03:26:55'),(34,'Don’t be hasty when it comes to safety.','',1,'2014-12-03 03:26:55'),(35,'Don’t be safety blinded, be safety minded.','',2,'2014-12-03 03:26:55'),(36,'Don’t learn safety by accident.','',3,'2014-12-03 03:26:55'),(37,'Don’t leave Private information on a public computer screen','',4,'2014-12-03 03:26:55'),(38,'Eyes are priceless, eye protection is cheap.','',5,'2014-12-03 03:26:55'),(39,'Falling objects can be brutal if you don’t protect your noodle.','',2,'2014-12-03 03:26:55'),(40,'Fingers toes, If you are not safe Who knows?','',3,'2014-12-03 03:26:55'),(41,'Forget the nurse with safety first.','',4,'2014-12-03 03:26:55'),(42,'Forgot your hearing protection? Forget about hearing!','',5,'2014-12-03 03:26:55'),(43,'Get in high speed pursuit of safety','',1,'2014-12-03 03:26:56'),(44,'Get smart! Use safety from the start.','',2,'2014-12-03 03:26:56'),(45,'Give them a Brake!','',3,'2014-12-03 03:26:56'),(46,'Got crazy with the lighter? Call a firefighter.','',4,'2014-12-03 03:26:56'),(47,'Hard hats, they’re not just for decoration','',5,'2014-12-03 03:26:56'),(48,'Have another day by being safe today!','',1,'2014-12-03 03:26:56'),(49,'Hearing protection is a sound investment.','',1,'2014-12-03 03:26:56'),(50,'Housekeeping you skip may cause a fall or slip.','',1,'2014-12-03 03:26:56'),(51,'If everything comes your way, you are in the wrong lane.','',1,'2014-12-03 03:26:56'),(52,'If they email you asking for cash, be sure to throw it in the trash.','',1,'2014-12-03 03:26:56'),(53,'If they email you asking for Money, Say no thanks I won’t fall for it honey.','',2,'2014-12-03 03:26:56'),(54,'If you don’t know the sender, it might be a pretender','',3,'2014-12-03 03:26:56'),(55,'If you don’t think it will happen to you, find the person who had it happen to them','',1,'2014-12-03 03:26:56'),(56,'If you mess up, ‘fess up','',1,'2014-12-03 03:26:56'),(57,'Is better to lose one minute in life… than to lose life in a minute.','',1,'2014-12-03 03:26:56'),(58,'It only takes one mistake to bring us all down; don’t let it be yours!','',1,'2014-12-03 03:26:57'),(59,'It’s easier to ask a dumb question than it is to fix a dumb mistake','',1,'2014-12-03 03:26:57'),(60,'Keep a grip on life and protect your hands','',1,'2014-12-03 03:26:57'),(61,'Keep safety in mind. It will save your behind.','',1,'2014-12-03 03:26:57'),(62,'Keeping your work area clean, helps keep hazards from being unseen.','',1,'2014-12-03 03:26:57'),(63,'Knock out…accidents','',1,'2014-12-03 03:26:57'),(64,'Know safety – no pain','',1,'2014-12-03 03:26:57'),(65,'Know safety No Accidents','',1,'2014-12-03 03:26:57'),(66,'Lead the way, safety today.','',1,'2014-12-03 03:26:57'),(67,'Learn from others mistakes, don’t have others learn from you.','',1,'2014-12-03 03:26:57'),(68,'Let’s all keep our heads, and other body parts, together','',1,'2014-12-03 03:26:57'),(69,'Life’s short, don’t rush it','',1,'2014-12-03 03:26:57'),(70,'Light up your tree – not your home','',1,'2014-12-03 03:26:57'),(71,'Make it your mission, not to live in unsafe condition.','',1,'2014-12-03 03:26:57'),(72,'Make safety a reality and don’t be a fatality','',1,'2014-12-03 03:26:57'),(73,'My job provides my paycheck, but safety takes me home.','',1,'2014-12-03 03:26:57'),(74,'Near miss reported today, is the accident that does not happen tomorrow.','',1,'2014-12-03 03:26:57'),(75,'Never drive faster than your guardian angel can fly','',1,'2014-12-03 03:26:57'),(76,'Never give safety a day off','',1,'2014-12-03 03:26:57'),(77,'No Belt. No Brains','',1,'2014-12-03 03:26:57'),(78,'No safety – know pain','',1,'2014-12-03 03:26:57'),(79,'One bad day at the grinder could ruin your whole life','',1,'2014-12-03 03:26:57'),(80,'Only You can prevent forest fires!','',1,'2014-12-03 03:26:57'),(81,'Pencils have erasers–mishaps don’t!','',1,'2014-12-03 03:26:58'),(82,'Prevent a jam, don’t open spam','',1,'2014-12-03 03:26:58'),(83,'Protect your hands, you need them to pick up your pay check','',1,'2014-12-03 03:26:58'),(84,'Quench the thirst – safety first','',1,'2014-12-03 03:26:58'),(85,'Replacing a saw guard is easier than replacing a finger','',1,'2014-12-03 03:26:58'),(86,'Safe crane operation is uplifting','',1,'2014-12-03 03:26:58'),(87,'Safety – A small investment for a rich future','',1,'2014-12-03 03:26:58'),(88,'Safety by Choice, Not by Chance.','',1,'2014-12-03 03:26:58'),(89,'Safety comes in a can, I can, You can, We can be safe.','',1,'2014-12-03 03:26:58'),(90,'Safety doesn’t happen by accident','',1,'2014-12-03 03:26:58'),(91,'Safety first makes us last.','',1,'2014-12-03 03:26:58'),(92,'Safety First, Avoid the Worst.','',1,'2014-12-03 03:26:58'),(93,'Safety first, to last.','',1,'2014-12-03 03:26:58'),(94,'Safety first…because accidents last.','',1,'2014-12-03 03:26:58'),(95,'Safety fits like a glove; Try one on.','',1,'2014-12-03 03:26:58'),(96,'Safety Glasses – All in favor say EYE','',1,'2014-12-03 03:26:58'),(97,'Safety in – we win','',1,'2014-12-03 03:26:58'),(98,'Safety is a cheap and effective insurance policy','',1,'2014-12-03 03:26:58'),(99,'Safety is a continuing journey, not a final destination.','',1,'2014-12-03 03:26:58'),(100,'Safety is a frame of mind – So concentrate on it all the time.','',1,'2014-12-03 03:26:59'),(101,'Safety is a Frame of Mind, Get the Picture.','',1,'2014-12-03 03:26:59'),(102,'Safety is a full time job – don’t make it a part time practice','',1,'2014-12-03 03:26:59'),(103,'Safety is a mission not an intermission','',1,'2014-12-03 03:26:59'),(104,'Safety is about doing the right thing, even if no one is looking.','',1,'2014-12-03 03:26:59'),(105,'Safety is as simple as ABC – Always Be Careful','',1,'2014-12-03 03:26:59'),(106,'Safety is like a lock – But you are the key.','',1,'2014-12-03 03:26:59'),(107,'Safety is no accident','',1,'2014-12-03 03:26:59'),(108,'Safety is success by purpose – Not Accident.','',1,'2014-12-03 03:26:59'),(109,'Safety isn’t a hobby, it’s a living.','',1,'2014-12-03 03:26:59'),(110,'Safety isn’t expensive it’s priceless.','',1,'2014-12-03 03:26:59'),(111,'Safety isn’t just a slogan, it’s a way of life.','',1,'2014-12-03 03:26:59'),(112,'Safety makes good dollars and sense','',1,'2014-12-03 03:26:59'),(113,'Safety rules are there to follow. So take care and we will see you tomorrow.','',1,'2014-12-03 03:26:59'),(114,'Safety rules are your best tools.','',1,'2014-12-03 03:26:59'),(115,'Safety saves, Accidents cost you.','',1,'2014-12-03 03:26:59'),(116,'Safety starts with “S” but begins with “YOU”.','',1,'2014-12-03 03:27:00'),(117,'Safety starts with me.','',1,'2014-12-03 03:27:00'),(118,'Safety: more fun than running with scissors','',1,'2014-12-03 03:27:00'),(119,'Safety… It can charm you, or ALARM you!','',1,'2014-12-03 03:27:00'),(120,'Safety…Did it, done it, doing it tomorrow','',1,'2014-12-03 03:27:00'),(121,'Safety…one habit you never need to break','',1,'2014-12-03 03:27:00'),(122,'Save tomorrow. Think safety today.','',1,'2014-12-03 03:27:00'),(123,'Seat Belts are for kids – Hug them at home – Belt them in the car','',1,'2014-12-03 03:27:00'),(124,'Seatbelts save lives. Buckle up everytime.','',1,'2014-12-03 03:27:00'),(125,'Shortcuts cut life short','',1,'2014-12-03 03:27:00'),(126,'Speed Thrills but Kills.','',1,'2014-12-03 03:27:00'),(127,'Stay safe, someone at home is waiting for you.','',1,'2014-12-03 03:27:00'),(128,'Stop drop & roll','',1,'2014-12-03 03:27:00'),(129,'Success is no accident','',1,'2014-12-03 03:27:00'),(130,'The best car safety device is a rear-view mirror with a cop in it.','',1,'2014-12-03 03:27:00'),(131,'The door to Safety swings on the hinges of common sense','',1,'2014-12-03 03:27:00'),(132,'The only trip you take should be on vacation.','',1,'2014-12-03 03:27:00'),(133,'The safe way is the only way.','',1,'2014-12-03 03:27:00'),(134,'The stupid shall be punished','',1,'2014-12-03 03:27:00'),(135,'Think Safety, Because I Love You Man.','',1,'2014-12-03 03:27:00'),(136,'Think sharp….never handle broken glass with bare hands.','',1,'2014-12-03 03:27:00'),(137,'Think smart before you start.','',1,'2014-12-03 03:27:00'),(138,'Those precious fingers don’t ignore, Or they could end up on the floor.','',1,'2014-12-03 03:27:00'),(139,'Those who work the safest way- live to see another day','',1,'2014-12-03 03:27:01'),(140,'To avoid a scene keep your work place clean.','',1,'2014-12-03 03:27:01'),(141,'To prevent a drastic call, Install a firewall','',1,'2014-12-03 03:27:01'),(142,'Tomorrow: Your reward for working safely today.','',1,'2014-12-03 03:27:01'),(143,'Trying to make up time could cost you your life.','',1,'2014-12-03 03:27:01'),(144,'Unsafe acts will keep you in stitches','',1,'2014-12-03 03:27:01'),(145,'Watch where you walk or you might need a walker.','',1,'2014-12-03 03:27:01'),(146,'Watch your step – it could be your last tomorrow','',1,'2014-12-03 03:27:01'),(147,'whats holding you back?','',1,'2014-12-03 03:27:01'),(148,'When you gamble with safety ..You bet your life.','',1,'2014-12-03 03:27:01'),(149,'While on a ladder, never step back to admire your work','',1,'2014-12-03 03:27:01'),(150,'Wipe Up and avoid a Slip Up!','',1,'2014-12-03 03:27:01'),(151,'Work safe today–heaven can wait.','',1,'2014-12-03 03:27:01'),(152,'Work together…work safely.','',1,'2014-12-03 03:27:01'),(153,'Working safely may get old, but so do those who practice it.','',1,'2014-12-03 03:27:01'),(154,'Your first mistake could be your last','',1,'2014-12-03 03:27:01'),(155,'Your reward for working safely today.','',1,'2014-12-03 03:27:01'),(156,'Your wife will spend your 401K; If you get killed at work today.','',1,'2014-12-03 03:27:01'),(157,'Protect your hands, you need them to pick up your pay check','',1,'2014-12-03 03:27:01'),(158,'Your wife will spend your 401K; If you get killed at work today','',1,'2014-12-03 03:27:01'),(159,'Safety…Did it, done it, doing it tomorrow','',1,'2014-12-03 03:27:01'),(160,'Watch your step - it could be your last tomorrow','',1,'2014-12-03 03:27:01'),(161,'Those precious fingers don’t ignore. . . Or they could end up on the floor','',1,'2014-12-03 03:27:01'),(162,'Your reward for working safely today.','',1,'2014-12-03 03:27:02'),(163,'Those who work the safest way- live to see another day','',1,'2014-12-03 03:27:02'),(164,'Get in high speed pursuit of safety','',1,'2014-12-03 03:27:02'),(165,'Seat Belts are for kids - Hug them at home - Belt them in the car','',1,'2014-12-03 03:27:02'),(166,'Safe crane operation is uplifting','',1,'2014-12-03 03:27:02'),(167,'Pencils have erasers–mishaps don’t!','',1,'2014-12-03 03:27:02'),(168,'Work safe today–heaven can wait.','',1,'2014-12-03 03:27:02'),(169,'Safety is a mission not an intermission','',1,'2014-12-03 03:27:02'),(170,'Safety doesn’t happen by accident','',1,'2014-12-03 03:27:02'),(171,'A spill, a slip, a hospital trip ','',1,'2014-12-03 03:27:02'),(172,'Falling objects can be brutal if you don’t protect your noodle','',1,'2014-12-03 03:27:02'),(173,'Safety glasses: All in favor say “Eye!”','',1,'2014-12-03 03:27:02'),(174,'It’s easier to ask a dumb question than it is to fix a dumb mistake','',1,'2014-12-03 03:27:02'),(175,'Safety isn’t a hobby, it’s a living.','',1,'2014-12-03 03:27:02'),(176,'Safety - A small investment for a rich future','',1,'2014-12-03 03:27:02'),(177,'Safety is no accident','',1,'2014-12-03 03:27:02'),(178,'Safety is a cheap and effective insurance policy','',1,'2014-12-03 03:27:02'),(179,'Let’s all keep our heads, and other body parts, together','',1,'2014-12-03 03:27:02'),(180,'While on a ladder, never step back to admire your work','',1,'2014-12-03 03:27:02'),(181,'Quench the thirst – safety first','',1,'2014-12-03 03:27:02'),(182,'When you gamble with safety you bet your life','',1,'2014-12-03 03:27:02'),(183,'The stupid shall be punished','',1,'2014-12-03 03:27:02'),(184,'Chance takers are accident makers','',1,'2014-12-03 03:27:02'),(185,'Safety is a full time job; don’t make it a part time practice','',1,'2014-12-03 03:27:02'),(186,'The door to Safety swings on the hinges of common sense','',1,'2014-12-03 03:27:02'),(187,'Is better to lose one minute in life… than to lose life in a minute.','',1,'2014-12-03 03:27:02'),(188,'Safety — a small investment for a rich future','',1,'2014-12-03 03:27:03'),(189,'Your first mistake could be your last','',1,'2014-12-03 03:27:03'),(190,'Safety isn’t expensive it’s priceless.','',1,'2014-12-03 03:27:03'),(191,'Safety is as simple as ABC…Always Be Careful','',1,'2014-12-03 03:27:03'),(192,'Unsafe acts will keep you in stitches','',1,'2014-12-03 03:27:03'),(193,'Knock out…accidents','',1,'2014-12-03 03:27:03'),(194,'If you mess up, ‘fess up','',1,'2014-12-03 03:27:03'),(195,'Hard hats, they’re not just for decoration','',1,'2014-12-03 03:27:03'),(196,'If you don’t think it will happen to you, find the person who had it happen to them','',1,'2014-12-03 03:27:03'),(197,'Keep safety in mind. It will save your behind.','',1,'2014-12-03 03:27:03'),(198,'One bad day at the grinder could ruin your whole life','',1,'2014-12-03 03:27:03'),(199,'Shortcuts cut life short','',1,'2014-12-03 03:27:03');



/*Data for the table `company_type` */

insert  into `company_type`(`company_type_id`,`company_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`status`) values
  (1,'GENERAL CONTRACTOR',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (2,'CONSTRUCTION MANAGER',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (3,'SUB CONTRACTOR',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (4,'OWNER',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (5,'SPECIALITY CONTRACTOR',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (6,'ARCHITECT/ENGINEERS',now(),'SYSTEM',now(),'SYSTEM','ACTIVE');

/*Table structure for table `contact` */



/*Data for the table `discipline` */

insert  into `discipline`(`id`,`name`,`info`,`ts_insert`) values
  (1,'masonry','Masonry',now()),
  (2,'plumbing','Plumbing',now()),
  (3,'electrical','Electrical',now()),
  (4,'mechanical','Mechanical',now()),
  (5,'Interiors','Interiors',now()),
  (6,'landscaping','Landscaping',now()),
  (7,'bridges','Bridges',now()),
  (8,'tunnels','Tunnels',now()),
  (9,'design','Design',now());

/*Table structure for table `document` */



/*Data for the table `project_type` */

insert  into `project_type`(`project_type_id`,`project_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`status`) values
  (1,'COMMERCIAL',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (2,'RESIDENTIAL',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (3,'INFRASTRUCTURE',now(),'SYSTEM',now(),'SYSTEM','ACTIVE'),
  (4,'MEDICAL',now(),'SYSTEM',now(),'SYSTEM','ACTIVE');

/*Data for the table `task_priority` */

insert  into `task_priority`(`task_priority_id`,`priority`,`code`) values (1,'Critical','CRITICAL'),(2,'High','HIGH'),(3,'Low','LOW');


/*Data for the table `user_type` */

insert  into `user_type`(`user_type_id`,`user_type`,`user_type_desc`,`created_date`,`created_by`,`modified_date`,`modified_by`,`is_expired`) values
  (1,'USER','Regular user',now(),'SYSTEM',now(),'SYSTEM','0'),
  (2,'PROJECT_MANAGER','Project Manager',now(),'SYSTEM',now(),'SYSTEM','0'),
  (3,'SUPER_USER','Super Admin User',now(),'SYSTEM',now(),'SYSTEM','0');



insert  into `project_file_category`(`project_file_category_id`,`active`,`name`) values
  (1,'Y','Shop Drawings'),
  (2,'Y','Specifications'),
  (3,'Y','Invoice RFIs'),
  (4,'Y','Submittals'),
  (5,'Y','Site Photographs'),
  (6,'Y','Transmittal'),
  (7,'Y','Confirmed Set'),
  (8,'Y','As-builts'),
  (9,'Y','Punchlists'),
  (10,'Y','Change Orders');



insert  into `task_status`(`task_status_id`,`status_code`,`status_name`,`status_description`) values
  (1,'ACTIVE','Active','Active Status'),
  (2,'PENDING','Pending','Pending Status'),
  (3,'COMPLETED','Completed','Completed Status'),
  (4,'EXPIRED','Expired','Expired Status');



/*
modify this for that user to set the permission
 */
insert  into `user_profile`(`user_profile_id`,`menu_profile_id`,`permission_profile_id`,`user_id`) values
  (1,1,4,9);