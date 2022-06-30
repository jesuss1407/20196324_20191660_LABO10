-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lab10
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `compraviajes`
--

DROP TABLE IF EXISTS `compraviajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compraviajes` (
  `estudiantes_idcodigo` int NOT NULL,
  `viajes_idviajes` int NOT NULL,
  `idcompraviajes` int NOT NULL AUTO_INCREMENT,
  `cantidadcompra` int NOT NULL,
  `fecha_reserva` date NOT NULL,
  PRIMARY KEY (`idcompraviajes`,`estudiantes_idcodigo`,`viajes_idviajes`),
  KEY `fk_compraviajes_viajes1_idx` (`viajes_idviajes`),
  KEY `fk_compraviajes_estudiantes1` (`estudiantes_idcodigo`),
  CONSTRAINT `fk_compraviajes_estudiantes1` FOREIGN KEY (`estudiantes_idcodigo`) REFERENCES `estudiantes` (`idcodigo`),
  CONSTRAINT `fk_compraviajes_viajes1` FOREIGN KEY (`viajes_idviajes`) REFERENCES `viajes` (`idviajes`)
) ENGINE=InnoDB AUTO_INCREMENT=12345697 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compraviajes`
--

LOCK TABLES `compraviajes` WRITE;
/*!40000 ALTER TABLE `compraviajes` DISABLE KEYS */;
INSERT INTO `compraviajes` VALUES (20191665,2,6,1,'2022-05-10'),(20191665,3,7,5,'2022-05-12'),(20191665,4,8,4,'2022-05-15'),(20191665,5,9,2,'2022-05-30'),(20191668,2,10,1,'2022-05-10'),(20191668,4,11,2,'2022-05-12'),(20191668,4,12,4,'2022-05-16'),(20191668,5,13,2,'2022-05-30'),(20191669,5,14,2,'2022-06-28'),(20191660,81404269,12345693,1,'2022-06-29'),(20191660,45787497,12345696,1,'2022-06-29');
/*!40000 ALTER TABLE `compraviajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiantes`
--

DROP TABLE IF EXISTS `estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiantes` (
  `idcodigo` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `edad` int NOT NULL,
  `especialidad` varchar(45) NOT NULL,
  `status` varchar(10) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `contrasena_hashed` varchar(256) NOT NULL,
  PRIMARY KEY (`idcodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiantes`
--

LOCK TABLES `estudiantes` WRITE;
/*!40000 ALTER TABLE `estudiantes` DISABLE KEYS */;
INSERT INTO `estudiantes` VALUES (20191555,'Marco','Antonio',20,'telecomunicaciones','normal','rrr5555555@pucp.edu.pe','f9896dc4a36cf3b4cdb17fca4a693c845045221a0a3cb63e579380095719ab1b'),(20191660,'Jorge','Guillen',20,'telecomunicaciones','normal','jorge@pucp.edu.pe','c52474804b8c7663c81ef717673937979f84a9e13a8dcdbf1f86a4c76bc123ad'),(20191661,'Juan','Lopez',20,'telecomunicaciones','Silver','juan@pucp.edu.pe','95c5dd81e14a7113b7804f53ab2dc715bd141c55db0b4f4ffcdc28a66fda42ea'),(20191662,'Pablo','Gamarra',23,'telecomunicaciones','Gold','pablo@pucp.edu.pe','06d9a9f6c06f28c716756d4119020dbe1a573d1a75f4cd486d18712c5a95f81c'),(20191663,'Alvaro','Quispe',22,'telecomunicaciones','Platinum','alvaro@pucp.edu.pe','add9e7c287fef25c59df5df2b6699af12dad47810f28adc3740f0bbc91969f3d'),(20191664,'Jesus','Castillo',24,'telecomunicaciones','normal','jesus@pucp.edu.pe','d29e4688269aa35fbab8b7935591722de68b6f8c081c86999c36a7652e64e7b8'),(20191665,'Ana','Terrones',25,'telecomunicaciones','Silver','ana@pucp.edu.pe','f8bba1e153883b48fc1992014317639185a2585cb9ab2961535e3fd2c81d362f'),(20191666,'Alex','Marques',26,'telecomunicaciones','Gold','alex@pucp.edu.pe','8aa7089cad8f54f4d339b6192b6f029a1e099ff89ff9bfa19680ba6cd925aa8a'),(20191667,'Marco','Rivera',27,'telecomunicaciones','Platinum','marco@pucp.edu.pe','1506384d1ef071da1fbe011aa9946b41d430c56e372dd07a1ad53dd6085afc43'),(20191668,'Cris','Flores',20,'telecomunicaciones','normal','cris@pucp.edu.pe','c57a183476266022072cc94fbde250daceda42c37bfe71a06c44bfc1cb02f004'),(20191669,'Messi','Flores',19,'civil','normal','messi@pucp.edu.pe','aa0c8d12686d38a1524df75e69e09512225ee33a75e9a06127a5fddeb960f24d'),(20191670,'Piero',' Casas',24,'telecomunicaciones','normal','piero@pucp.edu.pe','3d6b0589b7bc99d21b67bd7dbb61fd9d654b6305e9adc829e1b2c8064d77f0f6'),(20191877,'Pique','Pique',25,'telecomunicaciones','normal','zzz@pucp.edu.pe','f9896dc4a36cf3b4cdb17fca4a693c845045221a0a3cb63e579380095719ab1b'),(20191881,'Anuel','Aaa',18,'telecomunicaciones','normal','castillo445@pucp.edu.pe','f9896dc4a36cf3b4cdb17fca4a693c845045221a0a3cb63e579380095719ab1b'),(20197070,'Pedro','Castillo',18,'telecomunicaciones','normal','castillo@pucp.edu.pe','f9896dc4a36cf3b4cdb17fca4a693c845045221a0a3cb63e579380095719ab1b'),(20197078,'Edwin','Vizca',18,'telecomunicaciones','normal','a478@pucp.edu.pe','f9896dc4a36cf3b4cdb17fca4a693c845045221a0a3cb63e579380095719ab1b'),(20197790,'Jorge','Rivera',20,'telecomunicaciones','normal','7997rrr@pucp.edu.pe','f9896dc4a36cf3b4cdb17fca4a693c845045221a0a3cb63e579380095719ab1b'),(20202011,'David','Villa',27,'telecomunicaciones','normal','a78a@pucp.edu.pe','f9896dc4a36cf3b4cdb17fca4a693c845045221a0a3cb63e579380095719ab1b'),(20202025,'A','B',18,'telecomunicaciones','normal','aaa4@pucp.edu.pe','f9896dc4a36cf3b4cdb17fca4a693c845045221a0a3cb63e579380095719ab1b'),(20202026,'Ale','Rivera',19,'telecomunicaciones','normal','aaa55@pucp.edu.pe','2f49ba734b2b36d06c1166b289543b0a4f25877c1b68efbdb297d255793f05c8'),(20208080,'AAA','Guillen',18,'telecomunicaciones','normal','aaa@pucp.edu.pe','7c2ecd07f155648431e0f94b89247d713c5786e1e73e953f2fe7eca39534cd6d');
/*!40000 ALTER TABLE `estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viajes`
--

DROP TABLE IF EXISTS `viajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viajes` (
  `idviajes` int NOT NULL,
  `fecha_viaje` date NOT NULL,
  `ciudad_origen` varchar(45) NOT NULL,
  `ciudad_destino` varchar(45) NOT NULL,
  `costo_unitario` varchar(45) NOT NULL,
  `seguro` varchar(45) NOT NULL,
  PRIMARY KEY (`idviajes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viajes`
--

LOCK TABLES `viajes` WRITE;
/*!40000 ALTER TABLE `viajes` DISABLE KEYS */;
INSERT INTO `viajes` VALUES (2,'2022-08-10','Lima','Cusco','200','Otro'),(3,'2022-07-12','Lima','Arequipa','200','La positiva'),(4,'2022-07-15','Arequipa','Cusco','200','Seguro internacional'),(5,'2022-07-30','Cusco','Piura','200','SegruroNuevo'),(45787497,'2022-07-07','Lima','Loreto','200','Rimac'),(81404269,'2022-07-07','Lima','Loreto','200','Rimac');
/*!40000 ALTER TABLE `viajes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-29 23:54:43
