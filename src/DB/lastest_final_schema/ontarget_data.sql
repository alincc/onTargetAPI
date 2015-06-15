/*
-- Query: select * from user_type
LIMIT 0, 1000

-- Date: 2015-02-14 20:03
*/
INSERT INTO `user_type` (`user_type_id`,`user_type`,`created_date`,`created_by`,`modified_date`,`modified_by`,`is_expired`) VALUES (1,'USER','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM','0');

/*
-- Query: select * from company_type
LIMIT 0, 1000

-- Date: 2015-02-14 20:06
*/
INSERT INTO `company_type` (`company_type_id`,`company_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`deleted_date`,`delete_flag`,`deleted_by`,`status`) VALUES (1,'GENERAL CONTRACTOR',NULL,'SYSTEM','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00',NULL,NULL,'ACTIVE');
INSERT INTO `company_type` (`company_type_id`,`company_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`deleted_date`,`delete_flag`,`deleted_by`,`status`) VALUES (2,'CONSTRUCTION MANAGER',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,NULL,'ACTIVE');
INSERT INTO `company_type` (`company_type_id`,`company_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`deleted_date`,`delete_flag`,`deleted_by`,`status`) VALUES (3,'SUB CONTRACTOR',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,NULL,'ACTIVE');
INSERT INTO `company_type` (`company_type_id`,`company_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`deleted_date`,`delete_flag`,`deleted_by`,`status`) VALUES (4,'OWNER',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,NULL,'ACTIVE');
INSERT INTO `company_type` (`company_type_id`,`company_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`deleted_date`,`delete_flag`,`deleted_by`,`status`) VALUES (5,'SPECIALITY CONTRACTOR',NULL,'SYSTEM',NULL,'SYSTEM',NULL,NULL,NULL,'ACTIVE');
INSERT INTO `company_type` (`company_type_id`,`company_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`deleted_date`,`delete_flag`,`deleted_by`,`status`) VALUES (6,'ARCHITECT/ENGINEERS',NULL,'SYSTEM',NULL,'SYSTE',NULL,NULL,NULL,'ACTIVE');


/*
-- Query: select * from document_template
LIMIT 0, 1000

-- Date: 2015-02-14 20:07
*/
INSERT INTO `document_template` (`document_template_id`,`name`,`created_by`,`created_date`,`modified_by`,`modfied_date`) VALUES (20,'Purchase Order','SYSTEM','2015-01-09 13:19:58','SYSTEM','2015-01-09 13:19:58');
INSERT INTO `document_template` (`document_template_id`,`name`,`created_by`,`created_date`,`modified_by`,`modfied_date`) VALUES (21,'Change Order','SYSTEM','2015-01-09 13:19:58','SYSTEM','2015-01-09 13:19:58');
INSERT INTO `document_template` (`document_template_id`,`name`,`created_by`,`created_date`,`modified_by`,`modfied_date`) VALUES (22,'Request For Information','SYSTEM','2015-01-09 13:19:58','SYSTEM','2015-01-09 13:19:58');
INSERT INTO `document_template` (`document_template_id`,`name`,`created_by`,`created_date`,`modified_by`,`modfied_date`) VALUES (23,'Transmittal','SYSTEM','2015-01-09 13:19:58','SYSTEM','2015-01-09 13:19:58');


