-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: querico
-- ------------------------------------------------------
-- Server version	5.7.31-log

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
-- Table structure for table `detalleegreso`
--

DROP TABLE IF EXISTS `detalleegreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleegreso` (
  `hoja` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(45) NOT NULL,
  `retira` varchar(45) NOT NULL,
  `sector` varchar(45) NOT NULL,
  `ref` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `producto` varchar(45) NOT NULL,
  `medida` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `cantidad` varchar(45) NOT NULL,
  PRIMARY KEY (`hoja`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleegreso`
--

LOCK TABLES `detalleegreso` WRITE;
/*!40000 ALTER TABLE `detalleegreso` DISABLE KEYS */;
INSERT INTO `detalleegreso` VALUES (1,'1','DAVID GUERRERO','SYSTEMAS','0001','12/12/2020','TERMICA','10','SICA','1'),(2,'1','JOSE PEREZ','MECANICA','00002','12/12/2020','TERMICA','10','SICA','1'),(3,'4','DAD','DAD','DAWD','13/12/2020','TERMICA','10','SICA','4'),(4,'5','DAVID','MECANICA','2','13/12/2020','TERMICA','10','SICA','2'),(5,'1','da','man','2','17/12/2020','TERMICA','10','SICA','5'),(6,'2','SFSF','FSFS','FSF','17/12/2020','TERMICA','10','SICA','2'),(7,'28','MARIANO LARROQUE','EVISCERADO','MG','21/12/2020','RODAMIENTO','6204','SKF','2'),(8,'76','LUCAS BERON ','DESPLUME','MG','21/12/2020','CIERRA PUERTAS AEREO  NG2 30A45KG ','30 A 45KG','TRABEX','1'),(9,'29','CEPEDA','PLAYA','4','23/12/2020','RODAMIENTO','6205','SKF','1'),(10,'28','Cepeda','paletizado','','06/01/2021','RODAMIENTO','6204','SKF','2'),(11,'83','damian larroque','eviscerado','','06/01/2021','CORREA','AA-68','abix','2'),(12,'41','Perez Juan','eviscerado','','06/01/2021','RODAMIENTO','6305','SKF','1'),(13,'77','Pallavidini','desplume','','06/01/2021','CORREA','A-28','abix','2'),(14,'44','Pallavidini','desplume','','06/01/2021','RODAMIENTO','6308','SKF','2'),(15,'28','','','','07/01/2021','RODAMIENTO','6204','SKF','2'),(16,'54','','','','07/01/2021','RODAMIENTO','1205K','SKF','1'),(17,'27','','','','08/01/2021','RODAMIENTO','6203','SKF','2'),(18,'28','','','','08/01/2021','RODAMIENTO','6204','SKF','2'),(19,'41','','','','08/01/2021','RODAMIENTO','6305','SKF','2'),(20,'4','','','','08/01/2021','RODAMIENTO','6002','SKF','4'),(21,'41','','','','09/01/2021','RODAMIENTO','6305','SKF','2'),(22,'6','cepeda','empaque','','11/01/2021','RODAMIENTO','6004','SKF','2'),(23,'17','palavidini','empaque','','11/01/2021','RODAMIENTO','UC 205','SKF','1'),(24,'6','cepeda','empaque','','11/01/2021','RODAMIENTO','6004','SKF','3'),(25,'62','perez juan','desplume','','11/01/2021','RODAMIENTO','2204','SKF','4'),(26,'84','PEREZ JUAN','DESPLUME','','11/01/2021','CORREA','AA-155','abix','2'),(27,'2','','','','12/01/2021','RODAMIENTO','628','SKF','4'),(28,'6','cepeda maximiliano','rolo flipper empaque ','mg','12/01/2021','RODAMIENTO','6004','SKF','6'),(29,'8','CEPEDA','PALETIZADO','MT','12/01/2021','RODAMIENTO','6006','SKF','2'),(30,'76','palavidini','desplume','mg','13/01/2021','CIERRA PUERTAS AEREO  NG2 30A45KG ','30 A 45KG','TRABEX','1'),(31,'41','','','','14/01/2021','RODAMIENTO','6305','SKF','2'),(32,'84','PALAVIDINI','DESPLUME','MG','14/01/2021','CORREA','AA-155','abix','2'),(33,'85','','','','15/01/2021','CORREA','A-124','abix','2'),(34,'137','','','','15/01/2021','MEDIO ESLABON SIMPLE','1/2\"','SKF','1'),(35,'99','RIVEROS','EMPAQUE','MG','15/01/2021','CORREA DENTADA ','365T5-10MM','TRASMICIONES GES','1'),(36,'2','PALAVIDINI','EMPAQUE','','15/01/2021','RODAMIENTO','628','SKF','1'),(37,'42','PALAVIDINI','EMPAQUE','','15/01/2021','RODAMIENTO','6306','SKF','1'),(38,'29','PALAVIDINI','EMPAQUE','','15/01/2021','RODAMIENTO','6205','SKF','1'),(39,'84','moran lucas','desplume','mg','16/01/2021','CORREA','AA-155','abix','4'),(40,'84','moran lucas','desplume','mg','16/01/2021','CORREA','AA-155','abix','1'),(41,'6','cepeda','playa','','16/01/2021','RODAMIENTO','6004','SKF','2'),(42,'1','MARCOS','SISTEMAS','','11/02/2021','RODAMIENTO','608','SKF','5'),(43,'1','MARCOS MARQUEZ','Desplume','25','11/02/2021','RODAMIENTO','608','SKF','5'),(44,'4','MARCOS MARQUEZ','Desplume','25','11/02/2021','RODAMIENTO','6002','SKF','2'),(45,'1','SISTEMA','Desplume','25','11/02/2021','RODAMIENTO','608','SKF','2'),(46,'1','MARCOS','Desplume','25','11/02/2021','RODAMIENTO','608','SKF','1'),(47,'7','joni','Playa','12','16/02/2021','RODAMIENTO','6005','SKF','1'),(48,'6','joni','Playa','12','16/02/2021','RODAMIENTO','6004','SKF','1'),(49,'10','a','Playa','12','16/02/2021','RODAMIENTO','6008','SKF','1'),(50,'91','javi','Playa','15','19/02/2021','CORREA','SPZ-1762','abix','10'),(51,'101','JOSE PEREZ','SISTEMAS','','24/02/2021','CAJA PORTA RODAMIENTOS','FYK505','SKF','1'),(52,'1','JOSE','SISTEMAS','','24/02/2021','RODAMIENTO','608','SKF','1'),(53,'11','','Playa','4','30/04/2021','RODAMIENTO','6009','SKF','5'),(54,'5','','Playa','4','30/04/2021','RODAMIENTO','6003','SKF','6'),(55,'3','','','','30/04/2021','RODAMIENTO','6001','SKF','1'),(56,'4','ARIEL','NA','1','25/05/2021','RODAMIENTO','6002','SKF','2'),(57,'3','','Playa','2','25/05/2021','RODAMIENTO','6001','SKF','1'),(58,'2','DAVID','SYSTEMAS','NA','09/06/2021','RODAMIENTO','628','SKF','9');
/*!40000 ALTER TABLE `detalleegreso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleing`
--

DROP TABLE IF EXISTS `detalleing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleing` (
  `hoja` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(45) NOT NULL,
  `recibido` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `producto` varchar(45) NOT NULL,
  `medida` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `cantidad` varchar(45) NOT NULL,
  PRIMARY KEY (`hoja`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleing`
--

LOCK TABLES `detalleing` WRITE;
/*!40000 ALTER TABLE `detalleing` DISABLE KEYS */;
INSERT INTO `detalleing` VALUES (1,'1','PAÑOL ,','11/12/2020','TERMICA','10','SICA','10'),(2,'2','David Guerrero','15/12/2020','TERMICA','10','SICA','10'),(3,'124','PAÑOL ','22/12/2020','CAJA PORTA RODAMIENTOS','P 213','FK','8'),(4,'19','PAÑOL ','23/12/2020','RODAMIENTO','UC 207','SKF','2'),(5,'127','PAÑOL ','29/12/2021','CADENA INOX DOBLE 1/2\"','1/2\"','RVGHT ','2'),(6,'12','PAÑOL ','31/12/2021','RODAMIENTO','6010','SKF','4'),(7,'12','PAÑOL ','31/12/2021','RODAMIENTO','6010','SKF','4'),(8,'147','PAÑOL ','31/12/2021','MEDIO ESLABON SIMPLE','3/4\"','SKF','3'),(9,'18','PAÑOL ','06/01/2021','RODAMIENTO','UC 206','SKF','2'),(10,'28','PAÑOL ','06/01/2021','RODAMIENTO','6204','SKF','10'),(11,'63','PAÑOL ','11/01/2021','RODAMIENTO','2205','SKF','4'),(12,'4','PAÑOL ','11/01/2021','RODAMIENTO','6002','SKF','40'),(13,'27','PAÑOL ','11/01/2021','RODAMIENTO','6203','SKF','10'),(14,'84','PAÑOL ','11/01/2021','CORREA','AA-155','abix','10'),(15,'84','PAÑOL ','15/01/2021','CORREA','AA-155','abix','10'),(16,'1','AdminSoft','11/02/2021','RODAMIENTO','608','SKF','5'),(17,'1','AdminSoft','24/02/2021','RODAMIENTO','608','SKF','1'),(18,'3','AdminSoft','24/02/2021','RODAMIENTO','6001','SKF','10'),(19,'1','AdminSoft','24/02/2021','RODAMIENTO','608','SKF','10'),(20,'1','AdminSoft','30/04/2021','RODAMIENTO','608','SKF','21'),(21,'3','AdminSoft','09/06/2021','RODAMIENTO','6001','SKF','10'),(22,'2','AdminSoft','09/06/2021','RODAMIENTO','628','SKF','9'),(23,'3','AdminSoft','18/08/2021','RODAMIENTO','6001','SKF','2');
/*!40000 ALTER TABLE `detalleing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egresomat`
--

DROP TABLE IF EXISTS `egresomat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `egresomat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(45) NOT NULL,
  `retira` varchar(45) NOT NULL,
  `sector` varchar(45) NOT NULL,
  `ref` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `producto` varchar(45) NOT NULL,
  `medida` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `cantidad` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egresomat`
--

LOCK TABLES `egresomat` WRITE;
/*!40000 ALTER TABLE `egresomat` DISABLE KEYS */;
/*!40000 ALTER TABLE `egresomat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresomat`
--

DROP TABLE IF EXISTS `ingresomat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingresomat` (
  `id` int(11) NOT NULL,
  `cod` varchar(40) DEFAULT NULL,
  `recibido` varchar(45) DEFAULT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `producto` varchar(45) DEFAULT NULL,
  `cantidad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresomat`
--

LOCK TABLES `ingresomat` WRITE;
/*!40000 ALTER TABLE `ingresomat` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingresomat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordenes` (
  `ot` int(11) NOT NULL AUTO_INCREMENT,
  `solicitante` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `sector` varchar(45) NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `prioridad` varchar(45) NOT NULL,
  `estado` varchar(100) NOT NULL,
  PRIMARY KEY (`ot`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
INSERT INTO `ordenes` VALUES (2,'AdminSoft','08/01/2021','Playa','jdskjda\najsd\nasdjas\ndkas\nkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\nkdsakkasd','Normal',''),(3,'AdminSoft','12/01/2021','Playa','arreglar puerta','Normal','Solicitada'),(5,'GUSTAVO G GODOY','12/01/2021','Desplume','Manijas deregulacion de peladoras no funcionan.','Normal','rotas o trabadas'),(6,'GUSTAVO G GODOY','12/01/2021','Desplume','Poner cerradura o pasador en puerta de cinta de carjilones de la lincol','Normal','queda abierta'),(7,'GUSTAVO G GODOY','06/01/2021','Evicerado','Vinculo de anilladorta se corto.','Alta',''),(8,'GUSTAVO G GODOY','06/01/2021','Evicerado','Falta cuchilla se anilladora numero 8','Alta',''),(9,'GUSTAVO G GODOY','13/01/2021','Evicerado','ver paneleria de cielo saso de desplume y esviserado','Normal',''),(10,'GUSTAVO G GODOY','14/01/2021','Playa','sacar gabinete de matafuegos ','Normal',''),(11,'GUSTAVO G GODOY','14/01/2021','Playa','cambiar varillas de acero inoxidable de bajada de pilotesde jaulas de playa.','Normal',''),(12,'GUSTAVO G GODOY','14/01/2021','Playa','arreglar ventiladoresde colgado.','Intermedia',''),(14,'GUSTAVO G GODOY','15/01/2021','Evicerado','Colocar cubre cadena en arranca cabezas y enderesar dientes del mismo.','Intermedia','Tratamiento'),(16,'GUSTAVO G GODOY','15/01/2021','Playa','Rolos de comienza cinta n°1 estan rotos y no funcionan dos ventiladores.','Normal',''),(17,'MATIAS RICO','12/01/2021','Evicerado','hggkhjgh','Normal','sn'),(18,'MATIAS RICO','15/01/2021','Playa','pintar ciel rrazo de desplume','Normal','Tratamiento'),(19,'AdminSoft','18/01/2021','Playa','','Normal','Tratamiento'),(20,'AdminSoft','04/02/2021','Desplume','dwwdwa','Intermedia','Tratamiento'),(21,'AdminSoft','04/02/2021','Playa','dawdawd','Normal','Tratamiento'),(22,'AdminSoft','05/02/2021','Playa','dadad','Normal','Tratamiento'),(23,'AdminSoft','08/02/2021','Playa','AA','Normal','Tratamiento'),(24,'AdminSoft','08/02/2021','Playa','','Normal','Solicitada'),(25,'AdminSoft','11/02/2021','Desplume','DESPLUMAR TODAS LAS GALLINAS','Alta','Tratamiento');
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenesd`
--

DROP TABLE IF EXISTS `ordenesd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordenesd` (
  `ot` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  `solicita` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `sector` varchar(45) NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `observacion` varchar(100) NOT NULL,
  `materiales` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `fechac` varchar(45) NOT NULL,
  PRIMARY KEY (`ot`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenesd`
--

LOCK TABLES `ordenesd` WRITE;
/*!40000 ALTER TABLE `ordenesd` DISABLE KEYS */;
INSERT INTO `ordenesd` VALUES (1,'AT','JULIO D','18/12/20','MECANICO','REP. DE NORIA AAAAAAAAAAAAAAAAAAAAAAAAAAAS\nSSSSSSSSS\nDDD\nF','NA','','Proceso','19/12/20');
/*!40000 ALTER TABLE `ordenesd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenesp`
--

DROP TABLE IF EXISTS `ordenesp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordenesp` (
  `ot` int(11) NOT NULL,
  `solicitante` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `sector` varchar(45) NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `prioridad` varchar(45) NOT NULL,
  `estados` varchar(100) NOT NULL,
  `f_inicio` varchar(45) NOT NULL,
  `sector_def` varchar(45) NOT NULL,
  `materiales` varchar(200) NOT NULL,
  `obs_resp` varchar(100) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `f_cierre` varchar(45) NOT NULL,
  PRIMARY KEY (`ot`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenesp`
--

LOCK TABLES `ordenesp` WRITE;
/*!40000 ALTER TABLE `ordenesp` DISABLE KEYS */;
INSERT INTO `ordenesp` VALUES (1,'JULIO D','06/01/2021','Playa','EEWEEW','Normal','SS','01/01/21','OT','','','Cerrado','31/01/21'),(2,'AdminSoft','08/01/2021','Playa','jdskjda ajsd asdjas dkas kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk kdsakkasd','Normal','','01/01/21','MP',' Producto:RODAMIENTO, Marca: SKF, Medida: 6001, Cantidad 1\n','','Cerrado','31/01/21'),(3,'AdminSoft','12/01/2021','Playa','arreglar puerta','Normal','sn','01/01/21','OT','','se instalo un cierra puertas','Cerrado','31/01/21'),(4,'GUSTAVO G GODOY','12/01/2021','Playa','Arreglar cerradura de la entrada al tunel de desangrado.','Normal','Tratamiento','15/01/21','OT',' Producto:RODAMIENTO, Marca: SKF, Medida: 6009, Cantidad 5\n Producto:RODAMIENTO, Marca: SKF, Medida: 6003, Cantidad 6\n','','Proceso','21/01/21'),(12,'GUSTAVO G GODOY','14/01/2021','Playa','arreglar ventiladoresde colgado.','Intermedia','','15/01/21','OT',' Producto:RODAMIENTO, Marca: SKF, Medida: 6005, Cantidad 1\n Producto:RODAMIENTO, Marca: SKF, Medida: 6004, Cantidad 1\n Producto:RODAMIENTO, Marca: SKF, Medida: 6008, Cantidad 1\n','','Proceso','21/01/21'),(13,'GUSTAVO G GODOY','14/01/2021','Otros','oxido en panel de vestuari de hombres .\nse cortaron tornillos del panel de vestuario ','Normal','Tratamiento','15/01/21','OT','','','Proceso','21/01/21'),(14,'GUSTAVO G GODOY','15/01/2021','Evicerado','Colocar cubre cadena en arranca cabezas y enderesar dientes del mismo.','Intermedia','Tratamiento','18/01/21','OT','','ALGO','Proceso','18/01/21'),(15,'GUSTAVO G GODOY','15/01/2021','Playa','Apoya pie de zona de colgado la chapa esta muy lisa cambiarla.','Normal','Tratamiento','03/02/21','MP',' Producto:CORREA, Marca: abix, Medida: SPZ-1762, Cantidad 10\n','','Proceso','03/02/21'),(18,'MATIAS RICO','15/01/2021','Playa','pintar ciel rrazo de desplume','Normal','Solicitada','01/01/21','OT','','se instalo un cierra puertas','Cerrado','31/01/21'),(19,'AdminSoft','18/01/2021','Playa','','Normal','Tratamiento','15/01/21','OT','','KGHKJL','Proceso','21/01/21'),(20,'AdminSoft','04/02/2021','Evicerado','dadwad','Intermedia','Tratamiento','04/02/21','MP','','dadawd','Proceso','04/02/21'),(21,'AdminSoft','04/02/2021','Playa','dawdawd','Normal','Tratamiento','15/01/21','OT','','KGHKJL','Proceso','21/01/21'),(22,'AdminSoft','05/02/2021','Playa','dadad','Normal','Tratamiento','15/01/21','OT','','KGHKJL','Proceso','21/01/21'),(23,'AdminSoft','08/02/2021','Playa','AA','Normal','Tratamiento','18/01/21','OT','','','Proceso','18/01/21'),(25,'AdminSoft','11/02/2021','Desplume','DESPLUMAR TODAS LAS GALLINAS','Alta','Tratamiento','11/02/21','MP',' Producto:RODAMIENTO, Marca: SKF, Medida: 608, Cantidad 2 ','TERMINE CON TODO ','Cerrado','11/02/21');
/*!40000 ALTER TABLE `ordenesp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pañol`
--

DROP TABLE IF EXISTS `pañol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pañol` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `medida` varchar(45) NOT NULL,
  `un` varchar(45) NOT NULL,
  `serial` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `comentario` varchar(200) NOT NULL,
  `stock` varchar(45) NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pañol`
--

LOCK TABLES `pañol` WRITE;
/*!40000 ALTER TABLE `pañol` DISABLE KEYS */;
INSERT INTO `pañol` VALUES (1,'RODAMIENTO','SKF','608','UNIDAD','UNIDAD','Nuevo','','33'),(2,'RODAMIENTO','SKF','628','UNIDAD','UNIDAD','Nuevo','','1'),(3,'RODAMIENTO','SKF','6001','UNIDAD','','Nuevo','','37'),(4,'RODAMIENTO','SKF','6002','UNIDAD','','Nuevo','','50'),(5,'RODAMIENTO','SKF','6003','UNIDAD','','Nuevo','','7'),(6,'RODAMIENTO','SKF','6004','UNIDAD','','Nuevo','','7'),(7,'RODAMIENTO','SKF','6005','UNIDAD','','Nuevo','','20'),(8,'RODAMIENTO','SKF','6006','UNIDAD','','Nuevo','','13'),(9,'RODAMIENTO','SKF','6007','UNIDAD','','Nuevo','','2'),(10,'RODAMIENTO','SKF','6008','UNIDAD','','Nuevo','','5'),(11,'RODAMIENTO','SKF','6009','UNIDAD','','Nuevo','','5'),(12,'RODAMIENTO','SKF','6010','UNIDAD','UNIDAD','Nuevo','','6'),(13,'RODAMIENTO','SKF','6012','UNIDAD','','Nuevo','','4'),(14,'RODAMIENTO','SKF','3309','UNIDAD','','Nuevo','','4'),(15,'RODAMIENTO','SKF','3311A','UNIDAD','','Nuevo','','4'),(16,'RODAMIENTO','SKF','UC 204','UNIDAD','','Nuevo','','13'),(17,'RODAMIENTO','SKF','UC 205','UNIDAD','','Nuevo','','7'),(18,'RODAMIENTO','SKF','UC 206','UNIDAD','','Nuevo','','7'),(19,'RODAMIENTO','SKF','UC 207','UNIDAD','','Nuevo','','7'),(20,'RODAMIENTO','SKF','UC 208','UNIDAD','','Nuevo','','3'),(21,'RODAMIENTO','SKF','UC 209','UNIDAD','','Nuevo','','6'),(22,'RODAMIENTO','SKF','UC 210','UNIDAD','','Nuevo','','3'),(23,'RODAMIENTO','SKF','UC 212','UNIDAD','','Nuevo','','4'),(24,'RODAMIENTO','SKF','6000','UNIDAD','','Nuevo','','6'),(25,'RODAMIENTO','SKF','6201','UNIDAD','','Nuevo','','11'),(26,'RODAMIENTO','SKF','6202','UNIDAD','','Nuevo','','14'),(27,'RODAMIENTO','SKF','6203','UNIDAD','','Nuevo','','10'),(28,'RODAMIENTO','SKF','6204','','UNIDAD','Nuevo','','24'),(29,'RODAMIENTO','SKF','6205','UNIDAD','','Nuevo','','6'),(30,'RODAMIENTO','SKF','6206','UNIDAD','','Nuevo','','14'),(31,'RODAMIENTO','SKF','6207','UNIDAD','','Nuevo','','10'),(32,'RODAMIENTO','SKF','6208','UNIDAD','','Nuevo','','40'),(33,'RODAMIENTO','SKF','6209','UNIDAD','','Nuevo','','5'),(34,'RODAMIENTO','SKF','6210','UNIDAD','','Nuevo','','2'),(35,'RODAMIENTO','SKF','6211','UNIDAD','','Nuevo','','1'),(36,'RODAMIENTO','SKF','6215','UNIDAD','','Nuevo','','4'),(37,'RODAMIENTO','SKF','6300','UNIDAD','','Nuevo','','5'),(38,'RODAMIENTO','SKF','6301','UNIDAD','','Nuevo','','14'),(39,'RODAMIENTO','SKF','6303','UNIDAD','','Nuevo','','2'),(40,'RODAMIENTO','SKF','6304','UNIDAD','','Nuevo','','9'),(41,'RODAMIENTO','SKF','6305','UNIDAD','','Nuevo','','71'),(42,'RODAMIENTO','SKF','6306','UNIDAD','','Nuevo','','3'),(43,'RODAMIENTO','SKF','6307','UNIDAD','','Nuevo','','24'),(44,'RODAMIENTO','SKF','6308','UNIDAD','','Nuevo','','17'),(45,'RODAMIENTO','SKF','6309','UNIDAD','','Nuevo','','4'),(46,'RODAMIENTO','SKF','6310','UNIDAD','','Nuevo','','6'),(47,'RODAMIENTO','SKF','6311','UNIDAD','','Nuevo','','6'),(48,'RODAMIENTO','SKF','6314','UNIDAD','','Nuevo','','4'),(49,'RODAMIENTO','SKF','NUP 206','UNIDAD','','Nuevo','','5'),(50,'RODAMIENTO','SKF','6905NA','UNIDAD','','Nuevo','','5'),(51,'RODAMIENTO','SKF','6305ZNRC3','UNIDAD','','Nuevo','','2'),(52,'RODAMIENTO','SKF','7311BEP ','UNIDAD','','Nuevo','','4'),(53,'RODAMIENTO','SKF','30214','UNIDAD','','Nuevo','','6'),(54,'RODAMIENTO','SKF','1205K','UNIDAD','','Nuevo','','2'),(55,'RODAMIENTO','SKF','1207 ET','UNIDAD','','Nuevo','','4'),(56,'RODAMIENTO','SKF','NKI 45/35','UNIDAD','','Nuevo','','6'),(57,'RODAMIENTO','SKF','NKI 50/35','UNIDAD','','Nuevo','','2'),(58,'RODAMIENTO','SKF','NKI 50/25','UNIDAD','','Nuevo','','2'),(59,'RODAMIENTO','SKF','22213 E','UNIDAD','','Nuevo','','1'),(60,'RODAMIENTO','SKF','477/483 ','UNIDAD','','Nuevo','','4'),(61,'RODAMIENTO','SKF','2203 ','UNIDAD','','Nuevo','','4'),(62,'RODAMIENTO','SKF','2204','UNIDAD','','Nuevo','','0'),(63,'RODAMIENTO','SKF','2205','UNIDAD','','Nuevo','','4'),(64,'RODAMIENTO','SKF','3305','UNIDAD','','Nuevo','','4'),(65,'RODAMIENTO','SKF','3209','UNIDAD','','Nuevo','','2'),(66,'RODAMIENTO','SKF','2308 EK','UNIDAD','','Nuevo','','2'),(67,'RODAMIENTO','SKF','30204','UNIDAD','','Nuevo','','8'),(68,'RODAMIENTO','SKF','30206','UNIDAD','','Nuevo','','30'),(69,'RODAMIENTO','SKF','30208','UNIDAD','','Nuevo','','6'),(70,'RODAMIENTO','SKF','30209','UNIDAD','','Nuevo','','4'),(71,'RODAMIENTO','SKF','32208 X','UNIDAD','','Nuevo','','5'),(72,'RODAMIENTO','SKF','32009','UNIDAD','','Nuevo','','4'),(73,'RODAMIENTO','SKF','7304 BEP','UNIDAD','','Nuevo','','2'),(74,'RODAMIENTO','SKF','62203','UNIDAD','','Nuevo','','9'),(75,'RODAMIENTO','SKF','32206 J2','UNIDAD','','Nuevo','','4'),(76,'CIERRA PUERTAS AEREO  NG2 30A45KG ','TRABEX','30 A 45KG','UNIDAD','CPA 8045 ','Nuevo','','2'),(77,'CORREA','abix','A-28','','UNIDAD','Nuevo','','8'),(78,'CORREA','abix','A-43','UNIDAD','','Nuevo','','9'),(79,'CORREA','abix','A-50','UNIDAD','','Nuevo','','8'),(80,'CORREA','abix','A-52','UNIDAD','','Nuevo','','13'),(81,'CORREA','abix','A-66','UNIDAD','','Nuevo','','15'),(82,'CORREA','abix','A-67','UNIDAD','','Nuevo','','4'),(83,'CORREA','abix','AA-68','UNIDAD','','Nuevo','','8'),(84,'CORREA','abix','AA-155','UNIDAD','','Nuevo','','11'),(85,'CORREA','abix','A-124','','UNIDAD','Nuevo','','8'),(86,'CORREA','abix','A-125','UNIDAD','','Nuevo','','2'),(87,'CORREA','abix','A-132','UNIDAD','','Nuevo','','2'),(88,'CORREA','abix','B-63','UNIDAD','','Nuevo','','14'),(89,'CORREA','abix','B-64','UNIDAD','','Nuevo','','6'),(90,'CORREA','abix','B-68','UNIDAD','','Nuevo','','2'),(91,'CORREA','abix','SPZ-1762','UNIDAD','','Nuevo','','6'),(93,'CORREA','TRASMICIONES GES','CUMMINS 30003341','UNIDAD','','Nuevo','','1'),(94,'CORREA DENTADA ','TRASMICIONES GES','1500T10-50MM','UNIDAD','','Nuevo','CANGILON ','3'),(95,'CORREA DENTADA ','TRASMICIONES GES','1500T10-23MM','UNIDAD','','Nuevo','','1'),(96,'CORREA DENTADA ','TRASMICIONES GES','1350T10-25MM','UNIDAD','','Nuevo','','3'),(97,'CORREA DENTADA ','TRASMICIONES GES','1350T10-20MM','UNIDAD','','Nuevo','','1'),(98,'CORREA DENTADA ','TRASMICIONES GES','560T10-25MM','UNIDAD','','Nuevo','','1'),(99,'CORREA DENTADA ','TRASMICIONES GES','365T5-10MM','UNIDAD','','Nuevo','FLIPPER','1'),(100,'CORREA DENTADA ','abix','HTD1750-14M-30MM','','UNIDAD','Nuevo','MDM ','2'),(101,'CAJA PORTA RODAMIENTOS','SKF','FYK505','UNIDAD','','Nuevo','GRILON ','5'),(102,'CAJA PORTA RODAMIENTOS','SKF','FYK506','UNIDAD','','Nuevo','GRILON ','5'),(103,'CAJA PORTA RODAMIENTOS','WJH','F207','UNIDAD','','Nuevo','GRILON ','1'),(104,'CAJA PORTA RODAMIENTOS','WJH','FL209','UNIDAD','UNIDAD','Nuevo','GRILON','4'),(105,'CAJA PORTA RODAMIENTOS','WJH','F210','UNIDAD','','Nuevo','GRILON','4'),(106,'CAJA PORTA RODAMIENTOS','SKF','FYTBK 504','UNIDAD','','Nuevo','GRILON','10'),(107,'CAJA PORTA RODAMIENTOS','SKF','FL 205','UNIDAD','','Nuevo','GRILON','4'),(108,'CAJA PORTA RODAMIENTOS','WJH','FL 206','UNIDAD','','Nuevo','GRILON','3'),(109,'CAJA PORTA RODAMIENTOS','WJH','FL 207','UNIDAD','','Nuevo','GRILON','6'),(110,'CAJA PORTA RODAMIENTOS','WJH','P206','UNIDAD','','Nuevo','GRILON','5'),(111,'CAJA PORTA RODAMIENTOS','WJH','P208','UNIDAD','','Nuevo','GRILON','6'),(112,'CAJA PORTA RODAMIENTOS','SKF','FY 505','UNIDAD','','Nuevo','FUNDICION ','5'),(113,'CAJA PORTA RODAMIENTOS','FK','F 206 ','UNIDAD','','Nuevo','FUNDICION ','6'),(114,'CAJA PORTA RODAMIENTOS','SKF','FY 507','UNIDAD','','Nuevo','FUNDICION ','5'),(115,'CAJA PORTA RODAMIENTOS','FK','F 208','UNIDAD','','Nuevo','FUNDICION ','2'),(116,'CAJA PORTA RODAMIENTOS','SKF','T212','UNIDAD','','Nuevo','FUNDICION ','2'),(117,'CAJA PORTA RODAMIENTOS','SKF','F213','UNIDAD','','Nuevo','FUNDICION ','4'),(118,'CAJA PORTA RODAMIENTOS','FK','FL 204','UNIDAD','','Nuevo','FUNDICION ','4'),(119,'CAJA PORTA RODAMIENTOS','FK','FL 205','UNIDAD','','Nuevo','FUNDICION ','1'),(120,'CAJA PORTA RODAMIENTOS','FK','FL 206','UNIDAD','','Nuevo','FUNDICION ','4'),(121,'CAJA PORTA RODAMIENTOS','FK','P 204','UNIDAD','','Nuevo','FUNDICION ','16'),(122,'CAJA PORTA RODAMIENTOS','FK','P 207','UNIDAD','','Nuevo','FUNDICION ','11'),(123,'CAJA PORTA RODAMIENTOS','SKF','SY 512','UNIDAD','','Nuevo','FUNDICION ','2'),(124,'CAJA PORTA RODAMIENTOS','FK','P 213','UNIDAD','','Nuevo','FUNDICION ','14'),(125,'CADENA INOX DOBLE 3/8\"','RVGHT ','3/8\"','UNIDAD','ASA 35-2 ','Nuevo','','3 '),(126,'CADENA INOX SIMPLE 1/2\"','RVGHT ','1/2\"','UNIDAD','ASA 40-1','Nuevo','','2'),(127,'CADENA INOX DOBLE 1/2\"','RVGHT ','1/2\"','UNIDAD','ASA 40-2','Nuevo','','8'),(128,'CADENA COMUN SIMPLE 1/2\"','RVGHT ','1/2\"','UNIDAD','ASA 40-1','Nuevo','','1'),(129,'CADENA INOX SIMPLE 5/8\"','RVGHT ','5/8\"','UNIDAD','ASA 50-1','Nuevo','','8'),(130,'CADENA COMUN SIMPLE 5/8\"','RVGHT ','5/8\"','UNIDAD','ASA 50-1','Nuevo','','2'),(131,'CADENA COMUN DOBLE 5/8\"','RVGHT ','5/8\"','UNIDAD','ASA 50-2','Nuevo','','1'),(132,'CADENA COMUN SIMPLE 3/4\"','STIA','3/4\"','UNIDAD','ASA 60-1R','Nuevo','','4'),(133,'CADENA COMUN DOBLE 1\" ','STIA','1\"','UNIDAD','ASA 80-2R','Nuevo','','2'),(134,'CADENA COMUN SIMPLE 1 1/4\" ','STIA','1 1/4\"','UNIDAD','ASA 100-1R','Nuevo','','1'),(135,'CADENA COMUN SIMPLE 1 1/2\" ','RVGHT','1 1/2\"','UNIDAD','ASA 120-1','Nuevo','','1'),(136,'UNION CADENA SIMPLE','SKF','1/2\"','UNIDAD','asa 40-1','Nuevo','','20'),(137,'MEDIO ESLABON SIMPLE','SKF','1/2\"','UNIDAD','asa 40-1','Nuevo','','12'),(138,'MEDIO ESLABON DOBLE','SKF','1/2\"','UNIDAD','asa 40-2','Nuevo','','10'),(139,'UNION CADENA DOBLE','SKF','1/2\"','UNIDAD','asa 40-2','Nuevo','','1'),(140,'UNION CADENA SIMPLE','SKF','5/8\"','UNIDAD','ASA 50-1','Nuevo','','21'),(141,'MEDIO ESLABON SIMPLE','SKF','5/8\"','UNIDAD','ASA 50-1','Nuevo','','18'),(142,'MEDIO ESLABON DOBLE','SKF','5/8\"','UNIDAD','ASA 50-2','Nuevo','','1'),(143,'UNION CADENA DOBLE','SKF','5/8\"','UNIDAD','ASA 50-2','Nuevo','','4'),(144,'UNION CADENA DOBLE','SKF','3/8\"','UNIDAD','ASA 35-2','Nuevo','','9'),(145,'MEDIO ESLABON DOBLE','SKF','3/8\"','UNIDAD','ASA 35-2','Nuevo','','10'),(146,'UNION CADENA DOBLE','SKF','3/4\"','ASA 60-2','UNIDAD','Nuevo','','47'),(147,'MEDIO ESLABON SIMPLE','SKF','3/4\"','ASA 60-1','UNIDAD','Nuevo','','15'),(148,'UNION CADENA  SIMPLE','SKF','3/4\"','UNIDAD','ASA 60-1','Nuevo','','9'),(149,'MEDIO ESLABON DOBLE','SKF','3/4\"','UNIDAD','ASA 60-2','Nuevo','','15'),(150,'MEDIO ESLABON DOBLE ','SKF','1\"','UNIDAD','ASA 80-2','Nuevo','','13'),(151,'UNION CADENA DOBLE ','SKF','1\"','ASA 80-2','UNIDAD','Nuevo','','5'),(152,'UNION  CADENA SIMPLE','SKF','1\"','ASA 80-1','UNIDAD','Nuevo','','2'),(153,'MEDIO ESLABON SIMPLE','SKF','1\"','UNIDAD','ASA 80-1','Nuevo','','3'),(154,'UNION CADENA SIMPLE','SKF','1 1/2\"','UNIDAD','ASA 120-1','Nuevo','','7'),(155,'UNION CADENA DOBLE','SKF','1 1/2\"','UNIDAD','ASA 120-2','Nuevo','','4'),(156,'MEDIO ESLABON  DOBLE','SKF','1 1/2\"','UNIDAD','ASA 120-2','Nuevo','','4'),(157,'MEDIO ESLABON SIMPLE','SKF','1 1/2\"','UNIDAD','ASA 120-1','Nuevo','','1'),(158,'CANDADO ','SEKUR','N°26','UNIDAD','N°26','Nuevo','','0');
/*!40000 ALTER TABLE `pañol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pfaena`
--

DROP TABLE IF EXISTS `pfaena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pfaena` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) NOT NULL,
  `sector` varchar(45) NOT NULL,
  `horario` varchar(45) NOT NULL,
  `motivo` varchar(45) NOT NULL,
  `reinicio` varchar(45) NOT NULL,
  `responsable` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pfaena`
--

LOCK TABLES `pfaena` WRITE;
/*!40000 ALTER TABLE `pfaena` DISABLE KEYS */;
INSERT INTO `pfaena` VALUES (1,'10/01/2021','Desplume','17:00:00','PRIMERA\nSEGUNDA \nTERCERA','18:00:00','JOSE PEREZ','Fuera de servicio'),(2,'03/02/2021','Playa','12:22:00','dadwad','11:22:00','AdminSoft','Fuera de servicio'),(3,'03/02/2021','Evicerado','22:11:11','aaaaa','22:22:22','AdminSoft','Servicio'),(4,'05/02/2021','Desplume','11:11:11','','11:11:11','AdminSoft','Servicio'),(5,'11/02/2021','Desplume','21:58:00','NO TENGO NI IDEA','00:00:00','AdminSoft','Fuera de servicio');
/*!40000 ALTER TABLE `pfaena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remito1`
--

DROP TABLE IF EXISTS `remito1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remito1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `remito` varchar(45) NOT NULL,
  `patentes` varchar(45) NOT NULL,
  `pollos` varchar(45) NOT NULL,
  `pesobruto` varchar(45) NOT NULL,
  `pesotara` varchar(45) NOT NULL,
  `pesoneto` varchar(45) NOT NULL,
  `promedio` double NOT NULL,
  `transporte` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remito1`
--

LOCK TABLES `remito1` WRITE;
/*!40000 ALTER TABLE `remito1` DISABLE KEYS */;
INSERT INTO `remito1` VALUES (1,'01','08/02/2021','1','IRI299','9928','99','11','88',0.008863819500402902,'RAUO'),(2,'02','08/02/2021','1','AOE200','1002','99','11','88',0.08782435129740519,'RAUCH'),(3,'03','07/02/2021','1','AAA111','9922','991','99','892',0.0899012295908083,'LA LUNA'),(4,'001','11/02/2021','01','ABC123','22000','2000','1000','1000',0.045454545454545456,'EL SOL');
/*!40000 ALTER TABLE `remito1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remito2`
--

DROP TABLE IF EXISTS `remito2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remito2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(45) NOT NULL,
  `remito` varchar(45) NOT NULL,
  `patente` varchar(45) NOT NULL,
  `pollos` varchar(45) NOT NULL,
  `pesobruto` varchar(45) NOT NULL,
  `tara` varchar(45) NOT NULL,
  `pesoneto` varchar(45) NOT NULL,
  `pingreso` double NOT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `hentrada` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `chofer` varchar(45) DEFAULT NULL,
  `granja` varchar(45) DEFAULT NULL,
  `cargador` varchar(45) DEFAULT NULL,
  `promedio` double DEFAULT NULL,
  `muertos` varchar(45) DEFAULT NULL,
  `galpon` varchar(45) DEFAULT NULL,
  `pcajon` varchar(45) DEFAULT NULL,
  `orden` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remito2`
--

LOCK TABLES `remito2` WRITE;
/*!40000 ALTER TABLE `remito2` DISABLE KEYS */;
INSERT INTO `remito2` VALUES (1,'01','1','IRI299','9928','99','11','88',0.008863819500402902,'08/02/2021','10:00:10','Chasis','JUAN','IRIS','LUAN',0.008863819500402902,'0','0','0','A'),(2,'02','1','AOE200','1002','99','11','88',0.08782435129740519,'08/02/2021','10:33:00','Chasis','JOSE','IRIS','DAVID',0.08782435129740519,'0','0','0','A'),(3,'03','1','AAA111','9922','991','99','892',0.0899012295908083,'07/02/2021','11:00:00','Chasis','LA LOC','LOLO','A',0.0899012295908083,'0','0','2','A'),(4,'001','01','ABC123','22000','2000','1000','1000',0.045454545454545456,'11/02/2021','22:04:00','Chasis','MARCOS','EL SOL','JOSE',0.045454545454545456,'0','2','6','A');
/*!40000 ALTER TABLE `remito2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remito3`
--

DROP TABLE IF EXISTS `remito3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remito3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) NOT NULL,
  `hora` varchar(45) NOT NULL,
  `carga` varchar(45) NOT NULL,
  `patente` varchar(45) NOT NULL,
  `empresa` varchar(45) NOT NULL,
  `operador` varchar(45) NOT NULL,
  `chofer` varchar(45) NOT NULL,
  `remito` varchar(45) NOT NULL,
  `tara` varchar(45) NOT NULL,
  `pesobrutoe` varchar(45) NOT NULL,
  `pesonetoe` varchar(45) NOT NULL,
  `pesobrutos` varchar(45) NOT NULL,
  `pesonetos` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remito3`
--

LOCK TABLES `remito3` WRITE;
/*!40000 ALTER TABLE `remito3` DISABLE KEYS */;
INSERT INTO `remito3` VALUES (1,'19/01/2021','12:00:00','CARGA EXPORTACION','HLS2020','COASIN','LUIS','MORENO','202020','16140','26820','10680','35000','18860'),(2,'05/02/2021','22:11:22','la','ldald','ldald','AdminSoft','kakkd','dladl','222','1112','890','111','-111');
/*!40000 ALTER TABLE `remito3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporte`
--

DROP TABLE IF EXISTS `reporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reporte` (
  `id` int(11) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `remito` varchar(45) NOT NULL,
  `chofer` varchar(45) NOT NULL,
  `granja` varchar(45) NOT NULL,
  `cargador` varchar(45) NOT NULL,
  `pollos` varchar(45) NOT NULL,
  `kilos` varchar(45) NOT NULL,
  `promedio` double NOT NULL,
  `muertos` varchar(45) NOT NULL,
  `orden` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporte`
--

LOCK TABLES `reporte` WRITE;
/*!40000 ALTER TABLE `reporte` DISABLE KEYS */;
INSERT INTO `reporte` VALUES (1,'01','08/02/2021','1','JUAN','IRIS','LUAN','9928','88',0.008863819500402902,'0','A'),(2,'02','08/02/2021','1','JOSE','IRIS','DAVID','1002','88',0.08782435129740519,'0','A'),(3,'03','07/02/2021','1','LA LOC','LOLO','A','9922','892',0.0899012295908083,'0','A'),(4,'001','11/02/2021','01','MARCOS','EL SOL','JOSE','22000','1000',0.045454545454545456,'0','A');
/*!40000 ALTER TABLE `reporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `sector` varchar(45) NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'David','Guerrero','Dave','12345','Sistemas'),(2,'root2','root2','root2','12345','Operador'),(3,'PAÑOL','','Pañol','emiliano123','Operador'),(4,'JULIO','D','Julio','julio123','Operador'),(5,'GUILLERMO','','Guillermo ','macchi312','Operador'),(6,'GUSTAVO G','GODOY','Gustavo','gustavo123','Operador'),(7,'MATIAS','RICO','Matias','matias1983','Operador');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-29 19:35:46
