DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage`
(
    `id`         bigint NOT NULL AUTO_INCREMENT,
    `product_id` bigint NULL DEFAULT NULL COMMENT '产品id',
    `total`      int    NULL DEFAULT NULL COMMENT '总库存',
    `used`       int    NULL DEFAULT NULL COMMENT '已用库存',
    `residue`    int    NULL DEFAULT NULL COMMENT '剩余库存',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storage
-- ----------------------------
INSERT INTO `storage`
VALUES (1, 1, 100, 0, 100);

SET FOREIGN_KEY_CHECKS = 1;
