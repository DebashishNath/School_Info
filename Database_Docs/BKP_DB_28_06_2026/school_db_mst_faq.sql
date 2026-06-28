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
-- Table structure for table `mst_faq`
--

DROP TABLE IF EXISTS `mst_faq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mst_faq` (
  `faq_id` bigint NOT NULL AUTO_INCREMENT,
  `school_id` bigint NOT NULL,
  `question` text NOT NULL,
  `answer` text NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`faq_id`),
  KEY `fk_faq_school` (`school_id`),
  CONSTRAINT `fk_faq_school` FOREIGN KEY (`school_id`) REFERENCES `mst_school` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_faq`
--

LOCK TABLES `mst_faq` WRITE;
/*!40000 ALTER TABLE `mst_faq` DISABLE KEYS */;
INSERT INTO `mst_faq` VALUES (1,1,'What is the yearly fee for STD 1?','The yearly fee for STD 1 is Rs 45,000.','FEE','Y','2026-06-10 07:26:57'),(2,1,'When does admission start?','Admissions start from April 1st every year.','ADMISSION','Y','2026-06-10 07:26:57'),(3,1,'What documents are required?','Birth certificate, Aadhaar card and passport size photographs are required.','DOCUMENT','Y','2026-06-10 07:26:57'),(4,1,'Do you provide transport?','Yes, transport facility is available across major routes.','TRANSPORT','Y','2026-06-10 07:26:57'),(5,1,'What are the school timings?','School timing is 8:00 AM to 2:00 PM.','GENERAL','Y','2026-06-10 07:26:57');
/*!40000 ALTER TABLE `mst_faq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-28 20:55:52
