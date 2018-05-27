-- MySQL dump 10.16  Distrib 10.1.17-MariaDB, for osx10.11 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	10.1.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `BOOK`
--

DROP TABLE IF EXISTS `BOOK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BOOK` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `author` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BOOK`
--

LOCK TABLES `BOOK` WRITE;
/*!40000 ALTER TABLE `BOOK` DISABLE KEYS */;
INSERT INTO `BOOK` VALUES (1,'kukareku','kakaka');
INSERT INTO `BOOK` VALUES (2,'The Sea Wolf','Jack London');
INSERT INTO `BOOK` VALUES (3,'War and Peace','Leo Tolstoy');
INSERT INTO `BOOK` VALUES (5,'TheOldMan and theSea','Ernest Hemingway');
INSERT INTO `BOOK` VALUES (6,'Eugenii Onegin','Alex Pushkin');
INSERT INTO `BOOK` VALUES (10,'Red Hat','Pierro Sharle');
INSERT INTO `BOOK` VALUES (14,'Red Hat','Pierro Sharle');
INSERT INTO `BOOK` VALUES (15,'Red Hat 2','Pierro Sharle');
INSERT INTO `BOOK` VALUES (16,'Red Hat 3','Pierro Sharle');
INSERT INTO `BOOK` VALUES (19,'Red Hat 4','Charles Perrault');
INSERT INTO `BOOK` VALUES (20,'Spring Hibernate','Spring');
INSERT INTO `BOOK` VALUES (28,'Thinking In Java','Bruce Eckel 2');
/*!40000 ALTER TABLE `BOOK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LIBUSER`
--

DROP TABLE IF EXISTS `LIBUSER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LIBUSER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LIBUSER`
--

LOCK TABLES `LIBUSER` WRITE;
/*!40000 ALTER TABLE `LIBUSER` DISABLE KEYS */;
INSERT INTO `LIBUSER` VALUES (7,'Andrew','Tverdokhleb');
INSERT INTO `LIBUSER` VALUES (8,'Sara','Ali');
INSERT INTO `LIBUSER` VALUES (9,'Arnold','Schwarzenegger');
INSERT INTO `LIBUSER` VALUES (10,'John','Paul');
INSERT INTO `LIBUSER` VALUES (11,'Donald','Tramp');
INSERT INTO `LIBUSER` VALUES (12,'Bruce','Eckel');
INSERT INTO `LIBUSER` VALUES (13,'Kris','Norman');
INSERT INTO `LIBUSER` VALUES (14,'Kris','Norman');
INSERT INTO `LIBUSER` VALUES (20,'Sylvester','Stallone');
INSERT INTO `LIBUSER` VALUES (21,'Brad','Pitt');
INSERT INTO `LIBUSER` VALUES (25,'Angelina','Joly');
INSERT INTO `LIBUSER` VALUES (29,'July','Agency');
/*!40000 ALTER TABLE `LIBUSER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_out` date NOT NULL,
  `date_in` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`user_id`),
  KEY `bookid` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

LOCK TABLES `Orders` WRITE;
/*!40000 ALTER TABLE `Orders` DISABLE KEYS */;
INSERT INTO `Orders` VALUES (1,'2017-12-08','2017-12-08',7,2);
INSERT INTO `Orders` VALUES (4,'2017-12-08',NULL,8,3);
INSERT INTO `Orders` VALUES (5,'2017-12-08',NULL,10,2);
INSERT INTO `Orders` VALUES (7,'2017-12-18','2017-12-18',18,4);
INSERT INTO `Orders` VALUES (8,'2017-12-24','2017-12-24',29,6);
INSERT INTO `Orders` VALUES (11,'2017-12-24','2017-12-24',29,6);
INSERT INTO `Orders` VALUES (13,'2017-12-24','2017-12-24',29,6);
INSERT INTO `Orders` VALUES (16,'2017-12-25',NULL,29,20);
/*!40000 ALTER TABLE `Orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `on_hands`
--

DROP TABLE IF EXISTS `on_hands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `on_hands` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `book_id` (`book_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `on_hands_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `on_hands_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `BOOK` (`id`),
  CONSTRAINT `on_hands_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `LIBUSER` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `on_hands`
--

LOCK TABLES `on_hands` WRITE;
/*!40000 ALTER TABLE `on_hands` DISABLE KEYS */;
INSERT INTO `on_hands` VALUES (4,8,3);
INSERT INTO `on_hands` VALUES (5,10,2);
INSERT INTO `on_hands` VALUES (16,29,20);
/*!40000 ALTER TABLE `on_hands` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-27 21:28:43
