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
-- Table structure for table `trn_student_class`
--

DROP TABLE IF EXISTS `trn_student_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trn_student_class` (
  `student_class_id` bigint NOT NULL AUTO_INCREMENT,
  `student_id` bigint NOT NULL,
  `class_id` bigint NOT NULL,
  `academic_year` varchar(20) NOT NULL,
  `roll_number` varchar(50) DEFAULT NULL,
  `admission_date` date DEFAULT NULL,
  `status` varchar(50) DEFAULT 'ACTIVE',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`student_class_id`),
  KEY `fk_student_class_student` (`student_id`),
  KEY `fk_student_class_class` (`class_id`),
  CONSTRAINT `fk_student_class_class` FOREIGN KEY (`class_id`) REFERENCES `mst_class` (`class_id`),
  CONSTRAINT `fk_student_class_student` FOREIGN KEY (`student_id`) REFERENCES `mst_student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_student_class`
--

LOCK TABLES `trn_student_class` WRITE;
/*!40000 ALTER TABLE `trn_student_class` DISABLE KEYS */;
INSERT INTO `trn_student_class` VALUES (1,1,1,'2026-2027','1','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(2,2,1,'2026-2027','2','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(3,3,1,'2026-2027','3','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(4,4,1,'2026-2027','4','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(5,5,1,'2026-2027','5','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(6,6,1,'2026-2027','6','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(7,7,1,'2026-2027','7','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(8,8,1,'2026-2027','8','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(9,9,1,'2026-2027','9','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(10,10,1,'2026-2027','10','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(11,11,1,'2026-2027','11','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(12,12,1,'2026-2027','12','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(13,13,1,'2026-2027','13','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(14,14,1,'2026-2027','14','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(15,15,1,'2026-2027','15','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(16,16,1,'2026-2027','16','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(17,17,1,'2026-2027','17','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(18,18,1,'2026-2027','18','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(19,19,1,'2026-2027','19','2026-04-01','ACTIVE','2026-05-18 05:11:37'),(20,20,1,'2026-2027','20','2026-04-01','ACTIVE','2026-05-18 05:11:37');
/*!40000 ALTER TABLE `trn_student_class` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-10 13:37:00
