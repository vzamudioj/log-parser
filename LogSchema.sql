DROP DATABASE IF EXISTS logs;
CREATE DATABASE logs;
use logs;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;


--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `ipAddress` varchar(255) DEFAULT NULL,
  `httpMethod` varchar(255) DEFAULT NULL,
  `response` varchar(255) DEFAULT NULL,
  `httpClient` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=349460 DEFAULT CHARSET=latin1;