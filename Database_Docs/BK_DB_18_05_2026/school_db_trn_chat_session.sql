-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: school_db
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `trn_chat_session`
--

DROP TABLE IF EXISTS `trn_chat_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trn_chat_session` (
  `session_id` bigint NOT NULL AUTO_INCREMENT,
  `school_id` bigint NOT NULL,
  `lead_id` bigint DEFAULT NULL,
  `session_start` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `session_end` timestamp NULL DEFAULT NULL,
  `communication_channel` varchar(50) DEFAULT NULL,
  `ai_handled` char(1) DEFAULT 'Y',
  PRIMARY KEY (`session_id`),
  KEY `fk_session_school` (`school_id`),
  KEY `fk_session_lead` (`lead_id`),
  CONSTRAINT `fk_session_lead` FOREIGN KEY (`lead_id`) REFERENCES `trn_parent_lead` (`lead_id`),
  CONSTRAINT `fk_session_school` FOREIGN KEY (`school_id`) REFERENCES `mst_school` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_chat_session`
--

LOCK TABLES `trn_chat_session` WRITE;
/*!40000 ALTER TABLE `trn_chat_session` DISABLE KEYS */;
INSERT INTO `trn_chat_session` VALUES (1,1,1,'2026-05-18 05:11:37',NULL,'WhatsApp','Y'),(2,1,2,'2026-05-18 05:11:37',NULL,'Website','Y'),(3,1,3,'2026-05-18 05:11:37',NULL,'Facebook','Y'),(4,1,4,'2026-05-18 05:11:37',NULL,'WhatsApp','Y'),(5,1,5,'2026-05-18 05:11:37',NULL,'Website','Y');
/*!40000 ALTER TABLE `trn_chat_session` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-18 18:38:00
