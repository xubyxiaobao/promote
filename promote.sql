CREATE database promote;

CREATE TABLE `promote_user` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name`	VARCHAR(64) not null comment '姓名'
);

CREATE TABLE `promote_task_template`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP '修改时间',
	`create_user` INT NOT NULL,
	`accept_user` INT ,
	`interval_unit` VARCHAR(10) NOT NULL COMMENT '间隔时间单位：DAY/WEEK/MONTH',
	`times`	TINY_INT NOT NULL COMMENT '次数',
	`status` TINY_INT NOT NULL COMMENT '已发布(1)/已认领(2)/撤销(3)',
	`accept_time` DATETIME COMMNET '认领时间',
	`score` INT NOT NULL COMMENT '任务积分',
	`description` VARCHAR(512) NOT NULL '任务描述'
);

CREATE TABLE `promote_task_detail`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP '修改时间',
	`start_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
	`end_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP '结束时间',
	`task_id` INT NOT NULL COMMENT '任务模板ID',
	`create_user` INT NOT NULL,
	`accept_user` INT NOT NULL,
	`status` TINY_INT NOT NULL COMMENT '执行状态：未开始(1)/已完成(2)/未完成(3)',
	`score` INT NOT NULL COMMENT '任务积分'
);

CREATE TABLE `promote_score` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP '修改时间',
	`user_id` INT NOT NULL ,
	`score`	INT NOT NULL,
)

CREATE TABLE `promote_score_detail`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP '修改时间',
	`user_id`	INT NOT NULL,
	`score_type` INT NOT NULL comment '积分变动类型：兑换(1)/任务(2)',
	`relate_id`	INT NOT NULL comment 'score_type=2，relate_id=task_detail_id;score_type=1,relate_id=商品Id',
	`score`	INT NOT NULL comment '积分变动差值，+增加，-减少'
)

CREATE TABLE `promote_product`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP '修改时间',
	`name` VARCHAR(128) NOT NULL COMMENT '商品名称',
	`score` INT NOT NULL COMMENT '价值多少积分',
	`create_user` INT NOT NULL COMMENT '创建者'
)

