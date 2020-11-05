CREATE DATABASE  IF NOT EXISTS `glucose` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci */;
USE `glucose`;


--
-- Table structure for table `product_user`
--

DROP TABLE IF EXISTS `product_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_user` (
  `product_id` int NOT NULL,
  `user_id` decimal(10,0) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`product_id`,`user_id`),
  KEY `fk_user` (`user_id`),
  KEY `fk_product` (`product_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_user`
--

LOCK TABLES `product_user` WRITE;
/*!40000 ALTER TABLE `product_user` DISABLE KEYS */;
INSERT INTO `product_user` VALUES ('1','1',NULL),('4','2','2011-02-03');
/*!40000 ALTER TABLE `product_user` ENABLE KEYS */;
UNLOCK TABLES;