/*
-- Query: select * from project_type
LIMIT 0, 1000

-- Date: 2015-02-14 20:08
*/
INSERT INTO `project_type` (`project_type_id`,`project_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`delete_flag`,`deleted_date`,`deleted_by`,`status`) VALUES (1,'COMMERCIAL','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE');
INSERT INTO `project_type` (`project_type_id`,`project_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`delete_flag`,`deleted_date`,`deleted_by`,`status`) VALUES (2,'RESIDENTIAL','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE');
INSERT INTO `project_type` (`project_type_id`,`project_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`delete_flag`,`deleted_date`,`deleted_by`,`status`) VALUES (3,'INFRASTRUCTURE','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE');
INSERT INTO `project_type` (`project_type_id`,`project_type_name`,`created_date`,`created_by`,`modified_date`,`modified_by`,`delete_flag`,`deleted_date`,`deleted_by`,`status`) VALUES (4,'MEDICAL','0000-00-00 00:00:00','SYSTEM','0000-00-00 00:00:00','SYSTEM',NULL,NULL,NULL,'ACTIVE');

/*
-- Query: select * from task_status
LIMIT 0, 1000

-- Date: 2015-02-14 20:09
*/
INSERT INTO `task_status` (`task_status_id`,`status_code`,`status_name`,`status_description`) VALUES (1,'ACTIVE','Active','Active Status');
INSERT INTO `task_status` (`task_status_id`,`status_code`,`status_name`,`status_description`) VALUES (2,'ONGOING','Ongoing','Ongoing Status');
INSERT INTO `task_status` (`task_status_id`,`status_code`,`status_name`,`status_description`) VALUES (3,'COMPLETED','Completed','Completed Status');
INSERT INTO `task_status` (`task_status_id`,`status_code`,`status_name`,`status_description`) VALUES (4,'PENDING','Pending','Pending Status');


/*
-- Query: select * from user_safety_info
LIMIT 0, 1000

-- Date: 2015-02-14 20:10
*/
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (2,'10 fingers, 10 toes 2 eyes 1 nose…safety counts','',1,'2014-12-02 15:41:53');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (3,'10 fingers. 10 toes, If you are not safe Who knows?','',1,'2014-12-02 15:41:53');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (4,'A clean floor everyday keeps lost days away.','',1,'2014-12-02 15:41:53');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (5,'A spill, a slip, a hospital trip','',1,'2014-12-02 15:41:53');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (6,'A tree never hits an automobile except in self defense','',1,'2014-12-02 15:41:53');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (7,'Accidents Big Or Small, Avoid Them All','',1,'2014-12-02 15:41:53');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (8,'Accidents hurt, Safety doesn’t.','',1,'2014-12-02 15:41:53');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (9,'An ounce of prevention is worth a pound of cure','',1,'2014-12-02 15:41:53');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (10,'Are you part of the safety TEAM….(Together Employees Accomplish More)','',1,'2014-12-02 15:41:53');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (11,'Arms work best when attached to the body','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (12,'At work at play, let safety lead the way.','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (13,'Avoid the worst. Put safety first.','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (14,'Be a safety hero – score an accident zero','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (15,'Be alert! Accidents hurt.','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (16,'Be aware Take care','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (17,'Before you do it, take time to think through it.','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (18,'Behind the wheel, anger is one letter away from danger.','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (19,'Being safe is in your own hands.','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (20,'Best gift you can give your family is YOU! Please be safe','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (21,'Break the drive and arrive alive.','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (22,'Chance takers are accident makers','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (23,'Choose safety, for your family.','',1,'2014-12-02 15:41:54');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (24,'Click clack front and back.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (25,'Click it or ticket!','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (26,'Computer problems you can avoid, so you don’t have to get paranoid.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (27,'Courtesy and common sense promote safety.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (28,'Courtesy is contagious','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (29,'Dare to be aware.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (30,'Do you have eye for safety or are you blinded by bad habits','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (31,'Doesn’t matter how far. JUST BELT UP!','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (32,'Don’t be a fool, cause safety is cool, so make that your rule.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (33,'Don’t be a fool. Use the proper tool.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (34,'Don’t be hasty when it comes to safety.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (35,'Don’t be safety blinded, be safety minded.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (36,'Don’t learn safety by accident.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (37,'Don’t leave Private information on a public computer screen','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (38,'Eyes are priceless, eye protection is cheap.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (39,'Falling objects can be brutal if you don’t protect your noodle.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (40,'Fingers toes, If you are not safe Who knows?','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (41,'Forget the nurse with safety first.','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (42,'Forgot your hearing protection? Forget about hearing!','',1,'2014-12-02 15:41:55');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (43,'Get in high speed pursuit of safety','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (44,'Get smart! Use safety from the start.','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (45,'Give them a Brake!','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (46,'Got crazy with the lighter? Call a firefighter.','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (47,'Hard hats, they’re not just for decoration','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (48,'Have another day by being safe today!','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (49,'Hearing protection is a sound investment.','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (50,'Housekeeping you skip may cause a fall or slip.','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (51,'If everything comes your way, you are in the wrong lane.','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (52,'If they email you asking for cash, be sure to throw it in the trash.','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (53,'If they email you asking for Money, Say no thanks I won’t fall for it honey.','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (54,'If you don’t know the sender, it might be a pretender','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (55,'If you don’t think it will happen to you, find the person who had it happen to them','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (56,'If you mess up, ‘fess up','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (57,'Is better to lose one minute in life… than to lose life in a minute.','',1,'2014-12-02 15:41:56');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (58,'It only takes one mistake to bring us all down; don’t let it be yours!','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (59,'It’s easier to ask a dumb question than it is to fix a dumb mistake','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (60,'Keep a grip on life and protect your hands','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (61,'Keep safety in mind. It will save your behind.','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (62,'Keeping your work area clean, helps keep hazards from being unseen.','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (63,'Knock out…accidents','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (64,'Know safety – no pain','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (65,'Know safety No Accidents','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (66,'Lead the way, safety today.','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (67,'Learn from others mistakes, don’t have others learn from you.','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (68,'Let’s all keep our heads, and other body parts, together','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (69,'Life’s short, don’t rush it','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (70,'Light up your tree – not your home','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (71,'Make it your mission, not to live in unsafe condition.','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (72,'Make safety a reality and don’t be a fatality','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (73,'My job provides my paycheck, but safety takes me home.','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (74,'Near miss reported today, is the accident that does not happen tomorrow.','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (75,'Never drive faster than your guardian angel can fly','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (76,'Never give safety a day off','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (77,'No Belt. No Brains','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (78,'No safety – know pain','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (79,'One bad day at the grinder could ruin your whole life','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (80,'Only You can prevent forest fires!','',1,'2014-12-02 15:41:57');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (81,'Pencils have erasers–mishaps don’t!','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (82,'Prevent a jam, don’t open spam','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (83,'Protect your hands, you need them to pick up your pay check','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (84,'Quench the thirst – safety first','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (85,'Replacing a saw guard is easier than replacing a finger','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (86,'Safe crane operation is uplifting','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (87,'Safety – A small investment for a rich future','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (88,'Safety by Choice, Not by Chance.','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (89,'Safety comes in a can, I can, You can, We can be safe.','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (90,'Safety doesn’t happen by accident','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (91,'Safety first makes us last.','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (92,'Safety First, Avoid the Worst.','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (93,'Safety first, to last.','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (94,'Safety first…because accidents last.','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (95,'Safety fits like a glove; Try one on.','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (96,'Safety Glasses – All in favor say EYE','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (97,'Safety in – we win','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (98,'Safety is a cheap and effective insurance policy','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (99,'Safety is a continuing journey, not a final destination.','',1,'2014-12-02 15:41:58');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (100,'Safety is a frame of mind – So concentrate on it all the time.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (101,'Safety is a Frame of Mind, Get the Picture.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (102,'Safety is a full time job – don’t make it a part time practice','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (103,'Safety is a mission not an intermission','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (104,'Safety is about doing the right thing, even if no one is looking.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (105,'Safety is as simple as ABC – Always Be Careful','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (106,'Safety is like a lock – But you are the key.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (107,'Safety is no accident','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (108,'Safety is success by purpose – Not Accident.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (109,'Safety isn’t a hobby, it’s a living.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (110,'Safety isn’t expensive it’s priceless.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (111,'Safety isn’t just a slogan, it’s a way of life.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (112,'Safety makes good dollars and sense','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (113,'Safety rules are there to follow. So take care and we will see you tomorrow.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (114,'Safety rules are your best tools.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (115,'Safety saves, Accidents cost you.','',1,'2014-12-02 15:41:59');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (116,'Safety starts with “S” but begins with “YOU”.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (117,'Safety starts with me.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (118,'Safety: more fun than running with scissors','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (119,'Safety… It can charm you, or ALARM you!','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (120,'Safety…Did it, done it, doing it tomorrow','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (121,'Safety…one habit you never need to break','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (122,'Save tomorrow. Think safety today.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (123,'Seat Belts are for kids – Hug them at home – Belt them in the car','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (124,'Seatbelts save lives. Buckle up everytime.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (125,'Shortcuts cut life short','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (126,'Speed Thrills but Kills.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (127,'Stay safe, someone at home is waiting for you.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (128,'Stop drop & roll','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (129,'Success is no accident','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (130,'The best car safety device is a rear-view mirror with a cop in it.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (131,'The door to Safety swings on the hinges of common sense','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (132,'The only trip you take should be on vacation.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (133,'The safe way is the only way.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (134,'The stupid shall be punished','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (135,'Think Safety, Because I Love You Man.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (136,'Think sharp….never handle broken glass with bare hands.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (137,'Think smart before you start.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (138,'Those precious fingers don’t ignore, Or they could end up on the floor.','',1,'2014-12-02 15:42:00');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (139,'Those who work the safest way- live to see another day','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (140,'To avoid a scene keep your work place clean.','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (141,'To prevent a drastic call, Install a firewall','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (142,'Tomorrow: Your reward for working safely today.','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (143,'Trying to make up time could cost you your life.','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (144,'Unsafe acts will keep you in stitches','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (145,'Watch where you walk or you might need a walker.','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (146,'Watch your step – it could be your last tomorrow','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (147,'whats holding you back?','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (148,'When you gamble with safety ..You bet your life.','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (149,'While on a ladder, never step back to admire your work','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (150,'Wipe Up and avoid a Slip Up!','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (151,'Work safe today–heaven can wait.','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (152,'Work together…work safely.','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (153,'Working safely may get old, but so do those who practice it.','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (154,'Your first mistake could be your last','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (155,'Your reward for working safely today.','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (156,'Your wife will spend your 401K; If you get killed at work today.','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (157,'Protect your hands, you need them to pick up your pay check','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (158,'Your wife will spend your 401K; If you get killed at work today','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (159,'Safety…Did it, done it, doing it tomorrow','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (160,'Watch your step - it could be your last tomorrow','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (161,'Those precious fingers don’t ignore. . . Or they could end up on the floor','',1,'2014-12-02 15:42:01');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (162,'Your reward for working safely today.','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (163,'Those who work the safest way- live to see another day','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (164,'Get in high speed pursuit of safety','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (165,'Seat Belts are for kids - Hug them at home - Belt them in the car','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (166,'Safe crane operation is uplifting','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (167,'Pencils have erasers–mishaps don’t!','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (168,'Work safe today–heaven can wait.','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (169,'Safety is a mission not an intermission','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (170,'Safety doesn’t happen by accident','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (171,'A spill, a slip, a hospital trip ','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (172,'Falling objects can be brutal if you don’t protect your noodle','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (173,'Safety glasses: All in favor say “Eye!”','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (174,'It’s easier to ask a dumb question than it is to fix a dumb mistake','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (175,'Safety isn’t a hobby, it’s a living.','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (176,'Safety - A small investment for a rich future','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (177,'Safety is no accident','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (178,'Safety is a cheap and effective insurance policy','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (179,'Let’s all keep our heads, and other body parts, together','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (180,'While on a ladder, never step back to admire your work','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (181,'Quench the thirst – safety first','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (182,'When you gamble with safety you bet your life','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (183,'The stupid shall be punished','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (184,'Chance takers are accident makers','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (185,'Safety is a full time job; don’t make it a part time practice','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (186,'The door to Safety swings on the hinges of common sense','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (187,'Is better to lose one minute in life… than to lose life in a minute.','',1,'2014-12-02 15:42:02');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (188,'Safety — a small investment for a rich future','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (189,'Your first mistake could be your last','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (190,'Safety isn’t expensive it’s priceless.','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (191,'Safety is as simple as ABC…Always Be Careful','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (192,'Unsafe acts will keep you in stitches','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (193,'Knock out…accidents','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (194,'If you mess up, ‘fess up','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (195,'Hard hats, they’re not just for decoration','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (196,'If you don’t think it will happen to you, find the person who had it happen to them','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (197,'Keep safety in mind. It will save your behind.','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (198,'One bad day at the grinder could ruin your whole life','',1,'2014-12-02 15:42:03');
INSERT INTO `user_safety_info` (`id`,`name`,`info`,`discipline_id`,`ts_create`) VALUES (199,'Shortcuts cut life short','',1,'2014-12-02 15:42:03');



