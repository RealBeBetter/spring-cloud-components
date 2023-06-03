SET NAMES utf8mb4;
SET
    FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id`      bigint         NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` bigint         NULL DEFAULT NULL COMMENT '用户id',
    `total`   decimal(10, 0) NULL DEFAULT NULL COMMENT '总额度',
    `used`    decimal(10, 0) NULL DEFAULT NULL COMMENT '已用余额',
    `residue` decimal(10, 0) NULL DEFAULT 0 COMMENT '剩余可用额度',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account`
VALUES (1, 1, 1000, 0, 1000);

SET
    FOREIGN_KEY_CHECKS = 1;
