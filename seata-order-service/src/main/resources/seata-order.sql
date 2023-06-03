SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `id`         bigint         NOT NULL AUTO_INCREMENT,
    `user_id`    bigint         NULL DEFAULT NULL COMMENT '用户id',
    `product_id` bigint         NULL DEFAULT NULL COMMENT '产品id',
    `count`      int            NULL DEFAULT NULL COMMENT '数量',
    `money`      decimal(11, 0) NULL DEFAULT NULL COMMENT '金额',
    `status`     int            NULL DEFAULT NULL COMMENT '订单状态：0：创建中；1：已完结',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
