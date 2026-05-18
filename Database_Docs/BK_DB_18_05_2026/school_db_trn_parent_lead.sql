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
-- Table structure for table `trn_parent_lead`
--

DROP TABLE IF EXISTS `trn_parent_lead`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trn_parent_lead` (
  `lead_id` bigint NOT NULL AUTO_INCREMENT,
  `school_id` bigint NOT NULL,
  `parent_name` varchar(150) DEFAULT NULL,
  `student_id` bigint DEFAULT NULL,
  `mobile_number` varchar(20) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `interested_class_id` bigint DEFAULT NULL,
  `enquiry_source` varchar(50) DEFAULT NULL,
  `lead_status` varchar(50) DEFAULT 'NEW',
  `remarks` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`lead_id`),
  KEY `fk_lead_school` (`school_id`),
  KEY `fk_lead_class` (`interested_class_id`),
  KEY `fk_parent_lead_student` (`student_id`),
  CONSTRAINT `fk_lead_class` FOREIGN KEY (`interested_class_id`) REFERENCES `mst_class` (`class_id`),
  CONSTRAINT `fk_lead_school` FOREIGN KEY (`school_id`) REFERENCES `mst_school` (`school_id`),
  CONSTRAINT `fk_parent_lead_student` FOREIGN KEY (`student_id`) REFERENCES `mst_student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_parent_lead`
--

LOCK TABLES `trn_parent_lead` WRITE;
/*!40000 ALTER TABLE `trn_parent_lead` DISABLE KEYS */;
INSERT INTO `trn_parent_lead` VALUES (1,1,'Rajesh Sharma',1,'9000000001','rajesh.sharma@gmail.com',1,'WhatsApp','INTERESTED','Requested admission form','2026-05-18 05:11:37','2026-05-18 05:11:37'),(2,1,'Sourav Roy',2,'9000000002','sourav.roy@gmail.com',1,'Website','FOLLOWUP','Will visit school','2026-05-18 05:11:37','2026-05-18 05:11:37'),(3,1,'Anindita Das',3,'9000000003','anindita.das@gmail.com',1,'Facebook','NEW','Asked fee details','2026-05-18 05:11:37','2026-05-18 05:11:37'),(4,1,'Priya Sen',4,'9000000004','priya.sen@gmail.com',1,'WhatsApp','INTERESTED','Interested in transport','2026-05-18 05:11:37','2026-05-18 05:11:37'),(5,1,'Subhajit Ghosh',5,'9000000005','subhajit.ghosh@gmail.com',1,'Website','NEW','Need admission process','2026-05-18 05:11:37','2026-05-18 05:11:37'),(6,1,'Madhumita Mukherjee',6,'9000000006','madhumita@gmail.com',1,'Instagram','FOLLOWUP','Requested callback','2026-05-18 05:11:37','2026-05-18 05:11:37'),(7,1,'Arindam Paul',7,'9000000007','arindam@gmail.com',1,'WhatsApp','INTERESTED','Admission likely','2026-05-18 05:11:37','2026-05-18 05:11:37'),(8,1,'Puja Dutta',8,'9000000008','puja@gmail.com',1,'Website','NEW','Need fee structure','2026-05-18 05:11:37','2026-05-18 05:11:37'),(9,1,'Abhijit Banerjee',9,'9000000009','abhijit@gmail.com',1,'Facebook','FOLLOWUP','Asked hostel details','2026-05-18 05:11:37','2026-05-18 05:11:37'),(10,1,'Soma Chatterjee',10,'9000000010','soma@gmail.com',1,'WhatsApp','INTERESTED','Requested brochure','2026-05-18 05:11:37','2026-05-18 05:11:37'),(11,1,'Rakesh Nandi',11,'9000000011','rakesh@gmail.com',1,'Website','NEW','General enquiry','2026-05-18 05:11:37','2026-05-18 05:11:37'),(12,1,'Ankita Bose',12,'9000000012','ankita@gmail.com',1,'Instagram','FOLLOWUP','Need transport details','2026-05-18 05:11:37','2026-05-18 05:11:37'),(13,1,'Tanmoy Mitra',13,'9000000013','tanmoy@gmail.com',1,'WhatsApp','INTERESTED','Admission confirmed soon','2026-05-18 05:11:37','2026-05-18 05:11:37'),(14,1,'Mousumi Saha',14,'9000000014','mousumi@gmail.com',1,'Website','NEW','Requested meeting','2026-05-18 05:11:37','2026-05-18 05:11:37'),(15,1,'Kaushik Kar',15,'9000000015','kaushik@gmail.com',1,'Facebook','FOLLOWUP','Need scholarship info','2026-05-18 05:11:37','2026-05-18 05:11:37'),(16,1,'Ritu Bhattacharya',16,'9000000016','ritu@gmail.com',1,'WhatsApp','INTERESTED','Very interested','2026-05-18 05:11:37','2026-05-18 05:11:37'),(17,1,'Sanjay Pal',17,'9000000017','sanjay@gmail.com',1,'Website','NEW','Fee enquiry','2026-05-18 05:11:37','2026-05-18 05:11:37'),(18,1,'Nandita De',18,'9000000018','nandita@gmail.com',1,'Instagram','FOLLOWUP','Will submit documents','2026-05-18 05:11:37','2026-05-18 05:11:37'),(19,1,'Anup Sarkar',19,'9000000019','anup@gmail.com',1,'WhatsApp','INTERESTED','Need admission date','2026-05-18 05:11:37','2026-05-18 05:11:37'),(20,1,'Poonam Gupta',20,'9000000020','poonam@gmail.com',1,'Facebook','NEW','Requested school visit','2026-05-18 05:11:37','2026-05-18 05:11:37');
/*!40000 ALTER TABLE `trn_parent_lead` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-18 18:38:01
