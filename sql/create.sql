#库存表
CREATE TABLE `tb_inventory` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `total` int(11) NOT NULL COMMENT '库存总数',
      `remain_stock` int(11) NOT NULL COMMENT '剩余库存',
      `product_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '产品名称',
      `create_time` datetime DEFAULT NULL COMMENT '创建时间',
      `update_time` datetime DEFAULT NULL COMMENT '更新时间',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;