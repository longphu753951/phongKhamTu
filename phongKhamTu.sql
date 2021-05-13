-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: phongtu
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_Id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`category_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dangky`
--

DROP TABLE IF EXISTS `dangky`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dangky` (
  `dangKy_Id` bigint NOT NULL AUTO_INCREMENT,
  `ho` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ten` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sdt` varchar(10) NOT NULL,
  `ngayKham` date NOT NULL,
  `trieuChung` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buoiKham` int NOT NULL,
  `tinhTrang` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`dangKy_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `khambenh`
--

DROP TABLE IF EXISTS `khambenh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khambenh` (
  `khamBenh_Id` bigint NOT NULL AUTO_INCREMENT,
  `ho` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ten` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ngayKham` date NOT NULL,
  `gioKham` time NOT NULL,
  `tinhTrang` int DEFAULT '0',
  `nguyenNhan` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `loiKhuyen` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `tongTien` decimal(10,0) DEFAULT '0',
  `tienKham` decimal(10,0) DEFAULT '0',
  PRIMARY KEY (`khamBenh_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `khambenh_medicine`
--

DROP TABLE IF EXISTS `khambenh_medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khambenh_medicine` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `khamBenh_Id` bigint NOT NULL,
  `medicine_Id` bigint NOT NULL,
  `quantity` bigint NOT NULL DEFAULT '1',
  `price` decimal(10,0) NOT NULL,
  `totalPrice` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`,`khamBenh_Id`,`medicine_Id`),
  KEY `khamBenh_Id` (`khamBenh_Id`),
  KEY `medicine_Id` (`medicine_Id`),
  CONSTRAINT `khamBenh_Id` FOREIGN KEY (`khamBenh_Id`) REFERENCES `khambenh` (`khamBenh_Id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `medicine_Id` FOREIGN KEY (`medicine_Id`) REFERENCES `medicine` (`medicine_Id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `medicine_Id` bigint NOT NULL AUTO_INCREMENT,
  `category_Id` bigint NOT NULL,
  `fullname` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `pic` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`medicine_Id`),
  KEY `category_Id` (`category_Id`),
  CONSTRAINT `medicine_ibfk_1` FOREIGN KEY (`category_Id`) REFERENCES `category` (`category_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_Id` bigint NOT NULL AUTO_INCREMENT,
  `userName` varchar(14) NOT NULL,
  `password` varchar(100) NOT NULL,
  `user_role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-13 18:45:30
