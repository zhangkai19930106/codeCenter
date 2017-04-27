delete from PURE_LOG_VISIT;
delete from PURE_LOG_ENTER;

delete from PURE_ROLE_AUTH;
delete from PURE_USER_ROLE;
delete from PURE_USER_AUTH;

delete from PURE_POST_ROLE;
delete from PURE_POST_MARKED;
delete from PURE_POST;


delete from PURE_PORTAL_CUSTOMIZE;
delete from PURE_RESOURCES;
delete from PURE_RESOURCES_TYPE;
delete from PURE_APP_SYSTEM;

delete from PURE_MESSAGE;

delete from PURE_USER_EXT;

delete from PURE_USER;
delete from PURE_ROLE;

/*应用资源*/
insert into PURE_APP_SYSTEM (APP_SYSTEM_ID, APP_SYSTEM_NAME, SERVER_HOST, CONTEXTPATH, MEMO, ORD)
  values ('PURE', '安全管理', null, null, '系统安全管理，提供资源、角色、用户的及授权功能', 99);

/*资源类型*/
INSERT INTO PURE_RESOURCES_TYPE(RESOURCES_TYPE_ID, RESOURCES_TYPE_NAME, ORD)
  values (1, '系统菜单', 1);
INSERT INTO PURE_RESOURCES_TYPE(RESOURCES_TYPE_ID, RESOURCES_TYPE_NAME, ORD)
  values (2, '选项卡菜单', 2);
INSERT INTO PURE_RESOURCES_TYPE(RESOURCES_TYPE_ID, RESOURCES_TYPE_NAME, ORD)
  values (3, '页面链接', 3);
INSERT INTO PURE_RESOURCES_TYPE(RESOURCES_TYPE_ID, RESOURCES_TYPE_NAME, ORD)
  values (4, '页面按钮', 4);
INSERT INTO PURE_RESOURCES_TYPE(RESOURCES_TYPE_ID, RESOURCES_TYPE_NAME, ORD)
  values (5, '服务', 5);
INSERT INTO PURE_RESOURCES_TYPE(RESOURCES_TYPE_ID, RESOURCES_TYPE_NAME, ORD)
  values (6, 'portlet', 6);
INSERT INTO PURE_RESOURCES_TYPE(RESOURCES_TYPE_ID, RESOURCES_TYPE_NAME, ORD)
  values (99, '其它',99);

/*用户*/
insert into PURE_USER (USER_ID, USER_NAME, PASSWORD, LOGIN_ID, SEX, EMAIL, MOBILE, TELEPHONE, STATE, PWD_STATE, MEMO, REG_DATE, UPDATE_DATE)
   values (1, '管理员', 'bonc', 'admin',  1,null, '', '', 1, 1, '', null, null);


/*资源*/
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID) 
   values ('PURE','root',null,1, '系统资源', null,null, null, null, null, null, 1,'/root',1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID)
   values ('PURE','PURE_PORTAL','root', 1, '我的首页', '','/pure/PortalCustomize.action', '', '', '', '', 1,'/root/PURE_PORTAL',1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID)
   values ('PURE','PURE_PORTLET_POST','root', 6, '系统公告', '','/pure/portlet/Post.action', '', '', '', '', 6,'/root/PURE_PORTLET_POST',1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID)
   values ('PURE','PURE_SCSYS','root', 1, '安全管理', '','', '', '', '', '', 999,'/root/PURE_SCSYS',1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID)
   values ('PURE','PURE_USER','PURE_SCSYS', 1, '用户管理', '', '/pure/User.action', '','', '', '', 1,'/root/PURE_SCSYS/PURE_USER',1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID)
   values ('PURE','PURE_ROLE','PURE_SCSYS', 1, '角色管理', '', '/pure/Role.action','', '', '', '', 2,'/root/PURE_SCSYS/PURE_ROLE',1);

insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID)
   values ('PURE','PURE_RESOURCESGROUP','PURE_SCSYS', 1, '应用系统管理', '', '/pure/AppSystem.action', '','', '', '', 3,'/root/PURE_SCSYS/PURE_RESOURCESGROUP',1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID)
   values ('PURE','PURE_RESOURCES','PURE_SCSYS', 1, '系统资源管理', '', '/pure/Resources.action', '','', '', '', 4,'/root/PURE_SCSYS/PURE_RESOURCES',1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID)
   values ('PURE','PURE_USER_EXTCONF','PURE_SCSYS', 1, '用户扩展属性管理', '', '/pure/UserExtConf.action', '','', '', '', 5,'/root/PURE_SCSYS/PURE_USER_EXTCONF',1);
insert into PURE_RESOURCES (RESOURCES_ID, PARENT_ID, APP_SYSTEM_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, URL, EXT1, EXT2, EXT3, EXT4, MEMO, ORD,PATH,CREATER_ID)
   values ('PURE_POST', 'PURE_SCSYS', 'PURE', 1, '系统公告', '/pure/Post.action', '', '', '', '', '', 7,'/root/PURE_SCSYS/PURE_POST',1);

insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID)
   values ('PURE','PURE_ROLE_PERMISSION','PURE_SCSYS', 3, '角色授权', '','', '', '', '', '', 10,'/root/PURE_SCSYS/PURE_ROLE_PERMISSION',1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD,PATH,CREATER_ID)
  values ('PURE','PURE_USER_PERMISSION','PURE_SCSYS', 3, '用户授权', '','', '', '', '', '', 11,'/root/PURE_SCSYS/PURE_USER_PERMISSION',1);

/**日志管理**/
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID,RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_LOG','PURE_SCSYS','1','日志管理','','','0','','','','5','/root/PURE_SCSYS/PURE_LOG' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID,RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_LOGENTER','PURE_LOG','1','登录管理','','/pure/LogEnter.action','','','','','0','/root/PURE_SCSYS/PURE_LOG/PURE_LOGENTER' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID,RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_VISITORORD_LOG','PURE_LOG','1','模块访问者排名','','/pure/ModuleVisitorOrd.action','0','','','','3','/root/PURE_SCSYS/PURE_LOG' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID,RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_MODULE_VISIT_LOG','PURE_LOG','1','模块访问日志','','/pure/VisitLog.action','','','','','1','/root/PURE_SCSYS/PURE_LOG/PURE_VISITORORD_LOG' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID,RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_MODELORD_LOG','PURE_LOG','1','模块访问排名','','/pure/VisitModuleOrd.action','','','','','2','/root/PURE_SCSYS/PURE_LOG/PURE_MODELORD_LOG' ,1);

/**论坛菜单**/
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID,RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_LTJL','root','1','论坛交流','','','','','','','0','/root/PURE_LTJL' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID,RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_FORUM_INDEX','PURE_LTJL','1','交流首页','','/forum/Forum.action','','','','','1','/root/PURE_LTJL/PURE_FORUM_INDEX' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_FORUM_BOARD','PURE_LTJL','1','类别管理','','/forum/BoardType.action','','','','','2','/root/PURE_LTJL/PURE_FORUM_BOARD' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_FORUM_BOARD1','PURE_LTJL','1','版块管理','','/forum/Board.action','','','','','3','/root/PURE_LTJ/PURE_FORUM_BOARD1' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_FORUM_BOARD2','PURE_LTJL','1','版主管理','','/forum/BoardManager.action','','','','','4','/root/PURE_LTJL/PURE_FORUM_BOARD2' ,1);

/*测试菜单*/
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_TEST','root', 1, '测试菜单', '','', '', '', '', '', 99,'/root/PURE_TEST' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_TEST_TAB','PURE_TEST', 1, 'tab测试菜单', '','/pure/proxy/TabPage.action', '', '', '', '', 1,'/root/PURE_TEST/PURE_TEST_TAB' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_TEST_TAB_1','PURE_TEST_TAB', 2, 'bing', '','http://www.bing.com', '', '', '', '', 1,'/root/PURE_TEST/PURE_TEST_TAB/PURE_TEST_TAB_1' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_TEST_TAB_2','PURE_TEST_TAB', 2, 'baidu', '','http://www.baidu.com', '', '', '', '', 2,'/root/PURE_TEST/PURE_TEST_TAB/PURE_TEST_TAB_2' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_TEST_TAB_3','PURE_TEST_TAB', 2, 'sogou', '','http://www.sogou.cn', '', '', '', '', 3,'/root/PURE_TEST/PURE_TEST_TAB/PURE_TEST_TAB_3' ,1);
insert into PURE_RESOURCES (APP_SYSTEM_ID,RESOURCES_ID,PARENT_ID, RESOURCES_TYPE_ID, RESOURCES_NAME, MEMO,URL, EXT1, EXT2, EXT3, EXT4, ORD, PATH, CREATER_ID)
  values ('PURE','PURE_TEST_TAB_4','PURE_TEST_TAB', 2, '163', '','http://www.163.com', '', '', '', '', 4,'/root/PURE_TEST/PURE_TEST_TAB/PURE_TEST_TAB_4' ,1);

