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
-- Table structure for table `mst_student`
--

DROP TABLE IF EXISTS `mst_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mst_student` (
  `student_id` bigint NOT NULL AUTO_INCREMENT,
  `school_id` bigint NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `middle_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `aadhaar_number` varchar(20) DEFAULT NULL,
  `blood_group` varchar(10) DEFAULT NULL,
  `address` text,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `pincode` varchar(20) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`student_id`),
  KEY `fk_student_school` (`school_id`),
  CONSTRAINT `fk_student_school` FOREIGN KEY (`school_id`) REFERENCES `mst_school` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_student`
--

LOCK TABLES `mst_student` WRITE;
/*!40000 ALTER TABLE `mst_student` DISABLE KEYS */;
INSERT INTO `mst_student` VALUES (1,1,'Aarav',NULL,'Sharma','Male','2019-01-10',NULL,'O+',NULL,'Kolkata','West Bengal','700001','2026-05-18 05:11:37'),(2,1,'Vivaan',NULL,'Roy','Male','2019-02-14',NULL,'A+',NULL,'Kolkata','West Bengal','700002','2026-05-18 05:11:37'),(3,1,'Anaya',NULL,'Das','Female','2019-03-21',NULL,'B+',NULL,'Kolkata','West Bengal','700003','2026-05-18 05:11:37'),(4,1,'Diya',NULL,'Sen','Female','2019-04-11',NULL,'AB+',NULL,'Kolkata','West Bengal','700004','2026-05-18 05:11:37'),(5,1,'Ishaan',NULL,'Ghosh','Male','2019-05-05',NULL,'O+',NULL,'Kolkata','West Bengal','700005','2026-05-18 05:11:37'),(6,1,'Myra',NULL,'Mukherjee','Female','2019-06-16',NULL,'A+',NULL,'Kolkata','West Bengal','700006','2026-05-18 05:11:37'),(7,1,'Advik',NULL,'Paul','Male','2019-07-07',NULL,'B+',NULL,'Kolkata','West Bengal','700007','2026-05-18 05:11:37'),(8,1,'Kiara',NULL,'Dutta','Female','2019-08-12',NULL,'O-',NULL,'Kolkata','West Bengal','700008','2026-05-18 05:11:37'),(9,1,'Reyansh',NULL,'Banerjee','Male','2019-09-09',NULL,'AB+',NULL,'Kolkata','West Bengal','700009','2026-05-18 05:11:37'),(10,1,'Aadhya',NULL,'Chatterjee','Female','2019-10-18',NULL,'A-',NULL,'Kolkata','West Bengal','700010','2026-05-18 05:11:37'),(11,1,'Krish',NULL,'Nandi','Male','2019-11-20',NULL,'O+',NULL,'Kolkata','West Bengal','700011','2026-05-18 05:11:37'),(12,1,'Saanvi',NULL,'Bose','Female','2019-12-22',NULL,'B+',NULL,'Kolkata','West Bengal','700012','2026-05-18 05:11:37'),(13,1,'Arjun',NULL,'Mitra','Male','2019-01-30',NULL,'A+',NULL,'Kolkata','West Bengal','700013','2026-05-18 05:11:37'),(14,1,'Riya',NULL,'Saha','Female','2019-02-25',NULL,'O+',NULL,'Kolkata','West Bengal','700014','2026-05-18 05:11:37'),(15,1,'Kabir',NULL,'Kar','Male','2019-03-13',NULL,'B-',NULL,'Kolkata','West Bengal','700015','2026-05-18 05:11:37'),(16,1,'Navya',NULL,'Bhattacharya','Female','2019-04-27',NULL,'AB+',NULL,'Kolkata','West Bengal','700016','2026-05-18 05:11:37'),(17,1,'Atharv',NULL,'Pal','Male','2019-05-19',NULL,'O+',NULL,'Kolkata','West Bengal','700017','2026-05-18 05:11:37'),(18,1,'Meera',NULL,'De','Female','2019-06-08',NULL,'A+',NULL,'Kolkata','West Bengal','700018','2026-05-18 05:11:37'),(19,1,'Vihaan',NULL,'Sarkar','Male','2019-07-29',NULL,'B+',NULL,'Kolkata','West Bengal','700019','2026-05-18 05:11:37'),(20,1,'Pari',NULL,'Gupta','Female','2019-08-15',NULL,'O+',NULL,'Kolkata','West Bengal','700020','2026-05-18 05:11:37');
/*!40000 ALTER TABLE `mst_student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-18 12:05:42
