CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '科目ID',
  `name` varchar(50) NOT NULL COMMENT '科目名称',
  `is_custom` tinyint NOT NULL DEFAULT '0' COMMENT '是否自定义科目（0：否，1：是）',
  `family_id` varchar(32) DEFAULT NULL COMMENT '所属家庭ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='科目字典表'; 