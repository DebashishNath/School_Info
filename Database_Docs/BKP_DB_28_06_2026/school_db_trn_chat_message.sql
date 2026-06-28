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
-- Table structure for table `trn_chat_message`
--

DROP TABLE IF EXISTS `trn_chat_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trn_chat_message` (
  `message_id` bigint NOT NULL AUTO_INCREMENT,
  `session_id` bigint NOT NULL,
  `sender_type` varchar(20) DEFAULT NULL,
  `message_text` text,
  `message_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`),
  KEY `fk_message_session` (`session_id`),
  CONSTRAINT `fk_message_session` FOREIGN KEY (`session_id`) REFERENCES `trn_chat_session` (`session_id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_chat_message`
--

LOCK TABLES `trn_chat_message` WRITE;
/*!40000 ALTER TABLE `trn_chat_message` DISABLE KEYS */;
INSERT INTO `trn_chat_message` VALUES (1,1,'PARENT','What is the yearly fee for STD 1?','2026-05-18 05:11:37'),(2,1,'AI','Yearly fee for STD 1 is Rs. 45,000.','2026-05-18 05:11:37'),(3,2,'PARENT','When does admission start?','2026-05-18 05:11:37'),(4,2,'AI','Admissions start from April 1st.','2026-05-18 05:11:37'),(5,3,'PARENT','What documents are required?','2026-05-18 05:11:37'),(6,3,'AI','Birth certificate and Aadhaar card are required.','2026-05-18 05:11:37'),(7,4,'PARENT','Do you provide transport?','2026-05-18 05:11:37'),(8,4,'AI','Yes, transport facility is available.','2026-05-18 05:11:37'),(9,5,'PARENT','Can I get admission form link?','2026-05-18 05:11:37'),(10,5,'AI','Sure. Sending admission form link.','2026-05-18 05:11:37'),(103,1,'PARENT','What is the annual fee for Class 2 ?',NULL),(104,1,'AI','The annual fee for STD 2 is Rs 48000.00',NULL),(105,1,'PARENT','What is the annual fee for Class 11 ?',NULL),(106,1,'AI','The annual fee for STD 1 is Rs 45000.00',NULL),(107,1,'PARENT','What is the annual fee for STD 11 ?',NULL),(108,1,'AI','The annual fee for STD 1 is Rs 45000.00',NULL),(109,1,'PARENT','What is the annual fee for STD 11 ?',NULL),(110,1,'AI','Fee information for STD 11 is not available. Please contact the school office.',NULL),(111,1,'PARENT','What is the annual fee for STD 1 ?',NULL),(112,1,'AI','The annual fee for STD 1 is Rs 45000.00',NULL),(113,1,'PARENT','What is the annual fee for STD 2 ?',NULL),(114,1,'AI','The annual fee for STD 2 is Rs 48000.00',NULL),(115,1,'PARENT','What is the annual fee for STD 3 ?',NULL),(116,1,'AI','Fee information for STD 3 is not available. Please contact the school office.',NULL),(117,1,'PARENT','Do the school provide bus ?',NULL),(118,1,'AI','Transport details are not available. Please contact the school office.',NULL),(119,1,'PARENT','Do the school provide bus ?',NULL),(120,1,'AI','Yes, a transportation service is provided.',NULL),(121,1,'PARENT','Is school bus available??',NULL),(122,1,'AI','Yes, transport facility is available across major routes.',NULL),(123,1,'PARENT','How much is the fee for class 1?',NULL),(124,1,'AI','The annual fee for STD 1 is Rs 45000.00.',NULL),(125,1,'PARENT','Is the fee of class 1 high ? what is it ?',NULL),(126,1,'AI','The annual fee for STD 1 is Rs 45000.00.',NULL),(127,1,'PARENT','What papers should I submit?',NULL),(128,1,'AI','Birth certificate, Aadhaar card and passport size photographs are required.',NULL),(129,1,'PARENT','Any documents to submit?',NULL),(130,1,'AI','Birth certificate, Aadhaar card and passport size photographs.',NULL),(131,1,'PARENT','what are the certificates to give?',NULL),(132,1,'AI','School timing is 8:00 AM to 2:00 PM.',NULL),(133,1,'PARENT','What certificates are needed?',NULL),(134,1,'AI','Birth certificate, Aadhaar card and passport size photographs.',NULL);
/*!40000 ALTER TABLE `trn_chat_message` ENABLE KEYS */;
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
