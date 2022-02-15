-- Adminer 4.7.7 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `auction`;
CREATE TABLE `auction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_at` datetime(6) NOT NULL,
  `title` varchar(225) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `active` tinyint(1) NOT NULL,
  `count_comment` int NOT NULL,
  `base_price` double NOT NULL,
  `condition_content` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `deadline` datetime(6) NOT NULL,
  `date_success` datetime(6) DEFAULT NULL,
  `accept_price` double DEFAULT NULL,
  `current_price` double DEFAULT NULL,
  `status_auction` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `buyer_id` bigint DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `payment_method_id` bigint DEFAULT NULL,
  `rating` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `social_network_aucti_category_id_0a50e334_fk_social_ne` (`category_id`),
  KEY `social_network_aucti_user_id_f42c1fd2_fk_social_ne` (`user_id`),
  KEY `social_network_aucti_buyer_id_a53a418c_fk_social_ne` (`buyer_id`),
  KEY `social_network_aucti_payment_method_id_493cdb5c_fk_social_ne` (`payment_method_id`),
  CONSTRAINT `social_network_auction_ibfk_1` FOREIGN KEY (`buyer_id`) REFERENCES `social_network_user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `social_network_auction_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `social_network_user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `social_network_auction_ibfk_3` FOREIGN KEY (`payment_method_id`) REFERENCES `social_network_paymentmethod` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `social_network_auction_ibfk_4` FOREIGN KEY (`category_id`) REFERENCES `social_network_categoryauction` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `auctioncomment`;
CREATE TABLE `auctioncomment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `create_at` datetime(6) DEFAULT NULL,
  `price` double NOT NULL,
  `status_transaction` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `auction_id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `social_network_aucti_auction_id_33992e6a_fk_social_ne` (`auction_id`),
  KEY `social_network_aucti_user_id_4c77bfc6_fk_social_ne` (`user_id`),
  CONSTRAINT `social_network_aucti_auction_id_33992e6a_fk_social_ne` FOREIGN KEY (`auction_id`) REFERENCES `social_network_auction` (`id`),
  CONSTRAINT `social_network_aucti_user_id_4c77bfc6_fk_social_ne` FOREIGN KEY (`user_id`) REFERENCES `social_network_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `auctionimage`;
CREATE TABLE `auctionimage` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `auction_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `social_network_aucti_auction_id_8dc02dc6_fk_social_ne` (`auction_id`),
  CONSTRAINT `social_network_auctionimage_ibfk_1` FOREIGN KEY (`auction_id`) REFERENCES `social_network_auction` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `categoryauction`;
CREATE TABLE `categoryauction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `hashtagpost`;
CREATE TABLE `hashtagpost` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` longtext COLLATE utf8_unicode_ci NOT NULL,
  `create_at` datetime NOT NULL,
  `from` bigint DEFAULT NULL,
  `to` bigint NOT NULL,
  `auction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `from` (`from`),
  KEY `to` (`to`),
  KEY `auction_id` (`auction_id`),
  CONSTRAINT `social_network_message_ibfk_1` FOREIGN KEY (`from`) REFERENCES `social_network_user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `social_network_message_ibfk_2` FOREIGN KEY (`to`) REFERENCES `social_network_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `social_network_message_ibfk_4` FOREIGN KEY (`auction_id`) REFERENCES `social_network_auction` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `url` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_at` datetime NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `seen` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `social_network_notification_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `social_network_user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `paymentmethod`;
CREATE TABLE `paymentmethod` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `create_at` datetime(6) DEFAULT NULL,
  `count_comment` int NOT NULL,
  `active` tinyint(1) NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `social_network_post_user_id_f9469041_fk_social_network_user_id` (`user_id`),
  CONSTRAINT `social_network_post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `social_network_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `post_hashtag`;
CREATE TABLE `post_hashtag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `post_id` bigint NOT NULL,
  `hashtagpost_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `social_network_post_hashtag_post_id_hashtagpost_id_05fd050d_uniq` (`post_id`,`hashtagpost_id`),
  KEY `social_network_post__hashtagpost_id_f50a0780_fk_social_ne` (`hashtagpost_id`),
  CONSTRAINT `social_network_post_hashtag_ibfk_1` FOREIGN KEY (`hashtagpost_id`) REFERENCES `social_network_hashtagpost` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `social_network_post_hashtag_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `social_network_post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `post_like`;
CREATE TABLE `post_like` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `post_id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `social_network_post_like_post_id_user_id_5b8e345c_uniq` (`post_id`,`user_id`),
  KEY `social_network_post__user_id_cfdec8bd_fk_social_ne` (`user_id`),
  CONSTRAINT `social_network_post_like_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `social_network_post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `social_network_post_like_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `social_network_user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `post_comment`;
CREATE TABLE `post_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `create_at` datetime(6) DEFAULT NULL,
  `post_id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `social_network_postc_post_id_1d20aba3_fk_social_ne` (`post_id`),
  KEY `social_network_postc_user_id_08033e89_fk_social_ne` (`user_id`),
  CONSTRAINT `social_network_postcomment_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `social_network_post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `social_network_postcomment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `social_network_user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `post_image`;
CREATE TABLE `post_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `social_network_posti_post_id_d6826d11_fk_social_ne` (`post_id`),
  CONSTRAINT `social_network_postimage_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `social_network_post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `rating`;
CREATE TABLE `rating` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `star` int NOT NULL,
  `create_at` datetime NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `auction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `auction` (`auction_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `social_network_rating_ibfk_1` FOREIGN KEY (`auction_id`) REFERENCES `social_network_auction` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `social_network_rating_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `social_network_user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `typereport_id` bigint NOT NULL,
  `create_at` datetime NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `user_report` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_report` (`user_report`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `social_network_report_ibfk_1` FOREIGN KEY (`user_report`) REFERENCES `social_network_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `social_network_report_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `social_network_user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `typereport`;
CREATE TABLE `typereport` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_role` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'ROLE_USER',
  `username` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(254) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `rating` int DEFAULT '5',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- 2022-01-04 07:37:27
