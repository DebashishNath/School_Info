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
-- Table structure for table `trn_followup`
--

DROP TABLE IF EXISTS `trn_followup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trn_followup` (
  `followup_id` bigint NOT NULL AUTO_INCREMENT,
  `lead_id` bigint NOT NULL,
  `reminder_message` text,
  `reminder_date` timestamp NULL DEFAULT NULL,
  `reminder_status` varchar(50) DEFAULT 'PENDING',
  `sent_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`followup_id`),
  KEY `fk_followup_lead` (`lead_id`),
  CONSTRAINT `fk_followup_lead` FOREIGN KEY (`lead_id`) REFERENCES `trn_parent_lead` (`lead_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_followup`
--

LOCK TABLES `trn_followup` WRITE;
/*!40000 ALTER TABLE `trn_followup` DISABLE KEYS */;
INSERT INTO `trn_followup` VALUES (1,1,'Reminder for admission submission','2026-05-20 04:30:00','PENDING',NULL,'2026-05-18 05:11:37'),(2,2,'Please upload documents','2026-05-21 05:30:00','PENDING',NULL,'2026-05-18 05:11:37'),(3,3,'Seats are filling fast','2026-05-22 03:30:00','PENDING',NULL,'2026-05-18 05:11:37'),(4,4,'Reminder for school visit','2026-05-22 21:30:00','PENDING',NULL,'2026-05-18 05:11:37'),(5,5,'Complete admission process','2026-05-24 06:30:00','PENDING',NULL,'2026-05-18 05:11:37'),(6,1,'Reminder: Complete admission process.','2026-06-12 11:31:03','PENDING',NULL,NULL),(7,1,'Reminder: Complete admission process.','2026-06-12 11:31:40','PENDING',NULL,NULL),(8,1,'Reminder: Complete admission process.','2026-06-12 11:31:56','PENDING',NULL,NULL);
/*!40000 ALTER TABLE `trn_followup` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-28 20:55:51
