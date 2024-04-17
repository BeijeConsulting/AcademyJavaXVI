CREATE DATABASE  IF NOT EXISTS `beijejet` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `beijejet`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com    Database: beijejet
-- ------------------------------------------------------
-- Server version	8.0.35

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `Airport`
--

DROP TABLE IF EXISTS `Airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Airport` (
  `id_airport` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `id_city` int NOT NULL,
  PRIMARY KEY (`id_airport`),
  KEY `id_city` (`id_city`),
  CONSTRAINT `Airport_ibfk_1` FOREIGN KEY (`id_city`) REFERENCES `City` (`id_city`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Airport`
--

LOCK TABLES `Airport` WRITE;
/*!40000 ALTER TABLE `Airport` DISABLE KEYS */;
INSERT INTO `Airport` VALUES (1,'Aeroporto di Roma Fiumicino',1),(2,'Aeroporto di Madrid Barajas',2),(3,'Aeroporto di Belgrado Nikola Tesla',3),(4,'Aeroporto di Berlino Tegel',4),(5,'Aeroporto di Berna-Belp',5),(6,'Aeroporto di Bratislava',6),(7,'Aeroporto di Bruxelles',7),(8,'Aeroporto di Bucarest-Henri Coandă',8),(9,'Aeroporto di Budapest Ferenc Liszt',9),(10,'Aeroporto di Copenaghen-Kastrup',10),(11,'Aeroporto di Dublino',11),(12,'Aeroporto di Helsinki-Vantaa',12),(13,'Aeroporto di Lisbona Portela',13),(14,'Aeroporto di Londra Heathrow',14),(15,'Aeroporto di Lussemburgo-Findel',15),(16,'Aeroporto di Amsterdam Schiphol',16),(17,'Aeroporto di Oslo-Gardermoen',17),(18,'Aeroporto di Parigi Charles de Gaulle',18),(19,'Aeroporto di Praga-Václav Havel',19),(20,'Aeroporto di Reykjavik-Keflavík',20),(21,'Aeroporto di Atene-Eleftherios Venizelos',21),(22,'Aeroporto di Stoccolma-Arlanda',22),(23,'Aeroporto di Tirana Nënë Tereza',23),(24,'Aeroporto di Varsavia-Chopin',24),(25,'Aeroporto di Vienna-Schwechat',25),(26,'Aeroporto di Barcellona-El Prat',26),(27,'Aeroporto di Amburgo-Fuhlsbüttel',27),(28,'Aeroporto di Ginevra',28),(29,'Aeroporto di Zagabria-Franjo Tuđman',29),(30,'Aeroporto di Liegi',30),(31,'Aeroporto di Sofia',31),(32,'Aeroporto di Vilnius',32),(33,'Aeroporto di Manchester',33),(34,'Aeroporto di Rotterdam',34),(35,'Aeroporto di Bergen-Flesland',35);
/*!40000 ALTER TABLE `Airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `City`
--

DROP TABLE IF EXISTS `City`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `City` (
  `id_city` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  PRIMARY KEY (`id_city`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `City`
--

LOCK TABLES `City` WRITE;
/*!40000 ALTER TABLE `City` DISABLE KEYS */;
INSERT INTO `City` VALUES (1,'Napoli','Italia'),(2,'Madrid','Spagna'),(3,'Belgrado','Serbia'),(4,'Berlino','Germania'),(5,'Berna','Svizzera'),(6,'Bratislava','Slovacchia'),(7,'Bruxelles','Belgio'),(8,'Bucarest','Romania'),(9,'Budapest','Ungheria'),(10,'Copenaghen','Danimarca'),(11,'Dublino','Irlanda'),(12,'Helsinki','Finlandia'),(13,'Lisbona','Portogallo'),(14,'Londra','Regno Unito'),(15,'Lussemburgo','Lussemburgo'),(16,'Amsterdam','Paesi Bassi'),(17,'Oslo','Norvegia'),(18,'Parigi','Francia'),(19,'Praga','Repubblica Ceca'),(20,'Reykjavik','Islanda'),(21,'Atene','Grecia'),(22,'Stoccolma','Svezia'),(23,'Tirana','Albania'),(24,'Varsavia','Polonia'),(25,'Vienna','Austria'),(26,'Barcellona','Spagna'),(27,'Amburgo','Germania'),(28,'Ginevra','Svizzera'),(29,'Zagabria','Croazia'),(30,'Liegi','Belgio'),(31,'Sofia','Bulgaria'),(32,'Vilnius','Lituania'),(33,'Manchester','Regno Unito'),(34,'Rotterdam','Paesi Bassi'),(35,'Bergen','Norvegia');
/*!40000 ALTER TABLE `City` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Flight`
--

DROP TABLE IF EXISTS `Flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Flight` (
  `id_flight` int NOT NULL AUTO_INCREMENT,
  `id_airport_departure` int NOT NULL,
  `id_airport_arrival` int NOT NULL,
  `time_departure` datetime NOT NULL,
  `time_arrival` datetime DEFAULT NULL,
  `cost` decimal(10,2) NOT NULL,
  `max_capacity` int NOT NULL,
  `company` varchar(100) NOT NULL,
  PRIMARY KEY (`id_flight`),
  KEY `id_airport_departure` (`id_airport_departure`),
  KEY `id_airport_arrival` (`id_airport_arrival`),
  CONSTRAINT `Flight_ibfk_1` FOREIGN KEY (`id_airport_departure`) REFERENCES `Airport` (`id_airport`),
  CONSTRAINT `Flight_ibfk_2` FOREIGN KEY (`id_airport_arrival`) REFERENCES `Airport` (`id_airport`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Flight`
--

LOCK TABLES `Flight` WRITE;
/*!40000 ALTER TABLE `Flight` DISABLE KEYS */;
INSERT INTO `Flight` VALUES (1,1,14,'2023-05-12 20:00:00','2023-05-12 22:00:00',150.00,150,'Air Italia'),(2,2,6,'2023-05-12 09:30:00','2023-05-12 15:30:00',120.50,200,'Air Spagna'),(3,3,9,'2023-05-12 10:45:00','2023-05-12 19:45:00',200.00,180,'Air Serbia'),(4,4,25,'2023-05-12 11:30:00','2023-05-13 12:30:00',180.50,160,'Air Germania'),(5,5,16,'2023-05-12 12:15:00','2023-05-13 04:15:00',100.00,220,'Air Svizzera'),(6,6,28,'2023-05-12 13:00:00','2023-05-13 17:00:00',130.50,190,'Air Slovacchia'),(7,7,19,'2023-05-12 14:30:00','2023-05-13 09:30:00',160.00,170,'Air Belgio'),(8,8,11,'2023-05-12 15:15:00','2023-05-13 02:15:00',220.50,140,'Air Romania'),(9,9,22,'2023-05-12 16:45:00','2023-05-13 14:45:00',140.00,200,'Air Ungheria'),(10,10,35,'2023-05-12 22:45:00','2023-05-13 04:30:00',110.50,180,'Air Danimarca'),(11,14,1,'2023-05-12 13:00:00','2023-05-12 14:00:00',150.00,150,'Air Italia'),(12,6,2,'2023-05-12 14:15:00','2023-05-12 16:15:00',120.50,200,'Air Spagna'),(13,9,3,'2023-05-12 15:30:00','2023-05-12 18:30:00',200.00,180,'Air Serbia'),(14,25,4,'2023-05-12 16:15:00','2023-05-12 20:15:00',180.50,160,'Air Germania'),(15,16,5,'2023-05-12 17:00:00','2023-05-12 22:00:00',100.00,220,'Air Svizzera'),(16,28,6,'2023-05-12 18:15:00','2023-05-13 00:15:00',130.50,190,'Air Slovacchia'),(17,19,7,'2023-05-12 19:30:00','2023-05-13 02:30:00',160.00,170,'Air Belgio'),(18,11,8,'2023-05-12 20:45:00','2023-05-13 04:45:00',220.50,140,'Air Romania'),(19,22,9,'2023-05-12 21:30:00','2023-05-13 06:30:00',140.00,200,'Air Ungheria'),(20,35,10,'2023-05-12 22:45:00','2023-05-13 08:45:00',110.50,180,'Air Danimarca'),(21,35,10,'2023-05-12 23:45:00','2023-05-13 09:45:00',100.50,180,'Air Danimarca'),(22,1,6,'2023-05-12 15:55:00','2023-05-12 20:15:00',150.00,190,'Air Italia'),(23,10,14,'2023-05-12 15:55:00','2023-05-12 20:15:00',0.00,0,''),(24,14,35,'2023-05-12 15:55:00','2023-05-12 20:15:00',0.00,0,''),(29,35,6,'2023-05-12 15:55:00','2023-05-12 20:15:00',100.00,80,'Ryanair');
/*!40000 ALTER TABLE `Flight` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-17 14:53:22
