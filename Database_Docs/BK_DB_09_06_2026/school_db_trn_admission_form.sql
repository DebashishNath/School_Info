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
-- Table structure for table `trn_admission_form`
--

DROP TABLE IF EXISTS `trn_admission_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trn_admission_form` (
  `form_id` bigint NOT NULL AUTO_INCREMENT,
  `school_id` bigint NOT NULL,
  `lead_id` bigint NOT NULL,
  `form_sent` char(1) DEFAULT 'N',
  `form_sent_date` timestamp NULL DEFAULT NULL,
  `form_submitted` char(1) DEFAULT 'N',
  `form_submitted_date` timestamp NULL DEFAULT NULL,
  `form_link` varchar(500) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`form_id`),
  KEY `fk_form_school` (`school_id`),
  KEY `fk_form_lead` (`lead_id`),
  CONSTRAINT `fk_form_lead` FOREIGN KEY (`lead_id`) REFERENCES `trn_parent_lead` (`lead_id`),
  CONSTRAINT `fk_form_school` FOREIGN KEY (`school_id`) REFERENCES `mst_school` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_admission_form`
--

LOCK TABLES `trn_admission_form` WRITE;
/*!40000 ALTER TABLE `trn_admission_form` DISABLE KEYS */;
INSERT INTO `trn_admission_form` VALUES (1,1,1,'Y','2026-05-18 05:11:37','N',NULL,'https://school.com/form/1','2026-05-18 05:11:37'),(2,1,2,'Y','2026-05-18 05:11:37','Y',NULL,'https://school.com/form/2','2026-05-18 05:11:37'),(3,1,3,'Y','2026-05-18 05:11:37','N',NULL,'https://school.com/form/3','2026-05-18 05:11:37'),(4,1,4,'Y','2026-05-18 05:11:37','N',NULL,'https://school.com/form/4','2026-05-18 05:11:37'),(5,1,5,'Y','2026-05-18 05:11:37','Y',NULL,'https://school.com/form/5','2026-05-18 05:11:37');
/*!40000 ALTER TABLE `trn_admission_form` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-10 13:36:59
