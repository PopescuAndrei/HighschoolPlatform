CREATE DATABASE  IF NOT EXISTS `highschool` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `highschool`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: highschool
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.9-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `absences`
--

DROP TABLE IF EXISTS `absences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `absences` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` date DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  `STUDENT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ABSENCES_COURSES` (`COURSE_ID`),
  KEY `FK_ABSENCES_STUDENTS` (`STUDENT_ID`),
  CONSTRAINT `FK_ABSENCES_COURSES` FOREIGN KEY (`COURSE_ID`) REFERENCES `courses` (`ID`),
  CONSTRAINT `FK_ABSENCES_STUDENTS` FOREIGN KEY (`STUDENT_ID`) REFERENCES `students` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absences`
--

LOCK TABLES `absences` WRITE;
/*!40000 ALTER TABLE `absences` DISABLE KEYS */;
/*!40000 ALTER TABLE `absences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'12A'),(2,'12B'),(3,'11E'),(4,'9A');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Matematica'),(2,'Informatica'),(3,'Limba Romana'),(4,'Limba Engleza'),(5,'Istorie');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses_classes`
--

DROP TABLE IF EXISTS `courses_classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses_classes` (
  `ID` int(11) NOT NULL,
  `CLASS_ID` int(11) DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK__classes` (`CLASS_ID`),
  KEY `FK__courses` (`COURSE_ID`),
  CONSTRAINT `FK__classes` FOREIGN KEY (`CLASS_ID`) REFERENCES `classes` (`ID`),
  CONSTRAINT `FK__courses` FOREIGN KEY (`COURSE_ID`) REFERENCES `courses` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses_classes`
--

LOCK TABLES `courses_classes` WRITE;
/*!40000 ALTER TABLE `courses_classes` DISABLE KEYS */;
/*!40000 ALTER TABLE `courses_classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grades` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VALUE` int(11) DEFAULT NULL,
  `DATE` varchar(50) DEFAULT NULL,
  `STUDENT_ID` int(11) NOT NULL,
  `COURSE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_GRADES_STUDENTS` (`STUDENT_ID`),
  KEY `FK_GRADES_COURSES` (`COURSE_ID`),
  CONSTRAINT `FK_GRADES_COURSES` FOREIGN KEY (`COURSE_ID`) REFERENCES `courses` (`ID`),
  CONSTRAINT `FK_GRADES_STUDENTS` FOREIGN KEY (`STUDENT_ID`) REFERENCES `students` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
INSERT INTO `grades` VALUES (1,10,'2016-01-01',1,2),(2,9,'2016-01-02',1,1),(3,10,'2015-11-12',1,2),(4,10,'2016-01-07',1,3),(5,10,'2016-01-16',1,3),(6,10,'2016-01-16',2,3);
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professors`
--

DROP TABLE IF EXISTS `professors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professors` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PROFESSORS_COURSES` (`COURSE_ID`),
  CONSTRAINT `FK_PROFESSORS_COURSES` FOREIGN KEY (`COURSE_ID`) REFERENCES `courses` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professors`
--

LOCK TABLES `professors` WRITE;
/*!40000 ALTER TABLE `professors` DISABLE KEYS */;
INSERT INTO `professors` VALUES (1,'Stefan','Tudosie','stefan.t@gmail.com','f0cbe92bba636dcfa1b27cbb05cd6000890cded0',1),(2,'Cornel','Bulea','bulea@gmail.com','f0cbe92bba636dcfa1b27cbb05cd6000890cded0',5),(3,'Florin','Georgescu','georgi@gmail.com','f0cbe92bba636dcfa1b27cbb05cd6000890cded0',4),(4,'Shakira','Elena','shakirashakira@gmail.com','f0cbe92bba636dcfa1b27cbb05cd6000890cded0',3),(5,'Adriana','Badescu','a.badescu@gmail.com','f0cbe92bba636dcfa1b27cbb05cd6000890cded0',2);
/*!40000 ALTER TABLE `professors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `CLASS_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_STUDENTS_CLASSES` (`CLASS_ID`),
  CONSTRAINT `FK_STUDENTS_CLASSES` FOREIGN KEY (`CLASS_ID`) REFERENCES `classes` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Andrei','Popescu','andrei.popescu93@gmail.com','f0cbe92bba636dcfa1b27cbb05cd6000890cded0',1),(2,'Oana','Ionel','ionel.oana@gmail.com','f0cbe92bba636dcfa1b27cbb05cd6000890cded0',2),(3,'Narcisa','Brailoiu','narcisa@gmail.com','f0cbe92bba636dcfa1b27cbb05cd6000890cded0',1),(4,'Eduard','Gabrian','banana@gmail.com','f0cbe92bba636dcfa1b27cbb05cd6000890cded0',4),(5,'Gigi','Becali','miorita@gmail.com','f0cbe92bba636dcfa1b27cbb05cd6000890cded0',3);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-16 23:57:22
