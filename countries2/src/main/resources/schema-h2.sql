DROP TABLE IF EXISTS `cities`;
DROP TABLE IF EXISTS `states`;
DROP TABLE IF EXISTS `countries`;

CREATE TABLE `countries` (
     `id` mediumint NOT NULL AUTO_INCREMENT,
     `name` varchar(100) NOT NULL,
     `iso3` char(3) DEFAULT NULL,
     `numeric_code` char(3)  DEFAULT NULL,
     `iso2` char(2)  DEFAULT NULL,
     `phonecode` varchar(255) DEFAULT NULL,
     `capital` varchar(255) DEFAULT NULL,
     `currency` varchar(255) DEFAULT NULL,
     `currency_name` varchar(255) DEFAULT NULL,
     `currency_symbol` varchar(255) DEFAULT NULL,
     `tld` varchar(255) NULL,
     `native` varchar(255) NULL,
     `region` varchar(255) NULL,
     `subregion` varchar(255) DEFAULT NULL,
     `timezones` text ,
     `translations` text,
     `latitude` decimal(10,8) DEFAULT NULL,
     `longitude` decimal(11,8) DEFAULT NULL,
     `emoji` varchar(191),
     `emojiU` varchar(191),
     `created_at` timestamp,
     `updated_at` timestamp NOT NULL,
     `flag` int NOT NULL,
     `wikiDataId` varchar(255),
     PRIMARY KEY (`id`)
);

CREATE TABLE `states` (
      `id` mediumint NOT NULL AUTO_INCREMENT,
      `name` varchar(255) NOT NULL,
      `country_id` mediumint NOT NULL,
      `country_code` char(2) NOT NULL,
      `fips_code` varchar(255) DEFAULT NULL,
      `iso2` varchar(255) DEFAULT NULL,
      `type` varchar(191) DEFAULT NULL,
      `latitude` decimal(10,8) DEFAULT NULL,
      `longitude` decimal(11,8) DEFAULT NULL,
      `created_at` timestamp NULL DEFAULT NULL,
      `updated_at` timestamp NOT NULL ,
      `flag` int NOT NULL DEFAULT '1',
      `wikiDataId` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`),
      foreign key (`country_id`) references `countries`(`id`));

CREATE TABLE `cities` (
      `id` mediumint NOT NULL AUTO_INCREMENT,
      `name` varchar(255) NOT NULL,
      `state_id` mediumint NOT NULL,
      `state_code` varchar(255) NOT NULL,
      `country_id` mediumint NOT NULL,
      `country_code` char(2) NOT NULL,
      `latitude` decimal(10,8) NOT NULL,
      `longitude` decimal(11,8) NOT NULL,
      `created_at` timestamp NOT NULL,
      `updated_at` timestamp NOT NULL,
      `flag` int NOT NULL DEFAULT '1',
      `wikiDataId` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`));