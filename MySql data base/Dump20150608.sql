CREATE DATABASE  IF NOT EXISTS `jdbc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `jdbc`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: jdbc
-- ------------------------------------------------------
-- Server version	5.1.62-community

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
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine` (
  `MedicineName` varchar(50) DEFAULT NULL,
  `Type` varchar(10) DEFAULT NULL,
  `Dosage` varchar(12) DEFAULT NULL,
  `Day` char(2) DEFAULT NULL,
  `Total` char(3) DEFAULT NULL,
  `DosageRemarks` varchar(50) DEFAULT NULL,
  `IE` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES ('ABILIFY DISCMELT','CAPSULES','0-0-1','3','3','1 Night','Internal'),('ABILIFY','TABLETS','1-0-1','6','3','1 Morning - 1 Night','External'),('ABSORICA','CAPSULES','0-0-1','3','3','1 Night','Internal'),('ABSTRAL SUBLINQUAL','TABLETS','1-1-1','12','4','1 Morning- 1 Noon- 1 Night','External'),('Acarbose','TABLETS','0-1-0','2','2','1 Noon','External'),('BETOPTIC-S OPHTHALMIC','CAPSULES','0-0-1','3','3','1 Night','Internal'),('BEYAZ','TABLETS','0-1-0','5','5','1 Noon','External'),('BIAXIN','TABLETS','0-0-1','6','6','1 Night','External'),('BIAXIN XL','TABLETS','0-0-1','6','6','1 Night','External'),('BIDIL Hydralazine','TABLETS','1-1-1','15','5','1 Morning- 1 Noon- 1 Night','External'),('COUMADIN','TABLETS','1-0-0','10','10','1 Morning','External'),('COVERA -HS','TABLETS','1-1-1','15','5','1 Morning- 1 Noon- 1 Night','External'),('COZAAR','TABLETS','0-0-1','5','5','1 Night','External'),('CREON','CAPSULES','0-1-0','3','3','1 Noon','Internal'),('DEPAKENE','CAPSULES','0-0-1','1','1','1 Night','Internal'),('DEPAKOTE','TABLETS','0-0-1','6','6','1 Night','External'),('DEPAKOTE ER','TABLETS','0-0-1','6','6','1 Night','External'),('DEPEN','TABLETS','1-0-1','6','3','1 Morning - 1 Night','External'),('EFFIENT','TABLETS','1-0-1','6','3','1 Morning - 1 Night','External'),('ELAVIL','TABLETS','0-0-1','5','5','1 Night','External'),('ELDEPRYL','CAPSULES','0-0-1','1','1','1 Night','Internal'),('FANAPT','TABLETS','1-1-1','12','4','1 Morning- 1 Noon- 1 Night','External'),('FANAPT','TABLETS','1-1-0','6','3','1 Morning- 1 Noon- 1 Night','External');
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `reg` int(11) DEFAULT NULL,
  `pname` varchar(12) DEFAULT NULL,
  `rdate` varchar(15) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `martial` char(10) DEFAULT NULL,
  `gender` char(7) DEFAULT NULL,
  `dob` varchar(15) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `phone` mediumtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (0,'0','0','0','0','0','00000000',0,'0'),(1,'sonu','16/05/2015','Ranjeect colony Sogariya, kota jn. raj, PIN- 324002','Unmarried','Male','20/11/1989',25,'9876545678'),(2,'Reema','02/06/2015','27/2 b gali no. 520, rani bagh, new delhi 110045','Unmarried','Female','22/3/1992',23,'9876786546'),(3,'monu','04/06/2015','19/20 II-nd floor, janpath new delhi-78 ','Unmarried','Male','29/7/1997',17,'7898765678'),(4,'Bhola','08/06/2015','Punjabi bagh, new delhi','Unmarried','Male','4/9/1991',23,'9875788766');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-08 14:10:44
