-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: finalprojectdb
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `idClient` int NOT NULL AUTO_INCREMENT,
  `firstNameClient` varchar(45) NOT NULL,
  `lastNameClient` varchar(45) NOT NULL,
  `emailClient` varchar(45) NOT NULL,
  `telephoneNumberClient` varchar(45) NOT NULL,
  `ageClient` varchar(45) NOT NULL,
  `idMembership` int DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE KEY `emailClient_UNIQUE` (`emailClient`),
  UNIQUE KEY `telephoneNumberClient_UNIQUE` (`telephoneNumberClient`),
  KEY `foreignKeyClientMembership_idx` (`idMembership`),
  CONSTRAINT `foreignKeyClientMembership` FOREIGN KEY (`idMembership`) REFERENCES `membership` (`idMembership`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Daniel','Client','danielclient@rawpower.gym','+40759624458','20',1),(2,'client1','client1','client','client1','client1',2),(3,'clientT','clientT','clientT','clientT','28',3),(4,'asd','sad','sad','asd','asd',4);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diets`
--

DROP TABLE IF EXISTS `diets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diets` (
  `idDiet` int NOT NULL AUTO_INCREMENT,
  `dietMeals` varchar(45) NOT NULL,
  `dietCalories` varchar(45) NOT NULL,
  PRIMARY KEY (`idDiet`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diets`
--

LOCK TABLES `diets` WRITE;
/*!40000 ALTER TABLE `diets` DISABLE KEYS */;
INSERT INTO `diets` VALUES (1,'eggs,proteinShake,chicken,vegetables','1200'),(2,'eggs,proteinSHake,chicken,pork,vegetable','1350'),(3,'proteinShake,chicken,vegetables,proteinShake','1300');
/*!40000 ALTER TABLE `diets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercises`
--

DROP TABLE IF EXISTS `exercises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercises` (
  `idExercise` int NOT NULL AUTO_INCREMENT,
  `exerciseName` varchar(45) NOT NULL,
  PRIMARY KEY (`idExercise`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercises`
--

LOCK TABLES `exercises` WRITE;
/*!40000 ALTER TABLE `exercises` DISABLE KEYS */;
INSERT INTO `exercises` VALUES (1,'Pull Ups'),(2,'Chin Ups'),(3,'Push Ups'),(4,'Abs'),(5,'Squats');
/*!40000 ALTER TABLE `exercises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gyms`
--

DROP TABLE IF EXISTS `gyms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gyms` (
  `idGym` int NOT NULL AUTO_INCREMENT,
  `gymLocation` varchar(45) NOT NULL,
  PRIMARY KEY (`idGym`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gyms`
--

LOCK TABLES `gyms` WRITE;
/*!40000 ALTER TABLE `gyms` DISABLE KEYS */;
INSERT INTO `gyms` VALUES (1,'Brasov'),(2,'Bucuresti'),(3,'Timisoara');
/*!40000 ALTER TABLE `gyms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `managers` (
  `idManager` int NOT NULL AUTO_INCREMENT,
  `firstNameManager` varchar(45) NOT NULL,
  `lastNameManager` varchar(45) NOT NULL,
  `emailManager` varchar(45) NOT NULL,
  `telephoneNumberManager` varchar(45) NOT NULL,
  PRIMARY KEY (`idManager`),
  UNIQUE KEY `emailManager_UNIQUE` (`emailManager`),
  UNIQUE KEY `telephoneNumberManager_UNIQUE` (`telephoneNumberManager`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES (1,'Daniel','Guiman','daniel.mariusgdm@gmail.com','+40 726 047 188');
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membership`
--

DROP TABLE IF EXISTS `membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `membership` (
  `idMembership` int NOT NULL AUTO_INCREMENT,
  `idTrainer` int DEFAULT NULL,
  `idGym` int DEFAULT NULL,
  `idDiet` int DEFAULT NULL,
  `idExercise` int DEFAULT NULL,
  PRIMARY KEY (`idMembership`),
  KEY `foreignKeyMembershipTrainer_idx` (`idTrainer`),
  KEY `foreignKeyMembershipGym_idx` (`idGym`),
  KEY `foreignKeyMembershipDiet_idx` (`idDiet`),
  KEY `foreignKeyMembershipExercise_idx` (`idExercise`),
  CONSTRAINT `foreignKeyMembershipDiet` FOREIGN KEY (`idDiet`) REFERENCES `diets` (`idDiet`),
  CONSTRAINT `foreignKeyMembershipExercise` FOREIGN KEY (`idExercise`) REFERENCES `exercises` (`idExercise`),
  CONSTRAINT `foreignKeyMembershipGym` FOREIGN KEY (`idGym`) REFERENCES `gyms` (`idGym`),
  CONSTRAINT `foreignKeyMembershipTrainer` FOREIGN KEY (`idTrainer`) REFERENCES `trainers` (`idTrainer`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership`
--

LOCK TABLES `membership` WRITE;
/*!40000 ALTER TABLE `membership` DISABLE KEYS */;
INSERT INTO `membership` VALUES (1,1,3,2,2),(2,1,1,1,1),(3,2,2,2,1),(4,1,2,3,3);
/*!40000 ALTER TABLE `membership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainers`
--

DROP TABLE IF EXISTS `trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers` (
  `idTrainer` int NOT NULL AUTO_INCREMENT,
  `firstNameTrainer` varchar(45) NOT NULL,
  `lastNameTrainer` varchar(45) NOT NULL,
  `emailTrainer` varchar(45) NOT NULL,
  `telephoneNumberTrainer` varchar(45) NOT NULL,
  `ageTrainer` varchar(45) NOT NULL,
  `ratingTrainer` int DEFAULT NULL,
  `ratingComment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTrainer`),
  UNIQUE KEY `emailTrainer_UNIQUE` (`emailTrainer`),
  UNIQUE KEY `telephoneNumberTrainer_UNIQUE` (`telephoneNumberTrainer`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers`
--

LOCK TABLES `trainers` WRITE;
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
INSERT INTO `trainers` VALUES (1,'Daniel','Trainer','danieltrainer@rawpower.gym','+40726789546','24',NULL,NULL),(2,'trainer1','trainerel1','trsada','asdas','23',NULL,NULL);
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `idManager` int DEFAULT NULL,
  `idTrainer` int DEFAULT NULL,
  `idClient` int DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `foreignKeyUserManager_idx` (`idManager`),
  KEY `foreignKeyUserTrainer_idx` (`idTrainer`),
  KEY `foreignKeyUserClient_idx` (`idClient`),
  CONSTRAINT `foreignKeyUserClient` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`),
  CONSTRAINT `foreignKeyUserManager` FOREIGN KEY (`idManager`) REFERENCES `managers` (`idManager`),
  CONSTRAINT `foreignKeyUserTrainer` FOREIGN KEY (`idTrainer`) REFERENCES `trainers` (`idTrainer`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'danielmanager','caiimei',1,NULL,NULL),(2,'danieltrainer','samoara',NULL,1,NULL),(3,'trainer1','trainer1',NULL,2,NULL),(4,'danieluser','depebloc',NULL,NULL,1),(5,'client1','client1',NULL,NULL,2),(6,'clientT','clientT',NULL,NULL,3),(7,'asd','asd',NULL,NULL,4);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-28 17:22:08
