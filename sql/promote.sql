CREATE database promote;

create table `promote_user`(
  `id`         bigint not null auto_increment,
  `username`  varchar(100) not null,
  `email`  varchar(100) not null,
  `mobile_phone_number`  varchar(20) not null,
  `password`  varchar(100) not null,
  `salt`       varchar(10) ,
  `create_date` timestamp not null default CURRENT_TIMESTAMP,
  `status`    varchar(50),
  `deleted`   bool,
  `admin`     bool,
  constraint `pk_sys_user` primary key(`id`),
  constraint `unique_promote_user_username` unique(`username`),
  constraint `unique_promote_user_email` unique(`email`),
  constraint `unique_promote_user_mobile_phone_number` unique(`mobile_phone_number`),
  index `idx_sys_user_status` (`status`)
) charset=utf8 ENGINE=InnoDB;
alter table `promote_user` auto_increment=1000;

create table `promote_resource`(
  `id`         bigint not null auto_increment,
  `name`      varchar(100) not null ,
  `identity`  varchar(100) not null,
  `url`      varchar(200) not null,
  `parent_id` bigint ,
  `parent_ids`  varchar(200) default '',
  `is_show`       bool,
  constraint `pk_sys_resource` primary key(`id`),
  index `idx_promote_resource_name` (`name`),
  index `idx_promote_resource_identity` (`identity`),
  index `idx_promote_resource_user` (`url`),
  index `idx_promote_resource_parent_id` (`parent_id`)
) charset=utf8 ENGINE=InnoDB;
alter table `promote_resource` auto_increment=1000;;

create table `promote_permission`(
  `id`         bigint not null auto_increment,
  `name`      varchar(100),
  `permission`  varchar(100),
  `description`      varchar(200),
  `is_show`       bool,
  constraint `pk_sys_permission` primary key(`id`),
  index idx_promote_permission_name (`name`),
  index idx_promote_permission_permission (`permission`),
  index idx_promote_permission_show (`is_show`)
) charset=utf8 ENGINE=InnoDB;;
alter table `promote_permission` auto_increment=1000;;

create table `promote_role`(
  `id`         bigint not null auto_increment,
  `name`      varchar(100),
  `role`  varchar(100),
  `description`      varchar(200),
  `is_show`       bool,
  constraint `pk_promote_role` primary key(`id`),
  index `idx_promote_role_name` (`name`),
  index `idx_promote_role_role` (`role`),
  index `idx_promote_role_show` (`is_show`)
) charset=utf8 ENGINE=InnoDB;;
alter table `promote_role` auto_increment=1000;;


create table `promote_role_resource_permission`(
  `id`         bigint not null auto_increment,
  `role_id`   bigint,
  `resource_id` bigint,
  `permission_ids` varchar(500),
  constraint `pk_promote_role_resource_permission` primary key(`id`),
  constraint `unique_promote_role_resource_permission` unique(`role_id`, `resource_id`)
) charset=utf8 ENGINE=InnoDB;;
alter table `promote_role_resource_permission` auto_increment=1000;;

















CREATE TABLE `promote_task_template`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`create_user` INT NOT NULL,
	`accept_user` INT ,
	`interval_unit` VARCHAR(10) NOT NULL COMMENT '间隔时间单位：DAY/WEEK/MONTH',
	`times`	TINYINT NOT NULL COMMENT '次数',
	`status` TINYINT NOT NULL COMMENT '已发布(1)/已认领(2)/撤销(3)',
	`accept_time` DATETIME COMMENT '认领时间',
	`score` INT NOT NULL COMMENT '任务积分',
	`description` VARCHAR(512) NOT NULL COMMENT '任务描述'
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `promote_task_detail`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`start_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
	`end_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
	`task_id` INT NOT NULL COMMENT '任务模板ID',
	`create_user` INT NOT NULL,
	`accept_user` INT NOT NULL,
	`status` TINYINT NOT NULL COMMENT '执行状态：未开始(1)/已完成(2)/未完成(3)',
	`score` INT NOT NULL COMMENT '任务积分'
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `promote_score` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`user_id` INT NOT NULL ,
	`score`	INT NOT NULL
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `promote_score_detail`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`user_id`	INT NOT NULL,
	`score_type` INT NOT NULL COMMENT '积分变动类型：兑换(1)/任务(2)',
	`relate_id`	INT NOT NULL COMMENT 'score_type=2，relate_id=task_detail_id;score_type=1,relate_id=商品Id',
	`score`	INT NOT NULL COMMENT '积分变动差值，+增加，-减少'
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `promote_product`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`name` VARCHAR(128) NOT NULL COMMENT '商品名称',
	`score` INT NOT NULL COMMENT '价值多少积分',
	`create_user` INT NOT NULL COMMENT '创建者'
)ENGINE = InnoDB DEFAULT CHARSET=utf8;