/*操作类型*/
insert into PURE_OPT_TYPE   values('READ','查看',1);
insert into PURE_OPT_TYPE   values('CREATE','创建',2);
insert into PURE_OPT_TYPE   values('UPDATE','更新',3);
insert into PURE_OPT_TYPE   values('DELETE','删除',4);
insert into PURE_OPT_TYPE   values('AUTH','可授权',5);

/*资源与操作类型关系  id使用序列生成，可以注释语句*/
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (2, 'root', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (3, 'PURE_PORTAL', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (4, 'PURE_PORTLET_POST', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (5, 'PURE_SCSYS', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (6, 'PURE_USER', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (7, 'PURE_ROLE', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (8, 'PURE_RESOURCESGROUP', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (9, 'PURE_RESOURCES', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (10, 'PURE_USER_EXTCONF', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (11, 'PURE_POST', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (12, 'PURE_ROLE_PERMISSION', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (13, 'PURE_USER_PERMISSION', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (14, 'PURE_LOG', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (15, 'PURE_LOGENTER', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (16, 'PURE_VISITORORD_LOG', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (17, 'PURE_MODULE_VISIT_LOG', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (18, 'PURE_MODELORD_LOG', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (19, 'PURE_LTJL', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (20, 'PURE_FORUM_INDEX', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (21, 'PURE_FORUM_BOARD', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (22, 'PURE_FORUM_BOARD1', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (23, 'PURE_FORUM_BOARD2', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (24, 'PURE_TEST', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (25, 'PURE_TEST_TAB', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (26, 'PURE_TEST_TAB_1', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (27, 'PURE_TEST_TAB_2', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (28, 'PURE_TEST_TAB_3', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (29, 'PURE_TEST_TAB_4', 'READ');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (30, 'root', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (31, 'PURE_PORTAL', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (32, 'PURE_PORTLET_POST', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (33, 'PURE_SCSYS', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (34, 'PURE_USER', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (35, 'PURE_ROLE', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (36, 'PURE_RESOURCESGROUP', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (37, 'PURE_RESOURCES', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (38, 'PURE_USER_EXTCONF', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (39, 'PURE_POST', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (40, 'PURE_ROLE_PERMISSION', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (41, 'PURE_USER_PERMISSION', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (42, 'PURE_LOG', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (43, 'PURE_LOGENTER', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (44, 'PURE_VISITORORD_LOG', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (45, 'PURE_MODULE_VISIT_LOG', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (46, 'PURE_MODELORD_LOG', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (47, 'PURE_LTJL', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (48, 'PURE_FORUM_INDEX', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (49, 'PURE_FORUM_BOARD', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (50, 'PURE_FORUM_BOARD1', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (51, 'PURE_FORUM_BOARD2', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (52, 'PURE_TEST', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (53, 'PURE_TEST_TAB', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (54, 'PURE_TEST_TAB_1', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (55, 'PURE_TEST_TAB_2', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (56, 'PURE_TEST_TAB_3', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (57, 'PURE_TEST_TAB_4', 'CREATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (58, 'root', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (59, 'PURE_PORTAL', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (60, 'PURE_PORTLET_POST', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (61, 'PURE_SCSYS', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (62, 'PURE_USER', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (63, 'PURE_ROLE', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (64, 'PURE_RESOURCESGROUP', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (65, 'PURE_RESOURCES', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (66, 'PURE_USER_EXTCONF', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (67, 'PURE_POST', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (68, 'PURE_ROLE_PERMISSION', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (69, 'PURE_USER_PERMISSION', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (70, 'PURE_LOG', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (71, 'PURE_LOGENTER', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (72, 'PURE_VISITORORD_LOG', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (73, 'PURE_MODULE_VISIT_LOG', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (74, 'PURE_MODELORD_LOG', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (75, 'PURE_LTJL', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (76, 'PURE_FORUM_INDEX', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (77, 'PURE_FORUM_BOARD', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (78, 'PURE_FORUM_BOARD1', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (79, 'PURE_FORUM_BOARD2', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (80, 'PURE_TEST', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (81, 'PURE_TEST_TAB', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (82, 'PURE_TEST_TAB_1', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (83, 'PURE_TEST_TAB_2', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (84, 'PURE_TEST_TAB_3', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (85, 'PURE_TEST_TAB_4', 'UPDATE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (86, 'root', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (87, 'PURE_PORTAL', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (88, 'PURE_PORTLET_POST', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (89, 'PURE_SCSYS', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (90, 'PURE_USER', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (91, 'PURE_ROLE', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (92, 'PURE_RESOURCESGROUP', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (93, 'PURE_RESOURCES', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (94, 'PURE_USER_EXTCONF', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (95, 'PURE_POST', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (96, 'PURE_ROLE_PERMISSION', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (97, 'PURE_USER_PERMISSION', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (98, 'PURE_LOG', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (99, 'PURE_LOGENTER', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (100, 'PURE_VISITORORD_LOG', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (101, 'PURE_MODULE_VISIT_LOG', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (102, 'PURE_MODELORD_LOG', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (103, 'PURE_LTJL', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (104, 'PURE_FORUM_INDEX', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (105, 'PURE_FORUM_BOARD', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (106, 'PURE_FORUM_BOARD1', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (107, 'PURE_FORUM_BOARD2', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (108, 'PURE_TEST', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (109, 'PURE_TEST_TAB', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (110, 'PURE_TEST_TAB_1', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (111, 'PURE_TEST_TAB_2', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (112, 'PURE_TEST_TAB_3', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (113, 'PURE_TEST_TAB_4', 'DELETE');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (114, 'root', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (115, 'PURE_PORTAL', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (116, 'PURE_PORTLET_POST', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (117, 'PURE_SCSYS', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (118, 'PURE_USER', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (119, 'PURE_ROLE', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (120, 'PURE_RESOURCESGROUP', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (121, 'PURE_RESOURCES', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (122, 'PURE_USER_EXTCONF', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (123, 'PURE_POST', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (124, 'PURE_ROLE_PERMISSION', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (125, 'PURE_USER_PERMISSION', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (126, 'PURE_LOG', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (127, 'PURE_LOGENTER', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (128, 'PURE_VISITORORD_LOG', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (129, 'PURE_MODULE_VISIT_LOG', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (130, 'PURE_MODELORD_LOG', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (131, 'PURE_LTJL', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (132, 'PURE_FORUM_INDEX', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (133, 'PURE_FORUM_BOARD', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (134, 'PURE_FORUM_BOARD1', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (135, 'PURE_FORUM_BOARD2', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (136, 'PURE_TEST', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (137, 'PURE_TEST_TAB', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (138, 'PURE_TEST_TAB_1', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (139, 'PURE_TEST_TAB_2', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (140, 'PURE_TEST_TAB_3', 'AUTH');
insert into pure_resources_opt_rel (ID, RESOURCES_ID, OPT_TYPE)   values (141, 'PURE_TEST_TAB_4', 'AUTH');

------------------------------------------


/*角色*/
insert into PURE_ROLE (ROLE_ID,ROLE_NAME, MEMO, ORD)
  values ('root','管理员', '', 1);


/*角色权限*/
insert into PURE_USER_ROLE (ROLE_ID,USER_ID)
  values ('root', 1);


/*角色授权*/
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (1, 'root', 'PURE_FORUM_BOARD', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (2, 'root', 'PURE_FORUM_BOARD1', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (3, 'root', 'PURE_FORUM_BOARD2', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (4, 'root', 'PURE_FORUM_INDEX', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (5, 'root', 'PURE_LOG', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (6, 'root', 'PURE_LOGENTER', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (7, 'root', 'PURE_LTJL', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (8, 'root', 'PURE_MODELORD_LOG', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (9, 'root', 'PURE_MODULE_VISIT_LOG', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (10, 'root', 'PURE_PORTAL', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (11, 'root', 'PURE_PORTLET_POST', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (12, 'root', 'PURE_POST', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (13, 'root', 'PURE_RESOURCES', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (14, 'root', 'PURE_RESOURCESGROUP', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (15, 'root', 'PURE_ROLE', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (16, 'root', 'PURE_ROLE_PERMISSION', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (17, 'root', 'PURE_SCSYS', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (18, 'root', 'PURE_TEST', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (19, 'root', 'PURE_TEST_TAB', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (20, 'root', 'PURE_TEST_TAB_1', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (21, 'root', 'PURE_TEST_TAB_2', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (22, 'root', 'PURE_TEST_TAB_3', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (23, 'root', 'PURE_TEST_TAB_4', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (24, 'root', 'PURE_USER', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (25, 'root', 'PURE_USER_EXTCONF', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (26, 'root', 'PURE_USER_PERMISSION', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (27, 'root', 'PURE_VISITORORD_LOG', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (28, 'root', 'root', 'READ');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (29, 'root', 'PURE_FORUM_BOARD', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (30, 'root', 'PURE_FORUM_BOARD1', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (31, 'root', 'PURE_FORUM_BOARD2', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (32, 'root', 'PURE_FORUM_INDEX', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (33, 'root', 'PURE_LOG', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (34, 'root', 'PURE_LOGENTER', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (35, 'root', 'PURE_LTJL', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (36, 'root', 'PURE_MODELORD_LOG', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (37, 'root', 'PURE_MODULE_VISIT_LOG', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (38, 'root', 'PURE_PORTAL', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (39, 'root', 'PURE_PORTLET_POST', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (40, 'root', 'PURE_POST', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (41, 'root', 'PURE_RESOURCES', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (42, 'root', 'PURE_RESOURCESGROUP', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (43, 'root', 'PURE_ROLE', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (44, 'root', 'PURE_ROLE_PERMISSION', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (45, 'root', 'PURE_SCSYS', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (46, 'root', 'PURE_TEST', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (47, 'root', 'PURE_TEST_TAB', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (48, 'root', 'PURE_TEST_TAB_1', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (49, 'root', 'PURE_TEST_TAB_2', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (50, 'root', 'PURE_TEST_TAB_3', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (51, 'root', 'PURE_TEST_TAB_4', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (52, 'root', 'PURE_USER', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (53, 'root', 'PURE_USER_EXTCONF', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (54, 'root', 'PURE_USER_PERMISSION', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (55, 'root', 'PURE_VISITORORD_LOG', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (56, 'root', 'root', 'CREATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (57, 'root', 'PURE_FORUM_BOARD', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (58, 'root', 'PURE_FORUM_BOARD1', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (59, 'root', 'PURE_FORUM_BOARD2', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (60, 'root', 'PURE_FORUM_INDEX', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (61, 'root', 'PURE_LOG', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (62, 'root', 'PURE_LOGENTER', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (63, 'root', 'PURE_LTJL', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (64, 'root', 'PURE_MODELORD_LOG', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (65, 'root', 'PURE_MODULE_VISIT_LOG', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (66, 'root', 'PURE_PORTAL', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (67, 'root', 'PURE_PORTLET_POST', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (68, 'root', 'PURE_POST', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (69, 'root', 'PURE_RESOURCES', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (70, 'root', 'PURE_RESOURCESGROUP', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (71, 'root', 'PURE_ROLE', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (72, 'root', 'PURE_ROLE_PERMISSION', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (73, 'root', 'PURE_SCSYS', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (74, 'root', 'PURE_TEST', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (75, 'root', 'PURE_TEST_TAB', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (76, 'root', 'PURE_TEST_TAB_1', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (77, 'root', 'PURE_TEST_TAB_2', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (78, 'root', 'PURE_TEST_TAB_3', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (79, 'root', 'PURE_TEST_TAB_4', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (80, 'root', 'PURE_USER', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (81, 'root', 'PURE_USER_EXTCONF', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (82, 'root', 'PURE_USER_PERMISSION', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (83, 'root', 'PURE_VISITORORD_LOG', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (84, 'root', 'root', 'UPDATE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (85, 'root', 'PURE_FORUM_BOARD', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (86, 'root', 'PURE_FORUM_BOARD1', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (87, 'root', 'PURE_FORUM_BOARD2', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (88, 'root', 'PURE_FORUM_INDEX', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (89, 'root', 'PURE_LOG', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (90, 'root', 'PURE_LOGENTER', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (91, 'root', 'PURE_LTJL', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (92, 'root', 'PURE_MODELORD_LOG', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (93, 'root', 'PURE_MODULE_VISIT_LOG', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (94, 'root', 'PURE_PORTAL', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (95, 'root', 'PURE_PORTLET_POST', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (96, 'root', 'PURE_POST', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (97, 'root', 'PURE_RESOURCES', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (98, 'root', 'PURE_RESOURCESGROUP', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (99, 'root', 'PURE_ROLE', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (100, 'root', 'PURE_ROLE_PERMISSION', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (101, 'root', 'PURE_SCSYS', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (102, 'root', 'PURE_TEST', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (103, 'root', 'PURE_TEST_TAB', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (104, 'root', 'PURE_TEST_TAB_1', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (105, 'root', 'PURE_TEST_TAB_2', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (106, 'root', 'PURE_TEST_TAB_3', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (107, 'root', 'PURE_TEST_TAB_4', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (108, 'root', 'PURE_USER', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (109, 'root', 'PURE_USER_EXTCONF', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (110, 'root', 'PURE_USER_PERMISSION', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (111, 'root', 'PURE_VISITORORD_LOG', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (112, 'root', 'root', 'DELETE');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (113, 'root', 'PURE_FORUM_BOARD', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (114, 'root', 'PURE_FORUM_BOARD1', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (115, 'root', 'PURE_FORUM_BOARD2', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (116, 'root', 'PURE_FORUM_INDEX', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (117, 'root', 'PURE_LOG', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (118, 'root', 'PURE_LOGENTER', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (119, 'root', 'PURE_LTJL', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (120, 'root', 'PURE_MODELORD_LOG', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (121, 'root', 'PURE_MODULE_VISIT_LOG', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (122, 'root', 'PURE_PORTAL', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (123, 'root', 'PURE_PORTLET_POST', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (124, 'root', 'PURE_POST', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (125, 'root', 'PURE_RESOURCES', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (126, 'root', 'PURE_RESOURCESGROUP', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (127, 'root', 'PURE_ROLE', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (128, 'root', 'PURE_ROLE_PERMISSION', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (129, 'root', 'PURE_SCSYS', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (130, 'root', 'PURE_TEST', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (131, 'root', 'PURE_TEST_TAB', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (132, 'root', 'PURE_TEST_TAB_1', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (133, 'root', 'PURE_TEST_TAB_2', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (134, 'root', 'PURE_TEST_TAB_3', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (135, 'root', 'PURE_TEST_TAB_4', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (136, 'root', 'PURE_USER', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (137, 'root', 'PURE_USER_EXTCONF', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (138, 'root', 'PURE_USER_PERMISSION', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (139, 'root', 'PURE_VISITORORD_LOG', 'AUTH');
insert into PURE_ROLE_AUTH (ID, ROLE_ID, RESOURCES_ID, OPT_TYPE)   values (140, 'root', 'root', 'AUTH');


/*组织机构*/
insert into PURE_ORG (ORG_ID, ORG_NAME, PARENT_ID, PATH, ORD) values ('root', '全国', null, '/root', 1);
insert into PURE_ORG (ORG_ID, ORG_NAME, PARENT_ID, PATH, ORD) values ('1', '北京', 'root', '/root/1', 2);
insert into PURE_ORG (ORG_ID, ORG_NAME, PARENT_ID, PATH, ORD) values ('2', '上海', 'root', '/root/2', 3);
insert into PURE_ORG (ORG_ID, ORG_NAME, PARENT_ID, PATH, ORD) values ('3', '内蒙', 'root', '/root/3', 4);

